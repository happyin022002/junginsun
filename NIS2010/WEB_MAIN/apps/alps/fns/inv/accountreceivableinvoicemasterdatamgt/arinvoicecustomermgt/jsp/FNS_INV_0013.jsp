<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0013.jsp
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.19 한동훈
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceCustomerMgt");
	
	String cust_cnt_cd = StringUtil.xssFilter(request.getParameter("cust_cnt_cd"));
	if(cust_cnt_cd == null){
		cust_cnt_cd = "";
	}
		
	String cust_seq = StringUtil.xssFilter(request.getParameter("cust_seq"));
	String read_only = "readonly";
	if(cust_seq == null || cust_seq.equals("")){
		cust_seq = "";
		read_only = "";
	}
	
	String pop_yn = StringUtil.xssFilter(request.getParameter("pop_yn"));	
	if(pop_yn == null){
		pop_yn = "";		
	}
	
	String ret_yn = StringUtil.xssFilter(request.getParameter("ret_yn"));	
	if(ret_yn == null){
		ret_yn = "";		
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (FnsInv0013Event)request.getAttribute("Event");
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
<title>Customer Information</title>
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

<!-- 개발자 작업	-->		
		<!-- : ( Title ) (S) -->
		<%
			if(pop_yn.equals("Y")){
		%>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_cust_cr_due_dt_div_cd">
<input type="hidden" name="pop_yn" value="<%=pop_yn%>">
<input type="hidden" name="frm_delt_flg">
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">		
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Customer Information Inquiry</td></tr>
		</table>
		<%
			}else{
		%>
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_cust_cr_due_dt_div_cd">
<input type="hidden" name="pop_yn" value="<%=pop_yn%>">
<input type="hidden" name="frm_delt_flg">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">			
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<%
			}
		%>
		
		
<div style="display:none">
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->
</div>
<div id="msg" style="position:absolute;left:0;top:0;width:0;height:0;"></div>


		<!-- : ( Title ) (E) -->
		
		<!-- 1 (S)-->
		<table class="search"> 
       		<tr><td class="bg" >
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="65">Customer</td>
						<td width="400"><input type="text" name="frm_cust_cnt_cd" class="input1" style="width:30; text-align:center;" style="ime-mode:disabled" dataformat="engup" onKeyup="moveNext('frm_cust_cnt_cd','frm_cust_seq',2);" maxlength='2' value="<%=cust_cnt_cd%>" <%=read_only%>>&nbsp;-&nbsp;
										<input type="text" class="input1" name="frm_cust_seq" style="width:60; text-align:center;" style="ime-mode:disabled" dataformat="num" value="<%=cust_seq%>" maxlength="6" <%=read_only%>>&nbsp;
										<input type="text"  name="frm_cust_lgl_eng_nm" class="input2" style="width:250;" readonly></td>
						<td width="180">Tax Payer ID/Registry No</td>
						<td><input type="text" class="input1" name="frm_cust_rgst_no" style="width:130; text-align:center;" dataformat="uppernum" maxlength="14" <%=read_only%>>&nbsp;
							<!-- <input type="text" name="frm_cust_lgl_eng_nm2" class="input2" style="width:200;" readonly>-->							
						</td>
						<td>&nbsp;&nbsp;</td>						
						<td> 
						<table  id="del_flg" width="100%" class="search"  id="mainTable" style="display:none"> 
							<tr>
								<td width="100%">
									<font color="red">Deleted Customer</font>
								</td>
							</tr>
						</table> 								
						</td>						
					</tr>
				</table>
				<!--  biz_1   (E) -->
			
			</td></tr>
		</table>		
		<table class="height_8"><tr><td></td></tr></table>
		<!-- 1 (E)--> 

		<!-- 2 (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">

				<!-- Address (S) -->
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				
				<tr class="input2">
					<td width="10%" class="tr2_head">S.Rep. Code</td>
					<td width="15%"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_srep_cd" ></td> 
					<td width="10%" class="tr2_head">S.Rep. Name</td> 
					<td colspan="5"><input type="text" style="width:100%;text-align:Left" class="noinput2" readOnly="true" name="frm_srep_nm" ></td> 
				</tr>
				
				<tr class="input2">
					<td class="tr2_head">Address</td>
					<td colspan="7"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_bzet_addr" ></td></tr>
				<!-- tr class="input2">
					<td class="tr2_head"></td>
					<td colspan="7"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_bzet_addr2" ></td>
				</tr>-->
				<tr class="input2">
					<td width="10%" class="tr2_head">Country</td>
					<td width="15%"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_cnt_cd" ></td> 
					<td width="10%" class="tr2_head">State</td> 
					<td width="15%"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_ste_nm" ></td> 
					<td width="10%" class="tr2_head">City</td>
					<td width="15%"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_cty_nm" ></td> 
					<td width="10%" class="tr2_head">Zip Code</td>
					<td><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_zip_cd" ></td>
				</tr>
				<tr class="input2">
					<td width="10%" class="tr2_head">TEL No.</td> 
					<td width="15%"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_phn_no" ></td> 
					<td width="10%" class="tr2_head">Fax No.</td>
					<td width="15%"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_fax_no" ></td> 
					<td width="10%" class="tr2_head"> Sales Office</td>
					<td colspan="3"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_ofc_cd" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">Remark(s)</td>
					<td colspan="7"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_cust_rmk" ></td></tr>
				</table>
				<!-- Address (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
								
				<!-- CRD CUR (S) -->
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr class="input2">
					<td width="12%" class="tr2_head">Credit Cur.</td>
					<td width="9%" align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_cr_curr_cd" ></td> 
					<td width="12%" class="tr2_head">Credit Limit</td> 
					<td width="11%" align="right"><input type="text" style="width:100%;text-align:right" class="noinput2" readOnly="true" name="frm_cr_amt" ></td> 
					<td class="tr2_head" colspan="3">Credit FM/TO</td>
					<td width="9%" align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_cr_st_dt" ></td> 
					<td width="9%" align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_cr_end_dt" ></td> 
					<td width="9%" class="tr2_head">Credit Office</td>
					<td width="8%" align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_cr_clt_ofc_cd" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">I/B Credit Term</td>
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_ib_cr_term_dys" ></td> 
					<td class="tr2_head">O/B Credit Term</td> 
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_ob_cr_term_dys" ></td> 
					<td class="tr2_head">RLS CNTL</td>
					<td align="center" colspan="2" width = "70"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_cust_rlse_ctrl_flg" ></td> 
					<td class="tr2_head">PSN In CHG</td>
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_cntc_pson_nm" ></td> 
					<td class="tr2_head">Hide Due Date <BR>&nbsp;&nbsp;in Invoice<!--Hide Due Date in Invoice--></td>
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_inv_due_dt_dp_flg" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">Actual Payer</td>
					<td align="center" colspan="7"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_act_cust_cnt_cd" ></td> 
					<!-- <td class="tr2_head">O/B E-mail</td> 
					<td align="center"><A HREF="#" onmousemove="obEmlmsgmove('1')" onmouseover="obEmlmsgset('1');return true;"  onmouseout="obEmlmsghide('1');return true;"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_ob_eml" ></A>
					
					<td class="tr2_head">I/B E-mail</td>
					<td align="center"  colspan="3" ><A HREF="#" onmousemove="obEmlmsgmove('2')" onmouseover="obEmlmsgset('2');return true;"  onmouseout="obEmlmsghide('2');return true;"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_ib_eml" ></A>
 -->
					<td class="tr2_head" colspan="2">Ex. Rate Div/Basis</td>
					<td align="center">
						<A HREF="#" onmousemove="msgmove('1')" onmouseover="msgset('1');return true;"  onmouseout="msghide('1');return true;"><input type="text" style="width:40%;text-align:center" class="noinput2" readOnly="true" name="frm_xch_rt_div_cd" ></A>
						/<A HREF="#" onmousemove="msgmove('2')" onmouseover="msgset('2');return true;"  onmouseout="msghide('2');return true;"><input type="text" style="width:40%;text-align:center" class="noinput2" readOnly="true" name="frm_cng_indiv_cd" ></A>
					</td>						
				</tr>
				<tr class="input2">
					<td class="tr2_head">Remark(s)</td>
					<td colspan="7"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_cr_cust_rmk" ></td>
					<td rowspan="8" colspan="3" style="background-color:#F3F2F8; border-right:1px solid #F3F2F8;text-align:right;">

						<!-- OFT CRDT - Payment Day (S) -->
						<table class="search" style="border:15px solid #F3F2F8; width:250;">
						<tr>
							<td style="border:1px solid #F3F2F8;" width="200" align="center">
						
								<table style="width:200;" class="grid2"> 
								<tr class="h23">
									<td class="tr2_head">Issue</td></tr>
								<tr><td align="center" class="input2"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_iss_div_cd" ></td></tr>
								</table><br style="font-size:4pt;">
								<table border="0" style="width:200;" class="grid2"> 
								<tr class="h23">
									<td class="tr2_head">Credit DIV</td></tr>
								<tr><td align="center" class="input2">
									S/A Date<input type="radio" name="frm_cust_cr_due_dt_div_cd1" class="trans" disabled>&nbsp;&nbsp;&nbsp;
									Issue Date<input type="radio" name="frm_cust_cr_due_dt_div_cd2"  class="trans" disabled></td></tr>
								</table><br style="font-size:4pt;">
								<table border="0" style="width:200;" class="grid2"> 
								<tr class="h23">
									<td class="tr2_head" colspan="5">Payment Day</td></tr>
								<tr class="input2">
									<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_pay_dt_dy1" ></td>
									<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_pay_dt_dy2" ></td>
									<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_pay_dt_dy3" ></td>
									<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_pay_dt_dy4" ></td>
									<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_pay_dt_dy5" ></td></tr>
									
								<tr class="h23">
									<td class="tr2_head" colspan="5">WEEKLY</td></tr>
								<tr class="input2">
									<td align="center" colspan="5"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_pay_wk_dy_cd" ></td>
								</tr>
								
									
								</table>
							
							</td></tr></table> 
							
						<!-- OFT CRDT - Payment Day (E) -->					
					
					</td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">COL Method</td>
					<td colspan="2"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_pay_div_cd" ></td>
					<td class="tr2_head">Cust. ACCT No.</td>
					<td colspan="4"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_bank_acct_no" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">Owner</td>
					<td colspan="2"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_ownr_nm" ></td>
					<td width="7%" class="tr2_head" colspan="2">Tax Payer ID/Registry No.</td>
					<td width="%" colspan="3"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_tva_no" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">Biz Kind</td>
					<td colspan="3"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_bzct_nm" ></td>
					<td class="tr2_head">Biz Item</td>
					<td colspan="3"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_bztp_nm" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">Local Name</td>
					<td colspan="3"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_locl_nm" ></td>
					<td class="tr2_head">CO./PRV</td>
					<td colspan="3"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_indiv_corp_div_cd" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">Local Address</td>
					<td colspan="3"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_locl_addr1" ></td>
					<td colspan="4"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_locl_addr2" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head"></td>
					<td colspan="3"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_locl_addr3" ></td>
					<td colspan="4"><input type="text" style="width:100%;text-align:left" class="noinput2" readOnly="true" name="frm_locl_addr4" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">Cust Type</td>
					<td colspan="2"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_cr_cust_tp_cd" ></td>
					<td class="tr2_head">KOR I/B OFC</td>
					<td colspan="4"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_kr_ib_ofc_cd" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">LCL Zip Code</td>
					<td colspan="2"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_locl_zip_cd" ></td>
					<td class="tr2_head">LCL TEL No.</td>
					<td colspan="3"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_ob_phn_no" ></td>
					<td class="tr2_head" colspan="2">LCL Fax No.</td>
					<td colspan="2"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_ob_fax_no" ></td>
				</tr>
				<tr class="input2">
					<td class="tr2_head">Kind of SECU</td>
					<td colspan="2"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_cust_scr_div_cd" ></td>
					<td class="tr2_head">SECU AMT</td>
					<td colspan="3" align="right"><input type="text" style="width:100%;text-align:right" class="noinput2" readOnly="true" name="frm_cust_scr_locl_amt" ></td>
					<td class="tr2_head" colspan="2">SECU FM/TO</td>
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_scr_st_dt" ></td>
					<td align="center"><input type="text" style="width:100%;text-align:center" class="noinput2" readOnly="true" name="frm_scr_end_dt" ></td>
				</tr>
				 
				<tr>
					<td class="tr2_head">INV Email Info</td>
					<td colspan="10" >
					<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
				</table>

</td></tr></table>
				
    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>		    
<%
	if(ret_yn.equals("")){
%>		    
		    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>	
<% } %>	
<%
	if(ret_yn.equals("") && cust_seq.equals("")){
%>				
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
				</tr></table></td>
<% } %>			
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->

	</td></tr>
		</table>	

</td></tr>
</table>
<!-- : ( Button : pop ) (S) -->
<%
	if(pop_yn.equals("Y")){
%>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;" align="left"> 
       	<!--tr><td class="btn3_bg" align="right"-->
       	<tr>
       		<td align="center">
			    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
				    	
				    	<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
							<td class="btn1_right">
							</tr></table>
						</td>
				    	
					</tr>
				</table>
			</td>
				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<% } %>

<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>