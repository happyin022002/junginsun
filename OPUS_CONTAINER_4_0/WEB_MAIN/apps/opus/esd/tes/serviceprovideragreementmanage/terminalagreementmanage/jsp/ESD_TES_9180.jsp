<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_9180.js
*@FileTitle  : Thrp Cost List & data Insert	
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9180Event"%>
<%
	EsdTes9180Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Sever Exception
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count	
	
	String cost_cd		=  JSPUtil.getParameter(request, "cost_cd", "");
	String agmt_no		=  JSPUtil.getParameter(request, "agmt_no", "");
	String agmt_ver_no	=  JSPUtil.getParameter(request, "agmt_ver_no", "");
	
	String agmt_ofc_cty_cd	= agmt_no.substring(0,3);
	String agmt_seq		= agmt_no.substring(3,8);
	agmt_ver_no			= agmt_ver_no.substring(0,2)+agmt_ver_no.substring(3,5);
	
	String		userId	= "";

	try {
	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();

		event = (EsdTes9180Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage	= "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="tml_agmt_ofc_cty_cd" value="<%=agmt_ofc_cty_cd%>" id="tml_agmt_ofc_cty_cd" />
<input type="hidden" name="tml_agmt_seq" value="<%=agmt_seq%>" id="tml_agmt_seq" />
<input type="hidden" name="tml_agmt_ver_no" value="<%=agmt_ver_no%>" id="tml_agmt_ver_no" />
<input type="hidden" name="lgs_cost_cd" value="<%=cost_cd%>" id="lgs_cost_cd" />
<input type="hidden" name="cre_usr_id" value="<%=userId%>" id="cre_usr_id" />
<input type="hidden" name="loop_value" id="loop_value" />
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Register Throughput Cost Code</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
				--><button type="button" class="btn_normal" name="btn_save"  		id="btn_save">Save</button>	
			</div>
			<!-- opus_design_btn(E) -->
			<!-- page_location(S) -->
			<div class="location">
				<span id="navigation"></span>
			</div>
			<!-- page_location(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<div class="layer_popup_contents">
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
					<colgroup>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
				    <tbody>
					<tr>
						<th>Cost Code </th>
						<td><script type="text/javascript">ComComboObject('lgs_cost_cd_c',1, 90 ,0)</script></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>