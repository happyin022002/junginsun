<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0125.jsp
*@FileTitle : Commitment Vol./Ratio
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0
=========================================================
* History
* 2007-03-20 Kim Jong Beom
* 2008.07.23 전윤주 N200807218173 Commercial Base U/C 화면 추가로 125번에서 삭제
* 2009.10.23 김기대 New FrameWork 적용
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2010.10.01 김기종 Ticket ID:CHM-201006017-01[MAS] 아주 노선 선복사용량에 대한 원양으로의 운항 변고정비 배부 로직(약정율) 추가 요청
* 2011.05.26 최성민 [CHM-201006017-01] MAS 약정율 로직 추가 - 신규 생성 테이블로 변경 Month Copy 기능 추가
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0042");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error(e.toString());
    }
%>
<html>
<head>
<title>Commitment BSA/Ratio</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();">

<form method="post" name="form" onKeyDown="keyEnter_loc();" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
          <td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Commitment BSA/Ratio</td>
        </tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!--Button_L (S) -->
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
                      <td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Month_Copy" name="btn_Month_Copy">Month Copy</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>                
                
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td>
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
      <!--Button_L (E) -->

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search" border="0">
			  <tr>
			    <td colspan="8"><script language="javascript">masPeriod();</script></td>
              </tr>
              <tr>
                <td class="line_bluedot" colspan="8"></td>
              </tr>
              <tr class="h23">
                <td width="9%">Trade</td>
                <td width="19%">&nbsp;<script language="javascript">ComComboObject('f_cobtrade',1, 80 , 0 )</script></td>
                <td width="5%">Lane</td>
                <td width="19%"><div id="div_rLane">&nbsp;<script language="javascript">ComComboObject('f_coblane',1, 80 , 0 )</script></div></td>
                <td width="9%">Direction</td>
                <td width="19%">&nbsp;<script language="javascript">ComComboObject('f_cobdir',1, 80 , 0 )</script></td>
                <td width="4%">IOC</td>
                <td>&nbsp;<script language="javascript">ComComboObject('f_cobioc',1, 80 , 0 )</script></td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->

      <table class="height_10"><tr><td></td></tr></table>

      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( POR ) (S) -->
            <table width="100%">
              <tr>
                <td width="100%">
                  <table class="search" border="0">
                    <tr>
                      <td class="title_h"></td>
                      <td class="title_s">T/S Ratio</td>
                      <td align="right" valign="buttom" style="padding-right:2;">
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
                    <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
                  </table>
                  <!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_add" name="btn_add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_Save" name="btn_Save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>		
					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->	
		    	
                </td>
              </tr>
            </table>
            <!-- : ( POR ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
    </td>
  </tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close" id="btn_close">Close</td>
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
    </td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>
