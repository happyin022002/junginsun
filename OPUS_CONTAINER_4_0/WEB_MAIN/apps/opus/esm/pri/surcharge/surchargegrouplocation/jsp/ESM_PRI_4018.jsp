<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4018.jsp
*@FileTitle  : Surcharge Location Group Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/6/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.event.EsmPri4018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri4018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Surcharge.SurchargeGroupLocation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri4018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

	String preSvcScpCd = null;
    String preChgCd = null;
	String isPopup = null;

	preSvcScpCd = JSPUtil.getNull(request.getParameter("pre_svc_scp_cd"));
	preChgCd = JSPUtil.getNull(request.getParameter("pre_chg_cd"));
	isPopup = JSPUtil.getNull(request.getParameter("is_popup"));
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
<input type="hidden" name="grp_loc_seq" value="" id="grp_loc_seq" />
<input type="hidden" name="max_seq" value="0" id="max_seq" />
<input type="hidden" name="pre_svc_scp_cd" value="<%=preSvcScpCd%>" id="pre_svc_scp_cd" />
<input type="hidden" name="pre_chg_cd" value="<%=preChgCd%>" id="pre_chg_cd" />
<input name="cd" type="hidden" value="" id="cd" />
<input name="etc1" type="hidden" value="" id="etc1" />

<%if (isPopup.equals("Y")) {%>
	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title"><span id="titles">Surcharge Location Group Inquiry</span></h2>
			<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
				--><button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button><!-- 
				--><button type="button" class="btn_accent" name="btn_Close" id="btn_Close">Close</button>
			</div>
		</div>
	</div>
<%} else {%>
	<div class="page_title_area clear">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button>
		</div>
		
		<div class="location">
			<span id="navigation"></span>
		</div>
	</div>
	
<%}%>

<%if (isPopup.equals("Y")) {%>
	<div class="layer_popup_contents" style="overflow:auto; overflow:hidden;">
<%}%>
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="80">
				<col width="300">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
					<th>Service Scope</th>
					<td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 70, 0, 1, 0, false);</script><input name="svc_scp_nm" type="text" style="width:200px;"  value="" class="input2" readonly></td>
					<th>Charge </th>
					<td><script type="text/javascript">ComComboObject('chg_cd', 2, 70, 0, 1, 0, false);</script><input name="chg_nm" type="text" style="width:200px;"  value="" class="input2" readonly></td> 
 				</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet0');</script>
	</div>

	<div class="layout_wrap">
		<div class="layout_vertical_2" style="width: 40%">
			<div class="wrap_result">
				<div class="opus_design_grid" id="mainTable">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
			</div>
		</div>
	   	<div class="layout_vertical_2" style="width: 60%">
			<div class="wrap_result">
				<div class="opus_design_grid" id="mainTable">
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				</div>
			</div>
		</div>
	</div>
</div>
<%if (isPopup.equals("Y")) {%></div><%}%>
</form>