<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1008.jsp
*@FileTitle  : ESM_BKG-1008
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/23
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1008Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg1008Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // error from server
	String strErrMsg = ""; // error message
	int rowCount = 0; // count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");

	try
	{
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1008Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null)
		{
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		if ("US".equals(account.getCnt_cd()) || "CA".equals(account.getCnt_cd()))
		{
			bBtn_Disabled = false;
		}
	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
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


<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> <input type="hidden" name="ch_usr_id">
<input type="hidden" name="SEN"> <input type="hidden" name="KKL">
<input type="hidden" name="COS"> <input type="hidden" name="YML">

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
<div class="opus_design_btn">
    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
     --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
     --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class="wrap_search">
<div class="opus_design_inquiry">		
	<table class="search" border="0" style="width:979px;"> 
		<tr class="h23">
		<td width="50px">User ID</td>
		<td width="180px" ><input type="text" name="usr_id" style="width:150px" value="" class="input" ></td>
		<td width="65px">User Name</td>
		<td width="180px" ><input type="text" name="usr_nm" style="width:150px" value="" class="input"></td>
		<td width="45px">Office</td>
		<td width="*" ><input type="text" name="ofc_cd" style="width:60px" value="" class="input" maxlength="5" dataformat="enguponly" ></td>
		</tr>
	</table>
</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
<div class="opus_design_grid">	
	<div class="opus_design_btn">
	   <button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row&nbsp;Add</button>
	   <button type="button" class="btn_normal" name="btn_rowdelete" id="btn_rowdelete">Row Delete</button>
	</div>
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- 시트영역 -->

</form>
