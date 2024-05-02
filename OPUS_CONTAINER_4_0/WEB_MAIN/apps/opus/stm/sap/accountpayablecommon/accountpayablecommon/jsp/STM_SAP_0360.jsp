<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAP_0360.jsp
*@FileTitle  : AR Office Code Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/23
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0360Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0360Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String ofc_cd    = "";                      //PARAMETER
	String str_security_flag = "";               //PARAMETER
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountpayablecommonSC"); // 에러메세지 위치
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSap0360Event)request.getAttribute("Event");  
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		ofc_cd = StringUtil.xssFilter(request.getParameter("ofc_cd"));  //PARAMETER
		ofc_cd = ofc_cd==null?"":ofc_cd;          //PARAMETER
		str_security_flag = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("security_flag")));
		
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
		loadPage(); // .js 호출
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="str_security_flag" value="<%=str_security_flag %>" id="str_security_flag" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>AR Office Code</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_OK" 		id="btn_OK">OK</button><!--
			--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
		</div>
		<!-- opus_design_btn(E) -->

	</div>
	<!-- page_title_area(E) -->
</div>
<!-- opus_design_inquiry(S) -->
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
			  	<tbody>
					<colgroup>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
				    
					<tr>
						<th>Office Code</th>
						<td><input type="text" name="ofc_cd" style="width:120px;" class="input" value="<%=ofc_cd%>" maxlength="6" dataformat="enguponly" id="ofc_cd" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
		<table></table>
	</div>
	<!-- opus_design_inquiry(E) -->
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