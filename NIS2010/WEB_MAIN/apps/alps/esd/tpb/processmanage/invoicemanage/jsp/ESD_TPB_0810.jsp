<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0810.jsp
*@FileTitle : Invoice Cancel Remark 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-12
*@LastModifier : O Wan-Ki
*@LastVersion : 1.1
* 2008-09-12 O Wan-Ki 1.0 최초생성
* 2009-10-12 Park Sung-Jin 1.1 ALPS Migration 작업
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0810Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0810Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProcessManage.InvoiceManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0810Event)request.getAttribute("Event");
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
<title>Invoice Cancel Remark</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
	}
</script>
</head>
<!-- 개발자 작업	-->
<body onLoad="setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
<input type="hidden" name="pagerows">

<input type="hidden" name="s_file_no"> 


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">

			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Invoice Cancel Remark</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
			
						<table class="height_10"><tr><td></td></tr></table>
			
						<!-- TABLE '#D' : ( Search Options ) (S) -->
						<table class="search"> 
							<tr>
								<td class="bg_b1">				
									<!-- : ( POR ) (S) -->
									<table width="100%" id="mainTable">
										<tr>
											<td>
												* Reason for Invoice Cancel<br>
												<textarea type="text" style="width:98%" rows="5" name="s_invoice_cancel_remark" onblur="tpb_chkLenByByte(this,1000,'Reason')"></textarea>
											</td>
										</tr>
									</table>
									<!-- : ( POR ) (E) -->
								</td>
							</tr>
						</table>
						
						<table height="10"><tr><td></td></tr></table>

					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
					    	<tr>
					    		<td>       								
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_save">Save</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td width="10"></td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_close" id="btn_close">Close</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

		</td>
	</tr>
</table>


<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
</form>
</body>
</html>