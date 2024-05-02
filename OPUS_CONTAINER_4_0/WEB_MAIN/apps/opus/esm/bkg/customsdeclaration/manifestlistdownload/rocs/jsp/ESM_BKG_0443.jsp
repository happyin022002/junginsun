<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0443.jsp
*@FileTitle  : CRN Create
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0443Event"%><%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0443Event  event = null;	
Exception serverException   = null;			//error from server
String strErrMsg = "";						//Error message
int rowCount	 = 0;						//DB ResultSet list count

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String ofc_cd           = "";

String cn_no           = "";
String vvd_no           = "";

Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	
   	cn_no = request.getParameter("crn_no")==null?"":request.getParameter("crn_no");
   	vvd_no = request.getParameter("vvd_no")==null?"":request.getParameter("vvd_no");   	
   
	ofc_cd    = account.getOfc_cd(); 
	strUsr_id = account.getUsr_nm();

	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_user_id" value ="<%=strUsr_id%>" id="f_user_id" />
<input type="hidden" name="frm_user_ofc_cd" value ="<%=ofc_cd%>">
<input type="hidden" name="f_flag" value ="SEARCH">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="frm_vsl_cd"> 
<input type="hidden" name="frm_skd_voy_no"> 
<input type="hidden" name="frm_skd_dir_cd">
<input type="hidden" name="frm_crn_number">
<input type="hidden" name="err_msg">
<input type="hidden" name="ibflag">
<input type="hidden" name="cn_no" value="<%=StringUtil.xssFilter(cn_no)%>" id="cn_no" />
<input type="hidden" name="vvd_no" value="<%=StringUtil.xssFilter(vvd_no)%>" id="vvd_no" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 		
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_changeCrn" id="btn_changeCrn">Change CRN</button><!-- 
		--><button type="button" class="btn_normal" name="btn_list" id="btn_list">List</button><!-- 	
	--></div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table id="mainTable" style="width:979px;">
			<colgroup>
				<col width="110">
				<col width="*">
			</colgroup>
			<tbody> 
				<tr>
					<th>CRN</th>
					<td width=""><input name="frm_vsl_call_ref_no" id="frm_vsl_call_ref_no"  style="ime-mode: disabled;width:110px;" maxlength="13" dataformat="engup" type="text"  value=""></td>
				</tr>
			</tbody>
		</table>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<table style="width:979px;">
			<colgroup>
				<col width="110">
				<col width="*">
			</colgroup>
			<tbody> 
				<tr>
					<th>VVD Name</th>
					<td><input type="text" style="width:110px;ime-mode: disabled" class="input1"  name = "frm_vvd_number" id = "frm_vvd_number" dataformat="engup"  id="frm_vvd_number"  maxlength="9" ><!--  
						--><input name = "frm_vsl_eng_nm" id = "frm_vsl_eng_nm" type="text" style="width:250px;" class="input2" readonly  value=" ">
					</td>
				</tr>
			</tbody>
		</table>			
	
		<table style="width:979px;">
			<colgroup>
				<col width="110">
				<col width="190">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:110px;" class="input2" readonly  value="NLRTM"></td>
					<th>Call Date</th>
					<td><input name= "frm_vps_eta_dt" id= "frm_vps_eta_dt" type="text" style="width:147px;" class="input2" readonly  value=" "></td>
				</tr>
				<tr>
					<th>DEM Free Time</th>
					<td><input name= "frm_dem_free_dt" id= "frm_dem_free_dt" maxlength="8" type="text" style="width:110px;" class="input"  dataformat="ymd" style="ime-mode: disabled"  reqEsmred><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>
					<th>Berth Code</th>
					<td><%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeCombo("frm_brth_ctnt", "NL", "BERTH_CD","")%></td>

				</tr>
			</tbody>
		</table>
			
		<table style="width:662px; background-color:white;" class="grid2">
			<colgroup>
				<col width="110">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th class="tr2_head" style="text-align:center"><strong>N/L Text</strong></th>
					<td><textarea value = "" dataformat="engupetc" style="ime-mode: disabled;width:100%;resize:none;" name= "frm_ntfy_ltr_ctnt" id= "frm_ntfy_ltr_ctnt" rows="6"></textarea></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<table style="width:979px;"> 
			<colgroup>
					<col width="110">
					<col width="190">
					<col width="100">
					<col width="*">
				</colgroup>
			<tbody>
				<tr>
					<th>Creation ID</th>
					<td><input name= "frm_cstms_decl_usr_id" id= "frm_cstms_decl_usr_id" readonly type="text" style="width:110px;" class="input2" value=""></td>
					<th>Create Date</th>
					<td><input name= "frm_cre_dt" id= "frm_cre_dt" readonly type="text" style="width:145px;" class="input2" value=""></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">	
	<div class="opus_design_grid" style="display:none">						
	    <script type="text/javascript">ComSheetObject('sheet1');</script>					    
	</div>
</div>		

</form>