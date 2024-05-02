<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_5020.jsp
*@FileTitle : ESM_BKG_5020
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.07 경종윤
* 1.0 Creation
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0296Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	//EsmBkg5020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	String chk1 = "";
	String chk2 = "";
	String chk3 = "";
	String vslNm = "";

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

/*
		event = (EsmBkg5020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
*/
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		// 부모창에서 넘오온 파라메터 셋팅
		vvdCd = JSPUtil.getParameter(request, "vvd_cd");
		polCd = JSPUtil.getParameter(request, "pol_cd");
		podCd = JSPUtil.getParameter(request, "pod_cd");
		chk1 = StringUtil.xssFilter(request.getParameter("chk1")) == null ? "false" : StringUtil.xssFilter(request.getParameter("chk1"));
		chk2 = StringUtil.xssFilter(request.getParameter("chk2")) == null ? "false" : StringUtil.xssFilter(request.getParameter("chk2"));
		chk3 = StringUtil.xssFilter(request.getParameter("chk3")) == null ? "false" : StringUtil.xssFilter(request.getParameter("chk3"));
		vslNm = JSPUtil.getParameter(request, "vsl_nm");


	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form"  id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vvd_cd" value="<%=vvdCd%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<input type="hidden" name="pod_cd" value="<%=podCd%>">
<input type="hidden" name="chk1" value="<%=chk1%>">
<input type="hidden" name="chk2" value="<%=chk2%>">
<input type="hidden" name="chk3" value="<%=chk3%>">
<input type="hidden" name="vsl_nm" value="<%=vslNm%>">
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Manifest Generation_IGM Form III Preview</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<table>
				<tbody>
					<tr>
						<td>
							<div class="sm" style="width:130px">
								<table>
									<tr>
										<td>
											<input type="radio" name="entry_type" id="entry_type_lc" value="LC" checked><label for="entry_type_lc">LC</label><!--
										 --><input type="radio" name="entry_type" id="entry_type_tc" value="TC"><label for="entry_type_tc">TC</label><!--
										 --><input type="radio" name="entry_type" id="entry_type_ti" value="TI"><label for="entry_type_ti">TI</label>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_RD">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">rdViewerObject();</script>
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->

	</div>
</div>
<!-- popup_contens_area(E) -->
</form>