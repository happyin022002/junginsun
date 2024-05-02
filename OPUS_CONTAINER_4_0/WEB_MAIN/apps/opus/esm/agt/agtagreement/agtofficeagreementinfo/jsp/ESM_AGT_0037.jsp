<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_037.jsp
*@FileTitle : Other Information info(Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0037Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	String agmt_ofc_cd		= "";
	String vndr_cnt_cd  	= "";
	String vndr_seq  		= "";
	String agmt_ofc_cty_cd  = "";
	String agn_agmt_seq  	= "";
	String agn_agmt_ver_seq	= "";
	String io_bnd_cd  		= "";
	String ac_tp_cd  		= "";
	String agn_seq  		= "";
	String otr_ref_div_cd   = "";

	EsmAgt0037Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//error from server
	String strErrMsg = "";							//error message
	int rowCount	 = 0;							//count of DB resultSET list0";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.AGTAgreement.AGTOfficeAgreementInfo");
	
	//Parameters from ESM_AGT_0045 
	String pageType = "";

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	  	strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsmAgt0037Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
//			if (eventResponse != null) {
//				rowSet = eventResponse.getRs();
//				if(rowSet != null){
//					 rowCount = rowSet.getRowCount();
//				} // end if
//			} // end if

			//Receiving Parameters from ESM_AGT_003 
			agmt_ofc_cd  = JSPUtil.getParameter(request, "agmt_ofc_cd");
			vndr_cnt_cd  = JSPUtil.getParameter(request, "vndr_cnt_cd");
			vndr_seq  = JSPUtil.getParameter(request, "vndr_seq");
			agmt_ofc_cty_cd  = JSPUtil.getParameter(request, "agmt_ofc_cty_cd");
			agn_agmt_seq  = JSPUtil.getParameter(request, "agn_agmt_seq");
			agn_agmt_ver_seq  = JSPUtil.getParameter(request, "agn_agmt_ver_seq");
			io_bnd_cd  = JSPUtil.getParameter(request, "io_bnd_cd");
			ac_tp_cd  = JSPUtil.getParameter(request, "ac_tp_cd");
			agn_seq  = JSPUtil.getParameter(request, "agn_seq");
			otr_ref_div_cd = JSPUtil.getParameter(request, "otr_ref_div_cd");
			
//			Receiving Parameters from ESM_AGT_0045 
			pageType = JSPUtil.getParameter(request, "pageType"); 
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Other Information info(Pop-up)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}
	
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="agmt_ofc_cd" value="<%= agmt_ofc_cd %>">
<input type="hidden" name="vndr_cnt_cd" value="<%= vndr_cnt_cd %>">			<!-- Receiving Parameters from ESM_AGT_0003  -->
<input type="hidden" name="vndr_seq" value="<%= vndr_seq %>">
<input type="hidden" name="agmt_ofc_cty_cd" value="<%= agmt_ofc_cty_cd %>">
<input type="hidden" name="agn_agmt_seq" value="<%= agn_agmt_seq %>">
<input type="hidden" name="agn_agmt_ver_seq" value="<%= agn_agmt_ver_seq %>">
<input type="hidden" name="io_bnd_cd" value="<%= io_bnd_cd %>">
<input type="hidden" name="ac_tp_cd" value="<%= ac_tp_cd %>">
<input type="hidden" name="agn_seq" value="<%= agn_seq %>">
<input type="hidden" name="otr_ref_div_cd" value="<%= otr_ref_div_cd %>">
<input type="hidden" name="ctrt_ref_div_cd" value="<%= otr_ref_div_cd %>">

<!-- Receiving Parameters from ESM_AGT_0045  -->
<input type="hidden" name="pageType" value="<%= pageType %>">
<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="280" border="0">
				<tr>
					<td class="title"><img src="/opuscntr/img/ico_t1.gif" width="20" height="12">Other Information Info.</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     		<table class="search">
       			<tr>
       				<td class="bg_a">
						<table class="height_10">
							<tr><td></td></tr>
						</table>
						<!-- : ( Speed ) (S) -->
						<table width="100%" id="mainTable">
						  <tr>
						  	<td><script language="javascript">ComSheetObject('sheet1');</script></td>
						  </tr>
						</table>
						<!-- : ( Speed ) (E) -->
						<!--  Button_Sub (S) -->
						<% if(!pageType.equals("Inquiry")){%>
						<table width="100%" class="button">
			       			<tr>
			       				<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<%} %>
				    	<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
    		   	<tr>
    		   		<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<!-- Repeat Pattern -->
								<% if(!pageType.equals("Inquiry")){%>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_ok" id="btn_ok">OK</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<%} %>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close" id="btn_close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
				<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>
<%@include file="../../../common/include/common.jsp"%>