<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0031.jsp
*@FileTitle  : Stock Report (Detail)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0031Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%
	EesCim0031Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EesCim0031Event)request.getAttribute("Event");
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="loc_cd" value="<%=event.getInvtOptionVO().getLocCd() %>" id="loc_cd" />
<input type="hidden" name="loc_type_code" value="<%=event.getInvtOptionVO().getLocTypeCode() %>" id="loc_type_code" />
<input type="hidden" name="cntr_tpsz_cd" value="<%=event.getInvtOptionVO().getCntrTpszCd() %>" id="cntr_tpsz_cd" />
<input type="hidden" name="yard_cd" value="<%=event.getInvtOptionVO().getYardCd() %>" id="yard_cd" />
<input type="hidden" name="obj_cntr_tpsz_cd" value="<%=event.getInvtOptionVO().getObjCntrTpszCd() %>" id="obj_cntr_tpsz_cd" />
<input type="hidden" name="fm_stk_jb_dt" value="<%=event.getInvtOptionVO().getFmStkJbDt() %>" id="fm_stk_jb_dt" />
<input type="hidden" name="to_stk_jb_dt" value="<%=event.getInvtOptionVO().getToStkJbDt() %>" id="to_stk_jb_dt" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Stock Report (Detail)</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	       <button class="btn_accent" type="button"  name="btn_save" id="btn_save">Save</button><!--
		--><button class="btn_normal" type="button"  name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button class="btn_normal" type="button"  name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>			