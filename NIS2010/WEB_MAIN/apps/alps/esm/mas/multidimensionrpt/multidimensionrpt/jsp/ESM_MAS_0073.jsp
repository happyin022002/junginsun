<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_MAS_0073.jsp
*@FileTitle : Adjuested cost detail(MT/ABC)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.20
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.10.12 이석준
* 1.0 Creation
*=========================================================
* History
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
* 2013.12.05 최성민 [CHM-201327977] [MAS] P&L by Lane -> Adjusted Cost Detail 상 ABC 관련 항목 삭제
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String f_chkprd = "";
	String f_year = "";
	String f_fm_mon = "";
	String f_to_mon = "";
	String f_sls_mon = "";
	String f_fm_wk = "";
	String f_to_wk = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.ESM_MAS_0073");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		f_chkprd     = request.getParameter("f_chkprd");
		f_year = request.getParameter("f_year");	
		f_fm_mon   = request.getParameter("f_fm_mon");	
		f_to_mon    = request.getParameter("f_to_mon");	
		f_sls_mon = request.getParameter("f_sls_mon");
		f_fm_wk = request.getParameter("f_fm_wk");	
		f_to_wk = request.getParameter("f_to_wk");	
		
//		f_chkprd     = "M";
//		f_year = "2012";
//		f_fm_mon   = "09";
//		f_to_mon    = "10";	
//		f_sls_mon = "11";	
//		f_fm_wk = "35";	
//		f_to_wk = "37";
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Adjuested cost detail(MT/ABC)</title>
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
<form method="post" name="form"  onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_chkprd"   value="<%=f_chkprd %>">
<input type="hidden" name="f_year"     value="<%=f_year %>">
<input type="hidden" name="f_fm_mon"   value="<%=f_fm_mon %>">
<input type="hidden" name="f_to_mon"   value="<%=f_to_mon %>">
<input type="hidden" name="f_sls_mon"  value="<%=f_sls_mon %>">
<input type="hidden" name="f_fm_wk"    value="<%=f_fm_wk %>">
<input type="hidden" name="f_to_wk"    value="<%=f_to_wk %>">

<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">



      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0">
      <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; MT Adjusted Cost Detail</td></tr>        
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

      <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_plan_exp" name="btn_plan_exp">Planned Expense</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- Repeat Pattern -->
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button_L (E) -->


      <!-- TABLE '#D' : ( Search Options ) (S) -->

      <table class="height_10"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Search Options ) (S) -->      
      <table class="search" border="0">
        <tr>
          <td class="bg_b1">
          <table class="height_10"><tr><td></td></tr></table>
            <!-- : ( POR ) (S) -->
            
            <table width="100%" id="mainTable">
              <tr>
                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- : ( POR ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>