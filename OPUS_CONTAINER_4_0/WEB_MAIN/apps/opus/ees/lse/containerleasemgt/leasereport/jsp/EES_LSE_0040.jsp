<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0040.jsp
*@FileTitle  : Off Hire Result-Average using Day 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0040Event"%>
<%@ page import="com.clt.apps.opus.ees.lse.lsecommon.LSEUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0040Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.leasereport");
	
	//Company name과 code를 가져오기위한 선언  : 자사 & 자회사
	String[] cntrUseCoCd = null;		    //company

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0040Event)request.getAttribute("Event");
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<input type="hidden" name="lstm_cd" id="lstm_cd" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />
<input type="hidden" name="hcond_params" id="hcond_params" />
<input type="hidden" name="hcond_tpsz_cd" id="hcond_tpsz_cd" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search bg">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="60">
				<col width="260">
				<col width="120">
				<col width="*">
			</colgroup>
			<tr> 
				<th>Period</th>
				<td style="width: 188px; "><input type="text" name="str_evnt_dt" id="str_evnt_dt" caption="Start Duration" style="width:70px;text-align:center;ime-mode:disabled;" class="input1" value="" dataformat="ymd" >~&nbsp;<!--  
				--><input type="text" name="end_evnt_dt" id="end_evnt_dt" caption="End Duration" style="width:70px;text-align:center;ime-mode:disabled;" class="input1" value="" dataformat="ymd" ><!--  
				--><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>
				<th>Lease Term</th>
				<td><script type="text/javascript">ComComboObject('combo1', 1, 160, 1, 1);</script></td>
			</tr>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="260">
				<col width="120">
				<col width="220">
				<col width="140">
				<col width="*">
			</colgroup>
			<tr>
				<th>AGMT No.</th>
				<td><input type="text" name="agmt_cty_cd" id="agmt_cty_cd" caption="AGMT No." style="width:39px;text-align:center;" class="input2" value="HHO" readonly><!--  
				--><input type="text" caption="AGMT No." name="agmt_seq" id="agmt_seq" style="width:56px;" class="input" value="" maxlength="6" dataformat="num"><!--  
				--><button type="button" name="btns_search2" id="btns_search2" class="input_seach_btn"></button><!--  
				--><input type="text" name="ref_no" id="ref_no" style="width:120px" class="input2" readonly></td>
				<th>TP/SZ</th>
				<td><script type="text/javascript" >ComComboObject('combo2', 1, 160, 1 );</script></td>
				<th>Term Change</th>
				<td><select name="com_cre_flg" id="com_cre_flg" style="width:90px;" class="input1"><!--  
				--><option value="">Including</option><!--  
				--><option value="N" selected>Excluding</option><!--  
				--><option value="Y">Only</option><!--  
				--></select></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="60">
				<col width="620">
				<col width="122">
				<col width="*">
			</colgroup>
			<tr>
				<th>Lessor</th>
				<td>
					<input type="text" name="vndr_seq" id="vndr_seq" caption="Lessor." style="width:105px;text-align:center;" class="input" value="" maxlength="6" dataformat="num"><!--  
					--><button type="button" name="btns_search" id="btns_search" class="input_seach_btn" onClick="openPopup('cust_cd')"></button><!--  
					--><input type="text" name="vndr_abbr_nm" id="vndr_abbr_nm" caption="Lessor." style="width:120px;text-align:center;"  class="input2" value="" readonly><!--  
					--><input type="text" name="vndr_nm" id="vndr_nm" caption="Lessor." style="width:325px"  class="input2" value="" readonly></td>
				<th>DII</th>
				<td style="padding-left:4px"><select name="cntr_sts_cd" id="cntr_sts_cd" style="width:90px;" class="input1"><!--  
				--><option value="1" selected>Including</option><!--  
				--><option value="2">Excluding</option><!--  
				--><option value="3">Only</option><!--  
				--></select></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" style="width: 45%;margin-right: 4%;" id="mainTable">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--   
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="sheetTable2">
		<table>
   			<tr>
   				<td>&nbsp;</td>
   				<td id="dcondTD" style="color:gray;">&nbsp;</td>
   			</tr>
   		</table>
		<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_more" id="btn_more">More</button><!--  
		--><button type="button" class="btn_accent" name="btn_DownExcel2" id="btn_DownExcel2">Down Excel</button><!--   
		--></div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>