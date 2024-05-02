<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0011.jsp
*@FileTitle : Invoice Inquiry by I/F No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.16 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");
	
	String view_ar_if_no = request.getParameter("ar_if_no");
	if(view_ar_if_no == null){
		view_ar_if_no = "";
	}
	
	String view_inv_split_cd = request.getParameter("inv_split_cd");
	if(view_inv_split_cd == null){
		view_inv_split_cd = "";
	}
	
	String view_ar_ofc_cd = request.getParameter("ar_ofc_cd");
	if(view_ar_ofc_cd == null){
		view_ar_ofc_cd = "";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0011Event)request.getAttribute("Event");
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
<title>Invoice Inquiry by I/F No</title>
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
<%
	if(view_ar_if_no.equals("") && view_ar_ofc_cd.equals("")){
%>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="view_ar_if_no" value="<%=view_ar_if_no %>">
<input type="hidden" name="view_inv_split_cd" value="<%=view_inv_split_cd %>">
<input type="hidden" name="view_ar_ofc_cd" value="<%=view_ar_ofc_cd %>">
<input type="hidden" name="dp_prcs_knt" value="0">
<input type="hidden" name="dp_prcs_knt_local" value="0">

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
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 

<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="view_ar_if_no" value="<%=view_ar_if_no %>">
<input type="hidden" name="view_inv_split_cd" value="<%=view_inv_split_cd %>">
<input type="hidden" name="view_ar_ofc_cd" value="<%=view_ar_ofc_cd %>">
<input type="hidden" name="dp_prcs_knt" value="0">
<input type="hidden" name="dp_prcs_knt_local" value="0">
 
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="540" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Inquiry by I/F No</td></tr>
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
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="70">I/F No.</td>
					<td width="170"><input name="ar_if_no" type="text" style="width:100;" class="input1" value="" dataformat="engup" maxlength="11">&nbsp;<input name="inv_split_cd" type="text" style="width:24;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="50">B/L No.</td>
					<td width="170"><input name="bl_src_no" type="text" style="width:114;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="55">BKG No.</td>
					<td width="180"><input name="bkg_no" type="text" style="width:110;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="40">Office</td>   
					<td><input name="ar_ofc_cd" type="text" style="width:60;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
		<tr>
			<td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
			</td>
		</tr>
		</table>
		<!-- Tab ) (E) --> 	
		<!-- TAB General (s) -->	
		<div id="tabLayer" style="display:inline">
		<table class="search" height="370"> 
       	<tr>
       		<td class="bg" valign="top">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" align="">Actual Cust.&nbsp;</td>
					<td width="640"><input name="act_cust_cnt_cd" type="text" style="width:40;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<input name="act_cust_seq" type="text" style="width:60;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust">&nbsp;<input name="cust_lgl_eng_nm" type="text" style="width:300;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<input name="cust_rgst_no" type="text" style="width:150;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">Invoice Cust.&nbsp;</td>
					<td width=""><input name="inv_cust_cnt_cd" type="text" style="width:30;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<input name="inv_cust_seq" type="text" style="width:70;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" align="">Credit Limit&nbsp;</td>
					<td width="160"><input name="cr_curr_cd" type="text" style="width:40;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<input name="cr_amt" type="text" style="width:100;text-align:right;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">Credit Term&nbsp;</td> 
					<td width="160" class="stm">O/B&nbsp;<input name="ob_cr_term_dys" type="text" style="width:29;text-align:right;" class="input2" value="" readOnly tabIndex="-1">&nbsp;I/B&nbsp;<input name="ib_cr_term_dys" type="text" style="width:29;text-align:right;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">Credit Office&nbsp;</td>
					<td width=""><input name="cr_clt_ofc_cd" type="text" style="width:100;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>	
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" align="">Local VVD&nbsp;</td>
					<td width="160"><input name="vvd" type="text" style="width:120;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">Scope&nbsp;</td>
					<td width="160"><input name="svc_scp_cd" type="text" style="width:45;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">Bound&nbsp;</td>
					<td width="140"><input name="io_bnd_cd" type="text" style="width:45;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">S/A Date&nbsp;</td>
					<td><input name="sail_arr_dt" type="text" style="width:77;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>	
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" align="">Trunk VVD&nbsp;</td>
					<td width="160"><input name="trunk_vvd" type="text" style="width:120;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">Lane&nbsp;</td>
					<td width="160"><input name="slan_cd" type="text" style="width:45;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="90" align="">POR / POL</td>
					<td width="140"><input name="por_cd" type="text" style="width:50;" class="input2" value="" readOnly tabIndex="-1"> / <input name="pol_cd" type="text" style="width:50;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">POD / DEL</td>
					<td width=""><input name="pod_cd" type="text"style="width:50;" class="input2" value="" readOnly tabIndex="-1"> / <input name="del_cd" type="text"style="width:50;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>					
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" align="">C/A No.&nbsp;</td>
					<td width="160"><input name="bkg_corr_no" type="text" style="width:120;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">C/A Date&nbsp;</td>
					<td width="160"><input name="bkg_corr_dt" type="text" style="width:78;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="90" align="">SML Ref.&nbsp;</td>
					<td width="140"><input name="hjs_stf_ctnt" type="text" style="width:120;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">Sailing Date&nbsp;</td>
					<td><input name="sail_dt" type="text" style="width:77;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>
				<tr class="h23">
					<td width="" align="">INV Ref. No.&nbsp;</td>
					<td width=""><input name="inv_ref_no" type="text" style="width:120;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="" align="">BKG Ref. No.&nbsp;</td>
					<td width=""><input name="bkg_ref_no" type="text" style="width:120;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="" align="">S/I Ref. No.&nbsp;</td>
					<td width=""><input name="si_ref_no" type="text" style="width:120;" class="input2" value="" readOnly tabIndex="-1"></td>
					</tr>		
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" align="">Description&nbsp;</td>
					<td width="640"><input name="inv_rmk" type="text" style="width:600;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">Rev. Type&nbsp;</td>
					<td width="55"><input name="rev_tp_cd" type="text" style="width:30;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="50" align="">Source</td>
					<td width=""><input name="rev_src_cd" type="text" style="width:40;" class="input2" value="" readOnly tabIndex="-1"></td> 
				</tr>
				</table>	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" align="">Master B/L No.&nbsp;</td>
					<td width="160"><input name="mst_bl_no" type="text" style="width:100;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">RFA No.&nbsp;</td>
					<td width="160"><input name="rfa_no" type="text" style="width:100;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="90" align="">S/C No.&nbsp;</td>
					<td width="140"><input name="sc_no" type="text" style="width:100;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">F/Forwarder&nbsp;</td>
					<td width=""><input name="frt_fwrd_cnt_cd" type="text" style="width:30;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<input name="frt_fwrd_cust_seq" type="text" style="width:70;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>
				</table>	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" align="">Sales Rep.&nbsp;</td>
					<td width="160"><input name="srep_cd" type="text" style="width:100;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">Weight&nbsp;</td>
					<td width="160"><input name="cgo_wgt" type="text" style="width:100;text-align:right" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="90" align="">Measure&nbsp;</td>
					<td width="140"><input name="cgo_meas_qty" type="text" style="width:100;text-align:right" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="124" align="">EX. Rate(USD:LCL)&nbsp;</td>
					<td><input name="usd_xch_rt" type="text" style="width:100;text-align:right" class="input2" value="" readOnly tabIndex="-1"></td> 
				</tr>
				</table>	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" align="">WHF DEC&nbsp;</td>
					<td width="160"><input name="whf_decl_no" type="text" style="width:100;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">WHF Date&nbsp;</td>
					<td width="160"><input name="whf_decl_cfm_dt" type="text" style="width:78;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="90" align="">TEU / FEU&nbsp;</td>
					<td width=""><input name="bkg_teu_qty" type="text" style="width:43;text-align:right;" class="input2" value="" readOnly tabIndex="-1"> / <input name="bkg_feu_qty" type="text" style="width:42;text-align:right;" class="input2" value="" readOnly tabIndex="-1">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_container"></td>
				</tr>
				</table>	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" align="">I/F Date&nbsp;</td>
					<td width="160"><input name="bl_inv_if_dt" type="text" style="width:100;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="90" align="">Good Date&nbsp;</td>
					<td width="160"><input name="bl_inv_cfm_dt" type="text" style="width:78;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="90" align="">Eff. Date&nbsp;</td>
					<td width=""><input name="gl_eff_dt" type="text" style="width:78;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>
				<tr class="h23">
					<td width="" align="">Invoice No.&nbsp;</td>
					<td width=""><input name="inv_no" type="text" style="width:100;" class="input2" value="" readOnly tabIndex="-1"></td>
					<td width="" align="">Issue Date&nbsp;</td>
					<td width=""><input name="iss_dt" type="text" style="width:78;" class="input2" value="" readOnly tabIndex="-1"></td> 
					<td width="" align="">Due Date&nbsp;</td>
					<td width=""><input name="due_dt" type="text" style="width:78;" class="input2" value="" readOnly tabIndex="-1"></td>
				</tr>
				</table>	
			</td>
		</tr>
		</table>
		<!-- Tab BG Box(E) -->
		<!--biz page (E)-->
		</div>
		<!-- TAB General (E) -->	
		<!-- TAB Charge (s) -->	
		<div id="tabLayer" style="display:none">	
	
		<table class="search" height="370"> 
       	<tr>
       		<td class="bg" valign="top">
				<table class="height_5"><tr><td></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">By Currency</td>
				</tr>
				</table>		
				<!--  biz_1   (E) -->
				<!-- Grid  (S) -->
				<table width="550"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet1');</script>
					</td>
				</tr>
				</table> 
				<!-- Grid  (E) -->
				<!--  biz_2  (S) -->
				
				<table class="height_8"><tr><td></td></tr></table>
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">By Charge</td></tr>
				</table>		
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t2sheet2');</script>
					</td>
				</tr>
				</table> 
				<!-- Grid (E) -->
				
				<!--  biz_2   (E) -->
			</td>
		</tr>
		</table>	
		</div>
		<!-- TAB Charge (E) -->
	</td>
</tr>
</table>
<!-- Container (S) -->

<%
	if(view_ar_if_no.equals("") && view_ar_ofc_cd.equals("")){
%>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr>
			<td class="btn1_bg">
		   		<table border="0" cellpadding="0" cellspacing="0">
		   		<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_new">New</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	    <!--Button (E) -->
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
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
								</table>
							</td>
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

<table width="200" > 
<tr>
	<td width="100%" style="display:none">
		<script language="javascript">ComSheetObject('sheet3');</script>
	</td>
</tr>
</table> 				

<!-- Container (E) -->	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>