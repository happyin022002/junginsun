<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0367_02.jsp
*@FileTitle  : EXPORT REFERENCES
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/16
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg036702Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg036702Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingReceipt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg036702Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="bkg_no" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" type="hidden" />
<input id="callback_func" name="callback_func" value="<%=JSPUtil.getParameter(request, "func")%>" type="hidden" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>EXPORT REFERENCES</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!--  
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_search_tab">
		<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="50"/>
						<col width="120"/>
						<col width="150"/>
						<col width="155"/>
						<col width="50"/>
						<col width="20"/>
						<col width="50"/>
						<col width="150"/>
						<col width="*"/>
					</colgroup>
					<tbody>
					<tr>
						<th>Booking No.</th>	
						<td><input type="text" style="width:100px;" class="input2" name="vbkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" readonly></td>
						<td></td>
						<td></td>						
						<th>B/L No.</th>	
						<td><input type="text" style="width:100px;" class="input2" name="vbl_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" readonly></td>
						<td></td>
						<td></td>
						<td></td>				
					</tr>
					</tbody>
				</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_tab" > 
			<script >ComTabObject('tab1')</script>
		</div>
		<div id="tabLayer" style="display: inline">
			 <div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
		</div>
		<div id="tabLayer" style="display:none">
			 <div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
		</div>
	</div>
</div>
</form>