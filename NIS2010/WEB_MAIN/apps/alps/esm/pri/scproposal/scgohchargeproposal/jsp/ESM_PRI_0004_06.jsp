<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0004_06.jsp
*@FileTitle : S/C Proposal GOH Charge Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.06 김재연
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.event.EsmPri000406Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri000406Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] prcHngrBarTpCd	= null;
	String[] ratUtCd		= null;
	String[] currCd			= null;
	String[] srcInfoCd		= null;
	String[] prcProgStsCd	= null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCGOHChargeProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri000406Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		prcHngrBarTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcHngrBarTpCd"), false,"|","\t","getCode","getName");
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"),false,"|","\t");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoCd"), false,"|","\t","getCode","getName");
		prcProgStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcProgStsCd"), false,"|","\t","getCode","getName");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Proposal GOH Charge Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var prcHngrBarTpCdValue = " |<%=prcHngrBarTpCd[0]%>";
	var prcHngrBarTpCdText = " |<%=prcHngrBarTpCd[1]%>";
	var ratUtCdValue = " |<%=ratUtCd[0]%>";
	var ratUtCdText = " |<%=ratUtCd[1]%>";
	var currCdValue = "|<%=currCd[0]%>";
	var currCdText = "|<%=currCd[1]%>";
	var srcInfoCdValue = "|<%=srcInfoCd[0]%>";
	var srcInfoCdText = "|<%=srcInfoCd[1]%>";
	var PrcProgStsCdValue = "|<%=prcProgStsCd[0]%>";
	var PrcProgStsCdText = "|<%=prcProgStsCd[1]%>";
	
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
<input type="hidden" name="prop_no" value="">
<input type="hidden" name="amdt_seq" value="">
<input type="hidden" name="svc_scp_cd" value="">

<table class="search">
   	<tr>
   		<td class="bg">
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr></table>
		</td></tr>
		</table>
	    <!--Button (E) -->
		<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>