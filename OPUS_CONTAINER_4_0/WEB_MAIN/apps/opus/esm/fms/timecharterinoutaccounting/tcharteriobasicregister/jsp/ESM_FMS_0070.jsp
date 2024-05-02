<%
/*=========================================================
*@FileName 	 : ESM_FMS_0070.jsp
*@FileTitle  : Vendor Customer Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0070Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0070Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOBasicRegister");

    String condFlag = request.getParameter("condFlag")==null?"":request.getParameter("condFlag");

    String agmtFlag = request.getParameter("agmtFlag")==null?"":request.getParameter("agmtFlag");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0070Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Adding Logic extracting data from server when loading initial window ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		log.error("err " + e.toString(), e);
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="agmt_flag" id="agmt_flag" value="<%=agmtFlag%>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Vendor / Customer Inquiry Pop Up</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_normal" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_accent" name="btn_confirm" 	id="btn_confirm">Confirm</button><!--
		--><button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="145"/>
					<col width="100"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Search Keyword</th>
					<td colspan="2"><input type="text" style="width:145px;" class="input" name="search_name" dataformat="engup"  otherchar=" -._/" value="" id="search_name" /></td>
					<th>Condition</th>
					<td><!-- 
						 --><input type="radio" name="cond_flag" id="cond_flag" value="VP" class="trans" disabled <%=condFlag.equals("VP")?"checked":""%>>&nbsp;Vendor <!--
						--><input type="radio" name="cond_flag" id="cond_flag" value="CP" class="trans" disabled <%=condFlag.equals("CP")?"checked":""%>>&nbsp;Customer</td>
				</tr> 
			</tbody>
		</table>
		
	</div>
</div>
<div class="wrap_result">
   <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</form>