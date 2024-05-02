<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1801.jsp
*@FileTitle  : Pegasus XML Monitoring
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg1801Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg1801Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
		event = (EsmBkg1801Event)request.getAttribute("Event");
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
	var userOfc_cd = "<%=strOfc_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			// showErrorMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" value="<%=pageRows%>" type="hidden" />
<input type="hidden" name="sXml" id="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="rcv_seq" id="rcv_seq" value="">
<input type="hidden" name="xml_desc" id="xml_desc" value="">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		  --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_exceldown" id="btn_exceldown">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
	<!-- inquiry_area(S) -->
	<div class="opus_design_inquiry wFit">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="10" />
				<col width="60" />
				<col width="230" />
				<col width="60" />
				<col width="80" />
				<col width="60" />
				<col width="80" />
				<col width="60" />
				<col width="100" />
				<col width="60" />
				<col width="400" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td></td>
					<th>RCV Date</th>
					<td><input type="text" style="width: 80px"  class="input1" name="rcv_from_dt" id="rcv_from_dt" caption="RCV DT" dataformat="ymd" tabindex="1"><span class="dash">~</span><input type="text" style="width: 80px"  class="input1" name="rcv_to_dt"  id="rcv_to_dt" caption="RCV DT" dataformat="ymd" tabindex="2"><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>
					<th>Msg Seq.</th>
					<td><input type="text" style="width: 60px;" style="ime-mode:disabled" caption="XML Seq." class="input" maxlength="30" name="msg_seq"  id="msg_seq" value="" tabindex="11"></td>
					<th>Meg Type</th>
					<td>
						<select id="xter_sndr_id" name="xter_sndr_id">
							<option value="" selected="selected">ALL</option>
							<option value="VERMAS">VERMAS</option>
							<option value="EDI">EDI</option>
						</select>
					</td>
					<th>Upload</th>
					<td>
						<select id="upld_cd" name="upld_cd">
							<option value="N">N</option>
							<option value="M">M</option>
						</select>
					</td>
					<th>Request No. / VGM Doc ID.</th>
					<td><input type="text" style="width: 100px;" style="ime-mode:disabled" class="input" name="xter_rqst_no"  id="xter_rqst_no" value="" tabindex="11"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- inquiry_area(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) --> 
	<div class="opus_design_grid">
	  	 <div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_upload" id="btn_upload">Upload</button>
			<button type="button" class="btn_normal" name="btn_xmlview" id="btn_xmlview">Msg View</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
