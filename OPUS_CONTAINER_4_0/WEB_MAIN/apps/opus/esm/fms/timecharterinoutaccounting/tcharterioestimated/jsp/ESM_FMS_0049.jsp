<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0049.jsp
*@FileTitle  : Estimated Hire Results
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.event.EsmFms0049Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmFms0049Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOEstimated");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmFms0049Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// Adding Logic extracting data from server when loading initial window ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="est_type" id="est_type" value="RV"/>
<input type="hidden" name="usr_id" value="<%=strUsr_id			%>" id="usr_id" />
<input type="hidden" name="fr_yrmon" id="fr_yrmon" />
<input type="hidden" name="to_yrmon" id="to_yrmon" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Estimated Actual Results" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Estimated Actual Results" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Estimated Actual Results" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down&nbsp;Excel</button><!--
	--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button" style="display:none;">Print</button><!--
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
				<col width="70px" />				
				<col width="100px" />	
				<col width="70px" />				
				<col width="210px" />				
				<col width="70px" />				
				<col width="70px" />				
				<col width="70px" />				
				<col width="220px" />				
				<col width="40px" />				
				<col width="100px" />				
				<col width="*" />			
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Accrual Month</th>
					<td><input type="text" name="exe_yrmon" style="width:60px;text-align:center;ime-mode:disabled; " class="input1" maxlength="6" dataformat="ym" required=""  caption="Accrual Month" id="exe_yrmon" /><button type="button" id="btn_exe_yrmon" name="btn_exe_yrmon" class="calendar ir"></button></td>
		   			<th>Revenue Month</th>
					<td><!--
					--><input type="text" name="fr_duration" style="width:60px;text-align:center;ime-mode:disabled;" class="input1" maxlength="6" dataformat="ym" required caption="Revenue Duration" id="fr_duration" /><!--
					--><button type="button" id="btn_fr_duration" name="btn_fr_duration" class="calendar ir"></button>~ <!--
					--><input type="text" name="to_duration" style="width:60px;text-align:center;ime-mode:disabled; " class="input1" maxlength="6" dataformat="ym" required caption="Revenue Duration" id="to_duration" /><!--
					--><button type="button" id="btn_to_duration" name="btn_to_duration" class="calendar ir"></button></td>
					<th>Rev./Exp.</th>
					<td><script type="text/javascript">ComComboObject('re_divr_cd', 1, 120, 0, 0);</script></td>
					<th>Account</th>
					<td><script type="text/javascript">ComComboObject('acct_cd', 1, 210, 0, 0);</script></td>
					<th>VVD</th>
					<td><input type="text" style="width:100px;text-align:center;ime-mode:disabled" name="vvd_cd" id="vvd_cd" class="input" maxlength="10" value="" dataformat="engup"  caption="VVD"></td>
					<td></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>	
</form>