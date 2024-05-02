<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4025.jsp
*@FileTitle  : Charge Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.charge.event.EsmPri4025Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr" %>

<%
    EsmPri4025Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error happened at server side
    String strErrMsg = "";                      //Error Message
    int rowCount     = 0;                       //DB ResultSet List Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] repChgCd 		= null;
	String[] frtChgTpCd		= null;
	String[] chgRevTpCd		= null;
	String[] chgAplyTpCd		= null;
	
	Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.Charge");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri4025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding the code extract data from server when initialization loading..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		repChgCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("repChgCd"), true);
		frtChgTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("frtChgTpCd"),false,"|","\t","getCode","getName");
		chgRevTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("chgRevTpCd"),false,"|","\t","getCode","getName");
		chgAplyTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("chgAplyTpCd"),false,"|","\t","getCode","getName");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	<%=ConstantMgr.getCompanyCodeToJS()%>
	var repChgComboValue = " |<%=repChgCd[0]%>";  
    var repChgComboText = " |<%=repChgCd[1]%>";
    var frtChgTpComboValue = " |<%=frtChgTpCd[0]%>";  
    var frtChgTpComboText = " |<%=frtChgTpCd[1]%>";
    var chgRevTpComboValue = " |<%=chgRevTpCd[0]%>";  
    var chgRevTpComboText = " |<%=chgRevTpCd[1]%>";
    var chgAplyTpComboValue = " |<%=chgAplyTpCd[0]%>";  
    var chgAplyTpComboText = " |<%=chgAplyTpCd[1]%>";
    
    var repChgCdValue = " |<%=repChgCd[0]%>";  
    var repChgCdText = " |<%=repChgCd[1]%>";
    var frtChgTpCdValue = " |<%=frtChgTpCd[0]%>";  
    var frtChgTpCdText = " |<%=frtChgTpCd[1]%>";
    var chgRevTpCdValue = " |<%=chgRevTpCd[0]%>";  
    var chgRevTpCdText = " |<%=chgRevTpCd[1]%>";
    var chgAplyTpCdValue = " |<%=chgAplyTpCd[0]%>";  
    var chgAplyTpCdText = " |<%=chgAplyTpCd[1]%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="cd">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <tbody>
				<tr>
					<th>Charge Code</th>
					<td><input type="text" name="chg_cd" maxlength="3" style="width:70px; ime-mode:disabled;" dataformat="engup"class="input"></td>
					<th>Rep. Charge Code</th>
					<td colspan="3"><script type="text/javascript">ComComboObject('rep_chg_cd', 2, 70, 0, 0, 0, false);</script></td>
				</tr>
				<tr>
					<th width="60">Freight/Charge Type</th>
					<td width="120" style="padding-left:2"><script type="text/javascript">ComComboObject('frt_chg_tp_cd', 1, 180, 1, 0, 0, false);</script></td>
					<th width="120">Revenue Class</th>
					<td width="120"><script type="text/javascript">ComComboObject('chg_rev_tp_cd', 1, 190, 1, 0, 0, false);</script></td>
					<th width="120">Charge Character</th>
					<td><script type="text/javascript">ComComboObject('chg_aply_tp_cd', 1, 180, 1, 0, 0, false);</script></td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet0');</script>
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- opus_design_grid(E) -->
</form>