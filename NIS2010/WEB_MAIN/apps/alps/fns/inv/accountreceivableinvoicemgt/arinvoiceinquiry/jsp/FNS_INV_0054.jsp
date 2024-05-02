<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0054.jsp
*@FileTitle : Invoice Inquiry by Issue Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.01 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0054Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

		event = (FnsInv0054Event)request.getAttribute("Event");
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
<title>Invoice Inquiry by Issue Date</title>
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
<input type="hidden" name="user_cnt_cd" value="<%=strCnt_cd %>">
<input type="hidden" name="office">
<input type="hidden" name="svr_id">
<input type="hidden" name="dp_prcs_knt_local" value="0">
<input type="hidden" name="dp_prcs_knt" value="0">
<input type="hidden" name="ttl_locl_amt" value="0">
<input type="hidden" name="tax_inv_flg" value="N">
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
		<table class="search" id="mainTable"> 
		<tr>
			<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="85" align="">Issue Date</td>
					<td width="290"><input name="iss_fm_dt" dataformat="ymd" required maxlength="8" type="text" style="width:87" class="input" value="" cofield="iss_to_dt" caption="start date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;<input name="iss_to_dt" dataformat="ymd" required maxlength="8" type="text" style="width:85" class="input" value="" cofield="iss_fm_dt" caption="end date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="48" align="">B/L No.</td>
					<td width="130"><input name="bl_src_no" type="text" class="input" style="width:120;" maxlength="15" value="" dataformat="engup"></td>
					<td width="80" align="">Invoice No.</td>
					<td width="130"><input name="inv_no" type="text" class="input" style="width:120;" maxlength="15" value="" dataformat="engup"></td>
					<td width="60" align="">Office</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 75, 0);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="85" align="">Actual Cust.</td>
					<td width="468"><input name="cust_cnt_cd" type="text" style="width:28" class="input" value="" maxlength="2" dataformat="engup">&nbsp;<input name="cust_seq" type="text" style="width:55" maxlength="6" class="input" value="" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust1">&nbsp;<input name="cust_nm" type="text" style="width:298" class="input2" value="" maxlength="50">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_cust2"></td>
					<td width="80" align="">Rev. Type</td>
					<td width="130" style="padding-left:2;"><script language="javascript">ComComboObject('rev_type', 1, 80, 1);</script></td>
					<td width="58" align="">VVD</td>
					<td><input name="vvd" type="text" class="input" style="width:75;" value="" maxlength="9" minlength="9" dataformat="engup"></td>						
				</tr> 
				</table>				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<!--td width="93" align="">Incl. Sys Clear</td>
					<td width="79" style="padding-left:2;"><script language="javascript">ComComboObject('inv_clr_flg', 1, 60, 0);</script></td-->
					<td width="85" align="">Scope</td>
					<td width="140"><input name="scope" type="text" class="input" style="width:38;" value="" maxlength="3" minlength="3" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_SCP"></td>
					<td width="30" align="">Port</td>
					<td width="120"><input name="port" type="text" style="width:50" class="input" maxlength="5" minlength="5" value="" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_port"></td>
					<td width="48" align="">Bound</td>
					<td width="128" style="padding-left:2;"><script language="javascript">ComComboObject('bound', 1, 60, 0);</script></td>
					<td width="80" align="">Issue Office</td>
					<td width="130"><input name="iss_ofc_cd" type="text" style="width:80" class="input" maxlength="6" value="" dataformat="engup"></td>
					<td width="59" align="">User ID</td>
					<td><input name="usr_id" type="text" style="width:75" class="input" maxlength="20" value="" dataformat="eng"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!-- Grid  (S) -->
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
		<!--biz page (E)--> 
	</td>
</tr>
</table>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
<tr>
	<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td id="tax_inv_sum" style="display:none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_tax_inv">TAX INV Summary</td>
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
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
		</tr>
		</table>
	</td>
</tr>
</table>
<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>