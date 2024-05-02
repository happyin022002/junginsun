<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0003.jsp
*@FileTitle  : KeyMan Info Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.event.EsmSam0003Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmSam0003Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String pCustCd = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralInfoManage.KeyManInfoManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmSam0003Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		 pCustCd = JSPUtil.getNull(request.getParameter("cust_cd"));
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<title>KeyMan Info Management</title>


<script type="text/javascript">
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
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ibflag" value="R" id="ibflag" />
<input type="hidden" name="cust_kman_seq" value="" id="cust_kman_seq" />
<input type="hidden" name="cust_nm" value="" id="cust_nm" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button>
		<button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button>
		<button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button>
		<button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Customer Code</th>
		   			<td>
		   			<input type="text" style="width: 100px; text-align:center;" class="input1" name="cust_cd" dataformat="engup" maxlength="8" value="<%=pCustCd%>" id="cust_cd" onKeyDown="ComKeyEnter()"/> 
		   			<button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button>
		   			</td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_RowAdd" id="btn_RowAdd" type="button">Row Add</button>
			</div>
		<!-- opus_design_btn (E) -->	
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<h3 class="title_design">Detail Info</h3>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry ">
		<table>
			<colgroup>
				<col width="100" />				
				<col width="405" />				
				<col width="200" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>First Name</th>
					<td><input type="text" style="width: 370px;" class="input1" name="kman_n1st_nm" maxlength="50" id="kman_n1st_nm" /></td>
					<th>Customer</th>
					<td><input type="text" style="width: 75px;" class="input2" name="cust_cd1" maxlength="8" id="cust_cd1" /><input type="text" style="width: 175px;" class="input2" name="cust_lgl_eng_nm" maxlength="40" id="cust_lgl_eng_nm" /></td>
		   		</tr>
		   		<tr>
		   			<th>Last Name</th>
					<td><input type="text" style="width: 370px;" class="input1" name="kman_lst_nm" maxlength="50" id="kman_lst_nm" /></td>
					<th>Country Phone</th>
					<td><input type="text" style="width: 254px;" class="input" name="intl_phn_no" maxlength="4" dataformat="num" id="intl_phn_no" /></td>
		   		</tr>
		   		<tr>
		   			<th>Female/Male</th>
		   			<td><script type="text/javascript">ComComboObject('kman_gnd_cd', 1, 100, 1, 1 ,0 ,false)</script></td>
		   			<th>Email</th>
		   			<td><input type="text" style="width: 254px;" class="input1" name="kman_eml" maxlength="50" id="kman_eml" /></td>
		   		</tr>
		   		<tr>
		   			<th>Job Title</th>
					<td><input type="text" style="width: 370px;" class="input1" name="jb_tit_rmk" maxlength="100" id="jb_tit_rmk" /></td>
					<th>In Charge of</th>
					<td><input type="text" style="width: 254px;" class="input1" name="chg_desc" maxlength="100" id="chg_desc" /></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="160" />				
				<col width="110" />				
				<col width="120" />				
				<col width="200" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Department</th>
					<td><input type="text" style="width: 127px;" class="input" name="kman_dept_desc" maxlength="100" id="kman_dept_desc" /></td>
					<th>Significance</th>
                    <td><script type="text/javascript">ComComboObject('kman_sgnf_ind_cd', 1, 100, 1, 0 ,0 ,false)</script></td>
					<th>Nick Name</th>
					<td><input type="text" style="width: 254px;" class="input" name="kman_nknm_nm" maxlength="100" id="kman_nknm_nm" /></td>
		   		</tr>
		   		<tr>
		   			<th>Birth Day</th>
					<td><input type="text" style="width: 98px;" class="input1" name="kman_brdy_dt" dataformat="ymd" maxlength="10" id="kman_brdy_dt" /><button type="button" id="btn_cal1_kmanbd" name="btn_cal1_kmanbd" class="calendar ir"></button></td>
					<th>Education</th>
                    <td width="132"><script type="text/javascript">ComComboObject('kman_edu_cate_cd', 1, 100, 1, 0 ,0 ,false)</script></td>
					<th>Major</th>
					<td><input type="text" style="width: 254px;" class="input" name="kman_mjr_desc" maxlength="100" id="kman_mjr_desc" /></td>
		   		</tr>
		   		<tr>
		   			<th>Hobby</th>
					<td><input type="text" style="width: 127px;" class="input" name="kman_hby_desc" maxlength="100" id="kman_hby_desc" /></td>
					<th>Single/Married</th>
                    <td width="132"><script type="text/javascript">ComComboObject('kman_marr_flg', 1, 100, 1, 0 ,0 ,false)</script></td>
					<th>Work Fax#</th>
					<td><input type="text" style="width: 254px;" class="input" name="kman_ofc_fax_no" maxlength="20" dataformat="num" id="kman_ofc_fax_no" /></td>
		   		</tr>
		   		<tr>
		   			<th>Spouse Name</th>
					<td><input type="text" style="width: 127px;" class="input" name="kman_sps_nm" maxlength="100" id="kman_sps_nm" /></td>
					<th>Spouse Birth Date</th>
					<td><input type="text" style="width: 100px;" class="input" name="kman_sps_brdy_dt" dataformat="ymd" maxlength="10" id="kman_sps_brdy_dt" /><button type="button" id="btn_cal1_spbd" name="btn_cal1_spbd" class="calendar ir"></button></td>
					<th>Wedding Anniversary Date</th>
					<td><input type="text" style="width: 93px;" class="input" name="kman_wedd_anv_dt" dataformat="ymd" maxlength="10" id="kman_wedd_anv_dt" /><button type="button" id="btn_cal1_wedt" name="btn_cal1_wedt" class="calendar ir"></button></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Office Address</th>
					<td><input type="text" style="width: 860px;" class="input" name="kman_ofc_addr" maxlength="200" id="kman_ofc_addr" /></td>
		   		</tr>
		   		<tr>
		   			<th>Home Address</th>
					<td><input type="text" style="width: 860px;" class="input" name="kman_hm_addr" maxlength="200" id="kman_hm_addr" /></td>
		   		</tr>
		   		<tr>
		   			<th>BIZ Issue</th>
					<td><input type="text" name="biz_iss_desc" style="height: 45px; width: 860px; padding: 0px" maxlength="500" id="biz_iss_desc" /></td>
		   		</tr>
		   		<tr>
		   			<th>Remark</th>
					<td><input type="text" name="kman_rmk_desc" style="height: 45px; width: 860px; padding: 0px" maxlength="500" id="kman_rmk_desc" /></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>