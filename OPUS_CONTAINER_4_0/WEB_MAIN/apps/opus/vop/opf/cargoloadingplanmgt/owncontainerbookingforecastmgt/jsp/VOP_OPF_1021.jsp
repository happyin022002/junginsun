<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_1021.jsp
*@FileTitle  : Own Container Booking Forecast Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/22
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf1021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf1021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id   = "";
	String strUsr_nm   = "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	StringBuffer vslOprComboItem = new StringBuffer();
	String vsl_cd      = "";
	String skd_voy_no  = "";
	String skd_dir_cd  = "";
	String vsl_nm      = "";
	String yd_cd       = "";
	String loc_nm      = "";
	String yd_nm       = "";
	String slan_cd     = "";
	String slan_nm     = "";
	String cbf_ind_flg = "";
	String upd_dt      = "";
	String crr_cd      = "";
	String pod_cd      = "";
	String mlb_cd      = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopOpf1021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		vsl_cd      = JSPUtil.getParameter(request, "vsl_cd".trim(), "");
		skd_voy_no  = JSPUtil.getParameter(request, "skd_voy_no".trim(), "");
		skd_dir_cd  = JSPUtil.getParameter(request, "skd_dir_cd".trim(), "");
		vsl_nm      = JSPUtil.getParameter(request, "vsl_eng_nm".trim(), "");
		yd_cd       = JSPUtil.getParameter(request, "yd_cd".trim(), "");
		loc_nm      = JSPUtil.getParameter(request, "loc_nm".trim(), "");
		yd_nm       = JSPUtil.getParameter(request, "yd_nm".trim(), "");
		slan_cd     = JSPUtil.getParameter(request, "slan_cd".trim(), "");
		slan_nm     = JSPUtil.getParameter(request, "slan_nm".trim(), "");
		cbf_ind_flg = JSPUtil.getParameter(request, "cbf_ind_flg".trim(), "");
		upd_dt      = JSPUtil.getParameter(request, "upd_dt".trim(), "");
		crr_cd      = JSPUtil.getParameter(request, "crr_cd".trim(), "").equals("ALL")?"":JSPUtil.getParameter(request, "crr_cd".trim(), "");
		pod_cd      = JSPUtil.getParameter(request, "pod_cd".trim(), "");
		mlb_cd      = JSPUtil.getParameter(request, "mlb_cd".trim(), "");
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="head_opr_list" value="" id="head_opr_list" />
<input type="hidden" name="com_templateMrd" value="VOP_OPF_1021.mrd" id="com_templateMrd" />
<input type="hidden" name="com_templateMrdArguments" id="com_templateMrdArguments" />
<input type="hidden" name="com_templateMrdDescription" value="VOP_OPF_1021.mrd 파일이 첨부되었습니다." id="com_templateMrdDescription" />

<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdSaveDialogDir" id="com_mrdSaveDialogDir" />
<input type="hidden" name="com_mrdSaveDialogFileName" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogFileExt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="com_isBatch" id="com_isBatch" />
<input type="hidden" name="com_zoomIn" id="com_zoomIn" />

<!-- 1021 RD Parameter -->
<input type="hidden" name="vsl_cd" value="<%=vsl_cd%>" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" value="<%=skd_voy_no%>" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" value="<%=skd_dir_cd%>" id="skd_dir_cd" />
<input type="hidden" name="vsl_nm" value="<%=vsl_nm%>" id="vsl_nm" />
<input type="hidden" name="yd_cd" value="<%=yd_cd%>" id="yd_cd" />
<input type="hidden" name="loc_nm" value="<%=loc_nm%>" id="loc_nm" />
<input type="hidden" name="yd_nm" value="<%=yd_nm%>" id="yd_nm" />
<input type="hidden" name="slan_cd" value="<%=slan_cd%>" id="slan_cd" />
<input type="hidden" name="slan_nm" value="<%=slan_nm%>" id="slan_nm" />
<input type="hidden" name="cbf_ind_flg" value="<%=cbf_ind_flg%>" id="cbf_ind_flg" />
<input type="hidden" name="upd_dt" value="<%=upd_dt%>" id="upd_dt" />
<input type="hidden" name="crr_cd" value="<%=crr_cd%>" id="crr_cd" />
<input type="hidden" name="pod_cd" value="<%=pod_cd%>" id="pod_cd" />
<input type="hidden" name="mlb_cd" value="<%=mlb_cd%>" id="mlb_cd" />

<input type="hidden" name="st_1" id="st_1" />
<input type="hidden" name="st_2" id="st_2" />
<input type="hidden" name="st_3" id="st_3" />
<input type="hidden" name="st_4" id="st_4" />
<input type="hidden" name="st_5" id="st_5" />
<input type="hidden" name="st_6" id="st_6" />
<input type="hidden" name="st_7" id="st_7" />
<input type="hidden" name="st_8" id="st_8" />
<input type="hidden" name="st_9" id="st_9" />
<input type="hidden" name="st_10" id="st_10" />
<input type="hidden" name="st_11" id="st_11" />
<input type="hidden" name="st_12" id="st_12" />
<input type="hidden" name="st_13" id="st_13" />
<input type="hidden" name="st_14" id="st_14" />
<input type="hidden" name="st_15" id="st_15" />

<input type="hidden" name="opr_st_ct" id="opr_st_ct" />
<input type="hidden" name="opr1_st1" value="0" id="opr1_st1" />
<input type="hidden" name="opr1_st2" value="0" id="opr1_st2" />
<input type="hidden" name="opr1_st3" value="0" id="opr1_st3" />
<input type="hidden" name="opr1_st4" value="0" id="opr1_st4" />
<input type="hidden" name="opr1_st5" value="0" id="opr1_st5" />
<input type="hidden" name="opr1_st6" value="0" id="opr1_st6" />
<input type="hidden" name="opr1_st7" value="0" id="opr1_st7" />
<input type="hidden" name="opr1_st8" value="0" id="opr1_st8" />
<input type="hidden" name="opr1_st9" value="0" id="opr1_st9" />
<input type="hidden" name="opr1_st10" value="0" id="opr1_st10" />
<input type="hidden" name="opr1_st11" value="0" id="opr1_st11" />
<input type="hidden" name="opr1_st12" value="0" id="opr1_st12" />
<input type="hidden" name="opr1_st13" value="0" id="opr1_st13" />
<input type="hidden" name="opr1_st14" value="0" id="opr1_st14" />
<input type="hidden" name="opr1_st15" value="0" id="opr1_st15" />
<input type="hidden" name="opr2_st1" value="0" id="opr2_st1" />
<input type="hidden" name="opr2_st2" value="0" id="opr2_st2" />
<input type="hidden" name="opr2_st3" value="0" id="opr2_st3" />
<input type="hidden" name="opr2_st4" value="0" id="opr2_st4" />
<input type="hidden" name="opr2_st5" value="0" id="opr2_st5" />
<input type="hidden" name="opr2_st6" value="0" id="opr2_st6" />
<input type="hidden" name="opr2_st7" value="0" id="opr2_st7" />
<input type="hidden" name="opr2_st8" value="0" id="opr2_st8" />
<input type="hidden" name="opr2_st9" value="0" id="opr2_st9" />
<input type="hidden" name="opr2_st10" value="0" id="opr2_st10" />
<input type="hidden" name="opr2_st11" value="0" id="opr2_st11" />
<input type="hidden" name="opr2_st12" value="0" id="opr2_st12" />
<input type="hidden" name="opr2_st13" value="0" id="opr2_st13" />
<input type="hidden" name="opr2_st14" value="0" id="opr2_st14" />
<input type="hidden" name="opr2_st15" value="0" id="opr2_st15" />
<input type="hidden" name="opr3_st1" value="0" id="opr3_st1" />
<input type="hidden" name="opr3_st2" value="0" id="opr3_st2" />
<input type="hidden" name="opr3_st3" value="0" id="opr3_st3" />
<input type="hidden" name="opr3_st4" value="0" id="opr3_st4" />
<input type="hidden" name="opr3_st5" value="0" id="opr3_st5" />
<input type="hidden" name="opr3_st6" value="0" id="opr3_st6" />
<input type="hidden" name="opr3_st7" value="0" id="opr3_st7" />
<input type="hidden" name="opr3_st8" value="0" id="opr3_st8" />
<input type="hidden" name="opr3_st9" value="0" id="opr3_st9" />
<input type="hidden" name="opr3_st10" value="0" id="opr3_st10" />
<input type="hidden" name="opr3_st11" value="0" id="opr3_st11" />
<input type="hidden" name="opr3_st12" value="0" id="opr3_st12" />
<input type="hidden" name="opr3_st13" value="0" id="opr3_st13" />
<input type="hidden" name="opr3_st14" value="0" id="opr3_st14" />
<input type="hidden" name="opr3_st15" value="0" id="opr3_st15" />
<input type="hidden" name="opr4_st1" value="0" id="opr4_st1" />
<input type="hidden" name="opr4_st2" value="0" id="opr4_st2" />
<input type="hidden" name="opr4_st3" value="0" id="opr4_st3" />
<input type="hidden" name="opr4_st4" value="0" id="opr4_st4" />
<input type="hidden" name="opr4_st5" value="0" id="opr4_st5" />
<input type="hidden" name="opr4_st6" value="0" id="opr4_st6" />
<input type="hidden" name="opr4_st7" value="0" id="opr4_st7" />
<input type="hidden" name="opr4_st8" value="0" id="opr4_st8" />
<input type="hidden" name="opr4_st9" value="0" id="opr4_st9" />
<input type="hidden" name="opr4_st10" value="0" id="opr4_st10" />
<input type="hidden" name="opr4_st11" value="0" id="opr4_st11" />
<input type="hidden" name="opr4_st12" value="0" id="opr4_st12" />
<input type="hidden" name="opr4_st13" value="0" id="opr4_st13" />
<input type="hidden" name="opr4_st14" value="0" id="opr4_st14" />
<input type="hidden" name="opr4_st15" value="0" id="opr4_st15" />
<input type="hidden" name="opr5_st1" value="0" id="opr5_st1" />
<input type="hidden" name="opr5_st2" value="0" id="opr5_st2" />
<input type="hidden" name="opr5_st3" value="0" id="opr5_st3" />
<input type="hidden" name="opr5_st4" value="0" id="opr5_st4" />
<input type="hidden" name="opr5_st5" value="0" id="opr5_st5" />
<input type="hidden" name="opr5_st6" value="0" id="opr5_st6" />
<input type="hidden" name="opr5_st7" value="0" id="opr5_st7" />
<input type="hidden" name="opr5_st8" value="0" id="opr5_st8" />
<input type="hidden" name="opr5_st9" value="0" id="opr5_st9" />
<input type="hidden" name="opr5_st10" value="0" id="opr5_st10" />
<input type="hidden" name="opr5_st11" value="0" id="opr5_st11" />
<input type="hidden" name="opr5_st12" value="0" id="opr5_st12" />
<input type="hidden" name="opr5_st13" value="0" id="opr5_st13" />
<input type="hidden" name="opr5_st14" value="0" id="opr5_st14" />
<input type="hidden" name="opr5_st15" value="0" id="opr5_st15" />

<input type="hidden" name="opr_stcd1" id="opr_stcd1" />
<input type="hidden" name="opr_stcd2" id="opr_stcd2" />
<input type="hidden" name="opr_stcd3" id="opr_stcd3" />
<input type="hidden" name="opr_stcd4" id="opr_stcd4" />
<input type="hidden" name="opr_stcd5" id="opr_stcd5" />
<input type="hidden" name="opr_stcd6" id="opr_stcd6" />
<input type="hidden" name="opr_stcd7" id="opr_stcd7" />
<input type="hidden" name="opr_stcd8" id="opr_stcd8" />
<input type="hidden" name="opr_stcd9" id="opr_stcd9" />
<input type="hidden" name="opr_stcd10" id="opr_stcd10" />
<input type="hidden" name="opr_stcd11" id="opr_stcd11" />
<input type="hidden" name="opr_stcd12" id="opr_stcd12" />
<input type="hidden" name="opr_stcd13" id="opr_stcd13" />
<input type="hidden" name="opr_stcd14" id="opr_stcd14" />
<input type="hidden" name="opr_stcd15" id="opr_stcd15" />
<input type="hidden" name="opr_stcd16" id="opr_stcd16" />
<input type="hidden" name="opr_stcd17" id="opr_stcd17" />
<input type="hidden" name="opr_stcd18" id="opr_stcd18" />
<input type="hidden" name="opr_stcd19" id="opr_stcd19" />
<input type="hidden" name="opr_stcd20" id="opr_stcd20" />
<input type="hidden" name="opr_stcd21" id="opr_stcd21" />
<input type="hidden" name="opr_stcd22" id="opr_stcd22" />
<input type="hidden" name="opr_stcd23" id="opr_stcd23" />
<input type="hidden" name="opr_stcd24" id="opr_stcd24" />
<input type="hidden" name="opr_stcd25" id="opr_stcd25" />
<input type="hidden" name="opr_stcd26" id="opr_stcd26" />
<input type="hidden" name="opr_stcd27" id="opr_stcd27" />
<input type="hidden" name="opr_stcd28" id="opr_stcd28" />
<input type="hidden" name="opr_stcd29" id="opr_stcd29" />
<input type="hidden" name="opr_stcd30" id="opr_stcd30" />
<input type="hidden" name="opr_stcd31" id="opr_stcd31" />
<input type="hidden" name="opr_stcd32" id="opr_stcd32" />
<input type="hidden" name="opr_stcd33" id="opr_stcd33" />
<input type="hidden" name="opr_stcd34" id="opr_stcd34" />
<input type="hidden" name="opr_stcd35" id="opr_stcd35" />
<input type="hidden" name="opr_stcd36" id="opr_stcd36" />
<input type="hidden" name="opr_stcd37" id="opr_stcd37" />
<input type="hidden" name="opr_stcd38" id="opr_stcd38" />
<input type="hidden" name="opr_stcd39" id="opr_stcd39" />
<input type="hidden" name="opr_stcd40" id="opr_stcd40" />
<input type="hidden" name="opr_stcd41" id="opr_stcd41" />
<input type="hidden" name="opr_stcd42" id="opr_stcd42" />
<input type="hidden" name="opr_stcd43" id="opr_stcd43" />
<input type="hidden" name="opr_stcd44" id="opr_stcd44" />
<input type="hidden" name="opr_stcd45" id="opr_stcd45" />
<input type="hidden" name="opr_stcd46" id="opr_stcd46" />
<input type="hidden" name="opr_stcd47" id="opr_stcd47" />
<input type="hidden" name="opr_stcd48" id="opr_stcd48" />
<input type="hidden" name="opr_stcd49" id="opr_stcd49" />
<input type="hidden" name="opr_stcd50" id="opr_stcd50" />
<input type="hidden" name="opr_stcd51" id="opr_stcd51" />
<input type="hidden" name="opr_stcd52" id="opr_stcd52" />
<input type="hidden" name="opr_stcd53" id="opr_stcd53" />
<input type="hidden" name="opr_stcd54" id="opr_stcd54" />
<input type="hidden" name="opr_stcd55" id="opr_stcd55" />
<input type="hidden" name="opr_stcd56" id="opr_stcd56" />
<input type="hidden" name="opr_stcd57" id="opr_stcd57" />
<input type="hidden" name="opr_stcd58" id="opr_stcd58" />
<input type="hidden" name="opr_stcd59" id="opr_stcd59" />
<input type="hidden" name="opr_stcd60" id="opr_stcd60" />
<input type="hidden" name="opr_stcd61" id="opr_stcd61" />
<input type="hidden" name="opr_stcd62" id="opr_stcd62" />
<input type="hidden" name="opr_stcd63" id="opr_stcd63" />
<input type="hidden" name="opr_stcd64" id="opr_stcd64" />
<input type="hidden" name="opr_stcd65" id="opr_stcd65" />
<input type="hidden" name="opr_stcd66" id="opr_stcd66" />
<input type="hidden" name="opr_stcd67" id="opr_stcd67" />
<input type="hidden" name="opr_stcd68" id="opr_stcd68" />
<input type="hidden" name="opr_stcd69" id="opr_stcd69" />
<input type="hidden" name="opr_stcd70" id="opr_stcd70" />
<input type="hidden" name="opr_stcd71" id="opr_stcd71" />
<input type="hidden" name="opr_stcd72" id="opr_stcd72" />
<input type="hidden" name="opr_stcd73" id="opr_stcd73" />
<input type="hidden" name="opr_stcd74" id="opr_stcd74" />
<input type="hidden" name="opr_stcd75" id="opr_stcd75" />
<!-- Developer Performance	-->

<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Print CBF Summary</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Print" name="btn_Print" class="btn_accent">Print</button><!--
		--><button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<div class="sm">
		<table>
			<colgroup>
				<col width="30"/>
				<col width="150"/>
				<col width="30"/>
				<col width="150"/>
				<col width="30"/>
				<col width="150"/> 
				<col width="*"/>
			</colgroup>
			<tr>
				<th title="Port of Discharging">POD</th>
				<td><script type="text/javascript">ComComboObject('pod_cd2', 1, 70, 1, 0, 0, false);</script></td>
				<th>OPR</th>
				<td><script type="text/javascript">ComComboObject('crr_cd2', 1, 70, 1, 0, 0, false);</script></td>
				<th>MLB</th>
				<td><script type="text/javascript">ComComboObject('mlb_cd2', 1, 70, 1);</script></td>
				<td></td>
			</tr>
		</table>
		
		<table class="line_bluedot"><tr><td colspan="6"></label></td></tr></table>
			
		<table style="width: 500px;">
			<colgroup>
				<col width="130"/>
				<col width="*"/>
			</colgroup>  
			<tr>
				<th style="text-align: right;" class="pad_rgt_8">Volume</th>
				<td><input type="radio" value="1" name="selPrint" class="trans" checked="" id="selPrint1" /><label for="selPrint1">CBF Summary by Volume</label></label></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="radio" value="2" name="selPrint" class="trans" id="selPrint2" /><label for="selPrint2">Special Cargo Summary by Volume</label></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="radio" value="3" name="selPrint" class="trans" id="selPrint3" /><label for="selPrint3">CBF Summary by Volume (Mini Land Bridge)</label></td>
			</tr>	
			<tr>
				<th></th>
				<td><input type="radio" value="4" name="selPrint" class="trans" id="selPrint4" /><label for="selPrint4">Special Cargo Summary by Volume (Mini Land Bridge)</label></td>
			</tr>									
		</table>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<table style="width: 500px;"> 
			<colgroup>
				<col width="130"/>
				<col width="*"/>
			</colgroup> 
			<tr>
				<th style="text-align: right;" class="pad_rgt_8">Weight Group</th>
				<td><input type="radio" value="5" name="selPrint" class="trans" id="selPrint5" /><label for="selPrint5">CBF Summary by Weight Group</label></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="radio" value="6" name="selPrint" class="trans" id="selPrint6" /><label for="selPrint6">CBF Summary by Weight Group (Mini Land Bridge)</label></td>
			</tr>
		</table>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<table style="width: 500px;">
			<colgroup>
				<col width="130"/>
				<col width="*"/>
			</colgroup> 
			<tr>
				<th>Special Cargo Type</th>
				<td><input type="radio" value="7" name="selPrint" class="trans" id="selPrint7" /><label for="selPrint7">All Special Cargo</label></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="radio" value="8" name="selPrint" class="trans" id="selPrint8" /><label for="selPrint8">Dangerous Cargo</label></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="radio" value="9" name="selPrint" class="trans" id="selPrint9" /><label for="selPrint9">Reefer Cargo</label></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="radio" value="10" name="selPrint" class="trans" id="selPrint10" /><label for="selPrint10">Awkward Cargo</label></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="radio" value="11" name="selPrint" class="trans" id="selPrint11" /><label for="selPrint11">Break Bulk Cargo</label></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="radio" value="12" name="selPrint" class="trans" id="selPrint12" /><label for="selPrint12">Special Stowage</label></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="radio" value="13" name="selPrint" class="trans" id="selPrint13" /><label for="selPrint13">Empty Container</label></td>
			</tr>
		</table>
		</div>	
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>