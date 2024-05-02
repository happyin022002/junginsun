<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0107.js
*@FileTitle  : TPB Group Remaking 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
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
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.event.EsdTpb0107Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0107Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.OutstandingGroupmanage");
	
	String ofc_cd = "";
	String rhq_cd = "";
	String currentDay = DateTime.getFormatString("yyyy-MM-dd");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EsdTpb0107Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String[] officeInfo = TPBUtils.getHandleOfficeLevel( ofc_cd ); // 0:Office Level / 1:Office Code / 2:R.HQ Code / 3:HO Code
	String ofc_lvl = JSPUtil.getNull( officeInfo[0] ); // Office Level
	rhq_cd  = JSPUtil.getNull( officeInfo[2] ); // RHQ Code
%>

<script >
	function setupPage(){
		//alert("InitTab");
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//alert("loadPageEND");
		_text_ChangeUpperCase(); // automatic change to uppercase
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_bkg_no" id="s_bkg_no" />
<input type="hidden" name="s_bkg_no_split" id="s_bkg_no_split" />
<input type="hidden" name="s_bl_no_chk" id="s_bl_no_chk" />
<input type="hidden" name="s_bl_no" id="s_bl_no" />
<input type="hidden" name="s_bl_no_tp" id="s_bl_no_tp" />
<input type="hidden" name="s_vsl_cd" id="s_vsl_cd" />
<input type="hidden" name="s_skd_voy_no" id="s_skd_voy_no" />
<input type="hidden" name="s_skd_dir_cd" id="s_skd_dir_cd" />
<input type="hidden" name="s_n3pty_no" id="s_n3pty_no" />
<input type="hidden" name="s_dao_n3pty_no" id="s_dao_n3pty_no" />
<input type="hidden" name="s_h_ots_sts_cd" id="s_h_ots_sts_cd" />
<input type="hidden" name="s_trd_party_code" id="s_trd_party_code" />
<input type="hidden" name="s_h_vndr_cust_div_cd" id="s_h_vndr_cust_div_cd" />
<input type="hidden" name="s_h_n3pty_inv_no" id="s_h_n3pty_inv_no" />
<input type="hidden" name="s_cfm_dt" id="s_cfm_dt" />
<input type="hidden" name="s_cfm_dt_prev" id="s_cfm_dt_prev" />
<input type="hidden" name="s_cfm_dt_last" id="s_cfm_dt_last" />
<%--
<input type="hidden" name="s_vndr_cnt_cd">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_cust_cnt_cd">
<input type="hidden" name="s_cust_seq">
<input type="hidden" name="s_n3pty_ofc_cd">
--%>
<input type="hidden" name="sdate" id="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>">
<input type="hidden" name="edate" id="edate" value="<%=currentDay%>">
<input type="hidden" name="s_office_level" id="s_office_level" value="<%=ofc_lvl%>">
<input type="hidden" name="s_rhq_cd_for_rhq" id="s_rhq_cd_for_rhq" value="<%=rhq_cd%>">
<input type="hidden" name="s_ofc_cd_for_rhq" id="s_ofc_cd_for_rhq" value="<%=ofc_cd%>">
<input type="hidden" name="s_user_ofc_cd" id="s_user_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="s_user_id" id="s_user_id" value="<%=strUsr_id%>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button>	<!-- 		
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="10px" />
				<col width="50px" />
				<col width="150px" />
				<col width="50px" />
				<col width="150px" />
				<col width="50px" />
				<col width="150px" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th>Period</th>
				<td><input id="s_sdate" name="s_sdate" style="width:70px;" value="<%=DateTime.addMonths(currentDay, -1, "yyyy-MM-dd")%>" type="text" />~ <input id="s_edate" name="s_edate" style="width:70px;" value="<%=currentDay%>" caption="Date" data_format="ymd" onkeydown="tpb_isNumD(this, 'Y');" onblur="tpb_validateDateObj(this);" type="text" /><button class="calendar ir" name="btns_calendar2" id="btns_calendar2" type="button"></button></td>
				<th>RHQ</th>
				<td>
					<select class="input1" style="width: 90px" name="s_if_rhq_cd" id="s_if_rhq_cd" required caption="RHQ">
						<option value="" selected>Select</option>
					</select>
				</td>
				<th>Office</th>
				<td>
					<select class="input1" style="width: 100px" name="s_if_ofc_cd" id="s_if_ofc_cd" required caption="Office">
						<option value="" selected>Select</option>
					</select>
				</td>					
				<td></td> 
			</tr>
			<tr>
				<td></td>
				<th>Expiration Type</th>
				<td><%=JSPUtil.getCodeCombo("s_n3pty_src_sub_sys_cd", "", "style='width:162'", "CD00580", 0, "001: :ALL|")%><select name="s_n3pty_bil_tp_cd" id="s_n3pty_bil_tp_cd" style="width: 100px">
						<option value=''>Select</option>
					</select>
				</td>
				<th>3rd Party</th>
				<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:90'", "CD00583", 0, "001: :Select|")%><input type="text" style="width:70;" name="s_trd_party_val" maxlength="8" readonly><button type="button" class="input_seach_btn" name="btn_3rdParty" id="btn_3rdParty"></button></td>
				<td></td>
				<td></td>			
				<td></td> 
			</tr>
			<tr>
				<td></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input id="s_vvd" style="width:95px;" name="s_vvd" maxlength="9" type="text" /><button class="input_seach_btn" name="btn_vvd" id="btn_vvd" type="button"></button></td>
				<th>Booking No.</th>
				<td><input id="s_bkg_no_all" style="width:164px;" name="s_bkg_no_all" maxlength="13" onblur="getBLNo(this.form,this,'s_')" type="text" /></td>
				<th>B/L No.</th>
				<td><input id="s_bl_no_all" style="width:100px;" name="s_bl_no_all" maxlength="12" type="text" /></td>		
				<td></td> 
			</tr>
			<tr>
				<td></td>
				<th>Equipment No.</th>
				<td><input id="s_eq_no" style="width:95px;" name="s_eq_no" maxlength="11" type="text" /></td>
				<th>TPB No</th>
				<td><input id="s_n3pty_no_search" style="width:164px;" name="s_n3pty_no_search" maxlength="14" type="text" /> </td>
				<td></td>
				<td></td>
				<td></td> 
			</tr>
			<tr>
				<td></td>
				<th>Candidate</th>
				<td class="sm pad_left_4" style="height:25px;"><input id="s_candidate_include_flag" name="s_candidate_include_flag" value="I" style="border:0;" type="radio" /> <strong>Include</strong> <input id="s_candidate_include_flag" name="s_candidate_include_flag" value="E" style="border:0;" checked type="radio" /> <strong>Exclude</strong></td>
				<th></th>
				<td></td>
				<td></td>
				<td></td>
				<td></td> 
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
