<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0039.jsp
*@FileTitle  : Proposal Amendment Draft Print 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0039Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0039Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsmPri0039Event)request.getAttribute("Event");
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
<input type="hidden" name="pagerows">
<input type="hidden" name="cd_tp">
<input type="hidden" name="cd1">
<input type="hidden" name="cd2">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_open" id="btn_open">Open</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	    	<colgroup>
	            <col width="70px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<td colspan="3">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:500px;">
							<tr>
								<th>&nbsp;Print By</th>
							    <td class="stm">
									<input type="radio" value="1" name="ret_tp_rdo" class="trans" checked>&nbsp;S/C No.&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" value="2" name="ret_tp_rdo" class="trans">&nbsp;Proposal No.&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" value="3" name="ret_tp_rdo" class="trans">&nbsp;Authorizer&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" value="4" name="ret_tp_rdo" class="trans">&nbsp;Sales&nbsp;Rep.
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<!--TAB  (S) -->
						<div id="SearchLayer" style="display:inline">
							<!--  biz_1  (S) -->
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<th width="60">&nbsp;&nbsp;S/C No.</th>
									<td width="140"><input type="text" style="width:100;text-align: center;" name="sc_no" maxlength="9" dataformat="engup" class="input1"></td>
									<th width="55">AMD No.</th>
									<td width="100"><input type="text" style="width:50;text-align: center;" name="amdt_seq" readonly=true class="input2"></td> 
									<th width="55">Duration</th>
									<td width="180"><input type="text" style="width:75;text-align: center;" name="sc_dur_eff_dt" maxlength="10" dataformat="ymd" readonly=true class="input2">&nbsp;~&nbsp;
													<input type="text" style="width:75;text-align: center;" name="sc_dur_exp_dt" maxlength="10" dataformat="ymd" readonly=true class="input2"></td>
									<td>
										<table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<!-- <td class="btn2" name="btn_retrieve1">Retrieve</td> -->
												<td><button type="button" class="btn_etc" name="btn_retrieve1" id="btn_retrieve1">Retrieve</button></td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<!--  biz_1   (E) -->
						</div>
						<!--TAB  (E) -->
						
						<!--TAB  (S) -->
						<div id="SearchLayer" style="display:none">
						<!--  biz_1  (S) -->
							<table class="search" border="0" style="width:979;">
								<tr class="h23">
									<th width="85">&nbsp;&nbsp;Proposal No.</th>
									<td width="115"><input type="text" style="width:80;text-align: center;" name="prop_no" maxlength="10" dataformat="engup" class="input1"></td>
									<th width="55">Duration</th>
									<td width="180"><input type="text" style="width:75;text-align: center;" name="prop_dur_eff_dt" maxlength="10" dataformat="ymd" readonly=true class="input2">&nbsp;~&nbsp;
													<input type="text" style="width:75;text-align: center;" name="prop_dur_exp_dt" maxlength="10" dataformat="ymd" readonly=true class="input2"></td>
									<td ALIGN="left">
										<table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<!-- <td class="btn2" name="btn_retrieve2">Retrieve</td> -->
												<td><button type="button" class="btn_etc" name="btn_retrieve2" id="btn_retrieve2">Retrieve</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						<!--  biz_1   (E) -->
						</div>
						<!--TAB  (E) -->
						
						<!--TAB  (S) -->
						<div id="SearchLayer" style="display:none">
							<!--  biz_1  (S) -->
							<table class="search" border="0" style="width:979;">
								<tr class="h23">
									<th width="105">&nbsp;&nbsp;Approval Office</th>
									<td width="95"><input type="text" style="width:58;text-align: center;" name="apro_ofc_cd" readonly=true class="input2" value="<%=strUsr_ofc%>"></td>
									<th width="55">Auth by</th>
									<td width="140"><input type="text" style="width:100;" name="apro_usr_nm" readonly=true class="input2" value="<%=strUsr_nm%>"></td>
									<th width="65">Filed Date</th>
									<td width="230">
										<input type="text" style="width:75;text-align: center;" name="auth_dur_eff_dt" maxlength="10" dataformat="ymd" class="input1" >
										<span class="dash">~</span>
										<input type="text" style="width:75;text-align: center;" name="auth_dur_exp_dt" maxlength="10" dataformat="ymd" class="input1" ><!-- 
				 		 					--><a href="#" id="btns_calendar1" name="btns_calendar1" class="calendar ir">calendar</a>
									</td>
									<td>
										<table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<!-- <td class="btn2" name="btn_retrieve3">Retrieve</td> -->
												<td><button type="button" class="btn_etc" name="btn_retrieve3" id="btn_retrieve3">Retrieve</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<!--  biz_1   (E) -->
						</div>
						<!--TAB  (E) -->				
						
						<!--TAB  (S) -->
						<div id="SearchLayer" style="display:none">
							<!--  biz_1  (S) -->
							<table class="search" border="0" style="width:979;">
								<tr class="h23">
									<th width="105">&nbsp;&nbsp;Request Office</th>
									<td width="95"><input type="text" style="width:58px;text-align: center;" name="prop_ofc_cd" readonly=true class="input2" value="<%=strUsr_ofc%>"></td>
									<th width="65">Sales Rep.</th>
									<td width="260"><script type="text/javascript">ComComboObject('prop_srep_cd', 2, 70, 0, 1, 0, false);</script>&nbsp;
										<input type="text" style="width:180px;" name="prop_srep_nm" class="input2" disabled=true />
									</td>
									<th width="90">Creation Date</th>
									<td width="230"><input type="text" style="width:75px;text-align: center;" name="srep_dur_eff_dt" maxlength="10" dataformat="ymd" class="input1" >
													<span class="dash">~</span>
													<input type="text" style="width:75px;text-align: center;" name="srep_dur_exp_dt" maxlength="10" dataformat="ymd" class="input1" ><!-- 
				 		 					--><a href="#" id="btns_calendar2" name="btns_calendar2" class="calendar ir">calendar</a>
									<td>
										<table width="75" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<!-- <td class="btn2" name="btn_retrieve4">Retrieve</td> -->
												<td><button type="button" class="btn_etc" name="btn_retrieve4" id="btn_retrieve4">Retrieve</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<!--  biz_1   (E) -->
						</div>
						<!--TAB  (E) -->
					</td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>

<div id="confirmDialog"  title="ConfirmDialog" style="display: none">
	 <p>Do you want to download full version for filing new format?</p>
</div>

</form>