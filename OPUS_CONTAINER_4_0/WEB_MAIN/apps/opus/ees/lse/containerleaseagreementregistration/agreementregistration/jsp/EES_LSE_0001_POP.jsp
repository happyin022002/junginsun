<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0001_POP.jsp
*@FileTitle  : EQ Component
*@author     : CLT
*@version    : 1.0
*@since      : 2015/03/15
=========================================================*/
%>
	
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%
	EesLse0001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_off_cd    = "";
	String strCntrTpSzCd    = "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");

	//try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id     = account.getUsr_id();
		strUsr_nm     = account.getUsr_nm();
		strUsr_off_cd = account.getOfc_cd();
		
		//기존소스용
	 	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
		String returntitle = ((request.getParameter("returntitle")==null )?"":request.getParameter("returntitle"));
		String presetData = ((request.getParameter("presetData")==null )?"":request.getParameter("presetData"));      
		String sheet_id = ((request.getParameter("sheet_id")==null )?"":request.getParameter("sheet_id"));
		String sheet_row = ((request.getParameter("sheet_row")==null )?"":request.getParameter("sheet_row"));     
		String temp_value1 = ((request.getParameter("temp_value1")==null )?"":request.getParameter("temp_value1"));      
		String checked = ((request.getParameter("checked")==null )?"":request.getParameter("checked"));      
		String prefix = ((request.getParameter("prefix")==null )?"":request.getParameter("prefix"));    
		event = (EesLse0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntrTpSzCd = (String)eventResponse.getCustomData("cntr_tpsz_cd");
	//}catch(Exception e) {
	//	out.println(e.toString());
	//}
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
<input type="hidden" name="f_cmd" id="f_cmd">	
<input type="hidden" name="pagerows" id="pagerows">  	 				  <%-- 
<input type="hidden" name="returnval" id="returnval" value="<%=returnval%>">  
 --%>
 <input type="hidden" name="temp_value1" id="temp_value1" value="<%=temp_value1%>"> 
 <input type="hidden" name="checked" id="checked" value="<%=checked%>">
<input type="hidden" name="org_cntr_tpsz_cd" value="<%= strCntrTpSzCd %>" id="org_cntr_tpsz_cd" />
<input type="hidden" name="prefix" id="prefix" value="<%=prefix%>">
<input type="hidden" name="sheet_id" id="sheet_id" value="<%=sheet_id%>">
<input type="hidden" name="sheet_row" id="sheet_row" value="<%=sheet_row%>">            
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	 <h2 class="page_title"><%=returntitle%></h2> 
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Apply" id="btn_Apply" type="button">Apply</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->	

<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
</div>
</form>
