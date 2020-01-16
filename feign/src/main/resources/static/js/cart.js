
function cart(){
    var flag = false;
    var uId = 1;
    $.ajax({
        type:'get',
        url:'/cart',
        headers: {
            token:readCookie("token")
        },
        async: false,
        success:function (result) {
            uId = result;
            flag = true;
        }
    })
    if(flag){
        window.location.href ="/cart/findAll/"+uId;
    }else{
        alert("请登录再查看")
    }
}

function add() {
    var flag = false;
    var pId = document.getElementById("pId").innerText;
    var number = document.getElementById("number").value;
    var pPrice = document.getElementById("pPrice").innerText;
    $.ajax({
        type: 'post',
        url: '/cart/add',
        headers: {
            token:readCookie("token")
        },
        data:{
            'cpId':pId,
            'cAmount':number
        },
        dataType:'json',
        async: false,
        success:function(result){
            flag = true;
            if (200 == result.code){
                alert("添加购物车成功");
            }
        }
    })
    if (flag){

    }else {
        alert("请先登录");
    }
}

function product(){
    window.location.href ="/product/findAll";
}

function amountMin() {
    var a = $(this).parent().children('#amount');
    alert(a.val())
    if (parseInt(a.val()) >1){
        a.val(parseInt(a.val())-1)
    }else {
        $(".min").attr("disabled","disabled")
    }
     var price = a.attr("price");
    alert(price)
    setTotal(price,a.val());

}

function amountAdd() {

}

function setTotal(price,amount){
    $(".total").html((parseInt(price)*parseInt(amount)).toFixed(2));
}

function writeCookie(name,value,hours)
{
    var expires = "";
    if(null != hours)
    {
        var date = new Date();
        expires = new Date(date.getTime() + hours * 60 * 60 * 1000);
        expires = "; expires=" + expires.toGMTString();
    }
    document.cookie = name + "=" + escape(value) + expires;
    return document.cookie;
}

function readCookie(name)
{
    var cookieValue = "";
    var search = name + "=";
    var dc = document.cookie;
    if(dc.length > 0)
    {
        var offset = dc.indexOf(search);
        if(offset != -1)
        {
            offset += search.length;
            var end = dc.indexOf(";", offset);
            if(end == -1) end = dc.length;
            cookieValue = unescape(dc.substring(offset, end));
        }
    }
    return cookieValue;
}
