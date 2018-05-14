routes = [
    {
        path: '/home/',
        async: function (routeTo, routeFrom, resolve, reject) {
            // Show Preloader
            app.preloader.show();
            //获取店铺详情
            app.request.post('/shop/detail', {
                lng: 35,
                lat: 120
            }, function (data) {
                if (data.code !== 0) {
                    var toastBottom = app.toast.create({
                        text: data.msg,
                        closeTimeout: 2000,
                    });
                    toastBottom.open();
                }
                else {
                    app.data.shop=data.data.shop;
                    app.data.shop['homeGoodsPage']=0;
                    //获取商品列表
                    app.request.post('/shop/goods',{
                        shopId:data.data.shop.shopId,
                        page:0
                    },function (dataGoods) {
                        app.preloader.hide();
                        if(dataGoods.code!==0){
                            var toastBottom = app.toast.create({
                                text: data.msg,
                                closeTimeout: 2000,
                            });
                            toastBottom.open();
                        }
                        else{
                            resolve(
                                {
                                    templateUrl: './home',
                                },
                                {
                                    context: {
                                        scrollImgs:data.data.scrollImgs,
                                        shopName:data.data.shop.shopName,
                                        desText:data.data.shop.desText,
                                        acts:data.data.acts,
                                        goods:dataGoods.data,
                                    }
                                }
                            );
                        }
                    },function (error) {
                        app.preloader.hide();
                        var toastBottom = app.toast.create({
                            text: "出错，请重试",
                            closeTimeout: 2000,
                        });
                        toastBottom.open();
                    },"json");
                }
            }, function (error) {
                app.preloader.hide();
                var toastBottom = app.toast.create({
                    text: "出错，请重试",
                    closeTimeout: 2000,
                });
                toastBottom.open();
            }, "json");
        },
        on:{
            pageAfterIn:function(){
                if(app.data.user.userName==="未登录"){
                    app.popup.open("#home-login-popup",true);
                }
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
                $$('#home-login-button').on('click',function () {
                    app.preloader.show();
                    var formData=app.form.convertToData('#home-login-form');
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
                                app.loginScreen.close('#home-login-popup');
                                var toastCenter = app.toast.create({
                                    text: '登录成功',
                                    position: 'center',
                                    closeTimeout: 2000,
                                });
                                toastCenter.open();
                                app.data.user=data.data;
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
                var $ptrContent = $$('.ptr-content');
                $ptrContent.on('ptr:refresh', function (e) {
                    homeView.router.refreshPage();
                    app.ptr.done()
                });
                var allowInfinite=true;
                $$('.infinite-scroll-content').on('infinite', function () {
                    // Exit, if loading in progress
                    if (!allowInfinite) return;

                    // Set loading flag
                    allowInfinite = false;

                    app.request.post('/shop/goods',{
                        shopId:app.data.shop.shopId,
                        page:app.data.shop.homeGoodsPage+1
                    },function (dataGoods) {
                        app.preloader.hide();
                        if(dataGoods.code!==0){
                            var toastBottom = app.toast.create({
                                text: data.msg,
                                closeTimeout: 2000,
                            });
                            toastBottom.open();
                        }
                        else{
                            if(dataGoods) app.data.shop.homeGoodsPage++;
                            // Generate new items HTML
                            var html = '';
                            for (var goodsItem in dataGoods.data) {
                                html += '<div class="col-50">'+
                                    '<a class="goods-card-link" href="/goods/'+dataGoods.data[goodsItem].goodsId+'">'+
                                    '<div class="goods-card card activity-card-header-pic">'+
                                    '<div style="background-image:url('+dataGoods.data[goodsItem].goodsImg+')" class="card-header align-items-flex-end"></div>'+
                                    '<div class="goods-card-content card-content card-content-padding">'+
                                    '<p>'+dataGoods.data[goodsItem].goodsName+'</p>'+
                                    '<p>￥'+dataGoods.data[goodsItem].goodsPrice+'</p>'+
                                    '</div></div></a></div>';
                            }

                            // Append new items
                            $$('#goods-box').append(html);
                        }
                    },function (error) {
                        app.preloader.hide();
                        var toastBottom = app.toast.create({
                            text: "出错，请重试",
                            closeTimeout: 2000,
                        });
                        toastBottom.open();
                    },"json");

                });
            }
        }
    },
    {
        path: '/user/',
        templateUrl: './user/',
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
    },
    {
        path: '/moment/',
        async: function (routeTo, routeFrom, resolve, reject) {
            // Show Preloader
            if(app.data.user.userName!=="未登录") {
                app.preloader.show();
                //获取店铺详情
                app.request.post('/moment/recommend', {
                    userId:app.data.user.userId
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
                        resolve(
                            {
                                templateUrl: './moment/',
                            },
                            {
                                context: {
                                    activities: data.data,
                                }
                            }
                        );
                    }
                }, function (error) {
                    app.preloader.hide();
                    var toastBottom = app.toast.create({
                        text: "出错，请重试",
                        closeTimeout: 2000,
                    });
                    toastBottom.open();
                }, "json");
            }
            else{
                resolve(
                    {
                        templateUrl: './moment/',
                    },
                    {
                        context: {
                            activities: {},
                        }
                    }
                );
                $$('.page-content').append("请先登录")
            }
        },
        on:{
            pageAfterIn:function(){
                var $ptrContent = $$('.ptr-content');
                $ptrContent.on('ptr:refresh', function (e) {
                    momentView.router.refreshPage();
                    app.ptr.done()
                });
            }
        }
    },
    {
        path: '/cart/',
        templateUrl: './cart/',
    },
    {
        path: '/user/shopCollection',
        templateUrl: './user/shopCollection',
        on:{
            pageAfterIn:function () {
                app.toolbar.hide('#home-toolbar');
            }
        }
    },
    {
        path: '/user/activityCollection',
        templateUrl: './user/activityCollection',
        on:{
            pageAfterIn:function () {
                app.toolbar.hide('#home-toolbar');
            }
        }
    },
    {
        path: '/user/goodsCollection',
        templateUrl: './user/goodsCollection',
        on:{
            pageAfterIn:function () {
                app.toolbar.hide('#home-toolbar');
            }
        }
    },
    {
        path: '/order/commit',
        templateUrl: './order/commit',
        on:{
            pageAfterIn:function () {
                app.toolbar.hide('#home-toolbar');
            }
        }
    },
    {
        path: '/activity/:actId',
        async: function (routeTo, routeFrom, resolve, reject) {
            app.preloader.show();
            var actId = routeTo.params.actId;
            app.request.post('/activity/detail',{
                activityId:actId
            },function (data) {
                app.preloader.hide();
                if(data.code!==0){
                    var toastBottom = app.toast.create({
                        text: data.msg,
                        closeTimeout: 2000,
                    });
                    toastBottom.open();
                }
                else{
                    resolve(
                        {
                            templateUrl: './activity/{{actId}}',
                        },
                        {
                            context: {
                                actImg:data.data.shopAct.actImg,
                                actDes:data.data.shopAct.actDes,
                                beginTime:data.data.shopAct.beginTime,
                                endTime:data.data.shopAct.endTime,
                                goodsList:data.data.goodsArrayList,
                                actId:data.data.shopAct.actId,
                            }
                        }
                    );
                }
            },function (error) {
                app.preloader.hide();
                var toastBottom = app.toast.create({
                    text: "出错，请重试",
                    closeTimeout: 2000,
                });
                toastBottom.open();
            },"json");
        },
        on:{
            pageAfterIn:function () {
                app.toolbar.hide('#home-toolbar');
                $$('.navbar').addClass('goods-navbar');
            },
            pageBeforeOut:function () {
                $$('.navbar').removeClass('goods-navbar');
            }
        }
    },
    {
        path: '/settings/',
        url: './settings',
    },
    // Page Loaders & Router
    {
        path: '/shop/:id',
        templateUrl: './shop/{{id}}',
        on:{
            pageAfterIn:function () {
                //app.dialog.alert("init");
                app.toolbar.hide('#home-toolbar');
                if(app.data.user.shop==null) {
                    app.popup.open('#shop-register-popup', true);
                    $$('#map-input').on('click', function () {
                        app.popup.open('#map-popup', true);
                        let mapObj = new AMap.Map('map-container');
                        mapObj.plugin(['AMap.Geolocation'], function () {
                            geolocation = new AMap.Geolocation({
                                enableHighAccuracy: true,//是否使用高精度定位，默认:true
                                timeout: 20000,          //超过20秒后停止定位，默认：无穷大
                                maximumAge: 0,           //定位结果缓存0毫秒，默认：0
                                convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
                                showButton: true,        //显示定位按钮，默认：true
                                buttonPosition: 'LB',    //定位按钮停靠位置，默认：'LB'，左下角
                                buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                                showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
                                showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true
                                panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
                                zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
                                useNative: true
                            });
                            mapObj.addControl(geolocation);
                            geolocation.getCurrentPosition();
                            AMap.event.addListener(geolocation, 'complete', function (data) {
                                app.sheet.open('#map-sheet', true);
                                $$('#map-unused-btn').on('click', function () {
                                    app.sheet.close('#map-sheet');
                                    app.popup.close('#map-popup');
                                });
                                $$('#map-use-btn').on('click', function () {
                                    app.sheet.close('#map-sheet');
                                    app.popup.close('#map-popup');
                                    app.data.user['shop'] = {};
                                    app.data.user.shop['lng'] = data.position.lng;
                                    app.data.user.shop['lat'] = data.position.lat;
                                    AMap.service('AMap.Geocoder', function () {//回调函数
                                        //实例化Geocoder
                                        let geocoder = new AMap.Geocoder({});
                                        let lnglatXY = [data.position.lng, data.position.lat];
                                        geocoder.getAddress(lnglatXY, function (status, result) {
                                            if (status === 'complete' && result.info === 'OK') {
                                                //获取地址成功
                                                $$('#map-input').val(result.regeocode.formattedAddress);
                                            } else {
                                                //获取地址失败
                                                app.data.user.shop['lng'] = null;
                                                app.data.user.shop['lat'] = null;
                                                $$('#map-input').val("获取地址失败，请重试");
                                            }
                                        });
                                    });
                                    $$('#map-input').val(data.formattedAddress);
                                })
                            });//返回定位信息
                            AMap.event.addListener(geolocation, 'error', function (e) {
                                app.dialog.alert("定位出错，请退出重试");
                            });
                        });
                    });
                    $$('#map-close-link').on('click', function () {
                        app.sheet.close('#map-sheet', true);
                        app.popup.close('#map-popup', true);
                        app.popup.open('#shop-register-popup', true);
                    });
                    $$('#shop-register-btn').on('click', function () {
                        app.preloader.show();
                        var formData=app.form.convertToData('#shop-register-form');
                        if(formData.shopName==null||app.data.user.shop.lng==null||app.data.user.shop.lat==null){
                            var toastBottom = app.toast.create({
                                text: "数据填写出错",
                                closeTimeout: 2000,
                            });
                            toastBottom.open();
                            app.preloader.hide();
                        }
                        else {
                            app.request.post('/shopRegister', {
                                userId: app.data.user.userId,
                                shopName: formData.shopName,
                                lng: app.data.user.shop.lng,
                                lat: app.data.user.shop.lat
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
                    })
                }
                var showSubnavbar=false;
                $$('.page-content').on('scroll',function () {
                    var tabH=$$('.member-fans').offset().top-21;//元素距离顶部距离
                    if(tabH<=0 && !showSubnavbar){
                        $$('#shop-page').addClass("page-with-subnavbar");
                        $$('.shop-tab').addClass("subnavbar");
                        $$('#shop-navbar-inner').append($$('.shop-tab'));
                        $$('#shop-page-content').css("padding-top","74px");
                        $$('.shop-tab-content').css("overflow-y","scroll");
                        showSubnavbar=true;
                    }
                    if(tabH>30 && showSubnavbar){
                        $$('#shop-page').removeClass("page-with-subnavbar");
                        $$('.shop-tab').removeClass("subnavbar");
                        $$('#shop-card').append($$('.shop-tab'));
                        $$('#shop-page-content').css("padding-top","44px");
                        $$('.shop-tab-content').css("overflow-y","hidden");
                        showSubnavbar=false;
                    }
                });
                var startX;
                var startY;
                function toolbarScrollHide(parentEl,el,isHide=false){
                    $$('.page-content').on('touchstart',function (e) {
                        startX = e.changedTouches[0].pageX;
                        startY = e.changedTouches[0].pageY;
                    })
                    $$('.page-content').on('touchmove',function (e) {
                        var endX = e.changedTouches[0].pageX;
                        var endY = e.changedTouches[0].pageY;
                        //获取滑动距离
                        var distanceX = endX-startX;
                        var distanceY = endY-startY;
                        //判断到达底部
                        var height=$$(parentEl).height();
                        var scrollHeight=$$(parentEl)[0].scrollHeight;
                        var scrollTop=$$(parentEl)[0].scrollTop;
                        var bottom=scrollHeight-height-scrollTop;
                        //下滑方向
                        if(Math.abs(distanceX)<Math.abs(distanceY) && distanceY>0 && isHide || bottom<60 && isHide){
                            app.toolbar.show(el);
                            //$$('.page-content').css("padding-bottom","50px");
                            isHide=false;
                        }
                        //上滑
                        else if(Math.abs(distanceX)<Math.abs(distanceY) && distanceY<0 && !isHide || bottom>60 && isHide){
                            app.toolbar.hide(el);
                            //$$('.page-content').css("padding-bottom","0");
                            isHide=true;
                        }
                    });
                };

                $$('.goods-card-link').on('click',function (e) {
                    app.popover.open($$('.popover-goods-action-list'), this, true);
                });
                $$('#goods-tab').on('tab:show',function () {
                    app.toolbar.show('.shop-toolbar');
                    toolbarScrollHide('#goods-tab','.shop-toolbar');
                });
                $$('#goods-tab').on('tab:hide',function () {
                    app.toolbar.hide('.shop-toolbar');
                });
            },
            pageAfterOut:function () {
                //app.dialog.alert("out");
                app.toolbar.show('#home-toolbar');
            }
        }
    },
    {
        path: '/goods/:goodsId',
        data:function () {
            var goodsId;
            return goodsId
        },
        async: function (routeTo, routeFrom, resolve, reject) {
            app.preloader.show();
            var goodsId = routeTo.params.goodsId;
            app.data.user["recordGoodsId"]=goodsId;
            app.request.post('/goods/detail',{
                goodsId:goodsId
            },function (data) {
                app.preloader.hide();
                if(data.code!==0){
                    var toastBottom = app.toast.create({
                        text: data.msg,
                        closeTimeout: 2000,
                    });
                    toastBottom.open();
                }
                else{
                    resolve(
                        {
                            templateUrl: './goods/{{goodsId}}',
                        },
                        {
                            context: {
                                goodsImg:data.data.goods.goodsImg,
                                goodsName:data.data.goods.goodsName,
                                goodsPrice:data.data.goods.goodsPrice,
                                moduleLists:data.data.moduleLists,
                            }
                        }
                    );
                }
            },function (error) {
                app.preloader.hide();
                var toastBottom = app.toast.create({
                    text: "出错，请重试",
                    closeTimeout: 2000,
                });
                toastBottom.open();
            },"json");
        },
        on:{
            pageAfterIn:function () {
                app.toolbar.hide('#home-toolbar');
                $$('.navbar').addClass('goods-navbar');
                $$('#add-cart-btn').on('click',function () {
                    app.preloader.show();
                    app.request.post('/cart/add',{
                        goodsId:app.data.user.recordGoodsId,
                        userId:app.data.user.userId
                    },function (data) {
                        app.preloader.hide();
                        if(data.code!==0){
                            var toastBottom = app.toast.create({
                                text: data.msg,
                                closeTimeout: 2000,
                            });
                            toastBottom.open();
                        }
                        else{
                            var toastBottom = app.toast.create({
                                text: "添加购物车成功",
                                position: 'center',
                                closeTimeout: 2000,
                            });
                            toastBottom.open();
                        }
                    },function (error) {
                        app.preloader.hide();
                        var toastBottom = app.toast.create({
                            text: "出错，请重试",
                            closeTimeout: 2000,
                        });
                        toastBottom.open();
                    },"json");
                })
            },
            pageBeforeOut:function () {
                $$('.navbar').removeClass('goods-navbar');
            }
        }
    },
    {
        path: '/activity/:id',
        templateUrl: './activity/{{id}}',
        on:{
            pageAfterIn:function () {
                app.toolbar.hide('#home-toolbar');
                $$('.navbar').addClass('activity-navbar');
            },
            pageBeforeOut:function () {
                $$('.navbar').removeClass('activity-navbar');
                app.toolbar.show('#home-toolbar');
            }
        }
    },
    {
        path: '/page-loader-template7/:user/:userId/:posts/:postId/',
        templateUrl: './pages/page-loader-template7.html',
    },
    {
        path: '/page-loader-component/:user/:userId/:posts/:postId/',
        componentUrl: './pages/page-loader-component.html',
    },
    {
        path: '/request-and-load/user/:userId/',
        async: function (routeTo, routeFrom, resolve, reject) {
            // Router instance
            var router = this;

            // App instance
            var app = router.app;

            // Show Preloader
            app.preloader.show();

            // User ID from request
            var userId = routeTo.params.userId;

            // Simulate Ajax Request
            setTimeout(function () {
                // We got user data from request
                var user2 = {
                    firstName: 'Vladimir',
                    lastName: 'Kharlampidi',
                    about: 'Hello, i am creator of Framework7! Hope you like it!',
                    links: [
                        {
                            title: 'Framework7 Website',
                            url: 'http://framework7.io',
                        },
                        {
                            title: 'Framework7 Forum',
                            url: 'http://forum.framework7.io',
                        },
                    ]
                };
                // Hide Preloader
                app.preloader.hide();

                // Resolve route to load page
                resolve(
                    {
                        componentUrl: './pages/request-and-load.html',
                    },
                    {
                        context: {
                            user: user,
                        }
                    }
                );
            }, 1000);
        },
    },
    // Default route (404 page). MUST BE THE LAST
    {
        path: '(.*)',
        url: './pages/404.html',
    },
];
