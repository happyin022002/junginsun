<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0032.jsp
*@FileTitle : Sublet Revenue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.24 최우석
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0032Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	//int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strOfc_nm		= "";
	String cost_ofc_cd      = "";
	String inv_sub_sys_cd   = "FMS";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strOfc_nm = account.getOfc_eng_nm();
		cost_ofc_cd = account.getOfc_cd();

		event = (EsmFms0032Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Sublet Revenue</title>
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
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="slp_tp_cd" value="20">
<input type="hidden" name="slp_func_cd" value="T">
<input type="hidden" name="slp_iss_dt">
<input type="hidden" name="rqst_amt">
<input type="hidden" name="csr_type" value="AR">
<input type="hidden" name="tot_hire_amt">
<input type="hidden" name="tot_bnk_amt">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle" value="Sublet Revenue">
<input type="hidden"   name="com_mrdBodyTitle" value="Sublet Revenue">

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
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">CSR Master</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="85">Vessel Code</td>
						<td width="240">
							<input type="text" name="vsl_cd" style="width:54;text-align:center;ime-mode:disabled" class="input1" maxlength="4" required fullfill caption="Vessel Code">&nbsp;<img src="img/btns_search.gif" name="btn_vslCd" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand">&nbsp;<input type="text" name="vsl_eng_nm" style="width:140;" class="input2" readonly>
						</td>
						<td width="90">Contract Type</td>
						<td width="170">&nbsp;<script language="javascript">ComComboObject('flet_ctrt_tp_cd', 1, 86, 1);</script></td>
						<td width="90">Contract No.</td>
						<td width="170"><input type="text" name="flet_ctrt_no" style="width:120;text-align:center;" class="input2" value="" required caption="Contract No." readonly>&nbsp;<img src="img/btns_search.gif" name="btn_fletCtrtNo" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand"></td>
						<!-- <td width="105"><input type="text" name="flet_ctrt_tp_nm" style="width:70;" class="input2" value="" caption="Contract Type" readonly></td> -->
						<td width="65">Currency</td>   
						<td><input type="text" name="csr_curr_cd" maxlength="3" style="width:40;text-align:center;ime-mode:disabled" class="input1" value="USD" maxlength="3" required fullfill caption="Currency"></td></tr>
					<tr class="h23">
						<td>&nbsp;&nbsp;Requested By</td>
						<td><input type="text" name="slp_ofc_cd" value="<%=strOfc_cd%>" style="width:60;text-align:center;" class="input2" value="" caption="Requested By" readonly></td> 
						<td>Provided By</td>
						<td><input type="text" name="prov_by" value="<%=strUsr_nm%>" style="width:150;text-align:center;" class="input2" value="" caption="Provided By" readonly></td> 
						<td>CSR No.</td>
						<td colspan="3"><input type="text" name="csr_no" style="width:160;" class="input2" value="" caption="CSR No." readonly></td></tr>
					<tr class="h23">
						<td>&nbsp;&nbsp;Description</td>
						<td colspan="7"><input type="text" name="csr_desc" style="width:506;" class="input2" value="" caption="Description" readonly></td></tr>
					<tr class="h23">
						<td>&nbsp;&nbsp;VVD</td>
						<td><input type="text" style="width:100;text-align:center;ime-mode:disabled" name="vvd_cd" class="input1" maxlength="10" value="" required fullfill caption="VVD"></td>
						<td>Eff Date</td>
						<td colspan="7"><input type="text" name="eff_dt" maxlength="8" dataformat="ymd" required fullfill caption="Eff Date" style="width:70;ime-mode:disabled;" class="input1" value="">&nbsp;<img src="img/btns_calendar.gif" name="btn_effDt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
					<tr class="h23">
						<td width="90">&nbsp;&nbsp;Owner Code</td>
						<td width="600" colspan="10">
							<input type="text" style="width:30;text-align:center;" class="input2" name="ownr_cd" required caption="Owner Code" readonly>
							<input type="text" style="width:66;text-align:center;" class="input2" name="ownr_seq" required caption="Owner Code" readonly>
							<input type="text" style="width:401;" class="input2" name="ownr_nm" required caption="Owner Code" readonly>
						</td>
                    </tr> 
					<tr class="h23">
					<td width="160">&nbsp;&nbsp;Approval Step</td>
					<td width="" colspan="7"><input type="text" style="width:690" class="input2" name="apro_step" readOnly value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd) %>" >&nbsp;<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='apro_step_btn'>
					</td>
					</tr> 
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!--  biz_2  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Slip Detail</td></tr>
				</table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable" > 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
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
							<td class="btn2" name="btn_hire">Hire&nbsp;Revenue </td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_bodBor">BOD/BOR </td>
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
						<td width="610"></td>
						<td width="90">Total Amount</td>
						<td width="160"><input type="text" style="width:30;" class="tr_head3" value=" DR" readonly>&nbsp;<input type="text" name="dr_amt" style="width:100;text-align:right;" class="tr_head3" value="0" readonly></td>
						<td ><input type="text" style="width:30;" class="tr_head3" value=" CR" readonly>&nbsp;<input type="text" name="cr_amt" style="width:100;text-align:right;" class="tr_head3" value="0" readonly></td>
					</tr>
				</table>
				
			<!--  biz_2   (E) -->
			</td></tr>
		</table>
	</td></tr>
</table>
<!--biz page (E)-->
	
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	<tr>
		<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr id="btnSave" style="display:''"><td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr id="btnHire" style="display:''"><td class="btn1_left"></td>
						<td class="btn1" name="btn_hire">Hire&nbsp;Revenue</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td-->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_slip">Slip&nbsp;Inquiry</td>
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
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_print">Print</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (E) -->

<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>