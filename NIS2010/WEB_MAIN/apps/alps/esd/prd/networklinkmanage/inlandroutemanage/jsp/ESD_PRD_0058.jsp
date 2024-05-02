<%-- 
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0058.jsp
*@FileTitle : Priority 변경 팝업  
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-22
*@LastModifier : jungsunyong
*@LastVersion : 1.0
* 2006-09-22 jungsunyong
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
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event.EsdPrd0058Event"%>
<%
	EsdPrd0058Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	

	try {
		event = (EsdPrd0058Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Priority Change </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
	
		loadPage();
	}
</script>
</head>


<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="openSheetRow">  <!-- 부모창의  Row -->
<input type="hidden" name="routSeq">  <!-- 부모창의  rout_seq -->
<input type="hidden" name="r_inbound">  <!-- In/Out/Tmnl  구분 -->
<input type="hidden" name="rBtnIrgCd"> <!-- In/Out/Tmnl  구분, rInbound 와  같음  -->

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Priority</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button">

		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">

				<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width=""></td>
						    <td>
						        <!--IB (S)-->
						        <table  class="search">
						            <tr class="h23">
						                <td width="150">From (Location, TMNL)</td>
						                <td width="170"><input name="i_org_cd" type="text" required caption="ORG LOC" maxlength="7" tabIndex="1" style="width:70" disabled=false;></td>
						                <td width="135">To (Location, TMNL)</td>
						                <td width=""><input name="i_dest_cd" type="text" required caption="DEST LOC" maxlength="7" tabIndex="2" style="width:70" disabled=false;></td>

						            </tr>
						        </table>
						        <!--IB (E)-->

						    </td>

							<td width="">
						       <table border="0" style="height:20; background-color: #E9E9E9;">
						            <tr>
						                <td class="stm"><input type="hidden" name="r_btn_nod_ty_cd" value="Y"><input type="radio" name='nod_tp_cd1' value='Y' class="trans" disabled=false;>Yard&nbsp;<input type="radio" name='nod_tp_cd1' value='Z' class="trans" disabled=false;>Zone</td>
						                <td></td>
						            </tr>
						        </table>
						    </td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>
		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script language="javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- : ( Grid ) (E) -->

					</td>
				</tr>
			</table></td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->

<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--

	  /*
		ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
	  */
	  with(document.form)
	  {
		<%
		if(event != null){

			   String org_cd      =JSPUtil.getNull(event.getInlandRouteUSVO().getIOrgCd());
			   String dest_cd     =JSPUtil.getNull(event.getInlandRouteUSVO().getIDestCd());
			   String rInbound    =JSPUtil.getNull(event.getInlandRouteUSVO().getRInbound());
			   String rBtnIrgCd   =JSPUtil.getNull(event.getInlandRouteUSVO().getRBtnIrgCd());
			   String rBtnNodTyCd   =JSPUtil.getNull(event.getInlandRouteUSVO().getRBtnNodTyCd());
			   String openSheetRow  =JSPUtil.getNull(event.getInlandRouteUSVO().getISelectRow());
			   String routSeq  =JSPUtil.getNull(event.getInlandRouteUSVO().getRoutSeq());
			 	
			   //org_cd  = org_cd.substring(0,5);
		       dest_cd = dest_cd.substring(0,5);
		      
			   
		%>
		eval("i_org_cd" ).value  = "<%= org_cd	 %>";
		eval("i_dest_cd" ).value = "<%= dest_cd	 %>";
		eval("r_inbound" ).value  = "<%= rInbound	 %>";
		eval("rBtnIrgCd" ).value = "<%= rBtnIrgCd	 %>";
		eval("r_btn_nod_ty_cd" ).value  = "<%= rBtnNodTyCd	 %>";
		eval("openSheetRow" ).value = "<%= openSheetRow	 %>";
		eval("routSeq" ).value = "<%= routSeq	 %>";
		<%
		if(rBtnNodTyCd.equals("Y")) {
		%>
			eval("nod_tp_cd1[0]" ).checked = true;
		<%
		} else if(rBtnNodTyCd.equals("Z")) {
		%>
			eval("nod_tp_cd1[1]" ).checked = true;
		<%
		}
		%>
		<% } %>
	   }
-->
</SCRIPT>