<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  ESM_PRI_2001_02.jsp
*@FileTitle  :  RFA Guideline Creation - Commodity Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.event.EsmPri200102Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri200102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	//int rowCount   = 0;                       //count of DB resultSET list
	
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	//Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGroupCommodityGuideline");
	java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo> custList = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri200102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		 
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		custList = (java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo>)com.clt.framework.component.util.code.CodeUtil.getInstance().getCodeSelect("CD01714", 0);
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows"> 
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" value="">
<input type="hidden" name="gline_seq" id="gline_seq" value="">
<input type="hidden" name="grp_cmdt_seq" id="grp_cmdt_seq" value="">
<input type="hidden" name="cd" id="cd" value="">
<input type="hidden" name="yn_data" id="yn_data" value="N">

<!-- opus_design_btn(S) -->
	<div class="opus_design_btn" ><!-- style="padding-right: 14px;" -->
		<!-- Content -->
		<button type="button" class="btn_normal" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
<!-- opus_design_btn(e) -->
	

<!-- layout_wrap(S) -->
<div class="layout_wrap">							
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 38%">
		<!--Content-->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">			
				<button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Del" id="btn_Del">Delete</button>
			 </div>			
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
    <!-- layout_vertical_2(E) -->
    	
    
    <!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 3%">
			<table style="position: relative;top:190px">
			<tr>
				<td width="49" align="center">
					<button type="button" class="btn_right" name="btn_AddTo" id="btn_AddTo"></button>
					<!-- <img src="img/btn_add.gif" width="26" height="26" alt="" border="0" align="absmiddle"> -->
				</td>						
			</tr>
			</table>
			<!--Content-->		
	</div>
     <!-- layout_vertical_2(E) -->    
    <!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 59%">
		<!--Content-->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_Add2" id="btn_Add2">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Del2" id="btn_Del2">Delete</button>
			 </div> 
			  <script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
    <!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="sheetHidden" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
<!-- opus_design_grid(E) -->




 
</form>
