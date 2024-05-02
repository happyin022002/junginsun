<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_1006.jsp
*@FileTitle  : Commodity Exception Tariff Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.log4j.StringUtils"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt1006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

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


		event = (EesDmt1006Event)request.getAttribute("Event");
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

<input type="hidden" name="dmdt_trf_cd">
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
<input type="hidden" name="dmdt_trf_cd_list">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    
    <!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
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
	
	
	<!-- opus_design_inquiry(S) -->
<div class="wrap_search">	
	<div class="opus_design_inquiry wFit" id="MiniLayer">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="75px" />
	            <col width="120px" />
	            <col width="120px" />
	            <col width="42px" />
	            <col width="78px" />
	            <col width="120px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>&nbsp;&nbsp;Coverage</th>
					<td class="stm">&nbsp;Continent&nbsp;<script language="javascript">ComComboObject('combo1', 2, 40 , 0, 0, 0, true)</script></td>
					<td class="stm">Country&nbsp;<script language="javascript">ComComboObject('combo2', 2, 50 , 0, 0, 0, true)</script></td>
					<td class="stm"><span id="Region">Region</span></td>
					<td >&nbsp;<script language="javascript">ComComboObject('combo3', 2, 60 , 0, 0, 0, true)</script></td>
					<td class="stm">Location&nbsp;<input type="text" id="cvrg_location" name="cvrg_location" caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" OnKeyUp="checkLocation1(this)"></td>
					<td></td>
				</tr>
				<tr class="h23">
					<th>&nbsp;&nbsp;Origin</th>
					<td class="stm">&nbsp;Continent&nbsp;<script language="javascript">ComComboObject('combo4', 2, 40 , 0, 0, 0, true)</script></td>
					<td class="stm">Country&nbsp;<script language="javascript">ComComboObject('combo5', 2, 50 , 0, 0, 0, true)</script></td>
					<td class="stm"><span id="Region2">Region</span></td>
					<td>&nbsp;<script language="javascript">ComComboObject('combo6', 2, 60 , 0, 0, 0, true)</script></td>
					<td class="stm">Location&nbsp;<input type="text" id="org_dest_location" name="org_dest_location" caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" OnKeyUp="checkLocation2(this)"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<table>
	        <colgroup>
	            <col width="77px" />
	            <col width="350px" />
	            <col width="66px" />
	            <col width="100px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>&nbsp;&nbsp;Tariff Type</th>
					<td><script language="javascript">ComComboObject('combo7', 2, 300 , 0, 0)</script><button type="button" class="multiple_inq"></button></td>
					<th>Confirmed</th>
					<td><select name="cfm_flg" style="width:53px;" class="input">
						<option value="" >All</option>
						<option value="Y" selected>Y</option>
						<option value="N">N</option>
						</select>
					</td>
					<td></td>
				</tr>
				<tr class="h23">
					<th>Validity</th>
					<td class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10px;">
					<input type="checkbox" id="validity1" name="validity1" value="Y" class="trans" checked><label for="validity1">Current</label>
					<input type="checkbox" id="validity2" name="validity2" value="Y" class="trans" checked><label for="validity2">To-be</label>
					<input type="checkbox" id="validity3" name="validity3" value="Y" class="trans"><label for="validity3">Expired</label>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
			
		<script language="javascript">ComSheetObject('sheet1');</script>
		
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>