<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0052.jsp
*@FileTitle  : Confirmation and Distribution  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.event.EsmSaq0052Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0052Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaRelease");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSaq0052Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="mqta_rlse_ver_no" id="mqta_rlse_ver_no" />
<input type="hidden" name="is_new_version" id="is_new_version" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_generateversion" 		id="btn_generateversion">Generate Version</button>
		<button type="button" class="btn_normal" name="btn_release"  		id="btn_release">Distribute</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="38px"/>
					<col width="120px"/>
					<col width="60px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:80px;"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="quarter" id="quarter" style="width:80px;"></select></td>
				</tr>	
				
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- layout_wrap(S) -->

		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width:50%">
		        <!-- opus_design_grid(S) -->
		        <div class= "wrap_result">
		        <div class="opus_design_grid clear">
		            <script type="text/javascript">ComSheetObject('sheet1');</script>
		        </div>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		    <div class="layout_vertical_2 style="width:50%"">
		        <!-- opus_design_grid(S) -->
		        <div class= "wrap_result">
		        <div class="opus_design_grid clear">
		            <script type="text/javascript">ComSheetObject('sheet2');</script>
		        </div>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		</div>

<!-- layout_wrap(E) -->
</form>
