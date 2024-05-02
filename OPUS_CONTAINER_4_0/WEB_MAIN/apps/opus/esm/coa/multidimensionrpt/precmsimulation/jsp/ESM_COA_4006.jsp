<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_4006.jsp
*@FileTitle  : Inquiry By BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
	
    String f_pctl_no  = "";
    String f_eq_tp_cd = "";
    
    String screen_name = "";
    String popup_flag = "N";    
    Logger log = Logger.getLogger("com.clt.apps.MultiDimensionRPT.precmsimulation");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();        
 
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        screen_name = ((Screen)(request.getAttribute("com.clt.framework.core.comm.CURRENT_SCREEN"))).getName();
        
        if( screen_name.indexOf("POP") > 0){
            popup_flag = "Y";   
        }
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
		
        f_pctl_no = request.getParameter("pctl_no");
        f_eq_tp_cd = request.getParameter("eq_tp_cd");

    }catch(NullPointerException ne){
        log.error("not exist");
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
var popup_flag = "<%=popup_flag%>";
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        
        loadPage();
    }
</script>
<!-- Developer DIV  -->

<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="userId" id="userId"  value="<%=strUsr_id %>" />
<%if(popup_flag=="Y"){%>
<div class="layer_popup_title">
     <div class="page_title_area clear">
         <h2 class="page_title"><span>Route Cost Inquiry</span></h2>
         <div class="opus_design_btn">
             <button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
          --><button type="button" class="btn_normal" name="btn_downexcel"  id="btn_downexcel">Down Excel</button><!--
          --><button type="button" class="btn_normal" name="btn_Close" 		id="btn_Close">Close</button>
          </div>
     </div>
</div>
<input type="hidden" name="f_pctl_no" id="f_pctl_no" value="<%=JSPUtil.getNull(f_pctl_no)%>"  >
<input type="hidden" name="f_eq_tp_cd" id="f_eq_tp_cd" value="<%=JSPUtil.getNull(f_eq_tp_cd)%>"  >
<%}else{%>
<div class="page_title_area clear">
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <div class="opus_design_btn">
    	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
    	--><button type="button" class="btn_normal" name="btn_downexcel"    id="btn_downexcel">Down Excel</button>
    </div>
    <div class="location">
        <span id="navigation"></span>
    </div>
</div>

<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="90"  />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Booking</th>
                    <td><input type="text" style="width:130px" class="input1" name="f_pctl_no" id="f_pctl_no"  value="<%=JSPUtil.getNull(f_pctl_no)%>" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('uppernum');" maxlength="13" ></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<%}%>
<%if(popup_flag=="Y"){%><div class="layer_popup_contents"><%}%>

<!-- popup_contens_area(S) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <h3 class="title_design">Performance Inquiry</h3>
       <div class="opus_design_btn" style="margin-bottom:3px">
            <div id="div_zoom_in" style="display:inline">
                <button type="button" class="btn_up" name="bu_zoom_in" id="bu_zoom_in" title ="Zoom in(+)"></button>
                <!--<img class="cursor" src="/opuscntr/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">-->
            </div>
            <div id="div_zoom_out" style="display:none">
                <button type="button" class="btn_down" name="bu_zoom_out" id="bu_zoom_out" title ="Zoom out(-)"></button>
                <!--<img class="cursor" src="/opuscntr/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">-->
            </div>
        </div>
        <div class="grid_option_left mar_btm_4"><table><tr><td align="left" style="color: red;">&nbsp;*Red font indicates cost items for which vendor rates cannot be found (historical average is applied).</td></tr></table></div>
        <div id="mainTable">
            <script language="javascript">ComSheetObject('sheet1');</script>
        </div>
        <div class="grid_option_right mar_top_4">
            <button type="button" class="btn_etc" name="btns_remarks" id="btns_remarks">Remarks</button>
        </div>        
    </div>
    <div id="mainTable" style="Display:none">
        <script language="javascript">ComSheetObject('sheet2');</script>
    </div>    
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->

<!-- popup_contens_area(E) -->
<%if(popup_flag=="Y"){  %></div><%}%>
<!-- Developer DIV  END -->
</form>