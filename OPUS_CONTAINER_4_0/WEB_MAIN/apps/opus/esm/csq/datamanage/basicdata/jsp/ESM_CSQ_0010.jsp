<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0010.jsp
*@FileTitle  : Target VVD Fix
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String creFlg = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.datamanage.basicdata");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCsq0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		creFlg =  (String)eventResponse.getETCData("creFlg");
		
	}catch(Exception e) {
		//out.println(e.toString());
	}
%>

<script type="text/javascript">
	var almightyFlag = false;
	function setupPage() {
		var errMessage = "";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(true);
	}
</script>

<form name="form" method="post" style="margin: 0px">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_fm_wk" id="f_fm_wk" />
<input type="hidden" name="f_to_wk" id="f_to_wk" />
<input type="hidden" name="cre_flg" value="<%=creFlg%>" id="cre_flg" />

<div class="page_title_area">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" id="btn_Retrieve" name="btn_Retrieve" >Retrieve</button><!-- 
		--><button type="button" class="btn_normal" id="btn_Save" name="btn_Save" >Save</button><!-- 
		--><button type="button" class="btn_normal" id="btn_Creation" name="btn_Creation">Creation</button><!-- 
		--><button type="button" class="btn_normal" id="btn_Downexcel" name="btn_Downexcel" >Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
</div>
	
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="95">
				<col width="45">
				<col width="70">
				<col width="90">
				<col width="110">
				<col width="*">
			</colgroup>
			<tr>
				<th class="sm pad_left_8" style="text-align: left;"><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd1" class="trans" value="Y"><label for="f_bse_tp_cd1">Yearly</label></th>
				<th>Year</th>
				<td><script type="text/javascript">ComComboObject('f_bse_yr', 1, 60, 1, 1 )</script></td>
				<th><div id="div_qtr">Quarter</div></th>
				<td><script type="text/javascript">ComComboObject('f_bse_qtr_cd', 1, 75, 1, 1 )</script></td>
				<td><div id="div_period"></div></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="95">
				<col width="45">
				<col width="70">
				<col width="90">
				<col width="80">
				<col width="100">
				<col width="70">
				<col width="60">
				<col width="90">
				<col width="75">
				<col width="*">
			</colgroup>
			<tr>
				<th class="sm pad_left_8" style="text-align: left;"><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd2" class="trans" value="Q" checked><label for="f_bse_tp_cd2">Quarterly</label></th>
				<th>Trade</th>
				<td><script type="text/javascript">ComComboObject('f_trd_cd', 1, 60, 1)</script></td>
				<th>Lane Bound</th>
				<td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 75, 1 )</script></td>
				<th>Sub Trade</th>
				<td><script type="text/javascript">ComComboObject('f_sub_trd_cd', 1, 60, 1 )</script></td>
				<th>R/Lane</th>
				<td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 70, 1 )</script></td>
				<th> </th>
				<th></th>
			</tr>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" id="btn_Retrieve1" name="btn_Retrieve1">SKD & BSA Inquiry</button><!--
			--><button type="button" class="btn_normal" id="btn_DisLane" name="btn_DisLane">Disable Lane Select</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>