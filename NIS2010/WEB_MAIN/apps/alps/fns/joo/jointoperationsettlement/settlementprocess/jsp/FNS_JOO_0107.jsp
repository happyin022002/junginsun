<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0107.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.05.19 민정호
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0107Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 	FnsJoo0107Event  event = null;       //PDTO(Data Transfer Object including Parameters)
  	Exception serverException = null;    //서버에서 발생한 에러
  	String strErrMsg = "";               //에러메세지
  	int rowCount   = 0;                  //DB ResultSet 리스트의 건수

  	String successFlag = "";
  	String codeList = "";
  	String pageRows = "100";

  	String strUsr_id = "";
  	String strUsr_nm = "";
  	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementFinder");
	String crrCdList = "";
	String trdCdList = "";
	String direction = "";
	String trdLaneCrrList = "";	
	String strToyyyyMMdd = "";
	String strToyyyyMM = "";
  try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	strUsr_id = account.getUsr_id();
    	strUsr_nm = account.getUsr_nm();

    	event = (FnsJoo0107Event)request.getAttribute("Event");
    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    	if (serverException != null) {
      		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    	}

    	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		crrCdList      = eventResponse.getETCData("CRR_CD_LIST");
		trdCdList      = eventResponse.getETCData("TRD_CD_LIST");
		trdLaneCrrList = eventResponse.getETCData("TRD_LANE_CRR_LIST");
		strToyyyyMMdd = DateTime.getFormatDate(JSPUtil.getKST("yyyyMMdd"), "yyyyMMdd", "yyyy-MM-dd");		
		strToyyyyMM = DateTime.getFormatDate(JSPUtil.getKST("yyyyMM"), "yyyyMM", "yyyy-MM");
		
  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Each Container</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gUsrId = "<%=strUsr_id%>";
var gUsrNm = "<%=strUsr_nm%>";
var gCrrCd = "<%=crrCdList%>";
var gTrdCd = "<%=trdCdList%>";
var nJoSrcCd = "";
var gTrdLaneCrr = "<%=trdLaneCrrList%>";
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>
<!-- 개발자 작업 -->
<body onLoad="setupPage();">
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- BackEndJob을 위한 Field -->
<input type="hidden" name="key">

      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">						
						<td width="1">&nbsp;</td>
						<td width="170"><script language="javascript">ComComboObject('gubun',1,160,0,0);</script></td>
						<td width="30">Year/Month</td>
						<td width="120"><input type="text" style="width:60" class="input" value="<%=strToyyyyMM%>" maxlength="6" name="rev_yrmon" dataformat="ym" style="text-align:center">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"></td>											
						<td width="37">Trade</td>
						<td width="80"><script language="javascript">ComComboObject('trd_cd',1,55,0,0);</script></td>
						<td width="37">Lane</td>
						<td width="100"><script language="javascript">ComComboObject('rlane_cd',1,80,0,0);</script></td>
						<td width="37">Carrier</td>
						<td width="80"><script language="javascript">ComComboObject('jo_crr_cd',1,55,0,0);</script></td>
						<td width="37">VVD</td>
	                    <td width="100"><input type="text" style="width:80" class="input" maxlength='9' value="" name="vvd_cd" dataformat="engup"></td>
						<td width="37">Direction</td>
						<td width="80"><script language="javascript">ComComboObject('skd_dir_cd', 1, 55, 0,0 );</script></td>
						<td width="37">Rev/Exp</td>
						<td width="80"><script language="javascript">ComComboObject('re_divr_cd', 1, 55, 0,0 );</script></td>						
						<td width="*">&nbsp;</td>
	                    <td></td>
					</tr>
				</table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>

      <table class="height_8"><tr><td colspan="8"></td></tr></table>

      <table class="search">
        <tr>
          <td class="bg"  valign="top">
            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0">
              <tr>
              <td width="100%">
              <script language="javascript">ComSheetObject('sheet1');</script>            
              </td>               
              </tr>
			</table>
			<table width="100%"> 
		       	<tr>
		       	<td>                            	
		            <table width="100%" border="0" > 
		              <tr>
		                <td width="70">Page Size :</td>
		                <td width="90">
		                  <select style="width:80;" class="input" name="pagerows2" onChange="javascript:reset_all();">
		                    <option value="1000">1,000</option>
		                    <option value="5000">5,000</option>
		                    <option value="10000">10,000</option>
		                    <option value="20000">20,000</option>
		                    <option value="30000">30,000</option>
		                    <option value="50000" selected>50,000</option>
		                    <option value="70000">70,000</option>
		                    <option value="100000">100,000</option>
		                    <option value="150000">150,000</option>
		                  </select>
		                </td>              
					    <td align="left" width="20"><img class="cursor" img src="/hanjin/img/bu_prev02.gif" border="0" name="reward"></td>
		                <td align="left" width="45" class="title_s">Page :</td>
		                <td align="left" width="32" valign="bottom"><input type="text"  class="input2" style="width:30; valign:bottom; text-align:right;"  name="tot_page_cnt" value="0"></td>
		                <td align="left" width="38" valign="bottom"><input type="text" style="width:30; valign:bottom; text-align:right"  name="page_no" value="1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
		                <td><img class="cursor" img src="/hanjin/img/bu_next02.gif" border="0" name="forward"></td>		                
					  </tr>	
		            </table>      	
              	</td>              	
              </tr>
            </table>
            <!-- Grid (E) -->        
          </td>
		</tr>
      </table>
      <!-- biz page (E) -->

      <!-- Button (S) -->
<table width="100% " class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
        <tr><td>
            <table border="0">
            <tr><td>           
			</td></tr></table>          
		   </td>		          	
       	<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td> 				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
	</tr>
</table>
      <!-- Button (E) -->      
    </td>
  </tr>
</table>
<!-- 개발자 작업 끝 -->
</form>
</body>
</html>