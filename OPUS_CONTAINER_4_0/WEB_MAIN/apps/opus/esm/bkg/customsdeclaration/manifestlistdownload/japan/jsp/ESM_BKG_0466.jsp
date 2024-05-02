<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0466.jsp
	 *@FileTitle : ESM_BKG-0466
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 
	 *@LastModifier : 
	 *@LastVersion : 1.0

	  
	 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0466Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0466Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	//int rowCount = 0; //count of DB resultSET list

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String vvd_cd = "";
	String pod_cd = "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		vvd_cd = request.getParameter("vvd_cd") == null ? "" : request
				.getParameter("vvd_cd");
		pod_cd = request.getParameter("pod_cd") == null ? "" : request
				.getParameter("pod_cd");

		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0466Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// getting data from server when load the initial screen
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
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
<input type="hidden" name="pagerows"> <!-- start	--> <!-- OUTER - POPUP (S)tart -->

<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		
	<!-- page_title(E) -->
	
	    
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_transmit"   id="btn_transmit">Transmit to Sea-NACCS</button>
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
	
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
<div class="wrap_result">
    <div class="opus_design_grid">
    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
</form>