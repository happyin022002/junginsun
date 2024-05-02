<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4013.jsp
*@FileTitle : Invoice Creation - Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109784-01] [DMT] Invoice Creation & Issue의 Payer 정보 확인 절차 추가
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	//EesDmt4002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	String strCnt_cd = "";
	String strUsr_eml = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");
	
	//parameter
	String s_group_by = "";
	String s_chg_type = "";
	String jspno	  = "";
	String p_exchange_rt	= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
		strUsr_eml = account.getUsr_eml();


		//event = (EesDmt4002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		s_group_by		= JSPUtil.getParameter(request,"s_group_by");
		s_chg_type		= JSPUtil.getParameter(request,"s_chg_type");
		jspno			= JSPUtil.getParameter(request,"jspno");
		p_exchange_rt	= JSPUtil.getParameter(request,"inv_xch_rt");	//3001에서 넘어오는 exchange_rate
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice Creation - Group</title>
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
<body class="popup_bg" onLoad="setupPage();" onUnLoad="unLoadPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="tax_rto">

<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="s_cust_name">
<input type="hidden" name="ofc_cd">

<input type="hidden" name="s_group_by" value="<%=s_group_by %>">
<input type="hidden" name="s_chg_type" value="<%=s_chg_type %>">

<input type="hidden" name="success_yn">

<input type="hidden" name="session_cnt_cd" value="<%=strCnt_cd %>">
<input type="hidden" name="session_ofc_cd" value="<%=strUsr_ofc %>">
<input type="hidden" name="session_email" value="<%=strUsr_eml %>">
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>">
<input type="hidden" name="session_usr_id" value="<%=strUsr_id%>">

<input type="hidden" name="ofc_curr_date">
<input type="hidden" name="jspno" 			value="<%=jspno %>">
<input type="hidden" name="p_exchange_rt" 	value="<%=p_exchange_rt %>">
<input type="hidden" name="usr_cnt_cd"><!--  invoice 전 cnt_cd //2010.04.04.-->

<!-- container count 조회용 -->
<input type="hidden" name="s_ofc_cd">
<input type="hidden" name="s_bkg_no">
<input type="hidden" name="s_cntr_no">
<input type="hidden" name="s_dmdt_trf_cd">
<input type="hidden" name="re_cntr_cnt">

<input type="hidden" name="backendjob_key">		<!-- BackEndJob Key -->
<input type="hidden" name="backendjob_id">		<!-- BackEndJob 구분 ID -->

<!-- payer check -->
<input type="hidden" name="h_payer_cd">
<input type="hidden" name="h_payer_nm">
<input type="hidden" name="h_cust_gubun">

<input type="hidden" name="grp_bkg_no">
<input type="hidden" name="grp_dmdt_trf_cd">
<input type="hidden" name="por_cd">
<input type="hidden" name="del_cd">

<input type="hidden" name="s_fm_dt">
<input type="hidden" name="s_to_dt">

<input type="hidden" name="inv_new_rpt_flg">

<!-- AUTO INF. -->
<input type="hidden" name="auto_ar_inf_yn">

<!-- 인도 TAX RATIO 변경 전 필드 -->
<input type="hidden" name="ida_expn_tax_rt">
<input type="hidden" name="ida_expn_tax">
<input type="hidden" name="ida_edu_tax_rt">
<input type="hidden" name="ida_edu_tax">
<input type="hidden" name="ida_high_edu_tax_rt">
<input type="hidden" name="ida_high_edu_tax">
<input type="hidden" name="ida_locl_tax_rt">
<input type="hidden" name="ida_locl_tax">
<input type="hidden" name="ida_n2nd_locl_tax_rt">
<input type="hidden" name="ida_n2nd_locl_tax">
<!-- 인도 TAX RATIO 변경 후 필드 ( 2017.07.26 ) -->
<input type="hidden" name="ida_tax_appl_tm">
<input type="hidden" name="cust_vndr_div_cd">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="cond_ida_sac_cd">
<input type="hidden" name="port_cd">
<input type="hidden" name="ida_cgst_rto">
<input type="hidden" name="ida_cgst_amt">
<input type="hidden" name="ida_sgst_rto">
<input type="hidden" name="ida_sgst_amt">
<input type="hidden" name="ida_igst_rto">
<input type="hidden" name="ida_igst_amt">
<input type="hidden" name="ida_ugst_rto">
<input type="hidden" name="ida_ugst_amt">
<!-- 인도 TAX 관련 공통함수 구현에 따른 추가 필드 (어떤 화면에서 호출되었는지 구분하기 위함) ( 2017.07.26 ) -->
<input type="hidden" name="pgm_id" value="4013">
<!-- invoice 발행 후 조회 시 등록된 정보로 초기화를 시켜줘야 되기 때문에 계산 로직을 실행하지 않도록 제어해주는 변수 -->
<input type="hidden" name="inv_amt_calc_tp">
<!-- 인도 TAX Calculation 은 Tax Amount 변경에 의해서 실행됨을 알려주는 변수 ( 이 경우는 Tax Amount 를 계산하지 않고 입력된 금액으로 계산이 수행됩니다. ) -->
<input type="hidden" name="calc_by_cng_ida_tax_amt" value="N">
<!-- invoice A/R I/F 여부를 나타냄 ( 공통함수 사용에 따라 추가됨 ) -->
<input type="hidden" name="dmdt_ar_if_cd" value="N">
<input type="hidden" name="dc_amt">
<!-- 인도 TAX RD 출력시 사용할 필드 -->
<input type="hidden" name="ida_bank_acct_no">
<input type="hidden" name="ida_bank_ifsc_cd">
<!-- invoice 관련 공통함수 사옹에 따라 추가된 필드 -->
<input type="hidden" name="invoice_issue" value="1"> <!-- 1(before), 2(after) -->
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="cre_cnt_cd">
<input type="hidden" name="ida_gst_rgst_no">
<input type="hidden" name="ida_gst_rgst_sts_nm">
<input type="hidden" name="ida_ste_cd">
<input type="hidden" name="ida_ste_nm">
<input type="hidden" name="ida_sac_cd">
<input type="hidden" name="ida_sac_nm">

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Creation - Group</td></tr>
	</table>
	<!-- : ( Title ) (E) -->	
	<!-- : ( Search Options ) (S) -->
	<table class="search"> 
       		<tr><td class="bg">
			<!-- Grid  (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
				</tr>
			</table>
			<!-- Grid  (e) -->
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>		
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
			<td width="160">	
			<table class="search" border="0">
				<tr><td class="title_h"></td>
				<td class="title_s">Selected Total</td></tr>
			</table>
			</td>
			<td width="75">INV Cur.</td>			
			<% if( strUsr_ofc.equals("PKGSC") ||  strUsr_ofc.equals("PENSO") ||  strUsr_ofc.equals("PGUSO")) { %>
				<td width="195"><input type="text" name="inv_curr_cd" style="width:34;text-align:center;" class="input2" value="" readOnly></td>
				<td width="83">New Print</td>
				<td width=""><input type="checkbox" name="inv_new_rpt" style="width:33;" class="trans" value="" onclick="setRpt();"></td>
			<% } else { %>
				<td width=""><input type="text" name="inv_curr_cd" style="width:34;text-align:center;" class="input2" value="" readOnly></td>
				<td width=""><input type="hidden" name="inv_new_rpt" style="width:33;" class="trans" value="" ></td>
			<% }%>

			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="60">INV Q'TY</td>
				<td width="100"><input type="text" name="inv_qty" style="width:64;text-align:right;" class="input2" value="" readOnly></td>
				<td width="75">Billing AMT</td>
				<td width="195"><input type="text" name="inv_chg_amt" style="width:165;text-align:right;" class="input2" value="" readOnly></td>
				<td width="90">Tax Rate/AMT</td>
				<td width="250"><input type="checkbox" value="" name="chk_tax" class="trans" onclick="DmtComApplTaxRto();"><input type="text" name="tax_rto_dis" style="width:25;text-align:center;" class="input2" value="" readOnly>
				%
				<input type="text" name="tax_amt" style="width:150;text-align:right;" class="input2" value="" readOnly></td>
				<td width="55">INV AMT</td>
				<td width=""><input type="text" name="inv_amt" style="width:100%;text-align:right;" class="input2" value="" readOnly></td>
			</tr>
			</table>
			<!--  biz_1  (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="60">Payer</td>
				<td width="370"><input type="text" name="payer_cd" dataformat="engup" style="width:64;" maxlength="8" class="input1" style="ime-mode:disabled" value="" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;<img src="img/btns_search.gif" name="btn_payer_cd" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand">&nbsp;<input type="text" name="payer_nm" style="width:250;" class="input2" value="" readOnly></td>
				<td width="150">Issue Date Office Name</td>
				<td width=""><input type="text" name="issue_date" style="width:80;" class="input2" value="" readOnly>
				<input type="text" name="usr_ofc" style="width:50;" class="input2" value="" readOnly>
				<input type="text" name="usr_name" style="width:259;" class="input2" value="" readOnly></td>
			</tr> 
			</table>	
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="70">Invoice nbr </td>
				<td width="360"><input type="radio" name="s_group_inv" value = "GRP" class="trans" checked onclick="setGroupInv('GRP');">Combined Invoice nbr for selected BKGs</td>
				<td width=""><input type="radio" name="s_group_inv" value = "BKG" class="trans"  onclick="setGroupInv('BKG');">Individual invoice nbr for selected BKGs</td>
			</tr> 
			</table>	
		</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
	</td></tr>
</table>
<!-- Tab BG Box  (S) -->
<!--biz page (E)-->
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_update">Update</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ar">A/R I/F</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
				
			</tr>
		</table>
    <!--Button (E) -->
    </td>
</tr>
</table>		
<table width="100%"  id="mainTable2" style=display:none;> 
	<tr>
		<td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet2');</script> <!-- hidden 처리 (E)-->
		</td>
	</tr>
</table>
<table width="100%"  id="mainTable2" style=display:none;> 
	<tr>
		<td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet3');</script> <!-- hidden 처리 (E)-->
		</td>
	</tr>
</table>
</body>
</html>
