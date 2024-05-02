<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_AOC_3034.jsp
*@FileTitle : Default Currency Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.aoc.common.defaultcurr.event.EsdAoc3034Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdAoc3034Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strRhq_ofc_cd= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strRhq_ofc_cd = ((StringUtil.xssFilter(request.getParameter("rhq_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("rhq_cd")));
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdAoc3034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String transModeCdOut  = JSPUtil.getCodeCombo("f_rhq_cd" , "01", "style='width:120'", "CD00961", 0, "000010:ALL:ALL");
%>
<html>
<head>
<title>Vessel Information inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%=JSPUtil.getIBCodeCombo("f_rhq_cd" , "", "CD00961", 0, "")%>
	<%=BizComUtil.getIBCodeCombo("po_local_curr_cd", "01", "CURR", 2, "")%>
	
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
<input type="hidden" name="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="sel_cnt_cd">
<input type="hidden" name="sel_curr_cd">
<input type="hidden" name="sel_rhq_cd">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    	
	<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">RHQ</td>
					<td width="160">
						<script language="javascript">ComComboObject('rhq_cd', 1, 120, 1);</script>
					</td>	
					<td width="60">Country</td>
					<td width="240">
						<input name="cnt_cd" type="text" dataformat="engupcomma" style="width:150;">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_country">
						<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('Country');">
					</td>
					<td width="100">Currency Code</td>
					<td width="">
						<input name="curr_cd" type="text" dataformat="engupcomma" style="width:150;">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_currency">
						<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('Currency');">
					</td>
				</tr>
				</table>	
				<!-- biz_1  (E) -->
			</td></tr>
		</table>
					
	<table class="height_8"><tr><td></td></tr></table>

<!-- TAB [ Dry ] (S) -->
<div id="tabLayer" style="display:inline">
	<table class="search"> 
	<tr><td class="bg" style="height:416" valign="top">
		<!-- Grid  (S) -->
		<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->
		<!--  Button_Sub (S) -->
		<table width="100%" class="button"> 
       	<tr><td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_save">Save</td>
						<td class="btn2_right"></td>
						</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_row_add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
					</table>
				</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_row_delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
					</table>
				</td>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_down_excel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
					</table>
				</td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!-- Button_Sub (E) -->		
	</td></tr>
	</table>
</div>
<!-- TAB [ Dry ] (E) -->

	</td></tr>
</table>

<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>