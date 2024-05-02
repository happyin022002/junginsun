<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_CSR_0008.jsp
*@FileTitle : CSR Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.16 함대성
* 1.0 Creation
*----------------------------------------------------------
* History
* 2010.08.31 김영철 [CHM-201005571-01] [VOP-PSO] 공통 CSR내 Invoice 조건 칼럼 추가요청건
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ComCsr0008Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= ""; 
	String cnt_cd 	 		= ""; 
	String inv_sub_sys_cd   = "";
	String usr_eml 			= "";
	String ifStatus			= "";
		
	inv_sub_sys_cd 			= JSPUtil.getParameter(request, "INV_SUB_SYS_CD".trim(), "");
	
	Logger log = Logger.getLogger("com.hanjin.apps.ConsultationSlipRequestMgt.ConsultationSlipRequestMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    ofc_cd	  = account.getOfc_cd();
	    cnt_cd 	  = account.getCnt_cd();
	    usr_eml	  = account.getUsr_eml();
	    
		event = (ComCsr0008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String readonly_yn = null;
	String csr_no = null;
	String inv_no = null;
	readonly_yn = JSPUtil.getParameter(request,"readonly_yn".trim(),"");
	csr_no		= JSPUtil.getParameter(request,"csr_no".trim(),"");
	inv_no		= JSPUtil.getParameter(request,"inv_no".trim(),"");	
	ifStatus	= JSPUtil.getParameter(request, "if_status".trim(), "");	
%>
<html>
<head>
<title>CSR Interface Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="bizcommon/csr/CoCsr.js"></script>

<script language="javascript">
	var cnt_cd = "<%=cnt_cd%>";	
	var readonly_yn = "<%=readonly_yn%>";	
	var ofc_cd = "<%=ofc_cd%>";	
	var cnt_cd = "<%=cnt_cd%>";
	var ifStatus = "<%=ifStatus%>";
	
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
<!-- 개발자 작업	-->
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="csr_no">
<input type="hidden" name="inv_no">
<input type="hidden" name="inv_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="inv_sub_sys_cd" value="<%=inv_sub_sys_cd%>">
<input type="hidden" name="cost_ofc_cd">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="inv_knt">
<input type="hidden" name="curr_cd">   
<input type="hidden" name="total_amt">
<input type="hidden" name="max_iss_dt">
<input type="hidden" name="max_rcv_dt">
<input type="hidden" name="payment_due_dt">
<input type="hidden" name="cost_aproSeqKey">
<input type="hidden" name="login_aproSeqKey">
<input type="hidden" name="aproSeqKey">
<input type="hidden" name="cost_apro_step">
<input type="hidden" name="login_apro_step">
<input type="hidden" name="cre_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="usr_eml" value="<%=usr_eml%>">
<input type="hidden" name="usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="csr_apro_tp_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
<input type="hidden" name="DB_DATE" value=''>
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
				<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="85">Invoice Office</td>
							<td width="70"><input name="ofc_cd" type="text" maxlength=6 style="width:60" class="input2" style="width:72;text-align:center;" value="<%=ofc_cd%>" onKeyUp='csr_isApNum(this); this.value=this.value.toUpperCase();' onKeyDown='csr_chkInput(this); this.value=this.value.toUpperCase();' readonly></td>
							
							<td width="70">Date</td>
							<td width="150">
							<select style="width:144;" name='dt_status'>
								<option value="RA">Requesting Approval</option>
								<option value="AR">Approval Requested</option>
								<option value="AV">Approved or Disapproved</option>
								<option value="IU">I/F Status Updated</option>
							</select>
							</td>
							 
						    <td width="210"><input type="text" style="width:75;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' class="input"  name="fm_eff_dt" value="">&nbsp;~&nbsp;<input type="text" style="width:75;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input" name="to_eff_dt" value="" >&nbsp;<img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					   		</td>

							<td width="70">I/F Status</td>
							<td width="154">
								<select style="width:124;" name='if_status'>
									<option value="AL" selected>All</option>
									<option value="RA">Requesting Approval</option>
									<option value="AR">Approval Requested</option>
									<option value="SD">Sending</option>
									<option value="DA">Disapproved</option>
									<option value="IE">I/F Error</option>
									<option value="RJ">A/P Rejected</option>
									<option value="SC">I/F Success</option>
									<option value="SP">Paid</option>
								</select>
							</td>														
						</tr>
						<tr class="h23">
							<td width="83">Apro Type</td>
							<td width="95">
									<select style="width:60;" name='search_tp_cd'>
										<option value="" selected>All</option>
										<option value="AL">ALPS</option>
										<option value="GW">G/W</option>
									</select>
									</td>
							<td width="70">
							<select style="width:70;" name='if_no'>
								<option value="CSR" selected>CSR No</option>
								<option value="INV">INV No</option>
							</select>
							</td>
						
						    <td width="200" colspan="4"><input name="search_csr_no" type="text" maxlength=20 style="width:100%" value="<%=csr_no%>" onKeyPress='csr_enterCheck("retrieve");' onBlur='this.value=this.value.trim();'></td>
							<!--  biz_1   (E) -->
						</tr>
				</table> 
				<!--
				<table>						
					<tr class="h23">
						<td width="50">CSR No.</td>
						<td width="150"><input name="search_csr_no" type="text" maxlength=20 style="width:100%" value="<%=csr_no%>" onKeyPress='csr_enterCheck("retrieve");' onBlur='this.value=this.value.trim();'></td>
						<td width="55">&nbsp;&nbsp;INV No.</td>
						<td width="150"><input name="search_inv_no" type="text" maxlength=20 style="width:100%" value="<%=inv_no%>" onKeyPress='inv_enterCheck("retrieve");' onBlur='this.value=this.value.trim();'></td>				
					</tr>
				</table>
				-->
		</td></tr>
		</table>
		
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
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
			
			<!-- 3만불 이하  Approval Step 지정 -->
			<div id="btng_apro_step" style="visibility:hidden;">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr><td width="10%" class="sm" align="left">
				<input type="radio" name="ofc_tp" class="trans" Onclick="ofcChange();">Cost Office&nbsp;&nbsp;&nbsp;
				<input type="radio" name="ofc_tp" class="trans" Onclick="ofcChange();" checked>&nbsp;Log-in Office</td>
				</tr>
			</table>
			<table class="search" style="width:979;">
				<tr class="h23">
					<td>Approval Step</td>
					<td><input name="apro_step" type="text" style="width:800" value="<%//=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(ofc_cd, inv_sub_sys_cd) %>"> 
					<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='apro_route_btn'>
					</td>
				</tr>
			</table>		
			</div>
			
			</td></tr>
		</table>
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn1_bg">
				<div id='btng_csrcancel_yn' style="display:inline">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr><!-- files button add 2014.08.07 / remove 2014.09.24 -->
						<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_files">Files</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>-->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_new">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_print">Down&nbsp;Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<!-- 
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_editapprovalstep">Edit&nbsp;Apro&nbsp;Step</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						-->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_viewapprovalstep">Apro Step</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_agreement">AGMT&nbsp;Files</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_csrformat">CSR&nbsp;Format</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_invoicelistinquiry">Inv&nbsp;List</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<!-- approval request button add -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_approvalrequest">Approval&nbsp;Request</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_csrcancel">CSR&nbsp;Cancel</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
					</tr>
				</table>
				</div>
				<div id='btng_csrcancel_yn' style="display:none">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_new">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_print">Down&nbsp;Excel</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<!-- 
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_editapprovalstep">Edit&nbsp;Apro&nbsp;Step</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						-->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_viewapprovalstep">Apro Step</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_agreement">AGMT&nbsp;Files</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_csrformat">CSR&nbsp;Format</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btng_invoicelistinquiry">Invoice&nbsp;List</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
					</tr>
				</table>
				</div>
       	
       		</td></tr>
		</table>
		

		  
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