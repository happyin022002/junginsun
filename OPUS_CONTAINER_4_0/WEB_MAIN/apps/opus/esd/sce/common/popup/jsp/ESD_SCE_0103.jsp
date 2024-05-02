<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0103.jsp
*@FileTitle  : ESD_SCE_0103
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CommonPopUpManageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.common.popup");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (CommonPopUpManageEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd" id="f_cmd">
<input    type="hidden" name="f_slt_idx" id="f_slt_idx" value="0">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>VVD Inquiry</span></h2>
	<!-- page_title(E) -->
	 <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	    	   <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	    	--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			--><button type="button" class="btn_normal" name="btn_apply" id="btn_apply">Ok</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	    </div>
	    <!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			 <table> 
	            <colgroup>
	                <col width="60" />
	                <col width="*" />
	            </colgroup>
	            <tbody>
               		 <tr>
							<th>ETA / ETD</th>
							<td>
								<select name="seletad" id="seletad" style="width:74px;" onchange="selectVSLEVNT(this.value)">
									<option value="ETA" selected>ETA</option>
									<option value="ETD">ETD</option>
								</select><!-- 
								 --><input name="sdate" id="sdate" type="text" class="input" style="width:70px; text-transform:uppercase;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"  >~ <!-- 
								 --><input name="edate" id="edate" type="text" class="input" style="width:70px; text-transform:uppercase;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"  ><!--
								 --><button id="btn_bkg_calendar" name="btn_bkg_calendar"  type="button" class="calendar"></button>

							</td>
						</tr>
				</tbody>
			</table>
			<table> 
	            <colgroup>
	                <col width="63">	                
	                <col width="80">
	                <col width="80">
	                <col width="70">
	                <col width="80">
	                <col width="70">
	                <col width="80">
	                <col width="*">
	            </colgroup>
	            <tbody>
               		 <tr>
						<th>Lane</th>
						<td><input name="sellane" id="sellane" type="text" style="width:74px" value="" onKeyUp="ComChkObjValid(this, 'eng', true, 3); this.value = this.value.toUpperCase();" ></td>
						<th title="Port of Loading">POL</th>
						<td><input name="selpol" id="selpol" type="text" style="width:87px" value="" onKeyUp="ComChkObjValid(this, 'eng', true, 5); this.value = this.value.toUpperCase();"></td>
						<th title="Port of Discharging">POD</th>
						<td><input name="selpod" id="selpod" type="text" style="width:79px" value="" onKeyUp="ComChkObjValid(this, 'eng', true, 5); this.value = this.value.toUpperCase();" ></td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input name="selvvd"  id="selvvd" type="text" style="width:94px; text-transform:uppercase;"  value="" onKeyUp="ComChkObjValid(this, 'eng_num', true, 9);" onBlur="ComChkObjValid(this, 'eng_num', true, 9); " ></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >										
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</form>