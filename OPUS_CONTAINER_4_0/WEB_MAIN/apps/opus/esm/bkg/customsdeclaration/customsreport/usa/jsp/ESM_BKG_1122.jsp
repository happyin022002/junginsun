<%/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1122.jsp
*@FileTitle : US AMS : BAPLIE Monitoring Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.20
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.06.20 김봉균 
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg1122Event"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1122Event  event      = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null; //서버에서 발생한 에러
    String strErrMsg            = "";   //에러메세지
    int rowCount                = 0;    //DB ResultSet 리스트의 건수

    String successFlag  = "";
    String codeList     = "";
    String pageRows     = "1000";
    String strUsr_id    = "";
    String strUsr_nm    = "";
    String today        = "";

    Logger log = Logger.getLogger("com.clt.opus.CustomsDeclaration.CustomsReport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg1122Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script language="javascript">
    var today = "<%=today%>";
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if

        loadPage();
    }
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value=<%=pageRows%>>
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">

<div class="page_title_area clear">
    <h2 class="page_title">
        <button type="button"><span id="title"></span></button>
    </h2>
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
        <button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
        <button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
        <button type="button" class="btn_normal" name="btn_baplie" id="btn_baplie">Go to BAPLIE</button>
    </div>
   <div class="location">
        <span id="navigation"></span>
   </div>
</div>

<div class="wrap_search">
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="60px">
                <col width="100px">
                <col width="60px">
                <col width="120px">
                <col width="80px">
                <col width="100px">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th>LANE</th>
                    <td>
                        <input type="text" name="lane" style="width:50px; ime-mode: disabled;" class="input" dataformat="engup" maxlength="3" fullfill caption="LANE"></td>
                    <th>VVD</th>
                    <td>
                       <input type="text" name="vvd" style="width:90px; ime-mode: disabled;" class="input1" dataformat="eng" maxlength="9" fullfill caption="VVD"></td>
                    <th>Last F. POL</th>
                    <td>
                       <input type="text" name="l_pol" style="width:70px; ime-mode: disabled;" class="input" dataformat="eng" maxlength="5" fullfill caption="Last Foreign POL"></td>
                    <td rowspan="2" class="bg">
                        <table>
                            <tr>
                                <td width="50px" align="center"><input type="checkbox" name="gubun" class="trans"></td>
                                <td width="200px">
                                    <input type="radio" name="srch_dt" value="atd" class="trans" checked>&nbsp;Vessel A.T.D.<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Actual Time of Departure)</td>
                                <td width="*">
                                    <input type="radio" name="srch_dt" value="due" class="trans">&nbsp;Due Date</td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td class="stm" colspan="2">
                                    <input type="text" style="width: 75px; ime-mode: disabled" class="input1" value="" required disabled
                                    dataformat="ymd" name="due_from_dt" maxlength="10" caption="Due Date" cofield="due_to_dt">
                                    <input type="text" name="due_from_tm" maxlength="5" style="width:40px" dataformat="hm" value="00:00" class="input1" disabled>
                                    ~ <input type="text"
                                    style="width: 75px; ime-mode: disabled" class="input1" value="" required disabled
                                    dataformat="ymd" name="due_to_dt" maxlength="10" caption="Due Date" cofield="due_from_dt">
                                    <input type="text" name="due_to_tm" maxlength="5" style="width:40px" value="23:59" class="input1" disabled>
                                    <img src="img/btns_calendar.gif" width="19px" height="20" border="0" dataformat="hm" align="absmiddle" class="cursor" name="btn_calendar">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr class="h23">
                    <th width="60px">Customs</th>
                    <td><input type="text" name="customs" style="width:70px; ime-mode: disabled;" class="input"
                        dataformat="eng" maxlength="5" fullfill caption="Customs"></td>
                    <th colspan="2" width="180px">Send Status&nbsp;&nbsp;&nbsp;
                        <select name="snd_sts" class="input" style="width:60px;">
                        <option value="" selected>All</option>
                        <option value="N">No</option>
                        <option value="Y">Yes</option>
                        </select>
                    </th>
                </tr>
            <tbody>
        </table>
    </div>
</div>

<div class="wrap_result">
    <div class="opus_design_grid">
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
</div>
</form>