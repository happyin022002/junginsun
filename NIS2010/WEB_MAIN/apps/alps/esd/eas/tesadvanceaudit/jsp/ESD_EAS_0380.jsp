<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0380.js
*@FileTitle : TES Auto Audit - On-Dock Rail Invoice History
*Open Issues :
*Change history :
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="org.apache.log4j.Logger"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
	String strUsr_id = "";
	String strUsr_nm = "";
	
	String s_yd_cd = "";
	String s_vndr_seq = "";
	String s_inv_ofc_cd = "";
	String s_loc_cd = "";

    Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.eas.ESD_EAS_0380");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        
		s_yd_cd = StringUtil.xssFilter(request.getParameter("s_yd_cd"))== null?"":StringUtil.xssFilter(request.getParameter("s_yd_cd"));
		s_vndr_seq = StringUtil.xssFilter(request.getParameter("s_vndr_seq"))== null?"":StringUtil.xssFilter(request.getParameter("s_vndr_seq"));
		s_inv_ofc_cd = StringUtil.xssFilter(request.getParameter("s_inv_ofc_cd"))== null?"":StringUtil.xssFilter(request.getParameter("s_inv_ofc_cd"));

		//s_loc_cd 생성
		if(s_yd_cd != ""){
			s_loc_cd = s_yd_cd.substring(0,5);	
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>TES Auto Audit - On-Dock Rail Invoice History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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
<!-- Outer Table (S)-->
<input type="hidden" name="s_yd_cd"   value="<%=s_yd_cd%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; TES Auto Audit - On-Dock Rail Invoice History</td></tr>
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
                      <td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_new" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
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
				<td width="34">Yard</td>
				<td width="56"><input type="text" style="width:50" name="s_loc_cd" value="<%=s_loc_cd%>" class="input2" readOnly></td>
				<td width="60"><script language="javascript">ComComboObject('s_nod_cd', 1, 45, 0)</script></td>
				<td width="70">S/P No.</td>
				<td width="278" colspan="3"><input type="text" name="s_vndr_seq" dataformat="int" style="width:60" value="<%=s_vndr_seq%>" maxlength="6" onBlur='vender_change();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" name="btn_vndr" width="19" height="20" border="0" align="absmiddle">
				<input type="text" style="width:173" name="s_vndr_seq_name" class="input2" readOnly></td>
				<td width="70">Inv office</td>
				<td width="70"><input type="text" style="width:59" name="s_inv_ofc_cd" dataformat="engup" maxlength="6" value="<%=s_inv_ofc_cd%>"></td>
				<td width="50">Period</td>
				<td width="220">
				<input type="text" style="width:70; text-align:Center" name="s_from_inv_cfm_dt" dataformat="ymd" maxlength="8" class="input1" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="fnYearSet(this)">
				<img name="btns_from_inv_cfm_dt" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor">
				&nbsp;~&nbsp;
				<input type="text" style="width:70; text-align:Center" name="s_to_inv_cfm_dt" dataformat="ymd" maxlength="8" class="input1" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="fnYearSet(this)">
				<img name="btns_to_inv_cfm_dt" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor">
				</td>
              </tr>
              <tr class="h23">
				<td colspan="3">&nbsp;</td>              
				<td width="70">Cal. Type</td>
				<td colspan="3" style="padding-left: 2;"><script language="javascript">ComComboObject('s_calc_tp_cd', 1, 85, 0)</script></td>
				<td width="70">Cost Code</td>
				<td colspan="3" style="padding-left: 2;"><script language="javascript">ComComboObject('s_lgs_cost_subj_cd', 1, 60, 0)</script> <script language="javascript">ComComboObject('s_lgs_cost_dtl_cd', 1, 100, 1)</script></td>              
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <table class="height_5"><tr><td></td></tr></table>
        <table class="search" border="0">
        <tr>
          <td class="bg">
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject("sheet1");</script>
                </td>
              </tr>
            </table>
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_inv_detail">Inv. Details</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>					
				</tr>
				</table>
			</td></tr>
			</table>
          </td>
        </tr>
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
	<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>
