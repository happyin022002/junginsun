<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1603.jsp
*@FileTitle : EU DG Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1603Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1603Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;	//error from server
	String strErrMsg = "";					//error message
	int rowCount	 = 0;					//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCnt_cd		= "";
	String strPort_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
		strPort_cd = strCnt_cd + strOfc_cd.substring(0, 3);
		event = (EsmBkg1603Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		// parent window parameter setting		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_save"  	id="btn_save">Save</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
        <colgroup>
            <col width="40" />
            <col width="80" />
            <col width="50" />
            <col width="220" />
            <col width="50" />          
            <col width="*" />
        </colgroup>
        <tbody>			
			<tr>
				<th title="PORT">PORT</th>
				<td><input type="text" name="port" id="port" style="width:80px;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="PORT" maxlength="5"></td>
				<th>Vessel Operator</th>
				<td><input type="text" name="operator" id="operator" style="width:80px;" class="input" value="" style="ime-mode:disabled" dataformat="engup" caption="PORT" maxlength="5"></td>
				<th>Send Cell Positions</th>
				<td><select name="cellposition" id="cellposition" class="input" style="width:80px;"><!--
						--><option value=""></option><!--						
						--><option value="Y">Y</option><!--
						--><option value="N">N</option>
					  </select>
				</td>
				<th>Operator Loads</th>
				<td><select name="opload" id="opload" class="input" style="width:80px;"><!--
						--><option value=""></option><!--						
						--><option value="C">Container Line Allowed</option><!--
						--><option value="V">Vessel Operator Allowed</option>
					  </select>
				</td>
				<th>Operator Transits</th>
				<td><select name="optranzit" id="optranzit" class="input" style="width:80px;"><!--
						--><option value=""></option><!--						
						--><option value="C">Container Line Allowed</option><!--
						--><option value="V">Vessel Operator Allowed</option>
					  </select>
				</td>
				<th>Operator Discharges</th>
				<td><select name="opdischarge" id="opdischarge" class="input" style="width:80px;"><!--
						--><option value=""></option><!--						
						--><option value="C">Container Line Allowed</option><!--
						--><option value="V">Vessel Operator Allowed</option>
					  </select>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- layout_wrap (E) -->
</div>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	    
	   <!-- opus_design_btn(S) -->
	   <div class="opus_design_btn">
	        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
	        <button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
	        <!--<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
	        <button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>-->
	    </div>
	    <!-- opus_design_btn(E) -->	 
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->			
</form>