<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0096.jsp
*@FileTitle  : Yard Assign by CNTR
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/03
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0096Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0096Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String bkgNo = "";
	String calllFunc = "";
	String callSheetIdx = "";

	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0096Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		bkgNo  = JSPUtil.getParameter(request, "bkg_no".trim(), "");
		calllFunc  = JSPUtil.getParameter(request, "func".trim(), "");
		callSheetIdx  = JSPUtil.getParameter(request, "callSheetIdx".trim(), "");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="callSheetIdx" value="<%=callSheetIdx%>">


<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Booking Fax EDI - Yard Assign by CNTR</span></h2>
		
		<div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
	<div class= "opus_design_inquiry ">
			<table class="grid2" border="0" style="width:100%;"> 
				<tr class="h23">
					<th width="25%" class="tr2_head">Booking No.</th>
					<td width="25%" class="noinput2"><input type="text" style="width:100%;text-align:center;" class="noinput2" id="bkg_no" name="bkg_no" value="<%=bkgNo%>"></td>	
					<th width="25%" class="tr2_head">P/Up CY</th>
					<td width="25%" class="noinput2"><input type="text" style="width:100%;text-align:center;" class="noinput2" name="yd_cd"></td>				
							
				</tr> 
				<tr class="h23">
					<th width="25%" class="tr2_head">Booking Q'ty</th>
					<td width="25%" colspan="3" class="noinput2">
					<input type="text" style="width:100%;text-align:center;" class="noinput2" name="bkg_qty">
					</td>	
				</tr> 
			</table>				
			</div>
		<div class="opus_design_grid" >
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button><!--  -->
					<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
				</div>
			
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>


</form>
