<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0096.jsp
*@FileTitle  : Lease Agreement Version Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/22
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0096Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0096Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");

	String strAgmtCtyCd  = "";
	String strAgmtSeq    = "";
	String strAgmtVerSeq = "";
	String strOrgEffDt   = "";
	String strOrgExpDt   = "";	
	String strNewEffDt   = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0096Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strAgmtCtyCd  = (String)eventResponse.getCustomData("agmt_cty_cd");
		strAgmtSeq    = JSPUtil.getLPAD((String)eventResponse.getCustomData("agmt_seq"),6, "0");
		strAgmtVerSeq = (String)eventResponse.getCustomData("agmt_ver_seq");
		strOrgEffDt   = (String)eventResponse.getCustomData("eff_dt");
		strOrgExpDt   = (String)eventResponse.getCustomData("exp_dt");
		strNewEffDt   = DateTime.getFormatDate(DateTime.addDays(JSPUtil.replace(strOrgExpDt,"-",""), 1),"yyyyMMdd", "yyyy-MM-dd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Lease Agreement Version-Up</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_OK" 			id="btn_OK">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->		
		
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>					
					<col width="120"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr class="h23">
						<th>AGMT Ver.</th>
						<td>
							<input type="text" name="agmt_cty_cd" caption="AGMT Ver." style="width:35px;text-align:center;" class="input2" value="<%= strAgmtCtyCd %>" !maxlength="8" !dataformat="ymd" !cofield="exp_dt" readonly="" /><!-- 
							 --><input type="text" name="agmt_seq" caption="AGMT Ver." style="width:55px;text-align:center;" class="input2" value="<%= strAgmtSeq %>" !maxlength="8" !dataformat="ymd" !cofield="eff_dt" readonly="" /><!-- 
							 --><input type="text" name="agmt_ver_seq" caption="AGMT Ver." style="width:25px;text-align:center;" class="input2" value="<%= strAgmtVerSeq %>" !maxlength="8" !dataformat="ymd" !cofield="eff_dt" readonly="" />
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>					
					<col width="120"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr class="h23">
						<th>Effective Date</th>
						<td width=""><input type="text" name="eff_dt" caption="Effective Date" style="width:75px;text-align:center;" class="input2" value="<%= strOrgEffDt %>" dataformat="ymd" !cofield="exp_dt" readonly="" id="eff_dt" /><span class ="dash">~</span><input type="text" name="exp_dt" caption="Effective Date" style="width:75px;text-align:center;" class="input2" value="<%= strOrgExpDt %>" dataformat="ymd" !cofield="eff_dt" readonly="" id="exp_dt" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		<table class="line_bluedot" style="width:100%;"><tr><td colspan="6"></td></tr></table>
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>					
					<col width="120"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr class="h23">
						<th>New AGMT Ver.</th>
						<td width="">
							<input type="text" name="agmt_cty_cd" caption="AGMT Ver." style="width:35px;text-align:center;" class="input2" value="<%= strAgmtCtyCd %>" !maxlength="8" !dataformat="ymd" !cofield="exp_dt" readonly="" /><!-- 
							 --><input type="text" name="agmt_seq" caption="AGMT Ver." style="width:55px;text-align:center;" class="input2" value="<%= strAgmtSeq %>" !maxlength="8" !dataformat="ymd" !cofield="eff_dt" readonly="" /><!-- 
							 --><input type="text" name="agmt_ver_seq" caption="AGMT Ver." style="width:25px;text-align:center;" class="input2" value="<%= Integer.parseInt(strAgmtVerSeq)+1 %>" !maxlength="8" !dataformat="ymd" !cofield="eff_dt" readonly="" />
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>					
					<col width="120"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr class="h23">
						<th>New Effective Date</th>
						<td width=""><input type="text" name="new_eff_dt" caption="Effective Date" style="width:75px;text-align:center;" class="input2" value="<%= strNewEffDt %>" dataformat="ymd" !cofield="new_exp_dt" readonly="" id="new_eff_dt" /><span class = "dash">~</span><input type="text" name="new_exp_dt" caption="Effective Date" style="width:75px;text-align:center;" value="" maxlength="8" id="new_exp_dt" dataformat="ymd" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>
						</td>
					</tr> 
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
		
</div>
</form>