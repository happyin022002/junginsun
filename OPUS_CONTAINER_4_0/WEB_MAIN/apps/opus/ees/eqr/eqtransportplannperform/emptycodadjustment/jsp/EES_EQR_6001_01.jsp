<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_6001_01.jsp
*@FileTitle  : MTY COD Simulation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr6001Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr6001Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EQTransportPlanNPerform.EmptyCODAdjustment");
	CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr6001Event)request.getAttribute("Event");
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
<input type="hidden" name="week" id="week" />
<input type="hidden" name="trade" id="trade" />
<input type="hidden" name="vvd" id="vvd" />
<!-- layout_wrap(S) -->
<div class="layout_wrap" style="width:1630px;">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 20%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_data">
			<table>
				<colgroup>
			    	<col width="40">
			    	<col width="30">
			    	<col width="50">
			    	<col width="*">
			  	</colgroup>
				<tr>		
					<th>Lane</th>
					<td><input type="text" name="lane1" class="input" style="width:40px;" dataformat="engup" maxlength="3" id="lane1" /></td>
					<td><button type="button" class="btn_etc" name="btn_s1retrieve" id="btn_s1retrieve">Retrieve</button></td>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		</div>
	</div>
    <!-- layout_vertical_2(E) -->
   	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 20%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid mar_left_12 mar_rgt_12" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_data mar_left_12 mar_rgt_12">
			<table>
				<colgroup>
			    	<col width="40">
			    	<col width="30">
			    	<col width="50">
			    	<col width="*">
			  	</colgroup>
				<tr>		
					<th>Lane</th>
					<td><input type="text" name="lane2" class="input" style="width:40px;" dataformat="engup" maxlength="3" id="lane2" /></td>
					<td><button type="button" class="btn_etc" name="btn_s2retrieve" id="btn_s2retrieve">Retrieve</button></td>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		</div>
	</div>
    <!-- layout_vertical_2(E) -->
   	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 20%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_data">
			<table>
				<colgroup>
			    	<col width="40">
			    	<col width="30">
			    	<col width="50">
			    	<col width="*">
			  	</colgroup>
				<tr>		
					<th>Lane</th>
					<td><input type="text" name="lane3" class="input" style="width:40px;" dataformat="engup" maxlength="3" id="lane3" /></td>
					<td><button type="button" class="btn_etc" name="btn_s3retrieve" id="btn_s3retrieve">Retrieve</button></td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	</div>
    <!-- layout_vertical_2(E) -->
   	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 20%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid mar_left_12 mar_rgt_12" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_data mar_left_12 mar_rgt_12">
			<table>
				<colgroup>
			    	<col width="40">
			    	<col width="30">
			    	<col width="50">
			    	<col width="*">
			  	</colgroup>
				<tr>		
					<th>Lane</th>
					<td><input type="text" name="lane4" class="input" style="width:40px;" dataformat="engup" maxlength="3" id="lane4" /></td>
					<td><button type="button" class="btn_etc" name="btn_s4retrieve" id="btn_s4retrieve">Retrieve</button></td>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		</div>
	</div>
    <!-- layout_vertical_2(E) -->
   	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 20%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet5');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_data">
			<table>
				<colgroup>
			    	<col width="40">
			    	<col width="30">
			    	<col width="50">
			    	<col width="*">
			  	</colgroup>
				<tr>		
					<th>Lane</th>
					<td><input type="text" name="lane5" class="input" style="width:40px;" dataformat="engup" maxlength="3" id="lane5" /></td>
					<td><button type="button" class="btn_etc" name="btn_s5retrieve" id="btn_s5retrieve">Retrieve</button></td>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		</div>
	</div>
    <!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) -->

<!-- layout_wrap(S) -->
<div class="layout_wrap" style="width:1630px;">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 20%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet6');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
    <!-- layout_vertical_2(E) -->
   	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 20%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid mar_left_12 mar_rgt_12" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet7');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
    <!-- layout_vertical_2(E) -->
   	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 20%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet8');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
    <!-- layout_vertical_2(E) -->
   	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 20%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid mar_left_12 mar_rgt_12" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet9');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
    <!-- layout_vertical_2(E) -->
   	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 20%">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet10');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
    <!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable" style="display: none;">
	<script type="text/javascript">ComSheetObject('vvdTotal');</script>
</div>
<!-- opus_design_grid(E) -->
		<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable" style="display: none;">
	<script type="text/javascript">ComSheetObject('portTotal');</script>
</div>
<!-- opus_design_grid(E) -->
</form>