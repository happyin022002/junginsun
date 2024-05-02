<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0155.jsp
*@FileTitle : RMK PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.29 송호진
* 1.0 Creation
* History
* 2008-05-16 Ari
* 1.0 최초 생성 CSR No.N200804140004, N200804146015, N200804146018
* 2009-10-08 송호진 ALPS 전환
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.event.EsmMas0155Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//	EsmMas0155Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MultiDimensionRPT.PreCMSimulation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


//		event = (EsmMas0155Event)request.getAttribute(Event);
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RMK PopUp</title>
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

<!-- 개발자 작업	-->
<iframe height="0" width="0" name="frmHidden"></iframe>

<!-- body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();" onresize="changeSheetRows();" -->
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();" >
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param1">

<!--  부모창으로부터 전송된 폼값 -->
<input type="hidden" name="f_ofc_cd" value="<%=JSPUtil.getNull(request.getParameter("f_ofc_cd"))%>">
<input type="hidden" name="f_pctl_no" value="<%=JSPUtil.getNull(request.getParameter("f_pctl_no"))%>">
<input type="hidden" name="f_cob_profit_vw" value="<%=JSPUtil.getNull(request.getParameter("f_cob_profit_vw"))%>">
<input type="hidden" name="f_cob_profit_lv" value="<%=JSPUtil.getNull(request.getParameter("f_cob_profit_lv"))%>">
<input type="hidden" name="f_void_qty" value="<%=request.getParameter("f_void_qty")== null?"0":request.getParameter("f_void_qty")%>">
  <!-- OUTER - POPUP (S)tart -->
  <table width="100%" class="popup" cellpadding="10" border="0">
    <tr>
      <td class="top"></td>
    </tr>
    <tr>
      <td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Pre CM/OP Simulation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


        <!-- : ( Search Options ) (S) -->
        <table class="search">
          <tr>
            <td class="bg">
              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">Cost Detail Inquiry</td>
                  <td style="width:40;">POR</td>
                  <td><input name="por_cd" type="text" class="input2" style="width:50;ime-mode:disabled;" value="<%=JSPUtil.getNull(request.getParameter("sheet1_por"))%>" ReadOnly></td>
                  <td style="width:40;">POL</td>
                  <td><input name="pol_cd" type="text" class="input2" style="width:50;ime-mode:disabled;" value="<%=JSPUtil.getNull(request.getParameter("sheet1_pol"))%>" ReadOnly></td>
                  <td style="width:40;">POD</td>
                  <td><input name="pod_cd" type="text" class="input2" style="width:50;ime-mode:disabled;" value="<%=JSPUtil.getNull(request.getParameter("sheet1_pod"))%>" ReadOnly></td>
                  <td style="width:40;">DEL</td>
                  <td><input name="del_cd" type="text" class="input2" style="width:50;ime-mode:disabled;" value="<%=JSPUtil.getNull(request.getParameter("sheet1_del"))%>" ReadOnly></td>
 				  <td align="right" valign="bottom">
					<div id="div_zoom_in1" style="display:inline">
					<img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
					</div>
					<div id="div_zoom_out1" style="display:none">
					<img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
					</div>
				 </td>
				 <tr>
				 <td colspan="11">

				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( Grid ) (E) -->

				</td>
                </tr>
                <tr>
                  <td colspan="3" class="height_5"></td>
                </tr>
              </table>
              <!-- : ( Grid ) (S) -->

              <!-- : ( Grid ) (E) -->
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

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
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