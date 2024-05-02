<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0019.jsp
*@FileTitle : Vessel SKD & Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vsl_cd		= "";
	String pol_cd		= "";
	String pod_cd		= "";
	String vsl_eng_nm 	= "";
	
	String screenName		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingCommon.BookingUtil");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//If you imported data from the server initialization when loading.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		vsl_cd =  JSPUtil.getParameter(request, "vvd");
		pol_cd =  JSPUtil.getParameter(request, "pol_cd");
		pod_cd =  JSPUtil.getParameter(request, "pod_cd");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
		
		log.debug("vsl_cd"+vsl_cd);
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

<!-- OUTER - POPUP (S)tart -->
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<%
	if (screenName.indexOf("POP") > 0){
%>	




<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Vessel SKD &amp; Code Inquiry</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_select"  	id="btn_select">Select</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close"   id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents"  style="overflow:hidden;">
<%	}else{ %>

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	         	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    <!-- page_location(S) -->
	    <div class="location">
	        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	    </div>
	    <!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->

<%	} %>	

<div class="wrap_search">	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="40" />
	            <col width="80" />
	            <col width="50" />
	            <col width="220" />
	            <col width="50" />
	            <col width="80" />
	            <col width="50" />
	            <col width="*" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Lane</th>
					<td><script type="text/javascript" >ComComboObject('slan_cd', 1, 80, 0)</script><!--
					--><script type="text/javascript" for="slan_cd" Event='OnBlur()'>checkKeyInSlanCd(document.form.slan_cd);</script>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td colspan="1"><input type="text" name="vsl_cd" id="vsl_cd" style="width:90px;" class="input1" value="<%=vsl_cd %>" style="ime-mode:disabled" dataformat="engup" caption="VVD" maxlength="9" ><!--
					--><button type="button" class="input_seach_btn" id="btn_0B2pop" name="btn_0B2pop"></button></td>
					<th>Vessel Name</th>
					<td colspan="4"><input type="text" name="vsl_eng_nm" id="vsl_eng_nm" style="width:340px;" class="input" value="<%=vsl_eng_nm %>" style="ime-mode:disabled" dataformat="engup" caption="VESSEL NAME" maxlength="500" otherchar=" ,.-"><!-- 
					 --><button type="button" class="input_seach_btn" id="btn_vsl" name="btn_vsl"></button></td>
				</tr>
				<tr>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="vps_port_pol" id="vps_port_pol" style="width:80px;" class="input1" value="<%=pol_cd %>" style="ime-mode:disabled" dataformat="engup" caption="POL" maxlength="5"></td>
					<th>ETD</th>
					<td><!--
					--><input type="text" name=pf_etd_from_dt id=pf_etd_from_dt class="input"  style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd" caption="ETD START DATE" maxlength="8" /><!--
					--><span class="dash">~</span><!--
					--><input type="text" name="pf_etd_to_dt" id="pf_etd_to_dt" class="input" style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd"  caption="ETD END DATE" maxlength="8" /><!--
					--><button type="button" class="calendar" onClick="callDatePop('ETD')"></button>
					</td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="vps_port_pod"  id="vps_port_pod" style="width:80px;" class="input1" value="<%=pod_cd %>" style="ime-mode:disabled" dataformat="engup" caption="POL" maxlength="5"></td>
					<th>ETB</th>
					<td><!--
					--><input type="text" name="pf_etb_from_dt" id="pf_etb_from_dt" style="width:80px;" class="input" value="" dataformat="ymd" caption="ETB START DATE" maxlength="10" ><span class="dash">~</span><!--
					--><input type="text" name="pf_etb_to_dt" id="pf_etb_to_dt"  style="width:80px;" class="input" value="" dataformat="ymd" caption="ETB END DATE" maxlength="10" ><!--
					--><button type="button" class="calendar" onClick="callDatePop('ETB')"></button>
					</td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
	    <!-- opus_design_btn(S) -->
	   <!--  <div class="opus_design_btn">
	        그리드 버튼 영역(데이터 그리드 상단에 위치)
	        버튼 name / ID정의되어 있음. 별도 지정 금지
	        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
	        <button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
	        <button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
	        <button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	    </div> -->
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- : ( Button : pop ) (E) -->
<% if (screenName.indexOf("POP") > 0){ %>
</div>
<% } %>
</form> 