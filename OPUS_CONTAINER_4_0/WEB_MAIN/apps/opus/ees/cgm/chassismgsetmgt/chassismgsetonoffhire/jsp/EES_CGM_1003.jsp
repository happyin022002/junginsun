<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1003.jsp
*@FileTitle  : Chassis Master Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1003Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EesCgm1003Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list
    String successFlag = "";
    String codeList = "";
    String pageRows = "100";
    String strUsr_id = "";
    String strUsr_nm = "";
    String eqNo      = "";
    String strOfc_id = "";
    Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_id = account.getOfc_cd();
        event = (EesCgm1003Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        eqNo        = StringUtil.xssFilter(request.getParameter("eq_no"));
        if(eqNo == null){
            eqNo="";
        }
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch (Exception e) {
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="s_usr_id" name="s_usr_id" value="<%=strUsr_id %>" type="hidden" />
<input id="s_ofc_id" name="s_ofc_id" value="<%=strOfc_id %>" type="hidden" />
<input id="eq_knd_cd" name="eq_knd_cd" style="width: 60px; text-align: center; ime-mode:disabled" class="input2" maxlength="1" readonly value="Z" type="hidden" />
<input id="page_status" name="page_status" style="width: 60px; text-align: center; ime-mode:disabled" class="input2" maxlength="1" readonly type="hidden" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_mvmt" id="btn_mvmt">MVMT</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_status" id="btn_status">Status</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_spec" id="btn_spec">Spec.</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_mr" id="btn_mr">M&R</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
					<col width="37"/>
					<col width="70"/>
					<col width="350"/>
					<col width="71"/>
					<col width="200"/>
					<col width="*" />
				</colgroup>
				<tbody>
				<tr>
					<td></td>
					<th>Chassis No.</th>
                    <td><input id="eq_no" style="ime-mode: disabled; width:100px; text-align:center;" class="input1" value="<%=eqNo%>" name="eq_no" maxlength="10" dataformat="engup" type="text" /> </td>
                    <th>Type/Size</th>
                    <td><input id="eq_tpsz_cd" style="width: 60px; text-align:center;" class="input2" name="eq_tpsz_cd" readonly type="text" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>		
		<table>
			<colgroup>
					<col width="10"/>
					<col width="70"/>
					<col width="344"/>
					<col width="70"/>
					<col width="170"/>
					<col width="70"/>
					<col width="200"/>
					<col width="*" />
				</colgroup>
				<tbody>
				<tr>
					<td></td>
					 <th>Specification No.</th>
                    <td><input id="eq_spec_no" style="text-align: left; width: 265px;" class="input2" name="eq_spec_no" readonly type="text" /> </td>
                    <th>Manufacture</th>
                    <td><input id="mft_dt" style="text-align: center; width: 80px;" class="input2" name="mft_dt" readonly type="text" /> </td>
                    <th>Weight</th>
                    <td><input id="chss_tare_wgt" style="width: 75px; text-align:right;" class="input2" name="chss_tare_wgt" readonly type="text" /> lbs</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<div class="opus_design_inquiry wFit">		
		<div class="opus_design_grid wFit"></div>
		<h3 class="title_design">Current Status</h3>
		
		<table>
			<colgroup>
					<col width="10"/>
					<col width="70"/>
					<col width="150"/>
					<col width="70"/>
					<col width="120"/>
					<col width="70"/>
					<col width="155"/>
					<col width="73"/>
					<col width="150"/>
					<col width="*" />
				</colgroup>
				<tbody>
				<tr>
					<td></td>
					<th>Status</th>
                    <td><input id="aciac_div_cd" style="width: 100px; text-align:center;color:red;" class="input2" name="aciac_div_cd" readonly type="text" /> </td>
                    <th>Pool</th>
                    <td><input id="chss_pool_cd" style="width: 80px; text-align:center;" class="input2" name="chss_pool_cd" readonly type="text" /> </td>
                    <th>On-hire Date</th>
                    <td><input id="onh_dt" style="width: 80px; text-align:center;" class="input2" name="onh_dt" readonly type="text" /> </td>
                    <th>On-hire Office</th>
                    <td><input id="onh_ofc_cd" style="width: 75px; text-align:center;" class="input2" name="onh_ofc_cd" readonly type="text" /> </td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					 <th>Movement Status</th>
                    <td><input id="chss_mvmt_sts_cd" style="width: 100px; text-align:center;" class="input2" name="chss_mvmt_sts_cd" readonly type="text" /> </td>
                    <th>Yard</th>
                    <td><input id="crnt_yd_cd" style="width: 80px; text-align:center;" class="input2" name="crnt_yd_cd" readonly type="text" /> </td>
                    <th>Event Date</th>
                    <td><input id="chss_mvmt_dt" style="width: 120px; text-align:center;" class="input2" name="chss_mvmt_dt" readonly type="text" /> </td>
                    <th></th>
                    <td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
					<col width="5"/>
					<col width="5"/>
					<col width="500"/>
					<col width="*" />
				</colgroup>
				<tbody>
				<tr>
					<td></td>
					<th></th>
                    <td class="sm">
                   		<input id="cntr_chk" value="" class="trans" name="cntr_chk" type="checkbox" /><label for="cntr_chk"><strong>CNTR</strong></label><input id="atch_cntr" name="atch_cntr" style="width:144px; text-align:center;" class="input2" readonly="" type="text" />                   		
                   		<span style="margin-right:42px;"></span>
                        <input id="mgset_chk" value="" class="trans" name="mgset_chk" type="checkbox" /><label for="mgset_chk"><strong>M.G.Set</strong></label><input id="atch_mgs" name="atch_mgs" style="width: 80; text-align:center;" class="input2" readonly="" type="text" />
                        
                        <input id="bare_chk" value="" class="trans" name="bare_chk" type="checkbox" /><label for="bare_chk"><strong>Bare</strong></label>
                        
                        <input id="damage_chk" value="" class="trans" name="damage_chk" type="checkbox" /><label for="damage_chk"><strong>Damage</strong></label>
                        
                        <input id="disp_flg" value="" class="trans" name="disp_flg" type="checkbox" /><label for="disp_flg"><strong>Disposal</strong></label>
                        
                        <input id="lstay_chk" value="" class="trans" name="lstay_chk" type="checkbox" /><label for="lstay_chk"><strong>L/Stay more than 30 Days</strong></label> 
					</td>                        
					<td></td>
				</tr>
			</tbody>
		</table>
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<div class="opus_design_inquiry wFit">		
		<div class="opus_design_grid wFit"></div>
		<h3 class="title_design">Agreement</h3>			
		<table>
			<colgroup>
					<col width="22"/>
					<col width="70"/>
					<col width="150"/>
					<col width="72"/>
					<col width="110"/>
					<col width="70"/>
					<col width="168"/>
					<col width="70"/>
					<col width="150"/>
					<col width="*" />
				</colgroup>
				<tbody>
				<tr>
					<td></td>
					<th>Agreement No.</th>
                    <td><input id="agreement_no" style="width: 100px; text-align:center;" class="input2" name="agreement_no" readonly type="text" /> </td>
                    <th>Term</th>
                    <td><input id="agmt_lstm_cd" style="width: 80px; text-align:center;color:blue;" class="input2" name="agmt_lstm_cd" readonly type="text" /> </td>
                    <th>Actual On-hire</th>
                    <td><input id="act_onh_dt" style="width: 80px; text-align:center;" class="input2" name="act_onh_dt" readonly type="text" /> </td>
                    <th>Alias No.1</th>
                    <td><input id="chss_als_no" style="width: 100px; text-align:center;" class="input2" name="chss_als_no" readonly type="text" /> </td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>Reference No.</th>
                    <td><input id="agmt_ref_no" style="width: 100px; text-align:center;" class="input2" name="agmt_ref_no" readonly type="text" /> </td>
                    <th>Lessor</th>
                    <td><input id="vndr_abbr_nm" style="width: 80px; text-align:center;" class="input2" name="vndr_abbr_nm" readonly type="text" /> </td>
					<td></td>
					<td></td>
                    <th>Alias No.2</th>
                    <td><input id="n2nd_chss_als_no" style="width: 100px; text-align:center;" class="input2" name="n2nd_chss_als_no" readonly type="text" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<div class="opus_design_inquiry wFit">	
		<div class="opus_design_grid wFit"></div>
		<h3 class="title_design">Registration</h3>		
		<table>
			<colgroup>
					<col width="10"/>
					<col width="70"/>
					<col width="150"/>
					<col width="68"/>
					<col width="124"/>
					<col width="70"/>
					<col width="150"/>
					<col width="*" />
				</colgroup>
				<tbody>
				<tr>
					<td></td>
					<th>Registered State</th>
                    <td><input id="chss_rgst_ste_cd" style="width: 100px; text-align:center;" class="input2" name="chss_rgst_ste_cd" readonly type="text" /> </td>
                    <th>Reg. Year</th>
                    <td><input id="chss_rgst_yr" style="width: 65px; text-align:center;" class="input2" name="chss_rgst_yr" readonly type="text" /> </td>
                    <th class="sm">License No.</th>
                    <td class="sm"><input id="chss_rgst_lic_no" style="width: 120px; text-align:center;" class="input2" name="chss_rgst_lic_no" readonly type="text"/></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>Vehicle ID No.</th>
                    <td><input id="chss_veh_id_no" style="width: 150px; text-align:center;" class="input2" name="chss_veh_id_no" readonly type="text" /> </td>
                    <th></th>
                    <td></td>
                    <th class="sm">Expiry</th>
                    <td class="sm"><input id="chss_rgst_prd_cd" value="" class="trans" name="chss_rgst_prd_cd" type="radio" /> PMNT<input id="chss_rgst_prd_cd" value="" class="trans" name="chss_rgst_prd_cd" type="radio" /> Fixed<label></label><label></label><input id="chss_rgst_exp_dt" style="width :80px; text-align:center;" class="input2" name="chss_rgst_exp_dt" readonly="" type="text" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<div class="opus_design_inquiry wFit">		
		<div class="opus_design_grid wFit"></div>
		
		<table>
			<colgroup>
					<col width="30"/>
					<col width="70"/>
					<col width="150"/>
					<col width="105"/>
					<col width="70"/>
					<col width="150"/>
					<col width="*" />
				</colgroup>
				<tbody>
				<tr>
					<td></td>
					<th>Created Date</th>
                    <td><input id="chss_rgst_upd_dt" style="width: 80px; text-align:center;" class="input2" name="chss_rgst_upd_dt" readonly type="text" /> By <input id="chss_rgst_upd_id" style="width: 120px; text-align:center;" class="input2" name="chss_rgst_upd_id" readonly type="text" /></td>
                    <td></td>
                    <th>Updated Date</th>
                    <td><input id="upd_dt" style="width: 80px; text-align:center;" class="input2" name="upd_dt" readonly type="text" /> By <input id="upd_usr_id" style="width: 120px; text-align:center;" class="input2" name="upd_usr_id" readonly type="text" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	        <div class="opus_design_grid wFit" style="display:none;">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <div class="opus_design_grid wFit" style="display:none;">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <div class="opus_design_grid wFit" style="display:none;">
				<script type="text/javascript">ComSheetObject('sheet3');</script>
	        </div>
	<!-- opus_design_grid(E) -->
</div>
</form>