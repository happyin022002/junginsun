<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2011.jsp
*@FileTitle  : M.G.Set Off-Hire Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EesCgm2011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String form_day         = "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		form_day  = DateTime.getDateString().replace(".","-");  

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<head>
<title>M.G.Set Off-Hire Creation</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="eq_no" id="eq_no" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="yd_cd" id="yd_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="form_day" value="<%=form_day%>" id="form_day" />
<input type="hidden" name="chk_ver" value="ver2" id="chk_ver" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="New" id="New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_verify" id="btn_verify" type="button">Verify</button><!--
		--><button class="btn_normal" name="Save" id="Save" type="button">Off-Hire Confirm</button><!--
		--></div>
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
				<col width="70" />				
				<col width="90" />				
				<col width="60" />				
				<col width="100" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Office</th>
					<td><input type="text" style="width:60px;ime-mode:disabled; text-align:center;" dataformat="engup" name="sts_evnt_ofc_cd" class="input1" value="<%=strOfc_cd%>" maxlength="6" id="sts_evnt_ofc_cd" /><button type="button" id="ComOpenPopupWithTargetOffice" name="ComOpenPopupWithTargetOffice" class="input_seach_btn"></button></td>
					<th>Yard</th>
					<td><input type="text" style="width:70px;ime-mode:disabled; text-align:center;" name="sts_evnt_yd_cd" maxlength="7" class="input1" value="" dataformat="engup" id="sts_evnt_yd_cd" onblur="obj_focusout()"/><button type="button" id="ComOpenPopupWithTargetYard" name="ComOpenPopupWithTargetYard" class="input_seach_btn"></button></td>
					<th>Off-Hire Date</th>
					<td><input type="text" style="width:80px;ime-mode:disabled; text-align:center;" dataformat="ymd" name="sts_evnt_dt" class="input1" value="" maxlength="10" id="sts_evnt_dt" /><button type="button" class="calendar ir" onClick="showCalendar()"></button></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="Row_Add" id="Row_Add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="Delete" id="Delete" type="button">Row Delete</button><!--
			--><button class="btn_normal" name="btn_loadexcel" id="btn_loadexcel" type="button">Load Excel</button><!--
			--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>