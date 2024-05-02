<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_BKG_1058.jsp
*@FileTitle : MT Return Yard for Pickup Notice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1058Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1058Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strOfc_cd    = "";
	String parPodCd     = JSPUtil.getParameter(request, "pod_cd");
	String parDelCd     = JSPUtil.getParameter(request, "del_cd");
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.PickUpNotice");
	String mainPage   = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg1058Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
		
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
		
		document.form.pod_cd.value      = "<%=parPodCd%>";
		document.form.fnl_dest_cd.value = "<%=parDelCd%>";
		
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" 		id="f_cmd">
<input type="hidden" name="pagerows" 	id="pagerows">
<input type="hidden" name="usr_id" 		id="usr_id"     value="<%=strUsr_id%>">
<input type="hidden" name="usr_nm"  	id="usr_nm"     value="<%=strUsr_nm%>">
<input type="hidden" name="usr_ofc_cd" 	id="usr_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="delt_flg" 	id="delt_flg">
<input type="hidden" name="chk_tp" 		id="chk_tp">
<input type="hidden" name="loc_cd" 		id="loc_cd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<%if(mainPage.equals("true")){%>
		<!-- page_title(S) -->
		   	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	<%} else { %>

		<!-- page_title(S) -->
		<h2 class="page_title"><span id="title">Pick-Up Notice MT Return CY Set-Up</span></h2>
		<!-- page_title(E) -->    
	<%}%>
	
	<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button>
		
		<%if (!"true".equals(mainPage)){%>		
			<button type="button" class="btn_normal" name="btn_Close" 			id="btn_Close">Close</button>
		<%} %>	
					
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->	
	
</div>
<!-- page_title_area(E) -->  
<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="50" />
				<col width="80" />
				<col width="50" />
				<col width="200" />
				<col width="60" />
				<col width="100" />
				<col width="30" />
				<col width="80" />
				<col width="50" />
				<col width="85" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Port</th>
				<td>
					<input type="text" style="width:50px;ime-mode:disabled;" class="input" maxlength="5" dataformat="engup" fullfill="true" caption="Port" name="pod_cd" id="pod_cd" />
				</td>
				<th>Saved Date</th>
				<td>
					<input type="text" style="width:75px;" class="input" dataformat="ymd" maxlength="10" caption="Saved Date Start Date" cofield="rtn_yd_sav_dt_s" name="rtn_yd_sav_dt_s" id="rtn_yd_sav_dt_s" />~ <!--
					--><input type="text" style="width:75px;" class="input" dataformat="ymd" maxlength="10" caption="Saved Date End Date" cofield="rtn_yd_sav_dt_e" name="rtn_yd_sav_dt_e" id="rtn_yd_sav_dt_e" /><!--
					--><button type="button" class="calendar ir" name="img_dt" id="img_dt"></button>
				</td>
				<th>PICK YD</th>
				<td>
					<input type="text" style="width:70px;ime-mode:disabled;" class="input" minlength="5" maxlength="8" dataformat="engup" caption="PICK YD" name="pkup_yd_id" id="pkup_yd_id" />
				</td>
				<th title="Place of Delivery">DEL</th>
				<td>
					<input type="text" style="width:50px;ime-mode:disabled;" class="input" maxlength="5" dataformat="engup" fullfill="true" caption="DEL" name="fnl_dest_cd" id="fnl_dest_cd" />
				</td>
				<th>Return YD</th>
				<td>
					<input type="text" style="width:65px;ime-mode:disabled;" class="input" minlength="5" maxlength="7" dataformat="engup" caption="Return YD" name="mcntr_rtn_yd_cd" id="mcntr_rtn_yd_cd" />
				</td>
				<th>Office</th>
				<td>
					<input type="text" style="width:70px;ime-mode:disabled;" class="input" minlength="5" maxlength="6" dataformat="engup" caption="Office" name="rtn_yd_sav_ofc_cd" id="rtn_yd_sav_ofc_cd" />
				</td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->   

	
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->      
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd" 		id="btn_RowAdd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_Delete" 		id="btn_Delete">Row Delete</button>		
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->       
</div>
</form>