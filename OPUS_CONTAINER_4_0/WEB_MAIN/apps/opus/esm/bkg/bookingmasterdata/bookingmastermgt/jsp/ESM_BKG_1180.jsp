<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1180.jsp
*@FileTitle : E-BKG Handling Office Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.10
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2014.06.10 문동선
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1180Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1180Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingProcessMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg1180Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if		
		
		ComSetObjValue(document.form.screenName,"<%=screenName%>");
		loadPage();
	}
	
</script>
</head>


<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="vel_type" id="vel_type">
<input type="hidden" name="vel_data" id="vel_data">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName">
<!-- 개발자 작업	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button> 
		<button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button> 
		 <button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button>
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
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<colgroup>
				<col width="50"/>
				<col width="80"/>
				<col width="40"/>
				<col width="40">
				<col width="40">
				<col width="40">
				<col width="130"/>
				<col width="30"/>
				<col width="130"/>
				<col width="100"/>
				<col width="130"/>
				<col width="*"/>
		</colgroup>
		<tbody>
			<tr>
				<th>BKG Office</th>
				<td>
					<input type="text" style="width: 60px; ime-mode: disabled" class="input"	name="hndl_ofc_cd" id="hndl_ofc_cd" maxlength="5" dataformat="engup" value="">
				</td>
				<th>POL</th>
				<td>
					<input type="text" style="width: 60px; ime-mode: disabled" class="input" name="pol_cd" id="pol_cd" maxlength="5" dataformat="engup" value="">
				</td>
				<th>POR</th>
				<td>
					<input type="text" style="width: 60px; ime-mode: disabled" class="input" name="por_cd" id="por_cd" maxlength="5" dataformat="engup" value="">
				</td>
				<th>Office Country code</th>
				<td>
					<input type="text" style="width: 30px; ime-mode: disabled" class="input" name="vt_cust_cnt_cd" max="2" id="vt_cust_cnt_cd" maxlength="2" dataformat="engup" value="">
				</td>
				<th>Partner Office Code</th>
				<td>
					<input type="text" style="width: 100px; ime-mode: disabled" class="input" name="vt_cust_ofc_cd" max="20" id="vt_cust_ofc_cd" dataformat="engup" otherchar=" -" value="">
				</td>
				<th>Partner Office Name</th>
				<td>
					<input type="text" style="width: 130px; ime-mode: disabled" class="input" name="vt_cust_ofc_nm" id="vt_cust_ofc_nm">
				</td>
			</tr>		
		</tbody>
	</table>
</div>
</div>

<div class="wrap_result"> 
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row&nbsp;Add</button>
            <button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Row&nbsp;Delete</button>
        </div>
        <!-- opus_design_btn(E) -->
    
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script type="text/javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>
    <!-- opus_design_grid(E) -->
</div>
</form>
