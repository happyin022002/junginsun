<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	String ofc_cd = "";
	String cnt_cd  = "";
	String userId = "";
	String usr_nm = "";
	String usr_eml = "";
	String ifStatus 	= "";
	
	try {
	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";
	   cnt_cd = account.getCnt_cd()!=null&&!account.getCnt_cd().equals("")?account.getCnt_cd():"";
	   
	   userId=account.getUsr_id();
	   usr_nm=account.getUsr_nm();
	   usr_eml=account.getUsr_eml();
	   
	}catch(Exception e) {
		out.println(e.toString());
	}

	String readOnlyYn 	= null;
	String csrNo 		= null;
	
	
	readOnlyYn 			= JSPUtil.getParameter(request,"READONLY_YN".trim(),"");
	csrNo				= JSPUtil.getParameter(request,"CSR_NO".trim(),"");
	ifStatus			= JSPUtil.getParameter(request,"if_status".trim(),"");

	
%>
<html>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var cnt_cd = "<%=cnt_cd%>";
	var READONLY_YN = "<%=readOnlyYn%>";
	var OFC_CD = "<%=ofc_cd%>";
	var ifStatus = "<%=ifStatus%>";
	
    function setupPage(){
	    loadPage();
    }
</script>
</head>

<body onload="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="csr_no">
<input type="hidden" name="DB_DATE" value=''>
<input type="hidden" name="inv_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="cnt_cd" value="<%=cnt_cd%>">
<input type="hidden" name="cost_ofc_cd">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="inv_knt">
<input type="hidden" name="curr_cd">   
<input type="hidden" name="total_amt">
<input type="hidden" name="max_iss_dt">
<input type="hidden" name="max_rcv_dt">
<input type="hidden" name="payment_due_dt">
<input type="hidden" name="aproSeqKey">
<input type="hidden" name="cost_apro_step">
<input type="hidden" name="login_apro_step">
<input type="hidden" name="cre_usr_id" value="<%=userId%>">
<input type="hidden" name="usr_eml" value="<%=usr_eml%>">
<input type="hidden" name="usr_nm" value="<%=usr_nm%>">
<input type="hidden" name="csr_tp_cd">

	<!-- TABLE '#C' : ( Left Menu : Round Frame ) (S) -->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->



					<!-- TABLE '#D' : ( Button : Main ) (S) -->
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
							<tr><td class="btn1_bg">

									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
										<!-- Repeat Pattern -->

									</tr></table>

							</td></tr>
					</table>
					<!-- TABLE '#D' : ( Button : Main ) (E) -->
					<!-- TABLE '#D' : ( Search Options :  ) (S) -->
					<table class="search">
						<tr>
							<td class="bg">
							<!-- : ( Week ) (S) -->
							<table class="search" border="0">
								<tr class="h23"><td width="93"><img class="nostar">Invoice OFC</td>
									<td width="95">&nbsp;
										<input name="ofc_cd" type="text" maxlength=6 style="width:80" class="input1" value="<%=ofc_cd%>" onKeyUp='tes_isApNum(this); this.value=this.value.toUpperCase();' onKeyDown='tes_chkInput(this); this.value=this.value.toUpperCase();' readonly></td>
									<td width="70">&nbsp;&nbsp;Date</td>
									<td width="159">&nbsp;
									<select style="width:150;" name='dt_status'>
										<option value=""></option>
										<option value="RA">Requesting Approval</option>
										<option value="AR">Approval Requested</option>
										<option value="AV">Approved or Disapproved</option>
										<option value="IU">I/F Status Updated</option>
									</select>
									</td>
									<td width="">&nbsp;<input name="fm_eff_dt" type="text" style="width:75" maxlength=10 value="" onKeyUp='tes_isNumD(this,"Y"); tes_moveFocus(this,this.form.to_eff_dt,10);' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj(this);'>
									<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
									~
									<input name="to_eff_dt" type="text" style="width:75" maxlength=10 value="" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' onBlur='validateDateObj(this);'>
									<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
									<td width="65">I/F Status</td>
									<td width="258">&nbsp;
									<select style="width:140;" name='if_status'>
										<option value="AL" selected>All</option>
										<option value="RA">Requesting Approval</option>
										<option value="AR">Approval Requested</option>
										<option value="SD">Sending</option>
										<option value="DA">Disapproved</option>
										<option value="IE">I/F Error</option>
										<option value="RJ">A/P Rejected</option>
										<option value="SC">I/F Success</option>
									</select>
									</td>
								</tr>
								
								<tr class="h23"><td width="93"><img class="nostar">Apro Type</td>
									<td width="95">&nbsp;
									<select style="width:60;" name='search_tp_cd'>
										<option value="" selected>All</option>
										<option value="AL">ALPS</option>
										<option value="GW">G/W</option>
									</select>
									</td>
									<td width="70">&nbsp;&nbsp;CSR No.</td>
									<td colspan="2">&nbsp;
										<input name="search_csr_no" type="text" maxlength=20 style="width:200" value="<%=csrNo%>" onKeyPress='tes_enterCheck("retrieve");' onBlur='this.value=this.value.trim();'></td>
								</tr>
								
							</table>
							<!-- : ( Week ) (E) --></td>
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
								<tr>
									<td>
									<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- : ( Grid : Week ) (E) -->
							
							<!-- 3만불 이하  Approval Step 지정 -->
							<div id="btng_apro_step" style="visibility:hidden;">	
							
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr><td width="10%" class="sm" align="left">
									<input type="radio" name="ofc_tp" class="trans" Onclick="ofcChange();">Cost Office&nbsp;&nbsp;&nbsp;
									<input type="radio" name="ofc_tp" class="trans" checked Onclick="ofcChange();">&nbsp;Log-in Office
								</td></tr>
							</table>						
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="94">Approval Step</td>
									<td><input name="apro_step" type="text" style="width:853" value="<%//=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, "TES") %>" readonly> <img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='btng_search'></td>
								</tr>
							</table>
							</div>
							<!-- 3만불 이하  Approval Step 지정 -->
							
							<!-- : ( Button : Sub ) (S) -->
							<table class="button" border="0" width="100%">
								<tr>
									<td class="btn2_bg" class="align">
									<div id='btng_csrcancel_yn' style="display:inline">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<!--  2014.09.29 김영신 [CHM-201432136] Files, Edit Approval Step, View Approval Step 버튼 제거 
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_files" id="btng_files">Files</td>
												<td class="btn2_right"></td></tr></table>
												</td>-->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_print" id="btng_print">Print</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<!-- 
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_editapprovalstep" id="btng_editapprovalstep">Edit Approval Step</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												-->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_viewapprovalstep" id="btng_viewapprovalstep">View Approval Step</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_agreement" id="btng_agreement">AGMT Files</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_csrformat" id="btng_csrformat">CSR Format</td>
												<td class="btn2_right"></td></tr></table>
												</td>												
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_invoicelistinquiry" id="btng_invoicelistinquiry">Invoice List Inquiry</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_approvalrequest" id="btng_approvalrequest">Approval Request</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_csrcancel" id="btng_csrcancel">CSR Cancel</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<!-- Repeat Pattern -->
											</tr>
										</table>
									</div>
									<div id='btng_csrcancel_yn' style="display:none">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<!-- Repeat Pattern -->
												<!-- <!--  2014.09.29 김영신 [CHM-201432136] Files, Edit Approval Step, View Approval Step 버튼 제거 
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_files" id="btng_files">Files</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												-->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_print" id="btng_print">Print</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<!-- 
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_editapprovalstep" id="btng_editapprovalstep">Edit Approval Step</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												-->
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_viewapprovalstep" id="btng_viewapprovalstep">View Approval Step</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_agreement" id="btng_agreement">AGMT Link</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_csrformat" id="btng_csrformat">CSR Format</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_invoicelistinquiry" id="btng_invoicelistinquiry">Invoice List Inquiry</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td><td class="btn2" name="btng_approvalrequest" id="btng_approvalrequest">Approval Request</td>
												<td class="btn2_right"></td></tr></table>
												</td>
												<!-- Repeat Pattern -->
											</tr>
										</table>
									</div>
									</td>
								</tr>
							</table>
							
							
							
							<!-- : ( Button : Sub ) (E) --></td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
</td></tr>
</table>
<!-- Outer Table (E)-->


</form>

</body>

</html>


<DIV style="display:none;">
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
