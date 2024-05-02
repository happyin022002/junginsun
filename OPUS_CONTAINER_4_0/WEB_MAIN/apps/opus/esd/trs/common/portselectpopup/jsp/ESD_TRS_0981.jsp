<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0981.jsp
*@FileTitle  : Port Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
--%>

<%@page import="com.clt.framework.component.util.StringUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.common.portselectpopup.event.EsdTrs0981Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsdTrs0981Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.vskcommon.vskcodefinder");
    
    String cntCd = null;
    String portCd = null;
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsdTrs0981Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
    strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        portCd = request.getParameter("port_cd");
        portCd = portCd==null?"":portCd;
        
        if(portCd.length()==5){
            cntCd = portCd.substring(0, 2);
            portCd = portCd.substring(2);
        }else{
            cntCd = "";
            portCd = "";
        }
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">

    function setupPage(){  
        loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="loc_cd">
<input type="hidden" name="tmp_cnt_cd">

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span>Port Code Inquiry</span>
        </h2>
        <!-- page_title(E) -->
    
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button><!-- 
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) -->
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
	    <!-- opus_design_inquiry(S) -->
	    <div class="opus_design_inquiry">
	        <table> 
	            <colgroup>
	                <col width="70"  />
	                <col width="*" />
	            </colgroup>
	            <tbody>
	                <tr>
	                    <th>Port Code</th>
	                    <td>
	                        <input type="text" name="cnt_cd" maxlength=2 style="width:40px;text-align:center;ime-mode:disabled;" dataformat="enguponly" class="input" value="<%=cntCd%>" tabindex="1"><!--
	                        --><button type="button" class="input_seach_btn" name="btn_popup" id="btn_popup"></button><!--
	                        --><input type="text" name="port_cd" maxlength=3 style="width:50px;text-align:center;ime-mode:disabled;" dataformat="enguponly" class="input" value="<%= StringUtil.xssFilter(portCd) %>"tabindex="2">
	                    </td>
	                </tr>
	                <tr>
	                    <th>Port Name</th>
	                    <td><input type="text" name="loc_nm" style="width:300px;ime-mode:disabled;" dataformat="engup" otherchar=" " class="input" tabindex="3"></td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
	    <!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
	    <!-- opus_design_grid(S) -->
	    <div class="opus_design_grid" >
	        <script type="text/javascript">ComSheetObject('sheet1');</script>
	    </div>
	    <!-- opus_design_grid(E) -->
	</div>
</div>
<!-- popup_contens_area(E) -->
</form>
