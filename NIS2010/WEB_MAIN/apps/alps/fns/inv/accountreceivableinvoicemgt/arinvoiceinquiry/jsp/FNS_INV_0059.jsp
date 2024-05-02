<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0059.jsp
*@FileTitle : e-mail / Auto FAX Invoice Sent Result
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0059Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0059Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
		
		event = (FnsInv0059Event)request.getAttribute("Event");
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
<title>e-mail / Auto FAX Invoice Sent Result</title>
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
<input type="hidden" name="user_cnt_cd" value="<%=strCnt_cd %>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="svr_id">
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
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Invoice Date</td>

					<td><script language="javascript">ComComboObject('date_type', 1, 105, 1, 1);</script></td> 
					<td width="331" class="stm"><input type="text" name="from_dt" required dataformat="ymd" maxlength="8" style="width:75" class="input" cofield="to_dt" caption="start date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;<input name="to_dt" type="text" required dataformat="ymd" maxlength="8" style="width:75" class="input" cofield="from_dt" caption="end date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="65">User ID</td>
					<td width="135"><input name="cre_usr_id" type="text" style="width:105" value="" class="input" maxlength="20" dataformat="eng"></td>
					<td width="75">User Office</td>   
					<td width="124"><input name="iss_ofc_cd" type="text" style="width:60" value="" class="input" maxlength="5" dataformat="engup"></td>  
					<td width="57">Office</td>   
					<td><script language="javascript">ComComboObject('ar_ofc_cd', 1, 80, 0);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">VVD</td>   
					<td width="130"><input name="vvd" type="text" style="width:105" class="input" maxlength="9" minlength="9" value="" dataformat="engup"></td>					
					<!-- td width="75">User ID</td>
					<td width="130"><input name="cre_usr_id" type="text" style="width:105" value="" class="input" maxlength="20" dataformat="eng"></td-->
					<td width="80">Actual Cust.</td>
					<td width="560"><input name="act_cust_cnt_cd" type="text" style="width:30" value="" class="input" maxlength="2" dataformat="engup">&nbsp;<input name="act_cust_seq" type="text" style="width:55" value="" class="input" maxlength="6" dataformat="num">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust1">&nbsp;<input name="cust_nm" type="text" style="width:338" value="" class="input2" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust2"></td>
					<td width="54">Sent By</td>   
					<td><script language="javascript">ComComboObject('sent_by', 1, 80, 0, 0);</script></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">B/L No.</td>
					<td width="130"><input name="bl_src_no" type="text" style="width:105" class="input" maxlength="12" value="" dataformat="engup"></td>
					<td width="80">Invoice No.</td>
					<td width="187"><input name="inv_no" type="text" style="width:120"  class="input" maxlength="15" value="" dataformat="engup"></td>
					<td width="40">Port</td>
					<td width="151"><input name="port" type="text" style="width:50" class="input" maxlength="5" minlength="5" value="" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_port"></td>
					<td width="75">Scope</td>
					<td width="104"><input name="svc_scp_cd" type="text" style="width:38" class="input" maxlength="3" minlength="3" value="" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_SCP"></td>
					<td width="54">Bound</td>
					<td><script language="javascript">ComComboObject('io_bnd_cd', 1, 80, 1);</script></td>
				</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
			<!-- Grid (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
			<!-- Grid (E) -->
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">E-mail Count</td>
					<td width="80"><input name="eml_cnt" type="text" style="width:50;text-align:right" value="" class="input2"></td>
					<td width="75">Fax Count</td>
					<td width="80"><input name="fax_cnt" type="text" style="width:50;text-align:right" value="" class="input2"></td>
					<td width="90">Paper Count</td>
					<td width="80"><input name="paper_cnt" type="text" style="width:50;text-align:right" value="" class="input2"></td>
					<td width="90">Total Count</td>
					<td width="80"><input name="ttl_cnt" type="text" style="width:50;text-align:right" value="" class="input2"></td>
					<td width="80">Sent Count</td>
					<td width="80"><input name="snd_cnt" type="text" style="width:50;text-align:right" value="" class="input2"></td>
					<td width="100">Sent Ratio(%)</td>   
					<td><input name="snd_rt" type="text" style="width:50;text-align:right" value="" class="input2"></td></tr>
				</table>
			</td></tr>
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
	</td></tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>