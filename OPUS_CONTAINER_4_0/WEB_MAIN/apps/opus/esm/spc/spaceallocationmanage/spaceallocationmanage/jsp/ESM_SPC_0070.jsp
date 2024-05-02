<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_SPC_0070.jsp
 *@FileTitle : No-Show Adjustment
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0070Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0070Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpaceAllocationManage.SpaceAllocationManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0070Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" 			id="btn_downexcel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="10px" />
				<col width="100px" />
				<col width="10px" />
				<col width="100px" />
				<col width="10px" />
				<col width="100px" />
				<col width="10px" />
				<col width="100px" />
				<col width="10px" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>Type</th>
				<td class="sm"><span style="display:none;"><input type="radio" name="type" value="M" class="trans">Monthly</span>&nbsp;&nbsp;&nbsp;<input type="radio" name="type" value="2" class="trans" checked>D-7&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="type" value="1" class="trans">D-2</td>
				<th>Year</th>
				<td>
					<select class="input1" name="year" id="year" style="width:80px;" onchange="checkWeek();"></select>
				</td>
				<th>Month</th>
				<td>
					<select class="input1" name="month" id="month" style="width:60px;" onchange="changePeriod();"></select>
				</td>
				<th>Week</th>
				<td>
					<select class="input1" name="week" id="week" style="width:70px;" onchange="changePeriod();"></select>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="h23">
				<th>RHQ</th>
				<td>
					<SELECT name="rhq" class="input1">
						<option></option>
						<option value="SHAAS">SHAAS</option>
						<option value="SINWA">SINWA</option>
						<option value="NYCNA">NYCNA</option>
						<option value="HAMUR">HAMUR</option>
						<option value="SHAAS,SINWA">SHAAS, SINWA</option>
					</SELECT>
				</td>
				<th>Office</th>
				<td><input type="text" name="office" style="width:80px;" maxlength=6 onchange="return office_onchange();" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
				<td colspan="2">	
					<script type="text/javascript">ComComboObject("trade", 2, 100, 0, 0);</script>
				</td>
				<th>Lane</th>
				<td>
					<script type="text/javascript">ComComboObject("lane", 4, 100, 0, 0);</script>
				</td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input class="input1" type="input" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
<script type="text/javascript"> ComTabObject ('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->
<div id="tabLayer" style="display:inline">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable">
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<div id="tabLayer" style="display:none" id="mainTable">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('t1sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</div>
<!-- wrap_result(E) -->
				
</form>