<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0509.jsp
*@FileTitle  : Terminal Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event.VopVsk0509Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 

<%
	VopVsk0509Event event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String pop_yn       = "";
	String loc_cd		= "";
	String mainPage 		= "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationSupportMgt.TerminalInformationMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	mainPage = request.getParameter("mainPage");
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopVsk0509Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		pop_yn      = request.getParameter("pop_mode")==null?"N":"Y";
		loc_cd  	= request.getParameter("loc_cd")==null?"":request.getParameter("loc_cd");		
	} catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
	var preConds = {
		pop_yn      : "<%=pop_yn%>",
		loc_cd   	: "<%=StringUtil.xssFilter(loc_cd)%>"
	}
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script> 

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="comboCd" id="comboCd">
<input type="hidden" name="pagerows" id="pagerows">

<%if (!"true".equals(mainPage)){%>
<div class="layer_popup_title">
	<div class="page_title_area clear">
	<h2 class="page_title"><span>Terminal Information</span></h2>
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
	</div>
</div>
<%}else{%>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<%}%>

<%if (!"true".equals(mainPage)){%><div class="layer_popup_contents"><%}%>
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="40">
					<col width="140">
					<col width="70">
					<col width="200">
					<col width="80">
					<col width="*">
				</colgroup>
				<tr>
					<th>Port</th>
					<td><input type="text" style="width: 70px; text-align:center;ime-mode:disabled" class="input1" value="" name="loc_cd" id="loc_cd" maxlength="5" dataformat="engup" onkeyup="loc_cd_onkeyup()" onkeypress="loc_cd_onkeypress()" onblur="loc_cd_onblur()" caption="Port Code"><!--
						--><button type="button" class="input_seach_btn" name="ComOpenPopupWithTarget" id="ComOpenPopupWithTarget"></button>
					</td>
					<th width="40">RHQ</th>
					<td><div id="enablePorRhq" style="display:none;"><script type="text/javascript">ComComboObject('por_rhq', 0, 90, 0, 1);</script></div>
						<div id="disablePorRhq" style="display:inline;"><input type="text" style="width: 90px;text-align:center;" class="input2" value="" name="por_rhq_diable" id="por_rhq_diable" readonly></div>
					</td>
					<th>Updated Date</th>
					<td colspan="3"><input type="text" name="upd_dt_view" id="upd_dt_view" style="width: 115px; text-align:center;" class="input2" readOnly><!--
						 --><input type="text" name="upd_id_view" id="upd_id_view" style="width: 70px;" class="input2" readOnly></td>
				</tr>
			</tbody>
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
	
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		<div class="opus_design_data mar_top_12">
			<table class="grid_2"> 
				<colgroup>
					<col width="200">
					<col width="*">
				</colgroup>
				<tr>
					<th>Remark(s)</th>
					<td rowspan="2"><textarea style="width: 100%; height: 60px; resize:none;" name="gntr_rmk" id="gntr_rmk" onchange="gntr_rmk_onchange()"></textarea></td>
				</tr>
			</table> 
		</div>
	</div>

	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		<div class="opus_design_data">
			<table class="grid_2 mar_top_12">
				<colgroup>
					<col width="200">
					<col width="*">
				</colgroup>
				<tr>
					<th>Remark(s></th>
					<td rowspan="2"><textarea style="width: 100%; height: 60px; resize:none;" name="fltg_rmk" id="fltg_rmk" onchange="fltg_rmk_onchange()"></textarea></td>
				</tr>
			</table> 
		</div>
	</div>
	
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>
	
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t4sheet1');</script>
	</div>
	
	
	 <!-- opus_design_grid(S) -->
	 <div class="opus_design_grid" style="display: none;">
	     <script type="text/javascript">ComSheetObject('sheet1');</script>
	 </div>
</div>
<!-- opus_design_grid(E) -->
<%if (!"true".equals(mainPage)){%></div><%}%>
</form>