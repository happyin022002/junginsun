<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2007.jsp
*@FileTitle  : RFA Proposal Creation [Request]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String propNo = null;
    String amdtSeq = null;
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAProposalMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        propNo = JSPUtil.getNull(request.getParameter("prop_no"));
        amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
	}catch(Exception e) {
		out.println(e.toString());
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
<input type="hidden" name="prop_no" value="<%=propNo %>" 	id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=amdtSeq %>" 	id="amdt_seq" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2><span ></span></h2>
	<h2 class="page_title"><span>RFA Proposal Creation [Request]</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Send" 		id="btn_Send">Send</button> 
	    <button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
</div>
<div class="layer_popup_contents">
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="70">
				<col width="60">
				<col width="160">
				<col width="80">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
                    <th>Office Code</th>
                    <td><input type="text" name="ofc_cd" maxlength="6" style="width:60px;ime-mode:disabled;" onkeypress="ComKeyOnlyAlphabet('upper');" class="input" id="ofc_cd" /> </td>
                    <th>User ID</th>
                    <td><input type="text" name="usr_id" style="width:150px;ime-mode:disabled;" class="input" id="usr_id" /> </td>
                    <th>User Name</th>
                    <td><input type="text" name="usr_nm" style="width:150px;ime-mode:disabled;" class="input" id="usr_nm" /> </td>
                    <td><button type="button" class="btn_accent" name="btn_Search" id="btn_Search">Retrieve</button></td>
                </tr>
			</tbody>
		</table>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_result">
<!-- layout_wrap(S) -->
<div class="layout_wrap"> 
    <div class="layout_vertical_3"  style = "width: 327px">
		<div class="opus_design_gird">		
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	
	<div class="layout_vertical_3" style = "width: 100px">
	<div class="opus_design_inquiry">
	<br><br><br>
	<table style = "text-align: center;">
		<tbody>
              <tr>
              	<td><table><tr><td align="center"><button type="button" class="btn_right" name="btn_AddTo" id="btn_AddTo"></button></td></tr></table>
              	<!-- <img src="img/btns_add.gif" width="26" height="26" alt="" border="0" align="absmiddle" class="cursor" name="btn_AddTo"> --></td>
             </tr>
              <tr>
              	<td><table><tr><td align="center"><button type="button" class="btn_left" name="btn_DeleteTo" id="btn_DeleteTo"></button></td></tr></table>
              	<!-- <img src="img/btns_del.gif" width="26" height="26" alt="" border="0" align="absmiddle" class="cursor" name="btn_DeleteTo"> -->
              	</td>
             </tr>
              <tr>
              	<td style="height:60px"></td>
              </tr>
              <tr>
              	<td><table><tr><td align="center"><button type="button" class="btn_right" name="btn_AddCC" id="btn_AddCC"></button></td></tr></table>
              	<!-- <img src="img/btns_add.gif" width="26" height="26" alt="" border="0" align="absmiddle"class="cursor" name="btn_AddCC"> --></td>
              </tr>
              <tr>
              	<td style="padding-top:5"><table><tr><td align="center"><button type="button" class="btn_left" name="btn_DeleteCC" id="btn_DeleteCC"></button></td></tr></table>
              	<!-- <img src="img/btns_del.gif" width="26" height="26" alt="" border="0" align="absmiddle" class="cursor" name="btn_DeleteCC"> --></td>
              </tr>
         </tbody>
 	</table>
    </div>
	</div>
	
	<div class="layout_vertical_3" style = "width: 457px">
		<div class="opus_design_gird" id="subTable1">		
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<br>
		<div class="opus_design_grid" id="subTable2">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
</div>
</div>
</div>
</form>