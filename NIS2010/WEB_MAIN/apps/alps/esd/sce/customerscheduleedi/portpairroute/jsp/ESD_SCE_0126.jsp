<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0126.jsp
*@FileTitle : Ocean Route Information
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-09-17
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.event.EsdSce0126Event"%>
<%
	EsdSce0126Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String ocnFlg = "";
	String porCd ="";
	String polCd ="";
	String podCd ="";
	String delCd ="";
	String blockLanes ="";
	String rout_rcv_dt ="";
	String rout_seq ="";
	String n2nd_pol_cd ="";
	String n3rd_pol_cd ="";
	try {

		event = (EsdSce0126Event)request.getAttribute("Event");
		 porCd = JSPUtil.getNull(request.getParameter("por_cd"));
		 polCd = JSPUtil.getNull(request.getParameter("pol_cd"));
		 podCd = JSPUtil.getNull(request.getParameter("pod_cd"));
		 delCd = JSPUtil.getNull(request.getParameter("del_cd"));
		 blockLanes = JSPUtil.getNull(request.getParameter("block_lanes"));
		 rout_rcv_dt = JSPUtil.getNull(request.getParameter("rout_rcv_dt"));
		 rout_seq = JSPUtil.getNull(request.getParameter("rout_seq"));
		 n2nd_pol_cd = JSPUtil.getNull(request.getParameter("n2nd_pol_cd"));
		 n3rd_pol_cd = JSPUtil.getNull(request.getParameter("n3rd_pol_cd"));
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>Ocean Route Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage();
	}
</script>
</head>


<body onload="javascript:setupPage();">
<form method="post" name="form">
<input	type="hidden" name="f_cmd" value="<%=JSPUtil.getNull(request.getParameter("f_cmd")) %>" >
<input type="hidden" name="iPage">
<input type="hidden" name="por_cd" value="<%=porCd %>">
<input type="hidden" name="pol_cd" value="<%=polCd %>">
<input type="hidden" name="pod_cd" value="<%=podCd %>">
<input type="hidden" name="del_cd" value="<%=delCd %>">
<input type="hidden" name="block_lanes" value="<%=blockLanes %>">
<input type="hidden" name="rout_rcv_dt" value="<%=rout_rcv_dt %>">
<input type="hidden" name="rout_seq" value="<%=rout_seq %>">
<input type="hidden" name="n2nd_pol_cd" value="<%=n2nd_pol_cd %>">
<input type="hidden" name="n3rd_pol_cd" value="<%=n3rd_pol_cd %>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Ocean Route Information<!-- span id="title"></span --></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_new">Close</td><td class="btn1_right"></td></tr></table></td>
							<!-- td class="btn1_line"></td>
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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_manu" id="btn_manu">Manual Creation</td><td class="btn1_right"></td></tr></table></td -->

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
							<td width="40"><img class="nostar">POR</td>
							<td width="130" >
								<input class="input2"  value ="<%=porCd %>" caption="POR"  name="por_loc_cd" type="text"   maxlength="5" style="width:58;text-align:center;" value=""  dataformat="engup"  tabIndex="1" >
							</td>
							<td width="40"><img class="nostar">POL</td>
							<td width="130">
								<input class="input2"  value ="<%=polCd %>"caption="POL"  name="pol_port_cd" type="text"   maxlength="5" style="width:58;text-align:center;" value=""  dataformat="engup"  tabIndex="1" align="absmiddle">
							</td>
							<td width="40"><img class="nostar">POD</td>
							<td width="130">
								<input class="input2"  value ="<%=podCd %>" name="pod_port_cd" maxlength="5" type="text"    style="width:58;text-align:center;" value="" dataformat="engup" tabIndex="2" align="absmiddle">
							</td>
							<td width="40"><img class="nostar">DEL</td>
							<td width="130">
								<input class="input2"  value ="<%=delCd %>" name="del_loc_cd" maxlength="5" type="text"    style="width:58;text-align:center;" value="" dataformat="engup" tabIndex="2" align="absmiddle">
							</td>
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
									<!--  td>
									HJS web-site will show the vessel schedule that is marked in Guide, Standard and Add call Flag.
									</td-->
								</tr></table>
							</td>
						       	<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>

									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btn_downexcel" id="btn_downexcel">DownLoad</td><td class="btn2_right"></td></tr></table></td>
									<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_laneconnection" id="btng_laneconnection">Lane Connection</td><td class="btn2_right"></td></tr></table></td->
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