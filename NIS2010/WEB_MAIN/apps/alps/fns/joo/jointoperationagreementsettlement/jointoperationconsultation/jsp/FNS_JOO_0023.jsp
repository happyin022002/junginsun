<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0023.jsp
*@FileTitle : CSR Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.11 박희동
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event.FnsJoo0023Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>

<%
	FnsJoo0023Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");
	
	String csrNo = "";
	String editable = "N";
	String sysdate = JSPUtil.getKST("yyyyMMddHHmmss");
	String ofcCd = "";
	String csrGwUrl = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofcCd     = account.getOfc_cd();

		event = (FnsJoo0023Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		csrNo      = request.getParameter("csrNo")      == null ? ""  : StringUtil.xssFilter(request.getParameter("csrNo"));
		editable   = request.getParameter("editable")   == null ? "N" : StringUtil.xssFilter(request.getParameter("editable"));

		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");		
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CSR Approval</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="ibflag">
<input type="hidden" name="pagerows">
<input type="hidden" name="apro_dt">
<input type="hidden" name="sysdate" value="<%=sysdate%>">
<input type="hidden" name="old_apro_dt">
<input type="hidden" name="evid_tp_cd">
<input type="hidden" name="ofc_cd" value="<%=ofcCd%>">
<input type="hidden" name="apro_rqst_no">
<!-- 2010.01.27 Approval Step -->
<input type="hidden"   name="aproSeqKey">
<input type="hidden"   name="apro_step">

<!-- 2010.03.16 BackEndJob을 위한 Field -->
<input type="hidden" name="key">

<!-- GW Contract Link -->
<input type="hidden" name="csr_gw_url" value="<%=csrGwUrl%>">
<input type="hidden" name="agmt_doc_no" >	

<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CSR Approval Main</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="118">CSR No.</td>
					<td width="200"><input type="text" style="width:160" class="input2" name="csr_no" value="<%=csrNo%>" readOnly></td>
					<td width="80">&nbsp;</td>
					<td width="">&nbsp;</td>
				</tr> 
				</table>
			
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
				
			<table class="height_10"><tr><td></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" > 
				<tr class="h23">
					<td width="118">&nbsp;Issue Type</td>
					<td width=""><input type="text" style="width:160" class="input2" value="JOO TRANSFER SLIP" readOnly></td>
					</tr> 
				</table>
				<table class="search" border="0" > 
				<tr class="h23">
					<td width="118">&nbsp;Issue Team</td>
					<td width=""><input type="text" style="width:80" class="input2" name="slp_team_cd" readOnly></td>
					<td width="70">Issue Date</td>
					<td width=""><input type="text" style="width:80;text-align:center" class="input2" name="slp_iss_dt" dataformat="ymd" readOnly>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_iss"></td>
					<td width="70">Req. Date</td>
					<td width=""><input type="text" style="width:80;text-align:center" class="input2" name="rqst_dt" dataformat="ymd" readOnly>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_rqt"></td>
					<td width="60">Eff. Date</td>
					<td width=""><input type="text" style="width:80;text-align:center" class="input2" name="eff_dt" dataformat="ymd" readOnly>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal_eff"></td>
					<td width="40">Issuer</td>
					<td width=""><input type="text" style="width:110" class="input2" name="issuer" readOnly></td>
					</tr> 
				<tr class="h23">
					<td width="">&nbsp;Description</td>
					<td width="" colspan="9"><input type="text" style="width:799" class="input2" name="csr_desc" readOnly></td>
					</tr> 
				<tr class="h23">
					<td width="">&nbsp;VNDR/Customer</td>
					<td width="" colspan="9"><input type="text" style="width:100" class="input2" name="vndr_cust_seq" readOnly>&nbsp;<input type="text" style="width:695" class="input2" name="lgl_eng_nm" readOnly></td>
					</tr> 
				<tr class="h23">
					<td width="">&nbsp;CUR</td>
					<td width=""><input type="text" style="width:100" class="input2" name="csr_locl_curr_cd" readOnly></td>
					<td width="">Amount</td>
					<td width="" colspan="7"><input type="text" style="width:100;text-align:right" class="input2" dataformat="float" name="csr_locl_amt" readOnly></td>
					</tr> 

				<tr class="h23">
					<td width="">&nbsp;Evidence Type</td>
					<td width="" class="stm"><input type="text" style="width:100;" class="input2" name="evid_tp_nm" readOnly></td>
					</tr> 
					</table>
			<table class="search" border="0" > 
				<tr class="h23">
					<td width="265" style="padding-bottom:2;">
						<table class="search_sm2" border="0" style="width:310;">
							<tr class="h23">
								<td width="">Approval</td>
								<td class="stm"><input type="radio" value="Y" class="trans" name="apro_flg" checked>&nbsp;Yes&nbsp;&nbsp;&nbsp;<input type="radio" value="N" class="trans" name="apro_flg">&nbsp;No</td>
							</tr>
						</table>
					</td>
					<td width="265" style="padding-bottom:2;">
						<table class="search_sm2" border="0" style="width:250;">
							<tr class="h23">
								<td width="">&nbsp;Cancel</td>
								<td class="stm"><input type="radio" value="Y" class="trans" name="cxl_flg">&nbsp;Yes&nbsp;&nbsp;&nbsp;<input type="radio" value="N" class="trans" name="cxl_flg" checked>&nbsp;No</td>
							</tr>
						</table>
					</td>
					<td width="164"> 					
						<table class="search_sm2" border="0" style="width:250;visibility:hidden">
							<tr class="h23">
								<td width="">&nbsp;URG PAY</td>
								<td class="stm"><input type="radio" value="Y" class="trans" name="urg_pay_flg">&nbsp;Yes&nbsp;&nbsp;&nbsp;<input type="radio" value="N" class="trans" name="urg_pay_flg" checked>&nbsp;No</td>
							</tr>							
						</table>											
					</td>
					</tr></table> 
					<table class="search" border="0" > 
					<tr class="h23">
					<td width="118">&nbsp;Cancel Reason</td>
					<td width="" colspan="7"><input type="text" style="width:799" class="input2" name="cxl_desc" readOnly></td>
					</tr> 
					</table>					
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid  (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
    </td></tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="171" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" style="visibility:hidden">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_apro_step_view" id="btn_apro_step_view" auth="R">View Approval Step</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
<!--
// 중간 결재가 공통에서 삭제해서, 해당 버튼 삭제 				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_apro_step_edit" id="btn_apro_step_edit" auth="C">Edit Approval Step</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
 -->				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save" auth="C">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_evd" id="btn_evd" auth="U">Evidence</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_csr" id="btn_csr" auth="R">CSR Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_attach" id="btn_attach"  auth="C">Attachment</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_gwcl"  id="btn_gwcl"  auth="C">GW Contract Link</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>					
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close" id="btn_close" auth="R">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>					
				</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table></td></tr>
</table>
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
<%@include file="/bizcommon/include/common_nis2010.jsp"%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>