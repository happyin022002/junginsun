<%/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : ui_bkg_0444.jsp
*@FileTitle : B/L Inquiry
*@author : CLT
*@version : 1.0
*@since : 2014.05.09
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 
Exception serverException   = null;			//error from server
String strErrMsg = "";						//error message
int rowCount	 = 0;						//count of DB resultSET list

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String ofc_cd           = "";
String cn_no= "";
String frm_bl_no= ""; 
String vvd_no= ""; 
Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	
   	cn_no = request.getParameter("crn_no")==null?"":request.getParameter("crn_no");
   	vvd_no = request.getParameter("vvd_no")==null?"":request.getParameter("vvd_no");
	strUsr_id =	account.getUsr_id();
	ofc_cd    = account.getOfc_cd();  
	strUsr_nm = account.getUsr_nm();

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
		$('<button type="button" class="btn_accent" name="btn_retrieve"	id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_bl"  	id="btn_bl">Data Download</button>').appendTo("#btnArea");
//         $('<button type="button" class="btn_normal" name="btn_crn" 	id="btn_crn">CRN Creation</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_list"   id="btn_list">B/L List</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_addLane" 	id="btn_addLane">Add Lane</button>').appendTo("#btnArea");
        $('#btn_downexcel').after($('#btn_Close'));
		loadPage();
	}
</script>
	<form name="form" method="post">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="f_flag" value="SEARCH" id="f_flag" />
	<input type="hidden" name="pagerows" id="pagerows" />
	<input type="hidden" name="vsl_cd" id="vsl_cd" />
	<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
	<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
	<input type="hidden" name="mt_flag" id="mt_flag" />
	<input type="hidden" name="pol_cd" id="pol_cd" />
	<input type="hidden" name="cntr_no" id="cntr_no" />
	<input type="hidden" name="pg_no" value="esm0444" id="pg_no" />
	<input type="hidden" name="dif_chr" id="dif_chr" />
	<input type="hidden" name="bkg_no_split" id="bkg_no_split" />
	<input type="hidden" name="frm_slan_cd" id="frm_slan_cd" />
	<input type="hidden" name="crn_number" id="crn_number" />
	<input type="hidden" name="lane_cd" id="lane_cd" />
	<input type="hidden" name="etc_bkg_no" id="etc_bkg_no" />
	<input type="hidden" name="vsl_call_ref_no" id="vsl_call_ref_no" />
	<input type="hidden" name="cn_no" value="<%=StringUtil.xssFilter(cn_no)%>" id="cn_no" />
	<input type="hidden" name="vvd_no" value="<%=StringUtil.xssFilter(vvd_no)%>" id="vvd_no" />
	<input type="hidden" name="user_id" value="<%=strUsr_id%>" id="user_id" />

	<!-- start	-->
	<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
	
	<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
		    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <table>
		        <colgroup>
		            <col width="90" />
		            <col width="190" />
		            <col width="60" />
		            <col width="120" />
		            <col width="40" />
		            <col width="130" />
		            <col width="100" />
		            <col width="100" />
		            <col width="" />
		        </colgroup>
		        <tbody>
					
					<tr>
						<th>Call Date(ETA)</th>
						<td><input type="text" style="width: 85px; ime-mode: disabled" class="input1" maxlength="10" dataformat="ymd" maxlength="10" name="vps_eta_start_dt" id="vps_eta_start_dt" caption="ETA">~ <input type="text" style="width: 85px; ime-mode: disabled" class="input1" maxlength="10" dataformat="ymd" maxlength="10" name="vps_eta_end_dt" id="vps_eta_end_dt" caption="ETA"><!--
						--><button type="button" name="btn_calendar" id="btn_calendar"  class="calendar ir"></button></td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input name="vvd_number" id="vvd_number" dataformat="engup" style="ime-mode: disabled;width:100px" maxlength="9"  type="text" value="" class="input1"></td>
						<th>CRN</th>
						<td><input name="frm_crn_number" id="frm_crn_number"  style="ime-mode: disabled;width:120px" dataformat="engup"  maxlength="14" type="text" value="" class="input1"></td>
						<th>Creation Status</th>					
						<td><%=JSPUtil.getCodeCombo("slan_cd", "", "style='width:80px'", "CD01999", 0, "")%></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
		    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="width:800px">
		    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet2');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<%if(!mainPage.equals("true")){	%></div><%}%>
</form>
