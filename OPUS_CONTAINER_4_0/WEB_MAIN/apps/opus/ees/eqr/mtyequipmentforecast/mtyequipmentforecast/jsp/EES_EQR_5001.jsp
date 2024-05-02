<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_5001.jsp
*@FileTitle  : MTY Balance Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5001Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr5001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MTYEquipmentForecast.MTYEquipmentForecast");
	CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr5001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	<%= tpszUtil.getTpSzCodeCombo("eqr", "hidtpszall", "", "", "", "Y", "")%>
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
<input type="hidden" name="init_flag" id="init_flag" />
<input type="hidden" name="search_flag" id="search_flag" />

<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
	            <col width="30">
	            <col width="100">
	            <col width="150">
	            <col width="180">
	            <col width="50">
	            <col width="130">
	            <col width="50">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>ECC</th>
					<td>
						<input type="text" class="input" name="loc_cd" id="loc_cd" required style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill  style="width:50px;" class="input" value=""><!--  
						 --><button type="button" class="input_seach_btn"  name="btn_loc_cd"  id="btn_loc_cd" ></button>
					</td>
					<th>Balance Report ID</th>
					<td><input type="text" name="fcast_yrwk" id="fcast_yrwk" required maxlength="7" style="width:60px;" class="input1" value="" dataformat="yw"> (YYYY-WW)</td>
					<th><input type="radio" name="viewFlag" id="viewFlag1" class="trans" checked>&nbsp;<label for="viewFlag1">DRY</label></th>
					<th><input type="radio" name="viewFlag" id="viewFlag2" class="trans">&nbsp;<label for="viewFlag2">SPCL(RF, OT, FR)</label></th>
					<th><input type="radio" name="viewFlag" id="viewFlag3" class="trans">&nbsp;<label for="viewFlag3">ALL</label></th>
					<td></td>
				</tr> 
			</tbody>
		</table>
	</div>
	
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2">
			<div class="opus_design_grid" id="mainTable1">
				 <script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
	    <div class="layout_vertical_2 pad_left_8">
			<div class="opus_design_grid" id="mainTable1">
				 <script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	</div>
	<!-- layout_wrap(S) -->
</div>
</form>