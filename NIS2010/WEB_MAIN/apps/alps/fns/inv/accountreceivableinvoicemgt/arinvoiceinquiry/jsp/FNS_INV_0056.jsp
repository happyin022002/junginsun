<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0056.jsp
*@FileTitle : Invoice Not Issued Aging Inquiry by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.27 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0056Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (FnsInv0056Event)request.getAttribute("Event");
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
<title>Invoice Not Issued Aging Inquiry by Customer</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="user_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="dp_prcs_knt" value="0">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> 
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> 
		</table> 
		<!--Page Title, Historical (E)-->
					
		<!--biz page (S)-->
		<table class="search"> 
       	<tr>
       		<td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80" align="">Actual Cust.&nbsp;</td>
					<td width="460"><input name="act_cust_cnt_cd" type="text" style="width:30;" value="" class="input1" maxlength="2" dataformat="engup">&nbsp;<input name="act_cust_seq" type="text" style="width:60;" value="" class="input1" maxlength="6" dataformat="num">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust1">&nbsp;<input name="cust_nm" type="text" style="width:290;" class="input2" value="" readOnly="true">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust2"></td>
					<td width="90" align="">CRDT OFC&nbsp;</td>   
					<td width="125"><input name="cr_clt_ofc_cd" type="text" style="width:83" value="" class="input2" readOnly="true"></td>
					<td width="70" align="">Office&nbsp;</td>   
					<td style="padding-left:2;"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 80, 0);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80" align="">CRDT Limit&nbsp;</td>
					<td width="150"><input name="cr_amt" type="text" style="width:120;text-align:right" value="" class="input2" readOnly="true"></td>
					<td width="70" align="">O/B Term&nbsp;</td>   
					<td width="80"><input name="ob_cr_term_dys" type="text" style="width:50;text-align:right" value="" class="input2" readOnly="true"></td>
					<td width="60" align="">I/B Term&nbsp;</td>   
					<td width="100"><input name="ib_cr_term_dys" type="text" style="width:50;text-align:right" value="" class="input2" readOnly="true"></td>
					<td width="90" align="">Scope&nbsp;</td>   
					<td width="125"><input name="svc_scp_cd" type="text" style="width:60;" class="input" maxlength="3" minlength="3" value="" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_SCP"></td>
					<td width="70" align="">Currency&nbsp;</td>   
					<td style="padding-left:2;"><script language="javascript">ComComboObject('curr_flag', 1, 80, 1);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80" align="">Ex. Rate&nbsp;</td>
					<td width="458" style="padding-left:2;"><script language="javascript">ComComboObject('ex_rate_flag', 1, 121, 1);</script></td>
					<td width="90" align="">AMT Option&nbsp;</td>   
					<td width="123" style="padding-left:2;"><script language="javascript">ComComboObject('amt_option', 1, 85, 1);</script></td>
					<td width="70" align="">As of Date&nbsp;</td>   
					<td><input type="text" name="as_of_dt" dataformat="ymd" maxlength="8" style="width:80" class="input1">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				
				<!-- Grid (S) -->
				<table width="100%" class="search"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet');</script>
					</td>
				</tr>
				</table> 			 
				<!-- Grid (E) -->
			
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120"><input name="aging_option" type="checkbox" value="" class="trans">Aging Option</td>
					<td width="" class="stm"><input name="day1" type="text" style="width:30;text-align:right" value="30" class="input2" maxlength="3" dataformat="int" readOnly="true">&nbsp;
						<input name="day2" type="text" style="width:30;text-align:right" value="60" class="input2" maxlength="3" dataformat="int" readOnly="true">&nbsp;
						<input name="day3" type="text" style="width:30;text-align:right" value="90" class="input2" maxlength="3" dataformat="int" readOnly="true">&nbsp;
						<input name="day4" type="text" style="width:30;text-align:right" value="120" class="input2" maxlength="3" dataformat="int" readOnly="true">&nbsp;
						<input name="day5" type="text" style="width:30;text-align:right" value="180" class="input2" maxlength="3" dataformat="int" readOnly="true"></td>
				</tr>
				</table>
			
			</td>
		</tr>
		</table>
		<!-- Tab BG Box(E) -->
		<!--biz page (E)-->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrive">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
			</td>
			</tr>
			</table>
    	<!--Button (E) -->
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>