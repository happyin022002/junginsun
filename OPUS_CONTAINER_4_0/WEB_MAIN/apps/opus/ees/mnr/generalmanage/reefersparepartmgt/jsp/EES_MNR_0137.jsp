<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_MNR_0137.jsp
*@FileTitle : Standard Reefer Spare Parts List of the vsl
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0137Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0137Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id         =	account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm = account.getOfc_eng_nm();
		
		event = (EesMnr0137Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var currOfcCd = '<%=currOfcCd %>';
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_gubuns">
<input type="hidden" name="spr_prt_no" value="">

<input type="hidden" name="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" value="">
<input type="hidden" name="cost_ofc_cd" value="">
<input type="hidden" name="spr_prt_spl_tp_cd" value="">
<input type="hidden" name="spr_work_type" value=""> 

<!-- page_title_area(S) -->
	<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->


	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!--
	--><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!--
	--><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
<div class="opus_design_inquiry wFit">
	<table>
		 <colgroup>
			<col width="80px" />
			<col width="140px" />
			<col width="80px" />
			<col width="" />
		</colgroup> 
		<tbody>
			<tr class="h23"> 
				<th>Unit Type</th>
				<td><script type="text/javascript">ComComboObject('combo_spr_ut_tp_nm',2, 120 , 1);</script><input type="hidden" name="spr_ut_tp_nm"></td>
				<th>Spare Type</th>
				<td><script type="text/javascript">ComComboObject('combo_spr_tp_cd',2, 120 , 1);</script><input type="hidden" name="spr_tp_cd"></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
	        <button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>	
	

</form>
<%@include file="/bizcommon/include/common_opus.jsp" %>
