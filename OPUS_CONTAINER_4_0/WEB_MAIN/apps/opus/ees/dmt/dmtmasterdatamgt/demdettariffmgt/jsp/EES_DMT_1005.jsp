<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1005.jsp
*@FileTitle : Commodity Exception Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.26 김태균
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.log4j.StringUtils"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt1005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTMasterDataMgt.DemDetTariffMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt1005Event)request.getAttribute("Event");
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

<input type="hidden" name="sel_dmdt_trf_cd">
<input type="hidden" name="cvrg_conti_cd">
<input type="hidden" name="cvrg_cnt_cd">
<input type="hidden" name="cvrg_rgn_cd">
<input type="hidden" name="cvrg_ste_cd">
<input type="hidden" name="cvrg_loc_cd">
<input type="hidden" name="org_dest_conti_cd">
<input type="hidden" name="org_dest_cnt_cd">
<input type="hidden" name="org_dest_rgn_cd">
<input type="hidden" name="org_dest_ste_cd">
<input type="hidden" name="org_dest_loc_cd">

<input type="hidden" name="svr_id">
<input type="hidden" name="trf_seq">
<input type="hidden" name="trf_grp_seq">

<input type="hidden" name="wknd1" value="SAT">
<input type="hidden" name="wknd2" value="SUN">
<input type="hidden" name="dmdt_trf_cd_list">

<input type="hidden" name="cmdt_cd">
<input type="hidden" name="cmdt_row">

<input type="hidden" name="today">


<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	    
	    <!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
			<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
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
<div class="wrap_search pad_btm_8">	
	<div class="opus_design_inquiry wFit" id="MiniLayer" style="display: inline">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="70px" />
	            <col width="700px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Tariff Type</th>
					<td><script language="javascript">ComComboObject('combo1', 2, 105 , 0, 1, 0, true)</script><!--
				      --><input type="text" name="dmdt_trf_nm" style="width:411px;" class="input2" readonly value=""></td>
					<td></td>
				</tr>
				
			</tbody>
		</table>
		
	    <table>
	        <colgroup>
	            <col width="75px" />
	            <col width="60px" />
	            <col width="80px" />
	            <col width="55x" />
	            <col width="80px" />
	            <col width="45px" />
	            <col width="80px" />
	            <col width="55px" />
	            <col width="75px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>Coverage</th>
					<td class="stm">Continent</td>
					<td><script language="javascript">ComComboObject('combo2', 2, 40 , 0, 1, 0, true)</script></td>
					<td class="stm">Country</td>
					<td><script language="javascript">ComComboObject('combo3', 2, 50 , 0, 1, 0, true)</script></td>
					<td class="stm"><span id="Region">Region</span></td>
					<td><script language="javascript">ComComboObject('combo4', 2, 60 , 0, 0, 0, true)</script></td>
					<td class="stm">Location</td>
					<td><input type="text" id="cvrg_location" name="cvrg_location" caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" OnKeyUp="checkLocation1(this)"></td>
					<td></td>
				</tr>
				<tr class="h23">
					<th><span id="OriginDest">Origin</span></th>
					<td class="stm">Continent</td>
					<td><script language="javascript">ComComboObject('combo5', 2, 40 , 0, 1, 0, true)</script></td>
					<td class="stm">Country</td>
					<td><script language="javascript">ComComboObject('combo6', 2, 50 , 0, 0, 0, true)</script></td>
					<td class="stm"><span id="Region2">Region</span></td>
					<td><script language="javascript">ComComboObject('combo7', 2, 60 , 0, 0, 0, true)</script></td>
					<td class="stm">Location</td>
					<td><input type="text" id="org_dest_location" name="org_dest_location" caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" OnKeyUp="checkLocation2(this)"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
	</div>
</div>	
	
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		
		<!-- opus_grid_left(S)-->
		<div class="grid_option_left">&nbsp;&nbsp;&nbsp;*&nbsp;&nbsp;Effective Date:  Same as Basic Tariff Effective Date</div>
		<!-- opus_grid_left(E)-->
						
						
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_RowCopy" id="btn_RowCopy">Row Copy</button>
			<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
			<button type="button" class="btn_normal" name="btn_Update" id="btn_Update">Update</button>
			<button type="button" class="btn_normal" name="btn_Expire" id="btn_Expire">Expire</button>
		</div>
		<!-- opus_grid_btn(E) -->
		
		
		<script language="javascript">ComSheetObject('sheet1');</script>
		
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>	
				
<!-- Developer's task end -->
</form>
