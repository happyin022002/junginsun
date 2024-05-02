<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0014.jsp
*@FileTitle : Trend Line Type Inquiry(Pup-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
*
* History
* 2015.04.15 이병훈 [CHM-201534057] Split09-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.fcm.trendline.trendline.event.VopFcm0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	VopFcm0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	String trndLineTpCd          = "";
	
	
	String classList = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.vop.fcm");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		//checkYn = request.getParameter("checkYn");
		trndLineTpCd = request.getParameter("trndLineTpCd");
		
		//checkYn = checkYn==null?"":checkYn;
		//trndLineTpCd = trndLineTpCd==null?"":trndLineTpCd;
		trndLineTpCd = trndLineTpCd==null?"":JSPUtil.replaceForHTML(trndLineTpCd);
		
		event = (VopFcm0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		classList = eventResponse.getETCData("cntr_dzn_capa");
		classList = classList==null?"":classList;

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		if("<%=trndLineTpCd%>" != ""){
		   form.trnd_line_tp_cd.Code = "<%=trndLineTpCd%>";
		   form.trnd_line_tp_cd.Enable = false;
		}
	}
</script>
</head>
<body class="popup_bg" onload="javascript:setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input    type="hidden" name="f_cmd">
<input type="hidden" name="classList" value="<%=classList%>" %>

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="735" border="0">
	<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Trend Line Inquiry(Pop-up)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

				<table class="search" border="0" style="width:735;">
				<tr class="h23">
					<td width="118">Trend Line Type</td>
					<td width="140"><script language="javascript">ComComboObject('trnd_line_tp_cd',1,100,1,1);</script></td>
					<td width="57">Period</td>
					<td width="302">
						<input type="text" style="width:75" name="trnd_line_fm_dt" id="trnd_line_fm_dt" dataformat="ymd" maxlength="8">
						 ~ 
						<input type="text" style="width:75" name="trnd_line_to_dt" id="trnd_line_to_dt" dataformat="ymd" maxlength="8">
						<img class="cursor" src="img/alps/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
					</td>
					<td width="58">Budget</td>
					<td width="60">
						<select id="trnd_line_use_tp_cd" name="trnd_line_use_tp_cd" style="width:50;text-align:center;" class="input1">
							<option value="N">N</option>
							<option value="B">B</option>
						</select>
					</td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:735;">
				<tr class="h23">
					<td width="116">Lane</td>
					<td width="120"><input type="text" style="width:80;ime-mode:disabled" name="vsl_slan_cd" maxlength="3" dataformat="uppernum">
					                <img class="cursor" name="btns_search" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="80">Design Capa</td>
					<!-- <td>&nbsp;<input type="text" style="width:80;ime-mode:disabled" name="vsl_clss_cd" maxlength="3" dataformat="engup"><img class="cursor" name="btn_lane" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td> -->
					<td width="90"><script language="javascript">ComComboObject('vsl_clss_cd',1,80,1,0);</script></td>
					<td width="70"><script language="javascript">ComComboObject('vsl_clss_sub_cd',1,50,1,0);</script></td>
					<td width="47">Vessel</td>
					<td width="94"><input type="text" style="width:60;ime-mode:disabled" name="vsl_cd" maxlength="4" dataformat="uppernum">
					               <img class="cursor" name="btn_vsl_cd" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="58">Bound</td>
					<td width="60"><script language="javascript">ComComboObject('skd_dir_cd',1,50,1,0);</script></td>
				</tr>
				</table>
				
				</td>
			</tr>
		</table>
			<table class="height_8"><tr><td colspan="6"></td></tr></table>	
		<table class="search">
			<tr>
				<td class="bg">		
			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>

				<table width="100%" class="button"> 
		       		<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
							<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
							</table></td>
				</table>

			<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_5"><tr><td></td></tr></table> 
</td></tr>
</table>	
	
<!-- : ( Button : Pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Pop ) (E) -->



</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>
