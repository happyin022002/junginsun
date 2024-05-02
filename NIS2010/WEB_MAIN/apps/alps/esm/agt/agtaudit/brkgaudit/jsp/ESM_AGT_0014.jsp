<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_014.jsp
*@FileTitle : Brokerage Detail & History fo BL Pop-up 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-23
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-23 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.event.EsmAgt0014Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
EsmAgt0014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;				//서버에서 발생한 에러

String strErrMsg = "";							//에러메세지
int rowCount	 = 0;							//DB ResultSet 리스트의 건수

String tmpGrpTp = "";							//Location 별 Type 구분
String tmpBrogDiv = "";							//Type 구분
String grpTpCode = "";							//Location 별 Type 구분 Code
String grpTpText = "";							//Location 별 Type 구분 Text
String brogDivCode = "";							//Type 구분 Code
String brogDivText = "";							//Type 구분 Text

String bl_no = "";
String bkg_no = "";
String agmt_cnt_cd = "";
String agmt_cust_seq = "";
String agmt_rt_seq = "";	

try {

	event = (EsmAgt0014Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	//ESM_AGT_0013 화면에서 넘어온 파라미터를 받는다.
	bl_no = JSPUtil.getParameter(request, "bl_no");
    bkg_no = JSPUtil.getParameter(request, "bkg_no");
    agmt_cnt_cd = JSPUtil.getParameter(request,"agmt_cnt_cd");
    agmt_cust_seq = JSPUtil.getParameter(request,"agmt_cust_seq");
    agmt_rt_seq = JSPUtil.getParameter(request,"agmt_rt_seq");	
	
	//공통코드 combo string 가져와서 필요한 부분 추출
	tmpGrpTp = JSPUtil.getIBCodeCombo("", "", "CD00888", 0, "");
	tmpBrogDiv = JSPUtil.getIBCodeCombo("", "", "CD00598", 0, "");

	if(tmpGrpTp != null && tmpGrpTp.length() > 8) {
		grpTpCode = tmpGrpTp.substring(tmpGrpTp.indexOf("Code = \"")+8, tmpGrpTp.lastIndexOf("\""));
		grpTpText = tmpGrpTp.substring(tmpGrpTp.indexOf("Text = \"")+8, tmpGrpTp.indexOf("\";"));
	}

	if(tmpBrogDiv != null && tmpBrogDiv.length() > 8) {
		brogDivCode = tmpBrogDiv.substring(tmpBrogDiv.indexOf("Code = \"")+8, tmpBrogDiv.lastIndexOf("\""));
		brogDivText = tmpBrogDiv.substring(tmpBrogDiv.indexOf("Text = \"")+8, tmpBrogDiv.indexOf("\";"));
	}

} catch (Exception e) {
	out.println(e.toString());
}
%>
<html>
<head>
<title>Brokerage Detail & History fo BL Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=grpTpCode%>", "<%=grpTpText%>", "<%=brogDivCode%>", "<%=brogDivText%>");
	}
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="hdn_bl_no" value="<%=bl_no%>">
<input type="hidden" name="hdn_bkg_no" value="<%=bkg_no%>">

<input type="hidden" name="brog_cnt_cd" value="<%=agmt_cnt_cd%>">
<input type="hidden" name="brog_cust_seq" value="<%=agmt_cust_seq%>">
<input type="hidden" name="brog_rt_seq" value="<%=agmt_rt_seq%>">

<table width="900" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Brokerage Details & History for B/L</td>
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
								<td width="120">ETD DT</td>
								<td><input type="text" name="vsl_dep_dt" style="width:100;text-align:center;background:#EEEEEE;" readOnly="true"></td>
							</tr>
							<tr class="h23">
								<td width="120">Shipper</td>
								<td>
									<input type="text" name="shpr_cnt_seq" style="width:100;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="shpr_nm" style="width:438;background:#EEEEEE;" readOnly="true">
								</td>
							</tr>
							<tr class="h23">
								<td width="120">F.Frwder / Vendor</td>
								<td>
									<input type="text" name="frt_fwrd_cnt_seq" style="width:100;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="vndr_cnt_seq" style="width:112;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="frt_fwrd_nm" style="width:322;background:#EEEEEE;" readOnly="true">
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:77%;">
							<tr class="h23">
								<td width="120">T. VVD</td>
								<td width="140"><input type="text" name="comm_vsl" style="width:100;text-align:center;background:#EEEEEE;" readOnly="true"></td>
								<td width="80">Route</td>
								<td>
									<input type="text" name="bkg_por_cd" style="width:77;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="bkg_pol_cd" style="width:77;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="bkg_pod_cd" style="width:78;text-align:center;background:#EEEEEE;" readOnly="true">
									<input type="text" name="bkg_del_cd" style="width:78;text-align:center;background:#EEEEEE;" readOnly="true">
								</td>
							</tr>
							<tr class="h23">
								<td>REF No.</td>
								<td><input type="text" name="brog_ref_no" style="width:100; text-align:center;background:#EEEEEE;" readOnly="true"></td>
								<td>FMC</td>
								<td><input type="text" name="fmc_no" style="width:158;text-align:center;background:#EEEEEE;" readOnly="true"></td>
							</tr>	
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="120">SC / RFA No.</td>
								<td width="342"><input type="text" name="sc_rfa_no" style="width:221; background:#EEEEEE;" readOnly="true"></td>
								<td width="40">Kind</td>
								<td><input type="text" name="brog_knd_cd" style="width:160;text-align:center;background:#EEEEEE;" readOnly="true"></td>
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
		<!-- Search BG (S) -->
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
<div id="div1"  STYLE="visibility:hidden;">
<table>
	<tr>
		<td ><script language="javascript">ComSheetObject('sheet4');</script></td>
	</tr>
</table>
</div>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>
<%@include file="../../../common/include/common.jsp"%>