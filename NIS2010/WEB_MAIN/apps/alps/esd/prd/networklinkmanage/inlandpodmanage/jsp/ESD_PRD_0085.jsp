 <%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_085.jsp
*@FileTitle : POD Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-24
*@LastModifier : Noh Seung Bae
*@LastVersion : 1.0
* 2009-08-24 Noh Seung Bae
* 1.0 최초 생성
* 2011.07.20 변종건 [] Inland Route POD Management 기능변경 및 보완 요청
* 2011.11.07 이수진 [CHM-201113877-01] Constraint 기능상에 Update 이력 관리 기능 추가 및 관련 Alert Message 기능 추가
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.event.EsdPrd0085Event"%>
<%
	EsdPrd0085Event  event = null;				//PDTO(Data Transfer Object including Parameters)

	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	
	String nodeCd = "";

	SignOnUserAccount account = null;
	
	try {
	   //	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdPrd0085Event)request.getAttribute("Event");
		nodeCd =JSPUtil.getNull((String)event.getString("node_code"));
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_AUTH.jsp"%>
<html>
<head>
<title>POD Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		nodeCd = "<%=nodeCd%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		//InitTab();
		loadPage();
	}
</script>

<script language="javascript">
var CRUD = "<%=JSPUtil.getParameter(request, "CRUD", retCRUD)%>";
var OFC_CD = "<%=account.getOfc_cd()%>";
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">


<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_uploadexcel" id="btn_uploadexcel">Upload Excel</td><td class="btn1_right"></td></tr></table></td>

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
	
		
		
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
						<td width="30">Status</td>
						<td width="100"><select name="del_flag" >
											<option value="A">All</option>
											<option value="N" selected>Live</option>
											<option value="Y">Deleted</option>
										</select></td>
						<td width="170">
							<table class="sm" style="height:20; width:120; background-color: #E9E9E9;">
								<tr>
									<td width="" align="center">
										<input type="radio" name="pctl_io" class="trans" value="O" >O/B&nbsp;&nbsp;
										<input type="radio" name="pctl_io" class="trans" value="I" checked="checked" >I/B
									</td>
								</tr>
							</table>
						</td>
						<td width="120"><span id="lane">First/Last Lane</span></td>
						<td width="190"><input   style="width:100"  name="lane_code"  type="text" maxlength="3" value="" style="text-transform:uppercase" dataformat="engup">&nbsp;<img alt="" class="cursor" src="img/alps/button/btns_search.gif" name="p_lane_code" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="30"><span id="del">POR/DEL</span></td>
						<td width="190"><input   style="width:100"  name="del_code" type="text" maxlength="5" value="" style="text-transform:uppercase" dataformat="engup">&nbsp;<img alt="" class="cursor" src="img/alps/button/btns_search.gif" name="p_del_code" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="30"><span id="pod">POL/POD</span></td>
						<td width="190"><input   style="width:100"  name="pod_code" type="text" maxlength="5" value="" style="text-transform:uppercase" dataformat="engup" >&nbsp;<img alt="" class="cursor" src="img/alps/button/btns_search.gif" name="p_pod_code"width="19" height="20" border="0" align="absmiddle"></td>
				</table></td>
			</tr>
		</table>
					
			
		
		
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr><td class="bg">

					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script language="javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- Grid : Week (E) -->
					<!-- Button : Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowcopy" id="btng_rowcopy">Row Copy</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- Button : Sub (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->


    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>



<!-- 개발자 작업  끝 -->
</body>
</html>
