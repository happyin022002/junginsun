<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3504.jsp
*@FileTitle : Tariff General Information History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3504Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3504Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    String[] tariffCd = null;               //Tariff Code
    String   trfPfxCd       = null;             
    String   trfNo          = null;             
    
    Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffGeneralInformation");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri3504Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        trfPfxCd = JSPUtil.getNull(request.getParameter("trfPfxCd"));
        trfNo = JSPUtil.getNull(request.getParameter("trfNo"));

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        //COMMBO LIST       
        tariffCd        = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script language="javascript">
    var tariffCdComboValue = "<%=tariffCd[0]%>";
    var tariffCdComboText = "<%=tariffCd[1]%>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd%>">
<input type="hidden" name="trf_no" value="<%=trfNo%>">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
    
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
         
   
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
        --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
    </div>
    <!-- opus_design_btn(E) -->
    
    
    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <table>
            <colgroup>
                <col width="75px"  />
                <col width="120px" />
                <col width="80px"  />
                <col width="500px" />
                <col width="75px"  />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Tariff Code</th>
                    <td><script language="javascript">ComComboObject("tariff_cd", 2, 100, 0, 0, 0, false);</script></td>
                    <th>Tariff Name</th>
                    <td><input type="text" name="trf_nm_title" style="width:470px" class="input2"  value=""  readonly></td> 
                    <th>Access Date</th>
                    <td>
                        <input type="text" name="access_dt" style="width:80px;text-align:center;" class="input" value="" caption="Access Date" maxlength="10" dataformat="ymd" ><!--
                        --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
                    </td>
                </tr>
            </tbody>
        </table>
        <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        
    </div>
    <!-- opus_design_inquiry(E) -->
</div>  
    
<div class="wrap_result">
    <div class="opus_design_grid">
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script language="javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <table><tr><td height="5px"></td></tr></table>
        <script language="javascript">ComSheetObject('sheet2');</script>
    </div>
    <!-- opus_design_grid(E) -->
    
    <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
    
    <!-- data_area(S) -->
    <div class="opus_design_inquiry">
        <h3 class="title_design">Publishing Information / Tariff Type / Measurement / Currency Information </h3>
        <table>
            <colgroup>
                <col width="100px" />
                <col width="150px" />
                <col width="100px" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Tariff Code</th>
                    <td><input type="text" name="sh_trf_cd" style="width:122px; text-align:center;" class="input2" value="" readonly></td>
                    <th>Tariff Name</th>
                    <td><input type="text" name="trf_nm" style="width:623px;" class="input2" value="" readonly></td>
                </tr>
            </tbody>
        </table>
        <table>
            <colgroup>
                <col width="100px" />
                <col width="150px" />
                <col width="100px" />
                <col width="150px" />
                <col width="100px" />
                <col width="150px" />
                <col width="100px" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Request Office</th>
                    <td><input type="text" name="rqst_ofc_cd" style="width:122px; text-align:center;" class="input2" readonly></td>
                    <th>Creation Staff</th>
                    <td><input type="text" name="cre_usr_id" style="width:129px; text-align:center;" class="input2" readonly></td>
                    <th>Approval Office</th>
                    <td><input type="text" name="apro_ofc_cd" style="width:129px; text-align:center;" class="input2" readonly></td>
                    <th>Amend No.</th>
                    <td><input type="text" name="amdt_seq" style="width:122px; text-align:center;" class="input2" value="" readonly></td>
                </tr>
            </tbody>
        </table>
        <table>
            <colgroup>
                <col width="100px" />
                <col width="150px" />
                <col width="100px" />
                <col width="150px" />
                <col width="100px" />
                <col width="150px" />
                <col width="100px" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Effective Date</th>
                    <td><input type="text" name="eff_dt" maxlength="10" dataformat="ymd" style="width:122px; text-align:center;" class="input2" value="" readonly></td>
                    <th>Expiration Date</th>
                    <td><input type="text" name="exp_dt" maxlength="10" dataformat="ymd" style="width:129px; text-align:center;" class="input2" value="" readonly></td>
                    <th>Publish Date</th>
                    <td><input type="text" name="pub_dt" maxlength="10" dataformat="ymd" style="width:129px; text-align:center;" class="input2" value="" readonly></td>
                    <th>Creation Date</th>
                    <td><input type="text" name="cre_dt" maxlength="10" dataformat="ymd" style="width:122px; text-align:center;" class="input2" readonly></td>
                </tr>
            </tbody>
        </table>
        <table>
            <colgroup>
                <col width="100px" />
                <col width="150px" />
                <col width="100px" />
                <col width="150px" />
                <col width="100px" />
                <col width="150px" />
                <col width="100px" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Tariff Type</th>
                    <td><input type="text" name="trf_bzc_tp_cd" style="width:122px; text-align:center;" class="input2" value="" readonly></td>
                    <th>Weight Ton</th>
                    <td>
                        <input type="text" name="trf_bzc_wgt" dataformat="float" style="width:90px; text-align:right;" class="input2" value="" readonly><!--
                        --><input type="text" name="trf_bzc_wgt_ut_cd" style="width:35px; text-align:center;" class="input2" value="" readonly>
                    </td>
                    <th>Volume Ton</th>
                    <td>
                        <input type="text" name="trf_bzc_vol_qty" dataformat="float" style="width:90px; text-align:right;" class="input2" value="" readonly><!--
                        --><input type="text" name="trf_bzc_vol_ut_cd" style="width:35px; text-align:center;" class="input2" value="" readonly>
                    </td>
                    <th>Currency</th>
                    <td><input type="text" name="curr_cd" style="width:122px; text-align:center;" class="input2" value="" readonly></td>
                </tr>
            </tbody>
        </table>
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
        
        <h3 class="title_design">Publishing Office</h3>

        <table>
            <colgroup>
                <col width="100" />
                <col width="150" />
                <col width="100" />
                <col width="90"  />
                <col width="55"  />
                <col width="90"  />
                <col width="55"  />
                <col width="115" />
                <col width="90"  />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Contact</th>
                    <td><input type="text" name="pub_cntc_pson_nm" maxlength="50" style="width:122px;" class="input2" value="" readonly></td>
                    <th>Address</th>
                    <td colspan="5"><input type="text" name="pub_ofc_addr" maxlength="10" style="width:375px;" class="input2" value="" readonly></td>
                    <th>Phone</th>
                    <td><input type="text" name="pub_ofc_phn_no" maxlength="20" dataformat="tel" style="width:122px; text-align:center;" class="input2" value="" readonly></td>
                </tr>
                <tr>
                    <th>City</th>
                    <td><input type="text" name="pub_ofc_cty_nm" maxlength="20" style="width:122px;" class="input2" value="" readonly></td>
                    <th>State</th>
                    <td><input type="text" name="pub_ofc_ste_cd" maxlength="3" style="width:85px;" class="input2" value="" readonly></td>
                    <th>Zip Code</th>
                    <td><input type="text" name="pub_ofc_zip_cd" maxlength="10" dataformat="num" style="width:85px;" class="input2" value="" readonly></td>
                    <th>Country</th>
                    <td><input type="text" name="pub_ofc_cnt_nm" maxlength="20" style="width:81px;" class="input2" value="" readonly></td>
                    <th>Fax</th>
                    <td><input type="text" name="pub_ofc_fax_no" maxlength="20" dataformat="tel" style="width:122px; text-align:center;" class="input2" value="" readonly></td>
                </tr>
            </tbody>
        </table>

        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
    
        <div class="layout_wrap">
            <h3 class="title_design">Tariff Scope</h3>
            <div class="layout_vertical_2 opus_design_inquiry">
                <!-- opus_design_grid(S) -->
                <div class="opus_design_grid" id="mainTable" style="width:99%">             
                    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
                    <script language="javascript">ComSheetObject('sheet3');</script>
                    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
                </div>
                <!-- opus_design_grid(E) -->
            </div>
            <div class="layout_vertical_2 opus_design_inquiry">
                <!-- opus_design_grid(S) -->
                <div class="opus_design_grid" id="mainTable" style="width:99%">             
                    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
                    <script language="javascript">ComSheetObject('sheet4');</script>
                    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
                </div>
                <!-- opus_design_grid(E) -->
            </div>
        </div>
    </div>
</div>
</form>