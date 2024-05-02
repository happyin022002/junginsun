<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0015.jsp
*@FileTitle : M&R Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.09 박명신
* 1.0 Creation
*--------------------------------------------------
* History
* 2014-09-25 Chang Young Kim 10만불 비용지급 결재건 3차
* 2014-12-18 Chang Young Kim [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event.EesMnr0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>

<%
	EesMnr0015Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strOfc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.EQFlagMgt");

	String csrGwUrl = "";

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0015Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--MNR 공용 사용 -->
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script language="javascript">ComSheetObject('sheet1');</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="local_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 조회시 인덱스를 테우기 위한 히든값	-->
<input type="hidden" name="agmt_ofc_cty_cd">
<input type="hidden" name="agmt_seq">
<!-- 가변적 TPSZ를 처리하기 위한 히든값 -->
<input type="hidden" name="agmt_type_tpsz">
<!-- 저장시 가변적 VO 타입을 처리하기 위한 히든값 -->
<input type="hidden" name="agmt_display_type">
<input type="hidden" name="agmt_prifix">
<!-- 버젼업상태표시 -->
<input type="hidden" name="isversionup" value="N">

<!-- PARTER 용 히든 -->
<input type="hidden" name="ctrl_ofc_cd" value="<%=strOfc_cd%>">

<input type="hidden" name="csr_gw_url" value="<%=csrGwUrl%>">

<!-- 개발자 작업 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
		<tr><td class="btn1_bg">

			<table border="0" cellpadding="0" cellspacing="0">
			<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
					<td class="btn1" name="btn_del">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_versionup">Version_Up</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
		<!--Button (E) -->


		<!--biz page (S)-->
		<table class="search" id="mainTable" border="0" >
			<tr><td class="bg">


			<table class="search" border="0" style="width:100%;">
			<tr class="h23">
				<td width="100%">

				<!-- biz_1 (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="105">Agreement No.</td>
					<td width="140"><input required tabindex="1" type="text" name="agmt_no" style="width:100;" class = "input1" value = "" dataformat="eng">&nbsp;<img name="btn_agmt_no" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:pointer;cursor:hand"></td>
					<td width="85">Version No.</td>
					<td width="65"><script language="javascript">ComComboObject('agmt_ver_no', 2, 50, 1, 1,0,false,2);</script></td>
					<td width="100">G/W Contract</td>
					<td width="400">
						<input type="text" name="file_atch_flg" style="width:42;" class="input2" value="" readonly>&nbsp;<img name="btns_agmtAtch" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1">
					</td>
					<td width="">&nbsp;</td>
				</tr>
				</table>
				<!-- biz_1 (E) -->

				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<!-- biz_2 (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="105">Service Provider</td>
					<td width="290"><input required tabindex="3" type="text" name="vndr_seq" caption="Service Provider" style="width:55;text-align:left;" class="input1" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vndr" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_nm" caption="Service Provider" style="width:190;" class="input2" value="" readonly></td>
					<td width="100">Currency</td>
					<td width="80" style="padding-left:2"><script language="javascript">ComComboObject('curr_cd', 2, 60, 1, 1,0,false,4);</script></td>
					<td width="120">Agreement Office</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('agmt_ofc_cd', 1, 80, 1, 1);</script></td>
				</tr>
				<tr class="h23">
					<td>Effect Period</td>
					<td class="sm">
					<input required fullfill type="text" name="eff_dt" dataformat="ymd"	class="input1" caption="from date" maxlength="8" style="width:78" cofield="exp_dt" value="">
									~ <input required fullfill type="text" name="exp_dt" dataformat="ymd" class="input1" caption="to date"		maxlength="8" size="10" cofield="eff_dt">&nbsp;<img name="btn_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td>Pay Terms</td>
					<td class="sm"><input required name="pay_term_dys" type="text" style="width:42;text-align:right;" class="input1" value="" maxlength="3" dataformat="int" >&nbsp;days</td>
					<td>AGMT Sign Date</td>
					<td><input required name="agmt_dt" type="text" style="width:79" class="input1" value="" dataformat="ymd" maxlength="8">&nbsp;<img name="btn_calendar1" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td></tr>
				</table>
				<!-- biz_2 (E) -->

				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

				<!-- biz_3 (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="105">Tariff No.</td>
					<td width="290">
					<script language="javascript">ComComboObject('trf_no', 8, 270, 1, 0,0,false,1);</script>
					</td>
					<td width="100">Ref. No.</td>
					<td width=""><input required type="text" maxlength="20" name="agmt_ref_no" style="width:282;" class="input1" value="" dataformat="engup"></td>
				</tr>
				<tr class="h23">
				<td colspan="5">
					<table class="search" border="0" style="width:279;">
					<tr class="h23">
						<td width="105">EQ Type</td>
						<td width="" style="padding-left:2">
						<script language="javascript">ComComboObject('eq_knd_cd',1, 78 , 1,1)</script>
						</td>
					</tr>
					</table>
				</td>
				</tr>
				</table>
				<!-- biz_3 (E) -->
				</td>
				</tr></table>
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

		<!-- grid box (S) -->

		<table class="search" border="0">
		<tr><td valign="top" width="50%">
				<!-- Tab (S) -->
		 	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab (E) -->
				<!--TAB Repair (S) -->
				<div id="tabLayer" style="display:none">
					<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t1sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid (E) -->
					<!-- (Repair)RC형 추가요청 삭제 -->
				</div>

			<!--TAB Repair (E) -->

<!--TAB Cleaning (S) -->

<div id="tabLayer" style="display:none">
	<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>

	<!-- Grid (E) -->
	<!-- Button_Sub (S) -->
	<table width="100%" class="button">
	 	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="">
			&nbsp;
			</td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t2add">Row&nbsp;Add</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t2del">Row&nbsp;Delete</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			</tr></table>
	</td></tr>
	</table>
	<!-- Button_Sub (E) -->
</div>

<!--TAB Cleaning (E) -->



<!--TAB Survery (S) -->

<div id="tabLayer" style="display:none">

	<!-- Grid (S) -->

				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>

	<!-- Grid (E) -->

	<!-- Button_Sub (S) -->
	<table width="100%" class="button">
	 	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="">
			&nbsp;
			</td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t3add">Row&nbsp;Add</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t3del">Row&nbsp;Delete</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			</tr></table>
	</td></tr>
	</table>
	<!-- Button_Sub (E) -->

</div>

<!--TAB Survery (E) -->

<!--TAB Other (S) -->

<div id="tabLayer" style="display:none">

	<!-- Grid (S) -->

				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>

	<!-- Grid (E) -->

	<!-- Button_Sub (S) -->
	<table width="100%" class="button">
	 	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="">
			&nbsp;
			</td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t4add">Row&nbsp;Add</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t4del">Row&nbsp;Delete</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			</tr></table>
	</td></tr>
	</table>
	<!-- Button_Sub (E) -->

</div>

<!--TAB Other (E) -->


<!--TAB Pre-Pre-Maintenance (S) -->
<div id="tabLayer" style="display:none">
<!-- Grid (S) -->

				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t5sheet1');</script>
						</td>
					</tr>
				</table>

				<!-- Button_Sub (S) -->
				<table width="100%" class="button">
				 	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="">
						&nbsp;
						</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t5add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t5del">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>

						</tr></table>
				</td></tr>
				</table>
				<!-- Button_Sub (E) -->
	<!-- Grid (E) -->
</div>
<!--TAB Pre-Maintenance (E) -->


<!--TAB Trie Purchase (S) -->
<div id="tabLayer" style="display:none">
	
	<!-- Grid (S) -->
	<table width="100%" id="mainTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('t6sheet1');</script>
			</td>
		</tr>
	</table>
	<!-- Grid (E) -->

	<!-- Button_Sub (S) -->
	<table width="100%" class="button">
	 	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="">
			&nbsp;
			</td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t6add">Row&nbsp;Add</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t6del">Row&nbsp;Delete</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			</tr></table>
	</td></tr>
	</table>
	<!-- Button_Sub (E) -->
</div>
<!--TAB Trie Purchase (E) -->

<!--TAB PTI (S) -->
<div id="tabLayer" style="display:none">
	
	<!-- Grid (S) -->
	<table width="100%" id="mainTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('t7sheet1');</script>
			</td>
		</tr>
	</table>
	<!-- Button_Sub (S) -->
	<table width="100%" class="button">
		<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="">
			&nbsp;
			</td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t7add">Row&nbsp;Add</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t7del">Row&nbsp;Delete</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			</tr></table>
	</td></tr>
	</table>
	<!-- Button_Sub (E) -->
	<!-- Grid (E) -->
	
</div>
<!--TAB PTI (E) -->


<!--TAB Arrach/Detach (S) -->
<div id="tabLayer" style="display:none">

	<!-- Grid (S) -->
	<table width="100%" id="mainTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('t8sheet1');</script>
			</td>
		</tr>
	</table>
	<!-- Button_Sub (S) -->

	<table width="100%" class="button">
	 	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="">
			&nbsp;
			</td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t8add">Row&nbsp;Add</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_t8del">Row&nbsp;Delete</td>
			<td class="btn2_right"></td>
			</tr>
			</table></td>

			</tr></table>
	</td></tr>
	</table>
	<!-- Button_Sub (E) -->
	<!-- Grid (E) -->
</div>
<!--TAB Arrach/Detach (E) -->
		</td>
		<td valign="top" width="50%" style="padding-top:0px; padding-left:10px;">
		<!-- grid box (S) -->
			<table width="100%" class="search" border="0" style="padding-bottom:4px">
						<tr><td class="title_h"></td>
							<td class="title_s">Cost CTRL Office & Partner Infomation</td>
						</tr>
			</table>
			<table width="100%" id="mainTable">
			<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
			</td>
			</tr>
			</table>
			<!-- Grid (E) -->
			<!-- Button_Sub (S) -->
			<table width="100%" class="button">
			<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_add">Row&nbsp;Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_s1del">Row&nbsp;Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					</tr></table>
			</td></tr>
			</table>
			<!-- Button_Sub (S) -->
		<!-- grid box (S) -->
		</td></tr>
	</table>
	<table class="height_8"><tr><td colspan="8"></td></tr></table>
	<table class="search" border="0">
		<tr class="h23">
			<td width="75">Remark(s)</td>
			<td width=""><textarea name="agmt_rmk" wrap="off" style="width:100%;" rows="3" maxlength="4000"></textarea></td>
		</tr>
	</table>
		<!--biz page (E)-->
	</td></tr>
	</table>
</td></tr>
</table>

<!-- 개발자 작업 끝-->

</form>
</body>
</html>