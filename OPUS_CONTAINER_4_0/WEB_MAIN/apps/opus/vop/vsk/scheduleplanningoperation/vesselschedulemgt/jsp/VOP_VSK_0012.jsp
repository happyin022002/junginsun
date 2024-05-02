<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0012.jsp
*@FileTitle  : Long Range SKD  Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0012Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String eml 				= "";
	String popYn			= "";
	String selectYn		= "";

	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		eml = account.getUsr_eml();


		event = (VopVsk0012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		popYn	= request.getParameter("pop_mode") == null ? "N" : "Y";
		selectYn	= request.getParameter("select_mode") == null ? "N" : "Y";

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var conds = {
		pop_yn : "<%=popYn%>",
		select_yn : "<%=selectYn%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="vsl_slan_cd" id="vsl_slan_cd" />
<input type="hidden" name="tmp_vsl_slan_cd" id="tmp_vsl_slan_cd" />
<input type="hidden" name="tmp_vsl_cd" id="tmp_vsl_cd" />

<input type="hidden" name="com_subject" id="com_subject" />
<input type="hidden" name="com_content" id="com_content" />
<input type="hidden" name="com_from" value="<%=eml%>" id="com_from" />

<input type="hidden" name="pop_yn" value="<%=popYn %>" id="pop_yn" />
<input type="hidden" name="select_yn" value="<%=selectYn %>" id="select_yn" />

<%if("Y".equals(selectYn)){%>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Long Range SKD Inquiry</span></h2>
		
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		 --><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		 --><button class="btn_normal" name="btn_EMail" id="btn_EMail" type="button">E-Mail</button><!--
		 --><button class="btn_normal" name="btn_OK" id="btn_OK" type="button">OK</button><!--
		 --><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
	</div>
</div>
<%}else{%>
<div class="page_title_area clear">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
	 --><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
	 --><button class="btn_normal" name="btn_EMail" id="btn_EMail" type="button">E-Mail</button>
	</div>

	<div class="location">	
		<span id="navigation"></span>
	</div>
</div>
<%}%>

<%if("Y".equals(selectYn)){%><div class="layer_popup_contents"><%}%>
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="585" />				
				<col width="90" />				
				<col width="200" />				
				<col width="*" />
		   </colgroup>
		   <tbody>
		   		<tr>
					<th>Period</th>
					<td><input type="text" name="start_year" style="width:40px;text-align:center;" class="input1" value="" tabindex="2" maxlength="4" dataformat="yyyy"><!--
					--><button type="button" name="btns_back1" id="btns_back1" class="btn_left"></button><!--
					--><button type="button" name="btns_next1" id="btns_next1" class="btn_right"></button><!--
					--><select name="start_qt" style="width: 60px;" class="input1" tabindex="3" ><!--
					--><option value="1">1/4</option><option value="2">2/4</option><option value="3">3/4</option><option value="4">4/4</option></select><!--
					--><input type="text" name="start_date" style="width:80px;text-align:center;" class="input1" dataformat="ymd" caption="Start date" tabindex="4" maxlength="8" size="10"><!--
					--><button type="button" name="btns_calendar1" id="btns_calendar1"  class="calendar ir"></button><!--
					--><span class="dash">~</span><!--
					--><input type="text" name="end_year" id="end_year" style="width:40px;text-align:center;" class="input1" tabindex="5" maxlength="4" dataformat="yyyy"><!--
					--><button type="button" name="btns_back2" id="btns_back2" class="btn_left"></button><!--
					--><button type="button" name="btns_next2" id="btns_next2" class="btn_right"></button><!--
					--><select name="end_qt" style="width: 60px;" class="input1" tabindex="6"><!--
					--><option value="1">1/4</option><!--
					--><option value="2">2/4</option><!--
					--><option value="3">3/4</option><!--
					--><option value="4">4/4</option></select><input type="text" name="end_date" id="end_date" style="width: 100px;text-align:center" class="input1" dataformat="ymd" caption="End Date" tabindex="7" maxlength="8" size="10"><!--
					--><button type="button" name="btns_calendar2" id="btns_calendar2"  class="calendar ir"></button>
					</td>
					<th>Created Date</th>
					<td><input type="text" name="cre_dt" id="cre_dt" style="width:110px;text-align:center"  class="input2" value="" readonly><input type="text" name="cre_usr_id" id="cre_usr_id" style="width:80px;text-align:center" class="input2"  value="" readonly></td>
					<td width="0"></td>
		   		</tr>
		   	</tbody>
		</table>
		<table>
			<colgroup>
				<col width="70" />				
				<col width="80" />				
				<col width="90" />				
				<col width="415" />
				<col width="90" />
				<col width="200" />
				<col width="*" />
		   </colgroup>
		   		<tbody>
			   		<tr>
					<th>Lane Code</th>
					<td>
						<span id="span_vsl_slan_cd_1" style="display:block">
							<input type="text" name="vsl_slan_cd_1" style="width:40px;text-align:center;ime-mode:disabled" class="input" tabindex="1" maxlength="3" id="vsl_slan_cd_1" dataformat="engup"/><!--
							--><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button>
						</span>
						<span id="span_vsl_slan_cd_2" style="display:none">
							<select name="vsl_slan_cd_2" tabindex="1"></select>
						</span>
					</td>
					<th>Vessel Code</th>
					<td>
					<input type="text" name="vsl_cd" style="width:45px;text-align:center;ime-mode:disabled" value="" class="input" tabindex="8" maxlength="4" id="vsl_cd" dataformat="engup"/><!--
					--><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button>
					<th>Updated Date</th>
					<td><input type="text" name="upd_dt" style="width:110px;text-align:center" class="input2" value="" readonly id="upd_dt" /><input type="text" name="upd_usr_id" style="width:80px;text-align:center" class="input2" value="" readonly id="upd_usr_id" /></td>
					<th></th>
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
	<div class="opus_design_grid" id="sheet_div">
		<!-- opus_design_btn (S) -->
		<table id="mainTb" style="width:100%">
			<colgroup>
				<col width="50">				
				<col width="4">				
				<col width="50">				
				<col width="4">				
				<col width="50">				
				<col width="*">				
	   		</colgroup>				
			<tr>
				<td class="pad_btm_4"><div style="width:50px;background-color: yellow;text-align: center;padding: 5px 0;">Delay</div></td>
				<td></td><td class="pad_btm_4"><div style="width:50px;background-color: lightgreen;text-align: center;padding: 5px 0">Skip</div></td>
				<td></td><td class="pad_btm_4"><div style="width:50px;background-color: gray;text-align: center;padding: 5px 0">Reverse</div></td>
				<td align="right"><div class="opus_design_btn"><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button></div></td>
			</tr>
		</table>
		<!-- opus_design_btn (E) -->
		<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet3');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
<%if("Y".equals(selectYn)){%></div><%}%>
</form>