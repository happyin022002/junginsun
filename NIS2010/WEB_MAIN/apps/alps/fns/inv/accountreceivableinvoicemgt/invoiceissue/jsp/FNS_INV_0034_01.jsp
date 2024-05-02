<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0034_01.jsp
*@FileTitle : AccountReceivableInvoiceMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.17 정휘택
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv003401Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv003401Event  event = null;			//PDTO(Data Transfer Object including Parameters)
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


		event = (FnsInv003401Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String dodOfcCd = "";
	dodOfcCd = StringUtil.xssFilter(request.getParameter("ofc_cd"));
	
	String dodBlNos = "";
	dodBlNos = StringUtil.xssFilter(request.getParameter("bl_no"));
	
	String popup =  StringUtil.xssFilter(request.getParameter("popup")) == null ? "no": StringUtil.xssFilter(request.getParameter("popup"));
 
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

<% if(popup.equals("yes")){  %>
<body  class ="popup_bg" onLoad="setupPage();">

<% }else{ %>
<body  onLoad="setupPage();">
<% } %>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="ar_ofc_cd2">
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="bl_nos">
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
<input type="hidden" name="dodOfcCd" value="<%=dodOfcCd%>">
<input type="hidden" name="dodBlNos" value="<%=dodBlNos%>">

<% if(popup.equals("yes")){ %>
<table width="100%" class="popup" cellpadding="10" border ="0">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Invoice Issue</td></tr>
	</table>
	<!--Page Title, Historical (E)-->	
<%}else{  %>	

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>

<% } %>
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
					<td width="70"><select style="width:60;" class="noinput" name="bnd" onChange="javascript:initInvNO();" disabled>&nbsp;
						<option value="A" selected>All</option>
						<option value="O">O/B</option>
						<option value="I">I/B</option></td>
					<td width="70" align="right">Rev. Type&nbsp;</td>   
					<td width="70"><select style="width:60;" class="noinput" name="rev_type" onChange="javascript:initInvNO();">&nbsp;
						<option value="" selected>All</option>
						<option value="F">FRT</option>
						<option value="M">MRI</option></td>	
					<td width="50" align="right">Office&nbsp;</td>   
					<td width="110"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 90, 1, 1);</script>
					</td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="550">
						<table class="search_sm" border="0" style="width:550;">
							<tr class="h23">
								<td width="160" align="right">Date Option&nbsp;</td>
								<td width="80" class="stm"> <input type="radio" value="G" class="trans" checked name="dt_option">Good </td>
								<td width="" class="stm"> <input type="radio" value="U" class="trans" name="dt_option">Update </td>
							
							    <td width="70" align="right" >&nbsp;From&nbsp;</td>
							    <td width="240">
							    	<input type="text" style="width:80;" class="input" value="" name="from_dt" maxlength="8" dataformat="ymd" required cofield="to_dt" caption="start date">
					                <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar1">&nbsp;&nbsp;~
					            </td>
					            <td width="" align="right" >To&nbsp;</td>    
					            <td width="220">
					                <input type="text" style="width:80;" class="input" value="" name="to_dt" maxlength="8" dataformat="ymd" required cofield="from_dt" caption="end date">
					                <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar2">
					            </td>		
							</tr>
						</table>		
					</td>
					<!-- DXBSC일때만 출력 -->
					<%
						if(loginOfcCd.equals("DXBSC")){
					%>
					<td width="50" align="right">Type&nbsp;</td>   
					<td width="200">&nbsp;
						<input type="radio" value="P" class="trans" checked name="issue_type"  onclick="javascript:initInvNO();">PROFORMA &nbsp;
						<input type="radio" value="F" class="trans" name="issue_type" onclick="javascript:initInvNO();">FINAL
					</td>
					<td width="120"></td>	
					<% } %>		
					<!-- SYDSC일때만 출력 -->
					<%
						if(loginOfcCd.equals("SYDSC")||loginOfcCd.equals("MELSO")||loginOfcCd.equals("BENBS")||loginOfcCd.equals("FRESO")){
					%>
					<td width="150" align="right">Invoice body Cur&nbsp;</td>   
					<td width="250">&nbsp;
						<input type="radio" value="N" class="trans" checked name="exrate_type" >AUD &nbsp;
						<input type="radio" value="Y" class="trans" name="exrate_type" >USD
					</td>
					<td width="120"></td>	
					<% } %>		
					<td width="430" id="ind_opt" style="display:none">
						<table class="search_sm" border="0" style="width:430;">
							<tr class="h23">
								<td width="50" align="">&nbsp;&nbsp;Type</td>
								<td width="80" class="stm"> <input type="radio" value="P" class="trans" checked name="ind_iss_tp_cd" >Proforma </td>
								<td width="90" class="stm"> <input type="radio" value="T" class="trans" name="ind_iss_tp_cd" >Tax Invoice </td>
								<td width="90" class="stm"> <input type="radio" value="D" class="trans" name="ind_iss_tp_cd" >Debit Note </td>
								<td width="" class="stm"> <input type="radio" value="C" class="trans" name="ind_iss_tp_cd" >Credit Note </td>
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
				
			<table class="line_bluedot"><tr><td></td></tr></table>
		<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90" align="right">Invoice No.&nbsp;</td>
						<td width="305"><input type="text" style="width:115;" value="" class="input2" name="f_inv" readonly>&nbsp;~&nbsp;
						                <input type="text" style="width:115;" value="" class="input2" name="t_inv" readonly></td>
						<td width="130">Total Invoice Count</td>
						<td width="163"><input type="text" style="width:80;text-align:right;" value="" class="input2" name="tot_inv_cnt" readonly></td>
						<td width="150">Number of copy invoice</td>
						<td width=""><input type="text" style="width:80;text-align:right;" value="" class="input" name="copy_cnt" dataformat="int" minlength="1" maxlength="3"></td>
						             
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
				<%
					if(!loginOfcCd.equals("DXBSC")){
				%>
				<td id="btnPaper"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_paperissue">Paper&nbsp;Issue</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<% } %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_goto">Go&nbsp;to&nbsp;Send</td>
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