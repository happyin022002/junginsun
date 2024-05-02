<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0094_01.jsp
*@FileTitle : Invoice Customer Change(Single)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.26 최도순
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv009402Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv009402Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceCorrection");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();
	   
		event = (FnsInv009402Event)request.getAttribute("Event");
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
<title>Invoice Customer Change(Multi)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pagetype" value = "">
<input type="hidden" name="ofc">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="svr_id">
<input type="hidden" name="ar_ofc_cd2">
<input type="hidden" name="inv_nos">
<input type="hidden" name="bl_nos">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="user_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="bnd" value="A">

<input type="hidden" name="user_id" value="<%=strUsr_id%>">
<input type="hidden" name="if_user_id" >
<input type="hidden" name="invs_email">
<input type="hidden" name="state">
<input type="hidden" name="ots_smry_cd">
<input type="hidden" name="inv_dup_flg">
<input type="hidden" name="inv_mlt_bl_iss_flg">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="email_flag" value="N">
<input type="hidden" name="login_ofc_cd" value="<%=loginOfcCd%>">
<input type="hidden" name="print_nm">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>
		<!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0"
			width=100%>
			<tr>
				<td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
		<!-- Tab (E) -->
		<div id="tabLayer" style="display: inline">
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="110">Old Customer</td>
						<td width="460"><input type="text" style="width: 30;"
							class="input1" name="cnt_cd" id="cnt_cd" onblur="fn_cust_chg();"
							style="ime-mode:disabled"
							onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"
							onKeyUp="javascript:checkCustLeng('cnt_cd')">&nbsp;<input
							type="text" style="width: 60;" class="input1" name="cust_cd"
							id="cust_cd" onblur="fn_cust_chg();" value="" maxlength="6"
							dataformat="num">&nbsp;<input type="text"
							style="width: 300;" name="cust_nm" value="" class="input2"></td>
						</td>
						<td width="40">Office</td>
						<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 1,1);</script></td>
					</tr>
					<tr class="h23">
						<td width="">Issue Date</td>
						<td width="" colspan="3"><input type="text"
							style="width: 80;" class="input1" name="iss_fm_dt"
							dataformat="ymd" cofield="iss_to_dt"
							onBlur="fn_ComGetMaskedValue('iss_fm_dt');"
							onKeyUp="javascript:checkFmDtLeng(this.value)">&nbsp;<img
							class="cursor" src="img/btns_calendar.gif" width="19" height="20"
							border="0" align="absmiddle" name="btns_calendar">&nbsp;~&nbsp;<input
							type="text" style="width: 80;" class="input1" name="iss_to_dt"
							dataformat="ymd" cofield="iss_fm_dt"
							onBlur="fn_ComGetMaskedValue('iss_to_dt');">&nbsp;<img
							class="cursor" src="img/btns_calendar.gif" width="19" height="20"
							border="0" align="absmiddle" name="btns_calendar1"></td>
					</tr>
				</table>
				<!-- biz_1  (E) -->
				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>
				<!--grid (S)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						<script language="javascript">ComSheetObject('sheet2');</script></td>
					</tr>
				</table>
				<!--grid (E)-->
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<!-- biz_3  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="50">New</td>
						<td width="90">Actual Cust.</td>
						<td width=""><input type="text" style="width: 30;"
							name="act_cust_cnt_cd" id="act_cust_cnt_cd"
							onblur="fn_act_cust_chg();" style="ime-mode:disabled"
							onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"
							onKeyUp="javascript:checkCustLeng('act_cust_cnt_cd')"
							class="input1">&nbsp;<input type="text"
							style="width: 60;" name="act_cust_seq" id="act_cust_seq"
							onblur="fn_act_cust_chg();" value="" maxlength="6"
							dataformat="num" class="input1">&nbsp;<img class="cursor"
							src="img/btns_search.gif" name="btn_actcust" width="19"
							height="20" border="0" align="absmiddle">&nbsp;<input
							type="text" style="width: 200;" name="cust_lgl_eng_nm" value=""
							class="input2" readOnly>&nbsp;<img class="cursor"
							src="img/btns_search.gif" name="btn_custNm" width="19"
							height="20" border="0" align="absmiddle"></td>
						<td width="90">Invoice Cust.</td>
						<td width=""><input type="text" style="width: 30;"
							name="inv_cust_cnt_cd" id="inv_cust_cnt_cd"
							onblur="fn_inv_cust_chg();" style="ime-mode:disabled"
							onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"
							onKeyUp="javascript:checkCustLeng('inv_cust_cnt_cd')"
							class="input1">&nbsp;<input type="text"
							style="width: 60;" name="inv_cust_seq" id="inv_cust_seq"
							onblur="fn_inv_cust_chg();" value="" maxlength="6"
							dataformat="num" class="input1">&nbsp;<img class="cursor"
							src="img/btns_search.gif" name="btn_invcust" width="19"
							height="20" border="0" align="absmiddle">&nbsp;<input
							type="text" style="width: 200;" name="inv_cust_lgl_eng_nm" value=""
							class="input2" readOnly>&nbsp;<img class="cursor"
							src="img/btns_search.gif" name="btn_invCustNm" width="19"
							height="20" border="0" align="absmiddle"></td>
					</tr>

				</table>
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">Invoice No.</td>
						<td width="460"><input type="text" style="width: 96;"
							class="input2" name="f_inv"> &nbsp;-&nbsp;<input
							type="text" style="width: 100;" class="input2" name="t_inv"></td>
						<td width="150">Total Invoice Count</td>
						<td width=""><input type="text" style="width: 40;"
							class="input2" name="tot_inv_cnt"></td>
					</tr>
					<tr class="h23">
						<td width=""></td>
						<td width=""></td>
						<td width="">Number of copy invoice</td>
						<td width=""><input type="text" style="width: 40;"
							class="input" name="copy_cnt"></td>
					</tr>

				</table>
				<!-- biz_3  (E) --></td>
			</tr>
		</table>
		</div>

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_PaperIssue">Paper Issue</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_GotoSend">Go to Send</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) -->
		<!------- Print용 Hidden RD Object Start -------->
		<table width="100%" id="rdTable">
			<tr>
				<td width="100%"><script language="javascript">comRdObject('Rd');</script>
				</td>
			</tr>
		</table>
		<!------- Print용 Hidden RD Object End -------->
		</td>
	</tr>
</table>		
	<!-- 개발자 작업  끝 -->
</form>
</body>
</html>