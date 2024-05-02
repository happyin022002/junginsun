<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_AGT_0052.jsp
*@FileTitle : CSR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010-10-20
*@LastModifier : Sungjin Park
*@LastVersion : 1.0
* 2010-10-20 Sungjin Park
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event.EsmAgt0052Event"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmAgt0052Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	DBRowSet rowSet = null; //DB ResultSet
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AGTClosing.AGTClosing");

	String userId = "";
	String ofcCd = "";
	String arOfcCd = "";
	String ar_ofc_cd = "";
	String agn_cd = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		ofcCd = account.getOfc_cd();
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmAgt0052Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}

	//로그인한 USER가 속한 부서의 A/R Office Code를 구한다.
	arOfcCd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);

	//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
	ar_ofc_cd = ComboUtil
			.getCodeCombo(
					"ar_ofc_cd",
					arOfcCd,
					" onChange='ar_ofc_cd_OnChange(this);' style='width:85', class='input1'",
					"arOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");
	//agn_cd = ComboUtil.getCodeCombo("agn_cd", ofcCd, " style='width:100'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
	agn_cd = ComboUtil
			.getCodeCombo(
					"agn_cd",
					arOfcCd,
					" onChange='agn_cd_OnChange(this);' style='width:100', class='input1'",
					"sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
%>
<html>
<head>
<title>Agent Commission Request</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;">

<input type="hidden" name="sheet_bl_no_row_chk">
<input type="hidden" name="rect_top">
<input type="hidden" name="rect_left">

<input type="hidden" name="multi_csr_no">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage"> 
<input type="hidden" name="param1"><!-- ComboUtil에서 사용하는 codeItem --> 
<input type="hidden" name="param2"><!-- All Display 유무(Y, N, [All]) --> 
<input type="hidden" name="param3"><!-- Object Name --> 
<input type="hidden" name="param4"><!-- arOfcCd Code --> <input type="hidden" name="param5"><!-- BL No --> <!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td><!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom: 5;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>

					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="3%">Date</td>
						<td width="44%">
						<table border="0" style="height: 15; width: 90%;">
							<tr>
								<td width="180" style="padding-left: 1;"><input type="radio" name="date_option" class="trans" value="C" checked>Creation&nbsp;&nbsp;&nbsp;<input type="radio" name="date_option" class="trans" value="A">Approval&nbsp;&nbsp;</td>
								<td width="250" align="left" ><input type="text" name="search_dt_fr" style="width:75;ime-mode:disabled" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img
							class="cursor" src="/hanjin/img/button/btns_calendar.gif"
							width="19" height="20" border="0" align="absmiddle"
							name="btn_dt_fr"> ~ <input type="text" name="search_dt_to" style="width:75;ime-mode:disabled;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;<img
							class="cursor" src="/hanjin/img/button/btns_calendar.gif"
							width="19" height="20" border="0" align="absmiddle"
							name="btn_dt_to"></td>
							</tr>
						</table>
						</td>
						<td width="5%">Office</td>
						<td width="15%"><%=ar_ofc_cd%></td>
						<td width="8%">Sub Office</td>
						<td width="15%">
						<div id="div_sbOfcCd"><%=agn_cd%></div>
						</td>
					</tr>
					<tr class="h23">
						
						<td width="7%">CSR No</td>
						<!--<td width="" colspan="3" valign="top">
                              <table class="search" border="0">
                                <tr class="h23">
                                  <td valign="top" id="td_bl_no" width="123">
                                    <div id="bl_input" style="display:block;">
                                      <input type="text" name=s_csr_no style="width:121;" class="input1" value="" maxlength="12" dataformat="engupnum">
                                    </div>
                                    <div id="bl_sheet" style="display:none;width:123px;height:150px;position:absolute;left:0px;top:0px;">
                                      <script language="javascript">ComSheetObject('sheet1');</script>
                                    </div>
                                 </td>
                                 <td style="width:2"></td>
                                  <td width=""><table width="115" border="0" cellpadding="0" cellspacing="0" class="button">
                                		<tr><td class="btn2_left"></td>
                               				 <td class="btn2" id="tb1_btn_input_bl_no" name="tb1_btn_input_bl_no">Multi B/L No.</td>
                               				 <td class="btn2_right"></td>
                                		</tr></table>
                                	</td>
                                 </tr>
                              </table>
                            </td>
						--><td width="30%">
						<table border="0" style="height: 15; width: 62%;">
							<tr>
								<td id="td_csr_no">
									<div id="bl_input" style="display:block;">
									<input type="text" name="s_csr_no" style="width:150 ; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="19">
									</div>
									<div id="bl_sheet" style="display:none;width:150px;height:150px;position:absolute;left:0px;top:0px;">
                                      <script language="javascript">ComSheetObject('t1sheet1');</script>
                                    </div>
								</td>
								<td>
									<table border="0" cellpadding="0" cellspacing="0" class="button" align="right">				
										<td class="btn2_left"></td>
										<td class="btn2" id="tb1_btn_input_bl_no" name="tb1_btn_input_bl_no">Multi CSR No.</td>
										<td class="btn2_right"></td>
									</table>
								</td>
							</tr>
						</table>
								
						<td width="3%">R.VVD</td>
						<td width="15%"><input type="text" name="s_r_vvd" style="width: 100; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="9"></td>
						<td width="5%">Status</td>
						<td width="27%"><select style="width: 100;" name="s_sts_cd" >
							<option value="1" selected>Created</option>
							<!-- RS,RM -->
							<option value="2">Approved</option>
							<!-- IF -->
							<option value="3">Paid</option>
							<!-- IF -->
							<option value="4">Cancelled</option>
							<!-- RS,RM -->
						</select></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
				<table class="height_10">
					<tr>
						<td></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg"><!-- : ( Agent Commission Request ) (S) --> <!-- : ( grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
						<!-- : ( grid ) (E) --> <!-- : ( Agent Commission Request ) (E) --> <!-- <textarea name="sXml" cols="150" rows="10" ></textarea> --></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) --></td>

			</tr>
		</table>
		<!-- Outer Table (E)-->
<!-- : ( Button : pop ) (S) -->
<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
    	 	  	<tr>
    	 	  		<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0" align="left">
		    				<tr>
								<!-- Repeat Pattern -->
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_detail" id="btn_detail">CSR Detail</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
								
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->		

		</form>
</body>

</html>

