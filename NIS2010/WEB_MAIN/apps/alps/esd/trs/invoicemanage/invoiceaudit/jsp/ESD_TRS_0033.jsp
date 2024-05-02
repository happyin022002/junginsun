<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0033.jsp
*@FileTitle : Service provider로부터 접수한 Invoice를 Container 단위로 Audit하고 수정하여 Confirm하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-03
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2007-01-03 poong_yeon
* 1.0 최초 생성

*@LastModifyDate : 2009-02-17
*@LastModifier : ah-young
* 금액input box에 focus 줄때 0일때 값 없애기 등의 이벤트 추가
* 1.47  N200903160130  MtyRepo select popup 추가
* 2011.03.28 손은주 [CHM-201109560-01] Split 04-Intra - Europe Business 관련 VAT 기능 개발
* 2011.04.05 김영철 [CHM-201109654-01] Frustrate 처리된 CNTR 에 대해 두번이상 S/O 가 난 건들의 Invoice 처리 가능하도록 수정요청
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBCImpl"%>
<%
	EsdTrs0033Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	SignOnUserAccount account= null;
	String ofcCd = "";
	String ida_ofc_cd = "";
	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0033Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";
		ida_ofc_cd = JSPUtil.getNull(new InvoiceAuditBCImpl().getIndiaOfcCdChk(ofcCd));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);

	String inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	String inv_vndr_seq = JSPUtil.getNull(request.getParameter("inv_vndr_seq"));
	String mode = JSPUtil.getNull(request.getParameter("mode"));	//search, modify
	String if_sys_knd_cd_param = JSPUtil.getNull(request.getParameter("if_sys_knd_cd_param"));
	String mode_tab = JSPUtil.getNull(request.getParameter("mode_tab"));
	if(mode_tab.equals("")) mode_tab = "A";
%>
<html>
<head>
<title>Invoice Audit & Confirm</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var beforeOneMonth = '<%=beforeOneMonth%>';
	var today = '<%=today%>';
	var mode_tab = '<%=mode_tab%>';
	
	var ida_ofc_cd = '<%=JSPUtil.getNull(ida_ofc_cd)%>';
	var v_ofc_Cd = '<%=JSPUtil.getNull(ofcCd)%>';

	<%= JSPUtil.getIBCodeCombo("calc_logic_cd", "", "CD00874", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		if(document.form.mode_param.value != ''){
			initMode();
		}else{
			initCurrency();
		}
		calAmt();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type='hidden' name='inv_no_param' value='<%=inv_no%>'>
<input type='hidden' name='inv_vndr_seq_param' value='<%=inv_vndr_seq%>'>
<input type='hidden' name='mode_param' value='<%=mode%>'>
<input type='hidden' name='trsp_inv_act_sts_cd_param'>
<input type='hidden' name='hid_bkg'>
<input type='hidden' name='TRSP_SO_VNDR_NO'>
<input type='hidden' name='if_sys_knd_cd_param' value='<%=if_sys_knd_cd_param%>'>
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="conti_cd"  value="">
<input type="hidden" name="bpm_sum_inv_tot_amt" >
<input type="hidden" name="ap_rvs_cng_flg">
<input type="hidden" name="TRSP_SO_EQ_KIND" value="">
<input type='hidden' name='ida_ofc_cd' value='<%=ida_ofc_cd%>'>

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td>
					    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr>
						</table>
					</td>
					<td id="btn_auth" style="display:none">
					    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_authority" name="btn_authority">Invoice Authority</td><td class="btn1_right"></td></tr>
						</table>
					</td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->




		<div id="showMin" style="display:inline">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

					<!--Buttons for Search Options(S)-->
					<table class="search_in">
				       	<tr><td align="right" style="padding-bottom:3;">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_apply" name="btng_apply">Apply</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_reset" name="btng_reset">Reset</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
					<!--Buttons for Search Options(E)-->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="75">Invoice No. </td>
							<td width="276"><input name="invoice_no" type="text" style="width:122;" maxlength=20>                        			</td>
							<td width="67">Issue Date</td>
							<td width="117"><input name="issue_dt" type="text" style="width:75;" value="<%=today%>" maxlength=8><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='btns_issue'></td>
							<td width="100">Receive Date</td>
							<td><input name="recieve_dt" type="text" style="width:75;" value="<%=today%>" maxlength=8><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='btns_recieve'></td>
							<td><div id="eurView" style='display:none'>
								<table>
									<tr class="h23">
										<td width="120">Reverse Change</td>
			       						<td width="100"><input type="checkbox" name="ap_reverse_change_flg" value="" class="trans"></td>
       								</tr>
       							</table>
       							</div>
       						</td>
						</tr>
					</table>
					
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="75">W/O S/P</td>
							<td width="460"><input type='text' name='combo_svc_provider'  style="width:122;" onChange='getVendorSeq(sheetObjects[0], document.form, this.value)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input type="text" name='svc_provider' class="input2" ReadOnly style="width:294;"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='btng_provider'></td>
							<td width="102">Payment S/P</td>
							<td width="77"><input name="paymt_sp_cd" type="hidden"><script language="javascript">ComComboObject('paymt_sp_combo', 1, 75, 1);</script></td>
							<td><input name="paymt_sp_nm" ReadOnly class="input2" type="text" style="width:100%;" ></td>
						</tr>
					</table>
					
					<div id="IndiaLayer01" style="display:none"> 
					<table class="search_in" border="0">
						<tr class="h23">						
							<td width="75">GST Reg.</td>
							<td width="276"><input type="text" style="width:122" value=""  name ="ida_gst_rgst_sts_cd" valid="1" class="input2" readOnly ></td>
							
							<td width="94">GSTIN/UIN</td>
							<td width="90"><input type="text" style="width:70" value=""  name ="ida_gst_rgst_no" valid="1" class="input2" readOnly ></td>
							
							<td width="100">State</td>
							<!-- <td><input name="recieve_dt" type="text" style="width:75;" maxlength=8><img src="/hanjin/img/blank.gif" width="4" height="1" border="0"><input type="text" name='svc_provider' class="input2" ReadOnly style="width:50%;"</td> -->
							<td><input class="input2" type="text" style="width:75" name="ida_ste_cd" valid="1" readOnly >&nbsp;<input class="input2" type="text" style="width:263" name="ida_ste_nm" valid="1" readOnly ></td>
						</tr>
					</table>
					</div>
					
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="75">Currency</td>
							<td width="90"><%= BizComUtil.getCodeCombo("apply_currency","","style='width:70;' onChange='setCurrChange();'","CURR",2,"0::ALL") %>
							</td>
							<td width="100">Invoice Amount</td>
							<td width="86"><input name="inv_amt" type="text" style="width:70;text-align:right;" value='0.00'  onBlur='calAmt();'   onFocus="initAmt(this);"></td>
							<td width="94">V.A.T Amount</td>
							<!-- <td width="90"><input name="vat_amt" type="text" style="width:70;text-align:right;" value='0.00' onBlur='calAmt();'  onFocus="initAmt(this);"></td> -->
							<td width="90"><input id="vat_amt" name="vat_amt" type="text" style="width:70;text-align:right;" value='0.00'  onBlur='calAmt();'  onFocus="initAmt(this);"></td>
							
							<td width="100">W.H.T Amount</td>
							<td width="124"><input name="wht_amt" type="text" style="width:75;text-align:right;" value='0.00' onBlur='calAmt();'  onFocus="initAmt(this);"></td>
							<td width="95">S.B.C Amount</td>
							<td width="124"><input name="sbc_amt" type="text" style="width:123;text-align:right;" value='0.00' onBlur='calAmt();'  onFocus="initAmt(this);"></td>
						</tr>
					</table>
					
					<div id="IndiaLayer02" style="display:none">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="75">CGST</td>
							<%-- <td width="90"><%= BizComUtil.getCodeCombo("apply_currency","","style='width:70;' onChange='setCurrChange();'","CURR",2,"0::ALL") %></td> --%>
							<td width="90"><input name="inp_ida_cgst_amt" type="text" style="width:70;text-align:right;" value='0.00' onBlur='fn_calVat();' onFocus="initAmt(this);"></td>
							<td width="100">SGST</td>
							<td width="86"><input name="inp_ida_sgst_amt" type="text" style="width:70;text-align:right;" value='0.00' onBlur='fn_calVat();' onFocus="initAmt(this);"></td>
							<td width="94">IGST</td>
							<td width="90"><input name="inp_ida_igst_amt" type="text" style="width:70;text-align:right;" value='0.00' onBlur='fn_calVat();' onFocus="initAmt(this);"></td>
							<td width="100">UGST</td>
							<td width="124"><input name="inp_ida_ugst_amt" type="text" style="width:75;text-align:right;" value='0.00' onBlur='fn_calVat();' onFocus="initAmt(this);"></td>
							<td width="95"></td>
							<td width="123"></td>							
						</tr>
					</table>
					</div>
					
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="75"></td>
							<td width="90"></td>
							<td width="100"></td>
							<td width="86"></td>
							<td width="94"></td>
							<td width="90"></td>
							<td width="100"></td>
							<td width="124"></td>
							<td width="95">Total Amount</td>
							<td><input name="tot_amt" type="text" class="input2" readOnly style="width:123;text-align:right;" value='0.00'></td>
						</tr>
					</table></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_5"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

					<!--Buttons for Search Options(S)-->
					<table class="search_in">
				       	<tr><td align="right" style="padding-bottom:3;">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_retrieve" name="btng_retrieve">Retrieve</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_reset2" name="btng_reset2">Reset</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
					<!--Buttons for Search Options(E)-->

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100">Work Order No.</td>
							<td width="250"><input name="wo_no" type="text" style="width:155;" onKeyup='enterCheck(this)' onBlur='value_upper(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_wo_no'></td>
							<td width="80">Booking No.</td>
							<td width="215"><input name="booking_no" type="text" style="width:160;" onKeyup='enterCheck(this)' onBlur='value_upper(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_booking_no'></td>
							<td width="105">Bill Of Lading No.</td>
							<td align="right">
								<input name="bl_no" type="text" style="width:187;" onKeyup='enterCheck(this)' onBlur='value_upper(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_bl_no'></td>
						</tr>
						<tr class="h23">
							<td>Equipment No.</td>
							<td colspan="3" style="padding-left:2;">

									<table border="0" style="height:15; width:517; background-color: #E9E9E9;">
									<tr><td class="sm" width="198" style="padding-left:10;">
											<input type="radio" name='eq_no_rdo' value='cntr' class="trans" checked>Container&nbsp;<input type="radio" name='eq_no_rdo' value='chss' onClick='checkDigit();' class="trans">Chassis&nbsp;<input type="radio" name='eq_no_rdo' value='gnst' class="trans">Genset</td>
										<td><input name="eq_no_text" type="text" style="width:280;" onKeyup='enterCheck(this)' onChange='checkDigit(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_eq_no'></td>
									</tr></table>
							</td>
							<td>Service Order No. </td>
							<td align="right">
								<input name="so_no" type="text" style="width:187;" onKeyup='enterCheck(this)' onBlur='value_upper(this)'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_so_no'></td>
						</tr>
					</table>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		</div>

		<!-- TABLE '#D' : ( Tab ) (S) -->
					<!-- TABLE '#E' : ( Tab ) (S) -->
        		<table class="tab">
                   	<tr><td><script language="javascript">ComTabObject('tab1' )</script>
        		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="20%">Sum Of Invoice Total Amount</td>
							<td width="28%"><input name="cur_sum_inv_audit" type="text" style="width:35;" ReadOnly class="input2">&nbsp;<input name="sum_inv_tot_amt_audit" type="text" style="width:145;text-align:right;" ReadOnly class="input2"></td>
							<td width="16%">Number Of Equipment</td>
							<td width="11%" class="stm">20'&nbsp;<input name="num_eq_20_audit" type="text" value='0' style="width:50; text-align:right;" ReadOnly class="input2"></td>
							<td width="11%" class="stm">40'&nbsp;<input name="num_eq_40_audit" type="text" value='0' style="width:50; text-align:right" ReadOnly class="input2"></td>
							<td class="stm">Total&nbsp;<input name="num_eq_tot_audit" type="text" value='0' style="width:50; text-align:right"></td>
						</tr>
					</table>
					
					<div id="IndiaLayer03" style="display:none">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="40">CGST</td>
							<td width="116"><input name="ida_cgst_amt_chk_sum" type="text" style="width:70;text-align:right;" value='0' class="input2" readOnly onBlur='calAmt();'   onFocus="initAmt(this);"></td>
							<td width="40">SGST</td>
							<td width="100"><input name="ida_sgst_amt_chk_sum" type="text" style="width:70;text-align:right;" value='0' class="input2" readOnly onBlur='calAmt();'   onFocus="initAmt(this);"></td>
							<td width="40">IGST</td>
							<td width="134"><input name="ida_igst_amt_chk_sum" type="text" style="width:70;text-align:right;" value='0' class="input2" readOnly onBlur='calAmt();'  onFocus="initAmt(this);"></td>
							<td width="40">UGST</td>
							<td width="117"><input name="ida_ugst_amt_chk_sum" type="text" style="width:75;text-align:right;" value='0' class="input2" readOnly onBlur='calAmt();'  onFocus="initAmt(this);"></td>
							<td width="71">HSN/SAC</td>
							<td width="70"><input name="inp_hsn_sac" type="text" style="width:65;text-align:right;" onBlur='calAmt();'   onFocus="initAmt(this);"></td>
							
														
							<td>
								<table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" id="btng_gstRateCalc" name="btng_gstRateCalc">GST Rate Calc</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
							
						</tr>
					</table>
					</div>
					
					<table width="100%" height='10'>
                        <tr><td>
                        </td></tr>
		            </table>
					<!-- : ( Grid ) (E) -->


					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_surchargeapply" name="btng_surchargeapply">Surcharge Apply</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_invoicefileimport" name="btng_invoicefileimport">Invoice File Import</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_reject" name="btng_reject">Reject</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_cntrselect" name="btng_cntrselect">CNTR Select</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_cntrnoimport" name="btng_cntrnoimport">CNTR No. Import</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel0" name="btng_downexcel0">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_mtyselect" name="btng_mtyselect">MTY Select</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_currencychange" name="btng_currencychange">Cur. Change</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_verify" name="btng_verify">Verify</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>

					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
						
<!-- 							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_gstRateCalc" name="btng_gstRateCalc">GST Rate Calc.</td><td class="btn2_right"></td></tr></table></td> -->
						
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_cntrMvmt" name="btng_cntrMvmt">CNTR MVMT</td><td class="btn2_right"></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woPreview" name="btng_woPreview">W/O Preview</td><td class="btn2_right"></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_sendtoconfirmtab" name="btng_sendtoconfirmtab">Send to Confirm Tab</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_save" name="btng_save">Save</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->


				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
</div>


<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="hiddenTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>

					<table width="100%" id="hiddenTable2">
						<tr><td>
							 <script language="javascript">ComSheetObject('sheet3');</script>
						</td></tr>
					</table>
					<table width="100%" id="hiddenTable3">
						<tr><td>
							 <script language="javascript">ComSheetObject('sheet4');</script>
						</td></tr>
					</table>
				    <!-- : ( Grid ) (E) -->

					 <table class="search_in" border="0">
						<tr class="h23">
							<td width="21%">Sum Of Invoice Total Amount</td>
							<td width="28%"><input name="cur_sum_inv" type="text" style="width:35;" ReadOnly class="input2">&nbsp;<input name="sum_inv_tot_amt" type="text" style="width:145;text-align:right;" ReadOnly class="input2"> </td>
							<td width="16%">Number Of Equipment</td>
							<td width="11%" class="stm">20'&nbsp;<input name="num_eq_20" type="text" value='0' style="width:50; text-align:right;" ReadOnly class="input2"></td>
							<td width="11%" class="stm">40'&nbsp;<input name="num_eq_40" type="text" value='0' style="width:50; text-align:right;" ReadOnly class="input2"></td>
							<td class="stm">Total&nbsp;<input name="num_eq_tot" type="text" value='0' style="width:50; text-align:right;"></td>
						</tr>
					</table>


					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_cntrMvmt" name="btng_cntrMvmt">CNTR MVMT</td><td class="btn2_right"></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_woPreview" name="btng_woPreview">W/O Preview</td><td class="btn2_right"></td></tr></table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_sendbackto" name="btng_sendbackto">Send Back to Auditing Object Tab</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_save2" name="btng_save2">Save</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_confirm" name="btng_confirm">Confirm</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
</div>


</form>


</td></tr>
</table>
<!-- Outer Table (E)-->

<table width="100%" id="hiddenTable5">
	<tr><td>
		 <script language="javascript">ComSheetObject('sheet6');</script>
	</td></tr>
</table>

<FORM NAME='scgForm' method='POST'>
<input type='hidden' name='unique_cd'>
<input type='hidden' name='open_mode'>
<input type='hidden' name='step_cd'>
<input type='hidden' name='main_row'>
<input type='hidden' name='sheet_arr_no'>
<input type='hidden' name='ofc_cty_cd'>
<input type='hidden' name='so_seq'>
<input type='hidden' name='curr_cd'>
<input type='hidden' name='cgo_tp_cd'>
<input type='hidden' name='multi_ofc_cty_cd'>
<input type='hidden' name='multi_so_seq'>
<input type='hidden' name='multi_cgo_tp_cd'>
<input type='hidden' name='check_row'>
</FORM>

</body>
</html>
