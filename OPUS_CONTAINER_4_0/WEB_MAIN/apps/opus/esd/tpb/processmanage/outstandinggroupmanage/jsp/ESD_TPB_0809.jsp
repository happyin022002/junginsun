<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0809.jsp
*@FileTitle  : 3rd Party Target Selection 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.event.EsdTpb0809Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0809Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.OutstandingGroupmanage");

	String currentDay = DateTime.getFormatString("yyyy-MM-dd");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0809Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
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
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="s_vndr_cnt_cd" id="s_vndr_cnt_cd" />
<input type="hidden" name="s_vndr_seq" id="s_vndr_seq" />
<input type="hidden" name="s_cust_cnt_cd" id="s_cust_cnt_cd" />
<input type="hidden" name="s_cust_seq" id="s_cust_seq" />
<input type="hidden" name="s_n3pty_ofc_cd" id="s_n3pty_ofc_cd" />
<input type="hidden" name="s_src_vndr_cnt_cd" id="s_src_vndr_cnt_cd" />
<input type="hidden" name="s_src_vndr_seq" id="s_src_vndr_seq" />
<input type="hidden" name="sdate" value="<%=DateTime.addDays(currentDay, -7, "yyyy-MM-dd")%>" id="sdate" />
<input type="hidden" name="edate" value="<%=currentDay%>" id="edate" />
<div id="wait_img" style="position:absolute; visibility:hidden;">
	<img src="/opuscntr/img/opus/processing.gif" width="343px" height="121px" border="0">
</div>

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>3rd Party Target Selection</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_ok" id="btn_ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<tr>
						<td><%=JSPUtil.getCodeCombo("s_vndr_cust_div_cd", "", "style='width:100px' required caption='3rd Party'", "CD00583", 0, "001: :&lt;&lt;Select&gt;&gt;|")%><!-- 
							 --><input type="text" style="width:100px;" name="s_trd_party_val" maxlength="8" !readonly id="s_trd_party_val" onblur="s_trd_party_val_OnBlur()"/><!-- 
							 --><button type="button" name="btn_3rdParty" id="btn_3rdParty" class="input_seach_btn"></button>
						</td>
					</tr>
					<tr>					
						<td><input type="text" style="width:300px; display:none" name="s_trd_party_nm" readonly></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>