<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName :  ESM_PRI_0111.jsp
*@FileTitle  : S/C Performance Summary - View B/L 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
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
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0111Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0111Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String pScNo = "";
    String pSvcScpCd = "";
    String blObrdDtFrom = "";
    String blObrdDtTo = "";
    
    Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri0111Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
         
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        pScNo = request.getParameter("sc_no");
        pSvcScpCd = request.getParameter("svc_scp_cd");
        blObrdDtFrom = request.getParameter("bl_obrd_dt_from");
        blObrdDtTo= request.getParameter("bl_obrd_dt_to");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form"> 
<!--  Define for Office Code Validation check -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<input type="hidden" name="backendjob_key">
<!-- Form Hidden -->
<input type="hidden" name="sc_no" value="<%=StringUtil.xssFilter(pScNo)%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(pSvcScpCd)%>">
<input type="hidden" name="bl_obrd_dt_from" value="<%=StringUtil.xssFilter(blObrdDtFrom)%>">
<input type="hidden" name="bl_obrd_dt_to" value="<%=StringUtil.xssFilter(blObrdDtTo)%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>S/C Performance Summary View B/L</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry" style="margin-bottom:0;">	
		    <div class="opus_design_grid" >
					<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>	
	</div>

	<div class="opus_design_grid"  style="display: none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>		

</form>