<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_0496.jsp
*@FileTitle : T/S Remain Status by Location
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0496Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0496Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TransshipmentMgt.TransshipmentMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0496Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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

<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cnmv_sts_cds">
<input type="hidden" name="cntr_tpsz_cds">
<input type="hidden" name="frmr_vvds">
   
    
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
			--><button type="button" class="btn_normal" name="btn_downExcel"   id="btn_downExcel">Down Excel</button><!--  
			--><button type="button" class="btn_normal" name="btn_VVDAssign"   id="btn_VVDAssign">Go to Next VVD Assign</button>
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
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	          <colgroup>
	            <col width="50"/>
	            <col width="178"/>
	            <col width="85"/>
	            <col width="313"/>
	            <col width="95"/>
	            <col width="134"/>
	            <col width="120"/>
	            <col width="" />
	        </colgroup>  
	        <tbody>
				<tr class="h23">
					<th>Location</th>
					<td><input type="text" style="width:50px;" class="input1" value="" name="loc_cd" dataformat="engup" maxlength="5"><input type="text" style="width:30px;" class="input" value="" name="loc_yd_cd" dataformat="engup" maxlength="7"><button type="button" class="input_seach_btn" name="btn_loc_cd" id="btn_loc_cd"></button></td>
					<th>ETB Duration</th>
					<td><input type="text" style="width:75px" class="input" dataformat="ymd" name="vps_etb_dt">~ <input type="text" style="width:75px" dataformat="ymd" class="input" name="vps_etd_dt"><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td> 
					<th>Staying Day(s)</th>
					<td class="stm"><input type="text" style="width:60px;text-align:right;" class="input" value="" name="vps_eta_dt" dataformat="num" maxlength="3"><label for="chk4">or over</label></td>
					<td><button type="button" class="btn_etc" name="btn_yard_sum"   id="btn_yard_sum">Yard Summary</button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<table>
	          <colgroup>
	            <col width="60"/>
	            <col width="250"/>
	            <col width="64"/>
	            <col width="113"/>
	            <col width="67"/>
	            <col width="100"/>
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr class="h23">
					<th>Next VVD</th>
					<td  class="bg" style="height:25px; background-color: #E9E9E9;padding-left:10">
						<input type="radio" value="Y" class="trans" name="next_vvd"><label for="next_vvd">Assigned</label>
						<input type="radio" value="N" class="trans" name="next_vvd"><label for="next_vvd">Not Assigned</label>
						<input type="radio" value="A" class="trans" checked name="next_vvd" ><label for="next_vvd">All</label>
					</td>
					<th>Movement</th>
					<td>
						<input type="text" style="width: 30px; text-align:center;" class="input" value="TS" dataformat="engup" maxlength="2" name="cnmv_sts_cd1"><!-- 
						--><input type="text" style="width: 30px; text-align:center;" class="input" dataformat="engup" value="TN" maxlength="2" name="cnmv_sts_cd2"><!-- 
						--><input type="text" style="width: 30px; text-align:center;" class="input" dataformat="engup" value="EN" maxlength="2" name="cnmv_sts_cd3">
					</td>
					<th>Type/Size</th>
					<td>
						<input type="text" style="width: 30px; text-align:center;" class="input" value="" dataformat="engup" maxlength="4" name="cntr_tpsz_cd1"><!--  
						--><input type="text" style="width: 30px; text-align:center;" class="input" value="" dataformat="engup" maxlength="4" name="cntr_tpsz_cd2"><!-- 
						--><input type="text" style="width: 30px; text-align:center;" class="input" value="" dataformat="engup" maxlength="4" name="cntr_tpsz_cd3"><!-- 
						--><input type="text" style="width: 30px; text-align:center;" class="input" value="" dataformat="engup" maxlength="4" name="cntr_tpsz_cd4"><!-- 
						--><input type="text" style="width: 30px; text-align:center;" class="input" value="" dataformat="engup" maxlength="4" name="cntr_tpsz_cd5">
					</td>
					<td></td>
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
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	     <!-- opus_grid_right(S)-->
		<div class="grid_option_left">
			<table>
	         <colgroup>
	            <col width="70"/>
	            <col width="80"/>
	        </colgroup>
	        <tbody>
	        	<tr>
	        	<td colspan="2" height="5px"></td>
	        	</tr>
				<tr class="h23">
					<th>CNTR Q'ty</th>
					<td>
						<input type="text" style="width:80;text-align:right;" class="input2"  dataformat="int" value="" name="cntr_qty" maxlength="6" readOnly>
					</td>
				</tr>
			</tbody>
		</table>
		</div>
		<!-- opus_grid_right(E)-->
	</div>
	<!-- opus_design_grid(E) -->
	</div>
</form>