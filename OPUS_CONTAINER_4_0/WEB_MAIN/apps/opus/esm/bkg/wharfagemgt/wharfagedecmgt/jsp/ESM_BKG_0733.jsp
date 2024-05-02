<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0733.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0733Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr" %>
<%
	EsmBkg0733Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0733Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//  extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="companyCd" value = "<%=ConstantMgr.getCompanyCode() %>">
	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Wharfage Vessel Information - Location Code</span></h2>
			<!-- page_title(E) -->

			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
				 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
				 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
				 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
			 --></div>
			<!-- opus_design_btn(E) -->
		</div>
	<!-- page_title_area(E) -->
	</div>
	<!-- popup_title_area(E) -->
	<div class="layer_popup_contents">
		<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table>
					<tbody>
						<tr>
							<th><%=ConstantMgr.getCompanyCode() %> Code</th>
							<td><input type="text" style="width:80px;" class="input" name="loc_cd" id="loc_cd" dataformat="engup" maxlength="5"></td>
							<th>MF Code</th>
							<td><input type="text" style="width:80px;" class="input" name="un_loc_id" id="un_loc_id"  dataformat="engup" maxlength="5"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
				<button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
			</div>
			<!-- opus_grid_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		</div>
	</div>
</form>