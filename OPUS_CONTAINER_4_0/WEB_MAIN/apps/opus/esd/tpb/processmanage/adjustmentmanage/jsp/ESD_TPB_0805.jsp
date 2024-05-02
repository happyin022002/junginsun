<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0805.jsp
*@FileTitle  : Write-off Request Message
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0805Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0805Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.AdjustmentManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTpb0805Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<form name="form" enctype="multipart/form-data">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- 개발자 작업	-->
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_file_no" id="s_file_no" />


<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Request Message for ROC or Write-off</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_save" 			id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
	
</div>


<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="120" />			
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
					<th>* Reason for Write-off, ROC</th>
					<td></td>					
				</tr>				
			</tbody>
		</table>
		<table>
			<colgroup>				
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
					<td><textarea type="text" style="resize:none;" rows="5" name="s_ra_rmk1" onblur="tpb_chkLenByByte(this,1000,'Preventive Measures ')"></textarea></td>				
				</tr>
			</tbody>
		</table>
		<table style="display:none" name="adjRmk2" id="adjRmk2">
			<colgroup>				
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
					<td>
						* Preventive Measures (Only Write-off)<br>
						<textarea type="text" style="width:98%" rows="5" name="s_ra_rmk2" onblur="tpb_chkLenByByte(this,1000,'Preventive Measures ')"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>				
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
					<td><input type="checkbox" checked="" readonly="" disabled="" /><font color="red">The Reason above will be uploaded in Recovery Activity of TPBs selected.</font></td>				
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

</div>
</form>