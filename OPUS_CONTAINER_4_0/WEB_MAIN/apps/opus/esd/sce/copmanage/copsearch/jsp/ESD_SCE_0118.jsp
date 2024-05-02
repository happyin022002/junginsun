<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0118.jsp
*@FileTitle  : COP Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0118Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0118EventResponse"%>

<%
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		String userId=account.getUsr_id();

		EsdSce0118Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
		EsdSce0118EventResponse eventResponse = null;    	//RDTO(Data Transfer Object including DB ResultSet)

		Exception serverException   = null;
		String strErrMsg = "";
		DBRowSet rowSet      = null;
		int rowCount     = 0;

			try {
				serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

			if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }else{
	        	event = (EsdSce0118Event)request.getAttribute("Event");
	            eventResponse = (EsdSce0118EventResponse)request.getAttribute("EventResponse");
	            if (eventResponse != null) {
                	rowSet = eventResponse.getRowSet();
	                if(rowSet != null){
	                     rowCount = rowSet.getRowCount();
	                } // end if
	            } // end if
	        }
		} catch(Exception e){
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
        var formObject = document.form ;
    }

</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="old_cop_no">
<input type="hidden" name="new_cop_no">
<input type="hidden" name="cop_no_slave">
<input type="hidden" name="masterYN">
<input type="hidden" name="bkg_no">
<input type="hidden" name="user_id" value = <%=userId %>>
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>COP Inquiry</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
	
	<!-- wrap_search(S) -->	
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="65" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Cntr_NO. </th>
						<td><input name="cntr_no" id="cntr_no"  type="text" class="input1" maxlength=11 style="width:122px; text-transform:uppercase;" Onkeydown="onEnterKey(this)"  value="" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->	
	
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid (S) -->
		<div class="opus_design_grid" id="mainTable">
			<script language="javascript">ComSheetObject('t1sheet');</script>
		</div>
		<!-- opus_design_grid (E) -->
	</div>
	<!-- wrap_result(E) -->
</form>