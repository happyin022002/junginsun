<%/*=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ui_pri_2001.jsp
*@FileTitle  :  Guideline Creation
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/05/15
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.event.EsmPri2001Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAGuideline.RFAGuidelineMain");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri2001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	log.debug(serverException);
		}
		
		
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="usr_id" id="usr_id" value="<%=strUsr_id%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_confirm" id="btn_confirm">Confirm</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_confirmcancel" id="btn_confirmcancel">Confirm Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy</button>		
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
	<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100">
				<col width="20">
				<col width="60">
				<col width="90">
				<col width="20">
				<col width="260">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th>Service Scope</th>
				<td><script type="text/javascript">ComComboObject("svc_scp_cd", 2, 60, 0, 1, 0, false);</script><input name="svc_scp_nm" type="text" style="width:222px;"  value="" class="input2" readonly caption="Service Scope"></td>
				<th>Year</th>
				<td><input type="text" suppressWait="Y" name="scope_year" style="width:60px; text-align:center;" value="" maxlength="4" dataformat="yyyy" caption="Year"></td>
				<th>Duration</th>
				<td><!-- 
				  --><script type="text/javascript">ComComboObject("gline_seq", 3, 90, 0, 1, 2, true);</script> <!--
				  -->~&nbsp;<input name="eff_dt" id="eff_dt" type="hidden" value="" class="input1" caption="Effective Date" cofield="exp_dt" required><!-- 
				  --><input name="eff_dt_hidden" id="eff_dt_hidden" type="hidden" value="" class="input1"><!-- 
				  --><input name="exp_dt" id="exp_dt" type="text" style="width:80px;" value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd"  cofield="eff_dt"  required><!-- 				      				       
				  --><button type="button" name="btns_calendar" id="btns_calendar"  class="calendar ir"></button>
				</td>												
				<th>Confirmation</th>
				<td><input name="cfm_flg" type="text" style="width:38px;"  value="" class="input2" readonly caption="Confirmation"></td>
			</tr>
		</table>
					
		<table> 
			<colgroup>
				<col width="100">
				<col width="20">
				<col width="100">
				<col width="130">
				<col width="20">
				<col width="*">
			</colgroup>
			<tr>
				<th>Creation Date</th>
				<td><input name="cre_dt" type="text" style="width:80px;"  value="" class="input2" readonly caption="Creation Date"></td>
				<th>Staff</th>
				<td><input name="cre_usr_nm" type="text" style="width:100px;"  value="" class="input2" readonly caption="Staff"></td>
				<th>Team</th>
				<td><input name="cre_ofc_cd" type="text" style="width:60px;"  value="" class="input2" readonly caption="Team"></td></tr>
	
		</table>
	</div>
	<!-- opus_design_inquiry (E) -->
</div>	

<!-- opus_tab_btn(S) -->
<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- iFrame (S) -->
     <div id="tabLayer" style="display:none">
     	<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="470" src="about:blank"></iframe>
     </div>
     <div id="tabLayer" style="display:none">
     	<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="470" src="about:blank"></iframe>
     </div>
     <div id="tabLayer" style="display:none">
     	<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="470" src="about:blank"></iframe>
     </div>
     <div id="tabLayer" style="display:none">
     	<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="680" src="about:blank"></iframe>
     </div>            
	<!-- iFrame (E) -->
		
	<!-- opus_design_grid(S) Hidden -->
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) Hidden -->
</div>
</form>
