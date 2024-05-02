<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0019.jsp
*@FileTitle  : NB Delivery Schedule Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event.EsmFms0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
//	int rowCount	 = 0;						//Number of DB ResultSet List

//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
//	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutFleetManagement.TCharterStandardPrimeCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
</head>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="ydSeq" id="ydSeq" />
<input type="hidden" name="ownrSeq" id="ownrSeq" />
<input type="hidden" name="periodFlag" id="periodFlag" />
<input type="hidden" name="vslDeDt1" id="vslDeDt1" />
<input type="hidden" name="vslDeDt2" id="vslDeDt2" />
<input type="hidden" name="vslCdSizeFlag" id="vslCdSizeFlag" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
<div class="opus_design_btn">
	<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
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
				<col width="100" />
				<col width="100" />
				<col width="258" />										
				<col width="*" />				
		   </colgroup> 
		   <tbody>
	   		<tr>
		   		<th>Search Period</th>
				<td class="stm"><input type="radio" name="btn_periodFlag" value="" class="trans" checked>Date&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_periodFlag" value="" class="trans">Month&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_periodFlag" value="" class="trans">Year</td>
				<th>Duration </th>
				<td>
					<div id="style1" style="display:''">
						<input type="text" name="vslDeDate1" dataformat="ymd" required  caption="Duration To" style="width:80px;text-align:center;" class="input1" value=""><!-- 
						 --><button type="button" name="btn_vslDeDate1" id="btn_vslDeDate1"  class="calendar ir"></button><!-- 
						  -->~ <!-- 
						   --><input type="text" name="vslDeDate2" dataformat="ymd" required  cofield="vslDeDate1" caption="Duration From" style="width:80px;text-align:center;" class="input1" value=""><!-- 
						    --><button type="button" name="btn_vslDeDate2" id="btn_vslDeDate2"  class="calendar ir"></button>
					</div>
					<div id="style2" style="display:none">
						<input type="text" name="vslDeMonth1" maxlength="6" dataformat="ym" required  caption="Duration To" style="width:60px;text-align:center;" class="input1" value=""><!-- 
					 --><button type="button" name="btn_vslDeMonth1" id="btn_vslDeMonth1"  class="calendar ir"></button><!-- 
				  	-->~ <!-- 
					 --><input type="text" name="vslDeMonth2" maxlength="6" dataformat="ym" required  cofield="vslDeMonth1" caption="Duration From" style="width:60px;text-align:center;" class="input1" value=""><!-- 
					 --><button type="button" name="btn_vslDeMonth2" id="btn_vslDeMonth2"  class="calendar ir"></button>
					</div>
					<div id="style3" style="display:none">
						<input type="text" name="vslDeYear1" maxlength="4" dataformat="yyyy" required  caption="Duration To" style="width:40px;text-align:center;" class="input1" value=""><!-- 
					 --><button type="button" name="btn_vslDeYear1" id="btn_vslDeYear1"  class="calendar ir"></button><!-- 
				  	-->~ <!-- 
					 --><input type="text" name="vslDeYear2" maxlength="4" dataformat="yyyy" required  cofield="vslDeYear1" caption="Duration From" style="width:40px;text-align:center;" class="input1" value=""><!-- 
					 --><button type="button" name="btn_vslDeYear2" id="btn_vslDeYear2"  class="calendar ir"></button>
					</div>
				</td>
	   		</tr>
		   </tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="84" />				
				<col width="320" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
	   			<th>Yard</th>
				<td><input type="text" name="shpYdNm" style="width:202px" class="input" value="" readonly><!-- 
				 --><button type="button" name="btn_yard" id="btn_yard"  class="input_seach_btn"></button><!-- 
				  --><input type="checkbox" name="btn_ydClr" class="trans"></td>
				<th>Owner</th>
				<td><input type="text" name="ownrNm" style="width:200px" class="input" value="" readonly><!-- 
				 --><button type="button" name="btn_owner" id="btn_owner" class="input_seach_btn"></button><!-- 
				  --><input type="checkbox" name="btn_ownrClr" class="trans"></td>
		   		</tr>
		   </tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="84">				
				<col width="100">				
				<col width="179">				
				<col width="*">				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Vessel Size</th>
					<td class="stm"><input type="text" name="vslCdSize1" dataformat="int" maxlength="5" style="width:60px;text-align:right;" class="input" value="">&nbsp;~&nbsp;<input type="text" name="vslCdSize2" maxlength="5" dataformat="int" style="width:60px;text-align:right;" class="input" value="">&nbsp;<input type="radio" name="btn_vslCdSizeFlag" value="" class="trans" checked>Max&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_vslCdSizeFlag" value="" class="trans">14Ton</td>
					<th>Ship's Full Name</th>
					<td><input type="text" name="shpNm" maxlength="50" style="width:183px;" class="input" value=""></td>
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
			<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_ins" id="btn_ins" type="button">Row Ins</button><!--
			--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Row Del</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>