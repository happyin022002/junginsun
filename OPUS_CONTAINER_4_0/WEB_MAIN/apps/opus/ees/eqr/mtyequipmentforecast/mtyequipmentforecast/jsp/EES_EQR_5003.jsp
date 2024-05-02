<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_5003.jsp
*@FileTitle  : MTY Balance Report
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
<%@ page import="com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.event.EesEqr5003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr5003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String repoFlag 		= "";
	Logger log = Logger.getLogger("com.clt.apps.MTYEquipmentForecast.MTYEquipmentForecast");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr5003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		repoFlag = event.getMtyBalanceOptionVO().getRepoFlag();
		if ( repoFlag.equals("MINUS")) {
			repoFlag = "-";
		} else {
			repoFlag = "+";
		}
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
		loadPage('<%=repoFlag %>');
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="loc_cd" id="loc_cd"  value="<%=event.getAttribute("loc_cd") %>">
<input type="hidden" name="fcast_yrwk" id="fcast_yrwk"  value="<%=event.getAttribute("fcast_yrwk") %>">
<input type="hidden" name="inp_yrwk" id="inp_yrwk"  value="<%=event.getMtyBalanceOptionVO().getInpYrwk() %>">
<input type="hidden" name="tp_cd" id="tp_cd"  value="<%=event.getMtyBalanceOptionVO().getTpCd() %>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span><%=repoFlag %>Others Creation</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Save" id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
	            <col width="50">
	            <col width="140">
	            <col width="70">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th class="sm pad_left_8"><input type="radio" name="viewFlag" id="radio_viewFlag1" class="trans" checked><label for="radio_viewFlag1">DRY</label></th>
					<th class="sm pad_left_8"><input type="radio" name="viewFlag" id="radio_viewFlag2" class="trans"><label for="radio_viewFlag2">SPCL(RF, OT, FR)</label></th>
					<th class="sm pad_left_8"><input type="radio" name="viewFlag" id="radio_viewFlag3" class="trans"><label for="radio_viewFlag3">ALL</label></th>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent"  name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
		</div>
	<!-- opus_design_btn(E) -->
		 <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>