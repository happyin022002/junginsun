<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0026.jsp
*@FileTitle  : Movement status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0026Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
		BcmCcd0026Event  event = null;				//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//error from server
		String strErrMsg = "";						//error message
		int rowCount	 = 0;						//count of DB resultSet list
		String successFlag = "";
		String codeList  = "";
		String pageRows  = "100";
		String strUsr_id		= "";
		String strUsr_nm		= "";
		Logger log = Logger.getLogger("com.hanjin.apps.commoncode.sevice");
		try {
		   		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				strUsr_id =	account.getUsr_id();
				strUsr_nm = account.getUsr_nm();
				event = (BcmCcd0026Event)request.getAttribute("Event");
				serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
				if (serverException != null) {
						strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				}
				GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		} catch(Exception e) {
				out.println(e.toString());
		}
%>
<html>
<head>
<title>Movement status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
		var G_MDAA_CHK;
		var G_AHTU_TP_CD;
	
		function setupPage(){
			var errMessage = "<%=strErrMsg%>";
			if (errMessage.length >= 1) {
				ComShowMessage(errMessage);
			} // end if
			loadPage();
		}
</script>
</head>
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ibflag" value="I" id="ibflag" />
<input type="hidden" name="user_id" value="<%= strUsr_id %>" id="user_id" />
<input type="hidden" name="mdm_yn" value="Y" id="mdm_yn" />

<table width="100%" cellpadding="0" cellspacing="0" style="padding-top:2; padding-left:5;">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- Page Title, Historical (S) -->
			<table width="100%" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history">
						<img src="img/icon_history_dot.gif" align="absmiddle">
						<span id="navigation"></span>
					</td>
				</tr>
				<tr>
					<td class="title">
						<img src="img/icon_title_dot.gif" align="absmiddle">
						<span id="title">
							&nbsp; Movement status						
						</span>
					</td>
				</tr>
			</table>
			<!-- Page Title, Historical (E) -->		
			<table width="100%" class="search" id="leftTable">
				<tr>
					<td width="120">
					</td>
				</tr>
			</table>
			<!-- biz Page (S) -->
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">
						<table class="search" style="width:979;">
							<tr class="h23">
								<td style="width:140px">Movement Status Code</td>
								<td style="width:130px; padding-left:2px;"><input type="text" style="width:100px;ime-mode:disabled;text-align:center" class="input1" name="mvmt_sts_cd" dataformat="engup" maxlength="2" id="mvmt_sts_cd" />
									<img src="img/btns_search.gif" class="input_seach_btn" name="btn_mvmt_sts_search" id="btn_mvmt_sts_search" width="19" height="20" align="absmiddle" class="cursor"></td>
								<td style="text-align:right; width:168px;">Name</td>
								<td><input type="text" style="width:500px;ime-mode:disabled;text-align:left" class="input1" name="mvmt_sts_nm" dataformat="" otherchar="()_\-,. " maxlength="50" id="mvmt_sts_nm"/></td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="140" style="text-align:right;">Destination Flag</td>
								<td width="45" style="padding-left:2px";>
									<select style="width:40px;" name="dest_yd_flg" id="dest_yd_flg" class="input" onChange="obj_change();">
										<option value="N" selected>N</option>
										<option value="Y">Y</option>
									</select>
								</td>
								<td style="width:253px; text-align:right;">In/Out Bound </td>
								<td width="" style="padding-left:2"><script type="text/javascript">ComComboObject('io_bnd_cd', 2, 100, 1, 0 ,1 ,false)</script></td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="140" style="text-align:right;">Delete Flag</td>
								<td style="padding-left:2px; width:45px;">
									<select style="width:40px"; name="delt_flg" id="delt_flg" class="input" onChange="obj_change();">
										<option value="N" selected>N</option>
										<option value="Y">Y</option>
									</select>
								</td>
								<td width="73" style="text-align:right;">Create User</td>
					            <td><input type="text" style="width:65px;text-align:center;" class="input2" name="cre_usr_id" id="cre_usr_id" readOnly/>
					            </td>
					            <td width="110" style="text-align:right;">Create Date/Time</td>
					            <td><input type="text" style="width:100px;text-align:center;" class="input2" name="cre_dt" id="cre_dt" readOnly/>
					            </td>
					            <td width="110" style="text-align:right;">Last Update User</td>
					            <td><input type="text" style="width:65px;text-align:center;" class="input2" name="upd_usr_id" id="upd_usr_id" readOnly/>
					            </td>
					            <td width="150" style="text-align:right;">Last Update Date/Time</td>
					            <td><input type="text" style="width:100px;text-align:center;" class="input2" name="upd_dt" id="upd_dt" readOnly/>
					            </td>
							</tr>
						</table>	
					</td>
				</tr>
			</table>
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- biz Page (E) -->
			<!--Button (S) -->
			<table width="100%" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr>
	       			<td class="btn1_bg">
			    		<table border="0" cellpadding="0" cellspacing="0">
			    			<tr>
			    				<td id="btn_History">
			    					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_History">History</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td id="btn_Save1">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td id="btn_Create1">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Create">Create</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td width="20" id="bottom_space"></td>
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
		    <!--Button (E) -->		
		</td>
	</tr>
</table>
</form>
</body>
</html>