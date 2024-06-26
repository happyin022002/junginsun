<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_1109.jsp
*@FileTitle  : Customs Set up(Europe Advanced Manifest: Customs Setup) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
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

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">

<!-- Developer Work	-->

<!-- page_title_area(S) -->
	<div class="page_title_area clear">	
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->			 
	    
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">			
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>		
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
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
	            <col width="100px" />
	            <col width="200px" />
	            <col width="30px" />
	            <col width="146px" />
	            <col width="60px" />
	            <col width="100px" />
	            <col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th>Country</th>
					<td>
						<input type="text" style="width:32px;" class="input" name="p_cnt_cd" value=""  maxlength='2'  dataformat='engup' style="ime-mode:disabled">
					</td>
					<th>Port</th>
					<td>
						<script language="javascript">ComComboObject('p_port', 1, 100, '');</script>
					</td>
					<th>Terminal</th>
					<td>
						<script language="javascript">ComComboObject('p_tml', 1, 100, '');</script>
					</td>
					<td rowspan="2"></td>
				</tr>
				<tr>
					<th>Customs Code</th>
					<td colspan="5">
						<input type="text" style="width:200px;" class="input" name="p_cstms_cd" value=""  maxlength='20' dataformat='engup' style="ime-mode:disabled">
					</td>			
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	    	<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	    	<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
	        <button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button>
	    </div> 
	    <!-- opus_design_btn(E) -->	    
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>	    
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	    <div class="opus_design_data">
			* Customs code for EXS of MTMAR =MT000113 (Hardcoding)
		</div>	    
	</div>
	<!-- opus_design_grid(E) -->
</div>		
</form>