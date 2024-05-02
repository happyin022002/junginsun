<!--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_6102.jsp
*@FileTitle  : Revenue Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/12
=========================================================*/
-->

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event.EsmPri6101Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri6101Event  event 		= null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 			= "";			//에러메세지 
	int rowCount	 			= 0;			//DB ResultSet 리스트의 건수
	
	String successFlag 			= "";
	String codeList  			= "";
	String pageRows  			= "100";
	
	String strUsr_id 			= "";
	String strUsr_nm 			= "";
	String strUsr_ofc 			= "";
	String strUsrSrepCd 		= "";
	
	String[] svcScpCds = null;
    String[] cargoTypes = null;
    String[] customerTypes = null;

	
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.pri.prisimulation.prisimulation");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();
	
	
		event = (EsmPri6101Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String pctlNo = JSPUtil.getNull(request.getParameter("pctl_no"));
	String cntrSzCd = JSPUtil.getNull(request.getParameter("cntr_sz_cd"));
	String cmdtCd = JSPUtil.getNull(request.getParameter("cmdt_cd"));
	String cmdtSeq = JSPUtil.getNull(request.getParameter("cmdt_seq"));
	String autoRatFlg = JSPUtil.getNull(request.getParameter("auto_rat_flg"));
	
%>

<script language="javascript">

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        loadPage();
    }

</script>

<form id="form" name="form">
<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input type="hidden" id="pctl_no" name="pctl_no" value="<%=pctlNo%>">
<input type="hidden" id="cntr_sz_cd" name="cntr_sz_cd" value="<%=cntrSzCd%>">
<input type="hidden" id="cmdt_cd" name="cmdt_cd" value="<%=cmdtCd%>">
<input type="hidden" id="cmdt_seq" name="cmdt_seq" value="<%=cmdtSeq%>">
<input type="hidden" id="auto_rat_flg" name="auto_rat_flg" value="<%=autoRatFlg%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Revenue Detail</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	
	</div>
	<!-- page_title_area(E) -->
</div>


<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid">
			 <script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
    </div> 
    <!-- opus_design_grid(E) -->
</div>

</form>


