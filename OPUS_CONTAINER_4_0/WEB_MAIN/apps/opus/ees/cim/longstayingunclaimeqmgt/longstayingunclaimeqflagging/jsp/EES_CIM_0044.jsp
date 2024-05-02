<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0044.js
*@FileTitle  : Container Staying Days (Detail) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
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
<%@ page import="com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0044Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EqavailAbilityFinder.EqavailAbilityFinder");
	String titleFlag = JSPUtil.getParameter(request, "titleFlag".trim(), "");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesCim0044Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
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

<form name="form"> 
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="loc_type_code" name="loc_type_code" value="<%=event.getFlaggingSDaysOptionVO().getLocTypeCode() %>" type="hidden" />
<input id="loc_cd" name="loc_cd" value="<%=event.getFlaggingSDaysOptionVO().getLocCd() %>" type="hidden" />
<input id="loc_cd" name="loc_cd" value="<%=event.getFlaggingSDaysOptionVO().getCntrTpszCd() %>" type="hidden" />
<input id="dmg_flg" name="dmg_flg" value="<%=event.getFlaggingSDaysOptionVO().getDmgFlg() %>" type="hidden" />
<input id="over_stay_days" name="over_stay_days" value="<%=event.getFlaggingSDaysOptionVO().getOverStayDays() %>" type="hidden" />
<input id="cnmv_sts_cd" name="cnmv_sts_cd" value="<%=event.getFlaggingSDaysOptionVO().getCnmvStsCd() %>" type="hidden" />
<input id="uclm_ls_div_cd" name="uclm_ls_div_cd" value="<%=event.getFlaggingSDaysOptionVO().getUclmLsDivCd() %>" type="hidden" />
<input id="full_flg" name="full_flg" value="<%=event.getFlaggingSDaysOptionVO().getFullFlg() %>" type="hidden" />
<input id="lstm_cd" name="lstm_cd" value="<%=event.getFlaggingSDaysOptionVO().getLstmCd() %>" type="hidden" />
<input id="soc_cd" name="soc_cd" value="<%=event.getFlaggingSDaysOptionVO().getSocCd() %>" type="hidden" />
<input id="sub_cntr_tpsz_cd" name="sub_cntr_tpsz_cd" value="<%=event.getFlaggingSDaysOptionVO().getSubCntrTpszCd() %>" type="hidden" />
<input id="sub_loc_cd" name="sub_loc_cd" value="<%=event.getFlaggingSDaysOptionVO().getSubLocCd() %>" type="hidden" />
<input id="sub_cnmv_sts_cd" name="sub_cnmv_sts_cd" value="<%=event.getFlaggingSDaysOptionVO().getSubCnmvStsCd() %>" type="hidden" />
<input id="start_stay_days" name="start_stay_days" value="<%=event.getFlaggingSDaysOptionVO().getStartStayDays() %>" type="hidden" />
<input id="end_stay_days" name="end_stay_days" value="<%=event.getFlaggingSDaysOptionVO().getEndStayDays() %>" type="hidden" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Container Staying Days <%= titleFlag %>(Detail)</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_downexcel" name="btn_downexcel" class="btn_accent">Down Excel</button><!--
		--><button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_result">
	<div class="opus_design_grid">
	
			<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_more" id="btn_more">More</button><!--
			--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>