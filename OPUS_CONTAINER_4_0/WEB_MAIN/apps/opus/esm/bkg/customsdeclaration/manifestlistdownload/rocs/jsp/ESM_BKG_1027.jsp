<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1027.jsp
*@FileTitle  : ROCS : Sent/Receive Log
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/24
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
     
    Exception serverException   = null;         //serverException
    String strErrMsg = "";                      //error massage
    int rowCount     = 0;                       //DB ResultSet list count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String rcv_snd_div_cd = "";
    String sheet_msg_snd_dt = "";
    String sheet_bl_no = "";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        
        rcv_snd_div_cd = request.getParameter("rcv_snd_div_cd")==null?"":request.getParameter("rcv_snd_div_cd");
        sheet_msg_snd_dt = request.getParameter("sheet_msg_snd_dt")==null?"":request.getParameter("sheet_msg_snd_dt");
        sheet_bl_no = request.getParameter("sheet_bl_no")==null?"":request.getParameter("sheet_bl_no");
        
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        //when open screen, get data in server..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";

        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if

        loadPage();
    }
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rcv_snd_div_cd" value="<%=StringUtil.xssFilter(rcv_snd_div_cd)%>">
<input type="hidden" name="sheet_msg_snd_dt" value="<%=StringUtil.xssFilter(sheet_msg_snd_dt)%>">
<input type="hidden" name="sheet_bl_no" value="<%=StringUtil.xssFilter(sheet_bl_no)%>"> 

<!-- 팝업제목(S) -->
<div class="layer_popup_title">
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span>View Sent/Received Log</span></h2>
        <!-- page_title(E) -->
  
        <!-- btn_div(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- btn_div(E) -->
  
        <!-- page_location(S) -->
<!--         <div class="location"> -->
<!--             <span id="navigation"></span> -->
<!--         </div> -->
        <!-- page_location(E) -->
    </div>
</div>
<!-- 팝업제목(E) -->

<!-- 팝업영역(S) -->
<div class="layer_popup_contents">
    <div class="opus_design_inquiry">   <!-- no TAB  -->
	</div>
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- 팝업영역(E) -->
</form>
