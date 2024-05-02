<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1018.jsp
 *@FileTitle : CndManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.02
 *@LastModifier : 손윤석
 *@LastVersion : 1.0
 * 2009.07.02 손윤석
 * 1.0 Creation
 =========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
  String do_no_t = JSPUtil.getNull(request.getParameter("do_no"));
%>


<html>
<head>
<title>Cargo Release Remark Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage()
    {  
        loadPage();
    }
</script>

</head>
<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="old_rmk">


<table width="100%" class="popup" cellpadding="10" border="0"> 
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Cargo Release Remark</td></tr>
      </table>
 
      <table class="search"> 
        <tr>
          <td class="bg">
            <table class="search" border="0" style="width:484;"> 
              <tr class="h23">
                <td width="50">D/O No.</td>
                <td width=""><input type="text" style="width:90;" class="input1" value="<%=do_no_t%>" name="do_no" readonly></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    
      <table>
        <tr height="5"><td></td></tr>
      </table>
    
      <table class="search">
        <tr><td class="bg">
          <table border="0" style="width:100%; background-color:white;" class="grid2"> 
            <tr><td width="" class="tr2_head_l">D/O Remark (For Print)</td></tr>
            <tr><td>
              <textarea style="width:100%;overflow-y:hidden;text-indent:0px"  rows="5" name="do_prn_rmk"></textarea>
            </td></tr>
          </table>
        </td></tr>
      </table>
      <table class="height_5"><tr><td></td></tr></table>
      
<table width="100%"  id="mainTable" style="display:none"> 
  <tr>
    <td width="100%">
      <script language="javascript">ComSheetObject('sheet1');</script>
    </td>
  </tr>
</table>   
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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                     <td class="btn1_line"></td>
                <td>
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
