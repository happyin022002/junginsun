<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : stm_sco_0300.jsp
*@FileTitle : SAKURA Code Conversion
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
<%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0300Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    StmSco0300Event event = null;				//PDTO(Data Transfer Object including Parameters)
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
	   
		event = (StmSco0300Event)request.getAttribute("Event");
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
<input type="hidden" name="lgin_usr_ap_ofc" id="lgin_usr_ap_ofc" /> 
<input type="hidden" name="lgin_usr_locl_tm" id="lgin_usr_locl_tm" /> 

<!-- page_title_area(S) -->

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save"  	id="btn_save">Save</button>	
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
				<col width="100"/>
				<col width="250"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>Conversion Type</th>
		           	<td><script type="text/javascript">ComComboObject('lu_tp_cd', 2, 120, 1, 1, 0, false, 1);</script>		           	
		           	<!--  <input type="text" style="width:120;" class="input2"  name="lu_desc" id="lu_desc" readOnly></td> -->
		           	<th>Enable Flag</th>
		           	<td><select name="enbl_flg" class="input" style="width:50;" id="enbl_flg">
		                <option value="Y">Y</option>
		                <option value="N">N</option>
		                </select></td>		           
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>

