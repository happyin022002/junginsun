<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0075.jsp
*@FileTitle : E-mail / Print - window
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
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
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0075Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo"%>
<%
	EsmFms0075Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	//int rowCount	 = 0;						//Number of DB ResultSet List
	
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";
	
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strUsr_email = "";
	
	String pgm_id		= StringUtil.xssFilter(request.getParameter("pgm_id"))		==null		?"":StringUtil.xssFilter(request.getParameter("pgm_id"));
	String vsl_nm		= StringUtil.xssFilter(request.getParameter("vsl_eng_nm"))	==null		?"":StringUtil.xssFilter(request.getParameter("vsl_eng_nm"));
	String csr_no		= StringUtil.xssFilter(request.getParameter("csr_no"))		==null		?"":StringUtil.xssFilter(request.getParameter("csr_no"));
	String subject		= "Hire Statement";
	
	if(pgm_id.equalsIgnoreCase("esm_fms_0012") || !"".equals(vsl_nm)) {
		subject = subject + "(" + vsl_nm + ")";
		//subject = "Hire invoice";
	}

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_email = account.getUsr_eml();
	
		event = (EsmFms0075Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Adding Logic extracting data from server when loading initial window ..
	//	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="pgm_id" value="<%=pgm_id%>" id="pgm_id" />
<input type="hidden" name="subject" value="<%=subject%>" id="subject" />
<input type="hidden" name="file_path" value="" id="file_path" />
<input type="hidden" name="csr_no" value="<%=csr_no%>" id="csr_no" />
<input type="hidden" name="vsl_nm" value="<%=vsl_nm%>" id="vsl_nm" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Hire Statement" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Hire Statement" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Hire Statement" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />

<!-- Mail Send -->
<input type="hidden" name="com_rdSubSysCd" value="FMS" id="com_rdSubSysCd" />
<input type="hidden" name="com_from" id="com_from" value="<%=strUsr_email%>"/>
<input type="hidden" name="com_recipient" value="" id="com_recipient" />
<input type="hidden" name="com_carbonCopy" value="" id="com_carbonCopy" />
<input type="hidden" name="com_blindCarbonCopy" id="com_blindCarbonCopy" />
<input type="hidden" name="com_subject" value="" id="com_subject" />
<input type="hidden" name="com_fileKey" id="com_fileKey" />
<input type="hidden" name="com_content" id="com_content" />
<input type="hidden" name="com_templateMrd" value="" id="com_templateMrd" />
<input type="hidden" name="com_templateMrdArguments" id="com_templateMrdArguments" />
<input type="hidden" name="com_templateMrdDescription" value="ESM_FMS_030.mrd File Attach." id="com_templateMrdDescription" />

<input type="hidden" name="com_rdExportFileName" value="Hire_Statement.pdf" id="com_rdExportFileName" />
<input type="hidden" name="com_rdExportFileType" value="<%=ExportInfo.FTYPE_PDF%>" id="com_rdExportFileType" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>E-Mail / Print Selection </span></h2>
		
		<div class="opus_design_btn">
		    <button type="button" class="btn_normal" name="btn_email" 	id="btn_email">E-mail Type</button><!--
		 --><button type="button" class="btn_normal" name="btn_print" 	id="btn_print">Print</button><!--
		 --><button type="button" class="btn_normal" name="btn_tofile"  id="btn_tofile">Print to File</button><!--
		 --><button type="button" class="btn_normal" name="btn_close"  	id="btn_close">Close</button>	
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<table class="grid2">
			<tbody>
				<tr>
					<th>Select Your Format Type to retrieve the Hire Invoice / Statement</th>
				</tr>
			</tbody>
		</table>
		
		<div style="display:none">
			<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->

</div>
</form>
