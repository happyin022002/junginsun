<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4025.jsp
*@FileTitle : Charge Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.25 김재연
* 1.0 Creation
========================================================= 
* History                                                                                                                                                                                                                                                                                             
* 2012.07.18 원종규 [CHM-201219118] Charge code inquiry 의 Excel 출력 기능 추가 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.primasterdata.charge.event.EsmPri4025Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri4025Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] repChgCd 		= null;
	String[] frtChgTpCd		= null;
	String[] chgRevTpCd		= null;
	String[] chgAplyTpCd		= null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.PRIMasterData.Charge");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri4025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		repChgCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("repChgCd"), true);
		frtChgTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("frtChgTpCd"),false,"|","\t","getCode","getName");
		chgRevTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("chgRevTpCd"),false,"|","\t","getCode","getName");
		chgAplyTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("chgAplyTpCd"),false,"|","\t","getCode","getName");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Charge Code Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var repChgComboValue = " |<%=repChgCd[0]%>";  
    var repChgComboText = " |<%=repChgCd[1]%>";
    var frtChgTpComboValue = " |<%=frtChgTpCd[0]%>";  
    var frtChgTpComboText = " |<%=frtChgTpCd[1]%>";
    var chgRevTpComboValue = " |<%=chgRevTpCd[0]%>";  
    var chgRevTpComboText = " |<%=chgRevTpCd[1]%>";
    var chgAplyTpComboValue = " |<%=chgAplyTpCd[0]%>";  
    var chgAplyTpComboText = " |<%=chgAplyTpCd[1]%>";
    
    var repChgCdValue = " |<%=repChgCd[0]%>";  
    var repChgCdText = " |<%=repChgCd[1]%>";
    var frtChgTpCdValue = " |<%=frtChgTpCd[0]%>";  
    var frtChgTpCdText = " |<%=frtChgTpCd[1]%>";
    var chgRevTpCdValue = " |<%=chgRevTpCd[0]%>";  
    var chgRevTpCdText = " |<%=chgRevTpCd[1]%>";
    var chgAplyTpCdValue = " |<%=chgAplyTpCd[0]%>";  
    var chgAplyTpCdText = " |<%=chgAplyTpCd[1]%>";
    
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
<!-- 개발자 작업	-->
<input type="hidden" name="cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:;"> 
				<tr class="h23">
					<td width="130">Charge Code </td>
					<td width="200"><input type="text" name="chg_cd" maxlength="3" style="width:70; ime-mode:disabled;" class="input"></td>
					<td width="115">Rep. Charge Code</td>
					<td width="" colspan="3"><script language="javascript">ComComboObject('rep_chg_cd', 2, 70, 0, 1, 0, false);</script></td>
				</tr>
				<tr class="h23">
					<td width="130">Freight/Charge Type</td>
					<td width="200" style="padding-left:2"><script language="javascript">ComComboObject('frt_chg_tp_cd', 1, 180, 1, 1, 0, false);</script></td>
					<td width="115">Revenue Class</td>
					<td width="200"><script language="javascript">ComComboObject('chg_rev_tp_cd', 1, 190, 1, 1, 0, false);</script></td>
					<td width="110">Charge Character</td>
					<td width=""><script language="javascript">ComComboObject('chg_aply_tp_cd', 1, 180, 1, 1, 0, false);</script></td>
				</tr>
				</table>			
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<table width="100%" id="tempTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet0');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
		       	
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr></table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">						
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_downexcel">Down Excel</td>
						<td class="btn1_right"></td>
						</tr></table></td>
					</tr></table>
					
				</td></tr>				
				</table>
	    		<!-- Button_Sub (E) -->
	    					
		</td></tr></table>		
		<!--biz page (E)--> 

</td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>