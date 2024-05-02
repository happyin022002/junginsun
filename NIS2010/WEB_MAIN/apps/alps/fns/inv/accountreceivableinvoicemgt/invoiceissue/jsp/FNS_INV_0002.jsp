<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0002.jsp
*@FileTitle : (China) Tax Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0002Event)request.getAttribute("Event");
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
<title>(China) Tax Invoice Inquiry</title>
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
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="ofc_cd">
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
					<td width="70">Option</td>
					<td width="270"><select name="tax_inv_cxl_flg" style="width:70;" class="input1">&nbsp;
						<option value="" selected>All</option>
						<option value="N">Issue</option>						
						<option value="Y">Cancel</option></td> 
					<td width="100">B/L No.</td>   <!-- YITA29099202 -->
					<td width="260"><input type="text" name="bl_src_no" style="width:100" style="ime-mode:disabled" dataformat="uppernum" maxlength="12"></td>
					<td width="40">Office</td>   
					<td>
						<!-- <select style="width:70;"class="input1">&nbsp;
						<option value="0" selected>SHABB</option>
						<option value="1"></option>-->
						<script language="javascript">ComComboObject('ofc_cd2', 1, 100, 1);</script>
					</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Issue Date</td>   
					<td width="270"><input type="text" name="iss_dt_start" style="width:75" class="input1" dataformat="ymd" maxlength="10" size="10" cofield="iss_dt_end" caption="start date">
									<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
									&nbsp;~&nbsp;
									<input type="text" name="iss_dt_end" style="width:75" class="input1" dataformat="ymd" maxlength="10" size="10" cofield="iss_dt_start" caption ="end date">
									<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="100">Tax Invoice No.</td>   
					<td><input type="text" name="tax_inv_no_start" style="width:85"  dataformat="uppernum" maxlength="8">&nbsp;~&nbsp;<input type="text" name="tax_inv_no_end" style="width:85"  dataformat="uppernum" maxlength="8"></td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Customer</td>   
					<td width="110"><input type="text" name="act_cust_cnt_cd" style="width:25" class="input" style="ime-mode:disabled" dataformat="engup" maxlength="2"  onKeyup="moveNext('act_cust_cnt_cd','act_cust_seq',2);">&nbsp;<input type="text" name="act_cust_seq" style="width:55" class="input" style="ime-mode:disabled" dataformat="num" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust1"></td>
					<td><input type="text" name="cust_lgl_eng_nm" style="width:600" class="input2" readonly></td>
				</tr>
				<tr class="h23">
					<td width="70"></td>   
					<td width="110"></td>
					<td><input type="text" name="cust_locl_lang_nm" style="width:600" class="input2" readonly></td>
				</tr>
				</table>
				
			<table class="line_bluedot"><tr><td></td></tr></table>
			
			
			<!-- Grid (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet');</script>
							</td>
						</tr>
					</table> 			
			<!-- Grid (E) -->
			
				
				
				
			
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
		
    <!--Button (E) -->
	</td></tr>
</table>

</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>