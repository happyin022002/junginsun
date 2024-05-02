<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   VOP_VSK_0230.jsp
*@FileTitle  : VVD Code Help
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
<%@ page import="com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VskGloEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 
<%
	VskGloEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");
	
	String ctrlCd = "";
	String vslCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VskGloEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		ctrlCd = request.getParameter("ctrl_cd");
		vslCd = request.getParameter("vsl_cd");
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
<input type="hidden" name="slan_stnd_flg">
<input type="hidden" name="op"> 
<input type="hidden" name="vsl_cd" value="<%=StringUtil.xssFilter(vslCd) %>">
<input type="hidden" name="ctrl_cd" value="<%=StringUtil.xssFilter(ctrlCd) %>">

	 <!-- popup_title_area(S) -->
	 <div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>VVD Code Inquiry</span></h2>
			<!-- page_title(E) -->
			 		 
			 <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_ok"	   id="btn_ok">OK</button><!-- 
	        	 --><button type="button" class="btn_normal" name="btn_close"  id="btn_close">Close</button>	        	
		    </div>
		    <!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- popup_title_area(E) -->
	
	<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents" style="overflow:hidden;">
	
		<div class="wrap_result">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable">
			    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <script language="javascript">ComSheetObject('sheet1');</script>		
			    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	</div>
	<!-- popup_contens_area(E) -->

</form>

