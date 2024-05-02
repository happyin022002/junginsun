<%/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ees_cim_1055.jsp
*@FileTitle : Location M/B by COA BKG(로케이션 팝업)
*Open Issues :	
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.17 박명신
* 1.0 Creation	
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1062Event"%>
<%@ page import="org.apache.log4j.Logger" %>	
	
<%
		EesCim1062Event  event = null;					//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//서버에서 발생한 에러
		String strErrMsg = "";						//에러메세지
		int rowCount	 = 0;						//DB ResultSet 리스트의 건수

		String successFlag = "";
		String codeList  = "";
		String pageRows  = "100";

		String strUsr_id		= "";
		String strUsr_nm		= "";
		
		Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
		
		try {		
		   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			strUsr_id =	account.getUsr_id();
			strUsr_nm = account.getUsr_nm();

		
			event = (EesCim1062Event)request.getAttribute("Event");
			serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
			if (serverException != null) {	
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}	
			
		} catch(Exception e) {	
			out.println(e.toString());	
		}
	%>
<html>
<head>		
<title>Location</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
<script language="javascript">
	function setupPage(){		
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {	
			ComShowMessage(errMessage);
		} // end if
		loadPage();		
	}	
</script>
</head>
	
<body  onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">		
<input type="hidden" name="pagerows">	
<input type="hidden" name="rqst_usr_id" value="<%=strUsr_id%>">
	
<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">  <!-- CSR NO. N200802010006 -->
    <tr><td class="top"></td></tr>
    <tr><td valign="top">	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Location</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
        <!-- : ( Search Options ) (S) -->
        <table class="search" align="center">
          <tr>
            <td class="bg">
              <!-- : ( Level Group ) (E) -->
              <table width="100%" height="200" id="mainTable"> <!-- CSR NO. N200802010006 -->
                <tr>
                  <td>			
                    <script language="javascript">ComSheetObject1('sheet1');</script>
                  </td>	
                </tr>
              </table>
              <!-- : ( Level Group ) (E) -->
            </td>
          </tr>
        </table>
        <!-- : ( Search Options ) (E) -->
      </td>
    </tr>
  </table>
  <!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Ok" id="btn_Ok">Ok</td><td class="btn1_right"></td></tr></table></td>
				
				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
			</tr>
		</table>

	</td></tr>
</table>

</form>
</body>
</html>
