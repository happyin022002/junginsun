
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0472.jsp
	 *@FileTitle : ESM_BKG-0472
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.03
	 *@LastModifier : 김승민
	 *@LastVersion : 1.0
	 * 2009.06.03 김승민
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0472Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0472Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String jpMsgTpCd= "";
	String rcvDt= "";
	String rcvSeq= "";
	String bkgNo="";
	String vslCd = "";
	String skdVoyNo = "";
	String skdDirCd = "";
	String polCd = "";
	
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		jpMsgTpCd= request.getParameter("jpMsgTpCd")==null?"":request.getParameter("jpMsgTpCd");
		rcvDt= request.getParameter("rcvDt")==null?"":request.getParameter("rcvDt");
		rcvSeq= request.getParameter("rcvSeq")==null?"":request.getParameter("rcvSeq");
		bkgNo= request.getParameter("bkgNo")==null?"":request.getParameter("bkgNo");
		vslCd = request.getParameter("vslCd")==null?"":request.getParameter("vslCd");
		skdVoyNo = request.getParameter("skdVoyNo")==null?"":request.getParameter("skdVoyNo");
		skdDirCd = request.getParameter("skdDirCd")==null?"":request.getParameter("skdDirCd");
		polCd = request.getParameter("polCd")==null?"":request.getParameter("polCd");
		
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0472Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG-0472</title>
<meta http-eqEsmv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="jp_msg_tp_cd" value="<%=jpMsgTpCd%>">
<input type="hidden" name="rcv_dt" value="<%=rcvDt%>">
<input type="hidden" name="rcv_seq" value="<%=rcvSeq%>">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="vsl_cd" value="<%=vslCd%>">
<input type="hidden" name="skd_voy_no" value="<%=skdVoyNo%>">
<input type="hidden" name="skd_dir_cd" value="<%=skdDirCd%>">
<input type="hidden" name="pol_cd" value="<%=polCd%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Receive History from SEA-NACCS_View Receive File</span></td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
		    <!--Grid (S)-->
				<table width="100%"  id="mainTable"> 
				
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>		     
				<!--Grid (E)-->
					
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>			
</body>
</html>