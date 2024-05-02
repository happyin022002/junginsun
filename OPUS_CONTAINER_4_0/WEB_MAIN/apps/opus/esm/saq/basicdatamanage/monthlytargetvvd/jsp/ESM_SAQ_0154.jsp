<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0154.jsp
*@FileTitle  : Target VVD/Supply Inquiry
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
<%@ page import="com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.event.EsmSaq0154Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0154Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.clt.apps.BasicDataManage.MonthlyTargetVVD");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0154Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  		id="btn_downexcel">Down Excel</button>	
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
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="35px"/>
					<col width="110px"/>
					<col width="55px"/>
					<col width="110px"/>
					<col width="43px"/>
					<col width="110px"/>
					<col width="50px"/>
					<col width="110px"/>
					<col width="40px"/>
					<col width="150px"/>
					<col width="35px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:80px;"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="bse_qtr_cd" id="bse_qtr_cd" style="width:80px;"></select></td>
					<th>Trade</th>
					<td><script language="JavaScript">ComComboObject("trade", 2, 80, 0, 0);</script></td>
					<th>Bound</th>
					<td><select name="bound" id="bound" style="width:80px;"></select></td>
					<th>Lane</th>
					<td><script type="text/JavaScript">ComComboObject("search_lane", 4, 100, 0, 0, 2);</script></td>
					<th>Unit</th>
					<td>
						<select name="unit" id="unit" class="input1" style="width:80px;"></select>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div id="tabLayer" style="display:Inline">
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_skd"  id="btng_skd">SKD Inquiry</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
</div>
<!-- opus_design_grid(E) -->
</form>