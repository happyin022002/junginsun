<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0029.jsp
*@FileTitle  : On Hire Approval creation	
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
<%@ page import="com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event.EesLse0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0029Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc       = "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseMgt.OnhireApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();


		event = (EesLse0029Event)request.getAttribute("Event");
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
<input type="hidden" name="usr_ofc_cd" value="<%=strUsr_ofc%>" id="usr_ofc_cd">
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_normal" name="btn1_handleOnCharge" id="btn1_handleOnCharge">Handle On Charge</button><!--  
	--><button type="button" class="btn_normal" name="New"  	id="New">New</button><!--  
	--><button type="button" class="btn_normal" name="Save" 	id="Save">Save</button><!--  
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
				<col width="30">
				<col width="50">
				<col width="100">
				<col width="120">
				<col width="120">
				<col width="120">
				<col width="80">
				<col width="120">
				<col width="100">
				<col width="*">
			</colgroup>
			<tr>
				<th>Type</th>
				<td class="sm pad_left_4"><input type="radio" name="type_chk" value="O" class="trans" checked id="type_chk" />&nbsp;On-Hire&nbsp;&nbsp;<input type="radio" name="type_chk" value="L" class="trans" id="type_chk" />&nbsp;Lease Out</td>
				<th>LOC</th>
				<td><input type="text" name="loc_cd" style="width:50px;ime-mode:disabled;text-align:center;" value="" class="input1" dataformat="engup" maxlength="5" fullfill="" id="loc_cd" /><input type="hidden" name="loc_tp" value="LOC" class="trans" id="loc_tp" /><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button></td>
				<th>Lease Term</th> 
				<td><script type="text/javascript" >ComComboObject('combo1', 1, 50, 1 ,1);</script></td>
				<th>Pick Up Period</th>
				<td colspan="3"><input type="text" name="pkup_fm_dt" caption="Effective Date" style="width:75px;text-align:center;" class="input1" value="" dataformat="ymd" !cofield="pkup_fm_dt" id="pkup_fm_dt" />~&nbsp;<!--
                --><input type="text" name="pkup_due_dt" style="width:75px;text-align:center;" class="input1" value="" dataformat="ymd" !cofield="pkup_due_dt" id="pkup_due_dt" /><!--
                --><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
				<th>Auth No.</th>
				<td><input type="text" style="width:160px;" name="cntr_onh_auth_no" value="" class="input2" readonly id="cntr_onh_auth_no" /><input type="hidden" name="agmt_cty_cd" value="" id="agmt_cty_cd" /><input type="hidden" name="agmt_seq" value="" id="agmt_seq" /> </td>
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">
	<table>
		<colgroup>
			<col width="140">
			<col width="*">
		</colgroup>
		<tr>
			<th><h3 class="title_design">Term & Condition</h3></th>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div class="opus_design_inquiry" style="width:350px">
		<table>
			<colgroup>
				<col width="40">
				<col width="*">
			</colgroup>
			<tr>
				<th>TP/SZ</th>
				<td><script type="text/javascript" >ComComboObject('combo2', 1, 98, 1 ,1);</script><input type="text" name="tpsz_cd" style="width:182px" value="" class="input" readonly></td>
			</tr>
		</table>
	</div>
	<div class="opus_design_grid" id="tabLayer" style="display:none; margin-top:-30px;">
		<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="Row_Add" id="Row_Add">Row Add</button><!--  
	--><button type="button" class="btn_normal" name="Delete"  	id="Delete">Row Delete</button><!--    
	--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_data">
		<table class="grid2">
			<colgroup>
				<col width="90">
				<col width="*">
			</colgroup> 
			<tr>
				<th>Remark(s)</th>
				<td><textarea style="width:100%;height:80px;resize:none;" name="apro_rmk" id="apro_rmk"></textarea></td>
			</tr> 
		</table>
	</div>
</div>
</form>