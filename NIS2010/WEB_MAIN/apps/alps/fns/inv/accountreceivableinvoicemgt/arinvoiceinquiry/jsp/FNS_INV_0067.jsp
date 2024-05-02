<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0067.jsp
*@FileTitle : Invoice Detail Inquiry by Date & Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.07.16 한동훈
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0067Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0067Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

		event = (FnsInv0067Event)request.getAttribute("Event");
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
<title>Invoice Detail Inquiry by Date & Charge</title>
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
<input type="hidden" name="office">
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="user_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="login_rhq_cd">
<input type="hidden" name="locl_chg_ofc">
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
					<td width="85">Date&nbsp;</td>
					<td width="110">
						<!-- <input type="radio" name="dateOption" value="G" class="trans" checked>&nbsp;Good Date&nbsp;&nbsp;<input type="radio" name="dateOption" value="S" class="trans">&nbsp;Issue Date-->
						<select name="date_option" style="width:100;" class="input1" OnChange="javascript:dateChange(this);">
							<option value="G" selected>Good Date</option>
							<option value="I">I/F Date</option>	
							<option value="E">Eff. Date</option>						
							<option value="S">Issue Date</option>
							<option value="A">S/A Date</option>		
							<option value="R">POR ETD Date</option>							
						</select>
					</td>
					<td width="432"><input type="text" name="from_date" style="width:75" class="input1" dataformat="ymd" maxlength="10" size="10" cofield="to_date" caption="start date">
									<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">
									&nbsp;~&nbsp;
									<input type="text" name="to_date" style="width:75" class="input1" dataformat="ymd" maxlength="10" size="10" cofield="from_date" caption="end date">
									<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td width="80">Issue Option</td>  
					<td width="100"><select name="issue_flag" style="width:80;" class="input">
						<option value="" selected>ALL</option>
						<option value="Y">Issued</option>
						<option value="N">Not-Issued</option>
						</select></td>
					<td width="80">Office</td>  
					<td width="">
						<!-- 
						<select style="width:100;" class="input1">
						<option value="0" selected>HAMBB</option>
						<option value="1"></option>
						</select>
						<script language="javascript">ComComboObject('office2', 1, 60, 0, 1, 0, 1);</script>						
						-->
						<script language="javascript">ComComboObject('office2', 1, 100, 1);</script>												
					</td></tr>						
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">VVD</td>
					<td width="105">
						<input type="text" name="vvd" style="width:90" class="input" style="ime-mode:disabled" dataformat="uppernum" maxlength="9">											
					</td>
					<td width="41">Port</td>  
					<td width="100">						
						<input name="port" type="text" style="width:60;" class="input" maxlength="5" minlength="5" style="ime-mode:disabled" dataformat="uppernum">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_port">
					</td>  
					<td width="45">Scope</td>  
					<td width="100">
						<!-- <select name="scope" style="width:60;" class="input">
						<option value="" selected>ALL</option>
						<option value="1"></option>
						<option value="2"></option>
						<option value="3"></option>
						</select>
						-->
						<input name="scope" type="text" style="width:60;" class="input" maxlength="3" minlength="3" style="ime-mode:disabled" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_SCP">
					</td> 
					<td width="45">Bound</td>  
					<td width="100"><select name="bound" style="width:70;" class="input">
						<option value="" selected>ALL</option>
						<option value="O">O/B</option>
						<option value="I">I/B</option>
						</select></td>
					<td width="80">Local Charge</td>  
					<td width="100">
						<input type="checkbox" value="Y" class="trans" name="lcl_chg" style="" onclick="javascript:chkLclChg();">
					</td> 	
					<td width="80">CHG Code</td>  
					<td width="">
						<!-- 
						<select style="width:100;" class="input">
						<option value="0" selected>ALL</option>
						<option value="1"></option>
						<option value="2"></option>
						<option value="3"></option>
						</select>
						-->
						<script language="javascript">ComComboObject('chg_cd', 1, 100, 0, 0, 0, 1);</script>
					</td> 
					</tr>
					</table>
					
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
					<td width="85">Actual Cust.</td>
					<td width="542"><input type="text" name="act_cust_cnt_cd" style="width:30" class="input" style="ime-mode:disabled" dataformat="engup" maxlength="2">
									<input type="text" name="act_cust_seq" style="width:65" class="input" dataformat="num" maxlength="6">
									<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust1">
									<input type="text" name="cust_nm" style="width:321" class="input2" readonly>
									<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust2"></td>
					<td width="80">Rev Type</td>  
					<td width="100"><select name="rev_tp_cd" style="width:80;" class="input" OnChange="javascript:doChange(this);">
						<option value="" selected>ALL</option>
						<option value="B">B/L</option>
						<option value="C">C/A</option>
						<option value="M">MRI</option>
						</select></td> 
					<td width="80">Rev Source</td>  
					<td width="">
						<script language="javascript">ComComboObject('rev_src_cd', 1, 100, 0, 0);</script>
						<!-- <select name="rev_src_cd" style="width:80;" class="input">
						<option value="" selected>ALL</option>
						</select>-->
					</td> 
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
			<div style="display:none">
			<table class="height_8"><tr><td></td></tr></table>
			<!-- Grid (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			</div>
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
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table></td></tr>
</table>
		
    <!--Button (E) -->
	

</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>