<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0058.jsp
*@FileTitle  : New container Receiving Inquiry
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
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0058Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0058Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseMgt.LeaseReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0058Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	-->	<button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="300">
				<col width="40">
				<col width="*">
			</colgroup>
			<tr>
			    <th>S/N Range</th>
			    <td><!--  
			    --><input type="text" name="sn_eng_range1" style="width:45px;ime-mode:disabled" value="" class="input1" maxlength="4" dataformat="enguponly" id="sn_eng_range1" /><!--  
			    --><input type="text" name="sn_num_range1" style="width:57px;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="num" id="sn_num_range1" /><!--  
			    -->&nbsp;-&nbsp;<!--  
			    --><input type="text" name="sn_eng_range2" style="width:45px;ime-mode:disabled" value="" class="input1" maxlength="4" dataformat="enguponly" readonly  id="sn_eng_range2" /><!--  
			    --><input type="text" name="sn_num_range2" style="width:57px;ime-mode:disabled" value="" class="input1" maxlength="6" dataformat="num" id="sn_num_range2" /><!--  
			    --><input type="text" name="sn_num" class="input2" style="width:50px;ime-mode:disabled" readonly id="sn_num"></td>
			    <th>TP/SZ</th>
			    <td><!--  
			    --><script type="text/javascript" >ComComboObject('combo2', 1, 189, 1 );</script>&nbsp;<!--  
			    --><input type="hidden" name="cntr_tpsz_cd" value="" id="cntr_tpsz_cd" /></td>					
		    </tr>
		    <tr>
			    <th>Report Type</th>
			    <td><!--  
			    --><select name="report_type"><!--  
			    --><option value="N">Received</option><!--  
			    --><option value="Y">Not Receiving</option><!--  
			    --></select></td>					
			    <th>Receiving Date</th>
			    <td><!--  
			    --><input type="text" name="period_stdt" style="width:73px;text-align:center;" value="" class="input" dataformat="ymd" id="period_stdt" /><!--  
			    -->~&nbsp;<input type="text" name="period_eddt" style="width:73px;text-align:center" value="" class="input" dataformat="ymd" ><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></td>										
		    </tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!--<table>
		<colgroup>
			<col width="150">
			<col width="70">
			<col width="*">
		</colgroup>
       <tr>				      
		   <th class="title_design">Received Container</th>
		   <td><span id="Detail_text"></span>&nbsp;&nbsp;&nbsp;</td>
		   <td>&nbsp;</td>
	   </tr>
   </table> -->  	
	<div class="opus_design_grid">
		<h3 class="title_design" id="Detail_text">Received Container</h3>		
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
        <div style="display:none">
       		<script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
	</div>
</div>
</form>