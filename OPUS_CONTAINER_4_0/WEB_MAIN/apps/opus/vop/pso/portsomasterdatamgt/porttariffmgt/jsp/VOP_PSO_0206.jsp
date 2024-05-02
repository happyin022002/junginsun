<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_PSO_0206.jsp
*@FileTitle  : Service Provider Help
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/31
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0206Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0206Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Ofc_cd      = "";

	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortTariffMgt");
	
	String sType 	= StringUtil.xssFilter(request.getParameter("type")) == null 			? "B" : StringUtil.xssFilter(request.getParameter("type"));
	String sXml  	= StringUtil.xssFilter(request.getParameter("sXml")) == null 			? ""  : StringUtil.xssFilter(request.getParameter("sXml"));
	String sCondNo 	= StringUtil.xssFilter(request.getParameter("cond_no")) == null 		? ""  : StringUtil.xssFilter(request.getParameter("cond_no"));
	String popTitle = StringUtil.xssFilter(request.getParameter("pop_title_0206")) == null 	? ""  : StringUtil.xssFilter(request.getParameter("pop_title_0206"));
	String seq 		= StringUtil.xssFilter(request.getParameter("seq")) == null 			? "10": StringUtil.xssFilter(request.getParameter("seq"));
	String sheetIndex = StringUtil.xssFilter(request.getParameter("sheetIndex")) == null 	? "5" : StringUtil.xssFilter(request.getParameter("sheetIndex"));

	String title = "";
	
	if( sType.equals("B"))
		title = "Base Condition"; 
	else if(sType.equals("S"))
		title = "Surcharge Condition"; 	
	else if(sType.equals("D"))
		title = "Discount Condition"; 	
	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();
	   
		event = (VopPso0206Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>" ;
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" onKeyDown="ComKeyEnter()">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="type" value="<%=sType %>" >
<input type="hidden" name="seq" value="<%=seq %>" >
<input type="hidden" name="sheetIndex" value="<%=sheetIndex %>" >
<input type="hidden" name="sXml" value="<%=sXml %>" >
<input type="hidden" name="cond_no" value="<%=sCondNo %>" >

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span><%= popTitle%></span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn1_OK" id="btn1_OK">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn1_Close" id="btn1_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>
