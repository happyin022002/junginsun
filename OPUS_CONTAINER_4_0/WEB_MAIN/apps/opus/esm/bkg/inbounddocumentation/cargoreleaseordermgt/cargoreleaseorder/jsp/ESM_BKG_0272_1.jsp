<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0272.jsp
*@FileTitle  : E-mail / Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0272Event"%>
<%@ page import="org.apache.log4j.Logger" %>



<%
	EsmBkg0272Event event = null;
	Exception serverException   = null;
	String strErrMsg = "";
	String strUsr_eml = "";
	String subject = "";
	String strUsr_id = "";
	String strUsr_nm = "";
	String fileKey = "";

	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");
	try
	{
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_eml = ConstantMgr.getCompanyName() + " Co., Ltd.,"; 
		event = (EsmBkg0272Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if(serverException != null) 
		{
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}
	catch(Exception e) 
	{
		log.error(e.getMessage(),e);
	}

	fileKey = request.getParameter("fileKey");
%>

<script type="text/javascript">

	function setupPage()
	{
		var errMessage = "<%=strErrMsg%>";
		if(errMessage.length >= 1) 
		{
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
 
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="from" value="<%=strUsr_eml%>" id="from" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
	<h2 class="page_title"><span>E-mail</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Prev" id="btn_Prev" type="button">Prev</button><!--
		--><button class="btn_normal" name="btn_Next" id="btn_Next" type="button">Next</button><!--
		--><button class="btn_normal" name="btn_E-mail" id="btn_E-mail" type="button">E-mail Send</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="*" />				
				<col width="50" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th class="sm">E-mail :</th>
		   			<td class="sm"><input type="text" style="width:50px;text-align:center;"  class="noinput3" name="pageCount" id="pageCount" value=""></td>
		   		</tr>
		   </tbody>
		</table>
		<table  class="grid_2"> 
			<tr>
				<td><strong>E-mail Address</strong></td>
			</tr>
			<tr>
				<td><input type="text" style="width:100%;"  name="recipient"  id="recipient" value=""></td>
			</tr>
		</table>
		<table class="grid_2">
			<tr>
				<td><strong>subject</strong></td>
			</tr> 
			<tr>
				<td><input type="text" style="width:100%;"  name="subject" id="subject" value="Full Container Release Order" readOnly=true></td>
			</tr>
		</table>
		<table  class="grid_2">
			<tr>
				<td><strong>content</strong></td>
			</tr> 
			<tr>
				<td>
					<textarea style="width:100%;text-indent:0px; resize:none;" rows="27" name="content" id="content" readOnly=true></textarea>
				</td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</div>
</form>		
 