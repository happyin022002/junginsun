<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0510.jsp
*@FileTitle  : Hold Notice Send
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/03
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0510Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBkg0510Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strPgmNo         = ""; 
    String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.HoldNotice");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	//
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
		strPgmNo = JSPUtil.getParameter(request, "pgmNo");
		event = (EsmBkg0510Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
	if("".equals(mainPage)) {
		mainPage = "true";
	}	
%>



<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd"/>
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="flag" id="flag" value="<%=strPgmNo%>" />
<input type="hidden" name="usr_id" id="usr_id" value="<%=strUsr_id%>" />
<input type="hidden" name="usr_ofc_cd" id="usr_ofc_cd" value="<%=strOfc_cd%>" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" value="" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" value="" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableTfoolbar" value=""> 
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle"value="">


<%if(!mainPage.equals("true")){%><div class="layer_popup_title"><%}%>
<div class="page_title_area clear">

<%if(mainPage.equals("true")){%>
	<!-- page_title(S) -->
	   	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
<%} else { %>
	<!-- page_title(S) -->
	<h2 class="page_title"><span id="title">Hold Notice Send</span></h2>
	<!-- page_title(E) -->    
<%}%>
    
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_CustomsResult" id="btn_CustomsResult">Customs Result</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Fax_Send" id="btn_Fax_Send">Fax</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Email_Send" id="btn_Email_Send">E-Mail</button><!--
		 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_ListPrint" id="btn_ListPrint">List Print</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_SentHistory" id="btn_SentHistory">Sent History</button>
		<%if(!mainPage.equals("true")){%>		 	
				<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		<%}%>		 	
	</div>
		<!-- opus_design_btn(E) -->
	   	<!-- page_location(S) -->
	   	<div class="location">
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->	
</div>
<%if(!mainPage.equals("true")){	%></div><%}%>
<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="61" />
					<col width="120" />
					<col width="40" />
					<col width="220" />
					<col width="40" />
					<col width="150" />
					<col width="70" />
					<col width="40" />
					<col width="50" />
					<col width="80" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
					<td class="sm pad_left_8"><input type="radio" class="trans" name="sch_tp_cd" value="VVD" id="sch_tp_cd" onclick="obj_click();" /> <strong>VVD</strong></td>
					<td class="sm">
						<input type="text" style="width: 100px; ime-mode: disabled;" class="input1" dataformat="engup" minlength="9" maxlength="9" caption="VVD" fullfill="true" name="vvd" id="vvd" onclick="obj_click();"  />
					</td>
					<th class="sm">
						<input type="radio" class="trans" name="sch_tp_cd" value="ETA" id="sch_tp_cd" onclick="obj_click();"  /> POD ETA
					</th>
					<td class="sm">
						<input type="text" style="width: 75px;" class="input1" dataformat="ymd" maxlength="10" caption="POD ETA Start Date" cofield="dt_s" name="dt_s" id="dt_s" /><input type="text" style="width: 75px;" class="input1" dataformat="ymd" maxlength="10" caption="POD ETA End Date" cofield="dt_e" name="dt_e" id="dt_e" /><button type="button" class="calendar ir" name="img_dt" id="img_dt"></button>
					</td>
					<th class="sm">
						<input type="radio" class="trans" name="sch_tp_cd" value="BL" id="sch_tp_cd" onclick="obj_click();"  /> B/L No.
					</th>
					<td class="sm">
						<input type="text" style="width: 110px; ime-mode: disabled;" class="input1" dataformat="engup" maxlength="13" caption="B/L No." name="bl_no" id="bl_no" onclick="obj_click();" />
					</td>
					<th title="Port of Discharging">POD</th>
					<td>
						<input type="text" style="width: 50px; ime-mode: disabled;" class="input" name="pod_cd" id="pod_cd" value="" caption="POD" maxlength="5" minlength="5" dataformat="engup" fullfill="true" />
					</td>
					<th title="Place of Delivery">DEL</th>
					<td>
						<input type="text" style="width: 50px; ime-mode: disabled;" class="input" name="del_cd" id="del_cd" value="" caption="DEL" maxlength="5" minlength="5" dataformat="engup" fullfill="true" />
					</td>
					<th>Sent Result</th>
					<td width="">
						<select style="width: 70px;" class="input1" name="snd_rslt_cd" id="snd_rslt_cd">
							<option value="ALL">All</option>
							<option value="">Not Send</option>
							<option value="S">Success</option>
							<option value="F">Fail</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>CNTR No.</th>
				<td><input type="text"
					style="width: 100px; ime-mode: disabled;" class="input"
					dataformat="engup" maxlength="14" caption="Container No." name="cntr_no" id="cntr_no" />
				</td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t1Preview" id="btn_t1Preview">Preview</button>
			<button type="button" class="btn_normal" name="btn_t1FormSetting" id="btn_t1FormSetting">Form setup</button>
		</div>
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		<script type="text/javascript">ComSheetObject('t1sheet2');</script>
	</div>
	<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_t2GotoTPB" id="btn_t2GotoTPB">TPB Issue</button>
			<button type="button" class="btn_normal" name="btn_t2Preview" id="btn_t2Preview">Preview</button>
			<button type="button" class="btn_normal" name="btn_t2FormSetting" id="btn_t2FormSetting">Form setup</button>
		</div>
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		<script type="text/javascript">ComSheetObject('t2sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<%if(!mainPage.equals("true")){	%></div><%}%>
</form> 