<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : cps_gem_0032.jsp
	 *@FileTitle : Expense Code Maintenance for subsidiary
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2012.04.06
	 *@LastModifier : 이준범
	 *@LastVersion : 1.0
	 * 2012.04.06 이준범
	 * 1.0 Creation
	 * 2012.05.09 이준범 {CHM-201217605-01] 
	 * 제목 : GEM - Excel Upload 기능에서 I/F Error data 삭제 기능 개발
	 * 내용 : 1) 지역본부 Upload 시 산하 조직 모두 가능토록 구현
	         2) 논리적으로 삭제 처리 되던 전표(승인 전)에 대하여  물리적으로 삭제 처리
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0032Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem0032Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id    = "";
	String strUsr_nm    = "";
	String plnYr        = "";
	String plnMon       = "";
	String ofcCd        = "";
	String hplnYr       = "";
	String hplnMon      = "";
	String loginOfcCd   = "";
	String authflg      = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		plnYr      = JSPUtil.getParameter(request,"pln_yr","");
		plnMon     = JSPUtil.getParameter(request,"pln_mon","");
		ofcCd      = JSPUtil.getParameter(request,"ofc_lvl3","");
		hplnYr     = JSPUtil.getParameter(request,"hpln_yr","");
		hplnMon    = JSPUtil.getParameter(request,"hpln_mon","");
		loginOfcCd = JSPUtil.getParameter(request,"login_ofc_cd","");
		authflg    = JSPUtil.getParameter(request,"auth_flg","");
	    
	    //Expense Group Code
	    String gen_expn_group_cd = JSPUtil.getParameter(request,"gen_expn_group_cd","");
	   
		event = (CpsGem0032Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<html>
<head>
<title>Expense Office Maintenance - Office Code</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="sch_sumup_office">
<input type="hidden" name="hpln_yr"      value="<%=hplnYr%>">
<input type="hidden" name="hpln_mon"     value="<%=hplnMon%>">
<input type="hidden" name="login_ofc_cd" value="<%=loginOfcCd%>">
<input type="hidden" name="auth_flg"     value="<%=authflg%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Slip Upload</td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!-- Search (S) -->
	<table class="search">
		<tr>
			<td class="bg">
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width: 100%">
				<tr class="h23">
					<td width="3%">Year</td>
					<td width="5%"><input type="text" style="width:40;" class="input2" name="pln_yr" value="<%=plnYr%>" style="text-align:center;" readonly="readonly"></td>
					<td width="3%">Month</td>
					<td width="5%"><input type="text" style="width:30;" class="input2" name="pln_mon" value="<%=plnMon%>" style="text-align:center;" readonly="readonly"></td>
					<td width="10%">
					<input type="checkbox" value="" class="trans" checked disabled>BU
					<input type="checkbox" value="N" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HO');selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HO
					<input type="checkbox" value="Y" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ01('HQ');selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">HQ</td>
					<td width="10%" align="left">
						<select style="width:80;" class="input" name="ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');">
						</select>&nbsp;
						<select style="width:80;" class="input" name="ofc_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');">
						</select>&nbsp;
						<select style="width:80;" class="input" name="ofc_lvl3" >
						</select>&nbsp;</td>                    
                    <td width="28%" align="right" colspan="2">Slip I/F error data<input type="checkbox" value="Y" class="trans" name="slp_if_flg"></td> 
                    <td width="2%"></td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!--  biz_1  (E) -->
	
			<!-- Grid  (S) -->
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
				</tr>
			</table>
			<div id="target_Delete" style=" display:none;">
				<table width="100%" class="button"> 
	            <tr><td class="btn2_bg">
	                <table border="0" cellpadding="0" cellspacing="0"><tr>
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn2_Delete">Row&nbsp;Delete</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                    </tr></table>
	            </td></tr>
	            </table>
	        </div>              
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
            <!-- Button_Sub (E) -->
			</td>
		</tr>
	</table>
	<!-- Search (E) --> 
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
		<tr>
			<td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
				   	<td>
				   	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_popup">Slip I/F Error</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Save">Save</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_DownExcel">Down Excel</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
<!--Button (E) -->
</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>