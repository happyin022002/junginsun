<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0083.jsp
*@FileTitle  : Node Search
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0083Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0083Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String countryCd = "";
	String locCd = "";
	String ydCd = "";
	String rdTerm = "";
	String locTp = "";
	String calllFunc  = "";
	String ydDisplay = "";
	String znDisplay = "";
	String sheetIdx = "";
	String row = "";
	String col = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   	  
		event = (EsmBkg0083Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		calllFunc  = JSPUtil.getParameter(request, "func");
		locCd      = JSPUtil.getParameter(request, "loc_cd");
		ydCd       = JSPUtil.getParameter(request, "yd_cd");
		rdTerm     = JSPUtil.getParameter(request, "rd_term");
		locTp      = JSPUtil.getParameter(request, "loc_tp");
		if(locCd != null && locCd.length() >= 2){
			countryCd = locCd.substring(0,2);
		}
		if("D".equals(rdTerm)){
			ydDisplay = "none";
			znDisplay = "block";
		}else{
			ydDisplay = "block";
			znDisplay = "none";			
		}
		
		sheetIdx = JSPUtil.getParameter(request, "sheetIdx");
		row      = JSPUtil.getParameter(request, "row");
		col      = JSPUtil.getParameter(request, "col");			
		
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
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="locTp" value="<%=locTp%>">
<input type="hidden" name="sheetIdx" value="<%=sheetIdx%>">
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="col" value="<%=col%>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Location Search</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn" id="tabLayer_btn"><!-- 
				--><button type="button" class="btn_accent" name="btn_t1Retrieve" id="btn_t1Retrieve">Retrieve</button><!-- 
				--><button type="button" class="btn_normal" name="Code_Detail" id="Code_Detail">Code Detail</button><!-- 
				--><button type="button" class="btn_normal" name="btn_t1OK" id="btn_t1OK">Select</button><!-- 
				--><button type="button" class="btn_normal" name="btn_t1Close" id="btn_t1Close">Close</button><!-- 
			--></div>
		<div class="opus_design_btn" id="tabLayer_btn" style="display:none;"><!--     
			--><button type="button" class="btn_accent" name="btn_t2Retrieve" id="btn_t2Retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_t2Select" id="btn_t2Select">Select</button><!-- 
			--><button type="button" class="btn_normal" name="btn_t2Close" id="btn_t2Close">Close</button><!-- 
		--></div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search_tab">
	</div> 
	<!-- opus_tab_btn(S) -->
	<div class="wrap_result">
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		
		<!-- inquiry_area(S) -->
		
			<div  id="tabLayer"  style="display:inline;">
				<div class="opus_design_inquiry">
					<table> 
						<colgroup>
							<col width="60">
							<col width="110">
							<col width="90">
							<col width="90">
							<col width="70">
							<col width="110">
							<col width="80">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>Country</th>
								<td><input type="text" name="cnt_cd" style="width:25px;text-align:center;" class="input1" value="<%=countryCd %>" style="ime-mode:disabled"  maxlength="2" dataformat="enguponly"></td>
								<th>Location Code</th>
							    <td><input type="text" name="location_cd" style="width:50px;text-align:center;" class="input1" value="<%=(locCd != null)?locCd:"" %>" style="ime-mode:disabled"  maxlength="5" dataformat="enguponly"></td>
								<th>Location Name</th>
								<td><input name="loc_nm" type="text" class="input1" style="width:100px;ime-mode:disabled" dataformat="engup" otherchar=" "></td>
								<th>State</th>
								<td><input name="state" type="text" class="input" style="width:100px;ime-mode:disabled" maxlength="2" dataformat="engup"></td>						    
							</tr>
							<tr>
								<th>RCC</th>
								<td><script type="text/javascript">ComComboObject('rcc_cd', 1, 80, 1, 0, 0)</script></td>
								<th>UN Code</th>
								<td><input name="un_loc_ind_cd" type="text" style="width:20px;ime-mode:disabled" dataformat="enguponly" maxlength="1"></td>							
								<th>Control Office</th>
								<td colspan="3"><script type="text/javascript">ComComboObject('select', 2, 100, 1, 0, 0)</script><!--
								--><input name="loc_eq_ofc" type="text" style="width:186px;ime-mode:disabled" dataformat="enguponly" maxlength="5"></td>
							</tr>
						</tbody>
					</table>	
					<div class="opus_design_grid">
						<script type="text/javascript">ComSheetObject('t1sheet1');</script>
					</div>
				</div>
			</div>
			<div id="tabLayer"  style="display:none;">
				<div class="opus_design_inquiry">
					<table>
						<tbody>
							<tr>
								<th>Country</th>
								<td><input type="text" name="country_cd" style="width:25px;text-align:center;" class="input1 input_search" value="<%=countryCd %>" style="ime-mode:disabled"  maxlength=2 dataformat="enguponly"><!--
								--><button type="button" class="input_seach_btn" name="btn_008301pop" id="btn_008301pop"></button></td>
								<td>
									<div id="znCombo" style="display:<%=znDisplay%>">
										<script type="text/javascript">ComComboObject('postal_cd', 2, 85, 1, 0, 0)</script>
									</div>
								</td>
								<th>Location</th>
								<td><input type="text" name="loc_cd" style="width:50px;text-align:center;" class="input1" value="<%=(locCd != null)?locCd:"" %>" style="ime-mode:disabled"  maxlength="5" dataformat="enguponly"><!--
								--><input type="text" name="loc_cd2" style="width:25px;text-align:center;" class="input input_search" value="<%=ydCd %>" style="ime-mode:disabled"  maxlength="2" dataformat="engup"><!--
								--><button type="button" class="input_seach_btn" name="btn_008302pop" id="btn_008302pop"></button></td> 
								<th>EQ Control OFC</th>
								<td><input type="text" name="eq_ctrl_ofc_cd" style="width:50px;text-align:center;" class="input" style="ime-mode:disabled"  maxlength="5" dataformat="enguponly"></td>
								<td class="sm pad_left_12"><input type="radio" name="yz_flag" id="yz_flag1" value="Y" class="trans" <%if(!"D".equals(rdTerm)){ %>checked<%}%> onClick="javascript:setDisplayTp('Y');"><label for="yz_flag1">Yard</label><!--
								--><input type="radio" name="yz_flag" id="yz_flag2" value="Z" class="trans" <%if("D".equals(rdTerm)){ %>checked<%}%> onClick="javascript:setDisplayTp('Z');"><label for="yz_flag2">Zone</label>
								</td>
								<td>
									<div id="ydCheck" style="display:<%=ydDisplay%>">
									<input type="checkbox" name="marine_terminal" id="marine_terminal" value="Y" class="trans"><label for="marine_terminal">Marine Terminal</label>
									</div>
								</td>
							</tr>
						</tbody>
					</table>	
					<div class="opus_design_grid" id="yardTable" style="display:<%=ydDisplay%>">
						<script type="text/javascript">ComSheetObject('t2sheet1');</script>
					</div>
					<div class="opus_design_grid" id="zoneTable" style="display:<%=znDisplay%>">
						<script type="text/javascript">ComSheetObject('t2sheet2');</script>
					</div>
				</div>	
				<!-- inquiry_area(E) -->
			</div>
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
  		</div>
</div>

</form>