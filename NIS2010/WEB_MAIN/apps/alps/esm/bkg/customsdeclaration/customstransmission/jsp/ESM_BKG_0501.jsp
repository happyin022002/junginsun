<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0501.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%

	String cntCd = "";
	String ioBndCd = "";
	String sndDt = "";
	String hisSeq = "";

	String stwgSndId = "";
	String sndDate = "";
	String trsmMsgTpId = "";
	
	try {
		cntCd = StringUtil.xssFilter(request.getParameter("cnt_cd"))==null?"false":StringUtil.xssFilter(request.getParameter("cnt_cd"));
		ioBndCd = StringUtil.xssFilter(request.getParameter("io_bnd_cd"))==null?"false":StringUtil.xssFilter(request.getParameter("io_bnd_cd"));
		sndDt = StringUtil.xssFilter(request.getParameter("snd_dt"))==null?"false":StringUtil.xssFilter(request.getParameter("snd_dt"));
 		hisSeq = StringUtil.xssFilter(request.getParameter("his_seq"))==null?"":StringUtil.xssFilter(request.getParameter("his_seq"));
 		
 		stwgSndId = StringUtil.xssFilter(request.getParameter("stwg_snd_id"))==null?"false":StringUtil.xssFilter(request.getParameter("stwg_snd_id"));
 		sndDate = StringUtil.xssFilter(request.getParameter("snd_date"))==null?"false":StringUtil.xssFilter(request.getParameter("snd_date"));
 		trsmMsgTpId = StringUtil.xssFilter(request.getParameter("trsm_msg_tp_id"))==null?"":StringUtil.xssFilter(request.getParameter("trsm_msg_tp_id"));
 		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Canada ACI: Sent File</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="cnt_cd" value="<%=cntCd%>">
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>">
<input type="hidden" name="snd_dt" value="<%=sndDt%>">
<input type="hidden" name="his_seq" value="<%=hisSeq%>">

<input type="hidden" name="stwg_snd_id" value="<%=stwgSndId%>">
<input type="hidden" name="snd_date" value="<%=sndDate%>">
<input type="hidden" name="trsm_msg_tp_id" value="<%=trsmMsgTpId%>">

<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">
				Canada ACI: Sent File</td></tr>
			</table>
			<table class="search">
       			<tr>
       				<td class="bg">
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn1_bg">
			    		<table border="0" cellpadding="0" cellspacing="0">
			    			<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Excel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
						    	<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Print">Print</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_close" onclick="window.close()">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<table class="height_5"><tr><td headers="50"><script language='javascript'>comRdObject('csrPrevie');</script></td></tr></table>
</form>
</body>
</html>