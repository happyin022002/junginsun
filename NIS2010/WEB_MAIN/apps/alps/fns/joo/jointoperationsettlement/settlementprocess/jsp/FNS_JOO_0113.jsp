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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event.FnsJoo0113Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 	FnsJoo0113Event  event = null;       //PDTO(Data Transfer Object including Parameters)
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
	String picList = "";
	String strToyyyyMMdd = "";

  try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	strUsr_id = account.getUsr_id();
    	strUsr_nm = account.getUsr_nm();

    	event = (FnsJoo0113Event)request.getAttribute("Event");
    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    	if (serverException != null) {
      		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    	}

    	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		crrCdList      = eventResponse.getETCData("CRR_CD_LIST");
		trdCdList      = eventResponse.getETCData("TRD_CD_LIST");
		trdLaneCrrList = eventResponse.getETCData("TRD_LANE_CRR_LIST");
		picList = eventResponse.getETCData("PIC_LIST");		
		strToyyyyMMdd = DateTime.getFormatDate(JSPUtil.getKST("yyyyMMdd"), "yyyyMMdd", "yyyy-MM-dd");		

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
var gPicCd = "<%=picList%>";
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
						<td width="37">Trade</td>
						<td width="80"><script language="javascript">ComComboObject('trd_cd',1,55,0,0);</script></td>
						<td width="37">Lane</td>
						<td width="100"><script language="javascript">ComComboObject('rlane_cd',1,80,0,0);</script></td>
						<td width="37">Carrier</td>
						<td width="80"><script language="javascript">ComComboObject('jo_crr_cd',1,55,0,0);</script></td>
						<td width="37">Rev/Exp</td>
						<td width="80"><script language="javascript">ComComboObject('re_divr_cd', 1, 55, 0,0 );</script></td>
						<td width="37">Pic</td>
						<td width="80"><script language="javascript">ComComboObject('pic', 1, 155, 0,0 );</script></td>												
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
            <!-- Grid (E) -->
			<table width="100%"> 
		       	<tr>
		       	<td>
              	</td>        
		        <td>    
		            <table width="100%" border="0" > 
	       				<tr>
		       				<td style="height:14; text-align:right;">
		       				<table border="0" cellpadding="0" cellspacing="0">
		       				<tr>
				                <td>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1_1" name="btn_add"  id="btn_add" auth="C">Row&nbsp;Add</td>
									<td class="btn1_right"></td>
									</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1_1" name="btn_delete"  id="btn_delete" auth="C">Row&nbsp;Delete</td>
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
      <!-- biz page (E) -->

      <!-- Button (S) -->
<table width="100% " class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
        <tr><td>
            <table border="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_multi" id="btn_multi">Multi Creation & Change</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table>
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
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save"  id="btn_save" auth="C">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>					
				<td class="btn1_line"></td>														
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