<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0009.jsp
*@FileTitle  : Creation MT unit price of standard & MT Turntime by ECC 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.mtcost.event.EsmCoa0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
    EsmCoa0009Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String xml          = "";
    
    //Variable
    String f_cost_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
    String f_cntr_tpsz_cd = JSPUtil.getNullNoTrim(request.getParameter("f_cntr_tpsz_cd"));
    String f_cost_loc_grp_cd = JSPUtil.getNullNoTrim(request.getParameter("f_cost_loc_grp_cd"));
    if("".equals(f_cost_loc_grp_cd)) f_cost_loc_grp_cd = "E";
    String f_ecc_cd = JSPUtil.getNullNoTrim(request.getParameter("f_ecc_cd"));
    String f_lcc_cd = JSPUtil.getNullNoTrim(request.getParameter("f_lcc_cd"));
    String f_rcc_cd = JSPUtil.getNullNoTrim(request.getParameter("f_rcc_cd"));
    
    Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.MTCost");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmCoa0009Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
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
        ComSetFocus(document.form.f_cost_yrmon);
    }
</script>

<form name="form" onKeyDown="changeSearchSheet();" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="f_cntr_tpsz_cd2" value="">
<input type="hidden" name="f_cntr_tpsz_cd3" value="">
<input type="hidden" name="p_cost_yrmon" value="">
<input type="hidden" name="p_fcntr_ecc_cd" value="">
<input type="hidden" name="p_cntr_tpsz_cd" value="">
<input type="hidden" name="p_cntr_io_vol_sts_cd" value="">
<input type="hidden" name="p_ori_dest" value="">
<input type="hidden" name="f_fm_mon" value="">
<input type="hidden" name="f_to_mon" value="">
<input type="hidden" name="sXml" value="<%= xml%>">


<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_DownExcel"   id="btn_DownExcel">Down Excel</button>
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
    
<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
        <table>
             <colgroup>
                <col width="70"  />
                <col width="80"  />
                <col width="150" />
                <col width="80"  />
                <col width="70"  />
                <col width="180" />
                <col width="70"  />
                <col width="" />
            </colgrou> 
            <tbody>
                <tr>
                    <th>YYYY-MM</th>
                    <td><input type="text" name="f_cost_yrmon" class="input1" style="width:60px;" value="" maxlength="6" dataformat="ym" onKeyDown="ComKeyEnter();" onfocus="this.value=ComReplaceStr(this.value, '-', '');" onblur="addDash(this , 4);" id="f_cost_yrmon" /></td>
                    <th>Location Hierarchy</th>
                    <td><script type="text/javascript">ComComboObject('f_cost_loc_grp_cd', 1, 70 , 0 )</script></td>
                    <th id="div_combo_title">ECC</th>
                    <td>
                        <div id="div_ecc" style="display:inline;">
                            <script type="text/javascript">ComComboObject('f_ecc_cd', 1, 70 , 0 )</script>
                        </div>
                        <div id="div_lcc" style="display:none">
                            <script type="text/javascript">ComComboObject('f_lcc_cd', 1, 70 , 0 )</script>
                        </div>
                        <div id="div_rcc" style="display:none">
                            <script type="text/javascript">ComComboObject('f_rcc_cd', 1, 70 , 0 )</script>
                        </div>
                    </td>
                    <th>Type/Size</th>
                    <td><script type="text/javascript">ComComboObject('f_cntr_tpsz_cd', 1, 70 , 0 )</script></td>
                </tr>
            </tbody>
        </table>
        <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
	<h3 class="title_design">Full Repo. Unit Cost Inquiry (Per Full Vol.)</h3>
    <!-- : ( Full Based ) (S) -->
    <div style="display:none;"><!-- Remove display:none if you use Simulated MT Repo -->
        <table class="mar_btm_8">
            <tr>
                <td width="100%">
                    <input type="radio" name="kind" id="kind1" value="1" class="trans" onClick="changeSheet(this.value);" checked><label for="kind1">ull Based</label><!--
                    --><input type="radio" name="kind" id="kind2" value="2" class="trans" onClick="changeSheet(this.value);"><label for="kind2">MT Repo Simulated</label>
                </td>
                <td align="right" valign="bottom" class=" " style="width:60px">
                    <a href="javascript:ComOpenPopup('/opuscntr/COM_ENS_051.do', 850, 520,  '', '1,0,1,1,1,1,1,1,1,1,1,1', true);" class="purple">Location</a>
                </td>
                <td align="right" class="gray" style="width:30px">(USD)</td>
            </tr>
        </table>
    </div>
    <!-- : ( Full Based ) (E) -->
        
    <!-- : location link Added (S) -->
    <div id="mainTable">
        <!-- : location link Added -->
        <table class="mar_btm_8" border="0" style="width:100%;">
            <tr>
                <td align="right" width="100%" valign="bottom" class=" ">
                    <a href="javascript:ComOpenPopup('/opuscntr/COM_ENS_051.do', 850, 520,  '', '1,0,1,1,1,1,1,1,1,1,1,1', true);" class="purple">Location</a>&nbsp;
                </td>
                <td class="gray">(USD)</td>
            </tr>
        </table>
    </div>
    <!-- : location link Added (S) -->

    <!----------------------------------------------------------------- MT Start ---------------------------------------------------------->
    <div id = "div_mt" style="display:none">
        <div id="mt_ecc_sheet" style="display:<%="R".equals(f_cost_loc_grp_cd)?"none":"inline"%>">
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid"  id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet1');</script>

                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_EccStatus1" id="btng_EccStatus1">ECC Status</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->
            
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid"  id="mainTable">
            	<h3 class="title_design pad_btm_8">ECC Status</h3>
                <script type="text/javascript">ComSheetObject('sheet2');</script>
                
                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_RouteDetail1" id="btng_RouteDetail1">Route Detail 1</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->
            
                
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid"  id="mainTable">
                <div class="opus_design_inquiry">
                    <table class="search" border="0">
                    <colgroup>
                        <col width="30"  />
                        <col width="80"  />
                        <col width="" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>ECC</th>
                            <td><input type="text" name="f_ecc_cd2" value="" style="width:60px" disabled class="input2"></td>
                            <td>
                                <input type="radio" name="f_ori_dest" id="f_ori_dest11" value="0" class="trans" onClick="reSearch();"><label for="f_ori_dest11">Origin (From)</label><!--
                                --><input type="radio" name="f_ori_dest" id="f_ori_dest12" value="1" class="trans" onClick="reSearch();"><label for="f_ori_dest12">Destination (To)</label>
                            </td>
                        </tr>
                    </table>
                </div>

                <script type="text/javascript">ComSheetObject('sheet3');</script>
                
                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_RouteDetail2" id="btng_RouteDetail2">Route Detail 2</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->
        </div>
    
        <!-- LCC start-->
        <div id="mt_lcc_sheet" style="display:<%="L".equals(f_cost_loc_grp_cd)?"inline":"none"%>">
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid"  id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet4');</script>

                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_LccStatus1" id="btng_LccStatus1">LCC Status</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->
        
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid"  id="mainTable">
            	<h3 class="title_design">LCC Status</h3>
                <script type="text/javascript">ComSheetObject('sheet5');</script>
                
                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_RouteDetail2" id="btng_RouteDetail2">Route Detail 2</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->
       </div>
        <!-- LCC end-->
    
        <!-- RCC start-->
        <div id="mt_rcc_sheet" style="display:<%="R".equals(f_cost_loc_grp_cd)?"inline":"none"%>">
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid"  id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet6');</script>

                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_RccStatus1" id="btng_RccStatus1">RCC Status</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->
    
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid"  id="mainTable">
                <h3 class="title_design">RCC Status</h3>

                <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
                <script type="text/javascript">ComSheetObject('sheet7');</script>

                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_RouteDetail2" id="btng_RouteDetail2">Route Detail 2</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->
        </div>
        <!-- RCC end-->
    </div>
    <!-----------------------------------------------------------------  MT End   ---------------------------------------------------------->

    <!----------------------------------------------------------------- Full Start --------------------------------------------------------->
    <div id = "div_full" style="display:inline">
        <!-- full_ecc_sheet -------------------------------------------------------------------------------------------->
        <div id="full_ecc_sheet" style="display:<%="R".equals(f_cost_loc_grp_cd)?"none":"inline"%>">
            <div class="opus_design_grid"  id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet8');</script>

                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_EccStatus2" id="btng_EccStatus2">ECC Status</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->
            
            <!-- opus_design_grid(S) -->
            <h3 class="title_design pad_btm_8">ECC Status</h3>
            <div class="opus_design_grid"  id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet9');</script>
                
                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_RouteDetail3" id="btng_RouteDetail3">Route Detail 1</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->


            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid"  id="mainTable">
                <div class="opus_design_inquiry">
                    <table>
                        <colgroup>
                            <col width="30"  />
                            <col width="80"  />
                            <col width="" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>ECC</th>
                                <td><input type="text" name="f_ecc_cd3" value="" style="width:60px" disabled class="input2"></td>
                                <td>
                                    <input type="radio" name="f_ori_dest2" id="f_ori_dest21" value="0" class="trans"  onClick="reSearch2();"><label for="f_ori_dest21">Origin (From)</label><!--
                                    --><input type="radio" name="f_ori_dest2" id="f_ori_dest22" value="1" class="trans" onClick="reSearch2();"><label for="f_ori_dest22">Destination (To)</label>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <script type="text/javascript">ComSheetObject('sheet10');</script>

                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_RouteDetail4" id="btng_RouteDetail4">Route Detail 2</button>
                </div>
                
            </div>
            <!-- opus_design_grid(E) -->
        </div>
        <!-- full_ecc_sheet -------------------------------------------------------------------------------------------->

        <!-- LCC start -------------------------------------------------------------------------------------------->
        <div id="full_lcc_sheet" style="display:<%="L".equals(f_cost_loc_grp_cd)?"inline":"none"%>">
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid"  id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet11');</script>

                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_LccStatus2" id="btng_LccStatus2">LCC Status</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->

            <!-- opus_design_grid(S) -->
            <h3 class="title_design">LCC Status</h3>
            <div class="opus_design_grid"  id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet12');</script> 
            </div>
            <!-- opus_design_grid(E) -->
        </div>
        <!-- LCC end -------------------------------------------------------------------------------------------->
    
        <!-- RCC start -------------------------------------------------------------------------------------------->
        <div id="full_rcc_sheet" style="display:<%="R".equals(f_cost_loc_grp_cd)?"inline":"none"%>">
            <!-- opus_design_grid(S) -->
            <div class="opus_design_grid"  id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet13');</script>
                
                <div style="text-align:right; margin-top:4px;">
                    <button type="button" class="btn_etc" name="btng_RccStatus2" id="btng_RccStatus2">RCC Status</button>
                </div>
            </div>
            <!-- opus_design_grid(E) -->
            

            <!-- opus_design_grid(S) -->
            <h3 class="title_design">RCC Status</h3>
            <div class="opus_design_grid"  id="mainTable">
                <script type="text/javascript">ComSheetObject('sheet14');</script>
            </div>
            <!-- opus_design_grid(E) -->
        </div>
        <!-- RCC end -------------------------------------------------------------------------------------------->
    </div>
    <!----------------------------------------------------------------- Full End  ----------------------------------------------------------> 
</div>
<!-- wrap_result(E) -->
</form>
