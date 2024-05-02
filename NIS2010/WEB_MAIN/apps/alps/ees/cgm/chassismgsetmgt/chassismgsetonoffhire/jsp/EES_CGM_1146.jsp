<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1146.jsp
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.05.20 최민회
* 1.0 Creation
*--------------------------------------------------
* History
* 2015.04.28 Chang Young Kim [CHM-201534113] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1146Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%
	EesCgm1146Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
				
	}catch(Exception e) {
		out.println(e.toString());
	}
    
	String eqKndCd 	= StringUtil.xssFilter(request.getParameter("eq_knd_cd")); 
	String deYrmon 	= StringUtil.xssFilter(request.getParameter("de_yrmon"));
	String eqNoFm 	= StringUtil.xssFilter(request.getParameter("eq_no_fm"));
	String eqNoTo 	= StringUtil.xssFilter(request.getParameter("eq_no_to"));
	
	if(eqKndCd == null) eqKndCd = "";
	if(deYrmon == null) deYrmon = ""; else deYrmon = deYrmon.replace("-","");
	if(eqNoFm == null) eqNoFm = "";
	if(eqNoTo == null) eqNoTo = "";
    
%>

<html>
<head>
<title>Welcome to nis2010!</title>
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

<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="yd_cd">
<input type="hidden" name="curr_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">DIV</td>
					<td width="200"><select style="width:100;" name="eq_knd_cd" class="input1">&nbsp;
						<option value="Z" <%=(eqKndCd.equals("Z") || eqKndCd.equals(""))? "selected" : "" %>>Chassis</option>
						<option value="G" <%=eqKndCd.equals("G") ? "selected":"" %>>M.G.Set</option>
						</select></td>
					<td width="100">Delivery Month</td>
					<td width="150"><input type="text" style="width:60;ime-mode:disabled" dataformat="ym"  class="input1" name="de_yrmon" maxlength="6" value = "<%=deYrmon %>">&nbsp;<img name="btns_Calendar1" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="50">EQ. No.</td>
					<td width="250"><input type="text" style="width:100;" class="input1" maxlength="10" dataformat="engup" name="eq_no_fm" value= "<%=eqNoFm %>">&nbsp;-&nbsp;<input type="text" style="width:80;" class="input1" maxlength="6"  dataformat="isnum" name="eq_no_to" value = "<%=eqNoTo %>"></td>
					<td width="45"> Option</td>
					<td width=""><script language="javascript"> 
					ComComboObject('fa_if_sts_cd',  1, 120, 1, 1, 1, true);</script>
					
						</td>
				
				
				</tr>
			</table> 
			
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
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" ID ="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
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

</form>
</body>
</html>
