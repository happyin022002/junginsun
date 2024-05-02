<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3107.jsp
*@FileTitle : Calculation Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.10 황효근
* 1.0 Creation
*---------------------------------------------------------
* History
* 2010.10.26 황효근 [CHM-201006671-01] [EES-DMT] T/S Demurrage Free Time 변경(FM_MVMT_DT 전송 파라미터 추가)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3107Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3107Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt3107Event)request.getAttribute("Event");
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
<title>Calculation Detail(s)</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="est_mk"				value="<%=JSPUtil.getParameter(request, "est_mk", "")%>">
<input type="hidden" name="svr_id"				value="<%=JSPUtil.getParameter(request, "svr_id", "")%>">
<input type="hidden" name="cntr_cyc_no"			value="<%=JSPUtil.getParameter(request, "cntr_cyc_no", "")%>">
<input type="hidden" name="dmdt_chg_loc_div_cd"	value="<%=JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", "")%>">
<input type="hidden" name="chg_seq"				value="<%=JSPUtil.getParameter(request, "chg_seq", "")%>">
<input type="hidden" name="fm_mvmt_dt"			value="<%=JSPUtil.getParameter(request, "fm_mvmt_dt", "")%>"> 		<!-- 2010.10.26 추가 -->
<input type="hidden" name="fm_mvmt_yd_cd"		value="<%=JSPUtil.getParameter(request, "fm_mvmt_yd_cd", "")%>">	<!-- 2010.11.01 추가 -->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Calculation Detail(s)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
				<table class="search" border="0" style="width:880;"> 
					<tr class="h23">
						<td width="60">CNTR No. </td>
						<td width="140"><input type="text" name="cntr_no" value="<%=JSPUtil.getParameter(request, "cntr_no", "")%>" readonly style="width:90;text-align:center;" class="input2">&nbsp;<input type="text" name="cntr_tpsz_cd" value="<%=JSPUtil.getParameter(request, "cntr_tpsz_cd", "")%>" readonly  style="width:25;text-align:center;" class="input2"></td>
						<td width="70">Tariff Type</td>
						<td width="70"><input type="text" name="dmdt_trf_cd" value="<%=JSPUtil.getParameter(request, "dmdt_trf_cd", "")%>" readonly style="width:50;text-align:center;" class="input2"></td>
						<td width="50">BKG No. </td>
						<td width="130"><input type="text" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no", "")%>" readonly style="width:110;text-align:center;text-align:center;" class="input2"></td>
						<td width="50">B/L No. </td>
						<td width="130"><input type="text" name="bl_no" value="<%=JSPUtil.getParameter(request, "bl_no", "")%>" readonly style="width:110;text-align:center;" class="input2"></td>
						<td width="90">DEM/DET OFC</td>
						<td width=""><input type="text"  name="ofc_cd" value="<%=JSPUtil.getParameter(request, "ofc_cd", "")%>" readonly  style="width:50;text-align:center;" class="input2" value=""></td>
					</tr>
				
				</table>
				<table class="height_5"><tr><td></td></tr></table>
				<!--grid (S)-->
							<table width="880"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet5');</script>
									</td>
								</tr>
							</table>
							<!--grid(E)-->
				<table class="height_5"><tr><td></td></tr></table>
							<!--biz_1_1(S)-->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s" width="200">Incurred Amount</td>
							<td width="" align="right"><input type="text" name="bzc_trf_curr_cd" readonly style="width:30;text-align:center"  class="input2">&nbsp;<input type="text" name="org_chg_amt" readonly style="width:180;text-align:right" value="" class="input2"></td>
							</tr>
							</table>
							<!--biz_1_1(e)-->
						
							<!--grid (S)-->
							<table width="880"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!--grid(E)-->
						
						
						
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
							<!--biz_1_2(S)-->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s" width="200">Commodity Exception Amount</td>
							<td width="" align="right"><input type="text" name="bzc_trf_curr_cd" readonly style="width:30;text-align:center" value="" class="input2">&nbsp;<input type="text" name="cmdt_expt_amt" readonly style="width:180;text-align:right" value="" class="input2"></td>
							</tr>
							</table>
							<!--biz_1_2(e)-->
						
							<!--grid (S)-->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table>
							<!--grid(E)-->
						
						
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
							<!--biz_1_3(S)-->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s" width="200">Exception Amount</td>
							<td width="" align="right"><input type="text" name="bzc_trf_curr_cd" readonly style="width:30;text-align:center" value="" class="input2">&nbsp;<input type="text" name="sc_rfa_expt_amt" readonly style="width:180;text-align:right" value="" class="input2"></td>
							</tr>
							</table>
							<!--biz_1_3(e)-->
						
							
							<!--grid (S)-->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet3');</script>
									</td>
								</tr>
							</table>
							<!--grid(E)-->
						
						
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
							<!--biz_1_4(S)-->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s" width="200">Discount Amount</td>
							<td width="" align="right"><input type="text" name="bzc_trf_curr_cd" readonly style="width:30;text-align:center" value="" class="input2">&nbsp;<input type="text" name="aft_expt_dc_amt" readonly style="width:180;text-align:right" value="" class="input2"></td>
							</tr>
							</table>
							<!--biz_1_4(e)-->
						
							
								
							<!--grid (S)-->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet4');</script>
									</td>
								</tr>
							</table>
							<!--grid(E)-->
						
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
							<!--biz_1_5(S)-->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s" width="200">Billable Amount</td>
							<td width="" align="right"><input type="text" name="bzc_trf_curr_cd" readonly style="width:30;text-align:center" value="" class="input2">&nbsp;<input type="text" name="bil_amt" readonly style="width:180;text-align:right" value="" class="input2"></td>
							</tr>
							</table>
							<!--biz_1_5(e)-->
							
							
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
							<!--biz_1_6(S)-->
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s" width="200">Exception Cost</td>
							<td width="" align="right"><input type="text" name="expt_curr_cd" readonly style="width:30;text-align:center" value="" class="input2">&nbsp;<input type="text" name="expt_cost_amt" readonly style="width:180;text-align:right" value="" class="input2"></td>
							</tr>
							</table>
							<!--biz_1_6(e)-->
								
							<!--grid (S)-->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="450">
										<script language="javascript">ComSheetObject('sheet6');</script>
									</td>
								</tr>
							</table>
							<!--grid(E)-->			
						
						</td>
					</tr>
				
				</table>
				
				
				
				
			
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>

</td></tr>
		</table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
				
			</tr>
		</table></td>
				
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>