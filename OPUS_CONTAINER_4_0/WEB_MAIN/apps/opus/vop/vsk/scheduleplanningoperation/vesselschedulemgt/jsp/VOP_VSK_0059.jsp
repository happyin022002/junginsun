<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0059.jsp
*@FileTitle  : VSLSKD Delete & Closing (CCA)
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
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0059Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0059Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd = "";
	String strUsrAuthTpCd = "";
	String availActivate = "";
	
	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strUsrAuthTpCd = account.getUsr_auth_tp_cd();
		
		if ("S".equals(strUsrAuthTpCd) || "CLTCO".equals(strOfc_cd)) {
			availActivate = "Y";
		}
		
		event = (VopVsk0059Event)request.getAttribute("Event");
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
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="vvdList">
<input type="hidden" name="tmp_vsl_slan_cd" value="">
<input type="hidden" name="tmp_vsl_cd" value="">
<input type="hidden" name="availActivate" value="<%=availActivate %>">

<%// in case screen for Feeder, vsl_svc_tp_cd is "F", else "T"%>
<input type="hidden" name="vsl_svc_tp_cd" value="F">
<input type="hidden" name="slan_stnd_flg" value="Y">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button>
		<button type="button" class="btn_normal" name="btn_SkdClosing" id="btn_SkdClosing">SKD&nbsp;Holding</button>
		<% if ("Y".equals(availActivate)) {%>
			<button type="button" class="btn_normal" name="btn_SkdActivate" id="btn_SkdActivate">SKD&nbsp;Activate</button>
		<% } %>
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
<div class="opus_design_inquiry">
    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <table>
    	<colgroup>
            <col width="70px" />
            <col width="100px" />
            <col width="80px" />
            <col width="100px" />
            <col width="" />
        </colgroup>
        <tbody>
			<tr>
				<th>Lane Code</th>        
				<td>
					<input type="text" style="width:37px;text-align:center;ime-mode:disabled;" class="input" value="" name="vsl_slan_cd" maxlength="3" tabindex="1" dataformat="engup"><!-- 
					 --><button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1"></button>
				</td>
				<th>Vessel Code</th>
				<td>
					<input type="text" style="width:60px;text-align:center;ime-mode:disabled;" name="vsl_cd" maxlength="4" tabindex="2" dataformat="engup" ><!-- 
					 --><button type="button" class="input_seach_btn" name="btns_search2" id="btns_search2"></button>
				</td>
				<td>&nbsp;</td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>