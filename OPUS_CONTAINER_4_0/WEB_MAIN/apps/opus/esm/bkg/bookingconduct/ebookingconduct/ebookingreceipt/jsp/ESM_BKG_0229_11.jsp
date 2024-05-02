<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0229_11.jsp
 *@FileTitle : e-Booking & SI Process Detail(HBL 2)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022911Event"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg022911Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");
	String sXml = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg022911Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

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

<style type="text/css">
	.specialCls {
		float: right;
	}
	.specialCls:after {
		display: block;
		content: " ";
		clear: both;
	}
</style>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq")) %>" id="rqst_seq" />
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id")) %>" id="sender_id" />
<input type="hidden" name="hbl2_opus" value="" id="hbl2_opus" />
<input type="hidden" name="hbl2_esvc" value="" id="hbl2_esvc" />
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>" id="sXml" />
<!-- layout_wrap (S) -->
<div class="layout_wrap">
	<div class="layout_vertical_2 pad_rgt_8" >
		<div class="wrap_search">
			<div class="opus_design_grid">
				<h3 class="title_design">Booking Data OPUS</h3>
				<div class="specialCls">
					<button type="button" class="btn_etc" name="btn_cancelcopydata" id="btn_cancelcopydata">Cancel Copy Data</button>
				</div>
			</div>
			<!-- opus_design_inquiry (S) -->
			<div class="opus_design_inquiry">
		    	<table>
					<colgroup>
						<col width="80">						
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Booking No.</th>
							<td><input type="text" name="bkg_no" id="bkg_no" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>							
						</tr>
					</tbody>
				</table>
	    	</div>
	    	<!-- opus_design_inquiry (E) -->
	    	
	    	<!-- opus_design_grid(S) -->
	    	<div class="opus_design_gird" id="mainTable">
	    		<script type="text/javascript">ComSheetObject('sheet1');</script>
	    	</div>
	    	<!-- opus_design_grid(E) -->
		</div>
	</div>
	<div class="layout_vertical_2" >
		<div class="wrap_search">
			<div class="opus_design_grid">
				<h3 class="title_design">From e- Service</h3>
				<div class="specialCls">
					<button type="button" class="btn_etc" name="btn_datacopytoopus" id="btn_datacopytoopus">Data Copy to OPUS</button>
				</div>
			</div>
			<!-- opus_design_inquiry (S) -->
			<div class="opus_design_inquiry">
		    	<table>
					<colgroup>
						<col width="80">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Request No.</th>
							<td><input type="text" name="rqst_no" id="rqst_no" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly></td>
						</tr>
					</tbody>
				</table>
	    	</div>
	    	<!-- opus_design_inquiry (E) -->
	    	
	    	<!-- opus_design_grid(S) -->
	    	<div class="opus_design_grid" id="mainTable">
	    		<script type="text/javascript">ComSheetObject('sheet2');</script>
	    	</div>
	    	<!-- opus_design_grid(E) -->
		</div>
	</div>
</div>
<!-- layout_wrap (E) -->				
</form>