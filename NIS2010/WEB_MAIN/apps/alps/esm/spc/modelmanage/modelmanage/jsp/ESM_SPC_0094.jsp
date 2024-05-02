<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0094.jsp
*@FileTitle : Yield Group Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.12.02 진마리아
* 1.0 Creation
*
* History
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0094Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EsmSpc0094Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String costYrwk = null;
	String verSeq = null;
	String trdCd = null;
	String week = null;
	String season = null;
	String inquiryPopup = "N";
	String smpMainPopup = "N";
	
	Logger log = Logger.getLogger("com.hanjin.apps.modelmanage.modelmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		costYrwk = JSPUtil.getParameter(request, "cost_yrwk", "");//season
		trdCd = JSPUtil.getParameter(request, "trd_cd", "");
		week = JSPUtil.getParameter(request, "yrwk", "");//조회하고자 하는 주차
		
		// 0090 전용
		season = JSPUtil.getParameter(request, "cost_yrwk", "");
		smpMainPopup = JSPUtil.getParameter(request, "smp_main_popup", "");

		costYrwk = costYrwk==null?"":costYrwk;
		trdCd = trdCd==null?"":trdCd;
		week = week==null?"":week;
		
		if ( "Y".equals(smpMainPopup) ) {
			smpMainPopup = "Y";
		} else if(!"".equals(trdCd)){
			inquiryPopup = "Y";
		}
		event = (EsmSpc0094Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd	 = event.getSignOnUserAccount().getOfc_cd();
	String ofc_tp_cd = "";
%>

<html>
<head>
<title>Yield Group</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="inquiryPopup" value="<%=inquiryPopup%>">
<input type="hidden" name="smpMainPopup" value="<%=smpMainPopup%>">
<input type="hidden" name="season" value="<%=season%>">
<input type="hidden" name="week" value="<%=week%>">
<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="450" border="0" cellpadding="0" cellspacing="0" class="bodypadding" style="padding-top:2;padding-left:5;padding-right:5;">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<%if(!"".equals(trdCd)){ %>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Yield Group Inquiry</td></tr>
<%}else{ %>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Yield Group Setting</td></tr>
<%} %>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

<%if(!"".equals(trdCd)){ %>
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table width="100%" class="search" id="searchCondition">
			<tr><td class="bg">
				<table class="search" border="0">
					<tr class="h23">
						<td width="65"><img class="nostar">Trade</td>
						<td width="100"><input type="text" name="trd_cd" class="input2" style="width:60;text-align:center" value="<%=trdCd%>" readonly="readonly"></td>
						<td width="65"><img class="nostar">Season</td>
						<td width="200"><input type="text" name="cost_yrwk" class="input2" style="width:60;text-align:center" value="<%=costYrwk%>" readonly="readonly"></td>
					</tr>
				</table>
			</td></tr>
		</table>
<%}%>

		<table class="height_10"><tr><td></td></tr></table>
		
		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
<%if( "".equals(trdCd) || "Y".equals(smpMainPopup) ){ %>
       			<table width="100%" class="button">
					<tr>
						<td>
							<table border="0" width="100%" class="button">
								<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btn_rowadd" id="btn_rowadd">Row Add</td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td></tr>
							</table>
						</td>
					</tr>
				</table>
<%} %>
				<table class="height_5"><tr><td></td></tr></table>
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
			</td></tr>
		</table>

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- : ( Button : pop ) (S) -->
<table width="450" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
<%if ( "Y".equals(smpMainPopup) ) { %>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_save" id="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
<%} else if ( "".equals(trdCd) ) { %>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_ok" id="btn_ok">OK</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
<%} %>
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

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>