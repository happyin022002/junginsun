<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0069.jsp
*@FileTitle  : Pre Checking Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/14
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0069Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0069Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						////count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");
	
	String popType          = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0069Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//팝업유형 : R(단순 첵), S(Special Request용), B(Back Ground 첵)
		popType = request.getParameter("pop_type")==null?"":request.getParameter("pop_type");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
    var popType = "<%=StringUtil.xssFilter(popType)%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(popType);
		
		//creating scroll according to resolution (standard:1400,1050)		
		if(popType != 'B2') {
			if(screen.height >= 1024) {
				document.body.scroll = "no";
			} else {
				window.dialogWidth = parseInt(window.dialogWidth.replaceStr("px",""))+18+"px";
				document.body.scroll = "auto";			
			}
		}
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Pre Checking Report</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<div id="spBtnLayer1" style="display:"><button class="btn_accent" name="btn_sp_request" id="btn_sp_request" type="button">Special Request</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button></div><!--
		--><div id="spBtnLayer2" style="display:none"><button class="btn_normal" name="btn_Close1" id="btn_Close1" type="button">Close</button></div>
	</div>
	<!-- opus_design_btn (E) -->
</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<h3 class="title_design">Checking Result</h3>
		<table style="width:897px;">
			<colgroup>
				<col width="160">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>	
					<th style="text-align:left;">Segregation Validation</th>
					<td class="stm" style="color:#ff0000" id="rsltStr"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
	<div class="opus_design_inquiry">
		<table style="width:897px;">
			<colgroup>
				<col width="*">
			</colgroup>
			<tbody>
				<tr>	
					<th style="text-align:left;">Vessel Operator’s Prohibition</th>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>

	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
	<div class="opus_design_inquiry">
		<table style="width:897px;">
			<colgroup>
				<col width="*">
			</colgroup>
			<tbody>
				<tr>	
					<th style="text-align:left;">Port Prohibition/Restrictions En-route</th>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
<div id="spLayer" style="display:">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
	<div class="opus_design_inquiry">
		<table style="width:897px;">
			<colgroup>
				<col width="170">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>	
					<td><h3 class="title_design">Reason for Special <br />Request</h3></td>
					<td><input name="spReq" id="spReq" type="checkbox" value="Y" class="trans"></td>
					<td width="*" class="stm" id="spReqStr">&nbsp;</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_add" id="btn_add" type="button">Row Add</button><!--  
			--><button class="btn_normal" name="btn_insert" id="btn_insert" type="button">Row Insert</button><!--  
			--><button class="btn_normal" name="btn_copy" id="btn_copy" type="button">Row Copy</button><!--  
			--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<div class="opus_design_grid">
		<!-- Container Info Sheet (S) -->
		<script type="text/javascript">ComSheetObject('sheet5');</script>
		<!-- Container Info Sheet (E) -->
	</div>	
</div>
</div>
</div>
</form>
