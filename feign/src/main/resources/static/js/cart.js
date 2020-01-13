
function cart(){
    alert(readCookie("token"));
    var flag = false;
    $.ajax({
        type:'get',
        url:'/cart',
        headers: {
            token:readCookie("token")
        },
        async: false,
        success:function (result) {
            alert(1)
            flag = true;
        }
    })
    if(flag){
        window.location.href ="/cart/findAll";
    }else{
        alert("error")
    }
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
