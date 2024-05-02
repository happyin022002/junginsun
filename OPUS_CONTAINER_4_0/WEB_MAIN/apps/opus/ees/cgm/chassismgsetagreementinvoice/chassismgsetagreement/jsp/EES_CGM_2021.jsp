<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2021.jsp
*@FileTitle  : Lease Agreement Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm2021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd			= "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		event = (EesCgm2021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        UserRoleUtil uru = new UserRoleUtil();
        ComUsrRoleVO[] curv = uru.getUserRole(strUsr_id);
        for(int i=0; i< curv.length; i++)
        {
            if(curv[i].getUsrRoleCd().equals("ENISADM"))
            {
                tRole = "Authenticated";
                break;
            }else if(curv[i].getUsrRoleCd().length() == 5)
            {
                // 2021 Permission 'CGM01','CGM02'
                if( curv[i].getUsrRoleCd().equals("CGM01") || curv[i].getUsrRoleCd().equals("CGM02"))
                {
                    tRole = "Authenticated";
                    break;
                }
            }else
            {
                tRole = "Not Authenticated";
            }
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
  }
</script>

<form name="form2"><input id="sXml" name="sXml" value="<%=xml.replace(" \"","'") %>" type="hidden" /></form>
<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<!-- Form Hidden -->
<input id="action_flag" name="action_flag" type="hidden" />
<input id="intg_cd_id" name="intg_cd_id" type="hidden" />
<input id="ofc_cd" name="ofc_cd" type="hidden" value="<%=ofc_cd%>"/>
<input id="eq_knd_cd" name="eq_knd_cd" type="hidden" />
<input id="agmt_ofc_cty_cd" name="agmt_ofc_cty_cd" type="hidden" />
<input id="agmt_seq" name="agmt_seq" type="hidden" />
<input id="lst_ver_flg" name="lst_ver_flg" type="hidden" />
<input id="pre_eff_dt" name="pre_eff_dt" type="hidden" />
<input id="pre_exp_dt" name="pre_exp_dt" type="hidden" />
<input id="pre_agmt_exp_dt" name="pre_agmt_exp_dt" type="hidden" />
<input id="trole" name="trole" value="<%=tRole%>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_New" name="btn_New" class="btn_normal">New</button><!--
		--><button type="button" id="btn_Save" name="btn_Save" class="btn_normal">Save</button><!--
		--><button type="button" id="btn_Delete" name="btn_Delete" class="btn_normal">Delete</button><!--
		--><button type="button" id="btn_VersionUp" name="btn_VersionUp" class="btn_normal">Version Up</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80" />
					<col width="100" />
					<col width="80" />
					<col width="80" />
					<col width="70" />
					<col width="100" />
					<col width="70" />
					<col width="100" />
					<col width="100" />
					<col width="100" />
					<col width="123" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Agreement No.</th>
	                <td><input id="agmt_no" name="agmt_no" dataformat="engup" maxlength="9" style="width:80px; ime-mode:disabled" class="input1" type="text" /><button class="input_seach_btn" name="btns_agmtno" id="btns_agmtno" type="button"></button></td>
	                <th>Version</th>
	                <td><script type="text/javascript">ComComboObject('agmt_ver_no', 1, 50, 1, 0, 0, false);</script></td>
	                <th>Ref. No.</th>
	                <td><input id="agmt_ref_no" name="agmt_ref_no" dataformat="engup" otherchar="-_" maxlength="15" style="width:110px; ime-mode:disabled" class="input" type="text" /> </td>
	                <th>Contract No.</th>
	                <td><input id="agmt_ctrt_no" name="agmt_ctrt_no" dataformat="engup" otherchar="-_" maxlength="15" style="width:110px; ime-mode:disabled" class="input" type="text" /> </td>
	                <th>Currency</th>
	                <td><input id="curr_cd" name="curr_cd" readonly style="width: 60px; text-align:center;ime-mode:disabled" class="input2" type="text" /><button class="input_seach_btn" name="btns_curr_cd" id="btns_curr_cd" type="button"></button></td>
	                <th>Agreement Office</th>
	                <td><input id="agmt_iss_ofc_cd" name="agmt_iss_ofc_cd" dataformat="engup" maxlength="6" style="width:80px; text-align: center;" class="input1" type="text" />
<!-- 	                <button class="input_seach_btn" name="btns_office" id="btns_office" type="button"></button> -->
	                </td>
					<th>Old AGMT No.</th>
					<td><input type="text" name="old_agmt_no" id="old_agmt_no" style="width:100px;" class="input2" value="" dataformat="engup" ></td>
				</tr>
			</table>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="91" />
					<col width="42" />
					<col width="40" />
					<col width="80" />
					<col width="135" />
					<col width="*" />
				</colgroup>				
				<tr>
					<th>Lease Term</th>
		            <td><script type="text/javascript">ComComboObject('agmt_lstm_cd', 1, 100, 0, 1, 0, false);</script></td>
		            <th>Agreement Date</th>
		            <td>
		            	<input id="agmt_dt" name="agmt_dt" dataformat="ymd" maxlength="10" style="width: 80px; text-align: center; ime-mode:disabled" class="input1" type="text" /><!--
		            	 --><button class="calendar ir" name="btns_Calendar_agmtDt" id="btns_Calendar_agmtDt" type="button"></button>
		            </td>
		            <th>Agreement Eff. Date</th>
		            <td>
		            	<input id="agmt_eff_dt" name="agmt_eff_dt" dataformat="ymd" maxlength="10" style="width:80px; text-align: center; ime-mode:disabled" class="input1" type="text" /><!--
		            	 --><button class="calendar ir" name="btns_Calendar_agmt_effDt" id="btns_Calendar_agmt_effDt" type="button"></button>~&nbsp;
		            	<input id="agmt_exp_dt" name="agmt_exp_dt" dataformat="ymd" maxlength="10" style="width:80px; text-align: center; ime-mode:disabled" class="input1" type="text" /><!--
		            	 --><button class="calendar ir" name="btns_Calendar_agmt_expDt" id="btns_Calendar_agmt_expDt" type="button"></button>
		            </td>
				</tr>
				<tr>
					  <th>Lessor</th>
		              <td colspan="3"><input id="vndr_seq" name="vndr_seq" dataformat="num" maxlength="6" style="width:100px; text-align: center; ime-mode:disabled" class="input1" type="text" /><input id="vndr_lgl_eng_nm" name="vndr_lgl_eng_nm" readonly style="width:350px;ime-mode:disabled" class="input2" type="text" /><button class="input_seach_btn" name="btns_vndr" id="btns_vndr" type="button"></button> </td>
		              <th>Rate Eff. Date</th>
		              <td>
		              	<input id="eff_dt" name="eff_dt" dataformat="ymd" maxlength="10" style="width:80px; text-align: center; ime-mode:disabled" class="input1" type="text" /><!--
		            	 --><button class="calendar ir" name="btns_Calendar_effDt" id="btns_Calendar_effDt" type="button"></button>~&nbsp;
		              	<input id="exp_dt" name="exp_dt" dataformat="ymd" readonly maxlength="10" style="width:80px; text-align: center; ime-mode:disabled" class="input2" type="text" />
		              </td>
				</tr>
			</table>
		</div>			
			<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="91" />
					<col width="148" />
					<col width="80" />
					<col width="186" />
					<col width="70" />
					<col width="*" />
				</colgroup>	
				<tr>
					<th>Payment Term</th>
	                <td><input id="pay_term_dys" name="pay_term_dys" dataformat="num" maxlength="5" style="width:77px;text-align:right;ime-mode:disabled" class="input" type="text" />   days</td>
	                <th>On-hire Handling Charge</th>
	                <td><input id="onh_hndl_rt_amt" name="onh_hndl_rt_amt" maxlength="18" dataformat="float" pointcount="2" caption="On-Hire Handling Charge" style="width:80px;text-align:right;ime-mode:disabled" class="input" type="text" /> </td>
	                <th>Off-hire Handling Charge</th>
	                <td><input id="offh_hndl_rt_amt" name="offh_hndl_rt_amt" maxlength="18" dataformat="float" pointcount="2" caption="Off-Hire Handling Charge" style="width:80px;text-align:right;ime-mode:disabled" class="input" type="text" /> </td>
				</tr>
			</tbody>
		</table>		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>


	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="55" />
						<col width="150" />
						<col width="50" />
						<col width="200" />
						<col width="50" />
						<col width="100"/>
						<col width="*" />
					</colgroup>
					<tr>
						<th>Monthly Depreciation</th>
				        <td><input id="mon_dpc_rt_amt" name="mon_dpc_rt_amt" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Monthly Depreciation" style="width:100px;text-align:right;ime-mode:disabled" class="input" type="text" />   %</td>
				        <th>Max. Depreciation</th>
				        <td><input id="max_dpc_rt_amt" name="max_dpc_rt_amt" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Max. Depreciation" style="width:100px;text-align:right;ime-mode:disabled" class="input" type="text" />   %</td>
				        <th>Initial Factor</th>
				        <td class="sm"><input type="text" name="init_dpc_rt_amt" maxnum="999999999999999.99" dataformat="float" pointcount="2" caption="Initial Factor" style="width:100;text-align:right;ime-mode:disabled" class="input">%</td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<script type="text/javascript">ComSheetObject('t3sheet2');</script>
		</div>
	</div>
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t3sheet3');</script>
	</div>
	
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
      <table class="search">
    	  <tr class="" align="center">
    	  	<td><textarea name="diff_rmk" id="diff_rmk" style="width: 100%; height: 130px; ime-mode:disabled"></textarea></td>
     	 </tr>
      </table>
	</div>	

</div>
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<script tpye="text/javascript">ComSheetObject('sheet2');</script>
</div>

</form>