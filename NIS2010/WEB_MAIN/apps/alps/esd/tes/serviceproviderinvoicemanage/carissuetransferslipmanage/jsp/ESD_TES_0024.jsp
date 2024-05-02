<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_024.jsp
*@FileTitle : Terminal invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-18
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-18 jongbaemoon
* 1.0 최초 생성
* 2012.09.28  유병희  [CHM-201220148] [TES] eBilling PDF 증빙 조회 -- CSR Creation에 추가 수정 작업
* 2014.07.10  김영신  [CHM-201430993] Files 버튼 추가 및 활성화 기능 
* 2014.09.29  김영신  [CHM-201432136] Files 버튼 제거, Approval Step 사용안함
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0024Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl"%>
<%
	EsdTes0024Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String userId  = "";
	String ofc_cd  = "";
	String cost_ofc_cd  = "";
	String usr_eml = "";
	String usr_nm  = "";
	String cnt_cd  = "";

	String inv_cfm_dt = "";
	String vndr_seq = "";
	String vndr_seq_name = "";
	String cnt_inv = "";
	String curr_cd = "";
	String total_amt = "";
	String asanogb = "";
	String pay_group_cd = "";
	String iss_dt = "";
	String rcv_dt = "";
	String gen_pay_term_cd = "";
	String gen_pay_term_desc = "";
	String payment_due_dt = "";
	String pay_term_tp_cd = "";
	
	String inv_sub_sys_cd = "";

	/**	2013-03-05 CSR Creation 화면에서 이동해 왔을 경우 Main버튼을 통해 다시 CSR Creation 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위함 **/
	String pre_cond_inv_ofc_cd	= request.getParameter("pre_cond_inv_ofc_cd")!=null&&!request.getParameter("pre_cond_inv_ofc_cd").trim().equals("")?request.getParameter("pre_cond_inv_ofc_cd"):"";
	String pre_cond_inv_cfm_dt	= request.getParameter("pre_cond_inv_cfm_dt")!=null&&!request.getParameter("pre_cond_inv_cfm_dt").trim().equals("")?request.getParameter("pre_cond_inv_cfm_dt"):"";
	String pre_cond_vndr_seq 	= request.getParameter("pre_cond_vndr_seq")  !=null&&!request.getParameter("pre_cond_vndr_seq").trim().equals("")?request.getParameter("pre_cond_vndr_seq"):"";
	String pre_cond_vndr_seq_name 	= request.getParameter("pre_cond_vndr_seq_name")  !=null&&!request.getParameter("pre_cond_vndr_seq_name").trim().equals("")?request.getParameter("pre_cond_vndr_seq_name"):"";
	
	inv_cfm_dt 			 	= JSPUtil.getParameter(request, "inv_cfm_dt 			      ".trim(), "");
	vndr_seq 			  	= JSPUtil.getParameter(request, "vndr_seq 			        ".trim(), "");
	vndr_seq_name 		= JSPUtil.getParameter(request, "vndr_seq_name          ".trim(), "");
	cnt_inv 			  	= JSPUtil.getParameter(request, "cnt_inv 			        	".trim(), "");
	curr_cd 					= JSPUtil.getParameter(request, "curr_cd          			".trim(), "");
	total_amt 			  = JSPUtil.getParameter(request, "total_amt 			        ".trim(), "");
	asanogb 			 	 	= JSPUtil.getParameter(request, "asanogb 			        	".trim(), "");
	pay_group_cd 			 	= JSPUtil.getParameter(request, "pay_group_cd 			        	".trim(), "");
	iss_dt 						= JSPUtil.getParameter(request, "iss_dt          				".trim(), "");
	rcv_dt 						= JSPUtil.getParameter(request, "rcv_dt          				".trim(), "");
	gen_pay_term_cd 	= JSPUtil.getParameter(request, "gen_pay_term_cd 			  ".trim(), "");
	gen_pay_term_desc = JSPUtil.getParameter(request, "gen_pay_term_desc		  ".trim(), "");
	payment_due_dt 		= JSPUtil.getParameter(request, "payment_due_dt 			  ".trim(), "");
	pay_term_tp_cd 		= JSPUtil.getParameter(request, "pay_term_tp_cd 			  ".trim(), "");
	cost_ofc_cd 			= JSPUtil.getParameter(request, "cost_ofc_cd 			  		".trim(), "");
	
	inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd			".trim(), "");	

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   //userAuth=account.getAuth();
	   ofc_cd=account.getOfc_cd();
	   usr_nm=account.getUsr_nm();
	   usr_eml=account.getUsr_eml();
//		cnt_cd =account.getCnt_cd();
	    cnt_cd = JSPUtil.getNull(new TESCommonBCImpl().getMDMCnt_cd(ofc_cd)); //2009-05-08 : Office change기능 추가로 인해 cnt_cd는 session이 아닌 TES자체적으로 가져오도록 변경한다.

	   // ofc_cd  = "CHIBB";

		event = (EsdTes0024Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{

		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Terminal invoice CSR Creation - Detail</title>
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
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="inv_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="asanogb" value="<%=asanogb%>">
<input type="hidden" name="pay_group_cd" value="<%=pay_group_cd%>">
<input type="hidden" name="csr_amt">
<input type="hidden" name="iss_dt" value="<%=iss_dt%>">
<input type="hidden" name="rcv_dt" value="<%=rcv_dt%>">
<input type="hidden" name="gen_pay_term_cd" value="<%=gen_pay_term_cd%>">
<input type="hidden" name="temp_payment_due_dt" value="<%=payment_due_dt%>">
<input type="hidden" name="pay_term_tp_cd" value="<%=pay_term_tp_cd%>">
<input type="hidden" name="ap_ofc_cd" >
<input type="hidden" name="usr_eml" value="<%=usr_eml%>">
<input type="hidden" name="usr_nm" value="<%=usr_nm%>">
<input type="hidden" name="cre_usr_id" value="<%=userId%>">
<input type="hidden" name="csr_tp_cd">
<input type="hidden" name="evi_gb">
<input type="hidden" name="inv_knt">

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

<input type="hidden" name="s_tax_naid_flg">
<input type="hidden" name="s_finance_flg">
<input type="hidden" name="s_fa_flg">
<input type="hidden" name="s_tax_type">
<input type="hidden" name="s_tax_nsl_flg">

<input type="hidden" name="s_evi_inv_dt">
<input type="hidden" name="s_evi_comp_no">
<input type="hidden" name="s_evi_total_net_amt">
<input type="hidden" name="s_evi_tax_no2">
<input type="hidden" name="s_evi_total_tax_amt">
<input type="hidden" name="s_evi_ctnt1">
<input type="hidden" name="s_evi_ctnt2">
<input type="hidden" name="s_evi_ctnt3">
<input type="hidden" name="s_evi_ctnt4">
<input type="hidden" name="s_evi_ctnt5">
<input type="hidden" name="s_evi_ctnt6">
<input type="hidden" name="s_evi_ctnt7">
<input type="hidden" name="s_evi_ctnt8">
<input type="hidden" name="s_evi_ctnt9">
<input type="hidden" name="s_evi_ctnt10">
<input type="hidden" name="s_evi_ctnt11">
<input type="hidden" name="s_evi_ctnt12">
<input type="hidden" name="s_evi_tax_no">
<input type="hidden" name="s_evi_tax_code">

<input type="hidden" name="eviInputFlg">
<input type="hidden" name="s_eviInputFlg">

<!-- 전자계산서, 종이계산서 추가 -->
<input type="hidden" name="attr_ctnt8">

<input type="hidden"    name="aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(cost_ofc_cd, inv_sub_sys_cd) %>">
<input type="hidden"    name="cost_apro_step" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, "TES") %>">
<input type="hidden"    name="login_apro_step" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, "TES") %>">

<!--	2013-03-05 CSR Creation 화면에서 이동해 왔을 경우 Main 버튼을 통해 다시 CSR Creation 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위함 -->
<input name="pre_cond_inv_ofc_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_ofc_cd)%>">
<input name="pre_cond_inv_cfm_dt" type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_cfm_dt)%>">
<input name="pre_cond_vndr_seq"   type="hidden" value="<%=JSPUtil.getNull(pre_cond_vndr_seq)%>">
<input name="pre_cond_vndr_seq_name"   type="hidden" value="<%=JSPUtil.getNull(pre_cond_vndr_seq_name)%>">

<!-- TABLE '#C' : ( Left Menu : Round Frame ) (S) -->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr>
	<td>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"> Service Management > TML INV > Invoice > CSR Creation > CSR Creation > CSR Creation(Detail)<span id="navigation"></span></td></tr>
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> CSR Creation(Detail)<!-- <span id="title"></span> --></td></tr>
	</table>
	
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr><td>&nbsp;
			</td></tr>
	</table>

		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Week ) (S) -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">&nbsp;Cost Office</td>
							<td width="240">&nbsp;<input name="cost_ofc_cd" type="text" style="width:60" value="<%=cost_ofc_cd%>"></td>
							<td width="170">Payment Service Provider</td>
							<td width="">&nbsp;<input name="vndr_seq" type="text" style="width:70" value="<%=vndr_seq%>"> <!--<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">--> &nbsp;<input name="vndr_seq_name" type="text" style="width:380" value="<%=vndr_seq_name%>"></td>
							
							<td width="">&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<!--// eBilling - B //-->
							<td>
							<!-- 
							<div id="EDILayerPaging" style="display:none">
							<img src="/hanjin/img/button/btn_EDIinvoiceprint.gif" width="120" height="20" border="0" align="right" name='btn_EDIinvoiceviewPaging'>
							</div> -->
							
							<div id="EDILayerPaging" style="display:none">
							<table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_EDIinvoiceviewPaging" id="btn_EDIinvoiceviewPaging">EDI Invoice Print</td>
									<td class="btn1_right"> </td>
								</tr>
							</table>
							</div> 
							</td>
							

							
							<!--// eBilling - E //-->
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
					<table class="button" border="0" width="100%">
						<tr><td class="btn2_bg" class="align">
							<div id="btLayer" style="display:none">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td>
										<div id="EDILayer01" style="display:none">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_EDIinvoiceview" id="btn_EDIinvoiceview">Invoice PDF</td>
										<td class="btn2_right"></td></tr></table>
										</div>
									</td>	
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_main" id="btng_main">Main</td>
									<td class="btn2_right"></td></tr></table>
									</td>	
									<td class="btn1_line"></td>																
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_preview" id="btng_preview">CSR Preview</td>
									<td class="btn2_right"></td></tr></table>
									</td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_print" id="btng_print">Print</td>
									<td class="btn2_right"></td></tr></table>
									</td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_approvalrequest" id="btng_approvalrequest">CSR Create</td>
									<td class="btn2_right"></td></tr></table>
									</td>									
									<!-- Repeat Pattern -->
								</tr>
							</table>
							</div>
							<div id="btLayer" style="display:none">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td>
										<div id="EDILayer01" style="display:none">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_EDIinvoiceview" id="btn_EDIinvoiceview">Invoice PDF</td>
										<td class="btn2_right"></td></tr></table>
										</div>
									</td>	
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_main" id="btng_main">Main</td>
									<td class="btn2_right"></td></tr></table>
									</td>	
									<td class="btn1_line"></td>								
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_evidence" id="btng_evidence">증빙</td>
									<td class="btn2_right"></td></tr></table>
									</td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_preview" id="btng_preview">CSR Preview</td>
									<td class="btn2_right"></td></tr></table>
									</td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_print" id="btng_print">Print</td>
									<td class="btn2_right"></td></tr></table>
									</td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_approvalrequest" id="btng_approvalrequest">CSR Create</td>
									<td class="btn2_right"></td></tr></table>
									</td>									
									<!-- Repeat Pattern -->
								</tr>
							</table>
							</div>
						</td></tr>
					</table>
					<!-- : ( Button : Sub ) (E) -->		
						<!-- 													
									<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr><td width="10%" class="sm" align="left">
									<input type="radio" name="ofc_tp" class="trans" Onclick="ofcChange();">Cost Office&nbsp;&nbsp;&nbsp;
									<input type="radio" name="ofc_tp" class="trans" checked Onclick="ofcChange();">&nbsp;Log-in Office</td></tr></table>
						-->
									
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
						
							<td width="94">NO Of Invoice</td>
							<td width="90"><input name="cnt_inv" type="text" style="width:75" value=""></td>
							<td width="110">Invoice Currency</td>
							<td width="90"><input name="curr_cd" type="text" style="width:75" value="<%=curr_cd%>"></td>
							<td width="95">Total Amount</td>
							<td width="125"><input name="total_amt" type="text" style="width:110" value=""></td>
							<td width="375">
								<div id="srLayer" style="display:none">
									<table class="search" border="0">
										<tr class="h23">
											<td width="50">ASA No</td>
											<td><script language="javascript">ComComboObject('asa_no',1, 93 , 0 )</script></td>
										</tr>
									</table>
								</div>
								<div id="srLayer" style="display:none">
									<table class="search" border="0">
										<tr class="h23">
											<td width="100">증빙구분</td>
											<td width="">&nbsp;<select style="width:93;" name="evi_gb1" onChange="eviGbSelect(1)">
												<option value="1">세금계산서</option>
												<option value="2">계산서</option>
												<option value="3">기타</option>
												</select></td>
											<td></td>
										</tr>
									</table>
								</div>
								<div id="srLayer" style="display:none">
									<table border="0">
										<tr class="h23">
											<td width="50">ASA NO</td>
											<td width="110"><script language="javascript">ComComboObject('asa_no',1, 100, 0 )</script></td>
											<td width="60">증빙구분</td>
											<td width=""><select style="width:90;" name="evi_gb2" onChange="eviGbSelect(2)">
												<option value="1">세금계산서</option>
												<option value="2">계산서</option>
												<option value="3">기타</option>
												</select></td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
					<table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="94">Issued Date</td>
							<td width="90"><input name="max_iss_dt" type="text" style="width:75" value="" maxlength=10 onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj2(this);'></td>
							<td width="110">Received Date</td>
							<td width="90"><input name="max_rcv_dt" type="text" style="width:75" value=""  maxlength=10 onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj(this);'></td>
							<td width="95">Payment Term</td>
							<td width="125"><input name="gen_pay_term_desc" type="text" style="width:110" value="<%=gen_pay_term_desc%>"></td>
							<td width="140">Payment Due Date</td>
							<td width="235"><input name="payment_due_dt" type="text" style="width:75" maxlength="10" value="" maxlength=10 onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='if(this.value!=null&&this.value!=""){validateDateObj2(this);}'></td>
						</tr>
					</table>
					<!-- 
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="94">Approval Step</td>
							<td><input name="apro_step" type="text" style="width:853" value="<%//=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, "TES") %>"> <img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='btng_search'></td>
						</tr>
					</table>
					-->
					<table>
						<tr class="h23">
							<td width="94">CSR NO</td>
							<td width="180"><input name="csr_no" type="text" style="width:170;text-align:center;" value=""></td>
							<!-- 
							<td>
								<table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_files">Files</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							-->
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
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->

					<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->
</DIV>