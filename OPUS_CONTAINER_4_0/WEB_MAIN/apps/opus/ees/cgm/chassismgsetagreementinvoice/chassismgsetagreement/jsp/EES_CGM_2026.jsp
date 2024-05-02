<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2026.jsp
*@FileTitle  : Lease Term Change
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2026Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm2026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= "";
	String form_day			= "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply

	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();
		form_day  = DateTime.getDateString().replace(".","");

		event = (EesCgm2026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        //chungpa 20100304 transaction role apply start
        UserRoleUtil uru = new UserRoleUtil();
        ComUsrRoleVO[] curv = uru.getUserRole(strUsr_id);
        for(int i=0; i< curv.length; i++)
        {
            //System.out.println("chungpa priority>>>>" + curv[i].getUsrRoleCd());
            if(curv[i].getUsrRoleCd().equals("ENISADM"))
            {
                tRole = "Authenticated";
                break;
            }else if(curv[i].getUsrRoleCd().length() == 5)
            {
                // 2026 Permission 'CGM01'
                if( curv[i].getUsrRoleCd().equals("CGM01")
                    // 2010-08-05 'CGM02' Permission 추가 - Rquest by Y.M.Lee
                    || curv[i].getUsrRoleCd().equals("CGM02")
                    //|| curv[i].getUsrRoleCd().equals("CGM03")
                    //|| curv[i].getUsrRoleCd().equals("CGM04")
                    //|| curv[i].getUsrRoleCd().equals("CGM05")
                    //|| curv[i].getUsrRoleCd().equals("CGM99")
                )
                {
                    tRole = "Authenticated";
                    break;
                }
            }else
            {
                tRole = "Not Authenticated";
            }
        }
        //chungpa 20100304 transaction role apply end
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

		document.form.ofc_cd.value = "<%=ofc_cd%>";
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- developer working -->

<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />

<input type="hidden" name="agmt_no" id="agmt_no" />

<input type="hidden" name="old_agmt_ofc_cty_cd" id="old_agmt_ofc_cty_cd" />
<input type="hidden" name="old_agmt_seq" id="old_agmt_seq" />
<input type="hidden" name="old_agmt_ver_no" id="old_agmt_ver_no" />

<input type="hidden" name="new_agmt_ofc_cty_cd" id="new_agmt_ofc_cty_cd" />
<input type="hidden" name="new_agmt_seq" id="new_agmt_seq" />
<input type="hidden" name="new_agmt_ver_no" id="new_agmt_ver_no" />

<input type="hidden" name="eq_no" id="eq_no" />
<input type="hidden" name="form_day" value="<%=form_day %>" id="form_day" />
<input type="hidden" name="trole" value="<%=tRole%>" id="trole" />

<!-- developer working -->

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--></div>
<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- search_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100">
				<col width="120">
				<col width="100">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody> 
				<tr>
					<th>Activity Date</th>
					<td> <input type="text" name="sts_evnt_dt" dataformat="ymd" maxlength="10" style="width:80px;ime-mode:disabled;text-align:center" class="input1" value="" id="sts_evnt_dt" /><button type="button" id="btns_Calendar_activityDt" name="btns_Calendar_activityDt" class="calendar ir"></button></td>
					<th>Office</th>
					<td><input type="text" style="width:87px;text-align:center" name="sts_evnt_ofc_cd" dataformat="engup" maxlength="6" class="input1" value="" id="sts_evnt_ofc_cd" /><button type="button" id="btns_office" name="btns_office" class="input_seach_btn"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
		<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
		<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100">
				<col width="120">
				<col width="100">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody> 
				<tr><td colspan="3"><h3 class="title_design">Current Status by Agreement</h3></td></tr>
				<tr>
					<th>Agreement No.</th>
					<td> <input type="text" name="old_agmt_no" dataformat="engup" maxlength="9" style="width:80px;ime-mode:disabled" class="input" value="" id="old_agmt_no" /><button type="button" id="btns_agmtno" name="btns_agmtno" class="input_seach_btn"></button></td>
					<th>Ref. No.</th>
					<td><input type="text" name="old_agmt_ref_no" maxlength="15" readonly style="width:118px;ime-mode:disabled" class="input2" value="" id="old_agmt_ref_no" /></td>
					<td></td>
				</tr>
				<tr>
					<th>Lease Term</th>
					<td> <input type="text" name="old_agmt_lstm_cd" readonly style="width:35px;ime-mode:disabled;text-align:center" class="input2" value="" id="old_agmt_lstm_cd" /> </td>
					<th>Lessor</th>
					<td><input type="text" name="old_vndr_seq" readonly style="width:118px;" class="input2" value="" id="old_vndr_seq" /><input type="text" name="old_vndr_lgl_eng_nm" readonly style="width:280px;" class="input2" value="" id="old_vndr_lgl_eng_nm" /> </td>
				</tr>
			</tbody>
		</table>		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- search_area(E) -->

<!-- result_area(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
		<div><h3 class="title_design">Current Status by M.G.Set</h3></div>
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_rowadd" id="btn_rowadd" type="button">Row Add</button><!--
				--><button class="btn_normal" name="btn_rowdelete" id="btn_rowdelete" type="button">Row Delete</button><!--
				--><button class="btn_normal" name="btn_Loadexcel" id="btn_Loadexcel" type="button">Load&nbsp;Excel</button><!--
				--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down&nbsp;Excel</button><!--
				--></div>
	<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="100">
					<col width="120">
					<col width="100">
					<col width="100">
					<col width="*">
				</colgroup>
				<tbody>
					<tr><td colspan="3"><h3 class="title_design">After Status</h3></td></tr> 
					<tr>
						<th>Agreement No.</th>
						<td><input type="text" name="new_agmt_no" dataformat="engup" maxlength="9" style="width:80px;ime-mode:disabled" class="input1" value="" id="new_agmt_no" /><button type="button" id="btns_new_agmtno" name="btns_new_agmtno" class="input_seach_btn"></button></td>
						<th>Ref. No.</th>
						<td><input type="text" name="new_agmt_ref_no" readonly style="width:110px;" class="input2" value="" id="new_agmt_ref_no" /> </td>
						<td></td>
					</tr>
					<tr>
						<th>Lease Term</th>
						<td><input type="text" name="new_agmt_lstm_cd" readonly style="width:35px;" class="input2" value="" id="new_agmt_lstm_cd" /> </td>
						<th>Lessor</th>
						<td><input type="text" name="new_vndr_seq" readonly style="width:110px;" class="input2" value="" id="new_vndr_seq" /><input type="text" name="new_vndr_lgl_eng_nm" readonly style="width:280px;" class="input2" value="" id="new_vndr_lgl_eng_nm" /> </td>
						<td></td>
					</tr>
				</tbody>
			</table>		
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->

<!-- hidden handling (S)-->
<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- hidden handling (S)-->
<!-- developer working end -->
</form>
