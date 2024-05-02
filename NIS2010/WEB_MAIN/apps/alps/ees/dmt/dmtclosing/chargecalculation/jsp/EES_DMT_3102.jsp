<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3102.jsp
*@FileTitle : Partial Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.08.03 황효근
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3102Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeCalculation");
	
	// 팝업 페이지로 호출시 받아오는 파라미터 값들
	String bkgNo		= JSPUtil.getParameter(request, "bkg_no", "");
	String blNo			= JSPUtil.getParameter(request, "bl_no", "");
	String dmdtTrfCd	= JSPUtil.getParameter(request, "dmdt_trf_cd", "");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt3102Event)request.getAttribute("Event");
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
<title>Partial Payment</title>
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

<input type="hidden" name="svr_id"				value="<%=JSPUtil.getParameter(request, "svr_id", "")%>">
<input type="hidden" name="cntr_no"				value="<%=JSPUtil.getParameter(request, "cntr_no", "")%>">
<input type="hidden" name="cntr_cyc_no"			value="<%=JSPUtil.getParameter(request, "cntr_cyc_no", "")%>">
<input type="hidden" name="dmdt_chg_loc_div_cd"	value="<%=JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", "")%>">
<input type="hidden" name="cntr_tpsz_cd"		value="<%=JSPUtil.getParameter(request, "cntr_tpsz_cd", "")%>">
<input type="hidden" name="dmdt_chg_sts_cd"		value="<%=JSPUtil.getParameter(request, "dmdt_chg_sts_cd", "")%>">
<input type="hidden" name="backendjob_key">		<!-- BackEndJob Key -->
<input type="hidden" name="backendjob_id">		<!-- BackEndJob 구분 ID -->
<input type="hidden" name="yd_cd1">				<!-- Yard Code Validation -->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Partial Payment</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:840;"> 
					<tr class="h23">
						<td width="50">BKG No.</td>
						<td width="140"><input type="text" name="bkg_no" value="<%=bkgNo%>" style="width:110;" class="input2" readonly value=""></td>
						<td width="50">B/L No.</td>
						<td width="140"><input type="text" name="bl_no" value="<%=blNo%>" style="width:110;" class="input2" readonly value=""></td>
						<td width="70">Tariff Type</td>
						<td width=""><input type="text" name="dmdt_trf_cd" value="<%=dmdtTrfCd%>" style="width:110;" class="input2" readonly value=""></td>
					</tr>
				</table> 
					
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
				<!-- Grid  (S) -->

					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid  (E) -->
				
				<!--  biz_3  (S) -->
				<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowInsert">Row Insert</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Delete">Delete</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							<!-- 
							<td>
							<table class="search" border="0"> 
								<tr class="h23">
									<td width="40" align="right">Date</td>
									<td width="110"><input type="text" style="width:85;" class="input1" name="upd_dt" dataformat="ymd"  maxlength=8>&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
									<td width="40" align="right">Yard </td>
									<td width=""><input type="text" style="width:80;" class="input1" name="upd_yd_cd" dataformat="engup" maxlength="7" caption="Yard" >&nbsp;</td>
								</tr>
							</table>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Update">Update</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							-->
					</tr></table>
					</td></tr>
					</table>
				<!--  biz_3   (E) -->
				
			</td></tr>
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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
				
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>