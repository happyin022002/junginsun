<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0014.jsp
*@FileTitle : OceanLink 정보관리 (본사관리)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-22
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-09-22 kimyoungchul
* 1.0 최초 생성
* 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event.EsdPrd0014Event"%>
<%
	EsdPrd0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	
	String ocnFlg = "";
	try {

		event = (EsdPrd0014Event)request.getAttribute("Event");

		ocnFlg = (String)event.getAttribute("ocnFlg");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_AUTH.jsp"%>
<html>
<head>
<title>OceanLink 정보관리 (본사관리)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		OCN_FLG = "<%=ocnFlg %>";
		loadPage();
	}
</script>
</head>


<body onload="javascript:setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

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
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_multi" id="btn_multi">Multi Creation</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_auto" id="btn_auto">Auto Creation</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_manu" id="btn_manu">Manual Creation</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0" >
						<tr class="h23">
							<td width="40"><img class="nostar">POL</td>
							<td width="130">
								<input class="input1" required caption="POL"  name="pol_port_cd" type="text"   maxlength="5" style="width:58" value=""  dataformat="engup"  tabIndex="1" >
								<img class="cursor" name="btn_pol_port_cd" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="40"><img class="nostar">POD</td>
							<td width="130">
								<input class="input"  name="pod_port_cd" maxlength="5" type="text"    style="width:58" value="" dataformat="engup" tabIndex="2" >
								<img class="cursor" name="btn_pod_port_cd" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="60">T/S Port </td>
							<td width="120"><input name="ts_port_cd" maxlength="5" type="text" style="width:80" dataformat="engup" tabIndex="3"  ></td>
							<td width="45"><img class="nostar">Lane</td>
							<td width="170">
								<input name="tnk_lane_cd" maxlength="3" type="text" style="width:100"  dataformat="engup" tabIndex="4">
								<img class="cursor" name="btn_tnk_lane_cd" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" ></td>
							<td width="50"><img class="nostar">Type</td>
							<td width="120"><input type="hidden" name="ts_type" value="A">
								<select name="select1" style="width:60" onChange="changeSelect('T')"  tabIndex="5" >
								<option value="A" >All</option>
								<option value="D" >Direct</option>
								<option value="T" >T/S</option>
								</select></td>
							<td width=""class="stm">Del Flag <input name="i_del_flag" type="checkbox" class="trans"  value="Y" unchecked  tabIndex="6"> </td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script type="text/javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- Grid : Week (E) -->

					<!-- Button : Sub (S) -->
					<table width="100%" class="button">
				       	<tr>
				       			<td>
								<table class="search" border="0" style="width:600;">
								<tr class="h23">
									<td>
									HJS website shows only Guide and Standard ocean route for vessel schedule check. 
									</td> 
								</tr></table>
							</td>
						       	<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>

									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_pcgeneral" id="btng_pcgeneral">P/C General</td><td class="btn2_right"></td></tr></table></td>
									<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_laneconnection" id="btng_laneconnection">Lane Connection</td><td class="btn2_right"></td></tr></table></td-->
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
</body>
</html>

<script type="text/javascript">
<!--

	  /*
		ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
	  with(document.form)
	  {
		<%
		//if(event != null){
		//	   strFeevalue   =event.getFeeValue();
		%>
		eval("feevalue" ).value = "<%//= strFeevalue	 %>";
		<%// } %>
	   }
	  */
-->
</script>