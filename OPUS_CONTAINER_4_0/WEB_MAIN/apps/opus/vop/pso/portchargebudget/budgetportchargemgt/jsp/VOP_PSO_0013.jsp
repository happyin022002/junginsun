<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : vop_pso_0013.jsp
*@FileTitle : Interface to ERP
*@author : CLT
*@version : 1.0
*@since : 2014.05.16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Field for BackEndJob -->
<input type="hidden" name="key" id="key" />

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_creation" id="btn_creation" style="display:none;">Creation</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_Excel" id="btn_Excel">Down Excel</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_DtlExcel" id="btn_DetlExcel">Detail Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->
<div class= "wrap_search">
<div class="opus_design_inquiry">		
	<table> 
	<colgroup>	
		<col width="10%"/>
	    <col width="15%"/>			
		<col width="10%"/>
		<col width="15%"/>
		<col width="10%"/>
		<col width="40%"/>			
	</colgroup>
	<tbody>
		<tr>
			<th>Accrual Month</th>
			<td>
				<input name="exe_yrmon" id="exe_yrmon" dataformat="ym" maxlength="6" type="text" style="ime-mode:disabled; width:65px; text-align:center;" class="input1" value=""><button type="button" id="btns_calendar_s0" name="btns_calendar_s0" class="calendar ir"></button>
			</td>
			<th>Activity Month</th>
			<td>
				<input type="text" name="txtsdate" id="txtsdate" dataformat="ym"  size="10" style="width:60px;" class="input" value="" ><!-- 
				 --><button type="button" id="btns_calendar_s" name="btns_calendar_s" class="calendar ir"></button>~ 
				<input type="text" name="txtedate" id="txtedate" dataformat="ym"  size="10" style="width:60px;" class="input" value="" ><!-- 
				 --><button type="button" id="btns_calendar_e" name="btns_calendar_e" class="calendar ir"></button></td>
			<th>Status</th>						
			<td><input type="text" name="status" id="status" class="input2" readonly/></td>
		</tr>
	</tbody>
	</table>
</div>
</div>
<div class="wrap_result">
<div class="opus_design_grid">
	<div class="opus_design_btn">
		<span style="color: #000000; text-align: right; font-weight: bold; padding-right: 5px;">Currency [USD]</span>
	</div>	
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>

<div class="opus_design_grid" id="div_dummy" style="display: none;" >
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
</div>
</form>
