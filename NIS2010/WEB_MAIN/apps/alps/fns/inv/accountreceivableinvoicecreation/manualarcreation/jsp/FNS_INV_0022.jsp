<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0022.jsp
*@FileTitle : Other Revenue Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.04.27 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.event.FnsInv0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceCreation.ManualARCreation");
	
	String view_ar_if_no = StringUtil.xssFilter(request.getParameter("ar_if_no"));
	if(view_ar_if_no == null){
		view_ar_if_no = "";
	}
	
	String view_ar_ofc_cd = StringUtil.xssFilter(request.getParameter("ar_ofc_cd"));
	if(view_ar_ofc_cd == null){
		view_ar_ofc_cd = "";
	}
	
	String view_yn = "";
	if (view_ar_if_no != "" && view_ar_ofc_cd != "") {
		view_yn = "Y";
	}
	else {
		view_yn = "N";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();
	   
	   
		event = (FnsInv0022Event)request.getAttribute("Event");
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
<title>Other Revenue Invoice Creation</title>
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
<%
	if(view_ar_if_no.equals("") && view_ar_ofc_cd.equals("")){
%>
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="ots_smry_cd">
<input type="hidden" name="inv_vat_chg_cd">
<input type="hidden" name="inv_vat_chg_rt">
<input type="hidden" name="tva_amount" value="0">
<input type="hidden" name="svr_id">
<input type="hidden" name="usd_locl_xch_rt">
<input type="hidden" name="curr_point" value="0">
<input type="hidden" name="lcl_curr_point" value="0">
<input type="hidden" name="office_cnt_cd" value="">
<input type="hidden" name="tmp_bl_src_no" value="">
<input type="hidden" name="view_ar_if_no" value="<%=view_ar_if_no %>">
<input type="hidden" name="view_ar_ofc_cd" value="<%=view_ar_ofc_cd %>">
<input type="hidden" name="view_yn" value="<%=view_yn %>">
<input type="hidden" name="user_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="login_ofc_cd" value="<%=loginOfcCd%>">

<input type="hidden" name="tax_amount_ori" value="">

<input type="hidden" name="com_mrdPath"      value="">
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdBodyTitle" value="">

<input type="hidden" name="inv_prn_dvc_nm" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> 
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> 
		</table> 
		<!--Page Title, Historical (E)--> 
<%
	}
	else {
%>
<body class="popup_bg" onload="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="ots_smry_cd">
<input type="hidden" name="inv_vat_chg_cd">
<input type="hidden" name="inv_vat_chg_rt">
<input type="hidden" name="tva_amount" value="0">
<input type="hidden" name="svr_id">
<input type="hidden" name="usd_locl_xch_rt">
<input type="hidden" name="curr_point" value="0">
<input type="hidden" name="lcl_curr_point" value="0">
<input type="hidden" name="office_cnt_cd" value="">
<input type="hidden" name="tmp_bl_src_no" value="">
<input type="hidden" name="view_ar_if_no" value="<%=view_ar_if_no %>">
<input type="hidden" name="view_ar_ofc_cd" value="<%=view_ar_ofc_cd %>">
<input type="hidden" name="view_yn" value="<%=view_yn %>">
<input type="hidden" name="user_nm" value="<%=strUsr_nm%>">

<input type="hidden" name="tax_amount_ori" value="">

<input type="hidden" name="com_mrdPath"      value="">
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdBodyTitle" value="">

<input type="hidden" name="inv_prn_dvc_nm" value="">
 
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="540" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Other Revenue Invoice</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%
	}
%>
		<!--biz page (S)-->
		<table class="search"> 
       	<tr>
       		<td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="125">B/L No.</td>
					<td width="110"><input name="bl_src_no" type="text" style="width:98;" class="input1" dataformat="engup" maxlength="12" value=""></td>
					<td width="260">
						<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_auto">Auto B/L No.</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
					<td width="100">I/F No.</td>
					<td width="184"><input name="ar_if_no" type="text" style="width:96;" class="input2" dataformat="engup" maxlength="11" value=""></td>
					<td width="40">Office</td>
					<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 0);</script></td>
				</tr>
				<tr class="h23">
					<td width="">G/L Date</td>
					<td width="" colspan="2"><input name="eff_dt" type="text" style="width:75;text-align:left" class="input1" dataformat="ymd" maxlength="8" value="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					<td width="">Actual Cust.</td>
					<td width="" colspan="3"><input name="cust_cnt_cd" type="text" style="width:30;text-align:left" class="input1" value="" maxlength="2" dataformat="engup">&nbsp;<input name="cust_seq" type="text" style="width:62;text-align:left" class="input1" maxlength="6" class="input" value="" dataformat="num">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust1">&nbsp;<input name="cust_nm" type="text" style="width:212;" class="input2" value="" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust2"></td>
				</tr>
				<tr class="h23">
					<td width="">Curr/Amount</td>
					<td width="" style="padding-left:2;" colspan="2"><script language="javascript">ComComboObject('curr_cd', 1, 60, 0);</script>&nbsp;<input name="amount" type="text" style="width:180;text-align:right" class="input1" dataformat="float" value="" maxlength="14" pointcount="3" maxnum="99999999999.99"></td>
					<td width="">Local Amount</td>
					<td width="" colspan="3"><input name="lcl_curr" type="text" style="width:40;text-align:left" class="input2" value="" readonly tabIndex="-1">&nbsp;<input name="local_amount" type="text" style="width:166;text-align:right" class="input2" value="" readonly tabIndex="-1"></td>
				</tr>
				</table>
				<%
				if(loginOfcCd.equals("LEHSC")){
				%>
				<table id="taxDiv1" class="search" border="0" style="width:1129;display:none"> 
				<tr class="h23">
					<td width="125">Tax</td>
					<td width="368" style="padding-left:2;"><script language="javascript">ComComboObject('ar_tax_ind_cd', 1, 60, 1);</script>&nbsp;<input name="tax_curr_cd" type="text" style="width:40;text-align:left" class="input2" value="" readonly tabIndex="-1">&nbsp;<input name="tax_amount" type="text" style="width:136;text-align:right" class="input2" value="" readonly tabIndex="-1"></td>
					<td width="100">Local Total</td>
					<td width="326"><input name="total_curr_cd" type="text" style="width:40;text-align:left" class="input2" value="" readonly tabIndex="-1">&nbsp;<input name="total_local_amt" type="text" style="width:166;text-align:right" class="input2" value="" readonly tabIndex="-1">&nbsp;(Tax included)</td>


				    <td width="120">(LEHSC) VAT Rate</td>
					<td width=""><select style="width: 56" class="input1" 	name="lehbb_vat_rate">
							<option value="19.6" selected>19.6</option>
							<option value="20.0">20.0</option>
						</select>&nbsp;(%)</td>
				</tr>
				</table>
				<% } else {%>	
				<table id="taxDiv1" class="search" border="0" style="width:979;display:none"> 
				<tr class="h23">
					<td width="125">Tax</td>
					<td width="368" style="padding-left:2;"><script language="javascript">ComComboObject('ar_tax_ind_cd', 1, 60, 1);</script>&nbsp;<input name="tax_curr_cd" type="text" style="width:40;text-align:left" class="input2" value="" readonly tabIndex="-1">&nbsp;<input name="tax_amount" type="text" style="width:136;text-align:right" class="input2" value="" readonly tabIndex="-1"></td>
					<td width="100">Local Total</td>
					<td width=""><input name="total_curr_cd" type="text" style="width:40;text-align:left" class="input2" value="" readonly tabIndex="-1">&nbsp;<input name="total_local_amt" type="text" style="width:166;text-align:right" class="input2" value="" readonly tabIndex="-1">&nbsp;(Tax included)</td>
				</tr>
				</table>
				<% } %>	
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="125">Ex. Rate (to LCL)</td>
					<td width="370"><input name="inv_xch_rt" type="text" style="width:90;text-align:right" class="input1" dataformat="float" value="" maxlength="12" pointcount="6" maxnum="99999999999"></td>
					<td width="100">VVD</td>
					<!-- <td width="116"><input name="lcl_vvd" type="text" style="width:96;text-align:left" class="input2" value="" readonly tabIndex="-1"></td>  -->
					<td width="116"><input name="lcl_vvd" type="text" style="width:96;text-align:left" class="input1" value=""  maxlength="9" dataformat="engup"  style="ime-mode:disabled"></td>
					<td width="33">Port</td>
					<td width=""><input name="pol_cd" type="text" style="width:61;text-align:left" class="input2" value="" readonly tabIndex="-1"></td>
				</tr>
				<tr class="h23">
					<td width="">DR Account</td>
					<td width="" colspan="5"><input name="acct_cd" type="text" style="width:90;text-align:left" class="input2" value="111091" readonly tabIndex="-1">&nbsp;<input name="acct_eng_nm" type="text" style="width:472;" class="input2" value=" ACCOUNT RECEIVABLE - OTHER" readonly tabIndex="-1"></td>
				</tr>
				<tr class="h23">
					<td width="">Remark(s)</td>
					<td width="" colspan="5"><input name="inv_rmk" type="text" style="width:566;" class="input1" value=""></td>
				</tr>
				</table>
				<table id="taxDiv2" class="search" border="0" style="width:979;display:block">
				<tr class="h23">
					<td width="">&nbsp;</td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
			
				<!-- Grid (S) -->
				<table width="100%"  id="mainTable"> 
				<tr>
					<td>
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>			
				<!-- Grid (E) -->
			
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
	       		<tr>
	       			<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_add">Row&nbsp;Add</td>
									<td class="btn2_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_copy">Row&nbsp;Copy</td>
									<td class="btn2_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_delete">Row Delete</td>
									<td class="btn2_right"></td>
								</tr>
							</table></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
	    		<!-- Button_Sub (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0" id="mainTable2" style="width:100%;">
				<tr class="h23">
					<td width="80" style="vertical-align:top;" class="title_s">DR</td>
					<td width="300"><script language="javascript">ComSheetObject('sheet2');</script></td> 
					<td width="">&nbsp;</td>
					<td width="80" style="vertical-align:top;" class="title_s">CR</td>
					<td width="300"><script language="javascript">ComSheetObject('sheet3');</script></td> 
				</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="360">
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="80">Slip No.&nbsp;</td>
							<td width=""><input name="slp_no" type="text" style="width:188;text-align:left" class="input2" value="" readonly tabIndex="-1"></td>
						</tr>
						</table>
					</td>
					<td width="">
						<table id="invNoDiv" class="search" border="0" style="width:100%;display:none"> 
						<tr class="h23">
							<td width="100">Invoice No.&nbsp;</td>
							<td width=""><input name="inv_no" type="text" style="width:120;text-align:left" class="input2" value="" readonly tabIndex="-1"></td>
						</tr>
						</table>
					</td>
				</tr></table>
				<!-- Tab BG Box(E) -->
			</td>
		</tr></table>
		<!--biz page (E)-->
	</td>
</tr>
</table>
<%
	if(view_ar_if_no.equals("") && view_ar_ofc_cd.equals("")){
%>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="122" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print1">Slip Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="132" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_create">Inv No. Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
				</table>
				<!--Button (E) -->

			</td>
		</tr>
		</table>
<%
	}
	else {
%>
		<!-- : ( Button : Sub ) (S) -->
		<table width="100%" class="sbutton">
		<tr>
			<td height="71" class="popup">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
    					<table border="0" cellpadding="0" cellspacing="0">
    					<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_print2">Slip Print</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="132" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_create">Inv No. Creation</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!-- : ( Button : Sub ) (E) -->
<%
	}
%>


<div style="display:none;">
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet4');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->
</div>
<!------- Print용 Hidden RD Object Start -------->
<table>
<tr>
	<td height="1" width="1">
		<script language="javascript">comRdObject('report1');</script>
	</td>
</tr>
</table>
<!------- Print용 Hidden RD Object End -------->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>