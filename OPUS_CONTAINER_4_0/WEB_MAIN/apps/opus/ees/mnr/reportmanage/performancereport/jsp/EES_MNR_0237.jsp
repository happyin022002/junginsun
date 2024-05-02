<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0237.jsp
*@FileTitle : MNR PFMC by Type/Size
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0237Event"%>
<%@ page import="org.apache.log4j.Logger" %>
	
<%
	EesMnr0237Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();	
		strUsr_nm = account.getUsr_nm();	
				
		event = (EesMnr0237Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}	
		
		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="usd_only" id="usd_only" value="N"> 

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="70"/>
				<col width="50"/>
				<col width="60"/>
				<col width="190"/>
				<col width="60"/>
				<col width="60"/>
				<col width="130"/>
				<col width="*"/>			
		  	</colgroup>				
			<tr>
				<th>Period</th>		  
				<td colspan="3">										
					<span class="inquiry_calendar">
						<script  type="text/javascript">ComComboObject('report_period_type',2, 110 , 1,1)</script><!-- 
				       	 --><input required type="text" name="fm_dt" id="fm_dt" dataformat="ymd"  maxlength="10"  size="10"  cofield="to_dt" value="" class="input1"><!-- 
				       	 --><span class="dash">-</span><!-- 
				      	 --><input required type="text" name="to_dt" id="to_dt" dataformat="ymd"  maxlength="10"  size="10"  cofield="fm_dt" class="input1"><!-- 
				       	 --><a class="calendar ir" name="btn_calendar" id="btn_calendar" style="cursor:pointer">calendar</a>
				    </span>				
				</td>
				<th>EQ Type</th>	  	
				<td><script  type="text/javascript">ComComboObject('eq_type',2, 90, 1, 0, 0,false,1);</script></td>
				<th>TP/SZ</th>
				<td>
					<script  type="text/javascript">ComComboObject('tp_sz_cd', 2, 153, 0);</script>
				</td>
				<td></td>	
			</tr>
			<tr> 		
				<th>Regional HQ</th>	 
				<td>
					<script  type="text/javascript">ComComboObject('rhq',2, 100, 0, 0);</script>
				</td>
				<th>Country</th>					
				<td>
					<script  type="text/javascript">ComComboObject('country',2, 100, 0, 0);</script>
				</td>
				<th>Office</th>			
				<td>
					<script  type="text/javascript" >ComComboObject('ofc_cd',2, 100 ,0, 0,'',0,'');</script>
				</td>					
				<th>Service Provider</th> 	
				<td>
					<input type="text" name="vndr_seq" id="vndr_seq" caption="Service Provider" style="width:57px;text-align:left;" class="input" value="" dataformat="num" maxlength="6"><!-- &nbsp;
					 --><button type="button" name="btn_provider_popup" id="btn_provider_popup" id="btn_provider_popup" class="input_seach_btn"></button><!-- 
					 --><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" caption="Service Provider" style="width:200px;" class="input2" value="" readonly>
				</td> 	
			</tr>	
			<tr>	 
				<th>Account Code</th>			 	
				<td>
					<script  type="text/javascript">ComComboObject('acct_cd', 2, 100, 1, 0,0,false,4);</script>
				</td>		
				<th>Cost Code</th> 
				<td>
					<script  type="text/javascript">ComComboObject('cost_cd',2, 100, 1, 0, 0,false,1);</script>
				</td>
				<th>Cost Detail Code</th> 
				<td>
					<script  type="text/javascript">ComComboObject('cost_dtl_cd',2, 100, 1, 0, 0,false,1);</script>
				</td>
				<th>USD Only</th>
				<td>
					<input name="temp_usd_only" id="temp_usd_only" type="checkbox" value="Y" class="trans">
				</td>  
				<td></td> 		
			</tr>					  			 	
		</tbody>
	</table>	
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" >	

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button>				
	</div>
	<!-- opus_design_btn(E) -->
	
	<script type="text/javascript">ComSheetObject('sheet1');</script>	
</div>
<!-- opus_design_grid(E) -->
</div>
</form>