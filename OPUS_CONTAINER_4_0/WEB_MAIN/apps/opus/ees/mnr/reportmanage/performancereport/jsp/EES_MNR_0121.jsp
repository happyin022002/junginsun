<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_MNR_0121.jsp
*@FileTitle : MNR PFMC by Estimation Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0121Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0121Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";

	Logger log = Logger.getLogger("com.clt.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0121Event)request.getAttribute("Event");
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
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="user_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="curr_cd">
<!-- Developer's task	-->
<!-- page_title_area(S) -->
	<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_DownExcel"   id="btn_DownExcel">Down Excel</button>
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
<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
<div class="opus_design_inquiry wFit">
	<table>
		 <colgroup>
			<col width="100px" />
			<col width="130px" />
			<col width="120px" />
			<col width="120px" />
			<col width="80px" />
			<col width="*" />
		</colgroup> 
		<tbody>
			<tr class="h23">
				<th>Period</th>
				<td>
					<script language="javascript">ComComboObject('report_period_type',2, 100 , 1,1)</script>
						<input type="text" name="fm_dt" dataformat="ymd"    caption="from date"        maxlength="10"  size="10"  cofield="to_dt" value="">
                              	~ <input type="text" name="to_dt" dataformat="ymd"    caption="to date"        maxlength="10"  size="10"  cofield="fm_dt"><!--  
                              	--><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
				</td>
				<th>EQ Type</th>
				<td>
					<script language="javascript">ComComboObject('eq_type',2, 100 , 1,1);</script>
				</td>
				<th>TP/SZ</th>
				<td>
					<script language="javascript">ComComboObject('tp_sz_cd', 2, 100 ,0);</script>
					USD Only<input name="check_usd_only" type="checkbox" class="trans">
				</td>
			</tr>
			<tr class="h23">
				<th>Regional HQ</th>
				<td>
					<script language="javascript">ComComboObject('rhq',2, 100, 0, 0);</script>
				</td>
				<th>Office</th>
				<td>
					<script language="javascript">ComComboObject('ofc_cd',2, 100 ,0, 0,'',0,'');</script>
				</td>
				<th>Service Provider</th>
				<td>
					<input type="text" name="vndr_seq" caption="Service Provider" style="width: 57px;text-align:left;" class="input" value="" dataformat="num" maxlength="6"><!--  
					--><button type="button" class="input_seach_btn" name="btn_provider_popup" id="btn_provider_popup"></button><input type="text" name="vndr_lgl_eng_nm" caption="Service Provider" style="width:152;" class="input2" value="" readonly>
				</td>
			
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->


<div class="wrap_result">
			<!-- opus_design_grid(S) -->
					<div class="opus_design_grid">
						<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
							<script language="javascript">ComSheetObject('sheet1');</script>
						<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
					</div>
				<!-- opus_design_grid(E) -->
</div>
</form>