<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_INV_0043.jsp
 *@FileTitle : Invoice Report by Date
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.07
 *@LastModifier : 최도순
 *@LastVersion : 1.0
 * 2009.09.07 최도순
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0043Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0043Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (FnsInv0043Event)request.getAttribute("Event");
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
<title>Invoice Report by Date</title>
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
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="ofc">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="ar_hd_qtr_ofc_cd">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"	align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"	align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="82">Office</td>
						<td width="" style="padding-left: 2"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 96, 1, 1 );</script></td>
					</tr>
					<tr class="h23">
						<td width="">ACT Cust</td>
						<td width=""><input type="text" style="width: 30;"	name="act_cust_cnt_cd" id="act_cust_cnt_cd"	onblur="fn_act_cust_chg();" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2" class="input1" onKeyUp="javascript:checkCustLeng(this.value)">&nbsp;<input type="text" style="width: 60;" name="act_cust_seq" id="act_cust_seq" onblur="fn_act_cust_chg();" value="" maxlength="6" dataformat="num" class="input1">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_actcust" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" style="width: 300;" name="cust_lgl_eng_nm" value="" class="input2">&nbsp;<img class="cursor"	src="img/btns_search.gif" name="btn_custNm" width="19" height="20" border="0" align="absmiddle"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="82">Date</td>
						<td width="203"><select style="width: 96;" class="input1" name="dt_type" onChange="javascript:chgDtType(this.value);">
							<option value="I" selected>Issue Date</option>
							<option value="G">I/F Date</option>
							<option value="S">S/A Date</option>
						</select></td>
						<td width="40" class="stm">From</td>
						<td width="" colspan="3" class="stm"><input type="text"	style="width: 82;" class="input" name="fm_dt" class="input1" onBlur="fn_ComGetMaskedValue('fm_dt');" onKeyUp="javascript:checkFmDtLeng(this.value)" cofield="to_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20"	border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;To&nbsp;<input type="text" style="width: 82;" class="input" name="to_dt" class="input1" onBlur="fn_ComGetMaskedValue('to_dt');" cofield="fm_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20"	border="0" align="absmiddle" name="btns_calendar2"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="82">VVD</td>
						<td width="203"><input type="text" style="width: 155;"	class="input" name="vvd_cd" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="9"></td>
						<td width="40">Scope</td>
						<td width="134" style="padding-left: 2"><script
							language="javascript">ComComboObject('svc_scp_cd', 1, 82, 1);</script></td>
						<td width="45">Bound</td>
						<td width=""><select style="width: 50;" class="input" name="io_bnd_cd">
							<option value="" selected>All</option>
							<option value="O">O/B</option>
							<option value="I">I/B</option>
						</select></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="82">POR/POL</td>
						<td width="202"><input type="text" style="width: 70;" class="input" name="por_cd" style="ime-mode:disabled"	onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="5"> /
						<input type="text" style="width: 70;" class="input" name="pol_cd" style="ime-mode:disabled"	onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="5"></td>
						<td width="70">POD/DEL</td>
						<td width=""><input type="text" style="width: 70;"	class="input" name="pod_cd" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="5"> /
						<input type="text" style="width: 70;" class="input" name="del_cd" style="ime-mode:disabled"	onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="5"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="80">Issue Option</td>
						<td width="" style="padding-left: 2"><select style="width: 100;" class="input" name="iss_opt" disabled>
							<option value="I" selected>Issued</option>
							<option value="N">Not-Issued</option>
							<option value="">All</option>
						</select></td>
					</tr>
				</table>
				<!-- biz_1  (E) -->
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td height="300"><!--grid (S)-->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!--grid (E)--></td>
					</tr>
				</table>


				</td>
			</tr>
		</table>



		</td>
	</tr>
</table>

<!--biz page (E)--> <!--Button (S) -->
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
						<td class="btn1" name="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_downexcel">Down Excel</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		<!--Button (E) --></td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>