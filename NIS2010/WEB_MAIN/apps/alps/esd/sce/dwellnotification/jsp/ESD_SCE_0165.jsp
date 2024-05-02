<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0154.jsp
*@FileTitle : SCE
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.07.07 채창호
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0165Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce0165Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String row              = "";
	String cust_cd			= "";
	String subsc_eml		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.DwellNotification.DwellNotification");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce0165Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	row =JSPUtil.getParameter(request, "row".trim(), "");
	cust_cd = JSPUtil.getParameter(request, "cust_cd".trim(), "");
	subsc_eml = JSPUtil.getParameter(request, "subsc_eml".trim(), "");
%>
<html>
<head>
<title>E-mail List</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="totalCount">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top"><!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
         <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;One Time Send History</td>
        </tr>
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
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
			</table>
	    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg" >
          <table><tr><td width=25% align=left>
            <table class="search" border="0" style="width:550;" >
              <tr class="h23">
              <td width="120">Customer Code :</td>
                <td width="*"><input type="text" style="width:80;" class="input" name="cust_cd"  dataformat="uppernum" maxlength="8" minlength="8" value="<%=cust_cd%>" ></td>
              </tr>
            </table>
            </td>
            <td width="90%"></td>
            <td  align=right>


          <table class="search" border="0" style="width:300;">
              <tr class="h23">
  			  <td width="60">Email :</td>
              <td width="*"><input type="text" style="width:200;" class="input" name="subsc_eml" value="<%=subsc_eml%>" maxlength="100"></td>

              </tr>
            </table>
            </td></tr></table>
            <table class="line_bluedot">
              <tr>
                <td colspan="8"></td>
              </tr>
            </table>
            <!-- : ( Grid ) (S) -->
            <table width="100%"  id="mainTable">
             <tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
            </table>
            <!--  Button_Sub (S)--> 
            </td> <!-- Button_Sub (E) -->
        </tr>
      </table>
      <table class="height_5">
        <tr>
          <td></td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) --></td>
  </tr>
</table>
<!-- : ( Button : pop ) (S) -->

</form>
<!-- 개발자 작업  끝 -->
</body>
</html>