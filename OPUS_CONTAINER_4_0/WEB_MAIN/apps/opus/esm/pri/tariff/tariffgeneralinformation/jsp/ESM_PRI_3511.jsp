<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_PRI_3511.jsp
*@FileTitle  : Tariff General Information Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3511Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri3511Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String[] tariffCd         = null;               //Tariff Code
    String[] trfBzcStsCd      = null;               //Status
    
    Logger log = Logger.getLogger("com.clt.apps.Tariff.TariffGeneralInformation");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

        event = (EsmPri3511Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        //COMMBO LIST
        tariffCd         = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TARIFF_CD"));
        trfBzcStsCd      = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("TRF_BZC_STS_CD"), false);

        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
   
    var tariffCdValue           = " |<%=tariffCd[0]%>";
    var tariffCdText            = " |<%=tariffCd[1]%>";
    var trfBzcStsCdComboValue   = " |<%=trfBzcStsCd[0]%>".replace("|R", "");
    var trfBzcStsCdComboText    = " |<%=trfBzcStsCd[1]%>".replace("|Returned",""); 

    
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
<input type="hidden" name="trf_pfx_cd" value="">
<input type="hidden" name="trf_no" value="">

    <!-- page(S) -->
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        
        <!-- page_title(S) -->
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->
    
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
             --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
             --><button type="button" class="btn_normal" name="btn_creation" id="btn_creation">Open Creation</button><!-- 
             --><button type="button" class="btn_normal" name="btn_history" id="btn_history">History</button><!-- 
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
    <!--Page Title, Historical (E)-->   
    
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" style=display:none;>
        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <script type="text/javascript">ComSheetObject('sheet1');</script>
        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>
    <!-- opus_design_grid(E) -->
    
    <div class="wrap_search">   
        <!-- opus_design_inquiry(S) -->
        <div class="opus_design_inquiry wFit" id="mainTable">
            <!--  MiniLayer (S) -->
            <table>
                <colgroup>
                    <col width="80px" />
                    <col width="90px" />
                    <col width="80px" />
                    <col width="80px" />                                
                    <col width="" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Tariff Code</th>
                        <td>
                            <script type="text/javascript">ComComboObject("tariff_cd", 2, 100, 0, 0, 0, false);</script>
                        </td>
                        <th>Status</th>
                        <td>
                            <script type="text/javascript">ComComboObject("trf_bzc_sts_cd", 1, 100, 0, 0, 0, false);</script>
                        </td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="wrap_result">   
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
            <script type="text/javascript">ComSheetObject('sheet2');</script>
            <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
        </div>
        <!-- opus_design_grid(E) -->
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

        <!-- opus_design_inquiry(S) -->
        <div class="opus_design_inquiry wFit">
            <!--  MiniLayer (S) -->
            <table class="search" border="0">
                <tr>
                    <td>
                        <h3 class="title_design">Publishing Information / Tariff Type / Measurement / Currency Information </h3>
                    </td>               
                </tr>
            </table>
            <table>
                <colgroup>
                    <col width="100" />
                    <col width="150" />
                    <col width="100" />
                    <col width="150" />
                    <col width="100" />
                    <col width="150" />
                    <col width="100" />
                    <col width="" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Tariff Code</th>
                        <td>    
                            <input type="text" name="sh_trf_cd" style="width:122px; text-align:center;" class="input2" value="" readonly>
                        </td>
                        <th>Tariff Name</th>
                        <td colspan="5">
                            <input type="text" name="trf_nm" style="width:622px;" class="input2" value="" readonly>
                        </td>                   
                    </tr>
                    <tr>
                        <th>Request Office</th>
                        <td>
                            <input type="text" name="rqst_ofc_cd" style="width:122px; text-align:center;" class="input2" readonly>                  
                        </td>
                        <th>Creation Staff</th>
                        <td>
                            <input type="text" name="cre_usr_id" style="width:129px; text-align:center;" class="input2" readonly>
                        </td>
                        <th>Approval Office</th>
                        <td>
                            <input type="text" name="apro_ofc_cd" style="width:129px; text-align:center;" class="input2" readonly>
                        </td>
                        <th>Amend No.</th>
                        <td>
                            <input type="text" name="amdt_seq" style="width:122px; text-align:center;" class="input2" value="" readonly>
                        </td>
                    </tr>
                    <tr>
                        <th>Effective Date</th>
                        <td>
                            <input type="text" name="eff_dt" maxlength="10" dataformat="ymd" style="width:122px; text-align:center;" class="input2" value="" readonly>
                        </td>
                        <th>Expiration Date</th>
                        <td>
                            <input type="text" name="exp_dt" maxlength="10" dataformat="ymd" style="width:129px; text-align:center;" class="input2" value="" readonly>
                        </td>
                        <th>Publish Date</th>
                        <td>
                            <input type="text" name="pub_dt" maxlength="10" dataformat="ymd" style="width:129px; text-align:center;" class="input2" value="" readonly>
                        </td>
                        <th>Creation Date</th>
                        <td>
                            <input type="text" name="cre_dt" maxlength="10" dataformat="ymd" style="width:122px; text-align:center;" class="input2" readonly>
                        </td>
                    </tr>
                    <tr>
                        <th>Tariff Type</th>
                        <td>
                            <input type="text" name="trf_bzc_tp_cd" style="width:122px; text-align:center;" class="input2" value="" readonly>
                        </td>
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
                        <td>
                            <input type="text" name="curr_cd" style="width:122px; text-align:center;" class="input2" value="" readonly>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
    
        <!-- opus_design_inquiry(S) -->
        <div class="opus_design_inquiry wFit">
            <!--  MiniLayer (S) -->     
            <table class="search" border="0">
                <tr>
                    <td>
                        <h3 class="title_design">Publishing Office</h3>
                    </td>
                </tr>
            </table>
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
                    <col width="88"  />
                    <col width="" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Contact</th>
                        <td>
                            <input type="text" name="pub_cntc_pson_nm" maxlength="50" style="width:145px;" class="input2" value="" readonly>
                        </td>
                        <th>Address</th>
                        <td colspan="5">
                            <input type="text" name="pub_ofc_addr" maxlength="10" style="width:375px;" class="input2" value="" readonly>
                        </td>
                        <th>Phone</th>
                        <td>
                            <input type="text" name="pub_ofc_phn_no" maxlength="20" dataformat="tel" style="width:122px; text-align:center;" class="input2" value="" readonly>
                        </td>
                    </tr>
                    <tr>
                        <th>City</th>
                        <td>
                            <input type="text" name="pub_ofc_cty_nm" maxlength="20" style="width:145px;" class="input2" value="" readonly>
                        </td>
                        <th>State</th>
                        <td>
                            <input type="text" name="pub_ofc_ste_cd" maxlength="3" style="width:85px;" class="input2" value="" readonly>
                        </td>   
                        <th>Zip Code</th>
                        <td>
                            <input type="text" name="pub_ofc_zip_cd" maxlength="10" dataformat="num" style="width:85px;" class="input2" value="" readonly>
                        </td>   
                        <th>Country</th>
                        <td>
                            <input type="text" name="pub_ofc_cnt_nm" maxlength="20" style="width:81px;" class="input2" value="" readonly>
                        </td>   
                        <th>Fax</th>
                        <td>
                            <input type="text" name="pub_ofc_fax_no" maxlength="20" dataformat="tel" style="width:122px; text-align:center;" class="input2" value="" readonly>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
    
        <div class="layout_wrap">
            <table class="search" border="0">
                <tr>
                    <td>
                        <h3 class="title_design">Tariff Scope</h3>
                    </td>
                </tr>
            </table>
            <div class="layout_vertical_2 pad_rgt_8" style="width:49%">
                <!-- opus_design_grid(S) -->
                <div class="opus_design_grid" id="mainTable">             
                    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
                    <script type="text/javascript">ComSheetObject('sheet3');</script>
                    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
                </div>
                <!-- opus_design_grid(E) -->
            </div>
            <div class="layout_vertical_2" style="width:51%">
                <!-- opus_design_grid(S) -->
                <div class="opus_design_grid" id="mainTable">             
                    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
                    <script type="text/javascript">ComSheetObject('sheet4');</script>
                    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
                </div>
                <!-- opus_design_grid(E) -->
            </div>
        </div>
    </div>
<!-- developer performance  end -->
</form>
