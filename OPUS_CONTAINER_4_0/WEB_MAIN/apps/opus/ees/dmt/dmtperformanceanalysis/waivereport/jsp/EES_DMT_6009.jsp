<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_6009.jsp
*@FileTitle  : Waive Report by Office 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.event.EesDmt6009Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt6009Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_ofc       = "";
    String strRhq_ofc_cd    = "";
    Logger log = Logger.getLogger("com.clt.apps.DMTPerformanceAnalysis.waivereport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc  = account.getOfc_cd();
        strRhq_ofc_cd = account.getRhq_ofc_cd();


        event = (EesDmt6009Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // Retrieving the parameter values ​​for calls to pop-up page ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<!-- Developer's task -->
<input id="usr_ofc_cd" name="usr_ofc_cd" value="<%=strUsr_ofc%>" type="hidden" />
<input id="usr_rhq_ofc_cd" name="usr_rhq_ofc_cd" value="<%=strRhq_ofc_cd%>" type="hidden" />
<input id="ofc_cd2" name="ofc_cd2" type="hidden" />
<input id="ofc_cd" name="ofc_cd" type="hidden" />
<input id="tmp_ofc_cd" name="tmp_ofc_cd" type="hidden" />
<input id="dmdt_cntr_tp_cd" name="dmdt_cntr_tp_cd" type="hidden" />
<input id="dmdt_trf_cd" name="dmdt_trf_cd" type="hidden" />
<input id="start_dt" name="start_dt" type="hidden" />
<input id="end_dt" name="end_dt" type="hidden" />
<input id="slctofccd" name="slctofccd" type="hidden" />
<input id="slcttrfcd" name="slcttrfcd" type="hidden" />
<input id="slctscno" name="slctscno" type="hidden" />
<input id="slctrfano" name="slctrfano" type="hidden" />
<input id="tempuser" name="tempuser" type="hidden" />
<input id="curr_flg2" name="curr_flg2" type="hidden" />
<input id="head_office" name="head_office" value="<%=ConstantMgr.getHeadOfficeCode()%>" type="hidden" />

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   
   <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
   <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
   <!-- page_title(E) -->

   <!-- opus_design_btn(S) -->
   <div class="opus_design_btn">
      <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
      --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
      --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button><!--
      --><button type="button" class="btn_normal" name="btn_detail" id="btn_detail">Detail</button><!--
      --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
   <div class="opus_design_inquiry wFit">
      <div id="sch_cond_div" style=display:block;>
         <!--  MiniLayer (S) -->
   <table>
      <colgroup>
            <col width="95">
            <col width="500">
            <col width="100">
            <col width="*">
      </colgroup>
      <tbody>
         <tr>
               <th class="sm">To MVMT Date</th>
               <td class="sm"><input type="radio" name="dt_flg" id="dt_flg" value="M" class="trans" checked onclick="dt_flg_click()"><label for="dt_flg">Month</label><input type="text" name="to_mvmt_mon" id="to_mvmt_mon" maxlength="6" dataformat="ym" style="width:65px" class="input1" value=""><input type="radio" name="dt_flg" id="dt_flg" value="P" class="trans" onclick="dt_flg_click()"><label for="dt_flg">Period</label>&nbsp;&nbsp;<input type="text" name="fm_dt" id="fm_dt" dataformat="ymd" style="width:80px" class="input1"> ~ <input type="text" name="to_dt" id="to_dt" dataformat="ymd" style="width:80px" class="input1"><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>
                <th>Tariff Type</th>
                <td><script type="text/javascript">ComComboObject('tariff_type',1,130,1,1,0,false);</script><button type="button"  class="multiple_inq ir" name="btns_inv_no" id="btns_inv_no"></button></td>
         </tr>
      </tbody>
      </table>
   <table>
      <colgroup>
            <col width="95">
            <col width="200">
            <col width="300">
            <col width="100">
            <col width="*">
      </colgroup>
      <tbody>
         <tr>
                <th class="sm">Waive Office</th>
                <td class="sm"><select style="width:80px;" class="input1" name="reqapp" id="reqapp">
                              <option value="R" selected>Request </option>
                              <option value="A"         >Approval</option>
                             </select><!--  
                     --><input type="radio" id="ofc_flg2_1" name="ofc_flg2" value="R" class="trans mar_rgt_8" onclick="ofc_flg2_click()"><label for="ofc_flg2_1">RHQ</label><!-- 
                     --><input type="radio" id="ofc_flg2_2" name="ofc_flg2" value="O" class="trans" checked onclick="ofc_flg2_click()"><label for="ofc_flg2_1O">Office</label></td>
                <td class="sm">
                    <div id = "div_ofc2_txt" style="display:''"><input type="text" style="width:78px;" class="input" name="location" value=""  dataformat="engup" style="ime-mode:disabled"  maxlength="5"><button type="button" class="input_seach_btn" name="btns_ctrt_ofc" id="btns_ctrt_ofc"></button></div>
                    <div id = "div_ofc2_com" style="display:none" ><script type="text/javascript">ComComboObject('office2',1,80,0,1,0,true);</script></div></td>
                <th>Group by</th>
                <td><select name="grp_flg" id="grp_flg" style="width:127px;">
                       <option value="O" selected>Office</option>
                       <option value="R">RHQ</option>
                    </select></td>
         </tr>
      </tbody>
      </table>
   <table>
      <colgroup>
            <col width="95">
            <col width="500">
            <col width="100">
            <col width="*">
      </colgroup>
      <tbody>
         <tr>
                <th class="sm">Coverage</th>
                <td class="sm" >DEM/DET OFC <input type="radio" name="ofc_flg" id="ofc_flg" value="R" class="trans" checked onclick="ofc_flg_click()"><label for = "ofc_flg">RHQ</label><input type="radio" name="ofc_flg" id="ofc_flg" value="O" class="trans" onclick="ofc_flg_click()"><label for = "ofc_flg">Office</label> <script type="text/javascript">ComComboObject('office',1,77,0,1,0,true);</script><button type="button"  class="multiple_inq ir" name="btns_inv_no" id="btns_inv_no"></button><input type="checkbox" name="chk_sub_ofc" id="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans"><label for = "chk_sub_ofc">Incl. Sub Office</label></td>
                <td></td>
            </tr>
            <tr>
                <th class="sm">Currency</th>
                <td class="sm"><input type="radio" name="curr_flg" id="curr_flg" value="U" class="trans" checked><label for = "curr_flg">USD</label><input type="radio" name="curr_flg" id="curr_flg" value="L" class="trans"><label for = "curr_flg">Local</label></td>
                <th>CNTR Type</th>
                <td><script type="text/javascript">ComComboObject('cntr_type',1,130,1,0,0,false);</script></td>
            </tr>
      </tbody>
   </table>
</div>
</div>
</div>
<!-- opus_design_grid(S) -->
<div class="wrap_result">
   <div class="opus_design_grid">
       <script type="text/javascript">ComSheetObject('sheet1');</script>
   </div>
</div>
<!-- opus_design_grid(E) -->
</form>