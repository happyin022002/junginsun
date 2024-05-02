<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESM_SPC_0117.jsp
*@FileTitle : Import Mastertable
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05 
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.02.05 Arie
* 1.0 Creation
Cr반영용
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0117Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.coa.common.Utils"%>

<%

	EsmSpc0117Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BasicDataManage.ConstraintMaster");
	//report관련 소스추가
	String col_desc = Utils.iif(request.getParameter("col_desc")==null, "", request.getParameter("col_desc"));
    String col_nm   = Utils.iif(request.getParameter("col_nm")==null, "", request.getParameter("col_nm"));
    String selGroup = "";
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0117Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Import Control Option Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		//report upload
		var col_desc = document.form.f_header.value;
        var col_nm = document.form.f_headernm.value; 
		//loadPage();
		//report upload
        loadPage(col_desc, col_nm);
	}
</script>
</head>

<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="dirty_flag" id="dirty_flag">

<!-- report upload -->
<input type="hidden" name="f_header" id="f_header"  value="<%=col_desc%>">
<input type="hidden" name="f_headernm" id="f_headernm" value="<%=col_nm%>">
<input type="hidden" name="f_savename" id="f_savename">
<input type="hidden" name="pgm" id="pgm">
<input type="hidden" name="rpt_fom_nm" id="rpt_fom_nm">

<input type="hidden" name="pagerows" id="pagerows">


<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td height="10"></tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Import Mastertable</td></tr>
		</table>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!-- 그리드 상단에 저장된 컬럼 목록 및 컬럼 조정 버튼 출력시키는곳 -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr><td class="btn1_bg">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table   class="search" border="0">
								<tr class="h23">
								    <td width="20"></td>
					                <td width="175">Select Customized RPT Form</td>
					                <td width="120">
					                	<script language="javascript">ComComboObject('f_selgroup', 1, 120, 0)</script>
					                </td>
					                <td width="80"></td>
					                <td width="150" class="gray">
					                  <img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
					                  <a href="javascript:openRPTFormPopUp();" class="purple">Set Customized RPT Form</a>
					                </td>
					                <td></td>
					              </tr>
							</table>
						</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
						<!--
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down&nbsp;Excel</td><td class="btn1_right"></td></tr></table></td>
						  -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					</tr></table>

			</td></tr>
		</table>

    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->

		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- <table class="height_5"><tr><td></td></tr></table> -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
		            
	    			<!-- : ( Button : Sub ) (S) -->
	    			<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
	
									<!-- Repeat Pattern -->
									<td>* Limited up to 1000 rows (Total).</td>
									<td><input type="text" name="f_add_cnt" value="1"  style="width:40; text-align:center;">&nbsp;<td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
								</tr>
							</table>
						</td></tr>
				</table>
    			<!-- : ( Button : Sub ) (E) -->
    			
			</td></tr>
		</table>

<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
<!-- Outer Table (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>