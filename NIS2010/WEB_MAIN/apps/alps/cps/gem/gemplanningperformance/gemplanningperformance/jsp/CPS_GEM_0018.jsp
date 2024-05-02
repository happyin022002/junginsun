<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0018.jsp
     *@FileTitle : [CPS_GEM-0018] Summary_After Closing
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.07.03
     *@LastModifier : 박창준
     *@LastVersion : 1.0
     * 2009.07.03 박창준
     * 1.0 Creation
     =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String usrOfcCd = "";
    String usrAuthTpCd = "";
    Logger log = Logger.getLogger("com.hanjin.apps.GEMCommon.GEMMasterCodeMgt");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        usrAuthTpCd = account.getUsr_auth_tp_cd();
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

      

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Summary_After Closing</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="auth_flg">
<input type="hidden" name="usr_auth_tp_cd" value="<%=usrAuthTpCd%>">
<input type="hidden" name="usr_ofc_cd">
<input type="hidden" name="usr_tic_cd">
 
<input type="hidden" name="sch_expense_from">
<input type="hidden" name="sch_expense_to">
<input type="hidden" name="sch_expense_group">
<input type="hidden" name="backendjob_key">

<!-- 개발자 작업 -->

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
							<tr>
								<td width="" align="right">
									<table class="search" border="0" style="width:110;background-color: #E9E9E9;"> 
									<tr class="h23">
										<td><input type="radio" value="K" class="trans" name="sch_lang" onclick="isLangCheck(this);" checked>KOR&nbsp;&nbsp;<input type="radio"  value="E" class="trans" name="sch_lang" onclick="isLangCheck(this);">ENG</td>
									</tr>
									</table> 
								</td>
							</tr>
						</table>
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Mandatory Condition</td></tr>
						</table>
						
						<table class="height_5"><tr><td></td></tr></table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="45">Period</td>
								<td width="">
								<input type="text" style="width:60;" class="input1" value="" name="from_rslt_yrmon" onKeyDown="onOnlyNumber(this);" onKeyUp="chkKey('document.form.from_rslt_yrmon');" maxlength="7">&nbsp;<img class="cursor" name="from_rslt_yrmon_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;
								<input type="text" style="width:60;" class="input1" value="" name="to_rslt_yrmon" onKeyDown="onOnlyNumber(this);" onKeyUp="chkKey('document.form.to_rslt_yrmon');" onFocus="chkMonth();" onBlur="chkMonth();" maxlength="7">&nbsp;<img class="cursor" name="to_rslt_yrmon_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
							</tr>
						</table>
						
						<table class="height_5"><tr><td></td></tr></table>
								
						<table class="grid2" border="0" width="979">
							<tr class="tr2_head">
										<td width="25%">Target</td>
										<td width="25%">Type</td>
										<td width="25%">CUR</td>
										<td width="25%">Depreciation (240601)</td>
							</tr>
							<tr>
										<td style="padding:5 0 5 10" class="stm" valign="top">&nbsp;<input type="radio" name="sel_target" value="ini" class="trans" onclick="setTarget('ini');">Initial<br><br> &nbsp;&nbsp;<input type="radio" name="sel_target" value="add" class="trans" onclick="setTarget('add');">Additional<br><br>&nbsp;&nbsp;<input type="radio" name="sel_target" value="trn" class="trans" onclick="setTarget('trn');">Transfer<br><br>&nbsp;&nbsp;<input type="radio" name="sel_target" value="pfm" class="trans" onclick="setTarget('pfm');" checked>Final</td>
										<td style="padding:5 0 5 10" width="" class="stm" valign="top">&nbsp;<input type="checkbox" name="sub_office_view" value="Y" class="trans">Sub Office View<br><br> &nbsp;&nbsp;<input type="checkbox" name="monthly_view" value="Y" class="trans">Monthly View<br><br>&nbsp;&nbsp;<input type="checkbox" name="comparing_last_year" value="Y" class="trans">Comparing Last Year</td>
										<td style="padding:5 0 5 10" width="" class="stm" valign="top">&nbsp;<input type="radio" name="ofc_cur" value="LCL" class="trans" checked>LCL<br><br> &nbsp;&nbsp;<input type="radio" name="ofc_cur" value="USD" class="trans">USD<br><br>&nbsp;&nbsp;<input type="radio" name="ofc_cur" value="KRW" class="trans">KRW</td>
										<td style="padding:5 0 5 10" width="" class="stm" valign="top">&nbsp;<input type="radio" name="expn_dep" value="FAC" class="trans" checked>Excluding
<br><br> &nbsp;&nbsp;<input type="radio" name="expn_dep" value="DIV" class="trans">Including </td>
							</tr>
						</table>
						
						
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table class="height_5"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:979;">
							<tr><td class="title_h"></td>
								<td width="" class="title_s">Optional Condition</td>
							</tr>
						</table> 
						<table class="height_5"><tr><td></td></tr></table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="450" class="stm"><input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;<input type="checkbox" value="N" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HO');selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HO&nbsp;<input type="checkbox" value="Y" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HQ');selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HQ&nbsp;&nbsp;&nbsp;
											<select style="width:80;" class="input" name="ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">
											</select>&nbsp;<select style="width:80;" class="input" name="ofc_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');">
											</select>&nbsp;<select style="width:80;" class="input" name="ofc_lvl3" onchange="comFocusChange('document.form.sch_lang[1]');">
											</select>&nbsp;</td>
								<td width="40">Office</td>
                   				<td width="100">
                        		<input type="text" style="width:70;text-align: center;ime-mode:disabled;" class="input" name="ofc_expn_cd" maxlength="6" onKeyPress="ComKeyOnlyAlphabet('uppernum')">
                    			</td>											
								<td width="45">Expense</td>
								<td class="stm">&nbsp
								<script language="javascript">ComComboObject("combo1", 2, 70, 0, 0, 0, true);</script>&nbsp;~&nbsp;
								<script language="javascript">ComComboObject("combo2", 2, 70, 0, 0, 0, true);</script>
								</td>
							</tr>
						</table>
						
						
						<table class="height_5"><tr><td></td></tr></table>
								
						
						<table class="grid2" border="0" width="979">
							<tr class="tr2_head">
										<td width="25%">Expense Group</td>
										<td width="25%">TIC</td>
										<td width="25%">Salary</td>
										<td width="25%">Company</td>
							</tr>
							<tr>
										<td style="padding:5 0 5 10" class="stm" valign="top" align="center"><br>
										<script language="javascript">ComComboObject("combo3", 2, 70, 1, 0, 0, true);</script></td>
										<td style="padding:5 0 5 10" class="stm" valign="top" align="center"><br><select style="width: 75;" class="input" name="sch_tic_cd" onchange="comFocusChange('document.form.ofc_sal[0]');"></select></td>
										<td style="padding:5 0 5 10" class="stm" valign="top">&nbsp;<input type="radio" name="ofc_sal" value="" class="trans" checked>All<br><br> &nbsp;&nbsp;<input type="radio" name="ofc_sal" value="Y" class="trans">Yes<br><br>&nbsp;&nbsp;<input type="radio" name="ofc_sal" value="N" class="trans">No</td>
										<td style="padding:5 0 5 10" class="stm" valign="top">&nbsp;<input type="radio" name="ofc_co" value="" class="trans" checked>All<br><br> &nbsp;&nbsp;<input type="radio" name="ofc_co" value="O" class="trans">Own<br><br>&nbsp;&nbsp;<input type="radio" name="ofc_co" value="S" class="trans">Subsidiary</td>
							</tr>
						</table>
						
					
					
				
				<div id="target_report" style=" display:none;">
						<table class="height_5"><tr><td></td></tr></table>
								
						
				<table width="979" border="0" class="search_sm2">
					<tr class="h23">
						<td width="110">Target Report<br>(for Committee)</td>
						<td width="25"><input type="radio" name="target_rpt" class="trans" onclick="setTargetCon('expense');"></td>
						<td width="200"><table width="190" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn2_ActualresultsbyExpense"><span title="Result of Own" onclick="setTargetCon('expense');">Actual results by Expense</span></td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
						<td width="25"><input type="radio" name="target_rpt" class="trans" onclick="setTargetCon('office');"></td>
						<td width="180"><table width="170"  border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn2_ActualresultsbyOffice"><span title="Result of Own" onclick="setTargetCon('office');">Actual results by Office</span></td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
						<td width="25"><input type="radio" name="target_rpt" class="trans" onclick="setTargetCon('subsidiary');"></td>
						<td width="210"><table width="200"  border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn2_ActualresultsbySubsidiary"><span title="Result by Office" onclick="setTargetCon('subsidiary');">Actual results by Subsidiary</span></td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
						<td width="25"><input type="radio" name="target_rpt" class="trans" onclick="setTargetCon('monthly');"></td>
						<td width=""><table width="140"  border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn2_MonthlyExpense"><span title="excluding Korea & Subsidiary" onclick="setTargetCon('monthly');">Monthly Expense</span></td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
					</tr>
				</table>
				</div>
			<!--  biz_1   (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       	    <td align="left" width=""><span id="sp_commit" style="display: none;"><input type="checkbox" class="trans" name="chk_commit" value="Y" checked="checked">Committee</span></td>
       	    <td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--biz page (E)-->
	
	</td></tr>
		</table>

	<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet6');</script>
						</td>
					</tr>
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet7');</script>
						</td>
					</tr>
				</table>
	<!-- Grid BG Box  (S) -->

</form>	
</body>
</html>
