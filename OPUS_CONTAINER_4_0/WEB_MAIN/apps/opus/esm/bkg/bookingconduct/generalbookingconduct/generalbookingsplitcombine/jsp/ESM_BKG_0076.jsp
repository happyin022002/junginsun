<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0076.jsp
*@FileTitle  : Booking Combine
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0076Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0076Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSplitCombine");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0076Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="mst_bkg_no">
<input type="hidden" name="message" id="message" value="" />
<input type="hidden" name="ca_rsn_cd"       value=""  style="width:30;"><!-- CA ReasonCd : initialize -->
<input type="hidden" name="ca_remark"       value=""  style="width:30;"><!-- CA Remark   : initialize  -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
	 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_combine"  	id="btn_combine">Combine</button><!-- 
	   --><button type="button" class="btn_normal" name="btn_container" 	id="btn_container">Container</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_cancel" 	id="btn_cancel">BKG Cancel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- opus_design_inquiry(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="200">
					<col width="120">
					<col width="105">
					<col width="50">
					<col width="105">
					<col width="70">
					<col width="50">
					<col width="105">
					<col width="10">
					<col width="105">
					<col width="60">
					<col width="*">
				</colgroup>
				<tr>
					<th class="sm"><!-- 
					 --><input type="radio" name="search_gbn" value="B" onClick="javascript:changeSearchGbn()" class="trans"> By BKG No.<!-- 
					  --><input type="radio" name="search_gbn" value="R" onClick="javascript:changeSearchGbn()" class="trans" checked> By VVD & Route</th>
					<th>First VVD</th>
					<td><input type="text" name="vvd" id="vvd" style="width:80px;" maxlength="9" dataformat="engup" class="input1" value=""></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_cd" style="width:50px;" maxlength="5" dataformat="engup" class="input1" value=""><!-- 
					 --><input type="text" name="pol_nod_cd" style="width:25px;" maxlength="2" dataformat="engup" class="input" value=""></td> 
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_cd" style="width:50px;" maxlength="5" dataformat="engup" class="input1" value=""><!-- 
					 --><input type="text" name="pod_nod_cd" style="width:25px;" maxlength="2" dataformat="engup" class="input" value=""></td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" name="del_cd" style="width:50px;" maxlength="5" dataformat="engup" class="input" value=""><!-- 
					 --><input type="text" name="del_nod_cd" style="width:25px;" maxlength="2" dataformat="engup" class="input" value=""></td>
					<th>Hitchment</th>
					<td><input type="checkbox" name="hitchment_yn" value="Y" class="trans" onClick="javscript:changeHitchGbn()"></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="45">
					<col width="*">
				</colgroup> 
				<tr>
					<th>Shipper</th>
					<td><input type="text" name="cust_cnt_cd" style="width:25px;" dataformat="engup" maxlength="2" class="input" value=""><!-- 
					 --><input type="text" name="cust_seq" style="width:55px;" dataformat="engup" maxlength="6" class="input" value=""><!-- 
					 --><input type="text" name="cust_nm" style="width:200px;" dataformat="eng" maxlength="50" class="input" value=""></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_rowadd" id="btn_rowadd">Row Add</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_rowdelete"  	id="btn_rowdelete">Row Delete</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
</form>
