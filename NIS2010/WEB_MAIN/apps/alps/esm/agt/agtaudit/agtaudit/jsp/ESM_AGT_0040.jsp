<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_AGT_0040.jsp
*@FileTitle : Commission Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.01
*@LastModifier : 박성진
*@LastVersion : 1.1
* 1.0 2009.08.20 추경원 Creation 
* 1.1 2011.04.01 박성진 [CHM-201109284-01][ESM-AGT]Split 06-ALPS의 Location 조회불가건 수정 보완
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event.EsmAgt0040Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmAgt0040Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String[] strItem = null;
	String header = "";
	String col_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofcCd = "";
	String arOfcCd = "";
	String ar_ofc_cd = "";
	String agn_cd = "";
	String cboRptGroup = "";
	String cobTrade =  "";
	String cobLane  = "";
	String cobDir   = "";
	Logger log = Logger.getLogger("com.hanjin.apps.AGTAudit.AGTAudit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofcCd = account.getOfc_cd();


		event = (EsmAgt0040Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//로그인한 USER가 속한 부서의 A/R Office Code를 구한다.
		arOfcCd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);
		strItem = CodeUtil.getInstance().getAGTCommRptDefaultItem("SYSTEM", 1);

		if(strItem != null && strItem.length > 1) {
			header = strItem[0];
			col_nm = strItem[1];
		}

		//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
		ar_ofc_cd = ComboUtil.getCodeCombo("ar_ofc_cd", arOfcCd, " onChange='ar_ofc_cd_OnChange(this);' style='width:85', class='input1' ", "arOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");
		agn_cd = ComboUtil.getCodeCombo("agn_cd", arOfcCd, " style='width:85'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");

		//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
		cboRptGroup = ComboUtil.getCodeCombo("cboRptGroup", "",  " onChange='cboRptGroup_OnChange();' style='width:120'", "rptGroup", strUsr_id, " ", "");
		
		cobTrade = ComboUtil.getCodeCombo("s_trd_cd", "", " onChange='cobTradeOnChange(this);' style='width:80'", "trade", "", "All", "");
		cobLane  = ComboUtil.getCodeCombo("s_rlane_cd",  "", " style='width:80'", "rLane", "", "All", "");
		cobDir   = JSPUtil.getCodeCombo("s_dir_cd", "", " style='width:80'", "CD00593", 0, "000001: :All");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Commission Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=header%>", "<%=col_nm%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="1">
<!-- 개발자 작업	-->
<input type="hidden" name="iPage">
<input type="hidden" name="header" value="<%=header %>">
<input type="hidden" name="col_nm" value="<%=col_nm %>">
<input type="hidden" name="cre_usr_id" value="<%=strUsr_id %>">
<input type="hidden" name="slct_itm_fom_seq" value="1">
<input type="hidden" name="param1"> <!-- divNm -->
<input type="hidden" name="param2"> <!-- cboNm -->
<input type="hidden" name="param3"> <!-- defaultValue -->
<input type="hidden" name="param4"> <!-- addProperties -->
<input type="hidden" name="param5"> <!-- workName -->
<input type="hidden" name="param6"> <!-- param -->
<input type="hidden" name="param7"> <!-- allYN -->
<input type="hidden" name="param8"> <!-- addOption -->
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
                        <tr><td class="btn1_bg">

                                        <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                                <!-- Repeat Pattern -->
                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

                                                <td class="btn1_line"></td>

                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                        <tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
                                                <!-- Repeat Pattern -->

                                        </tr></table>

                                </td></tr>
                        </table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->

			<!-- TABLE '#D' : ( Search Options ) (S) -->
                        <table class="search" border="0">
                        <tr><td class="bg">
                                <table class="search_in" border="0">
                                        <tr class="h23">
                                                <td width="7%">Office</td>
                                                <td width="18%"><%= ar_ofc_cd %></td>
                                                <td width="8%">Sub Office</td>
                                                <td width="15%"><div id="div_sbOfcCd"><%= agn_cd %></div></td>
                                                <td width="10%">Booking Office</td>
                                                <td width="18%"><input type="text" name="bkg_ofc_cd" style="width:125;ime-mode:disabled;"  onkeypress="ComKeyOnlyAlphabet('upper')"  maxlength="6"><img src="" width="2" height="1" border="0"><a href="javascript:openWindowOffice(document.form, 'BKG');" class="purple"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
                                                <td width="8%">Sales Office</td>
                                                <td colspan="3" align="right"><input type="text" name="ob_sls_ofc_cd" style="width:134;ime-mode:disabled;"  onkeypress="ComKeyOnlyAlphabet('upper')"  maxlength="6"><img src="" width="2" height="1" border="0"><a href="javascript:openWindowOffice(document.form, 'SLS');" class="purple"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
                                        </tr>
                                        <tr class="h23">
                                                <td>Status</td>
                                                <td><select style="width:85;" name="sts_option">
                                                                <!-- <option value="C" selected>Created</option> -->
                                                                <option value="R" selected>Requested</option>
                                                                <option value="A">Audited</option>
                                                                <option value="I">Interfaced</option>
                                                         </select>
                                                </td>
                                                <td>Date</td>
                                                <td colspan="7" class="stm"><input type="text" name="search_dt_fr" style="width:85;ime-mode:disabled" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"> ~ <input type="text" name="search_dt_to" style="width:85;ime-mode:disabled;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
                                        </tr>
                                        <tr class="h23">
                                                <td>VVD</td>
                                                <td><input type="text" name="comm_vvd" style="width:85;ime-mode:disabled;"  onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="10"></td>
                                                <td>Bound</td>
                                                <td><select name="io_bnd_cd" style="width:85;">
                                                                        <option value="A" selected>All</option>
                                                                        <option value="I">In</option>
                                                                        <option value="O">Out</option>
                                                         </select></td>
                                                <td>POR/POL</td>
                                                <td width="17%"><input type="text" name="por_cd" style="width:55;ime-mode:disabled;"  onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="5">&nbsp;/&nbsp;<input type="text" name="pol_cd" style="width:55;ime-mode:disabled;"  onkeypress="ComKeyOnlyAlphabet('uppernum')"  maxlength="5"></td>
                                                <td width="8%">POD/DEL</td>
                                                <td colspan="3"><input type="text" name="pod_cd" style="width:60;ime-mode:disabled;"  onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="5">&nbsp;/&nbsp;<input type="text" name="del_cd" style="width:59;ime-mode:disabled;"  onkeypress="ComKeyOnlyAlphabet('uppernum')"  maxlength="5"></td>
                                        </tr>
                                        <tr class="h23">
                                                <td>Audit No.</td>
                                                <td colspan="3"><input type="text" name="comm_apro_no" style="width:339;ime-mode:disabled;" onkeypress="ComKeyOnlyAlphabet('upper')" maxlength="20"></td>
                                                <td>Invoice No.</td>
                                                <td colspan="5"><input type="text" name="inv_no" style="width:233;ime-mode:disabled;"  onkeypress="ComKeyOnlyAlphabet('upper')" maxlength="30">
                                        </tr>
                                        <tr class="h23">
                                                <td>B/L No.</td>
                                                <td colspan="3"><input type="text" name="bl" style="width:80;ime-mode:disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum');setBlNo(this);" maxlength="12"><img src="" width="2" height="1" border="0"><input type="text" name="bl_no" style="width:257;ime-mode:disabled;"  onkeypress="setBlNos(this);" onKeyUp="setBlNos(this);" ></td>
                                                <td colspan="8">
                                                <table border="0">
	                                                <tr class="h23">
	                                                	<td width="60">Trade</td>
														<td width="100"><%=cobTrade%></td>
														<td width="60">Lane</td>
														<td width="100"><div id="div_rLane"><%=cobLane%></td>
														<td width="80">Direction</td>
														<td width="100"><%=cobDir%></td>
	                                                </tr>
                                                </table>
                                                </td>
                                        </tr>

                                </table>
                        </td></tr>
                        </table>
			<!-- TABLE '#D' : ( Search Options : BKG Information ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
			<tr><td class="bg">

			<!-- : ( BKG Information ) (S) -->
                                <table class="search" border="0">
                                        <tr class="h23">
                                                <td width="140">Customized RPT Form</td>
                                                <td><div id="div_rptGroup"><%=cboRptGroup%></div></td><td><input type="text" name="ingPage" style="border:0;background:transparent;font:bold;coler:blue;" ></td>
                                                <td rowspan="2" class="gray"><img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" align="absmiddle" hspace="5"><a href="javascript:openCustRPTForm();" class="purple">Customized RPT Form</a></td>
                                        </tr>
                                </table>

				<table class="height_5"><tr><td></td></tr></table>

				<!-- : ( grid ) (S) -->
				<table width="100%" id="mainTable">
				  <tr><td>
				 	<script language="javascript">ComSheetObject('sheet1');</script>
				  </td></tr>
				</table>
				<!-- : ( grid ) (E) -->


			</td></tr>
			</table>
			<!-- TABLE '#D' : ( Search Options : BKG Information ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
<script language="Javascript">
	var toDate = ComGetNowInfo();
	var fromDate = ComGetDateAdd(toDate,"D", -7);

	document.form.search_dt_fr.value = fromDate;
	document.form.search_dt_to.value = toDate;
</script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>