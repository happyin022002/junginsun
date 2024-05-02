<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0224.jsp
*@FileTitle : Hanger Bar Inventory History Pop Up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.event.EesMnr0224Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0224Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String ofcCd = ((request.getParameter("ofc_cd")==null )?"":request.getParameter("ofc_cd"));

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strRhq_ofc_cd         = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();

		event = (EesMnr0224Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<!--Use a common at MNR  -->
<script language="javascript">
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

        $('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
        $('#btn_Retrieve').after($('#btn_Close'));
        
        document.getElementById("title").innerHTML = "Hanger Bar Inventory History";
        
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="key_value">
<input type="hidden" name="usr" value="<%=strUsr_id %>">
<input type="hidden" name="ar_hd_qtr_cd">


	
		<!-- page_title_area(S) -->
		<!-- page_title_area(S) -->
		
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span id="title"> </span></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_normal" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_Close"	id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
	<!-- popup_contens_area(S) -->
	
	
		<!-- opus_design_inquiry(S) -->
		<div class="wrap_search">
<div class="opus_design_inquiry wFit">
		    <table>
		        <tbody>
					<tr>
						<th width="40px">Office</th>
						<td width="100px"><input name="ofc_cd" value="<%=ofcCd%>" type="text" style="width:75px" class="input2" readOnly></td>
						<th >Period</th>
		              	<td >
							<input name="from_dt" type="text" style="width:75px" class="input" dataformat="ymd" cofield="to_dt">&nbsp;~
							<input name="to_dt" type="text" style="width:75px" class="input" dataformat="ymd" cofield="from_dt"><!--
							 <img name="btn_calendar" class="cursor" src="img/btns_calendar.gif" width="19px" height="20" border="0" align="absmiddle">
	                  --><button type="button" name="btns_to_eff_dt" id="btns_to_eff_dt"  class="calendar ir"></button></td>	
					</tr>
					
				</tbody>
			</table>
			
		</div>
		<!-- opus_design_inquiry(E) -->
		</div>
	<div class="wrap_result">	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid"> 
		    <script language="javascript">ComSheetObject('sheet1');</script>
	    </div>
		<!-- opus_design_grid(E) -->
		
	</div>
	<!-- popup_contens_area(E) -->
	
	
</form>
