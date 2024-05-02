<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0016.jsp
     *@FileTitle : [CPS_GEM-0016] Slip Inquiry by Performance
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.06.04
     *@LastModifier : 박창준
     *@LastVersion : 1.0
     * 2009.06.04 박창준
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
<title>Slip Inquiry  by Performance</title>
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
<input type="hidden" name="pagerows" value="100">
<input type="hidden" name="auth_flg">
<input type="hidden" name="login_office">
<input type="hidden" name="sch_expense_from">
<input type="hidden" name="sch_expense_to">
<input type="hidden" name="sch_expense_group">
<input type="hidden" name="ofc_co_div_cd">
<input type="hidden" name="page_no" value="1">
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
					<td width="50">Month</td>
					<td width="250">
					<input type="text" style="width:60" value="" class="input1" name="from_rslt_yrmon" onKeyDown="onOnlyNumber(this);" onKeyUp="chkEntkey('document.form.from_rslt_yrmon');" maxlength="7">&nbsp;<img class="cursor" name="from_rslt_yrmon_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;
					<input type="text" style="width:60" value="" class="input1" name="to_rslt_yrmon" onKeyDown="onOnlyNumber(this);" onKeyUp="chkEntkey('document.form.to_rslt_yrmon');" onFocus="chkMonth();" onBlur="chkMonth();" maxlength="7">&nbsp;<img class="cursor" name="to_rslt_yrmon_cal" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>					
                    <td width="40">Office</td>
                    <td width="80">
                        <input type="text" style="width:70;text-align: center;ime-mode:disabled;" class="input" name="ofc_expn_cd" maxlength="6" fullfill onKeyPress="ComKeyOnlyAlphabet('uppernum')" onKeyUp="onOfficeKeyup();">
                    </td>

					<td width="110">Expense Group</td>
					<td width="80">
						<script language="javascript">ComComboObject("combo3", 2, 70, 0, 0, 0, true);</script>
					</td>
					<td width="60">Expense</td>
					<td width="190">
					<script language="javascript">ComComboObject("combo1", 2, 70, 0, 0, 0, true);</script>&nbsp;~&nbsp;
					<script language="javascript">ComComboObject("combo2", 2, 70, 0, 0, 0, true);</script>
					</td>
					<td width="25">TIC</td>
					<td width="">
						<select style="width: 75;" class="input" name="sch_tic_cd" onchange="focusOut();"></select>
					</td>
					<td width="">COM</td>
					<td width="">
						<select style="width: 85;" class="input" name="sch_com_div" >
							<option value="" selected></option>
							<option value="O">Own</option>
							<option value="S">Subsidiary</option>
							<option value="E">Etc</option>
						</select>
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
					<td width="260" align="left"><select style="width:80;" class="input" name="ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">
						</select>&nbsp;<select style="width:80;" class="input" name="ofc_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');">
						</select>&nbsp;<select style="width:80;" class="input" name="ofc_lvl3" onchange="comFocusChange('document.form.ofc_cur[0]');">
						</select>&nbsp;</td>
                    <td width="53">Slip No.</td>
                    <td width="135">
                        <input type="text" style="width:130;text-align: left;ime-mode:disabled;" class="input" name="slp_tj_no" maxlength="255">
                    </td>						
					<td width="195">
						<table class="search_sm2" border="0" style="width:190;"> 
							<tr class="h23">
								<td width="35">&nbsp;CUR</td>
								<td class="stm">
								<input type="radio" value="Slip" class="trans" name="ofc_cur" checked>Slip&nbsp;&nbsp;
								<input type="radio" value="USD" class="trans" name="ofc_cur">USD&nbsp;&nbsp;
								<input type="radio" value="KRW" class="trans" name="ofc_cur">KRW
								</td>
							</tr>
						</table> 
					</td>
					<td width="55">CUR Unit</td>
					<td width="40"><input type="text" style="width:25" value=" 1" class="input" name="cur_unit" style="text-align:right;"></td>
					<td width="">
						<table class="search_sm2" border="0" style="width:120;"> 
							<tr class="h23">
								<td><input type="radio" value="K" class="trans" name="sch_lang" onclick="isLangCheck(this);" checked>KOR&nbsp;&nbsp;
									<input type="radio"  value="E" class="trans" name="sch_lang" onclick="isLangCheck(this);">ENG
								</td>
							</tr>
						</table> 
					</td>
				</tr>
				
				</table> 	
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				
                <table width="100%" class="button"> 
                <tr class="h23">                    
                    <td align="left" width=""><span id="sp_commit" style="display: none;"><input type="checkbox" class="trans" name="chk_commit" value="Y" checked="checked">Committee</span></td>
                </tr>
                </table>				
	<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	
	</td></tr>
		</table>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_popup">Slip I/F Error</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>
		
<div style="display: none;"><script language="javascript">ComSheetObject('sheet2');</script></div>
</form>
</body>
</html>