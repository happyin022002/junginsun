<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_PRD_0087.jsp
*@FileTitle : Agreement Rate History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.1
* 2010-03-18 cjh
* 1.0 최초 생성
* HISTORY
*
* 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
* 1.2 2011.06.29 민정호 [CHM-201111442] R9 CNTR 추가관련 로직 변경요청
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception					serverException		= null;			//서버에서 발생한 에러
	String						strErrMsg			= "";								 //에러메세지
	String	userId		= "";
	String	ofcCd		= "";

	String optionStr    = "";
	String selIMDG = "";	//Trans Mode Combo
	String selTRANSMODE = "";	//Trans Mode Combo
	String selCARGOMODE = "";	//Cargo Type Combo
	String selRAILSVC   = "";	//Rail Service Combo

	selIMDG	= JSPUtil.getCodeCombo("imdg_cd", "01"	,"style='width:98' disabled", "CD02249", 0, optionStr);
//	selTRANSMODE	= JSPUtil.getCodeCombo("ufm_agmt_trsp_tp_cd", "01"	,"style='width:98' disabled", "CD00283", 0, optionStr);
//	selCARGOMODE	= JSPUtil.getCodeCombo("ufm_cgo_tp_cd",	"01"	,"style='width:98;' disabled", "CD00748", 0, optionStr);
//	selRAILSVC		= JSPUtil.getCodeCombo("ufm_rail_svc_tp_cd",		"01"	,"style='width:136;' disabled", "CD00916", 1, optionStr);

 
	//String effective_date   = ((request.getParameter("effective_date")==null)?"":request.getParameter("effective_date"));	// 추가-민정호
	//String delete_yn   = ((request.getParameter("delete_yn")==null)?"":request.getParameter("delete_yn"));	// 추가-민정호	
	
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
<title>Imdg Class</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  var fm_nod_yd = "";
  function setupPage(){
    loadPage();
    
    var formObject = document.form;
 
    //getComboList(formObject.fm_fm_nod_cd, document.fm_fm_nod_yd, 'F');
    //getComboList(formObject.fm_via_nod_cd, document.fm_via_nod_yd, 'V');
    //getComboList(formObject.fm_dor_nod_cd, document.fm_dor_nod_yd, 'D');
    //getComboList(formObject.fm_to_nod_cd, document.fm_to_nod_yd, 'T');
 
    	    
  }
  
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" >


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td>
      <!-- TABLE (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> IMDG</td></tr>
      </table>
      <!-- TABLE (E) -->
      
      <!--Button (S) -->
 
      <!--Button (E) -->
  
      <div id="MiniLayer" style="display:inline">
      <!--biz page (S)-->
      <table class="height_8"><tr><td></td></tr></table>  
      <!--  biz_1  (S) -->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            <table class="search" border="0" style="width:300;"> 
              <tr class="h23">
                <td width="" valign="top">
                  <table class="search" border="0" style="width:100%;">

                  

                    
                    <tr class="h23">
 
                      <td colspan="2">IMDG Class</td>
                      <td colspan="3">
 
					    <script language="javascript">ComComboObject('imdg_clss_cd', 2, 150, 1, 1);</script>
					    <input type="hidden" name="fm_eqtpsz" value="">                          
                      </td>  
                      </td>
                     
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="50"></td>
              </tr>
              <tr><td></td></tr>
            </table>
          </td>
        </tr>
      </table>
      <!--  biz_1   (E) -->
      </div>
    </td>
  </tr>
</table>

<table class="height_8"><tr><td></td></tr></table>  

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;"> 
  <tr>
    <td>
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">

            <!-- TABLE '#D' : ( Grid ) (S) -->

            <!-- TABLE '#D' : ( Grid ) (E) -->			
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
                      <td class="btn1" name="btng_save">Apply</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>

                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close">Close</td>
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
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<script language="javascript">ComSheetObject('sheet1');</script>
</body>
</html>
