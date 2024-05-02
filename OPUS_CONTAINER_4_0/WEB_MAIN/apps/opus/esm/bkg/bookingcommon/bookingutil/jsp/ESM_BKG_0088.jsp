<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0088.jsp
*@FileTitle  : Return CY Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.event.EsmBkg0088Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0088Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strLocCd			= "";
	String strYdCd			= "";
	String strN1st_vndr_cnt_cd = "";
	//Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strN1st_vndr_cnt_cd = account.getCnt_cd();
	   
		event = (EsmBkg0088Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//when open screen, get data in server..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		if (JSPUtil.getParameter(request, "searcheKeyOpener").length() > 4){
			strLocCd =  JSPUtil.getParameter(request, "searcheKeyOpener").substring(0,5);
			if (JSPUtil.getParameter(request, "searcheKeyOpener").length() > 4){
				strYdCd  =  JSPUtil.getParameter(request, "searcheKeyOpener").substring(5, JSPUtil.getParameter(request, "searcheKeyOpener").length());
			}else{
				strYdCd  =  JSPUtil.getParameter(request, "searcheKeyOpener");
			}
		}else{
			strLocCd =  JSPUtil.getParameter(request, "searcheKeyOpener");
		}
		
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Developer Work	-->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Return CY Inquiry</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
            --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 
            --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->


<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
	    <div class="opus_design_inquiry">
			<table> 
				<colgroup>
					<col width="60" />
					<col width="40" />
					<col width="40" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Country</th>
						<td><input type="text" name="n1st_vndr_cnt_cd" style="width:35px;" class="input1" value="<%=strN1st_vndr_cnt_cd %>" style="ime-mode:disabled" dataformat="enguponly" caption="Country" maxlength="2"></td>
						<th>Yard</th>
						<td><input type="text" name="loc_cd" style="width:60px;" class="input1" value="<%=strLocCd %>" maxlength="5" style="ime-mode:disabled" dataformat="enguponly" caption="Yard"  fullfill><input type="text" name="yd_cd" style="width:30px;" class="input" value="<%=strYdCd%>" maxlength="2" style="ime-mode:disabled" dataformat="engup" caption="Yard"  fullfill></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- inquiry_area(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- popup_contens_area(E) -->
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>