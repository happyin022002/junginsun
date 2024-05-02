<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0035.jsp
*@FileTitle : COP POPUP
*Open Issues :
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0009Event"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%
    EsdSce0009Event         event           = null;
    Exception                serverException = null;
    DBRowSet                 rowSet          = null;
    String strErrMsg = "";
    int rowCount	 = 0;

	try {

		event = (EsdSce0009Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String cop_no 		= StringUtil.xssFilter(request.getParameter("cop_no"));
	String bkg_no 		= StringUtil.xssFilter(request.getParameter("bkg_no"));
	String cop_sts_cd 	= StringUtil.xssFilter(request.getParameter("cop_sts_cd"));

	

%>
<script type="text/javascript">
<!--
function setupPage() {
}
//-->
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="cop_no" value="<%=cop_no%>" id="cop_no" />
<input type="hidden" name="bkg_no" value="<%=bkg_no%>" id="bkg_no" />
<input type="hidden" name="cop_sts_cd" value="<%=cop_sts_cd%>" id="cop_sts_cd" />
<input type="hidden" name="bound_name" value="O" id="bound_name" />
<input type="hidden" name="iscompled" value="Y" id="iscompled" />
<input type="hidden" name="isnodchg" value="N" id="isnodchg" />
<input type="hidden" name="isfrmchg" value="N" id="isfrmchg" />
<input type="hidden" name="ts_area" id="ts_area" />

<!-- opus_design_data(E) -->
<div class="layer_poup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span id="titles">COP Manual Replan Option</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
			  --><button type="button" class="btn_accent" name="btn_ok" id="btn_ok">Ok</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<div class="layer_popup_contents"> 
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="grid_2">
				<colgroup>
					<col width="250" />
					<col width="*" />
				</colgroup>
				<tbody>
<!-- 					<tr> 
						<td><input type="radio" id="comm_choice" name="comm_choice" value="N" onClick="selectCompleted();" Checked/><label for="comm_choice1">Planned Route Only</label></td>
						<td><input type="radio" id="comm_choice" name="comm_choice" value="Y" onClick="selectCompleted();"/><label for="comm_choice1">Include Completed Route</label></td>
					</tr>
 -->				
 					<tr id="boundArea">
						<td><input type='radio' name='bound_choice' id='bound_choice' onClick='selectBound(this)' value="O" Checked ><label for='bound_choice1'>Outbound</label></td>
						<td><input type='radio' name='bound_choice' id='bound_choice' onClick='selectBound(this)' value="I" ><label for='bound_choice1'>Inbound</label></td>
					</tr>
					
<!-- 					<tr>
						<td><input type='checkbox' name='dest_nod_check' id='dest_nod_check' value='' onClick='checktnod()'><label for='dest_nod_check1' id="lblDest">Change Inland Dest Node</label></td>
						<td><input type='text' name='dest_nod' value='' disabled style='width:110px; text-transform:uppercase;'><button type='button' class='input_seach_btn' onclick='openNodPop()'></button></td>
					</tr>
 -->					
				</tbody>
			</table>
		</div>
	</div>
</div>
</form>
