<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_4007.jsp
*@FileTitle  : RMK POPUP
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException = null;
    String strErrMsg = "";
    
    String f_pctl_no = "";
    String f_eq_tp_cd = "";
    String f_p_pgm_no = "";
    
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.jsp.ESM_COA_4007");
    try {
        f_pctl_no = JSPUtil.getNull(request.getParameter("f_pctl_no"));
        f_eq_tp_cd = JSPUtil.getNull(request.getParameter("f_eq_tp_cd"));
        f_p_pgm_no = JSPUtil.getNull(request.getParameter("f_pgm_no"));
        
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } //end of if
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>

<!-- <iframe height="0" width="0" name="frmHidden"></iframe> -->
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
        setRetrieveAction();
    }
</script>

<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param1">
<!--  Form value from the parent window -->
<input type="hidden" name="f_pctl_no" value="<%=f_pctl_no%>">
<input type="hidden" name="f_eq_tp_cd" value="<%=f_eq_tp_cd%>">
<input type="hidden" name="f_p_pgm_no" value="<%=f_p_pgm_no%>">

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">	
        <!-- opus_design_btn(S) -->        
        <table border="1">
            <colgroup>
            	<col width="670" />
                <col width="65" />
                <col width="80" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr >
                    <td><h2 class="page_title"><span>Route Cost Detail</span></h2></td>
                    <%if ("ESM_COA_0141".equals(f_p_pgm_no)) {%>
                    	<th></th>
                    	<td></td>
                    <% } else { %>
                    	<th>EQ SIZE: </th>
                    	<td valign="baseline" align=right><script language="javascript">ComComboObject('f_cntr_tpsz_cd',1, 70 , 0);</script></td>
                    <% } %>
                    <td valign="top" align=left>
				        	   <button type="button" class="btn_normal" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
				            --><button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button><!--
				            --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
                    </td>
                </tr>
            </tbody>
        </table>      
        <!-- opus_design_btn(E) --> 

        <!-- page_location(S) -->
        <div class="location">
            <span id="navigation"></span>
        </div>
        <!-- page_location(E) -->
    </div>
<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">
<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <h3 class="title_design">Cost Remark Inquiry</h3>
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
        <%if (!"ESM_COA_0141".equals(f_p_pgm_no)) {%>
        <div class="grid_option_left mar_btm_4"><table><tr><td align="left" style="color: red;">&nbsp;*Red font indicates cost items for which vendor rates cannot be found (historical average is applied).</td></tr></table></div>
        <% } %>
        <div id="mainTable">
            <script language="javascript">ComSheetObject('sheet1');</script>
        </div>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</div>
<!-- popup_contens_area(E) -->

</form>
