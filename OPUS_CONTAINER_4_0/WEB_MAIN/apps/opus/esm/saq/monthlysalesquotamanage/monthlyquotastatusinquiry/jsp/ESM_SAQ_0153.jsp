<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0153.jsp
*@FileTitle  : Process Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.event.EsmSaq0153Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0153Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaStatusInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0153Event)request.getAttribute("Event");
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

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->
<input type="hidden" name="grp_flg" id="grp_flg" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btng_downexcel" 		id="btng_downexcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="45px"/>
					<col width="330px"/>
					<col width="50px"/>
					<col width="160px"/>
					<col width="55px"/>
					<col width="160px"/>
					<col width="45px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
							<th>View</th>
							<td>
								<input type="radio" name="grp" value="trade" checked="" onclick="grp_onChange()" id="grp_trade"/><label for="grp_trade">Trade/Bound</label>
								<input type="radio" name="grp" value="org" onclick="grp_onChange()" id="grp_org"/><label for="grp_org">Origin</label></td>
							<th>Year</th>
							<td><select class="input1" name="year" id="year" style="width:90px;" onchange="year_onChange();"></select></td>
							<th>Quarter</th>
							<td colspan="3"><select class="input1" name="quarter" id="quarter" style="width:90px;" onchange="quarter_onChange();"></select></td>
						</tr>
						<tr>
							<th>Step</th>
							<td><select name="step" id="step" style="width:260px;"></select></td>
							<th>Status</th>
							<td><select name="sts" id="sts" style="width:90px;"></select></td>
							<th>Trade</th>
							<td><select name="trd_cd" id="trd_cd" style="width:90px;" onchange="trd_cd_onChange()"></select></td>
							<th>Bound</th>
							<td><select name="dir_cd" id="dir_cd" style="width:80px;"></select></td>
						</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
