<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1120.jsp
*@FileTitle  : Europe Advanced Manifest - ENS Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1120Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1120Event  event = null;
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
        
        event = (EsmBkg1120Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");      
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
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
<input type="hidden" name="call_type" value="ESM_BKG_1120">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
            --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
            --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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

<div class="wrap_search">
    <!-- inquiry_area(S) -->
    <div class="opus_design_inquiry wFit">
        <table> 
            <colgroup>
                <col width="65" />
                <col width="55"/>
                <col width="345" />
                <col width="150"/>
                <col width="155"  />
                <col width="*"  />
            </colgroup>
            <tbody>
                <tr>
                    <td class="sm"><input type="radio" name="p_date_gb" value="B" class="trans" checked="checked" id="p_date_gb1" /><label for="p_date_gb1">POL ETB</label></td>
					<td class="sm"><input type="radio" name="p_date_gb" value="A" class="trans" id="p_date_gb2" /><label for="p_date_gb2">POFE ETA</label></td>
                    <td><input type="text" style="width:80px" value="" class="input1"  name="p_from_dt" id="p_from_dt"  maxlength='10' dataformat="ymd" ><input type="text" name="p_from_mt" id="p_from_mt" style="width:40px" value="00:00" class="input1" dataformat="hm"  maxlength="5" required>~ <input type="text" style="width:80px" value="" class="input1"  name="p_to_dt" id="p_to_dt"  maxlength='10' dataformat="ymd" ><input type="text" name="p_to_mt" style="width:40px" value="23:59" class="input1" dataformat="hm"  maxlength="5" required ><button type="button" id="btn_date" name="btn_date" class="calendar ir"></button></td>
                    <td class="sm"><input type="radio" name="p_rhq_gb" value="PO" class="trans" checked id="p_rhq_gb1"> 
                    	<label for="p_rhq_gb1">POL Office</label>
                   		<input type="radio" name="p_rhq_gb" value="BO" class="trans" id="p_rhq_gb2">
                    	<label for="p_rhq_gb2">BKG Office</label></td>
                    <th>Type</th>
                    <td><select style="width: 85px;" name="p_type" id="p_type">
                            <option value="" selected>ENS</option>
                        </select>
                    </td>
                </tr>   
            </tbody>
        </table>
        <table> 
            <colgroup>
                <col width="30"  />
                <col width="143"  />
                <col width="65"  />
                <col width="101"  />
                <col width="40"  />
                <col width="115" />
                <col width="50"  />
                <col width="85"  />
                <col width="50"  />
                <col width="120" />
                <col width="40"  />
                <col width="80"  />
                <col width="50"  />
                <col width="*" />
            </colgroup>
            <tbody>
                <tr>
                    <th>RHQ</th>
                    <td><script type="text/javascript">ComComboObject("rhq", 1, 100);</script></td>
                    <th style="" id="p_pol_ofc">POL OFC</th>
                    <th style="display:none" id="p_bkg_ofc">BKG OFC</th>
                    <td><input type="text" style="width:70px;" class="input" name="p_b_ofc_cd" maxlength="6" dataformat="engup" id="p_b_ofc_cd" /> </td>
                    <th title="Port of Loading">POL</th>
                    <td><input type="text" style="width:65px;" class="input" name="p_pol" value="" maxlength="5" dataformat="engup" id="p_pol" /><input type="text" style="width:25px;" class="input" name="p_pol_yd" value="" maxlength="2" dataformat="engup" id="p_pol_yd" /></td>
                    <th>POFE</th>
                    <td><input type="text" style="width:75px;" class="input" name="p_pofe" maxlength="7" dataformat="engup" id="p_pofe" /> </td>
                    <th title="Vessel Voyage Direction">VVD</th>
                    <td><input type="text" style="width:90px;" class="input" name="p_vvd" value="" maxlength="9" dataformat="engup" id="p_vvd" /> </td>
                    <th>LANE</th>
                    <td><input type="text" style="width:35px;" class="input" name="cond_lane" value="" maxlength="3" dataformat="engup" id="cond_lane" /> </td>
                    <td><input type="checkbox" name="p_fdr_yn" value="Y" class="trans" id="p_fdr_yn" /><label for = "p_fdr_yn">Incl. FDR</label></td>
                    <td></td>
                </tr>   
            </tbody>
        </table>
    </div>
    <!-- inquiry_area(E) -->
</div>
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" >
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="65" />
                <col width="65"  />
                <col width="10"  />
                <col width="90"  />
                <col width="65"  />
                <col width="90" />
                <col width="65"  />
                <col width="90" />
                <col width="65"  />
                <col width="100" />
                <col width="65"  />
                <col width="100" />
                <col width="65"  />
                <col width="140" />
                <col width="*"  />
            </colgroup>
            <tbody> 
                <tr>
                    <th>Total B/L</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_total_bl_cnt" readonly id="div_total_bl_cnt" /> </td>
                    <th>=</th>
                    <th>Accepted</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_acc_bl_cnt" readonly id="div_acc_bl_cnt" /> </td>
                    <th style='color:red'>+&nbsp;&nbsp;Rejected</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_rej_bl_cnt" readonly id="div_rej_bl_cnt" /> </td>
                    <th style='color:red'>+&nbsp;&nbsp;Not-received</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_nrcv_bl_cnt" readonly id="div_nrcv_bl_cnt" /> </td>
                    <th style='color:red'>+&nbsp;&nbsp;Do Not Load</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_donld_bl_cnt" readonly id="div_donld_bl_cnt" /> </td>
                    <th style='color:red'>+&nbsp;&nbsp;Un-Sent B/L</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_unsent_bl_cnt" readonly id="div_unsent_bl_cnt" /> </td>
                    <td colspan="2"></td>
                </tr>  
                <tr>
                    <th>Total ESD (USD)</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_total_ens_amt" readonly id="div_total_ens_amt" /> </td>
                    <th>=</th>
                    <th><span id ='rhq_ens_txt1'></span></th>
                    <td><span id ='rhq_ens_val1'></span></td>
                    <th><span id ='rhq_ens_txt2'></span></th>
                    <td><span id ='rhq_ens_val2'></span></td>
                    <th><span id ='rhq_ens_txt3'></span></th>
                    <td><span id ='rhq_ens_val3'></span></td>
                    <th><span id ='rhq_ens_txt4'></span></th>
                    <td><span id ='rhq_ens_val4'></span></td>
                    <th><span id ='rhq_ens_txt5'></span></th>
                    <td><span id ='rhq_ens_val5'></span></td>
                     <th><span id ='rhq_ens_txt6'></span></th>
                    <td><span id ='rhq_ens_val6'></span></td>
                     <th><span id ='rhq_ens_txt7'></span></th>
                    <td><span id ='rhq_ens_val7'></span></td>
                     <th><span id ='rhq_ens_txt8'></span></th>
                    <td><span id ='rhq_ens_val8'></span></td>
                    
                    <th>VVD</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_total_vvd_cnt" readonly id="div_total_vvd_cnt" /> </td>
                </tr>   
                <tr>
                    <th>Total AMA (USD)</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_total_mcf_amt" readonly id="div_total_mcf_amt" /> </td>
                    <th>=</th>
                    
                    <th><span id ='rhq_mcf_txt1'></span></th>
                    <td><span id ='rhq_mcf_val1'></span></td>
                    <th><span id ='rhq_mcf_txt2'></span></th>
                    <td><span id ='rhq_mcf_val2'></span></td>
                    <th><span id ='rhq_mcf_txt3'></span></th>
                    <td><span id ='rhq_mcf_val3'></span></td>
                    <th><span id ='rhq_mcf_txt4'></span></th>
                    <td><span id ='rhq_mcf_val4'></span></td>
                    <th><span id ='rhq_mcf_txt5'></span></th>
                    <td><span id ='rhq_mcf_val5'></span></td>
                    <th><span id ='rhq_mcf_txt6'></span></th>
                    <td><span id ='rhq_mcf_val6'></span></td>
                    <th><span id ='rhq_mcf_txt7'></span></th>
                    <td><span id ='rhq_mcf_val7'></span></td>
                    <th><span id ='rhq_mcf_txt8'></span></th>
                    <td><span id ='rhq_mcf_val8'></span></td>

                    <th>ENS Amendment</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_total_amd_cnt" readonly id="div_total_amd_cnt" /> </td>
                </tr>   
                <%--
                <tr>
                    <th>Total ENS (USD)</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_total_ens_amt" readonly id="div_total_ens_amt" /> </td>
                    <th>=</th>
                    <span id='test'></span>
                    <th>VVD</th>
                    <td><input type="text" style="width:60px;text-align:right;" value="" class="input2" name="div_total_vvd_cnt" readonly id="div_total_vvd_cnt" /> </td>
                </tr>   
                 --%>
            </tbody>
        </table>
    </div>
<%--    
    <!-- opus_design_grid(E) -->
    <div style="display:block;">&nbsp;&nbsp;* ESD surcharge should be rated for feeder ESD cases as well.</div>
    <div style="display:block;">&nbsp;&nbsp;* AMA surcharge should be rated for ESD original case sent  more than one time due to customer’s fault/request.</div>
--%>
</div>
</form>
