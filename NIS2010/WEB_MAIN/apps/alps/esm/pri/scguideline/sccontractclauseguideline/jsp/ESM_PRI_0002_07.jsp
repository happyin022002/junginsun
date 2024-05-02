<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0002_07.jsp
*@FileTitle : SC Guideline Contract Clause Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.01 최성민
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.sccontractclauseguideline.event.EsmPri000207Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000207Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] noteClssCd = null;			//NOTE CLASSIFICATION CODE
	String[] chgCd = null;				//SURCHARGE
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCContractClauseGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri000207Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		noteClssCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("NOTE_CLSS_CD"), false);
		chgCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHG_CD"), false);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SC Guideline Contract Clause</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var noteClssCdComboValue = " |<%=noteClssCd[0]%>";
    var noteClssCdComboText = " |<%=noteClssCd[1]%>";
    
	var chgCdComboValue = " |<%=chgCd[0]%>";
    var chgCdComboText = " |<%=chgCd[1]%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="svc_scp_cd" value="">
<input type="hidden" name="gline_seq" value="">
<input type="hidden" name="ctrt_cluz_seq" value="">
<input name="cd" type="hidden" value="">
<!-- 개발자 작업	-->


<!-- (TAB) Contract Clause (S) -->
<!-- <div id="tabLayer" style="display:none"> -->
	
		<table class="search"> 
       		<tr><td class="bg">				
			<table class="height_2"><tr><td></td></tr></table>
				
				<table class="search">
					<tr>
						<td width="20%" valign="top">
						<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!--grid(E)-->						
						</td>
						<td width="49" align="center"><img src="img/btn_add.gif" width="26" height="26" alt="" border="0" align="absmiddle">&nbsp;</td>	
						<td width="" valign="top">
						
						<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>&nbsp;
								</td>
							</tr>
						</table>
						<!--grid(E)-->			
						</td>
					</tr>
				
				</table>
				
				
			</td></tr>
		</table>
	
<!--  </div> -->
<!-- (TAB) Contract Clause (E) -->	


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>