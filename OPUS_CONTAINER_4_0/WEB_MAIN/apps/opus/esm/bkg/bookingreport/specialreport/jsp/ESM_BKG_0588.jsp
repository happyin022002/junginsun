<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0588.jsp
*@FileTitle  : Special cargo summary information 
*@author     : CLT
*@version    : 1.0
*@since      : 04/28/2014
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.specialreport.event.EsmBkg0588Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0588Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.SpecialReport");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0588Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="ch_usr_id" id="ch_usr_id">
<input type="hidden" name="com_mrdPath" id="com_mrdPath" >
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle">
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_printfor" id="btn_printfor">Print for CBF</button><!--
		--><button type="button" class="btn_normal" name="btn_application" id="btn_application">Application</button><!--
		--><button type="button" class="btn_normal" name="btn_approval" id="btn_save">Approval Result Detail</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
	<colgroup>
					<col width="5"/>
					<col width="42"/>
					<col width="130"/>
					<col width="30"/>
					<col width="130"/>
					<col width="128"/>
					<col width="113"/>
					<col width="50"/>
					<col width="73"/>
					<col width="150"/>
					<col width="*" />
	</colgroup>
		<tbody>
			<tr>
				<td></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td>
					<input type="text" name="vvd_cd" id="vvd_cd" style="width:112px;" class="input1" value="" style="ime-mode:disabled" dataformat="engup"  caption="T/VVD" maxlength="9" required>
				</td>
				<th class="sm">POL</th>
				<td class="sm">
					<input type="text" name="pol_cd" id="pol_cd" style="width:53px;" class="input1" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engup" required>
					<input type="text" name="pol_nod_cd" id="pol_nod_cd" style="width:25px;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup"><!--
					--><button type="button" id="btn_0083PolPop" name="btn_0083PolPop" class="input_seach_btn"></button>
				</td>
				<th class="sm">
				<label for="chk_l_type">Local</label><input type="checkbox" name="chk_l_type" id="chk_l_type"  value="Y" class="trans">
				<label for="chk_t_type">T/S</label><input type="checkbox" name="chk_t_type" id="chk_t_type" value="Y" class="trans">
				</th>
				
				<th>Zone</th>
				<td>
					<script type="text/javascript">ComComboObject('zone_code',1, 80, 0,0);</script>
				</td>
				<th>Option</th>
				<td class="sm">
					<input type="radio" name="spcl_cgo_type" id="spcl_cgo_type1" value="" class="trans" checked><label for="spcl_cgo_type1">ALL</label>
					<input type="radio" name="spcl_cgo_type" id="spcl_cgo_type2" value="DG" class="trans"><label for="spcl_cgo_type2">DG</label>
					<input type="radio" name="spcl_cgo_type" id="spcl_cgo_type3" value="RF" class="trans"><label for="spcl_cgo_type3">RF</label>
					<input type="radio" name="spcl_cgo_type" id="spcl_cgo_type4" value="AK" class="trans"><label for="spcl_cgo_type4">AK</label>
					<input type="radio" name="spcl_cgo_type" id="spcl_cgo_type5" value="BB" class="trans"><label for="spcl_cgo_type5">BB</label>
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="5"/>
				<col width="42"/>
				<col width="130"/>
				<col width="30"/>
				<col width="150"/>
				<col width="30"/>
				<col width="150"/>
				<col width="55"/>
				<col width="90"/>
				<col width="45"/>
				<col width="80"/>
				<col width="60"/>
				<col width="200"/>
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th title="Port of Discharging">POD</th>
				<td>
					<input type="text" name="pod_cd" id="pod_cd" style="width:53px;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engup"><!--
					--><input type="text" name="pod_nod_cd" id="pod_nod_cd" style="width:25px;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup"><!--
					--><button type="button" id="btn_0083PodPop" name="btn_0083PodPop" class="input_seach_btn"></button>
				</td>
				<th title="Place of Receipt">POR</th>
				<td>
					<input type="text" name="por_cd" id="por_cd" style="width:55px;" class="input" value="" maxlength=5 style="ime-mode:disabled"  dataformat="engup"><!--
					--><input type="text" name="por_nod_cd" id="por_nod_cd" style="width:25px;" class="input" value="" maxlength=2 style="ime-mode:disabled"  dataformat="engup"><!--
					--><button type="button" id="btn_0083PorPop" name="btn_0083PorPop" class="input_seach_btn"></button>
				</td >
				<th title="Place of Delivery">DEL</th>
				<td>
					<input type="text" name="del_cd" id="del_cd" style="width:55px;" class="input" value="" maxlength=5 style="ime-mode:disabled" dataformat="engup"><!--
					--><input type="text" name="del_nod_cd" id="del_nod_cd" style="width:25px;" class="input" value="" maxlength=2 style="ime-mode:disabled" dataformat="engup"><!--
					--><button type="button" id="btn_0083DelPop" name="btn_0083DelPop" class="input_seach_btn"></button>
				</td>
				<th>BKG OFC</th>
				<td>
					<input type="text" name="bkg_ofc_cd"  id="bkg_ofc_cd" style="width:60px;" value="" style="ime-mode:disabled" dataformat="enguponly" caption="BKG Office" maxlength="6" >
				</td>
				<th>S.Rep</th>
				<td>
					<input type="text" name="ob_srep_cd" id="ob_srep_cd" style="width:55px;" value="" style="ime-mode:disabled" dataformat="enguponly" caption="S.Rep" maxlength="4">
				</td>
				<th>BKG Staff</th>
				<td class="sm">
					<input type="radio" name="bkg_staff_type" id="bkg_staff_type1" value="ID" class="trans" checked><label for="bkg_staff_type1">ID</label>
					<input type="radio" name="bkg_staff_type" id="bkg_staff_type2" value="NAME" class="trans"><label for="bkg_staff_type2">Name</label>
					<input type="text" name="bkg_staff" style="width: 80px;" value="" maxlength="20" dataformat="engup">
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
					<col width="5"/>
					<col width="30"/>
					<col width="110"/>
					<col width="150"/>
					<col width="*"/>
			</colgroup>
			<tr>
				<td></td>
				<th>Status</th>
				<td>
					<script type="text/javascript">ComComboObject('bkg_sts_cd',1,111, 0,0);</script>
				</td>
				<th>
				<label for="spcl_cgo_apro_cd">Non Approval & container match</label><input type="checkbox" name="spcl_cgo_apro_cd" id="spcl_cgo_apro_cd" class="trans" value="Y">
				</th>
				
				<td></td>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div>	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<div class="wrap_result">
<!-- opus_design_grid(E) -->
</form>