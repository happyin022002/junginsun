<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoPopup.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send Ftp Report</title>
</head>
<body>
<h1>Send Ftp Report Sample</h1>
<form name="form" action="/hanjin/SampleReportFtp.do">
<br><hr size=5 noshade>
RD Application CD
<br>
<input type="text" size="200" name="rd_appl_cd" value="BKG043">
<br><hr size=5 noshade>
RD Parameter
<br>
<input type="text" size="200" name="rd_para_ctnt" value="/rv  form_bkgNo['BKK141710200'] form_usrId['NIS2010'] form_loclFlg['N'] form_tsFlg['N'] form_chgDpFlg['0'] form_remarkCtnt[''] form_ofcCd['SELBB']">
<br><hr size=5 noshade>
Export File Name
<br>
<input type="text" size="200" name="xpt_file_nm" value="TestFtpFile.pdf">
<br><hr size=5 noshade>
<input type="button" value="fire" onclick="form.submit()">
</form>
</body>
</form>
</html>