<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_015.jsp
*@FileTitle : FAC Detail & History fo BL Pop-up 
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
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.facaudit.event.EsmAgt0015Event"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
EsmAgt0015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;				//error from server

String strErrMsg = "";							//error message
int rowCount	 = 0;							//count of DB resultSET list

String tmpGrpTp = "";							//Location Type
String tmpFacDiv = "";							//Type 
String grpTpCode = "";							//Location Type Code
String grpTpText = "";							//Location Type Text
String facDivCode = "";							//Type Code
String facDivText = "";							//Type Text

String bl_no = "";
String bkg_no = "";
String fac_ofc_cd = "";
String frt_fwrd_cnt_cd = "";
String frt_fwrd_cust_seq = "";
String fac_rt_seq = "";

try {

	event = (EsmAgt0015Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	} else {
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		bl_no = JSPUtil.getParameter(request, "bl_no");
		bkg_no = JSPUtil.getParameter(request, "bkg_no");
    	fac_ofc_cd = JSPUtil.getParameter(request, "fac_ofc_cd");
    	frt_fwrd_cnt_cd = JSPUtil.getParameter(request, "agmt_cnt_cd");
    	frt_fwrd_cust_seq = JSPUtil.getParameter(request, "agmt_cust_seq");
    	fac_rt_seq = JSPUtil.getParameter(request, "agmt_rt_seq");
    			
	} // end else

	//Extract necessary part from Common code combo string 
	tmpGrpTp = JSPUtil.getIBCodeCombo("", "", "CD00616", 0, "");
	tmpFacDiv = JSPUtil.getIBCodeCombo("", "", "CD00993", 0, "");

	if(tmpGrpTp != null && tmpGrpTp.length() > 8) {
		grpTpCode = tmpGrpTp.substring(tmpGrpTp.indexOf("Code = \"")+8, tmpGrpTp.lastIndexOf("\""));
		grpTpText = tmpGrpTp.substring(tmpGrpTp.indexOf("Text = \"")+8, tmpGrpTp.indexOf("\";"));
	}

	if(tmpFacDiv != null && tmpFacDiv.length() > 8) {
		facDivCode = tmpFacDiv.substring(tmpFacDiv.indexOf("Code = \"")+8, tmpFacDiv.lastIndexOf("\""));
		facDivText = tmpFacDiv.substring(tmpFacDiv.indexOf("Text = \"")+8, tmpFacDiv.indexOf("\";"));
	}

} catch (Exception e) {
	out.println(e.toString());
}
%>
<html>
<head>
<title>FAC Detail & History fo BL Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage("<%=grpTpCode%>", "<%=grpTpText%>", "<%=facDivCode%>", "<%=facDivText%>");
	}
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="hdn_bl_no" value="<%=bl_no%>">
<input type="hidden" name="hdn_bkg_no" value="<%=bkg_no%>">

<input type="hidden" name="fac_ofc_cd" value="<%=fac_ofc_cd%>">
<input type="hidden" name="frt_fwrd_cnt_cd" value="<%=frt_fwrd_cnt_cd%>">
<input type="hidden" name="frt_fwrd_cust_seq" value="<%=frt_fwrd_cust_seq%>">
<input type="hidden" name="fac_rt_seq" value="<%=fac_rt_seq%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="/opuscntr/img/icon_title_dot.gif" align="absmiddle">&nbsp; FAC Details & History for B/L</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!--Button_L (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	    	   	<tr>
	    	   		<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button_L (E) -->
			<!-- Search BG (S) -->
		 	<table class="search">
	   			<tr>
	   				<td class="bg">
						<table class="search" border="0" style="width:20%;" align="right">
							<tr class="h23">
								<td valign="top"><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<table><tr><td style="height:3;"></td></tr></table>
						<table class="search" border="0" style="width:77%;">
							<tr class="h23">
								<td width="120">B/L</td>
								<td width="140"><input type="text" name="bl_no" class="input1" style="width:100;text-align:center;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="12"></td>
								<td width="80">Booking No.</td>
								<td><input type="text" name="bkg_no" class="input1" style="width:110;text-align:center;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="13"></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:77%;">
							<tr class="h23">
								<td width="120">ETD Date</td>
								<td><input type="text" name="vsl_dep_dt" style="width:100;text-align:center;background:#EEEEEE;" readOnly="true"></td>
							</tr>
							<tr class="h23">
								<td>Shipper</td>
								<td>
									<input type="text" name="shpr_cnt_seq" style="width:100;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="shpr_nm" style="width:438;background:#EEEEEE;" readOnly="true">
								</td>
							</tr>
							<tr class="h23">
								<td>F. Frwder</td>
								<td>
									<input type="text" name="frt_fwrd_cnt_seq" style="width:100;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="frt_fwrd_nm" style="width:438;background:#EEEEEE;" readOnly="true">
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:77%;">
							<tr class="h23">
								<td width="120">T. VVD</td>
								<td width="140">
									<input type="text" name="comm_vsl" style="width:100;text-align:center;background:#EEEEEE;" readOnly="true"></td>
								<td width="80">Route</td>
								<td>
									<input type="text" name="bkg_por_cd" style="width:77;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="bkg_pol_cd" style="width:77;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="bkg_pod_cd" style="width:78;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="bkg_del_cd" style="width:78;text-align:center;background:#EEEEEE;" readOnly="true">
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:77%;">
							<tr class="h23">
								<td width="120">FMC</td>
								<td><input type="text" name="fmc_no" style="width:100;text-align:center;background:#EEEEEE;" readOnly="true"></td>
							</tr>	
							<tr class="h23">
								<td>SC / RFA No.</td>
								<td><input type="text" name="sc_rfa_no" style="width:297;background:#EEEEEE;" readOnly="true"></td>
							</tr>
						</table>
						<table><tr><td style="height:4;"></td></tr></table>
						<table class="line_bluedot"><tr><td style="height:20;"></td></tr></table>
						<!-- : ( grid ) (S) -->
						<table width="100%" id="mainTable1">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
						<!-- : ( grid ) (E) -->
						<!-- : ( grid ) (S) -->
						<table width="100%" id="mainTable2">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet3');</script></td>
							</tr>
						</table>
						<!-- : ( grid ) (E) -->
					</td>
				</tr>
			</table>
			<!-- Search BG (E) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_5"><tr><td></td></tr></table>
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
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td>
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
<!-- : ( Button : pop ) (E) -->
<div id="div1"  STYLE="visibility:hidden;">
<table>
	<tr>
		<td ><script language="javascript">ComSheetObject('sheet4');</script></td>
	</tr>
</table>
</div>
</form>
</body>
</html>
<%@include file="../../../common/include/common.jsp"%>