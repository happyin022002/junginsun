<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0028.jsp
*@FileTitle  : Vessel service lane
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
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
		BcmCcd0028Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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


				event = (BcmCcd0028Event)request.getAttribute("Event");
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
<title>Vessel Service Lane</title>
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
<input type="hidden" name="mdm_yn" value="y" id="mdm_yn" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="add_flg" value="I" id="add_flg" />
<input type="hidden" name="user_id" value="<%= strUsr_id %>" id="user_id" />

<input type="hidden" name="creflag" value="Y" id="creflag" />

<input type="hidden" name="mst_dat_subj_cd" value="SCVL" id="mst_dat_subj_cd" />
<input type="hidden" name="rqst_no" value="<%=rqstNo%>" id="rqst_no" />
<input type="hidden" name="proc_tp_cd" value="<%=procTpCd%>" id="proc_tp_cd" />
<input type="hidden" name="rqst_usr_chk" value="<%=rqstUsrChk%>" id="rqst_usr_chk" />
<input type="hidden" name="rqst_ofc_cd" value="<%=rqstOfcCd%>" id="rqst_ofc_cd" />
<input type="hidden" name="old_modi_vsl_slan_cd" id="old_modi_vsl_slan_cd" value="" />
<input type="hidden" name="edi_if_flg" id="edi_if_flg"  />


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
							&nbsp; Vessel Service Lane Code						
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
						<table class="search" style="width:979">
			                <tr class="h23">
								<td width="160" align="right" style="padding-right:4px;">Vessel Service Lane Code</td>
								<td><input type="text" style="width:90px;ime-mode:disabled;text-align:center" name="vsl_slan_cd" class="input1" dataformat="uppernum" maxlength="3" id="vsl_slan_cd" />
								<!-- button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1"></button-->
								<img src="img/btns_search.gif" name="btns_search1" id="btns_search1" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
								</td>

								<td  width="80" align="right" style="padding-right:4px;display:none;">VIP Code</td>
			                    <td style="display:none"><input type="text" style="width:100px;text-align:center;" class="input1" dataformat="engup" id="modi_vsl_slan_cd" name="modi_vsl_slan_cd" maxlength="30"></td>
			                    <td style="display:none" width="130" align="right" style="padding-right:4px;">Sakura CTR Code</td>
			                    <td style="display:none"><input type="text" style="width:100px;text-align:center;" class="input1" dataformat="engup" id="modi_cost_ctr_cd" name="modi_cost_ctr_cd" maxlength="30"></td>
			                    <td style="display:none" width="120" align="right" style="padding-right:4px;">VIP Team Code</td>
			                    <td style="display:none"><input type="text" style="width:100px;text-align:center;" class="input" dataformat="engup" id="modi_vip_team_cd" name="modi_vip_team_cd" maxlength="20"></td>
			                    
							</tr>
			      		</table>
			      		<table class="search" style="width:100% " style="width:979" >
							<tr  class="h23">
									<td>
										<table class="line_bluedot"><tr><td></td></tr></table>
									</td>
								</tr>	
						</table>
						<table class="search" border='0' style="width:979">
		   					<tr class="h23">
								<td width="160" align="right" style="padding-right:4px;">Name</td>
								<td width="816"><input type="text" style="width:300px;ime-mode:disabled;text-align:left" class="input1" name="vsl_slan_nm" dataformat="etc" otherchar="()_\-,. " maxlength="50" id="vsl_slan_nm"/> </td>                    
								<!-- td width="100" align="right" style="padding-right:4px;">Legacy Code</td>
			                    <td><input type="text" style="width:150px;text-align:center;" class="input1" dataformat="engup" id="modi_vsl_slan_cd2" name="modi_vsl_slan_cd2" maxlength="30"></td-->
							</tr>
		   				</table>
		   				<table class="search" border="0" style="width:979">
		   					<tr class="h23">
								<td width="160" align="right" style="padding-right:4px;">Lane Service Type</td>
								<td width="160"><script type="text/javascript">ComComboObject('vsl_svc_tp_cd', 1, 155, 1, 1 ,0 ,false)</script></td>
								<td width="100" align="right" style="padding-right:4px;">Vessel Type</td>
								<td width="180"><script type="text/javascript">ComComboObject('vsl_tp_cd', 1, 175, 1, 1 ,0 ,false)</script></td>
								<td width="100" align="right" style="padding-right:4px;">Feeder/Trunk</td>
								<td width="260"><script type="text/javascript">ComComboObject('fdr_div_cd', 1, 160, 1, 1 ,0 ,false)</script></td>
							</tr>
		   				</table>
		   				
						
		   				<table class="search" border="0" style="width:979">
		   					<tr class="h23">
							<td width="160" align="right" style="padding-right:4px;">Effect Date</td>
							<td width="160" style="padding-right:4px;"><input type="text" style="width:90px;ime-mode:disabled;text-align:center" class="input" name="st_eff_dt" dataformat="ymd" maxlength="10" id="st_eff_dt" />
								<!-- button type="button" class="calendar ir" name="btn_Calendar1" id="btn_Calendar1"></button-->
								<img class="cursor" src="img/btns_calendar.gif" name="btn_Calendar1" width="19" height="20" alt="" border="0" align="absmiddle" >
							</td>
							<td width="100" align="right" style="padding-right:4px;">Expire Date</td>
							<td width="550" style="padding-right:4px;"><input type="text" style="width:90px;ime-mode:disabled;text-align:center" class="input" name="end_eff_dt" dataformat="ymd" maxlength="10" id="end_eff_dt" />
								<!-- button type="button" class="calendar ir" name="btn_Calendar2" id="btn_Calendar2"></button-->
								<img class="cursor" src="img/btns_calendar.gif" name="btn_Calendar2" width="19" height="20" alt="" border="0" align="absmiddle" >
							</td>
							<td width="100" align="right" style="padding-right:4px;display:none">Company Code</td>
							<td width="270" style="display:none;">
								<!-- input type="text" style="width:160px;ime-mode:disabled;text-align:left" class="input" readonly name="co_nm" id="co_nm" disabled/-->
								<!-- input type="hidden" style="width:150px;ime-mode:disabled;text-align:left" class="input1" name="co_cd" id="co_cd" /-->
								<script type="text/javascript">ComComboObject('co_cd', 1, 160, 1, 0 ,0 ,false)</script>
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
			
			<!-- Grid BG Box (S) -->
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">
						<table class="search">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Vessel Service Lane Direction</td>
							</tr>
						</table>
						
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%">
								
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						
						<!-- Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Row_Add">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td id="btn_RowDelete_set">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_Row_Delete">Row Delete</td>
														<td class="btn2_right"></td>
													</tr>											
												</table>
											</td>												
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			<!-- Grid BG Box (E) -->
			
			<table class="height_8">
				<tr>
					<td></td>
				</tr>
			</table>
			
			<!-- biz_2 (S) -->
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">
						
						<table class="search" style="width:979;">
		   					<tr class="h23">
								<td width="100" align="right" style="padding-right:4px;">Delete Flag</td>
								<!-- td><script type="text/javascript">ComComboObject('delt_flg', 1, 60, 1, 0 ,0 ,false)</script></td-->
								<td>
			                        <select style="width:40px;" name="delt_flg" class="input" id="delt_flg">
			                            <option value="N" selected>N</option>
			                            <option value="Y">Y</option>
			                        </select>
			                    </td>
			                    
								<td width="100" align="right" style="padding-right:4px;">Create User</td>
					            <td><input type="text" style="width:80px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
					            </td>
					            <td width="140" align="right" style="padding-right:4px;">Create Date/Time</td>
					            <td><input type="text" style="width:100px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
					            </td>
					            <td width="140" align="right" style="padding-right:4px;">Last Update User</td>
					            <td><input type="text" style="width:80px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
					            </td>
					            <td width="190" align="right" style="padding-right:4px;">Last Update Date/Time</td>
					            <td><input type="text" style="width:100px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
					            </td>
							</tr>
		   				</table>
					</td>
				</tr>
			</table>
			<!-- biz_2 (E) -->	
		</td>
	</tr>
</table>


<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td class="top"></td>
	</tr>
	
	<tr>
		<td valign="top">
			
			
			<table width="100%" class="search" id="leftTable">
				<tr>
					<td width="120">
					</td>
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

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<!-- page_title_area(S) -->
	<!-- page_title_area(E) -->
</table>
</form>
</body>
</html>