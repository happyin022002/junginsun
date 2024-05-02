<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0074.jsp
*@FileTitle : Check Master Bookin No.
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="com.clt.apps.opus.esd.sce.copmanage.COPManageSC" %>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.COPManageEvent" %>


<%

String r_bkg_no 			= "";
String r_bkg_no_split 		= "";
String r_cntr_no_list 		= "";

String f_return 			= "";

try {

	r_bkg_no 		= request.getParameter("bkg_no");
	r_bkg_no_split 	= request.getParameter("bkg_no_split");
	r_cntr_no_list	= request.getParameter("cntr_no");

	COPManageSC copMngSc = new COPManageSC();
	
	f_return = copMngSc.searchMstrBkgNo( r_bkg_no, r_bkg_no_split, r_cntr_no_list);


}catch(Exception e) {
	out.println(e.toString());
}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Sync With OPUS </title>
</head>

<script language="JavaScript">

document.onreadystatechange=checkReady;

function checkReady(){
	formObject = document.form;
	var result = '';
	result = '<%=f_return%>';

  if (document.readyState=='complete'){
  	self.status = "";
    self.status = result;
    self.status = "";
    self.defaultStatus=result;
  }else if (document.readyState=='완료'){
  	self.status = "";
    self.status = result;
    self.status = "";
    self.defaultStatus=result;
  }
  	self.status = "";
    self.status = result;
    self.status = "";

}

</script>

<body   >

<form method="post" name="form">
<input	type="hidden" name="f_cmd" value="<%=f_return%>">
</form>
</body>
</html>