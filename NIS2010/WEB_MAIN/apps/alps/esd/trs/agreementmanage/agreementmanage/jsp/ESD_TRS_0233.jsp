<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0233.jsp
*@FileTitle : Agreement Header Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-17
*@LastModifier : pjy
*@LastVersion : 1.0
* 2010-05-17 pjy
* 1.0 최초 생성
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
	String	  userId    = "";
	String	  ofcCd		= "";
	String    agmt_no   = ((request.getParameter("agmt_no")==null )?"":request.getParameter("agmt_no"));
	try {		
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
	
	String mainRow = JSPUtil.getNull(request.getParameter("main_row"));
%>
<html>
<head>
<title>Agreement Header Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    loadPage();
  }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="mainRow" value='<%=mainRow%>'>

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
          <td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Agreement Header Inquiry</td>
        </tr>
      </table>
      <!-- : ( Title ) (E) -->
    
      <table class="height_8"><tr><td></td></tr></table>  
      <!--  biz_1  (S) -->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
          
            <!--  biz_2   (S) -->
            <table class="search" border="0" style="width:600;"> 
              <tr class="h23">
                <td width="" valign="top">
                  <table class="search" style="width:600;">
                    <tr class="h23">
                      <td width="100">Service Provider</td>
                      <td width="45"><input name="combo_svc_provider" type="text" style="width:50;" value=""  maxlength="6" onChange='getVendorSeq(sheetObjects[0], document.form, this.value)'></td>
                      <td width="190"><input name="svc_provider" type="text" style="width:105;" value="" title="This inputbox cant't write">
                      <img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='btn_provider'>
                      </td>
                      <td width="100">Agreement No.</td>
                      <td><input name="agmt_no" type="text" style="width:70;" value="<%=agmt_no%>" maxlength="9"></td>
                    </tr>

                    <tr class="h23">
                      <td>Reference No.</td>
                      <td colspan="2"><input name="agmt_ref_no" type="text" style="width:157;" value=""  maxlength="15" onKeyup="javascript:doSearchEnter();"></td>
                      <td>Contract Office</td>
                      <td align="left"><input name="ctrt_ofc_cd" type="text" style="width:70;" value="" maxlength="6"></td>
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

<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="popup" width="100%" cellpadding="10">
	<tr>
		<td class="bg">
		<table class="search" id="mainTable">
			<tr><td>
				<!-- : ( Button : Sub ) (E) -->
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
                      <td class="btn1" name="btng_retrieve" id="btn_Retrieve">Retrieve</td>
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