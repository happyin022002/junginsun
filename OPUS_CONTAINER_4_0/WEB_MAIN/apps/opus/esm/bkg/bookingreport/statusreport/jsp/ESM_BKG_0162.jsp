<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0162.jsp
*@FileTitle  : Container List on Stowage & B/L
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0162Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0162Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.StatusReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		
		event = (EsmBkg0162Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//  extract additional data obtained from the server during Initial loading ..
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


<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	  
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn"><!--
	    --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button><!--
	    --><button type="button" class="btn_normal" name="btn_history"   id="btn_history">EQ History</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
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
	            <col width="70" />
	            <col width="115" />
	            <col width="50" />
	            <col width="80" />
	            <col width="60" />
	            <col width="80" />
	            <col width="60" />
	            <col width="120" />
	            <col width="60" />
	            <col width="120" />
	            <col width="60" />
	            <col width="40" />
	            <col width="60" />
	            <col width="*" />
	        </colgroup> 
	        <tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd_cd" style="width:105px;ime-mode:disabled;" class="input1" value="" dataformat="engup"  caption="VVD" maxlength="9" fullfill required></td>
					<th title="Port of Discharging"><span id="pol">POD</span></th>
					<td><input type="text" name="pol_cd" style="width:70px;ime-mode:disabled;" class="input1" value="" dataformat="engup"  caption="POL" maxlength="5" fullfill required ></td>
					<th>Bound</th>
					<td><script type="text/javascript">ComComboObject('bound_type', 1, 47, 0,1,0);</script></td>
					<th>Stowage Status</th>
					<td><script type="text/javascript">ComComboObject('stwg_status', 1, 100, 0,1,0);</script></td>
					<th>Stowage vs B/L</th>
					<td><script type="text/javascript">ComComboObject('bkg_cgo_ty_cd', 1, 80, 0,1,0);</script></td>
					<th>Special CNTR</th>
					<td><script type="text/javascript">ComComboObject('sp_cntr_ty_cd', 1, 47, 0,1,0);</script></td>
					<th>F/M</th>
					<td><script type="text/javascript">ComComboObject('cgo_tp', 1, 47, 0,1,0);</script></td>
				</tr>
			</tbody>
		</table>
		<table> 
			<colgroup>
	            <col width="70" />
	            <col width="*" />
	        </colgroup> 
	        <tbody>
	        	<tr>
					<th>BKG Office</th>
					<td><input type="text" name="bkg_ofc_cd" style="width:105px;" class="input" value="" style="ime-mode:disabled" dataformat="engup"  caption="B/OFC" maxlength="6"></td>
				</tr>
	        </tbody>
		</table>	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>	

<div class="wrap_result">
	<!-- opus_design_inquiry(E) -->
	<div class="opus_design_grid">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form> 