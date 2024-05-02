<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0024_POP.jsp
*@FileTitle  : W/O Issue Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
--%>

<%@page import="com.clt.framework.component.util.StringUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event"%>
<%@ page import="java.util.StringTokenizer"%>
<%!
    private ArrayList splitStr(String src, String delim)
    {
        if(src == null || src.equals("")) return null;
        ArrayList returnV = new ArrayList();
        StringTokenizer st = new StringTokenizer(src, delim);
        String tempNo = null;
        while (st.hasMoreTokens()) {
            tempNo = st.nextToken();
            returnV.add(tempNo);
        }
        if (returnV.size() == 0) returnV.add(src);
        return returnV;
    }
%>

<%
    EsdTrs0024Event  event = null;  
    Exception serverException   = null;
    String strErrMsg = "";
    int rowCount     = 0; 
    SignOnUserAccount account = null;
    String wo_no_a= "";
    try {
        account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        event = (EsdTrs0024Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        wo_no_a =  StringUtil.xssFilter(request.getParameter("wo_no_a"));
    }catch(Exception e) {
        out.println(e.toString());
    }
  
%>

<script  type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="p_wo_no" id="p_wo_no" value="<%= wo_no_a %>"/>
<input type="hidden" name="p_wo_prv_grp_seq" id="p_wo_prv_grp_seq" value=""/>
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />
<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
    <div class="page_title_area clear">
        <h2 class="page_title">
            <span>W/O Preview</span>
        </h2>
		<div class="opus_design_btn">
			<button type="button" id="btn_close" name="btn_close" class="btn_accent">Close</button>
		</div>        
    </div>
<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="150"  />
                <col width=""/>
            </colgroup>
            <tbody>
                <tr>
                    <th>Number Of W/O To Issue</th>
                    <td><script language="javascript">ComComboObject('wo_group_no', 1, 150, 1);</script></td>
                </tr>
            </tbody>
        </table>
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
        <!--  biz_1 (S) -->
        <table>
            <colgroup>
                <col width="100" />
                <col width="200" />
                <col width="60"  />
                <col width="" />
                <col width=""/>
            </colgroup>
            <tbody>
                <tr>
                    <th>Issue Type</th>
                    <td>
                       <input type="checkbox" name='WO_DTL_USE_FLG' id='WO_DTL_USE_FLG' value='DTL' class="trans" onClick='rdOpen(document.form);setWoDtlUseFlg(this);' /><label for="WO_DTL_USE_FLG">Detail Form</label>
                    </td>
                    <th>Rate</th>
                    <td>
                        <input type="radio" name='RT_DP_USE_FLG' value='Y' class="trans" onClick='rdOpen(document.form)' checked /><label for="RT_DP_USE_FLG">Show</label><!--
                        --><input type="radio" name='RT_DP_USE_FLG' value='N' class="trans" onClick='rdOpen(document.form)' /><label for="RT_DP_USE_FLG">Hide</td></label>
                   </td>
                   <td></td>
                </tr>
            </tbody>
        </table>        
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <div class="opus_design_grid" style="height: 600px">
        <script language="javascript">rdViewerObject();</script>
    </div>
</div>   
<div class="wrap_result" style="display: none" > 
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <div>
            <script language="javascript">ComSheetObject('sheet');</script>
            <script language="javascript">ComSheetObject('sheet2');</script>
            <script language="javascript">ComSheetObject('sheet3');</script>
        </div>
    </div>
    <!-- opus_design_grid(E) -->

<!-- wrap_result(E) -->
</div>
<!-- popup_contens_area(E) -->
</form>