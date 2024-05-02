<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0030.jsp
*@FileTitle : Actual Source Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-31 Seong-mun Kang
* --------------------------------------------------------
* History
* 2013.05.14 김상수 [CHM-201324115] Actual Data Receiving Status 보완요청
*                    - CNTR no 입력후 retrieve 시 다른 조회 조건은 필요하지 않도록 로직 수정
*                    - CNTR No.가 없는 건 (HJCU0000000) 대상에서 제외
*                    - EDI MSG ID, EDI 컬럼을 Service Provider 앞 위치로 이동시키고 그 위치에 VVD 컬럼 추가
*                    - On Time 정렬기능 추가
*                    - Activity 컬럼 앞에 Activity Code 컬럼 추가
* 2013.06.21 김상수 [CHM-201324903] Actual Data Receiving Status 보완요청(추가)
*                    - 조회조건에 다건의 Yard Code 입력 가능하게 수정
=========================================================*/
%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.event.EsdSce0030Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
	EsdSce0030Event  event = null;
	Exception serverException = null;

	String strErrMsg = "";
	DBRowSet rowSet = null;
	int rowCount = 0;
	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	String userId = account.getUsr_id();

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			event = (EsdSce0030Event)request.getAttribute("Event");
		}
	} catch(Exception e) {
		out.println(e.toString());
	}


	int rowSize=100 ;

%>
<html>
<head>
<title>Welcome to NMS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<script>
	function setupPage(){
		loadPage();
	}
</script>

<body onLoad="setupPage();">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>



		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		<form method="post" name="form">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="row_size" value="<%=rowSize%>">

		<input name="nod_cd" type="hidden">
		<input name="cntr_no" type="hidden">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->

		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="25"><input type="radio" name="search_div" class="trans" checked></td>
							<td width="100">Yard</td>
							<td width="210"><input class="input1" name="nod_cd_display" type="text" style="width:138; text-transform:uppercase;" onKeyUp="javascript:this.value=this.value.trim().toUpperCase();chkCharObj(this, jsEng+jsNum+',', true)"> <img class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onclick="openNodePop(true,'nod_cd_display')"></td>
							<td width="76">Activity</td>
							<td width="250">
								<script language="javascript">ComComboObject('act_cd', 2, 80, 1, 1);</script>
							</td>
							<td width="140">Service Provider</td>
							<td colspan="2"><input name="sc_cd" type="text" style="width:138; text-transform:uppercase;"> <img class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onclick="openServiceProviderPop(false, 'sc_cd')"></td>
						</tr>
						<tr class="h23">
							<td>&nbsp;</td>
							<td>RCV Type</td>
							<td>
								<select class="input1" name="act_rcv_tp_cd">
									<option value="MVMT">MVMT</option>
									<option value="VSK">VSL SKD</option>
								</select>
							</td>
							<td>Planned DT</td>
							<td>
								<input class="input1" type="text" style="width:78 ; text-transform:uppercase;" name="act_dt1"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >
								&nbsp;~&nbsp;<input class="input1" type="text" style="width:78 ; text-transform:uppercase;" name="act_dt2"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >
								<img name="btn_calendar" class="cursor" src="img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
							</td>
							<td>Actual Data Receiving</td>
							<td width="50">
								<select class="input" name="actual_receiving" onchange="act_OnChange(this)">
									<option value="Y" selected>Yes</option>
									<option value="N">No</option>
								</select>
							</td>
							<td width="">
								<table border="0">
								<tr>
									<td><img src="img/alps/ico_b1.gif" align="absmiddle"> :
									</td>
									<td><input name="on_time_cnt" type="text" class="transgray" style="width:50px;vertical-align:middle;" readonly>
									</td>
								</tr>
								</table>							</td>
						</tr>
						<tr class="h23">
							<td><input type="radio" name="search_div" class="trans"></td>
							<td>Container No.</td>
							<td><input name="cntr_no_nonbit" type="text" style="width:138px;text-transform:uppercase;" maxlength="10" onBlur='javascript:this.value=this.value.trim().toUpperCase();' onChange="CheckDigitSplit(this,'cntr_no_split', 'cntr_no')" onKeyUp="CheckDigitSplit(this, 'cntr_no_split', 'cntr_no')">&nbsp;<input id="cntr_no_split" type="text" style="width:20" maxlength="2" readonly></td>
							<td>MVMT STS</td>
							<td><%=JSPUtil.getCodeCombo("act_sts_mapg_cd","","style='width:78'","CD00252",0,"000001: :ALL").trim()%></td>
							<td>On Time</td>
							<td>
								<select class="input" name="on_time">
									<option>ALL</option>
									<option value="Y">Yes</option>
									<option value="N" selected>No</option>
								</select>
							</td>
							<td>
								<table border="0">
								<tr>
									<td ><img src="img/alps/ico_r.gif" align="absmiddle"> :
									</td>
									<td><input name="not_on_time_cnt" type="text" class="transgray" style="width:50px;vertical-align:middle;" readonly>
									</td>
								</tr>
								</table>
							</td>
						</tr>
					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
		</td></tr>
		</table>
		</form>
    </td></tr>
</table>
<!-- Outer Table (E)-->
</body>
</html>

