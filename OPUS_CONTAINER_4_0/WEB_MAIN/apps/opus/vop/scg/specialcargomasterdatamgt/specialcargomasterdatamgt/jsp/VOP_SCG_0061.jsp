<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : vop_scg_0061.jsp
 *@FileTitle: Packaging Code (Inquiry)
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/23
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0061Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0061Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoMasterDataMgt.SpecialCargoMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0061Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
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

<form name="form"  id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows"  id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn1_Excel" id="btn1_Excel" type="button">Down Excel</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry">
		<table style="width:979px">
			<tbody>
				<colgroup>
					<col width="70"/>
					<col width="330"/>
					<col width="90"/>
					<col width="120"/>
					<col width="90"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Packaging Style</th>
					<td><input type="radio" value="" name="imdg_pck_tp_cd" checked="" class="trans" caption="All" id="imdg_pck_tp_cd" /><label for="imdg_pck_tp_cd">All</label><!-- 
						 --><input type="radio" caption="Inner" value="I" name="imdg_pck_tp_cd" class="trans" id="imdg_pck_tp_cd_I" /><label for="imdg_pck_tp_cd_I">Inner</label><!-- 
					  	 --><input type="radio" value="O" name="imdg_pck_tp_cd" class="trans" caption="Outer" id="imdg_pck_tp_cd_O" /><label for="imdg_pck_tp_cd_O">Outer</label><!-- 
					     --><input type="radio" value="M" name="imdg_pck_tp_cd" class="trans" caption="Intermediate" id="imdg_pck_tp_cd_M" /><label for="imdg_pck_tp_cd_M">Intermediate</label></td>
					<th>Packaging Code</th>
					<td><input type="text" name="imdg_pck_cd" style="ime-mode:disabled" maxlength="5" dataformat="engup" id="imdg_pck_cd" style="width:100px;"/> </td>
					<th>Packaging Description</th>
					<td><input type="text" name="imdg_pck_desc" style="ime-mode:disabled" id="imdg_pck_desc" style="width:100%;"/> </td>
				</tr>
				
				
				
			</tbody>
		</table>
		<table class="height_10"><tr><td colspan="8"></td></tr></table>

	</div>
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" >			
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
</div>
<!-- opus_design_grid(E) -->

</form>
  