
<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1101.jsp
*@FileTitle : EQ Forecast Summary Filter
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.12.15 박정민
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.event.EesEqr1101Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EesEqr1101Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
	String strCnt_cd		= "";
//emptycodadjustment    Logger log = Logger.getLogger("com.hanjin.apps.cntrcodconfirm.emptycodadjustment");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


        event = (EesEqr1101Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
    
	// Location Type Code Select 박스
	String locSelectBox = JSPUtil.getCodeCombo("s_loc_grp_cd","","style='width:60;'","CD03052",0,"000001: :ALL");
	String divSelectBox = JSPUtil.getCodeCombo("s_hul_bnd_cd","","style='width:80;'","CD03217",0,"000001: :ALL");
%>
<html>
<head>
<title>MTY Repo Inquiry by Period</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("loc_grp_cd", "01", "CD03052", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("hul_bnd_cd", "01", "CD03217", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("rcc_cd", "01", "CD00255", 0, "")%>


    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
        //document.form.froms.focus();      
    }
</script>
</head>

<body onLoad="setupPage();">
	<form name="form">
		<input type="hidden" name="f_cmd"> <input type="hidden"
			name="pagerows">
		<!-- 개발자 작업 -->



		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			style="padding-top: 2; padding-left: 5;">
			<tr>
				<td valign="top">
					<!--top menu (S)--> <!--top menu (E)-->
				</td>
			</tr>

			<tr>
				<td valign="top">
					<!--Page Title, Historical (S)-->
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="title">
						<tr>
							<td class="history"><img src="img/icon_history_dot.gif"
								align="absmiddle"><span id="navigation"></span></td>
						</tr>
						<tr>
							<td class="title"><img src="img/icon_title_dot.gif"
								align="absmiddle"><span id="title"></span></td>
						</tr>
					</table> <!--Page Title, Historical (E)--> <!--Button (S) -->
					<table width="100%" class="button" border="0" cellpadding="0"
						cellspacing="0" style="padding-top: 0; , padding-bottom: 2;">
						<tr>
							<td class="btn1_bg">

								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td><table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
										<td><table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_new">New</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
										<td class="btn1_line"></td>
										<td><table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_save">Save</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
										<td><table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_downExcel">Down Excel</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
									</tr>
								</table>
							</td>
						</tr>
					</table> <!--Button (E) --> <!--biz page (S)-->
					<table class="search">
						<tr>
							<td class="bg">
								<!--  biz_1  (S) -->
								<table class="search" border="0" style="width: 600;">
									<tr class="h23">
										<td width="35">RCC</td>
										<td width="100"><select style="width:75;" name="s_rcc_cd" onChange="change_rcc()">
												<option value="" selected>ALL</option>
												<option value="CNSHA">CNSHA</option>
												<option value="CNHKG">CNHKG</option>
												<option value="TWTPE">TWTPE</option>
												<option value="KRSEL">KRSEL</option>
												<option value="JPTYO">JPTYO</option>
												<option value="SGSIN">SGSIN</option>
												<option value="DEHAM">DEHAM</option>
												<option value="USNYC">USNYC</option>
										</select>
										</td>
										<td width="60">Location</td>
										<td width="170">
										 <%= locSelectBox %> <input type="text" class="input"
											name="s_loc_cd" dataformat="engup" size="5" maxlength="5"
											fulfill size="5" style="width: 53;" value="">
											<img class="cursor" src="img/btns_search.gif"
											name="btn_loc_cd" width="19" height="20" border="0"
											align="absmiddle" disabled></td>
										<td width="40">DIV</td>
										<td><%= divSelectBox %></td>
									</tr>
								</table> <!--  biz_1   (E) -->
								<table class="line_bluedot"><tr><td></td></tr></table> 
								<!-- Tab (S) --> <!-- Tab (E) --> <!-- Tab BG Box  (S) -->
								<table width="100%" id="mainTable">
									<tr>
										<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
										</td>
									</tr>
								</table> <!-- Grid (E) --> <!--  Button_Sub (S) -->
								<table width="100%" class="button">
									<tr>
										<td class="btn2_bg">
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td><table width="100%" border="0" cellpadding="0"
															cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_row_add">Row Add</td>
																<td class="btn2_right"></td>
															</tr>
														</table></td>
													<td><table width="100%" border="0" cellpadding="0"
															cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_row_del">Row Delete</td>
																<td class="btn2_right"></td>
															</tr>
														</table></td>
												</tr>
											</table>
										</td>
									</tr>
								</table> <!-- Button_Sub (E) --> <!--  Grid_button (S) -->
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<!-- Tab BG Box  (S) -->
		<!--biz page (E)-->
		<!--Button (S) -->

		<!--Button (E) -->

		<table class="height_10">
			<tr>
				<td colspan="8"></td>
			</tr>
		</table>
		</td>
		</tr>
		</table>


		<!-- Copyright (S) -->
		<!-- Copyright(E)-->



		<!-- 개발자 작업  끝 -->
	</form>
</body>
</html>