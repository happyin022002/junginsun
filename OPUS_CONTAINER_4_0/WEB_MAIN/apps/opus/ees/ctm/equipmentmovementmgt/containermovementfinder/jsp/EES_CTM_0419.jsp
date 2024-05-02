<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0419.jsp
*@FileTitle : VL/VD EDI Test Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0419Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0419Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //DB ResultSet list count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementFinder");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesCtm0419Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<style>
 .Obj1 {background:#C9FD86}
 .Obj2 {background:#FFFFFF}
</style>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer job  -->

<!-- 제목 -->
<div class="page_title_area clear">
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

        <!-- btn_div -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
         --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
    </div>

   <!-- page_location(S) -->
   <div class="location">
        <span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class="wrap_search">
    <div class="opus_design_inquiry">       
        <table border="0" style="width:979px;">
        <tr>
            <th width="40px" class="align_left">T/VVD</th>
            <td width="100px"><input type="text" style="width:80px;" class="input1" name="vls_cd" maxlength="9" tabindex="1" dataformat ="engup" onBlur="getEtaEtdTime();"></td>
            <th width="30px" class="align_left">Port</th>
            <td width="70px"><input type="text" style="width:50px;" class="input1" name="pol_cd" maxlength="5" tabindex="2" dataformat ="engup" onBlur="getEtaEtdTime();"></td>
            <td width="180px">
                <table border="0" style="width:150px;">
                    <tr class="h23">
                        <th width="40px" class="align_left">MVMT</th>
                        <td class="stm"><input type="radio" value="VL" name="flgrslt" class="trans" checked> VL&nbsp;&nbsp;<input type="radio" value="VD" name="flgrslt" class="trans" onChange="getEtaEtdTime();"> VD</td>
                    </tr>
                </table>
            </td>
            <th width="50px" class="align_left">ETA/ETD </th>
            <td><input type="text" style="width:120px;" class="input2" name="eta_etd" readonly></td>
        </tr>
        </table>
    </div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
    <div class="opus_design_grid">
        <!--  biz_2  (S) -->
        <div class="layout_wrap" style="width:1258px">
        <tr>
            <div class="layout_vertical_2" style="width:40%;">
            <h3 class="title_design mar_btm_8">Booking container List</h3>        
                
            <script type="text/javascript">ComSheetObject('sheet1');</script>
            
            <div class="opus_design_btn  mar_top_8">
               <button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
               --><button type="button" class="btn_normal" name="btn_detail" id="btn_detail">MVMT Inquiry</button>
            </div>
            </div>
            <div class="layout_vertical_2" style="width:20%; padding-left:10px;">                        
                <div class="opus_design_inquiry">
                <table style="margin: 25px 0px;">
                <tr>
                    <td style="padding-right: 10px; padding-top:3px; padding-bottom:3px;"><input type="text" style="width:70px;text-align:right" class="input" name="u1"></td>
                    <td style="padding-right: 10px;"><button type="button"  style="width:75px" class="btn_etc" name="btn_unmatch" id="btn_unmatch">Unmatch</button>
                    </td>
                    <td><input type="text" style="width:70px;text-align:right" class="input" name="u2"></td>
                </tr>
                <tr>
                    <td style="padding-right: 10px; padding-top:3px; padding-bottom:3px;"><input type="text" style="width:70px;text-align:right;" class="input" name="m1"></td>
                    <td style="padding-right: 10px;"><button type="button"  style="width:75px" class="btn_etc" name="btn_match" id="btn_match">Match</button>                    
                    </td>
                    <td><input type="text" style="width:70px;text-align:right;" class="input" name="m2"></td>
                </tr>
                <tr>
                    <td style="padding-right: 10px; padding-top:3px; padding-bottom:3px;"><input type="text" style="width:70px;text-align:right;background-color:#ADC900;" name="l1"></td>
                    <td style="padding-right: 10px;"><button type="button" style="width:75px" class="btn_etc" name="btn_total" id="btn_total">Total</button> 
                    </td>
                    <td><input type="text" style="width:70px;text-align:right;background-color:#ADC900;" name="l2"></td>
                </tr>
    
                </table>
                </div>
            </div>
            <div class="layout_vertical_2 pad_left_8" style="width:40%;">
            <h3 class="title_design mar_btm_8">Movement(EDI)</h3>     
            
            <script type="text/javascript">ComSheetObject('sheet2');</script>
            
            <div class="opus_design_btn mar_top_8">
               <button type="button" class="btn_normal" name="btn_edimsg" id="btn_edimsg">EDI MSG</button><!--
               --><button type="button" class="btn_normal" name="btn_detail2" id="btn_detail2">MVMT Inquiry</button>
            </div>
            </div>
        </tr>
        </div>
        
    </div>
</div>
<!-- 시트영역 -->

<!-- end of developer job -->
</form>
