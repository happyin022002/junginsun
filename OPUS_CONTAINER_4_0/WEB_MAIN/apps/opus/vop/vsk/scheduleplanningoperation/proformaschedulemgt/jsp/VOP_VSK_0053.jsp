<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   VOP_VSK_0053.jsp
*@FileTitle  : P/F SKD Creation (CCA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SchedulePlanningOperation.ProformaScheduleMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
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
<input type="hidden" name="min_max_spd" value="1">
<input type="hidden" name="port_cd">
<input type="hidden" name="port_name">
<input type="hidden" name="vsl_svc_tp_cd">
<input type="hidden" name="zd">
<input type="hidden" name="check_vsl_skd" id="check_vsl_skd">
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
			--><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
		</div>
		<!-- opus_design_btn(E) -->
	
	   	<!-- page_location(S) -->
	   	<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->
	</div>
	
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
		    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <table style="bg">
		        <colgroup>
		        	<col width="65px" />
		            <col width="75px" />
		            <col width="85px" />
		            <col width="75px" />	            
		            <col width="85px" />
		            <col width="60px" />
		            <col width="45px" />
		            <col width="60px" />
		            <col width="85px" />
		            <col width="130px" />
		            <col width="90px" />
		            <col width="110px" />
		            <col width="" />
		        </colgroup>
		        <tbody>
					<tr>
						<th>Lane Code</th>
						<td>
							<input type="text" style="width:40px;ime-mode:disabled;text-align:center"  maxlength="3" dataformat="engup" class="input1" name="vsl_slan_cd" value="" tabIndex="1" onKeyPress="if(event.keyCode==13) doSearch();"><!--
							--><button type="button" class="input_seach_btn" name="btns_search"></button>
						</td>
						<th>P/F SKD Type</th>
						<td>
							<input type="text" style="width:40px;ime-mode:disabled;text-align:center" class="input1" name="pf_svc_tp_cd" dataformat="num" maxlength="4" value="" tabIndex="2" onKeyPress="if(event.keyCode==13) doSearch();"><!--
							--><button type="button" class="input_seach_btn" name="btns_search02"></button>
						</td>
						<th>Standard IND</th>
						<td>
							<select name="slan_stnd_flg" style="width:46px;" tabIndex="4" onKeyPress="if(event.keyCode==13) doSearch();">
								<option value="N" selected="selected">N</option>
								<option value="Y">Y</option>
							</select>
						</td>
						<th>Duration</th>
						<td>
							<input type="text" id="svc_dur_dys" name="svc_dur_dys" style="width:40px;ime-mode:disabled;text-align:right" maxlength="4" dataformat="num" class="input2" value="" readOnly>
						</td>
						<th>Created Date</th>
						<td>
							<input type="text" id="cre_dt" name="cre_dt" style="width:120px;text-align:center;" class="input2" readOnly="readonly" value="">
						</td>
						<th>Updated Date</th>
						<td>
							<input type="text" id="upd_dt" name="upd_dt" style="width:120px;text-align:center;" class="input2" readOnly="readonly" value="">
						</td>
						<td></td>
					</tr>				
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">		
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn" id="mainTable">
		        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		        <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
		        <button type="button" class="btn_normal" name="btn_RowInsert" id="btn_RowInsert">Row Insert</button>
		        <button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button>
		    </div>
		    <!-- opus_design_btn(E) -->
		    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script language="javascript">ComSheetObject('sheet1');</script>
		    <script language="javascript">ComSheetObject('sheet2');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	   </div>
	   <!-- opus_design_grid(E) -->
	</div>
</form>