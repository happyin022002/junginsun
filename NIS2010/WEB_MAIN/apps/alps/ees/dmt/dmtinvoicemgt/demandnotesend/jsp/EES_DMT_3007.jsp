﻿﻿<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3007.jsp
*@FileTitle : Demand Note Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.07 최성환
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3007Event"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event.EES_DMT_3007HTMLAction"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesDmt3007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id 	= "";
	String strUsr_nm 	= "";
	String strUsr_ofc 	= "";
	String strCnt_cd 	= "";
	String strUsr_eml	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTInvoiceMgt.demandnotesend");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	= account.getUsr_id();
		strUsr_nm 	= account.getUsr_nm();
		strUsr_ofc 	= account.getOfc_cd();
		strCnt_cd 	= account.getCnt_cd();
		strUsr_eml 	= account.getUsr_eml();

		event = (EesDmt3007Event)request.getAttribute("Event");
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
<title>Demand Note Issue Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    function setupPage(){
        loadPage();     
    }
</script>
</head>

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
<input type="hidden" name="session_ofc_cd" value="<%=strUsr_ofc %>">
<input type="hidden" name="session_email" value="<%=strUsr_eml %>">
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>">
<input type="hidden" name="session_usr_id" value="<%=strUsr_id%>">
<!-- country code -->
<input type="hidden" name="tax_nm"><!-- AU(GST) / 이외 (VAT) -->

<!-- 호출 타입 구분 group/booking -->
<input type="hidden" name="call_to_rd_tp"> 
<!-- Demand Note Issue Preview - Group -->
<!-- 부모화면 데이터 -->
<input type="hidden" name="ofc_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="dmdt_chg_sts_cd">
<input type="hidden" name="cntr_no"> 
<input type="hidden" name="bkg_no">
<input type="hidden" name="payer_cd">
<input type="hidden" name="tmp_payer_cd">
<input type="hidden" name="payer_nm">

<input type="hidden" name="org_curr_cd">
<input type="hidden" name="inv_curr_cd">
<input type="hidden" name="ex_rate">
<input type="hidden" name="tot_org_amt">
<input type="hidden" name="tot_dc_amt">
<input type="hidden" name="tot_bil_amt">
<input type="hidden" name="tot_tax_amt">
<input type="hidden" name="tot_payable_amt">
<input type="hidden" name="tax_rto_dis">
<!-- ETC 데이터 -->
<input type="hidden" name="cust_vat">
<input type="hidden" name="ofc_add01">
<input type="hidden" name="ofc_add02">
<input type="hidden" name="ofc_add03">
<input type="hidden" name="cust_nm">
<input type="hidden" name="address01">
<input type="hidden" name="address02">
<input type="hidden" name="address03">
<input type="hidden" name="address04">
<input type="hidden" name="header01">
<input type="hidden" name="header02">
<input type="hidden" name="header03">
<input type="hidden" name="header04">
<input type="hidden" name="header05">
<input type="hidden" name="header06">
<input type="hidden" name="header07">
<input type="hidden" name="header08">
<input type="hidden" name="header09">
<input type="hidden" name="header10">
<input type="hidden" name="sh_num">
<input type="hidden" name="hjs_ref">
<input type="hidden" name="print_date">
<input type="hidden" name="dmdt_trf_nm">

<!-- Demand Note Issue Preview - Booking -->
<!-- 부모화면 데이터 -->
<input type="hidden" name="tot_amt">
<input type="hidden" name="dc_amt">
<input type="hidden" name="inv_chg_amt">
<!-- <input type="hidden" name="tax_rto_dis"> -->
<input type="hidden" name="tax_amt">
<input type="hidden" name="inv_amt">
<!-- ETC 데이터 -->
<input type="hidden" name="sheet_remark01">
<input type="hidden" name="sheet_remark02">
<input type="hidden" name="sheet_remark03">
<input type="hidden" name="sheet_remark04">
<input type="hidden" name="sheet_remark05">
<input type="hidden" name="sheet_remark06">
<input type="hidden" name="sheet_remark07">
<input type="hidden" name="sheet_remark08">
<input type="hidden" name="sheet_remark09">
<input type="hidden" name="sheet_remark10">
<input type="hidden" name="sheet_remark11">
<input type="hidden" name="sheet_remark12">
<input type="hidden" name="sheet_remark13">
<input type="hidden" name="sheet_remark14">

<input type="hidden" name="vvd_cd">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="arr">
<input type="hidden" name="dep">
<input type="hidden" name="bl_no">
<input type="hidden" name="cmdt_cd">
<input type="hidden" name="cmdt_nm">
<input type="hidden" name="bkg_rcv_term_cd">
<input type="hidden" name="bkg_rcv_term_nm">
<input type="hidden" name="bkg_del_term_cd">
<input type="hidden" name="bkg_del_term_nm">
<input type="hidden" name="pod">
<input type="hidden" name="pod_nm">
<input type="hidden" name="del">
<input type="hidden" name="del_nm">
<input type="hidden" name="trucker">
<input type="hidden" name="vndr_seq">

<!-- rd hidden 처리 flag -->
<input type="hidden" name="bil_to_loc_div_cd">
<input type="hidden" name="cust_ref_prn_flg">
<input type="hidden" name="phn_fax_prn_flg">
<input type="hidden" name="cust_vat_prn_flg">
<input type="hidden" name="tax_amt_prn_flg">

<input type="hidden" name="dc_amt_prn_flg">
<input type="hidden" name="title">
<!-- PAYER INFO FAX,EMAIL SETTING -->
<input type="hidden" name="payr_faxnos">
<input type="hidden" name="payr_emailnos">
<!-- rd data set -->
<input type="hidden" name="rd_fxeml_sys_cd"         > <!-- DMT //-->
<input type="hidden" name="rd_fxeml_file_name"      > <!-- RD FILE NAME 파일 이름만 *.mrd //-->
<input type="hidden" name="rd_fxeml_bat_flg"        > <!-- N //-->
<input type="hidden" name="rd_fxeml_title"          > <!-- 제목 //-->
<input type="hidden" name="rd_fxeml_rd_param"       > <!-- RD REPORT PARAMETER //-->
<input type="hidden" name="rd_fxeml_fax_no"         > <!-- RECIEVER FAX NO ex) NAME:5336  //-->
<input type="hidden" name="rd_fxeml_fax_sndr_id"    > <!-- SENDER ID //-->
<input type="hidden" name="rd_fxeml_eml_sndr_nm"    > <!-- EMAIL SENDER NAME  //-->
<input type="hidden" name="rd_fxeml_eml_sndr_add"   > <!-- SENDER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_rcvr_add"   > <!-- RECIEVER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_atch_file"  > <!-- ATTACH FILE NAME //-->
<input type="hidden" name="rd_fxeml_eml_templt"     > <!-- C:/sitectx/ALPS/APP-INF/config/template/mailtemplate/ TEMPLETE FILE 메일본문 //-->
<input type="hidden" name="rd_fxeml_eml_tmplt_param"> <!-- MAILETEMPLETE PARAM ex) name;mjchang|message;DMT EMAIL SEND TEST //-->
<input type="hidden" name="rd_fxeml_doc_tp"			> <!-- DEMAND 구분 //-->	
<input type="hidden" name="invno"					> <!-- invoice no //-->		
<input type="hidden" name="payc"					> <!-- payer code //-->	
<!-- rd data set //-->

<!-- india tax-->
<input type="hidden" name="rd_usr_cnt_cd">

<!-- 인도 TAX RATIO 변경 전 필드 -->
<input type="hidden" name="rd_ida_expn_tax_rt">
<input type="hidden" name="rd_ida_expn_tax">
<input type="hidden" name="rd_ida_edu_tax_rt">
<input type="hidden" name="rd_ida_edu_tax">
<input type="hidden" name="rd_ida_high_edu_tax_rt">
<input type="hidden" name="rd_ida_high_edu_tax">
<!-- SBC ( Swacha Bharat Cess ) -->
<input type="hidden" name="rd_ida_locl_tax_rt">
<input type="hidden" name="rd_ida_locl_tax">
<!-- KCC ( Krishi Kalyan Cess ) -->
<input type="hidden" name="rd_ida_n2nd_locl_tax_rt">
<input type="hidden" name="rd_ida_n2nd_locl_tax"> 
<!-- 인도 TAX RATIO 변경 후 필드 ( 2017.07.26 ) -->
<input type="hidden" name="rd_ida_tax_appl_tm">
<input type="hidden" name="rd_ida_cgst_rto">
<input type="hidden" name="rd_ida_cgst_amt">
<input type="hidden" name="rd_ida_sgst_rto">
<input type="hidden" name="rd_ida_sgst_amt">
<input type="hidden" name="rd_ida_igst_rto">
<input type="hidden" name="rd_ida_igst_amt">
<input type="hidden" name="rd_ida_ugst_rto">
<input type="hidden" name="rd_ida_ugst_amt">
<!-- 인도 TAX 공통 -->
<input type="hidden" name="cond_ida_sac_cd">
<input type="hidden" name="rd_tax_rgst_no">
<input type="hidden" name="rd_svc_cate_rmk"> 
<input type="hidden" name="rd_pmnt_acct_no"> 
<input type="hidden" name="rd_ida_bank_acct_no">
<input type="hidden" name="rd_ida_bank_ifsc_cd">
<input type="hidden" name="rd_ida_gst_rgst_no">
<input type="hidden" name="rd_ida_ste_cd">
<input type="hidden" name="rd_ida_sac_cd">
<input type="hidden" name="rd_ida_tax_cin">
<input type="hidden" name="rd_ida_ofc_ste_cd">

<input type="hidden" name="usr_cnt_cd">
<input type="hidden" name="ida_tax_appl_tm">
<!-- Preview / Demand Print / Fax Send / Email Send 를 위해 RD 출력 전, 필요한 정보 조회시 조회결과 필드명 앞에 rd 붙일지 여부  -->
<!-- Preview 화면에서 실행된 경우에는 무조건 Y, 그렇지 않으면 무조건 N  -->
<input type="hidden" name="rd_var_nm_flg" value="Y">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Demand Note Issue Preview</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		
		<!-- RD용 : Grid  나중에 처리 후 아래에 두자.... (S) -->				
<table width="100%"  id="mainTable" style="display:none">
<!--  <table width="100%"  id="mainTable" >-->
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>		
<table width="100%"  id="mainTable2" style="display:none">
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table>			
<!-- Grid  (e) -->

	
		<!-- : ( Search Options ) (S) -->	
	
		<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->

				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td style="width:880;" height="545"  align="center">
							<script language='javascript'>comRdObject('Demand');</script>
						<td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="66">Attention<td>
						<td width="170"><input type="text" name="dmdt_payr_cntc_pnt_nm" style="width:140;" class="input2" value=""><td>
						<td width="26">Tel.<td>
						<td width="180"><input type="text" name="payr_cntc_pnt_phn_no" style="width:150;" class="input2" value=""><td>
						<td width="26">Fax<td>
						<td width="180"><input type="text" name="payr_cntc_pnt_fax_no" style="width:150;" class="input2" value=""><td>
						<td width="40">E-mail<td>
						<td width=""><input type="text" name="payr_cntc_pnt_eml" style="width:100%;" class="input2" value=""><td>
					</tr>
				</table>
				
				
					</td></tr>
				</table>
				
				<!--  biz_1  (E) -->
			<table class="height_5"><tr><td></td></tr></table>	
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
 

	

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Demand Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_fax">Fax Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_email">Email Send</td>
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
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>			
</body>
</html>