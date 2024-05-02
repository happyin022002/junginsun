<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0020.jsp
*@FileTitle : AR CSR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.08.06 박희동
* 1.0 Creation
* -------------------------------------------------------------------------------
* History
* 2012.02.28 조병연 [CHM-20121640001][ALPS JOO] Account Month가 Closing된 후 Save 및 Delete 기능 비활성화 
* - Account Month가 Closing된 이후에는 Data 생성 및 삭제 기능들이 비활성화되도록 Logic 추가
* - 현재 AP Closing Time을 기준으로 하는것을 AR Closing Time으로 변경 (쿼리 변경)
* - Save, Delete 버튼 비활성화
=========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>

<%
	FnsJoo0020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String yyyyMM   = "";//JSPUtil.getKST("yyyy-MM");
	String yyyyMMdd = "";//JSPUtil.getKST("yyyy-MM-dd");
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");

	String crrCombo   = "";
	String cost_ofc_cd = "";
	String inv_sub_sys_cd = "JOO";
	
	SignOnUserAccount account=null;
	String csrGwUrl = "";	

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		cost_ofc_cd = account.getOfc_cd();


		event = (FnsJoo0020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		crrCombo   = eventResponse.getETCData("jo_crr_cd");
		yyyyMMdd   = eventResponse.getETCData("localDate");
		yyyyMMdd   = yyyyMMdd.substring(0,4)+"-"+yyyyMMdd.substring(4,6)+"-"+yyyyMMdd.substring(6,8);
		yyyyMM     = yyyyMMdd.substring(0,7);

		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>AR CSR Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gOfcCd       = "<%=cost_ofc_cd%>";
var gCrrCombo    = "<%=crrCombo%>";
var gYYYYMM      = "<%=yyyyMM%>";
var gYYYYMMDD    = "<%=yyyyMMdd%>";

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
<input type="hidden" name="ibflag">
<input type="hidden" name="pagerows">
<input type="hidden" name="code">
<input type="hidden" name="name">
<input type="hidden" name="super_cd1">
<input type="hidden" name="super_cd2">
<input type="hidden" name="re_divr_cd" value="R">
<input type="hidden" name="ar_ap_div_cd" value="R">
<input type="hidden" name="slp_tp_cd" value="18">
<input type="hidden" name="slp_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="slp_func_cd" value="T">
<input type="hidden" name="issuer_id" value="<%=strUsr_id%>">
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle" value="Transfer Slip">
<input type="hidden"   name="com_mrdBodyTitle" value="Transfer Slip">
<input type="hidden"   name="com_mrdSaveDialogFileExt" value="ppt">
<input type="hidden"   name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt">
<input type="hidden"   name="com_mrdSaveDialogFileName" value="Transfer Slip">
<input type="hidden"   name="com_mrdSaveDialogDir" value="">
<!-- 2010.01.27 Approval Step -->
<input type="hidden"   name="aproSeqKey">
<!-- GW Contract Link -->
<input type="hidden" name="csr_gw_url" value="<%=csrGwUrl%>">
<input type="hidden" name="agmt_doc_no" >
<input type="hidden" name="apro_flg" >
<input type="hidden" name="cxl_flg" >


<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
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
					<td width="100">Account Month</td>
					<td width="150"><input type="text" style="width:60" class="input1" name="acct_yrmon" value="<%=yyyyMM%>" dataformat="ym" maxlength=6>&nbsp;<img class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle" name="btns_back">&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle" name="btns_next"></td>
					<td width="40">Carrier</td>
					<td width="90"><script language="javascript">ComComboObject('jo_crr_cd',1,55,0,1);</script></td>
					<td width="88">Combined No.</td>
					<td width="110"><script language="javascript">ComComboObject('stl_cmb_seq',2,55,0,1);</script></td>
					<td width="55">CSR No.</td>
					<td width=""><input type="text" style="width:194" class="input2" name="csr_no"></td>
					</tr> 
				</table>
				
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="160">Customer Code</td>
					<td width="169"><input type="text" style="width:30" class="input2" name="cust_vndr_cnt_cd" readOnly>&nbsp;<input type="text" style="width:90" class="input2" name="cust_vndr_seq" readOnly></td>
					<td width="150">Customer Name(Local)</td>
					<td width=""><input type="text" style="width:348" class="input2" name="cust_vndr_kor_nm" readOnly></td>
					</tr> 
				<tr class="h23">
					<td width="">Business Registration No.</td>
					<td width=""><input type="text" style="width:124" class="input2" name="cust_vndr_rgst_no" dataformat="saupja" readOnly></td>
					<td width="">Customer Name(English)</td>
					<td width=""><input type="text" style="width:348" class="input2" name="cust_vndr_eng_nm" readOnly></td>
					</tr> 
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="160">Issue Team</td>
					<td width="169"><input type="text" style="width:124;text-align:center" class="input2" name="slp_iss_ofc_cd" value="<%=account.getOfc_cd()%>" readOnly></td>
					<td width="79">Issue Date</td>
					<td width="170"><input type="text" style="width:75;text-align:center" class="input2" name="slp_iss_dt" value="<%=yyyyMMdd%>" dataformat="ymd" maxlength="8" readOnly>&nbsp;<!-- <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_iss">--></td>
					<td width="61">Issuer</td>
					<td width="" colspan="3"><input type="text" style="width:188;text-align:left" class="input2" name="issuer_nm" value="<%=strUsr_nm%>" readOnly></td>
					</tr> 
				<tr class="h23">
					<td width="160">Description</td>
					<td width="" colspan="8"><input type="text" style="width:667" class="input1" name="csr_desc" maxlength="50"></td>
					</tr> 
				<tr class="h23">
					<td width="">Currency</td>
					<td width=""><input type="text" style="width:124;text-align:center" class="input2" name="locl_curr_cd" readOnly></td>
					<td width="">Amount</td>
					<td width=""><input type="text" style="width:124;text-align:right" class="input2" name="stl_locl_amt" readOnly dataformat="float"></td>
					<td width="">Eff. Date</td>
					<td width="150"><input type="text" style="width:90;text-align:center" class="input1" name="eff_dt" dataformat="ymd" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_eff"></td>
					<td width="">DUE Date</td>
					<td width=""><input type="text" style="width:90;text-align:center" class="input1" name="rqst_dt" dataformat="ymd" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_rqst"></td>
					</tr> 
				<tr class="h23">
					<td width="160">Approval Step</td>
					<td width="" colspan="7"><input type="text" style="width:690" class="input2" name="apro_step" readOnly value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(cost_ofc_cd, inv_sub_sys_cd) %>" >&nbsp;<img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name='apro_step_btn'>
					</td>
					</tr> 
				</table>
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
 
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
<!-- 		    
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
 -->				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save" auth="S">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>				
				<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_attach">Attachment</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_gwcl">GW Contract Link</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>																	
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<table class="search" border="0" style="width:665;" style="display:none"> 
<tr class="h23">
    <td><!-- Grid  (S) -->
   <script language="javascript">ComSheetObject('sheet2');</script>
<!-- Grid (E) -->
</td>
</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>