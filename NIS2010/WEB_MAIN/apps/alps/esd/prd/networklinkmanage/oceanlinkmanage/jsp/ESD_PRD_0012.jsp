<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0012.jsp
*@FileTitle : OceanLink 정보관리 (본사관리)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-19
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-09-19 kimyoungchul
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
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.event.EsdPrd0012Event"%>
<%
	EsdPrd0012Event  event = null;				    //PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			    //서버에서 발생한 에러
	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";
	String optStr="|000010:N:No Change";
	
	try {
 
	  
		event = (EsdPrd0012Event)request.getAttribute("Event");
 
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
<title>OceanLink 정보관리 (본사관리)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("ts_ind_cd", "N", "CD00128", 0, optStr)%>
	<%= JSPUtil.getIBCodeCombo("day_cd", "01", "CD00131", 0, "")%>	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
 
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

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">

				<table class="search_in" border="0">
				<tr class="h23">
				    <td width="200">Status&nbsp;<select style="width:100;" class="input" name="delt_flg" >
		            	<option value="A"  >All     </option>
       		     		<option value="N" selected>Live</option>
      		   			<option value="Y">Deleted</option>      		   					    
                        </select></td>
             
				    
					<td width="43">Lane</td>
					<td width="230"><input type="text" name="vsl_lane_cd" maxlength="3" value="<%=event.getString("vsl_lane_cd")%>" style="width:100" tabIndex="1"  dataformat="engup">
						<img class="cursor" name="btn_lane_cd" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="30">POL</td>
					<td width="230"><input type="text" name="fm_port_cd" maxlength="5" value="<%=event.getString("fm_port_cd")%>" style="width:100"  tabIndex="2"   dataformat="engup">
						<img class="cursor" name="btn_pol_cd" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="30">POD</td>
					<td width="230"><input type="text" name="to_port_cd" maxlength="5" value="<%=event.getString("to_port_cd")%>" style="width:100"  tabIndex="3"  dataformat="engup">
						<img class="cursor" name="btn_pod_cd" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="65">Direction</td>
					<td>
						<input type="hidden" name="skd_dir_cd" value="<%=event.getString("skd_dir_cd")%>">
						<select name="select1" style="width:100" onChange="changeDirection()" tabIndex="4">
						<option value="0" selected>ALL</option>
						<option value="E">E</option>
						<option value="W">W</option>
						<option value="S">S</option>
						<option value="N">N</option>
						</select> </td>
				</tr>
				</table>

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
		<table class="search" border="0">
		<tr><td class="bg">

			<!-- Grid : Week (S) -->
			<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->

			<table width="100%" id="mainTable" height="300">
			     <tr><td>
			        <script type="text/javascript">ComSheetObject('sheet1');</script>
			     </td></tr>
			</table>
			<!-- Grid : Week (E) -->


			<!-- Button : Sub (S) -->
			<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
                            <td class="stm" width="810" style=" font-weight:bold;" > * You can inquire of manually created and deleted links in case status is 'Deleted'</td>
                          
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_constraint" id="btng_constraint">Constraint</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
			<!-- Button : Sub (E) -->

			</td></tr>
		</table>
    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>
