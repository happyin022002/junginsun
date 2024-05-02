<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0014_01.jsp
     *@FileTitle : [CPS_GEM-0014_01] Requested expense Vs Approved expense
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.06.16
     *@LastModifier : 박창준
     *@LastVersion : 1.0
     * 2009.06.16 박창준
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

//Account Infomation
SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
String usrAuthTpCd = account.getUsr_auth_tp_cd();   
%>
<html>
<head>
<title>Requested expense Vs Approved expense</title>
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
<input type="hidden" name="login_office">

<input type="hidden" name="sch_expense_from">
<input type="hidden" name="sch_expense_to">
<input type="hidden" name="sch_expense_group">
<input type="hidden" name="rslt_yrmon">
<input type="hidden" name="usr_ofc_cd">
<input type="hidden" name="usr_auth_tp_cd" value="<%=usrAuthTpCd%>">
<input type="hidden" name="usr_tic_cd">

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
				<tr class="h23">
				<td width="240">
						<table class="search_sm2" border="0" style="width:230;"> 
							<tr class="h23">
								<td>
								<input type="radio" value="EA" name="gen_expn_rqst_tp_cd" class="trans" onclick="setTpCd('EA');" checked>ADD/TRS&nbsp;&nbsp;
								<input type="radio" value="EI" name="gen_expn_rqst_tp_cd" class="trans" onclick="setTpCd('EI');">INI&nbsp;&nbsp;
								<div id="tp_cd_ea" style="width:200px; height:0px; position:absolute; display:;">
								<input type="text" class="input1" style="width:60;text-align:center;" name="ea_rslt_yrmon" value="" maxlength="7" onKeyDown="onOnlyNumber(this);" onKeyUp="chkYrmonkey('document.form.ea_rslt_yrmon');">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="ea_rslt_yrmon_cal" width="19" height="20" border="0" align="absmiddle">
								</div>
								<div id="tp_cd_ei" style="width:200px; height:0px; position:absolute; display:none;">
								<input type="text" class="input1" style="width:60;text-align:center;" name="ei_rslt_yr" value="" maxlength="4" onKeyDown="onOnlyNumber(this);" onKeyUp="chkYrkey('document.form.ei_rslt_yr');">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="ei_rslt_yr_cal" width="19" height="20" border="0" align="absmiddle">
								</div>
								</td>
							</tr>
						</table> 
					</td>
					<td width="220">
						<table class="search_sm2" border="0" style="width:98%;"> 
							<tr class="h23">
								<td width="30">CUR</td>
								<td class="stm">
									<input type="radio" value="LCL" class="trans" name="ofc_cur" checked>LCL&nbsp;&nbsp;
									<input type="radio" value="USD" class="trans" name="ofc_cur">USD&nbsp;&nbsp;
									<input type="radio" value="KRW" class="trans" name="ofc_cur">KRW
								</td>
							</tr>
						</table> 
					</td>					
                    <td width="40">Office</td>
                    <td width="80">
                        <input type="text" style="width:70;text-align: center;ime-mode:disabled;" class="input" name="ofc_expn_cd" maxlength="6" fullfill onKeyPress="ComKeyOnlyAlphabet('uppernum')" onKeyUp="onOfficeKeyup();">
                    </td>                           					
					<td width="100">Expense Group</td>
					<td width="80">
						<script language="javascript">ComComboObject("combo3", 2, 70, 0, 0, 0, true);</script>
					</td>
					<td width="60">Expense</td>
					<td width="">
						<script language="javascript">ComComboObject("combo1", 2, 70, 0, 0, 0, true);</script>&nbsp;~&nbsp;
						<script language="javascript">ComComboObject("combo2", 2, 70, 0, 0, 0, true);</script>
					</td>
					
				</tr>
				</table> 	
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="130">
						<input type="checkbox" value="" class="trans" checked disabled>BU
						<input type="checkbox" value="N" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HO');selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HO
						<input type="checkbox" value="Y" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HQ');selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HQ
					</td>
					<td width="260" align="left">
						<select style="width:80;" class="input" name="ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">
						</select>&nbsp;<select style="width:80;" class="input" name="ofc_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');">
						</select>&nbsp;<select style="width:80;" class="input" name="ofc_lvl3" onchange="comFocusChange('document.form.sch_tic_cd');">
					</td>
					
					<td width="25">TIC</td>
					<td width="90">
						<select style="width: 75;" class="input" name="sch_tic_cd" onchange="comFocusChange('document.form.ofc_co[0]');"></select>
					</td>
					<td width="250">
									<table class="search_sm2" border="0" style="width:220;"> 
										<tr class="h23">
											<td width="35">COM</td>
											<td class="stm">
												<input type="radio" value="" class="trans" name="ofc_co" checked>All&nbsp;&nbsp;<input type="radio" value="O" name="ofc_co" class="trans">Own&nbsp;&nbsp;<input type="radio" value="S" name="ofc_co" class="trans"> Subsidiary
											</td>
										</tr>
									</table> 
								</td>
					<td width="">
						<table class="search_sm2" border="0" style="width:120;"> 
							<tr class="h23">
								<td class="stm">
									<input type="radio" value="K" class="trans" name="sch_lang" onclick="isLangCheck(this);" checked>KOR&nbsp;&nbsp;
									<input type="radio" value="E" class="trans" name="sch_lang" onclick="isLangCheck(this);">ENG
								</td>
							</tr>
						</table> 
					</td>
					
				</tr>
				
				</table> 	
				
				<table class="height_5"><tr><td></td></tr></table>
				
				<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<table class="search" border="0" style="width:;"> 
				<tr class="h23">
					<td width="150">Approval Opinion&nbsp;<img src="img/btns_search.gif" name="btn_popup01" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand"></td>
					<td width="180">Expense Code Inquiry&nbsp;<img src="img/btns_search.gif" name="btn_popup" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand"></td>
					<td align="left" width=""><span id="sp_commit" style="display: none;"><input type="checkbox" class="trans" name="chk_commit" value="Y" checked="checked">Committee</span></td>
				</tr>		
			</table> 		
			<!--  biz_1   (E) -->
			
		</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_RequestInformation">Request Information</td>
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

</form>
</body>
</html>