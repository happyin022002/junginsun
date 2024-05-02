<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0066.jsp
*@FileTitle : Invoice Summary Inquiry by Date & Source
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.29 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0066Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0066Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
		
		event = (FnsInv0066Event)request.getAttribute("Event");
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
<title>Invoice Summary Inquiry by Date & Source</title>
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
<input type="hidden" name="office">
<input type="hidden" name="dp_prcs_knt" value="0">
<input type="hidden" name="ar_curr_cd" value="">

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
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="85">Date&nbsp;</td>
					<td width="110"><select name="date_option" style="width:100;" class="input">
						<option value="G" selected>Good Date</option>
						<option value="I">I/F Date</option>
						<option value="E">Eff. Date</option>
						<option value="S">Issue Date</option>
						<option value="A">S/A Date</option>
						</select></td>
					<td width="412"><input type="text" name="from_date" dataformat="ymd" required maxlength="8" style="width:85" class="input1" cofield="to_date" caption="start date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" name="to_date" dataformat="ymd" required maxlength="8" style="width:85" class="input1" cofield="from_date" caption="end date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="80">Issue Option</td>  
					<td width="120"><select name="issue_flag" style="width:90;" class="input">
						<option value="" selected>All</option>
						<option value="Y">Issued</option>
						<option value="N">Not-Issued</option>
						</select></td>
					<td width="80">Office</td>  
					<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 90, 0, 1, 0, 1);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="85">VVD&nbsp;</td>
					<td width="210"><input name="vvd" type="text" style="width:98;" class="input" maxlength="9" minlength="9" value="" dataformat="engup"></td>
					<td width="35">Port</td>  
					<td width="117"><input name="port" type="text" style="width:62;" class="input" maxlength="5" minlength="5" value="" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_port"></td>  
					<td width="45">Scope</td>  
					<td width="115"><input name="scope" type="text" style="width:50;" class="input" maxlength="3" minlength="3" value="" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_SCP"></td> 
					<td width="80">Bound</td>  
					<td width="120"><select name="bound" style="width:90;" class="input">
						<option value="" selected>All</option>
						<option value="O">O/B</option>
						<option value="I">I/B</option>
						</select></td>
					<td width="80">CHG Code</td>  
					<td width=""><script language="javascript">ComComboObject('chg_cd', 1, 90, 0, 0, 0, 1);</script></td> 
				</tr>
				</table>
					
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="85">Actual Cust.</td>
					<td width="522"><input name="act_cust_cnt_cd" type="text" style="width:30;" value="" class="input" maxlength="2" dataformat="engup">&nbsp;-&nbsp;<input name="act_cust_seq" type="text" style="width:65;" value="" class="input" maxlength="6" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust1">&nbsp;<input name="cust_nm" type="text" style="width:321;" value="" class="input2" value="" readonly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust2"></td>
					<td width="80">Rev Type</td>  
					<td width="120"><select name="rev_tp_cd" style="width:90;" class="input" OnChange="javascript:doChange(this);">
						<option value="" selected>All</option>
						<option value="B">B/L</option>
						<option value="C">C/A</option>
						<option value="M">MRI</option>
						</select></td> 
					<td width="80">Rev Source</td>  
					<td width=""><script language="javascript">ComComboObject('rev_src_cd', 1, 90, 1, 0);</script></td> 
				</tr>
				</table>
				<!-- biz_1 (E) -->
				<table class="height_8"><tr><td></td></tr></table>
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