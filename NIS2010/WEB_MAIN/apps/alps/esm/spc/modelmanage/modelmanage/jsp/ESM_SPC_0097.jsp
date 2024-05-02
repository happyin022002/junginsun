<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0097.jsp
*@FileTitle : CMPB Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.01
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.02.01 진마리아
* 1.0 Creation
* 2013.02.01 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
* 2015.02.06 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0097Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EsmSpc0097Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String costYrwk = null;
	String verSeq = null;
	String custLglEngNm = null;
	String scNo = null;
	String rfaNo = null;
	String trdCd = null;
	String subTrdCd = null;
	String rlaneCd = null;
	String slsRgnOfcCd = null;
	String unitCd = null;
	String unitText = null;
	String perfStYrwk = null;
	String perfEndYrwk = null;
	String custCntCd = null;
	String custSeq = null;
	String slsRhqCd = null;
	String scRfaFlg = null;
	
	String perfStYr = null;
	String perfStWk = null;
	String perfEndYr = null;
	String perfEndWk = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.modelmanage.modelmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		costYrwk = JSPUtil.getParameter(request, "cost_yrwk", "");
		verSeq = JSPUtil.getParameter(request, "ver_seq", "");
		custLglEngNm = JSPUtil.getParameter(request, "cust_lgl_eng_nm", "");
		scNo = JSPUtil.getParameter(request, "sc_no", "");
		rfaNo = JSPUtil.getParameter(request, "rfa_no", "");
		trdCd = JSPUtil.getParameter(request, "trd_cd", "");
		subTrdCd = JSPUtil.getParameter(request, "sub_trd_cd", "");
		rlaneCd = JSPUtil.getParameter(request, "rlane_cd", "");
		slsRgnOfcCd = JSPUtil.getParameter(request, "sls_rgn_ofc_cd", "");
		unitCd = JSPUtil.getParameter(request, "unit_cd", "");
		unitText = JSPUtil.getParameter(request, "unit_text", "");
		perfStYrwk = JSPUtil.getParameter(request, "perf_st_yrwk", "");
		perfEndYrwk = JSPUtil.getParameter(request, "perf_end_yrwk", "");
		custCntCd = JSPUtil.getParameter(request, "cust_cnt_cd", "");
		custSeq = JSPUtil.getParameter(request, "cust_seq", "");
		slsRhqCd = JSPUtil.getParameter(request, "sls_rhq_cd", "");
		scRfaFlg = JSPUtil.getParameter(request, "sc_rfa_flg", "");
		
		costYrwk = costYrwk==null?"":costYrwk;
		verSeq = verSeq==null?"":verSeq;
		custLglEngNm = custLglEngNm==null?"":custLglEngNm;
		scNo = scNo==null?"":scNo;
		rfaNo = rfaNo==null?"":rfaNo;
		trdCd = trdCd==null?"":trdCd;
		subTrdCd = subTrdCd==null?"":subTrdCd;
		rlaneCd = rlaneCd==null?"":rlaneCd;
		slsRgnOfcCd = slsRgnOfcCd ==null?"":slsRgnOfcCd;
		unitCd = unitCd==null?"":unitCd;
		unitText = unitText==null?"":unitText;
		perfStYrwk = perfStYrwk==null?"":perfStYrwk;
		perfEndYrwk = perfEndYrwk==null?"":perfEndYrwk;
		custCntCd = custCntCd==null?"":custCntCd;
		custSeq = custSeq==null?"":custSeq;
		slsRhqCd = slsRhqCd==null?"":slsRhqCd;
		
		if ( (trdCd.equals("AES") || trdCd.equals("IAS")) && scRfaFlg.equals("SC") ) {
			scNo = rfaNo;
			rfaNo = "";
		}
		
//		if(!"".equals(perfStYr) && !"".equals(perfEndYr)){
//			perfStYr = perfStYrwk.substring(0,4);
//			perfStWk = perfStYrwk.substring(4,6);
//			perfEndYr = perfEndYrwk.substring(0,4);
//			perfEndWk = perfEndYrwk.substring(4,6);
//		}else{
//			perfStYr = "";
//			perfStWk = "";
//			perfEndYr = "";
//			perfEndWk = "";
//		}
		
		event = (EsmSpc0097Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd	 = event.getSignOnUserAccount().getOfc_cd();
	String ofc_tp_cd = "";
%>

<html>
<head>
<title>CMPB pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

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
<input type="hidden" name="cost_yrwk" value="<%=costYrwk%>">
<input type="hidden" name="ver_seq" value="<%=verSeq%>">
<input type="hidden" name="unit" value="<%=unitCd%>">
<input type="hidden" name="cust_cnt_cd" value="<%=custCntCd%>">
<input type="hidden" name="cust_seq" value="<%=custSeq%>">
<input type="hidden" name="sls_rhq_cd" value="<%=slsRhqCd%>">
<input type="hidden" name="sc_rfa_flg" value="<%=scRfaFlg%>">
<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="700" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     	<table width="700" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CMPB pop-up</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="700" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr><td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

			</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table width="700" class="search" id="searchCondition">
			<tr><td class="bg">
				<table class="search" border="0">
					<tr class="h23">
						<td width="90"><img class="nostar">Week</td>
<!-- 		                <td width="50"><input type="text" name="perf_st_yr" class="input2" style="width:40;text-align:center" value="<%=perfStYr%>" readonly="readonly"></td>
		                <td width="50"><input type="text" name="perf_st_wk" class="input2" style="width:30;text-align:center" value="<%=perfStWk%>" readonly="readonly"></td>
		                <td width="50"><input type="text" name="perf_end_yr" class="input2" style="width:40;text-align:center" value="<%=perfEndYr%>" readonly="readonly"></td>
		                <td width="50"><input type="text" name="perf_end_wk" class="input2" style="width:30;text-align:center" value="<%=perfEndWk%>" readonly="readonly"></td>
 -->
 						<td width="185">
	 						<input type="text" name="perf_st_yrwk" class="input2" style="width:63;text-align:center" value="<%=perfStYrwk%>" readonly="readonly">
	 						&nbsp; ~ &nbsp;
	 						<input type="text" name="perf_end_yr" class="input2" style="width:63;text-align:center" value="<%=perfEndYrwk%>" readonly="readonly">
 						</td>
						<td width="50"><img class="nostar">UNIT</td>
						<td width="105"><input type="text" name="unit_text" class="input2" style="width:40;text-align:center" value="<%=unitText%>" readonly="readonly"></td>
						<td width="85"><img class="nostar">Trade</td>
						<td width="65"><input type="text" name="trd_cd" class="input2" style="width:40;text-align:center" value="<%=trdCd%>" readonly="readonly"></td>
						<td width="50" colspan="2"></td>
					</tr>
			<!-- 	</table>
				<table class="search" border="0" style="width:100%"> --> 
					<tr class="h23">
						<td width="90"><img class="nostar">Account(Individual)</td>
						<td width="185"><input type="text" name="cust_grp_nm" class="input2" style="width:160;text-align:left" value="<%=custLglEngNm%>" readonly="readonly"></td>
<%if(!scNo.equals("")){%>
						<td width="50"><img class="nostar">SC#</td>
						<td width="105"><input type="text" name="sc_no" class="input2" style="width:80;text-align:center" value="<%=scNo%>" readonly="readonly"></td>
<%}else{%>
						<td width="50"><img class="nostar">RFA</td>
						<td width="105"><input type="text" name="rfa_no" class="input2" style="width:80;text-align:center" value="<%=rfaNo%>" readonly="readonly"></td>
<%}%>
<%if(rlaneCd.equals("")){%>
						<td width="85"><img class="nostar">Sub Trade</td>
						<td width="65"><input type="text" name="sub_trd_cd" class="input2" style="width:40;text-align:center" value="<%=subTrdCd%>" readonly="readonly"></td>
						<td width="0"><input type="hidden" name="rlane_cd"></td>
<%}else{%>
						<td width="65"><img class="nostar">Lane</td>
						<td width="85"><input type="text" name="rlane_cd" class="input2" style="width:60;text-align:center" value="<%=rlaneCd%>" readonly="readonly"></td>
						<td width="0"><input type="hidden" name="sub_trd_cd" value="<%=subTrdCd%>"></td>
<%}%>
						<td width="60"><img class="nostar">L.OFC</td>
						<td width="60"><input type="text" name="sls_rgn_ofc_cd" class="input2" style="width:45;text-align:center" value="<%=slsRgnOfcCd%>" readonly="readonly"></td>
					</tr>
				</table>
			</td></tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>
		
		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<table class="height_5"><tr><td></td></tr></table>
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
			</td></tr>
		</table>

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>