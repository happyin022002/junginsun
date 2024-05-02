<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1162.jsp
*@FileTitle  : ESM_BKG_1162
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.event.EsmBkg1162Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1162Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	//String whereGubun = request.getParameter("pgmNo");
	String whereGubun = "ESM_BKG_1162";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1162Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="in_list_type" id="in_list_type" />
<input type="hidden" name="in_cntr_match" id="in_cntr_match" />
<input type="hidden" name="in_pol_ts" id="in_pol_ts" />
<input type="hidden" name="in_pod_ts" id="in_pod_ts" />
<input type="hidden" name="in_cntr_cfm_flg" id="in_cntr_cfm_flg" />
<input type="hidden" name="in_bkg_cgo_tp_cd_temp" id="in_bkg_cgo_tp_cd_temp" />

<input type="hidden" name="vvd_nkm" id="vvd_nkm" />
<input type="hidden" name="un_loc_cd" id="un_loc_cd" />
<input type="hidden" name="vps_eta_dt" id="vps_eta_dt" />
<input type="hidden" name="vps_etd_dt" id="vps_etd_dt" />
<input type="hidden" name="vps_etb_dt" id="vps_etb_dt" />
<input type="hidden" name="in_order_by_type" id="in_order_by_type" />
<input type="hidden" name="in_ofc_cd_type" id="in_ofc_cd_type" />
<input type="hidden" name="in_including_type" id="in_including_type" />
<input type="hidden" name="key" id="key" />
<input type="hidden" name="fax" id="fax" />
<input type="hidden" name="email" id="email" />
<input type="hidden" name="vessel_name" id="vessel_name" />

<input type="hidden" size="200" name="com_mrdPath" value="apps/opus/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0783.mrd" id="com_mrdPath" />
<input type="hidden" size="200" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" size="200" name="com_mrdTitle" value="Container Loading/Discharging List_Print" id="com_mrdTitle" />
<input type="hidden" size="200" name="com_mrdBodyTitle" value="<span style='color:red'>Container Loading/Discharging List_Print</span>" id="com_mrdBodyTitle" />
<!-- 개발자 작업	-->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downExcel" 	id="btn_downExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downXML" 	id="btn_downXML">Down XML</button>
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

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="30">
				<col width="100">
				<col width="30">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:80px;" name="vvd" class="input1" value="" required="" fullfill="" maxlength="9" dataformat="engup" caption="VVD" id="vvd" /> </td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" id="pod_cd" style="width:50px;" class="input1" name="pod_cd" value="" dataformat="engup" caption="POD" fullfill="" maxlength="5" />  </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
</form>