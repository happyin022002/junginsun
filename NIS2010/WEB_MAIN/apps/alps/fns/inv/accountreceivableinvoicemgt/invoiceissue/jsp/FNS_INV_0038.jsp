<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0038.jsp
*@FileTitle : (N.China) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0038Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0038Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (FnsInv0038Event)request.getAttribute("Event");
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
<title>(N.China) Invoice Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="print_nm">
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
					<td width="60">&nbsp;&nbsp;B/L No.</td>   
					<td width="210"><input name="blNo" type="text" style="width:100;" class="input1" style="ime-mode:disabled" dataformat="uppernum" maxlength="12"></td>
					<td width="40">Office</td>   
					<td>
						<!-- <select style="width:105;"class="input1">&nbsp;
						<option value="0" selected>SHAAS</option>
						<option value="1"></option>
						-->
						<script language="javascript">ComComboObject('ofc_cd2', 1, 100, 1);</script>
					</td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="700">
						<table class="search_sm2" border="0" style="width:416;">
							<tr class="h23">
								<td width="150"> Invoice Currency</td>
								<td width="80" class="stm"> <input name="curCd" type="radio" value="USD" class="trans" onClick="fnCurrency();" checked>USD </td>
								<td width="80" class="stm"> <input name="curCd" type="radio" value="CNY" class="trans" onClick="fnCurrency();">CNY </td>
								<td width="" class="stm"> <input name="curCd" type="radio" value="ALL" class="trans" onClick="fnCurrency();">USD/CNY </td>
							</tr>
						</table>
					
					</td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<!--grid   (S)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!--grid   (E)-->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="70">Invoice No.</td>
						<td width="280"><input type="text" name="inv_start_no" style="width:90;" readonly class="input2">&nbsp;-&nbsp;<input type="text" name="inv_end_no" style="width:90;" readonly class="input2"></td>
						<td width="160"> Total Invoice Count</td>
						<td width=""><input name="tot_count" type="text" style="width:90; text-align:right;" readonly class="input2"></td>
					</tr>
					<!-- 
					<tr class="h23">
						<td width=""></td>
						<td width=""></td>
						<td width=""> Number of copy invoice</td>
						<td width=""><input type="text" style="width:50;" value=" 1" class="input2"></td>
					</tr>
					-->
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
		    	<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_PaperIssue">Paper&nbsp;Issue</td>
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
<!------- Print용 Hidden RD Object Start -------->
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>