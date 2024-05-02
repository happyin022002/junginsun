<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1094.jsp
*@FileTitle : ESM_BKG_1094
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
* 2015.03.12 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1094Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
    EsmBkg1094Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    String pageRows  = "100";
    String strUsr_id = "";
    String strUsr_nm = "";
    String vvdCd = "";
	String crnNo = "";
	String podClptIndSeq = "";
	
    Logger log = Logger.getLogger("CustomsDeclaration.ManifestListDownload");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        vvdCd = StringUtil.xssFilter(request.getParameter("vvd_no"))==null?"":StringUtil.xssFilter(request.getParameter("vvd_no"));
        crnNo = StringUtil.xssFilter(request.getParameter("crn_no"))==null?"":StringUtil.xssFilter(request.getParameter("crn_no"));
        // Add. [CHM-201534307]
        podClptIndSeq = StringUtil.xssFilter(request.getParameter("pod_clpt_ind_seq")) ==null?"":StringUtil.xssFilter(request.getParameter("pod_clpt_ind_seq"));
        
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (EsmBkg1094Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (null != serverException) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>ESM_BKG_1094</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (1 <= errMessage.length) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="err_msg">
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> ROCS - CRN Change</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Grid ) (S) -->
            <table width="100%"  id="mainTable">
              <tr class="h23">
                <td width="150">VVD</td>
                <td width="200"><input name="vvd_cd"  style="ime-mode: disabled" maxlength="13" dataformat="uppernum" type="text" style="width:110;" class="input2" value="<%=vvdCd %>" readonly></td>
              </tr>
              <tr class="h23">
                <td width="150">POD / Calling</td>
                <td width="200"><input name="pod_cd"  style="ime-mode: disabled" maxlength="13" dataformat="uppernum" type="text" style="width:65;" class="input2" value="NLRTM" readonly>
              	<input name="pod_clpt_ind_seq"  style="ime-mode: disabled" maxlength="13" dataformat="uppernum" type="text" style="width:40;" class="input2" value="<%=podClptIndSeq %>" readonly></td>
              </tr>
              <tr class="h23">
                <td width="150">Current CRN</td>
                <td width="200"><input name="vsl_call_ref_no_old"  style="ime-mode: disabled" maxlength="13" dataformat="uppernum" type="text" style="width:110;" class="input2" value="<%=crnNo %>" readonly></td>
              </tr>
              <tr class="h23">
                <td width="150">New CRN</td>
                <td width="200"><input name="vsl_call_ref_no_new"  style="ime-mode: disabled" maxlength="13" dataformat="uppernum" type="text" style="width:110;" class="input1" value=""></td>
              </tr>
            <table width="100%"  id="mainTable" style="display:none">
              <tr><td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
            </table>
            <!-- : ( Grid ) (E) -->
          </td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) -->
      <table class="height_5"><tr><td></td></tr></table>
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
                <td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">SAVE</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
                    <td class="btn1_line"></td>
                <td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
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
