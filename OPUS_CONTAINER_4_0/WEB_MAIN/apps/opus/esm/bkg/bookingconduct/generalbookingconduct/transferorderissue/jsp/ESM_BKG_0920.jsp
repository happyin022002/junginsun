<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0920.jsp
*@FileTitle  : TRO - Copy
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0920Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0920Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			////serverException
	String strErrMsg = "";						//error massage
/*	
	int rowCount	 = 0;						//DB ResultSet list count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
*/

	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.TransferOrderIssue");
	
	try {	
/* 		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   */ 
	
		event = (EsmBkg0920Event)request.getAttribute("Event");		
	   
		 //when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Developer Work	-->
<input type="hidden" name="ui_id"     value=""><!-- historyLine -->
<input type="hidden" name="io_bnd_cd" value="">
<input type="hidden" name="tro_seq"   value="">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>TRO - Copy</span></h2>
		<div class="opus_design_btn">
		 	<button type="button" class="btn_normal" name="btn_OK" id="btn_OK">OK</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
<div class=wrap_search>
 	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="10%" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>Booking No.</th>
					<td>
						<input type="text" name="bkg_no" style="width:100px" class="input2" value="" readonly>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	</div>
	<div class=wrap_result>
	<div class="opus_design_grid">
		<div class="opus_design_btn">
		 	<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	</div>
</div>

</form>


<SCRIPT LANGUAGE="javascript">
<!--
      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo   = event.getBkgNo();
            String boundCd = event.getBoundCd();
            String troSeq  = event.getTroSeq();
            String uiId    = event.getUiId();
        %>    
            eval("bkg_no").value    = "<%=bkgNo%>";
            eval("io_bnd_cd").value = "<%=boundCd%>";
            eval("tro_seq").value   = "<%=troSeq%>";
            eval("ui_id").value     = "<%=uiId%>";
        <% } %>
       }
-->
</SCRIPT>
