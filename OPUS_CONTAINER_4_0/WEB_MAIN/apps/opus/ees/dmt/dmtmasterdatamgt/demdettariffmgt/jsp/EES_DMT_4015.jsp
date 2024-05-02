<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4015.jsp
*@FileTitle  : SZPBB DEM Tariff Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt4015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt4015Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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


		event = (EesDmt4015Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
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
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button>
	</h2>
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

<!-- wrap_search_tab(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry sm">   
	<table class="search"> 
       		<tr><td class="bg">
				<div id="showMin" style="display: inline"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979px;"> 
				<tr class="h23">
					<th width="90px">Coverage</th>
					<th width="60px" class="stm">Continent</th>
					<td width="80px">
						<input type="text" id="cvrg_continent" name="cvrg_continent" caption="Continent" style="width:60px;" class="input2" readonly value="A" >
					</td>
					<th width="55px" class="stm">Country</th>
					<td width="80px">
						<input type="text" id="cvrg_country" name="cvrg_country" caption="country" style="width:60px;" class="input2" readonly value="CN" >
					</td>
					<th width="45px" class="stm">Region</th>
					<td width="80px">
						<input type="text" id="cvrg_region" name="cvrg_region" caption="region" style="width:60px;" class="input2" readonly value="CNS" >
					</td>
					<th width="55px" class="stm">Location</th>
					<td width="80px">
						<input type="text" id="cvrg_location" name="cvrg_location" caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" OnKeyUp= "checkLocation1(this)" onKeyPress="ComKeyOnlyAlphabet('upper')">
					</td>
					<th width="30px" class="stm">Yard</th>
					<td width="334px">
						<input type="text" id="yd_cd1" name="yd_cd1" style="width:60px;" class="input" value="" dataformat="engup" maxlength="5"  style="ime-mode:disabled" OnKeyUp="checkYard1(this)" onKeyPress="ComKeyOnlyAlphabet('upper')" ><!--
						--><script language="javascript">ComComboObject('combo1', 2, 60 , 0, 0, true)</script>
					</td>	
					</tr> 
					<tr class="h23">
					<th width="">Origin/Dest.</th>
					<th width="60px" class="stm">Continent</th>
					<td width="80px"><script language="javascript">ComComboObject('combo2', 2, 60 , 0, 0, 0, true)</script></td>
					<th width="55px" class="stm">Country</th>
					<td width="80px"><script language="javascript">ComComboObject('combo3', 2, 60 , 0, 0, 0, true)</script></td>
					<th width="45px" class="stm"><span id="Region2">Region</span></th>
					<td width="80px">&nbsp;<script language="javascript">ComComboObject('combo4', 2, 60 , 0, 0, 0, true)</script></td>
					<th width="55px" class="stm">Location</th>
					<td width="80px">&nbsp;<input type="text" id="org_dest_loction" name="org_dest_location"  caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" OnKeyUp= "checkLocation2(this)" onKeyPress="ComKeyOnlyAlphabet('upper')"></td>
					</tr>
					</table> 
					<table class="search" border="0" style="width:979px;"> 
					<tr class="h23">
						<th width="85px">&nbsp;&nbsp;Tariff Type</th>
						<td width="" colspan="5"><script language="javascript">ComComboObject('combo5', 2, 259 , 1, 1)</script></td>
					</tr>
					</table> 
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					
					<table class="search" border="0" style="width:979px;"> 
					<tr class="h23">
						<th width="140px">CNTR & Cargo Type</th>
						<td width="" colspan="5">
							<script language="javascript">ComComboObject('combo6', 2, 370 , 0)</script><!--
							--><button type="button" class="multiple_inq"></button>							
						</td>
					</tr>
					</table> 
					
					<table class="search_sm" border="0" style="width:537px;">
					
					<tr class="h23">
						<th width="70px">Validity</th>
						<td width="100px" class="stm"><input type="checkbox" name="validity1" value="Y" class="trans" checked>&nbsp;Current</td>
						<td width="100px" class="stm"><input type="checkbox" name="validity2" value="Y" class="trans" checked>&nbsp;To-be</td>
						<td width="800px" class="stm" colspan="2"><input type="checkbox" name="validity3" value="Y" class="trans">&nbsp;Expired</td>
					</tr>
				</table>
				<!--  biz_1  (E) --></div>									
			</td></tr>
		</table>	
	</div>
</div>

<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid sm" id="mainTable" >										
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<script language="javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->					
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->				

</form>

<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid sm" id="mainTable" style="display:none;">										
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('sheet2');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->					
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
