<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : COM_APR_0T1.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : SSY
*@LastVersion : 1.0
* 1.0 최초 생성
*-------------------------------------------------------------------------------------------------------
* History
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.bizcommon.authorization.event.ComApr0T1Event"%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%
	ComApr0T1Event  event = null;
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
	String pgm_no			= "";
	String auth_apro_tp_cd	= "";
	String auth_pgm_btn_seq	= "";
	String usr_id = "";
	String xls_prmt = "";
	String auth_rqst_knt = "";
	try{
		event = (ComApr0T1Event)request.getAttribute("Event");
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		mode = StringUtil.xssFilter(request.getParameter("mode")) == null ? "" : StringUtil.xssFilter(request.getParameter("mode"));
		sub_sys_cd = StringUtil.xssFilter(request.getParameter("sub_sys_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("sub_sys_cd"));
		ofc_cd =  StringUtil.xssFilter(account.getOfc_cd());
		//ofc_cd = StringUtil.xssFilter(request.getParameter("ofc_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("ofc_cd"));
		csr_no = StringUtil.xssFilter(request.getParameter("csr_no")) == null ? "" : StringUtil.xssFilter(request.getParameter("csr_no"));
		apro_step = StringUtil.xssFilter(request.getParameter("apro_step")) == null ? "" : StringUtil.xssFilter(request.getParameter("apro_step"));
		target_obj_nm = StringUtil.xssFilter(request.getParameter("target_obj_nm")) == null ? "" : StringUtil.xssFilter(request.getParameter("target_obj_nm"));
		apro_cfm_scrn_flg = StringUtil.xssFilter(request.getParameter("apro_cfm_flg")) == null ? "" : StringUtil.xssFilter(request.getParameter("apro_cfm_flg"));
		pgm_no = StringUtil.xssFilter(request.getParameter("pgm_no")) == null ? "" : StringUtil.xssFilter(request.getParameter("pgm_no"));
		auth_apro_tp_cd = StringUtil.xssFilter(request.getParameter("auth_apro_tp_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("auth_apro_tp_cd"));
		auth_pgm_btn_seq = StringUtil.xssFilter(request.getParameter("auth_pgm_btn_seq")) == null ? "" : StringUtil.xssFilter(request.getParameter("auth_pgm_btn_seq"));
		xls_prmt = StringUtil.xssFilter(request.getParameter("xls_prmt")) == null ? "" : StringUtil.xssFilter(request.getParameter("xlt_prmt"));
		usr_id = account.getUsr_id();
		auth_rqst_knt = StringUtil.xssFilter(request.getParameter("auth_rqst_knt")) == null ? "" : StringUtil.xssFilter(request.getParameter("auth_rqst_knt"));
	}catch(Exception e) {
		out.println(e.toString());
	}
	String chk_mt_dft_apro_step_yn = "";
%>
<html>
<head>
<title>Authorization List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/hanjin/css/OrganTree.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="/hanjin/js/OrganTree.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/HashMap.js"></script>

</HEAD>

<body class="popup_bg" onLoad="loadPage(); initTree('treeView', 'loadData'); officeSearch(); " onUnLoad="delRqstNo();">
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
<input type="hidden" name="pgm_no" value="<%=pgm_no%>">
<input type="hidden" name="auth_apro_tp_cd" value="<%=auth_apro_tp_cd%>">
<input type="hidden" name="auth_pgm_btn_seq" value="<%=auth_pgm_btn_seq%>">
<input type="hidden" name="usr_id" value="<%=usr_id%>">
<input type="hidden" name="ep_id">
<input type="hidden" name="xls_prmt" value = "<%=xls_prmt%>">
<input type="hidden" name="auth_rqst_knt" value = "<%=auth_rqst_knt%>">

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Authorization Approval Route Manager</td></tr>
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
						<img src="img/btns_up.gif" border="0" name="btns_up" class="cursor" >
						<br><br>
						<img  src="img/btns_down.gif" border="0" name="btns_down" class="cursor" >
						<br><br><br><br>
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
	
</td>
	</tr>
</table>

<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->
<div  id ="auth_rqst_rsn" style="display:none">
<table width="100%"  class="search">
<tr><td height="40" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr class="h23" >
				<td width="124">Request Reason : </td>
                <td width="611"><textarea style="width:610;overflow: hidden;" rows="1" class="input" caption="Request Reason" required maxlength="1300" caption="Calculation Basis" name="auth_rqst_rsn"  ></textarea></td>
				<!-- <td align="right"><img src="img/btns_note.gif" width="19" height="20" alt="" border="0" style="cursor: hand;"  align="absmiddle" onClick="showNote(this, 'B')"></td> -->
			</tr>
			</table>
    <!--Button (E) -->
	
		</td></tr>
		</table>
</td></tr>
</table>
</div>

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

<script type="text/javascript">
var frm_flag = "<%=StringUtil.xssFilter(request.getParameter("xls_prmt"))%>";	
document.form.xls_prmt.value = frm_flag;
if(frm_flag == "Y"){
	var target;

	target = document.getElementById('auth_rqst_rsn');
	target.style.display = "inline";
		
}
</script>

 <%@include file="../../include/common_alps.jsp"%>