<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0047.jsp
*@FileTitle  : Pick-up Status by Auth No
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event.EesLse0047Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
    EesLse0047Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_ofc       = "";
    Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseMgt.OnhireApproval");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc = account.getOfc_cd();

        event = (EesLse0047Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        //getting data from server when load the initial screen
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
<input type="hidden" name="f_cmd"               id="f_cmd" />
<input type="hidden" name="pagerows"            id="pagerows" />
<input type="hidden" name="detail_auth_no"      id="detail_auth_no" />
<input type="hidden" name="detail_agmt_cty_cd"  id="detail_agmt_cty_cd" />
<input type="hidden" name="detail_agmt_seq"     id="detail_agmt_seq" />
<input type="hidden" name="detail_cntr_tpsz_cd" id="detail_cntr_tpsz_cd" />
<input type="hidden" name="detail_divsion"      id="detail_divsion" />
<input type="hidden" name="tysz"                id="tysz" />
<input type="hidden" name="usr_ofc_cd"          id="usr_ofc_cd" value="<%=strUsr_ofc%>" >
<div class="page_title_area clear">
   <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn"><!--  
    --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
    --><button type="button" class="btn_normal" name="btn_New"      id="btn_New">New</button><!--  
    --></div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
</div>
<div class="wrap_search">
    <div class="opus_design_inquiry wFit">
        <table>
            <colgroup>
                <col width="50">
                <col width="50">
                <col width="50">
                <col width="100">
                <col width="100">
                <col width="*">
            </colgroup>
            <tr>
                <th class="sm">Term</th>
                <td class="sm pad_left_8"><input type="radio" name="lstm_tp_cd" value="O" class="trans" checked id="lstm_tp_cd" />&nbsp;On Hire</td>  
                <td class="sm pad_left_8"><input type="radio" name="lstm_tp_cd" value="L" class="trans" id="lstm_tp_cd" />&nbsp;Lease Out</td>  
                <th>LOC</th>
                <td><select name="loc_tp" ><!--  
                --><option value="R" >RCC</option><!--  
                --><option value="L">LCC</option><!--  
                --></select>&nbsp;<input type="text" style="width:75px;ime-mode:disabled;text-align:center;" name="loc_cd"  value="" class="input"  dataformat="engup" maxlength="5" fullfill><!--  
                --><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button></td>
                <th>Date</th>   
                <td><input type="text" name="period_stdt" style="width:80px;ime-mode:disabled;text-align:center;" value="" class="input" dataformat="ymd" id="period_stdt" /><!--  
                -->~&nbsp;<input type="text" name="period_eddt" style="width:80px;ime-mode:disabled;text-align:center;" value="" class="input" dataformat="ymd" id="period_eddt" /><!--  
                --><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
             </tr>  
        </table>
    </div>
    <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>  
    <div class="opus_design_inquiry wFit">
        <table>
            <colgroup>
                <col width="80">
                <col width="140">
                <col width="90">
                <col width="217">
                <col width="80">
                <col width="*">
            </colgroup>
            <tr>
                <th>Auth No.</th>
                <td><input type="text" style="width:156px;" name="auth_no" class="input" value="" dataformat="engup" otherchar = "-" id="auth_no" /></td>
                <th>Lease Term</th>
                <td><script type="text/javascript" >ComComboObject('combo1', 1, 185, 1 );</script><input type="hidden" name="lstm_cd" value="" ></td>
                <th>TP/SZ</th>
                <td><script type="text/javascript" >ComComboObject('combo2', 1, 120, 1 );</script><input type="hidden" name="cntr_tpsz_cd" value="" ></td>
            </tr>   
        </table>
        <table>
            <colgroup>
                <col width="80">
                <col width="*">
            </colgroup>
            <tr>
                <th>AGMT No.</th>
                <td><input type="text" style="width:45px;text-align:center" name="agmt_cty_cd" class="input2" value="HHO" maxlength="3" readonly id="agmt_cty_cd" /><!--  
                --><input type="text" style="width:78px;text-align:center" name="agmt_seq" class="input" value="" maxlength="6" dataformat="num" id="agmt_seq" /><!--  
                --><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button><!--  
                --><input type="text" style="width:75px;" name="vndr_seq" class="input2" value="" readonly id="vndr_seq" /><!--  
                <input type="text" style="width:50px;" name="vndr_abbr_nm" class="input2" value="" readonly id="vndr_abbr_nm" />  
                --><input type="text" style="width:200px;" name="vndr_nm" class="input2" value="" readonly id="vndr_nm" />
                </td>
              </tr>
        </table>
        <table>
            <colgroup>
                <col width="80">
                <col width="40">
                <col width="40">
                <col width="40">
                <col width="*">
            </colgroup>
            <tr>
                <th class="sm">Division</th>
                <td class="sm pad_left_8"><input type="radio" name="new_van_tp_cd" value="" class="trans" checked id="new_van_tp_cd" />&nbsp;All</td>  
                <td class="sm pad_left_8"><input type="radio" name="new_van_tp_cd" value="N" class="trans" id="new_van_tp_cd" />&nbsp;New</td>  
                <td class="sm pad_left_8"><input type="radio" name="new_van_tp_cd" value="O" class="trans" id="new_van_tp_cd" />&nbsp;Old</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </div>
</div>
<div class="wrap_result">
    <!--  <table>
        <colgroup>
                <col width="100">
                <col width="*">
        </colgroup>
        <tr>
            <th class="title_design">Summary</th>
            <td>&nbsp;</td>
        </tr>
    </table>-->
    <div class="opus_design_grid" id="mainTable" style="display:inline-block"> 
        <h3 class="title_design">Summary</h3>
        <div class="opus_design_btn"><!--  
        --><button type="button" class="btn_accent" name="btn_downexcel_summary" id="btn_downexcel_summary">Down Excel</button><!--  
        --></div>
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- <table>
        <colgroup>
                <col width="120">
                <col width="*">
        </colgroup>
        <tr>
            <th class="title_design">CNTR Detail</th>
            <td>&nbsp;</td>
        </tr>
    </table> -->
    <div class="opus_design_grid" id="mainTable">
        <h3 class="title_design">CNTR Detail</h3>
        <div class="opus_design_btn"><!--  
        --><button type="button" class="btn_accent" name="btn_downexcel_detail" id="btn_downexcel_detail">Down Excel</button><!--  
        --></div>
        <script type="text/javascript">ComSheetObject('sheet2');</script>
    </div>
</div>
</form>