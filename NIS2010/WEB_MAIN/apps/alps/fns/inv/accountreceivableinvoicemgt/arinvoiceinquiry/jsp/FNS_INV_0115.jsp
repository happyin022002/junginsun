<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName   : fns_inv_0115.jsp
*@FileTitle  : ERP IF Error Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.13
*@LastModifier : 김현화
*@LastVersion : 1.0
* 2010.12.13 김현화
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0115Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0115Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
		
		event = (FnsInv0115Event)request.getAttribute("Event");
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
<title>Invoice Inquiry by Good Date</title>
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
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="user_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="office">
<input type="hidden" name="dp_prcs_knt_local" value="0">
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
		<table class="search" id="mainTable"> 
		<tr>
			<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="80" align="">Date</td>
					<td width="0"><select name="date_option" style="width:90;" class="input1" >
								<option value="C" selected>Good Date</option>
								<option value="I">I/F Date</option>
								<option value="G">G/L Date</option>
								</select>
								<input type="text" name="from_date" required dataformat="ymd" maxlength="8" style="width:85" class="input1" cofield="to_date" caption="start date">
								<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;
								<input type="text" name="to_date" required dataformat="ymd" maxlength="8" style="width:85" class="input1" cofield="from_date" caption="end date">
								<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
								<input type="text" name="date_blank" maxlength="8" style="width:0" class="input" readOnly value="blank"></td>
					
					<td width="70">I/F Status</td>
					<td width="110"><select name="if_flag" style="width:90;" class="input1">
								<option value="" selected>ALL</option>
								<option value="N">No</option>
								<option value="E">Error</option>
								</select></td>
					<td width="65">RHQ&nbsp;</td>
					<td width="120"><script language="javascript">ComComboObject('ar_hd_qtr_ofc_cd', 1, 100, 0, 1);</script></td>
					<td width="60" align="">Office&nbsp;</td>
					<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 0, 1);</script></td>
					
				</tr> 
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				    <td width="80" align="">Interface No</td>
					<td width="130"><input name="if_no" type="text" style="width:90;" class="input" maxlength="11"  value="" dataformat="engup"></td>
				    <td width="50" align="">B/L No</td>
					<td width="130"><input name="bl_no" type="text" style="width:90;" class="input" maxlength="20"  value="" dataformat="engup"></td>
				    <td width="70" align="">Invoice No</td>
					<td width="173"><input name="inv_no" type="text" style="width:90;" class="input" maxlength="20" value="" dataformat="engup"></td>
					<td width="62" align="">Rev Type</td>
					<td width="109"><select name="rev_tp_cd" style="width:100;" class="input" OnChange="javascript:doChange(this);">
						<option value="" selected>ALL</option>
						<option value="B">B/L</option>
						<option value="C">C/A</option>
						<option value="M">MRI</option>
						</select></td>
				   <td width="73">Rev Source&nbsp;</td>  
					<td width=""><script language="javascript">ComComboObject('rev_src_cd', 1, 100, 0, 0);</script></td>	 
				</tr>
				</table>
				
				<!--  biz_2   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
				<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable1" style="display:block"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			 

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
    	<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
			<td class="btn1" name="btn_downExcel">Down Excel</td>
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