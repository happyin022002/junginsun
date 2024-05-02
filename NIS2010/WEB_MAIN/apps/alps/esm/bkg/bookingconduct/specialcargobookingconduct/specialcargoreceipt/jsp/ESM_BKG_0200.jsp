<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0200.jsp
*@FileTitle : Dangerous cargo application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.08 이병규
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.10.14 변종건 [CHM-201113595-01] US Rail DG bkg에 대한 warning msg 요청 - DG Cargo Validation Check 추가
 2011.10.21 변종건 [CHM-201113466-01] DG Cargo Application 기능 보완 요청
 2011.12.20 변종건 [CHM-201114816-01] 위험물  입력 관련 로직 변경 추가 요청 검토(추가 요청 사항)
 2012.01.12 변종건 [CHM-201215424-01] Booking DG Application Cargo 필수입력 조건 변경 요청
 2013.11.01 김보배 [CHM-201326836] [dg cargo application] E-MAIL 주소 입력 컬럼 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0200Event"%>
<%@ page import="m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>

<%
	EsmBkg0200Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String bkgNo = "";
	String screenName = "";
	
	String isInquiry = "N";	
	Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	//inquiry mode
	if (screen.getName().indexOf("Q") >= 0){
		isInquiry = "Y";
	} else {
		isInquiry = "N";			
	}
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0200Event)request.getAttribute("Event");
		bkgNo = event.getBkgNo();
		
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
<title>Dangerous Cargo Application</title>
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
									
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">										
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="dg_cntr_seq">
<input type="hidden" name="temp_cntr_no">
<input type="hidden" name="cntr_no">
<input type="hidden" name="cntr_tpsz_cd">

<input type="hidden" name="in_imdg_pck_cd1">
<input type="hidden" name="in_imdg_pck_cd2">
<input type="hidden" name="intmd_imdg_pck_cd1">
<input type="hidden" name="intmd_imdg_pck_cd2">
<input type="hidden" name="out_imdg_pck_cd1">
<input type="hidden" name="out_imdg_pck_cd2">
<input type="hidden" name="in_imdg_pck_desc1">
<input type="hidden" name="in_imdg_pck_desc2">
<input type="hidden" name="intmd_imdg_pck_desc1">
<input type="hidden" name="intmd_imdg_pck_desc2">
<input type="hidden" name="out_imdg_pck_desc1">
<input type="hidden" name="out_imdg_pck_desc2">

<input type="hidden" name="in_imdg_pck_qty1">
<input type="hidden" name="in_imdg_pck_qty2">
<input type="hidden" name="intmd_imdg_pck_qty1">
<input type="hidden" name="intmd_imdg_pck_qty2">
<input type="hidden" name="out_imdg_pck_qty1">
<input type="hidden" name="out_imdg_pck_qty2">
<input type="hidden" name="max_in_pck_qty">
<input type="hidden" name="max_in_pck_tp_cd">

<input type="hidden" name="hcdg_intmd_bc_rstr_desc">
<input type="hidden" name="hcdg_pck_rstr_desc">
<input type="hidden" name="hcdg_tnk_rstr_desc">
<input type="hidden" name="ltd_qty">
<input type="hidden" name="imdg_expt_qty_cd">

<input type="hidden" name="ems_no">
<input type="hidden" name="emer_rspn_gid_no" maxlength="3">
<input type="hidden" name="emer_rspn_gid_chr_no">
<input type="hidden" name="ctrl_temp_ctnt">
<input type="hidden" name="emer_temp_ctnt">
<input type="hidden" name="title_id" value="dg">
<input type="hidden" name="button" value="N">
<input type="hidden" name="diff_rmk" >

<input type="hidden" name="clod_flg" >
<input type="hidden" name="rc_flg" >
<input type="hidden" name="awk_cgo_flg" >
<input type="hidden" name="bb_cgo_flg" >
<input type="hidden" name="hcdg_flg" >
<input type="hidden" name="meas_qty" >
<input type="hidden" name="hcdg_dpnd_qty_flg" >
<input type="hidden" name="spcl_rqst_flg" >
<!-- <input type="hidden" name="imdg_un_no_seq" > -->

<input type="hidden" name="temp_grs_wgt">
<input type="hidden" name="temp_net_wgt">
<input type="hidden" name="crr_cd">
<input type="hidden" name="dcgo_seq">
<input type="hidden" name="slan_cd">
<input type="hidden" name="vessel_nm">

<input type="hidden" name="isInquiry" value="<%=isInquiry%>">

<input type="hidden" name="del_cd">
<input type="hidden" name="spcl_provi_no">
<input type="hidden" name="dest_trns_mod_cd">
<input type="hidden" name="hzd_combo_disable_flg">
<input type="hidden" name="dflt_segr_grp_nm">
<input type="hidden" name="grs_capa_qty">
<input type="hidden" name="irregular_list">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>	

		<!--biz page-1 (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">BKG No.</td>
					<td width="140"><input name="bkg_no" type="text" style="width:96;" class="input" value="<%=bkgNo%>" maxlength="13">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
					</td>
					<td width="50">B/L No.</td>
					<td width="125"><input type="text" name="bl_no" style="width:113;" class="input" value=""></td> 
					<td width="125">Requested By/Date</td>
					<td width="220"><input name="rqst_usr_id" type="text" style="width:90;" class="input2" value="" readonly>&nbsp;<input name="rqst_dt" type="text" style="width:115;" class="input2" value="" readonly></td>
					<td width="160" class="sm"><input name="rqst_gdt" type="text" style="width:115;" class="input2" value="" readonly> (GMT)</td>
				<td width="60">Approval</td>
					<td><input name="spcl_cgo_auth_cd" type="text" style="width:20;" class="input2_1" value="" readonly>&nbsp;<img name="btn_approval" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="50">T/VVD</td>
					<td width="140"><input name="vsl_cd" type="text" style="width:120;" class="input2" value="" readonly></td>
					<td width="30">POL</td>
					<td width="100"><input name="pol_cd" type="text" style="width:50;" class="input2" value="" readonly>&nbsp;<input name="pol_nod_cd" type="text" style="width:30;" class="input2" value="" readonly></td>
					<td width="30">POD</td>
					<td width="90"><input name="pod_cd" type="text" style="width:50;" class="input2" value="" readonly>&nbsp;<input name="pod_nod_cd"type="text" style="width:30;" class="input2" value="" readonly></td>
					<td width="107"><table width="105" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="ts_route_vvd_btn">Route Detail</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>								
					<td width=""><table width="160" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="pre_checking_reports_btn">Pre Checking Reports</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
			
		<table class="height_8"><tr><td colspan="8"></td></tr></table>
		<!--biz page-1 (E)-->
	
	
	
		<!-- biz 2,3 - frame (S) -->
		<table class="search"> 
       	<tr><td width="240" style="padding-right:10px;">
	


				<!-- biz_2-1  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table> 
						<!-- biz_2-1 (E) -->
						
						<table class="height_8"><tr><td></td></tr></table>
						
						<!-- biz_2-2  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table> 
						<!-- biz_2-2 (E) -->
						
							<table width="0"  id="mainTable"> 
								<tr>
									<td width="0">
										<script language="javascript">ComSheetObject('sheet3');</script>
									</td>
								</tr>
							</table> 

							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet4');</script>
									</td>
								</tr>
							</table> 
							
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet5');</script>
									</td>
								</tr>
							</table> 
							
							<table width="0"  id="mainTable"> 
								<tr>
									<td width="0">
										<script language="javascript">ComSheetObject('sheet6');</script>
									</td>
								</tr>
							</table> 

						<!--  Button_Sub (S) -->
						<table width="240" class="button"> 
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="row_add">Row Add</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="row_delete">Row Delete</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_copy1">Copy</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
										
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
						
						
					
				<!-- biz 2 - frame (E) -->
	
			</td>
		
		
			<td valign="top">
		
				<!-- biz 4 - frame (S) -->
						<!--  biz_4  (S) -->
						<table class="search" border="0" style="width:729;"> 
						<tr class="h23">
							<td width="100">Cargo Seq.</td>
							<td width="100" class="stm"><input name="cntr_cgo_seq_sum" type="text" style="width:30;" class="input2" value="" readOnly>&nbsp;<select id="cntr_cgo_seq" name="cntr_cgo_seq" style="width:40;" class="input1"></select></td><td width="70" id="approved"></td>
							<td width="160"></td>
							<td width="125" align="right"><table width="125" border="0" cellpadding="0" cellspacing="0" class="button"><tr><td class="btn2_left"></td><td class="btn2" name="un_information_btn">UN Information</td><td class="btn2_right"></td></tr></table></td>
							<td width="95"><table width="95" border="0" cellpadding="0" cellspacing="0" class="button"><tr><td class="btn2_left"></td><td class="btn2" name="restrictions_btn">Restrictions</td><td class="btn2_right"></td></tr></table></td>
							<td width="120"><table width="120" border="0" cellpadding="0" cellspacing="0" class="button"><tr><td class="btn2_left"></td><td class="btn2" name="srch_irregulars_list" id="srch_irregulars_list">Irregulars List</td><td class="btn2_right"></td></tr></table></td>
							<td 125><table width="125" border="0" cellpadding="0" cellspacing="0" class="button"><tr><td class="btn2_left"></td><td class="btn2" name="pkg_qty_type" style="color:red;">PKG Q'ty / Type</td><td class="btn2_right"></td></tr></table></td>
						
							</tr>
						</table>
						
						<table class="search" border="0" style="width:729;"> 
						<tr class="h23">
							<td width="45">UN No.</td>
							<td width="100"><input name="imdg_un_no" type="text" style="width:40;" class="input1" value="" maxlength="4" id="imdg_un_no">&nbsp;<input name="imdg_un_no_seq" type="text" style="width:20;" class="input2" value="" readonly>&nbsp;<img name="imdg_class_button" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<td width="82">IMDG Class</td>
							<td width="70"><input name="imdg_clss_cd" type="text" style="width:29;" class="input1" value="" maxlength="3" readonly>&nbsp;<input name="imdg_comp_grp_cd" type="text" style="width:20;" class="input2" value="" maxlength="1" readonly></td>
							
							<td width="90">Gross Weight</td>
							<td width="157"><input name="grs_wgt" type="text" style="width:90; text-align:right;" class="input1" value="" dataformat="float" pointcount="3" maxlength="11">&nbsp;<input type="text" style="width:36;" class="input2" value=" KGS" readonly></td> 
							<td width="75">Net Weight</td>
							<td width=""><input name="net_wgt" type="text" style="width:90; text-align:right;" class="input1" value="" dataformat="float" pointcount="3" maxlength="11">&nbsp;<input type="text" style="width:36;" class="input2" value=" KGS" readonly></td>
							</tr>
						</table>
						
						<table class="search" border="0" style="width:729;"> 
						<tr class="h23">
							<td width="150">Proper Shipping Name</td>
							<td colspan="3"><input name="prp_shp_nm" type="text" style="width:100%;" class="input1" value=""></td></tr>
						<tr class="h23">
							<td>Hazardous Contents</td>
							<td><input name="hzd_desc" type="text" style="width:280;" class="input1" value=""></td>
							<td>Segregation Group</td>
							<td><script language="javascript">ComComboObject('hzd_ctnt', 1, 180, 1);</script></td>
						</tr>
						</table>
						
						<table class="search" border="0" style="width:729;"> 
						<tr class="h23">
							<td width="68">Flash Point</td>
							<td width="100"><input name="flsh_pnt_cdo_temp" type="text" style="width:50; text-align:right;" class="input" value="">&nbsp;<input type="text" style="width:22;" class="input" value="&ordm;C" readonly></td>
							<td width="93">Packing Group</td>
							<td width="90"><select name="imdg_pck_grp_cd" style="width:60;" class="input1"><option value=""></option>
							<option value="1">I</option>
							<option value="2" >II</option>
							<option value="3" >III</option></select></td>
							<td width="75">PSA Group</td>
							<td width="120"><input name="psa_no" type="text" style="width:40;" class="input2" value="" readonly>&nbsp;</td>
							<td width="87">Limited Q'ty</td>
							<td><select style="width:40;" name="imdg_lmt_qty_flg" class="input1"><option value=""></option><option value="Y">Y</option><option value="N">N</option></select>&nbsp;&nbsp;&nbsp;&nbsp;<input name="hcdg_flag" type="text" style="width:43;"  class="input2_1" value="" readOnly></td>
						</tr>
						</table>
						
						<table class="search" border="0" style="width:729;"> 
						<tr class="h23">
							<td width="68">Sub Label</td>
							<td width="160"><input name="imdg_subs_rsk_lbl_cd1" type="text" style="width:30;" class="input" value="">&nbsp;<input name="imdg_subs_rsk_lbl_cd2" type="text" style="width:30;" class="input" value="">&nbsp;<input name="imdg_subs_rsk_lbl_cd3" type="text" style="width:30;" class="input" value="">&nbsp;<input name="imdg_subs_rsk_lbl_cd4" type="text" style="width:30;" class="input" value=""></td>
							<td width="90">Cargo Status</td>
							<td width="90"><select name="dcgo_sts_cd" style="width:60;" class="input1"><option value=""></option>
							<option value="L">Liquid</option>
							<option value="G" >GAS</option>
							<option value="P" >PASTE</option>
							<option value="S" >SOLID</option></select></td>
							<td width="118">Marine Pollutant</td>
							<td width="85"><select name="mrn_polut_flg" style="width:40;" class="input1"><option value="Y">Y</option><option value="N" >N</option>							
							</select></td>
							<td width="89">Excepted Q'ty</td>
							<td><select name="imdg_expt_qty_flg" style="width:40;"><option value=""></option><option value="Y">Y</option><option value="N">N</option></select></td>
						</tr>
						</table>
							
						<table class="search" border="0" style="width:729;"> 
						<tr class="h23">
							<td width=170>Emergency Contact(TEL)</td>
							<td width="268"><input name="emer_cntc_phn_no_ctnt" type="text" style="width:200;" class="input1" value=""></td>
							<td width="130">Certificate Number</td>
							<td width="200"><input name="certi_no" type="text" style="width:100%;" class="input" value="" maxlength="15"></td>
						</tr>
						<tr class="h23">
							<td width="">Contact Person(Name)</td>
							<td width=""><input name="emer_cntc_pson_nm" type="text" style="width:200;" class="input1" value=""></td>
							<td colspan="2"><table width="220" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_emer_info">Other Emergency Information</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
						</tr>
						<tr class="h23">
							<td width="">Internal E-mail 1</td>
							<td width=""><input name="dcgo_rqst_grp_eml1" type="text" style="width:200;" class="input" value=""></td>
							<td width="">Internal E-mail 2</td>
							<td width=""><input name="dcgo_rqst_grp_eml2" type="text" style="width:200;" class="input" value=""></td>
						</tr>
						</table>
						
						<table class="search" border="0" style="width:729;"> 
						<tr class="h23">
						<td width="420">
						<!-- Tab (S) -->

						<table class="tab" border="0" cellpadding="0" cellspacing="0" width="420"> 
						<tr><td width="420">
						<script language="javascript">ComTabObject('tab1')</script>
						</td></tr>
						</table>

						<!-- Tab (E) -->
						</td>
						
						</tr>
						</table>
						<!-- Class 1 Only (S) -->
						<table border="0">
							<tr>
								<td width="450">
									<div id="tabLayer" style="display:inline">
			
										<table border="0" style="width:420; background-color:white;" class="grid2"> 
										<tr><td width="25%" class="tr2_head" rowspan="2">Class 1 Only</td>
											<td width="34%" class="tr2_head">Consignee Detail</td> 
											<td width="%"><input name="cnee_dtl_desc" type="text" style="width:100%; text-align:left;" class="noinput" value=""></td></tr>
										<tr><td class="tr2_head">Net Explosive Weight</td> 
											<td><input name="net_explo_wgt" type="text" style="width:75%; text-align:right;" class="noinput" value="" maxlength="8">&nbsp;<input type="text" style="width:20%;" class="noinput" value="KGS"></td></tr>
										</table>	
										<table class="search" height=25><tr><td></td></tr></table><!-- adjust the value of a height for the height on the left table (tab1) -->
									
			
									</div>
			
									<!-- Class 1 Only (E) -->
	
	
	
	
									<!-- Class 7 Only (S) -->
									<div id="tabLayer" style="display:none">
			
										<table border="0" style="width:420; background-color:white;" class="grid2"> 
										<tr><td width="15%" class="tr2_head" rowspan="3">Class 7 <br>Only</td>
											<td class="tr2_head" colspan="5">Radio Active Commodities</td></tr>
										<tr><td width="20%" class="tr2_head">Schedule</td> 
											<td width="15%" align="center"><input type="text" name="rada_skd_no" style="border:0;" value=""></td>
											<td width="20%" class="tr2_head">Activity</td>
											<td width="20%"><input name="rada_amt" type="text" style="width:60%; text-align:right;" class="noinput" value="" maxlength="8"></td>
											<td><select name="rada_ut_cd" style="width:60;">
											<option value=""></option>
											<option value="MBQ">MBQ</option>
											<option value="NBQ" >NBQ</option>
											<option value="GBQ" >GBQ</option>
											<option value="TBQ" >TBQ</option></select></td></tr>
										<tr><td class="tr2_head" colspan="2"> Transportation Index</td> 
											<td align="right"><input type="text" name="rada_trsp_no" style="width:100%; text-align:center;" class="noinput" value="" maxlength="5"></td>
											<td colspan="2"></td></tr>
										</table>						
										<table class="search" height=3><tr><td></td></tr></table><!-- adjust the value of a height for the height on the left table (tab2) -->
			
									</div>
									<!-- Class 7 Only (E) -->
								</td>
								<td>
									<table class="search" border="0"> 
										<tr class="h23">
											<td width="115">Approval Ref. No.</td>
											<td><input name="aply_no" type="text" style="width:150;" class="input" value="" readonly></td>
										</tr>
										<tr class="h23">
											<td width="115">Storage Temp</td>
											<td><input name="stwg_temp_ctnt" type="text" style="width:80;" maxlength="10" class="input1" value="">&nbsp;&deg;C</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				



						
						<!--  biz_4   (E) -->
						<!--  Button_Sub (S) -->
						<table width="729" class="button" > 
				       	<tr>
				       		<td width="" colspan="2">
							   	Pre-Checking Status : Carr.
							   	<input type="text" style="width:20;" class="input2" value="" readonly="readonly" name = "crr_pre_chk_cd">&nbsp;Port.&nbsp;
							   	<input type="text" style="width:20;" class="input2" value="" readonly="readonly" name = "opr_pre_chk_cd">&nbsp;Pack.&nbsp;
							   	<input type="text" style="width:20;" class="input2" value="" readonly="readonly" name = "pck_pre_chk_cd">&nbsp;Seg.&nbsp;
							   	<input type="text" style="width:20;" class="input2" value="" readonly="readonly" name = "segr_pre_chk_cd">
							</td>
				       		<td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" id="btn_Remark" name="btn_Remark">Remark(S)</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
			
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_add">Add</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_copy2">Copy</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left" id="btn_cancel_left"></td>
								<td class="btn2" id="btn_cancel" name="btn_cancel">Request Cancel</td>
								<td class="btn2_right" id="btn_cancel_right"></td>
								</tr>
								</table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_delete">Delete</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
										
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
				
						
						
				<!-- biz 4 - frame (E) -->
				
				
				
				
			</td></tr>
		</table>
		<!-- biz 2,3 - frame (E) -->
		
	</td></tr>
		</table>
		
		
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrive">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_attach" id="btn_attach">Attach File</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_save" id="btn_save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_request" id="btn_request">Request</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_email">E-mail</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_print">Print</td>
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
	
	<span id="progressPop"></span>
	
	<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>	

<div id="layList" name="layList" style="position:absolute;z-index:999;display:none" CELLPADDING=5 CELLSPACING=0 BORDER=0/>
<IFRAME id="ifrm" name="ifrm" src="apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html"  frameborder=0 marginHeight=0 marginWidth=0 width=115 height=82  style="position:absolute;border:1 #e9e9e9 solid" CELLSPACING=0 scrolling="no"></IFRAME>
	


<!-- 
<input type="hidden" name="com_rdSubSysCd" value="COM">
<input type="hidden" name="com_from" value="nhc123@cyberlogitec.com">
<input type="hidden" name="com_fromName" value="HC TEST">
<input type="hidden" name="com_subject" value="Title 입니다.">
<input type="hidden" name="com_content" id="com_content" value="11">
<input type="hidden" name="com_smtp" value="<%=com.hanjin.framework.core.config.SiteConfigFactory.get("COM.MAIL.SMTP.GROUPWARE") %>">
<input type="hidden" name="com_template" value="">
<input type="hidden" name="com_argument" value="">
-->

		
		<input type="hidden" name="com_from" value="">
		<input type="hidden" name="com_fromName" value="">
		<input type="hidden" name="com_recipient" value="">
		<input type="hidden" name="com_carbonCopy" value="">
		<input type="hidden" name="com_blindCarbonCopy" value="">
		<input type="hidden" name="com_subject" value="">
		<input type="hidden" name="com_fileKey" value="">
		<input type="hidden" name="com_content" value="">
		
		<input type="hidden" name="com_smtp" value="203.246.130.40">

	
	
	
	
</form>
</body>
</html>