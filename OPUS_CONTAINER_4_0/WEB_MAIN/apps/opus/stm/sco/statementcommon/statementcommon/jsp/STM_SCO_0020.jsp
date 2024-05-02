<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   STM_SCO_0020.jsp
*@FileTitle  : Lookup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    StmSco0020Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//Error occurred from server
	String strErrMsg = "";						//Error Message
	
	String strUsr_id = "";
	String strUsr_nm = "";
	
	String[] applCd = null;

	
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sco.statementcommon.StatementCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSco0020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}		     	
		
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
	
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}	
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="h_lu_tp_cd" id="h_lu_tp_cd">  
<input type="hidden" name="d_lu_tp_cd" id="d_lu_tp_cd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="350">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>Type</th>
                    <td><input type="text" style="width:300px;" class="input" name="lu_tp_cd" dataformat="engupetc"></td>
                    <th>Application</th>
                    <td><script type="text/javascript">ComComboObject('lu_appl_cd', 1, 80, 1, 0);</script></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	    <div class="layout_flex_fixed" style="width:48%">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid" id="mainTable">
	        	<div class="opus_design_btn">
	        		<button class="btn_normal" name="btn_add_h" id="btn_add_h" type="button">Row Add</button><!--  
	        		--><button class="btn_normal" name="btn_del_h" id="btn_del_h" type="button">Row Delete</button>
	        	</div>
	            <script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    <div class="layout_flex_fixed" style="width:4%;text-align:center;">
        	<table class="search" style="width:55px;height:400px; vertical-align:middle;">
				<colgroup>
					<col width="50">
				</colgroup>
				<tbody>
					<tr>
						 <td style="text-align:center;"><button class="btn_right" type="button" ></button></td>
					</tr>
				</tbody>
			</table>
	    </div>
	    <div class="layout_flex_fixed" style="width:48%; text-align:right;">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid" id="headerTable">
	        	<div class="opus_design_btn">
	        		<button class="btn_normal" name="btn_add_d" id="btn_add_d" type="button">Row Add</button><!--  
	        		--><button class="btn_normal" name="btn_del_d" id="btn_del_d" type="button">Row Delete</button>
	        	</div>
	            <script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
	<!-- layout_wrap(E) -->
</div>
</form>
