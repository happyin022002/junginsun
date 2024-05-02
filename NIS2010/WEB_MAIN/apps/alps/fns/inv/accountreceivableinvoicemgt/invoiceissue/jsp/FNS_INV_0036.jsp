<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0036.jsp
*@FileTitle : (Vietnam) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.26 최우석
* 1.0 Creation
-------------------------------------------------------- 
* History
* 2010.07.26 최도순 [CHM-201004735] [ALPS Invoice] SGNBB Invoice type 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0036Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
//	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
//	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceCorrection");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (FnsInv0036Event)request.getAttribute("Event");
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
<title>(Vietnam) Invoice Issue</title>
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
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="pagetype" value="E">
<input type="hidden" name="inv_type">
<input type="hidden" name="bl_nos">
<input type="hidden" name="dt_opt" value="G">
<input type="hidden" name="ar_ofc_cd">
<input type="hidden" name="inv_no_list">
<input type="hidden" name="inv_prn_dvc_nm">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="iss_type" value="SINGLE">
<input type="hidden" name="xch_rt_dt1">
<input type="hidden" name="event_type">
<input type="hidden" name="preview_yn">
<input type="hidden" name="event_ofc">
<input type="hidden" name="vn_inv_pay_mzd_cd">

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
					<td width="685">
						<table class="search_sm2" border="0" style="width:610;">
							<tr class="h23">
								<td width="100"> Invoice Type</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td width="70" class="stm"><input type="radio" name="btn_invType" value="" class="trans" checked>FRT </td>
								<td width="70" class="stm"> <input type="radio" name="btn_invType" value="" class="trans">THC </td>
								<td width="70" class="stm"> <input type="radio" name="btn_invType" value="" class="trans">DHF </td>
								<td width="110" class="stm"> <input type="radio" name="btn_invType" value="" class="trans">DMR/DTC </td>
								<td width="70" class="stm"> <input type="radio" name="btn_invType" value="" class="trans">M&R </td>
								<td width="70" class="stm"> <input type="radio" name="btn_invType" value="" class="trans">MRI </td>
								<td width="70" class="stm"> <input type="radio" name="btn_invType" value="" class="trans">SLF </td>
								<td width="70" class="stm"> <input type="radio" name="btn_invType" value="" class="trans">CLN </td>
								<td width="70" class="stm"> <input type="radio" name="btn_invType" value="" class="trans">REF </td>
								<td width="" class="stm"> <input type="radio" name="btn_invType" value="" class="trans">ETC </td>
							</tr>
						</table>
					
					</td>
					<td width="86">Office</td>   
					<td><script language="javascript">ComComboObject('combo_ar_ofc_cd', 1, 100, 1, 1);</script></td>
				</tr>
			</table>
			<table class="height_2"><tr><td></td></tr></table>

			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="685">
						<table class="search_sm2" border="0" style="width:300;">
							<tr class="h23">
								<td width="100"> Issue By</td>
								<td width="100" class="stm"> <input type="radio" name="btn_issBy" value="" class="trans">Customer </td>
								<td width="" class="stm"> <input type="radio" name=btn_issBy value="" class="trans" checked>B/L No. </td>
								
							</tr>
						</table>
					
					</td>
					<td width="85" align="left">Bound</td>
					<td><select style="width:50;"class="input1" name="io_bnd_cd">&nbsp;
						<option value="" selected>All</option>
						<option value="O">O/B</option>
						<option value="I">I/B</option></td>
				</tr>
			</table>
			<table class="height_2"><tr><td></td></tr></table>
				
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="330">
						<table class="search_sm2" border="0" style="width:300;">
							<tr class="h23">
								<td width="100"> Date Option</td>
								<td width="100" class="stm"><input type="radio" name="btn_dtOpt" value="" class="trans" checked>Good </td>
								<td width="" class="stm"> <input type="radio" name="btn_dtOpt" value="" class="trans">S/A Date </td>
							</tr>
						</table>
					
					</td>
					<td width="35">From</td>   
					<td width="155"><input type="text" name="from_dt" style="width:80;text-align:center;" class="input1" value="" maxlength="8" dataformat="ymd" required fullfill cofield="to_dt" caption="start date">&nbsp;<img src="img/btns_calendar.gif" name="btn_fromDt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="20">To</td>  
					<td width="160"><input type="text" name="to_dt" style="width:80;text-align:center;" class="input1" value="" maxlength="8" dataformat="ymd" required fullfill cofield="from_dt" caption="end date">&nbsp;<img src="img/btns_calendar.gif" name="btn_toDt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="90">Ex.Rate Date</td>  
					<td width=""><input type="text" name="xch_rt_dt" style="width:80;text-align:center;" class="input1" value="" maxlength="8" dataformat="ymd" required fullfill caption="Ex.Rate Date">&nbsp;<img src="img/btns_calendar.gif" name="btn_xchRtDt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="50">&nbsp;Ex.Rate</td>  
					<td width=""><input type="text" name="xch_rt" style="width:50;text-align:right;" class="input2" value="" caption="Ex.Rate" readonly></td>
				</tr>
			</table>
			<table class="height_2"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="330">
						<table class="search_sm2" border="0" style="width:300;">
							<tr class="h23">
								<td width="100"> Issue Option</td>
								<td width="100" class="stm"><input type="radio" name="btn_issOpt" value="" class="trans" checked>Single </td>
								<td width="" class="stm"><input type="radio" name="btn_issOpt" value="" class="trans">Combined </td>
							</tr>
						</table>
					</td>
					<td>
						<table class="search_sm2" border="0" style="width:600;">
						<tr class="h23">
							<td width="165" align="left">Method of payment</td>
							<td><select style="width:350;"class="input1" name="method_pay">&nbsp;
								<option value="C" selected>Tiền mặt (cash) </option>
								<option value="B">Chuyển khoản (Bank Transfer)</option>
								<option value="A">Tiền mặt (cash)/ Chuyển khoản (Bank Transfer)</option></td>
							</tr>	
						</table>
					</td> 
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Actual Cust.</td>
					<td width="" colspan="7"><input type="text" style="width:30;text-align:center;ime-mode:disabled" class="input1" name="cust_cnt_cd" required fullfill maxlength="2" dataformat="engup">&nbsp;<input type="text" style="width:55;text-align:center;ime-mode:disabled" class="input1" name="cust_seq" maxlength="6" fullfill dataformat="int">&nbsp;<img src="img/btns_search.gif" name="btn_custInfo" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" style="width:360;" class="input2" name="cust_nm" readonly>&nbsp;<input type="text" style="width:100;" class="input2" name="cust_rgst_no" readonly>&nbsp;<img src="img/btns_search.gif" name="btn_custCd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>	
				</tr>
				<tr class="h23">
					<td width="">CRDT Limit</td>
					<td width="200"><input type="text" style="width:40;text-align:center;ime-mode:disabled" class="input2" name="cr_curr_cd" readonly>&nbsp;<input type="text" style="width:100;text-align:right;" class="input2" name="cr_amt" readonly></td>
					<td width="30">Tel.</td>
					<td width="224"><input type="text" style="width:160;" class="input2" name="phn_no" readonly></td>
					<td width="30">Fax</td>
					<td width="225"><input type="text" style="width:160;" class="input2" name="fax_no" readonly></td>
					<td width="30">PIC</td>
					<td width=""><input type="text" style="width:160;" class="input2" name="cntc_pson_nm" readonly></td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80" valign="TOP">&nbsp;B/L No.</td>
					<td width="899">
						<!--grid   (S)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 
						<!--grid   (E)-->
					</td>
				</tr>
			</table>
				
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70"></td>
					<td width="250"></td>
					<td width="280"> Total Invoice Count&nbsp;&nbsp;<input type="text" name="inv_no_cnt" style="width:80;text-align:right;" value=" " class="input2" readonly></td>
					<td width="150"></td>
					<td width=""></td>
				</tr>
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
			    	<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>					
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_paperissue">Issue</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					
				</tr>
				</table>
			</td></tr>
		</table>
		<!--Button (E) -->
	</td></tr>
</table>

<!------- Print용 Hidden RD Object Start -------->
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		<!-- <script language="javascript">comRdObjectPopup('Rd');</script>-->
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>