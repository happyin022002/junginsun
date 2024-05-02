<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4011.jsp
*@FileTitle : Surcharge Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.24 김재연
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.11.18 서미진 [CHM-201114508] Days, Period Type, Period Criteria 정보 조회되도록 컬럼 추가
* 2014.09.01 최성환 [CHM-201431588] Surcharge Inquiry 화면의 surcharge 개정 이력 관리 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.surcharge.surcharge.event.EsmPri4011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri4011Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] svcScpCds = null; 
	String[] chgCd = null; 
	String[] pctBseCd = null;
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
	String[] cntrSzCd = null;
	String[] cnlTzCd = null;
	String[] scgPrdTpCd = null;
	String[] scgPrdCrteCd = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.Surcharge.Surcharge");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri4011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
		chgCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("chgCd"));
		pctBseCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("pctBseCd"), false);
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
		cntrSzCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("cntrSzCd"),true,"|","\t");
		cnlTzCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("cnlTzCd"), false,"|","\t","getCode","getName");
		scgPrdTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scgPrdTpCd"), false,"|","\t","getCode","getName");
		scgPrdCrteCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scgPrdCrteCd"), false,"|","\t","getCode","getName");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Surcharge Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var svcScpComboValue = " |<%=svcScpCds[0]%>";  
    var svcScpComboText = " |<%=svcScpCds[1]%>";
	var chgCdComboValue = " |<%=chgCd[0]%>";
	var chgCdComboText = " |<%=chgCd[1]%>";
	var prcRcvTermCdComboValue = " |<%=prcRcvTermCd[0]%>";
	var prcRcvTermCdComboText = " |<%=prcRcvTermCd[1]%>";
	var prcDeTermCdComboValue = " |<%=prcDeTermCd[0]%>";
	var prcDeTermCdComboText = " |<%=prcDeTermCd[1]%>";
	var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";
	var scgImdgClssCdComboValue = "<%=scgImdgClssCd[0]%>";
	var scgImdgClssCdComboText = "<%=scgImdgClssCd[1]%>";
	var ratUtCdComboValue = " |<%=ratUtCd[0]%>";
	var ratUtCdComboText = " |<%=ratUtCd[1]%>";
	var cntrSzCdComboValue = " |<%=cntrSzCd[0]%>";
	var cntrSzCdComboText = " |<%=cntrSzCd[1]%>";
	
	var pctBseCdComboValue = " |<%=pctBseCd[0]%>"; 
	var pctBseCdComboText = " |<%=pctBseCd[1]%>";
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
	var cnlTzCdValue = " |<%=cnlTzCd[0]%>";
	var cnlTzCdText = " |<%=cnlTzCd[1]%>";

	var scgPrdTpCdValue = " |<%=scgPrdTpCd[0]%>";
	var scgPrdTpCdText = " |<%=scgPrdTpCd[1]%>";
	var scgPrdCrteCdValue = " |<%=scgPrdCrteCd[0]%>";
	var scgPrdCrteCdText = " |<%=scgPrdCrteCd[1]%>";
	
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
<!-- surcharge -->
<input  type="hidden" name="jb_id">
<input  type="hidden"   name="f_excel">

<!-- surcharge -->
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<!-- 개발자 작업	-->
<input type="hidden" name="cd" >
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" > <!-- style="width:979;" -->
				<tr class="h23"><!-- 12개 -->
					<td width="110">&nbsp;&nbsp;SVC Scope</td>
					<td width="100"><script language="javascript">ComComboObject('svc_scp_cd', 2, 80, 0, 0, 0, false);</script></td>
					<td width="80">&nbsp;&nbsp;POR</td>
					<td width="60"><input type="text" name="por_def_cd" maxlength="5" dataformat="uppernum" style="ime-mode:disabled; width:60;"></td> 
					<td width="80">&nbsp;&nbsp;POL</td>
					<td width="60"><input type="text" name="pol_def_cd" maxlength="5" dataformat="uppernum" style="ime-mode:disabled; width:60;"></td>
					<td width="80">&nbsp;&nbsp;POD</td>
					<td width="60"><input type="text" name="pod_def_cd" maxlength="5" dataformat="uppernum" style="ime-mode:disabled; width:60;"></td>
					<td width="80">&nbsp;&nbsp;DEL</td>
					<td width="60"><input type="text" name="del_def_cd" maxlength="5" dataformat="uppernum" style="ime-mode:disabled; width:60;"></td>
					<td width="60">&nbsp;&nbsp;R/D</td> 
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('prc_rcv_term_cd', 1, 50, 0, 0, 0, false);</script>&nbsp;
						<script language="javascript">ComComboObject('prc_de_term_cd', 1, 50, 0, 0, 0, false);</script></td>
					
				</tr>
				<tr class="h23" >
					<td width="">&nbsp;&nbsp;Charge</td>
					<td width=""><script language="javascript">ComComboObject('chg_cd', 2, 80, 0, 0, 0, false);</script></td>
					<td width="">&nbsp;&nbsp;PER Type</td>
					<td width=""style="padding-left:2"><script language="javascript">ComComboObject('rat_ut_cd', 2, 60, 0, 0, 0, false);</script></td>
					<td width="">&nbsp;&nbsp;Size </td>
					<td width=""style="padding-left:2"><script language="javascript">ComComboObject('cntr_sz_cd', 2, 60, 0, 0, 0, false);</script></td>
					
					<td width="">&nbsp;&nbsp;Cargo Type</td>
					<td width=""style="padding-left:2"><script language="javascript">ComComboObject('prc_cgo_tp_cd', 2, 70, 0, 0, 0, false);</script></td>
					<td width="">&nbsp;&nbsp;IMDG Class</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('scg_imdg_clss_cd', 2, 50, 0, 0, 0, false);</script></td>
					
					<td width="" colspan="2"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_loc_grp_pop">Location Group</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
				    </td>
				</tr>
				
				<tr class="h23" align="left">
				    <td width=""><input type="radio" name="rdoDate" value="1" class="trans" checked>&nbsp;Access Date</td>
                    <td width=""><input type="text" style="width:70;text-align:center;" name="access_date" class="input" dataformat="ymd" maxLength="10" minlength="8" caption="Access Date"> <img src="img/btns_calendar.gif" class="cursor" name="btns_calendar3" width="19" height="20" border="0" align="absmiddle"></td>

					<!-- surcharge -->
					<td width=""  ><input type="radio" name="rdoDate" value="2" class="trans" >&nbsp;EFF Date</td>
                    <td width="" colspan="3">
                        <input type="text" class="input1" style="width:70;text-align:center;" name="eff_date_from"  dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                        ~
                        <input type="text" class="input1" style="width:70;text-align:center;" name="eff_date_to"  dataformat="ymd" maxLength="10" minlength="8"> <img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                    </td>
                    <td width="">&nbsp;&nbsp;Update Date</td>
					<td width="" ><input type="text" name="upd_dt" style="width:70;" dataformat="ymd" maxlength="10" caption="Update Date" class="input" required></td>
					<td width="" colspan="2"><input type="checkbox" name="wdr_flg" value="Y" class="trans">Inc. Deleted Data</td>
				</tr>
				
				</table>
				<!--  biz_1   (E) -->
				
				<!--  biz_2  (S) -->
				<!-- Grid  (S) -->
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
				<!-- Grid (E) -->
				
				<!--  biz_2   (E) -->
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve" ID="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
				</table></td>
				<td class="btn1_line"></td>
				    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</table></td>
		
				<!-- surcharge excel download -->
				<td class="btn1_line"></td>
				    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_surcharge_excel">Surcharge Inquiry Down Excel</td>
					<td class="btn1_right"></td>
					</table></td>
		
				
			</tr>
			</table>
		
    <!--Button (E) -->
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>