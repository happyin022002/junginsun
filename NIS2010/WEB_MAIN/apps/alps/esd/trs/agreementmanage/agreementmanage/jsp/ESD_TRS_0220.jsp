<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0220.jsp
*@FileTitle : Agreement Header
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-18
*@LastModifier : cjh
*@LastVersion : 1.0
* 2010-03-18 cjh
* 1.0 최초 생성 
* HISTORY
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception serverException = null;	//서버에서 발생한 에러
	String	  strErrMsg	= "";			//에러메세지
	String	  userId    = "";
	String	  ofcCd		= "";
	String    agmt_no   = "";	
	try {
		agmt_no = ((request.getParameter("agmt_no")==null )?"":request.getParameter("agmt_no"));	
		
		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	ofcCd						= account.getOfc_cd();
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
<title>Agreement Header</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    loadPage();
  }
</script>
</head>

<body class="popup_bg" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="fm_trsp_agmt_ofc_cty_cd"	  value="">
<input type="hidden" name="f_cmd" >

<input type="hidden" name="hid_row" >
<input type="hidden" name="hid_col" >

<table width="100%" class="popup" cellpadding="10">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
          <td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Agreement Header</td>
        </tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!--retrieve page (S)-->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <table class="search" border="0" style="width:230;"> 
              <tr class="h23">
                <td width="100">Agreement No.</td>
                <td width="130"><input name="fm_agmtno" type="text" style="width:80;" class="input" value="<%=agmt_no%>" onKeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--retrieve page (E)-->
    
      <table class="height_8"><tr><td></td></tr></table>  
      <!--  biz_1  (S) -->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">  
            <table class="search" border="0">
              <tr>
                <td class="title_h"></td>
                <td class="title_s">Header Information</td>
              </tr>
              <tr>
                <td class="height_5"></td>
              </tr>
            </table>
          
            <!--  biz_2   (S) -->
            <table class="search" border="0" style="width:700;"> 
              <tr class="h23">
                <td width="" valign="top">
                  <table class="search" border="0" style="width:100%;">
                    <tr class="h23">
                      <td width="100">Service Provider</td>
                      <td width="45"><input name="fm_vndr_prmry_seq" type="text"  style="width:50;" value=""  maxlength="6" onBlur="vender_blur();"></td>
                      <td width="140"><input name="fm_vndr_prmry_nm" type="text" style="width:105;" value="" class="input2"  title="This inputbox cant't write" readOnly>
                      <img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_provider'>
                      </td>
                      <td colspan="2" width="95"></td>
                    </tr>

                    <tr class="h23">
                      <td>Reference No.</td>
                      <td colspan="2"><input name="fm_agmt_ref_no" class="input1" type="text" style="width:157;" value=""  maxlength="15"></td>
                      <td>Contract Office</td>
                      <td align="right"><input name="fm_ctrt_ofc_cd" class="input1" type="text" style="width:70;" value="" maxlength="6" onBlur="office_blur();"></td>
                    </tr>
                    <tr class="h23">
                      <td>Remarks</td>
                      <td colspan="4"><input name="fm_inter_rmk" type="text" style="width:100%;" value="" maxlength="1000"></td>
                    </tr>
                  </table>
                </td>
                <td width="10"></td>
                <td width="230">
                  <table width="100%" id="mainTable">
                    <tr>
                      <td>
                        <script language="javascript">ComSheetObject('sheet0');</script>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
              <tr>
                <td class="btn2" name="" align="right">
                </td>
                <td></td>
                <td>
                  <!--  Button_Sub (S) -->
                  <table width="100%" class="button"> 
                    <tr>
                      <td class="btn2_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                          <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                              <tr>
                                <td class="btn2_left"></td>
                                <td class="btn2" id="btn_rowadd" name="btn_rowadd">Row Add</td>
                                <td class="btn2_right"></td>
                              </tr>
                            </table>
                          </td>
                          <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                              <tr>
                                <td class="btn2_left"></td>
                                <td class="btn2" id="btn_save" name="btn_save">Save</td>
                                <td class="btn2_right"></td>
                              </tr>
                            </table>
                          </td>
                        </table>
                      </td>
                    </tr>
                  </table>
                  <!-- Button_Sub (E) -->
                </td>
              </tr>
            </table>
            <!--  biz_2   (E) -->
          </td>
        </tr>
      </table>
      <!--  biz_1   (E) -->
      <table class="height_5"><tr><td></td></tr></table>
    </td>
  </tr>
</table>

<!-- : ( Button : Sub ) (S) -->
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
                      <td class="btn1" name="btng_retrieve" id="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_create">Create</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_update">Update</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_ok">OK</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_new">New</td>
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
<!-- : ( Button : Sub ) (E) -->
<script language="javascript">ComSheetObject('sheet1');</script>
</form>
</body>
</html>