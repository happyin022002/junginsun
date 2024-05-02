<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0001_004.jsp
*@FileTitle : Origin/Destination Arbitrary Charge Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.17 공백진
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri000104Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>

<%
	EsmPri000104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCArbitraryChargeGuideline");
	String[] currCd = null;
	String[] perCd = null;	
	String[] termOrgCd = null;
	String[] termDesCd = null;
	String[] transCd = null;	
	String[] cargoCd = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri000104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"), false);
        perCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("perCd"), false);
		
        termOrgCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("termOrgCd"), false ,"|","\t","getCode","getName");
        termDesCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("termDesCd"), false ,"|","\t","getCode","getName");
        transCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("transCd"), false ,"|","\t","getCode","getName");
        cargoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cargoCd"), true ,"|","\t","getCode","getName");
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Origin/Destination Arbitrary Charge Guideline Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var currCdComboValue = " |<%=currCd[0]%>";
    var currCdComboText = " |<%=currCd[1]%>";
    var perCdComboValue = " |<%=perCd[0]%>";
    var perCdComboText = " |<%=perCd[1]%>";
    
    var termOrgCdComboValue = " |<%=termOrgCd[0]%>";
    var termOrgCdComboText = " |<%=termOrgCd[1]%>";
    var termDesCdComboValue = " |<%=termDesCd[0]%>";
    var termDesCdComboText = " |<%=termDesCd[1]%>";    
    var transCdComboValue = " |<%=transCd[0]%>";
    var transCdComboText = " |<%=transCd[1]%>";
    var cargoCdComboValue = " |<%=cargoCd[0]%>";
    var cargoCdComboText = " |<%=cargoCd[1]%>";    
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
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
<input type="hidden" name="svc_scp_cd" value="">
<input type="hidden" name="gline_seq" value="">
<input type="hidden" name="org_dest_tp_cd" value="O">
<input type="hidden" name="cd" >
	
		<table class="search"> 
       		<tr><td class="bg">	
			
				<!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_LoadExcel">Load&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
    <!--Button (E) -->
			<table class="search" width="979">
				<tr><td>
				<table class="search_sm2">
					<tr class="h23">
						<td width="40">&nbsp;Type</td>
						<td class="stm">
						<input type="radio" class="trans" name="dest_tp_cd" checked ><span id="dest_tp_cd1">Origin Arbitrary</span>&nbsp;&nbsp;&nbsp;
						<input type="radio" class="trans" name="dest_tp_cd" > <span id="dest_tp_cd2">Destination Arbitrary</span></td>
					</tr>
				</table>
				</td></tr>
			</table>
				
	 		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
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
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Copy">Row&nbsp;Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Del">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
			</td></tr>
		</table>
			
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>