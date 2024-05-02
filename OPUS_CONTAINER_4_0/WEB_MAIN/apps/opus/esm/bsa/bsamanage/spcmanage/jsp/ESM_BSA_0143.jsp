<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0143.jsp
*@FileTitle  : HSlot-info by VVD(VESSELS)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event.EsmBsa0143Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0143Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	//form value in parent window
    String chkPrd  = "";
    String txtYear  = "";
	String txtFmMonth = "";
	String txtToMonth = "";
	String txtFmWeek = "";
	String txtToWeek = "";

	String selTrade = "";
	String selRlane = "";
	String selDir = "";
	String selIOC = "";

	String txtVsl_cd 	= "";
	String txtSkd_voy_no 	= "";
	String txtDir_cd = "";

	String isExcludZero = "";

	//selected row value
	String s_cost_yrmon = "";
	String s_trd_cd = "";
	String s_rlane_cd = "";
	String s_ioc_cd = "";
	String s_vsl_cd = "";
	String s_skd_voy_no = "";
	String s_skd_dir_cd = "";
	String xml = "";

	Logger log = Logger.getLogger("com.clt.apps.BSAManage.SPCManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0143Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		if(event != null) {
			chkPrd = JSPUtil.getNull(request.getParameter("chkPrd"));
			txtYear = JSPUtil.getNull(request.getParameter("txtYear"));
			txtFmMonth = JSPUtil.getNull(request.getParameter("txtFmMonth"));
			txtToMonth = JSPUtil.getNull(request.getParameter("txtToMonth"));
			txtFmWeek = JSPUtil.getNull(request.getParameter("txtFmWeek"));
			txtToWeek = JSPUtil.getNull(request.getParameter("txtToWeek"));

			selTrade = JSPUtil.getNull(request.getParameter("cobTrade"));
			selRlane = JSPUtil.getNull(request.getParameter("cobLane"));
			selDir = JSPUtil.getNull(request.getParameter("cobDir"));
			selIOC = JSPUtil.getNull(request.getParameter("cobIOC"));

			txtVsl_cd = JSPUtil.getNull(request.getParameter("txtVsl_cd"));
			txtSkd_voy_no = JSPUtil.getNull(request.getParameter("txtSkd_voy_no"));
			txtDir_cd = JSPUtil.getNull(request.getParameter("txtDir_cd"));

			isExcludZero = JSPUtil.getNull(request.getParameter("isExcludZero"));


			s_trd_cd = JSPUtil.getNull(request.getParameter("s_trd_cd"));
			s_rlane_cd = JSPUtil.getNull(request.getParameter("s_rlane_cd"));
			s_ioc_cd = JSPUtil.getNull(request.getParameter("s_ioc_cd"));
			s_vsl_cd = JSPUtil.getNull(request.getParameter("s_vsl_cd"));
			s_skd_voy_no = JSPUtil.getNull(request.getParameter("s_skd_voy_no"));
			s_skd_dir_cd = JSPUtil.getNull(request.getParameter("s_skd_dir_cd"));
		}

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
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
<div style="display:none">
<iframe height="0" width="0" name="frmHidden"></iframe>
</div>
<form method="post" name="form" onSubmit="return false;" >
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="iPage" id="iPage" />
	<input type="hidden" name="param1" id="param1" />
	<input type="hidden" name="param2" id="param2" />
	<input type="hidden" name="param3" id="param3" />
	<input type="hidden" name="param4" id="param4" />
	<input type="hidden" name="param5" id="param5" />
	<input type="hidden" name="param6" id="param6" />
	<input type="hidden" name="param7" id="param7" />
	<input type="hidden" name="param8" id="param8" />
	<input type="hidden" name="sXml" value="<%= xml %>" id="sXml" />
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Slot Information By VVD For Vessels</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
<!-- 		<div class="location">
			<span id="navigation"></span>
		</div> -->
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="80" />
					<col width="50" />
					<col width="90" />
					<col width="50" />
					<col width="80" />
					<col width="50" />
					<col width="80" />
					<col width="140" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td colspan="9"><script type="text/javascript">initPeriod2();</script></td>
						<td colspan="1"><label for="isExcludZero"><b>Carriers with BSA only</b></label><input type="checkbox" name="isExcludZero" id="isExcludZero" value="1" class="trans" onKeyUp="moveTab(this, selTrade)" checked></td>
					</tr>
					<tr><td class="line_bluedot" colspan="10"></td></tr>
					<tr>
						<th>Trade</th>
						<td><script type="text/javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
						<th>Lane</th>
						<td><div id="div_rLane"><script type="text/javascript">ComComboObject('cobLane', 1, 80 , 0 )</script></div></td>
						<th>Dir.</th>
						<td><script type="text/javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
						<th>IOC</th>
						<td><script type="text/javascript">ComComboObject('cobIOC', 1, 70 , 0 )</script></td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td>
						<!-- 2014.11.25 김용습 - dataformat="enguponly"와 onkeypress="onlyEng();"이 서로 충돌하여 에러메시지 발생시켜 onkeypress부분 주석 처리, Vessel 코드에 숫자도 들어갈 수 있으니 dataformat도 enguponly에서 engup으로 변경합니다 -->
						<%-- <input type="text" size="4" name="txtVsl_cd" value="<%=s_vsl_cd%>" maxlength="4" dataformat="enguponly" onkeypress="onlyEng();" onkeyup="moveTab(this, txtSkd_voy_no);" style="ime-mode:disabled" id="txtVsl_cd" /> --%>
						<input type="text" size="4" name="txtVsl_cd" value="<%=s_vsl_cd%>" maxlength="4" dataformat="engup" onkeyup="moveTab(this, txtSkd_voy_no);" style="ime-mode:disabled" id="txtVsl_cd" /><!-- 
						 --><input type="text" size="4" name="txtSkd_voy_no" value="<%=s_skd_voy_no%>" dataformat="engdn"  maxlength="4"style="ime-mode:disabled" id="txtSkd_voy_no" /><!-- 
						 --><%-- <input type="text" size="1" name="txtDir_cd" value="<%=s_skd_dir_cd%>" dataformat="enguponly" maxlength="1" onkeypress="onlyEng();" style="ime-mode:disabled" id="txtDir_cd" /> --%>
						 <input type="text" size="1" name="txtDir_cd" value="<%=s_skd_dir_cd%>" dataformat="enguponly" maxlength="1" style="ime-mode:disabled" id="txtDir_cd" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<div class="opus_design_inquiry" style="text-align: Right;">
				<button type="button" class="btn_down" name="bu_zoom_in" id="bu_zoom_in" style="display:inline" alt="Zoom in(+)"></button><!--
				--><button type="button" class="btn_up" name="bu_zoom_out" id="bu_zoom_out" style="display:none" alt="Zoom out(-)"></button>
			</div>
				<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>



<SCRIPT type="text/javascript">
<!--
    /**
     * getting the Infomation, which the user input, from event except ibsheet and showing it on the screen
     */
	with(document.form){
		<% if(event != null) {
			   int tmp = 0;
		       if(chkPrd.equals("M")) {
		    	   tmp = 1;
		       }
		%>
	    chkPrd["<%=tmp%>"].checked  =true;
	    txtYear.value       = "<%= txtYear %>";
	    txtFmMonth.value     = "<%= txtFmMonth %>";
	    txtToMonth.value     = "<%= txtToMonth %>";
	    txtFmWeek.value     = "<%= txtFmWeek %>";
	    txtToWeek.value     = "<%= txtToWeek %>";
	    <%}%>
	}
-->
</SCRIPT> 