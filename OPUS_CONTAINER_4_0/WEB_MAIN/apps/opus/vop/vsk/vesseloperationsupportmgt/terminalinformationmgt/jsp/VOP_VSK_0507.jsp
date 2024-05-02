<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0507.jsp
*@FileTitle  : Terminal Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event.VopVsk0507Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	VopVsk0507Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationSupportMgt.TerminalInformationMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopVsk0507Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="comboCd" id="comboCd">
<input type="hidden" name="pagerows" id="pagerows">


<!-- page_title_area(S) -->
<div class="page_title_area">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="30">
					<col width="120">
					<col width="70">
					<col width="100">
					<col width="160">
					<col width="*">
				</colgroup>
				<tr>
					<th>Port</th>
					<td><!-- 
						 --><input type="text" style="width: 60px; text-align:center;ime-mode:disabled;" class="input1" value="" name="loc_cd" id="loc_cd" dataformat="engup"  maxlength="5"><!-- 
						 --><button type="button" class="input_seach_btn"  name="ComOpenPopupWithTarget" id="ComOpenPopupWithTarget"></button>
					</td>
					<th>RHQ</th>
					<td>
						<div id="enablePorRhq" style="display:none;">
							<script type="text/javascript">ComComboObject('por_rhq', 0, 90, 0, 1);</script>
						</div>
						<div id="disablePorRhq" style="display:inline;">
							<input type="text" style="width: 80px; text-align:center;" class="input2" value="" name="por_rhq_diable" id="por_rhq_diable" readonly>
						</div>
					</td>
					<th>Updated Date</th>
					<td><!-- 
						 --><input type="text" name="upd_dt_view" id="upd_dt_view" style="width: 115px; text-align:center;" class="input2" readOnly><!-- 
						 --><input type="text" name="upd_id_view" id="upd_id_view" style="width: 70px;" class="input2" readOnly>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline;">
		<div class="opus_design_grid">
				<div class="opus_design_btn"><!-- 
					 --><button type="button" class="btn_accent" name="btn_t1RowAdd" id="btn_t1RowAdd">Row Add</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_t1RowInsert" id="btn_t1RowInsert">Row Insert</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_t1Delete" id="btn_t1Delete">Row Delete</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_t1DownExcel1" id="btn_t1DownExcel1">Down Excel</button>
				</div>
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			<div class="opus_design_data mar_top_12">
				<table class="grid_2">
					<colgroup>
						<col width="200">
						<col width="*">
					</colgroup> 
					<tbody>
						<tr>
							<th><strong>Remark(s)</strong></th>
							<td><textarea style="width: 100%; height: 60px ;ime-mode:disabled; resize:none" name="gntr_rmk" id="gntr_rmk"></textarea></td>
						</tr>
					</tbody>
				</table> 
			</div>
		</div>
	</div>
	<div id="tabLayer" style="display:none;">
		<div class="opus_design_grid">
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_t2RowAdd" id="btn_t2RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t2RowInsert" id="btn_t2RowInsert">Row Insert</button><!--
				 --><button type="button" class="btn_normal" name="btn_t2Delete" id="btn_t2Delete">Row Delete</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t2DownExcel1" id="btn_t2DownExcel1">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
			<div class="opus_design_data mar_top_12">
				<table class="grid_2">
					<colgroup>
						<col width="200">
						<col width="*">
					</colgroup> 
					<tbody>
						<tr>
							<th><strong>Remark(s)</strong></th>
							<td><textarea style="width:100%; height:60px;ime-mode:disabled;resize:none;" name="fltg_rmk" id="fltg_rmk"></textarea></td>
						</tr>
					</tbody>
				</table> 
			</div>
		</div>
	</div>
	
	<div id="tabLayer" style="display:none;">
		<div class="opus_design_grid">
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_t3RowAdd" id="btn_t3RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t3RowInsert" id="btn_t3RowInsert">Row Insert</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t3Delete" id="btn_t3Delete">Row Delete</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t3DownExcel1" id="btn_t3DownExcel1">Down Excel</button>
			</div>
				<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
	</div>
	<div id="tabLayer" style="display:none;">
		<div class="opus_design_grid">
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_t4RowAdd" id="btn_t4RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t4RowInsert" id="btn_t4RowInsert">Row Insert</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t4Delete" id="btn_t4Delete">Row Delete</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_t4DownExcel1" id="btn_t4DownExcel1">Down Excel</button>
			</div>
				<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>