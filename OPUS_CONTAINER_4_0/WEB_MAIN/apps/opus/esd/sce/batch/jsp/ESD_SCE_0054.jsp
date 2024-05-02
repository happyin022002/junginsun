<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0010.jsp
*@FileTitle : COP Manual Batch Update
*Open Issues :
*Change history :
    요건 및 UI 변경에 따른 수정
*@LastModifyDate : 2006-10-19
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-02 Seong-mun Kang
* 1.0 최초생성
=========================================================*/ 
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="com.clt.apps.opus.esd.sce.batch.copmanage.event.COPManageEvent" %>
<%@ page import="com.clt.apps.opus.esd.sce.batch.copmanage.COPManageBSC" %>

<%
	COPManageEvent  event = null;				//(Data Transfer Object including Parameters)

	String str_bkg_no 			= ""; 
	String str_bkg_no_split 	= "";
	String str_in_cntr_no 		= "";
	String str_in_cntr_tp		= "";
	String str_in_chg_cntr_no	= "";
	String str_in_chg_cntr_tp	= "";

	String f_return 			= "";

	
	try {

		
		str_bkg_no 			= request.getParameter("bkg_no");
		str_bkg_no_split 	= request.getParameter("bkg_no_split");
		str_in_cntr_no 		= request.getParameter("cntr_no");
		str_in_cntr_tp 		= request.getParameter("cntr_tpsz");
		str_in_chg_cntr_no 	= request.getParameter("chg_cntr_no");
		str_in_chg_cntr_tp 	= request.getParameter("chg_cntr_tpsz");
		
		COPManageBSC copman = new COPManageBSC();
		
		f_return = copman.CheckSORoute( str_bkg_no, str_bkg_no_split, str_in_cntr_no, str_in_cntr_tp, str_in_chg_cntr_no, str_in_chg_cntr_tp );
		
		
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

function setupPage(){
	window.status = '<%=f_return%>';
	
	alert("Retuen Data : "+'<%=f_return%>');
	
}

</script>

<body onload="javascript:setupPage();">

</body>
</html>