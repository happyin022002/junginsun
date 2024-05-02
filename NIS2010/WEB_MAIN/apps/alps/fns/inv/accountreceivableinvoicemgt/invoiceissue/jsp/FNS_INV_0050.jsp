<%
/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : FNS_INV_0050.jsp
 * @FileTitle : Customer Preferable Report
 * Open Issues :
 * Change history : 2012.04.10 [CHM-201217107-01] Customer Preferable Report 내 아이템 추가 요청.
 * @LastModifyDate : 2012.04.10
 * @LastModifier : 김상현
 * @LastVersion : 1.0
 * 2009.08.18 한동훈
 * 1.0 Creation
 */
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0050Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0050Event  event = null;         // PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;    // 서버에서 발생한 에러
	String strErrMsg = "";                 // 에러메세지
	int rowCount = 0;                      // DB ResultSet 리스트의 건수

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


		event = (FnsInv0050Event)request.getAttribute("Event");
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
<title>Customer Preferable Report</title>
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
<input type="hidden" name="cntr_no_yn">
<input type="hidden" name="chg_cd_yn">
<input type="hidden" name="save_yn">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="cTmplItem">
<input type="hidden" name="bl_no">
<input type="hidden" name="bl_nos">
<input type="hidden" name="bkg_no">
<input type="hidden" name="rect_top">
<input type="hidden" name="rect_left">
<input type="hidden" name="sheet_bl_no_row_chk">
<input type="hidden" name="tmplt_ofc_cd" value="">
<input type="hidden" name="select_tmplt" value="">
<input type="hidden" name="change_tmplt" value="N">			
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
						<td width="95">Template Name</td>   
						<td width="330">
							<script language="javascript">ComComboObject('rpt_tmplt_nm', 2, 200, 1, 1, 0, true);</script>
						</td>
						<td width="100">Payment Term</td> 
						<td width="">&nbsp;<select name="frt_term_cd" style="width:80;" class="input">
						<option value="A" >All</option>
						<option value="P" >PrePaid</option>
						<option value="C" selected>Collect</option>
						</select>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
					<td width="65">S/C No.</td>   <!-- AEN20931 US039061 CN 046444 S--> <!-- AEN21823 HJNA0069E-->
					<td width="160">&nbsp;<input type="text" name="sc_no" value ="" style="width:80;" class="input" dataformat="uppernum" maxlength="9" onChange="sc_no_OnChange()"></td>
					
					<td width="70">RFA No.</td>  
					<td width="130">&nbsp;<input type="text" name="rfa_no" value ="" style="width:90;" class="input" dataformat="uppernum" maxlength="11" onChange="rfa_no_OnChange()"></td> 
					<td width="70">Customer</td>   
					<td width="">&nbsp;<select name="cust_gb" style="width:110;" class="input">
						<!-- option value="" selected></option>-->
						<option value="S">Shipper</option>
						<option value="C">Consignee</option>
						<option value="N">Notify</option>
						<option value="GS">Group Cust - Shpr</option>
						<option value="GC">Group Cust - Cnee</option>
						</select>&nbsp;<input type="text" name="cust_cnt_cd" style="width:30;" class="input" style="ime-mode:disabled" dataformat="engup" maxlength="2" onKeyup="moveNext('cust_cnt_cd','cust_seq',2);">&nbsp;<input type="text" name="cust_seq" style="width:55;" class="input" style="ime-mode:disabled" dataformat="num" maxlength="6">&nbsp;<input type="text" name="cust_lgl_eng_nm" style="width:250;" class="input2">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust2"></td>
					</tr>
				</table>	
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
					<td width="65">Date</td>   
					<td width="160">&nbsp;<select name="date_gb" style="width:121;" class="input">
					    <option value="1STVVD" >First POL ETD</option>
						<option value="OBD" selected>Onboard Date</option>
						<option value="ETD">T.VVD - POL - ETD</option>
						<option value="ETA">T.VVD - POD - ETA</option>
						<option value="PCD">Port Close Date</option>
						<option value="BDR">BDR</option>
						<!-- <option value="DEL">DEL - ETA</option> 불필요한 값 삭제 처리. by Sang-Hyun Kim 2012.04.10 -->
						</select></td>
					<td width="70">From</td>   
					<td width="130">
						&nbsp;<input type="text" name="from_date" style="width:90;" class="input" dataformat="ymd" maxlength="10" caption="start date" cofield="to_date">&nbsp;
								<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_from_dt">
					</td>
					<td width="30">To</td>   
					<td width="">
						<input type="text" name="to_date" style="width:90;" class="input" dataformat="ymd" maxlength="10" caption="end date">&nbsp;
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_to_dt"></td>
					</tr>
				</table>	
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
					<td width="65">Trunk VVD</td>   
					<td width="160">&nbsp;<input type="text" name="vvd" style="width:120;" class="input" style="ime-mode:disabled" dataformat="uppernum" maxlength="9"></td>
					<td width="70">POR/POL</td>  
					<td width="253">&nbsp;<input type="text" name="por_cd" style="width:90;" class="input" style="ime-mode:disabled" dataformat="uppernum" maxlength="5">
					/ <input type="text" name="pol_cd" style="width:90;" class="input" style="ime-mode:disabled" dataformat="uppernum" maxlength="5"></td>   
					<td width="60">POD/DEL</td>  
					<td width="">&nbsp;<input type="text" name="pod_cd" style="width:90;" class="input" style="ime-mode:disabled" dataformat="uppernum" maxlength="5">
					/ <input type="text" name="del_cd" style="width:90;" class="input" style="ime-mode:disabled" dataformat="uppernum" maxlength="5"></td>    
					</tr>
				</table>	
				<table class="search" border="0" style="width:979;" id="mainTable1">
					<tr class="h23">
					<td width="65">BKG Office</td>   
					<td width="160">&nbsp;<input type="text" name="bkg_ofc_cd" style="width:120;" class="input" style="ime-mode:disabled" dataformat="engup" maxlength="6"></td>
					<td width="70">Sales Office</td>  
					<td width="">&nbsp;<input type="text" name="ob_sls_ofc_cd" style="width:90;" class="input" style="ime-mode:disabled" dataformat="engup" maxlength="6"></td>  
			 	
                    <td width="55" >B/L No.</td>
                    <td width="" colspan="3" valign="top">
                    
                     <table class="search" border="0">
                                <tr class="h23">
                                  <td valign="top" id="td_bl_no" width="123">
                                    <div id="bl_input" style="display:block"> 
                                      <input type="text" name="input_bl_no" style="width:121;" class="input1" value="" maxlength="12" dataformat="uppernum"  >
                                    </div>
                                    <div id="bl_sheet" style="display:none;width:123px;height:150px;position:absolute;left:0px;top:0px;">
                                      <script language="javascript">ComSheetObject('sheet3');</script>
                                    </div>
                                 </td>
                                 <td style="width:2"></td>
                                  <td width=""><table width="115" border="0" cellpadding="0" cellspacing="0" class="button">
                                		<tr><td class="btn2_left"></td>
                               				 <td class="btn2" id="btn_input_bl_no" name="btn_input_bl_no" >Multi B/L No.</td>
                               				 <td class="btn2_right"></td>
                                		</tr></table>
                                	</td>
                                 </tr>
                      </table>
                    
                    </td>					
					 	
					</tr>
				</table>	
				<!-- biz_1  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
				<!-- Grid  (S) -->	
					
					
		</td></tr>
		</table>
		
	

			</td></tr>
		</table>
	
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
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_report">View Last Report</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_template">Create Template</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_preview">B/L Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="search">
					<tr><td style="padding-left:7">Report ID&nbsp;<input type="text" name="cust_rpt_id" style="width:120;" class="input2"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>

<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>