<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4016.jsp
*@FileTitle : Upload Excel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.13 김재연
* 1.0 Creation
=========================================================
* History 
* 2012.03.19 서미진 [CHM-201216863] PSA Group 추가    
* 2013.03.07 전윤주 [CHM-201323465] Surcharge Creation / Inquiry 에서 RF Condition 항목 추가
* 2013.10.01 전윤주 [CHM-201326927] MDM rating flag와 연계하여 Auto 항목 추가
* 2013.10.01 전윤주 [CHM-201326929] BL Printing시 숨길 수 있는 Hide 항목 추가     
* 2014.03.20 전윤주 [CHM-201429456] Food Grade 항목 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.surcharge.surcharge.event.EsmPri4016Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>

<%
	EsmPri4016Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Surcharge.Surcharge");
	
	//부모창에서 넘어온 파라미터
	String trdCd		= JSPUtil.getNull(request.getParameter("trd_cd"));
	String svcScpCd		= JSPUtil.getNull(request.getParameter("svc_scp_cd"));
	String chgCd		= JSPUtil.getNull(request.getParameter("chg_cd"));
	String fltPctTpCd	= JSPUtil.getNull(request.getParameter("flt_pct_tp_cd"));
	String pctBseCd		= JSPUtil.getNull(request.getParameter("pct_bse_cd"));
	
	String[] scgImdgClssCd = null;
	String[] orgTrspModCd = null;
	String[] destTrspModCd = null;
	String[] usaSvcModCd = null;
	String[] prcRcvTermCd = null;
	String[] prcDeTermCd = null;
	String[] prcHngrBarTpCd = null;
	String[] payTermCd = null;
	String[] ratUtCd = null;
	String[] prcCgoTpCd = null;
	String[] currCd = null;
	String[] dirCallFlg = null;
	String[] socFlg = null;
	String[] ioGaCd = null;
	String[] subTrdCd = null;
	String[] psaCd = null;
	String[] rfCondCd = null;
	String templateKey = null;
	String[] actRatFlg = null; 
	String[] fdGrdFlg = null; 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri4016Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		scgImdgClssCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scgImdgClssCd"),true,"|","\t","getCode","getName");
		orgTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("orgTrspModCd"), false,"|","\t","getCode","getName");
		destTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("destTrspModCd"), false,"|","\t","getCode","getName");
		usaSvcModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("usaSvcModCd"), false,"|","\t","getCode","getName");
		prcRcvTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcRcvTermCd"), false,"|","\t","getCode","getName");
		prcDeTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcDeTermCd"), false,"|","\t","getCode","getName");
		prcHngrBarTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcHngrBarTpCd"), false,"|","\t","getCode","getName");
		payTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("payTermCd"), false,"|","\t","getCode","getName");
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
		prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"), false,"|","\t");
		dirCallFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dirCallFlg"), false,"|","\t","getCode","getName");
		socFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("socFlg"), false,"|","\t","getCode","getName");
		ioGaCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ioGaCd"), false,"|","\t","getCode","getName");
		subTrdCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("subTrdCd"), true,"|","\t");
		psaCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("psaCd"), false);  
		rfCondCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("rfCondCd"), true,"|","\t","getCode","getName"); 
		actRatFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("actRatFlg"), false,"|","\t","getCode","getName");
		fdGrdFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("fdGrdFlg"), false,"|","\t","getCode","getName");
		// Excel Template File Key
	    templateKey = (String)eventResponse.getCustomData("templateKey");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Surcharge Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var scgImdgClssCdComboValue = "<%=scgImdgClssCd[0]%>";
	var scgImdgClssCdComboText = "<%=scgImdgClssCd[1]%>";
	var orgTrspModCdValue = " |<%=orgTrspModCd[0]%>";
	var orgTrspModCdText = " |<%=orgTrspModCd[1]%>";
	var destTrspModCdValue = " |<%=destTrspModCd[0]%>";
	var destTrspModCdText = " |<%=destTrspModCd[1]%>";
	var usaSvcModCdValue = " |<%=usaSvcModCd[0]%>";
	var usaSvcModCdText = " |<%=usaSvcModCd[1]%>";
	var prcRcvTermCdValue = " |<%=prcRcvTermCd[0]%>";
	var prcRcvTermCdText = " |<%=prcRcvTermCd[1]%>";
	var prcDeTermCdValue = " |<%=prcDeTermCd[0]%>";
	var prcDeTermCdText = " |<%=prcDeTermCd[1]%>";
	var prcHngrBarTpCdValue = " |<%=prcHngrBarTpCd[0]%>";
	var prcHngrBarTpCdText = " |<%=prcHngrBarTpCd[1]%>";
	var payTermCdValue = " |<%=payTermCd[0]%>";
	var payTermCdText = " |<%=payTermCd[1]%>";
	var ratUtCdValue = " |<%=ratUtCd[0]%>";
	var ratUtCdText = " |<%=ratUtCd[1]%>";
	var prcCgoTpCdValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdText = " |<%=prcCgoTpCd[1]%>";
	var scgImdgClssCdValue = " |<%=scgImdgClssCd[0]%>";
	var scgImdgClssCdText = " |<%=scgImdgClssCd[1]%>";
	var currCdValue = " |<%=currCd[0]%>";
	var currCdText = " |<%=currCd[1]%>";
	var dirCallFlgValue = "<%=dirCallFlg[0]%>";
	var dirCallFlgText = "<%=dirCallFlg[1]%>";
	var socFlgValue = "<%=socFlg[0]%>";
	var socFlgText = "<%=socFlg[1]%>";
	var ioGaCdValue = "<%=ioGaCd[0]%>";
	var ioGaCdText = "<%=ioGaCd[1]%>";
	var subTrdCdValue = " |<%=subTrdCd[0]%>";
	var subTrdCdText = " |<%=subTrdCd[1]%>";
	var psaCdValue = " |<%=psaCd[0]%>";                                                                                                                                                                                                                                                           
	var psaCdText = " |<%=psaCd[1]%>";   
	var rfCondCdValue = " |<%=rfCondCd[0]%>";                                                                                                                                                                                                                                                           
	var rfCondCdText = " |<%=rfCondCd[1]%>";  
	var actRatFlgValue = " |<%=actRatFlg[0]%>";                                                                                                                                                                                                                                                         
	var actRatFlgText = " |<%=actRatFlg[1]%>";
	var fdGrdFlgValue = " |<%=fdGrdFlg[0]%>";                                                                                                                                                                                                                                                         
	var fdGrdFlgText = " |<%=fdGrdFlg[1]%>"; 
	
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
<input type="hidden" name="cd" >
<input type="hidden" name="trd_cd" value="<%=trdCd%>">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="chg_cd" value="<%=chgCd%>">
<input type="hidden" name="flt_pct_tp_cd" value="<%=fltPctTpCd%>">
<input type="hidden" name="pct_bse_cd" value="<%=pctBseCd%>">
<table width="800" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Surcharge Creation - Load Excel</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 		<table class="search"> 
     		<tr><td class="bg">
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 
				<table width="100%"  id="mainTable" style="display:none"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
				</table>
				<table width="100%"  id="mainTable" style="display:none"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
				</table> 
				<!-- : ( Grid ) (E) -->	
			</td></tr>
		</table>
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_template">Template</td>
					<td class="btn1_right"></td></tr>
					</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_openfile">Open&nbsp;File</td>
					<td class="btn1_right"></td>
					</table></td>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_check">Check</td>
					<td class="btn1_right">
				</table></td>
				    
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</table></td>
			<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
<form name="downform" action="/hanjin/FileDownload" method="post" target="downifm">
	<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
<iframe name="downifm" style="display:none;"></iframe>
</body>
</html>