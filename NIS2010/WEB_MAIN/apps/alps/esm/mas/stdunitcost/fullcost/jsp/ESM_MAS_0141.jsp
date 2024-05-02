<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0141.jsp
*@FileTitle : Link별 표준단가 조회 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2007-06-07
*@LastModifier : IM OKYOUNG
*@LastVersion : 1.0
* 2007-02-26 IM OKYOUNG
* 1.0 최초 생성
* =========================================================
* History
* 2008.05.02 임옥영 R200804296327 CSS파일 경로 변경
* 2009.09.04 장영석 New frame work 적용
* 2011.12.30 최윤성 [CHM-201115391-01] [MAS] Pre CM/OP Simulation화면 U.I변경건 Inquiry by BKG / Product Catalog Inquiry 동일 적용요청 - Remark 추가
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>	
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지

	//부모창에서 받은 변수
	String f_pctl_no= JSPUtil.getNullNoTrim(request.getParameter("f_pctl_no"));
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitcost.Fullcost");


	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		  log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>Link별 표준단가 조회 팝업</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setRetrieveAction();
	}
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- 부모창의 폼값 -->
<input type="hidden" name="f_pctl_no" value="<%=f_pctl_no%>">


<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr>
      <td valign="top">

				<!-- : ( Title ) (S) -->
				<table width="100%" border="0">
				<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Route Cost</td></tr>
				</table>
				<!-- : ( Title ) (E) -->


              <!-- TABLE '#D' : ( Search Options ) (S) -->
              <table class="search">
                <tr><td class="bg">

                    <!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                      <tr>
                        <td>
                          <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                      </tr>
                    </table>
                    <!-- : ( POR ) (E) -->
                    
                    <table class="search" border="0">
                    	<tr><td><img src="/hanjin/img/ico_star.gif" border="0"> <strong>Remark</strong></td></tr>
						<tr><td class="sm">
							<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="4"><font color="#0000FF"><b>If costs are marked in Blue, please contact each RHQ(NOG, UOG, AOG, WOG) and ask for more accurate costs. </b></font><br>
						</td></tr>
					</table>
                  </td>
                </tr>
              </table>
              <!-- TABLE '#D' : ( Search Options ) (E) -->


	</td></tr>
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

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_DownExcel" id="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
			</table>
		</td></tr>
		</table>
		
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>