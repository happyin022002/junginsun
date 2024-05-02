<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0013.jsp
*@FileTitle  : CndManifestListDownload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0013Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
    EsmBkg0013Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    boolean isCA_Usr = true;
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmBkg0013Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // If you imported data from the server initialization when loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){
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

<!-- 제목 -->
<div class="page_title_area clear">
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->

        <!-- btn_div -->
   <div class="opus_design_btn">
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
	--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
	--><button type="button" class="btn_normal" name="btn_create" id="btn_create">CRN Create</button><!--
	--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">CRN Delete</button>
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
        <table>
            <colgroup>
                <col width="30px">
                <col width="130px">
                <col width="30px">
                <col width="290px">
                <col width="30px">
                <col width="130px">
                <col width="50px">
                <col width="*">
            </colgroup>
            <tbody>         
            <tr>
                <th width="30px">POD</th>
                <td width="130px"><input type="text"
                    style="width: 90px; ime-mode: disabled" class="input"
                    dataformat="engup" name="vps_port_cd" maxlength="5" caption="POD"></td>
                <th width="30px">ETA</th>
                <td width="290px"><input type="text"
                    style="width: 75px; ime-mode: disabled" class="input" maxlength="10"
                    dataformat="ymd" name="s_vps_eta_dt" caption="ETA" cofield="e_vps_eta_dt">
                &nbsp;~&nbsp; <input type="text"
                    style="width: 90px; ime-mode: disabled" class="input" maxlength="10"
                    dataformat="ymd" name="e_vps_eta_dt" caption="ETA" cofield="s_vps_eta_dt">
                    <button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
                </td>
                <th width="30px">Lane</th>
                <td width="130px"><input type="text"
                    style="width: 90px; ime-mode: disabled" dataformat="engup"
                    class="input" name="slan_cd" maxlength="3" caption="Lane"></td>
                <th width="50px">Operator</th>
                <td width=""><input type="text"
                    style="width: 90px; ime-mode: disabled" dataformat="engup"
                    class="input" name="crr_cd" maxlength="4" caption="Operator"></td>
            </tr>
            <tr>
                <th width="">VVD</th>
                <td width=""><input type="text"
                    style="width: 90px; ime-mode: disabled" dataformat="engup"
                    class="input" name="vvd_cd" maxlength="9" caption="VVD"></td>
                <th width="">CRN</th>
                <td width="" colspan="5"><input type="text"
                    style="width: 200px; ime-mode: disabled" dataformat="engup"
                    class="input" name="cvy_ref_no" maxlength="20" caption="CRN"></td>
            </tr> 
            </tbody>
        </table>
</div>
</div>
<!-- 검색영역 -->           

<div class="wrap_result">  
<div class="opus_design_grid">  
    <script language="javascript">ComSheetObject('sheet1');</script>
</div>
</div>

</form>
