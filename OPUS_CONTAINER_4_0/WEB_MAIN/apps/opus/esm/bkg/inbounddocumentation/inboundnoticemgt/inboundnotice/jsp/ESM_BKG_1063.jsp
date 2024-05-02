<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1063.jsp
*@FileTitle : Pick up down-load
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1063Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1063Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "500";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strPgmNo         = "";

	String strPre_popUp     = "";
	String strSch_tp_cd     = "";
	String strPre_bl_no     = "";
	String mainPage   = "";

	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.PickUpNotice");

	try {
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strPre_popUp = JSPUtil.getParameter(request, "popUp");
		strSch_tp_cd = JSPUtil.getParameter(request, "sch_tp_cd");
		strPre_bl_no = JSPUtil.getParameter(request, "bl_no");

		strPgmNo = JSPUtil.getParameter(request, "pgmNo");
		event = (EsmBkg1063Event)request.getAttribute("Event");
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

		<%if ("Y".equals(strPre_popUp)) {%>
		document.form.flag.value   = "ESM_BKG_1063-01";
		document.form.popUp.value  = "Y";
		document.form.p_sch_tp_cd.value = "<%=strSch_tp_cd%>";
		document.form.p_bl_no.value  = "<%=strPre_bl_no%>";
		<%}%>

		loadPage();
	}
</script>


<form name="form" id="form">

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="popUp" id="popUp" />
<input type="hidden" name="p_sch_tp_cd" id="p_sch_tp_cd" />
<input type="hidden" name="p_bl_no" id="p_bl_no" />
<input type="hidden" name="pagerows" id="pagerows" value="<%=pageRows %>" />
<input type="hidden" name="flag" id="flag" value="<%=strPgmNo%>" />
<input type="hidden" name="bl_nos" id="bl_nos" />

<div class="page_title_area clear">


	<!-- page_title(S) -->
		<h2 class="page_title"><span id="title"></span></button></h2>
	<!-- page_title(E) -->


	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!--
		--><!-- <button type="button" class="btn_normal" name="btn_Delete" 		id="btn_Delete">Delete</button>--><!--
		--><!-- <button type="button" class="btn_normal" name="btn_Upload" 		id="btn_Upload">Upload</button>--><!--
		--><!--<button type="button" class="btn_normal" name="btn_DataSetup" 	id="btn_DataSetup">Data Setup</button>--><!--
		--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!--
		--><!--<button type="button" class="btn_normal" name="btn_PickupSend" 	id="btn_PickupSend">Pickup Send</button>-->

		<%if ("true".equals(mainPage)){%>
			<!--<button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button> -->
			<!--<button type="button" class="btn_normal" name="btn_History" 		id="btn_History">History</button> -->
		<%} else {%>
		<!-- --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		<%}%>

	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->



<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" display:inline;" name="tabLayer" id="tabLayer">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table style="width:750px;">
				<colgroup>
					<col />
					<col />
					<col />
					<col />
					<col />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<td><input type="radio" class="trans" name="sch_tp_cd" id="sch_tp_cd" value="VVD" />&nbsp;<b>VVD</b></td>
						<td><input type="text" style="width:77px;ime-mode:disabled;" class="input1" dataformat="engup" minlength="9" maxlength="9" caption="VVD" fullfill="true" name="vvd" id="vvd" /></td>
						<th class="trans">POD</th>
						<td class="trans"><input type="text" style="width: 50px;" class="input1" id="pod_cd" name="pod_cd" caption="POD" maxlength="5" style="ime-mode:disabled" dataformat="engup" fullfill /></td>
						<td><input type="radio" class="trans" name="sch_tp_cd" id="sch_tp_cd" value="ATA" />&nbsp;<b>POD ATA</b> </td>
						<td><input type="text" style="width:75px;" class="input1" dataformat="ymd" maxlength="10" caption="ATA POD Start Date" cofield="dt_s" name="dt_s" id="dt_s" /><!--
							 --><input type="text" style="width:75px;" class="input1" dataformat="ymd" maxlength="10" caption="ATA POD End Date" cofield="dt_e" name="dt_e" id="dt_e" /><!--
							 --><button type="button" id="img_dt" name="img_dt" class="calendar ir"></button></td>
						<td><input type="radio" class="trans" name="sch_tp_cd" id="sch_tp_cd" value="BL" />&nbsp;<b>B/L No.</b></td>
						<td><input type="text" style="width:110px;ime-mode:disabled;" class="input1" dataformat="engup" maxlength="13" caption="B/L No." name="disp_bl_no" id="disp_bl_no" />
							<button type="button" class="multiple_inq ir" style="background: url(./style/images/theme_default/sprite_common.png) -98px -157px no-repeat; background-color:#ffffff;" name="btn_multBlNo" id="btn_multBlNo"></button></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- wrap_search(E) -->
	<br>
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear"  display:inline;" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t2sheet2');</script>
</div>
<div class="opus_design_tab sm" display:inline;" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_design_grid(E) -->
<table>
	<tbody>
		<colgroup>
			<col width="30"/>
			<col width="50"/>
			<col width=*/>
			<%if ("true".equals(mainPage)){%>
				<col width="148"/>
			<%} else {%>
				<col width="326"/>
			<% } %>
		</colgroup>
		<tr>
			<td>&nbsp;</td>
			<td>
			</td>
		</tr>
	</tbody>
</table>

</form>

<div id="layList" style="position:absolute; z-index:999; display:none; background-color:white;"> <!-- background-color: #d4f6ff; -->
	<table>
		<tr>
			<td>
				<label style="margin-right: 0px;">Rows : </label>
				<label style="margin-right: 0px;" id="rows">000</label>
				<label style="margin-right: 0px;">/</label>
				<label>100</label>
			</td>
		</tr>
	</table>
	<textarea id="mult_bl_no" name="mult_bl_no" placeholder="B/L No." class="multi_value mar_none" style="top:0; text-transform: uppercase; width:145px; height:140px;"></textarea>
</div>
