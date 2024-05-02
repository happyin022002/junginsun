<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0027.jsp
*@FileTitle  : Revenue lane
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
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
		BcmCcd0027Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
		
		
		//String mode = "rev";	//Min 추가

		try {
		   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				strUsr_id =	account.getUsr_id();
				strUsr_nm = account.getUsr_nm();


				event = (BcmCcd0027Event)request.getAttribute("Event");
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
<title>Service Lane</title>
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


<body  onLoad="setupPage();">
<form name="form" id="form">

<input type="hidden" name="creflag" value="Y" id="creflag" />
<input type="hidden" name="mst_dat_subj_cd" value="REVL" id="mst_dat_subj_cd" />
<input type="hidden" name="rqst_no" value="<%=rqstNo%>" id="rqst_no" />
<input type="hidden" name="proc_tp_cd" value="<%=procTpCd%>" id="proc_tp_cd" />
<input type="hidden" name="rqst_usr_chk" value="<%=rqstUsrChk%>" id="rqst_usr_chk" />
<input type="hidden" name="rqst_ofc_cd" value="<%=rqstOfcCd%>" id="rqst_ofc_cd" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="add_flg" value="I" id="add_flg" />
<input type="hidden" name="mdm_yn" value="Y" id="mdm_yn" />
<input type="hidden" name="user_id" value="<%= strUsr_id %>" id="user_id" />

<!-- input type="hidden" name="modi_rlane_cd" id="modi_rlane_cd" /-->




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
							&nbsp; Revenue Lane						
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
								<td width="140" align="right" style="padding-right:4px;">Revenue Lane  Code</td>
								<td width="839"><input type="text" style="width:90px;ime-mode:disabled;text-align:center" name="rlane_cd" class="input1" dataformat="uppernum" maxlength="5" id="rlane_cd" />
								<!-- button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1"></button-->
								<img src="img/btns_search.gif" name="btn_rlane_search" id="btn_rlane_search" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
								</td>
								
								<!-- 
								<td width="80" align="right" style="padding-right:4px;">VIP Code</td>
			                    <td><input type="text" style="width:100px;text-align:center;" class="input1" dataformat="engup" id="modi_vsl_slan_cd" name="modi_vsl_slan_cd" maxlength="30"></td>
			                    <td width="130" align="right" style="padding-right:4px;">Sakura CTR Code</td>
			                    <td><input type="text" style="width:100px;text-align:center;" class="input1" dataformat="engup" id="modi_cost_ctr_cd" name="modi_cost_ctr_cd" maxlength="30"></td>
			                    <td width="120" align="right" style="padding-right:4px;">VIP Team Code</td>
			                    <td><input type="text" style="width:100px;text-align:center;" class="input" dataformat="engup" id="modi_vip_team_cd" name="modi_vip_team_cd" maxlength="20"></td>
			                    -->
							</tr>
			      		</table>
			      		<table class="search" style="width:100%;" >
							<tr  class="h23">
									<td>
										<table class="line_bluedot"><tr><td></td></tr></table>
									</td>
								</tr>	
						</table>
						<table class="search" style="width:979;" border='0'>
		   					<tr class="h23">
								<td width="140" align="right" style="padding-right:4px;">Name</td>
								<td width="210" ><input type="text" style="width:170px;ime-mode:disabled;text-align:left" class="input1" name="rlane_nm" dataformat="etc" otherchar="()_\-,. " maxlength="50" id="rlane_nm"/> </td>                    
								<td width="132" align="right" style="padding-right:4px;">Vessel Type</td>
								<td style="padding-left:2px;"><script type="text/javascript">ComComboObject('vsl_tp_cd', 1, 100, 1, 1 ,0 ,false)</script></td>
								<!-- td width="100" align="right" style="padding-right:4px;">Legacy Code</td>
			                    <td><input type="text" style="width:150px;text-align:center;" class="input1" dataformat="engup" id="modi_vsl_slan_cd2" name="modi_vsl_slan_cd2" maxlength="30"></td-->
							</tr>
		   				</table>
		   				<table class="search" style="width:979;" border="0">
		   					<tr class="h23">
								<td width="140" align="right" style="padding-right:4px;">Representative Trade</td>
								<td width="210" style="padding-left:2px;"><script type="text/javascript">ComComboObject('rep_trd_cd', 1, 210, 1, 1 ,0 ,false)</script></td>
								<td width="130" align="right" style="padding-right:4px;">Vessel Service Lane</td>
								<td width="140" ><input type="text" style="width:110px;ime-mode:disabled;text-align:center" class="input1" name="vsl_slan_cd" dataformat="engup" maxlength="3" id="vsl_slan_cd" />
								<!-- button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1"></button-->
								<img src="img/btns_search.gif" name="btn_slan_search" id="btn_slan_search" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> </td>
								
								<td width="200" align="right" style="padding-right:4px;">Modified Revenue Lane Code</td>
								<td><input type="text" style="width:80px;ime-mode:disabled;text-align:center" class="input" name="modi_rlane_cd" dataformat="engup" maxlength="3" id="modi_rlane_cd" /></td>
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
								<td class="title_s">Detail Revenue Lane</td>
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
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
					            </td>
					            <td width="140" align="right" style="padding-right:4px;">Last Update User</td>
					            <td><input type="text" style="width:80px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
					            </td>
					            <td width="190" align="right" style="padding-right:4px;">Last Update Date/Time</td>
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
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

</form>
</body>
</html>