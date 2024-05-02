<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0010.jsp
*@FileTitle  : Statement of Account
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
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0010Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	//Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutFleetManagement.TCharterIOInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0010Event)request.getAttribute("Event");
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

<head>
<title>Statement of Account</title>


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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_id" id="usr_id" value="<%=strUsr_id%>">
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Statement Of Account" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Statement Of Account" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Statement Of Account" id="com_mrdSaveDialogFileName" />
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
		--><button class="btn_normal" type="button" name="btn_savetofile" id="btn_savetofile" >Down Excel</button><!-- 
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
				<col width="85" />
				<col width="260" />				
				<col width="80" />				
				<col width="200" />				
				<col width="90" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>		   			
		   			<th>Vessel Code</th>
					<td>
						<input type="text" name="vslCd" style="width:54px;text-align:center;ime-mode:disabled" class="input1" maxlength="4" required fullfill caption="Vessel Code" dataformat="engup" onchange="obj_change();"><!-- 
						 --><button type="button" name="btn_vslCd" id="btn_vslCd"  class="input_seach_btn"></button><!-- 
						  --><input type="text" name="vslEngNm" style="width:140px;" class="input2" readonly>
						<!--<input type="checkbox" name="btn_vslCdClr" class="trans">-->
					</td>
					<th>Contract No.</th>
					<td><input type="text" name="fletCtrtNo" style="width:120px;text-align:center;" class="input2" value="" required caption="Contract No." readonly><!-- 
					 --><button type="button" name="btn_fletCtrtNo" id="btn_fletCtrtNo"  class="input_seach_btn"></button></td>
					<th>Contract Type</th>
					<td><input type="text" name="fletCtrtTpCd" style="width:70px;" class="input2" value="" caption="Contract Type" readonly></td>
					<td><input type="hidden" name="hirNo" style="width:50px;" class="input" value="" dataformat="int" maxlength="5" caption="Hire No."></td>
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
		<script type="text/javascript">ComSheetObject('sheet3');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
</div>	

</form>
</body>
</html>