// Dom7
var $$ = Dom7;

// Framework7 App main instance
var app  = new Framework7({
    cache:true,
    cacheDuration: 1000*60*10,
    root: '#app', // App root element
    id: 'io.framework7.testapp', // App bundle ID
    name: 'Framework7', // App name
    theme: 'auto', // Automatic theme detection
    pushState : true,
    initOnDeviceReady:function () {
        app.dialog.alert("device ready");
        document.addEventListener("backbutton",app.methods.onBackKeyDown,false);
    },
    methods:{
        onBackKeyDown:function () {
            app.dialog.alert("ddd");
        }
    },
    data:function () {
        let user = JSON.parse(window.localStorage.getItem('user'));
        if(user==null){
            user={
                'userName':'未登录',
                'head':"http://iph.href.lu/60x60?text=...&fg=ffffff&bg=ddd",
                'shop':{},
            };
            var shop={}
        }
        return {user,shop};
    },
    // App routes
    routes: routes,
    precompileTemplates: true,
    template7Pages: true, //pages启用Template7
    template7Data: {
    },
    preprocess: function (content, url, next) {
        //判断如果是跳转到列表页面
        if(url.indexOf("/home/")>=0){
            app.dialog.alert("get");
            //先获取数据
            $$.getJSON("data/news.json", function (data) {
                console.log(data);
                //模板编译
                var compiledTemplate = Template7.compile(content);
                //模板数据加载
                next(compiledTemplate(data));
            });
        }else{
            //其他页面按正常流程走
            next(content);
        }
    }
});

// Init/Create views
var homeView = app.views.create('#view-home', {
    url: '/home/',

});
var momentView = app.views.create('#view-moment', {
    url: '/moment/'
});
var CartView = app.views.create('#view-cart', {
    url: '/cart/'
});
var userView = app.views.create('#view-user', {
    url: '/user/',
});

var searchbar = app.searchbar.create({
    el: '.searchbar',
    searchContainer: '.list',
    searchIn: '.item-title',
    on: {
        search(sb, query, previousQuery) {
            console.log(query, previousQuery);
        }
    }
});

var barActions=app.actions.create({
    buttons:[
        {
            text:"关注",
            color:"black",
            onClick:function () {
                app.dialog.alert("成功关注")
            }
        },
        {
            text:"分享",
            color:"black",
            onClick:function () {
                app.dialog.alert("成功分享注")
            }
        },
        {
            text:"投诉",
            color:"black",
            onClick:function () {
                app.dialog.alert("成功投诉")
            }
        },
    ]
});

$$('.bar-actions').on('click', function () {
    barActions.open();
});
