<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0596.jsp
*@FileTitle  : Manual BDR
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0596Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0596Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0596Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<input type="hidden" name="vsl_cd" id="vsl_cd">
<input type="hidden" name="skd_voy_no" id="skd_voy_no">
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd">
<input type="hidden" name="vps_port_cd" id="vps_port_cd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_BKGBDR"  	id="btn_BKGBDR">BKG BDR</button><!--
		--><button type="button" class="btn_normal" name="btn_VVDBDR" 		id="btn_VVDBDR">VVD BDR</button><!--
		--><button type="button" class="btn_normal" name="btn_C_BKGBDR" 	id="btn_C_BKGBDR">BKG BDR Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_C_VVDBDR" 	id="btn_C_VVDBDR">VVD BDR Cancel</button>
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
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
			 		<col width="240"/>
					<col width="50"/>
					<col width="100"/>
					<col width="50"/>
					<col width="100"/>
					<col width="50"/>
					<col width="100"/>
					<col width="70"/>
					<col width="100"/>
					<col width="50"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th class="sm">Option
						<input type="radio" name="rdo_trunk_feeder" id="rdo_trunk_feeder1" value="T" class="trans" checked><label for="rdo_trunk_feeder1">Trunk Base</label>
						<input type="radio" name="rdo_trunk_feeder" id="rdo_trunk_feeder2" value="S" class="trans"><label for="rdo_trunk_feeder2">Feeder Base</label>
					</th>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd_cd" id="vvd_cd" style="width:80px;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="VVD" maxlength="9" fullfill></td>					
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_cd" id="pol_cd" style="width:80px;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="POD" maxlength="5" fullfill></td>					
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_cd" id="pod_cd" style="width:80px;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="POD" maxlength="5" fullfill></td>					
					<th>BKG No.</th>
					<td><input type="text" name="bkg_no" id="bkg_no" style="width:103px;"class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="Booking No." maxlength="13"></td>					
					<th>BDR</th>
					<td><select name="bdr_flg" style="width:67px;">
						<option value="" selected>All</option>
						<option value="N">No</option>
						<option value="Y">Yes</option>
						</select>
					</td>					
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot">
			<tbody>
			    <tr><th></th><td colspan="5"></td></tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
			 		<col width="60"/>
					<col width="50"/>
					<col width="90"/>
					<col width="50"/>
					<col width="87"/>
					<col width="*" />
			    </colgroup>
				<tr>
					<th>VVD BDR</th>
					<td><input type="text" name="vvd_bdr" id="vvd_bdr" style="width:40px;text-align:center;" 	class="input2" value="" readonly></td>
					<th>Total Booking</th>
					<td><input type="text" name="tot_booking_cnt" id="tot_booking_cnt" style="width:40px;text-align:right;" 	class="input2" value="" readonly></td>
					<th>BDR Booking</th>
					<td><input type="text" name="btr_booking_cnt" id="btr_booking_cnt" style="width:40px;text-align:right;" 	class="input2" value="" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- Button_Sub (E) -->
		<div class="opus_design_btn" style="text-align: right;">
			<button type="button" class="btn_accent" name="btn_CheckAll" 		id="btn_CheckAll">Check All</button>
			<button type="button" class="btn_accent" name="btn_UncheckAll" 		id="btn_UncheckAll">Uncheck All</button>
		</div>
		<!-- Button_Sub (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>