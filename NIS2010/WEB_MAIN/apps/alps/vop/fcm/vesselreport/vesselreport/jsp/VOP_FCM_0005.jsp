<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VOP_FCM_0005.jsp
*@FileTitle : Departure Report Overlap Correction (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
*
* History
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event.VopFcm0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    String strErrMsg		= "";                                 //에러메세지
    String dep_rpt_err_seq	= "";
    String vvd				= "";
    String vsl_cd			= "";
    String skd_voy_no		= "";
    String skd_dir_cd		= "";
    String dep_port_cd		= "";
    String clpt_ind_seq		= "";
    String call_ui_id		= "";
    
	try {

		dep_rpt_err_seq	= JSPUtil.getParameter(request, "dep_rpt_err_seq");
		vvd				= JSPUtil.getParameter(request, "vvd");
		dep_port_cd		= JSPUtil.getParameter(request, "dep_port_cd");
		clpt_ind_seq	= JSPUtil.getParameter(request, "clpt_ind_seq");
		call_ui_id		= JSPUtil.getParameter(request, "call_ui_id");
		
		vsl_cd		= vvd.substring(0, 4);
		skd_voy_no	= vvd.substring(4, 8);
		skd_dir_cd	= vvd.substring(8, 9);
 		 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Departure Report Overlap Correction Pop-Up</title>
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

<body class="popup_bg" onload="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="dep_rpt_err_seq" value="<%=dep_rpt_err_seq%>">
<input type="hidden" name="vsl_cd"			value="<%=vsl_cd%>">
<input type="hidden" name="skd_voy_no"		value="<%=skd_voy_no%>">
<input type="hidden" name="skd_dir_cd"		value="<%=skd_dir_cd%>">
<input type="hidden" name="dep_port_cd"		value="<%=dep_port_cd%>">
<input type="hidden" name="clpt_ind_seq"	value="<%=clpt_ind_seq%>">
<input type="hidden" name="call_ui_id"		value="<%=call_ui_id%>">
<input type="hidden" name="sim_chk"			value="N">
	<table width="100%" class="popup" cellpadding="10">
		<tr><td class="top"></td></tr>
		<tr>
			<td valign="top">
				<!-- : ( Title ) (S) -->
				<table width="100%" border="0">
					<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Departure Report Overlap Correction Pop-Up</td></tr>
				</table>
				<!-- : ( Title ) (E) -->
				<table class="search">
					<tr>
						<td class="bg">		
						<!-- : ( Grid ) (S) -->
							<table width="100%" id="mainTable">
		                        <tr>
		                        	<td><script language="javascript">ComSheetObject('sheet1');</script></td>
		                        </tr>
								<tr>
									<td style="padding:0 0 0 110px;">
										<table width="100%" border="0">
											<tr>
												<td class="title_h"></td>
												<td class="title_s">Past Cleansing History</td>
											</tr>
										</table>
									</td>
								</tr>
		                        <tr>
		                        	<td style="padding-left:110px;"><script language="javascript">ComSheetObject('sheet2');</script></td>
		                        </tr>
								<tr>
									<td style="padding:10px 0 0 110px;">
										<table width="100%" border="0">
											<tr>
												<td class="title_h"></td>
												<td class="title_s">Same Section Data</td>
											</tr>
										</table>
									</td>
								</tr>
		                        <tr>
		                        	<td style="padding-left:110px;"><script language="javascript">ComSheetObject('sheet3');</script></td>
		                        </tr>
		                        <tr style="display:none;">
		                        	<td><script language="javascript">ComSheetObject('sheet4');</script></td>
		                        </tr>
				            </table>
						<!-- : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
			</td>
		</tr>
	</table>
	<!-- : ( Button : Sub ) (S) -->
	<table width="100%" class="sbutton">
	<tr>
		<td class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
			<tr>
				<td class="btn3_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Simulation">Simulation</td>
								<td class="btn1_right"></td>
								
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Confirm</td>
								<td class="btn1_right"></td>
								
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
								
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Delete">Delete</td>
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
	<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>