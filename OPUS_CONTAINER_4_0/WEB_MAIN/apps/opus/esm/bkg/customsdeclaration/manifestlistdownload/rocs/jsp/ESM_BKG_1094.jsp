<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1094.jsp
*@FileTitle  : ESM_BKG_1094
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1094Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EsmBkg1094Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    String pageRows  = "100";
    String strUsr_id = "";
    String strUsr_nm = "";
    String vvdCd = "";
	String crnNo = "";
    Logger log = Logger.getLogger("CustomsDeclaration.ManifestListDownload");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        vvdCd = request.getParameter("vvd_no")==null?"":request.getParameter("vvd_no");
        crnNo = request.getParameter("crn_no")==null?"":request.getParameter("crn_no");
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (EsmBkg1094Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (null != serverException) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        // get data from server when load page ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (1 <= errMessage.length) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>ROCS - CRN Change</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_save" 	id="btn_save">SAVE</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
		                <th title="Vessel Voyage Direction">VVD</th>
		                <td><input name="vvd_cd" style="ime-mode: disabled" maxlength="13" dataformat="engup" type="text" class="input2" value="<%=StringUtil.xssFilter(vvdCd) %>" readonly id="vvd_cd" /> </td>
		             </tr>
		             <tr>
		                <th>Current CRN</th>
		                <td><input name="vsl_call_ref_no_old" style="ime-mode: disabled" maxlength="13" dataformat="engup" type="text" class="input2" value="<%=StringUtil.xssFilter(crnNo) %>" readonly id="vsl_call_ref_no_old" /> </td>
		             </tr>
		             <tr>
		                <th>New CRN</th>
		                <td><input name="vsl_call_ref_no_new" style="ime-mode: disabled" maxlength="13" dataformat="engup" type="text" class="input1" value="" id="vsl_call_ref_no_new" /> </td>
		             </tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" style="display:none">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</form>