<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_COA_4014.jsp
*@FileTitle : COA AVG Agency Commission
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
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.event.EsmCoa4014Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmCoa4014Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id  = "";
	String strUsr_nm  = "";
	String strUsr_ofc = "";

	String xml = "";
	Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.StatementCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	   
		event = (EsmCoa4014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
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
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
<input type="hidden" name="f_selgroup" id="f_selgroup" /> 

<!-- page_title_area(S) -->

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_creation"   	id="btn_creation">Creation</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  	id="btn_downexcel">Down Excel</button>
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
				<col width="90px"/>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>YYYY-MM</th>
					<td>
						<input type="text" style="width:100px;text-align:center;" class="input1" name="f_cost_yrmon" id="f_cost_yrmon" dataformat="ym" required caption="YYYY MM"><!--
						--><button type="button" class="calendar" name="f_cost_yrmon_cal" id="f_cost_yrmon_cal" class="calendar ir"></button>
					</td>
					<th>Office</th>
		           	<td><input type="text" name="f_ofc_cd" id="f_ofc_cd" style="width:60px;text-align:center;" class="input" dataformat="engup"  style="ime-mode:disabled" maxlength="5" caption="Office Code"></td>
		            <td width="*"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_tab">
		<script language="javascript">ComTabObject('tab1');</script>
	</div>
	<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="t1btn_rowadd" id="t1btn_rowadd">Row Add</button>
			<button type="button" class="btn_accent" name="t1btn_save" id="t1btn_save">Save</button>
		</div>
		<!-- opus_grid_btn(E) -->
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="t2btn_rowadd" id="t2btn_rowadd">Row Add</button>
			<button type="button" class="btn_accent" name="t2btn_save" id="t2btn_save">Save</button>
		</div>
		<!-- opus_grid_btn(E) -->
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
   </div>
</div>
</form>

