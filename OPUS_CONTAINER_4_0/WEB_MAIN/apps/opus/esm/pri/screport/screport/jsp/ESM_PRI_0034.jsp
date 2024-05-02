<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0988.jsp
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2016.06.07 강동윤
* 1.0 Creation
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
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0034Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String strIsSC		    = "";
	String strNoteGb		= "";
	String strPropNo		= "";
	String strAmdtSeq		= "";
	String strSvcScpCd      = "";
	String strGenSpclRtTpCd = "";
	String strCmdtHdrSeq    = "";
	String strRoutSeq 		= "";

	
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.pri.screport.screport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		strIsSC 		  	= StringUtil.xssFilter(request.getParameter("is_sc"));
		strNoteGb 		  	= StringUtil.xssFilter(request.getParameter("note_gubun"));
		strPropNo 		  	= StringUtil.xssFilter(request.getParameter("prop_no"));
		strAmdtSeq			= StringUtil.xssFilter(request.getParameter("amdt_seq"));
		strSvcScpCd			= StringUtil.xssFilter(request.getParameter("svc_scp_cd"));
		strGenSpclRtTpCd	= StringUtil.xssFilter(request.getParameter("gen_spcl_rt_tp_cd"));
		strCmdtHdrSeq		= StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq"));
		strRoutSeq			= StringUtil.xssFilter(request.getParameter("rout_seq"));
		
		log.debug("--------IS SC     ------>"+strIsSC);
		log.debug("--------NOTE GUBUN------>"+strNoteGb);
		log.debug("--------PROP NO   ------>"+strPropNo);
		log.debug("--------AMDT SEQ  ------>"+strAmdtSeq);
		log.debug("--------SVC SCP CD------>"+strSvcScpCd);
		log.debug("--------GEN SPC TP------>"+strGenSpclRtTpCd);
		log.debug("--------CMDT H SEQ------>"+strCmdtHdrSeq);
		log.debug("--------ROUT SEQ  ------>"+strRoutSeq);


		event = (EsmPri0034Event)request.getAttribute("Event");
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

<!-- <body  onLoad="setupPage();"> -->
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="is_sc" value="<%= strIsSC %>">
<input type="hidden" name="note_gubun" value="<%= strNoteGb %>">
<input type="hidden" name="prop_no" value="<%= strPropNo %>">
<input type="hidden" name="amdt_seq" value="<%= strAmdtSeq %>">
<input type="hidden" name="svc_scp_cd" value="<%= strSvcScpCd %>">
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%= strGenSpclRtTpCd %>">
<input type="hidden" name="cmdt_hdr_seq" value="<%= strCmdtHdrSeq %>">
<input type="hidden" name="rout_seq" value="<%= strRoutSeq %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Note Information</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button><!--
		-->
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<!-- OUTER - POPUP (S)tart -->
<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<tr class="h23">
					<td align="center"><textarea class="textarea_img1" name="note_ctnt" id="note_ctnt" rows="15" style="resize:none;width:100%;height:100%" class="input1" wrap=hard></textarea></td> 
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div id="hiddenSheetLayer" style="display: none">
<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- 개발자 작업  끝 -->
</form>
