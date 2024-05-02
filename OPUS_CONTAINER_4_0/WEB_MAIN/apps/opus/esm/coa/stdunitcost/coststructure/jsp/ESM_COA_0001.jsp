<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0001.jsp
*@FileTitle  : Setting List Box To Set Key Business Rule 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	Exception serverException	= null;								//Error from server
	String strErrMsg = "";													//Error message
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.stdunitcost.coststructure.CoaSpclRepoCntrRgst");

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end else
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
        setRetrieveAction();
    }
</script>

<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">


	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Set List Box To Set Key Business Rule</span></h2>
			<!-- page_title(E) -->
					
			 <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->				
		       	<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		    </div>
		    <!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- popup_title_area(E) -->	
	
	<div class="layer_popup_contents">
	
		<!-- wrap_result(S) -->
		<div class="wrap_result">			
			
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" id="mainTable">
			<h3 class="title_design">Sp Group</h3>
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btng_RowAdd" id="btng_RowAdd">Row Add</button><!--
					--><button type="button" class="btn_normal" name="btng_Save" id="btng_Save">Save</button>
				</div>
				<script language="javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<!-- wrap_result(S) -->
		
	</div>

</form>
