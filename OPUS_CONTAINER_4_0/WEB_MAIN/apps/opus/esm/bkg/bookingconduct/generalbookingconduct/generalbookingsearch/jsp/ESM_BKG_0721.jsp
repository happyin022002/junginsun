<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0721.jsp
*@FileTitle  : Cut Off Time
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0721Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0721Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkg_no		= "";

	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0721Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		strBkg_no =event.getBkgBlNoVO().getBkgNo();

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
		document.title="Cut Off Time";
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bdr_Flag" id="bdr_Flag" />
<input type="hidden" name="modifyFlag" id="modifyFlag" />

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Cut Off Time</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_data" style="width:520px;margin-bottom:25px">   <!-- no TAB  -->
			<table class="grid_2"> 
				<colgroup>
					<col width="110" />
					<col width="90" />
					<col width="65" />
					<col width="130" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Booking No.</th>
						<th title="Vessel Voyage Direction">VVD</th>		
						<th title="Port of Loading">POL</th>
						<th>ETB</th>
						<th>ETD</th>				
					</tr> 
					
					<tr>
						<td><input type="text" style="width:100px;" class="noinput2" name="bkg_no" value="<%=strBkg_no%>" readonly id="bkg_no" /></td>
						<td><input type="text" style="width:85px;" class="noinput2" name="vvd" readonly id="vvd" /></td>
						<td><input type="text" style="width:60px;" class="noinput2" name="pol" readonly id="pol" /></td>
						<td><input type="text" style="width:120px;" class="noinput2" name="etb" readonly id="etb" /></td>
						<td><input type="text" style="width:120px;" class="noinput2" name="etd" readonly id="etd" /></td>					
					</tr> 
	
				</tbody>
			</table>
		</div>
	
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>
