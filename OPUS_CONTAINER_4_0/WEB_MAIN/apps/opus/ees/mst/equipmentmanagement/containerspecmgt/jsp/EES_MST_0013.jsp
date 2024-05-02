<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0013.jsp
*@FileTitle  : Equipment Organization Chart
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	String strUsr_id		= "";
	String strUsr_nm		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesMst0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
<!-- layout_wrap (S) -->
	<div class="layout_wrap">
	    <div class="layout_flex_flex" style="padding-right:508px;padding-top:26px">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid mar_top_8">
	            <script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    
	   <div class="layout_flex_fixed" style="width:500px;float:right!important">
	        <div class="opus_design_grid">
	        	<div class="grid_option_right mar_btm_8">
					<table>
						<tbody>
							<tr>
								<th width="40"><b>SCC</b></th>
								<td>
									<input type="text" style="width:90px;text-align:center;" class="input" name="scc_cd" id="scc_cd"  readonly>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<script type="text/javascript" >ComSheetObject('sheet2');</script>

	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
<!-- layout_wrap (E) -->
</div>
</form>