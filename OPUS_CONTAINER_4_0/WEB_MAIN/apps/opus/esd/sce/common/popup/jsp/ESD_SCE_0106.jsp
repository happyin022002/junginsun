<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0106.jsp
*@FileTitle  : Notified Subscriber - Search Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%

	CommonPopUpManageEvent event = null;
	SignOnUserAccount account = null; 						//Session 정보
	Exception serverException = null;					 	//Setting error at server side
	DBRowSet rowSet = null;							   		//DB ResultSet
	String strErrMsg = "";									//Error message
	int rowCount	 = 0;								  	//DB ResultSet List count.

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (CommonPopUpManageEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Country</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
	<!-- inquiry_area(S) -->
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="65" />
					<col width="90" />
					<col width="95" />
					<col width="180" />
					<col width="50" />
					<col width="89" />
					<col width="90" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Continent</th>
						<td><select name="conti_cd" style="width:65px;">
							<option value="N" selected>All</option>
							<option value="A">ASIA</option>
							<option value="E">EUROPE</option>
							<option value="F">AFRICA</option>
							<option value="M">AMERICA</option>
						</select></td>
						<th>Sub Continent</th>
						<td><select name="sub_conti_cd" style="width:150px;">
							<option value="N" selected>All</option>
							<option value="AE">SOUTH EAST ASIA</option>
							<option value="AF">FAR EAST ASIA</option>
							<option value="AM">MIDDLE EAST ASIA</option>
							<option value="AO">OCEANIA</option>
							<option value="AW">SOUTH WEST ASIA</option>
							<option value="EC">SCANDINAVIA EUROPE</option>
							<option value="EE">EAST EUROPE</option>
							<option value="EN">NORTH EUROPE</option>
							<option value="ES">SOUTH EUROPE</option>
							<option value="FC">CENTRAL AFRICA</option>
							<option value="FE">EAST AFRICA</option>
							<option value="FN">NORTH AFRICA</option>
							<option value="FS">SOUTH AFRICA</option>
							<option value="FW">WEST AFRICA</option>
							<option value="MC">CENTRAL AMERICA</option>
							<option value="MN">NORTH AMERICA</option>
							<option value="MS">SOUTH AMERICA</option>
						</select></td>
						<th>Country</th>
						<td><input name="cnt_cd" id="cnt_cd" type="text" value="" dataformat="engup" style="width:64px; text-transform:uppercase;" onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)"></td>
						<th>Country Name</th>
						<td><input name="cnt_nm" id="cnt_nm" type="text" value="" dataformat="engup" style="width:100px; text-transform:uppercase;"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</form>

<%@include file="../../../common/commonpopup/include/common.jsp"%>