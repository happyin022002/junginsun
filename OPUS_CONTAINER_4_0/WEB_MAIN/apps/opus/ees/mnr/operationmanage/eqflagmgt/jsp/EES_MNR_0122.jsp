<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0122.jsp
*@FileTitle  : Damage Flagging/Unflagging 
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0122Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0122Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String workApp 		    = "";
	
	String strOfc_cd        = "";
    String rhqOfcCd         = "";

	Logger log = Logger.getLogger("com.clt.apps.OperationManage.EQFlagMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		workApp = account.getAccess_system();
		
		strOfc_cd = account.getOfc_cd();
        rhqOfcCd  = account.getRhq_ofc_cd();
        
		event = (EesMnr0122Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<!--Use a common at MNR  -->
<script  type="text/javascript">
	//workApp ALP or SPP
	var workApp = '<%=workApp%>';
	var currOfcCd = '<%=strOfc_cd %>';
    var rhqOfcCd  = '<%=rhqOfcCd %>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eq_no" id="eq_no" />
<input type="hidden" name="mnr_dmg_flg_dt" value="" id="mnr_dmg_flg_dt" />
<input type="hidden" name="mnr_flg_tp_cd" value="" id="mnr_flg_tp_cd" />
<input type="hidden" name="flg_yd_type" value="" id="flg_yd_type" />

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrive" id="btn_retrive">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
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
<div class="opus_design_inquiry wFit">
	<div id="sch_cond_div" style=display:block;>
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="80" />
            <col width="80" />
            <col width="60" />
            <col width="80" />
            <col width="70" />
            <col width="120" />
            <col width="60" />            
            <col width="80" />
            <col width="80" />
            <col width="120" />
            <col width="80" />
            <col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>EQ Type</th>
				<td><script type="text/javascript">ComComboObject('eq_knd_cd',1, 100 , 1,1)</script></td>
				<th>Yard</th>
				<td><input style="width:60px;" type="text" name="mnr_dmg_flg_yd_cd" value="" dataformat="engup" maxlength="7" caption="yard cd" class="input1" id="mnr_dmg_flg_yd_cd" /><button type="button" class="input_seach_btn" name="btns_popup" id="btns_popup"></button></td>
				<th>EQ No.</th>
				<td><input type="text" name="eq_list" style="width:100px;" class="input" dataformat="engup" id="eq_list" /><button type="button" class="multiple_inq ir" name="eq_no_multi" id="eq_no_multi"></button></td>
				<th>Flag Type</th>
				<td><script type="text/javascript">ComComboObject('flag_type',1, 80 , 1,1)</script></td>
				<th>TP/SZ</th>
				<td><script type="text/javascript">ComComboObject('eq_tpsz_cd', 2, 120 ,0)</script></td>
				<th>Over Days</th>
				<td><input type="text" name="mnr_dmg_flg_dt_over_day" dataformat="num" style="width:60px; text-align:right" class="input" value="" id="mnr_dmg_flg_dt_over_day" /> </td>
			</tr>
		</tbody>
	</table>
	</div>
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<div class="layout_vertical_2 mar_rgt_8" style="width:59%">
		<!-- opus_grid_btn(S) -->
        <div class="opus_design_btn">
        	<button class="btn_accent" name="btn_more" id="btn_more" type="button">more</button>
            <button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!--
            --><button type="button" class="btn_normal" name="btn_loadExcel" id="btn_loadExcel">Load Excel</button>
        </div>
        <!-- opus_grid_btn(E) -->
	
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script  type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	
	<div class="layout_vertical_2" style="width:40%">
		<h3 class="title_design">EQ General Information</h3>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
		<h3 class="title_design">Damage Flagging History</h3>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet5');</script>
		</div>
	</div>
</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

<!-- Developer's task   -->
</form>