<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1005.jsp
*@FileTitle  : Own Chassis Master Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1005Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm1005Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesCgm1005Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        UserRoleUtil uru = new UserRoleUtil();
        ComUsrRoleVO[] curv = uru.getUserRole(strUsr_id);
        for (int i=0; i< curv.length; i++)
        {
            if(curv[i].getUsrRoleCd().equals("ENISADM"))
            {
                tRole = "Authenticated";
                break;
            } else if(curv[i].getUsrRoleCd().length() == 5)
            {
                // 1005 Permission 'CGM01','CGM02'
                if( curv[i].getUsrRoleCd().equals("CGM01") || curv[i].getUsrRoleCd().equals("CGM02"))
                {
                    tRole = "Authenticated";
                    break;
                }
            } else
            {
                tRole = "Not Authenticated";
            }
        }
	} catch (Exception e) {
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
	}
</script>


<form name="form2" id="form2"><input id="sXml" name="sXml" value="<%=xml.replace(" \"","'") %>" type="hidden" /></form>
<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="eq_knd_cd" class="input2" style="width:50px;text-align:center" name="eq_knd_cd" value="Z" type="hidden" />
<input id="eq_lot_no_tmp" class="input2" style="width:100px;text-align:center" name="eq_lot_no_tmp" type="hidden" />
<input id="eq_lot_no_etc" class="input2" style="width:100px;text-align:center" name="eq_lot_no_etc" type="hidden" />
<input id="eq_spec_no_tmp" class="input2" style="width:100px;text-align:center" name="eq_spec_no_tmp" type="hidden" />
<input id="page_status" class="input2" style="width:50px;text-align:center" name="page_status" type="hidden" />
<input id="agmt_no" class="input2" style="width:50px;text-align:center" name="agmt_no" type="hidden" />
<input id="agmt_ver_no" class="input2" style="width:50px;text-align:center" name="agmt_ver_no" type="hidden" />
<input id="agmt_ofc_cty_cd" class="input2" style="width:50px;text-align:center" name="agmt_ofc_cty_cd" type="hidden" />
<input id="agmt_seq" class="input2" style="width:50px;text-align:center" name="agmt_seq" type="hidden" />
<input id="chss_tare_wgt" name="chss_tare_wgt" type="hidden" />
<input id="vndr_seq" name="vndr_seq" type="hidden" />
<input id="trole" name="trole" value="<%=tRole%>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
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
			<tbody>
			<colgroup>
					<col width="120px"/>
					<col width="370px"/>
					<col width="*" />
				</colgroup>
				<tr>
				<th>Cert. & Chassis List</th>
					<td><script type="text/javascript">ComComboObject('eq_cert_chassis_list', 2, 374, 0, 1, 0, false);</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->

<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
					<col width="120px"/>
					<col width="50px"/>
					<col width="162px"/>
					<col width="70px"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Cert. No.</th>
					<td><input id="eq_lot_no" style="width: 140px; ime-mode:disabled;" dataformat="engup" otherchar="-_" class="input1" name="eq_lot_no" maxlength="15" type="text" /></td>
					<th>Cert. Iss Date</th>
					<td><input id="eq_lot_iss_dt" name="eq_lot_iss_dt" style="width: 100px; ime-mode:disabled; text-align:center;" dataformat="ymd" onfocus="domFunFocusDel(this)" class="input1" maxlength="8" type="text" /><button class="calendar ir" name="btns_Calendar_a" id="btns_Calendar_a" type="button"></button></td>
					<td></td>
				</tr>
			
				<tr>
					<th>Serial No.</th>
					<td>
						<input id="eq_pfx_cd" style="width: 50px; text-align:center; ime-mode:disabled" dataformat="engup" class="input1" name="eq_pfx_cd" maxlength="4" type="text" />
						<input id="fm_ser_no" style="width: 60px; text-align:center; ime-mode:disabled" dataformat="num" class="input1" name="fm_ser_no" maxlength="6" type="text" />
						<input id="to_ser_no" style="width: 60px; text-align:center; ime-mode:disabled" dataformat="num" class="input1" name="to_ser_no" maxlength="6" type="text" />
						<input id="units" style="width: 70px; text-align:right" class="input2" name="units" readonly="" type="text" />Unit(s)
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->

<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
					<col width="120px"/>
					<col width="370px"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Spec. No.</th>
					<td><script type="text/javascript">ComComboObject('eq_spec_no', 1, 374, 1, 1, 0, true);</script></td>
					<td></td>
				</tr>
				<tr>
					<th>Chassis Typ/Size</th>
					<td><input id="eq_tpsz_cd" style="width: 50px; text-align:center" class="input2" name="eq_tpsz_cd" readonly="" type="text" /></td>
					<td></td>
				</tr>
				<tr>
					<th>Manufacturer</th>
					<td><input id="vndr_lgl_eng_nm" style="width: 375px; text-align:center" class="input2" name="vndr_lgl_eng_nm" readonly="" type="text" /></td>
					<td></td>
				</tr>
				<tr>
					<th>Delivery Month</th>
					<td><input id="de_yrmon" name="de_yrmon" style="width: 100px; ime-mode:disabled; text-align:center;" dataformat="ym"  class="input1" maxlength="6" type="text" /><button class="calendar ir" name="btns_Calendar_b" id="btns_Calendar_b" type="button"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->

<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
					<col width="120px"/>
					<col width="370px"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Agreement No.</th>
					<td><input id="agreement_no" style="width: 100px; ime-mode:disabled" dataformat="engup" class="input1" name="agreement_no" maxlength="9" type="text" /><button class="input_seach_btn" name="btns_ComOpenPopupWithTargetAgree" id="btns_ComOpenPopupWithTargetAgree" type="button"></button></td>
					<td></td>
				</tr>
				<tr>
					<th>Reference No.</th>
					<td><input id="agmt_ref_no" style="width: 100px; text-align:center" class="input2" name="agmt_ref_no" readonly="" type="text" /></td>
					<td></td>
				</tr>
				<tr>
					<th>Office</th>
					<td><input id="agmt_iss_ofc_cd" style="width: 100px; text-align:center" class="input2" name="agmt_iss_ofc_cd" readonly="" type="text"/></td>
					<td></td>
				</tr>
				<tr>
					<th>Agreement Date</th>
					<td><input id="agreement_dt" style="width: 100px; text-align:center" class="input2" name="agreement_dt" readonly="" type="text" /></td>
					<td></td>
				</tr>
				<tr>
					<th>Lease Term</th>
					<td><input id="agmt_lstm_cd" style="width: 100px; text-align:center" class="input2" name="agmt_lstm_cd" readonly="" type="text" /></td>
					<td></td>
				</tr>
				<tr>
					<th>Financing Co.</th>
					<td><script type="text/javascript">ComComboObject('financing_co', 1, 374, 1, 0, 0, true);</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->

<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
					<col width="120px"/>
					<col width="370px"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Create Date</th>
					<td><input id="cre_dta" style="width: 100px; text-align:center" class="input2" readonly="" name="cre_dta" type="text" /> By <input id="cre_usr_id" style="width: 100px; text-align:center" class="input2" readonly="" name="cre_usr_id" type="text" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	 <!-- opus_design_grid(S) -->
	     <div class="opus_design_grid" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	     </div>
	<!-- opus_design_grid(E) -->
	 <!-- opus_design_grid(S) -->
	     <div class="opus_design_grid" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	     </div>
	<!-- opus_design_grid(E) -->
</div>
</form>