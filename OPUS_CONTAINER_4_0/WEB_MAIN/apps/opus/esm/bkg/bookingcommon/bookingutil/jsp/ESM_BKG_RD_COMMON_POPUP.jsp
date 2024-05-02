<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName  : ESM_BKG_RD_COMMON_POPUP.jsp
*@FileTitle : ESM_BKG_RD_COMMON_POPUP
*@author    : CLT
*@version   : 1.0
*@since     : 2016/07/01
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.ReportDesigner.CommonPopup");
	String bkg_mrd_param[] = null;
	String bkg_mrdPath[] = null;
	int bkg_mrdCount = 0;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		bkg_mrd_param = request.getParameterValues("bkg_mrd_param");
		bkg_mrdPath = request.getParameterValues("bkg_mrdPath");
		
		bkg_mrdCount = bkg_mrd_param.length;
		
	} catch (Exception e) {
		out.println(e.toString());
	}


%>
<script type="text/javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		ComShowMessage(errMessage);
	}
	rdOpen();
}
</script>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<form name="form"">
<input type="hidden" id="com_mrdDisableToolbar" value="<%=request.getParameter("com_mrdDisableToolbar")%>" />
<input type="hidden" id="com_isBatch" value="<%=request.getParameter("com_isBatch")%>" />
<input type="hidden" id="bkg_mrdCount" value="<%=bkg_mrdCount %>" />
<%
for(int i=0; i<bkg_mrd_param.length; i++){ 
	out.println("<input type=\"hidden\" name=\"bkg_mrdArguments\" value=\""+bkg_mrd_param[i]+"\" >");
}
for(int i=0; i<bkg_mrdPath.length; i++){ 
	out.println("<input type=\"hidden\" name=\"bkg_mrdPath\" value=\""+bkg_mrdPath[i]+"\" >");
}
%>

	<div class="layer_popup_title">	
		<div class="page_title_area clear">
		   	<h2 class="page_title"><span><%=request.getParameter("com_mrdBodyTitle")!=null?request.getParameter("com_mrdBodyTitle"):"" %></span></h2>
		    <div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_Close" onclick="ComClosePopup()"	id="btn_Close">Close</button>
		    </div>
		</div>
	</div>


	<div class="layer_popup_contents">
		<div class="wrap_result">
			<div class="opus_design_RD"> 
				<script type="text/javascript">rdViewerObject();</script>
		    </div>
		</div>
	</div>
</form>