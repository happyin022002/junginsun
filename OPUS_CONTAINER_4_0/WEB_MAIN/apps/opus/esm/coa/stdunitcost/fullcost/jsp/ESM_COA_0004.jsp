<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0004.jsp
*@FileTitle  : Node Cost (PA/RA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.fullcost.event.EsmCoa0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EsmCoa0004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSET list

	String successFlag = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String xml			= "";
	
	Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.FullCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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

<form name="form" id="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="sXml" id="sXml" value="<%= xml%>">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
	
	   	<!-- page_location(S) -->
	   	<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	<!--Page Title, Historical (E)-->
	
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!--  MiniLayer (S) -->
			<table>
				<colgroup>
					<col width="1" />					
					<col width="130" />
					<!-- <col width="100" />
					<col width="150" /> -->
					<col width="" />
				</colgroup>
				<tbody>
					<tr>						
						<th>Location</th>
						<td>
							<input type="text" style="width:100px;ime-mode:disabled;" class="input1" name="f_loc_cd" value=""  maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" dataformat="engup">
						</td>
						<!-- <th>Service Lane</th>
						<td>
							<input type="text" style="width:100px;ime-mode:disabled;" name="f_slan_cd" value="" maxlength="3" onKeyDown="ComKeyEnter();" dataformat="engup">
						</td> -->						
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->
	
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">				
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>		<!-- opus_design_grid(E) -->

	<!-- wrap_result(E) -->
	
	<!-- wrap_result(S) -->
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!--  MiniLayer (S) -->
			
			<table>
				<tr>
					<td>
						<h3 class="title_design mar_top_12">Standard Unit Cost Inquiry</h3>
					</td>
					<td>
						<!-- opus_design_btn(S) -->			
						<div class="opus_design_btn">				
							<button type="button" class="btn_accent" name="btn_Retrieve3" id="btn_Retrieve3">Retrieve</button>
						</div>
						<!-- opus_design_btn(E) -->		
					</td>
				</tr>
			</table>
			
			<table>
				<colgroup>
					<col width="90" />					
					<col width="180" />
					<col width="160" />
					<col width="90" />
					<col width="120" />
					<col width="130" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>YYYY-MM</th>
						<td><input type="text" name="f_cost_yrmon" class="input1" style="width:60px;" value="" maxlength="7" dataformat="ym"  onkeypress="ComKeyOnlyNumber(window)" onfocus="this.value=ComReplaceStr(this.value, '-', '');" onblur="addDash(this , 4);" id="f_cost_yrmon" /></td>
						<th>Type/Size</th>
                   		<td><script type="text/javascript">ComComboObject('f_cntr_tpsz_cd',1, 70 , 0 )</script></td>
						<td><input type="radio" class="trans" name="f_full_mty_cd" id="f_full_mty_cd_1" value="F" onClick="showActGrpCombo();" checked><label for="f_full_mty_cd_1">Full</label>&nbsp;&nbsp;&nbsp;<!-- 
							 --><input type="radio" class="trans" name="f_full_mty_cd" id="f_full_mty_cd_2" value="M" onClick="hideActGrpCombo();"><label for="f_full_mty_cd_2">Empty</label></td>
						<th>Special Cargo</th>
                		<td class="pad_left_8">
							<input type="checkbox" class="trans" name="f_spcl_cgo_dg_flg" id="rdo0" value="Y">&nbsp;&nbsp;<lable for="rdo0">DG</lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
							--><input type="checkbox" class="trans" name="f_spcl_cgo_bb_flg" id="rdo1" value="Y">&nbsp;&nbsp;<lable for="rdo1">BB</lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
							--><input type="checkbox" class="trans" name="f_spcl_cgo_awk_flg" id="rdo2" value="Y">&nbsp;&nbsp;<lable for="rdo2">AK</lable>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
							--><input type="checkbox" class="trans" name="f_spcl_cgo_rf_flg" id="rdo3" value="Y">&nbsp;&nbsp;<lable for="rdo3">RF</lable></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<th>Activity Group</th>
						<td><script type="text/javascript">ComComboObject('f_act_grp_cd',1, 170 , 0 )</script></td>
						<th>Location Hierarchy</th>
						<td><script type="text/javascript">ComComboObject('f_cost_loc_grp_cd',1, 70 , 0 )</script></td>					
						<td colspan="2"></td>
					    <td align="right" colspan="2"><div id="div_zoom_in" style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in" title="Zoom in(+)"></button></div><!-- 
        					 --><div id="div_zoom_out" style="display:none" class="grid_option_right"><button type="button" class="btn_up" name="bu_zoom_out"  title="Zoom out(-)" ></button></div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">				
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div style="display:none;">
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet3');</script>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
</form>