<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : VOP_VSK_0032.jsp
*@FileTitle : On-Time Ratio
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0032Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.actualschedulemanagement.ontimeresultanalysis");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0032Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="sum_date">

	<!-- 제목 -->
	<div class="page_title_area clear">
			<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
			<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
			<!-- page_title(E) -->
	
			<!-- btn_div -->
		<div class="opus_design_btn">
		    <button type="button" class="btn_accent" id="btn_Retrieve" name="btn_Retrieve">Retrieve</button><!-- 
		     --><button type="button" class="btn_normal" id="btn_DownExcel" name="btn_DownExcel">Down Excel</button>
		</div>
	
	   <!-- page_location(S) -->
	   <div class="location">
			<span id="navigation"></span>
	   </div>
	</div>
	<!-- 제목 -->

	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0"> 
				<tr class="h23">
					<th width="70px">Lane Code</th>
					<td width="120px">
						<input type="text" name="vsl_slan_cd" style="width:50px;text-align:center;ime-mode:disabled" class="input" maxlength="3" dataformat="engup"><button type="button" class="input_seach_btn" name="btns_search1"></button>
					<th width="80px">Vessel Code</th>
					<td width="120px">
						<input type="text" name="vsl_cd" style="width:60px;text-align:center;ime-mode:disabled" class="input" maxlength="4" dataformat="engup"><button type="button" class="input_seach_btn" name="btns_search2"></button>
					<th width="35px">Port</th>
					<td width="120px">
						<input type="text" name="vps_port_cd" style="width:50px;text-align:center;ime-mode:disabled" class="input" maxlength="5" dataformat="engup"><button type="button" class="input_seach_btn" name="btns_search3"></button>
					<th width="80px">Carrier Code</th>
					<td width="120px">
						<input type="text" name="crr_cd" style="width:60px;text-align:center;ime-mode:disabled" class="input" maxlength="3" dataformat="engup"><button type="button" class="input_seach_btn" name="btns_search4"></button>
					<th width="100px">On-time Option</th>
					<td width=""><input type="text" name="ontime_opt" style="width:35px;text-align:right;ime-mode:disabled" size="2" maxlength="2" class="input" value="0"></td>		
				</tr>	
				</table>
				<table> 
				<tr class="h23">
					<th width="70px">Group</th>
					<td width="120px"><select name="grp_id" style="width:79px;" class="input1">
						<option value="A" >Port</option>
						<option value="B">VSL</option>
						<option value="C">Lane</option></select></td>
					<th width="80px">Period 1</th>
					<td width="280px">
						<input name="start_date1" type="text" dataformat="ym" style="width:60px;text-align:center;" class="input1" maxlength="6" size="7"  ><!--  
						--><button type="button" class="calendar" name="btn_cal11"></button>
						<input type="text" style="width:15px;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly tabindex="-1">
						<input name="end_date1" type="text"  dataformat="ym" style="width:60px;text-align:center;" class="input1" maxlength="6" size="7"  ><!--
						--><button type="button" class="calendar" name="btn_cal12"></button></td>
					<th width="83px">Period 2</th>
					<td width="*">
						<input name="start_date2" type="text"  dataformat="ym" style="width:60px;text-align:center;" class="input" maxlength="6" size="7" ><!--
						--><button type="button" class="calendar" name="btn_cal21"></button>~
						<input name="end_date2" type="text"  dataformat="ym" style="width:60px;text-align:center;" class="input" maxlength="6" size="7" ><!--
						--><button type="button" class="calendar" name="btn_cal22"></button></td>
					</tr>	
				</table>
		</div>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<div class="opus_design_inquiry wFit">
				<table> 
				<tr class="h23">
					<td width="70px"></td>
					<td width="480px">
						<table border="0" style="width:290px;"> 
							<tr class="h23">
								<td width="*"><input type="radio" name="delay_opt" value="E" class="trans" checked> Exclude of Consecutive Delay &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="delay_opt" value="I" class="trans"> Include of Consecutive Delay</td> 
							</tr>
						</table>
					</td>
					<td width="25px"></td>
					<td width="*">
						<table border="0" style="width:290px;"> 
							<tr class="h23">
								<td width="*"><input type="radio" name="ratio_opt" value="A" class="trans" checked> Arrival On-time Ratio &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="ratio_opt" value="D" class="trans"> Departure On-time Ratio</td> 
							</tr>
						</table>
					</td>
					</tr>	
				</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>

</form>

