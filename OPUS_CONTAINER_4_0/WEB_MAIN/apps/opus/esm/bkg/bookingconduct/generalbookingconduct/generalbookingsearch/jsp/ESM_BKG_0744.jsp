<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0744.jsp
*@FileTitle  : Direct NVO AMS File No
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0744Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0744Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String bkgNo = "";
	String caFlg = "";
	String bdrFlg = "";	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0744Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		bkgNo  = JSPUtil.getParameter(request, "bkg_no");		
		caFlg  = JSPUtil.getParameter(request, "ca_flg");
		bdrFlg  = JSPUtil.getParameter(request, "bdr_flg");
		
		//when open screen, get data in server..
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
<input type="hidden" name="bkg_no" value="<%= bkgNo%>" id="bkg_no" />
<input type="hidden" name="ca_flg" value="<%= caFlg%>" id="ca_flg" />
<input type="hidden" name="bdr_flg" value="<%= bdrFlg%>" id="bdr_flg" />
<!-- Developer Work	-->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Direct NVO-AMS File No</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!-- 
		--></div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<!-- wrap_search(S) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
			<colgroup>
				<col width="50" />
				<col width="*" />
			</colgroup>
				<tr>
					<th>TTL No. of HB/L</th>
					<td><input type="text" name="hbl_ttl_knt"  style="width:60px;text-align:right;ime-mode:disabled" value="0" class="input1" dataformat="num" ></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
	<div class="opus_design_grid" >
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button>
		</div>
		<!-- opus_grid_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
			<colgroup>
				<col width="50" />
				<col width="*" />
			</colgroup>
				<tr>
					<th>Total Pieces</th>
					<td><input type="text"  name="total_pieces" id="total_pieces" style="width:60px;text-align:right;" class="input"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</div>
<!-- wrap_search(E) -->
</form>
