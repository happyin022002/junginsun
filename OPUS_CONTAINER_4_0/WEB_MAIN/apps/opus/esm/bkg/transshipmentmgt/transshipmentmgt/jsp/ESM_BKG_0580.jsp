<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0580.jsp
*@FileTitle  : VVD Discharging Yard
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0580Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0580Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TransshipmentMgt.TransshipmentMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0580Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if 
		loadPage();
	}
</script>

<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vps_port_cds">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title"></span>
			</button>
		</h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_saveAs" id="btn_saveAs">Save As</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_yardPaste" id="btn_yardPaste">Yard Paste</button>
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
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
					<col width="50"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*" />
				</colgroup>
				<tr>
						<th>Port CD</th>
						<td><input type="text" style="width:80px;" class="input1" value="" name="vps_port_cd" id="vps_port_cd" dataformat="engup" maxlength="5"></td>
						<th>Other(s) Port CD</th>
						<td><input type="text" style="width:80px;" class="input" value="" name="vps_oher_port_cd" id="vps_oher_port_cd" dataformat="engup" maxlength="5"></td>
						<th>ETB Duration</th>
						<td><input type="text" style="width:80px"  class="input1" name="vps_etb_dt" id="vps_etb_dt" dataformat="ymd"><!-- 
							 --><span class="dash">~</span><!-- 
							  --><input type="text" style="width:88px"  class="input1" name="vps_etd_dt" id="vps_etd_dt" dataformat="ymd"><!-- 
							 --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
						</td>
				</tr>
				<colgroup>
					<col width="50"/>
					<col width="100"/>
					<col width="100"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*" />
				</colgroup>
				<tr>
						<th>Carrier</th>
						<td><input type="text" style="width:80px;" class="input" value="" name="crr_cd" dataformat="engup" maxlength="3"></td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:80px;" class="input" value="" name="vvd" dataformat="engup" maxlength="9"></td>
						<th>Lane</th>
						<td><input type="text" style="width:60px;" class="input" value="" name="lane" dataformat="engup" maxlength="3"></td>
					</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="layout_wrap">
	   <!-- layout_vertical_2(S) -->
	   <div class="layout_vertical_2 pad_rgt_8">
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid">
	           <script type="text/javascript">ComSheetObject('sheet1');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	   </div>
	   <!-- layout_vertical_2(E) -->
	   <!-- layout_vertical_2(S) -->
	   <div class="layout_vertical_2">
	       <!-- opus_design_inquiry(S) -->
	       <div class="opus_design_grid">
	          <script type="text/javascript">ComSheetObject('sheet2');</script>
	       </div>
	       <!-- opus_design_inquiry(E) -->
	   </div>
	   <!-- layout_vertical_2(E) -->
	</div>
</div>
</form>