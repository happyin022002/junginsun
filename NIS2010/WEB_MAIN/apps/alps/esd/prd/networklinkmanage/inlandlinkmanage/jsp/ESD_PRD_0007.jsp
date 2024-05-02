<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0007.jsp
*@FileTitle : Link  List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-25
*@LastModifier : jungsunyong
*@LastVersion : 1.0
* 2006-09-25 jungsunyong
* 1.0 최초 생성
=========================================================*/ --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.event.EsdPrd0007Event"%>

<%

	EsdPrd0007Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	
	String optStr="|000010: : ";

	try {
		
	 
	   
		

		event = (EsdPrd0007Event)request.getAttribute("Event");

		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);


		

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Link  List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("rail_crr_tp_cd", "01", "CD00287", 0, optStr)%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="i_page">
<input type="hidden" name="row">
<input type="hidden" name="col">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Link  List Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">

				<table class="search" border="0" style="width:100%;">
						<tr class="h23">
							<td width="8%"><img class="nostar">Origin</td>
							<td width="25%"><input class="input1" name="i_org_cd" maxlength="7" required caption="Origin" type="text" style="width:110" value="" dataformat="engup"> </td>
							<td width="13%"><img class="nostar">Destination</td>
							<td width="25%"><input class="input1" name="i_dest_cd" maxlength="7" required caption="Destination" type="text" style="width:110" value="" dataformat="engup"> <!-- onChange="validateLocation(this.value,2);"  --> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_dest_loc"></td>
							<td width="31%"></td>
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
					<!-- : ( Button : Sub ) (S) -->
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
	    				<!-- : ( Button : Sub ) (E) -->
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
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>

<script type="text/javascript">
<!--

	  /*
		ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
	  */
	  with(document.form)
	  {
		<%
		if(event != null){
			   String org_cd   = event.getSearchInlandLinkManageListVO().getIOrgCd();
			   String dest_cd   = event.getSearchInlandLinkManageListVO().getIDestCd();
			   String row   =  event.getSearchInlandLinkManageListVO().getRow();
			   String col   = event.getSearchInlandLinkManageListVO().getCol();
		%>
		eval("i_org_cd" ).value = "<%= org_cd	 %>";
		eval("i_dest_cd" ).value = "<%= dest_cd	 %>";
		eval("row" ).value = "<%= row	 %>";
		eval("col" ).value = "<%= col	 %>";
		<% } %>
	   }
-->
</script>