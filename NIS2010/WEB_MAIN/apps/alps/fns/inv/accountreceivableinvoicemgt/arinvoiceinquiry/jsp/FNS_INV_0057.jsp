<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0057.jsp
*@FileTitle : Invoice Not Issued Inquiry by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.23 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0057Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0057Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

		event = (FnsInv0057Event)request.getAttribute("Event");
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
<title>Invoice Not Issued Inquiry by Customer</title>
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
					<td width="450"><input name="act_cust_cnt_cd" type="text" style="width:30;" value="" class="input1" maxlength="2" dataformat="engup">&nbsp;<input name="act_cust_seq" type="text" style="width:69;" value="" class="input1" maxlength="6" dataformat="num">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust1">&nbsp;<input name="cust_nm" type="text" style="width:260;" class="input2" value="" readOnly="true">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust2"></td>
					<td width="70" align="">Over Due</td>   
					<td width="200"><input name="from_over_due" type="text" style="width:70;text-align:right" value="-999" class="input1" maxlength="6" dataformat="int">&nbsp;~&nbsp;<input name="to_over_due" type="text" style="width:70;text-align:right" value="999" class="input1" maxlength="6" dataformat="int"></td>
					<td width="60" align="">Office</td>   
					<td><script language="javascript">ComComboObject('ar_ofc_cd', 2, 80, 0);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80" align="">CRDT Limit&nbsp;</td>
					<td width="140"><input name="cr_amt" type="text" style="width:125;text-align:right" value="" class="input2" readOnly="true"></td>
					<td width="70" align="right">O/B Term&nbsp;</td>   
					<td width="60"><input name="ob_cr_term_dys" type="text" style="width:50;text-align:right" value="" class="input2" readOnly="true"></td>
					<td width="70" align="right">I/B Term&nbsp;</td>   
					<td width="110"><input name="ib_cr_term_dys" type="text" style="width:50;text-align:right" value="" class="input2" readOnly="true"></td>
					<td width="70" align="">As of Date</td>   
					<td width="200"><input type="text" name="as_of_date" dataformat="ymd" maxlength="8" style="width:80" class="input1">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					<td width="60" align="">Option</td>   
					<td><script language="javascript">ComComboObject('amount_option', 2, 80, 1);</script></td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid (S) -->
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>			
				<!-- Grid (E) -->
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
					<td class="btn1" name="btn_retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table></td>
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