<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_3003.jsp
*@FileTitle : From/To Year Month Input
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.coa.common.Utils"%>

<%
    //Variable
    String cost_yrmon = (JSPUtil.getNullNoTrim(request.getParameter("cost_yrmon"))).replace("-", "");
    String[] arr_mon = Utils.getYearMonthList(cost_yrmon, 4);
    String fm_mon = Utils.addDateSeperator(arr_mon[3], "-");
    String to_mon = Utils.addDateSeperator(arr_mon[1], "-");
%>
<html>
<head>
<title>Select Creation Type</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">
    function fnProcess() {
        var frm = document.form;

        if(frm.f_fm_yrmon.value == "" || frm.f_to_yrmon.value == ""){
            if(ComShowConfirm(ComGetMsg('COA10002'))){
                window.returnValue = "";
                form.f_fm_yrmon.focus();
            }
        }else {
            window.returnValue = frm.f_fm_yrmon.value+'@@'+frm.f_to_yrmon.value;
            window.close();
        }
    }

    function fnLoad(){
        form.f_fm_yrmon.focus();
    }

    function fnKeyPressAction(e){
        if(e.keyCode == 13){
            fnProcess();
        }
    }

</script>
<body onLoad="fnLoad();">
<form method="post" name="form">

<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10" border="0">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="280" border="0">
        <tr><td class="title"><img src="/opuscntr/img/ico_t1.gif" width="20" height="12">Input Period</td></tr>
      </table>
      <!-- : ( Title ) (E) -->
      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Grid ) (S) -->
            <table width="262" class="search">
              <tr class="h23">
                <td width="130"><div align="center">Period</div></td>
                <td width="90"><input type="text" class="input1" value=<%=fm_mon %> name="f_fm_yrmon" style="width:60" maxlength="7" onKeyPress="ComKeyOnlyNumber(window)" onBlur="addDash(this , 4);" onFocus="this.value=ComReplaceStr(this.value, '-', '');"></td>
                <td width="10">~</td> 
                <td width="90"><input type="text" class="input1" value=<%=to_mon %> name="f_to_yrmon" style="width:60" maxlength="7" onKeyPress="ComKeyOnlyNumber(window)" onBlur="addDash(this , 4);" onFocus="this.value=ComReplaceStr(this.value, '-', '');"></td>
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
                      <td class="btn1" onClick="fnProcess();">Confirm</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>

                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close" id="btn_close" onClick="javascript:self.close();">Close</td>
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
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>