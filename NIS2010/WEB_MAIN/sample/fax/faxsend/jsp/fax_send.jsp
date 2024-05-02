<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoPopup.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Fax Send Sample</h1>
<form name="form" action="/hanjin/fax_send.do">
<br><hr size=5 noshade>
Module
<br>
<input type="text" size="200" name="rd_appl_cd" value="COM">
<br><hr size=5 noshade>
MRD
<br>
<input type="text" size="200" name="rpt_file_nm" value="TEST.mrd">
<br><hr size=5 noshade>
BatchFlag
<br>
<input type="text" size="200" name="batch_flag" value="N">
<br><hr size=5 noshade>
Title
<br>
<input type="text" size="200" name="fax_tit_nm" value="Fax Title">
<br><hr size=5 noshade>
MRD Parameter
<br>
<input type="text" size="200" name="para_info_ctnt" value="[]">
<br><hr size=5 noshade>
Fax Name & Number
<br>
<input type="text" size="200" name="rcvr_info_ctnt" value="KIM;5320">
<br><hr size=5 noshade>
Office Code
<br>
<input type="text" size="200" name="ofc_cd" value="SELPIO">
<br><hr size=5 noshade>
Creat User
<br>
<input type="text" size="200" name="cre_usr_id" value="KJH">
<br><hr size=5 noshade>

<!-- input type="button" value="fire" onclick="ComOpenRDPopupModal('dialogWidth:750px;dialogHeight:690px')"-->
<input type="button" value="fire" onclick="form.submit()">
<br>
KIM;3375959 
<br>
DXBBB
</body>
</form>
</html>