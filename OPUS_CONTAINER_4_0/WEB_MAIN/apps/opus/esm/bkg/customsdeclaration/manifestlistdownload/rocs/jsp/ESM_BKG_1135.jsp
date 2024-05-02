<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1135.jsp
*@FileTitle  : ESM_BKG_1135
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/22
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1135Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1135Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

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
	Logger log = Logger.getLogger("com.clt.opus.CustomsDeclaration.ManifestListDownload");

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

		event = (EsmBkg1135Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="in_vvd_cd" value="<%=StringUtil.xssFilter(inVvdCd) %>">
<input type="hidden" name="in_pol_cd" value="<%=StringUtil.xssFilter(inPolCd) %>">
<input type="hidden" name="in_pod_cd" value="<%=StringUtil.xssFilter(inPodCd) %>">
<input type="hidden" name="allPol" value="<%=StringUtil.xssFilter(allPol) %>">
<input type="hidden" name="bkg_cgo_tp_cd" value="<%=StringUtil.xssFilter(bkgCgoTpCd) %>">
<input type="hidden" name="port_cd" value="">
<input type="hidden" name="in_list_type" value="<%=StringUtil.xssFilter(inListType) %>">
<input type="hidden" name="in_rcv_id">
<input type="hidden" name="in_snd_id">
<input type="hidden" name="in_yd_cd">
<input type="hidden" name="in_dest_svr_cd">
<input type="hidden" name="in_area_id">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>ROCS - Lane Add</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--  -->
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--  -->
					<button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>
