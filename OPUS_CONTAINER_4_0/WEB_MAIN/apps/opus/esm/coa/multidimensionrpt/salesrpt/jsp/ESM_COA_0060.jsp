<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0060.jsp
*@FileTitle  : Inquiry by Customized Condition
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.coa.common.Utils"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0060Event"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%
    EsmCoa0060Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;
    String strErrMsg= "";
    String userId   = "";
    String ofc_cd   = "";
    String ofc_lvl  = "";
    String selGroup = "";
    String prevWeek = "";

    String col_desc = Utils.iif(request.getParameter("col_desc")==null, "", request.getParameter("col_desc"));
    String col_nm   = Utils.iif(request.getParameter("col_nm")==null, "", request.getParameter("col_nm"));

    String userName = "";
    String xml = "";
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);


        //ADD----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        //userAuth=account.getAuth();
        userName  = account.getUsr_nm();

        event = (EsmCoa0060Event)request.getAttribute("Event");
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
        var col_desc = document.form.f_header.value;
        var col_nm = document.form.f_headernm.value;


        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage(col_desc, col_nm);
    }
</script>

<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
<iframe height="0" width="0" name="frmHidden2" id="frmHidden2"></iframe>

<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="chkGubun" id="chkGubun" />
<input type="hidden" name="f_header" value="<%=col_desc%>" id="f_header" />
<input type="hidden" name="f_headernm" value="<%=col_nm%>" id="f_headernm" />
<input type="hidden" name="userId" value="<%=userId %>" id="userId" />
<input type="hidden" name="ofc_cd" value="" id="ofc_cd" />
<input type="hidden" name="ofc_lvl" value="" id="ofc_lvl" />
<input type="hidden" name="f_shipper" id="f_shipper" />
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
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
        --><button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button>
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
<div class="wrap_search" style="margin-top:-20px;">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="90"  />
                <col width="110" />
                <col width="160" />
                <col width="110" />
                <col width="130" />
                <col width="130" />
                <col width="50"  />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <td colspan="9"><script type="text/javascript">coaPeriod1("1","O");</script></td>
                </tr>
                <tr><td colspan="9" class="line_bluedot" style="height:11;"></td></tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
                    <th>Profit View</th>
                    <td><script type="text/javascript">ComComboObject('f_pro_vw',1, 131 , 0 )</script></td>
                    <th>Office View</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_vw',1, 80 , 0 )</script></td>
                    <th>Profit Level</th>
                    <td><script type="text/javascript">ComComboObject('f_pro_lvl',1, 80 , 0 )</script></td>
                    <!-- SJH.20141111.ADD, 20150527.MOD -->
                    <th style="display:none">EPP Type</th>
                    <td style="display:none"><script type="text/javascript">ComComboObject('f_type_cd',1, 80 , 0 )</script></td>                      
                </tr>
                <tr><td colspan="9" class="line_bluedot" style="height:11;"></td></tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
                    <th>Office Level</th>
                    <td><script type="text/javascript">ComComboObject('f_rhq_cd',1, 131 , 0 )</script></td>
                    <th>Office</th>
                    <td><script type="text/javascript">ComComboObject('f_sls_ofc_cd',1, 80 , 0 )</script></td>
                    <td colspan="4">
                        <input type="checkbox" class="trans" name="f_excl_sts" id="f_excl_sts" value="Y"><!--
                        --><label for="f_excl_sts"><b>Exclude Sub</b></label>
                    </td>
                </tr>
                <tr>
                    <td colspan="9" class="line_bluedot" style="height:11;"></td>
                </tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td>
                    <th>Trade</th>
                    <td><script type="text/javascript">ComComboObject('f_trd_cd',1, 80 , 0 )</script></td>
                    <th>Lane</th>
                    <td><script type="text/javascript">ComComboObject('f_rlane_cd',1, 80 , 0 )</script></td>
                    <th>Direction</th>
                    <td><script type="text/javascript">ComComboObject('f_skd_dir_cd',1, 80 , 0 )</script></td>
                    <th title="Vessel Voyage Direction">VVD</th>
                    <td>
                        <input type="text" dataformat="engup" style="width:42px;ime-mode:disabled" maxlength="4" name="f_vsl_cd" id="f_vsl_cd"><!--
                        --><input type="text" dataformat="num" style="width:42px;ime-mode:disabled" maxlength="4" name="f_skd_voy_no" id="f_skd_voy_no"><!--
                        --><input type="text" dataformat="engup" style="width:23px;ime-mode:disabled" maxlength="1" name="f_dir_cd" id="f_dir_cd"> 
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <th title="Place of Receipt">POR</th><!-- 20151209.MOD : NUMBER추가 -->
                    <td><input type="text" name="f_bkg_por_cd" id="f_bkg_por_cd" dataformat="engup" onKeyPress="onlyEngNumber();" maxlength="5" style="width:80px;ime-mode:disabled" ></td>
                    <th>REV POL</th>
                    <td><input type="text" name="f_rev_pol_cd" id="f_rev_pol_cd" dataformat="engup" onKeyPress="onlyEngNumber();" maxlength="5" style="width:80px;ime-mode:disabled" ></td>
                    <th>REV POD</th>
                    <td><input type="text" name="f_rev_pod_cd" id="f_rev_pod_cd" dataformat="engup" onKeyPress="onlyEngNumber();" maxlength="5" style="width:80px;ime-mode:disabled" ></td>
                    <th title="Place of Delivery">DEL</th>
                    <td><input type="text" dataformat="engup" onKeyPress="onlyEngNumber();" name="f_bkg_del_cd" id="f_bkg_del_cd" maxlength="5" style="width:115px;ime-mode:disabled" ></td>
                </tr>
                <tr>
                    <td></td>
                    <th>BKG POL</th>
                    <td><input type="text" dataformat="engup" onKeyPress="onlyEngNumber();" name="f_bkg_pol_cd" id="f_bkg_pol_cd" maxlength="5" style="width:80px;ime-mode:disabled"></td>
                    <th>BKG POD</th>
                    <td colspan="5"><input type="text" dataformat="engup" onKeyPress="onlyEngNumber();" name="f_bkg_pod_cd" maxlength="5" style="width:80px;ime-mode:disabled" ></td>
                </tr>
                <tr>
                    <td colspan="9" class="line_bluedot" style="height:11;"></td>
                </tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Customer</td>
                    <th>Shipper</th>
                    <td>
                        <input type="text" dataformat="engup" maxlength="8" name="txtShipper" style="width:80px;ime-mode:disabled" ><!--
                        --><button type="button" class="input_seach_btn" name="btn_pop_shipper" id="btn_pop_shipper" onClick="ShipperPopUp();"></button>
                    </td>
                    <th>Service Contract</th>
                    <td>
                        <input type="text" maxlength="20" dataformat="engup" name="f_sc_no" id="f_sc_no" style="width:80px;ime-mode:disabled"><!--
                        --><button type="button" class="input_seach_btn" name="btn_pop_contract" id="btn_pop_contract" onClick="comPopupLoc(1, document.form.f_sc_no.value);"></button>
                    </td>
                    <th>RFA</th>
                    <td><input type="text" maxlength="11" dataformat="engup" name="f_rfa_no" id="f_rfa_no" style="width:80px; ime-mode:disabled" ></td>
                    <th>TAA</th>
                    <td><input type="text" dataformat="engup" maxlength="11" name="f_taa_no" id='f_taa_no' style="width:80px;ime-mode:disabled" ></td>
                </tr>
                <tr>
                    <td></td>
                    <th>Key Acct(Group)</th>
                    <td colspan="3"><script type="text/javascript">ComComboObject('f_key_acct_group_cd',1, 349 , 0 )</script></td>
                    <th>Key Acct(individual)</th>
                    <td><script type="text/javascript">ComComboObject('f_key_acct_indvl_cd',2, 80 , 0 )</script></td>
                </tr>
                <tr>
                    <td></td>
                    <th>M/A(Group)</th>
                    <td colspan="3"><script type="text/javascript">ComComboObject('f_mlt_trd_group_cd',1, 349 , 0 )</script></td>
                    <th>M/A(individual)</th>
                    <td><script type="text/javascript">ComComboObject('f_mlt_trd_indvl_cd',2, 80 , 0 )</script></td>
                </tr>
                <tr>
                    <td colspan="9" class="line_bluedot" style="height:11;"></td>
                </tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Others</td>
                    <th>Rep. Commodity</th><!-- 20160115.MOD -->
                    <!--<td><script type="text/javascript">ComComboObject('f_cmdt_cd',2, 80, 0,0,0); </script></td> -->
                    <td>
                        <input type="text" name="f_cmdt_cd" id="f_cmdt_cd" style="width:80px;ime-mode:disabled;" maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" dataformat="engup"><!--
                        --><button type="button" class="input_seach_btn" onClick="CommodityPopUp();"></button>
                    </td>                    
                    <th>US Mode</th>
                    <td colspan="4"><script type="text/javascript">ComComboObject('f_usa_bkg_mod_cd',1, 80 , 0 )</script></td>
                </tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Others</td>
                    <th>Type/Size</th>
                    <td>
                        <script type="text/javascript">ComComboObject('f_cntr_tpsz_cd', 1, 80, 0, 0, 0);</script><!--
                        <button type="button" class="multiple_inq ir" name="btns_cntr_tpsz_cd" id="btns_cntr_tpsz_cd"></button>-->
                    </td>
                    <th>Service Scope</th>
                    <td colspan="4"><script type="text/javascript">ComComboObject('f_svc_scp_cd',2, 80 , 0 )</script></td>
                    <!-- <td >
                    
                        <input type="radio" class="trans" name="f_view_tpsz" id="f_view_tpsz1" value="BOX"  onClick="javascript:changeType();"><label for="f_view_tpsz1">BOX</label>
                        <input type="radio" class="trans" name="f_view_tpsz" id="f_view_tpsz2" value="TEU" checked onClick="javascript:changeType();"><label for="f_view_tpsz2">TEU</label>
                    </td> -->
                </tr>
                <tr class="h23">
                    <td></td>
                    <th>Booking</th>
                    <td>
                      <!-- SJH.20140903.MOD : maxlength -->
                      <input type="text" dataformat="engup" style="width:120px;ime-mode:disabled" name="f_bkg_no" id="f_bkg_no">
                      <button type="button" class="multiple_inq ir" name="btns_multisearch1" id="btns_cntr_tpsz_cd" onClick="openPopup('f_bkg_no')"></button>
                    </td>
                    <td colspan="6">
                      <input type="checkbox" class="trans" name="f_bkg_sts" id="f_bkg_sts" value="Y"><label for="f_bkg_sts"><b>Waiting Booking Include</b></label><!--
                      --><input type="checkbox" class="trans" name="f_dir_sts" id="f_dir_sts" value="Y" onClick="viewBound();"><label for="f_dir_sts"><b>Bound Display</b></label><!--
                      --><input type="checkbox" class="trans" name="f_wk_sts" id="f_wk_sts" value="Y" onClick="viewWeek();"><label for="f_wk_sts"><b>Week Display</b></label><!--
                      --><input type="checkbox" class="trans" name="f_soc_sts" id="f_soc_sts" value="Y"><label for="f_soc_sts"><b>Excluding S.O.C</b></label>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid"  id="mainTable">
        <table class="mar_btm_8">
            <colgroup>
                <col width="210" />
                <col width="150" />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <td><h3 class="title_design">Select Customized RPT Form</h3></td>
                    <td><script type="text/javascript">ComComboObject('f_selgroup',1, 200 , 0 )</script></td>
                    <td align="right">  
			            <div class="opus_design_btn">
							<button type="button" class="btn_accent" name="btn_form" 		id="btn_form">Set Customized RPT Form</button>
						</div>
                      <!-- <img class="cursor" src="/opuscntr/img/opus/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:ComOpenWindow2('ESM_COA_0059.do','', 'width=600,height=550,menubar=0,status=0,scrollbars=0,resizable=1');" class="purple">Set Customized RPT Form</a> -->
                    </td>
                </tr>
            </tbody>
        </table>

        <script type="text/javascript">ComSheetObject('sheet1');</script> 
    </div>
    <!-- opus_design_grid(E) -->

    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table class="search" border="0">
            <colgroup>
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <td class="gray_tit" style="padding-left:0;">
                        <img src="/opuscntr/img/ico_star.gif">&nbsp;<strong>Remark</strong>
                    </td>
                </tr>
                <tr>
                    <td style="padding-left:10;">
                        <img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0"><!--
                        -->Please reset the report form - in the event that an error occurs.<br>
                        <img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0"><!--
                        -->If you want to check all costs related to the booking, please include the BKG number when retrieving the data and double click it.
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_result(E) -->
</form>

