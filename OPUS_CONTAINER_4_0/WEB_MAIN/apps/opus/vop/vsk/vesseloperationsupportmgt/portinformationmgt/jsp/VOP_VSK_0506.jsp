<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0506.jsp
*@FileTitle  : Port Information Creation
*@author     : CLT
*@since      : 2014/05/15
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.event.VopVsk0504Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0504Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationSupportMgt.PortInformationMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopVsk0504Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="trsp_mod_cd" id="trsp_mod_cd">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="30px"/>
				<col width="120px"/>
				<col width="30px"/>
				<col width="120px"/>
				<col width="30px"/>
				<col width="120px"/>
				<col width="80px"/>
				<col width="90px"/>
				<col width="5px"/>
				<col width="90px"/>
				<col width="*" />
			</colgroup>
			<tr>
				<th>Port</th>
				<td><!-- 
					 --><input type="text" name="loc_cd" id="loc_cd" style="width: 60px; text-align:center; ime-mode:disabled;" class="input1" value="" dataformat="engup" maxlength="5" caption="Vessel Code"><!-- 
					 --><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button><!-- 
				 --></td>
				<th>RHQ</th>
				<td>
					<div id="comboRhq" style="display:none;"><script type="text/javascript">ComComboObject('rhq', 0, 90, 0, 1);</script></div>
					<div id="inputRhq" style="display:inline;"><input type="text" style="width: 80px; text-align:center;" class="input2" value="" name="in_rhq" id="in_rhq" readOnly></div>
				</td>
				
				<th>Year</th>
				<td>
					<input type="hidden" name="nowYear" id="nowYear" style="width: 50px; text-align:center;" class="input2" value="<%=DateTime.getYear()%>"><!-- 
					 --><input type="hidden" name="nowDateTime" id="nowDateTime" style="width: 50px; text-align:center;" class="input2" value="<%=DateTime.getShortDateString()%><%=DateTime.getShortTimeString()%>"><!-- 
					 --><input type="text" name="cel_year" id="cel_year" style="width: 60px; text-align:center;" class="input" value="<%=DateTime.getYear()%>" dataformat="num" maxlength="4" caption="Year"><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button>
				</td>
				<th>Updated Date</th>
				<td>
					<input type="text" name="upd_dt" id="upd_dt" style="width: 115px; text-align:center;" class="input2" readOnly><!-- 
					 --><input type="text" name="upd_usr_id" id="upd_usr_id"  style="width: 70px;" class="input2" readOnly>
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_tab_btn(S) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
<!-- opus_tab_btn(E) -->


	<div id="tabLayer" style="display:inline;">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t1downexcel" id="btn_t1downexcel">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			
			<div class="opus_design_data mar_top_12">
			<table class="grid_2">
				<colgroup>
					<col width="200">
					<col width="*">
				</colgroup> 
				<tbody>
					<tr>
						<th><strong>Remark(s)</strong></th>
						<td><textarea style="width: 100%; height: 60px ;ime-mode:disabled; resize:none" name="mnvr_rmk" id="mnvr_rmk" ></textarea></td>
					</tr>
				</tbody>
			</table> 
			</div>
		</div>
	</div>

	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t2downexcel" id="btn_t2downexcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>

	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t3downexcel" id="btn_t3downexcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>


	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_t4downexcel" id="btn_t4downexcel">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
	</div>




	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t5downexcel" id="btn_t5downexcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('t5sheet1');</script>

		<table width="100%"  id="mainTable"> 
			<tr>
				<td></td>
			</tr>
			<tr>
				<td width="100%" align="right" valign="bottom" style="font-weight: bold; padding-top: 10px; padding-bottom: 10px;">Unit(%)</td>
			</tr>
			<tr>
				<td width="100%">
					<div class="opus_design_btn">				
						<button type="button" class="btn_normal" name="btn_t5downexcel2" id="btn_t5downexcel">Down Excel</button>
					</div>
				</td>
			</tr>


			</table>
			<table>
			<tr>
				<td></td>
			</tr>
				<script type="text/javascript">ComSheetObject('t5sheet2');</script>
			</table>
			<table>
			<tr>
				<td style="text-align: right; padding-top: 10px;">
					<!-- button type="button" class="btn_etc" name="btn_t5tierScg" id="btn_t5tierScg">Tier & Surcharge</button -->
				</td>
			</tr>
		</table>		
	</div>


	<div class="opus_design_grid " name="tabLayer" id="tabLayer" style="display:none">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t6downexcel" id="btn_t6downexcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('t6sheet1');</script>
		<div class="opus_design_data mar_top_12">
			<table class="grid_2">
				<colgroup>
					<col width="200">
					<col width="*">
				</colgroup> 
				<tbody>
					<tr>
						<th><strong>Remark(s)</strong></th>
						<td><textarea style="width: 100%; height: 60px ; resize:none" name="trsp_rmk_td" id="trsp_rmk_td"></textarea></td>
					</tr>
				</tbody>
			</table> 
		</div>
	</div>


	<div class="opus_design_grid " name="tabLayer" id="tabLayer" style="display:none">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_t7downexcel" id="btn_t7downexcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('t7sheet1');</script>
		<div class="opus_design_data mar_top_12">
			<table class="grid_2">
				<colgroup>
					<col width="200">
					<col width="*">
				</colgroup> 
				<tbody>
					<tr>
						<th><strong>Remark(s)</strong></th>
						<td><textarea style="width: 100%; height: 60px ; resize:none" name="trsp_rmk_rd" id="trsp_rmk_rd"></textarea></td>
					</tr>
				</tbody>
			</table> 
		</div>
	</div>		


	<div class="opus_design_grid clear " name="tabLayer" id="tabLayer" style="display:none">
		<script type="text/javascript">ComSheetObject('t10sheet1');</script>
	</div>
</div>
</form>