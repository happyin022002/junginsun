<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0030.jsp
*@FileTitle  : Trade
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0030Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	BcmCcd0030Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.commoncode.sevice");
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


		event = (BcmCcd0030Event)request.getAttribute("Event");
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
<title>trade</title>
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
<input type="hidden" name="user_id" value="<%= strUsr_id %>" id="user_id" />

<input type="hidden" name="creflag" value="Y" id="creflag" />

<input type="hidden" name="mst_dat_subj_cd" value="TRDE" id="mst_dat_subj_cd" />
<input type="hidden" name="rqst_no" value="<%=rqstNo%>" id="rqst_no" />
<input type="hidden" name="proc_tp_cd" value="<%=procTpCd%>" id="proc_tp_cd" />
<input type="hidden" name="rqst_usr_chk" value="<%=rqstUsrChk%>" id="rqst_usr_chk" />
<input type="hidden" name="rqst_ofc_cd" value="<%=rqstOfcCd%>" id="rqst_ofc_cd" />


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
							&nbsp; Trade					
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
		    
		    <!-- biz_1 (S) -->
		    <table class="search" id="mainTable" >
				<tr>
					<td class="bg">
						<table class="search" style="width:979;" border="0">
			                <tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">Trade Code</td>
								<td width="700"><input type="text" style="width:90px;ime-mode:disabled;text-align:center" name="trd_cd" class="input1" dataformat="engup" maxlength="3" id="trd_cd" />
								<!-- button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1"></button-->
								<img src="img/btns_search.gif" name="btns_trade" id="btns_trade" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
								</td>
							</tr>
			      		</table>						
			      		<table class="search" style="width:100%;" >
							<tr  class="h23">
									<td>
										<table class="line_bluedot"><tr><td></td></tr></table>
									</td>
								</tr>	
						</table>
						
						<table class="search" style="width:979;" border="0">
							<tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">Name</td>
								<td width="700"><input type="text" style="width:200px;ime-mode:disabled;text-align:center" name="trd_nm" class="input1" dataformat="engup" otherchar="()_\-,. " maxlength="50" maxlength="3" id="trd_nm" />
								</td>
							</tr>
			      		</table>
			      		
			      		<table class="search" style="width:979;" border="0">
			      			<tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">Continent From</td>
								<td width="145" style="padding-left:2px;"><script type="text/javascript">ComComboObject('fm_conti_cd', 1, 100, 1, 0 ,0 ,false)</script></td>
								
								<td width="130" align="right" style="padding-right:4px;">Continent To</td>
								<td width="140" style="padding-left:2px;"><script type="text/javascript">ComComboObject('to_conti_cd', 1, 100, 1, 0 ,0 ,false)</script></td>
								
								<td width="130" align="right" style="padding-right:4px;">Vessel Type</td>
								<td width="140" style="padding-left:2px;"><script type="text/javascript">ComComboObject('vsl_tp_cd', 1, 100, 1, 1 ,0 ,false)</script></td>
							</tr>
			      			<tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">Admin Office</td>
								<td width="150"><input type="text" style="width:100px;ime-mode:disabled;text-align:center" name="ofc_cd" class="input1" dataformat="engup" maxlength="6" maxlength="3" id="ofc_cd" />
								<img src="img/btns_search.gif" name="btn_ofc_cd" id="btn_ofc_cd" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
								</td>
								
								<td width="130" align="right" style="padding-right:4px;">Effect Date</td>
								<td width="140"><input type="text" style="width:100px;ime-mode:disabled;text-align:center" name="st_eff_dt" class="input1" dataformat="ymd" maxlength="6" maxlength="10" id="st_eff_dt" />
								<img class="cursor" src="img/btns_calendar.gif" name="btn_Calendar1" width="19" height="20" alt="" border="0" align="absmiddle" >
								</td>
								
								<td width="130" align="right" style="padding-right:4px;">Expire Date</td>
								<td width="140"><input type="text" style="width:100px;ime-mode:disabled;text-align:center" name="end_eff_dt" class="input" dataformat="ymd" maxlength="6" maxlength="10" id="end_eff_dt" />
								<img class="cursor" src="img/btns_calendar.gif" name="btn_Calendar2" width="19" height="20" alt="" border="0" align="absmiddle" >
								</td>
							</tr>
			      		</table>
			      		
			      		<table class="search" style="width:100%;" >
							<tr  class="h23">
									<td>
										<table class="line_bluedot"><tr><td></td></tr></table>
									</td>
								</tr>	
						</table>
						
						
						<table class="search" style="width:979;" border="0">
							<tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">Delete Flag</td>
								<td width="50">
									<select style="width:40px;" name="delt_flg" class="input" id="delt_flg">
			                            <option value="N" selected>N</option>
			                            <option value="Y">Y</option>
			                        </select>
								</td>
								
								<td width="120" align="right" style="padding-right:4px;">Create User</td>
								<td width="60"><input type="text" style="width:60px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
								</td>
								
								<td width="160" align="right" style="padding-right:4px;">Create Date/Time</td>
								<td width="100"><input type="text" style="width:102px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
								</td>
								
								<td width="160" align="right" style="padding-right:4px;">Last Update User</td>
								<td width="60"><input type="text" style="width:60px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
								</td>
								
								<td width="210" align="right" style="padding-right:4px;">Last Update Date/Time</td>
								<td width="80"><input type="text" style="width:102px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
								</td>
								
								
							</tr>
			      		</table>
						
					</td>
				</tr>
			</table>
			<!-- biz_1 (E) -->
			
			<table class="height_8">
				<tr>
					<td></td>
				</tr>
			</table>
			
		</td>
	</tr>
</table>

<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
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
					
					
	           	<td id="btn_Retrieve">
		           	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve">Retrieve</td>
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
				
				<!-- td id="btn_Request">
		           	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Request" id="btn_New">Request</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td-->
				
				<td id="btn_Create">
		           	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Create" id="btn_Create">Create</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				
				<td id="btn_New">
		           	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New" id="btn_New">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				
				<!-- td id="btn_Close" >
		           	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close" id="btn_New">Close</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td-->
				
	 			</tr>
	 	   </table>
		</td>
	</tr>
</table>
<div style='display:none'>
	<div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
</body>
</html>