<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0032.jsp
*@FileTitle : Invoice Report by No Good & Not Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.04 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0032Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
		
		event = (FnsInv0032Event)request.getAttribute("Event");
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
<title>Invoice Report by No Good & Not Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
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

<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="office">
<input type="hidden" name="user_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="hd_ofc_cd">

<input type="hidden" name ="date_option" value="I">
<input type="hidden" name ="select_option" value="A">
<input type="hidden" name ="rev_tp_cd" value="">
<input type="hidden" name ="io_bnd_cd" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> 
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> 
		</table> 
		<!--Page Title, Historical (E)--> 
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       	<tr>
       		<td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:60%;"> 
				<tr class="h23">
					<td width="110" style="padding-left:5;">Office</td>
					<td colspan="3">
					<script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 0);</script>
					</td></tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:60%;"> 
				<tr class="h23">
					<td width="107" rowspan="3" style="padding-left:5;">Date Option</td>
					<td width="110" class="stm"><input name="date_option_si" type="radio" class="trans" checked>&nbsp;I/F Date</td>
					<td rowspan="2">
						<input type="text" name="from_date" required dataformat="ymd" maxlength="8" style="width:85" class="input1" cofield="to_date" caption="start date">&nbsp;
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"> ~ 
						<input type="text" name="to_date" required dataformat="ymd" maxlength="8" style="width:85" class="input1" cofield="from_date" caption="end date">&nbsp;
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
					</td></tr>
				<tr class="h23">					
					<td class="stm"><input name="date_option_sa" type="radio" class="trans">&nbsp;S/A Date</td></tr>
				<tr class="h23">					
					<td class="stm"><input name="date_option_sd" type="radio" class="trans">&nbsp;Sailing Date</td></tr>
				</table>		
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table border="0" style="width:65%;" class="search_sm"> 
				<tr class="h23">
					<td width="100" rowspan="2">Select Option</td>
					<td width="100" class="stm">
						<input name="select_option_ng" type="radio" class="trans" checked>&nbsp;No Good&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td class="stm">
						<input name="select_option_ni" type="radio" class="trans">&nbsp;Not issued Invoice
					</td>
				</tr>
				<tr class="h23">
					<td class="stm">
						<input name="select_option_rc" type="radio" class="trans">&nbsp;Rep Cust.&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td class="stm">
						<input name="select_option_nv" type="radio" class="trans">&nbsp;No VVD Ex. Rate
					</td>
				</tr>
				</table>
				<table class="height_8"><tr><td></td></tr></table>
				
				<table border="0" style="width:65%;" class="search_sm"> 
				<tr class="h23">
					<td width="100">Rev Type</td>
					<td class="stm">
						<input name="if_type_bl" type="radio" value="" class="trans">&nbsp;B/L&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="if_type_ca" type="radio" value="" class="trans">&nbsp;C/A&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="if_type_mri" type="radio" value="" class="trans">&nbsp;MRI&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="if_type_all" type="radio" value="" class="trans" checked>&nbsp;ALL
					</td></tr>
				</table>
				<table class="height_8"><tr><td></td></tr></table>
				
				<table border="0" style="width:65%;" class="search_sm"> 
				<tr class="h23">
					<td width="100">Bound</td>
					<td class="stm">
						<input name="bound_ib" type="radio" class="trans">&nbsp;I/B&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="bound_ob" type="radio" class="trans">&nbsp;O/B&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="bound_all" type="radio" class="trans" checked>&nbsp;ALL</td></tr>
				</table>
								
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search" border="0" style="width:60%;"> 
				<tr class="h23">
					<td width="100" style="padding-left:8;">Port</td>
					<td>&nbsp;<input type="text" name="port" required style="width:110" class="input" maxlength="5" minlength="5" value="" dataformat="engup">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_port"></td></tr>
				</table>
				<!--  biz_1   (E) -->
			
		</td></tr></table>

		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
<tr>
	<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right">
				</tr></table></td>
			<td class="btn1_line"></td>		
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
		</tr>
		</table>
	</td>
</tr>
</table>
<!--Button (E) -->

<div style="display:none">
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>