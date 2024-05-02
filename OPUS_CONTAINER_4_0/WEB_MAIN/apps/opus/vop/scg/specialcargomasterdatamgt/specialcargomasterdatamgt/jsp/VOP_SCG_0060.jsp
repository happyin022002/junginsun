<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : vop_scg_0060.jsp
 *@FileTitle: Packing Instructions/Provisions (Inquiry)
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/23
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0042Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0042Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						////count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String pop_yn      		= "";
	String imdg_pck_instr_cd  = "";
	String imdg_pck_instr_seq  = "";
	String imdg_pck_instr_cdObj  = "";
	String imdg_pck_instr_seqObj  = "";
	
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoMasterDataMgt.SpecialCargoMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0042Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		pop_yn      		= request.getParameter("pop_mode")==null?"N":"Y";
		imdg_pck_instr_cd  	= request.getParameter("imdg_pck_instr_cd")==null?"":request.getParameter("imdg_pck_instr_cd");	
		imdg_pck_instr_seq  = request.getParameter("imdg_pck_instr_seq")==null?"":request.getParameter("imdg_pck_instr_seq");	
		imdg_pck_instr_cdObj= request.getParameter("imdg_pck_instr_cdObj")==null?"":request.getParameter("imdg_pck_instr_cdObj");
		imdg_pck_instr_seqObj  = request.getParameter("imdg_pck_instr_seqObj")==null?"":request.getParameter("imdg_pck_instr_seqObj");	
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	//팝업호출 및 초기조회조건
	var preConds = {
		pop_yn       		: "<%=StringUtil.xssFilter(pop_yn)%>",
		imdg_pck_instr_cd   : "<%=StringUtil.xssFilter(imdg_pck_instr_cd)%>",
		imdg_pck_instr_seq  : "<%=StringUtil.xssFilter(imdg_pck_instr_seq)%>",
		imdg_pck_instr_cdObj  : "<%=StringUtil.xssFilter(imdg_pck_instr_cdObj)%>",
		imdg_pck_instr_seqObj  : "<%=StringUtil.xssFilter(imdg_pck_instr_seqObj)%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">


<% if (pop_yn=="Y") { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
	<h2 class="page_title"><span>Packing Instructions/Provisions - Inquiry</span></h2>
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_down_excel" id="btn_down_excel">Down Excel</button><!-- 
		 --><button class="btn_normal" name="btn_OK" id="btn_OK" type="button">OK</button><!--
		 --><button type="button" class="btn_normal" name="btn_Close" style="display:yes" id="btn_Close">Close</button>			
	</div>
	<!-- opus_design_btn(E) -->
	</div>
</div>
<%}else{%>

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_down_excel" id="btn_down_excel" type="button">Down Excel</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<% } %>

<% if (pop_yn=="Y") { %><div class="layer_popup_contents"><%}%>
<div class= "wrap_search" style="overflow:hidden;">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry">
		<table style="width:979px">
			<tbody>
				<colgroup>
					<col width="150"/>
					<col width="*"/>
			    </colgroup>
				<tr >
					<th>Packing Instructions/Provisions</th>
					<td><input type="text" name="imdg_pck_instr_cd" style="width:70px;" class="input" value="" maxlength="10" dataformat="engup" id="imdg_pck_instr_cd" /> </td>
	 			</tr>
				
			</tbody>
		</table>
		<table class="height_10"><tr><td colspan="8"></td></tr></table>

	</div>
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" >			
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
</div>
<!-- opus_design_grid(E) -->
<% if (pop_yn=="Y") { %></div><%}%>
</form>
