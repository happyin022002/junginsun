<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1064.jsp
*@FileTitle  : Pick up Upload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1064Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1064Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1064Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Pick up Upload</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_FileImport" 			id="btn_FileImport">File Import</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_Verify" 			id="btn_Verify">Verify</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_Close" 			id="btn_Close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>				
					<col width="50"/>
					<col width="50"/>
					<col width="50"/>
					<col width="50"/>
					<col width="50"/>
					<col width="60"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
						<td class="sm"><input type="radio" name="rail_cd" value="BN" class="trans" id="rail_cd" /> <strong>BN</strong></td>
	                    <td class="sm"><input type="radio" name="rail_cd" value="UP" class="trans" id="rail_cd" /> <strong>UP</strong></td>
	                    <td class="sm"><input type="radio" name="rail_cd" value="NS" class="trans" id="rail_cd" /> <strong>NS</strong></td>
	                    <td class="sm"><input type="radio" name="rail_cd" value="CN" class="trans" id="rail_cd" /> <strong>CN</strong></td>
	                    <td></td>                
	                    <!-- <th>File Name</th> -->
	                    <td>&nbsp;</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" name="tabLayer" id="tabLayer">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid " name="tabLayer" id="tabLayer">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" name="tabLayer" id="tabLayer">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<!-- opus_design_grid(E) -->	
	</div>
</div>
</form>