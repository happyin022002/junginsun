<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_SCE_0009.jsp
*@FileTitle : COP Main Search
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0009Event"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%
    EsdSce0009Event         event           = null;
    Exception                serverException = null;
    DBRowSet                 rowSet          = null;
    String strErrMsg = "";  //error message
    int rowCount	 = 0;
	try {
		event = (EsdSce0009Event)request.getAttribute("Event");
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
   	    loadPage();
    }

</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="cop_no" value="<%=event.getCOPReplanInfoVO().getCopNo()%>" id="cop_no" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="bkg_no" value="<%=event.getCOPReplanInfoVO().getBkgNo()%>" id="bkg_no" />
<input type="hidden" name="cop_sts_cd" value="<%=event.getCOPReplanInfoVO().getCopStsCd()%>" id="cop_sts_cd" />
<!-- 
<input type="hidden" name="bkg_no_split" id="bkg_no_split" />
-->
<input type="hidden" name="bound_name" value="<%=event.getCOPReplanInfoVO().getBoundName()%>" id="bound_name" />
<input type="hidden" name="iscompled" value="<%=event.getCOPReplanInfoVO().getIscompled()%>" id="iscompled" />
<input type="hidden" name="nodcd" value="<%=event.getCOPReplanInfoVO().getNodcd()%>" id="nodcd" />
<input type="hidden" name="isnodchg" value="<%=event.getCOPReplanInfoVO().getIsnodchg()%>" id="isnodchg" />
<input type="hidden" name="frmcd" value="<%=event.getCOPReplanInfoVO().getFrmcd()%>" id="frmcd" />
<input type="hidden" name="isfrmchg" value="<%=event.getCOPReplanInfoVO().getIsfrmchg()%>" id="isfrmchg" />

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span id="titles">COP Manual Replan</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		     <button type="button" class="btn_accent" name="btn_apply" id="btn_apply">Apply</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
		<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<h3 class="title_design">Target COP Information</h3>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_grid">
		<h3 class="title_design">Possible Route Information</h3>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>

</form>