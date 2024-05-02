<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1125.jsp
*@FileTitle : CANADA ACI : ACI Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.07.13 김봉균
* 1.0 Creation 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg1125Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1125Event  event = null;
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    Logger log = Logger.getLogger("com.clt.opus.CustomsDeclaration.CustomsReport");

    try {
           SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

        event = (EsmBkg1125Event)request.getAttribute("Event");
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
<input type="hidden" name="call_type" value="ESM_BKG_1125">


<div class="page_title_area clear">
    <h2 class="page_title">
        <button type="button"><span id="title"></span></button>
    </h2>
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
        <button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
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
                <col width="180px">
                <col width="330px">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <td width="180">
                        <input type="radio" name="p_date_gb" value="B" class="trans" checked>POL ETB &nbsp
                        <input type="radio" name="p_date_gb" value="A"   class="trans">POD ETA</td>
                    <td width="330">
                        <input type="text" style="width:80px" value="" class="input1"  name="p_from_dt"  maxlength='10' dataformat="ymd" >
                        <input type="text" name="p_from_mt" style="width:40px" value="00:00" class="input1" dataformat="hm"  maxlength="5" required>
                         &nbsp;~&nbsp;
                        <input type="text" style="width:80px" value="" class="input1"  name="p_to_dt"  maxlength='10' dataformat="ymd" >
                        <input type="text" name="p_to_mt" style="width:40px" value="23:59" class="input1" dataformat="hm"  maxlength="5" required >
                        <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_date">
                    </td>
                    <td width="*">
                        <input type="radio" name="p_rhq_gb" value="PO" class="trans" checked>POL(T/S) Office &nbsp
                        <input type="radio" name="p_rhq_gb" value="BO"   class="trans">BKG Office</td>
                </tr>
            </tbody>
        </table>
        <table>
            <colgroup>
                <col width="30px">
                <col width="90px">
                <col width="65px">
                <col width="90px">
                <col width="40px">
                <col width="116px">
                <col width="50px">
                <col width="85px">
                <col width="50px">
                <col width="120px">
                <col width="70px">
                <col width="100px">
                <col width="30px">
                <col width="70px">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th width="30">RHQ</th>
                    <td width="90">
                        <script type="text/javascript">ComComboObject('rhq', 1, 70, 1, 0, 0, false);</script>
                    </td>
                    <th style="display:inline" id="p_pol_ofc">POL OFC</th>
                    <th style="display:none" id="p_bkg_ofc">BKG OFC</th>
                    
                    <td width="90"><input type="text" style="width:70px;" class="input" name="p_b_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled"></td>
                    <th>POL</th>
                    <td width="116"><input type="text" style="width:60px;" class="input" name="p_pol" value="" maxlength='5' dataformat='engup' style="ime-mode:disabled" >
                               &nbsp<input type="text" style="width:25px"  class="input" name="p_pol_yd"  value=""  maxlength='2' dataformat='engup' style="ime-mode:disabled">
                    </td>
                    <th width="50">POD</th>
                    <td width="85"><input type="text" style="width:65px;" class="input" name="p_pod" maxlength='5' dataformat='engup' style="ime-mode:disabled"></td>
                    <th width="50"> &nbsp;&nbsp;VVD</th>
                    <td width="120"><input type="text" style="width:80px;" class="input" name="p_vvd" value=""  maxlength='9' dataformat='engup' style="ime-mode:disabled"></td>
                    <th width="70">BL Type</th>
                    <td width="100">
                        <select name="p_bl_type" class="input" style="width:70px;">
                        <option value="" selected></option>
                        <option value="M">Master</option>
                        <option value="H">House</option>
                        </select></td>
                    <td width="30"></td>
                    <td width="70"></td>
                    <td width="150"></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="wrap_result">
    <div class="opus_design_grid">
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
</div>

<div class="wrap_search">
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="120px">
                <col width="20px">
                
                <col width="50px">
                <col width="50px">
                <col width="20px">
                
                <col width="55px">
                <col width="50px">
                <col width="20px">
                
                <col width="70px">
                <col width="50px">
                <col width="20px">
                
                <col width="70px">
                <col width="50px">
                <col width="20px">
                
                <col width="60px">
                <col width="50px">
                <col width="20px">
                
                <col width="70px">
                <col width="50px">
                <col width="20px">
                <col width="70px">
                <col width="*">
            </colgroup>
            <tbody>
            <tr>
            <th>Total B/L</th>
            <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_total_bl_cnt" readonly></td>
            <td align='center'> = </td>
            <th>Accept</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_acc_bl_cnt" readonly></td>
            <td align='center'> + </td>
            <th style='color:red'>Rejected</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_rej_bl_cnt" readonly style='color:red'></td>
            <td align='center'> + </td>
            <th style='color:red'>Not-received</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_nrcv_bl_cnt" readonly style='color:red'></td>
            <td align='center'> + </td>
            <th style='color:red'>Do Not Load</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_donld_bl_cnt" readonly style='color:red'></td>
            <td align='center'> + </td>
            <th style='color:red'>Release</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_rlse_bl_cnt" readonly style='color:red'></td>
            <td align='center'> + </td>
            <th style='color:red'>Un-Sent B/L</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_unsent_bl_cnt" readonly style='color:red'></td>
            <td align='center'> + </td>
            <th style='color:red'>POD IRR.</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_podirr_bl_cnt" readonly style='color:red'></td>
            </tr>
            
            <tr>
            <th>Total CMS (USD)</th>
            <td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_total_cms_cnt" readonly></td>
            <td align='center'> = </td>
            <th>SHAAS</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_total_shaas_ens" readonly></td>
            <td align='center'> + </td>
            <th>NYCNA</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_total_nycna_ens" readonly></td>
            <td align='center'> + </td>
            <th>HAMUR</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_total_hamur_ens" readonly></td>
            <td align='center'> + </td>
            <th>SINWA</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_total_sinwa_ens" readonly></td>
            <th colspan="2">VVD</th>
            <td colspan="7"><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_total_vvd_cnt" readonly></td>
            </tr>
            
            
            <tr>
            <th>Total MCF (USD)</th>
            <td><input type="text" style="width:60px;text-align:right;" value="" class="input2"  name="div_total_mcf_amt" readonly></td>
            <td align='center'> = </td>
            <th>SHAAS</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_total_shaas_mcf" readonly></td>
            <td align='center'> + </td>
            <th>NYCNA</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_total_nycna_mcf" readonly></td>
            <td align='center'> + </td>
            <th>HAMUR</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_total_hamur_mcf" readonly></td>
            <td align='center'> + </td>
            <th>SINWA</th>
            <td><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_total_sinwa_mcf" readonly></td>
            <th colspan="2">ACI Amendment</th>
            <td colspan="7"><input type="text" style="width:50px;text-align:right;" value="" class="input2"  name="div_total_amd_cnt" readonly></td>
            </tr>
            
            </tbody>
        </table>
         
    </div>
</div>

<table>
    <tr>
        <td> * MCF surcharge should be rated for ACI amendment regardless of BDR.</td>
    </tr>
</table>

</form>