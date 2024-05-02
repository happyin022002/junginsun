<%/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VOP_OPF_0074.jsp
*@FileTitle : VNOR Mail Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.21
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2015.04.21 이병훈
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0074Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0074Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String ofcCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		ofcCd = account.getOfc_cd();
	   
		event = (VopOpf0074Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>VNOR Mail Setup</title>
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

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;VNOR Mail Setup</td></tr>
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
						<td>Office&nbsp;&nbsp;&nbsp;<input type="text" style="width:60;text-align:center;" class="input2" value="<%=ofcCd %>" name="ofc_cd"></td>
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
					<td class="btn1" name="btn_save">Save</td>
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
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>