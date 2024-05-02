<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0008.jsp
*@FileTitle  : Capital Budgeting
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0008Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	//int rowCount	 = 0;						//Number of DB ResultSet List

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutFleetManagement.TCharterIOInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		log.error(e.getMessage(),e);
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
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Capital Budgeting" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Capital Budgeting" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Capital Budgeting" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new" >New</button><!--
		--><button class="btn_normal" type="button" name="btn_DownExcel" id="btn_DownExcel" >Down Excel</button><!-- 
		 --><button class="btn_normal" type="button" name="btn_print" id="btn_print" >Print</button><!--
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
				<col width="68" />										
				<col width="250" />
				<col width="100" />										
				<col width="*" />				
		   </colgroup>
		   		<tr>		   			
		   			<th>Duration</th>
					<td><input type="text" style="width:80px;text-align:left;" class="input1" name="eff_dt" id="eff_dt" required caption="Duration From" maxlength="10" dataformat="ymd"><!-- 
					 --><button type="button" name="ef_dt" id="ef_dt"  class="calendar ir"></button><!-- 
					  -->~ <!-- 
					   --><input type="text" style="width:80px;text-align:center;" class="input1" name="exp_dt" id="exp_dt" required caption="Duration To" maxlength="10" dataformat="ymd" cofield="eff_dt"><!-- 
					    --><button type="button" name="ex_dt" id="ex_dt"  class="calendar ir"></button>		   			
		   			<th>Vessel Code</th>
					<td><input type="text" style="width:56px;text-align:center;ime-mode:disabled" class="input" maxlength="4" name="vsl_cd" id="vsl_cd" onkeyup="engnum_keyup()" onchange="vsl_cd_change()" dataformat="engup"/><!-- 
					 --><button type="button" name="btn_vslpop" id="btn_vslpop"  class="input_seach_btn"></button><!-- 
					  --><input type="text" style="width:200px;" class="input2" name="vsl_eng_nm" readonly>
					</td>
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
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>