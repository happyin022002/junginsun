<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0479.jsp
*@FileTitle  : ESM_BKG-0479
*@author     : CLT dfs
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.event.EsmBkg0479Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0479Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from the server
	String strErrMsg = ""; //error messege
	int rowCount = 0; //the number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CustomsTransmission");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd = account.getOfc_cd();
		strUsr_id = account.getUsr_id();

		event = (EsmBkg0479Event) request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usrOfc" value="<%=strOfc_cd%>" id="usrOfc" />
<input type="hidden" name="usrId" value="<%=strUsr_id%>" id="usrId" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
			   <button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
			--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Schedule Search</button><!--
			--><button type="button" class="btn_normal" name="btn_RouteRetrieve" id="btn_RouteRetrieve">BKG Route Search</button><!--
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Trans" id="btn_Trans">Transmit to NACCS</button>
	</div>
	<!-- opus_design_btn(E) -->
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
					<col width="30">
					<col width="150">
					<col width="30">
					<col width="120">
					<col width="30">
					<col width="120">
					<col width="50">
					<col width="300">
					<col width="50">
					<col width="*">
				</colgroup>
				<tbody>
					 <tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" class="input" name="in_vvd_cd"  id="in_vvd_cd" maxlength="9" dataformat="engup" style="width: 100px;ime-mode:disabled"></td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" class="input" name="in_pol_cd" id="in_pol_cd" maxlength="5" dataformat="engup" style="width: 60px;ime-mode:disabled"></td>
						<th title="Place of Receipt">POR</th>
						<td><input type="text" class="input" name="in_por_cd" id="in_por_cd" maxlength="5" dataformat="engup" style="width: 60px;ime-mode:disabled"></td>
						<th>Period</th>
						<td>
							<input type="text" name="in_bat_skd_prd_fm_dt" id="in_bat_skd_prd_fm_dt" style="width:80px;" class="input" dataformat="ymd" maxlength="8" caption="From to Date">~&nbsp;<!--
							 --><input type="text" name="in_bat_skd_prd_to_dt" id="in_bat_skd_prd_to_dt" style="width:80px;" class="input" dataformat="ymd" maxlength="8" caption="From to Date"><!--
							 --><button type="button" class="calendar" name="from_to_calendar" id="from_to_calendar" ></button>
						</td>
						<th>User ID</th>
						<td><input type="text" style="width: 150px;" class="input" name="in_edi_snd_usr_id" id="in_edi_snd_usr_id" maxlength="20" style="ime-mode:disabled"></td>
					</tr>
				</tbody>
			</table>

		</div>
		<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button><!--
			 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>