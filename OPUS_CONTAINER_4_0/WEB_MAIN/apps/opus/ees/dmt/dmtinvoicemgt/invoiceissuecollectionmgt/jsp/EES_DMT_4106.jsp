<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4106.jsp
*@FileTitle  : Invoice Cancel Reason Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4106Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesDmt4106Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	String strCnt_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

	String invoice_no = "";
	String cre_ofc_cd = "";
	String dmdt_trf_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

		event = (EesDmt4106Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		invoice_no	= JSPUtil.getParameter(request,"dmdt_inv_no");
		cre_ofc_cd =  JSPUtil.getParameter(request,"cre_ofc_cd");
		dmdt_trf_cd	= JSPUtil.getParameter(request,"dmdt_trf_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>



<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!--  Developer's task -->
<input type="hidden" name="dmdt_inv_no" id="dmdt_inv_no" value="<%=invoice_no%>"  />
<input type="hidden" name="cre_ofc_cd" id="cre_ofc_cd" value="<%=cre_ofc_cd%>"  />
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd" value="<%=dmdt_trf_cd%>"  />
<input type="hidden" name="success_yn" id="success_yn" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Invoice Cancel Reason Entry</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			 <button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		 </div>
		<!-- opus_design_btn(E) -->
	</div>
</div>

<div class="layer_popup_contents">	
	<!-- page_title(E) -->
	<div class= "wrap_search">
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>

		<div class= "opus_design_inquiry" >
			<table>
				<colgroup>
					<col width="50" />
					<col width="80" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Remark(s)</th>
						<td colspan="3"><textarea name="cxl_rmk" cols="" rows="5" style="width:100%;resize:none;"></textarea></td>
					</tr>
					 <tr>
						<th>Office</th>
						<td><input type="text" style="width:70px;" class="input2" value="<%=strUsr_ofc %>"></td>
						<th>Name</th>
						<td><input type="text" style="width:100%;" class="input2" value="<%=strUsr_nm %>"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>	
</form>			