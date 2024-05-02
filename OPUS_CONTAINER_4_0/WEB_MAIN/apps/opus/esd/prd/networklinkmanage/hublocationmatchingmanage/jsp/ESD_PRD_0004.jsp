<%--=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0004.jsp
*@FileTitle  : HubLocation Information Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.event.EsdPrd0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdPrd0004Event  event = null;
	Exception serverException   = null;
	String strErrMsg = "";
	int rowCount	 = 0;

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsdPrd0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
<h2 class="page_title">
	<button type="button">
		<span id="title">Hub Location Management</span>
	</button>
</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_loadexcel"   id="btn_loadexcel">Load Excel</button><!-- 
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
<div class= "opus_design_inquiry wFit">
<!-- opus_design_inquiry(S) -->
	    <table>
	    <tbody>
	         <colgroup>
	            <col width="60" />
	            <col width="130" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="*"/>
	        </colgroup>
				<tr>
					<th>Port</th>
					<td><input name="in_port_cd" maxlength="5" type="text" style="width:130px;text-align:center" tabindex="1" dataformat="engup" id="in_port_cd" /><button type="button" id="port_btn" name="port_btn" class="input_seach_btn"></button></td>
					<th>Hub Location</th>
					<td><input name="in_hub_loc_cd" maxlength="5" type="text" style="width:130px;text-align:center" tabindex="2" dataformat="engup" id="in_hub_loc_cd" /><button type="button" id="hub_btn" name="hub_btn" class="input_seach_btn"></button></td>
					<th>Location</th>
					<td><input name="in_loc_cd" maxlength="5" type="text" style="width:130px;text-align:center" tabindex="3" dataformat="engup" id="in_loc_cd" /><button type="button" id="loc_btn" name="loc_btn" class="input_seach_btn"></button></td>
				</tr>
				
			</tbody>
		</table>
	</div>
</div>
	<!-- opus_design_inquiry(E) -->
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button><!-- 
	         --><button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>



