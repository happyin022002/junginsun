<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0015.jsp
*@FileTitle : Dangerous CGO Application Details for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.17
*@LastModifier : 정운
*@LastVersion : 1.0
* 2009.07.13 이도형
* 1.0 Creation
*=========================================================
*History
*2011.01.05 이행지 [CHM-201007766-01] [VO-SCG] 다수 SEQ. REJECT 시 RJT사유 입력 개선요청
*2011.01.12 이행지 [CHM-201108316-01] [SCG] Reject N(all)추가요청
*2011.11.02 표준희 [CHM-201112981-01] [VO-SCG] 위험물 입력 관련 로직 변경 및 추가
*2011.12.12 김민아 [CHM-201114815-01] 특수화물(DG) 시스템 개선 요청(Segregation Group name 변경 외 3건)
*2012.07.05 이혜민 [CHM-201218535-01] [SCG] DG application 조회 화면에 package Q"ty/Type 의 정보 표시
*2012.12.17 진마리아 [CHM-201221863-01] [VOP-SCG] Application Detail for Own BKG 에 combine, split 정보 추가
*2014.01.17  정운   [CHM-201428537-01]	Pre-checking status의 컬럼의 값이 "X"일 때, 붉은색 표시
*=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0015Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkgNo 	= StringUtil.xssFilter(request.getParameter("bkg_no"));
	String strVvdCd 	= StringUtil.xssFilter(request.getParameter("vvd_cd"));
	String strCntrSeq 	= StringUtil.xssFilter(request.getParameter("dg_cntr_seq"));
	String strCgoSeq 	= StringUtil.xssFilter(request.getParameter("cntr_cgo_seq"));
	String strRqstSeq 	= StringUtil.xssFilter(request.getParameter("spcl_cgo_apro_rqst_seq"));
	String strRow 		= StringUtil.xssFilter(request.getParameter("row"));
	String strScgFlg	= StringUtil.xssFilter(request.getParameter("scg_flg"));
	String strType		= StringUtil.xssFilter(request.getParameter("type"));
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0015Event)request.getAttribute("Event");
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
<title>Dangerous CGO Application Details for Own BKG</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		var toDay = new Date();
	    var year  = toDay.getUTCFullYear();
	    var month = toDay.getUTCMonth() + 1;
	    var day   = toDay.getUTCDate();
	    var hours = toDay.getUTCHours();
	    var minutes = toDay.getUTCMinutes();
	    if(month < 10) month = '0' + month;
	    if(day < 10) day = '0' + day;
	    if(hours < 10) hours = '0' + hours;
	    if(minutes < 10) minutes = '0' + minutes;
	    //var toDays = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes;
	    var toDays = year + '-' + month + '-' + day;
		document.form.auth_usr_id.value = '<%=strUsr_id%>';
		document.form.vvd_cd.value = '<%=strVvdCd%>';
		document.form.auth_dt.value = toDays;
		
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="ltd_qty">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="dg_cntr_seq" value="<%=strCntrSeq %>">
<input type="hidden" name="spcl_cgo_apro_rqst_seq" value="<%=strRqstSeq %>">
<input type="hidden" name="row" value="<%=strRow %>">
<input type="hidden" name="scg_flg" value="<%=strScgFlg %>">
<input type="hidden" name="type" value="<%=strType %>">

<input type="hidden" name="vsl_cd">
<input type="hidden" name="temp_seq">
<input type="hidden" name="temp_cntr_no">
<input type="hidden" name="cntr_no">
<input type="hidden" name="cntr_tpsz_cd">

<input type="hidden" name="in_imdg_pck_cd1">
<input type="hidden" name="in_imdg_pck_cd2">
<input type="hidden" name="in_imdg_pck_qty1">
<input type="hidden" name="in_imdg_pck_qty2">
<input type="hidden" name="in_imdg_pck_desc1">
<input type="hidden" name="in_imdg_pck_desc2">
<input type="hidden" name="out_imdg_pck_cd1">
<input type="hidden" name="out_imdg_pck_cd2">
<input type="hidden" name="out_imdg_pck_qty1">
<input type="hidden" name="out_imdg_pck_qty2">
<input type="hidden" name="out_imdg_pck_desc1">
<input type="hidden" name="out_imdg_pck_desc2">
<input type="hidden" name="intmd_imdg_pck_cd1">
<input type="hidden" name="intmd_imdg_pck_cd2">
<input type="hidden" name="intmd_imdg_pck_qty1">
<input type="hidden" name="intmd_imdg_pck_qty2">
<input type="hidden" name="intmd_imdg_pck_desc1">
<input type="hidden" name="intmd_imdg_pck_desc2">
<input type="hidden" name="max_in_pck_qty">
<input type="hidden" name="max_in_pck_tp_cd">
<input type="hidden" name="hcdg_intmd_bc_rstr_desc">
<input type="hidden" name="hcdg_pck_rstr_desc">
<input type="hidden" name="hcdg_tnk_rstr_desc">
<input type="hidden" name="imdg_expt_qty_cd">

<input type="hidden" name="ems_no">
<input type="hidden" name="emer_rspn_gid_no" maxlength="3">
<input type="hidden" name="emer_rspn_gid_chr_no">
<input type="hidden" name="ctrl_temp_ctnt">
<input type="hidden" name="emer_temp_ctnt">
<input type="hidden" name="title_id" value="dg">

<input type="hidden" name="clod_flg" >
<input type="hidden" name="rc_flg" >
<input type="hidden" name="awk_cgo_flg" >
<input type="hidden" name="bb_cgo_flg" >
<input type="hidden" name="hcdg_flg" >
<input type="hidden" name="meas_qty" >
<input type="hidden" name="hcdg_dpnd_qty_flg" >
<input type="hidden" name="spcl_rqst_flg" >

<input type="hidden" name="temp_grs_wgt">
<input type="hidden" name="temp_net_wgt">


<input type="hidden" name="bkg_por_cd">
<input type="hidden" name="bkg_por_yd_cd">
<input type="hidden" name="bkg_del_cd">
<input type="hidden" name="bkg_del_yd_cd">
<input type="hidden" name="org_trns_mod_cd">
<input type="hidden" name="dest_trns_mod_cd">

<input type="hidden" name="bkg_pol_cd">
<input type="hidden" name="bkg_pol_yd_cd">
<input type="hidden" name="bkg_pod_cd">
<input type="hidden" name="bkg_pod_yd_cd">

<input type="hidden" name="mailYn" value="N">
<input type="hidden" name="grs_capa_qty">

<input type="hidden" name="old_bkg_no">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Dangerous CGO Application Details for Own BKG </td></tr>
			</table>
			<!-- : ( Title ) (E) -->
	
			<table class="search"> 
		       	<tr>
		       		<td class="bg">
				 		<table class="search" border="0" style="width:988;"> 
							<tr class="h23">
								<td width="" valign="top">
									<!--  biz_1  (S) -->
									<table class="search" border="0" style="width:570;"> 
										<tr class="h23">
											<td width="50">BKG No.</td>
											<td width="120"><input type="text" name="bkg_no" style="width:100;" class="input2" readOnly value="<%=strBkgNo %>"></td>
											<td width="115">Booking Combine</td>
											<td width=""><input type="text" name="bkg_combine" style="width:250;" class="input2" readOnly value=""></td> 
										</tr>
									</table>
									
									<table class="search" border="0" style="width:570;"> 
										<tr class="h23">
											<td width="50">B/L No.</td>
											<td width="120"><input type="text" name="bl_no" style="width:100;" class="input2" readOnly value=""></td> 
											<td width="115">Booking Split</td>
											<td width=""><input type="text" name="bkg_split" style="width:250;" class="input2" readOnly value=""></td>
										</tr>
									</table>
				
									<table class="search" border="0" style="width:570;"> 
										<tr class="h23">
											<td width="50">VVD CD</td>
											<td width="112"><input type="text" name="vvd_cd" style="width:100;" class="input2" readOnly value=""></td>
											<td width="50" align="right">POL&nbsp;</td>
											<td width="85"><input type="text"  name="pol_cd" style="width:50;" class="input2" readOnly value="">&nbsp;<input type="text" name="pol_nod_cd" style="width:25;" class="input2" readonly value=""></td>
											<td width="20" align="left">
												<!-- table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_PolCd">Info.</td>
														<td class="btn2_right"></td>
													</tr>
												</table-->
											</td>
											<td width="27">POD</td>
											<td width="86"><input type="text"  name="pod_cd" style="width:50;" class="input2" readOnly value="">&nbsp;<input type="text" name="pod_nod_cd" style="width:25;" class="input2" readonly value=""></td>
											<!-- td width="" align="left">
												<table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_PodCd">Info.</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td-->
											<td width="" align="left">
												<table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_RouteDetail">Route Detail</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<!--  biz_1   (E) -->
								</td>
								<td width="">
									<!--  biz_2  (S) -->
									<table class="search" border="0" style="width:409;"> 
										<tr class="h23">
											<td width="63">BKG.Staff</td>
											<td width="230">
												<input type="text" name="rqst_usr_nm" style="width:150;" class="input2" readOnly value="">
												<input type="text" name="rqst_usr_id" style="width:65;" class="input2" readonly value="">
											</td>
											<td width="65">BKG.Office</td>
											<td width=""><input type="text" name="rqst_ofc_cd" style="width:50;" class="input2" readOnly value=""></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:409;"> 
										<tr class="h23">
											<td width="145">Requested Date (GMT)</td>
											<td width=""><input type="text" name="rqst_gdt" style="width:111;" class="input2" readOnly value=""></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:409;"> 
										<tr class="h23">
											<td width="25">Tel.</td>
											<td width="140"><input type="text" name="rqst_usr_phn_no" style="width:120;" class="input2" readOnly value=""></td>
											<td width="43">E-mail</td>
											<td width=""><input type="text" name="rqst_usr_eml" style="width:100%;" class="input2" readOnly value=""></td>
										</tr>
									</table>
									<!--  biz_2   (E) -->
								</td>
							</tr>
						</table>

						<table class="line_bluedot"><tr><td></td></tr></table>
						<!--  biz_2   (S) -->
       					<table class="search" border="0" style="width:988;"> 
							<tr class="h23">
								<td width="220" valign="top">
									<!-- biz_2-1  (S) -->
									<table width="220" class="search" id="mainTable"> 
										<tr>
											<td width="220">
												<script language="javascript">ComSheetObject('sheet1');</script>
											</td>
										</tr>
									</table> 
									<!-- biz_2-1 (E) -->
						
									<table class="height_8"><tr><td></td></tr></table>
						
									<!-- biz_2-2  (S) -->
									<table width="220" class="search" id="mainTable"> 
										<tr>
											<td width="220">
												<script language="javascript">ComSheetObject('sheet2');</script>
											</td>
										</tr>
									</table> 
									<!-- biz_2-2 (E) -->
									
									<table width="220" class="search" id="mainTable" style="display:none"> 
										<tr>
											<td width="0">
												<script language="javascript">ComSheetObject('sheet3');</script>
											</td>
										</tr>
									</table> 
									
									<table width="220" class="search" id="mainTable" style="display:none">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet4');</script>
											</td>
										</tr>
									</table> 
									
									<table width="200" class="search" id="mainTable" style="display:none"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet5');</script>
											</td>
										</tr>
									</table> 
									
								</td>
								
								<td width="">
									<table width="5" border="0">
										<tr><td></td></tr>
									</table>
								</td>
								
								<td width="780" valign="top" border="0">
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="74">Cargo Seq.</td>
											<td width="">
												<input type="text" name="cntr_cgo_seq" style="width:30; text-align:center;" class="input2" readOnly value="<%=strCgoSeq %>"> /
												<input type="text" name="cntr_cgo_seq_sum" style="width:30; text-align:center;" class="input2" readOnly value="">
											</td>
											<td width="110">
												<table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Irregular" id="btn_Irregular">Irregulars List</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td width="115">
												<table width="115" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_UnInformation">UN Information</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td width="95">
												<table width="95" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Restrictions">Restrictions</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td width="150">
												<table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Pre-CheckingReport">Pre-Checking Report</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td width="145">
												<table width="145" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_PackageQtyType">Package Q'ty / Type</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											
										</tr>
									</table>
						
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="45">UN No.</td>
											<td width="100">
												<input type="text" name="imdg_un_no" style="width:40; text-align:center;" class="input2" readOnly value="">
												<input name="imdg_un_no_seq" type="text" style="width:20; text-align:center;" class="input2" value="" readonly>&nbsp;<img src="img/btns_search.gif" name="btn_UnNo" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
											</td>
											<td width="70" align="right">IMDG Class</td>
											<td width="">&nbsp;
												<input type="text" name="imdg_clss_cd" style="width:30; text-align:center;" class="input2" readOnly value="">
												<input type="text" name="imdg_comp_grp_cd" style="width:20; text-align:center;" class="input2" readOnly value="">
											</td>
											<td width="90">Gross Weight</td>
											<td width="150"><input type="text" name="grs_wgt" style="width:100; text-align:right;" class="input2" readOnly value="">&nbsp;KGS</td> 
											<td width="80">Net Weight</td>
											<td width="143"><input type="text" name="net_wgt" style="width:100; text-align:right;" class="input2" readOnly value="">&nbsp;KGS</td>
										</tr>
										<!-- tr class="h23">
											<td colspan="6"></td>
											<td>Net Weight</td>
											<td><input type="text" name="net_wgt" style="width:90; text-align:right;" class="input2" dataformat="float" value="">&nbsp;<input type="text" name="wgt_ut_cd2" style="width:56;" class="input2" value=""></td>
											<td><table width="150" border="0" cellpadding="0" cellspacing="0" class="button"><tr><td class="btn2_left"></td><td class="btn2" style="color:red;" name="btn_pack">Package Q'ty / Type</td><td class="btn2_right"></td></tr></table></td>
										</tr-->
									</table>
						
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="140">Proper Shipping Name</td>
											<td width="" colspan="3"><input type="text" name="prp_shp_nm" style="width:100%;" class="input2" readOnly value=""></td>
										</tr>
										<tr class="h23">
											<td width="140">Hazardous Contents</td>
											<td width="285"><input type="text" name="hzd_desc" style="width:265;" class="input2" readOnly value=""></td>
										    <td width="135">Segregation Group</td>
							                <td width=""><script language="javascript">ComComboObject('hzd_ctnt', 1, 200, 1);</script></td>
										</tr>
									</table>
						
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="74">Flash Point</td>
											<td width="80"><input type="text" name="flsh_pnt_cdo_temp" style="width:50; text-align:right;" class="input2" readOnly value="">&nbsp;&deg;C</td>
											<td width="93">Packing Group</td>
											<td width="80"><input type="text" name="imdg_pck_grp_cd" style="width:60; text-align:center;" class="input2" readOnly value=""></td>
											<td width="75">PSA Group</td>
											<td width="100"><input type="text" name="psa_no" style="width:40; text-align:center;" class="input2" readOnly value="">&nbsp;<input type="text" style="width:40;" class="input2" readOnly value=""></td>
											<td width="90">Limited Q'ty</td>
											<td width="45">
												<select name="imdg_lmt_qty_flg" style="width:40;" class="input2" disabled>
													<option value=""></option>
													<option value="Y">Y</option>
													<option value="N">N</option>
												</select>
											</td>
											<td width=""><input type="text" name="hcdg_flag" style="width:100%;color:red;font-weight:bold" class="input2" readOnly value=""></td>
										</tr>
									</table>

									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="74">Sub Label</td>
											<td width="130">
												<input type="text" name="imdg_subs_rsk_lbl_cd1" style="width:25;" class="input2" readOnly value=""> 
												<input type="text" name="imdg_subs_rsk_lbl_cd2" style="width:25;" class="input2" readOnly value=""> 
												<input type="text" name="imdg_subs_rsk_lbl_cd3" style="width:25;" class="input2" readOnly value="">
												<input type="text" name="imdg_subs_rsk_lbl_cd4" style="width:25;" class="input2" readOnly value="">
											</td>
											<td width="93">Cargo Status</td>
											<td width="87">
												<select name="dcgo_sts_cd" style="width:60;" class="input2" disabled>
													<option value=""></option>
													<option value="L">Liquid</option>
													<option value="G">GAS</option>
													<option value="P">PASTE</option>
													<option value="S">SOLID</option>
												</select>
											</td>
											<td width="109">Marine Pollutant</td>
											<td width="76">&nbsp;&nbsp;
												<select name="mrn_polut_flg" style="width:40;" class="input2" disabled>
													<option value=""></option>
													<option value="Y">Y</option>
													<option value="N">N</option>
												</select>
											</td>
											<td width="90">Excepted Q’ty</td>
											<td>
												<select name="imdg_expt_qty_flg" style="width:40;" class="input2" disabled>
													<option value=""></option>
													<option value="Y">Y</option>
													<option value="N">N</option>
												</select>
											</td>
										</tr>
									</table>
							
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="450">
												<table class="grid2" border="0" style="width:99%;"> 
													<tr class="h23">
														<td class="tr2_head" width="130">Emergent Contact</td>
														<td class="noinput2"><input type="text" name="emer_cntc_phn_no_ctnt" style="width:100%;" class="noinput2" readOnly value=""></td>
													</tr>
													<tr class="h23">
														<td class="tr2_head" width="130">Contact Person</td>
														<td class="noinput2"><input type="text" name="emer_cntc_pson_nm" style="width:100%;" class="noinput2" readOnly value=""></td>
													</tr>
												</table>
											</td>
											<td>
												<table class="search" border="0" style="width:100%;"> 
													<tr class="h23">
														<td width="120"> Certificate Number</td>
														<td><input type="text" name="certi_no" style="width:100%;" class="input2" readOnly value=""></td>
													</tr>
												</table>
												<table class="height_2"><tr><td></td></tr></table>
												<!--  Button_Sub (S) -->
												<table width="" class="search"> 
										       		<tr>
										       			<td class="btn2_bg">
															<table border="0" cellpadding="0" cellspacing="0">
																<tr>
																	<td>
																		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																			<tr>
																				<td class="btn2_left"></td>
																				<td class="btn2" name="btn_OtherEmergencyInformation">Other Emergency Information</td>
																				<td class="btn2_right"></td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
									    		<!-- Button_Sub (E) -->
											</td>					
										</tr>
									</table>
						
									<table class="height_8" ><tr><td></td></tr></table>
				
									<table class="search" border="0" style="width:100%"> 
										<tr class="h23">
											<td width="55%">
												<!-- Tab (S) -->
									     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="2"> 
													<tr>
														<td width="100%">
															<script language="javascript">ComTabObject('tab1')</script>
														</td>
													</tr>
												</table>
												<!-- Tab (E) -->
												<!-- Tab Class 1 Only (S) -->
												<div id="tabLayer" style="display:inline">
													<table border="0" style="width:400; background-color:white;" class="grid2"> 
														<tr>
															<td width="25%" class="tr2_head" rowspan="2">Class 1 Only</td>
															<td width="34%" class="tr2_head">Consignee Detail</td> 
															<td class="input2"><input name="cnee_dtl_desc" type="text" style="width:100%;" class="noinput2" readOnly value=""></td>
														</tr>
														<tr>
															<td class="tr2_head">Net Explosive Weight</td> 
															<td class="input2"><input type="text" name="net_explo_wgt" style="width:75%; text-align:right;" class="noinput2" readOnly value="">&nbsp;<input type="text" style="width:20%;" class="noinput2" readOnly value="KGS"></td>
														</tr>	
													</table>	
													<table class="search" height="25"><tr><td></td></tr></table>
												</div>

												<!-- Tab Class 1 Only (E) -->
												<div id="tabLayer" style="display:none">					
													<table border="0" style="width:400; background-color:white;" class="grid2"> 
														<tr>
															<td width="15%" class="tr2_head" rowspan="3">Class 7 <br>Only</td>
															<td class="tr2_head" colspan="5">Radio Active Commodities</td>
														</tr>
														<tr>
															<td width="20%" class="tr2_head">Schedule</td> 
															<td width="15%" align="center" id="rada_skd_no" class="input2"></td>
															<td width="20%" class="tr2_head"0>Activity</td>
															<td width="20%" class="input2"><input type="text" name="rada_amt" style="width:60%; text-align:right;" class="noinput2" readOnly value=""></td>
															<td class="input2">
																<select name="rada_ut_cd" style="width:60;" class="input2" disabled >
																	<option value=""></option>
																	<option value="MBQ">MBQ</option>
																	<option value="NBQ">NBQ</option>
																	<option value="GBQ">GBQ</option>
																	<option value="TBQ">TBQ</option>
																</select>
															</td>
														</tr>
														<tr>
															<td class="tr2_head" colspan="2"> Transportation Index</td> 
															<td colspan="3"><input type="text" name="rada_trsp_no" style="width:100%; text-align:center;" class="noinput2" value="" maxlength="8"></td>
														</tr>
													</table>						
													<table class="search" height="3"><tr><td></td></tr></table><!-- adjust the value of a height for the height on the left table (tab2) -->					
												</div>					
											</td>
											<td width="">
											<table width="7" border="0">
												<tr><td></td></tr>
												</table>
											</td>					
										
											
											<td width="" valign="top">
												<table width="187" border="0">
												<tr><td class="title_s"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;DG Package Q"ty & Type</td></tr>
												</table>
												
												<table class="search_sm2" border="0" style="width:98%;">
													<tr class="h23"><td class="title_h"></td>
														<td class="text">&nbsp;Outer Package</td></tr>
												</table>
												
												<table class="search_sm2" border="0" style="width:98%;"> 
													<tr class="h23">
														<td width="55">1st Q'TY</td>
														<td width="42"><input type="text" name="out_dg_pck_qty1" style="width:42;text-align:right" class="input2" readonly value="" ></td>
														<td width="26">Type</td>
														<td width="41"><input type="text" name="out_dg_pck_cd1" style="width:42;" class="input2" readonly value="" ></td></tr>
													<tr class="h23">
														<td width="55">2nd Q'TY</td>
														<td width="42"><input type="text" name="out_dg_pck_qty2" style="width:42;text-align:right" class="input2" readonly value=""></td>
														<td width="26">Type</td>
														<td width="42"><input type="text" name="out_dg_pck_cd2" style="width:42;" class="input2" readonly value="" ></td></tr>
												</table>
											</td>
											
										
											
											<td width="" valign="top">
												<table width="187" border="0">
												<tr><td class="title_s">&nbsp;</td></tr>
												</table>
												
												<table class="search_sm2" border="0" style="width:98%;">
													<tr class="h23"><td class="title_h"></td>
														<td class="text">&nbsp;Inner Package</td></tr>
												</table>
												
												<table class="search_sm2" border="0" style="width:98%;"> 
													<tr class="h23">
														<td width="55">1st Q'TY</td>
														<td width="42"><input type="text" name="in_dg_pck_qty1" style="width:43;text-align:right" class="input2" readonly value="" ></td>
														<td width="26">Type</td>
														<td width="42"><input type="text" name="in_dg_pck_cd1" style="width:42;" class="input2" readonly value="" ></td></tr>
													<tr class="h23">
														<td width="55">2nd Q'TY</td>
														<td width="42"><input type="text" name="in_dg_pck_qty2" style="width:43;text-align:right" class="input2" readonly value="" ></td>
														<td width="26">Type</td>
														<td width="42"><input type="text" name="in_dg_pck_cd2" style="width:42;" class="input2" readonly value="" ></td></tr>
												</table>
											</td>
										</tr>
									</table>

									<table class="search" border="0" style="width:100%;"> 
									    <tr class="h23">
										<td width="100" style="width: 100px">Storage Temp</td>
										<td width=""><input name="stwg_temp_ctnt" type="text" style="width:80;" class="input1" readOnly value="">&nbsp;&deg;C</td></tr>
									</table>

									<table class="search" border="0" style="width:100%;"> 
							       		<tr class="h23">
											<td width="74">Remark(s)</td>
											<td width=""><input type="text" name="diff_rmk" style="width:98%;" class="input2" readonly value=""></td>
											<td width="120">
												<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btn_AttachedFile" name="btn_AttachedFile">Attached File</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>			
								</td>
							</tr>
						</table>
		
						<!--  biz_2   (E) -->
	       				<table class="line_bluedot"><tr><td height="20"></td></tr></table>
       		
			       		<!--  biz_3 (S) -->
						<table class="search" border="0" style="width:988;"> 
							<tr class="h23">
								<td width="110">Approval by</td>
								<td width="135"><input type="text" name="auth_usr_id" style="width:108;" class="input1" readOnly value=""></td>
								<td width="70">Date (GMT)</td>
								<td width="" colspan="2"><input type="text" name="auth_dt" style="width:80;" class="input1" readOnly value=""></td>
								<td width="" colspan="2">
							   	Pre-Checking Status : Carr. &nbsp;<input type="text" style="width:20;font-weight:bold" class="input2" value="" readonly="readonly" name = "pre_crr"> &nbsp;Port&nbsp;<input type="text" style="width:20;font-weight:bold" class="input2" value="" readonly="readonly" name = "pre_opr">&nbsp;Pack.&nbsp;<input type="text" style="width:20;font-weight:bold" class="input2" value="" readonly="readonly" name = "pre_pck">&nbsp;Seg.&nbsp;<input type="text" style="width:20;font-weight:bold" class="input2" value="" readonly="readonly" name = "pre_sgr">
							    </td>  
							</tr>
							<tr class="h23">
								<td width="">Approval</td>
								<td width=""><select name="spcl_cgo_auth_cd" style="width:108;" class="input1" style="font-weight:bold;">
									<option value="Y" style="color:green;">Y</option>
									<option value="A" style="color:green;">Y(all)</option>
                                    <option value="N" style="color:red;">N</option>
									<option value="M" style="color:red;">N(all)</option>
									<option value="P" style="color:blue;">P</option>
									<option value="" style="color:orange;"></option>
									</select>
								</td>
								<td width="">RJT Code</td>
								<td width="100" style="padding-left:2;"> 
									<script language="javascript">ComComboObject('spcl_cgo_auth_rjct_cd', 2, 80, 0, 2);</script>								
								</td>
								<td width="70">Remark(s)</td>
								<td><input type="text" name="spcl_cgo_auth_rmk" style="width:100%;" class="input" value=""></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="110">Approval Ref. No.</td>
								<td><input type="text" name="apro_ref_no" style="width:378;" class="input2" value="" maxlength="50" disabled></td>
							</tr>	
						</table>
						<!--  biz_3   (E) -->	
					</td>
				</tr>
			</table>	
			<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr>
		       		<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_ApprovalDetails">Approval Details</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td width="">
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Mail">Mail</td>
											<td class="btn1_right"></td>
									</tr>
									</table>
								</td>
								<td width="">
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Prev">Prev.</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td width="">
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Next">Next</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td width="">
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					    <!--Button (E) -->	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table> 
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>