var $$ = Dom7;
$$('#register-button').on('click',function () {
    app.preloader.show();
    var formData=app.form.convertToData('#register-form');
    if(formData.password1!==formData.password2){
        toastBottom.text="密码不匹配，请确认";
        toastBottom.open();
    }
    else{
        app.request.post('/register',{username:formData.username,password1:formData.password1,password2:formData.password2},function (data) {
            app.preloader.hide();
            if(data.code!==0){
                toastBottom.text=data.msg;
                toastBottom.open();
            }
            else{
                app.dialog.alert(data.data);
            }
        })
    }
})