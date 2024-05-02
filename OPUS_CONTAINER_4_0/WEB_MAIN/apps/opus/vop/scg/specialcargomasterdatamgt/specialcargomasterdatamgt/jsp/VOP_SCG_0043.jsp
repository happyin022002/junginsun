<%/*=========================================================
*@FileTitle : Packaging Code (Creation)
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_SCG_0043.js
*@FileTitle  : Packaging Code (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0043Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0043Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (VopScg0043Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Save"  		id="btn_Save">Save</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="100px"/>
					<col width="150px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th class="wrap_search_btn">Packaging Style</th>
					<td class="wrap_search_btn">
						<input type="radio" value="" name="imdg_pck_tp_cd" id="imdg_pck_tp_cd" checked><label for="imdg_pck_tp_cd">All</label><!--
						--><input type="radio" value="I" name="imdg_pck_tp_cd" id="imdg_pck_tp_cd_I" ><label for="imdg_pck_tp_cd_I">Inner</label><!--
						--><input type="radio" value="O" name="imdg_pck_tp_cd" id="imdg_pck_tp_cd_O" ><label for="imdg_pck_tp_cd_O">Outer</label><!--
						--><input type="radio" value="M" name="imdg_pck_tp_cd" id="imdg_pck_tp_cd_M" ><label for="imdg_pck_tp_cd_M">Intermediate</label>
					</td>
					<td></td>
				</tr>	
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_RowAdd" 	id="btn_RowAdd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_RowInsert" 	id="btn_RowInsert">Row Insert</button><!--
			--><button type="button" class="btn_normal" name="btn_RowCopy" 	id="btn_RowCopy">Row Copy</button><!--
			--><!--  <button type="button" class="btn_normal" name="btn_RowDelete" 	id="btn_RowDelete">Row Delete</button>-->
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
