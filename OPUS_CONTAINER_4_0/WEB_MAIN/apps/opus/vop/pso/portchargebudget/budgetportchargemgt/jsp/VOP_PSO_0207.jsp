<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_pso_0207.jsp
*@FileTitle  : Monthly Estimation Creation (Detail)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0207Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0207Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String sdt = "";
	String edt = "";
	String xxx = "";
	String acct_cd = "";
	String exe_yrmon = "";
	String cost_cd = "";
	String contiCd = "";
	String acctCd = "";
	Logger log = Logger.getLogger("com.clt.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0207Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		sdt 		= StringUtil.xssFilter(request.getParameter("sdt"));
		edt 		= StringUtil.xssFilter(request.getParameter("edt"));
		acct_cd 	= StringUtil.xssFilter(request.getParameter("acct_cd"));
		xxx 		= StringUtil.xssFilter(request.getParameter("xxx"));
		exe_yrmon	= StringUtil.xssFilter(request.getParameter("exe_yrmon"));
		cost_cd  	= StringUtil.xssFilter(request.getParameter("cost_cd"));
		contiCd		= eventResponse.getETCData("conti_cd");
		acctCd		= eventResponse.getETCData("acct_cd");
		if(JSPUtil.getNull(sdt).equals("")){
			sdt = xxx;
			edt = xxx;
		}
		//sdt = xxx;
		//edt = xxx;

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
var gContiCd  = "<%=contiCd%>";
var gAcctCd  = "<%=acctCd%>";
var gParamAcctCd  = "<%=acct_cd%>";
var gParamCostCd  = "<%=cost_cd%>";
var gParamSdt     = "<%=sdt%>";
var gParamEdt     = "<%=edt%>";
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
<input type="hidden" name="exe_yrmon" id="exe_yrmon" value="<%=exe_yrmon%>"/>
<input type="hidden" name="cost_cd" id="cost_cd" value="<%=cost_cd%>"/>

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Monthly Estimation Creation (Detail)</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 			id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_Excel"           id="btn_Excel">Down Excel</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_close" 			id="btn_close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->

	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>				
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="40%">				
			</colgroup>
			<tbody>
			    <tr>
				    <th>Continent</th>
					<td><script type="text/javascript">ComComboObject('conti_cd',2,170,1,0);</script></td>
					<th>Activity Month</th>
					<td><input type="text" name="sdt" id="sdt" dataformat="ym"  size="10" style="width:60px;" class="input" value="<%=sdt %>"><!-- 
				 	 --><button type="button" id="btns_calendar_s" name="btns_calendar_s" class="calendar ir"></button>~ 
				        <input type="text" name="edt" id="edt" dataformat="ym"  size="10" style="width:60px;" class="input" value="<%=edt %>"><!-- 
				     --><button type="button" id="btns_calendar_e" name="btns_calendar_e" class="calendar ir"></button>
					<%--<input readonly name="sdt" type="text" style="width:60px;text-align:center;" class="input2" value="<%=sdt %>" id="sdt" />~ <input readonly name="edt" type="text" style="width:60px;text-align:center;" class="input2" value="<%=edt %>" id="edt" /> --%>
					</td>
					<th>Account Code</th>
					<td><script type="text/javascript">ComComboObject('acct_cd',2, 96, 0, 1);</script><input id="account_nm" name="account_nm" style="width: 180px; text-align:left" class="input2" value="" readonly type="text" /></td>
					<%-- 
					<td><input readonly name="acct_cd" type="text" style="width:55px;text-align:center;" class="input2" value="<%=acct_cd %>" id="acct_cd" /></td>
					--%>
					<td>&nbsp;</td>
				</tr>
				<tr>
				    <th>Option</th>
				    <td colspan="6"><!-- 
					 --><input name="match_flag" type="radio" value="all" class="trans" checked="" id="match_flag1" /><label for="match_flag1"><strong>All</strong></label><!-- 
					 --><input name="match_flag" type="radio" value="match" class="trans" id="match_flag2" /><label for="match_flag2"><strong>Accrual Cost Match</strong></label><!-- 
					 --><input name="match_flag" type="radio" value="unmatch" class="trans" id="match_flag3" /><label for="match_flag3"><strong>Accrual Cost Mismatch</strong></label><!-- 
					 --><input name="match_flag" type="radio" value="match003" class="trans" id="match_flag4" /><label for="match_flag4"><strong>Estimate Cost is 0</strong></label><!-- 
					 --><input name="match_flag" type="radio" value="match004" class="trans" id="match_flag5" /><label for="match_flag5"><strong>Accrual Cost > 0</strong></label><!-- 
					 --><input name="match_flag" type="radio" value="match005" class="trans" id="match_flag6" /><label for="match_flag6"><strong>Accrual Cost < 0</strong></label></td>

				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</form>