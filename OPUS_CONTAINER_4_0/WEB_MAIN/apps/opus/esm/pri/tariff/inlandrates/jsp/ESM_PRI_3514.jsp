<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_3514.jsp
 *@FileTitle  : Inland Rates Creation &amp; Amendment
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3514Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3514Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strRqstOfcCd     = "";
    String trfPfxCd         = "";
    String trfNo            = "";
    String trfInlndSeq      = "";
    String amdtSeq          = "";
    
    String[] trfRuleStsCd = null;           //Status
    String[] aproOfcCd = null;              //Approval Office
    String[] tariffCd = null;               //Tariff Code
    String[] trfInlndAmdtTCd = null;        //Amend Type
    String[] inlndRtTermCd = null;          //Term
    String[] prcRrspModCd = null;           //Trans. Mode
    String[] inlndRtLmtWgtUtCd = null;      //Weght Unit
    String[] prcCgoTpCd = null;             //Type
    String[] srcInfoCd = null;              //Source
    String[] currCd = null;                 //Currency
        
    Logger log = Logger.getLogger("com.clt.apps.Tariff.InlandRates");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRqstOfcCd = account.getOfc_cd();


        event = (EsmPri3514Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        //COMMBO LIST   
        trfRuleStsCd        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_RULE_STS_CD"), false);
        aproOfcCd           = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("APRO_OFC_CD"));
        tariffCd            = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));
    
        trfInlndAmdtTCd     = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_INLND_AMDT_TP_CD"));
        inlndRtTermCd       = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("INLND_RT_TERM_CD"), false);
        prcRrspModCd        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_INLND_RT_TRSP_MOD_CD"), false);
        inlndRtLmtWgtUtCd   = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("INLND_RT_LMT_WGT_UT_CD"));
        prcCgoTpCd          = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_CGO_TP_CD"), false);
        srcInfoCd           = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
        currCd              = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);
                
        trfPfxCd        = JSPUtil.getNull(request.getParameter("trfPfxCd"));
        trfNo           = JSPUtil.getNull(request.getParameter("trfNo"));
        trfInlndSeq     = JSPUtil.getNull(request.getParameter("trfInlndSeq"));
        amdtSeq         = JSPUtil.getNull(request.getParameter("amdtSeq"));
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    var trfRuleStsCdComboValue = "|<%=trfRuleStsCd[0]%>";
    var trfRuleStsCdComboText = "|<%=trfRuleStsCd[1]%>";
    
    var aproOfcCdComboValue = "<%=aproOfcCd[0]%>";
    var aproOfcCdComboText = "<%=aproOfcCd[1]%>";
    
    var tariffCdComboValue = "<%=tariffCd[0]%>";
    var tariffCdComboText = "<%=tariffCd[1]%>";

    var trfInlndAmdtTCdComboValue = "|<%=trfInlndAmdtTCd[0]%>";
    var trfInlndAmdtTCdComboText = "|<%=trfInlndAmdtTCd[1]%>";

    var inlndRtTermCdComboValue = " |<%=inlndRtTermCd[0]%>";
    var inlndRtTermCdComboText = " |<%=inlndRtTermCd[1]%>";

    var prcRrspModCdComboValue = " |<%=prcRrspModCd[0]%>";
    var prcRrspModCdComboText = " |<%=prcRrspModCd[1]%>";

    var inlndRtLmtWgtUtCdComboValue = " |<%=inlndRtLmtWgtUtCd[0]%>";
    var inlndRtLmtWgtUtCdComboText = " |<%=inlndRtLmtWgtUtCd[1]%>";

    var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>";
    var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";

    var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";

    var currCdComboValue = " |<%=currCd[0]%>";
    var currCdComboText = " |<%=currCd[1]%>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd"                                   id="f_cmd" />
<input type="hidden" name="pagerows"                                id="pagerows" />
<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd%>"        id="trf_pfx_cd" />
<input type="hidden" name="trf_no" value="<%=trfNo%>"               id="trf_no" />
<input type="hidden" name="trf_inlnd_seq" value="<%=trfInlndSeq%>"  id="trf_inlnd_seq" />
<input type="hidden" name="ofc_cd" value="<%=strRqstOfcCd%>"        id="ofc_cd" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>"           id="usr_id" />
<input type="hidden" name=trf_cd_nm value=""                        id="trf_cd_nm" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
           <button type="button" class="btn_accent" name="btn_retrieve"     id="btn_retrieve">Retrieve</button><!-- 
        --><button type="button" class="btn_normal" name="btn_new"          id="btn_new">New</button><!-- 
        --><button type="button" class="btn_normal" name="btn_amend"        id="btn_amend">Amend</button><!-- 
        --><button type="button" class="btn_normal" name="btn_save"         id="btn_save">Save</button><!-- 
        --><button type="button" class="btn_normal" name="btn_delete"       id="btn_delete">Delete</button><!-- 
        --><button type="button" class="btn_normal" name="btn_request"      id="btn_request">Request</button><!-- 
        --><button type="button" class="btn_normal" name="btn_approve"      id="btn_approve">Approve</button><!-- 
        --><button type="button" class="btn_normal" name="btn_publish"      id="btn_publish">Publish</button><!-- 
        --><button type="button" class="btn_normal" name="btn_cancel"       id="btn_cancel">Cancel</button><!-- 
        --><button type="button" class="btn_normal" name="btn_downexcel"    id="btn_downexcel">Down Excel</button><!-- 
        --><button type="button" class="btn_normal" name="btn_loadexcel"    id="btn_loadexcel">Load Excel</button>
    </div>
    <!-- opus_design_btn(E) -->

    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
</div>
<!-- page_title_area(E) -->

<!-- Hidden sheet for Transaction (S) -->
<div style="display:none;"> 
    <script type="text/javascript">ComSheetObject('sheet1');</script>       
</div>
<!-- Hidden sheet for Transaction (E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
    <div class="opus_design_inquiry wFit">
        <table>
           <colgroup>
               <col width="115px">
               <col width="150px">
               <col width="90px">
               <col width="650px">
               <col width="*">
           </colgroup>
           <tbody>
                <tr>
                    <th>Tariff Code</th>
                    <td><script type="text/javascript">ComComboObject("tariff_cd", 2, 110, 0, 1, 0, false);</script></td>
                    <th>Tariff Name</th>
                    <td><input type="text" name="trf_nm" id="trf_nm" style="width:645px;" class="input2" value="" readonly></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        <table>
           <colgroup>
               <col width="115">
               <col width="430">
               <col width="80">
               <col width="80">
               <col width="60">
               <col width="84">
               <col width="50">
               <col width="100">
               <col width="*">
           </colgroup>
           <tbody>
                <tr>
                    <th>Inland Rates Name</th>
                    <td><script type="text/javascript">ComComboObject("inlnd_cd", 1, 400, 0, 1, 0, true);</script></td>
                    <th>Amend Type</th>
                    <td><script type="text/javascript">ComComboObject("trf_inlnd_amdt_tp_cd", 2, 50, 0, 0, 0, false);</script></td>
                    <th>Amend No.</th>
                    <td><input type="text" name="amdt_seq" id="amdt_seq" maxlength="20" style="width:60px;text-align:center;" class="input2" value="" readonly></td>
                    <th>Status</th>
                    <td><input type="text" name="trf_inlnd_sts_nm" id="trf_inlnd_sts_nm" style="width:90px;text-align:center;" class="input2" value="" readonly></td>
                    <td></td>               
                </tr>
            </tbody>
        </table>
    </div>

</div>

<div class="wrap_result">
    <div class="opus_design_data wFit">    
        <table>
           <colgroup>
               <col width="115">
               <col width="110">
               <col width="100">
               <col width="140">
               <col width="100">
               <col width="140">
               <col width="80">
               <col width="140">
               <col width="*">
           </colgroup>
           <tbody>
                <tr>
                    <td colspan="9"><h3 class="title_design">Publishing Information</h3></td>
                </tr>
                <tr>
                    <th>Creation Date</th>
                    <td><input type="text" name="cre_dt" maxlength="10" dataformat="ymd" style="width:100px; text-align:center;" class="input2" readonly></td>
                    <th>Effective Date</th>
                    <td><input type="text" name="eff_dt" maxlength="10" dataformat="ymd" style="width:100px; text-align:center;" class="input1" value="" required caption="Effective Date">
                    	<!-- <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar1" class="cursor"> -->
                    	<button type="button" class="calendar" name="btns_calendar1" id="btns_calendar1"></button></td>
                    <th>Expiration Date</th>
                    <td><input type="text" name="exp_dt" id="exp_dt" maxlength="10" dataformat="ymd" style="width:100px; text-align:center;" class="input" value="">
                    	<!-- <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar2" class="cursor"> -->
                    	<button type="button" class="calendar" name="btns_calendar2" id="btns_calendar2"></button></td>
                    <th>Publish Date</th>
                    <td><input type="text" name="pub_dt" id="pub_dt" maxlength="10" dataformat="ymd" style="width:130px; text-align:center;" class="input2" value="" readonly></td>
                    <td></td>
                </tr>
                <tr >
                    <th>Request Office</th>
                    <td><input type="text" name="rqst_ofc_cd" style="width:100px; text-align:center;" class="input2" value="" readonly></td>
                    <th>Creation Staff</th>
                    <td><input type="text" name="cre_usr_id" style="width:100px; text-align:center;" class="input2" value="" readonly></td>
                    <th>Approval Office</th>
                    <td><script type="text/javascript">ComComboObject('apro_ofc_cd', 2, 100, 0, 1);</script></td>
                    <th>Attached File</th>
                    <td style="padding-top:5px;padding-bottom:5px;"><div style="width:300px"><script type="text/javascript">ComSheetObjectInput('sheet2');</script></div></td>
                    <td style="padding-left:5px;"><button type="button" class="btn_etc" name="btn_fileadd" id="btn_fileadd" style="display:none;">Add</button>
                        <button type="button" class="btn_etc" name="btn_filedelete" id="btn_filedelete" style="display:none;">Del.</button>
                    </td>
                </tr>
            </tbody>
        </table>    
    </div>
    <!-- opus_design_inquiry(E) -->
    
    <table class="line_bluedot"><tr><td></td></tr></table>
    
    <!-- opus_design_grid(S) -->    
    <div class="opus_design_grid">
 <!-- 수정후 요부분 삭제!   	 --><!-- <script type="text/javascript">ComSheetObjectInput('sheet2');</script> -->
        <div class="opus_design_data wFit">
        <table>
           <colgroup>
               <col width="300" />
               <col width="200" />
               <col width="150" />
               <col width="190" />
               <col width="" />
           </colgroup>
           <tbody>
                <tr>
                    <td><h3 class="title_design">Location Information (by Inland Name)</h3></td>
                    
                    <th><input type="checkbox" name="search_view_yn" value="Y" class="trans" id="search_view_yn"><label for="search_view_yn" >View Amend Delete</label></th>
                    <th>Search Location</th>
                    <td><input type="text" name="search_row" maxlength="50" style="width:190px;" class="input" value="" dataformat="engup" ></td>
                    <td><button type="button" class="btn_etc" name="btn_rowsearch" id="btn_rowsearch">Retrieve</button></td>
                </tr>
            </tbody>
        </table>
        </div>
        <div class="opus_design_btn"><!-- 
             --><button type="button" class="btn_accent" name="btn_rowadd"      id="btn_rowadd">Row Add</button><!--        
            --><button type="button" class="btn_accent" name="btn_rowdelete"    id="btn_rowdelete">Delete</button><!-- 
            --><button type="button" class="btn_accent" name="btn_rowamend"     id="btn_rowamend">Amend</button><!-- 
            --><button type="button" class="btn_accent" name="btn_amendcancel" id="btn_amendcancel">Amend Cancel</button><!-- 
        --></div>   
        <script type="text/javascript">ComSheetObject('sheet3');</script>
    </div>
</div>
<br>
<!-- opus_design_grid(E) -->
<div class="opus_design_grid" style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet4');</script>
</div>
</form>
<div class="opus_design_grid" style="display:none;">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>