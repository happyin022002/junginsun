<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   VOP_VSK_0054.jsp
*@FileTitle  : LRS SKD Creation(CCA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0054Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0054Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0054Event)request.getAttribute("Event");
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

<input type="hidden" name="op_type">
<input type="hidden" name="vsl_cd" value="">
<input type="hidden" name="tmp_vsl_slan_cd" value="">
<input type="hidden" name="pf_svc_tp_cd" value="">
<input type="hidden" name="slan_stnd_flg" value="Y">
<input type="hidden" name="stnd_pf_svc_tp_cd">

<input type="hidden" name="skdDirCd1">
<input type="hidden" name="skdDirCd2">
<input type="hidden" name="svc_dur_dys">
<input type="hidden" name="initVslCnt">

<%// if screen for Feeder, vsl_svc_tp_cd is "F", else "T"%>
<input type="hidden" name="vsl_svc_tp_cd" value="F">



<!-- page_title_area(S) -->
<div class="page_title_area clear">
    
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_normal" name="btn_New"      	id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button>
		<button type="button" class="btn_normal" name="btn_Simulation"  id="btn_Simulation">Simulation</button>
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
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
				<col width="70px" />
				<col width="90px" />
				<col width="60px" />
				<col width="140px" />
				<col width="65px" />				            	            
				<col width="50px" />
				<col width="50px" />				            	            
				<col width="50px" />				
				<col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>Lane Code</th>
					<td>
						<input  name="vsl_slan_cd" type="text" style="width:37px;text-align:center;ime-mode:disabled" class="input1" dataformat="engup" maxLength="3" tabindex="1"><!--						
						--><button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1"></button>
					</td>
					<th>End Date</th>
					<td>
						<input type="text" name="end_date" style="width:80px;text-align:center" class="input1" dataformat="ymd"  tabindex="2" maxLength="8" size="10" ><!--
						--><button type="button" class="calendar" name="btns_calendar1" id="btns_calendar1"></button>
					</td>
					<th>Frequency</th>
					<td>
						<input type="text" name="brth_itval_dys" style="width:22px;text-align:right;"  class="input" dataformat="int" tabindex="4" >
					</td>
					<th>VSL No.</th>
					<td>
						<input type="text" name="vsl_cnt" style="width:22px;text-align:right;"  class="input" dataformat="int" maxlength="2" tabindex="5">
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
	    <!-- opus_design_btn(E) -->
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">			
	    <!-- opus_design_btn(E) -->
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">			
	    <!-- opus_design_btn(E) -->
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet3');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->		
</div>

</form>
