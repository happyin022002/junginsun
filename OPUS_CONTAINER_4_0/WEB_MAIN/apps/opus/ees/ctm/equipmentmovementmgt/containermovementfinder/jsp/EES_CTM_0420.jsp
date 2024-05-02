<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0420.jsp
*@FileTitle  : EDI Result Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0420Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0420Event event = null;        //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;    //error from server
    String strErrMsg = "";               //error message
    int rowCount = 0;                    //DB ResultSet list count
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String strUsr_id    = "";
    String strUsr_nm    = "";
    Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.LongTxContainerMovementFinder");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        
        
        event = (EesCtm0420Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
          strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    
    } catch(Exception e) {
        out.println(e.toString());
    }


    // Duration 종료일(현재일)
    String pDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
    // Duration 시작일(현재일 -7)
    String pDate1 = DateTime.addMonths(pDate2, -1, "yyyy-MM-dd");
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

<form name="form" onsubmit="return false;">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="f_cmd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
        --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>

<div class="wrap_search">
<!-- inquiry_area(S) -->
<div class="opus_design_inquiry">
    <!--  biz_1 (S) -->
    <table>
        <colgroup>
            <col width="90"  />
            <col width="90"  />
            <col width="45"  />
            <col width="100"  />
            <col width="35"  />
            <col width="57"  />
            <col width="100" />
            <col width="350" />
            <col width="*" />
        </colgroup>
        <tbody>
            <tr>
                <th>Receiving Date</th>
                <td colspan="8">
                    <input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1" id="p_date1" onChange="javascript:dateCheck();">~
                    <input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2" id="p_date2" onChange="javascript:dateCheck();"><!--  
                    --><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button>
                </td>
            </tr>
            <tr>
                <th>RCC</th>
                <td><script type="text/javascript">ComComboObject('rcc_cd', 1, 70, 1, 1, 2, 0, 3)</script></td>
                <th>LCC</th>
                <td><script type="text/javascript">ComComboObject('lcc_cd', 1, 70 , 0, 0, 2, 0, 4)</script></td>
                <th>Yard</th>
                <td>
                    <input type="text" style="width:55px;ime-mode:disabled;" class="input" maxlength="5" tabindex="5" name="yd_cd_disp" id="yd_cd_disp" dataformat ="engup" >
                    <input type="hidden" name="p_yard1" id="p_yard1">
                </td>
                <td><script type="text/javascript">ComComboObject("p_yard2", 2, 50, 0, 0, 0, 0, 10)</script></td>
                
                <td class="sm pad_left_8"><b>GAP</b>&nbsp;&nbsp;
                    <input type="radio" name="gap_radio" value="" class="trans" checked>All&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="gap_radio" value="12" class="trans">12 Hour&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="gap_radio" value="24" class="trans">24 Hour&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="gap_radio" value="48" class="trans">48 Hour
                </td>
                <td></td>
            </tr>
        </tbody>
    </table>
    <!--  biz_1   (E) -->   
</div>
<!-- inquiry_area(E) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<div class="opus_design_grid" style="display:none;">
    <script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
    <!-- data_area(S) -->
    <div class="opus_design_inquiry">
        <table style="width:70%" >
            <colgroup>
                <col width="5%"   />
                <col width="3.5%" />
                <col width="6%"   />
                <col width="4.5%" />
                <col width="3.5%" />
                <col width="6%"   />
                <col width="4.5%" />
                <col width="3.5%" />
                <col width="6%"   />
                <col width="4.5%" />
                <col width="4%"   />
                <col width="6%"   />
                <col width="4.5%" />
                <col width="3.5%" />
                <col width="6%"   />
                <col width="4.5%" />
                <col width="3.5%" />
                <col width="6%"   />
                <col width="4.5%" />
                <col width="3.5%" />
                <col width="6%"   />
                <col width=""     />
            </colgroup>
            <tbody>
                <tr>
                    <th class="tr2_head2" style="text-align:center;"> SUMM</th>
                    <td class="tr2_head2" style="text-align:center;">ERR</td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" readonly="true" name="int_err"></td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" readonly="true" name="int_err_ratio"></td>
                    <td class="tr2_head2" style="text-align:center;">OK</td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" readonly="true" name="int_ok"></td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" readonly="true" name="int_ok_ratio"></td>
                    <td class="tr2_head2" style="text-align:center;">12 H</td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" readonly="true" name="edi_12h"></td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" readonly="true" name="edi_12h_ratio"></td>
                    <td class="tr2_head2" style="text-align:center;">24 H</td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" readonly="true" name="edi_24h"></td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" readonly="true" name="edi_24h_ratio"></td>
                    <td class="tr2_head2" style="text-align:center;">48 H</td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" readonly="true" name="edi_48h"></td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" readonly="true" name="edi_48h_ratio"></td>
                    <td class="tr2_head2" style="text-align:center;">Over</td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" readonly="true" name="edi_over"></td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" readonly="true" name="edi_over_ratio"></td>
                    <td class="tr2_head2" style="text-align:center;">TTL</td>
                    <td class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" readonly="true" name="edi_ttl"></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- data_area(E) -->
</div>
</form>
