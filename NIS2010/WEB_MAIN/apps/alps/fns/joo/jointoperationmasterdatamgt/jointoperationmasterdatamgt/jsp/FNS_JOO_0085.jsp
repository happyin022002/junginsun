<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0085.jsp
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0085Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0085Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationMasterDataMgt.JointOperationMasterDataMgt");
	String crrCdList = "";
	String trdCdList = "";
	String ofcCdList = "";
	String joSrcList = "";
	String joSrcNmList = "";
	String joBkgTpList = "";
	String joBkgTpNmList = "";
	String trdLaneCrrList = "";
	String direction = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_locl_nm();


		event = (FnsJoo0085Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		crrCdList      = eventResponse.getETCData("CRR_CD_LIST");
		trdCdList      = eventResponse.getETCData("TRD_CD_LIST");
		ofcCdList	   = eventResponse.getETCData("OFC_CD");
		joSrcList      = eventResponse.getETCData("JO_SRC_CD");
		joSrcNmList    = eventResponse.getETCData("JO_SRC_NM");
		joBkgTpList    = eventResponse.getETCData("JO_BKG_TP_CD");
		joBkgTpNmList  = eventResponse.getETCData("JO_BKG_TP_NM");
		trdLaneCrrList = eventResponse.getETCData("TRD_LANE_CRR_LIST");
		//direction       = JSPUtil.getCodeCombo("sel_bound", "01", "style='width:60'", "CD00714", 0, "");
		
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
var gCrrCd = "<%=crrCdList%>";
var gTrdCd = "<%=trdCdList%>";
var gOfcCd = "<%=ofcCdList%>";
var nJoSrcCd = "";
var gJoSrcCd = ("<%=joSrcList%>").split("|");
var gJoSrcNm = ("<%=joSrcNmList%>").split("|");
var gJoBkgTpCd = ("<%=joBkgTpList%>").split("|");
var gJoBkgTpNm = ("<%=joBkgTpNmList%>").split("|");
var gTrdLaneCrr = "<%=trdLaneCrrList%>";
//alert("<%=direction%>");
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
						<!--td width="65">Ref No</td>
						<td width="200"><script language="javascript">ComComboObject('jo_ref_no', 1, 180, 1, 0,0 );</script></td-->

						<td width="110">Effective Period</td>
						<td width="210">
							From Year&nbsp;<input type="text" style="width:40" class="input" name="agmt_eff_year" maxlength="4">&nbsp;
							Month&nbsp;<input type="text" style="width:20" class="input" name="agmt_eff_mon" maxlength="2">
						</td>
						<td width="40">Office</td>
						<td width="110"><script language="javascript">ComComboObject('ofc_cd', 1, 80, 0,0 );</script></td>
						<td width="55">Rev/Exp</td>
						<td width="115"><script language="javascript">ComComboObject('re_divr_cd', 1, 80, 0,0 );</script></td>
						<td width="65">Del</td>
						<td width=""><script language="javascript">ComComboObject('delt_flg',1,55,0,0);</script></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="110">Carrier</td>
						<td width="210"><script language="javascript">ComComboObject('jo_crr_cd',1,55,0,0);</script></td>
						<td width="40">Trade</td>
						<td width="110"><script language="javascript">ComComboObject('trd_cd',1,55,0,0);</script></td>
						<td width="55">Lane</td>
						<td width="115"><script language="javascript">ComComboObject('rlane_cd',1,80,0,0);</script></td>
						<td width="65">Direction</td>
						<td width=""><script language="javascript">ComComboObject('skd_dir_cd', 1, 55, 0,0 );</script></td>
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
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_copy" name="btns_copy" auth="C">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_add" name="btns_add" auth="C">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btns_insert" name="btns_insert" auth="C">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
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