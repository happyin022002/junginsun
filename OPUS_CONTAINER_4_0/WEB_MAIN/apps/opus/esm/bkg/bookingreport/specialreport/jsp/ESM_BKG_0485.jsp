<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0485.jsp
*@FileTitle  : Special Cargo Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.SpecialReport");
	
	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	if (home !=null) fileDir.append(home);
	String separator = System.getProperty("file.separator");
	if (separator !=null) fileDir.append(separator);
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_nm" value="<%=strUsr_nm%>" id="usr_nm" />

<input type="hidden" name="in_out" id="in_out" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=fileDir.toString()%>" id="com_mrdSaveDialogDir" />
<input type="hidden" name="com_mrdSaveDialogFileName" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdDisableToolbar" value="3" id="com_mrdDisableToolbar" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="com_zoomIn" id="com_zoomIn" />
<input type="hidden" name="com_isBatch" value="N" id="com_isBatch" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">		
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>			
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
	 <h3 class="title_design mar_top_12">Special Cargo Manifest Type</h3>
	<!--  biz_1  (S) -->
	<table>
		<colgroup>
		 	<col width="700;"/>
		 	<col width="*"/>
		</colgroup>
		<tbody>
			<tr>
				<td class="pad_left_8 sm">
					<input name="rdo_manifest_type" type="radio" value="DG" class="trans" id="rdo1_1" checked onChange="javascript:fnMfType(this);"><label for="rdo1_1">Danger</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
					 --><input name="rdo_manifest_type" type="radio" value="AW" class="trans" id="rdo1_2" onChange="javascript:fnMfType(this);"><label for="rdo1_2">Awkward</label>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
					 --><input name="rdo_manifest_type" type="radio" value="BB" class="trans" id="rdo1_3" onChange="javascript:fnMfType(this);"><label for="rdo1_3">Break Bulk</label>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
					 --><input name="rdo_manifest_type" type="radio" value="RF" class="trans" id="rdo1_4" onChange="javascript:fnMfType(this);"><label for="rdo1_4">Reefer</label>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
					 --><input name="rdo_manifest_type" type="radio" value="SS" class="trans" id="rdo1_5" onChange="javascript:fnMfType(this);"><label for="rdo1_5">Special Stowage</label>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
					 --><input name="rdo_manifest_type" type="radio" value="PC" class="trans" id="rdo1_6" onChange="javascript:fnMfType(this);"><label for="rdo1_6">Precaution</label>
				</td>
			</tr>
			<tr>
				<td class="pad_left_8 sm">
					[&nbsp;<input type="checkbox" name="dg_flg_type1" id="dg_flg_type1" checked><label for="dg_flg_type1">Own</label>&nbsp;
					<input type="checkbox" name="dg_flg_type2" id="dg_flg_type2" checked><label for="dg_flg_type2">Partner</label>]
				</td>
			</tr>
		</tbody>
	</table>
	<!--  biz_1   (E) -->

	<table class="height_10"><tr><td></td></tr></table>
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width:50%">
	    <div clas="opus_design_inquiry">
	       <h3 class="title_design mar_top_12">VVD & POL / POD</h3>
	       <table class="sm mar_btm_4">
	       		<colgroup>
	       			<col width="40"/>
	       			<col width="120"/>
	       			<col width="30"/>
	       			<col width="*"/>
	       		</colgroup>
	       		<tbody>
					<tr>
						<td colspan="4" class="pad_left_8">
							<input name="rdo_in_out" type="radio" value="IN" class="trans" id="rdo2_1" checked><label for="rdo2_1">Inbound</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
							 --><input name="rdo_in_out" type="radio" value="OUT" class="trans" id="rdo2_2"><label for="rdo2_2">Outbound</label>
						</td>
					</tr>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td colspan="3">
	                        <input type="text" name="vvd_cd" id="vvd_cd" value="" maxlength="9" class="input1" required dataformat="engup" style="width:110px;ime-mode:disabled">&nbsp;
							<input type="radio" name="rdo_local_ts" id="rdo3_0" value="ALL" class="trans" id="rdo3_0" checked>&nbsp;<label for="rdo3_0">All</label>&nbsp;&nbsp;&nbsp;
							<input type="radio" name="rdo_local_ts" id="rdo3_1" value="LOCAL" class="trans" id="rdo3_1">&nbsp;<label for="rdo3_1">Local</label>&nbsp;&nbsp;&nbsp;
							<input type="radio" name="rdo_local_ts" id="rdo3_2" value="TS" class="trans" id="rdo3_2">&nbsp;<label for="rdo3_2">T/S</label>
						</td>
					</tr>
					<tr>
						<th title="Port of Loading">POL</th>
						<td>
							<input type="text" name="vvd_pol" id="vvd_pol" value="" maxlength="5" class="input" dataformat="engup" style="width:60px;ime-mode:disabled">
							<input type="text" name="pol_yd_cd" id="pol_yd_cd" value="" maxlength="2" class="input" dataformat="engup" style="width:30px;ime-mode:disabled">
						</td>
						<th title="Port of Discharging">POD</th>
						<td>
							<input type="text" name="vvd_pod" id="vvd_pod" value="" maxlength="5" class="input1" dataformat="engup" style="width:60px;ime-mode:disabled" required><!-- 
							 --><input type="text" name="pod_yd_cd" id="pod_yd_cd" value="" maxlength="2" class="input" dataformat="engup" style="width:30px;ime-mode:disabled">
						</td>
					</tr>
					<tr><td colspan="4" height="5"></td></tr>
				</tbody>
			</table>
			</div>
	    </div>
	    <div class="layout_vertical_2" style="width:50%">
	    	<div clas="opus_design_inquiry" style="padding-left:20px;">
		    	<h3 class="title_design mar_top_12">Booking Route</h3>
				<table class="sm">
					<colgroup>
		       			<col width="40"/>
		       			<col width="100"/>
		       			<col width="30"/>
		       			<col width="*"/>
		       		</colgroup>
					<tbody>
						<tr><td colspan="4" height="8"></td></tr>
						<tr>
							<th title="Place of Receipt">POR</th>
							<td><input name="por_cd" id="por_cd" type="text" maxlength="5" style="width:60px;ime-mode:disabled" class="input" dataformat="engup" value=""></td>
							<th title="Port of Loading">POL</th>
							<td><input name="pol_cd" id="pol_cd" type="text" maxlength="5" style="width:60px;ime-mode:disabled" class="input" dataformat="engup" value=""></td>
						</tr>
                       <tr><td colspan="4" height="3"></td></tr>
						<tr>
							<th title="Port of Discharging">POD</th>
							<td><input name="pod_cd" id="pod_cd" type="text" maxlength="5" style="width:60px;ime-mode:disabled" class="input" dataformat="engup" value=""></td>
							<th title="Place of Delivery">DEL</th>
							<td><input name="del_cd" id="del_cd" type="text" maxlength="5" style="width:60px;ime-mode:disabled" class="input" dataformat="engup" value=""></td>
						</tr>
						<tr><td colspan="4" height="8"></td></tr>
					</tbody>
				</table>
			</div>
	    </div>
	</div>
	<!-- layout_wrap(e) -->
	
			
	</div>		
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">		
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">rdViewerObject('report1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">		
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>

<form name="form2" id="form2">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="vsl_cd" id="vsl_cd" />
	<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
	<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
	<input type="hidden" name="pol_cd" id="pol_cd" />
	<input type="hidden" name="pod_cd" id="pod_cd" />
	<input type="hidden" name="pol_yd_cd" id="pol_yd_cd" />
	<input type="hidden" name="pod_yd_cd" id="pod_yd_cd" />
	<input type="hidden" name="io_bnd_cd" id="io_bnd_cd" />
</form>

