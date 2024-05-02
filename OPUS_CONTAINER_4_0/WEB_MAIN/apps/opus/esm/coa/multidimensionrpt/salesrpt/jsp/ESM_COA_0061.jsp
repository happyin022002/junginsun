<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0061.jsp
*@FileTitle  : Inquiry By BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//  EsmCoa0061Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";

    String pro_vw   = "";
    String pro_lvl  = "";
    String s_bkg_no  = "";
    
    String screen_name = "";
    String popup_flag = "N";    
    Logger log = Logger.getLogger("com.clt.apps.MultiDimensionRPT.SalesRPT");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
        
 
//      event = (EsmCoa0061Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        screen_name = ((Screen)(request.getAttribute("com.clt.framework.core.comm.CURRENT_SCREEN"))).getName();
        
        if( screen_name.indexOf("POP") > 0){
            popup_flag = "Y";   
        }
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        pro_vw = request.getParameter("f_pro_vw"); 
        pro_lvl = request.getParameter("f_pro_lvl");
        s_bkg_no = request.getParameter("f_s_bkg_no");
                                
//      GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(NullPointerException ne){
        log.error("not exist");
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
var popup_flag = "<%=popup_flag%>";
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<!-- Developer DIV  -->

<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="f_rd_flg" id="f_rd_flg" />
<input type="hidden" name="userId" id="userId"  value="<%=strUsr_id %>" />
<input type="hidden" name="f_ofc_cd" value="" id="f_ofc_cd" />
<input type="hidden" name="f_ofc_lvl" value="" id="f_ofc_lvl" />
<input type="hidden" name="f_rout_no" value="" id="f_rout_no" />
<input type="hidden" name="f_pctl_no" value="" id="f_pctl_no" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_pro_vw" id="s_pro_vw"  value="<%=JSPUtil.getNull(pro_vw)%>" />
<input type="hidden" name="s_pro_lvl" id="s_pro_lvl" value="<%=JSPUtil.getNull(pro_lvl)%>"  />

<input type="hidden" name="f_cntr_tpsz_cd" value="" id="f_cntr_tpsz_cd" />
<input type="hidden" name="f_type_cd" value="" id="f_type_cd" />

<%if(popup_flag=="Y"){%>
<div class="layer_popup_title">
           <div class="page_title_area clear">
               <h2 class="page_title"><span>Inquiry by BKG</span></h2>
               <div class="opus_design_btn">
                   <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
                   --><button type="button" class="btn_normal" name="btn_downexcel"    id="btn_downexcel">Down Excel</button>
                </div>
           </div>
</div>

<%}else{%>
<div class="page_title_area clear">
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <div class="opus_design_btn">
    	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
    	--><button type="button" class="btn_normal" name="btn_downexcel"    id="btn_downexcel">Down Excel</button>
    </div>
    <div class="location">
        <span id="navigation"></span>
    </div>
</div>
<%}%>
<%if(popup_flag=="Y"){%><div class="layer_popup_contents"><%}%>


<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="90"  />
                <col width="290" />
                <col width="90"  />
                <col width="74"  />
                <col width="245" />
                <col width="80"  />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Booking</th>
                    <td><input type="text" style="width:130px" class="input1" name="f_bkg_no" id="f_bkg_no"  value="<%=JSPUtil.getNull(s_bkg_no)%>" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('uppernum');" maxlength="13" ></td>
                    <td><img src="/opuscntr/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0"><b>By View</b></td>
                    <th> Profit View</th>
                    <td><script type="text/javascript">ComComboObject('f_pro_vw',1, 100 , 0 )</script></td>
                    <th>Profit Level</th>
                    <td><script type="text/javascript">ComComboObject('f_pro_lvl',1, 94 , 0 )</script></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
    
    <div class="wrap_result">
       <div class="opus_design_inquiry ">   
            <table>
            <colgroup>
                <col width="90" />
                <col width="160" />
                <col width="200" />
                <col width="80" />
                <col width="65" />
                <col width="110" />
                <col width="90" />
                <col width="55" />
                <col width="92" />
                <col width="38" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Booking No.</th>
                    <td><input type="text" style="width:133px;" name="f_bkg_split" value="" disabled class="input2" id="f_bkg_split"/> </td>
                    <td><b>Contract Office</b>&nbsp;<input type="text" style="width:97px" name="f_clt_ofc_cd" id="f_clt_ofc_cd" disabled class="input2"></td>
                    <th>Sales Office</th>
                    <td><input type="text" style="width:61px;" name="f_ofc" value="" disabled class="input2" id="f_ofc" /> </td>
                    <th>Shipper</th>
                    <td><input type="text" style="width:70px;" name="f_shipper" disabled class="input2" id="f_shipper" /> </td>
                    <td colspan="5"><div style="padding: 0 0 0 6px" id="div_shipper"></div></td>
                </tr>
                <tr>
                    <th>IOC</th>
                    <td>
                        <input type="text" style="width:20px;text-align:center;" name="f_ioc" value="" disabled class="input2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--
                        --><b>R/Lane</b>&nbsp;&nbsp;<!--
                        --><input type="text" style="width:48px" name="f_rlane" value="" disabled class="input2">
                    </td>
                    <td>
                        <b>VVD</b>&nbsp;<!--
                        --><input type="text" style="width:78px" name="f_vvd" value="" disabled class="input2">&nbsp;&nbsp;&nbsp;<!--
                        --><b>R/Term</b>&nbsp;&nbsp;<!--
                        --><input type="text" style="width:20px;text-align:center;" name="f_rterm" value="" disabled class="input2">
                    </td>
                    <th>D/Term</th>
                    <td><input type="text" style="width:20px;text-align:center;" name="f_dterm" value="" disabled class="input2"></td>
                    <th>R/Mon</th>
                    <td><input type="text" style="width:70px" name="f_cost_yrmon" disabled class="input2"></td>
                    <th>S/Mon</th>
                    <td><input type="text" style="width:69px" name="f_sls_yrmon" disabled class="input2"></td>
                    <th>Week</th>
                    <td><input type="text" style="width:20" name="f_cost_wk" disabled class="input2"></td>
                </tr>
                <tr>
                    <th>Special Cargo</th>
                    <td class="sm">
                        <input type="checkbox" class="trans" name="f_spcl_dg" id="f_spcl_dg" value="Y" disabled><label for="f_spcl_dg">DG</label><!--
                        --><input type="checkbox" class="trans" name="f_spcl_rf" id="f_spcl_rf" value="Y" disabled><label for="f_spcl_rf">RF</label><!--
                        --><input type="checkbox" class="trans" name="f_spcl_ak" id="f_spcl_ak" value="Y" disabled><label for="f_spcl_ak">AK</label><!--
                        --><input type="checkbox" class="trans" name="f_spcl_bb" id="f_spcl_bb" value="Y" disabled><label for="f_spcl_bb">BB</label>
                    </td>
                    <td>
                        <label for="f_mt_rev">Revenue MT</label><!--
                        --><input type="checkbox" class="trans" name="f_mt_rev" id="f_mt_rev" disabled><!--
                        --><label for="f_soc_flg">S.O.C</label><!--
                        --><input type="checkbox" class="trans" name="f_soc_flg" id="f_soc_flg" value="Y" disabled>
                    </td>
                    <th>BKG STS</th>
                    <td><input type="text" style="width:20px;text-align:center;" name="bkg_sts" disabled class="input2"></td>
                    <th>Rep. Commodity</th>
                    <td><input type="text" style="width:70px" name="f_rcmdt" value="" disabled class="input2"></td>
                    <th>Weight</th>
                    <td colspan="3">
                        <input type="text" style="width:105px;text-align:right;" name="f_bkg_cgo_wgt" disabled class="input2" dataformat="float" ><!--
                        --><input type="text" style="width:41px" name="f_bkg_wgt_tp_cd" disabled class="input2">
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" id="mainTable1">
        <script type="text/javascript">ComSheetObject('sheet1');</script>

        <script type="text/javascript">ComSheetObject('sheet2');</script>        
        
        <div class="grid_option_right mar_top_4">
        <!-- SJH.20141027.ADD -->
            <table>
                <colgroup>
                    <col width="200" />
                    <col width="70" />
                    <col width="70" />
                    <col width="" />
                </colgroup>
                <tbody>
                    <tr>
                        <td></td>
                        <th>EPP TYPE</th>
                        <td><script language="javascript">ComComboObject('p_type_cd',1, 70 , 0);</script></td>
                        <td valign="bottom" align="right">
              <button type="button" class="btn_etc" name="btng_costdetail" id="btng_costdetail">Cost Detail</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <!-- opus_design_grid(E) -->

    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
        <h3 class="title_design  mar_top_12">Performance Inquiry</h3>
        <div class="opus_design_inquiry">
            <table>
                <colgroup>
                    <col width="70" />
                    <col width="100" />
                    <col width="*" />
                    <col width="30" />
                </colgroup>
                <tbody>
                    <tr>
                        <th>Type/Size</th>
                        <td><script type="text/javascript">ComComboObject('p_cntr_tpsz_cd',1, 80 , 0 )</script></td>
                        <td valign="middle" align="right">
                            (USD)&nbsp;
                        </td>
                        <td>	
					        <div class="opus_design_btn" style="margin-bottom:4px;">
					            <div align="right">
					                <div id="div_zoom_in" style="display:inline" align="right">
					                    <button type="button" class="btn_up" name="bu_zoom_in" id="bu_zoom_in" title="Zoom in(+)"></button>
					                </div>
					                <div id="div_zoom_out" style="display:none" align="right">
					                     <button type="button" class="btn_down" name="bu_zoom_out" id="bu_zoom_out" title="Zoom out(-)"></button>
					                </div>
					            </div>
							</div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <script type="text/javascript">ComSheetObject('sheet3');</script>

        <div class="grid_option_right mar_top_4">
            <button type="button" class="btn_etc" name="btns_remarks" id="btns_remarks">Remarks</button>
        </div>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
<%if(popup_flag=="Y"){  %></div><%}%>
<!-- Developer DIV  END -->
</form>
<iframe id=myiframe src="" width=0 height=0></iframe>