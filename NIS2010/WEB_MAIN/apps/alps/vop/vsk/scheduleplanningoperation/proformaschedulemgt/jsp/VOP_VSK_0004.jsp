<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0004.jsp
*@FileTitle : P/F SKD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.06 서창열
* 1.0 Creation

* 2014.04.10 박다은 [CHM-201429686-01] [VSK] P/F SKED Excel format 변경
* 2014.06.08 임예지 [CHM-201429996] P/F SKED Excel Down Format 변경 요청 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0004Event  	event 			= null;					//PDTO(Data Transfer Object including Parameters)
	Exception 			serverException = null;			//서버에서 발생한 에러
	String 				strErrMsg 		= "";						//에러메세지
	int 				rowCount	 	= 0;						//DB ResultSet 리스트의 건수
	
	String 				successFlag 	= "";
	String 				codeList  		= "";
	String 				pageRows  		= "100";

	String 				strUsr_id		= "";
	String 				strUsr_nm		= "";
	Logger 				log 			= Logger.getLogger("com.hanjin.apps.SchedulePlanningOperation.ProformaScheduleMgt");
	
	String 				vsl_slan_cd 	= "";
	String 				pf_skd_tp_cd	= "";
	String 				read_only 		= "";	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		vsl_slan_cd 	= JSPUtil.replaceForHTML(request.getParameter("vsl_slan_cd"));		
		vsl_slan_cd 	= vsl_slan_cd==null?"":vsl_slan_cd;
		
		pf_skd_tp_cd 	= JSPUtil.replaceForHTML(request.getParameter("pf_skd_tp_cd"));		
		pf_skd_tp_cd 	= pf_skd_tp_cd==null?"":pf_skd_tp_cd;		
		
		read_only 		= JSPUtil.replaceForHTML(request.getParameter("read_only"));		
		read_only 		= read_only==null?"":read_only;			

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>P/F SKD Inquiry</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="min_max_spd">
<input type="hidden" name="port_cd">
<input type="hidden" name="port_name">
<input type="hidden" name="read_only"	value="<%=read_only%>">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<% if(!"Y".equals(read_only)){ %>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;<span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td>
				</tr>
			</table>
			<% } else { %>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"></td>
				</tr>
				<tr>
					<td class="title">PF SKD Inquiry(Popup)</td>
				</tr>
			</table>
			<% } %>
			<!--Page Title, Historical (E)-->
			<!--biz page (S)-->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="80">Lane Code</td>
								<td width="90"><input type="text" style="width:50;text-align:center;ime-mode:disabled;text-align:center" name="vsl_slan_cd" class="input1" maxlength="3" dataformat="uppernum" value="<%=vsl_slan_cd%>" tabIndex="1" onKeyPress="if(event.keyCode==13) doSearch();">&nbsp;<img src="img/btns_search.gif" name="btns_search"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td>
								<td width="84">P/F SKD Type</td>
								<td width="99"><input type="text" style="width:40;text-align:center;ime-mode:disabled" name="pf_svc_tp_cd" class="input1" maxlength="4" dataformat="uppernum" value="<%=pf_skd_tp_cd%>" tabIndex="2" onKeyPress="if(event.keyCode==13) doSearch();">&nbsp;<img src="img/btns_search.gif" name="btns_search02"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td> 
								<td width="90">Standard IND</td>   
								<td width="90"><input type="text" style="width:40;text-align:center" name="slan_stnd_flg" class="input2" value="" readOnly="readonly"></td> 
								<td width="70">Multi IND</td>   
								<td width="95"><input type="text" style="width:40;text-align:center" name="mml_usd_flg" class="input2" value="" readOnly="readonly"></td>
								<td width="90">Created Date</td>
								<td align="right"><input type="text" style="width:110;" name="cre_dt" class="input2" value="" readOnly="readonly">&nbsp;<input type="text" style="width:80;text-align:center;" name="cre_usr_id" class="input2" value="" readOnly="readonly"></td>
							</tr>
							<tr class="h23">
								<td>Vessel Class</td>
								<td colspan="3"><input type="text" style="width:50;text-align:center;" name="n1st_vsl_clss_cd" class="input2" value="" readOnly="readonly">&nbsp;<input type="text" style="width:20;text-align:right;" name="n1st_vsl_clss_knt" class="input2" value="" readOnly="readonly">&nbsp;&nbsp;<input type="text" style="width:50;text-align:center;" name="n2nd_vsl_clss_cd" class="input2" value="" readOnly="readonly">&nbsp;<input type="text" style="width:20;text-align:right;" name="n2nd_vsl_clss_knt" class="input2" value="" readOnly="readonly">&nbsp;&nbsp;<input type="text" style="width:50;text-align:center;" name="n3rd_vsl_clss_cd" class="input2" value="" readOnly="readonly">&nbsp;<input type="text" style="width:20;text-align:right;" name="n3rd_vsl_clss_knt" class="input2" value="" readOnly="readonly"></td>
								<td>Duration</td>
								<td><input type="text" style="width:40;text-align:right" name="svc_dur_dys" class="input2" value="" readOnly="readonly"></td> 
								<td>Frequency</td>   
								<td><input type="text" style="width:40;text-align:right" name="brth_itval_dys" class="input2" value="" readOnly="readonly"></td>
								<td>Updated Date</td>
								<td align="right"><input type="text" style="width:110;" name="upd_dt" class="input2" value="" readOnly="readonly">&nbsp;<input type="text" style="width:80;text-align:center;" name="upd_usr_id" class="input2" value="" readOnly="readonly"></td>
							</tr>
						</table>
						<!--  biz_1   (E) -->
						<table class="line_bluedot"><tr><td></td></tr></table>
						<!--  biz_2  (S) -->
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
									<script language="javascript">ComSheetObject('sheet2');</script>
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table> 
						<!-- Grid (E) -->
						<!-- BKG Information (S) -->
						<!--Sub Button (S) -->
						<% if(!"Y".equals(read_only)){ %>
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0"> 
       						<tr>
       							<td class="btn2_bg">
		    						<table border="0" cellpadding="0" cellspacing="0">
		    							<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_DownExcel">Down&nbsp;Excel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<% } %>
    					<!--Sub Button (E) -->
						<!--table border="0" style="width:550; background-color:white;" class="grid2"> 
							<tr>
								<td class="tr2_head2">Calling Port</td>
								<td width="85"><input type="text" style="width:80;text-align:right" class="noinput" name="clpt_knt" value=""></td> 
								<td class="tr2_head2">Total Buffer Ratio</td>
								<td><input type="text" style="width:70;text-align:right" class="noinput" name="tot_buf_rat" value=""></td></tr>
							<tr><td class="tr2_head2">Distance (P/S ~ P/S)</td>
								<td><input type="text" style="width:80;text-align:right" dataformat="int" class="noinput" name="ttl_dist" value=""></td> 
								<td class="tr2_head2">Sea buffer Ratio</td>
								<td><input type="text" style="width:70;text-align:right" class="noinput" name="sea_buf_rat" value=""></td></tr>
							<tr><td class="tr2_head2">Maximum Speed</td>
								<td><input type="text" style="width:80;text-align:right" class="noinput" name="max_spd" value=""></td> 
								<td class="tr2_head2">Port buffer Ratio</td>
								<td><input type="text" style="width:70;text-align:right" class="noinput" name="port_buf_rat" value=""></td></tr>
							<tr><td class="tr2_head2">P/F Speed</td>
								<td><input type="text" style="width:80;text-align:right" class="noinput" name="avg_spd" value=""></td> 
								<td class="tr2_head2">P/F Speed Ratio</td>
								<td><input type="text" style="width:70;text-align:right" class="noinput" name="pf_spd_rat" value=""></td></tr>
							<tr><td class="tr2_head2">Speed (Incl. buffer)</td>
								<td><input type="text" style="width:80;text-align:right" class="noinput" name="buf_spd" value=""></td> 
								<td class="tr2_head2">Buffer Speed Ratio</td>
								<td><input type="text" style="width:70;text-align:right" class="noinput" name="buf_spd_rat" value=""></td></tr>
						</table-->
						<!-- BKG Information (E) -->
						<!--  biz_2   (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--biz page (E)-->
<!--Button (S) -->
<% if(!"Y".equals(read_only)){ %>
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    <tr>
    	<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
		    		
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
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<% } else { %>


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
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_Close">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
    					<!--Button (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>	
<% } %>			
<!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>