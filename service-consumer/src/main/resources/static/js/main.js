//根据快递员姓名自动填充其公司及手机号
function courierName1(){
    $.ajax({
        type:"POST",
        url:"/deposit/findByName",
        data:{
            "courierName":$('#courierName').val()
        },
        dataType:"json",
        success:function (data) {
            console.log(data);
            $(".company").val(data.company);
            $(".courierTel").val(data.courierTel);
        },
        error:function (e) {
            console.log(e);
        }
    });
}
//非空验证
function verification(){
    var courierName = document.getElementById("courierName").value;
    var courierNumber = document.getElementById("courierNumber").value;
    var username = document.getElementById("username").value;
    var usernameTel = document.getElementById("usernameTel").value;
    if (courierName == "" || courierName == null ){
        alert("快递员姓名不能为空");
        return false;
    }else if (courierNumber == "" || courierNumber == null){
        alert("快递单号不能为空");
        return false;
    }else if (username == "" || username == null){
        alert("收件人姓名不能为空");
        return false;
    }else if (usernameTel == "" || usernameTel == null){
        alert("收件人手机号不能为空");
        return false;
    }else {
        return true;
    }
}


function sendCode() {
    $.ajax({
        type:"get",
        url:"/sendCode?usernameTel="+$("#usernameTel").val().trim(),
        dataType:'json',
        success:function (data) {
            console.log(data);
        },
        error:function (error) {
            console.log(error);
        }
    })
}

function checkCode() {
    $.ajax({
        type:"post",
        url:"/checkCode",
        data:{
            "usernameTel":$('#usernameTel').val(),
            "getCode":$('#getCode').val()
        },
        dataType:'json',
        success:function (data) {
            // console.log(data);
            if (data.error==null){
                // 如果验证成功，执行登录，通过手机号查询用户记录
                alert("您的快递在"+ data.position +"，" + data.address + "，请取件！");
                $(".codeInfo").css("display","none");
                return true;
            }else {
                alert(data.error)
                // 如果验证不成功
                $(".codeInfo").css("display","inline-block");
                return false;
            }
        },
        error:function (e) {
            console.log(e);
        }
    })
}
