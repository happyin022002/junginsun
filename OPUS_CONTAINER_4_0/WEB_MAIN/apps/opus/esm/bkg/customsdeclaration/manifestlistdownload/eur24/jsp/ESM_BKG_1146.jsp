<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1146.jsp
*@FileTitle  : ESM_BKG_1146
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1146Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1146Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag	= "";
	String codeList		= "";
	String pageRows		= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strPgmNo     = "";
	String strBlNo      = "";
	String strPolCd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1146Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strBlNo = JSPUtil.getNull(request.getParameter("bl_no"));
        strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
        strPolCd = JSPUtil.getNull(request.getParameter("pol_cd"));

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
	
	function endPage() {
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	}
	
	window.onbeforeunload=function(){
		endPage();
	};
	
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pol_cd" value="<%=strPolCd%>">
<input type="hidden" name="pgm_no" value="<%=strPgmNo%>">
<input type="hidden" name="cnt_cd" value="">

<!-- page(S) -->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Previous Doc Reference No. Pop-up</span></h2>
		<!-- page_title(E) -->
	   
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Select" 	id="btn_Select">Select</button><!--
			--><button type="button" class="btn_normal" name="btn_Close"   id="btn_Close">Close</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">		
	<!-- opus_design_inquiry(S) -->
    <div class="wrap_search">
	 <div class="opus_design_inquiry">
		<table>
			<colgroup>
			<col width="10%">
			<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>B/L No.</th>
					<td>
						<input type="text" name="bl_no" style="width:110px; ime-mode: disabled;" class="input2" value="<%=strBlNo%>" dataformat="eng" maxlength="12px" caption="B/L No." Readonly>
					</td>
				</tr>
			</tbody>
		</table>
	 </div>	
	</div>
	<!-- opus_design_inquiry(E) -->
	
	<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
    </div>
    <!-- opus_design_btn(E) -->
    
    <script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- page(E) -->
</form>
