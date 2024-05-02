<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0042.jsp
*@FileTitle  : TDR Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0042Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo"%>
<%
	VopOpf0042Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";
	String strVslCd			= "";
	String strVoyNo			= "";
	String strDirCd			= "";
	String strYdCd			= "";
	String popYn			= "";
	String mainpage 		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (VopOpf0042Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		mainpage = request.getParameter("mainPage");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//Parameters in case of Retrieving TDR
		popYn		= request.getParameter("pop_mode") == null ? "N" : "Y";
		strVslCd	= request.getParameter("vsl_cd") == null ? "" : request.getParameter("vsl_cd");
		strVoyNo	= request.getParameter("voy_no") == null ? "" : request.getParameter("voy_no");
		strDirCd	= request.getParameter("dir_cd") == null ? "" : request.getParameter("dir_cd");
		strYdCd		= request.getParameter("yd_cd") == null ? "" : request.getParameter("yd_cd");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	//Calling Pop_up and initial retrieve condition 
	//Retrieve Pop-up on SCG_0016
	var preConds = {
		pop_yn      : "<%=popYn%>",
		vsl_cd   	: "<%=StringUtil.xssFilter(strVslCd)%>",
		voy_no   	: "<%=StringUtil.xssFilter(strVoyNo)%>",
		dir_cd		: "<%=StringUtil.xssFilter(strDirCd)%>",
		yd_cd		: "<%=StringUtil.xssFilter(strYdCd)%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();

		if("Y" == preConds.pop_yn) {		

			//Showing close button
			document.all.popLayer.style.display = "";

			//Set title of page
			var titleStr = "TDR Inquiry";
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.title.innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	} else {
			  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	}

				if(preConds.vsl_cd != "" && preConds.voy_no != "" && preConds.dir_cd != "" && preConds.yd_cd != ""){
					document.form.vsl_cd.value = preConds.vsl_cd;
					document.form.skd_voy_no.value = preConds.voy_no;
					document.form.skd_dir_cd.value = preConds.dir_cd;

					searchVVDInfo();

					document.form.yd_cd.Code = preConds.yd_cd;
					doActionIBSheet(0, document.form, IBSEARCH);
				}
			}catch(err) {
			 	ComShowMessage(err);
			}
		}

	}
</script>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="port_cd" id="port_cd" />
<input type="hidden" name="voy_no" id="voy_no" />
<input type="hidden" name="dir_cd" id="dir_cd" />
<input type="hidden" name="clpt_ind_seq" id="clpt_ind_seq" />
<input type="hidden" name="sys_create" id="sys_create" />
<input type="hidden" name="comboCd" value="" id="comboCd" />

<input type="hidden" name="chkDate" dataformat="ymdhm" id="chkDate" />
<input type="hidden" name="authbtn" id="authbtn" />

<!-- Container Status -->
<input type="hidden" name="status1" id="status1" />
<input type="hidden" name="status2" id="status2" />
<!-- Specail Carge Status -->
<input type="hidden" name="sc_status1" id="sc_status1" />
<input type="hidden" name="sc_status2" id="sc_status2" />
<input type="hidden" name="sc_status3" id="sc_status3" />
<input type="hidden" name="cargo_type1" id="cargo_type1" />
<input type="hidden" name="cargo_type2" id="cargo_type2" />
<!-- Container No Search -->
<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="misHandleChk" value="SD" id="misHandleChk" />

<!-- TDR_UTILIZE Carge Status -->
<input type="hidden" name="sl_status1" id="sl_status1" />
<input type="hidden" name="sl_status2" id="sl_status2" />

<!-- Report Popup -->
<input type="hidden" size="200" name="com_mrdPath" value="apps/opus/vop/opf/cargoloadingresultmgt/terminaldeparturereport/report/VOP_OPF_1036.mrd" id="com_mrdPath" />
<input type="hidden" size="200" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" size="200" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\" id="com_mrdSaveDialogDir" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="TerminalDepartureReport" id="com_mrdSaveDialogFileName" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="pdf" id="com_mrdSaveDialogFileExt" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" size="200" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />
<input type="hidden" size="200" name="com_mrdTitle" value="Terminal Departure Report" id="com_mrdTitle" />
<input type="hidden" size="200" name="com_mrdBodyTitle" value="Terminal Departure Report" id="com_mrdBodyTitle" />
<input type="hidden" size="200" name="com_isBatch" value="Y" id="com_isBatch" />

<!-- TDR Mail Send -->
<input type="hidden" name="com_rdSubSysCd" value="OPF" id="com_rdSubSysCd" />
<input type="hidden" name="com_from" value="<%=strUsr_eml%>" id="com_from" />
<input type="hidden" name="com_recipient" value="" id="com_recipient" />
<input type="hidden" name="com_carbonCopy" value="<%=strUsr_eml%>" id="com_carbonCopy" />
<input type="hidden" name="com_blindCarbonCopy" id="com_blindCarbonCopy" />
<input type="hidden" name="com_subject" value="" id="com_subject" />
<input type="hidden" name="com_fileKey" id="com_fileKey" />
<input type="hidden" name="com_content" id="com_content" />
<input type="hidden" name="com_templateMrd" value="apps/opus/vop/opf/cargoloadingresultmgt/terminaldeparturereport/report/VOP_OPF_1036.mrd" id="com_templateMrd" />
<input type="hidden" name="com_templateMrdArguments" id="com_templateMrdArguments" />
<input type="hidden" name="com_templateMrdDescription" value="UI_OPF_0036.mrd 파일이 첨부되었습니다." id="com_templateMrdDescription" />

<input type="hidden" name="com_rdExportFileName" value="TerminalDepartureReport.pdf" id="com_rdExportFileName" />
<input type="hidden" name="com_rdExportFileType" value="<%=ExportInfo.FTYPE_PDF%>" id="com_rdExportFileType" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
	--><button type="button" class="btn_normal" name="btn_ExcludefromTPR" id="btn_ExcludefromTPR">Exclude from TPR</button><!--  
	--><button type="button" class="btn_normal" name="btn_Mail"  	id="btn_Mail">Mail</button><!-- 
	--><button type="button" class="btn_normal" name="btn_Print"  	id="btn_Print">Print</button><!-- 
	--><button type="button" style="display: none;" class="btn_normal" name="btn_Close"  id="btn_Close">Close</button><!-- 
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="200">
				<col width="50">
				<col width="*">
			</colgroup>
			<tr>
				<th>VVD CD</th>
				<td style="padding:3px;"><input type="text" style="width:55px;" class="input1" name="vsl_cd" required fullfill caption="Vessel Code" maxlength="4" dataformat="engup" id="vsl_cd" onchange="vsl_cd_onchange()"/><!-- 
					 --><input type="text" style="width:40px;" class="input1" name="skd_voy_no" required fullfill caption="Schedule Voyage Number" maxlength="4" dataformat="engup" id="skd_voy_no" onchange="skd_voy_no_onchange()"/><!-- 
					 --><input type="text" style="width:20px;" class="input1" name="skd_dir_cd" caption="Schedule Direction Code" maxlength="1" dataformat="engup" id="skd_dir_cd" onchange="skd_dir_cd_onchange()" /><!--
					--><button type="button" id="btns_searchVvd" name="btns_searchVvd" class="input_seach_btn"></button>
				</td>
				<th>Port</th>
				<td><script language="javascript">ComComboObject('yd_cd', 3, 100, 0, 1, 0, true);</script><!-- 
					 --><input type="text" style="width:340px;" class="input2" name="yd_nm" id="yd_nm" readonly></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tabTdr')</script>
	</div>
	<div id="tabLayer" style="display:none;">
		<table>
			<colgroup>
				<col width="170">
				<col width="*">
			</colgroup>
			<tr>
				<th class="title_design">Arrival/Departure Time</th>
				<td>&nbsp;</td>
			</tr>
		</table>
		<div class="opus_design_data wFit">
			<table class="grid_2">
				<colgroup>
					<col width="200" />
					<col width="*" />
					<col width="200" />
					<col width="*" />
				</colgroup>
				<tr>
		   		   <th style="text-align: center; padding: 3px" colspan="2"><b>Arrival</b></th>
				   <th style="text-align: center;" colspan="2"><b>Departure</b></th>
				</tr>
				<tr>
					<th><b>First Pilot On</b></th>
					<td style="padding:3px;"><input type="text" style="width:120px;" readonly class="input" value="" name="first_pilot_on" maxlength="16" dataformat="ymdhm" caption="First Pilot On" id="first_pilot_on" /></td>
					<th><b>Unberth</b></th>
					<td style="padding:3px;"><input type="text" style="width:120px;" readonly class="input" value="" name="unberth" maxlength="16" dataformat="ymdhm" id="unberth" /></td>
				</tr>
				<tr>
					<th><b>Anchorage</b></th>
					<td style="padding:3px;"><input type="text" style="width:120px;"  class="input" value="" readonly name="anchorage_arr" dataformat="ymdhm" maxlength="16" id="anchorage_arr" /></td>
					<th><b>Anchorage</b></th>
					<td style="padding:3px;"><input type="text" style="width:120px;" class="input" value="" readonly name="anchorage_dep" dataformat="ymdhm" maxlength="16" id="anchorage_dep" /></td>
				</tr>
				<tr>
					<th><b>Berth</b></th>
					<td style="padding:3px;"><input type="text" style="width:120px;" class="input" value="" readonly name="berth" dataformat="ymdhm" maxlength="16" id="berth" /></td>
					<th><b>Last Pilot Off</b></th>
					<td style="padding:3px;"><input type="text" style="width:120px;" class="input" value="" readonly name="last_pilot_off" dataformat="ymdhm" maxlength="16" id="last_pilot_off" /></td>
				</tr>
				<tr>
					<td colspan="2" rowspan="2" class="input2"></td>
					<th><b>ETA Next Port</b></th>
					<td style="padding:3px;"><input type="text" style="width:55px;" value="" name="eta_next_port" fullfill readonly id="eta_next_port" /><input type="text" style="width:120px;"  value="" name="eta_next_date" dataformat="ymdhm" maxlength="16" readonly id="eta_next_date" /></td>
				</tr>
				<tr>
					<th><b>ETA Canal</b></th>
					<td style="padding:3px;"><input type="text" style="width:55px;" value="" name="next_canal" fullfill readonly id="next_canal" /><input type="text" style="width:120px;" value="" name="eta_canal" dataformat="ymdhm" maxlength="16" readonly id="eta_canal" /></td>
				</tr>
			</table>
		</div>
		<table class="line_bluedot wFit mar_top_12"><tr><td colspan="8"></td></tr></table>
		<table>
			<colgroup>
				<col width="150">
				<col width="*">
			</colgroup>
			<tr>
				<th class="title_design">Vessel Condition</th>
				<td>&nbsp;</td>
			</tr>
		</table>
		<div class="opus_design_data wFit">
			<table class="grid_2">
				<tr>
				   <th></th>
				   <th style="text-align: center; padding: 3px" colspan="6"><b>Arrival</b></th>
				   <th style="text-align: center;" colspan="6"><b>Departure</b></th>
				</tr>
				<tr>
					<th><b>Draft (meter)</b></th>
					<th><b>FWD</th>
					<td style="padding:3px;"><input type="text" style="width:80px;text-align:right;" readonly class="input" value="" name="arr_draft_fwd" dataformat="num" maxlength="12" id="arr_draft_fwd" /> </td>
					<th><b>AFT</b></th>
					<td style="padding:3px;" colspan="3"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="arr_draft_aft" dataformat="num" maxlength="12" id="arr_draft_aft" /> </td>
					<th><b>FWD</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="dep_draft_fwd" dataformat="num" maxlength="12" id="dep_draft_fwd" /> </td>
					<th><b>AFT</b></th>
					<td style="padding:3px;" colspan="3"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="dep_draft_aft" dataformat="num" maxlength="12" id="dep_draft_aft" /> </td>
				</tr>
				<tr>
					<th><b>Ballast (M/T)</b></th>
					<td colspan="6"><input type="text" readonly style="width:129px;text-align:right;" class="input" value="" name="arr_ballast" dataformat="float" maxlength="17" id="arr_ballast" /> </td>
					<td colspan="6"><input type="text" readonly style="width:129px;text-align:right;" class="input" value="" name="dep_ballast" dataformat="float" maxlength="17" id="dep_ballast" /> </td>
				</tr>
				<tr>
					<th><b>ROB (M/T)</b></th>
					<th><b>F.O</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="arr_rob_fo" dataformat="float" maxlength="17" id="arr_rob_fo" /></td>
					<th><b>D.O</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="arr_rob_do" dataformat="float" maxlength="17" id="arr_rob_do" /></td>
					<th><b>F.W</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:90px;text-align:right;" class="input" value="" name="arr_rob_fw" dataformat="float" maxlength="17" id="arr_rob_fw" /></td>
					<th><b>F.O</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="dep_rob_fo" dataformat="float" maxlength="17" id="dep_rob_fo" /></td>
					<th><b>D.O</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="dep_rob_do" dataformat="float" maxlength="17" id="dep_rob_do" /></td>
					<th><b>F.W</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:90px;text-align:right;" class="input" value="" name="dep_rob_fw" dataformat="float" id="dep_rob_fw" /></td>
				</tr>
				<tr>
					<th><b>Low Sulphur (M/T)</b></th>
					<th><b>F.O</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="arr_low_sul_fo" maxlength="17" dataformat="float" id="arr_low_sul_fo" /></td>
					<th><b>D.O</b></th>
					<td style="padding:3px;" colspan="3"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="arr_low_sul_do" maxlength="17" dataformat="float" id="arr_low_sul_do" /></td>
					<th><b>F.O</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="dep_low_sul_fo" maxlength="17" dataformat="float" id="dep_low_sul_fo" /></td>
					<th><b>D.O</b></th>
					<td style="padding:3px;" colspan="3"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="dep_low_sul_do" maxlength="17" dataformat="float" id="dep_low_sul_do" /></td>
				</tr>
				<tr>
					<th colspan="7"><b>Supply (M/T)</b></th>
					<th><b>F.O</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="dep_slp_fo" dataformat="float" maxlength="17" id="dep_slp_fo" /></td>
					<th><b>D.O</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="dep_slp_do" dataformat="float" maxlength="17" id="dep_slp_do" /></td>
					<th><b>F.W</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:90px;text-align:right;" class="input" value="" name="dep_slp_fw" dataformat="float" maxlength="17" id="dep_slp_fw" /></td>
				</tr>
				<tr>
					<th colspan="7"><b>Supply Low Sulphur (M/T)</b></th>
					<th><b>F.O</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="dep_low_sul_fo_wgt" maxlength="17" dataformat="float" id="dep_low_sul_fo_wgt" /></td>
					<th><b>D.O</b></th>
					<td colspan="3"><input type="text" readonly style="width:80px;text-align:right;" class="input" value="" name="dep_low_sul_do_wgt" maxlength="17" dataformat="float" id="dep_low_sul_do_wgt" /></td>
				</tr>
				<tr>
					<th><b>DWT/Displ. (M/T)</b></th>
					<td colspan="2"><input type="text" readonly style="width:129px;text-align:right;" class="input" value="" name="arr_dwt" dataformat="float" maxlength="17" id="arr_dwt" /> </td>
					<td colspan="4"><input type="text" readonly style="width:129px;text-align:right;" class="input" value="" name="arr_displt" maxlength="17" dataformat="float" id="arr_displt" /> </td>
					<td colspan="2"><input type="text" readonly style="width:129px;text-align:right;" class="input" value="" name="dep_dwt" dataformat="float" maxlength="17" id="dep_dwt" /> </td>
					<td colspan="4"><input type="text" readonly style="width:129px;text-align:right;" class="input" value="" name="dep_displ" maxlength="17" dataformat="float" id="dep_displ" /> </td>
				</tr>
				<tr>
					<th><b>GM (meter</b></th>
					<td colspan="2"><input type="text" readonly style="width:129px;text-align:right;" class="input" value="" name="arr_gm" maxlength="17" dataformat="num" id="arr_gm" /></td>
					<td colspan="4" class="input2"></td>
					<td colspan="2"><input type="text" readonly style="width:129px;text-align:right;" class="input" value="" name="dep_gm" maxlength="17" dataformat="num" id="dep_gm" /></td>
					<td colspan="4" class="input2"></td>
				</tr>
				<tr>
					<th><b>Tugboat</b></th>
					<td colspan="2"><input type="text" readonly style="width:129px;text-align:right;" class="input" value="" name="arr_tugboat" dataformat="num" maxlength="17" id="arr_tugboat" /></td>
					<td colspan="4" class="input2"></td>
					<td colspan="2"><input type="text" readonly style="width:129px;text-align:right;" class="input" value="" name="dep_tugboat" dataformat="num" maxlength="17" id="dep_tugboat" /></td>
					<td colspan="4" class="input2"></td>
				</tr>
			</table>
		</div>
		<div class="opus_design_grid" id="mainTable" style="display:none;">
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" style="display:none;">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100">
					<col width="140">
					<col width="180">
					<col width="*">
				</colgroup>
				<tr>
					<th><b>Number of Used Crane</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:60px;text-align:center" class="input" value="" dataformat="num" name="used_crane" id="used_crane" onblur="used_crane_onblur()"/> </td>
					<th><b>Average Number of Used Crane</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:60px;text-align:center" class="input" value="" name="avg_crane" readonly id="avg_crane" /> </td>
				</tr>
			</table>
		</div>
		<h3 class="title_design mar_top_12 mar_btm_4">Working Hours</h3>
		<div class="opus_design_data wFit">
			<table class="grid_2">
				<colgroup>
					<col width="200">
					<col width="*">
					<col width="200">
					<col width="*">
					<col width="200">
					<col width="*">
				</colgroup>
				<tr>
					<th><b>Gross Work Hours</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;text-align:right;" class="input" value="" name="gross_work" maxlength="8" id="gross_work" /></td>
					<th><b>Net Work Hours</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;text-align:right;" class="input" value="" name="net_work" id="net_work" /></td>
					<th id="net_work" name="net_work" ><b>Lost Time by G/Crane</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;text-align:right;" class="input" value="" name="lost_time" id="lost_time" /></td>
				</tr>
				<tr>
					<th><b>Gross Gang Hours</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;text-align:right;" class="input" value="" name="gross_gang" id="gross_gang" /></td>
					<th><b>Net Gang Hours</b></th>
					<td style="padding:3px;" colspan="3"><input type="text" readonly style="width:110px;text-align:right;" class="input" value="" name="net_gang" id="net_gang" /></td>
				</tr>
			</table> 
		</div>
		<h3 class="title_design mar_top_12 mar_btm_4">Handling Moves</h3>
		<div class="opus_design_data wFit">
			<table class="grid_2">
				<colgroup>
					<col width="200">
					<col width="*">
					<col width="200">
					<col width="*">
					<col width="200">
					<col width="*">
				</colgroup>
				<tr>
					<th><b>Hatch Cover Handling</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;text-align:right;" class="input" value="" name="hatch_handl" dataformat="num" maxlength="4" id="hatch_handl" /></td>
					<th><b>Gear Box Handling</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;text-align:right;" class="input" value="" name="gear_handl" dataformat="num" maxlength="4" id="gear_handl" /></td>
					<th><b>Total Container Handling Moves</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;text-align:right;" class="input" value="" name="move_handl" dataformat="num" maxlength="6" id="move_handl" /></td>
				</tr>
			</table> 
		</div>
		<h3 class="title_design mar_top_12 mar_btm_4">Productivity</h3>		
		<div class="opus_design_data mar_btm_12 wFit">
			<table class="grid_2">
				<colgroup>
					<col width="130">
					<col width="70">
					<col width="120">
					<col width="60">
					<col width="130">
					<col width="125">
					<col width="60">
					<col width="120">
					<col width="60">
					<col width="*">
				</colgroup>
				<tr>
					<th><b>Terminal</b></th>
					<th><b>Gross</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;%;text-align:right;" class="input" value="" name="tmnl_gross" dataformat="float" maxlength="7" id="tmnl_gross" /></td>
					<th><b>Net</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;%;text-align:right;" class="input" value="" name="tmnl_net" dataformat="float" maxlength="7" id="tmnl_net" /></td>
					<th><b>Per Gang</b></th>
					<th><b>Gross</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;%;text-align:right;" class="input" value="" name="per_gang_gross" dataformat="float" maxlength="7" id="per_gang_gross" /></td>
					<th><b>Net</b></th>
					<td style="padding:3px;"><input type="text" readonly style="width:110px;%;text-align:right;" class="input" value="" name="per_gan_net" dataformat="float" maxlength="7" id="per_gan_net" /></td>
				</tr>
			</table> 
		</div>
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" style="display:none;">
		<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="445px"></iframe>
	</div>
	<div id="tabLayer" style="display:none;">
		 <iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="445px"></iframe>
	</div>
	<div id="tabLayer" style="display:none;">
		 <iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="445px"></iframe>
	</div>
	<div id="tabLayer" style="display:none;">
		 <iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="445px"></iframe>
	</div>
	<div id="tabLayer" style="display:none;">
		 <iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="445px"></iframe> 
	</div>
	<div id="tabLayer" style="display:none;">
		 <iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="445px"></iframe> 
	</div>
	<div id="tabLayer" style="display:none;">
		 <iframe name="t9frame" id="t9frame" frameborder="0" scrolling="no" width="100%" height="445px"></iframe> 
	</div>
	<div id="tabLayer" style="display:none;">
		<div class="opus_design_data">
			<table>
				<tr>
					<td><textarea style="width:100%;height:420px;resize:none;" name="tdr_info" id="tdr_info" class="input2" readonly onblur="tdr_info_onchange()"></textarea></td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div id="tdrHeader" style="display:none;">
	<script language="javascript">ComSheetObject('sheetTdrH');</script>
</div>
</form>