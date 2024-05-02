<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0041.js
*@FileTitle  : Calling TML Exception
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.event.EsdPrd0041Event"%>

<%
	EsdPrd0041Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	try {
		event = (EsdPrd0041Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("dir_cd", "01", "CD00593", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
<form method="post" name="form" id="form" >
<input	type="hidden" name="f_cmd"  id="f_cmd">
<input type="hidden" name="iPage" id="iPage">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="40px;"></col>
					<col width="200px;"></col>
					<col width="35px;"></col>
					<col width="*"></col>
				</colgroup>
				<tr class="h23">
					<th>Port</th>
					<td><input class="input1" name="i_port_cd" id="i_port_cd" maxlength="5" type="text" style="width:70px;text-align:center" value="" tabIndex="1"  dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_port" id="btn_port"></button>
					<th>Lane</th>
					<td><input name="i_vsl_slan_cd" id="i_vsl_slan_cd" maxlength="3" type="text" style="width:70px;text-align:center" value="" tabIndex="2"  dataformat="engup" style="text-align:center"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_slan" id="btn_slan"></button>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
		<button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
<script type="text/javascript">
<!--

	  /*
	  */
	  with(document.form)
	  {
		<%

        if(event != null){
          String i_port_cd   = event.getSearchCallingTmlMtxExptVO().getIPortCd();

        %>
        eval("i_port_cd" ).value = "<%= JSPUtil.getNull(i_port_cd)%>";

        <% } %>
	   }
-->
</script>