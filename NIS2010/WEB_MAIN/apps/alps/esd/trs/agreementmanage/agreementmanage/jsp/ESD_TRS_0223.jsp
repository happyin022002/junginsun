<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0223.jsp
*@FileTitle : Agreement USA Rail Surcharge
*Open Issues :
*Change history :
*@LastModifyDate : 2010-08-12
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2010-03-18 cjh	   	1.0  최초 생성
* 2010-08-12 Sun, CHOI	1.1 Agreement Reference No 조회 컬럼 추가 및 조회 조건 추가
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%> 
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception					serverException		= null;			//서버에서 발생한 에러
	String						strErrMsg			= "";								 //에러메세지
	String	userId		= "";
	String	ofcCd		= "";

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
%>

<html>
<head>
<title>Agreement USA Rail Surcharge</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  <%= BizComUtil.getIBCodeCombo("default_curr", "01", "CURR", 1, "")%>
  <%= JSPUtil.getIBCodeCombo("rail_road_code", "", "CD00930", 0, "")%>
  <%= JSPUtil.getIBCodeCombo("rail_scg_code", "", "CD02586", 0, "")%>
  function setupPage(){
    loadPage();
  }
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="hid_eff_dt" value="">
<input type="hidden" name="f_cmd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
      
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
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
                      <td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
        </table>
      </td></tr>
      </table>
      <!--Button (E) -->
  
      <!--biz page (S)-->
      <div id="MiniLayer" style="display:inline">
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:700;">
              <tr class="h23"> 
            	<td width="100">Rail Company</td>
                <td width="105" align="center">
                  <script language="javascript">ComComboObject('rail_road_code',2, 100 , 1 )</script>
                </td>
                <td width="">
                  <input name="fm_vndr_nm" type="text" style="width:200;" readonly class="input2">
                </td>
                
                <td width="130">Effective Date(as of)</td>
                <td width="130">
                  <input name="eff_dt" type="text" style="width:80;" class="input" value="" maxlength="8" onFocus="javascript:delHypen(this);"  onBlur="javascript:getHypen(this);">&nbsp;<img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar">
                </td>
                <td width="">
                </td>
              </tr>
              <tr class="h23">
                <td width="100">Agreement No.</td>
                <td width="105" align="center">
                  <input name="fm_agmtno" type="text" style="width:80;" class="input" value="" onBlur="setgetUpper(this);">
                  <img name='btn_agmtno' class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="">
                </td>       
                
                <td width="130">Reference No.</td>
                <td width="130">
                  <input name="agmt_ref_no" type="text" style="width:100;" class="input" value="" maxlength="20">
                </td>
                <td width="">
                </td>
              </tr>
            </table>

            
            <!--  biz_1   (E) -->
          </td>
        </tr>
      </table>
      </div>
    
      <table class="height_8"><tr><td></td></tr></table>  
    </td>
  </tr>
</table>
    
<table class="height_8"><tr><td></td></tr></table>  

<!-- TABLE '#D' : ( Tab ) (S) -->
<table class="tab">
  <tr><td><script language="javascript">ComTabObject('tab1' )</script></td></tr>
</table>
<!-- TABLE '#D' : ( Tab ) (E) -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"> 
  <tr>
    <td>
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            
            <div id="tabLayer" style="display:inline">
            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->
            </div>
            <div id="tabLayer" style="display:none">
            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->
            </div>
            <div id="tabLayer" style="display:none">
            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet3');</script>
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->
            </div>
            
            <!-- : ( Button_ Sub ) (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_reset" name="btng_reset">Reset</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_loadexcel" name="btng_loadexcel">File Import</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_verify" name="btng_verify">Verify</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_history" name="btng_history">History</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <!-- Repeat Pattern -->
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_delete" name="btng_delete">Delete</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_update" name="btng_update">Update</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>

                      <!-- Repeat Pattern -->
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- : ( Button_ Sub ) (E) -->
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>
