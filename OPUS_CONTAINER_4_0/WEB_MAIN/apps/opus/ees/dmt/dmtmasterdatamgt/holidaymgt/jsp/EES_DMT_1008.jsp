<%--
 =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_1008.jsp
*@FileTitle  : Holiday by Country Inquiry
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.event.EesDmt1008Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%
	EesDmt1008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTMasterDataMgt.HolidayMgt");
	String rhqOfcList = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		rhqOfcList = account.getRhq_ofc_cd();
	   
		event = (EesDmt1008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//rhqOfcList = OfficeCodeMgr.getOfficeCodeList("000004","COM");//RHQ_OFC_LIST
		
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
<input type="hidden" name="svr_id">
<input type="hidden" name="hol_yr">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="wknd_tp_cd">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=rhqOfcList%>">


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


<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="25px" />
	            <col width="100px" />
	            <col width="30px" />
	            <col width="100px" />
	            <col width="50px" />
	            <col width="100px" />
	            <col width="40px" />
	            <col width="100px" />
	            <col width="45px" />
	            <col width="70px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>RHQ</th>
					<td>
						<!-- 
						<select name="rhq" style="width:70;" class="input1" OnChange="searchCountryByRHQ()">
						<option value="" selected>All</option>
							<%--
								String rhqOfc = "";
								for(int i = 0 ; i < rhqOfcList.size() ; i++) {
									rhqOfc = (String)rhqOfcList.get(i);
							--%>
							<option value="<%--=rhqOfc --%>"><%--=rhqOfc --%></option>
							<%--
								}
							--%>
						</select>
						 -->
						<script type="text/javascript">ComComboObject('rhq', 1 ,80 , 0 , 1 , 0, true);</script>
						
					</td>
					<th>Year</th>
					<td>&nbsp;<select name="year" style="width:60;" class="input"></select></td>
					<th>Country</th>
					<td>
						<script language="javascript">ComComboObject('cboCountry', 2, 60 , 0, 0, 0, true)</script>
					</td>
					<th><span id="Region">Region</span></th>
					<td width="100">&nbsp;
						<script language="javascript">ComComboObject('cboRegion', 2, 60 , 0, 0, 0, true)</script>
					</td>
					<th>Location</th>
					<td width="">&nbsp;<input type="text" name="location" style="width:60;" class="input" value="" dataformat="engup" maxlength="5" OnKeyUp="checkLocation()"></td>
					<td>
					<div style="display:none;">
						<script type="text/javascript">ComComboObject('sys_area_grp_id', 1 ,80 , 0 , 1 , 0, true);</script>
					</div>
					</td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
	
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	    <table class="line_bluedot mar_top_4"><tr><td colspan="6"></td></tr></table>
	    
		<!-- layout_wrap(S) -->	    
    	<div class="layout_wrap" style="width: 100%;">
    	
			<!-- layout_vertical_2(S) -->	
			<div class="layout_vertical_2 mar_top_4" style="width: 9.99%;">    	
				<!-- layout_vertical_2(S) -->
					<div class="opus_design_grid" id="mainTable2">
						<script type="text/javascript">ComSheetObject('sheet2');</script>
					</div>
			    <!-- layout_vertical_2(E) -->    	
			</div>
				    	
			<div class="layout_vertical_2 mar_top_4 pad_left_12" style="width: 10%;">				    	
			    <!-- layout_vertical_2(S) -->
					<div class="opus_design_grid" id="mainTable2">
						<script type="text/javascript">ComSheetObject('sheet3');</script>
					</div>			
			    <!-- layout_vertical_2(E) -->    	
			</div>
			
			<div class="layout_vertical_2 mar_top_4 pad_left_12" style="width: 80%;">	    	
			    <!-- layout_vertical_2(S) -->
					<div class="opus_design_grid" id="mainTable2">
						<script type="text/javascript">ComSheetObject('sheet4');</script>
					</div>			
			    <!-- layout_vertical_2(E) -->    
			 </div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>