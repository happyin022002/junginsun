<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved. 
*@FileName   : esm_pri_0001.jsp
*@FileTitle  : Guideline Creation
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
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.event.EsmPri0001Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//Number of DB ResultSet List
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGuidelineMain");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		log.debug(serverException);
		}
		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
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
<input type="hidden" name="usr_id" id="usr_id"  value="<%=strUsr_id%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm</button><!--
		--><button type="button" class="btn_normal" name="btn_confirmcancel" id="btn_confirmcancel">Confirm Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy</button>
	</div>
	<!-- opus_design_btn(E) -->	
	
    <!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	
</div>
<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="100" />
				<col width="400" />
				<col width="60" />
				<col width="260" />
				<col width="90" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Service Scope</th>
					<td><script type="text/javascript">ComComboObject("svc_scp_cd", 2, 77, 0, 1, 0, false);</script><input name="svc_scp_nm" type="text" style="width: 290px;"  value="" class="input2" readonly caption="Service Scope"></td>
					<th>Duration</th>
					<td><script type="text/javascript">ComComboObject("gline_seq", 3, 108, 0, 1, 0, true);</script><!-- 
						 --><span class="dash">~</span><!-- 	
					      --><input name="eff_dt" 			id="eff_dt" 		type="hidden" 	value="" class="input1" caption="Effective Date"  dataformat="ymd" required><!-- 					  
					      --><input name="eff_dt_hidden" 	id="eff_dt_hidden" 	type="hidden" 	value="" class="input1"><!-- 
					      --><input name="exp_dt" 			id="exp_dt" 		type="text" 	style="width: 75px;"  value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required><!-- 	
					      --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>
					<th>Confirmation</th>
					<td><input name="cfm_flg" id="cfm_flg" type="text" style="width: 80px;"  value="" class="input2" readonly caption="Confirmation"></td></tr>
	
				<tr>
					<th>Creation Date</th>
					<td><input name="cre_dt" id="cre_dt" type="text" style="width:77px;"  value="" class="input2" readonly caption="Creation Date"></td>
					<th>Staff</th>
					<td><input name="cre_usr_nm" id="cre_usr_nm" type="text" style="width:140px;"  value="" class="input2" readonly caption="Staff"></td>
					<th>Team</th>
					<td><input name="cre_ofc_cd" id="cre_ofc_cd" type="text" style="width:80px;"  value="" class="input2" readonly caption="Team"></td></tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search(E) -->



<!-- wrap_result(S) -->
<div class="wrap_result" >

	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->


	<!-- iFrame (S) -->
	<div id="tabLayer" style="display:none">
		<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="450px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="450px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="450px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="450px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="800px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="450px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="450px" src="about:blank"></iframe>
	</div>
	
	
	<!-- Hidden sheet for Transaction (S) -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- Hidden sheet for Transaction (E) -->
		
		
</div>
<!-- wrap_result(E) -->


</form>