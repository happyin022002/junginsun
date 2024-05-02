<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0090.jsp
*@FileTitle  : Special Stowage Request
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0090Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0090Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String calllFunc 		= "";
	String stwgCd 		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0090Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		calllFunc  = JSPUtil.getParameter(request, "func");
		stwgCd  = JSPUtil.getParameter(request, "stwg_cd");
		
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="button" id="button" value="N">
<input type="hidden" name="por_cd">
<input type="hidden" name="del_cd">
<input type="hidden" name="rcv_term_cd">
<input type="hidden" name="de_term_cd">
<input type="hidden" name="bdr_flg">
<input type="hidden" name="corr_no">
<input type="hidden" name="rqst_apro_cd">
<input type="hidden" name="saved_stwg_cd" id="saved_stwg_cd">
<input type="hidden" name="saved_stwg_rmk" id="saved_stwg_rmk">

<!-- 
<input type="hidden" name="stwg_cd" value="<%=stwgCd%>">
 -->
<input type="hidden" name="stwg_cd" id="stwg_cd">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 
		<h2 class="page_title"><span>Stowage Special Request</span></h2>
		 -->
		<h2 class="page_title"><span>Special Stowage Application for OwnBKG/Partner Lines</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_normal" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_Request" id="btn_Request">Request</button><!--
		--><button type="button" class="btn_normal" name="btn_CancelReq" id="btn_CancelReq">Cancel Request</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<br>
<br>
<br>

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="70" />
					<col width="200" />
					<col width="40" />
					<col width="400" />
					<col width="70" />
					<col width="60" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>BKG No.</th>
					<td><input id="bkg_no" name="bkg_no" style="width: 105px;" class="input" value="" readonly  type="text" dataformat="engup"/><!-- 
					 -->
					<th>Requested By/Date</th>
					<td><input id="rqst_usr_id" name="rqst_usr_id" style="width: 90px;" class="input2" value="" readonly type="text" /><input id="rqst_dt" name="rqst_dt" style="width: 115px;" class="input2" value="" readonly type="text" /><input id="rqst_gdt" name="rqst_gdt" style="width: 115px;" class="input2" value="" readonly type="text" />  (GMT)</td>
					<th>Approval</th>
					<td><input id="spcl_cgo_apro_cd" name="spcl_cgo_apro_cd" style="width: 20px;text-align:center;" class="input2_1" value="" readonly type="text" /><button class="input_seach_btn" name="btn_approval" id="btn_approval" type="button"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
	    <div class="layout_vertical_2" style="width:50%;">

			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
	    		
		<div class="layout_vertical_2 mar_left_12" style="width:48%">
			<!-- data_area(S) -->
					
			<div class="opus_design_grid" >
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
							
			<div class="opus_design_data">
			    <table class="grid2"> 
					<tbody>
						<tr>
							<td><strong>Remark(s)</strong></td> 
						</tr>
						<tr>
							<td><textarea cols="62" rows="5" name="stwg_rmk" id="stwg_rmk" maxlength="500"></textarea></td> 
						</tr>
					</tbody>
				</table>
			</div>
			<!-- data_area(E) -->
		</div>

        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
        </div>
        <!-- opus_design_grid(E) -->
		
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet4');</script>
        </div>
        <!-- opus_design_grid(E) -->
	</div>    
</div>

</form>
<!-- : ( Button : pop ) (E) -->