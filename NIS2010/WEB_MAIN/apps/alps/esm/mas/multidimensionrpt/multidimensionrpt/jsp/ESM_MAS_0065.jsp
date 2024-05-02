<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0065.jsp
*@FileTitle : EQ 회송기여도 RPT 조회1-1
*Open Issues :
*Change history :CSR No. N200801154876 주간 대상항차 기준 변경 관련 요청
                  (PFMC by Office 화면) 전윤주
                :CSR No. R200804296329 내부 경로 변경
*@LastModifyDate : 2008-02-28
*                : 2008-05-06
*@LastModifier : Chilseo_Park
               : Yunju jeon
*@LastVersion : 1.0
* 2006-12-01 Chilseo_Park
* 2008-05-06 전윤주
* 1.0 최초 생성
=========================================================*/
* History
* 2009.02.04 김태윤 N200901210016 - MAS_조직개편 관련 기능 수정
* 2009.04.03 김종열 N200903170124 - MAS_Multi-dimension report 조회권한 변경. 디자인 수정
* 2009.09.16 김기식 Alps전환작업
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg= "";
    String userId   = "";
    String ofc_cd   = "";
    String ofc_lvl  = "";
    
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
        	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        	
	        userId = account.getUsr_id();
	        ofc_cd = account.getOfc_cd(); //getUserOffice2();
	        ofc_lvl = account.getUsr_auth_tp_cd(); //getUserLevel();
        }
	//	N200903170124 처리를 위해 ofc_cd, ofc_lvl을 무조건 SELHQ,1로 바꾸어 준다.
		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inquire EQ Repo-contribution By BKG</title>
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

<body onLoad="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
  <input	type="hidden" name="f_cmd">
  <input type="hidden" name="iPage">
  <!--  부모창으로부터 전송된 폼값 -->
  <input type="hidden" name="f_trd_cd" value="<%=JSPUtil.getNull(request.getParameter("f_trd_cd"))%>">
  <input type="hidden" name="f_rlane_cd" value="<%=JSPUtil.getNull(request.getParameter("f_rlane_cd"))%>">
  <input type="hidden" name="f_vvd1" value="<%=JSPUtil.getNull(request.getParameter("f_vvd1"))%>">
  <input type="hidden" name="f_vvd2" value="<%=JSPUtil.getNull(request.getParameter("f_vvd2"))%>">
  <input type="hidden" name="f_vvd3" value="<%=JSPUtil.getNull(request.getParameter("f_vvd3"))%>">
  <input type="hidden" name="f_skd_dir_cd" value="<%=JSPUtil.getNull(request.getParameter("f_skd_dir_cd"))%>">

  <input type="hidden" name="f_usa_mode" value="<%=JSPUtil.getNull(request.getParameter("f_usa_mode"))%>">
  <input type="hidden" name="f_r_cmdt" value="<%=JSPUtil.getNull(request.getParameter("f_r_cmdt"))%>">
  <input type="hidden" name="f_shipper" value="<%=JSPUtil.getNull(request.getParameter("f_shipper"))%>">
  <input type="hidden" name="f_sc" value="<%=JSPUtil.getNull(request.getParameter("f_sc"))%>">
  <input type="hidden" name="f_rfa" value="<%=JSPUtil.getNull(request.getParameter("f_rfa"))%>">
  <input type="hidden" name="f_cntr_tpsz_cd" value="<%=JSPUtil.getNull(request.getParameter("f_cntr_tpsz_cd"))%>">
  <input type="hidden" name="f_year" value="<%=JSPUtil.getNull(request.getParameter("f_year"))%>">
  <input type="hidden" name="f_fm_mon" value="<%=JSPUtil.getNull(request.getParameter("f_fm_mon"))%>">
  <input type="hidden" name="f_to_mon" value="<%=JSPUtil.getNull(request.getParameter("f_to_mon"))%>">
  <input type="hidden" name="f_fm_wk" value="<%=JSPUtil.getNull(request.getParameter("f_fm_wk"))%>">
  <input type="hidden" name="f_to_wk" value="<%=JSPUtil.getNull(request.getParameter("f_to_wk"))%>">
  <input type="hidden" name="f_chkprd" value="<%=JSPUtil.getNull(request.getParameter("f_chkprd"))%>"> <!-- CSR No. N200801154876 -->
     
  <input type="hidden" name="f_pol" value="<%=JSPUtil.getNull(request.getParameter("f_pol"))%>">
  <input type="hidden" name="f_pod" value="<%=JSPUtil.getNull(request.getParameter("f_pod"))%>">
  <input type="hidden" name="f_por" value="<%=JSPUtil.getNull(request.getParameter("f_por"))%>">
  <input type="hidden" name="f_del" value="<%=JSPUtil.getNull(request.getParameter("f_del"))%>">
  <!-- -->
  <input type="hidden" name="f_rhq_cd" value="<%=JSPUtil.getNull(request.getParameter("f_rhq_cd"))%>">
  <input type="hidden" name="f_sls_ofc_cd" value="<%=JSPUtil.getNull(request.getParameter("f_sls_ofc_cd"))%>">
  <input type="hidden" name="f_sch_mode" value="<%=JSPUtil.getNull(request.getParameter("f_sch_mode"))%>">

  <!-- OUTER - POPUP (S)tart -->
  <table width="100%" class="popup" cellpadding="10" border="0">
    <tr>
      <td class="top"></td>
    </tr>
    <tr>
      <td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Inquire EQ Repo-contribution By BKG</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


        <!-- : ( Search Options ) (S) -->
        <table class="search">
          <tr>
            <td class="bg">
              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">Booking Detail Inquiry</td>
                </tr>
                <tr>
                  <td class="height_5"></td>
                </tr>
              </table>
              <!-- : ( Grid ) (S) -->
              <table width="100%" id="mainTable">
                <tr>
                  <td>
                    <script language="javascript">ComSheetObject('sheet1');</script>
                  </td>
                </tr>
              </table>
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
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_costdetail" id="btn_costdetail">Cost Detail</td><td class="btn1_right"></td></tr></table></td>
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


</form>
</body>
</html>
