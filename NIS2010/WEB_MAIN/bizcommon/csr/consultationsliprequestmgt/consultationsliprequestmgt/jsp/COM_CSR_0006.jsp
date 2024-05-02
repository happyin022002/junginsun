<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0006.jsp
*@FileTitle : Invoice CSR Creation -Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.14 함대성
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComCsr0006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String cnt_cd  = "";
	String previewFlg  = "";
	String previewFlgYN  = "";	

	previewFlg 			 	= JSPUtil.getParameter(request, "previewFlg 			      ".trim(), "");
	previewFlgYN 		 	= JSPUtil.getParameter(request, "previewFlgYN 			      ".trim(), "");
	
	Logger log = Logger.getLogger("com.hanjin.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (ComCsr0006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice CSR Creation -Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="bizcommon/csr/CoCsr.js"></script>
<script language="javascript" src="rd.js"></script>
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();		
	}
	var cnt_cd = "<%=cnt_cd%>";
	var previewFlg  = "<%=previewFlg%>";
	var previewFlgYN  = "<%=previewFlgYN%>";
</script>
</head>

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="580" border="0">
		<tr><td class="title"><img src="img/ico_t1.gif" width="20" height="12">Invoice CSR Preview</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search" >
       	<tr><td class="bg_b1">
			<!-- : ( Seq. ) (S) -->
			<table border="1" style="width:737;" height="545" class="grid" >
			<tr><td><script language='javascript'>comRdObject('csrPrevie');</script></td></tr>
			</table>

				<!-- : ( Seq. ) (E) -->
			<table class="height_10"><tr><td></td></tr></table>

				<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="sbutton">
		       	<tr><td class="align">

					<div id='btng_approvalrequest_yn' style="display:none">
				    <table class="sbutton">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_print">Print</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>	
						<!-- Approval Request 버튼 제거 						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_approvalrequest">Approval Request</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>-->
					</tr>
					</table>
					</div>

					<div id='btng_approvalrequest_yn' style="display:none">
				    <table class="sbutton">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_print">Print</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
					</tr>
					</table>
					</div>
				</td></tr>
			</table>
		    <!-- : ( Button : Sub ) (E) -->
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->



<table class="height_10"><tr><td></td></tr></table>

</td></tr>
</table>


</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btng_close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>