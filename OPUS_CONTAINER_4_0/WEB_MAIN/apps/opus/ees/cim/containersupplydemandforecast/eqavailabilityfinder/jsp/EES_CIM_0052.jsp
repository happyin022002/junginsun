<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CIM_0052.jsp
*@FileTitle  : Past BR
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.event.EesCim0052Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0052Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EqavailAbilityFinder.EqavailAbilityFinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCim0052Event)request.getAttribute("Event");
		
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="loc_cd" id="loc_cd" value="<%=event.getAvailOptionVO().getLocCd() %>">
<input type="hidden" name="cntr_tpsz_cd_val1" id="cntr_tpsz_cd_val1" value="<%=event.getAvailOptionVO().getCntrTpszCdVal1() %>">
<input type="hidden" name="cntr_tpsz_cd_val2" id="cntr_tpsz_cd_val2" value="<%=event.getAvailOptionVO().getCntrTpszCdVal2() %>">
<input type="hidden" name="cntr_tpsz_cd_val3" id="cntr_tpsz_cd_val3" value="<%=event.getAvailOptionVO().getCntrTpszCdVal3() %>">
<input type="hidden" name="cntr_tpsz_cd_val4" id="cntr_tpsz_cd_val4" value="<%=event.getAvailOptionVO().getCntrTpszCdVal4() %>">

	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Past BR Information</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Downexcel" 	id="btn_Downexcel">Down Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
			</div>
			
		</div>
		<!-- page_title_area(E) -->
	</div>
<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
