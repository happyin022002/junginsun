<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0067.jsp
*@FileTitle : Guideline Arbitrary - Excel Import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.18 최성민
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri0067Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbKeyVO" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0067Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//부모창에서 넘어온 파라미터
	String svcScpCd		= "";
	String glineSeq		= "";
	String orgDestTpCd		= "";
	
	String[] prcTrspModCd = null;
	String[] rcvDeTermCd = null;
	String[] ratUtCd = null;
	String[] prcCgoTpCd = null;
	String[] currCd = null;	
	
	String templateKey = null;
		
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCArbitraryChargeGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0067Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		//부모창에서 넘어노 파라미터
		RsltPriSgArbKeyVO rsltPriSgArbKeyVO = event.getRsltPriSgArbKeyVO();		
		if(rsltPriSgArbKeyVO != null) {
			glineSeq = rsltPriSgArbKeyVO.getGlineSeq();
			svcScpCd = rsltPriSgArbKeyVO.getSvcScpCd();
			orgDestTpCd = rsltPriSgArbKeyVO.getOrgDestTpCd();
		}

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				
		prcTrspModCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("PRC_TRSP_MOD_CD"), false);
		rcvDeTermCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("RCV_DE_TERM_CD"), false);
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("RAT_UT_CD"), false);
		prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("PRC_CGO_TP_CD"),false);
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("CURR_CD"), false);
	    
		// Excel Template File Key
	    templateKey = (String)eventResponse.getCustomData("templateKey");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Guideline Arbitrary - Excel Import</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var prcTrspModCdComboValue = " |<%=prcTrspModCd[0]%>";  
    var prcTrspModCdComboText = " |<%=prcTrspModCd[1]%>";
	var rcvDeTermCdComboValue = " |<%=rcvDeTermCd[0]%>";
	var rcvDeTermCdComboText = " |<%=rcvDeTermCd[1]%>";
	var ratUtCdComboValue = " |<%=ratUtCd[0]%>"; 
	var ratUtCdComboText = " |<%=ratUtCd[1]%>";
	var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>"; 
	var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";
	var currCdComboValue = " |<%=currCd[0]%>"; 
	var currCdComboText = " |<%=currCd[1]%>";
	
<!--	ComDebug(prcTrspModCdComboValue);-->
<!--	ComDebug(prcTrspModCdComboText);-->
<!--	ComDebug(rcvDeTermCdComboValue);-->
<!--	ComDebug(ratUtCdComboValue);-->
<!--	ComDebug(ratUtCdComboText);-->
<!--	ComDebug(prcCgoTpCdComboValue);-->
<!--	ComDebug(prcCgoTpCdComboText);-->
<!--	ComDebug(currCdComboValue);-->
<!--	ComDebug(currCdComboText);-->
	
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







<!-- 하드코딩 삭제할것 -->



<!-- 개발자 작업	-->
<!-- http://localhost:7001/hanjin/ESM_PRI_0067.do?svc_scp_cd=TPE&gline_seq=3&org_dest_tp_cd=O  로 테스트할것 -->

<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd %>">
<input type="hidden" name="gline_seq" value="<%=glineSeq %>">
<input type="hidden" name="org_dest_tp_cd" value="<%=orgDestTpCd %>">

<input type="hidden" name="cd" >

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Guideline Origin/Destination Arbitrary - Excel Import</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
	
	
				
			<!-- Grid (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->

	<!--biz page (E)-->
	<table class="height_5"><tr><td></td></tr></table>
	
	</td></tr>
</table>
</td></tr>
</table>	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				    <tr><td class="btn1_left"></td>
				    <td class="btn1" name="btn_Template">Template</td>
				    <td class="btn1_right"></td>
				    </tr></table>
			    </td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_file">Open&nbsp;File</td>
					<td class="btn1_right"></td>
					</tr></table>
					</td>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_check">Check</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" >Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td></tr>
		</table>
		</td></tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- Grid (S) -->
	<div style="display:block;">
	<table id="mainTable"> 
		<tr>
			<td>
				<script language="javascript">ComSheetObject('sheet2');</script>
			</td>
		</tr>
	</table>
	</div>
<!-- Grid (E) -->
	

<!-- 개발자 작업  끝 -->
</form>
<form name="downform" action="/hanjin/FileDownload" method="post" target="downifm">
<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
<iframe name="downifm" style="display:none;"></iframe>
</body>
</html>