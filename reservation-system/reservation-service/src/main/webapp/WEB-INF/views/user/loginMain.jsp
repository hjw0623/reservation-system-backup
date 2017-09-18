<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<script>
    function Resizing(img) 
    {  
        if(img.width > 460) 
        {
            img.width = 460;
        }
        if(img.height >70){
            img.height =70;
        }   
    }
</script>
</head>
<body>
    <h1> 로그인 </h1>
    <div class="_login">
        <img alt="naverlogin" class="img_thumb" src="/imgresources/naverlogin.png" OnLoad="javascript:Resizing(this);">
        <br><br>
        <img alt="googlelogin" class="img_thumb" src="/imgresources/googlelogin.png" OnLoad="javascript:Resizing(this);">
        <br><br>
        <img alt="facebooklogin" class="img_thumb" src="/imgresources/facebooklogin.png" OnLoad="javascript:Resizing(this);">
    </div>

</body>



</html>
