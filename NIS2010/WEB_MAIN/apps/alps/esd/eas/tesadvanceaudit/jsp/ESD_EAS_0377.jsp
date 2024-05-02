<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0377.js
*@FileTitle : TES Auto Audit - MR Audit Detail
*Open Issues :
*Change history :
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0377Event"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="org.apache.log4j.Logger"%>
<%
	Exception serverException = null;	//서버에서 발생한 에러
	EsdEas0377Event  event = null;      //PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse =  null;

    String strErrMsg = "";              //에러메세지
	String strUsr_id = "";
	String strUsr_nm = "";

	String s_yd_cd = "";
	String s_vndr_seq = "";
	String s_inv_ofc_cd = "";
	String s_inv_no = "";
	String s_vvd = "";
	String s_io_bnd_cd = "";
	String s_atb_dt = "";
	String s_expn_aud_sts_cd = "";
	String s_yd_nm = "";
	String s_vndr_nm = "";
	String s_eas_flg = "";
	String s_iss_dt = "";
	String s_inv_cfm_dt = "";
	String s_expn_aud_seq = "";
	
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.eas.ESD_EAS_0377");
	try {
        event = (EsdEas0377Event)request.getAttribute("Event");
        eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{	
			s_yd_nm = eventResponse.getETCData("YdNm");
            s_vndr_nm = eventResponse.getETCData("VndrNm");
		}

		s_yd_cd = StringUtil.xssFilter(request.getParameter("s_yd_cd"))== null?"":StringUtil.xssFilter(request.getParameter("s_yd_cd"));
		s_vndr_seq = StringUtil.xssFilter(request.getParameter("s_vndr_seq"))== null?"":StringUtil.xssFilter(request.getParameter("s_vndr_seq"));
		s_inv_ofc_cd = StringUtil.xssFilter(request.getParameter("s_inv_ofc_cd"))== null?"":StringUtil.xssFilter(request.getParameter("s_inv_ofc_cd"));
		s_inv_no = StringUtil.xssFilter(request.getParameter("s_inv_no"))== null?"":StringUtil.xssFilter(request.getParameter("s_inv_no"));
		s_vvd = StringUtil.xssFilter(request.getParameter("s_vvd"))== null?"":StringUtil.xssFilter(request.getParameter("s_vvd"));
		s_io_bnd_cd = StringUtil.xssFilter(request.getParameter("s_io_bnd_cd"))== null?"":StringUtil.xssFilter(request.getParameter("s_io_bnd_cd"));
		s_atb_dt = StringUtil.xssFilter(request.getParameter("s_atb_dt"))== null?"":StringUtil.xssFilter(request.getParameter("s_atb_dt"));
		s_expn_aud_sts_cd = StringUtil.xssFilter(request.getParameter("s_expn_aud_sts_cd"))== null?"":StringUtil.xssFilter(request.getParameter("s_expn_aud_sts_cd"));
		s_eas_flg = StringUtil.xssFilter(request.getParameter("s_eas_flg"))== null?"N":StringUtil.xssFilter(request.getParameter("s_eas_flg"));
		s_iss_dt = StringUtil.xssFilter(request.getParameter("s_iss_dt"))== null?"":StringUtil.xssFilter(request.getParameter("s_iss_dt"));
		s_inv_cfm_dt = StringUtil.xssFilter(request.getParameter("s_inv_cfm_dt"))== null?"":StringUtil.xssFilter(request.getParameter("s_inv_cfm_dt"));
		s_expn_aud_seq = StringUtil.xssFilter(request.getParameter("s_expn_aud_seq"))== null?"":StringUtil.xssFilter(request.getParameter("s_expn_aud_seq"));
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
// 		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>TES Auto Audit - MR Audit Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("s_expn_aud_sts_cd", "", "CD03348", 0, "")%>
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>
<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="expn_aud_sts_cd" value="<%=s_expn_aud_sts_cd%>">
<input type="hidden" name="expn_aud_seq" value="<%=s_expn_aud_seq%>">
<input type="hidden" name="iss_dt" value="<%=s_iss_dt%>">
<input type="hidden" name="inv_cfm_dt" value="<%=s_inv_cfm_dt%>">
<input type="hidden" name="s_lgs_cost_cd" value="">

<!-- Outer Table (S)-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; TES Auto Audit - MR Audit Detail</td></tr>
      </table>
      <!-- : ( Title ) (E) -->
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
                      <td class="btn1" id="btn_down_excel" name="btn_down_excel">Down Excel</td>
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
      <table class="search">
        <tr>
          <td class="bg">
            <table class="search_in" border="0" style="width:100%;">
              <tr class="h23">
				<td width="50">Yard</td>
				<td width="200"><input type="text" style="width:60" name="s_yd_cd" value="<%=s_yd_cd%>" class="input2" readOnly>&nbsp;<input type="text" style="width:120" name="s_yd_nm" value="<%=s_yd_nm%>" class="input2" readOnly></td>
				<td width="60">S/P No.</td>
				<td width="200"><input type="text" style="width:60" name="s_vndr_seq" value="<%=s_vndr_seq%>" class="input2" readOnly>&nbsp;<input type="text" style="width:120" name="s_vndr_seq_name" value="<%=s_vndr_nm%>" class="input2" readOnly></td>
				<td width="70">Inv office</td>
				<td width="100"><input type="text" style="width:80" name="s_inv_ofc_cd" value="<%=s_inv_ofc_cd%>" class="input2" readOnly></td>
				<td width="70">Invoice No</td>
				<td width="90"><input type="text" style="width:108" name="s_inv_no" value="<%=s_inv_no%>" class="input2" readOnly></td>
              </tr>
              <tr class="h23">
				<td>VVD</td>
				<td><input type="text" style="width:80; text-align:Center" name="s_vvd" value="<%=s_vvd%>" class="input2" readOnly></td>
				<td>Bound</td>
				<td><input type="text" style="width:80; text-align:Center" name="s_io_bnd_cd" value="<%=s_io_bnd_cd%>" class="input2" readOnly></td>
				<td>ATB</td>
				<td><input type="text" style="width:80; text-align:Center" name="s_atb_dt" value="<%=s_atb_dt%>" class="input2" readOnly></td>
				<td>Audit Result</td>
				<td style="padding-left:2;"><script language="javascript">ComComboObject('s_expn_aud_sts_cd',1,110,1);</script></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <table class="height_5"><tr><td></td></tr></table>
        <table class="search" border="0">
        <tr>
          <td class="bg">
            <table class="search" border="0">
              <tr class="h23">
                <td width="50">Inv Amt</td>
                <td width="136"><input class="input2" type="text" name="inv_ttl_amt" style="width:120;text-align:right;" readOnly></td>
                <td width="50">Est Amt</td>
                <td width="136"><input class="input2" type="text" name="estm_ttl_amt" style="width:120;text-align:right;" readOnly></td>
                <td width="56">Diff. Amt</td>
                <td width="136"><input class="input2" type="text" name="diff_amt" style="width:120;text-align:right;" readOnly></td>
				<td width="76">&nbsp;</td>
				<td width="120">&nbsp;</td>
              </tr>
              <tr><td height="3"></td></tr>
            </table>
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject("sheet1");</script>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <table width="100%" class="button"> 
      	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_cntr_vol">CNTR Vol.</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_inv_detail">Inv. Details</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_history">History</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_agreement">Agreement</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
<% if("Y".equals(s_eas_flg)){ %>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_eac_transfer">EAC Transfer</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
<% } %>
				</tr>
				</table>
		</td></tr>
	  </table>
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close" id="btn_close">Close</td>
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
    </td>
  </tr>
</table>
<div style="display:none;">
	<script language="javascript">ComSheetObject('sheet10');</script>
</div>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>
