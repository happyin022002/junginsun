<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0045.jsp
*@FileTitle : Sublet Revenue Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.25
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.24 최우석
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0045Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	//int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmFms0045Event)request.getAttribute("Event");
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
<title>Sublet Revenue Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="hanjin/rpt/script/rdviewer50.js"></script>
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

<input type="hidden" name="to_inv_no">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
			<tr><td class="btn1_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    		<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
					</tr>
				</table>
			</td></tr>
		</table>
		<!--Button (E) -->

		<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Slip Inquiry Head</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="">
							<table class="search_sm2" border="0" style="width:330;"> 
								<tr class="">
									<td width="84"><strong>&nbsp;Condition</strong></td>
									<td width="" class="noinput1"><input type="radio" name="btn_condition" value="" class="trans" checked>Vessel &nbsp;&nbsp;&nbsp;<input type="radio" name="btn_condition" value="" class="trans">VVD&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_condition" value="" class="trans">Invoice No. </td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">&nbsp;&nbsp;Vessel Code</td>
						<td width="270"><input type="text" name="vsl_cd" style="width:54;text-align:center;ime-mode:disabled" class="input" maxlength="4" required fullfill caption="Vessel Code">&nbsp;<img src="img/btns_search.gif" name="btn_vslCd" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand">&nbsp;<input type="text" name="vsl_eng_nm" style="width:140;" class="input2" readonly></td>
						<td width="90">Contract Type</td>
						<td width="200">&nbsp;&nbsp;<script language="javascript">ComComboObject('flet_ctrt_tp_cd', 1, 86, 1);</script></td>
						<td width="80">Contract No.</td>
						<td width=""><input type="text" name="flet_ctrt_no" style="width:120;text-align:center;" class="input2" value="" required caption="Contract No." readonly>&nbsp;<img src="img/btns_search.gif" name="btn_fletCtrtNo" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand"></td>
						<!-- <td width=""><input type="text" name="flet_ctrt_tp_nm" style="width:70;" class="input2" value="" caption="Contract Type" readonly></td> -->
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">&nbsp;&nbsp;VVD </td>
						<td width="270"><input type="text" style="width:100;text-align:center;ime-mode:disabled" name="vvd_cd" class="input" maxlength="10" value="" required fullfill caption="VVD"></td>
						<td width="80">Invoice No.</td>
						<td width=""><input type="text" name="to_inv_no1" style="width:100;text-align:center;ime-mode:disabled" maxlength="12" class="input" value="" required fullfill caption="Invoice No."></td>
					</tr>
				</table>
				
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Inquiry Result List</td></tr>
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

				<!--  biz_2  (S) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Sublet Revenue Detail Inquiry</td></tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				<table class="height_5"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td align="right">Total Amount&nbsp;<input type="text" name="curr_cd" style="width:50;text-align:center;" class="tr_head3" value="" readonly>&nbsp;<input type="text" name="csr_amt" style="width:100;text-align:right;" class="tr_head3" value="" readonly></td>
					</tr>
				</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<!--biz page (E)-->

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr><td class="btn1_bg">
    	<table border="0" cellpadding="0" cellspacing="0">
    		<tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
		</table>
	</td></tr>
</table>
<!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>