<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_1052.jsp
*@FileTitle  : Supporting Upload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf1052Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf1052Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.StevedoreDamageMgt.StevedoreDamageMgt");
	
	String func = "";
	
	String pageId = "";
	String stvDmgProcCd = "";
	String stvDmgAtchFileTpCd = "";
	String vslCd = "";
	String stvDmgNo = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		func = request.getParameter("func");
		
		pageId =  request.getParameter("pageId");
		stvDmgNo = request.getParameter("stvDmgNo");
		stvDmgProcCd = request.getParameter("stvDmgProcCd");
		stvDmgAtchFileTpCd = request.getParameter("stvDmgAtchFileTpCd");
		vslCd = request.getParameter("vslCd");


		event = (VopOpf1052Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=StringUtil.xssFilter(pageId)%>','<%=StringUtil.xssFilter(stvDmgNo)%>','<%=StringUtil.xssFilter(strUsr_id)%>','<%=StringUtil.xssFilter(stvDmgProcCd)%>','<%=StringUtil.xssFilter(stvDmgAtchFileTpCd)%>','<%=StringUtil.xssFilter(vslCd)%>');
	}
	
	/**
     * select file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     **/
	function returnPopupData(sheetObj){
		//opener = window.dialogArguments;
		opener.<%=StringUtil.xssFilter(func)%>(sheetObj, '<%=StringUtil.xssFilter(stvDmgAtchFileTpCd)%>', '<%=StringUtil.xssFilter(stvDmgProcCd)%>');
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="stvDmgAtchFileTpCd" value="<%=StringUtil.xssFilter(stvDmgAtchFileTpCd) %>" id="stvDmgAtchFileTpCd" />
<input type="hidden" name="stvDmgProcCd" value="<%=StringUtil.xssFilter(stvDmgProcCd) %>" id="stvDmgProcCd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Supporting Upload</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	    <button class="btn_accent" type="button" name="btn_Ok" id="btn_Ok">Ok</button><!-- 
	     --><button class="btn_normal" type="button" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->		
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn">
			   <button type="button" class="btn_normal" name="btn_FileAdd" id="btn_FileAdd">File Add</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	

<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
</div>
</form>