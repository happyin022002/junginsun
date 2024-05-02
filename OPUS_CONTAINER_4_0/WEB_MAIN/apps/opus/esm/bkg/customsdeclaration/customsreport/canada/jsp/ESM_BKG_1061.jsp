<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1061.jsp
*@FileTitle  : Notice-Files E-mail Attached Grouping option Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    Logger log = Logger.getLogger("com.clt.opus.CustomsDeclaration.CustomsReport");

    try {
           SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- page(S) -->
<!-- page_title_area(S) -->
<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Notice-Files E-mail Attached Grouping option Pop-up</span></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_OK" id="btn_OK">&nbsp;OK&nbsp;&nbsp;</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	
	   	<!-- page_location(S) 
	   	<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) 
	        <span id="navigation"></span>
	   	</div>
	   	page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="opus_design_inquiry">
		<!--  MiniLayer (S) -->
		<table class="search">
			<tr><td class="title_h"></td>
				<td class="title_s">Among B/Ls you selected for E-mailing, Several B/Ls have same E-mail address.</td></tr>
		</table>
		<table class="search" style="width:100%;">
			<colgroup>
				<col width="130px" />
	            <col width="" />
			</colgroup>
			<tr class="h23">
				<td rowspan="2" style="padding:0, 0, 22, 5">&nbsp;You would like to</td>
				<td width="">
					<table class="search_sm2" border="0" style="width:100%;"> 
					<tr>
					<td width=""><input type="radio" class="trans" name="attach_flg" checked value="1">
					send those Files Separately</td></tr>
					<tr><td width=""><input type="radio" class="trans" name="attach_flg" value="0">
					group
					<input type="text" class="input" style="width:30px;" value="10" name="attach_max_cnt" 
						dataformat="int" maxlength="2">
					Files per E-Mail then send </td></tr>
					</table>	
				</td>
			</tr>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
<!-- popup_contens_area(E) -->
<!-- 개발자 작업  끝 -->
</form>
<%@include file="/bizcommon/include/common_alps.jsp" %>