<%/*=========================================================
 *Copyright(c) 2017 SMLines
 *@FileName : ESM_BKG_N011.jsp
 *@FileTitle : Canada Export: CRN Delete
 *Open Issues :
 *Change history :
 *@LastVersion : 1.0
 *
 * 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkgN011Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkgN011Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String cvyRefNo = "";
	String strUsr_id = "";
	String strUsr_nm = "";
	boolean isCA_Usr = true;
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CndManifestListDownload");

	try
	{
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkgN011Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null)
		{
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		cvyRefNo = JSPUtil.getParameter(request, "cvy_ref_no");
	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Canada Export: CRN( Conveyance Ref. No.) Delete</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="download_flag">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->

<table width="900" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Canada Export: CRN Delete</td></tr>
			</table>
	<!--Page Title, Historical (E)-->

			<!--biz page (S)-->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0" style="width: 280;">
							<tr class="h23">
							
					<td width="30">CRN</td>

								<td width="150">
									<input type="text" style="width:90; ime-mode:disabled" name="cvy_ref_no" value="<%= cvyRefNo %>" class="input1" maxlength="20"  required caption="CRN" >	
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

<!-- Grid BG Box  (S) -->
	     	<table width="100%" class="search" id="mainTable">
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
			<!-- Grid BG Box  (S) -->
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;,padding-left:5;"> 
       				<tr>
       					<td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
		    					<tr>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
												<td class="btn1_right"></td>
																					
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_Delete" id="btn_Delete">Delete</td>
												<td class="btn1_right"></td>
												
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
												<td class="btn1_right"></td>
												
								
											</tr>
										</table>
				
									</td>
								
								</tr>
							</table>
							</td>
						</tr>
					</table>
		
				</td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>

			
</form>
</body>
</html>