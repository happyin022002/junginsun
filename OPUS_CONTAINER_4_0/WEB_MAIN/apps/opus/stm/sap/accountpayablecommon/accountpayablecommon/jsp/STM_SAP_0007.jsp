<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0007.jsp
*@FileTitle  : Payment Method Popup
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
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0007Event"%>  

<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0007Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String lu_cd     = "";                      //PARAMETER
		
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountpayablecommonSC"); // 에러메세지 위치
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSap0007Event)request.getAttribute("Event");  
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		lu_cd = StringUtil.xssFilter(request.getParameter("lu_cd"));  //PARAMETER
		lu_cd = lu_cd==null?"":lu_cd;           //PARAMETER
				
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
		loadPage(); // .js 호출
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Payment Method</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_OK" id="btn_OK" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- opus_design_inquiry(S) -->
<div class="layer_popup_contents ">
	<div class= "wrap_search">
	  <div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80">
					<col width="200">
					<col width="*">
				</colgroup>
				<tr class="h23">
					<th>Payment Method</th>
                    <td style="font-weight:normal;">
						<input type="text" name="lu_cd" id="lu_cd" maxlength="25" dataformat="engup" style="width:180px;" class="input" value="<%=lu_cd%>">
                    </td>
                    <td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
      </div>
   </div>
   <!-- opus_design_inquiry(E) -->
   <!-- opus_design_grid(S) -->
	<div class="wrap_result" style="overflow:hidden; padding-bottom:30px !important;">
	   <div class="opus_design_grid">
	    	<script type="text/javascript">ComSheetObject('sheet1');</script>
	   </div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>