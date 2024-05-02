<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0060.jsp
*@FileTitle  : Ocean Route Creation - Multi Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0060Event"%>
<%
	EsdPrd0060Event  event = null;	
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	try {
		event = (EsdPrd0060Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>



<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="lnk_cnt" id="lnk_cnt" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Ocean Route Creation - Multi Creation</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="130" />
					<col width="95" />
					<col width="130" />
					<col width="90" />
					<col width="130" />
					<col width="90" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Lane</th>
						<td>
							<input class="input1" name="lane1" id="lane1" tabindex="1"  maxlength="3" required="" caption="Lane" style="text-transform:uppercase" type="text" value="" dataformat="engup" /><!-- 
							 --><button type="button" id="btn_tnk_lane_cd" name="btn_tnk_lane_cd" class="input_seach_btn"></button>
						<th>1st T/S Lane</th>
						<td>
							<input name="lane2" id="lane2" tabindex="2"  maxlength="3" type="text" style="text-transform:uppercase" value="" dataformat="engup" /><!-- 
							 --><button type="button" id="btn_1st_lane_cd" name="btn_1st_lane_cd" class="input_seach_btn"></button>
						<th>2nd T/S Lane </th>
						<td>
							<input name="lane3" id="lane3" tabindex="3"  maxlength="3" style="text-transform:uppercase" type="text" dataformat="engup" /><!-- 
							 --><button type="button" id="btn_2nd_lane_cd" name="btn_2nd_lane_cd" class="input_seach_btn"></button>
						<th>3rd T/S Lane</th>
						<td>
							<input name="lane4" id="lane4" type="text"  maxlength="3" tabindex="4" style="text-transform:uppercase" dataformat="engup" /><!-- 
							 --><button type="button" id="btn_3rd_lane_cd" name="btn_3rd_lane_cd" class="input_seach_btn"></button>
						</td>	
					</tr>
				</tbody>
			</table>
		</div>
	</div>			
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_rowadd" 	id="btng_rowadd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btng_rowcopy" id="btng_rowcopy">Row Copy</button><!--
		--></div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>