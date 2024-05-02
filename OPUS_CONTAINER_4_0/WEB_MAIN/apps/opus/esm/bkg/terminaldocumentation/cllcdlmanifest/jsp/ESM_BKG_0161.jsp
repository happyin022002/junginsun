<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0161.jsp
*@FileTitle  : Sort Option 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
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
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0161Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EsmBkg0161Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id = "";
    String strUsr_nm = "";
    String codeGubun = "";
	String isPop     = "";
	String pageTitle = "";
    Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        codeGubun = StringUtil.xssFilter(request.getParameter("codeGubun"))==null?"":StringUtil.xssFilter(request.getParameter("codeGubun"));
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		isPop     = StringUtil.xssFilter(JSPUtil.getParameter(request, "isPop"));
		pageTitle = isPop.equalsIgnoreCase("Y") ? " Sort Option" : "List Sorting Option";
        event = (EsmBkg0161Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (null != serverException) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
     // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (1 <= errMessage.length) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden"  name="codeGubun" id="codeGubun" value="<%=codeGubun%>">
<input type="hidden" name="isPop" id="isPop" value="<%=isPop%>">
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span><%=pageTitle%></span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			--><button type="button" class="btn_accent" name="btn_ok" id="btn_ok">Ok</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close"  	id="btn_close">Close</button><!-- 
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table id="mainTable">
					<tbody>
						<colgroup>
						<col width="50px"></col>
						<col width="12px"></col>
						<col width="*"></col>
						</colgroup>
					    <tr class="h23">
		                <th>1st Priority</th>
		                <td><script type="text/javascript">ComComboObject('select1', 2, 280, 1, 0, 0);</script></td>
		                <td></td>
		              </tr>
		              <tr class="h23">
		                <th>2nd Priority</th>
		                <td><script type="text/javascript">ComComboObject('select2', 2, 280, 1, 0, 0);</script></td>
		                <td></td>
		              </tr>
		              <tr class="h23">
		                <th>3rd Priority</th>
		                <td><script type="text/javascript">ComComboObject('select3', 2, 280, 1, 0, 0);</script></td>
		                <td></td>
		              </tr>
		              <tr class="h23">
		                <th>4th Priority</th>
		                <td><script type="text/javascript">ComComboObject('select4', 2, 280, 1, 0, 0);</script></td>
		                <td></td>
		              </tr>
		              <tr class="h23">
		                <th>5th Priority</th>
		                <td><script type="text/javascript">ComComboObject('select5', 2, 280, 1, 0, 0);</script></td>
		                <td></td>
		              </tr>
					</tbody>
				</table>
			</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none" id="mainTable" name="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->
</form>