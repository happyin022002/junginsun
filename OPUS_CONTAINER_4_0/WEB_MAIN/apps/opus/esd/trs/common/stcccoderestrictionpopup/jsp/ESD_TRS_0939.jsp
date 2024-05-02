<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0939.jsp
*@FileTitle  : STCC Code Restriction(공통 Popup)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.event.EsdTrs0939Event"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%
	EsdTrs0939Event event = null;
	Exception serverException = null;
	String strErrMsg = "";
	try {
		event = (EsdTrs0939Event) request.getAttribute("Event");
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
<script type="text/javascript">
	var comboStccRstrFlgCode = '|Y|N';
	var comboStccRstrFlgText = 'All|Y|N';
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<h2 class="page_title"><span>STCC Select</span></h2>
		<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			 --><button type="button" class="btn_normal" name="btn_new"      id="btn_new">New</button><!--
			 --><button type="button" class="btn_normal" name="btn_ok"		 id="btn_ok">OK</button><!--
			 --><button type="button" class="btn_normal" name="btn_close"	 id="btn_close">Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table> 
				<tbody>
					<tr>
						<th width="70px">Code</th>
						<td width="70px"><input type="text" name="stcc_cd" maxlength="7" style="width:80px;" dataformat="engup"></td>
						<th width="100px">Description</th>
						<td width="110px"><input type="text" name="stcc_desc" style="width:150px;"></td>
						<th width="70px">Restricted</th>
						<td width="100px"><script type="text/javascript">ComComboObject('stcc_rstr_flg', 1, 80, 1)</script></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script>ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>
