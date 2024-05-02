<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3010.js
*@FileTitle  : Deleted Charge Report by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt3010Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTPerformanceAnalysis.ChargeCalculationReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id	= account.getUsr_id();
		strUsr_nm	= account.getUsr_nm();
		strUsr_ofc	= account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();


		event = (EesDmt3010Event)request.getAttribute("Event");
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

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- Developer's task	-->
<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="head_office"			value="<%=ConstantMgr.getHeadOfficeCode()%>"><!-- HEAD OFFICE -->

	<!-- page(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_Minimize" id="btn_Minimize">Minimize</button><!--
			--><button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail</button><!--
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
		<div class="opus_design_inquiry wFit" id="sch_cond_div">
			<!--  MiniLayer (S) -->
			<table>
				<colgroup>
		            <col width="120px" />
		            <col width="100px" />
		            <col width="100px" />
		            <col width="100px" />
		            <col width="" />
				</colgroup>
				<tbody>
					<tr>
						<th class="sm">Period</th>
						<td class="sm"><input type="radio" name="dt_flg" id="dt_flg1" value="F" class="trans" checked><label for="dt_flg1">From Date<label><input type="radio" name="dt_flg" id="dt_flg2" value="D" class="trans"><label for="dt_flg2">Deleted Date<label>
						</td>						
						<td class="sm">
							<input type="text" name="fm_dt" dataformat="ymd" style="width:80px;text-align:center" class="input1" onblur="obj_blur()" onfocus="obj_focus()">~&nbsp;<!--
							--><input type="text" name="to_dt" dataformat="ymd" style="width:80px;text-align:center" class="input1" onblur="obj_blur()" onfocus="obj_focus()"><!--
							--><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>							
						</td>
						<td colspan="2"></td>						
					</tr>
					<tr>
						<th class="sm">DEM/DET Office</th>
						<td class="sm">
							<input type="radio" name="ofc_flg" id="ofc_flg1" value="R" class="trans" checked onclick="ofc_flg_click()"><label for="dt_flg2">RHQ</label>
							<input type="radio" name="ofc_flg" id="ofc_flg2" value="O" class="trans" onclick="ofc_flg_click()"><label for="dt_flg2">Office</label>
						</td>
						<td class="sm">
							<script type="text/javascript">ComComboObject('office',1,80,0,1,0);</script><!--
							--><button type="button" class="multiple_inq"></button><!--							
							--><input type="checkbox" name="chk_sub_ofc" id="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans"><label for="chk_sub_ofc">Incl. Sub Office</label>
						</td>
						<th>Group by</th>
						<td>
							<select name="grp_flg" style="width:80px;" class="input">
								<option value="O" selected>Office</option>
								<option value="R">RHQ</option>
							</select>
						</td>										
					</tr>
					<tr>
						<th>Delete Type</th>
						<td colspan="4">
							<select name="del_cd" style="width:275px;" class="input"></select>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- wrap_search(E) -->
	
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->

</form>
