<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_pri_0001_02.jsp
*@FileTitle  : Some Title 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.event.EsmPri000102Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri000102Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGuidelineMain");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri000102Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd">
<input type="hidden" name="gline_seq" id="gline_seq">
<input type="hidden" name="grp_loc_seq" id="grp_loc_seq">

<div class="opus_design_title clear">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->	
</div>

<!-- <div class="wrap_result"> -->
	<!-- layout_wrap (S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width: 49%">
		       <!-- opus_design_grid(S) -->
				     <div class="opus_design_grid">
				         <div class="opus_design_btn">
							<button type="button" class="btn_normal" name="btn_rowadd1" id="btn_rowadd1" suppressWait="Y">Row Add</button>
							<button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1" suppressWait="Y">Delete</button>
						</div>
						<script type="text/javascript">ComSheetObject('sheet1');</script>
				    </div>
			   <!-- opus_design_grid(E) -->
		    </div>
		    
		   <div class="layout_vertical_2" style="width: 2%">
				<table>
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
		    
		     <div class="layout_vertical_2" style="width: 49%">
		         <!-- opus_design_grid(S) -->
				     <div class="opus_design_grid">
				         <div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_rowadd2" id="btn_rowadd2" suppressWait="Y">Row Add</button>
						<button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2" suppressWait="Y">Delete</button>
						</div>
						<script type="text/javascript">ComSheetObject('sheet2');</script>
				    </div>
			   <!-- opus_design_grid(E) -->
		    </div>
		</div>
	<!-- layout_wrap (E) -->
	
	 <!-- opus_design_grid(S) -->
	     <div class="opus_design_grid" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	    </div>
	<!-- opus_design_grid(E) -->
<!-- </div> -->
</form>