<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0130.jsp
 *@FileTitle : CndManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.17
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.08.17 손윤석
 * 1.0 Creation
 =========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
    String do_no 		= JSPUtil.getNull(request.getParameter("do_no"));
    String dubai_mrd_id = JSPUtil.getNull(request.getParameter("dubai_mrd_id"));
%>
<html>
<head>
<title>Receiver Info</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<script language="javascript">
    function setupPage()
    {
        loadPage();
    }
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="bkg_no" value="">
<input type="hidden" name="old_do_no" value = "">
<input type="hidden" name="old_rcvr_co_nm" value="">
<input type="hidden" name="old_cntc_phn_no" value="">
<input type="hidden" name="old_pic" value="">
<input type="hidden" name="old_act_cnee_nm" value="">
<input type="hidden" name="old_cust_ref_nm" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Receiver Info.</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!-- : ( Search Options ) (S) -->

      <table class="search">
        <tr>
          <td class="bg">
            <table class="search" border="0" style="width:100%;">
              <tr class="h23">
                <td width="120">&nbsp;D/O No.</td>
                <td align='left'><input type="text" style="width:90;ime-mode:disabled;" class="input1" caption="D/O No." value="<%=do_no %>" name="do_no" dataformat=""  minlength="10" maxlength="12" required></td>
              </tr>
              <tr><td height="4"></td></tr>
            </table>
            <!--Grid (S)-->
            <table class="grid2" border="0" id="mainTable" style="width:100%;">
              <tr>
                <td width="100%" class="tr2_head">Receipt Company</td>
                <%if(dubai_mrd_id != "" && dubai_mrd_id.length() > 0){ %>
                	<td width="" colspan="3" align="center"><textarea style="width:334;height:40;" class="noinput" name="rcvr_co_nm" maxlength="100" onKeyDown="fncTextareaMaxLine(this.value)"></textarea></td>
                <%} else{ %>
                	<td width="" colspan="3" align="center"><input type="text" style="width:334;" class="noinput" value="" name="rcvr_co_nm" maxlength="50"></td>
                <%} %>
              </tr>
              <tr>
                <td align="center" class="tr2_head">Contact Phone No.</td>
                <td align="center" align="left"><input type="text" style="width:120;ime-mode:disabled;" class="noinput" value="" name="cntc_phn_no" dataformat="jumin" maxlength="30"></td>
                <td align="center"width="100" class="tr2_head">PIC</td>
                <td align="center" align="left"><input type="text" style="width:120;" class="noinput" value="" name="pic" maxlength="50"></td>
              </tr>
              <tr>
                <td align="center" class="tr2_head">Actual Consignee</td>
                <td align="center"colspan="3" class="noinput"><input type="text" style="width:334;" class="noinput" value="" name="act_cnee_nm" maxlength="50"></td>
              </tr>
                <tr>
                <td align="center" class="tr2_head">Customer reference</td>
                <td align="center" align="left"><input type="text" style="width:120;ime-mode:disabled;" class="noinput" value="" name="cust_ref_nm" maxlength="15"></td>
                <td align="center" class="tr2_head">Order B/L</td>
                <td align="center" align="left" class="noinput2"><input type="text" style="width:120;" class="noinput2" value="" name="order_flg" readOnly></td>
              </tr>
            </table>
            <!--Grid (E)-->
          </td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) -->
      <table class="height_5"><tr><td></td></tr></table>
    </td>
  </tr>
</table>


<table width="100%"  id="mainTable">
  <tr>
    <td width="100%">
      <script language="javascript">ComSheetObject('sheet1');</script>
    </td>
  </tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="90">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>



                <td width="72">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>

                <td class="btn1_line"></td>

                <td width="72">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!--Button (E) -->

          </td>
        </tr>
      </table>
      <!-- : ( Button : pop ) (E) -->
    </td>
  </tr>
</table>

</form>
</body>
</html>
