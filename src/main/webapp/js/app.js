// Dom7
var $$ = Dom7;

// Framework7 App main instance
var app  = new Framework7({
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
        }
        return {user};
    },
    // App routes
    routes: routes,
});

// Init/Create views
var homeView = app.views.create('#view-home', {
    url: '/',
    on:{
        pageInit:function () {
            app.request.post('/shop/detail', {
                lng: 1,
                lat: 1
            }, function (data) {
                app.preloader.hide();
                if (data.code !== 0) {
                    var toastBottom = app.toast.create({
                        text: data.msg,
                        closeTimeout: 2000,
                    });
                    toastBottom.open();
                }
                else {
                    app.popup.close('#shop-register-popup',true);
                    app.data.user['shop'] = data.data;
                    window.localStorage.setItem("user", JSON.stringify(app.data.user));
                }
            }, function (error) {
                app.preloader.hide();
                var toastBottom = app.toast.create({
                    text: "出错，请重试",
                    closeTimeout: 2000,
                });
                toastBottom.open();
            }, "json")
        }
    }
});
var momentView = app.views.create('#view-moment', {
    url: '/moment/'
});
var CartView = app.views.create('#view-cart', {
    url: '/cart/'
});
var userView = app.views.create('#view-user', {
    url: '/user/',
    on:{
        pageInit:function () {
        },
        pageAfterIn:function () {
            $$('#register-button').on('click',function () {
                app.preloader.show();
                var formData=app.form.convertToData('#register-form');
                if(formData.username===""||formData.password1===""||formData.password2===""){
                    var toastBottom = app.toast.create({
                        text: '输入出错，请修改',
                        closeTimeout: 2000,
                    });
                    toastBottom.open();
                    app.preloader.hide();
                }
                else if(formData.password1!==formData.password2){
                    var toastBottom = app.toast.create({
                        text: '密码不匹配，请确认',
                        closeTimeout: 2000,
                    });
                    toastBottom.open();
                    app.preloader.hide();
                }
                else{
                    app.request.post('/register',{username:formData.username,password1:formData.password1,password2:formData.password2},function (data) {
                        app.preloader.hide();
                        if(data.code!==0){
                            var toastBottom = app.toast.create({
                                text: data.msg,
                                closeTimeout: 2000,
                            });
                            toastBottom.open();
                        }
                        else{
                            $$('#login-popup').close();
                            $root.user.userName=data.data.userName;
                        }
                    })
                }
            });
            $$('#login-button').on('click',function () {
                app.preloader.show();
                var formData=app.form.convertToData('#login-form');
                if(formData.username===""||formData.password===""){
                    var toastBottom = app.toast.create({
                        text: '输入出错，请修改',
                        closeTimeout: 2000,
                    });
                    toastBottom.open();
                    app.preloader.hide();
                }
                else{
                    app.request.post('/login',{username:formData.username,password:formData.password},function (data) {
                        app.preloader.hide();
                        if(data.code!==0){
                            var toastBottom = app.toast.create({
                                text: data.msg,
                                closeTimeout: 2000,
                            });
                            toastBottom.open();
                        }
                        else{
                            app.loginScreen.close('#login-popup');
                            var toastCenter = app.toast.create({
                                text: '登录成功',
                                position: 'center',
                                closeTimeout: 2000,
                            });
                            toastCenter.open();
                            $$('#userName-p').text(data.data.userName);
                            $$('#user-head-img').attr('src',data.data.head);
                            app.data['user']=data.data;
                            //只能存储字符串，如果需要存储对象，首先要转化为字符串。利用JSON.stringify()；
                            window.localStorage.setItem("user",JSON.stringify(app.data.user));
                        }
                    },function (error) {
                        app.preloader.hide();
                        var toastBottom = app.toast.create({
                            text:error.text,
                            closeTimeout: 2000,
                        });
                        toastBottom.open();
                    },"json");
                }
            })
            $$('.item-link').on('click',function () {
                //app.dialog.alert("click");
                //app.toolbar.hide('#home-toolbar');
            });
        }
    }
});

// var shopView=app.views.create('#view-shop',{
//     url:'/user/:id/',
//     on:{
//         pageInit:function () {
//             app.toolbar.hide('#home-toolbar');
//         },
//         pageAfterOut:function () {
//             app.toolbar.show('#home-toolbar');
//         }
//     }
// });
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