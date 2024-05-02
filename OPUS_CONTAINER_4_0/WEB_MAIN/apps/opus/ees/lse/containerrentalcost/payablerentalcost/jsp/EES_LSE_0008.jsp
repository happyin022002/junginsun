<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0008.jsp
*@FileTitle : Invoice File Import
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0008Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strCostYrmon	= "";
	String func         = "";
	String strVndrSeq   = "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerRentalCost.PayableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strCostYrmon = JSPUtil.getNull(request.getParameter("chg_cost_yrmon"));
		if ( strCostYrmon.equals("") ) {
			strCostYrmon = DateTime.addMonths(DateTime.getShortDateString(), -1, "yyyyMMdd").substring(0, 6);
		}

		func = JSPUtil.getNull(request.getParameter("func"));
		strVndrSeq   = JSPUtil.getNull(request.getParameter("vndr_seq"));
		
		event = (EesLse0008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="func" value="<%= func %>">
<input type="hidden" name="co_cost_yrmon" value="<%= strCostYrmon %>">
<input type="hidden" name="vndr_seq" value="<%= strVndrSeq %>">
<input type="hidden" name="agmt_cty_cd"   value="">
<input type="hidden" name="agmt_seq"      value="">
<div class="page_title_area clear">
<div class="layer_popup_title">	
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Invoice File Import</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close"	id="btn_Close">Close</button>
			
	    </div>
	</div>
</div>
</div>
<div class="layer_popup_contents">
<div class="wrap_result">	
	<div class="opus_design_grid " >
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_New"	id="btn_New">New</button><!-- 
			--><button type="button" class="btn_normal" name="btn_FileAdd"	id="btn_FileAdd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_FileDel"	id="btn_FileDel">Row Delete</button>
		</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

<div style="display:none">
	<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
</div>
</div>
</form>
