<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0233.jsp
*@FileTitle  : MI Transmit History  for IE
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg0233Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0233Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vsl_cd		= "";
	String pgmNo = request.getParameter("pgmNo");
	Logger log = Logger.getLogger("com.clt.apps.BookingCommon.BookingUtil");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0233Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//vsl_cd =  JSPUtil.getParameter(request, "searcheKeyOpener");
		
		//log.debug("vsl_cd"+vsl_cd);
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
<input type="hidden" name="page_no" value="<%=StringUtil.xssFilter(pgmNo)%>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_Transmit" id="btn_Transmit">Transmit</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table style="width:500px">
		<colgroup>
            <col width="40px" />
            <col width="100px" />
            <col width="150px" />
        </colgroup>
		<tbody>
			<tr>
				<th title="Port of Discharging">POD</th>
				<td>
					<input type="text" name="pod_cd" style="width:50px;ime-mode:disabled" value="" maxlength="5" class="input1" dataformat="engup" required caption="POD">
				</td>
				<td class="sm pad_left_4">
					<input type="radio" name="edaoreta" value="EDA" class="trans" checked>MI EDA&nbsp;&nbsp;&nbsp;
					<input type="radio" name="edaoreta" value="ETA" class="trans">SKD ETA
					<input type="text" style="width: 75px; ime-mode: disabled" class="input1"
								dataformat="ymd" name="from_dt" caption="EDA" cofield="to_dt" maxlength="10">&nbsp;~&nbsp;
					<input type="text" style="width: 75px; ime-mode: disabled" class="input1"
								dataformat="ymd" name="to_dt" caption="EDA" cofield="from_dt" maxlength="10">
					<button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
				</td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_grid(E) -->

</form>
