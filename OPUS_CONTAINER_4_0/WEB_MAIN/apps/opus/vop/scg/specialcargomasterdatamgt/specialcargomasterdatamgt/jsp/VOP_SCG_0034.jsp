<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0034.jsp
 *@FileTitle : Partner's Contact Point for SPCL CGO - Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0034Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	   
	   
		event = (VopScg0034Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd"    id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="tabSelectedIdx" value="0" id="tabSelectedIdx" />
<input type="hidden" name="transmit_target" id="transmit_target" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button>		
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="10" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>RSO</th>
				<td><script type="text/javascript">ComComboObject('rgn_shp_opr_cd', 2, 60, 1, 1);</script><input type="text" name="rgn_shp_opr_desc" id="rgn_shp_opr_desc" style="width:180px;" class="input2" value="" readOnly></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div name="tabLayer" id="tabLayer"  style="display:inline;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn1_RowAdd" 		id="btn1_RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn1_RowInsert" 			id="btn1_RowInsert">Row Insert</button><!-- 
				 --><button type="button" class="btn_normal" name="btn1_RowCopy" 			id="btn1_RowCopy">Row Copy</button><!-- 
				 --><button type="button" class="btn_normal" name="btn1_RowDelete" 			id="btn1_RowDelete">Row Delete</button>		
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div name="tabLayer" id="tabLayer"  style="display:none;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn2_RowAdd" 					id="btn2_RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn2_RowInsert" 			id="btn2_RowInsert">Row Insert</button><!-- 
				 --><button type="button" class="btn_normal" name="btn2_RowCopy" 			id="btn2_RowCopy">Row Copy</button><!-- 
				 --><button type="button" class="btn_normal" name="btn2_RowDelete" 			id="btn2_RowDelete">Row Delete</button>		
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>

	<div name="tabLayer" id="tabLayer"  style="display:none;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn3_RowAdd" 					id="btn3_RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn3_RowInsert" 			id="btn3_RowInsert">Row Insert</button><!-- 
				 --><button type="button" class="btn_normal" name="btn3_RowCopy" 			id="btn3_RowCopy">Row Copy</button><!-- 
				 --><button type="button" class="btn_normal" name="btn3_RowDelete" 			id="btn3_RowDelete">Row Delete</button>		
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>	
</div>
<!-- wrap_result(E) -->
				
</form>
