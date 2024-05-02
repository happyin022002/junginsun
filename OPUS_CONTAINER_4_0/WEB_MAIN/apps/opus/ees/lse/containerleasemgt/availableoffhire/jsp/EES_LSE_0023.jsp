<%--
/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0023.jsp
*@FileTitle  : Target Off-Hire Location Registration
*@author     : CLT
*@version    : 1.0
*@since      : 2016/05/10
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EesLse0023Event"%>
<%
    EesLse0023Event  event    = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;         //Error occurred on the server
    DBRowSet rowSet           = null;                              //DB ResultSet
    String strErrMsg          = "";                               //Error message    
    String strUsr_off_cd      = "";
  
    int rowCount              = 0;                                 //DB ResultSet List the number of

    SignOnUserAccount account = null;

    try {
        account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        event = (EesLse0023Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } // end if
        

    } catch(Exception e) {
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
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="agmt_ver_seq" id="agmt_ver_seq">
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_off_cd %>" id="usr_ofc_cd" />
<input type="hidden" name="upd_usr_id" id="upd_usr_id" value="<%=account.getUsr_id()%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    
    <!-- opus_design_btn (S) -->
    <div class="opus_design_btn">
        <button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
        --><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
        --><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button>
    </div>
    <!-- page_location(S) -->
    <div class="location">  
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>

<!-- page_title_area(E) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <table>
            <colgroup>
                <col width="90">
                <col width="330">
                <col width="130">
                <col width="300">
                <col width="90">
                <col width="150">       
                <col width="150"> 
                <col width="250">       
                <col width="450">       
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th>Contract No.</th>
                    <td><input type="text" name="ctrt_no" style="width:100px;" size="" maxlength="" class="input" value="" id="ctrt_no" class="input"/></td>
                    <th>AGMT No.</th>
                    <td><input type="text" style="width:35px;text-align:center;" name="agmt_cty_cd" id="agmt_cty_cd" dataformat="engup" class="input2" value="HHO" maxlength="3" readonly><!--  
                        --><input type="text" style="width:60px;text-align:center;" name="agmt_seq" id="agmt_seq"  class="input"  value="" maxlength="6" dataformat="num"><!--  
                        --><button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1"></button><!--  
                        --><input type="text" name="ref_no" id="ref_no" style="width:150px;" class="input2" readonly></td>  
                    <th>Term</th>
                    <td><script type="text/javascript" >ComComboObject('lstm_cd', 1, 100, 1);</script></td>
                    <th>TP/SZ</th>
                    <td><script type="text/javascript" >ComComboObject('cntr_tpsz_cd', 1, 110, 1);</script></td>               
                </tr>
                <tr>
                   <th>Target Area</th>
                   <td><script type="text/javascript" >ComComboObject('eq_loc_tp_cd', 1, 100, 1);</script><!--  
                        --><input type="text" name="loc_cd" id="loc_cd" style="width:100px;" class="input2" dataformat="engup"><!--                                         
                        --><button type="button" name="btn_tgtarea" id="btn_tgtarea" class="input_seach_btn"></button> 
                  </td>
                  <th>Lessor</th>
				  <td><input type="text" name="vndr_seq" caption="Lessee" style="width:100px;text-align:center;" class="input" value="" maxlength="6" dataformat="num" id="vndr_seq" /><!--  
				  --><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button><!--  
				  --><input type="text" name="vndr_nm" caption="Lessor." style="width:150px;" class="input2" value="" readonly="" id="vndr_nm" /></td>
                   <th>Sale and Leaseback Flag</th>
                   <td><input type="checkbox" name="slb_flg" caption="SLB Flag" value="Y" class="trans" id="slb_flg" /></td>
                   <th>Off hire Flag</th>
                   <td><input type="checkbox" name="use_flg" caption="Off Hire Flag" value="1" class="trans" id="use_flg" /></td>
                   <th>Include Remaining 0 Qty</th>
                   <td>
                   <select style="width:78px;" class="input" name="remain" id="remain">
					<option value="I" >Include</option><!-- 
				 --><option value="E" selected>Exclude</option><!-- 
				 --><option value="O">Only </option><!-- 
				 --></select>
                   </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>  

<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" id="mainTable">
        <div class="opus_design_btn"><!-- 
            --><button class="btn_normal" name="btn_rowadd" id="btn_rowadd" type="button">Row Add</button><!--  
            --><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button>
        </div>
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
</form>
