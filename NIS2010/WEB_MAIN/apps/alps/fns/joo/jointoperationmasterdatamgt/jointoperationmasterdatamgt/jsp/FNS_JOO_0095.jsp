<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0095.jsp
*@FileTitle : Basic Information for Loading Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.23 박희동
* 1.0 Creation
* -------------------------------------------------------
* 2012.04.05 조병연[CHM-201217059-01]
* Title : [ALPS JOO] Estimate VVD Code Check - Current Estimate Cost 0 조회 기능 추가
* 내용 :
* 1. BSA adjustment 칼럼 추가  :
* 기존 통합선복사용실적조회 화면에 있던 BSA adjustment 기능을 Basic Info 화면으로 옮겨, 
* 해당 Lane, Carrier에 일괄적으로 적용 (TEU, WT 분리하여 적용)
* 2. Add Carriers 수정 : 
* Main에서 Lane, Rep. Carrier를 신규로 생성했을 때, Add Carriers로 자동으로 저장되도록 수정
* 3. Bay plan table에서 같은 포트가 2개 이상일 경우, 가장 늦은 ETD에 해당하는 plan의 data를 적용 수정 : 
* 테스트 서버 적용된 사항 미반영 상태. 
* 모든 레인에서 같은 포트가 두 개 이상이라면 마지막에 CALLING 한 포트를 기준으로 해야 함 
* (ALX, BRSSZ & ALW, MXZLO)
* EX. ALX/ HJAA0014E : ETD 2011-10-15 data (현재 ETD 2011-10-03 data 임)
* 4. RF sub alloc 수정 : 
* Basic Info에 입력된 RF sub alloc 을 반영하여, sub alloc 보다 loading 개수가 
* 적은 경우 “0”으로 표기되도록 쿼리 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0095Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0095Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationMasterDataMgt.JointOperationMasterDataMgt");
	
	String crrCdList = "";
	String trdCdList = "";
	String trdLaneCrrList = "";
	String kndCdList = "";
	
	String yyyyMM = JSPUtil.getKST("yyyy-MM");			// KST 시간으로 오늘 시간
	String yyyyMM2 = DateTime.addYears(yyyyMM,-1, "yyyy-MM");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_locl_nm();
		strOfc_cd = account.getOfc_cd();

		event = (FnsJoo0095Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
 		crrCdList      = eventResponse.getETCData("CRR_CD_LIST"); 			//out.println(crrCdList);
		trdCdList      = eventResponse.getETCData("TRD_CD_LIST");			//out.println(trdCdList);
		trdLaneCrrList = eventResponse.getETCData("TRD_LANE_CRR_LIST");		//out.println(trdLaneCrrList);
		kndCdList 	   = eventResponse.getETCData("KND_CD_LIST");			//out.println(kndCdList); 
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Basic Information for Loading Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gUsrId = "<%=strUsr_id%>";
var gUsrNm = "<%=strUsr_nm%>";
var gOfcCd = "<%=strOfc_cd%>";
var gCrrCd = "<%=crrCdList%>";
var gTrdCd = "<%=trdCdList%>";
var gKndCd = "<%=kndCdList%>";
var gDateFrom = "<%=yyyyMM2%>";
var gDateTo = "<%=yyyyMM%>";
var gSaveId = "";
var gTrdLaneCrr = "<%=trdLaneCrrList%>";

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
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">Carrier</td>
						<td width="220" style="padding-left:2"><script language="javascript">ComComboObject('jo_crr_cd',1,61,0,0);</script></td>
						<td width="60">Trade</td>
						<td width="90" style="padding-left:2"><script language="javascript">ComComboObject('trd_cd',1,55,0,0);</script></td>
						<td width="40">Lane</td>
						<td width="130" style="padding-left:2"><script language="javascript">ComComboObject('rlane_cd',1,70,0,0);</script></td>
						<td width="40">VVD</td>
						<td width="110"><input type="text" style="width:80" class="input"  maxlength='9'  caption='VVD' name='vvd_cd' dataformat="engup"></td>
						<td width="60">Rev/Exp</td>
						<td width="" style="padding-left:2"><script language="javascript">ComComboObject('re_divr_cd',1,80,1,0);</script></td>
					</tr>
					<tr class="h23">
						<td width="50">Date</td>
						<!--  <td width="220"><input type="text" style="width:60" class="input" value="<%=yyyyMM2%>" maxlength="6" name="fm_prd1" dataformat="ym" style="text-align:center" cofield = "to_prd2">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;<input type="text" style="width:60" class="input" value="<%=yyyyMM%>"  maxlength="6" name="to_prd2" dataformat="ym" style="text-align:center" cofield = "fm_prd1">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td> -->
						<td width="220"><input type="text" style="width:60" class="input" value="<%=yyyyMM2%>" maxlength="6" name="fm_prd1" dataformat="ym" style="text-align:center">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;<input type="text" style="width:60" class="input" value="<%=yyyyMM%>"  maxlength="6" name="to_prd2" dataformat="ym" style="text-align:center">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
						<td width="60">Settled</td>
						<td width="90"  style="padding-left:2"><script language="javascript">ComComboObject('sttl_cd', 1, 55, 1,0 );</script></td>
						<td width="40">Kind</td>
						<td width="130" style="padding-left:2"><script language="javascript">ComComboObject('jo_cmpn_knd_cd', 1, 100, 1,0 );</script></td>
						<td width="40">Del</td>
						<td width="110" style="padding-left:2"><script language="javascript">ComComboObject('delt_flg',1,55,1,0);</script></td>
					</tr>
				</table>

				<!--  biz_1   (E) -->
				
		  </td></tr>
		  </table>
		  <table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			<!-- Grid  (S) --> 
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 	
			<!-- Grid (E) -->
			</td></tr>
		</table>
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_carriers" name="btns_carriers" auth="C">Add Carriers</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td-->
<!-- 						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_copy" name="btns_copy" auth="C">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td> -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_add" name="btns_add" auth="C">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
<!-- 						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_insert" name="btns_insert" auth="C">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td> -->
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_del" name="btns_del" auth="C">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
		
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
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
		</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table></td></tr></table>
<!-- Copyright (S) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html> 