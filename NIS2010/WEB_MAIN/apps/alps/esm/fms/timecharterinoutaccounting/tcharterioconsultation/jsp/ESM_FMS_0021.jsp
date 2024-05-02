<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0021.jsp
*@FileTitle : Payments Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.20 정윤태
* 1.0 Creation 

* 2012.05.29 전상화 [CHM-CHM-201218108-01] 수정 
* Slip Type에서 'Prepayment Bunker' 추가 
*
  
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String inv_sub_sys_cd = "FMS";
	String cost_ofc_cd      = "";	
	
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		cost_ofc_cd = account.getOfc_cd();
		
		event = (EsmFms0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>

<html>
<head>
<title>Payments Slip</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>


<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="slp_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="csr_type" value="AP">
<input type="hidden" name="ap_ctr_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="chk_acct_cd">
<input type="hidden" name="chk_ctr_cd">
<input type="hidden" name="chk_bunker_vvd">
<input type="hidden" name="pre_work_flag">
<input type="hidden" name="evid_tp_cd_val">
<input type="hidden" name="usd_locl_xch_rt">
<input type="hidden" name="make_tax_yn">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle" value="Payments Slip">
<input type="hidden"   name="com_mrdBodyTitle" value="Payments Slip">

<!-- 2010.01.27 Approval Step 
<input type="hidden"   name="aproSeqKey">
<input type="hidden" name="apro_step" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd) %>">
 -->
 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="90">Vessel Code</td>
					<td width="255"><input type="text" style="width:56;text-align:center;ime-mode:disabled;" class="input1" maxlength="4" name="vsl_cd" required fullfill caption="Vessel Code">&nbsp;<img src="img/btns_search.gif" class="cursor" width="19" height="20" alt="" border="0" name="btn_vslpop" align="absmiddle">&nbsp;<input type="text" style="width:150;" class="input2" name="vsl_eng_nm" readonly></td>
					<td width="90">Contract Type </td>
					<td width="105">&nbsp;<script language="javascript">ComComboObject('flet_ctrt_tp_cd', 1, 86, 1);</script></td>
					<td width="85">Contract No.</td>
					<td width="165"><input type="text" style="width:120;text-align:center;" class="input1" maxlength="15" name="flet_ctrt_no" required fullfill caption="Contract No." readonly>&nbsp;<img src="img/btns_search.gif" class="cursor" name="btn_ctrtpop" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<!-- <td width="80"><input type="text" style="width:56;text-align:center;" class="input2" name="flet_ctrt_tp_cd" readonly></td> -->
					<td width="60">Currency</td>
					<td width=""><input type="text" style="width:56;text-align:center;ime-mode:disabled;" class="input1" name="csr_curr_cd" value="USD" maxlength="3" dataformat="engup" required fullfill caption="Currency"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="90">Office</td>
					<td width="85"><input type="text" style="width:55;text-align:center;" class="input2" value="<%=strOfc_cd%>" readonly></td>
					<td width="60">CSR Date</td>
					<td width="110"><input type="text" style="width:80;text-align:center;" class="input2" name="slp_iss_dt" readonly></td>
					<td width="78">Provided By </td>
					<td width="197"><input type="text" style="width:150;text-align:center;" class="input2" name="usr_nm" value="<%=strUsr_nm%>" readonly></td>
					<td width="90">CSR No.</td>
					<td width=""><input type="text" style="width:196;text-align:center;" name="csr_no" class="input2" readonly></td>
				</tr>
				</table>
				
<!--  Editor 2012.05.29  : Start  -->					
				<table class="search" border="0" style="width:979;"> 
			 	
<!--  1st Row : Start  -->				
				<tr class="h23">
					<td width="90">Description</td>
					<td width="523" colspan="5">
							<input type="text" style="width:483;" class="input1" maxlength="100" 							name="slp_desc" caption="Description">
					</td>
					<td width="366" rowspan="2">
						<table class="search_sm2" border="0" style="width:295;"> 
							<tr class="">
								<td width="92"><strong>&nbsp;Slip Type</strong></td>
								<td class="noinput1">
								   <input type="radio" value="P" class="trans" name="slp_tp" checked>Prepayment&nbsp;&nbsp;&nbsp;
								   <input type="radio" value="S" class="trans" name="slp_tp">Standard
								  
								   <div>
								   <input type="radio" value="P" class="trans" name="slp_tp">Prepayment without Hire
								   </div>
								   
								   <div>
								   <input type="radio" value="P" class="trans" name="slp_tp">Prepayment Bunker
								   </div>
								   
								   </td>
							</tr>
						</table>
					</td>
				</tr>
<!--  1st Row : End  -->	

<!--  2nd Row : Start  -->
		<tr class="h23">
					
					<td width="90">Evidence Type </td>
					<td width="80" style="padding-left:2"><select style="width:78;" class="input1" name="evid_tp_cd" onchange="setButton(this.value);">
						</select></td>
					<td width="80">Request Date</td>
					<td width="110"><input type="text" style="width:80;text-align:center;" class="input1" name="rqst_dt" maxlength="8" dataformat="ymd" required fullfill caption="Request Date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="rqst_dt_cal" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="85">G/L Date</td>
					<td width="110"><input type="text" style="width:80;text-align:center;" class="input1" name="eff_dt" maxlength="8" dataformat="ymd" required fullfill caption="Effective Date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="eff_dt_cal" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>				
<!--  2nd Row : End  -->	
				
				</table>
				
<!--  Editor 2012.05.29  : End  -->					
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="90">Owner Code</td>
					<td width="531"><input type="text" style="width:78;text-align:center;" class="input2" name="ownr_cd" readonly>&nbsp;<input type="text" style="width:400;" class="input2" name="ownr_nm" readonly></td>
					<td width="89">Hire No.</td>
					<td width="86"><input type="text" style="width:80;text-align:center;" class="input2" name="ppay_hir_no" readonly></td>
					<td><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td></td>
						<td></td>
						<td></td>
						</tr>
						</table></td>
					<!-- td><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_totalCal">Total Cal</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td-->
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="90">Approval Step</td>
					<td width="" colspan="6"><input type="text" style="width:690" class="input2" name="apro_step" readOnly value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd) %>" >&nbsp;<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='apro_step_btn'>
					</td>
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable" style="display:none;"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable" style="display:none;"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable" style="display:none;"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable" style="display:none;"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet5');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
               <!-- Grid  (S) -->
					<table width="100%" id="mainTable" style="display:none;"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet6');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
				
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_prepayments">Prepayments</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_charterersExp">Acct Management</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_offhireExp">Offhire Exp</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_ownersAccount">Owner's Account </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_bodBor">BOD/BOR </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowIns">Row Ins</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td-->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowDel">Row Del</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) width:979; 886 -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:982;"> 
				<tr class="h23">
					<td width="580"></td>
					<td width="100">Total Amount</td>
					<td width="160"><input type="text" style="width:50;text-align:center;" class="tr_head3" value="DR" readonly>&nbsp;<input type="text" style="width:100;text-align:right;" class="tr_head3" name="dr_amt" value="0.00" readonly></td>
					<td ><input type="text" style="width:50;text-align:center;" class="tr_head3" value="Diff" readonly>&nbsp;<input type="text" style="width:100;text-align:right;" class="tr_head3" name="diff_amt" value="0.00" readonly></td>
				</tr>
				<tr class="h23">
					<td width="590"></td>
					<td width="90"> </td>
					<td width="160"></td>
					<td ><input type="text" style="width:50;text-align:center;" class="tr_head3" value="Balance" readonly>&nbsp;<input type="text" style="width:100;text-align:right;" class="tr_head3" name="balance_amt" value="0.00" readonly></td>
				</tr>
				</table>
					
				</td></tr>
			</table>
	
	<!--biz page (E)-->

    
    <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_preview">Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_hireStatement">Hire Statement</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_taxEvidence">Tax Evidence</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_slipInquiry">Slip Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

</td></tr>
</table>

<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

</form>
</body>
</html>
