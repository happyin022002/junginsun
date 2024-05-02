<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0220.jsp
*@FileTitle  : Create Accounting Entries
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    //StmSap0220Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		//event = (StmSap0220Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
<input type="hidden" name="functional_currency" value="" id="functional_currency" />
<input type="hidden" name="f_curr_prcs" value="" id="f_curr_prcs" />
<input type="hidden" name="capture_period" value="" id="capture_period" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel" >Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="100"/>
			<col width="150"/>
			<col width="150"/>
			<col width="100"/>
			<col width="100"/>
			<col width="*" />
		</colgroup>
		<tbody>
		 <tr>
            <th>Accounting Date</th>
            <td><input type="text" style="width:80px;" value="" name="acctg_fr_dt" dataformat="ymd" maxlength="10" class="input1" required cofield="acctg_to_dt" caption="start date" id="acctg_fr_dt" /><button type="button" id="btns_calFr" name="btns_calFr" class="calendar ir"></button>~&nbsp;<input type="text" style="width:80px;" value="" name="acctg_to_dt" dataformat="ymd" maxlength="10" class="input1" required cofield="acctg_fr_dt" caption="end date" id="acctg_to_dt" /><button type="button" id="btns_calTo" name="btns_calTo" class="calendar ir"></button>
            <th>Accounting Source</th>
            <td><script type="text/javascript">ComComboObject('acctg_evnt_tp_cd', 2, 200, 1, 1,0,false,1);</script></td>
            <th>CSR No</th>
            <td><input type="text" style="width:175px;" value="" name="inv_no" maxlength="20" dataformat="engup"  class="input" id="inv_no" /></td>
        </tr>
    </table>
 </div>
</div>                   
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="100"/>
			<col width="200" />
			<col width="*" />
		</colgroup>
		<tbody>
		<tr>
            <th>Capture Period</th>
	        <td><input type="text" style="width:80px;" value="" name="capture_period_mm" dataformat="ym" maxlength="6" class="input1" id="capture_period_mm" /><button type="button" id="btns_calMm" name="btns_calMm" class="calendar ir"></button><input type="text" style="width:175px;" value="" name="csr_no" maxlength="20" dataformat="engup"  class="input1" id="csr_no" /><button type="button" class="btn_etc" name="btn_capture" id="btn_capture" >Capture</button></td>
	        <td></td>
        </tr>
    </table>
 </div>
</div>
<!-- opus_design_grid(E) -->                                      
 </form>