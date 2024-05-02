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
        function command01Calling(commandName){
			if(commandName == "COMMAND01")
		      document.form.action="http://localhost:8001/hanjin/ESD_SCE_NTEST1.do?f_cmd=" + COMMAND01;
            if(commandName == "COMMAND02")
              document.form.action="http://localhost:8001/hanjin/ESD_SCE_NTEST1.do?f_cmd=" + COMMAND02;
		    if(commandName == "COMMAND03")
			  document.form.action="http://localhost:8001/hanjin/ESD_SCE_NTEST1.do?f_cmd=" + COMMAND03;
		    if(commandName == "COMMAND04")
			  document.form.action="http://localhost:8001/hanjin/ESD_SCE_NTEST1.do?f_cmd=" + COMMAND04;
		    if(commandName == "COMMAND05")
			  document.form.action="http://localhost:8001/hanjin/ESD_SCE_0150.do?f_cmd=" + SEARCH;
		    if(commandName == "COMMAND06")
			  document.form.action="http://localhost:8001/hanjin/ESD_SCE_0151.do?f_cmd=" + SEARCH;

		  //alert(document.form.action);
		  document.form.submit();
		}
</script>


</head>


<body >
<form method="post" name="form" onSubmit="return false;" >
<input type=button name="COMMAND01" value='COMMAND01' onclick=command01Calling('COMMAND01');>
<input type=button name="COMMAND02" value='COMMAND02' onclick=command01Calling('COMMAND02');>
<input type=button name="COMMAND03" value='COMMAND03' onclick=command01Calling('COMMAND03');>
<input type=button name="COMMAND04" value='COMMAND04' onclick=command01Calling('COMMAND04');>
<input type=button name="COMMAND05" value='COMMAND05' onclick=command01Calling('COMMAND05');>
<input type=button name="COMMAND06" value='COMMAND06' onclick=command01Calling('COMMAND06');>
</form>
</body>
</html>

