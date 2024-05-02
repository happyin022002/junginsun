<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_bkg_0560.jsp
*@FileTitle : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0560Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0560Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0560Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="frm_attr_ctnt2" id="frm_attr_ctnt2" />


<%
	String keyAddr     = (request.getParameter("keyAddr") == null)? "":request.getParameter("keyAddr");
%>

	
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
			--><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!-- 
			--><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button>
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
	
<div class= "wrap_search">	
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table class="search">
			<colgroup>
			<col width="80">
			<col width="100">
			<col width="80">
			<col width="*">
			</colgroup>
	        <tbody>
				<tr>
					<th>CNTR/BULK</th>
						<td><select style="width:67px;" class="input1" name="cntr_blk_div_cd" name="cntr_blk_div_cd">
						<option value="A" selected="selected">All</option>
						<option value="C">CNTR</option>
						<option value="B">BULK</option>
						</select></td> 
					<th>Port</th>
					<td>
						<input type="text"  maxlength="5" style="width:60px;" class="input1" dataformat="engup" name="port_cd" id="port_cd">
					</td>
				</tr>
				
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
	<!-- opus_design_inquiry(E) -->
				
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button><!-- 
	        --><button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script  type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
	<!-- opus_design_grid(E) -->
	</form>
				