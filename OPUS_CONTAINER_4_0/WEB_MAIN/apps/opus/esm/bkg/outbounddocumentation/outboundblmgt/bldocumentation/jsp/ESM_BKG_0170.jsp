<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0170.jsp
*@FileTitle  : Container Copy And Move
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
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0170Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0170Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");

	String bkg_no = "";
	String cntr_no = "";
	String cntr_vol = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0170Event)request.getAttribute("Event");
		bkg_no = event.getBkgNo();
		cntr_no = event.getCntrNo();
		cntr_vol = event.getCntrVol();

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
		loadPage();
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Container Copy &amp; Move</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_normal" name="btn_Apply" id="btn_Apply">Apply</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- inquiry_area(S) -->
		<div class="opus_design_inquiry">   <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="60" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td><input type="radio" name="radio_gubun" value="C" class="trans" checked id="rdo1" ><label for="rdo1">Copy</label></td>
						<td><input type="radio" name="radio_gubun" value="M" class="trans" id="rdo2"><label for="rdo2">Move</label></td>
					</tr>
					<tr>
	    				<th>CNTR No.</th>
						<td><input type="text" style="ime-mode:disabled;width:100%;" name="cntr_no" value="<%=cntr_no%>" class="input2" readOnly></td>
					 </tr>
				</tbody>
			</table>
		</div>
		<!-- inquiry_area(E) -->	
		
	</div>

	
	
	
	<div class="wrap_result">
		<!-- data_area(S) -->
		<div class="opus_design_data">
		    <table class="grid2"> 
				<colgroup>
					<col width="50%" />
					<col width="50%" />
				</colgroup>
				<tbody>
					<tr class="tr2_head">
						<th>Source Booking No.</th>
						<th>Vol.</th>
					</tr>
					<tr>
						<td><input type="text" name="bkg_no" style="width:100%;" value="<%=bkg_no%>" class="noinput2" readOnly></td>
						<td><input type="text" name="cntr_vol" style="width:100%;;text-align:right" value="<%=cntr_vol%>" class="noinput" dataformat="float" maxlength="4" pointcount="2"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- data_area(E) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
	    	<!-- opus_grid_btn(S) -->
	    	<div class="opus_design_btn"><!--
	    	--><button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button><!--
	    	--><button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Delete</button>
	    	</div>
	    	<!-- opus_grid_btn(E) -->
			
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	
	    <!-- data_area(S) -->
	    <div class="opus_design_data">
	        <table class="grid2 wAuto"> 
	    		<colgroup>
					<col width="70%" />
					<col width="30%" />
	    		</colgroup>
	    		<tbody>
					<tr>
						<th>Original Vol.</th>
						<td class="input2" id="td_org_vol">1.00</td>
					</tr>
					<tr>
						<th>Partial Total</th>
						<td><input class="input2"  type="text" style="width:35px" id="td_sum_vol" dataformat="commafloat" pointcount="2"></td>
					</tr>
	    		</tbody>
	    	</table>
	    </div>
	    <!-- data_area(E) -->
	</div>
</div>
<!-- popup_contens_area(E) -->

</form>