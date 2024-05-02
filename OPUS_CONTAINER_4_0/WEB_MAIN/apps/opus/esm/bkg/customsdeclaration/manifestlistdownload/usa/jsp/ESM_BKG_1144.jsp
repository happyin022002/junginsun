<%-- 
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_BKG_1144.jsp
*@FileTitle : Secondary notification & Customs broker nomination
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1144Event"%>
<%@ page import="com.clt.syscommon.common.table.MdmCountryVO" %>
<%@ page import="com.clt.syscommon.common.table.MdmPortVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%
    EsmBkg1144Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id    = "";
    String strUsr_nm    = "";
    String strOfc_cd    = "";

    String strCustCode  = "";
    String strCreOfcCd  = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

        event = (EsmBkg1144Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strCustCode = JSPUtil.getNullNoTrim(request.getParameter("cust_cnt_cd"));
        strCustCode = strCustCode + JSPUtil.getNullNoTrim(request.getParameter("cust_seq"));
        strCreOfcCd = JSPUtil.getNullNoTrim(request.getParameter("ofc_cd"));

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    var userOfficeCode = "<%=strOfc_cd%>";
    function setupPage()
    {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="strCustCntCd">
<input type="hidden" name="strCustSeq">
<input type="hidden" name="strPod">
<input type="hidden" name="strDel">
<input type="hidden" name="strLocCd">

<div class="page_title_area clear">
    <h2 class="page_title">
        <button type="button"><span id="title"></span></button>
    </h2>
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
        <button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
        <button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
        <button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
    </div>
   <div class="location">
        <span id="navigation"></span>
   </div>
</div>

<div class="wrap_search">
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="100px">
                <col width="100px">
                <col width="48px">
                <col width="110px">
                <col width="25px">
                <col width="80px">
                <col width="90px">
                <col width="*">
            </colgroup>
            <tbody>
            <tr>
                <th width="100">Customer Code</th>
                <td width="100">
                    <input type="text" name="cust_cd" style="width:70px; ime-mode: disabled;" class="input" value="<%=strCustCode%>" dataformat="engup" maxlength="8" caption="Customer Code"></td>
                <th width="48">S/C No.</th>
                <td width="110">
                    <input type="text" name="sc_no" style="width:73px; ime-mode: disabled;" class="input"
                                    dataformat="engup" maxlength="9" caption="S/C No."></td>
                <th width="25">POD</th>
                <td width="80"><input type="text" name="pod_cd" style="width:50px; ime-mode: disabled;" class="input"
                                    dataformat="engup" maxlength="5" fullfill caption="POD"></td>
                <th width="25">DEL</th>
                <td width="80"><input type="text" name="del_cd" style="width:50px; ime-mode: disabled;" class="input"
                                    dataformat="engup" maxlength="5" fullfill caption="DEL"></td>
                <th width="90">Create Office</th>
                <td width=""><input type="text" name="cre_ofc_cd" style="width:50px; ime-mode: disabled;" class="input"
                                    value="<%="".equals(strCreOfcCd) ? strOfc_cd : strCreOfcCd%>"
                                    dataformat="engup" minlength="5" maxlength="6" caption="Create Office"></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="wrap_result">
    <div class="opus_design_grid">
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
            <button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">Row Copy</button>
            <button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
        </div>
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
</div>
</form>