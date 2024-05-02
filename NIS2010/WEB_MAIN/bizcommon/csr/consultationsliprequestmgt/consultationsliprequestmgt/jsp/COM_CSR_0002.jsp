<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : com_csr_0002.jsp
*@FileTitle : CSR Creation(Detail)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.13
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2009.07.02 함대성
* 1.0 Creation
*----------------------------------------------------------
* History
* 2013.02.13 조인영 [CHM-201322900] CSR Approval Step 결재선 변경 기능 추가
* 2013.02.18 조인영 [CHM-201322899] CSR  creation의 “Approvd By” 값 변경
* 2014.07.10 김영신 [CHM-201430993] Files 버튼 추가 및 활성화 기능 
* 2014.09.29 김영신 [CHM-201432136] Fiels 버튼 제거 , Approval Step 사용안함
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0002Event"%>
<%@ page import="com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.*"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComCsr0002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");
	
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
	//2009-11-23
	String pso_trns_slp_ctnt = "";
	
	//추가(변경) 2009-07-15 apOfcCd 를 앞단에서 받는다 
	String apOfcCd = "";
	
	inv_cfm_dt 			= JSPUtil.getParameter(request, "inv_cfm_dt 			".trim(), "");	
	vndr_seq 			= JSPUtil.getParameter(request, "vndr_seq 			    ".trim(), "");
	vndr_seq_name 		= JSPUtil.getParameter(request, "vndr_seq_name          ".trim(), ""); 		
	cnt_inv 			= JSPUtil.getParameter(request, "cnt_inv 			    ".trim(), "");
	curr_cd 		    = JSPUtil.getParameter(request, "curr_cd          		".trim(), ""); 
	total_amt 			= JSPUtil.getParameter(request, "total_amt 			    ".trim(), "");
	asanogb 			= JSPUtil.getParameter(request, "asanogb 			    ".trim(), "");	
	pay_group_cd 		= JSPUtil.getParameter(request, "pay_group_cd 			".trim(), "");	
	iss_dt 				= JSPUtil.getParameter(request, "iss_dt          		".trim(), ""); 
	rcv_dt 				= JSPUtil.getParameter(request, "rcv_dt          		".trim(), ""); 
	gen_pay_term_cd 	= JSPUtil.getParameter(request, "gen_pay_term_cd 		".trim(), "");
	gen_pay_term_desc 	= JSPUtil.getParameter(request, "gen_pay_term_desc		".trim(), "");
	payment_due_dt 		= JSPUtil.getParameter(request, "payment_due_dt 		".trim(), "");	
	pay_term_tp_cd 		= JSPUtil.getParameter(request, "pay_term_tp_cd 		".trim(), "");	
	cost_ofc_cd 		= JSPUtil.getParameter(request, "cost_ofc_cd 			".trim(), "");	
	apOfcCd 			= JSPUtil.getParameter(request, "apOfcCd 				".trim(), "");
	inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd			".trim(), "");
	//2009-11-23
	pso_trns_slp_ctnt	= JSPUtil.getParameter(request, "pso_trns_slp_ctnt		".trim(), "");

	try {
		   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		   userId=account.getUsr_id();
		   //userAuth=account.getAuth();	   
		   ofc_cd=account.getOfc_cd();	   
		   usr_nm=account.getUsr_nm();
		   usr_eml=account.getUsr_eml();
		   //cnt_cd =account.getCnt_cd();
		   //향후 모듈세션가져온다 
	  	   cnt_cd = JSPUtil.getNull(new CSRExternalFinderBCImpl().getMDMCntCd(ofc_cd)); //2009-05-08 : Office change기능 추가로 인해 cnt_cd는 session이 아닌 TES자체적으로 가져오도록 변경한다.
		
		   event = (ComCsr0002Event)request.getAttribute("Event");
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
<title>CSR Creation(Detail)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="bizcommon/csr/CoCsr.js"></script>

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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="iPage">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="inv_sub_sys_cd" value="<%=inv_sub_sys_cd%>">	<!-- 모듈 -->
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
<input type="hidden" name="ap_ofc_cd" value="<%=apOfcCd%>">	<!-- apOfcCd 앞단에서 받아오는것으로 변경  2009-07-15-->
<input type="hidden" name="usr_eml" value="<%=usr_eml%>">
<input type="hidden" name="usr_nm" value="<%=usr_nm%>">
<input type="hidden" name="cre_usr_id" value="<%=userId%>">
<input type="hidden" name="csr_tp_cd">
<input type="hidden" name="evi_gb">
<input type="hidden" name="inv_knt">
<input type="hidden" name="inv_cfm_dt" value="<%=inv_cfm_dt%>">
<!-- 2009-11-23 -->
<input type="hidden" name="pso_trns_slp_ctnt" value="<%=pso_trns_slp_ctnt%>">

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

<!-- 전자계산서/종이계산서 -->
<input type="hidden" name="attr_ctnt8">

<!-- 2009-09-30 추가 -->
<input type="hidden" name="ttl_lss_div_cd" >
<input type="hidden" name="inv_rgst_no" >

<input type="hidden" name="eviInputFlg">
<input type="hidden" name="s_eviInputFlg">
<input type="hidden" name="apopen">
<!-- RD -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<!-- 전도금 -->
<input type="hidden"   name="pso_trns_slp_ctnt_var" value="">

<input type="hidden"    name="asa_no_s">
<input type="hidden"    name="cost_aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(cost_ofc_cd, inv_sub_sys_cd) %>">
<input type="hidden"    name="login_aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(ofc_cd, inv_sub_sys_cd) %>">
<input type="hidden"    name="aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(ofc_cd, inv_sub_sys_cd) %>">
<input type="hidden"    name="cost_apro_step" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd) %>">
<input type="hidden"    name="login_apro_step" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, inv_sub_sys_cd) %>">

<!-- BackEndJob을 위한 Field -->
<input type="hidden" name="key">

<!-- asa no list -->
<input type="hidden" name="asaListFlg">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
<!--Page Title, Historical (S)-->   
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
        <tr><td class="history"><!-- img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span--></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> CSR Creation(Detail)<!--span id="title"></span--></td></tr>   
    </table>   
<!--Page Title, Historical (E)--> 
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="70">Cost Office</td>
							<td width="130"><input name="cost_ofc_cd" type="text" style="width:60;text-align:center;" value="<%=cost_ofc_cd%>"></td>
							<td width="90">Payment S/P</td>
							<td width="">&nbsp;<input name="vndr_seq" type="text" style="width:70;text-align:center;" value="<%=vndr_seq%>"> <!--<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">--> &nbsp;<input name="vndr_seq_name" type="text" style="width:380" value="<%=vndr_seq_name%>"></td>
							<!--// eBilling - B //--><td><div id="EDILayer01" style="display:none"><img src="img/enis/button/btn_EDIinvoiceprint.gif" width="120" height="20" border="0" align="right" name='btn_EDIinvoiceview'></div></td><!--// eBilling - E //-->
						</tr>
				</table>
				
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%" class="search"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 			
			<!-- Grid (E) -->
										<!-- 
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
										<tr><td width="10%" class="sm" align="left">
										<input type="radio" name="ofc_tp" class="trans" Onclick="ofcChange();">Cost Office&nbsp;&nbsp;&nbsp;
										<input type="radio" name="ofc_tp"  class="trans" Onclick="ofcChange();" checked>&nbsp;Log-in Office</td></tr></table>
										-->
				<table class="line_bluedot"><tr><td></td></tr></table>
					<!-- : ( Week ) (S) -->
					<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="90">No. Of Invoice</td>
							<td width="100"><input name="cnt_inv" type="text" style="width:80;text-align:right;" value=""></td>
							<td width="80">INV Currency</td>
							<td width="100"><input name="curr_cd" type="text" style="width:40;text-align:center;" value="<%=curr_cd%>"></td>
							<td width="90">Total Amount</td>
							<td width="120"><input name="total_amt" type="text" style="width:100;text-align:right;" value=""></td>
							<td width="399" align="left">
							
							<div id="srLayer" style="display:none">  
								<table class="search" border="0">
									<tr class="h23">
										<td width="50">ASA No.</td>
										<td><script language="javascript">ComComboObject('asa_no',2,276, 0, 0);</script></td>
									</tr>
								</table>
							</div>
							
							<div id="srLayer" style="display:none">
								<table class="search" border="0">
									<tr class="h23">
										<td width="120">증빙구분</td>
										<td>&nbsp;<select style="width:80;" name="evi_gb1" onChange="eviGbSelect(1)">
											<option value="1">세금계산서</option>
											<option value="2">계산서</option> 
											<option value="3">기타</option>
											</select></td>
									</tr>
								</table>
							</div>
							
							<div id="srLayer" style="display:none">
								<table class="search" border="0">
									<tr class="h23">
										<td width="50">ASA No.</td>
										<td width="310"><script language="javascript"><!--ComComboObject('asa_no',2,276,0,0)--></script></td>
										<td width="120">증빙구분</td>
										<td>&nbsp;<select style="width:80;" name="evi_gb2" onChange="eviGbSelect(2)">
											<option value="1">세금계산서</option>
											<option value="2">계산서</option> 
											<option value="3">기타</option>
											</select></td>
									</tr>
								</table>
							</div>	
							
							</td>	
							
						</tr>
					</table>
					
					<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="91">Issue Date</td>
							<td width="100"><input name="max_iss_dt" type="text" style="width:80;text-align:center;" value="" maxlength=10  onBlur='validateDateObj2(this);'></td>
							<td width="80">Receive Date</td>
							<td width="100"><input name="max_rcv_dt" type="text" style="width:80;text-align:center;" value=""  maxlength=10  onBlur='validateDateObj(this);'></td>
							<td width="91">Payment Term</td>
							<td width="120"><input name="gen_pay_term_desc" type="text" style="width:100;text-align:right;" value="<%=gen_pay_term_desc%>"></td>
							<td width="120">Payment Due Date</td> 
							<td width="279" style="padding-left:2"><input name="payment_due_dt" type="text" style="width:80;text-align:center;" maxlength="10" value="" maxlength=10 onKeyUp='csr_isNumD(this,"Y");' onKeyDown='csr_chkInput(this); csr_isNumD(this,"Y");' onBlur='if(this.value!=null&&this.value!=""){validateDateObj2(this);}'></td>
						</tr>
						<!-- remove 2014.09.24
						<tr class="h23">
							<td>Approval Step</td>
							<td colspan="7"><input name="apro_step" type="text" style="width:800" value="<%//=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, inv_sub_sys_cd) %>"> 
							<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='apro_route_btn'>
							</td>
						</tr> -->
						<tr class="h23">
							<td>CSR No.</td>
							<td width="180"  colspan="7"><input name="csr_no" type="text" style="width:170;text-align:center;" value=""></td>
							<!-- remove 2014.09.24
							<td colspan="6">
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
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td class="align">
					<div id="btLayer" style="display:none">
					<table class="sbutton">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_main">Main</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_preview">Preview</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_print">Print </td>
									<td class="btn1_right"></td>
								</tr>
					         	<script language="javascript">comRdObject('Rd');</script>
								</tr>
							</table></td-->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_approvalrequest">CSR Create</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					</div>
					<div id="btLayer" style="display:none">
					<table class="sbutton">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_main">Main</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>		
							<td class="btn1_line"></td>				
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_evidence">증빙</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_preview">Preview</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_print">Print</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td-->							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_approvalrequest">CSR Create</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					</div>
					<div id="btLayer" style="display:none">
					<table class="sbutton">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_main">Main</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_preview">Preview</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_print">Print</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td-->
							<!-- button명 변경 Approval Request-> CSR Create -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_approvalrequest">CSR Create</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					</div>
				</td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>

</td>
</tr>
</table>

<!-- Copyright (S) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<DIV style="display:none"> 
		<!-- Grid  (S) -->
		<table width="100%" class="search"  id="mainTable"> 
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table> 			
		<!-- Grid (E) -->
		
		<!-- Grid  (S) -->
		<table width="100%" class="search"  id="mainTable">
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table> 			
		<!-- Grid (E) --> 
</DIV>