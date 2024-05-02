<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_167.jsp
*@FileTitle  : TC/O Hire Table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.coa.lanesimulation.event.EsmCoa0167Event"%>

<%
    EsmCoa0167Event  event = null;     //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null; //서버에서 발생한 에러
    String strErrMsg    = "";           //에러메세지
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.lanesimulation.EsmCoa0167Event");

    try {

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsmCoa0167Event)request.getAttribute("Event");
        } // end else

    }catch(Exception e) {
        log.error("EsmCoa0167Event Exception : "+e.toString());
        out.println(e.toString());
    }
%>


<script type="text/javascript">
<!--

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }

-->
</script>


<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span> TC/O Hire</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_rowadd" 	id="btn_rowadd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--></div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>