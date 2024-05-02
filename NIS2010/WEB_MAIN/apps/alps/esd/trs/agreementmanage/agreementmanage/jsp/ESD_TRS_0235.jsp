<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0235.jsp
*@FileTitle : Agreement Rate Inquiry Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.1
* 2010-05-17 pjy
* 1.0 최초 생성
*
* 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
* 2011.11.23 김영철  [CHM-201114499] [TRS] Agreement Inquiry by Route 에 필요한 변수 변경
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%> 
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException = null;	//서버에서 발생한 에러
	String	  strErrMsg	= "";			//에러메세지
	
	String fm_rail_svc_tp_cd         = request.getParameter("fm_rail_svc_tp_cd")!=null?request.getParameter("fm_rail_svc_tp_cd"):"";
	String fm_agmt_trsp_tp_cd        = request.getParameter("fm_pop_agmt_trsp_tp_cd")!=null?request.getParameter("fm_pop_agmt_trsp_tp_cd"):"";
	String fm_trsp_agmt_ofc_cty_cd   = request.getParameter("fm_trsp_agmt_ofc_cty_cd")!=null?request.getParameter("fm_trsp_agmt_ofc_cty_cd"):"";
	String fm_trsp_agmt_seq          = request.getParameter("fm_trsp_agmt_seq")!=null?request.getParameter("fm_trsp_agmt_seq"):"";
	String fm_trsp_agmt_rt_tp_ser_no = request.getParameter("fm_trsp_agmt_rt_tp_ser_no")!=null?request.getParameter("fm_trsp_agmt_rt_tp_ser_no"):"";
	String fm_vndr_seq               = request.getParameter("fm_vndr_seq")!=null?request.getParameter("fm_vndr_seq"):"";
	String fm_ctrt_ofc_cd            = request.getParameter("fm_ctrt_ofc_cd")!=null?request.getParameter("fm_ctrt_ofc_cd"):"";
	String fm_eq_knd_cd              = request.getParameter("fm_eq_knd_cd")!=null?request.getParameter("fm_eq_knd_cd"):"";
	String fm_trsp_agmt_eq_tp_sz_cd  = request.getParameter("fm_trsp_agmt_eq_tp_sz_cd")!=null?request.getParameter("fm_trsp_agmt_eq_tp_sz_cd"):"";
	String fm_cgo_tp_cd              = request.getParameter("fm_cgo_tp_cd")!=null?request.getParameter("fm_cgo_tp_cd"):"";
	String fm_fm_nod_cd              = request.getParameter("fm_fm_nod_cd")!=null?request.getParameter("fm_fm_nod_cd"):"";
	String fm_via_nod_cd             = request.getParameter("fm_via_nod_cd")!=null?request.getParameter("fm_via_nod_cd"):"";
	String fm_dor_nod_cd             = request.getParameter("fm_dor_nod_cd")!=null?request.getParameter("fm_dor_nod_cd"):"";
	String fm_to_nod_cd              = request.getParameter("fm_to_nod_cd")!=null?request.getParameter("fm_to_nod_cd"):"";
	String fm_trsp_agmt_bdl_qty      = request.getParameter("fm_trsp_agmt_bdl_qty")!=null?request.getParameter("fm_trsp_agmt_bdl_qty"):"";
	String fm_wgt_meas_ut_cd         = request.getParameter("fm_wgt_meas_ut_cd")!=null?request.getParameter("fm_wgt_meas_ut_cd"):"";
	String fm_basic_rt               = request.getParameter("fm_basic_rt")!=null?request.getParameter("fm_basic_rt"):"";
	String fm_curr_cd                = request.getParameter("fm_curr_cd")!=null?request.getParameter("fm_curr_cd"):"";
	String fm_way                    = request.getParameter("fm_way")!=null?request.getParameter("fm_way"):"";
	String effective_date            = request.getParameter("effective_date")!=null?request.getParameter("effective_date"):"";
	String tab_gubun            	 = request.getParameter("tab_gubun")!=null?request.getParameter("tab_gubun"):"";
		
	if("current".equals(tab_gubun)){
		effective_date = "";
	}
		
	try {		
		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Agreement Rate Inquiry Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    loadPage();
  }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">

<input type="hidden" name="fm_rail_svc_tp_cd" value="<%=fm_rail_svc_tp_cd%>">
<input type="hidden" name="fm_agmt_trsp_tp_cd" value="<%=fm_agmt_trsp_tp_cd%>">
<input type="hidden" name="fm_trsp_agmt_ofc_cty_cd" value="<%=fm_trsp_agmt_ofc_cty_cd%>">
<input type="hidden" name="fm_trsp_agmt_seq" value="<%=fm_trsp_agmt_seq%>">
<input type="hidden" name="fm_trsp_agmt_rt_tp_ser_no" value="<%=fm_trsp_agmt_rt_tp_ser_no%>">
<input type="hidden" name="fm_vndr_seq" value="<%=fm_vndr_seq%>">
<input type="hidden" name="fm_ctrt_ofc_cd" value="<%=fm_ctrt_ofc_cd%>">
<input type="hidden" name="fm_eq_knd_cd" value="<%=fm_eq_knd_cd%>">
<input type="hidden" name="fm_trsp_agmt_eq_tp_sz_cd" value="<%=fm_trsp_agmt_eq_tp_sz_cd%>">
<input type="hidden" name="fm_cgo_tp_cd" value="<%=fm_cgo_tp_cd%>">
<input type="hidden" name="fm_fm_nod_cd" value="<%=fm_fm_nod_cd%>">
<input type="hidden" name="fm_via_nod_cd" value="<%=fm_via_nod_cd%>">
<input type="hidden" name="fm_dor_nod_cd" value="<%=fm_dor_nod_cd%>">
<input type="hidden" name="fm_to_nod_cd" value="<%=fm_to_nod_cd%>">
<input type="hidden" name="fm_trsp_agmt_bdl_qty" value="<%=fm_trsp_agmt_bdl_qty%>">
<input type="hidden" name="fm_wgt_meas_ut_cd" value="<%=fm_wgt_meas_ut_cd%>">
<input type="hidden" name="fm_curr_cd" value="<%=fm_curr_cd%>">
<input type="hidden" name="fm_basic_rt" value="<%=fm_basic_rt%>">
<input type="hidden" name="fm_way" value="<%=fm_way%>">
<input type="hidden" name="effective_date" value="<%=effective_date%>">
<input type="hidden" name="f_cmd" >

<table width="100%" class="popup" cellpadding="10">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
          <td height="0" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Agreement Rate Inquiry Detail</td>
        </tr>
      </table>
      <!-- : ( Title ) (E) -->
    </td>
  </tr>
</table>

<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="popup" width="100%" cellpadding="10">
	<tr>
		<td class="bg">
		<table class="search" id="mainTable">
			<tr><td>
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td></tr>
		</table>
    </td></tr>
</table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton" cellpadding="10">
  <tr>
    <td class="popup" valign="top">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
          <td class="btn3_bg" height="71">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>