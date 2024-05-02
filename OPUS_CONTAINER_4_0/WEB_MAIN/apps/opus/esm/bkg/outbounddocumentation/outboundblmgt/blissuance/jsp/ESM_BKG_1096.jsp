<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1096.jsp
*@FileTitle  : Email(Edit)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1096Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EsmBkg1096Event event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         // error from server
    String strErrMsg = "";                      // error message
    int rowCount = 0;                       // count of DB resultSET list
    String successFlag = "";
    String codeList = "";
    String pageRows = "100";
    String ntcKndCd = null;
    String bkgNoList = null;
    String edtToEml = null;
    String comRecipient = null;
    String comSubject = null;
    String comContent = null;
    String codStsCd = null;
    String codRqstSeq = null;
    String oldPol = null;
    String oldPod = null;
    String newPod = null;
    String uiId = null;
    Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        event = (EsmBkg1096Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        ntcKndCd = JSPUtil.getParameter(request, "ntc_knd_cd");
        bkgNoList = JSPUtil.getParameter(request, "bkg_no_list");
        edtToEml = JSPUtil.getParameter(request, "edt_to_eml", "");
        comRecipient = JSPUtil.getParameter(request, "com_recipient");
        comSubject = JSPUtil.getParameter(request, "com_subject");
        comContent = JSPUtil.getParameter(request, "com_content");
        codStsCd = JSPUtil.getParameter(request, "cod_sts_cd");
        codRqstSeq = JSPUtil.getParameter(request, "cod_rqst_seq");
        oldPol = JSPUtil.getParameter(request, "oldPol");
        oldPod = JSPUtil.getParameter(request, "oldPod");
        newPod = JSPUtil.getParameter(request, "newPod"); 
        uiId = JSPUtil.getParameter(request, "ui_id");
    } catch(Exception e) {
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
</head>

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="ui_id" value="<%=uiId%>">
<input type="hidden" name="edt_ntc_knd_cd" value="<%=ntcKndCd%>">
<input type="hidden" name="edt_bkg_no_list" value="<%=bkgNoList%>">
<input type="hidden" name="com_recipient" value="<%=comRecipient%>">
<input type="hidden" name="com_subject" value="<%=comSubject%>">
<input type="hidden" name="com_content" value="<%=comContent%>">
<input type="hidden" name="cod_sts_cd" value="<%=codStsCd%>">
<input type="hidden" name="cod_rqst_seq" value="<%=codRqstSeq%>">
<input type="hidden" name="old_pol" value="<%=oldPol%>">
<input type="hidden" name="old_pod" value="<%=oldPod%>">
<input type="hidden" name="new_pod" value="<%=newPod%>">
<input type="hidden" name="edt_contents">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Email (Edit)</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Send" id="btn_Send">Send Email</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
	<div class="opus_design_inquiry">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="60px" />
				<col width="100%" />
			</colgroup>
			<tbody>
				<tr>
					<th>To</th>
					<td><input type="text" name="edt_to_eml" style="width:99%;text-align:left;" class="input" value="<%=edtToEml %>"></td>
				</tr>  
				<tr>
					<th>CC</th>
					<td><input type="text" name="edt_cc_eml" style="width:99%;text-align:left;" class="input" value=""></td>
				</tr> 
				<tr>
					<th>From</th>
					<td><input type="text" name="edt_from_eml" style="width:99%;text-align:left;" class="input2" value=""></td>
				</tr>  
				<tr>
					<th>Subject</th>
					<td><input type="text" name="edt_subject" style="width:99%;text-align:left;" class="input" value=""></td>
				</tr> 
				<tr>
					<th>Contents</th>
					<td><textarea class="ckeditor" name="edt_contents" id="edt_contents" style="width:99%;height:200;"></textarea></td>
				</tr>    

			</tbody>
		</table>
	</div>
	<!-- inquiry_area(E) -->
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<script language="javascript">ComSheetObject('sheet1');</script>

	<!-- opus_design_grid(E) -->
</div>
	</div>
<!-- popup_contens_area(E) -->
</form>
