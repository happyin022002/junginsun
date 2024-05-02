<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0034.jsp
*@FileTitle  : carrier
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
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event.BcmCcd0034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	BcmCcd0034Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.commoncode.partner");
	String mainPage 		= "";
    mainPage = request.getParameter("main_page");
	// 승인처리용 정보
	String rqstNo		= JSPUtil.getParameter(request, "rqst_no");
	String procTpCd		= JSPUtil.getParameter(request, "proc_tp_cd");
	String rqstUsrChk	= JSPUtil.getParameter(request, "rqst_usr_chk");
	String rqstOfcCd	= JSPUtil.getParameter(request, "rqst_ofc_cd");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (BcmCcd0034Event)request.getAttribute("Event");
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
<title>Carrier</title>
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
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ibflag" value="I" id="ibflag" />
<input type="hidden" name="mdm_yn" value="Y" id="mdm_yn" />
<input type="hidden" name="creflag" value="Y" id="creflag" />
<input type="hidden" name="mst_dat_subj_cd" value="CARR" id="mst_dat_subj_cd" />
<input type="hidden" name="rqst_no" value="<%=rqstNo%>" id="rqst_no" />
<input type="hidden" name="proc_tp_cd" value="<%=procTpCd%>" id="proc_tp_cd" />
<input type="hidden" name="rqst_usr_chk" value="<%=rqstUsrChk%>" id="rqst_usr_chk" />
<input type="hidden" name="rqst_ofc_cd" value="<%=rqstOfcCd%>" id="rqst_ofc_cd" />
<input type="hidden" name="onchange_flag">



<table width="100%" cellpadding="0" cellspacing="0" style="padding-top:2; padding-left:5;">
	<tr>
		<td class="top"></td>
	</tr>

	<tr>
		<td valign="top">
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
							&nbsp; Carrier						
						</span>
					</td>
				</tr>
			</table>
			
			<table width="100%" class="search" id="leftTable">
				<tr>
					<td width="120">
					</td>
				</tr>
			</table>
			
			<table class="search" id="mainTable" >
				<tr>
					<td class="bg">
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="130" align="right" style="padding-right:4px;">Carrier Code</td>
			                    <td colspan="3">
			                    	<input id="crr_cd" style="width: 50px; ime-mode:disabled;text-align:center;" class="input1" dataformat="engup" name="crr_cd" maxlength="3" type="text"/>
									<img src="img/btns_search.gif" name="btn_search" id="btn_search" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
			                    </td>
 							</tr>
						</table>
						
						<table class="search" style="width:100% " >
							<tr  class="h23">
 								<td>
 									<table class="line_bluedot"><tr><td></td></tr></table>
 								</td>
 							</tr>	
						</table>
						<table class="search" style="width:979;">
							<tr  class="h23">
 								<td width="130" align="right" style="padding-right:4px;">Name</td>
 								<td width="300"><input type="text" style="width:250px;text-align:left;" class="input1" dataformat="etc" otherchar="()_\-,. " name="crr_nm" value=" " maxlength="50" id="crr_nm"/> </td>
 								<td width="130" align="right" style="padding-right:4px;">Booking EDI</td>					
								<td><input type="text" style="width:50px;ime-mode:disabled;text-align:center;" dataformat="engup" class="input" value=" " name="bkg_edi_cd" maxlength="2" id="bkg_edi_cd" /></td>
 							</tr>
						</table>
						<table class="search" style="width:100%" >
							<tr  class="h23">
 								<td>
 									<table class="line_bluedot"><tr><td></td></tr></table>
 								</td>
 							</tr>	
						</table>
						<table class="search" style="width:990;">
							<tr class="h23">
								<td width="200" align="right" style="padding-right:4px;">Delete Flag</td>
			                    <td>
			                        <select style="width:40px;" name="delt_flg" class="input" id="delt_flg">
			                            <option value="N" selected>N</option>
			                            <option value="Y">Y</option>
			                        </select>
			                    </td>
			                    <td width="280" align="right" style="padding-right:4px;">Create User</td>
					            <td><input type="text" style="width:75px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
					            </td>
					            <td width="340" align="right" style="padding-right:4px;">Create Date/Time</td>
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
					            </td>
					            <td width="420" align="right" style="padding-right:4px;">Last Update User</td>
					            <td><input type="text" style="width:75px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
					            </td>
					            <td width="520" align="right" style="padding-right:4px;">Last Update Date/Time</td>
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
					            </td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td id="btn_History">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
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
								<td id="btn_Save">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
										<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td id="btn_Create">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Create">Create</td>
										<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td width="20" id="bottom_space"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
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
		</td>
	</tr>
</table>
<div class="wrap_result" style='display:none'>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
</body>
</html>