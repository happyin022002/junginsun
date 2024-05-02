<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0145.jsp
*@FileTitle  : Lane History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.EsmCoa0145Event"%>
<%
    Exception serverException = null;	//Error from server
    String strErrMsg = "";              //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0145");
    EsmCoa0145Event event = null;
    try {
        event = (EsmCoa0145Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error(e.toString());
    }
%>


<script>
var saveStatus = false;
function Exit() {
    if (self.screenTop > 9000) {
        opener.retrieve();
    }
}
</script>
<script type="text/javascript" event="onunload" for="window">
    Exit();
</script>
<script type="text/javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />

<input type="hidden" name="f_h_trd_cd" value="<%=event.getSearchConditionVO().getFTrdCd() %>" id="f_h_trd_cd" />
<input type="hidden" name="f_h_rlane_cd" value="<%=event.getSearchConditionVO().getFRlaneCd() %>" id="f_h_rlane_cd" />
<input type="hidden" name="f_h_dir_cd" value="<%=event.getSearchConditionVO().getFDirCd() %>" id="f_h_dir_cd" />
<input type="hidden" name="f_h_ioc_cd" value="<%=event.getSearchConditionVO().getFIocCd() %>" id="f_h_ioc_cd" />

<input type="hidden" name="f_vsl_cd" id="f_vsl_cd" />
<input type="hidden" name="f_skd_voy_no" id="f_skd_voy_no" />
<input type="hidden" name="f_skd_dir_cd" id="f_skd_dir_cd" />

<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Lane History</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Rowadd" 	id="btn_Rowadd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
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
	<div class="wrap_result" style="overflow:hidden">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>