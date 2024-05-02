<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0035.jsp
*@FileTitle  : Inquiry by Source Data
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>  
<%
    GeneralEventResponse eventResponse = null;
    Exception serverException = null;
    String strErrMsg = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.multidimensionrpt.sales.jsp.ESM_COA_035");

    String userId  = "";
    String usr_ofc_cd  = "";
    String usr_ofc_lvl = "";
    String xml = "";
    String strTpsz = "";
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
            userId = account.getUsr_id();
            usr_ofc_cd = account.getOfc_cd();  //.getUserOffice2();
            usr_ofc_lvl = account.getUsr_auth_tp_cd();  //.getUserLevel();          
            
            strTpsz = eventResponse.getETCData("strTpsz");
            xml = HttpUtil.makeXML(request,response); 
            xml = xml.replaceAll("\"", "'");
           
        } //end of if
        
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>

<script type="text/javascript">
    var strTpsz = "<%= strTpsz %>";
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        var formObj = document.form;

        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage();
    }
</script>

<form method="post" name="form"  onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<input type="hidden" name="userId"  value="<%=userId%>">
<input type="hidden" name="f_usr_ofc_cd"  value="<%=usr_ofc_cd%>">
<input type="hidden" name="f_usr_ofc_lvl" value="<%=usr_ofc_lvl%>">
<input type="hidden" name="f_excel">
<input type="hidden" name="f_shpr_cd">
<input type="hidden" name="sXml" value="<%=xml%>"> 

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
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
        --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
        --><button type="button" class="btn_normal" name="btn_filedownload" id="btn_filedownload">File Download</button>
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
    <div class="opus_design_inquiry">
        <table>
             <colgroup>
                <col width="90" />
                <col width="110"  />
                <col width="160" />
                <col width="110" />
                <col width="110" />
                <col width="110" />
                <col width="110" />
                <col width="50"  />
                <col width="110" />
                <col width="50" />
                <col width="110" />                
                <col width="50" />
                <col width="" />
            </colgroup> 
            <tbody>
                <tr>
                    <td colspan="13"><script type="text/javascript">coaPeriod1("2","O");</script></td>
                </tr>
                <tr>
                	<td colspan="13" class="line_bluedot" style="height:11;"></td>
                </tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
                    <th>Profit View</th>
                    <td><script type="text/javascript">ComComboObject('f_pro_vw',1, 131 , 0 )</script></td>
                    <th>Office View</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_vw',1, 80 , 0 )</script></td>
                    <th>Profit Level</th>
                    <td><script type="text/javascript">ComComboObject('f_pro_lvl',1, 80 , 0 )</script></td>
                    <!-- SJH.20141111.ADD -->
                    <th><div style="display:none">EPP Type</div></th>
                    <td colspan="5"><div style="display:none"><script type="text/javascript">ComComboObject('f_type_cd',1, 80 , 0 )</script></div></td>                     
                </tr>
                <tr>
                  <td colspan="13" class="line_bluedot" style="height:11;"></td>
                </tr>           
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
                    <th>Office Level</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_lvl',1, 131 , 0 )</script></td>
                    <th>Office</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_cd',1, 80 , 0 )</script></td>
                    <td colspan="2"><input type="checkbox" class="trans" name="f_excl_sts" id="f_excl_sts" value="Y"><label for="f_excl_sts">Exclude Sub</label></td>
                    <th title="Vessel Voyage Direction">VVD</th>
                    <td colspan="5">
                        <input type="text" name="f_vsl_cd" style="width:50px;text-align:center;ime-mode:disabled;" maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" dataformat="engup"><!--
                        --><input type="text" name="f_skd_voy_no" style="width:50px;text-align:center;" maxlength="4" onKeyPress="ComKeyOnlyNumber(this);" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" dataformat="num"><!--
                        --><input type="text" name="f_skd_dir_cd"    style="width:20px;text-align:center;ime-mode:disabled;" maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper');" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" dataformat="enguponly">
                    </td>
                </tr>
                <tr>
                  <td colspan="13" class="line_bluedot" style="height:11;"></td>
                </tr>       
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td>
                    <th>Trade</th>
                    <td><script type="text/javascript">ComComboObject('f_trd_cd',1, 80 , 0 )</script></td>
                    <th>Lane</th>
                    <td><script type="text/javascript">ComComboObject('f_rlane_cd',1, 80 , 0 )</script></td>
                    <th>IOC</th>
                    <td><script type="text/javascript">ComComboObject('f_ioc_cd',1, 80 , 0 )</script></td>
                    <th>Bound</th>
                    <td><script type="text/javascript">ComComboObject('f_dir_cd',1, 80 , 0 )</script></td>
					<!-- SJH.20141218.ADD -->
					<th>Service Scope</th>
                    <td colspan="3"><input type="text" name="f_svc_scp_cd" style="width:80px;ime-mode:disabled;" maxlength="3" onKeyPress="ComKeyOnlyAlphabet('upper');" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" dataformat="enguponly" ></td>                    
                </tr>
                <tr>
                    <td></td>
                    <th title="Place of Receipt">POR</th><!-- 20151209.MOD : NUMBER추가 -->
                    <td><input type="text" name="f_bkg_por_cd" style="width:80px;ime-mode:disabled;" maxlength="5" dataformat="engup" onKeyPress="onlyEngNumber();" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" ></td>
                    <th>Revenue POL</th>
                    <td><input type="text" name="f_rev_pol_cd" style="width:80px;ime-mode:disabled;" maxlength="5" dataformat="engup" onKeyPress="onlyEngNumber();" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" ></td>
                    <th>Revenue POD</th>
                    <td><input type="text" name="f_rev_pod_cd" style="width:80px;ime-mode:disabled;" maxlength="5" dataformat="engup" onKeyPress="onlyEngNumber();" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" ></td>
                    <th title="Place of Delivery">DEL</th>
                    <td><input type="text" name="f_bkg_del_cd" style="width:80px;ime-mode:disabled;" maxlength="5" dataformat="engup" onKeyPress="onlyEngNumber();" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" ></td>
                    <!-- SJH.20141218.ADD -->
                    <th>1ST POL</th>
                    <td><input type="text" name="f_bkg_pol_cd" style="width:80px;ime-mode:disabled;" maxlength="5" dataformat="engup" onKeyPress="onlyEngNumber();" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" ></td>
                    <th>Last POD</th>
                    <td><input type="text" name="f_bkg_pod_cd" style="width:80px;ime-mode:disabled;" maxlength="5" dataformat="engup" onKeyPress="onlyEngNumber();" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" ></td>
                </tr>
                <tr>
                    <td colspan="13" class="line_bluedot" style="height:11;"></td>
                </tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Customer</td>
                    <th>Shipper</th>
                    <td>
                        <input type="text" name="txtShipper" style="width:57px;ime-mode:disabled;" maxlength="10" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" dataformat="engup"><!--
                        --><button type="button" class="input_seach_btn" onClick="shipperPopUp();"></button>
                    </td>
                    <th>Service Contract</th>
                    <td>
                        <input type="text" name="f_sc_no" style="width:57px;ime-mode:disabled;" maxlength="9" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" dataformat="engup"><!--
                        --><button type="button" class="input_seach_btn" onClick="comPopupLoc(1, document.form.f_sc_no.value);"></button> <!-- 20150806.MOD -->
                    </td>
                    <th>RFA</th>
                    <td><input type="text" name="f_rfa_no" style="width:80px;ime-mode:disabled;" maxlength="11" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" dataformat="engup"></td>
                    <th>TAA</th>
                    <td><input type="text" maxlength="11" name="f_taa_no" style="width:80px;"  onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="ime-mode:disabled" dataformat="engup"></td>
                    <!-- SJH.20141218.ADD -->
					<th>SC/RFA Group Cust Nm</th>
                    <td colspan="3"><input type="text" name="f_cust_grp_nm" style="width:247px;ime-mode:disabled;" maxlength="50" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();" dataformat="enguponly" otherchar="& " ></td>
                </tr>
                <tr>
                  <td colspan="13" class="line_bluedot" style="height:11;"></td>
                </tr>
                <tr>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Others</td>
                    <th>Rep. Commodity</th><!-- 20160115.MOD -->
                    <!--<td><script type="text/javascript">ComComboObject('f_rep_cmdt_cd',2,80,0)</script></td>-->
                    <td>
                        <input type="text" name="f_rep_cmdt_cd" id="f_rep_cmdt_cd" style="width:57px;ime-mode:disabled;" maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" dataformat="engup"><!--
                        --><button type="button" class="input_seach_btn" onClick="CommodityPopUp();"></button>
                    </td>                    
                    <th>Service Mode</th>
                    <td><script type="text/javascript">ComComboObject('f_usa_bkg_mod_cd',1, 80 , 0 )</script></td>
                    <th>RPT Form</th>
                    <td>
                        <select name="RPTForm" style="width:80px;" onChange="rPTFormOnChange(this);">
                            <option value="ACCT" selected>Account</option>
                            <option value="TPSZ">TP/SZ</option>
                        </select>
                    </td>
                    <td colspan="7">
                        <input type="checkbox" class="trans" name="f_bkg_sts" id="f_bkg_sts" value="Y"><label for="f_bkg_sts">Waiting Booking Include</label>
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
    <div class="opus_design_grid">
        <div id="tabLayer1" style="display:inline" id="mainTable">
        <div class="opus_design_btn" style="margin-bottom:4px;">
            <div align="right">
                <div id="div_zoom_in1" style="display:inline" align="right">
                    <button type="button" class="btn_up" name="bu_zoom_in1" id="bu_zoom_in1" title="Zoom in(+)"></button>
                </div>
                <div id="div_zoom_out1" style="display:none" align="right">
                     <button type="button" class="btn_down" name="bu_zoom_out1" id="bu_zoom_out1" title="Zoom out(-)"></button>
                </div>
            </div>
		</div>
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>

        <div id="tabLayer2" style="display:inline" id="mainTable2">
        	<div class="opus_design_btn" style="margin-bottom:4px;">
                <div id="div_zoom_in2" style="display:inline" align="right">
                    <button type="button" class="btn_up" name="bu_zoom_in2" id="bu_zoom_in2" title="Zoom in(+)"></button>
                </div>
                <div id="div_zoom_out2" style="display:none" align="right">
                    <button type="button" class="btn_down" name="bu_zoom_out2" id="bu_zoom_out2" title="Zoom out(-)"></button>
                </div>
            </div>

            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
