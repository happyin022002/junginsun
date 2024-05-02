<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_035.jsp
*@FileTitle : FAC Location info Pop-up 
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
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil" %>
<%@ page import="com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0035Event"%>


<%
EsmAgt0035Event  event = null;					//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;				//error from server

String strErrMsg = "";							//error message
int rowCount	 = 0;							//count of DB resultSET list

String strUsr_id		= "";
String strUsr_nm		= "";
Logger log = Logger.getLogger("com.clt.apps.AGTAgreement.AGTCustomerAgreementinfo");

String row_type= "";
String fac_ofc_cd="";
String frt_fwrd_cnt_cd_seq="";
String fac_rt_seq="";
String rout_ref_div_cd="";
String rout_info_cd="";
String frt_fwrd_cnt_cd = "";
String frt_fwrd_cust_seq = "";

try {

	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	strUsr_id =	account.getUsr_id();
	strUsr_nm = account.getUsr_nm();
	
	event = (EsmAgt0035Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
	row_type = JSPUtil.getParameter(request, "row_type");
	fac_ofc_cd = JSPUtil.getParameter(request, "fac_ofc_cd");
	frt_fwrd_cnt_cd_seq = JSPUtil.getParameter(request, "frt_fwrd_cnt_cd_seq");
	fac_rt_seq = JSPUtil.getParameter(request, "fac_rt_seq");
	if(fac_rt_seq.equals("")){
		fac_rt_seq = "0";
	}
	rout_ref_div_cd = JSPUtil.getParameter(request, "rout_ref_div_cd");
	rout_info_cd = JSPUtil.getParameter(request, "rout_info_cd");
	frt_fwrd_cnt_cd = frt_fwrd_cnt_cd_seq.substring(0,2);
	frt_fwrd_cust_seq = frt_fwrd_cnt_cd_seq.substring(3);
	
	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	} else {
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} // end else
} catch (Exception e) {
	out.println(e.toString());
}
%>
<html>
<head>
<title>FAC Location info Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="fac_ofc_cd" value="<%=fac_ofc_cd%>">
<input type="hidden" name="frt_fwrd_cust_seq" value="<%=frt_fwrd_cust_seq%>">
<input type="hidden" name="fac_rt_seq" value="<%=fac_rt_seq%>">
<input type="hidden" name="rout_ref_div_cd" value="<%=rout_ref_div_cd%>">
<input type="hidden" name="frt_fwrd_cnt_cd" value="<%=frt_fwrd_cnt_cd%>">
<input type="hidden" name="row_type" value="<%=row_type%>">

<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="280" border="0">
		<tr><td class="title"><img src="/opuscntr/img/ico_t1.gif" width="20" height="12">FAC Location Info</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg_a">

			<table class="height_10"><tr><td></td></tr></table>

			<!-- : ( Speed ) (S) -->
					<table width="100%" id="mainTable">
						  <tr><td>
						 <script language="javascript">ComSheetObject('sheet1');</script>
						  </td></tr>
					</table>
			<!-- : ( Speed ) (E) -->
			<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button">
	    					<tr>
	    						<td class="btn2_bg">
	                            	<table border="0" cellpadding="0" cellspacing="0">
	                            		<tr>
	                                		<td>
	                                			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_rowadd">Row&nbsp;Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                                       			<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_rowclear">Row Clear</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
			<!-- : ( Button : Sub ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_10"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>		
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td>
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