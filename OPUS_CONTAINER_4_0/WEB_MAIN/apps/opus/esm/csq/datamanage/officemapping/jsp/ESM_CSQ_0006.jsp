<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0006.jsp
*@FileTitle  : Lane-Office Relation Setting
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.datamanage.officemapping.event.EsmCsq0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0006Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//ì„œë²„ì—�ì„œ ë°œìƒ�í•œ ì—�ëŸ¬
	String strErrMsg = "";						//ì—�ëŸ¬ë©”ì„¸ì§€
	int rowCount	 = 0;						//DB ResultSet ë¦¬ìŠ¤íŠ¸ì�˜ ê±´ìˆ˜

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.datamanage.officemapping");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmCsq0006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// ì´ˆê¸°í™”ë©´ ë¡œë”©ì‹œ ì„œë²„ë¡œë¶€í„° ê°€ì ¸ì˜¨ ë�°ì�´í„° ì¶”ì¶œí•˜ëŠ” ë¡œì§�ì¶”ê°€ ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
	// pop_mode
	String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";	
	String p_bse_yr      = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd  = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String p_ofc_vw_cd   = JSPUtil.getParameter(request, "f_ofc_vw_cd", "");
	String p_sub_trd_cd  = JSPUtil.getParameter(request, "f_sub_trd_cd", "");
	String p_dir_cd  	 = JSPUtil.getParameter(request, "f_dir_cd", "");
	String p_rlane_cd    = JSPUtil.getParameter(request, "f_rlane_cd", "");
%>

<title>Lane-Office Relation Setting</title>

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

<% if ("Y".equals(popMode)) { %>
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span id="title"></span></h2>
		<!-- page_title(E) -->

<% } else { %>
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button">
	<span id="title"></span></button></h2>
	<!-- page_title(E) -->
<% } %>

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="strOfc_cd" value="<%= strOfc_cd%>" id="strOfc_cd" />
<input type="hidden" name="popMode" value="<%= popMode%>" id="popMode" />
<input type="hidden" name="p_bse_yr" value="<%= p_bse_yr%>" id="p_bse_yr" />
<input type="hidden" name="p_bse_qtr_cd" value="<%= p_bse_qtr_cd%>" id="p_bse_qtr_cd" />
<input type="hidden" name="p_ofc_vw_cd" value="<%= p_ofc_vw_cd%>" id="p_ofc_vw_cd" />
<input type="hidden" name="p_sub_trd_cd" value="<%= p_sub_trd_cd%>" id="p_sub_trd_cd" />
<input type="hidden" name="p_dir_cd" value="<%= p_dir_cd%>" id="p_dir_cd" />
<input type="hidden" name="p_rlane_cd" value="<%= p_rlane_cd%>" id="p_rlane_cd" />
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button> 
		<button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button>
		<button class="btn_normal" name="btn_Create" id="btn_Create" type="button">Create</button>
		<button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button>
<% if (popMode.equals("Y")) { %>
		<button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
<% } %>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
</div>

<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!-- ì¡°íšŒì˜�ì—­ [Table](S) (ê¸°ì¡´ As-is êµ¬ì¡°ì—�ì„œ ë³€ê²½ë�˜ëŠ” ì‚¬í•­ ì—†ì�Œ) -->
        <table>
            <colgroup>
                <col width="110">
                <col width="50">
                <col width="150">
                <col width="50">
                <col width="130">
                <col width="50">
                <col width="150">
                <col width="50">
                <col width="150">
                <col width="30">
                <col width="120">
                <col width="30">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                   <td class='sm pad_left_8'><input type="radio" name="f_bse_tp_cd" id ="f_bse_tp_cd_y" class="trans" value="Y"><label for ="f_bse_tp_cd_y"><strong>Yearly</strong></label></td>
                   <th>Year</th>
                   <td><script type="text/javascript">ComComboObject('f_bse_yr', 1, 100, 1, 1)</script></td>
                   <th><div id="div_qtr">Quarter</div></th>
                   <td><script type="text/javascript">ComComboObject('f_bse_qtr_cd', 1, 100, 1, 1)</script></td>
                   <td colspan="2"><div id="div_period"></div></td>
                   <th>Office View</th>
                   <td><script type="text/javascript">ComComboObject('f_ofc_vw_cd', 1, 100, 1, 1)</script></td>
                </tr>
                <tr>
                   <td class='sm pad_left_8'><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd_q" class="trans" value="Q" checked><label for="f_bse_tp_cd_q"><strong>Quarterly</strong></label></td>
                   <th>Trade</th>
                   <td><script type="text/javascript">ComComboObject('f_trd_cd', 1, 100, 1)</script></td>
                   <th>Sub Trade</th>
                   <td><script type="text/javascript">ComComboObject('f_sub_trd_cd', 1, 100, 1)</script></td>
                   <th>R/Lane</th>
                   <td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 100, 1)</script></td>
                   <th>Lane Bound</th>
                   <td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 100, 1)</script></td>
                   <th>RHQ</th>
                   <td><script type="text/javascript">ComComboObject('f_rhq_cd', 1, 100, 1)</script><td>
                   <th>Office</th>  
                   <td><script type="text/javascript">ComComboObject('f_rgn_ofc_cd', 1, 100, 1)</script></td> 
                </tr>
            </tbody>
        </table>
        <!-- ì¡°íšŒì˜�ì—­ [Table](E) (ê¸°ì¡´ As-is êµ¬ì¡°ì—�ì„œ ë³€ê²½ë�˜ëŠ” ì‚¬í•­ ì—†ì�Œ) -->
    </div>
    <!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result"> 
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">
    	<div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_NewLaneAdd" id="btn_NewLaneAdd">New Lane Add</button>
      	</div>
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
</form>
