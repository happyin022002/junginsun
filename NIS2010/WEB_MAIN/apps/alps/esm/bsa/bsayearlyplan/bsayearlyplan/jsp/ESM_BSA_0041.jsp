<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0041.jsp
*@FileTitle : BSA Creation/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.25
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.25 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.25 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.04.14 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
* 2011.04.15 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가  - BSA I/F 버튼 추가
* 2011.07.18 이행지 [CHM-201112101-01] Currency 항목 추가
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap" %> 
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0041Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 

<%
    //DBRowSet rowSet = null;
    DBRowSet[] rowSet = new DBRowSet[2];
    EsmBsa0041Event event = null;
    Exception serverException = null;
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bsa.ESM_BSA_0041");
    String strErrMsg = "";
    String xml = "";

    List<SearchBsaCrrRgstListVO> list = null;
    SearchBsaCrrRgstListVO vo = null;
    String bsa_op_jb_cd = "";
    String bsa_op_jb_nm = "";
    String crr_cd = "";
    String bsaOpJbCd = "";
    int head_cnt = 0;
    String  headSet = "";
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String userId   = "";
    String userName = "";

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        //추가----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        //userAuth=account.getAuth();
        userName  = account.getUsr_nm();

        event = (EsmBsa0041Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
            CommonBsaRsVO commonVO = (CommonBsaRsVO)(eventResponse.getCustomData("rtnVo"));         
            list = (List<SearchBsaCrrRgstListVO>) commonVO.getResultVOList();
            headSet = commonVO.getStrTemp();
            rowCount = list.size();
            
    
            for(int j=0; j<rowCount; j++){
                vo = (SearchBsaCrrRgstListVO) list.get(j);
                bsa_op_jb_cd = bsa_op_jb_cd + "|" + vo.getBsaOpJbCd();
                if(vo.getBsaOpJbCd().equals("001")){
                    bsa_op_jb_nm = bsa_op_jb_nm + "|" + vo.getBsaOpJbNm();;
                } else {
                    bsa_op_jb_nm = bsa_op_jb_nm + "|" + vo.getBsaOpJbNm();
                }
                crr_cd       = crr_cd       + "|" + vo.getCrrCd();
                    
            }
        } // end else
        //추가----------------------------------------------------------------------------------------- END

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>

<html>
<head>
<title>Inquire/Edit BSA Table</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage("<%=bsa_op_jb_nm%>","<%=crr_cd%>","<%=headSet%>");
        document.form.txtSDate.focus();
    }
</script>
</head>

<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<input type="hidden" name="head_cnt"     value="<%=head_cnt%>">
<input type="hidden" name="bsa_op_jb_cd" value="<%=bsa_op_jb_cd%>">
<input type="hidden" name="bsa_op_jb_nm" value="<%=bsa_op_jb_nm%>">
<input type="hidden" name="crr_cd"       value="<%=crr_cd%>">
<input type="hidden" name="header2"      value="<%=headSet%>">
<input type="hidden" name="bsa_op_jb_cd_len" value=""> <!-- ALPS 변환중 추가 -->
<input type="hidden" name="crr_cd_len" value=""> <!-- ALPS 변환중 추가 -->
<input type="hidden" name="sXml"          value="<%=xml%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>

      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="history">
            <img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span>
          </td>
        </tr>
        <tr>
          <td class="title">
            <img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span>
          </td>
        </tr>
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
      <table class="search" border = '0'>
        <tr>
          <td class="bg">
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="55" style="text-indent:7;">Period</td>
                <td width="230">
                  <input class="input1" type="text" dataformat="ymd" name="txtSDate" style="width:75;text-align:center;ime-mode:disabled;" maxlength="8" 
                         onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');" 
                         OnBeforeDeactivate="ComAddSeparator(this);"  
                         OnBeforeActivate="ComClearSeparator(this);">
                  <img name="btns_calendar1" src="/hanjin/img/button/btns_calendar.gif" class="cursor"
                       width="19" height="20" border="0" align="absmiddle">
                  &nbsp;~&nbsp;
                  <input class="" type="text" dataformat="ymd"  name="txtEDate" style="width:75;text-align:center;ime-mode:disabled;" maxlength="8"
                         onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');" 
                         OnBeforeDeactivate="ComAddSeparator(this);"  
                         OnBeforeActivate="ComClearSeparator(this);">
                  <img name="btns_calendar2" src="/hanjin/img/button/btns_calendar.gif" class="cursor"
                       width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="150" class="stm">(ETD of 1st Port)</td>

                                
                <td>Carriers with BSA only&nbsp;<input type="checkbox" name="isExcludZero" value="1" class="trans"></td>
              </tr>
            </table>
            <table class="search_in" border="0">
              <tr><td class="line_bluedot"></td></tr>
            </table>
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="50" style="text-indent:7;">Trade</td>
                <td width="120"><script language="javascript">ComComboObject('cobTrade', 1, 100 , 0 )</script></td>

                <td width="40" style="text-indent:7;">Lane</td>
                <td width="130"><div id="div_rLane"><script language="javascript">ComComboObject('cobLane', 1, 100 , 0 )</script></div></td>

                <td width="30" style="text-indent:7;">Dir.</td>
                <td width="100"><script language="javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
                <td width="40" style="text-indent:7;">Curr.</td>
                <td width="100"><script language="javascript">ComComboObject('cobCurr', 1, 80 , 0 )</script></td>
                <td width="150"></td>
              </tr>
            </table>
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
            <table width="100%" border="0">
              <tr height="12">
                <td width="100%" align="right" valign="bottom" style="padding-right:1;">
                  <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
                  <img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
                  </div>
                  <div id="div_zoom_out" style="display:none">
                  <img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
                  </div>
                </td>
             </tr>
             
             <tr class="h23" id="tr_opt" style="display:none" >
               <td colspan="2">
                 <input type="radio" name="rdoType2" value="0" class="trans" onClick="changeSheet(this.value);"  checked>Long Leg  &nbsp;&nbsp;&nbsp;
                 <input type="radio" name="rdoType2" value="1" class="trans" onClick="changeSheet(this.value);">Short Leg &nbsp;&nbsp;&nbsp;
               </td>
             </tr>
             <tr class="h23" id="tr_slot" style="display:inline">
               <td width="100%">
                 <table width="100%" id="mainTable1">
                   <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
                 </table>
               </td>
             </tr>           
           </table>
           <!-- : ( Button : Sub ) (S) -->
           <table width="100%" class="button">
             <tr>
               <td class="btn2_bg">
                 <table border="0" cellpadding="0" cellspacing="0">
                   <tr>
	                 <!-- Repeat Pattern -->
	                 <td>
	                   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                     <tr>
	                       <td class="btn2_left"></td>
	                       <td class="btn2" name="btng_bsaif" id="btng_bsaif">BSA I/F</td>
	                       <td class="btn2_right"></td>
	                     </tr>
	                   </table>
	                 </td>
	                 <td id = "td_rowadd_btn" style="display:none">
	                   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                     <tr>
	                       <td class="btn2_left"></td>
	                       <td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
	                       <td class="btn2_right"></td>
	                     </tr>
	                   </table>
	                 </td>
	                 <td>
	                   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                     <tr>
	                       <td class="btn2_left"></td>
	                       <td class="btn2" name="btng_rowcopy" id="btng_rowcopy">Row Copy</td>
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
           <!-- : ( Button : Sub ) (E) -->
         </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <!-- --------------------------------------------------------------------------------------------------------- -->
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>