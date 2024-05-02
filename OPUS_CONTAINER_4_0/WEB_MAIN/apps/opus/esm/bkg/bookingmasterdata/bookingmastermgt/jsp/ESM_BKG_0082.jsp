<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0082.jsp
*@FileTitle  : Booking Creation 1_MT P/UP CY inquiry
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0082Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0082Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strLocCd			= "";
	String strYdCd			= "";
	String calllFunc 		= "";
	String callSheetIdx		= "";
	
	//Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0082Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//when open screen, get data in server..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		if (JSPUtil.getParameter(request, "searcheKeyOpener").length() > 4){
			strLocCd =  JSPUtil.getParameter(request, "searcheKeyOpener").substring(0,5);
			if (JSPUtil.getParameter(request, "searcheKeyOpener").length() > 4){
				strYdCd  =  JSPUtil.getParameter(request, "searcheKeyOpener").substring(5, JSPUtil.getParameter(request, "searcheKeyOpener").length());
			}else{
				strYdCd  =  JSPUtil.getParameter(request, "searcheKeyOpener");
			}
		}else{
			strLocCd =  JSPUtil.getParameter(request, "searcheKeyOpener");
		}
		calllFunc  = JSPUtil.getParameter(request, "func");
		callSheetIdx  = JSPUtil.getParameter(request, "callSheetIdx"); 
		
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="selectSheetYdCd" id="selectSheetYdCd" />
<input type="hidden" name="calllFunc" value="<%=calllFunc%>" id="calllFunc" />
<input type="hidden" name="callSheetIdx" value="<%=callSheetIdx%>" id="callSheetIdx" />

<!-- Developer Work	-->

<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>MT Pick Up CY Inquiry</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Select</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!-- 
		--></div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>

<!-- popup_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- popup_contens_area(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="50" />
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>Yard Code</th>
						<td><input type="text" name="loc_cd" style="width:70px;" class="input1" value="<%=strLocCd %>" maxlength="5" style="ime-mode:disabled" dataformat="enguponly" caption="Yard"  fullfill><!-- &nbsp;
						     --><input type="text" name="yd_cd"  style="width:30px;" class="input" value="<%=strYdCd %>" maxlength="2" style="ime-mode:disabled" dataformat="engup" caption="Yard"  fullfill></td>
						</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		 <!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_flex_fixed" style="width:200px">
		        <!-- opus_design_grid(S) -->
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
				<!-- opus_design_grid(E) -->
		    </div>
		    <div class="layout_flex_flex" style="padding-left:208px">
	    		<div class="opus_design_data">
					<table class="grid_2"> 
						<colgroup>
							<col width="220" />
							<col width="270" />
							<col width="200" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<th>Yard Name</th>
								<td colspan="3"><input type="text" style="width:100%;text-align:left;" class="input2" name="yd_nm"  readonly></td>
							</tr>
							<tr>
								<th>Tel</th>
								<td><input type="text" style="width:100%;text-align:left;" class="input2" name="phn_no"  readonly></td> 
								<th>P.I.C</th>
								<td><input type="text" style="width:100%;text-align:left;" class="input2" name="yd_pic_nm"  readonly></td>
							</tr>
						</tbody>
					</table>
				</div>
		     	<!-- opus_design_grid(S) -->
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				</div>
				<!-- opus_design_grid(E) -->
		    </div>
		</div>
		<br>
		<!-- layout_wrap(e) -->
		<div class="opus_design_inquiry">
			<table><tr><td><font bold color="red">* </font>EQ Inventory information is subject to local situation. <br> For accurate information, please contact your local operation department directly.</td></tr></table>
		</div>
	</div>
	<!-- popup_contens_area(E) -->
</div>
</form>
