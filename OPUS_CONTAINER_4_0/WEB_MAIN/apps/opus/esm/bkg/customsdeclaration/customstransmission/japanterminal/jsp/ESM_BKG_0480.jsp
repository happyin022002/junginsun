<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0480.jsp
*@FileTitle  :
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.event.EsmBkg0480Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0480Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from the server
	String strErrMsg = ""; //error messege
	int rowCount = 0; //the number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CustomsTransmission");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0480Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
<%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeForMultiCombo("jpTeminalCy", "JP", "JP_TEMINAL_CY_CD","")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden"  name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
	 --><button type="button" class="btn_normal" name="btn_New" 		id="btn_New">New</button><!--
	 --><div id="bkrbkc_save" style="display:inline;"><button type="button" class="btn_normal" name="btn_Save"  style="display:inline;"	id="btn_Save">BKR/BKC Save</button></div><!--
	 --><div id="qty_save" style="display:none;"><button type="button" class="btn_normal" name="btn_Save"  style="display:inline;"	id="btn_Save">Qty Save</button></div><!--
	 --><button type="button" class="btn_normal" name="btn_Trans"  id="btn_Trans">Transmit to NACCS</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40"/>
				<col width="100"/>
				<col width="40"/>
				<col width="55"/>
				<col width="80"/>
				<col width="120"/>
				<col width="80"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<td class="sm pad_left_12" colspan="4"><input type="radio" name="radio_cd" id="radio_cd1" value="B" class="trans" checked><label for="radio_cd1">BKG No</label><!--
					--><input type="radio" name="radio_cd" id="radio_cd2" value="V" class="trans"><label for="radio_cd2">VOL QTY Manual</label></td>
					<th>BKG No</th>
					<td colspan="5"><input type="text" style="width:130px;" class="input" name="in_bkg_no" maxlength="13" dataformat="engup" id="in_bkg_no" /> </td>
				</tr>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 95px;" class="input2" name="in_vvd_cd" maxlength="9" dataformat="engup" readonly id="in_vvd_cd" /> </td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width: 60px;" class="input2" name="in_pol_cd" maxlength="5" dataformat="engup" readonly id="in_pol_cd" /> </td>
					<th title="Place of Receipt">POR</th>
					<td><input type="text" style="width: 60px;" class="input2" name="in_por_cd" maxlength="5" dataformat="engup" readonly id="in_por_cd" /> </td>
					<th>Period</th>
					<td><input type="text" name="in_bat_skd_prd_fm_dt" style="width:80px;" class="input2" dataformat="ymd" maxlength="8" caption="From to Date" readonly id="in_bat_skd_prd_fm_dt" />~&nbsp;<!--
					 --><input type="text" name="in_bat_skd_prd_to_dt" style="width:80px;" class="input2" dataformat="ymd" maxlength="8" caption="From to Date" readonly id="in_bat_skd_prd_to_dt" /><!--
					 --><button type="button" id="from_to_calendar" name="from_to_calendar" class="calendar ir"></button></td>
					<th>User ID</th>
					<td><input type="text" style="width: 150px;" class="input2" name="in_edi_snd_usr_id" maxlength="20" readonly id="in_edi_snd_usr_id" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>