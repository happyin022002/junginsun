<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0208.jsp
*@FileTitle : Invoice Inquiry Correction Report
*Open Issues :
*Change history :
*@LastModifyDate : 2008-03-20
*@LastModifier : jhlee
*@LastVersion : 1.0
* 2008-03-20 jhlee
* 1.0 최초 생성 
* 2009-09-04 김진 : ALPS Naming change
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.event.EsdTrs0030Event"%>

<%
	EsdTrs0030Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	
	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth(); 

		event = (EsdTrs0030Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String queryStr      = JSPUtil.getNull(request.getParameter("queryStr"));

%>
<html>
<head>
<title>Invoice Inquiry Correction Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	
	var queryStr = "<%=queryStr%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();		
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 

<!-- OUTER - POPUP (S)tart -->
<table width="755" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="580" border="0">
		<tr><td class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Invoice Inquiry Correction Report</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg_b1">

				<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( Seq. ) (S) -->
				<table border="1" style="width:737;" height="545" class="grid" >
				<tr><td><script language='javascript'>comRdObject('InvCorrection');</script></td></tr>


				<!-- : ( Seq. ) (E) -->


				<!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="sbutton">
		       	<tr><td class="align">

				    <table class="sbutton">
				    <tr><td class="bt"><img class="cursor" src="/hanjin/img/button/btng_print.gif" width="65" height="19" border="0" name="btng_print"></td>
					</table>

				</td></tr>
				</table>
		    	<!-- : ( Button : Sub ) (E) -->
 		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
	</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
		<table width="100%" class="sbutton">
			<tr><td height="71" class="popup"></td></tr>
		</table>
		<table class="sbutton">
			<tr><td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
		</table>
	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>

