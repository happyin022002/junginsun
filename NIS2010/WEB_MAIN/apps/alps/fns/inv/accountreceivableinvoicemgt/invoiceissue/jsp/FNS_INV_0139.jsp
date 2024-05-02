<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0139.jsp
*@FileTitle : AccountReceivableInvoiceMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2014.08.27 최도순
* 1.0 Creation
* --------------------------------------------------------
* History
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0139Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0139Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String loginOfcCd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();


		event = (FnsInv0139Event)request.getAttribute("Event");
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
<title>AccountReceivableInvoiceMgt</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<input type="hidden" name="ar_ofc_cd2">
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="bl_nos">
<input type="hidden" name="bkg_nos">
<input type="hidden" name="svr_id">
<input type="hidden" name="inv_nos">
<input type="hidden" name="user_id" value="<%=strUsr_id%>">
<input type="hidden" name="user_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="if_user_id" >
<input type="hidden" name="invs_email">
<input type="hidden" name="state">
<input type="hidden" name="ots_smry_cd">
<input type="hidden" name="inv_dup_flg">
<input type="hidden" name="inv_mlt_bl_iss_flg">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="email_flag" value="N">
<input type="hidden" name="login_ofc_cd" value="<%=loginOfcCd%>">
<input type="hidden" name="print_nm">
<input type="hidden" name="com_mrdPath"> 
<input type="hidden" name="com_mrdArguments"> 
<input type="hidden" name="send_flag"> 
<input type="hidden" name="edt_to_eml"> 
<input type="hidden" name="edt_cc_eml"> 
<input type="hidden" name="edt_from_eml"> 
<input type="hidden" name="edt_subject"> 
<input type="hidden" name="edt_contents"> 

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
					<td width="550">
						<table class="search_sm" border="0" style="width:550;">
							<tr class="h23">
								<td width="83" align="">&nbsp;Issue By</td>
								<td width="80" class="stm"> <input type="checkbox" value="" class="trans" name="chk_vvd" style="" onclick="javascript:clickVvd();">VVD </td>
								<td width="80" class="stm"> <input type="checkbox" value="" class="trans" name="chk_cust" onclick="javascript:clickCust();">Customer </td>
								<td width="80" class="stm"> <input type="checkbox" value="" class="trans" name="chk_blno" onclick="javascript:clickBlno();" checked>B/L No. </td>
								<td width="80" class="stm"> <input type="checkbox" value="" class="trans" name="chk_userid" onclick="javascript:clickUserid();">User ID </td>
								<td width="" class="stm"> <input type="checkbox" value="" class="trans" name="chk_all" onclick="javascript:clickAll();">Period </td>
							</tr>
						</table>
					
					</td>
					<td width="50" align="right">Bound&nbsp;</td>   
					<td width="70"><select style="width:60;" class="noinput" name="bnd" onChange="javascript:initInvNO();">&nbsp;
						<option value="A" selected>All</option>
						<option value="O">O/B</option>
						<option value="I">I/B</option></td>
					
					<td width="50" align="right">Office&nbsp;</td>   
					<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 90, 1, 1);</script>
					</td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="550">
						<table class="search_sm" border="0" style="width:550;">
							<tr class="h23">
								<td width="130" align="right">Date Option&nbsp;</td>
								<td width="80" class="stm"> <input type="radio" value="G" class="trans" checked name="dt_option">Good </td>
								<td width="120" class="stm"> <input type="radio" value="U" class="trans" name="dt_option">S/A Date </td>
							
							    <td width="30" align="right" >&nbsp;From&nbsp;</td>
							    <td width="200">
							    	<input type="text" style="width:80;" class="input" value="" name="from_dt" maxlength="8" dataformat="ymd" required cofield="to_dt" caption="start date">
					                <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar1">&nbsp;&nbsp;~
					            </td>
					            <td width="30" align="right" >To&nbsp;</td>    
					            <td width="200">
					                <input type="text" style="width:80;" class="input" value="" name="to_dt" maxlength="8" dataformat="ymd" required cofield="from_dt" caption="end date">
					                <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar2">
					            </td>		
							</tr>
						</table>		
					</td>					
			    </tr>
				</table>	
		
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90" align="">&nbsp;VVD</td>
						<td width="150"><input type="text" style="width:100;" name="vvd" minlength="9" maxlength="9" class="input2" dataformat="engup" readOnly></td>
						<td width="90" align="right">Service Scope&nbsp;</td>
						<td width="106"><input type="text" style="width:50;" name="scp" minlength="3" maxlength="3" class="input2" dataformat="engup" readOnly></td>
						<td width="90" align="right">Port Code&nbsp;</td>
						<td width=""><input type="text" style="width:50;" name="port" minlength="5" maxlength="5" class="input2" dataformat="engup" readOnly></td>
					</tr>
				</table>
				
			<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90" align="">&nbsp;Actual Cust.</td>
						<td width="" colspan="7">
						<input type="text" style="width:40;" class="input2" name="cust_cnt_cd" minlength="2" maxlength="2" dataformat="engup" readonly>
						<input type="text" style="width:55;" class="input2" name="cust_seq" maxlength="6" dataformat="hms" onfocusout="javascript:getCustNm();" readonly>
						<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="popup1" disabled onclick="javascript:openFnsInv0013();">
						<input type="text" style="width:360;" class="input2" name="cust_nm" readonly>
						<input type="text" style="width:100;" class="input2" name="cust_rgst_no" readonly>
						<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="popup2" disabled onclick="javascript:openFnsInv0086();"></td>
							
					</tr>
					<tr class="h23">
						<td width="90" align="">&nbsp;Credit Limit</td>
							<td width=""><input type="text" style="width:40;" class="input2" name="cr_curr_cd" readonly>
							<input type="text" style="width:100;text-align:right;" class="input2" name="cr_amt" readonly></td>
						<td width="28">Tel.</td>
							<td width="185"><input type="text" style="width:130;" class="input2" name="phn_no" readonly></td>
						<td width="28">Fax</td>
							<td width="200"><input type="text" style="width:130;" class="input2" name="fax_no" readonly></td>
						<td width="30">PIC</td>
							<td width=""><input type="text" style="width:130;" class="input2" name="cntc_pson_nm" readonly></td>
							
					</tr>
				</table>
				
				
			<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:403;"> 
					<tr class="h23">
						<td width="83" align="">&nbsp;Stamp Info</td>
						<td width="80" class="stm"> <input type="radio" value="A" class="trans" name="stamp_type" checked>All </td>
						<td width="80" class="stm"> <input type="radio" value="D" class="trans" name="stamp_type" >Due Date </td>
						<td width="80" class="stm"> <input type="radio" value="S" class="trans" name="stamp_type" >S/A Date </td>
						<td width="80" class="stm"> <input type="radio" value="N" class="trans" name="stamp_type" >N/A </td>
					</tr>
				</table>	
				
				
			<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:243;"> 
					<tr class="h23">
						<td width="83" align="">&nbsp;Email</td>
						<td width="80" class="stm"> <input type="radio" value="T" class="trans" name="mail_type" checked>Together </td>
						<td width="80" class="stm"> <input type="radio" value="S" class="trans" name="mail_type" >Separately </td>
					</tr>
				</table>				
				
			<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				    <tr class="h23">
						<td width="86" valign="TOP" align="">&nbsp;B/L No.</td>
						<td width="828" align="left">							
						<!--grid (S)-->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table> 
						<!--grid (E)-->							
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
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
				<td id="btnPaper"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_preview">Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btnPaper"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_paperissue">Paper&nbsp;Issue</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_eml">E-mail Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_fax">FAX Send</td>
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
<div style="display:none">
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->
</div>
<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
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