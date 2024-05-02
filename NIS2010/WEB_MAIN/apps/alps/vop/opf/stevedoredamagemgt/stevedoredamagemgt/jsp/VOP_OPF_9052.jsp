<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_9052.jsp
*@FileTitle : Claim Handling Office User Select
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.06
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2011.10.06 김민아
* 1.0 Creation
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StevedoreDamageMgt.StevedoreDamageMgt");
	
	String ofcCd = "";
	String UsrId = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		ofcCd = StringUtil.xssFilter(request.getParameter("ofc_cd"));
		UsrId = StringUtil.xssFilter(request.getParameter("usr_id"));
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Claim Handling Office User Select</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/hanjin/css/OrganTree.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="/hanjin/js/OrganTree.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/HashMap.js"></script>

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

<body class="popup_bg" onLoad="setupPage(); initTree('treeView', 'loadData', false, 'TAOSC'); officeSearch();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- input type="hidden" name="ofc_cd" value="<%=ofcCd %>"-->
<input type="hidden" name="usr_id" value="<%=UsrId %>">

<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Claim Handling Office User Select </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
		<table class="search" id="mainTable" border="0">
			<tr><td class="bg">
 			
			<table class="search"> 
       			<tr class="h23">
        		<td width="210">
        		
				<!--  biz_1  (S) -->
				<table class="search" border="0">
					<tr class="h23">
						<td>Claim Handling Office&nbsp;&nbsp;&nbsp;<input type="text" style="width:60;text-align:center;" class="input2" value="<%=ofcCd %>" name="ofc_cd"></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td></td></tr></table>
        		
					<table id="mainTable">
						<tr>
							<td>
							<div id="treeView" style="overflow: auto; width: 210px; height: 320px; border-width: 1px; border-style: solid; border-color: #7F9DB9;"></div>
							</td>
						</tr>
					</table>
		        <!-- : ( Grid ) (E) -->	
		        </td>
		        <td width="10"></td>
		        <td width="372">
		        
		        				<!--  biz_1  (S) -->
					<table class="search" border="0">
					<tr class="h23">
							<td><select id="search">
								<option value="NAME">Name</option>
								<option value="TEAMNM">Department</option>
								<option value="POS">Title</option>
								<option value="JOB">Job Info</option>
								<option value="CN">User ID</option>
							</select>
							<input type="text" style="width:130;" class="input" value="" name="search_text">&nbsp;</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Search">Search</td>
									<td class="btn1_right"></td>
									</tr>
								</table>
							</td>			
						</tr>
					</table>
					<!--  biz_1   (E) -->
		
					<table class="line_bluedot"><tr><td></td></tr></table>
			
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>				
				<!-- : ( Grid ) (E) -->	
		       
		        </td>
			
				<td width="35" align="center">
					<img src="img/btns_add.gif" border="0" name="btns_add" class="cursor" >
					<br><br><img src="img/btns_del.gif" border="0" name="btns_del" class="cursor">
				</td>
			
			    <td width="372">
			    
				<!--  biz_1  (S) -->
				<table class="search" border="0">
					<tr class="h23">
						<td></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td></td></tr></table>
				
			        <!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
					<!-- : ( Grid ) (E) -->	
			    <!-- : ( Button : Grid ) (E) -->	
				
				</td></tr>
			</table>
<!-- : ( Search Options ) (E) -->

			<table class="height_5"><tr><td></td></tr></table>
		</td></tr>
	</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:4;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	   		<!-- <div style="display:none">
	   		<!-- Grid  (S) 
			<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
			</table>
			<!-- Grid (E) 
			</div> -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>
