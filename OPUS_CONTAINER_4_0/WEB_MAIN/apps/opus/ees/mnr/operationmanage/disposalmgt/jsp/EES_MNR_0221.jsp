<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0221.jsp
*@FileTitle  : Sold Creation File Import_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0221Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0221Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	int insCnt 				= 0;
	if(request.getParameter("insCnt")!=null){
		String sInsCnt = request.getParameter("insCnt");
		insCnt = Integer.parseInt(sInsCnt);
	}

	Logger log = Logger.getLogger("com.clt.apps.AgreementManage.TariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0221Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from sever when first loading
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
<input type="hidden" name="ins_cnt" value="<%=insCnt%>" id="ins_cnt" />
<input type="hidden" name="pagerows" id="pagerows" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Sold Creation File Import</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_New" 				id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_LoadExcel" 		id="btn_LoadExcel">Load Excel</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_OK" 				id="btn_OK">OK</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_Close" 			id="btn_Close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->	
	
</div>
<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
<div class="wrap_result">
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Save" 			id="btn_Save">Verify</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_RowAdd" 			id="btn_RowAdd">Row Add</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_RowDel" 			id="btn_RowDel">Row Delete</button>		
		</div>
		<!-- opus_design_btn(E) -->		
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="*"/>												
			</colgroup> 			
			<tbody>				
				<tr>
					<td><h3 class="title_design">Sold Creation File Format</h3></td>									
				</tr>				
			</tbody>
		</table>
		<table class = "grid2 wAuto">
			<colgroup>				
				<col width="100"/>
				<col width="100"/>
				<col width="100"/>												
			</colgroup> 			
			<tbody>				
				<tr align="center">
					<td class ="sm"><strong>EQ No.</strong></td>
					<td class ="sm"><strong>P/Up Yard</strong></td>
					<td class ="sm"><strong>Sold DT</strong></td>					
				</tr>
				<tr align="center">
					<td>HLCU1234567</td>
					<td>KRPUSYK</td>
					<td>20091101</td>					
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
		
</div>
</div>
</form>