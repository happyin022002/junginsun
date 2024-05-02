<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : STM_SCO_0400.jsp
*@FileTitle : TES Manual Cancellation
*Open Issues :
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0 
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0410Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    StmSco0410Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id  = "";
	String strUsr_nm  = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sco.statementcommon.StatementCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	   
		event = (StmSco0410Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
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
<input type="hidden" name="locl_curr_cd" id="locl_curr_cd" /> 
<input type="hidden" name="key" id="key" />  
<input type="hidden" name="job_flg" id="job_flg" /> 

<!-- page_title_area(S) -->

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--<!--
		--><button type="button" class="btn_normal" name="btn_new"   	id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  	id="btn_save">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90px"/>
				<col width="90px"/>
				<col width="90px"/>
				<col width="120px"/>
				<col width="90px"/>
				<col width="90px"/>
				<col width="90px"/>
				<col width="90px"/>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Module</th>
		           	<td><script type="text/javascript">ComComboObject('mdl_tp_cd', 1, 60, 0, 1);</script></td>
					<th>Accrual Month</th>
					<td>
						<input type="text" style="width:100px;text-align:center;" class="input1" name="accl_yrmon" id="accl_yrmon" dataformat="ym" required caption="Accrual Month"><!--
						--><button type="button" class="calendar" name="accl_yrmon_cal" id="accl_yrmon_cal" class="calendar ir"></button>
					</td>
					<th>Trade</th>
		           	<td><script type="text/javascript">ComComboObject('trd_cd', 2, 60, 0, 0);</script></td>
		            <th>Account</th>
                    <td><script type="text/javascript">ComComboObject('acct_cd', 2, 80, 0, 0);</script></td>
                    <td width="*"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_tab">
		<!-- 
		<div class="opus_design_btn">
			<span style="color: #000000; text-align: right; font-weight: bold; padding-right: 5px;">Currency [USD]</span>
		</div>
		 -->
		<script language="javascript">ComTabObject('tab1');</script>
	</div>
	<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
   </div>
</div>
</form>

