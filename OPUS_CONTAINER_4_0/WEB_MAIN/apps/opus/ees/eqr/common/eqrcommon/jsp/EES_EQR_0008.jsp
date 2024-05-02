<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0008.jsp
*@FileTitle : Manage EQR Week
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.event.EesEqr0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesEqr0008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	//Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerSpecMgt");
    String popMode  = (request.getParameter("pop_mode") == null)? "N": "Y";  

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();		

		event = (EesEqr0008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// setting Ofc_cd 
		
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pop_mode" id="pop_mode" value="<%= popMode %>">

<!-- 제목 -->
<% if (popMode.equals("Y")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Manage EQR Week ( EES_EQR_0008 )</span></h2>
		
		<!-- btn_div -->
		<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_retrive" id="btn_retrive">Retrieve</button><!--
		    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		    --><!-- <button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button> -->
		</div>

	</div>
</div>   
<% } else { %>
<div class="page_title_area clear">
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrive" id="btn_retrive">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<% } %>    
<!-- 제목 -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="*">
			</colgroup> 
			<tr>
				<th>Year</th>
				<td><input type="text" style="width:60px" class="input" name="searchYear" value=""  maxlength="4" dataformat="num"></td>							
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
		<% if (!popMode.equals("Y")) { %>
		   <button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button><!--
		   --><button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Row Delete</button><!--
		   --><button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
		   <% } %><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
			