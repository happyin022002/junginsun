<!--%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0028GS.jsp
*@FileTitle : Exception Alert/통지 대상 등록 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-30
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-08-30 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
%-->
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>

<html>
<head>
<title>Welcome to enis! Program TEST for Non UI programs</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
        function SEARCH01Calling(commandName){
			if(commandName == "SEARCH")
		      document.form.action="http://localhost:7001/hanjin/ESD_SCE_NTEST2.do?f_cmd=" + SEARCH;



		  //alert(document.form.action);
		  document.form.submit();
		}
</script>


</head>


<body >
<form method="post" name="form" onSubmit="return false;" >
<input type=button name="COMMAND01" value='SEARCH' onclick=SEARCH01Calling('SEARCH');>
</form>
</body>
</html>

