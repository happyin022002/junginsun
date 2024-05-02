<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0060.jsp
*@FileTitle  :  Fleet Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0060Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0060Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	//int rowCount	 = 0;						//Number of DB ResultSet List

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	//Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutFleetManagement.TCharterIOInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0060Event)request.getAttribute("Event");
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
<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" id="schDt" name="schDt">
<input type="hidden" id="schDtTo" name="schDtTo">
<input type="hidden" id="ownrSeq" name="ownrSeq">
<input type="hidden" id="periodFlag" name="periodFlag">
<input type="hidden" id="vslSizeFlag" name="vslSizeFlag">
<input type="hidden"  id="usr_id" name="usr_id" value="<%=strUsr_id%>">
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Fleet Status" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Fleet Status" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Fleet Status" id="com_mrdSaveDialogFileName" />
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
				<col width="90" />				
				<col width="160" />				
				<col width="170" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Search Period</th>
					<td><input type="radio" name="btn_periodFlag" value="" class="trans" checked>Date&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_periodFlag" value="" class="trans">Month&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_periodFlag" value="" class="trans">Year</td>
					<th>Duration</th>
					<td>
						<div id="style1" style="display:''">
							<input type="text" name="schDate" dataformat="ymd" required  caption="Duration" style="width:80px;text-align:center;ime-mode:disabled;" class="input1" value=""><!-- 
						 	--><button type="button" name="btn_schDate" id="btn_schDate"  class="calendar ir"></button>~
						 	   <input type="text" name="schDateTo" dataformat="ymd" required  caption="Duration" style="width:80px;text-align:center;ime-mode:disabled;" class="input1" value=""><!-- 
					   		--><button type="button" name="btn_schDateTo" id="btn_schDateTo"  class="calendar ir"></button>
						</div>
						<div id="style2" style="display:none">
							<input type="text" name="schMonth" maxlength="6" dataformat="ym" required  caption="Duration" style="width:60px;text-align:center;ime-mode:disabled;" class="input1" value=""><!-- 
						 	--><button type="button" name="btn_schMonth" id="btn_schMonth"  class="calendar ir"></button>~
						 	<input type="text" name="schMonthTo" maxlength="6" dataformat="ym" required  caption="Duration" style="width:60px;text-align:center;ime-mode:disabled;" class="input1" value=""><!-- 
					   		--><button type="button" name="btn_schMonthTo" id="btn_schMonthTo"  class="calendar ir"></button>
						</div>
						<div id="style3" style="display:none">
							<input type="text" name="schYear" maxlength="4" dataformat="yyyy" required  caption="Duration" style="width:40px;text-align:center;ime-mode:disabled;" class="input1" value=""><!-- 
						 	--><button type="button" name="btn_schYear" id="btn_schYear"  class="calendar ir"></button>~
						  	<input type="text" name="schYearTo" maxlength="4" dataformat="yyyy" required  caption="Duration" style="width:40px;text-align:center;ime-mode:disabled;" class="input1" value=""><!-- 
						   	--><button type="button" name="btn_schYearTo" id="btn_schYearTo"  class="calendar ir"></button>
						</div>
					</td>
		   		</tr>
		   </tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="90" />				
				<col width="246" />				
				<col width="84" />
				<col width="250" />
				<col width="60" />
				<col width="*" />				
		   </colgroup>  
				<tr class="h23">
					<th>Contract Type</th>
					<td>
						<select name="contractType" id="combo_contractType" style="width:100px;"><!-- 
						 --><option value="">All</option></select></td>
					<th>Vessel Size</th>
					<td><input type="text" name="vslSize1" dataformat="int" maxlength="5" style="width:60px;ime-mode:disabled;text-align:right;" class="input" value=""><!-- 
					 --> ~ <!--
					 --><input type="text" name="vslSize2" dataformat="int" maxlength="5" style="width:60px;ime-mode:disabled;text-align:right;" class="input" value=""><!--
					 --><input type="radio" name="btn_vslSizeFlag" value="" class="trans" align="baseline" checked> Max.&nbsp;&nbsp;<!--
					 --><input type="radio" name="btn_vslSizeFlag" value="" class="trans" align="baseline"> 14Ton</td>
					<th>Lane</th>
					<td><input type="text" name="laneCd" style="width:40px;text-align:center;ime-mode:disabled" class="input" maxlength="3"  dataformat="engup" caption="Lane Code"><!--
					--><button type="button" name="btn_laneCd" id="btn_laneCd"  class="input_seach_btn"></button><!--
					--><input type="checkbox" name="btn_laneCdClr" class="trans"></td>
				</tr>
			</table>
			
			<table>
				<colgroup>
					<col width="90" />				
					<col width="250" />		
					<col width="80" />		
					<col width="*" />				
		   		</colgroup> 	
			
				<tr class="h23">
					<th>Owner</th>
					<td><input type="text" name="ownrNm" style="width:200px;" class="input" value="" readonly><!--
					--><button type="button" name="btn_owner" id="btn_owner"  class="input_seach_btn"></button><!--
					--><input type="checkbox" name="btn_ownrClr" class="trans"></td>
					<th>Gear with</th>
					<td style="padding-left:2"><select name="gearWith" style="width:78px;"><!--
					--><option value="" selected>All</option><!--
					--><option value="N">G.Less</option><!--
					--><option value="Y">Geared</option></select></td>
				</tr>
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
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>	
	<!-- opus_design_grid(E) -->
</div>
</form>