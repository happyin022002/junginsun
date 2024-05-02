<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   VOP_PSO_0040.jsp
*@FileTitle  : Object List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0040Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0040Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0040Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="user_id" value="<%=strUsr_id%>" id="user_id" />

	
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button> 			
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
	
	<div class = "wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!--  MiniLayer (S) -->
			<table>
				<colgroup>
		            <col width="1px" />
		            <col width="110px" />	            
		            <col width="" />
				</colgroup>
				<tbody>
					<tr>
						<th>Obj. Name</th>
						<td>
							<input type="text" name="obj_nm" style="width:250px;ime-mode:disabled;" class="input" value="" maxlength="50" >
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class = "wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
	    	<div class="opus_design_btn">
	        	<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
	        	<button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button>
	    	</div>
	    	<!-- opus_design_btn(E) -->
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script language="javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>