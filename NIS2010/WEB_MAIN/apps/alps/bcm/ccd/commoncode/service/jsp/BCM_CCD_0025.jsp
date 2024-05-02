<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0025.jsp
*@FileTitle  : activity
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0025Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
		BcmCcd0025Event  event = null;				//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//Error from server
		String strErrMsg = "";						//Error message
		int rowCount	 = 0;						//Count of DB resultSet list

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


				event = (BcmCcd0025Event)request.getAttribute("Event");
				serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

				if (serverException != null) {
						strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				}

				GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		}catch(Exception e) {
				out.println(e.toString());
		}
%>

<html>
<head>
<title>Activity</title>
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
							&nbsp; Activity						
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
								<td style="width:180px; text-align:right; padding-right:3px;">Activity Code</td> 
								<td>
									<input type="text" style="width:115px; ime-mode:disabled; text-align:center" class="input1" name="act_cd" dataformat="engup" maxlength="6" id="act_cd" />
									<img src="img/btns_search.gif" name="btns_search1" id="btns_search1" width="19" height="20" align="absmiddle" class="cursor">
								</td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>	
						<table class="search" style="width:979;">
							<tr class="h23">
								<td style="width:180px; text-align:right; padding-right:3px;">Name</td>
								<td><input type="text" style="width:378px;ime-mode:disabled;text-align:left" class="input1" name="act_nm" maxlength="50" id="act_nm" /> </td>
								<td style="width:100px; text-align:right; padding-right:3px;">Description</td>
								<td><input type="text" style="width:300px;text-align:left" class="input" name="act_desc" maxlength="100" id="act_desc" /> </td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
								<td style="width:180px; text-align:right; padding-right:5px;">Activity Type</td>
								<td style="width:130px;"><script type="text/javascript">ComComboObject('act_tp_cd', 2, 130, 1, 0 ,1 ,false)</script></td>
								<td style="width:100px; text-align:right; padding-right:5px;">Full/Empty</td>
								<td><script type="text/javascript">ComComboObject('full_mty_cd', 2, 130, 1, 0 , 1,false)</script></td>
								<td style="width:120px; text-align:right; padding-right:5px;">BND / SKD Seq.</td>
								<td><script type="text/javascript">ComComboObject('bnd_vskd_seq_cd', 2, 100, 1, 0 , 1,false)</script></td>
								<!-- <td><input type="text" style="width:140px;ime-mode:disabled;text-align:center" class="input" name="bnd_vskd_seq_cd" dataformat="engup" maxlength="1" id="bnd_vskd_seq_cd" /> </td> -->
								<td style="width:90px; text-align:right; padding-right:5px;">Node Type</td>
								<td><script type="text/javascript">ComComboObject('nod_tp_cd', 2, 110, 1, 0 , 1,false)</script></td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
								<td style="width:180px; text-align:right; padding-right:5px;">Operation Type</td>
								<td style="width:130px"><script type="text/javascript">ComComboObject('act_op_tp_cd', 2, 130, 1, 0 , 1,false)</script></td>
								<td style="width:100px; text-align:right; padding-right:5px;">Trans. Mode</td>
								<td><script type="text/javascript">ComComboObject('trsp_mod_cd', 2, 130, 1, 0 , 1,false)</script></td>
								<!-- <td><input type="text" style="width:140px;ime-mode:disabled;text-align:center" class="input" name="trsp_mod_cd" dataformat="engup" maxlength="2" id="trsp_mod_cd" /> </td> -->
								<td style="width:120px; text-align:right; padding-right:5px;">ORG/DST</td>
								<td><script type="text/javascript">ComComboObject('org_dest_cd', 2, 100, 1, 0 , 1,false)</script></td>
								<td style="width:90px; text-align:right; padding-right:3px;">Actual Flag</td>
								<td>
									<select style="width:110px;" name="act_flg" class="input" id="delt_flg" onChange="obj_change();">
										<option value="Y" selected>Y</option>
										<option value="N">N</option>
									</select>
								</td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
								<td style="width:180px; text-align:right; padding-right:3px;">Actual Standard EDI Mapping</td>
								<td><input type="text" style="width:360px;ime-mode:disabled;text-align:center" class="input" name="act_stnd_edi_sts_cd" dataformat="engup" maxlength="5" id="act_stnd_edi_sts_cd" /> </td>
								<td style="width:110px; text-align:right; padding-right:3px;">COP SKD Logic No</td>
								<td style="width:307px;"><input type="text" style="width:140px;ime-mode:disabled;text-align:right" class="input" name="cop_skd_lgc_no" dataformat="engup" maxlength="7" id="cop_skd_lgc_no" /> </td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>							
						<table class="search" style="width:979;">
							<tr class="h23">
								<td style="width:80px; text-align:right; padding-right:3px;">Delete Flag</td>
								<td>
									<select style="width:40px;" name="delt_flg" class="input" id="delt_flg" onChange="obj_change();">
										<option value="N" selected>N</option>
										<option value="Y">Y</option>
									</select>
								</td>
								<td style="width:80px; text-align:right; padding-right:3px;">Create User</td>
					            <td><input type="text" style="width:60px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
					            </td>
					            <td style="width:120px; text-align:right; padding-right:3px;">Create Date/Time</td>
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
					            </td>
					            <td style="width:110px; text-align:right; padding-right:3px;">Last Update User</td>
					            <td><input type="text" style="width:60px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
					            </td>
					            <td style="width:150px; text-align:right; padding-right:3px;">Last Update Date/Time</td>
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
					            </td>							
							</tr>
						</table>	
					</td>
				</tr>	
			</table>	
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
<div class="wrap_result">
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
</body>
</html>
