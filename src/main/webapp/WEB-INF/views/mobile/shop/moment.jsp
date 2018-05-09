{%extends "base.html"%}
{%block css%}
<link href="static/css/moment.css" rel="stylesheet">
{%endblock%}
{%block main%}
    <!--cover-->
    <div>
        <div class="header-content-wrap">
            <div class="container">
                <h1 class="intro-text">Make the best of your WordPress experience with Zerif Lite</h1>
            </div>
        </div>
        <div class="wrap-head">
            <img src="static/img/new.png">
        </div>
    </div>

    <!--moment-->
    <div class="moment">
        <div class="section-header">
                <h1>交流圈</h1>
                <p>-分享生活美一刻-</p>
            </div>
        <div class="container">
            <div class="row clearfix moment-item">
                <div class="col-sm-2 text-center moment-head">
                    <img src="static/img/rank.png">
                    <p>hello</p>
                </div>
                <div class="col-sm-6 moment-content">
                    <div class="row moment-text">
                        <p>Bootstrap，来自 Twitter，是目前最受欢迎的前端框架。Bootstrap 是基于 HTML、CSS、JAVASCRIPT 的，它简洁灵活，使得 Web 开发更加快捷。</p>
                    </div>
                    <div class="row moment-img">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                    </div>
                    <div class="row moment-operation">
                        <a class="moment-operation-thumbs-up"><span class="glyphicon glyphicon-thumbs-up"></span>赞</a>
                        <a class="moment-operation-comment"><span class="glyphicon glyphicon-comment"></span>评论</a>
                    </div>
                    <div class="row moment-thumbs-up">
                        <span class="glyphicon glyphicon-thumbs-up"></span>
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                    </div>
                    <div class="row moment-comment-edit">
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-btn">
                        <button class="btn" type="button">发送</button>
                    </span>
                        </div>
                        <!-- /input-group -->
                    </div>
                </div>
                <div class="col-sm-4 moment-comment-wrap">
                    <div class="row clearfit">
                        <div class="col-md-12 moment-comment-head">
                            <p>评论</p>
                        </div>
                    </div>
                    <div class="row clearfit">
                        <div class="col-md-12 moment-comment-content">
                            <ul>
                                {%for li in [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]%}
                                <li>
                                    <div class="row moment-comment-item">
                                        <div class="col-xs-2 moment-comment-head">
                                            <img src="static/img/rank.png">
                                        </div>
                                        <div class="col-xs-10">
                                            <div class="row">
                                                <div class="col-xs-6 moment-comment-name">
                                                    <p>小明</p>
                                                </div>
                                                <div class="col-xs-6 moment-comment-date">
                                                    <p>10/15 15:30</p>
                                                </div>
                                            </div>
                                            <div class="row moment-comment-text">
                                                <p>hello world!</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                {%endfor%}
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row clearfix moment-item">
                <div class="col-sm-2 text-center moment-head">
                    <img src="static/img/rank.png">
                    <p>hello</p>
                </div>
                <div class="col-sm-6 moment-content">
                    <div class="row moment-text">
                        <p>Bootstrap，来自 Twitter，是目前最受欢迎的前端框架。Bootstrap 是基于 HTML、CSS、JAVASCRIPT 的，它简洁灵活，使得 Web 开发更加快捷。</p>
                    </div>
                    <div class="row moment-img">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                    </div>
                    <div class="row moment-operation">
                        <a class="moment-operation-thumbs-up"><span class="glyphicon glyphicon-thumbs-up"></span>赞</a>
                        <a class="moment-operation-comment"><span class="glyphicon glyphicon-comment"></span>评论</a>
                    </div>
                    <div class="row moment-thumbs-up">
                        <span class="glyphicon glyphicon-thumbs-up"></span>
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                        <img src="static/img/new.png">
                    </div>
                    <div class="row moment-comment-edit">
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-btn">
                        <button class="btn" type="button">发送</button>
                    </span>
                        </div>
                        <!-- /input-group -->
                    </div>
                </div>
                <div class="col-sm-4 moment-comment-wrap">
                    <div class="row clearfit">
                        <div class="col-md-12 moment-comment-head">
                            <p>评论</p>
                        </div>
                    </div>
                    <div class="row clearfit">
                        <div class="col-md-12 moment-comment-content">
                            <ul>
                                {%for li in [1,1,1]%}
                                <li>
                                    <div class="row moment-comment-item">
                                        <div class="col-xs-2 moment-comment-head">
                                            <img src="static/img/rank.png">
                                        </div>
                                        <div class="col-xs-10">
                                            <div class="row">
                                                <div class="col-xs-6 moment-comment-name">
                                                    <p>小明</p>
                                                </div>
                                                <div class="col-xs-6 moment-comment-date">
                                                    <p>10/15 15:30</p>
                                                </div>
                                            </div>
                                            <div class="row moment-comment-text">
                                                <p>hello world!hello world!hello world!hello world!hello world!</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                {%endfor%}
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="static/js/moment.js"></script>
{%endblock%}