<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1095.jsp
*@FileTitle  : ANCS - Lane Add
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg1095Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1095Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String inListType		= "";
	String inVvdCd			= "";
	String inPolCd			= "";
	String inPodCd			= "";
	String allPol			= "";
	String bkgCgoTpCd			= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		inListType = request.getParameter("inListType")==null?"":request.getParameter("inListType");
		allPol = request.getParameter("allPol")==null?"":request.getParameter("allPol");
		inVvdCd = request.getParameter("inVvdCd")==null?"":request.getParameter("inVvdCd");
		inPolCd = request.getParameter("inPolCd")==null?"":request.getParameter("inPolCd");
		inPodCd = request.getParameter("inPodCd")==null?"":request.getParameter("inPodCd");
		bkgCgoTpCd = request.getParameter("inBkgCgoTpCd")==null?"":request.getParameter("inBkgCgoTpCd");

		event = (EsmBkg1095Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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
<input type="hidden" name="in_vvd_cd" value="<%=StringUtil.xssFilter(inVvdCd) %>" id="in_vvd_cd" />
<input type="hidden" name="in_pol_cd" value="<%=StringUtil.xssFilter(inPolCd) %>" id="in_pol_cd" />
<input type="hidden" name="in_pod_cd" value="<%=StringUtil.xssFilter(inPodCd) %>" id="in_pod_cd" />
<input type="hidden" name="allPol" value="<%=StringUtil.xssFilter(allPol) %>" id="allPol" />
<input type="hidden" name="bkg_cgo_tp_cd" value="<%=StringUtil.xssFilter(bkgCgoTpCd) %>" id="bkg_cgo_tp_cd" />
<input type="hidden" name="port_cd" value="" id="port_cd" />
<input type="hidden" name="in_list_type" value="<%=StringUtil.xssFilter(inListType) %>" id="in_list_type" />
<input type="hidden" name="in_rcv_id" id="in_rcv_id" />
<input type="hidden" name="in_snd_id" id="in_snd_id" />
<input type="hidden" name="in_yd_cd" id="in_yd_cd" />
<input type="hidden" name="in_dest_svr_cd" id="in_dest_svr_cd" />
<input type="hidden" name="in_area_id" id="in_area_id" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>ANCS - Lane Add</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Save" 	id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
	<!-- opus_design_grid(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd" 	id="btn_RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button><!--
			--></div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>