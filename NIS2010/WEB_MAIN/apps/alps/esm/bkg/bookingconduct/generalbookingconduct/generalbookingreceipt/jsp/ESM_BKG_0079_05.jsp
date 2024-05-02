<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0079_05.jsp
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.31 김병규
* 1.0 Creation
===============================================================================
* History
* 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
* 2010.11.22 최도순 [CHM-201007206] Actual customer column 보완 및 M&D 화면에 자동 DISPLAY 요청
* 2011.01.10 이일민 [CHM-201108147] EU24 관련 Country Code 및 EORI Code Validation 체크 로직
* 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
* 2012.01.16 박성호[CHM-201215684-01] BKG Customer tab Notify- Street/P.O BOx의 컬럼수제한 50자로 변경
* 2012.05.31 조정민[CHM-201218066] [BKG] FMC No 수동 입력 불가능토록 기능 보완 요청
* 2012.09.13 김기택[CHM-201219941-01] [BKG] Booking Customer 에 Country Of Origin 항목을 MAX 35 자리에서 32 자리로 변경
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg007905Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg007905Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingReceipt");
	String bkgNo = "";
	String isInquiry = "N";		
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg007905Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
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
<input type="hidden" name="isInquiry"         value="<%=isInquiry%>">
<input type="hidden" name="modify_flag" >
<input type="hidden" name="ca_flg" >
<input type="hidden" name="same_as_flag" >
<input type="hidden" name="old_bkg_no"  value="<%= bkgNo%>">
<input type="hidden" name="old_bl_no" >
<input type="hidden" name="org_bl_no" >
<input type="hidden" name="bl_tp_cd" >
<input type="hidden" name="bl_no_tp" >
<input type="hidden" name="bdr_flg" >
<input type="hidden" name="bkg_sts_cd" >
<input type="hidden" name="order_found_flag" >
<input type="hidden" name="frob_flag" >
<input type="hidden" name="ca_manifest_flag" >
<input type="hidden" name="sc_no" >
<input type="hidden" name="rfa_no" >
<input type="hidden" name="svc_scp_cd" >
<input type="hidden" name="appl_dt" >
<input type="hidden" name="sh_mdm_address" >
<input type="hidden" name="cn_mdm_address" >
<input type="hidden" name="nf_mdm_address" >
<input type="hidden" name="ff_mdm_address" >
<input type="hidden" name="an_mdm_address" >
<input type="hidden" name="sam_cnee_ntfy_flg" >
<input type="hidden" name="ca_exist_flg" >
<input type="hidden" name="nl_flag">
<input type="hidden" name="indiv_pson_flg">
<input type="hidden" name="sh_cust_cnt_cd_old">
<input type="hidden" name="sh_cust_seq_old">
<input type="hidden" name="ff_cust_cnt_cd_old">
<input type="hidden" name="ff_cust_seq_old">
<input type="hidden" name="old_act_cust_cd">
<input type="hidden" name="ob_sls_ofc_cd">
<input type="hidden" name="ob_srep_cd">
<input type="hidden" name="jp24_alert_flg">
<input type="hidden" name="aloc_sts_cd" value="">
<input type="hidden" name="de_term_cd" value="">
<input type="hidden" name="old_kr_cstms_cust_tp_cd" value="">
<input type="hidden" name="is_rated_flg" value="">
<input type="hidden" name="non_rt_sts_cd" value="">
<input type="hidden" name="kr_cstms_cust_tp_cd_use_flg" value="">
<input type="hidden" name="eml_info" value="">
<input type="hidden" name="sh_ida_gst_rgst_no" >
<input type="hidden" name="cn_ida_gst_rgst_no" >
<input type="hidden" name="nf_ida_gst_rgst_no" >
<input type="hidden" name="sh_co_chn_no" >
<input type="hidden" name="cn_co_chn_no" >
<input type="hidden" name="nf_co_chn_no" >
<!-- 개발자 작업	-->

	<!--biz page (S)-->
	<table class="search"  style="width:979"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">BKG  No.</td>
					<td width="180"><input type="text" name="bkg_no" maxlength=13 style="width:115;" class="input" value="" style="ime-mode:disabled"  dataformat="engupnum" tabindex=1>
											<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop"></td>
					<td width="50">B/L No.</td>
					<td width="120"><input type="text" name="bl_no" maxlength=13 style="width:115;" class="input" style="ime-mode:disabled"  dataformat="engupnum"   tabindex=2></td>
					<td width="45"><div style="display:none"  id="org_bl"><img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_OrgBlPop"></div></td>
					<td width="40">Route</td>
					<td width="225"><input type="text" name="por_cd" style="width:48;" class="input2" value="" readonly>&nbsp;<input type="text" name="pol_cd" style="width:48;" class="input2" value="" readolny>&nbsp;<input type="text" name="pod_cd" style="width:48;" class="input2" value="" readonly>&nbsp;<input type="text" name="del_cd" style="width:48;" class="input2" value="" readonly></td>
					<td width="65">A/Customer</td>
					<td width="130"><input type="text" name="agmt_act_cnt_cd" style="width:23;" class="input" value=""  maxlength=2 dataformat="engup" readOnly>&nbsp;<input type="text" name="agmt_act_cust_seq" style="width:50;" class="input" value="" maxlength=6 dataformat="int" readOnly>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Sa0190"  id="btn_t7Sa0190">&nbsp;<input type="text" name=act_cust_list_exist_flg style="width:23;text-align:center;" class="input2" value="" readonly></td>
					<td><table width="90%" border="0" cellpadding="0" cellspacing="0" class="button" id = "del_btn">
						<tr><td class="btn2_left"></td><td class="btn2_3" name="btn_t7Delete"  id="btn_t7Delete">Del</td><td class="btn2_right"></td></tr></table></td>
				</tr>
			</table>
				
				<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480">
						<table class="search" border="0" style="width:480;">
							<tr class="h23" width="100%">
				 				<td width="73">Shipper</td>
								<td><input type="text" name="sh_cust_cnt_cd" style="width:25;" class="input1" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=11>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Sh0192" id="btn_t7Sh0192">&nbsp;<input type="text" name="sh_cust_seq" style="width:58;" class="input1" value="" maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=12>&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7ShMdmCustNm" id="btn_t7ShMdmCustNm">&nbsp;<input type="text" name="sh_cust_lgl_eng_nm" style="width:120;" class="input2" value="" readonly>&nbsp;<input type="text" style="width:25;" class="input2" value="" readonly name="sh_cust_tp">&nbsp;<script language="javascript" >ComComboObject('kr_cstms_cust_tp_cd', 2, 90, 1, 0, 2)</script></td>
							</tr>
						</table>
						<table class="search_sm2" border="0" style="width:480;"> 
							<tr class="h23">
								<td>		
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="68" class="stm">Name</td>
											<td><textarea  cols="35" rows="2" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img2" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('2','35',this, 'Shipper');" class="textarea1" name="sh_cust_nm" tabindex=13></textarea></td>
										</tr>
										<tr class="h23">
											<td width="" class="stm">Address<br>Print<input type="checkbox" class="trans" name="sh_addr_prn_flg" value="Y"></td>
											<td width=""colspan="6"><textarea cols="35" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('3','35',this, 'Shipper');" wrap="hard"  class="textarea1" name="sh_cust_addr" tabindex=14></textarea></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;">						
										<tr class="h23">
											<td width="65" class="stm">City / State</td>
											<td width="170" style="padding-left:1"><input type="text" name="sh_cust_cty_nm" style="width:125;" class="input" value="" tabindex=15 dataformat="etc" maxlength=30 style="ime-mode:disabled" >&nbsp;<input type="text"  name="sh_cust_ste_cd" style="width:30;" class="input" value="" tabindex=16 maxlength=2 style="ime-mode:disabled"  dataformat="engupnum"></td>
											<td width="50" class="stm">Country</td>
											<td width="40"><input type="text"  name="sh_cstms_decl_cnt_cd" style="width:30;" class="input" value="" tabindex=17 maxlength=2 style="ime-mode:disabled"  dataformat="engup"></td>
											<td width="50" class="stm">ZIP Code</td>
											<td width=""><input type="text"  name="sh_cust_zip_id" style="width:74;" class="input" value="" tabindex=18 dataformat="zipcode" maxlength=10 style="ime-mode:disabled" >&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7ShZipCode"  id="btn_t7ShZipCode"></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="60" class="stm">Street /<br>P.O.Box</td>
											<td width="160" style="padding-left:1"><input type="text" name="sh_eur_cstms_st_nm" style="width:150;" class="input" value="" tabindex=19 dataformat="etc" maxlength=50 style="ime-mode:disabled" ></td>
											<td width="75" class="stm" id="sh_jpt_gst_man">JAPAN Tel#/GST No</td>
											<td width="138"><input type="text"  name="sh_eori_no" style="width:138;" class="input" value="" tabindex=20 maxlength=20 style="ime-mode:disabled"  dataformat="eoriengupnum"></td>
										</tr>
									</table>
									<!-- 2018.05.10 : 중국 해관 56호령 관련 컬럼 추가 (S) -->
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="70" class="stm">Fax</td>
											<td width="160" style="padding-left:1"><input type="text" name="sh_cust_fax_no" style="width:137;" class="input" value="" maxlength=50 tabindex=19></td>
											<td width="75" class="stm" id="sh_jpt_gst_man">E-mail</td>
											<td width=""><input type="text" name="sh_cust_eml" style="width:185;" class="input" value="" tabindex=20></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="65" class="stm">Tel</td>
											<td width="" style="padding-left:1"><input type="text" name="sh_cust_phn_no" style="width:137;" class="input" value="" maxlength=50 tabindex=19></td>
										</tr>
									</table>
									<!-- 2018.05.10 : 중국 해관 56호령 관련 컬럼 추가 (E) -->
								</td>
							</tr>
						</table>									
						
						<table class="height_8"><tr><td></td></tr></table>
						
						<table class="search" border="0" style="width:480;">
							<tr class="h23"width="100%">
					 			<td width="73">Consignee</td>
								<td class="stm"><input type="text" name="cn_cust_cnt_cd" style="width:25;" class="input1" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=21>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Cn0192" id="btn_t7Cn0192">&nbsp;<input type="text"  name="cn_cust_seq" style="width:58;" class="input1" value="" maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=22>&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7CnMdmCustNm" id="btn_t7CnMdmCustNm">&nbsp;<input type="text" name="cn_cust_lgl_eng_nm" style="width:120;" class="input2" value="" readonly>&nbsp;<input type="text" style="width:25;" class="input2" value="" readonly name="cn_cust_tp">&nbsp;B/L Type&nbsp;<select style="width:60;" class="input" name="cust_to_ord_flg"><option value="Y">Order</option><option value="N">Straight</option></select></td>
							</tr>
						</table>						
						<table class="search_sm2" border="0" style="width:480;"> 
							<tr class="h23">
								<td>								
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="68" class="stm">Name</td>
											<td ><textarea  cols="35" rows="2" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img2" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('2','35',this, 'Consignee');" wrap="hard"  name="cn_cust_nm" tabindex=23></textarea></td>
										</tr>
										<tr class="h23">
											<td width="" class="stm">Address<br>Print<input type="checkbox" class="trans" name="cn_addr_prn_flg" value="Y"></td>
											<td width=""><textarea cols="35" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('3','35',this, 'Consignee');" wrap="hard"  name="cn_cust_addr" tabindex=24></textarea></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="65" class="stm">City / State</td>
											<td width="170" style="padding-left:1"><input type="text" name="cn_cust_cty_nm" style="width:125;" class="input" value="" tabindex=27 dataformat="etc" maxlength=30 style="ime-mode:disabled" >&nbsp;<input type="text" name="cn_cust_ste_cd" style="width:30;" class="input" value="" tabindex=28 maxlength=2 style="ime-mode:disabled"  dataformat="engup"></td>
											<td width="50" class="stm">Country</td>
											<td width="40"><input type="text" name="cn_cstms_decl_cnt_cd" style="width:30;" class="input" value="" tabindex=29 maxlength=2 style="ime-mode:disabled"  dataformat="engup"></td>
											<td width="50" class="stm">ZIP Code</td>
											<td width=""><input type="text" name="cn_cust_zip_id" style="width:74;" class="input" value="" tabindex=30 dataformat="zipcode" maxlength=10 style="ime-mode:disabled" >&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7CnZipCode"  id="btn_t7CnZipCode"></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="65" class="stm">Street /<br>P.O.Box</td>
											<td width="" style="padding-left:1"><input type="text" name="cn_eur_cstms_st_nm" style="width:137;" class="input" value="" tabindex=31 dataformat="etc" maxlength=50 style="ime-mode:disabled" ></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="65" class="stm" id="cn_jpt_gst_man">JAPAN Tel#/GST No</td>
											<td>
												<select name="cn_co_chn_tp_cd" style="display:none;">
													<option value="U">USCI Code</option>
													<option value="O">Org. Code</option>
													<option value="B">Business License No</option>
												</select>
											</td>
											<td width=""><input type="text"  name="cn_eori_no" style="width:138;" class="input" value="" tabindex=32 maxlength=20 style="ime-mode:disabled"  dataformat="eoriengupnum"></td>
										</tr>
									</table>		
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="65" class="stm">IEC/Fax</td>
											<td width="150" style="padding-left:1"><input type="text" name="cn_cust_fax_no" style="width:137;" class="input" value="" maxlength=20 tabindex=25></td>
											<td width="50" class="stm">E-mail</td>
											<td width=""><input type="text" name="cn_cust_eml" style="width:185;" class="input" value="" tabindex=26></td>
										</tr>
									</table>
									<!-- 2018.05.10 : 중국 해관 56호령 관련 컬럼 추가 (S) -->
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="65" class="stm">Tel</td>
											<td width="" style="padding-left:1"><input type="text" name="cn_cust_phn_no" style="width:137;" class="input" value="" maxlength=20 tabindex=25></td>
										</tr>
									</table>
									<!-- 2018.05.10 : 중국 해관 56호령 관련 컬럼 추가 (E) -->
								</td>
							</tr>
						</table>
						
						
						<table class="height_8"><tr><td></td></tr></table>
						
						<table class="search" border="0" style="width:480;">
							<tr class="h23"width="100%">
					 			<td width="73">Notify</td>  
								<td><input type="text" style="width:25;" class="input" value="" name="nf_cust_cnt_cd" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=41>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Nf0192" id="btn_t7Nf0192">&nbsp;<input type="text" style="width:58;" class="input" value="" name="nf_cust_seq"  maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=42>&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7NfMdmCustNm" id="btn_t7NfMdmCustNm">&nbsp;<input type="text" style="width:120;" class="input2" value="" name="nf_cust_lgl_eng_nm"  readonly>&nbsp;<input type="text" style="width:25;" class="input2" value="" readonly name="nf_cust_tp"></td>
							</tr>
						</table>
						
						<table class="search_sm2" border="0" style="width:480;"> 
							<tr class="h23">
								<td>								
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="68" class="stm">Name</td>
											<td ><textarea  cols="35" rows="2" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img2" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('2','35',this, 'Notify');" wrap="hard"  name="nf_cust_nm" tabindex=43></textarea></td>
										</tr>
										<tr class="h23">
											<td width="" class="stm">Address<br>Print<input type="checkbox" class="trans" name="nf_addr_prn_flg" value="Y"><br>Same as<br>CNEE<input type="checkbox" value=""class="trans" name="sam_cnee_copy_flg" value="Y"></td>
											<td width=""><textarea cols="35" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('3','35',this, 'Notify');" wrap="hard"  name="nf_cust_addr" tabindex=44></textarea></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="65" class="stm">City / State</td>
											<td width="170" style="padding-left:1"><input type="text" style="width:125;" class="input" value="" name="nf_cust_cty_nm" tabindex=47 dataformat="etc" maxlength=30 style="ime-mode:disabled"  >&nbsp;<input type="text" style="width:30;" class="input" value="" name="nf_cust_ste_cd" tabindex=48 maxlength=2 style="ime-mode:disabled"  dataformat="engup"></td>
											<td width="50" class="stm">Country</td>
											<td width="40"><input type="text" style="width:30;" class="input" value="" name="nf_cstms_decl_cnt_cd" tabindex=49 maxlength=2 style="ime-mode:disabled"  dataformat="engup"></td>
											<td width="50" class="stm">ZIP Code</td>
											<td width=""><input type="text" style="width:74;" class="input" value="" name="nf_cust_zip_id" tabindex=50 dataformat="zipcode" maxlength=10 style="ime-mode:disabled" >&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7NfZipCode"  id="btn_t7NfZipCode"></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="65" class="stm">Street /<br>P.O.Box</td>
											<td width="" style="padding-left:1"><input type="text" name="nf_eur_cstms_st_nm" style="width:137;" class="input" value="" tabindex=51 dataformat="etc" maxlength=50 style="ime-mode:disabled" ></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:480;"> 
										<tr class="h23">
											<td width="65" class="stm" id="nf_jpt_gst_man">JAPAN Tel#/GST No</td>
											<td>
												<select name="nf_co_chn_tp_cd" style="display:none;">
													<option value="U">USCI Code</option>
													<option value="O">Org. Code</option>
													<option value="B">Business License No</option>
												</select>
											</td>
											<td width=""><input type="text"  name="nf_eori_no" style="width:138;" class="input" value="" tabindex=52 maxlength=20 style="ime-mode:disabled"  dataformat="eoriengupnum"></td>
										</tr>
									</table>		
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="65" class="stm">Fax</td>
											<td width="150" style="padding-left:1"><input type="text" style="width:137;" class="input" value="" name="nf_cust_fax_no"  maxlength=20 tabindex=45></td>
											<td width="50" class="stm">E-mail</td>
											<td width=""><input type="text" style="width:185;" class="input" value="" name="nf_cust_eml" tabindex=46></td>
										</tr>
									</table>
									<!-- 2018.05.10 : 중국 해관 56호령 관련 컬럼 추가 (S) -->
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="65" class="stm">Tel</td>
											<td width="" style="padding-left:1"><input type="text" style="width:137;" class="input" value="" name="nf_cust_phn_no"  maxlength=20 tabindex=45></td>
										</tr>
									</table>
									<!-- 2018.05.10 : 중국 해관 56호령 관련 컬럼 추가 (E) -->
								</td>
							</tr>
						</table>	
					</td>
					<td width="19">&nbsp;</td>
					<td width="480" valign="top">
					
						<table class="search" border="0" style="width:480;">
							<tr class="h23" width="100%">
					 			<td width="73">F/Forwarder</td>
								<td class="stm"><input type="text" style="width:25;" class="input" value="" name="ff_cust_cnt_cd" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=61>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Ff0192" id="btn_t7Ff0192">&nbsp;<input type="text" style="width:58;" class="input" value="" name="ff_cust_seq"  maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=62>&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7FfMdmCustNm"  id="btn_t7FfMdmCustNm">&nbsp;<input type="text" style="width:100;" class="input2" value="" name="ff_cust_lgl_eng_nm"  readonly>&nbsp;<input type="text" style="width:20;" class="input2" value="" readonly name="ff_cust_tp">&nbsp;&nbsp;&nbsp;FMC No.<input type="text" name="fmc_cd" style="width:65;" class="input2" value="" tabindex=63 readOnly ></td>
							</tr>
						</table>
						
						<table class="search_sm2" border="0" style="width:480;"> 
							<tr class="h23">
								<td>
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="68" class="stm">Name &amp;<br>Address<br>Print<input type="checkbox" class="trans" name="ff_addr_prn_flg" value="Y"></td>
											<td><textarea cols="35" rows="5" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img5" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('5','35',this, 'F/Forwarder');" wrap="hard"  name="ff_cust_nm" tabindex=64></textarea></td>
										</tr>
									</table>
									<table class="search_sm2" border="0" style="width:460;">
										<tr><td height="42"></td></tr>
									</table>				
								</td>
							</tr>
						</table>						
						
						<table class="height_8"><tr><td></td></tr></table>
						
						<table class="search" border="0" style="width:480;">
						<tr class="h23"width="100%">
				 			<td width="73">A/Notify</td>
							<td><input type="text" style="width:25;" class="input" value="" name="an_cust_cnt_cd" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=71>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7An0192" id="btn_t7An0192">&nbsp;<input type="text" style="width:58;" class="input" value="" name="an_cust_seq"  maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=72>&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7AnMdmCustNm" id="btn_t7AnMdmCustNm">&nbsp;<input type="text" style="width:120;" class="input2" value="" name="an_cust_lgl_eng_nm"  readonly>&nbsp;<input type="text" style="width:25;" class="input2" value="" readonly name="an_cust_tp"></td></tr>
						</table>						
						<table class="search_sm2" border="0" style="width:480;"> 
							<tr class="h23">
								<td>								
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="68" class="stm">Name &amp;<br>Address<br>Print<input type="checkbox" class="trans" name="an_addr_prn_flg" value="Y"></td>
											<td><textarea cols="35" rows="5" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img5" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('5','35',this, 'A/Notify');" wrap="hard" name="an_cust_nm" tabindex=73></textarea></td>
										</tr>
									</table>									
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="65" class="stm">Fax</td>
											<td width="150" style="padding-left:1"><input type="text" style="width:137;" class="input" value="" name="an_cust_fax_no" maxlength=20 tabindex=74></td>
											<td width="50" class="stm">E-mail</td>
											<td width=""><input type="text" style="width:189;" class="input" value="" name="an_cust_eml" tabindex=75></td>
										</tr>
									</table>					
									<table class="search_sm2" border="0" style="width:460;">
										<tr><td height="42"></td></tr>
									</table>				
							</td></tr>
						</table>
						
						
						<table class="height_8"><tr><td></td></tr></table>
						
						<table class="search" border="0" style="width:480;">
							<tr class="h23"width="100%">
					 			<td width="273">Export Ref./Actual customer name</td>
								<td></td>
							</tr>
						</table>						
						<table class="search_sm2" border="0" style="width:480;"> 
							<tr class="h23">
								<td>								
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="68" class="stm" valign="top">Print<input type="checkbox" class="trans"  name="ex_addr_prn_flg" value="Y" tabindex=81></td>
											<td><textarea cols="35" rows="3" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical" dataformat="etc" onBlur="javascript:validateCols('3','35',this, 'Export Ref.');" wrap="hard"  name="ex_cust_nm" tabindex=82></textarea></td>
										</tr>
									</table>									
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="120" class="stm">Forwarder's Ref. No.</td>
											<td width="137"><input type="text" style="width:100;" class="input" value="" name="ff_ref_no" tabindex=83>&nbsp;<img class="cursor" src="img/btns_plus.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7FwRefNo" id="btn_t7FwRefNo"></td>
											<td width="60" class="stm">EDI Ref.</td>
											<td width=""><input type="text" style="width:30;" class="input" value="" name="ex_cust_cnt_cd" maxlength=2 style="ime-mode:disabled"  dataformat="engup" tabindex=84>&nbsp;<input type="text" style="width:58;" class="input" value="" name="ex_cust_seq"   maxlength=6 style="ime-mode:disabled"  dataformat="int" tabindex=85>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_t7Ex0192"  id="btn_t7Ex0192"></td>
										</tr>
									</table>									
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="120" class="stm">Country of Origin</td>
											<td width=""> <input type="text" style="width:313;" class="input" value="" name="org_cnt_nm"  dataformat="etc" tabindex=86 maxlength=32 style="ime-mode:disabled"  ></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:460;">
										<tr><td height="15"></td></tr>
									</table>		
									<table class="search" border="0" style="width:460;"> 
										<tr class="h23">
											<td width="65" class="stm">End User</td>
											<td><textarea cols="35" rows="2" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-x:hidden" class="textarea_img3" wrap="physical" dataformat="etc" wrap="hard"  name="end_usr_nm" tabindex=82></textarea></td>
										</tr>
									</table>							
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>	 
				<!--Button (S) -->
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t7Retrieve"  id="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t7New" id="btn_t7New">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t7Save" id="btn_t7Save">Save</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_t7CustomerCodeRqst">CUSTOMER CODE RQST</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>				
					</tr>
				</table>
			</td></tr>
		</table>
    <!--Button (E) -->
<div id="orgBlNo" style="position:absolute;left:0;top:0;width:0;height:0;"></div> 	 		    
<table width="50%"  id="mainTable">
	<tr>
		<td width="50%">
			<script language="javascript">ComSheetObject('t7sheet1');</script>
		</td>
	</tr>
</table>			
<div style="display:none">
	<script language="javascript">ComSheetObject('bkgChgOfcSheet');</script>
</div>
			
	<!--biz 2page (E)-->

<!-- 개발자 작업  끝 -->
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"/>
</form>
</body>
</html>