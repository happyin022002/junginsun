<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_080.jsp
*@FileTitle : Terminal invoice CSR Creation -Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-28 jongbaemoon
* 1.0 최초 생성 2
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0080Event"%>

<%
	EsdTes0080Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String cnt_cd  = "";
	String previewFlg  = "";
	String previewFlgYN  = "";	

	previewFlg 			 	= JSPUtil.getParameter(request, "previewFlg 			      ".trim(), "");
	previewFlgYN 		 	= JSPUtil.getParameter(request, "previewFlgYN 			      ".trim(), "");

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth(); 
	   cnt_cd =account.getCnt_cd();

		//event = (EsdTes0080Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
/*			eventResponse = (EsdTes0080EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
*/		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Terminal invoice CSR Creation -Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="rpt/script/rdviewer50.js"></script>
<script language="javascript">
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();		
	}
	var cnt_cd = "<%=cnt_cd%>";
	var previewFlg  = "<%=previewFlg%>";
	var previewFlgYN  = "<%=previewFlgYN%>";
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">

<!-- OUTER - POPUP (S)tart -->
<table width="755" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="580" border="0">
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"> Terminal Invoice CSR Preview</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg_b1">

				<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( Seq. ) (S) -->
				<table border="1" style="width:737;" height="545" class="grid" >
				<tr><td><script language='javascript'>comRdObject('csrPrevie');</script></td></tr>


				<!-- : ( Seq. ) (E) -->


				<!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="button">
		       	<tr><td class="btn2_bg">

					<div id='btng_approvalrequest_yn' style="display:none">
				    <table>
				    <tr>
				    <!-- 
				    	<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_print.gif" width="65" height="19" border="0" name="btng_print"></td>
						<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_approvalrequest.gif" width="126" height="19" border="0" name="btng_approvalrequest"></td>
					 -->	
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btng_print" id="btng_print">Print</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
						</td>
						<!-- Approval Request 버튼 제거 
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btng_approvalrequest" id="btng_approvalrequest">Approval Request</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
						</td>
						-->
					</tr>
					</table>
					</div>

					<div id='btng_approvalrequest_yn' style="display:none">
				    <table>
				    <tr>
				    	<!-- <td class="bt"><img class="cursor" src="/hanjin/img/button/btng_print.gif" width="65" height="19" border="0" name="btng_print"></td> -->
				    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_print" id="btng_print">Print</td>
							<td class="btn2_right"></td></tr></table></td>
					</tr>
					</table>
					</div>


				</td></tr>
				</table>
		    	<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_10"><tr><td></td></tr></table>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr>
	<td height="71" class="popup">
		<table class="sbutton">
		<tr>
			<!-- <td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td>
			 -->
			<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td><td class="btn2" name="btn_close" id="btn_close">Close</td>
				<td class="btn2_right"></td>
			</tr>
			</table>
			</td>
		</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>

