<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BSA_024.jsp
*@FileTitle : SPC Control J/O Slot 생성/조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006.10.24
*@LastModifier : Park Eun Ju
*@LastVersion : 1.0
*=========================================================
* History :
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2009.08.01 김기대 ENIS ---> ALPS 변환
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2011.04.04 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
*=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0024Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>

<%
    EsmBsa0024Event  event = null;                      //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;                 //서버에서 발생한 에러
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bsa.bsamanage.ESM_BSA_0024");
    String strErrMsg    = "";                           //에러메세지
    String jHeader      = "";
    String sHeader      = "";
    String cobTrade     = "";
    String cobLane      = "";
    String cobDir       = "";
    String trd_cd       = "";
    String rlane_cd     = "";
    String cobOpJob     = "";
    String opJob		= "";

    String userId   = "";
    String userName = "";
    String xml = "";

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        //추가----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        //userAuth=account.getAuth();
        userName  = account.getUsr_nm();

        event = (EsmBsa0024Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	CommonBsaRsVO retVo = (CommonBsaRsVO)eventResponse.getCustomData("retVo");

                jHeader = JSPUtil.getNull(retVo.getStrTemp());
                sHeader = JSPUtil.getNull(retVo.getStrTemp2());
                opJob = retVo.getStrTemp3();

                trd_cd   = JSPUtil.getNull(request.getParameter("selTrade"))==null? "": JSPUtil.getNull(request.getParameter("selTrade"));
                rlane_cd = JSPUtil.getNull(request.getParameter("selRlane"))==null? "": JSPUtil.getNull(request.getParameter("selRlane"));
           } // end if
        } // end else
        //추가----------------------------------------------------------------------------------------- END
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>SPC Control J/O Slot 생성/조회</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){
        var jHeader = "<%=jHeader%>";
        var sHeader = "<%=sHeader%>";
        var errMessage = "<%=strErrMsg%>";

        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage(jHeader, sHeader);

        //document.getElementById("txtSDate").value = "2009-08-01";
        //document.getElementById("txtEDate").value = "2009-08-31";
    }
</script>
</head>


<body onload="javascript:setupPage();document.form.txtSDate.focus();" >
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="jHeader" value="<%=jHeader%>">
<input type="hidden" name="sHeader" value="<%=sHeader%>">
<input type="hidden" name="sXml"    value="<%=xml%>"> 

<input type="hidden" name="param1"> <!--  codeItem     -->
<input type="hidden" name="param2"> <!--  All 유무       -->
<input type="hidden" name="param3"> <!--  Methode Name -->
<input type="hidden" name="param4"> <!--  trd_cd       -->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>

      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

      <!-- TABLE '#D' : ( Button : Main ) (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>

                

                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_save" id="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
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
      <!-- TABLE '#D' : ( Button : Main ) (E) -->
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="60" style="text-indent:7;">Period</td>
                <td width="280">
                    <input class="input1" type="text" style="width:75;text-align:center;" name="txtSDate" maxlength="8" 
                    	   onkeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('LengthNextFocus');" 
                    	   onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" 
                    	   onFocus="ComClearSeparator(this,'ymd','-');this.select();">&nbsp;
                    	   <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;
                    <input type="text" style="width:75;text-align:center;" name="txtEDate" maxlength="8" 
                    	   onkeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('LengthNextFocus');" 
                    	   onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" 
                    	   onFocus="ComClearSeparator(this,'ymd','-'); this.select();">&nbsp;
                    	   <img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
                </td>
                <td width="150" class="stm">(ETD of 1st Port)</td>
                <td width="40">Trade</td>
                <td width="130"><script language="javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
                <td width="35">Lane</td>
                <td width="130"><div id="div_rLane"><script language="javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></div></td>
                <td width="30">Dir.</td>
                <td><script language="javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
              </tr>
            </table>
            <table class="search_in" border="0">
              <tr><td class="line_bluedot"></td></tr>
            </table>
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="350">
                    <input type="radio" class="trans" name="rdoOp_cd" value="J" onClick="changeView('1');" checked>Joint Operating&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" class="trans" name="rdoOp_cd" value="S" onClick="changeView('2');">Space Chartering
                </td>
                <td>
                Carriers with BSA only&nbsp;<input type="checkbox" name="isExcludZero" value="1" class="trans">
                </td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <table class="height_10"><tr><td></td></tr></table>
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( POR ) (S) -->
            <div id="rdoLayer1" style="display:inline">
            <!-- table class="search" border="0" style="width:737;" -->
            <table class="search" border="0" width="100%">
              <tr class="h23">
                <td><div id="div_opjob"></div></td>
                <td align="right" valign="bottom" style="padding-right:2;">
                  <div id="div_zoom_in1" style="display:inline">
                  <img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
                  </div>
                  <div id="div_zoom_out1" style="display:none">
                  <img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
                  </div>
                </td>
              </tr>
            </table>
            <table width="100%" id="mainTable1">
              <tr>
                <td>
                <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            </div>
            <div id="rdoLayer2" style="display:none">
            <table class="search" border="0" width="100%">
              <tr class="h23">
                <td><div id="div_opjob2"></div></td>
                <td align="right" valign="bottom" style="padding-right:2;">
                  <div id="div_zoom_in2" style="display:inline">
                  <img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in2" alt="Zoom in(+)">
                  </div>
                  <div id="div_zoom_out2" style="display:none">
                  <img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out2" alt="Zoom out(-)">
                  </div>
                </td>
              </tr>
            </table>
            <table width="100%" id="mainTable2">
              <tr>
                <td>
                <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
              </tr>
            </table>
            </div>
            <!-- : ( POR ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <table class="height_10"><tr><td></td></tr></table>
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
	var opJob = "<%=opJob%>";
	var arrOpJob = opJob.split("|$$|");
      /*
        ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
      */
    with(document.form) {
        <% if(event != null) {%>
        txtSDate.value 	= "<%= JSPUtil.getNull(request.getParameter("txtFMDate"))==null? "": JSPUtil.getNull(request.getParameter("txtFMDate")) %>";
		txtEDate.value 	= "<%= JSPUtil.getNull(request.getParameter("txtToDate"))==null? "": JSPUtil.getNull(request.getParameter("txtToDate")) %>";
		cobTrade.value  = "<%= JSPUtil.getNull(request.getParameter("selTrade"))==null? "": JSPUtil.getNull(request.getParameter("selTrade"))  %>";
		cobLane.value  	= "<%= JSPUtil.getNull(request.getParameter("selRlane"))==null? "": JSPUtil.getNull(request.getParameter("selRlane"))  %>";
		cobDir.value    = "<%= JSPUtil.getNull(request.getParameter("selDir"))==null? "": JSPUtil.getNull(request.getParameter("selDir"))    %>";
		<% } %>

        var rdoStr1 = "";
        var rdoStr2 = "";
        var rdoCode = arrOpJob[0].split("|");
        var rdoName = arrOpJob[1].split("|");

        for(i=0; i<rdoName.length-1; i++){
            rdoStr1 += "<input type='radio' value='"+rdoCode[i]+"' class='trans' name='rdoOp_jb_cd' onClick=\"chgBsaOpJb('"+rdoCode[i]+"','"+rdoName[i]+"');\">&nbsp;"+rdoName[i]+"&nbsp;&nbsp;&nbsp;&nbsp;";
            rdoStr2 += "<input type='radio' value='"+rdoCode[i]+"' class='trans' name='rdoOp_jb_cd2' onClick=\"chgBsaOpJb('"+rdoCode[i]+"','"+rdoName[i]+"');\">&nbsp;"+rdoName[i]+"&nbsp;&nbsp;&nbsp;&nbsp;";
        }
        div_opjob.innerHTML = rdoStr1;
        div_opjob2.innerHTML = rdoStr2;
        rdoOp_jb_cd[0].checked=true;
        rdoOp_jb_cd2[0].checked=true;
    }
-->
</SCRIPT>