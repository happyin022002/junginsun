<%--=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0021.jsp
* @FileTitle : Inquiry/Edit BSA Table
* Open Issues :
* Change history :
* @LastModifyDate : 2006-09-18
* @LastModifier : Kim Jong Beom
* @LastVersion : 1.0
*  2006-09-18 Kim Jong Beom
*  1.0 최초 생성 
*=========================================================
* History :
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2009.08.01 김기대 ENIS ---> ALPS 변환'
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2011.04.04 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
* 2014.06.30 김용습 R4J 패치 사전 작업
* 2015.01.23 김용습 [CHM-201533808] Check Date 버튼 추가
*=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap" %> 
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0021Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 

<%
    //DBRowSet rowSet = null;
    DBRowSet[] rowSet = new DBRowSet[2];
    EsmBsa0021Event event = null;
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bsa.ESM_BSA_0021");
    String strErrMsg = "";
    String xml = "";

    String bsa_op_jb_cd1 = "";
    String bsa_op_jb_nm1 = "";
    String crr_cd1 = "";
    String bsa_op_jb_cd2 = "";
    String bsa_op_jb_nm2 = "";
    String crr_cd2 = "";

	String userId   = "";
	String userName = "";
	
	//2014.06.30 김용습 R4J 패치 사전 작업
	String bsaOpJbCd1 = "";
	String bsaOpJbNm1 = "";
	String crrCd1 = "";
	String bsaOpJbCd2 = "";
	String bsaOpJbNm2 = "";
	String crrCd2 = "";
	StringBuffer out1 = new StringBuffer();
	StringBuffer out2 = new StringBuffer();
	StringBuffer out3 = new StringBuffer();
	StringBuffer out4 = new StringBuffer();
	StringBuffer out5 = new StringBuffer();
	StringBuffer out6 = new StringBuffer();

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        //추가----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        //userAuth=account.getAuth();
        userName  = account.getUsr_nm();

        event = (EsmBsa0021Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	CommonBsaRsVO vo = (CommonBsaRsVO)(eventResponse.getCustomData("rtnVo"));
            	CommonBsaRsVO[] vos = vo.getCommonBsaRsVOArray();

                rowSet[0] = vos[0].getDbRowset();
                rowSet[1] = vos[1].getDbRowset();

                if (rowSet != null) {
                    while (rowSet[0].next()) {
                    	//2014.06.30 김용습 R4J 패치 사전 작업
                        //bsa_op_jb_cd1 = bsa_op_jb_cd1 + "|" + JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_cd"));
                        //bsa_op_jb_nm1 = bsa_op_jb_nm1 + "|" + JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_nm"));
                        //crr_cd1       = crr_cd1       + "|" + JSPUtil.getNull(rowSet[0].getString("crr_cd"));
                    	bsaOpJbCd1 = JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_cd"));
                    	bsaOpJbNm1 = JSPUtil.getNull(rowSet[0].getString("bsa_op_jb_nm"));
                    	crrCd1 = JSPUtil.getNull(rowSet[0].getString("crr_cd"));
                    	
                    	out1.append("|").append(bsaOpJbCd1);
                    	out2.append("|").append(bsaOpJbNm1);
                    	out3.append("|").append(crrCd1);
                        
                    } //end of while
                    bsa_op_jb_cd1 = out1.toString();
                    bsa_op_jb_nm1 = out2.toString();
                    crr_cd1       = out3.toString();

                    while (rowSet[1].next()) {
                    	//2014.06.30 김용습 R4J 패치 사전 작업
                        //bsa_op_jb_cd2 = bsa_op_jb_cd2 + "|" + JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_cd"));
                        //bsa_op_jb_nm2 = bsa_op_jb_nm2 + "|" + JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_nm"));
                        //crr_cd2       = crr_cd2       + "|" + JSPUtil.getNull(rowSet[1].getString("crr_cd"));
                    	bsaOpJbCd2 = JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_cd"));
                    	bsaOpJbNm2 = JSPUtil.getNull(rowSet[1].getString("bsa_op_jb_nm"));
                    	crrCd2 = JSPUtil.getNull(rowSet[1].getString("crr_cd"));
                    	
                    	out4.append("|").append(bsaOpJbCd2);
                    	out5.append("|").append(bsaOpJbNm2);
                    	out6.append("|").append(crrCd2);
                    } //end of while
                    bsa_op_jb_cd2 = out4.toString();
                    bsa_op_jb_nm2 = out5.toString();
                    crr_cd2       = out6.toString();

                } //end of if
            } // end if
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

        loadPage("<%=bsa_op_jb_nm1%>","<%=crr_cd1%>","<%=bsa_op_jb_nm2%>","<%=crr_cd2%>");
        document.form.txtSDate.focus();
    }
</script>
</head>

<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;" onKeyDown="keyEnter_loc();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param1"> <!-- Gubun   |  Method Name  -->
<input type="hidden" name="param2"> <!-- Year    |  vsl_cd       -->
<input type="hidden" name="param3"> <!--         |  skd_voy_no   -->
<input type="hidden" name="param4"> <!--         |  dir_cd       -->
<input type="hidden" name="param5"> <!-- sMonth  |               -->
<input type="hidden" name="param6"> <!-- eMonth  |               -->
<input type="hidden" name="param7"> <!-- sWeek   |               -->
<input type="hidden" name="param8"> <!-- eWeek   |               -->


<input type="hidden" name="bsa_op_jb_cd"  value="<%=bsa_op_jb_cd1%>">
<input type="hidden" name="bsa_op_jb_nm1" value="<%=bsa_op_jb_nm1%>">
<input type="hidden" name="jHeader"       value="<%=crr_cd1%>">
<input type="hidden" name="bsa_op_jb_cd2" value="<%=bsa_op_jb_cd2%>">
<input type="hidden" name="bsa_op_jb_nm2" value="<%=bsa_op_jb_nm2%>">
<input type="hidden" name="sHeader"       value="<%=crr_cd2%>">
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
      <table class="search">
        <tr>
          <td class="bg">
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="55" style="text-indent:7;">Period</td>
                <td width="280">
                  <input class="input1" type="text" name="txtSDate" style="width:75;text-align:center;" maxlength="8"
                         onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-');this.select();" value="">
                  <img name="btns_calendar1" src="/hanjin/img/button/btns_calendar.gif" class="cursor"
                       width="19" height="20" border="0" align="absmiddle">
                  &nbsp;~&nbsp;
                  <input  type="text" name="txtEDate" style="width:75;text-align:center;" maxlength="8"
                          onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
                         onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-'); this.select();" value="" >
                  <img name="btns_calendar2" src="/hanjin/img/button/btns_calendar.gif" class="cursor"
                       width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="150" class="stm">(ETD of 1st Port)</td>
                <td width="40">Trade</td>
                <td width="130"><script language="javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
                <td width="35">Lane</td>
                <td width="130"><script language="javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></td>
                <td width="30">Dir.</td>
                <td><script language="javascript">ComComboObject('cobDir', 1, 60 , 0 )</script></td>
              </tr>
            </table>

            <table class="search_in" border="0">
              <tr>
                <td class="line_bluedot"></td>
              </tr>
            </table>
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="400">
                  <input type="radio" name="rdoOp_cd" value="J" class="trans" checked>Joint Operating&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio" name="rdoOp_cd" value="S" class="trans">Space Chartering
                </td >
                <td width="500">Carriers with BSA only&nbsp;<input type="checkbox" name="isExcludZero" value="1" class="trans">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                	Effective VSL CAPA&nbsp;<input type="checkbox" name="excludVslCapa" value="N" class="trans">
                </td>
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

            <!-- table class="search" border="0" style="width:737;" -->
            <table class="search" border="0" width="100%">
              <tr class="h23">
                <td width="80%">
                  <input type="radio" name="rdoType" value="001" class="trans" checked>Initial BSA &nbsp;&nbsp;&nbsp;
                  <input type="radio" name="rdoType" value="002" class="trans">Basic Leased &nbsp;&nbsp;&nbsp;
                  <input type="radio" name="rdoType" value="003" class="trans">Basic Chartered &nbsp;&nbsp;&nbsp;
                  <input type="radio" name="rdoType" value="004" class="trans">Additional Leased &nbsp;&nbsp;&nbsp;
                  <input type="radio" name="rdoType" value="005" class="trans">Additional Chartered
                </td>
                <td width="20%" align="right" valign="bottom" style="padding-right:3;">
                  <div id="div_zoom_in1" style="display:inline"> <!-- absolute / relative -->
                    <img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
                  </div>
                  <div id="div_zoom_out1" style="display:none">
                    <img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
                  </div>
                  <div id="div_zoom_in2" style="display:none">
                    <img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in2" alt="Zoom in(+)">
                  </div>
                  <div id="div_zoom_out2" style="display:none">
                    <img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out2" alt="Zoom out(-)">
                  </div>
                </td>
              </tr>
            </table>

            <table width="100%">
              <tr>
                <td width="100%">
                  <div id="tabLayer1" style="display:inline">
                    <table width="100%" id="mainTable1">
                      <tr>
                        <td><script language="javascript">ComSheetObject('sheet1');</script></td>
                      </tr>
                    </table>
                  </div>
                  <div id="tabLayer2" style="display:inline">
                    <table width="100%" id="mainTable2">
                      <tr>
                        <td><script language="javascript">ComSheetObject('sheet2');</script></td>
                      </tr>
                    </table>
                  </div>
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
						 <td class="btn2_3" id="btng_checkdate" name="btng_checkdate" title="A cell causing a date period overlap will turn red if you click this button.">Check Date</td>
						 <td class="btn2_right"></td>
						</tr>
					   </table>
					  </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btng_vvdinquiry" id=""btng_vvdinquiry"">VVD Inquiry</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
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
                            <td class="btn2" name="btng_rowdel" id="btng_rowdel">Row Clear</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btng_creation" id="btng_creation">Creation</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btng_crrinfo" id="btng_crrinfo">CRR Info.</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btng_addcrrrgst" id="btng_addcarrgst">Add Carrier</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btng_stepupdownbyport" id="btng_stepupdownbyport">Step Up / Down by Port</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btng_skdinquiry" id="btng_skdinquiry">SKD Inquiry</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <!-- Repeat Pattern -->
                    </tr>
                  </table>
                </td>
              </tr>
              <tr>
					<td width="100%" class="gray_tit" align="left">
						<br>
						* Basic Slots = Basic slot allocation among joint operating carriers
						<br>
						* Basic Lease = Slots leased by SML to other carriers
						<br>
						* Basic Chartered = Slots chartered by SML from other carriers
						<br>
						* Additional Lease = Additional slots leased by SML to other carriers
						<br>
						* Additional Chartered = Additional slots chartered by SML from other carriers						
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
