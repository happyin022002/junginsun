<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0093.jsp
*@FileTitle : Slip Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.27
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2015.07.27 이영두
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0093Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0093Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOConsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0093Event)request.getAttribute("Event");
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
<title>Slip Approval</title>
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

<input type="hidden" name="slip_apro_flg" value="Y">
<input type="hidden" name="vat_slp_tp_cd" value="N">
<input type="hidden" name="flet_ctrt_tp_cd">
<input type="hidden" name="save_csr_no">
<input type="hidden" name="slip_type">
<input type="hidden" name="inter_co_cd">
<input type="hidden" name="ar_inter_co_cd">
<input type="hidden" name="lst_apro_flg">
<input type="hidden" name="apro_rqst_no">
<input type="hidden" name="apro_rqst_seq">
<input type="hidden" name="apro_dt">
<input type="hidden" name="csr_type">
<input type="hidden" name="screen_gubun" value="SlipApproval">		<!-- Slip Inquiry,  Slip Approval 화면을 구분, 민정호(2014.07)-->
<!-- Report Designer 에 필요한 Input Box -->
<input type="hidden"   name="com_mrdPath" value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle" value="Slip Approval">
<input type="hidden"   name="com_mrdBodyTitle" value="Slip Approval">


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
					<td class="title_s">Slip Approval Head</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="343">
					<table class="search_sm2" border="0" style="width:270;"> 
							<tr class="h23">
								<td width="84">&nbsp;Date</td>
								<td width="" class="noinput1"><input type="radio" value="E" class="trans" name="condition" checked>G/L Date &nbsp;&nbsp;&nbsp;<input type="radio" value="C" name="condition" class="trans">CSR Date </td>
							</tr>
						</table>
					</td>
					<td width=""> </td>
					<td width=""><input value="" type="text" style="width:80;text-align:center;" class="input1" name="from_eff_dt" fullfill maxlength="8" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="from_ef_dt" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input value="" type="text" style="width:80;text-align:center;" class="input1" name="to_eff_dt" maxlength="8" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="to_ef_dt" width="19" height="20" border="0" align="absmiddle"></td>
					
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Vessel Code</td>
					<td width="260"><input type="text" style="width:56;text-align:center;" class="input" maxlength="4" name="vsl_cd" style="ime-mode:disabled" fullfill caption="Vessel Code">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vslpop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:150;" class="input2" name="vsl_eng_nm" readonly></td>
					<td width="59">CSR No.</td>
					<td width=""><input value="" type="text" style="width:;" class="input" name="csr_no" maxlength="22" style="ime-mode:disabled"></td>
				    <td width="90">P-Settlement</td>
					<td width=""><input type="checkbox" value="Y" name="pchk" id="pchk" class="trans"></td>
				
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				 <!--  biz_1   (E) -->
				<!--  biz_2  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s"> Slip Inquiry - Detail</td></tr>
				</table>
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
				
			<table class="search" border="0" style="width:983;"> 
				<tr class="h23">
					<td width="590"></td>
					<td width="90">Total Amount</td>
					<td width="160"><input type="text" style="width:50;text-align:center;" class="tr_head3" value="DR" readonly>&nbsp;<input type="text" style="width:100;text-align:right;" class="tr_head3" name="dr_amt" readonly></td>
					<td ><input type="text" style="width:50;text-align:center;" class="tr_head3" name="diff" readonly>&nbsp;<input type="text" style="width:100;text-align:right;" class="tr_head3" name="cr_amt" readonly></td>
				</tr>
				<tr class="h23">
					<td width="590"></td>
					<td width="90"> </td>
					<td width="160"></td>
					<td id="balanceAmt" style="display:none;"><input type="text" style="width:50;text-align:center;" class="tr_head3" value="Balance" readonly>&nbsp;<input type="text" style="width:100;text-align:right;" class="tr_head3" name="balance_amt" readonly></td>
				</tr>
				</table>	
				
				<!--  biz_2  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s"> Approval Waiting List</td></tr>
				</table>
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 				
				
			</td></tr> 
			</table>
				<table class="height_5"><tr><td></td></tr></table>
				
			
							
	</td></tr>
			</table>
	<!--biz page (E)-->
	
				


		<!-- Grid (E) -->
	          <table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width=""> 
						<table class="search_sm2" border="0" style="width:;"> 
							<tr class="h23">
								<td width="80">Approval</td>
								<td width="100" class="noinput1"><input type="radio" class="noinput1" name="apro_flg" value="Y">Yes &nbsp;&nbsp;&nbsp;<input type="radio" class="noinput1" name="apro_flg" value="N" checked>No </td>
							    
							    <td width="50"></td>
							    <td width="100">Cancel Remark</td>
					            <td width=""><input type="text" style="width:370;" maxlength="100" class="input2" name="cxl_desc" caption="Cancel Remark"><input type="hidden" name="slp_no"><input type="hidden" name="vsl_code"><input type="hidden" name="vsl_eng_name"></td>
							</tr>
							
						</table>					
					</td>
					
				</tr>
				</table>
	
	<!--biz page (E)-->
	 
    <!--Button (S) -->
		<table width="0%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
       		 <table border="0" cellpadding="0" cellspacing="0"><tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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

<!-- 개발자 작업  끝 -->
</form>
<form name="form2">
<input type="hidden" name="f_cmd">
<input type="hidden" name="csr_no">

</form>
</body>
</html>