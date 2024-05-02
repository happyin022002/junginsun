<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0032.jsp
*@FileTitle : Transportation Invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.26
*@LastModifier : 최 선
*@LastVersion : 1.4
* 2009.10.01 kimjin
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.03.04 1.1 N200903030070 2009-03-04 : CSR IF Inquriy Downexcel 버튼 추가
* 2009.05.11 1.2 N200905040013  : Office Change 개념의 모듈적용 요청
* 2011.04.01 최 선   1.3 [] TITLE 변경
* 2011.12.26 최 선   1.4 [CHM-201115241] [TRS] Hold invoice 관련 메세지 추가요청
* 2013.01.25 조인영 [CHM-201322577-01] CSR creation approval step 로직 개선
* 2014.11.26 최종혁 김현화[CHM-201432901]Split 01-비용지급 전표 결재건
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0032Event"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl"%>
<%
	EsdTrs0032Event  event 		= null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;		//서버에서 발생한 에러
	String strErrMsg 			= "";		//에러메세지

	String userId  = "";
	String ofc_cd  = "";
	String usr_eml = "";
	String usr_nm  = "";
	String cnt_cd  = "";

	String inv_cfm_dt 		= "";
	String vndr_seq 		= "";
	String vndr_seq_name 	= "";
	String curr_cd 			= "";
	String asanogb 			= "";
	String paymenttype 		= null;
	String gen_pay_term_cd 	= "";
	String pay_term_tp_cd 	= "";

	String payment_due_dt 	= "";
	String inv_ofc_cd 		= null;
	String cost_ofc_cd		= "";
	String inv_sub_sys_cd	= "";	
	String conti_cd = "";

	inv_cfm_dt 			 	= JSPUtil.getParameter(request, "form_inv_cfm_dt	".trim(), "");
	vndr_seq 			  	= JSPUtil.getParameter(request, "vndr_seq 			".trim(), "");
	vndr_seq_name 			= JSPUtil.getParameter(request, "vndr_seq_name      ".trim(), "");
	curr_cd 				= JSPUtil.getParameter(request, "curr_cd          	".trim(), "");
	asanogb 		 	 	= JSPUtil.getParameter(request, "asanogb 			".trim(), "");
	paymenttype		 	 	= JSPUtil.getParameter(request, "paymenttype		".trim(), "");
	gen_pay_term_cd 		= JSPUtil.getParameter(request, "gen_pay_term_cd 	".trim(), "");
	pay_term_tp_cd 			= JSPUtil.getParameter(request, "pay_term_tp_cd 	".trim(), "");
	payment_due_dt 			= JSPUtil.getParameter(request, "payment_due_dt 	".trim(), "");
	ofc_cd		 			= JSPUtil.getParameter(request, "cost_office_cd 	".trim(), "");
	conti_cd				= JSPUtil.getParameter(request, "conti_cd 			".trim(), "");
	cost_ofc_cd 			= JSPUtil.getParameter(request, "cost_ofc_cd 		".trim(), "");
	
	inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd			".trim(), "");	

	try {

	   SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId						= account.getUsr_id();
	   usr_nm						= account.getUsr_nm();
	   usr_eml						= account.getUsr_eml();
	   cnt_cd						= account.getCnt_cd();
	   inv_ofc_cd					= account.getOfc_cd();

       //N200905040013 2009-05-11: Office Change 개념의 모듈적용
	   CSRIssueTransferSlipManageBCImpl csrBC = new CSRIssueTransferSlipManageBCImpl();
	   cnt_cd						= csrBC.searchOfficeChangedCntCd(ofc_cd);
	   
		event 						= (EsdTrs0032Event)request.getAttribute("Event");
		serverException 			= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Transportation Invoice CSR Creation - Detail</title>
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
	var cnt_cd = "<%=cnt_cd%>";
</script>
<script language="javascript" type="text/javascript">

//타이틀 안먹어서 강제로 지정해줌 20090825 김진

</script>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="cnt_cd" 		value="<%=cnt_cd%>"		>
<input type="hidden" name="asanogb" 	value="<%=asanogb%>"	>
<input type="hidden" name="paymenttype" value="<%=paymenttype%>">
<input type="hidden" name="csr_amt">
<input type='hidden' name='pgmNo' value='ESD_TRS_0032'>		
<input type="hidden" name="ap_ofc_cd" >
<input type="hidden" name="usr_eml" 	value="<%=usr_eml%>"	>
<input type="hidden" name="usr_nm" 		value="<%=usr_nm%>"		>
<input type="hidden" name="cre_usr_id" 	value="<%=userId%>"		>
<input type="hidden" name="conti_cd" 	value="<%=conti_cd%>"		>
<input type="hidden" name="csr_tp_cd">
<input type="hidden" name="evi_gb">

<input type="hidden" name="tax_naid_flg">
<input type="hidden" name="finance_flg">
<input type="hidden" name="fa_flg">
<input type="hidden" name="tax_type">
<input type="hidden" name="tax_nsl_flg">

<input type="hidden" name="evi_inv_dt">
<input type="hidden" name="evi_comp_no">
<input type="hidden" name="evi_total_net_amt">
<input type="hidden" name="evi_tax_no2">
<input type="hidden" name="evi_total_tax_amt">
<input type="hidden" name="evi_ctnt1">
<input type="hidden" name="evi_ctnt2">
<input type="hidden" name="evi_ctnt3">
<input type="hidden" name="evi_ctnt4">
<input type="hidden" name="evi_ctnt5">
<input type="hidden" name="evi_ctnt6">
<input type="hidden" name="evi_ctnt7">
<input type="hidden" name="evi_ctnt8">
<input type="hidden" name="evi_ctnt9">
<input type="hidden" name="evi_ctnt10">
<input type="hidden" name="evi_ctnt11">
<input type="hidden" name="evi_ctnt12">
<input type="hidden" name="evi_tax_no">
<input type="hidden" name="evi_tax_code">
<input type="hidden" name="eviInputFlg">
<input type="hidden" name="gen_pay_term_cd"  value="<%=gen_pay_term_cd%>">
<input type="hidden" name="pay_term_tp_cd"  value="<%=pay_term_tp_cd%>">
<input type="hidden" name="payment_due_dt"  value="<%=payment_due_dt%>">
<input type="hidden" name="cfm_dt" value="<%=inv_cfm_dt%>">
<input type="hidden" name="asa_no">
<input type="hidden" name="inv_ofc_cd" value="<%=inv_ofc_cd%>">
<input type="hidden" name="wo_vndr_seq">
<input type="hidden" name="type" value="">
<input type="hidden" name="r_inv_no">
<input type="hidden" name="r_inv_vndr_seq">
<input type="hidden"    name="aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(cost_ofc_cd, inv_sub_sys_cd) %>">
<input type="hidden"    name="cost_apro_step" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, "TRS") %>">
<input type="hidden"    name="login_apro_step" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(inv_ofc_cd, "TRS") %>">

<!-- TABLE '#C' : ( Left Menu : Round Frame ) (S) -->


<!-- Outer Table (S)-->
<table width="100%" border="0" right="" cellpadding="0" cellspacing="0" class="bodypadding" style="PADDING-RIGHT: 5px;">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;CSR Creation&nbsp;(Detail)</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Week ) (S) -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="7%">Cost Office</td>
							<td width="13%">&nbsp;<input name="cost_ofc_cd" type="text" style="width:60" value="<%=ofc_cd%>"></td>
							<td width="17%">Payment Service Provider</td>
							<td><input name="vndr_seq" type="text" style="width:220" value="<%=vndr_seq%>"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><!--<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">-->&nbsp;<input name="vndr_seq_name" type="text" style="width:380" value="<%=vndr_seq_name%>"></td>
						</tr>
					</table>
					<!-- : ( Week ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->
					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="sbutton">
						<tr>
							<td class="align">
								<div id="btLayer" style="display:none">


								<!--  Button_Sub (S) -->
								<table width="100%" class="button">
							       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btng_preview" name="btng_preview">Preview</td><td class="btn2_right"></td></tr></table></td>

										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btng_print" name="btng_print">Print</td><td class="btn2_right"></td></tr></table></td>

										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btng_approvalrequest" name="btng_approvalrequest">CSR Create</td><td class="btn2_right"></td></tr></table></td>
										<!-- N200903030070 2009-03-04 : CSR IF Inquriy Downexcel 버튼 추가 -->

										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel1" name="btng_downexcel1">Down Excel</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
								</table>
						    		<!-- Button_Sub (E) -->
								</div>


								<div id="btLayer" style="display:none">
										<!--  Button_Sub (S) -->
										<table width="100%" class="button">
									       	<tr><td class="btn2_bg">
											<table border="0" cellpadding="0" cellspacing="0">
											<tr>

												<!-- Repeat Pattern -->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" id="btng_evidence" name="btng_evidence">증빙</td><td class="btn2_right"></td></tr></table></td>

												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" id="btng_preview" name="btng_preview">Preview</td><td class="btn2_right"></td></tr></table></td>

												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" id="btng_print" name="btng_print">Print</td><td class="btn2_right"></td></tr></table></td>

												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" id="btng_approvalrequest" name="btng_approvalrequest">CSR Create</td><td class="btn2_right"></td></tr></table></td>

												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel1" name="btng_downexcel1">Down Excel</td><td class="btn2_right"></td></tr></table></td>
												<!-- Repeat Pattern -->


											</tr></table>
										</td></tr>
										</table>
								    		<!-- Button_Sub (E) -->

								</div>
							</td>
						</tr>
					</table>
					<!-- : ( Button : Sub ) (E) -->
										<!-- <table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr><td width="10%" class="sm" align="left">
										<input type="radio" name="ofc_tp" class="trans" Onclick="ofcChange();">Cost Office&nbsp;&nbsp;&nbsp;
										<input type="radio" name="ofc_tp"  class="trans" Onclick="ofcChange();" checked>&nbsp;Log-in Office</td></tr></table> -->
				</td>
			</tr>
		</table>

				<table class="height_10"><tr><td></td></tr></table>

		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Week ) (S) -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="90">No. Of Invoice</td>
							<td width="113"><input name="cnt_inv" type="text" style="width:90" value=""></td>
							<td width="104">Invoice Currency</td>
							<td width="113"><input name="curr_cd" type="text" style="width:90" value="<%=curr_cd%>"></td>
							<td width="90">Total Amount</td>
							<td width="133"><input name="total_amt" type="text" style="width:110" value=""></td>
							<td width="336">

							<div id="srLayer" style="display:none">
								<table class="search" border="0">
									<tr class="h23">
										<td width="120">ASA No.</td>
										<td>
											<script language="javascript">ComComboObject('asa_no_1', 1, 93, 0)</script>
										</td>
									</tr>
								</table>
							</div>

							<div id="srLayer" style="display:none">
								<table class="search" border="0">
									<tr class="h23">
										<td width="120">증빙구분</td>
										<td><select style="width:93;" name="evi_gb1" onChange="eviGbSelect(1)">
												<option value=""></option>
												<option value="1">세금계산서</option>
												<option value="2">계산서</option>
												<option value="3">기타</option>
											</select>
										</td>
									</tr>
								</table>
							</div>

							<div id="srLayer" style="display:none">
								<table class="search" border="0">
									<tr class="h23">
										<td width="55">ASA No.</td>
										<td width="110">
											<script language="javascript">ComComboObject('asa_no_2', 1, 90, 0)</script>
										</td>
										<td width="55">증빙구분</td>
										<td><select style="width:93;" name="evi_gb2" onChange="eviGbSelect(2)">
												<option value=""></option>
												<option value="1">세금계산서</option>
												<option value="2">계산서</option>
												<option value="3">기타</option>
											</select>
										</td>
									</tr>
								</table>
							</div>
							</td>
						</tr>
					<table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="90">Issue Date</td>
							<td width="113"><input name="max_iss_dt" type="text" style="width:90" value="" ></td>
							<td width="104">Receive Date</td>
							<td width="113"><input name="max_rcv_dt" type="text" style="width:90" value="" ></td>
							<td width="90">Payment Term</td>
							<td width="133"><input name="gen_pay_term_view" type="text" style="width:110" value=""></td>
							<td width="120">Payment Due Date</td>
							<td><input name="payment_due_dt_view" type="text" style="width:80" maxlength="8" value="" onKeyPress="form_keypress();" onChange="form_change(this);"></td>
							<td>Mst.Inv Creation<input type="checkbox" checked name="mst_inv_file_flg" value="Y" class="trans"></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<!--  <tr class="h23">
							<td width="90">Approval Step</td>
							<td><input name="apro_step" type="text" style="width:866" value="<%//==com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(inv_ofc_cd, "TRS") %>"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='btns_search'></td>
						</tr> -->
						<tr class="h23">
							<td width="90">CSR No.</td>
							<td><input name="csr_no" type="text" style="width:100%" value=""></td>
						</tr>


					</table>
					<!-- : ( Week ) (E) -->
			</td>
			</tr>
		</table>
	<!-- TABLE '#D' : ( Tab BG Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>
<DIV style="display:none">
					<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable2">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->

					<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable3">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->
</DIV>