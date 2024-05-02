<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0923.jsp
*@FileTitle  : Inbound Cargo Release for POD Office_Popup History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
%>  
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0923Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    EsmBkg0923Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //error from server
    String strErrMsg = "";                        //error message
    int rowCount     = 0;                        //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");
    
    /* user define value */
    String blNo = "";
    String cntCd = "";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsmBkg0923Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        if (strErrMsg.equals("")) {
            
            // getting data from server when load the initial screen
            GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
            blNo       = JSPUtil.getParameter(request, "bl_no");
            cntCd	   = JSPUtil.getParameter(request, "cnt_cd");
        }
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script language="javascript">
  var parBlNo = "<%=StringUtil.xssFilter(blNo) %>";
    function setupPage(){
        var errMessage = "<%=StringUtil.xssFilter(strErrMsg)%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows %>">
<input type="hidden" name="cnt_cd" value="<%= cntCd == null ? "" : StringUtil.xssFilter(cntCd)%>">
<input type="hidden" name="bl_no" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Inbound Cargo Release Order for POD Office Pop-up History</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>