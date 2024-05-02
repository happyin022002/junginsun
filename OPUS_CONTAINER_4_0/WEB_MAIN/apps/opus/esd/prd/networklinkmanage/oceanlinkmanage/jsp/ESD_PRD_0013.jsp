<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0013.jsp
*@FileTitle  : RHQ Ocean Link Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.event.EsdPrd0013Event"%>

<%
	EsdPrd0013Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								  //count of DB resultSET list
	try {
		event = (EsdPrd0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />

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
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
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
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<tr>
				<th width="80">From Port</th>
				<td width="120"><input id="port_fm" name="port_fm" maxlength="5" style="width: 70px;text-align:center" tabindex="1" dataformat="engup" type="text" /><button type="button" class="input_seach_btn" name="btn_port_fm"  id="btn_port_fm"></button></td>
				<th width="130">To</th>
				<td><input id="port_to" name="port_to" maxlength="5" style="width: 70px;text-align:center" tabindex="2" dataformat="engup" type="text" /><button type="button" class="input_seach_btn" name="btn_port_to" id="btn_port_to"></button></td>
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
				<button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button>
				<button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button>
				<button type="button" class="btn_normal" name="btng_constraintLink" id="btng_constraintLink">Constraint Link</button>
		  	</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
      </div>
<!-- opus_design_grid(E) -->
</div>
</form>