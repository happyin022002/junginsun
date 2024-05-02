<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   esm_bkg_0072.jsp
 *@FileTitle  : BDR Status Report 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0072Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0072Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0072Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
	<input type="hidden" name="f_cmd" id="f_cmd"> 
	<input type="hidden" name="pagerows" id="pagerows"> 
	<input type="hidden" name="ch_usr_id" id="ch_usr_id">
	<input type="hidden" name="com_mrdPath" id="com_mrdPath">
	<input type="hidden" name="com_mrdArguments" id="com_mrdArguments">
	<input type="hidden" name="com_mrdTitle" id="com_mrdTitle">
	<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle">
	<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!-- 
		   --><button type="button" class="btn_normal" name="btn_Print" 	id="btn_Print">Print</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
	<!-- page_title_area(E) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="2%">
					<col width="1%">
					<col width="8%">
					<col width="1%">
					<col width="7%">
					<col width="*">
				</colgroup>
				<tr>
					<th>Period</th>
					<td><!-- 
					 --><select style="width: 100px;" class="input1" name="period_type" id="period_type"><!-- 
					  --><option value="SAIL">SAIL DATE</option><!-- 
					   --><option value="BDR">BDR DATE</option>
						</select>&nbsp;<!-- 
						 --><input type="text" style="width: 80px" value="" class="input1" name="from_dt" id="from_dt" maxlength='10' dataformat='ymd'> ~ <!-- 
						  --><input type="text" style="width: 80px" value="" class="input1" name="to_dt" id="to_dt" maxlength='10' dataformat='ymd'><!-- 
						    --><button type="button" class="calendar ir" name="btn_period" id="btn_period"></button>
					</td>
					<th>BKG Office</th>
					<td><input type="text" style="width: 60px;ime-mode:disabled" value="" class="input1" name="ofc_cd" id="ofc_cd" dataformat='enguponly' maxlength='6'>
					</td>
					<th>Status</th>
					<td><!-- 
					 --><select style="width: 67px;" class="input1" name="status_cd" id="status_cd"><!-- 
					  --><option value="ALL" selected>All</option><!-- 
					   --><option value="F">Firm</option><!-- 
					    --><option value="W">Wait</option><!-- 
					     --></select>
					</td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
<!-- 개발자 작업  끝 -->
</form>