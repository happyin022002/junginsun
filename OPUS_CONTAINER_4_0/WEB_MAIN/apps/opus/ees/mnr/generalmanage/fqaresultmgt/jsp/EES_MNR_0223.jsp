<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0223.jsp
*@FileTitle  : FQA Result Detail Pop Up 
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
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.event.EesMnr0223Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0223Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String vndrSeq = ((request.getParameter("vndr_seq")==null )?"":request.getParameter("vndr_seq"));
	String ydCd = ((request.getParameter("yd_cd")==null )?"":request.getParameter("yd_cd"));
	String fldAudDt = ((request.getParameter("fld_aud_dt")==null )?"":request.getParameter("fld_aud_dt"));
	String ofcCd = ((request.getParameter("ofc_cd")==null )?"":request.getParameter("ofc_cd"));
	
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0223Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<!-- common use in MNR -->      
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
<input type="hidden" name="pagerows">
<input type="hidden" name="key_value">  
<input type="hidden" name="ofc_cd" value="<%=ofcCd %>">
<input type="hidden" name="usr" value="<%=strUsr_id %>">

<!-- Developer's task -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>FQA Result Detail Info</span></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
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
	<table>
		 <colgroup>
			<col width="70" />
			<col width="300" />
			<col width="28" />
			<col width="110" />
			<col width="70" />
			<col width="120" />
			<col width="130" />
			<col width="" />
		</colgroup> 
		<tbody>
			<tr>
				<th>S/Provider</th>
				<td><input type="text" style="width:60px;" class="input2" readOnly name="vndr_seq" id="vndr_seq" value="<%=vndrSeq%>"  maxlength="6" dataformat="num"><input type="text" style="width:200px;" class="input2" readOnly name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" ></td>
				<th>Yard</th>
			    <td><input type="text" style="width:60px;" class="input2" readOnly name="yd_cd" id="yd_cd" value="<%=ydCd%>"type="text"  dataformat="engup" maxlength="7" ></td>
				<th>Audit Date</th>
				<td><input type="text" style="width:80px;" class="input2" readOnly name="fld_aud_dt" id="fld_aud_dt" value="<%=fldAudDt%>" dataformat="ymd" maxlength="10" ></td>
				<th>Audit  Result History</th>
				<td><script type="text/javascript">ComComboObject('combo1',2, 80 ,1,0,1)</script></td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<h3 class="title_design">Field Quality Audit Result</h3>
	<div class="opus_design_grid">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>

<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->

<!-- layout_wrap(S) -->
	<div class="opus_design_inquiry">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 350px">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	     <!-- layout_vertical_2(E) -->
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2">
			<table>
				<colgroup>
						<col width="250">
					<col width="*">
				</colgroup>
				<tr>
					<th>Total Performance Score by 100% Point</th>
					<td><input type="text" style="width:40px; text-align:right;" class="input2" readOnly name="total" id="total" value=""></td>			
				</tr>
			</table>
		</div>
	     <!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->
</div>
<!-- opus_design_grid(E) -->

<!-- <script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script> -->

<!-- Developer's task -->
</form>