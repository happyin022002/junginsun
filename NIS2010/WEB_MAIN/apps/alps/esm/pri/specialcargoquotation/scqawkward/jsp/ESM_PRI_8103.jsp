<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_8103.jsp
*@FileTitle : Commodity Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.04.28 김재연
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event.EsmPri8103Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmPri8103Event  event = null;    //PDTO(Data Transfer Object including Parameters)
  Exception serverException   = null; //서버에서 발생한 에러
  String strErrMsg = "";        //에러메세지
  int rowCount   = 0;       //DB ResultSet 리스트의 건수
  
  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id    = "";
  String strUsr_nm    = "";
  Logger log = Logger.getLogger("com.hanjin.apps.specialcargoquotation.scqawkward");
  
  try {
      SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
     
     
    event = (EsmPri8103Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }
    
    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    
  }catch(Exception e) {
    out.println(e.toString());
  }
  
  String cmdtNm = JSPUtil.getNull(request.getParameter("prc_cmdt_def_nm"));
  String commodityCmd = JSPUtil.getNull(request.getParameter("commodity_cmd")); 
  String prcCmdtTpCd = JSPUtil.getNull(request.getParameter("prc_cmdt_tp_cd"));
  String grpCd = JSPUtil.getNull(request.getParameter("grp_cd"));
  String svcScpCd = JSPUtil.getNull(request.getParameter("svc_scp_cd"));
  String glineSeq = JSPUtil.getNull(request.getParameter("gline_seq"));
  String prcCustTpCd = JSPUtil.getNull(request.getParameter("prc_cust_tp_cd"));
  String propNo = JSPUtil.getNull(request.getParameter("prop_no"));
  String amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
  String chgCd = JSPUtil.getNull(request.getParameter("chg_cd"));
  String creOfcCd = JSPUtil.getNull(request.getParameter("cre_ofc_cd"));
  String qttnNo = JSPUtil.getNull(request.getParameter("qttn_no"));
  String qttnVerNo = JSPUtil.getNull(request.getParameter("qttn_ver_no"));
  String multiYn = JSPUtil.getNull(request.getParameter("multi_yn"));
%>
<html>
<head>
<title>Commodity Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->
<input type="hidden" name="commodity_cmd" value="<%=commodityCmd%>">
<input type="hidden" name="prc_cmdt_tp_cd" value="<%=prcCmdtTpCd%>">
<input type="hidden" name="grp_cd" value="<%=grpCd%>">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="gline_seq" value="<%=glineSeq%>">
<input type="hidden" name="prc_cust_tp_cd" value="<%=prcCustTpCd%>">
<input type="hidden" name="prop_no" value="<%=propNo%>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>">
<input type="hidden" name="chg_cd" value="<%=chgCd%>">
<input type="hidden" name="cre_ofc_cd" value="<%=creOfcCd%>">
<input type="hidden" name="qttn_no" value="<%=qttnNo%>">
<input type="hidden" name="qttn_ver_no" value="<%=qttnVerNo%>">
<input type="hidden" name="multi_yn" value="<%=multiYn%>"><!-- TRI GRI에서만 사용됨 -->

<%
    if (!commodityCmd.equals("")) {
%>
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td valign="top">
    <!-- : ( Title ) (S) -->
    <table width="100%" border="0">
    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Commodity Inquiry</td></tr>
    </table>
<%
    } else {
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  
  <tr><td valign="top">
  <!--Page Title, Historical (S)-->
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
    <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
  </table>
  <!--Page Title, Historical (E)-->
<%
    }
%>
    <!-- : ( Title ) (E) -->
    <!--biz page (S)-->
    <table class="search"> 
        <tr><td class="bg">
      <table class="search_sm" border="0" style="display:none; width:380;"> 
        <tr class="h23">
          <td width="30">Type</td>
            <td width="" class="stm">
              <input type="radio" name="radio_type" value="C" class="trans" checked>Commodity&nbsp;&nbsp;
              <input type="radio" name="radio_type" value="R" class="trans">Rep. Commodity&nbsp;&nbsp;
            <input type="radio" name="radio_type" value="G" class="trans">Commodity Group
          </td>
        </tr>
      </table> 
      <!-- Raido Tab [ Commodity ] (S) -->
      <div id="radioLayer1" style="display:none">
      <table class="search" border="0" style="width:560;"> 
        <tr class="h23">
          <td width="40"> &nbsp;&nbsp;Code</td>
            <td width="100"><input type="text" name="cmdt_cd" dataformat="int" maxlength="6" style="width:60;" class="input"></td>
          <td width="80">Description</td>
            <td width=""><input type="text" name="cmdt_nm" value="<%=cmdtNm%>" maxlength="40" style="width:200;ime-mode:disabled" class="input"></td>
        </tr>
        </table> 
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
        <!--grid (S)-->
        <table width="100%"  id="mainTable"> 
          <tr>
            <td width="100%">
              <script language="javascript">ComSheetObject('sheet1');</script>
            </td>
          </tr>
        </table>
        <!--grid (E)-->
        <!--  biz_1   (E) -->
        <!--  Button_Sub (S) -->
      <table width="100%" class="button"> 
          <tr><td class="btn2_bg">
        <table border="0" cellpadding="0" cellspacing="0"><tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td>
            <td class="btn2" name="btn_t1Retrieve" id="btn_t1Retrieve">Retrieve</td>
            <td class="btn2_right"></td>
            </tr>
            </table></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td>
            <td class="btn2" name="btn_t1New">New</td>
            <td class="btn2_right"></td>
            </tr>
            </table></td>
          </tr></table>
      </td></tr>
      </table>
    </div>
    <!-- Raido Tab [ Commodity ] (E) -->
    <!-- Raido Tab [ Rep Commodity ] (S) -->
    <div id="radioLayer2" style="display:none">
      <table class="search" border="0" style="width:560;"> 
        <tr class="h23">
          <td width="40"> &nbsp;&nbsp;Code</td>
            <td width="100"><input type="text" name="rep_cmdt_cd" dataformat="int" minlength="2" maxlength="4" style="width:60;" class="input"></td>
          <td width="80">Description</td>
            <td width=""><input type="text" name="rep_cmdt_nm" dataformat="eng" maxlength="40" style="width:200;" class="input"></td>
        </tr>
        </table> 
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
        <!--grid (S)-->
        <table width="100%"  id="mainTable"> 
          <tr>
            <td width="100%">
              <script language="javascript">ComSheetObject('sheet2');</script>
            </td>
          </tr>
        </table>
        <!--grid (E)-->
        <!--  biz_1   (E) -->
        <!--  Button_Sub (S) -->
      <table width="100%" class="button"> 
          <tr><td class="btn2_bg">
        <table border="0" cellpadding="0" cellspacing="0"><tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td>
            <td class="btn2" name="btn_t2Retrieve" id="btn_t2Retrieve">Retrieve</td>
            <td class="btn2_right"></td>
            </tr>
            </table></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td>
            <td class="btn2" name="btn_t2New">New</td>
            <td class="btn2_right"></td>
            </tr>
            </table></td>
          </tr></table>
      </td></tr>
      </table>
    </div>
    <!-- Raido Tab [ Group.Commodity ] (S) -->
    <div id="radioLayer3" style="display:none">   
      <table class="search" border="0" style="width:560;"> 
        <tr class="h23">
          <td width="45"> &nbsp;&nbsp;Code</td>
            <td width="">
            <script language="javascript">ComComboObject('grp_cmdt_seq', 2, 70, 0, 1, 0, false);</script> <input type="text" name="prc_grp_cmdt_desc" style="width:150;" class="input2" readOnly></td>
        </tr>
        </table> 
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
        <!--grid (S)-->
        <table width="100%"  id="mainTable"> 
          <tr>
            <td width="100%">
              <script language="javascript">ComSheetObject('sheet3');</script>
            </td>
          </tr>
        </table>
        <table width="100%" class="button"> 
              <tr><td class="btn2_bg">
            <table border="0" cellpadding="0" cellspacing="0"><tr>
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr><td class="btn2_left"></td>
              <td class="btn2" name="btn_t3Retrieve" id="btn_t3Retrieve">Retrieve</td>
              <td class="btn2_right"></td>
              </tr>
            </table></td>
          </tr></table>
      </td></tr>
      </table>
        <!-- Button_Sub (E) -->
    </div>
    <!-- Raido Tab [ Group.Commodity ] (E) -->
    </td></tr></table>
    <!--biz page (E)--> 
  </td></tr></table>
<%
    if (!commodityCmd.equals("")) {
%>
  <table class="height_5"><tr><td></td></tr></table>
  <table width="100%" class="sbutton">
  <tr><td height="71" class="popup">
      <!--Button (S) -->  
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
        <table border="0" cellpadding="0" cellspacing="0">
        <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
          <tr><td class="btn1_left"></td>
          <td class="btn1" name="btn_Ok">OK</td>
          <td class="btn1_right"></td>
        </tr></table></td>  
      <td class="btn1_line"></td>   
      <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
          <tr><td class="btn1_left"></td>
          <td class="btn1" name="btn_Close">Close</td>
          <td class="btn1_right"></td>
        </tr></table></td>  
      </tr>
      </table>
      </td>
    </tr></table>
      <!--Button (E) -->
  </td></tr>
  </table>
<%
  }
%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>