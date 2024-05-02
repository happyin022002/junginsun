<%
/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_BKG_S004.jsp
*@FileTitle : SAC Master Data (India)
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.28 송민석
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo.SearchMdmChargeVO"%>
<%@ page import="java.util.List"%>

<%@ page import="org.apache.log4j.Logger" %>
 
 
<html>
<head>
<title>SAC Master Data (India)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
 	function setupPage(){

		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	
        <table width="100%" class="button" border="0" cellpadding="0"
            cellspacing="0" style="padding-top: 0; , padding-bottom: 2;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>                
            </tr>
            </table></td>
            </tr>
            </table>
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
	
	
	
                <!--  biz  (S) -->
                <table class="search" border="0" style="width:100%;">
                <tr class="h23">
                    <td width="85">SAC Code</td>
                    <td width="150"><input type="text" style="width: 100; text-align: left;" name="ida_sac_cd"  class="input"></td>
                   <td width="85">SAC Desc.</td>
                    <td width="100"><input type="text" style="width: 500; text-align: left;" name="ida_sac_nm"  class="input"></td>
                    <td>&nbsp;</td>
                </tr>
                </table>
		            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
 
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table>
 
				
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>