<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EES_LSE_0021_01.jsp
 *@FileTitle : Off-Hire CNTR List - Send to E-mail
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/28
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.clt.framework.component.util.io.FileUtils"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EesLse0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesLse0021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String subject = "";
	String strContent 		= null;
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		String template = request.getParameter("template");
		String argument = request.getParameter("argument");
		
		strContent = EesLse0021Event.getTemplateContent(template, argument);
		subject = StringUtil.xssFilter(request.getParameter("subject"));
		//if(subject != null) {
		if(!"".equals(subject)) {
			  subject = subject.replace("null",  DateTime.getFormatString("yyyy-MM-dd"));
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript" type="text/javascript" src="/opuscntr/syscommon/common/fckeditor/ckeditor.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="siteConfig" value="<%= SiteConfigFactory.get("COM.MAIL.SAVE.DIRECTORY") %>">
<input type="hidden" name="blindCarbonCopy" value="<%=StringUtil.xssFilter(request.getParameter("blindCarbonCopy"))%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Off-Hire Request</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_send" id="btn_send">Send</button><!--
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_inquiry">
			<table> 
				<tbody>
			      		<tr><td>
		
						<!-- Grid  (S) -->
						<table id="tabLayer" width="100%" class="grid_2">
							<tr>
								<th width="12%" class="align_center">From</th>
								<td colspan="2"><input type="text" name="from" caption="From" style="width: 100%; text-align: left;ime-mode:disabled;" class="noinput"
									value="shipment.info@notifications.nykline.com"></td>
							</tr>
							<tr>
								<th class="align_center">TO</th>
								<td colspan="2"><input type="text" name="recipient" caption="Recipient" style="width: 100%; text-align: left;ime-mode:disabled;" class="noinput"
									value="<%=StringUtil.xssFilter(request.getParameter("recipient"))%>"></td>
							</tr>
							<tr>
								<th class="align_center">CC</th>
								<td colspan="2"><input type="text" name="carbonCopy" caption="Carbon Copy" style="width: 100%; text-align: left;ime-mode:disabled;" class="noinput"
									value="<%=StringUtil.xssFilter(request.getParameter("carbonCopy"))%>"></td>
							</tr>
							<!--2016.03.29 / Ji yeon Jeon
							PDL : #40604 -> Send BCC email to email address 'shipment.info@notifications.nykline.com' 
							2016.04.19 / Ji yeon Jeon -> Change email address to 'shipinfobcc@na.nykline.com'-->
							<tr>
								<th class="align_center">BCC</th>
								<td colspan="2"><input type="text" name="h_blindCarbonCopy" caption="Blind Carbon Copy" style="width: 100%; text-align: left;ime-mode:disabled;" class="noinput"
									value="shipinfobcc@na.nykline.com"></td>
							</tr>
							
							<tr>
								<th class="align_center" width="12%">Subject</th>
								<td colspan="2"><input type="text" name="subject" caption="Subject" style="width: 100%; text-align: left" class="noinput"
									value="<%=subject%>"></td>
							</tr>
							<tr>
								<th class="align_center"  width="12%">Attach</th>
								<td width="4%"><input type="button" value="Attach" id="btn_attach" name="btn_attach"></td>
								<td><input type="text" name="fileKey" caption="Attach" style="width: 100%; text-align: left;" class="noinput" value="<%=StringUtil.xssFilter(request.getParameter("fileKey"))%>" readonly></td>
							</tr>
						</table>
						<textarea class="ckeditor" name="content" id="com_content" caption="Contents"><%=strContent == null ? "" : strContent%></textarea> <!-- Grid  (E) --></td>
					</tr>
				</tbody>
			</table>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->
</form>
<%@include file="/bizcommon/include/common_opus.jsp" %>