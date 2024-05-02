<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0045_Dtl.jsp
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.20 장석현
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	VopOpf0045Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";

	String nItem			= "";
	int sheetNo = 0;
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.RegionDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (VopOpf0045Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//TDR조회시 파라메터 값들.......
		nItem	= StringUtil.xssFilter(request.getParameter("nItem")) == null ? "1" : StringUtil.xssFilter(request.getParameter("nItem"));
		sheetNo = Integer.parseInt(nItem) + 1;
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>RDR Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
	function setupPage(sheetNm){
		var parentTabIdx = <%=nItem%>;
		var parentTabName = parent.marrTabTitle[<%=nItem%>];
		var objSheet = document.all.item(sheetNm);		

		ComConfigSheet(objSheet);
		parent.initSheet(objSheet, <%=sheetNo%>);
		//objSheet.SelectHighLight = false;
		//objSheet.SelectFontBold = true;
		ComEndConfigSheet(objSheet);
		
		if(parent.bRetrive){
			parent.doActionIBSheet(objSheet, parent.document.form, IBSEARCH, "search<%= sheetNo < 10 ? "0" + sheetNo : Integer.toString(sheetNo) %>");
		}
	}
       function setSheetObject(sheet_obj){
          sheetObjects[sheetCnt++] = sheet_obj;
       }
</script>
</head>

<body  onLoad="setupPage('t<%=sheetNo%>sheet1');">
	<table class="search"> 
    <tr><td class="bg">
		
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t<%=sheetNo%>sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			
			
			</td></tr>
		</table>

<!-- 개발자 작업  끝 -->

</body>
</html>
