<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAP_0003.js
*@FileTitle  : CSR No
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
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0003Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String inv_no = "";
	String ofc_cd = "";
	String inv_flg = "";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountPayableCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();	   
		event = (StmSap0003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		inv_no = StringUtil.xssFilter(request.getParameter("inv_no"));
		inv_no = inv_no==null?"":inv_no;
		ofc_cd = StringUtil.xssFilter(request.getParameter("ofc_cd"));
		ofc_cd = ofc_cd==null?"":ofc_cd;
		inv_flg = StringUtil.xssFilter(request.getParameter("inv_flg"));
		inv_flg = inv_flg==null?"":inv_flg;
		
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="ofc_cd" id="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="inv_flg" id="inv_flg" value="<%=inv_flg%>">

	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>CSR NO</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_OK" 		id="btn_OK">Ok</button><!--
				--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->

		</div>
		<!-- page_title_area(E) -->
	</div>
<div class="layer_popup_contents">	
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="40"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>CSR No</th>
						<td><input type="text"  name="inv_no" id="inv_no" dataformat="engup" style="width:160px;" class="input" value="<%=inv_no%>"></td>
					</tr>					
				</tbody>
			</table>
		</div>
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
