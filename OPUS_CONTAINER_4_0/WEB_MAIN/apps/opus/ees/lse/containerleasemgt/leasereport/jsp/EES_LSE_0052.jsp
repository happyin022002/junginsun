<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0052.jsp]
*@FileTitle  : On-Hire Result by Lease Term/Lessor-Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19

=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0052Event"%>
<%@ page import="com.clt.apps.opus.ees.lse.lsecommon.LSEUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0052Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseMgt.LeaseReport");

	//Company name과 code를 가져오기위한 선언  : 자사 & 자회사
	String[] company = null;		    //company

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0052Event)request.getAttribute("Event");
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

<input type="hidden" name="detail_lstm_cd" id="detail_lstm_cd" />
<input type="hidden" name="detail_vndr_seq" id="detail_vndr_seq" />
<input type="hidden" name="detail_cntr_tpsz_cd" id="detail_cntr_tpsz_cd" />
<input type="hidden" name="tysz" id="tysz" />
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
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th>Period</th>
				<td><input type="text" name="period_stdt" style="width:70px;ime-mode:disabled;text-align:center;" value="" class="input1" dataformat="ymd" id="period_stdt" /> ~ <!--  
				--><input type="text" name="period_eddt" style="width:70px;ime-mode:disabled;text-align:center" value="" class="input1" dataformat="ymd" id="period_eddt" /><!--  
				--><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button>
				</td>
			</tr>	
		</table>
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="150">
				<col width="*">
			</colgroup>
			<tr>
			    <th>Lessor</th>
			    <td><input type="text" style="width:70px;" name="vndr_seq" value="" class="input" dataformat="num" maxlength="6" id="vndr_seq" /><!--  
			    --><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button><!--  
			    --><input type="text" name="abbr_nm" style="width:108px;" class="input2" readonly id="abbr_nm" /><!--  
			    --><input type="text" name="vndr_nm" style="width:353px;" class="input2" readonly id="vndr_nm" /></td>
			    <td>&nbsp;</td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="80">
				<col width="200">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
			    <th>Lease Term</th>
			    <td><script type="text/javascript" >ComComboObject('combo1', 1, 209, 1 );</script><!--  
			    --><input type="hidden" name="lstm_cd" value="" id="lstm_cd" /></td>
			    <th>TP/SZ</th>
			    <td><!--  
			    --><script type="text/javascript" >ComComboObject('combo2', 1, 270, 1 );</script><!--  
			    --><input type="hidden" name="cntr_tpsz_cd" value="" id="cntr_tpsz_cd" /></td>
			</tr>
			<tr>
			    <th>Term Change</th>
			    <td><select name="term_change"><!--  
			    --><option value="">Including</option><!--  
			    --><option value="N" selected >Excluding</option><!--  
			    --><option value="Y">Only</option><!--  
			    --></select></td>
			    <th>DII</th>
			    <td><select name="dii"><!--  
			    --><option value="" selected>Including</option><!--  
			    --><option value="N">Excluding</option><!--  
			    --><option value="Y">Only</option><!--  
			    --></select></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_DownExcel1" id="btn_DownExcel1">Down Excel</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_more" id="btn_more">More</button><!--  
		--><button type="button" class="btn_accent" name="btn_DownExcel2" id="btn_DownExcel2">Down Excel</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>