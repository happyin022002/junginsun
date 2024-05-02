<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1163.jsp
*@FileTitle  : Russia Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.event.EsmBkg1163Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
  	EsmBkg1163Event event = null; //PDTO(Data Transfer Object including Parameters) 
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		 event = (EsmBkg1163Event) request.getAttribute("Event"); 
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
		showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>

<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="pagerows" id="pagerows" />
	<input type="hidden" name="ch_usr_id" id="ch_usr_id" />
	<input type="hidden" name="curr_page" value="1" id="curr_page" />
	<input type="hidden" name="rows_per_page" value="50" id="rows_per_page" />
	<input type="hidden" name="order_by" value="" id="order_by" />
	<input type="hidden" name="order_by_title" value="" id="order_by_title" />

	<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
	<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
	<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
	<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
	<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />
	
	<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">DownExcel</button><!--
		--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
		--></div>
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
				<col width="40" />				
				<col width="160" />				
				<col width="50" />				
				<col width="80" />				
				<col width="50" />
				<col width="70" />				
				<col width="50" />				
				<col width="70" />	
				<col width="80" />				
				<col width="150" />		
				<col width="50" />	
				<col width="150" />			
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th class="sm">Mode</th>
					<td class="sm"><input type="radio" value="O" class="trans" name="mode_type" checked id="mode_type0" /><label for="mode_type0">Outbound</label><input type="radio" value="I" class="trans" name="mode_type" id="mode_type1" /><label for="mode_type1">Inbound</label></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:75px;ime-mode:disabled" class="input1" value="" name="vvd_cd" maxlength="9" dataformat="engup" id="vvd_cd" /> </td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:50px;" value="" class="input1" name="pol_cd" maxlength="5" dataformat="engup" id="pol_cd" /><input type="text" style="width:25px;" value="" class="input" name="pol_yd_cd" maxlength="2" dataformat="engup" id="pol_yd_cd" /></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:50px;" value="" class="input" name="pod_cd" maxlength="5" dataformat="engup" id="pod_cd" /><input type="text" style="width:25px;" value="" class="input" name="pod_yd_cd" maxlength="2" dataformat="engup" id="pod_yd_cd" /></td>
					<th class="sm">Cargo Type</th>
					<td class="sm"><input type="radio" value="ALL" class="trans" name="cargo_type" checked="" id="cargo_type3" /><label for="cargo_type3">All</label><input type="radio" value="F" class="trans" name="cargo_type" id="cargo_type4" /><label for="cargo_type4">Full</label><input type="radio" value="P" class="trans" name="cargo_type" id="cargo_type5" /><label for="cargo_type5">Empty</label></td>
					<th class="sm">Cargo Route</th>
					<td class="sm"><input type="radio" value="ALL" class="trans" name="cargo_route" checked="" id="cargo_route6" /><label for="cargo_route6">All</label><input type="radio" value="L" class="trans" name="cargo_route" id="cargo_route7" /><label for="cargo_route7">Local</label><input type="radio" value="T" class="trans" name="cargo_route" id="cargo_route8" /><label for="cargo_route8">T/S</label></td>
					<td></td>
		   		</tr>
		   	</tbody>
		  </table>
		  </div>
		   		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		   		<div class="opus_design_inquiry wFit">
		  <table>
			<colgroup>
				<col width="95" />				
				<col width="40" />				
				<col width="60" />				
				<col width="40" />				
				<col width="60" />
				<col width="40" />				
				<col width="60" />				
				<col width="40" />	
				<col width="60" />		
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr >
					<th class ="sm">Booking Route</th>
					<th class ="sm">POR</th>
					<td class ="sm"><input type="text" style="width:50px;" value="" class="input" name="br_por_cd" maxlength="5" dataformat="engup" id="br_por_cd" /></td>
					<th class ="sm">POL</th>
					<td class ="sm"><input type="text" style="width:50px;" value="" class="input" name="br_pol_cd" maxlength="5" dataformat="engup" id="br_pol_cd" /></td>
					<th class ="sm">POD</th>
					<td class ="sm"><input type="text" style="width:50px;" value="" class="input" name="br_pod_cd" maxlength="5" dataformat="engup" id="br_pod_cd" /></td>
					<th class ="sm">DEL</th>
					<td class ="sm"><input type="text" style="width:50px;" value="" class="input" name="br_del_cd" maxlength="5" dataformat="engup" id="br_del_cd" /></td>
					<td></td>
				</tr>
		   		
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="40" />				
					<col width="90" />				
					<col width="40" />				
					<col width="50" />				
					<col width="40" />
					<col width="90" />				
					<col width="40" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			<th title="Vessel Voyage Direction">VVD</th>
		   				<td><input type="text" style="width:80px;" class="input2" value="" readonly name="hd_vvd_cd" id="hd_vvd_cd" /> </td>
		   				<th id="hd_pol_pod" name="hd_pol_pod" >POL</th>
		   				<td><input type="text" style="width:50px;" class="input2" value="" readonly name="hd_pol_pod_cd" id="hd_pol_pod_cd" /> </td>
		   				<th id="hd_eta_etd" name="hd_eta_etd" >ETD</th>
		   				<td><input type="text" style="width:80px;" class="input2" value="" readonly name="hd_eta_etd_cd" id="hd_eta_etd_cd" /> </td>
		   				<th>Mode</th>
		   				<td><input type="text" style="width:80px;" class="input2" value="" readonly name="hd_mode_type" id="hd_mode_type" /> </td>
			   		</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_check_all" id="btn_check_all">Check All</button><!--
			--><button class="btn_normal" id="btn_uncheck_all" type="button" name="btn_uncheck_all">Uncheck All</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>


<div class="opus_design_RD" style="display:inline">
	<script type='text/javascript'>rdViewerObject('report1');</script>
</div>  
<!--Button (E) --> 
<!-- 개발자 작업  끝 -->
</form>
<form name="form2" method="POST">
	<input type="hidden" name="message" id="message" />
</form>
<form name="form3" method="post">
	<input type="hidden" name="bkg_no" id="bkg_no" />
	<input type="hidden" name="mode_type" id="mode_type" />
	<input type="hidden" name="vvd_cd" id="vvd_cd" />
	<input type="hidden" name="pol_cd" id="pol_cd" />
	<input type="hidden" name="pol_yd_cd" id="pol_yd_cd" />
	<input type="hidden" name="pod_cd" id="pod_cd" />
	<input type="hidden" name="pod_yd_cd" id="pod_yd_cd" />
</form>
