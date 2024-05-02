<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3522.jsp
*@FileTitle : Inland Rates Excel Imports
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.10 최성민
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
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.inlandrates.event.EsmPri3522Event"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3522Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String trfPfxCd 		= "";
	String trfNo 			= "";
	String trfInlndSeq 		= "";
	String amdtSeq 			= "";
	String inlndColNm		= "";
	String updDt			= "";
	String dtlUpdDt			= "";
	
	String[] inlndRtTermCd = null;		  	//Term
	String[] prcRrspModCd = null;		  	//Trans. Mode
	String[] inlndRtLmtWgtUtCd = null;		//Weght Unit
	String[] prcCgoTpCd = null;		    	//Type
	String[] currCd = null;		    		//Currency
	
	Logger log = Logger.getLogger("com.hanjin.apps.Tariff.InlandRates");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3522Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		inlndRtTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("INLND_RT_TERM_CD"), false);
		prcRrspModCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_INLND_RT_TRSP_MOD_CD"), false);
		inlndRtLmtWgtUtCd	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("INLND_RT_LMT_WGT_UT_CD"));
		prcCgoTpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_CGO_TP_CD"), false);
		currCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);
		    
		trfPfxCd 		= JSPUtil.getNull(event.getPriTrfInlndParamVO().getTrfPfxCd());
		trfNo 			= JSPUtil.getNull(event.getPriTrfInlndParamVO().getTrfNo());
		trfInlndSeq		= JSPUtil.getNull(event.getPriTrfInlndParamVO().getTrfInlndSeq());
		amdtSeq			= JSPUtil.getNull(event.getPriTrfInlndParamVO().getAmdtSeq());
		inlndColNm		= JSPUtil.getNull(event.getPriTrfInlndParamVO().getEtc1());
		updDt			= JSPUtil.getNull(event.getPriTrfInlndParamVO().getUpdDt());
		dtlUpdDt		= JSPUtil.getNull(event.getPriTrfInlndParamVO().getEtc2());
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inland Rates Creation &amp; Amendment[Load Excel]</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var inlndRtTermCdComboValue = " |<%=inlndRtTermCd[0]%>";
	var inlndRtTermCdComboText = " |<%=inlndRtTermCd[1]%>";
	
	var prcRrspModCdComboValue = " |<%=prcRrspModCd[0]%>";
	var prcRrspModCdComboText = " |<%=prcRrspModCd[1]%>";
	
	var inlndRtLmtWgtUtCdComboValue = " |<%=inlndRtLmtWgtUtCd[0]%>";
	var inlndRtLmtWgtUtCdComboText = " |<%=inlndRtLmtWgtUtCd[1]%>";
	
	var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";
	
	var currCdComboValue = " |<%=currCd[0]%>";
	var currCdComboText = " |<%=currCd[1]%>";

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
<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd%>">
<input type="hidden" name="trf_no" value="<%=trfNo%>">
<input type="hidden" name="trf_inlnd_seq" value="<%=trfInlndSeq%>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>">
<input type="hidden" name="inlnd_col_nm" value="<%=inlndColNm %>">
<input type="hidden" name="upd_dt" value="<%=updDt %>">
<input type="hidden" name="dtl_upd_dt" value="<%=dtlUpdDt %>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="1000" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Inland Rates Excel Imports</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				<!--Grid (s)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!--Grid (E)-->
		   		<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowadd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowdelete">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
					</table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><!--
		    	
		    	<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				    <tr><td class="btn1_left"></td>
				    <td class="btn1" name="btn_template">Template</td>
				    <td class="btn1_right"></td>
				    </tr></table>
				    </td>
		    	
				--><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name=btn_loadexcel>Open File</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_check">Check</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td class="btn1_line"></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
		</td></tr>
</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>