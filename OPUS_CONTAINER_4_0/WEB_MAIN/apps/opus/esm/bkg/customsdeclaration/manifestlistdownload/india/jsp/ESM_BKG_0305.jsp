<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0305.jsp
*@FileTitle  : ESM_BKG_0305
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0305Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0305Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCntCd			= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCntCd  = account.getCnt_cd();
	   
	   
		event = (EsmBkg0305Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>W/H (Bond Area) Inquiry</span></h2>
		<div class="opus_design_btn">
		 	<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  -->
		 	<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--  -->
		 	<button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!--  -->
		 	<button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail</button><!--  -->
		 	<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
				<!--  biz_1  (S) -->
				<table>		 
				<tr class="h23">
					<th width="70px">Country</th>
					<td width="140">
						<input type="text" style="width:50px;" class="input1" value="<%=strCntCd%>" name="cnt_cd"
						dataformat="engup" maxlength="2" fullfill caption="Country">
					</td>
					<th width="60px">Location</th>
					<td width="170">
						<input type="text" style="width:100px" class="input" name="loc_cd"
						dataformat="engup" maxlength="5" fullfill caption="Location">
					</td>
					<th width="110px">W/H Abbr. Code</th>
					<td width="170">
						<input type="text" style="width:100px;" class="input" name="wh_cd"
						dataformat="engup" maxlength="5" caption="W/H Abbr. Code">
					</td>
					<th width="130px">W/H Customs Code</th>
					<td>
						<input type="text" style="width:100px" class="input" name="cstms_cd"
						dataformat="engup" maxlength="10" caption="W/H Customs Code">
					</td>
				</tr> 
				<tr class="h23">
					<th>W/H Name</th>
					<td colspan="7">
						<input type="text" style="width:309px;" class="input" name="wh_nm"
						dataformat="engup" maxlength="500" caption="W/H Name">
					</td>
				</tr> 
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid"  id="mainTable">
				<h3 class="title_design"><b>Warehouse Information</h3>
			<script language="javascript">ComSheetObject('sheet1');</script> 
    	</div>		
	</div>		
</div>

</form>
