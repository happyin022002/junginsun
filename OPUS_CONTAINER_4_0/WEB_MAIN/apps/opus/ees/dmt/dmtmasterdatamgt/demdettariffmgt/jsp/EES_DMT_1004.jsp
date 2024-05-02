<%--
 =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_1004.jsp
*@FileTitle  : Basic Tariff Detail(s) Inquiry
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt1004Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTMasterDataMgt.DemDetTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt1004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
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
<input type="hidden" name="conti_cd">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="yd_cd">

<input type="hidden" name="cvrg_conti_cd">
<input type="hidden" name="cvrg_cnt_cd">
<input type="hidden" name="cvrg_rgn_cd">
<input type="hidden" name="cvrg_loc_cd">
<input type="hidden" name="cvrg_yd_cd">

<input type="hidden" name="org_dest_conti_cd">
<input type="hidden" name="org_dest_cnt_cd">
<input type="hidden" name="org_dest_rgn_cd">
<input type="hidden" name="org_dest_loc_cd">
<input type="hidden" name="dmdt_trf_cd_list">
<input type="hidden" name="dmdt_cntr_cgo_list">

<input type="hidden" name="code1" value="CD02053"><!-- DEM/DET CONTAINER CARGO TYPE CODE -->
<input type="hidden" name="code2" value="CD01963"><!-- DEM/DET CARGO TYPE CODE -->


<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->		
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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


<!-- opus_design_inquiry(S) -->
<div class="wrap_search pad_btm_12">
	<div class="opus_design_inquiry wFit" id="showMin" style="display: inline">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <tbody>
				<tr>
					<th width="120">Coverage</th>
					<td width="80" align="center">Continent</td>
					<td width="70"><script language="javascript">ComComboObject('combo1', 2, 60 , 0, 1, 0, true)</script></td>
					<td width="60" align="center">Country</td>
					<td width="70"><script language="javascript">ComComboObject('combo2', 2, 60 , 0, 1, 0, true)</script></td>
					<td  width="60" align="center"><span id="Region">Region</span></td>
					<td width="70"><script language="javascript">ComComboObject('combo3', 2, 60 , 0, 0, 0, true)</script></td>
					<td width="60" align="center">Location</td>
					<td width="70"><input type="text" id="cvrg_location" name="cvrg_location" caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" OnKeyUp= "checkLocation1(this)" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
					<td width="40" align="center">Yard</td>
					<td><input type="text" id="yd_cd1" name="yd_cd1" style="width:60px;" class="input" value="" dataformat="engup" maxlength="5"  style="ime-mode:disabled" OnKeyUp="checkYard1(this)" onKeyPress="ComKeyOnlyAlphabet('uppernum')" ><script language="javascript">ComComboObject('combo4', 2, 50 , 0, 0, 0, true)</script></td>
				</tr>
				<tr>
					<th>Origin/Dest.</th>
					<td align="center">Continent</td>
					<td><script language="javascript">ComComboObject('combo5', 2, 60 , 0, 0, 0, true)</script></td>
					<td align="center">Country</td>
					<td><script language="javascript">ComComboObject('combo6', 2, 60 , 0, 0, 0, true)</script></td>
					<td align="center"><span id="Region2">Region</span></td>
					<td><script language="javascript">ComComboObject('combo7', 2, 60 , 0, 0, 0, true)</script></td>
					<td align="center">Location</td>
					<td><input type="text" id="org_dest_loction" name="org_dest_location"  caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" OnKeyUp= "checkLocation2(this)" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
					<td></td>
				</tr>
				<tr>
					<th>Tariff Type</th>
					<td colspan="10"><script language="javascript">ComComboObject('combo8', 2, 287 , 0, 1)</script><button type="button" class="multiple_inq"></button></td>
				</tr>
				<tr>
					<th>CNTR & Cargo Type</th>
					<td colspan="10"><script language="javascript">ComComboObject('combo9', 2, 422 , 0)</script><button type="button" class="multiple_inq"></button></td>
				</tr>
				<tr>
					<th>Validity</td>
					<td class="bg" style="height:25;background-color: #E9E9E9;padding-left:10"><input type="checkbox" id="validity1" name="validity1" value="Y" class="trans" checked><label for="validity1">Current</label></td>
					<td class="bg" style="height:25;background-color: #E9E9E9;padding-left:10"><input type="checkbox" id="validity2" name="validity2" value="Y" class="trans" checked><label for="validity2">To-be</label></td>
					<td class="bg" style="height:25;background-color: #E9E9E9;padding-left:10"><input type="checkbox" id="validity3" name="validity3" value="Y" class="trans"><label for="validity3">Expired</label></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    			
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable2" style="display:none;">
	    			
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>