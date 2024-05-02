<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAP_0005.jsp
*@FileTitle  : Source 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0005Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountPayableCommonSC");
	
	String lu_cd = StringUtil.xssFilter(request.getParameter("lu_cd")) != null ? StringUtil.xssFilter(request.getParameter("lu_cd")) : "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSap0005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<script  type="text/javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Source</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_ok" 		id="btn_ok">Ok</button><!--
			--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="40"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Source</th>
						<td><input type="text" name="lu_cd" id="lu_cd" style="width:150px;" class="input" dataformat="engup" value="<%=lu_cd%>"></td>
					</tr>					
				</tbody>
			</table>
		</div>
     </div>
    <!-- opus_design_grid(S) -->
	<div class="wrap_result" style="overflow:hidden; padding-bottom:30px !important;">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>