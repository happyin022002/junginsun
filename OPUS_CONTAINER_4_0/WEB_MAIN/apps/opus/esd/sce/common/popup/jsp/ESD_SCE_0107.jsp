<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0107.jsp
*@FileTitle  : RailETA - History Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%

	SignOnUserAccount account = null; 						//Session 정보
	Exception serverException = null;					 	//Setting error at server side.
	//DBRowSet rowSet = null;							   		//DB ResultSet
	String strErrMsg = "";									//Error Message
	//int rowCount	 = 0;									  	//DB ResultSet List count
    //String strUsrNm = "";

	String cntr_no = request.getParameter("cntr_no") == null ? "" : request.getParameter("cntr_no");
	String eta_tp = request.getParameter("eta_tp") == null ? "" : request.getParameter("eta_tp");
	String eta_yr = request.getParameter("eta_yr") == null ? "" : request.getParameter("eta_yr");

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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

<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
<input    type="hidden" name="cntr_id">
<input    type="hidden" name="cnmv_yr" value="<%=eta_yr%>">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Rail ETA</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
	
	<!-- wrap_search(S) -->	
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="90" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
		                <th>Container No.</th>
		                <td><input name="cntr_no" id="cntr_no" value="<%=cntr_no%>" readonly border="0">
					</tr>
		            <tr>
		                <th>ETA Type.</th>
		                <td><input name="eta_tp" id="eta_tp" value="<%=eta_tp%>" readonly border="0"></td>
				    </tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->	
	
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid (S) -->
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid (E) -->
	</div>
	<!-- wrap_result(E) -->
</form>
<%@include file="../../../common/commonpopup/include/common.jsp"%>