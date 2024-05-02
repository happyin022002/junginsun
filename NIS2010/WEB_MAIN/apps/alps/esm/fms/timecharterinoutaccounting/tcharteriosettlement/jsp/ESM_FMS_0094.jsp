<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : esm_fms_0094.jsp
*@FileTitle : Revenue VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.05
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.05 손진환 
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event.EsmFms0094Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0094Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String cost_ofc_cd      = "";
	String inv_sub_sys_cd = "FMS";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOSettlement");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		cost_ofc_cd = account.getOfc_cd();

		event = (EsmFms0094Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Multi Prepayments Settlement</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="slp_iss_dt">
<input type="hidden" name="slp_ofc_cd" value="<%=cost_ofc_cd%>">
<!-- 개발자 작업	-->
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle" value="Settlement">
<input type="hidden"   name="com_mrdBodyTitle" value="Settlement">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<!-- 
				<table class="search" border="0">
				<tr>
					<td class="title_h"></td>
					<td class="title_s">Condition</td>
				</tr>
				</table>
				 -->
				<!-- Creation (S)-->
				<table class="search" border="0" style="width:779;"> 
					<tr class="h23">
						<td style="width:15%;">
							<input type="radio" name="condition" required value="C" class="trans" checked>&nbsp;&nbsp;Creation
						</td>
						<td style="width:10%;"></td>
						<td style="width:15%;">&nbsp;&nbsp;Payment Date</td>
						<td>
							<input type="text" name="pay_date" style="width:80;text-align:center;ime-mode:disabled;" class="input1" maxlength="8" dataformat="ymd" required fullfill caption="Payment Date" >&nbsp;
							<img src="img/btns_calendar.gif" name="btn_pay_date" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
						</td>
						<td style="width:10%;"></td>
						<td style="width:15%;">&nbsp;&nbsp;Effective Date</td>
						<td>	
							<input type="text" name="eff_dt" style="width:80;text-align:center;ime-mode:disabled;" class="input1" maxlength="8" dataformat="ymd" required fullfill caption="Effective Date" >&nbsp;
							<img src="img/btns_calendar.gif" name="btn_eff_dt" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
						</td>
					</tr>
				</table>
				<!-- Creation (E)-->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!-- Inquiry (S)-->
				<table class="search" border="0" style="width:779;"> 
					<tr class="h23">
						<td style="width:15%;">
							<input type="radio" name="condition" required value="S" class="trans">&nbsp;&nbsp;Inquiry
						</td>
						<td style="width:10%;"></td>
						<td style="width:15%;">&nbsp;&nbsp;Vessel</td>
						<td>
							<input type="text" name="vsl_cd" maxlength="4" style="width:80;text-align:center;ime-mode:disabled;" dataformat="engup" class="input" value="">
						</td>
						<td style="width:15%;">&nbsp;&nbsp;Effective Date</td>
						<td>
							<input type="text" name="eff_date_from" style="width:80;text-align:center;ime-mode:disabled;" class="input1" maxlength="8" dataformat="ymd" required fullfill caption="Period(From)" >&nbsp;
							<img src="img/btns_calendar.gif" name="btn_eff_date_from" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">	&nbsp;&nbsp;
							<input type="text" name="eff_date_to" style="width:80;text-align:center;ime-mode:disabled;" class="input1" maxlength="8" dataformat="ymd" required fullfill caption="Period(To)" >&nbsp;
							<img src="img/btns_calendar.gif" name="btn_eff_date_to" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
						</td>
					</tr>
				</table>
				<!-- Inquiry (E)-->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="160">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Step</td>
						<td width="" colspan="7">
							<input type="text" style="width:690" class="input2" name="apro_step" readOnly value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd) %>" >
							&nbsp;<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="apro_step_btn">
						</td>
					</tr> 
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				<!--
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Prepayments Inquiry -Grid</td></tr>
				</table>
				-->
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid (E) -->
				<!--  biz_2   (E) -->
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_creation">Creation</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_preview">Preview</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_print">Print</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
			</table>	
		</td></tr>
		</table>
    <!--Button (E) -->

</td></tr>
</table>
		
<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>