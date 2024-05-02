<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0430.jsp
*@FileTitle  : CNTR History Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0430Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0430Event  event = null;         //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;    //error from server
    String strErrMsg = "";                 //error message
    String usrOffice = "";                 // OFFICE CODE
    try {

        event = (EesCtm0430Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        usrOffice = account.getOfc_cd();
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

    }catch(Exception e) {
        out.println(e.toString());
    }

  String cntrNo = (request.getParameter("cntrNo") == null)? "": request.getParameter("cntrNo");
  String chkDgt = (request.getParameter("chkDgt") == null)? "": request.getParameter("chkDgt");
  cntrNo = cntrNo + chkDgt;
  String tpSz = (request.getParameter("tpSz") == null)? "": request.getParameter("tpSz");
  String autoFlg = (request.getParameter("autoFlg") == null)? "": request.getParameter("autoFlg");

  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>

<script type="text/javascript" src="/opuscntr/apps/opus/ees/ctm/equipmentmovementmgt/containermovementmgt/script/common_0430.js"></script>
<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }

</script>
<!-- developer job  -->

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="p_date1">
<input type="hidden" name="usr_office" value="<%=usrOffice%>">
<input type="hidden" name="auto_flg" value="<%=autoFlg%>">
<input type="hidden" name="osca_bkg_flg" id="osca_bkg_flg" value="">

<% if (popMode.equals("Y")) { %>
<!-- layer_popup_title(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span>CNTR History Update</span></h2>
        <!-- page_title(E) -->
            
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn2_save" id="btn2_save">Save</button><!--
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<% } else { %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button"><span id="title"></span></button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
         --><button type="button" class="btn_normal" name="btn2_save" id="btn2_save">Save</button>
    </div>
    <!-- opus_design_btn(E) -->
    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<% } %>

<div class="wrap_search"> 
<div class="opus_design_inquiry wFit">
    <table>
        <tbody>
            <tr>
                <th width="40">Container No.</th>
                <td>
                    <input type="text" style="width:90px;ime-mode:disabled;" tabindex="1" name="p_cntrno" id="p_cntrno" class="input1" maxlength='11' dataformat="engup" value="<%=cntrNo%>"><!--
                    <input type="text" style="width:20px;" maxlength="1" name="check_digit" id="check_digit" tabindex="2" class="input" value="">
                    --><input type="text" style="width:26px;" class="input" name="ctnr_tpsz_cd" id="ctnr_tpsz_cd" value="<%=tpSz%>" readonly>&nbsp;
                </td>
            </tr>
        </tbody>
    </table>
</div>
<!-- inquiry_area(E) --> 
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <!-- opus_grid_title(S) -->
    <h3 class="title_design">VVD /BKG History</h3><br/>
    <!-- opus_grid_title(E) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <!-- opus_grid_title(S) -->
    <h3 class="title_design">Movement History (Update)</h3><br/>
    <!-- opus_grid_title(E) -->
    <!-- opus_grid_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_normal" name="btn2_add" id="btn2_add">Row&nbsp;Insert</button>
        <button type="button" class="btn_normal" name="btn2_delete" id="btn2_delete">Row&nbsp;Delete</button>
    </div>
    <!-- opus_grid_btn(E) -->
    <script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
</div>

<!-- end of developer job -->
</form>
</body>
</html>