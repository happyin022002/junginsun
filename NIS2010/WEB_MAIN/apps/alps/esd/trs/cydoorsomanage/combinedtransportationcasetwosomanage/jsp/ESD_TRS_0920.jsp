<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0920.jsp
*@FileTitle : CY & Door S/O Creation Matchmaking Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-29
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-09-29 z_kim_sang_geun
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
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String optionStr = "000020:ALL:ALL";

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "01", "CD00283", 0, optionStr)%>
	<%=JSPUtil.getIBCodeCombo("dor_svc_tp_cd", "01", "CD00284", 0, "")%>
</script>
<html>
<head>
<title>CY & Door S/O Creation Matchmaking Popup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();" onunload="javascript:doClosePopup();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
<input type="hidden" name="ui_conti_cd">
<input type="hidden" name="cydoor_div">
<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Matchmaking</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
     	<table class="search"> 
       	<tr><td class="bg_a">

				<!-- : ( Node / Link ) (S) -->
                    <table class="search"  id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
				<!-- : ( Node / Link ) (E) -->
				
				<table class="search"><tr><td class="height_10"></td></tr></table>
				
				<!-- : ( Node / Link ) (S) -->
                    <table class="search"  id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                    </table>
				<!-- : ( Node / Link ) (E) -->
						
			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) --> 	

			
	
</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table class="sbutton">
		<tr><td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_apply.gif" width="66" height="20" border="0" name="btn_apply"></td>
			<td class="p_bt"><img class="cursor" src="/hanjin/img/button/btn_close.gif" width="66" height="20" border="0" name="btn_close"></td></tr>
		</table>
	
	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>