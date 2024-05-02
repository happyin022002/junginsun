<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0004.jsp
     *@FileTitle : [CPS_GEM-0004] Actual Results for Subsidiaries
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.05.25
     *@LastModifier : 박창준
     *@LastVersion : 1.0
     * 2009.05.25 박창준
     * 1.0 Creation
     =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<html>
<head>
<title>Actual Results for Subsidiaries</title>
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
<input type="hidden" name="hpln_yr">
<input type="hidden" name="hpln_mon">

<input type="hidden" name="gw_subject" value="Requet for Performance Input">
<input type="hidden" name="gw_contents" value="">
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
					
					<td width="30">Year</td>
					<td width="55"><input type="text" style="width:40;" class="input1" name="pln_yr" value="" onKeyDown="onOnlyNumber(this);" maxlength="4" style="text-align:center;"></td>
					<td width="30">Month</td>
					<td width="45"><input type="text" style="width:30;" class="input1" name="pln_mon" value="" onKeyDown="onOnlyNumber(this);" maxlength="2" style="text-align:center;" onKeyUp="chkEntkey();"></td>
					<td width="130">
					<input type="checkbox" value="" class="trans" checked disabled>BU
					<input type="checkbox" value="N" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HO');selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HO
					<input type="checkbox" value="Y" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HQ');selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HQ</td>
					<td width="270" align="left">
						<select style="width:80;" class="input" name="ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">
						</select>&nbsp;
						<select style="width:80;" class="input" name="ofc_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');">
						</select>&nbsp;
						<select style="width:80;" class="input" name="ofc_lvl3" onchange="noticeButton();">
						</select>&nbsp;</td>
					<td width="160"><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn1_Performance" id='btn1_Performance'>Performance Input</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					<td  style="width:160;">
						<table class="search_sm2" border="0" style="width:150;"> 
							<tr class="h23">
								<td>SUM UP</td>
								<td class="stm"><input type="radio" name="sum_up" value="Y" class="trans">Yes&nbsp;&nbsp;&nbsp;<input type="radio" name="sum_up" value="N" class="trans" checked>No</td>
							</tr>
						</table> 
					</td>
					<td width="">
						<table class="search_sm2" border="0" style="width:;"> 
							<tr class="h23">
								<td class="stm"><input type="radio" value="KOR" name="lang_div" class="trans">KOR</td>
								<td class="stm"><input type="radio" value="ENG" name="lang_div" class="trans" checked>ENG</td>
							</tr>
						</table> 
					</td>
						
				</tr>
				</table> 
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
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
	<!-- Grid BG Box  (S) -->
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       		<td><table width="240" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_ReqPerformance">Request for Performance Input</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
       		<td class="btn1_bg">
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
					<td class="btn1" name="btn1_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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
</form>
</body>
</html>