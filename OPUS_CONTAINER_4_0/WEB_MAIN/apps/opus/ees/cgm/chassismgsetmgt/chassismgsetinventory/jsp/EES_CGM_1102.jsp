<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1102.jsp
*@FileTitle  : Chassis Variation Status Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1102Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String crntLocCd =  StringUtil.xssFilter(request.getParameter("crnt_loc_cd"));
	String includeEnParam = StringUtil.xssFilter(request.getParameter("include_en_param"));
	String includeNpParam = StringUtil.xssFilter(request.getParameter("include_np_param"));
	String inqFmDys = StringUtil.xssFilter(request.getParameter("inq_fm_dys"));
	String inqToDys = StringUtil.xssFilter(request.getParameter("inq_to_dys"));
	String locationParam = StringUtil.xssFilter(request.getParameter("location_param"));
	
	
	crntLocCd = crntLocCd==null ?  "" : crntLocCd;
	includeEnParam = includeEnParam == null ? "" : includeEnParam;
	includeNpParam = includeNpParam == null ? "" : includeNpParam;
	inqFmDys = inqFmDys ==  null ? "" : inqFmDys;
	inqToDys = inqToDys ==  null ? "" : inqToDys;
	locationParam = locationParam == null ? "" : locationParam;
	
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- developer working -->
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="include_en_param" id="include_en_param" />
<input type="hidden" name="include_np_param" id="include_np_param" />
<input type="hidden" name="location_param" value="<%=locationParam %>" id="location_param" />
<input type="hidden" name="eq_orz_cht_chktype" id="eq_orz_cht_chktype" />
<input type="hidden" name="eq_orz_cht_rcc_cd" id="eq_orz_cht_rcc_cd" />
<input type="hidden" name="eq_orz_cht_lcc_cd" id="eq_orz_cht_lcc_cd" />
<input type="hidden" name="eq_orz_cht_scc_cd" id="eq_orz_cht_scc_cd" />
<input type="hidden" name="back_end_job_key" id="back_end_job_key" />
<input type="hidden" name="location" id="location" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down&nbsp;Excel</button><!--
	--></div>
<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
	
</div>
<!-- page_title_area(E) -->

<!-- wrap_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="1" />
				<col width="280" />
				<col width="100" />
				<col width="150" />
				<col width="50" />
				<col width="150" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Location</th>
					<td ><script type="text/javascript">ComComboObject("combo_location", 1, 75, 0, 1, 0, true);</script><!-- 
					 --><input type="text" name="crnt_loc_cd" id="crnt_loc_cd" dataformat="engup" maxlength="5" style="width:95px;ime-mode:disabled" class="input1" value="<%=crntLocCd %>"><!-- 
					 --><button type="button" name="btns_crnt_loc_cd" id="btns_crnt_loc_cd" class="input_seach_btn"></button><!-- 
					 --></td>					
					<th><label for="include_en">Include 'EN'</label><input type="checkbox" name="include_en" id="include_en" value="" class="trans" <%= includeEnParam  %>></th>
					<th><label for="include_np">Include 'NP'</label><input type="checkbox" name="include_np" id="include_np" value="" class="trans" <%= includeNpParam  %>></th>
					<td></td>
					<th class="sm"><input type="radio" name="doc_type" value="" class="trans" checked="" id="doc_type" onclick="doc_type_change()"/> Summary<input type="radio" name="doc_type" value="" class="trans" id="doc_type" onclick="doc_type_change()"/> Detailed</th>
					<td></td>
				</tr>
				<tr>
					<th>Period</th>
					<td><input type="text" name="inq_fm_dys" id="inq_fm_dys" style="width: 75px;ime-mode:disabled" dataformat="ymd" class="input1" maxlength="10" value="<%=inqFmDys %>"/>~ <input type="text" name="inq_to_dys" id="inq_to_dys" style="width:82px;ime-mode:disabled" dataformat="ymd" class="input1" maxlength="10" value="<%=inqToDys %>" /><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir"></button></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="summaryLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="detailLayer" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_grid" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>