<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1010.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg1010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1010Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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

<form name="form" id="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="frm_attr_ctnt2" id="frm_attr_ctnt2" />
<%
	String vvd     = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String portCd     = (request.getParameter("port_cd") == null)? "":request.getParameter("port_cd");
%>


<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title">WHF Declaration Check-List</span></button></h2>
		<!-- page_title(E) -->


		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new"      id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="95" />
	            <col width="250" />
	            <col width="35" />
	            <col width="130" />
	            <col width="35" />
	            <col width="130" />
	            <col width="35" />
	            <col width="130" />
	            <col width="*" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>입출항 일자</th>
					<td><!--
					--><input type="text" name="s_date" dataformat="ymd" class="input1" caption="년월일" value="" maxlength="10" size="10" id="s_date" /><!--
					-->~&nbsp;<!--
					--><input type="text" name="e_date" dataformat="ymd" class="input1" caption="년월일" value="" maxlength="10" size="10" id="e_date" /><!--
					--><button type="button" id="btn_calendar2" name="btn_calendar2" class="calendar ir"></button>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:100px;ime-mode:disabled" name="vvd" maxlength="9" dataformat="engup" class="input" id="vvd" /></td>
					<th>Port</th>
					<td><input type="text" style="width:100px;ime-mode:disabled" name="port_cd" maxlength="5" dataformat="engup" class="input" id="port_cd" /></td>
					<th>Lane</th>
					<td><input type="text" style="width:100px;ime-mode:disabled" name="vsl_slan_cd" maxlength="3" dataformat="engup" class="input" id="vsl_slan_cd" /></td>
					<td><!--
					--><input type="radio" id="radio1" value="I" class="trans" name="ixport" checked="checked" id="ixport" />&nbsp;<lable for="radio1">수입</lable>&nbsp;&nbsp;&nbsp;<!--
					--><input type="radio" id="radio2" value="O" class="trans" name="ixport" id="ixport" />&nbsp; <lable for="radio2">수출</lable>
					</td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>