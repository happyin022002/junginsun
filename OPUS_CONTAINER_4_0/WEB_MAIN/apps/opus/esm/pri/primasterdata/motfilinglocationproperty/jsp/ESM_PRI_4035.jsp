<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4035.jsp
*@FileTitle  : MOT Base Port Table Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.event.EsmPri4035Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri4035Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] svcScopeList = null;
	String[] orgDestList = null;	
	String[] motFileLaneCdList = null;

	Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.MotFilingLocationProperty");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri4035Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		svcScopeList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScopeList"), true);
		orgDestList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("orgDestList"), false ,"|","\t","getCode","getName");		
		motFileLaneCdList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("motFileLaneCdList"), true ,"|","\t","getCode","getName");	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
    var svcScopeCdValue = " |<%=svcScopeList[0]%>";
    var svcScopeCdText = " |<%=svcScopeList[1]%>";
    var orgDestCdValue = " |<%=orgDestList[0]%>";
    var orgDestCdText = " |<%=orgDestList[1]%>";
    var motFileLaneCdValue = " |<%=motFileLaneCdList[0]%>";
    var motFileLaneCdText = " |<%=motFileLaneCdList[1]%>";    

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->	
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent"  type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button class="btn_normal"  type="button" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn (E) -->
	
 <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->
    
<div class="wrap_result">
	<div class="opus_design_grid"  id="mainTable">
		<div class="opus_design_btn">
		     	<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button> 
			 	<button type="button" class="btn_normal"  name="btn_del" id="btn_del">Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet0');</script>
	</div>
</div>	
</form>