<%
/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0018.jsp
*@FileTitle  :	Estimate expense
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
<%@ page import="com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.event.EesLse0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerCostAnalysis.PayableEstimateAudit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0018Event)request.getAttribute("Event");
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
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_Calculation"  	id="btn_Calculation">Calculation</button><!--  
	--><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!--  
	--><button type="button" class="btn_normal" name="btn_New" 	id="btn_New">New</button></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search bg">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100">
				<col width="130" />
				<col width="130" />
				<col width="130" />
                <col width="100" />	
                <col width="100" />  
				<col width="100" />
                <col width="*" />
                
			</colgroup>
			<tr>					   			
			    <th>Accrual Month</th>
			    <td><input type="text" name="period_eddt" style="width:60px;" value="" class="input1" maxlength="6" dataformat="ym" id="period_eddt" /><!--  
			    --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>	
			    <th>Revenue Month</th> 
                <td><input type="text" name="rev_month" style="width:60px;" value="" class="input" maxlength="6" dataformat="ym" id="rev_month" /><!--  
                --><button type="button" id="btn_calendar1" name="btn_calendar1" class="calendar ir"></button></td>	
                <th>Lease Term</th>
                <td><script type="text/javascript">ComComboObject('lstm_cd', 1, 55, 1 );</script></td> 
                <th>Charge Type</th>
                <td><script type="text/javascript">ComComboObject('lse_pay_chg_tp_cd',2,80,1);</script></td>
            </tr>		    
		</table>
        <table>
            <colgroup>
                <col width="97">
                <col width="100" />
                <col width="122" />                
                <col width="90" />     
                <col width="90" />   
                <col width="90" /> 
                <col width="130" />                 
                <col width="*" />
            </colgroup>
            <tr>
                <th>AGMT No.</th>
                <td>&nbsp;<input type="text" style="width: 35px" class="input" dataformat="engup" name="agmt_cty_cd" id="agmt_cty_cd" maxlength="3" value="HHO"><input type="text" style="width: 60px" class="input" dataformat="num" name="agmt_seq" id="agmt_seq" style="ime-mode:disabled; text-align:center;" maxlength="6"><button type="button" name="btns_agmt" id="btns_agmt"  class="input_seach_btn"></button></td>
                <th>Contract No.</th>
                <td><input type="text" name="lse_ctrt_no" caption="Contract No" style="width:130px;" class="input" value="" maxlength="20" dataformat="excepthan" id="lse_ctrt_no" /></td>
                <th>Lessor</th>
                <td>&nbsp;<input type="text" name="vndr_seq" id="vndr_seq" maxlength="6" style="width: 50px; text-align:center; ime-mode:disabled"  class="input" dataformat="num"><button type="button" class="input_seach_btn" name="btns_vndr" id="btns_vndr" ></button><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" readonly style="width: 200px; ime-mode:disabled" class="input2" value=""></td>
               <th>Sakura Account</th>
                <td><!-- <input type="text" name="skr_acct_cd" caption="Contract No" style="width:100px;" class="input" value="" maxlength="20" dataformat="num" id="skr_acct_cd" /> -->
                <script type="text/javascript">ComComboObject('skr_acct_cd',3,160,1);</script>
                </td>
            </tr>
       </table>
	</div>
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <div class="opus_design_btn">
         <button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
    </div>
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- opus_design_grid(E) -->
</form>