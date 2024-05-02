<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0057.js
*@FileTitle  : Total Container Inventory by Lease Term & TY/SZ 
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
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0057Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0057Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.leasereport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0057Event)request.getAttribute("Event");
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
<input type="hidden" name="lstm_cd" id="lstm_cd" />
<input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" />
<input type="hidden" name="cnmv_sts_cd" id="cnmv_sts_cd" />
<input type="hidden" name="hcond_params" id="hcond_params" />
<input type="hidden" name="hcond_vndr_seq" id="hcond_vndr_seq" />
<input type="hidden" name="hcond_lstm_cd" id="hcond_lstm_cd" />
<input type="hidden" name="hcond_tpsz_cd" id="hcond_tpsz_cd" />
<input type="hidden" name="hcond_mvsts_cd" id="hcond_mvsts_cd" />
<input type="hidden" name="hcond_lsepaytp_cd" id="hcond_lsepaytp_cd" />
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
				<col width="100">
				<col width="80">
				<col width="100">
				<col width="*">
			</colgroup>
			<tr>
			    <th>Location</th>
			    <td><select name="loc_tp"  dataformat="engup" style="width:65px"><!--  
			    --><option value="" selected>ALL</option><!--  
			    --><option value="RCC">RCC</option><!--  
			    --><option value="LCC">LCC</option><!--  
			    --><option value="SCC">SCC</option><!--  
			    --></select><!--  
			    --><input type="text" style="width:100px;text-align:center;" name="loc_cd"  value="" class="input"  dataformat="engup" maxlength="5" fullfill><!--  
			    --><button type="button" name="btns_search1" id="btns_search1" class="input_seach_btn"></button></td>
			    <th>Lessor</th>
				<td><input type="text" name="vndr_seq" caption="Lessee" style="width:60px" class="input" value="" maxlength="6" dataformat="num" id="vndr_seq" /><!--  
				--><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button><!--  
				--><input type="text" name="vndr_abbr_nm" caption="Lessee" style="width:112px;text-align:center;" class="input2" value="" readonly id="vndr_abbr_nm" /><!--  
				--><input type="text" name="vndr_nm" caption="Lessor." style="width:306px;" class="input2" value="" readonly id="vndr_nm" /></td>
				<td class="pad_left_4"><input type="checkbox" name="chk_expand" class="trans" id="chk_expand" name="chk_expand" />All Expanded</td>
				
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="80">
				<col width="185">
				<col width="100">
				<col width="250">
				<col width="80">
				<col width="*">
			</colgroup>
		    <tr>
				<th>Lease Term</th>
				<td><script type="text/javascript">ComComboObject('combo1', 1, 169, 1 , 0);</script></td>
				<th>TP/SZ</th>
				<td><script type="text/javascript" >ComComboObject('combo2', 1, 206, 1 , 0 );</script></td>
				<th>MVMT Status</th>
				<td><script type="text/javascript" >ComComboObject('combo3', 1, 182, 1 , 0);</script></td>
				<th>Lease Payment Type</th>
                <td><script type="text/javascript" >ComComboObject('lse_pay_tp_cd', 2, 70, 1 );</script><input type="hidden" name="lse_pay_tp_cd" value="" id="lse_pay_tp_cd" /></td>
				
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script> 
	</div>
	<div class="opus_design_grid" id="sheetTable2">
		<table>
   			<tr>
   				<td>&nbsp;</td>
   				<td id="dcondTD" style="color:gray;"></td>
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