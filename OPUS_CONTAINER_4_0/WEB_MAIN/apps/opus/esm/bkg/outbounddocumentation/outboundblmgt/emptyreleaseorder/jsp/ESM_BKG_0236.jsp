<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0236.jsp
*@FileTitle  : BKG LDF FTP Sending List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event.EsmBkg0236Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>
<%
	EsmBkg0236Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");
	String sXml = null;
	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	if (home !=null) fileDir.append(home);
	String separator = System.getProperty("file.separator");
	if (separator !=null) fileDir.append(separator);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();	   
		event = (EsmBkg0236Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// getting data from server when load the initial screen 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);	
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="cm_code" id="cm_code">
<input type="hidden" name="ldf_dl_dt" id="ldf_dl_dt">
<input type="hidden" name="bkg_ofc_cd" id="bkg_ofc_cd">
<input type="hidden" name="bkg_fm_dt" id="bkg_fm_dt">
<input type="hidden" name="bkg_to_dt" id="bkg_to_dt">
<input type="hidden" name="file_dl_nm" id="file_dl_nm">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Booking LDF Log</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
	<!-- inquiry_area(S) -->
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="50" />
				<col width="80" />
				<col width="50" />
				<col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>Send Date</th>
					<td><input type="text" style="width: 80px" class="input1" name="ldf_dt" id="ldf_dt" caption="Send DT" dataformat="ymd" tabindex="1" value="<%=JSPUtil.getKST("yyyy-MM-dd")%>"><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>
					<th>Office</th>
					<td><input type="text" name="ofc_cd" id="ofc_cd" size="6" style="text-align:left;" class="input" value="" style="ime-mode:disabled"  maxlength=5 dataformat="enguponly"></td>			
				</tr> 
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab sm">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retry" id="btn_retry">Retry</button>
			</div>	
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>

	<div id="tabLayer" style="display:none;">
	<div style="position:relative;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >	
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	</div>
</div>
</form>