<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_2002.jsp
*@FileTitle  : Customs Package Type Code Conversion
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg2002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg2002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg2002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="chk_cnt_cd">
<input type="hidden" name="chk_pck_tp_cd">
<input type="hidden" name="chk_cstms_pck_tp_cd">
<input type="hidden" name="chk_tp_cd">
<input type="hidden" name="chk_pck_cd">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	   
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button>
			<button type="button" class="btn_normal" name="btn_exceldown"   id="btn_exceldown">Down Excel</button>
			<button type="button" class="btn_normal" name="btn_excelup"   id="btn_excelup">Load Excel</button>
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
			
			
	<!-- opus_design_inquiry(S) -->
	<div class="wrap_search">
	  <div class="opus_design_inquiry wFit">
	    <table>
	         <colgroup>
	            <col width="70px" />
	            <col width="80px" />
	            <col width="120px" />
	            <col width="120px" />
	            <col width="200px" />
	            <col width="730px" />
	        </colgroup>
	         
	        <tbody>
				<tr class="h23">
					<th>Country</th>
					<td>
						<input type="text" style="width:30px; ime-mode:disabled" name="frm_cnt_cd"  
						class="input1" dataformat="enguponly" maxlength="2" caption="Country Code">
					</td>
					<th>Package Type</th>
					<td>
						<input type="text" style="width:50px; ime-mode:abled" name="frm_pck_tp_cd"  
						class="input" dataformat="enguponly" maxlength="2"><!--
						--><button type="button" class="input_seach_btn" name="btn_pop" width="19px" height="20" alt="" border="0" align="absmiddle" class="cursor"></button>						
					</td>
					<th>Customs Package Type</th>
					<td>
						<input type="text" style="width:50px; ime-mode:abled" name="frm_cstms_pck_tp_cd"  
						class="input" dataformat="engup" maxlength="3">
					</td>
				</tr>
				
			</tbody>
		</table>
	  </div>
	</div>
	<!-- opus_design_inquiry(E) -->


	<!-- opus_design_grid(S) -->
<div class="wrap_result ">
	<div class="opus_design_grid ">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
	        <button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
	<!-- opus_design_grid(E) -->
</form>