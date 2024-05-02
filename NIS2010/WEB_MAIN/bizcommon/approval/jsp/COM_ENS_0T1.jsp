<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_ENS_0V1.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.13
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2009.11.10 정인선
* 1.0 최초 생성
*-------------------------------------------------------------------------------------------------------
* History
* 2013.01.25 조인영 [CHM-201322577-01] CSR creation approval step 로직 개선
* 2013.02.13 조인영 [CHM-201322900] CSR Approval Step 결재선 변경 기능 추가
* 2015.04.16 심성윤 [CHM-201534125] ALPS 결재 화면 Admin 기능 개발
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.bizcommon.approval.event.ComEns0T1Event"%>
<%@ page import="com.hanjin.bizcommon.approval.util.ApprovalUtil"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%
	ComEns0T1Event  event = null;
	String cahrt = "";
	if(request.getParameter("Subscriber") != null || !request.getParameter("Subscriber").equals("")){
		cahrt = request.getParameter("Subscriber");
	}
	String ofc_cd 			= ""; 
	String mode 			= "";	
	String sub_sys_cd 		= "";	
	String csr_no 			= "";	
	String apro_step 		= "";	
	String target_obj_nm 	= "";
	String apro_cfm_scrn_flg 	= "";
	try{
		event = (ComEns0T1Event)request.getAttribute("Event");
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		mode = StringUtil.xssFilter(request.getParameter("mode")) == null ? "" : StringUtil.xssFilter(request.getParameter("mode"));
		sub_sys_cd = StringUtil.xssFilter(request.getParameter("sub_sys_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("sub_sys_cd"));
		ofc_cd = StringUtil.xssFilter(request.getParameter("ofc_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("ofc_cd"));
		csr_no = StringUtil.xssFilter(request.getParameter("csr_no")) == null ? "" : StringUtil.xssFilter(request.getParameter("csr_no"));
		apro_step = StringUtil.xssFilter(request.getParameter("apro_step")) == null ? "" : StringUtil.xssFilter(request.getParameter("apro_step"));
		target_obj_nm = StringUtil.xssFilter(request.getParameter("target_obj_nm")) == null ? "" : StringUtil.xssFilter(request.getParameter("target_obj_nm"));
		apro_cfm_scrn_flg = StringUtil.xssFilter(request.getParameter("apro_cfm_flg")) == null ? "" : StringUtil.xssFilter(request.getParameter("apro_cfm_flg"));

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String chk_mt_dft_apro_step_yn = "";
	chk_mt_dft_apro_step_yn = JSPUtil.getNull(new ApprovalUtil().checkDftAproStepYN());
%>
<html>
<head>
<title>Organization Chart</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/hanjin/css/OrganTree.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="/hanjin/js/OrganTree.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/HashMap.js"></script>

</HEAD>

<body class="popup_bg" onLoad="loadPage(); initTree('treeView', 'loadData'); officeSearch(); <%if(chk_mt_dft_apro_step_yn.trim().equals("Y")){%> chkDft();<%}%>">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="ofc_cd_deptsrch">
<input type="hidden" name="mode" value="<%=mode%>">
<input type="hidden" name="apro_step" value="<%=apro_step%>">
<input type="hidden" name="target_obj_nm" value="<%=target_obj_nm%>">
<input type="hidden" name="ofc_cd"  value="<%=ofc_cd%>">
<input type="hidden" name="aproSeqKey" >
<input type="hidden" name="csr_no" value="<%=csr_no%>">
<input type="hidden" name="sub_sys_cd" value="<%=sub_sys_cd%>">
<input type="hidden" name="frst_apro_usr_id">
<input type="hidden" name="apro_cfm_scrn_flg" value="<%=apro_cfm_scrn_flg%>">
<input type="hidden" name="ep_id">
<input type="hidden" name="chk_mt_dft_apro_step_yn" value="<%=chk_mt_dft_apro_step_yn%>">

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Approval Route Manager</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
				
				
				<!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table-->
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			
					<!-- TABLE '#D' : ( Button : Main ) (S) -->
				
			<!--Page Title, Historical (E)--> <!-- 1 (S) -->
			<table class="search" id="mainTable" border="0">
				<tr>
				<td class="bg">
					<table class="search" border="0">
					<tr class="h23">
					<td width="210">
					<!-- Grid (S) -->
					<table id="mainTable">
						<tr>
							<td>
							<div id="treeView" style="overflow: auto; width: 210px; height: 320px; border-width: 1px; border-style: solid; border-color: #7F9DB9;"></div>
							</td>
						</tr>
					</table>
					</td>
					<td width="10"></td>
					<td> 
						<!-- Grid (S) -->
						<table id="mainTable" width="300">
							<tr>
								<td>
								<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					</td>
				
					<td width="35" align="center">
						<img src="img/btns_add.gif" border="0" name="btns_add" class="cursor" >
						<br><br><img src="img/btns_del.gif" border="0" name="btns_del" class="cursor">
					</td>
	
					<td width="330" valign="top"> 
					<!-- : ( Grid : Week ) (S) -->
						<table width="100%" id="mainTable">
		                	<tr><td>
		                    	<script language="javascript">ComSheetObject('sheet2');</script>
		               		</td></tr>
		               </table>
					<!-- : ( Grid : Week ) (E) -->
					</td>
				</tr>
			</table>
			
			
	
				
		</td>
	</tr>
</table>
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
							<td>
							<%if(chk_mt_dft_apro_step_yn!=null && !chk_mt_dft_apro_step_yn.trim().equals("Y")){%> 							
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_confirm">Save as Default</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							<%}%> 								
							</td>
						</tr>
						</table>
					</td>
					</tr>
				</table>

</td>
	</tr>
</table>

<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="171" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<!-- td class="btn1" name="btn_retrieve">Retrieve</td-->
					<td class="btn1" name="btn_ok">O K</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<!-- td class="btn1" name="btn_save">save</td-->
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table></td></tr>
</table>


</BODY>

</HTML>

 <%@include file="../../include/common_alps.jsp"%>