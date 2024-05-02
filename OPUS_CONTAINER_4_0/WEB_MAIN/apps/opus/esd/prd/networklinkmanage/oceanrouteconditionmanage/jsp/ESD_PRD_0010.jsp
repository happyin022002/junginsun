<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0010.jsp
*@FileTitle : Ocean Route Embargo Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.event.EsdPrd0010Event"%>
<%
	EsdPrd0010Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								  //count of DB resultSET list
	try {
		event = (EsdPrd0010Event)request.getAttribute("Event");
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
			ComShowMessage(errMessage);
		} 
		loadPage();
	}
</script>

<form method="post" name="form" id="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title"></span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
				--><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!--  
				--><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button>
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
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="60px" />
	            <col width="130px" />
	            <col width="50px" />
	            <col width="100px" />
	            <col width="*" />
	        </colgroup> 
	        <tbody>
		        <tr>
					<th>Country From</th>
					<td><input name="i_from" id="i_from" maxlength="2" type="text" style="width:150px;text-align:center" tabindex="1" dataformat="engup" /><button type="button" id="btn_fromCnt" name="btn_fromCnt" class="input_seach_btn"></button></td>
					<th>To</th>
					<td><input name="i_to" id="i_to" maxlength="2" type="text" style="width:150px;text-align:center" tabindex="2" dataformat="engup" /><button type="button" id="btn_toCnt" name="btn_toCnt" class="input_seach_btn"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
	<!-- opus_design_inquiry(E) -->
	
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="maintable">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
	        <button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>

<script type="text/javascript">
<!--
	  /*
		displaying values from form input
	  */
	  with(document.form)
	  {
		<%
        if(event != null){
          String i_from   =event.getSearchEmbargoVO().getIFrom();
          String i_to   =event.getSearchEmbargoVO().getITo();
        %>
        eval("i_from" ).value = "<%= JSPUtil.getNull(i_from)     %>";
        eval("i_to" ).value = "<%= JSPUtil.getNull(i_to)     %>";

        <% } %>
	   }
-->
</script>