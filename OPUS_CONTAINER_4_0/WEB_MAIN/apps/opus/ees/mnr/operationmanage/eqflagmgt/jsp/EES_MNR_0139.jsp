<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0139.jsp
*@FileTitle  : Damage Flagging/Unflagging Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0139Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0139Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list
	 
	//for existing source     
 	String eqType = ((request.getParameter("eq_type")==null )?"":request.getParameter("eq_type"));
	//String dmgFlag = ((request.getParameter("dmg_flag")==null )?"":request.getParameter("returntitle"));
    	     
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
 	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.EQFlagMgt");
	 
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id(); 
		strUsr_nm = account.getUsr_nm(); 
	     
		event = (EesMnr0139Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} 
		
		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">   
	function setupPage(){ 
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eq_type" value="<%=eqType%>" id="eq_type" />   
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span>Damage Flagging/Unflagging</span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_new" 	id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_loadExcel" 		id="btn_loadExcel">Load Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_ok" 		id="btn_ok">Ok</button><!--
		--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="120"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>EQ Type</th>
					<td><script  type="text/javascript">ComComboObject('combo1',1, 100 ,1,1)</script></td>
					<td><input name="dmg_flag" value="Y" type="radio" class="trans" checked="" id="dmg_flag" /> Flagging</td>
					<td><input name="dmg_flag" value="N" type="radio" class="trans" id="dmg_flag" />Unflagging</td>
				</tr>	
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Save" id="btn_Save">Verify</button><!--
			--><button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Del</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
		<h3 class="title_design">Damage Flagging/Unflagging File Format</h3>
		<table class="grid_2" style="width: 360px">
			<tbody>
				<colgroup>
					<col width="120"/>
					<col width="120"/>
					<col widt="120"/>
				<tr>
					<th><b>EQ No.</b></th>
					<th><b>Yard</b></th>
					<th><b>Date</b></th>
				</tr>
				<tr align="center">
					<td>HLCU1234567</td>
					<td>KRPUSR1</td>
					<td><script  type="text/javascript">document.writeln(ComGetNowInfo());</script></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
</form> 