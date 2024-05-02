<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0149.jsp
*@FileTitle : Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.11 송호진
* 1.0 Creation
===========================================================
	' History :
	' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
	' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[149]
    ' 2009.09.15송호진  ALPS F/W 적용
    * 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.event.EsmCoa0149Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//	EsmCoa0149Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
    String f_ofc_cd   = "";
    String f_ofc_lvl  = "";
    
	Logger log = Logger.getLogger("com.hanjin.apps.MultiDimensionRPT.SalesRPT");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

//		event = (EsmCoa0149Event)request.getAttribute(Event);
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
<title>Cost Detail</title>
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

<!-- 개발자 작업	-->
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
  <input	type="hidden" name="f_cmd">
  <input type="hidden" name="iPage">
  <!--  부모창으로부터 전송된 폼값 -->
  <!--  
  <input type="hidden" name="f_ofc_lvl" value="<%=JSPUtil.getNull(request.getParameter("f_ofc_lvl"))%>">
  <input type="hidden" name="f_ofc_cd" value="<%=JSPUtil.getNull(request.getParameter("f_ofc_cd"))%>">
  <input type="hidden" name="f_chkprd" value="<%=JSPUtil.getNull(request.getParameter("f_chkprd"))%>">
  
  <input type="hidden" name="f_year" value="<%=JSPUtil.getNull(request.getParameter("f_year"))%>">
  <input type="hidden" name="f_fm_mon" value="<%=JSPUtil.getNull(request.getParameter("f_fm_mon"))%>">
  <input type="hidden" name="f_to_mon" value="<%=JSPUtil.getNull(request.getParameter("f_to_mon"))%>">
  <input type="hidden" name="f_fm_wk" value="<%=JSPUtil.getNull(request.getParameter("f_fm_wk"))%>">
  <input type="hidden" name="f_to_wk" value="<%=JSPUtil.getNull(request.getParameter("f_to_wk"))%>">
   -->
  <input type="hidden" name="f_pro_vw" value="<%=JSPUtil.getNull(request.getParameter("f_pro_vw"))%>">
  <input type="hidden" name="f_pro_lvl" value="<%=JSPUtil.getNull(request.getParameter("f_pro_lvl"))%>">
  <!-- 
  <input type="hidden" name="f_ofc_vw" value="<%=JSPUtil.getNull(request.getParameter("f_ofc_vw"))%>">

  <input type="hidden" name="f_rhq_cd" value="<%=JSPUtil.getNull(request.getParameter("f_rhq_cd"))%>">
  <input type="hidden" name="f_sls_ofc_cd" value="<%=JSPUtil.getNull(request.getParameter("f_sls_ofc_cd"))%>">
  
  <input type="hidden" name="f_trd_cd" value="<%=JSPUtil.getNull(request.getParameter("s_trd_cd"))%>">
  <input type="hidden" name="f_rlane_cd" value="<%=JSPUtil.getNull(request.getParameter("s_rlane_cd"))%>">
  <input type="hidden" name="f_dir_cd" value="<%=JSPUtil.getNull(request.getParameter("s_dir_cd"))%>">
  
  <input type="hidden" name="f_vsl_cd" value="<%=JSPUtil.getNull(request.getParameter("f_vsl_cd"))%>">
  <input type="hidden" name="f_skd_voy_no" value="<%=JSPUtil.getNull(request.getParameter("f_skd_voy_no"))%>">
  <input type="hidden" name="f_dir_cd" value="<%=JSPUtil.getNull(request.getParameter("f_dir_cd"))%>"> 
  
  <input type="hidden" name="f_bkg_por_cd" value="<%=JSPUtil.getNull(request.getParameter("bkg_por_cd"))%>">
  <input type="hidden" name="f_rev_pol_cd" value="<%=JSPUtil.getNull(request.getParameter("rev_pol_cd"))%>">
  <input type="hidden" name="f_rev_pod_cd" value="<%=JSPUtil.getNull(request.getParameter("rev_pod_cd"))%>">
  <input type="hidden" name="f_bkg_del_cd" value="<%=JSPUtil.getNull(request.getParameter("bkg_del_cd"))%>">
  
  <input type="hidden" name="f_shpr" value="<%=JSPUtil.getNull(request.getParameter("f_shpr"))%>">
  <input type="hidden" name="f_sc_no" value="<%=JSPUtil.getNull(request.getParameter("f_sc_no"))%>">
  <input type="hidden" name="f_rfa_no" value="<%=JSPUtil.getNull(request.getParameter("f_rfa_no"))%>">

  <input type="hidden" name="f_key_acct_group_cd" value="<%=JSPUtil.getNull(request.getParameter("f_key_acct_group_cd"))%>">
  <input type="hidden" name="f_key_acct_indvl_cd" value="<%=JSPUtil.getNull(request.getParameter("f_key_acct_indvl_cd"))%>">
  
  <input type="hidden" name="f_cmdt_cd" value="<%=JSPUtil.getNull(request.getParameter("f_cmdt_cd"))%>">
  <input type="hidden" name="f_usa_bkg_mod_cd" value="<%=JSPUtil.getNull(request.getParameter("f_usa_bkg_mod_cd"))%>">
  -->
  <input type="hidden" name="f_cntr_tpsz_cd" value="<%=JSPUtil.getNull(request.getParameter("f_cntr_tpsz_cd"))%>">
  <!--  
  <input type="hidden" name="f_view_tpsz" value="<%=JSPUtil.getNull(request.getParameter("f_view_tpsz"))%>">
  <input type="hidden" name="f_bkg_no" value="<%=JSPUtil.getNull(request.getParameter("f_bkg_no"))%>">
  <input type="hidden" name="f_dir_sts" value="<%=JSPUtil.getNull(request.getParameter("f_dir_sts"))%>">
  <input type="hidden" name="f_bkg_no" value="RTMZ1090012">
  -->
  <input type="hidden" name="f_bkg_no" value="<%=JSPUtil.getNull(request.getParameter("s_bkg_no"))%>">
  
  <!-- OUTER - POPUP (S)tart -->
  <table width="1000" class="popup" cellpadding="10" border="0">
    <tr><td class="top"></td></tr>
    <tr><td valign="top">

			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Cost Detail Inquiry</td></tr>
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
                  <td rowspan="2" class="gray" style="padding-bottom:5;"><a href="#" class="purple" onClick="openBKGinquiry(sheetObjects[0],document.form,'')"><img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">Inquiry by BKG</a></td>
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