<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_399.jsp
*@FileTitle  : NVOCC House B/L Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0399Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0399Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String ofc_cd    = "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentationBL");
	
	String shprNm = "";
	String cneeNm = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd    = account.getOfc_cd();

		event = (EsmBkg0399Event)request.getAttribute("Event");
		shprNm = event.getShprNm();
		cneeNm = event.getCneeNm();
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">



<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>House B/L Template</span></h2>
		
		<div class="clear" style="text-align:right; margin:5px 0;" >	
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button> 
			<input type="radio" name="rd_target" value="S" class="trans" checked>SHPR&nbsp;&nbsp;
			<input type="radio" name="rd_target" value="C" class="trans">CNEE&nbsp;&nbsp;
			<input type="radio" name="rd_target" value="B" class="trans">SHPR+CNEE
			<button type="button" class="btn_normal" name="btn_CheckSelect" id="btn_CheckSelect">Select</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:684;"> 
				<tr class="h23">
					<td width="50">Shipper</td>
					<td width="280"><input type="text" name="shpr_nm" value="<%//=shprNm%>" style="ime-mode:disabled;width:220px;" dataformat="engup" otherchar=" !@#$%^*()_+&-,." class="input1"></td>
					<td width="70">Consignee</td>
					<td width="280"><input type="text" name="cnee_nm" value="<%//=cneeNm%>" style="ime-mode:disabled;width:220px;" dataformat="engup" otherchar=" !@#$%^*()_+&-,." class="input1"></td>
					<td width="40">Office</td>
					<td width="64"><input type="text" name="ofc_cd" value="<%=ofc_cd%>" style="ime-mode:disabled;width:60px;" dataformat="engupnum" class="input2" readOnly></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">				
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--  -->
					<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid" >
			<div class="opus_design_grid">				
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_RowAdd2" id="btn_RowAdd2">Row Add</button><!--  -->
					<button type="button" class="btn_normal" name="btn_Delete2" id="btn_Delete2">Row Delete</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>	
			<script language="javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>

</form>