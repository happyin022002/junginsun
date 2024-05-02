<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2001_12.jsp
*@FileTitle : Guideline Creation - Arbitrary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.14 김재연
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.event.EsmPri200112Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri200112Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] prcTrspModCd	= null;
	String[] ratUtCd		= null;
	String[] currCd			= null;
	String[] prcCgoTpCd		= null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.rfaguideline.rfaarbitrarychargeguideline");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri200112Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		prcTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcTrspModCd"), false,"|","\t","getCode","getName");
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"),false,"|","\t");
		prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Guideline Creation - Arbitrary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var prcTrspModCdValue = " |<%=prcTrspModCd[0]%>";
	var prcTrspModCdText = " |<%=prcTrspModCd[1]%>";
	var ratUtCdValue = " |<%=ratUtCd[0]%>";
	var ratUtCdText = " |<%=ratUtCd[1]%>";
	var currCdValue = "|<%=currCd[0]%>";
	var currCdText = "|<%=currCd[1]%>";
	var prcCgoTpCdValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdText = " |<%=prcCgoTpCd[1]%>";
	
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
<input type="hidden" name="svc_scp_cd" value="TPE">
<input type="hidden" name="gline_seq" value="0">
<input type="hidden" name="cd" >

<input type="hidden" name="rout_tgt_row" value="">
<input type="hidden" name="bak_dest_tp_cd" value="O">
<input type="hidden" name="add_chg_tp_cd" value="A">

<input type="hidden" name="grp_loc_seq">
<input type="hidden" name="eff_dt">



<table class="search"> 
	<tr><td class="bg">
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    <tr><td class="btn1_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    <tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_save">Save</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_downexcel">Down Excel</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_loadexcel">Load Excel</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		<table class="search_sm2" border="0">
			<tr class="h23">
				<td width="60">&nbsp;&nbsp;Type</td>
				<td class="stm">
					<input type="radio" name="org_dest_tp_cd" value="O" class="trans" checked>&nbsp;<span id="org_dest_tp_cd1">Origin Arbitrary</span>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="org_dest_tp_cd" value="D" class="trans">&nbsp;<span id="org_dest_tp_cd2">Destination Arbitrary</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>
		<!--Grid (s)-->
		<table width="100%" id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		<table width="100%" id="subTable" style="display:none"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table>
		<!--Grid (E)-->
		<!--  Button_Sub (S) -->
		<table width="100%" class="button"> 
    					<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
					</table></td><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowcopy">Row&nbsp;Copy</td>
						<td class="btn2_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
					</table></td>
				</tr></table>
			</td></tr>
		</table>
		<!-- Button_Sub (E) -->
	</td></tr>
	</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
<!--TAB Arbitraty  (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>