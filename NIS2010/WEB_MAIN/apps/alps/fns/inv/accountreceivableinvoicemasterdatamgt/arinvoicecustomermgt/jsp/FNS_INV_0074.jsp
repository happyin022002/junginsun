<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0074.jsp
*@FileTitle : (Korea)Security Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.23 최도순
* 1.0 Creation
* History
* -------------------------------------------------------- 
* 2011.12.05 권 민 [CHM-201114691] AR INV내  (Korea) Security Creation 기능 보완 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0074Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0074Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceCustomerMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0074Event)request.getAttribute("Event");
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
<title>(Korea)Security Entry</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="eff_dt" >
<input type="hidden" name="curr_cd" >
<input type="hidden" name="locl_curr_cd" >
<input type="hidden" name="pagetype" value = "I">
<!-- 2011.12.05 credit flag 추가 by Kwon Min -->
<input type="hidden" name="cr_flg" >
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

				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">Customer</td>
						<td width="570"><input type="text" class="input1"
							style="width: 30;" name="cust_cnt_cd" id="cust_cnt_cd"
							onblur="fn_cust_chg();" style="ime-mode:disabled"
							onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"
							onKeyUp="javascript:checkCustLeng(this.value)">&nbsp;<input
							type="text" class="input1" style="width: 60;" name="cust_seq"
							id="cust_seq" onblur="fn_cust_chg();" value="" maxlength="6"
							dataformat="num">&nbsp;<img class="cursor"
							src="img/btns_search.gif" name="btn_cust" width="19" height="20"
							border="0" align="absmiddle">&nbsp;<input type="text"
							style="width: 300;" name="cust_lgl_eng_nm" value=""
							class="input2">&nbsp;<img class="cursor"
							src="img/btns_search.gif" name="btn_custNm" width="19"
							height="20" border="0" align="absmiddle"></td>
						<td width="80">Credit Office</td>
						<td width=""><input type="text" style="width: 85;"
							class="input2" name="frm_ar_ofc_cd" readOnly>
						<td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">Credit FM/TO</td>
						<td width="278"><input type="text" style="width: 85;"
							class="input2" name="frm_cr_st_dt" readOnly>&nbsp;~&nbsp;<input
							type="text" style="width: 85;" class="input2"
							name="frm_cr_end_dt" readOnly></td>
						<td width="87">Credit Curr</td>
						<td width="205"><input type="text" style="width: 84;"
							class="input2" name="frm_cr_curr" readOnly></td>
						<td width="80">Credit Limit</td>
						<td width=""><input type="text"
							style="width: 170; text-align: right" class="input2"
							name="frm_cr_amt" readOnly></td>
						<td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="67">CRD Term</td>
						<td width="90" class="stm">O/B&nbsp;<input type="text"
							style="width: 60;" class="input2" name="frm_ob_cr_term_dys"
							readOnly></td>
						<td width="" class="stm">I/B&nbsp;<input type="text"
							style="width: 60;" class="input2" name="frm_ib_cr_term_dys"
							readOnly></td>

					</tr>
				</table>


				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>

				<!--grid (S)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--grid (E)--> <!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_add">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_copy">Row&nbsp;Copy</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_del">Row&nbsp;Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) --></td>
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
				<table width="72 border=" 0" cellpadding="0" cellspacing="0"
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
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="button">
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