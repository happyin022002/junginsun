<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESM_BKG_0332.jsp
*@FileTitle : ESM_BKG_0332
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation, 2015.06.30 [CHM-201535756] 한국 WHF 면제/조정 기능 간소화
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0332Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
    EsmBkg0332Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    String pageRows  = "100";
    String strUsr_id = "";
    String strUsr_nm = "";
	
    String vvd_no =  "";
    String pod_cd = "";
    String bkg_no = "";
    String bdr_flg = "";
    
    Logger log = Logger.getLogger("CustomsDeclaration.ManifestListDownload");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        
        vvd_no = StringUtil.xssFilter(request.getParameter("vvd_no"))==null?"":StringUtil.xssFilter(request.getParameter("vvd_no"));
        pod_cd = StringUtil.xssFilter(request.getParameter("port_cd"))==null?"":StringUtil.xssFilter(request.getParameter("port_cd"));
        bkg_no = StringUtil.xssFilter(request.getParameter("bkg_no"))==null?"":StringUtil.xssFilter(request.getParameter("bkg_no"));
        bdr_flg = StringUtil.xssFilter(request.getParameter("bdr_flg"))==null?"":StringUtil.xssFilter(request.getParameter("bdr_flg"));
        
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (EsmBkg0332Event)request.getAttribute("Event");
        
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
<title>Re-Calculate WHF(ESM_BKG_0332)</title>
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
<input type="hidden" name="vvd_no" value="<%=vvd_no %>">
<input type="hidden" name="pod_cd" value="<%=pod_cd %>">
<input type="hidden" name="bkg_no" value="<%=bkg_no %>">
<input type="hidden" name="bdr_flg" value="<%=bdr_flg %>">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="rat_ut_cd">
<input type="hidden" name="rat_as_qty">

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Re-Calculate WHF</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Grid ) (S) -->
            <table width="600"  id="mainTable">
            	<tr class="h23">
                	<td width="120" style="text-align:center">R.CBM</td>
                	<td width="40"></td>
                	<td width="120" style="text-align:center">Ton</td>
                	<td width="40"></td>
                	<td width="120" style="text-align:center">Rate</td>
                	<td width="40"></td>
                	<td width="120" style="text-align:center">WHF</td>
                </tr>
            	<tr class="h23">
                	<td width="120"><input name="cbm_amt" id="cbm_amt" style="ime-mode: disabled; text-align:right;" maxlength="10" dataformat="num" type="text" style="width:110;" class="input1" value=""></td>
                	<td width="40" style="text-align:center">or</td>
                	<td width="120"><input name="ton_amt" id="ton_amt" style="ime-mode: disabled; text-align:right;" maxlength="10" dataformat="num" type="text" style="width:110;" class="input1" value="">
              		<td width="40" style="text-align:center">X</td>
                	<td width="120"><input name="chg_ut_amt" id="chg_ut_amt" style="ime-mode: disabled; text-align:right;" maxlength="10" dataformat="num" type="text" style="width:110;" class="input1" value=""></td>
              		<td width="40" style="text-align:center">=</td>
                	<td width="120"><input name="chg_amt" id="chg_amt" style="ime-mode: disabled; text-align:right;" maxlength="18" dataformat="num" type="text" style="width:110;" class="input2" value="" readonly></td>
              	</tr>
            </table>
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
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    	<tr><td class="btn1_left"></td>
                    		<td class="btn1" name="btn_confirm" id="btn_confirm">Confirm</td>
                    		<td class="btn1_right"></td>
                    	</tr>
                    </table>
                </td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    	<tr><td class="btn1_left"></td>
                    		<td class="btn1" name="btn_close" id="btn_close">Close</td>
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
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
