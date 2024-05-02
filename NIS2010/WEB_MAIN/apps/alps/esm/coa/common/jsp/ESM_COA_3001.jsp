<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_3001.jsp
*@FileTitle : Select Creation Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 최인경
*@LastVersion : 1.0
=========================================================*/
%>
<html>
<head>
<title>Select Creation Type</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">
    function fnProcess() {
        var frm = document.form;

        if(frm.f_password.value == ""){
            if(ComShowConfirm(ComGetMsg('COA10054'))){
                window.returnValue = "";
                self.close();
            }
        }else {
            if(frm.f_password.value != "6475"){
                ComShowConfirm(ComGetMsg('COA10055'));
                window.returnValue = "";
                self.close();
            }
            window.returnValue = frm.f_password.value;
            window.close();
        }
    }

    function fnLoad(){
        form.f_password.focus();
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
        <tr><td class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Input PassWord</td></tr>
      </table>
      <!-- : ( Title ) (E) -->
      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Grid ) (S) -->
            <table width="262" class="search">
              <tr class="h23">
                <td width="60"><div align="right">Password</div></td>
                <td width="130"><input name="f_password" type="password" onKeyDown="fnKeyPressAction(event);"></td>
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