<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BSA_0121.js
*@FileTitle  : Company Slot Swap Information By VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event.EsmBsa0104Event"%>
<%@ page import="com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String header = "";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BSAManage.SPCManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		CommonBsaRsVO retVo = (CommonBsaRsVO)eventResponse.getCustomData("retVo");
		header = retVo.getStrTemp();
			
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script>
	var saveStatus = false;
	function Exit() {
		//(saveStatus + " : " + self.screenTop);
	    if (self.screenTop > 9000) {
	    	if(saveStatus){
	    		opener.parentExecute();
	    	}
	    	//self.close();
	    	//opener.location.href=opener.document.location;
	    }
	}
</script>
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=header%>");
	}
</script>
<!-- <form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();"> -->
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="flag" id="flag" />
<input type="hidden" name="chgValueRowNo" id="chgValueRowNo" />
<input type="hidden" name="pPort_etd_dt" id="pPort_etd_dt"   value="<%= JSPUtil.getNull(request.getParameter("pPort_etd_dt")) %>">
<input type="hidden" name="pTrd_cd" id="pTrd_cd"     value="<%= JSPUtil.getNull(request.getParameter("pTrd_cd")) %>">
<input type="hidden" name="pRlane_cd"  id="pRlane_cd"   value="<%= JSPUtil.getNull(request.getParameter("pRlane_cd")) %>">
<input type="hidden" name="pVsl_cd" id="pVsl_cd"     value="<%= JSPUtil.getNull(request.getParameter("pVsl_cd")) %>">
<input type="hidden" name="pSkd_voy_no" id="pSkd_voy_no" value="<%= JSPUtil.getNull(request.getParameter("pSkd_voy_no")) %>">
<input type="hidden" name="pDir_cd" id="pDir_cd"     value="<%= JSPUtil.getNull(request.getParameter("pDir_cd")) %>">
<input type="hidden" name="sRow"  id="sRow"        value="<%= JSPUtil.getNull(request.getParameter("sRow")) %>">
<input type="hidden" name="pBsa_op_jb_cd" id="pBsa_op_jb_cd"        value="<%= JSPUtil.getNull(request.getParameter("pBsa_op_jb_cd")) %>">
<div class="layer_popup_contents">
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Company Slot Swap Information By VVD</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_save" 	id="btn_save">Save</button><!--
				--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
			<!-- page_location(S) -->
<!-- 			<div class="location">
				<span id="navigation"></span>
			</div> -->
			<!-- page_location(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>