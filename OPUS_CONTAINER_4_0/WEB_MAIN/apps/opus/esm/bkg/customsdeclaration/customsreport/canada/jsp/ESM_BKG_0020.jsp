<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0020.jsp
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0020Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();

	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">

	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Advice Note Type Setup Pop-up</span></h2>
			<!-- page_title(E) -->
			
			<!-- opus_design_btn(S) -->
	    	<div class="opus_design_btn">
	        	<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_normal" name="btn_Setup" id="btn_Setup">Setup</button>								
				<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	    	</div>
	    	<!-- opus_design_btn(E) -->  
		</div>
	<!-- page_title_area(E) -->
	</div>
	<!-- popup_title_area(E) -->	
	
	<div class="layer_popup_contents">
	
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
		    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <table style="search_sm2">
		        <colgroup>
		        	<col width="10px" />
		            <col width="25px" />	            
		            <col width="66px" />	            	            
		            <col width="315px" />
		            <col width="*" />	            
		        </colgroup>
		        <tbody>
					<tr>
						<td></td>
						<td style="smt"><input type="checkbox" class="trans" name="vvd_flg" checked></td>
						<th title="Vessel Voyage Direction">VVD</th>					
						<td>
							<input type="text" style="width:315px;" class="input" readonly="readonly"
							name="vvd_cd" maxlength="9" dataformat="eng" minlength="9" caption="VVD" 
							value="<%=StringUtil.xssFilter(request.getParameter("vvd_cd"))%>">
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" class="trans" name="eta_flg" checked></td>
						<th>ETA</th>					
						<td>
							<input type="text" style="width:315px;" class="input" readonly="readonly"
							name="eta_dt" dataformat="ymd" caption="ETA" value="<%=StringUtil.xssFilter(request.getParameter("eta_dt"))%>">
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" class="trans" name="antype_flg" checked></td>
						<th>A/N Type</th>
						<td>
							<script language="javascript">ComComboObject('cnd_an_tp_cd', 1, 315, 1);</script>
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >	
		    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script language="javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>