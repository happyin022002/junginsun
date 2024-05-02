<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0230.jsp
*@FileTitle : ACEP Candidate Cntr List 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0230Event"%>
<%@ page import="org.apache.log4j.Logger" %> 
					   
<% 					
	EesMnr0230Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= ""; 
	String strUsr_nm		= "";   
	String rhqOfcCd         = ""; 
	String currOfcCd       = "";
	String currOfcEngNm     = ""; 
	Logger log = Logger.getLogger("com.clt.apps.reportmanage.performancereport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm(); 
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();
		
		event = (EesMnr0230Event)request.getAttribute("Event");
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
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">   
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="month" id="month">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_Detail" 			id="btn_Detail">Detail</button>					
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
				<colgroup>
					<col width="30"/>
					<col width="200"/>
					<col width="120"/>
					<col width="60"/>
					<col width="60"/>
					<col width="*"/>			
			  	</colgroup>		
			  	<tbody>		
				<tr>
					<th>Date</th>
					<td><!--
					--><input type="text" name="cur_dt" id="cur_dt" style="width:80px;text-align:center" class="input1" dataformat="ymd" maxlength="10" required><!--
					--><button type="button" class="calendar ir" name="cur_dt_cal" id="cur_dt_cal" >calendar</button>
					</td>
					<th>Months after ACEP Audit</th>
					<td><!--
					--><script  type="text/javascript">ComComboObject('cb_month', 1, 50 , 0, 1);</script>
					</td>
					<th>Term </th>
					<td><!--
					--><script  type="text/javascript">ComComboObject('term_type', 1, 100 , 1, 0);</script>
					</td>
				</tr> 			
				<tr>
					<th>ACEP</th> 
					<td><!--
						--><script  type="text/javascript">ComComboObject('acep_type', 1, 80 , 1, 1);</script><!--
						--><input type="text" name="loc_cd" id="loc_cd" style="width:120px;" class="input" dataformat="engup" maxLength="7" CAPTION="ACEP">
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