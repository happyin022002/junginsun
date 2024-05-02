<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0017.jsp
*@FileTitle : Invoice Customer Correction by Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.12 최도순
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceCorrection");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (FnsInv0017Event)request.getAttribute("Event");
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
<title>Invoice Item Correction(General)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<input type="hidden" name="ofc" value="">
<input type="hidden" name="ofc_cd" value="">
<input type="hidden" name="pagetype" value = ""><!-- OFFICE LIST -->
<input type="hidden" name="ar_ofc_cd2"><!-- OFFICE LIST -->
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="frm_bkg_no">
<input type="hidden" name="frm_cust_nm">
<input type="hidden" name="frm_act_cust_cnt_cd">
<input type="hidden" name="frm_act_cust_seq">
<input type="hidden" name="old_act_cust_cnt_cd">
<input type="hidden" name="old_act_cust_seq">
<input type="hidden" name="changed_cust_cd">
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
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;" id="mainTable">
					<tr class="h23">
						<td width="80">I/F Date</td>
						<td width="250"><input type="text" style="width: 80;"
							class="input1" name="from_date" maxlength="8"
							required dataformat="ymd" cofield="to_date" caption="start date" >&nbsp;<img
							class="cursor" src="img/btns_calendar.gif" width="19" height="20"
							border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;
							<input type="text" style="width: 80;"
							class="input1" name="to_date" maxlength="8"
							required dataformat="ymd" cofield="from_date" caption="end date" >&nbsp;<img
							class="cursor" src="img/btns_calendar.gif" width="19" height="20"
							border="0" align="absmiddle" name="btns_calendar2"></td>
						<td width="50">Bound</td>
						<td><select style="width: 52;" class="input1" name="io_bnd_cd">
							<option value="" selected>All</option>
							<option value="O">O/B</option>
							<option value="I">I/B</option>
						</select></td>
						<td width="50">VVD</td>
						<td><input type="text" style="width: 100;" name="frm_vvd" value="" class="input2" maxlength="9" readonly></td>
						<td width="50">Scope</td>
						<td><input type="text" style="width: 100;" name="frm_svc_scp_cd" value="" class="input2" maxlength="9" readonly></td>
						<td width="50">Office</td>
						<td style="padding: 2"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 101, 1,1);</script></td>
					</tr>
					<tr class="h23">
						<td width="80">Actual Cust.</td>
						<td width="450" colspan="5"><input type="text"
							style="width: 27;" class="input1" name="act_cust_cnt_cd"
							id="act_cust_cnt_cd" onchange="fn_act_cust_chg();"
							dataformat="engup" maxlength="2">&nbsp;<input type="text"
							class="input1" style="width: 60;" name="act_cust_seq"
							id="act_cust_seq" onchange="fn_act_cust_chg();" value=""
							maxlength="6" dataformat="num">&nbsp;<img class="cursor"
							src="img/btns_search.gif" name="btn_actcust" width="19"
							height="20" border="0" align="absmiddle">&nbsp;<input
							type="text" style="width: 300;" name="cust_lgl_eng_nm" value=""
							class="input2" readOnly>&nbsp;<img class="cursor"
							src="img/btns_search.gif" name="btn_custNm" id="btn_custNm"
							width="19" height="20" border="0" align="absmiddle"></td>
						<td width="50">Port</td>
						<td><input type="text" style="width: 100;" name="port_cd" value="" class="input" maxlength="5" dataformat="uppernum">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_port"></td>
					</tr>
					<tr class="h23">
						<td colspan="4">
						<table class="search" border="0" cellpadding="0" cellspacing="0">
							<tr class="h23">
								<td width="80">Route</td>
								<td><input type="text" style="width: 60;" name="frm_por_cd"
									class="input2" readonly> <input type="text"
									style="width: 60;" name="frm_pol_cd" class="input2" readonly>
								<input type="text" style="width: 60;" name="frm_pod_cd"
									class="input2" readonly> <input type="text"
									style="width: 60;" name="frm_del_cd" class="input2" readonly></td>
							</tr>
						</table>
						</td>
						<td width="50">B/L No.</td>
						<td><input type="text" style="width: 100;" class="input2"
							name="frm_bl_src_no" maxlength="12" readonly></td>
						<td width="50">I/F No.</td>
						<td><input type="text" style="width: 100;" class="input2"
							name="frm_ar_if_no" maxlength="11" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;" id="mainTable">
					<tr class="h23">
						<td width="80">Remark(s)</td>
						<td><input type="text" style="width: 841;" class="input"
							name="frm_inv_rmk" onblur="fn_inv_rmk_chg(this.value);"></td>
					</tr>
				</table>

				</td>
			</tr>
		</table>

		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>

		<table class="search">
			<tr>
				<td class="bg"><!-- Grid  (S) --> <script language="javascript">ComSheetObject('sheet1');</script>
				<script language="javascript">ComSheetObject('sheet2');</script> <!-- Grid (E) -->
				</td>
			</tr>
		</table>

		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>

		<table class="search" style="width: 979;">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="80">SHPR/CNEE</td>
						<td width="40"><input type="text" class="input2"
							style="width: 40;" name="frm_shpr_cust_cnt_cd" readonly></td>
						<td width="50"><input type="text" class="input2"
							style="width: 50;" name="frm_shpr_cust_seq" readonly></td>
						<td width=""><input type="text" class="input2"
							style="width: 803;" name="frm_shpr_cust_nm" readonly></td>
					</tr>
					<tr class="h23">
						<td width="80">Address</td>
						<td colspan="3"><input type="text" class="input2"
							style="width: 100%;" name="frm_shpr_cust_addr" readonly></td>
					</tr>
				</table>


				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="80">FWDR/NTFY</td>
						<td width="40"><input type="text" class="input2"
							style="width: 40;" name="frm_fwdr_cust_cnt_cd" readonly></td>
						<td width="50"><input type="text" class="input2"
							style="width: 50;" name="frm_fwdr_cust_seq" readonly></td>
						<td width=""><input type="text" class="input2"
							style="width: 803;" name="frm_fwdr_cust_nm" readonly></td>
					</tr>
					<tr class="h23">
						<td width="80">Address</td>
						<td colspan="3"><input type="text" class="input2"
							style="width: 100%;" name="frm_fwdr_cust_addr" readonly></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="320" align="left"><img class="cursor"
							src="img/btns_back_1.gif" name="btn_back_1" width="18"
							height="19" border="0" align="absmiddle"> <img
							class="cursor" src="img/btns_back.gif" name="btn_back" width="18"
							height="19" border="0" align="absmiddle"> <img
							class="cursor" src="img/btns_next.gif" name="btn_next" width="18"
							height="19" border="0" align="absmiddle"> <img
							class="cursor" src="img/btns_next_1.gif" name="btn_next_1"
							width="18" height="19" border="0" align="absmiddle"> <input
							type="text" class="input2" style="width: 30;" name="cur_cnt"
							readonly> / <input type="text" class="input2"
							style="width: 30;" name="all_cnt" readonly></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
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
		</td>
	</tr>
</table>
		<!-- 개발자 작업  끝 -->
</form></body>
</html>