<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7028.jsp
 *@FileTitle : DG Cargo Surcharge for Add-on tariff
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.19
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2012.07.19 서미진
 * 1.0 Creation
 * 2013.02.26 [CHM-201323107] 전윤주 화면 이름 변경
 * 2014.12.09 [CHM-201433491] ADD ON TARIFF / DG 요율 관련 (CUR_CD 추가)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri7028Event"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
    EsmPri7028Event event = null; 
	Exception serverException = null;
	String strErrMsg = ""; 
	int rowCount = 0;

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.pri.tariff");
	
	String[] termCd = null;
	String svcScpCd = "";	
	String fdrTrfNo = "";	
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri7028Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		termCd 	    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RCV_DE_TERM_CD"), false);
		svcScpCd 	= request.getParameter("svcScpCd");
		fdrTrfNo    = request.getParameter("fdrTrfNo");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DG Cargo Surcharge for Add-on tariff</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	var termCdValue = " |<%=termCd[0]%>";
	var termCdText = " |<%=termCd[1]%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>" required="required">
<input type="hidden" name="fdr_trf_no" value="<%=fdrTrfNo%>" required="required">
<input type="hidden" name="org_dest_tp_cd" value="<%= JSPUtil.getParameter(request, "org_dest_tp_cd") %>" required="required">
<input type="hidden" name="rhq_cd" value="<%=JSPUtil.getParameter(request, "rhq_cd")%>" required="required">
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;DG Cargo Surcharge for Add-on tariff</td>
			</tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->	
		<table class="search" border="0" style="width:100%;">        	
			<tr class="h23">  
				<!-- <td width="" >* USD</td>	 -->						
				<td width="">
					<!-- <input type="text" name="curr_cd" style="border:0;font:bold" > -->
				</td>					
			</tr>                                                                                                                                                                                                                                                                                                                                                                                          
		</table>
		
		<table class="search"> 
       	<tr><td class="bg">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			</td></tr>
		</table>
	<!--  biz_1   (E) -->
	</td></tr>
</table>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    	<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Close">Close</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>