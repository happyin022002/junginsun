<%
/*========================================================= 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0406.jsp
*@FileTitle : International MVMT
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0406Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0406Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //DB ResultSet list count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMgt");
    String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesCtm0406Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="org_vvd" id="org_vvd">
<input type="hidden" name="osca_bkg_flg" id="osca_bkg_flg" value="">

<!-- 제목 -->
<div class="page_title_area clear">
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->

        <!-- btn_div -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve" style="display:none;" disabled>Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
        --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
    </div>

   <!-- page_location(S) -->
   <div class="location">
        <span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class="wrap_search">
    <div class="opus_design_inquiry wFit">      
        <table border="0" style="width:979px;">
            <tr>
                <th width="50px">Status</th>
                <td width="110px"><select style="width:55px;" class="input1" id="p_status" name="p_status"  tabindex="1">
                    <option value="OP" selected>OP</option>
                    <option value="OC">OC</option>
                    <option value="VL">VL</option>
                    <option value="VD">VD</option>
                    <option value="IC">IC</option>
                    <option value="ID">ID</option>
                    <option value="MT">MT</option>
                    <option value="EN">EN</option>
                    <option value="TN">TN</option>
                    <option value="TS">TS</option>
                    </select></td>
                <th width="70px">Origin Yard</th>
                <td width="150px" style="padding-top:1;">
                    <input type="text" style="width:55px;text-align:center;ime-mode:disabled" maxlength="5" class="input1" id="p_yard1" name="p_yard1"  tabindex="2" dataformat ="engup" ><!--
                    --><script type="text/javascript">ComComboObject('p_yard2', 2, 50 , 0)</script>
                </td> 
                <th width="70px" class="align_left">Event date</th>
                <td><input type="text" style="width:75px;ime-mode:disabled" maxlength="10" class="input1" tabindex="4" id="p_date" name="p_date" dataformat="ymd"><!--
                    --><button type="button" name="btn_Calendar1" id="btn_Calendar1" class="calendar"></button><!--
                    --><input type="text" style="width:50px;ime-mode:disabled" maxlength="4" class="input1" tabindex="5" id="p_time" name="p_time" dataformat="hm"><!--
                    --><input type="hidden" style="width:112px;ime-mode:disabled" maxlength="16" class="input1" id="p_date0" name="p_date0">
                </td>
            </tr>
        </table>
        <table border="0" style="width:979px; display:none;" id="condHidden">
            <tr>
                <th width="50px">VVD CD</th>
                <td width="200px"><input type="text" style="width:90px;ime-mode:disabled" maxlength="9" class="input" name="p_vvd" id="p_vvd" dataformat ="engup" tabindex="6">
                 						<input type="checkbox" style="width:10px;ime-mode:disabled" class="input" name="oscar_bkg_flg"  value=""> OSCAR<!-- <input type="text" style="width:46;ime-mode:disabled" maxlength="4" class="input" name="p_vvd1_1" tabindex="6">&nbsp;<input type="text" style="width:40;ime-mode:disabled" maxlength="4" class="input" name="p_vvd1_2" tabindex="7">&nbsp;<input type="text" maxlength="1" style="width:20;ime-mode:disabled" class="input" name="p_vvd1_3" tabindex="8">-->
                </td>
                <th width="35px">POL</th>
                <td width="90px"><input type="text" style="width:55px;ime-mode:disabled" maxlength="5" class="input" name="p_pol" dataformat ="enguponly" tabindex="7"></td>
                <th width="30px">POD</th>
                <td width="100px"><input type="text" style="width:50px;ime-mode:disabled" maxlength="5" class="input" name="p_pod" dataformat ="enguponly" tabindex="8"></td>
                <th width="30px">F/M</th>
                <td width="*"><select style="width:60px;"class="input" name="p_type1" id="p_type1" tabindex="9">
                    <option value="" selected>ALL</option>
                    <option value="F">Full</option>
                    <option value="M">Empty</option>
                    </select></td>
                <td><input type="hidden" style="width:60px;"class="input" name="p_type2"></td>
                <!--
                <td width="70">Local T/S</td>
                <td><select style="width:60;"class="input" name="p_type3">
                    <option value="" selected>ALL</option>
                    <option value="N">Local</option>
                    <option value="Y">T/S</option>
                    </select></td> -->
        </table>
    </div>
</div>
<!-- 검색영역 -->
<!-- 시트영역 -->
<div class="wrap_result">
    <div class="opus_design_grid">  
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
            <button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
            <button type="button" class="btn_normal" name="btn_select" id="btn_select">Select CNTR</button>
            <button type="button" class="btn_normal" name="btn_qty" id="btn_qty">QTY Check</button>
            <button type="button" style="display:none;" class="btn_normal" name="btn_pre" id="btn_pre" disabled>PreCheck</button>
            <button type="button" class="btn_normal" name="btn_loadExcel" id="btn_loadExcel">LoadExcel</button>
            <button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
        </div>
        <script type="text/javascript">ComSheetObject('sheet1');</script>
        <div id='hiddenGrid' style='display:none'><script type="text/javascript">ComSheetObject('sheet0');</script></div>
    </div>
    <div class="opus_design_inquiry">
        <table>
            <tr>
              <!-- <th width="100px" class="align_left">Diff.Check Digit</th> -->
              <td style="padding-left:4;padding-top:3">
                <input type="hidden" style="width:90px; ime-mode:disabled;" class="input" maxlength="11" tabindex="10" id="p_cntrno" name="p_cntrno" dataformat="engup">
              </td>
            </tr>
        </table>
    </div>
</div>
<!-- 시트영역 -->
</form>
