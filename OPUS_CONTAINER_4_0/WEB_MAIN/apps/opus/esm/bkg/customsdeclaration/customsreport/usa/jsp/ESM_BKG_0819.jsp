<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0819.jsp
*@FileTitle  : MI Transmit History  for IE
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/01
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0819Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0819Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vsl_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingCommon.BookingUtil");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0819Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//vsl_cd =  JSPUtil.getParameter(request, "searcheKeyOpener");
		
		//log.debug("vsl_cd"+vsl_cd);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Developer Work	-->

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>US AMS: MI Transmit History for IE</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">DownExcel</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr class="h23">
					<td width="620">
						<table class="search_sm" border="0" style="width:590;">
							<tr class="h23">
								<td width="110">
									<input name="gubun" type="radio" value="1" class="trans" checked>&nbsp;Send Date</td>
								<td width="340">
								<input type="text" style="width:75px; ime-mode: disabled" class="input1"
									dataformat="ymd" name="fromd" caption="Sent Date" cofield="tod"><!-- 
								 --><input type="text" name="fromt" style="width:40px" value="00:00" class="input1">
								~&nbsp; 
								<input type="text" style="width: 75px; ime-mode: disabled" class="input1"
									dataformat="ymd" name="tod" caption="Sent Date" cofield="fromd"><!-- 
									
								--><input type="text" name="tot" style="width:40px" value="23:59" class="input1"><!-- 
									 --><button class="calendar ir" name="btn_calendar" id="btn_calendar" type="button"></button>

								</td>
								<td width="50">
									<input name="gubun" type="radio" value="0" class="trans" >&nbsp;VVD</td>
								<td width="">
									<input type="text" name="vvd" style="width:90px;" class="input1" value="" required dataformat="eng"></td>
							</tr>
						</table>
					</td>
					<td width="30">POL</td>
					<td width="90"><input type="text" name="pol" style="width:60px;" class="input" value="" dataformat="eng"></td>
					<td width="30">POD</td>
					<td width=""><input type="text" name="pod" style="width:60px;" class="input" value="" dataformat="eng"></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				<script language="javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
	</div>
</div>
<!-- Developer Work End-->
</form>
