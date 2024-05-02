<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   VOP_VSK_0513.jsp
*@FileTitle  : SHA Tide Information Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.event.VopVsk0513Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0513Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationSupportMgt.SHATideInformationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0513Event)request.getAttribute("Event");
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
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="max_day">
<input type="hidden" name="nowYear" style="width:50;" class="input2" value="<%=DateTime.getYear()%>">
<input type="hidden" name="nowMonth" style="width:50;" class="input2" value="<%=(DateTime.getMonth()<10)?"0"+DateTime.getMonth():DateTime.getMonth()%>">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	         
	   
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve"     id="btn_Retrieve">Retrieve</button><!--
            --><button type="button" class="btn_normal" name="btn_New"          id="btn_New">New</button><!--
            --><button type="button" class="btn_normal" name="btn_Save" 	 	id="btn_Save">Save</button><!--
            --><button type="button" class="btn_normal" name="btn_Excel" 	 	id="btn_Excel">Down Excel</button>
	    </div>
	    
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
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	        	<col width="40px" />
	            <col width="90px" />
	            <col width="65px" />
	            <col width="110px" />
	            <col width="45px" />
	            <col width="80px" />
	            <col width="40px" />
	            <col width="" />	            
	        </colgroup>
	        <tbody>
				<tr>
					<th>Port Code</th>
					<td>
						<input type="text" style="width:70;text-align:center;" class="input2" name="loc_cd" id="loc_cd" dataformat="engup" style="ime-mode:disabled" maxlength="5" value="CNSHA" readOnly>
					</td>
					<th>Year</th>
					<td>
						<script language="javascript">ComComboObject('tide_yr', 1, 80, 1);</script>
					</td>
					<th>Month</th>
					<td>
						<script language="javascript">ComComboObject('tide_mon', 1, 50, 1);</script>
					</td>										
					<th>Updated Date</th>
					<td>
						<input type="text" name="upd_dt" style="width:115;text-align:center;" class="input2" readOnly>
						<input type="text" name="upd_usr_id" style="width:80;" class="input2" readOnly>					
					</td>										
				</tr>
			</tbody>
		</table>
	</div>	
</div>
	
	<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear">
	    <!-- opus_grid_btn(S) -->
	    <div class="opus_design_btn" id="div_ofc1">
	        <button type="button" class="btn_normal" name="btn_Import_File" id="btn_Import_File">Import File</button>
	        <button type="button" class="btn_normal" name="btn_File_Templete" id="btn_File_Templete">File Template</button>
	    </div>  
	    <!-- opus_grid_btn(E) -->
	    
	    <div class="opus_design_grid clear"  name="tabLayer" id="tabLayer">	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>	
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- TAB [ Gang Structure ] (E) -->
	<div id="tabLayer" style="display:none">
			<table class="search" id="mainTable"> 
	       		<tr><td class="bg">	
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script type="text/javascript">ComSheetObject('sheet2');</script>
								<script type="text/javascript">ComSheetObject('sheet3');</script>
								
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->			
				
				</td></tr>
			</table>
			<!--biz page (E)-->
	</div>
</div>
	<!-- TAB [ Gang Structure ] (E) -->	
	
</form>