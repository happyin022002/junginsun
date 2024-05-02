<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0055.jsp
*@FileTitle  : D/Dock Schedule Review - Graph
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event.EsmFms0055Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmFms0055Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutFleetManagement.TCharIODockSchedule");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmFms0055Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		log.error("err " + e.toString(), e);
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

<input type="hidden" name="snd_year" id="snd_year" />
<input type="hidden" name="trd_year" id="trd_year" />
<input type="hidden" name="flet_dck_svey_tp_nm" id="flet_dck_svey_tp_nm" />
<input type="hidden" name="reflection_nm" id="reflection_nm" />
<input type="hidden" name="usr_id" value="<%=strUsr_id			%>" id="usr_id" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Dry Dock Schedule" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Dry Dock Schedule" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Dry Dock Schedule" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new" >New</button><!--
		--><button class="btn_normal" type="button" name="btn_DownExcel" id="btn_DownExcel" >Down Excel</button><!--
		--><button class="btn_normal" type="button" name="btn_Print" id="btn_Print" >Print</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90" />				
				<col width="250" />				
				<col width="50" />				
				<col width="140" />				
				<col width="80" />
				<col width="110" />
				<col width="70" />
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<tr>
					<th>Vessel Code</th>
					<td><input dataformat="engup" type="text" style="width:54px;text-align:center;" class="input" value="" maxlength="4" id="vsl_cd" name="vsl_cd"  caption="Vessel Code" style="ime-mode:disabled"><!--
					--><button type="button" name="btn_vslpop" id="btn_vslpop"  class="input_seach_btn"></button><!--
					--><input type="text" style="width:162px;" class="input2" name="vsl_eng_nm" id="vsl_eng_nm" readonly value=""></td>
					<th>Lane</th>
					<td><input dataformat="engup" type="text" style="width:50px;text-align:center;" class="input" maxlength="3" name="lane_cd" id="lane_cd" caption="Lane" style="ime-mode:disabled"><!--
					--><button type="button" name="btn_lanepop" id="btn_lanepop"  class="input_seach_btn"></button>
					<th>Contract TP</th>
					<td><select name="flet_ctrt_tp_cd" style="width:80px;"><option value="" selected>All</option></select></td>
					<th>Vessel Size</th>
					<td><input type="text" name="vsl_dznd_capa_fr" id="vsl_dznd_capa_fr" style="width:60px;text-align:right;ime-mode:disabled;" class="input" maxlength="5" dataformat="num" value=""><!--
					-->~ <!--
					--><input type="text"  name="vsl_dznd_capa_to" id="vsl_dznd_capa_to" style="width:60px;text-align:right;ime-mode:disabled;" class="input" maxlength="5" dataformat="num" value=""></td></tr>
				<tr>
					<th>D/Dock TP</th>
					<td><select name="flet_dck_svey_tp_cd" style="width:223px;" class="input1"><!--
					--><option value="" selected>All Types</option></select>
					<th>Duration</th>
					<td><input type="text" name="fr_duration" id="fr_duration" style="width:50px;text-align:center;ime-mode:disabled; " class="input1" maxlength="4" dataformat="yyyy" required  caption="Duration"><!--
					--><button type="button" name="btn_fr_duration" id="btn_fr_duration"  class="calendar ir"></button><!--
					-->~ <input type="text" name="to_duration" id="to_duration" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" maxlength="4" dataformat="yyyy" required  caption="Duration"><!--
					--><button type="button" name="btn_to_duration" id="btn_to_duration"  class="calendar ir"></button></td>
					<th>Owner</th>
					<td><input type="text" style="width:141px;" class="input2" name="ownr_nm" id="ownr_nm" caption="Owner" readonly><!--
					--><button type="button" name="btn_ownerpop" id="btn_ownerpop"  class="input_seach_btn"></button><!--
					--><input type="hidden" name="ownr_seq" id="ownr_seq"><input type="checkbox" name="btn_ownrclr" id="btn_ownrclr" class="trans"></td>
				</tr>
				<tr>
					<th>Reflection of Phase in / out</th>
					<td><select name="reflection_cd" style="width:138px;" class="input1"><option value="I">Included</option><option value="E" selected>Excluded</option></select></td></tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->			
</div>
</form>