<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0042.jsp
*@FileTitle : 일당용선료관리
*Open Issues :
*Change history :
* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.10.23 김기대 New FrameWork 적용
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0 
=========================================================
	* History
	* 2012.07.05 이석준 [CHM-201218728-01] Dailyhire by Cht-VSL (PA) Create 기능 추가
	* 2013.05.07 성미영 [SRM-201334889] Dailyhire by Cht-VSL (PA) 전월 copy 기능 추가
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0042");
	String userId = "";
	String ofc_cd = "";
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			userId = account.getUsr_id();
	        ofc_cd = account.getOfc_cd(); //getUserOffice2();
        }
    } catch(Exception e) {
        log.error(e.toString());
    }
%>
<html>
<head>
<title>Dailyhire by Cht-VSL (PA)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
       loadPage();
    }

</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="v_ofc_cd"  value="<%=ofc_cd%>">
<input type="hidden" name="f_cobcost">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>

      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
        </tr>
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


      <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">

            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!--  Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_create" name="btn_create">Create</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>                
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Save" name="btn_Save">Save</td>
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
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="180">
                YYYY-MM <input type="radio" name="f_yrtype" class="trans" value="yrmon" onClick="setYrMon()" checked>&nbsp;&nbsp;
                YYYY-WW <input type="radio" name="f_yrtype" class="trans" value="yrwk">
                </td>
                <td width="75">
                <input type="text" style="width:60" class="input1" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComAddSeparator_Local(this, '-');this.select();" onblur="javascript:fnYearWeekSet(this);">
                </td>
                <td width="180" class="sm"><div id="div_period"></div></td>
                <td width="50">Vessel</td>
                <td width="120"><input type="hidden" name="f_vsl_cd">&nbsp;<script language="javascript">ComComboObject('select1',1, 70 , 0 )</script></td>
                <td width="300">
				  <table id="drd_table" border="0">
                    <tr>
                      <td>
                      <td width="80">Start Month</td>
                      <td width="100">
                      <input type="text" style="width:60" class="input1" name="f_sweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComAddSeparator_Local(this, '-');this.select();" onblur="javascript:fnYearWeekSet(this);">
                      </td>
                      <td width="60">Duration</td>
                      <td width="60"><script language="javascript">ComComboObject('f_dur',1, 50 , 0 )</script></td>
                    </tr>	
                  </table>
                </td>
                <td width="">&nbsp;</td>                
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->

      <table class="height_8"><tr><td></td></tr></table>

      <!-- Tab ) (S) -->
      <table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
        <tr>
          <td width="100%">
            <script language="javascript">ComTabObject('tab1')</script>
          </td>
        </tr>
      </table>

      <div id="tabLayer" style="display:inline">
      <table class="search">
        <tr>
          <td class="bg">
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      </div>
      
      <div id="tabLayer" style="display: none">
      <table class="search" border="0">
        <tr>
          <td class="bg">
<!--             <table class="search_in" border="0"> -->
<!-- 	          <tr class="h23"> -->
<!-- 	            <td width="100">TTL Cost</td> -->
<!-- 	            <td width="250"> -->
<!--                   <input type="text" style="width:200;text-align:right;" name="ttl_amt2" disabled class="input2"> -->
<!--                 </td> -->
<!-- 	            <td width="120">TTL Cost per WK</td> -->
<!-- 	            <td width=""><input type="text" style="width:200;text-align:right;" name="ttl_wk_amt2" value=""  disabled class="input2"></td> -->
<!-- 	          </tr> -->
<!-- 	        </table> -->
<!--             <table class="line_bluedot"><tr><td></td></tr></table> -->
            <input type="hidden" style="width:200;text-align:right;" name="ttl_amt2" disabled class="input2">
	        <input type="hidden" style="width:200;text-align:right;" name="ttl_wk_amt2" disabled class="input2">
            <table width="100%" id="mainTable">
              <tr>
                <td>
                    <script language="javascript">ComSheetObject('t2sheet1');</script>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      </div>            

      <div id="tabLayer" style="display: none">
      <table class="search" border="0">
        <tr>
          <td class="bg">
<!--             <table class="search_in" border="0"> -->
<!-- 	          <tr class="h23"> -->
<!-- 	            <td width="100">TTL Cost</td> -->
<!-- 	            <td width="250"> -->
<!--                   <input type="text" style="width:200;text-align:right;" name="ttl_amt3" disabled class="input2"> -->
<!--                 </td> -->
<!-- 	            <td width="120">TTL Cost per WK</td> -->
<!-- 	            <td width=""><input type="text" style="width:200;text-align:right;" name="ttl_wk_amt3" value=""  disabled class="input2"></td> -->
<!-- 	          </tr> -->
<!-- 	        </table> -->
<!--             <table class="line_bluedot"><tr><td></td></tr></table> -->
            <input type="hidden" style="width:200;text-align:right;" name="ttl_amt3" disabled class="input2">
	        <input type="hidden" style="width:200;text-align:right;" name="ttl_wk_amt3" disabled class="input2">
            <table width="100%" id="mainTable">
              <tr>
                <td>
                    <script language="javascript">ComSheetObject('t3sheet1');</script>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      </div>
      
      <div id="tabLayer" style="display: none">
      <table class="search" border="0">
        <tr>
          <td class="bg">
<!--             <table class="search_in" border="0"> -->
<!-- 	          <tr class="h23"> -->
<!-- 	            <td width="100">TTL Cost</td> -->
<!-- 	            <td width="250"> -->
<!--                   <input type="text" style="width:200;text-align:right;" name="ttl_amt4" disabled class="input2"> -->
<!--                 </td> -->
<!-- 	            <td width="120">TTL Cost per WK</td> -->
<!-- 	            <td width=""><input type="text" style="width:200;text-align:right;" name="ttl_wk_amt4" value=""  disabled class="input2"></td> -->
<!-- 	          </tr> -->
<!-- 	        </table> -->
<!--             <table class="line_bluedot"><tr><td></td></tr></table> -->
            <input type="hidden" style="width:200;text-align:right;" name="ttl_amt4" disabled class="input2">
	        <input type="hidden" style="width:200;text-align:right;" name="ttl_wk_amt4" disabled class="input2">
            <table width="100%" id="mainTable">
              <tr>
                <td>
                    <script language="javascript">ComSheetObject('t4sheet1');</script>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      </div>
      
      <div id="tabLayer" style="display: none">
      <table class="search" border="0">
        <tr>
          <td class="bg">
<!--             <table class="search_in" border="0"> -->
<!-- 	          <tr class="h23"> -->
<!-- 	            <td width="100">TTL Cost</td> -->
<!-- 	            <td width="250"> -->
<!--                   <input type="text" style="width:200;text-align:right;" name="ttl_amt5" disabled class="input2"> -->
<!--                 </td> -->
<!-- 	            <td width="120">TTL Cost per WK</td> -->
<!-- 	            <td width=""><input type="text" style="width:200;text-align:right;" name="ttl_wk_amt5" value=""  disabled class="input2"></td> -->
<!-- 	          </tr> -->
<!-- 	        </table> -->
<!--            <table class="line_bluedot"><tr><td></td></tr></table>	         -->
	        <input type="hidden" style="width:200;text-align:right;" name="ttl_amt5" disabled class="input2">
	        <input type="hidden" style="width:200;text-align:right;" name="ttl_wk_amt5" disabled class="input2">
            <table width="100%" id="mainTable">
              <tr>
                <td>
                    <script language="javascript">ComSheetObject('t5sheet1');</script>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      </div>
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>
