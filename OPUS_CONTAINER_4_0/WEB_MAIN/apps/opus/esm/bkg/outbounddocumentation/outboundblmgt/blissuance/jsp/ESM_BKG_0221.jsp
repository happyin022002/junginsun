<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0221.jsp
*@FileTitle  : Edit Send Email/Fax
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.core.config.SubSystemConfigFactory" %>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0221Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0221Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.Outboundblmgt.Blissuance");
	
    String bkg_no         = "";
    String bl_no          = "";
    String ok_hidden      = "";
    String send_hidden    = "";
    String form_type      = "";
    String form_dataOnly  = "";
    String form_manifest  = "";
    String form_hiddeData = "";
    String form_mainOnly  = "";
    String form_level     = "";
    String form_remark    = "";
    String form_Cntr      = "";
    String form_CorrNo    = "";
    String form_his_cntr  = "";
    String form_his_bkg   = "";
    String form_his_mkd   = "";
    String form_his_xpt   = "";
    String form_his_bl    = "";
    String form_his_bl_mkd= "";
    String rp             = "";
    String ui_id          = "";
    String ntc_knd_cd     = "";
    String func           = "";  // pop_mode is '1'
    String pop_mode       = "";  // Popup mode
    String sheetIdx       = "";  // if Multi Sheet, Sheet Index Info
    String row            = "";  // Targeted Cell row
    String col            = "";  // Targeted Cell col
    String fax_no         = "";  
    String email          = "";  
    String fax_email      = "";  // fax or email delimiter
    String calllFunc 		= "";
    String CFG_FILEOPEN_LOGURL_BASE = SubSystemConfigFactory.get("COM.CLT.FILEOPEN.DOMAIN") + "/"; 
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0221Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//bkg_no = "KORZ1025122|KORY6085393|HKGZ1020073";
        bkg_no         = JSPUtil.getParameter(request, "bkg_no"                             );
        bl_no          = JSPUtil.getParameter(request, "bl_no"                              );
        ok_hidden      = JSPUtil.getParameter(request, "ok_hidden"       , "N"              );
        send_hidden    = JSPUtil.getParameter(request, "send_hidden"     , "N"              );
        form_type      = JSPUtil.getParameter(request, "form_type"       , "2"              );
        form_dataOnly  = JSPUtil.getParameter(request, "form_dataOnly"   , "N"              );
        form_manifest  = JSPUtil.getParameter(request, "form_manifest"   , "N"              );
        form_hiddeData = JSPUtil.getParameter(request, "form_hiddeData"  , "N"              );
        form_mainOnly  = JSPUtil.getParameter(request, "form_mainOnly"   , "N"              );
        form_level     = JSPUtil.getParameter(request, "form_level"      , "1"              );
        form_remark    = JSPUtil.getParameter(request, "form_remark"     , ""               );
        form_Cntr      = JSPUtil.getParameter(request, "form_Cntr"       , "1"              );
        form_CorrNo    = JSPUtil.getParameter(request, "form_CorrNo"     , ""               );
        form_his_cntr  = JSPUtil.getParameter(request, "form_his_cntr"   , "BKG_CONTAINER"  );
        form_his_bkg   = JSPUtil.getParameter(request, "form_his_bkg"    , "BKG_BOOKING"    );
        form_his_mkd   = JSPUtil.getParameter(request, "form_his_mkd"    , "BKG_BL_MK_DESC" );
        form_his_xpt   = JSPUtil.getParameter(request, "form_his_xpt"    , "BKG_XPT_IMP_LIC");
        form_his_bl    = JSPUtil.getParameter(request, "form_his_bl"     , "BKG_BL_DOC"     );
        form_his_bl_mkd= JSPUtil.getParameter(request, "form_his_bl_mkd" , "BKG_BL_ISS"     );
        rp             = JSPUtil.getParameter(request, "rp"              , ""               );
        ui_id          = JSPUtil.getParameter(request, "ui_id"                              );
        ntc_knd_cd     = JSPUtil.getParameter(request, "ntc_knd_cd"                         );
        func           = JSPUtil.getParameter(request, "func"                               );
        pop_mode       = JSPUtil.getParameter(request, "pop_mode"        , "1"              );
        sheetIdx       = JSPUtil.getParameter(request, "sheetIdx"                           );
        row            = JSPUtil.getParameter(request, "row"                                );
        col            = JSPUtil.getParameter(request, "col"                                );
        fax_no         = JSPUtil.getParameter(request, "fax_no"          , ""               );
        email          = JSPUtil.getParameter(request, "email"           , ""               );
        fax_email      = JSPUtil.getParameter(request, "fax_email"                          );
        calllFunc      = JSPUtil.getParameter(request, "func");
	} catch(Exception e) {
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" id="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="bl_no" id="bl_no" value="<%=bl_no%>">
<input type="hidden" name="form_type" id="form_type" value="<%=form_type%>">
<input type="hidden" name="form_dataOnly" id="form_dataOnly" value="<%=form_dataOnly %>">
<input type="hidden" name="form_manifest" id="form_manifest" value="<%=form_manifest %>">
<input type="hidden" name="form_hiddeData" id="form_hiddeData" value="<%=form_hiddeData%>">
<input type="hidden" name="form_mainOnly" id="form_mainOnly" value="<%=form_mainOnly %>">
<input type="hidden" name="form_level" id="form_level" value="<%=form_level%>">
<input type="hidden" name="form_remark" id="form_remark" value="<%=form_remark%>">
<input type="hidden" name="form_Cntr" id="form_Cntr" value="<%=form_Cntr%>">
<input type="hidden" name="form_CorrNo" id="form_CorrNo" value="<%=form_CorrNo%>">
<input type="hidden" name="form_his_cntr" id="form_his_cntr" value="<%=form_his_cntr%>">
<input type="hidden" name="form_his_bkg" id="form_his_bkg" value="<%=form_his_bkg%>">
<input type="hidden" name="form_his_mkd" id="form_his_mkd" value="<%=form_his_mkd%>">
<input type="hidden" name="form_his_xpt" id="form_his_xpt" value="<%=form_his_xpt%>">
<input type="hidden" name="form_his_bl" id="form_his_bl" value="<%=form_his_bl%>">
<input type="hidden" name="form_his_bl_mkd" id="form_his_bl_mkd" value="<%=form_his_bl_mkd%>">
<input type="hidden" name="rp" id="rp" value="<%=rp%>">
<input type="hidden" name="ui_id" id="ui_id" value="<%=ui_id%>">
<input type="hidden" name="ntc_knd_cd" id="ntc_knd_cd" value="<%=ntc_knd_cd%>">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>" id="calllFunc" />
<input type="hidden" name="rd_domain" id="rd_domain" value="<%=CFG_FILEOPEN_LOGURL_BASE%>"/>
<%-- DO NOT add the 'input box' before fax,email element : because of the return function  --%>

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Edit Fax E-mail</span></h2>
		
		<div class="opus_design_btn">
			<% if (!"Y".equalsIgnoreCase(ok_hidden)) { %>
				<button type="button" class="btn_accent" name="btn_ok" id="btn_ok">OK</button>
			<%}%>
			<% if (!"Y".equalsIgnoreCase(send_hidden)) { %>
				<button type="button" class="btn_accent" name="btn_send" id="btn_send">Send</button>
			<%}%>
				<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<th width="70">Fax</th>
						<td><input id="fax" name="fax" type="text" style="width:270px;" class="input" value="<%=fax_no%>" maxlength="50"></td>
					</tr>
					<tr>
						<th>E-mail</th>
						<td><input id="email" name="email" type="text" style="width:270px;" class="input" value="<%=email%>" maxlength="200"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->

<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>"> 
</form>

<form name="form2">
    <input type="hidden" id="func" name="func" value="<%=func%>">
    <input type="hidden" id="pop_mode]" name="pop_mode" value="<%=pop_mode%>">
    <input type="hidden" id="sheetIdx" name="sheetIdx" value="<%=sheetIdx%>">
    <input type="hidden" id="row" name="row" value="<%=row%>">
    <input type="hidden" id="col" name="col" value="<%=col%>">
    <input type="hidden" id="fax_email" name="fax_email" value="<%=fax_email%>">
</form>