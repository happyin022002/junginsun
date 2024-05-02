<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0055.jsp
*@FileTitle : Reefer Spare Parts Supply Inquiry
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0055Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0055Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm();
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();

		event = (EesMnr0055Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}

</script>


<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="retfld">


	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title">Reefer Spare Part Supply Inquiry</span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
				<button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button>
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
	
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="70px" />
	            <col width="100px" />
	            <col width="100px" />
	            <col width="180px" />
	            <col width="70px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>C. Office</th>
					<td>
						<input type="text" name="cost_ofc_cd" style="width:65px;" class="input1" value="" required dataformat="engup"><!--  
						--><button type="button" class="input_seach_btn" name="btn_cost_ofc_cd" id="btn_cost_ofc_cd"></button>
						<!-- <img class="cursor" src="img/btns_search.gif" width="19px" height="20" border="0" align="absmiddle" name="btn_cost_ofc_cd"> -->
					</td>
					<th>W/O Issue Date</th>
					<td>
						<input type="text" maxlength=10 style="width:80px;text-align:center" class="input1" name="fromcal" dataformat="ymd" required  fulfill >&nbsp;~&nbsp;
						<input type="text" maxlength=10 style="width:80px;text-align:center" class="input1" name="tocal" dataformat="ymd" required  fulfill><!--  
						--><button type="button" class="calendar" name="btn_calendar" id="btn_calendar"></button>
						<!-- <img class="cursor" src="img/btns_calendar.gif" width="19px" height="20" border="0" align="absmiddle" name="btn_calendar"> -->
					</td>
					<th>Vessel</th>
					<td>
						<input type="text" name="vsl_cd" style="width:65px;" class="input" value="" dataformat="engup"><!--  
						--><button type="button" class="input_seach_btn" name="btn_vessel" id="btn_vessel"></button>
						<!-- <img class="cursor" src="img/btns_search.gif" width="19px" height="20" border="0" align="absmiddle" name="btn_vessel"> -->
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
	<div class="opus_design_grid"  id="mainTable">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_grid(E) -->
</div>    			


</form>
<%@include file="/bizcommon/include/common_opus.jsp" %>