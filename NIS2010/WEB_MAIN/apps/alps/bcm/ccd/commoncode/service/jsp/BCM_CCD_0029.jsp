<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0029.jsp
*@FileTitle  : Vessel service scope
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
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	BcmCcd0029Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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


		event = (BcmCcd0029Event)request.getAttribute("Event");
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
<title>Service Scope</title>
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

<body onload="setupPage();">
<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="mdm_yn" name="mdm_yn" value="y" type="hidden" />
<input id="ibflag" name="ibflag" value="I" type="hidden" />
<input id="user_id" name="user_id" value="<%= strUsr_id %>" type="hidden" />
<input id="creflag" name="creflag" value="Y" type="hidden" />
<input id="mst_dat_subj_cd" name="mst_dat_subj_cd" value="SVSP" type="hidden" />
<input id="rqst_no" name="rqst_no" value="<%=rqstNo%>" type="hidden" />
<input id="proc_tp_cd" name="proc_tp_cd" value="<%=procTpCd%>" type="hidden" />
<input id="rqst_usr_chk" name="rqst_usr_chk" value="<%=rqstUsrChk%>" type="hidden" />
<input id="rqst_ofc_cd" name="rqst_ofc_cd" value="<%=rqstOfcCd%>" type="hidden" />


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
							&nbsp; Service Scope						
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
								<td width="130" align="right" style="padding-right:4px;">Service Scope Code</td>
								<td width="700"><input type="text" style="width:90px;ime-mode:disabled;text-align:center" name="svc_scp_cd" class="input1" dataformat="engup" maxlength="3" id="svc_scp_cd" />
								<!-- button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1"></button-->
								<img src="img/btns_search.gif" name="btn_scp_search" id="btn_scp_search" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
								</td>
								
								<!-- 
								<td width="130" align="right" style="padding-right:4px;">Sakura CTR Code</td>
								<td width="100"><input type="text" style="width:90px;ime-mode:disabled;text-align:center" name="modi_cost_ctr_cd" class="input" dataformat="engup" maxlength="3" id="modi_cost_ctr_cd" />
								</td>
								
								<td width="130" align="right" style="padding-right:4px;">Service Scope Group</td>
								<td width="100"><input type="text" style="width:90px;ime-mode:disabled;text-align:center" name="modi_svc_grp_cd" class="input" dataformat="engup" maxlength="2" id="modi_svc_grp_cd" />
								</td>
								
								<td width="130" align="right" style="padding-right:4px;">Domi/Non Domi Flag</td>
								<td width="60">
									<select style="width:50px;" class="input" name="dmnt_flg">
			                            <option value="N" selected>N</option>
			                            <option value="Y">Y</option>
			                        </select>
								</td>
								-->
							</tr>
			      		</table>
			      		
			      		<table class="search" style="width:979;" border="0">
			                <tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">Name</td>
								<td width="700"><input type="text" style="width:580px;ime-mode:disabled;text-align:left" name="svc_scp_nm" class="input1" dataformat="etc" maxlength="50" id="svc_scp_nm" />
								</td>
							</tr>
			      		</table>
			      		
			      		<table class="search" style="width:979;" border="0">
			                <tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">Bound</td>
								<td width="90" align="left" style="padding-left:2px;"><script type="text/javascript">ComComboObject('svc_scp_bnd_cd', 1, 90, 1, 1 ,0 ,false)</script></td>
								
								<td width="120" align="right" style="padding-right:4px;">Conference Status</td>
								<td width="45">
									<!-- script type="text/javascript">ComComboObject('conf_flg', 1, 124, 1, 1 ,0 ,false)</script-->
									<select style="width:45px;" class="input1" name="conf_flg">
			                            <option value="" selected></option>
			                            <option value="N">N</option>
			                            <option value="Y">Y</option>
			                        </select>
								</td>
								
								<td width="110" align="right" style="padding-right:4px;">FMC File Status</td>
								<td width="45">
									<!-- script type="text/javascript">ComComboObject('fmc_file_flg', 1, 70, 1, 1 ,0 ,false)</script-->
									<select style="width:45px;" class="input1" name="fmc_file_flg">
			                            <option value="" selected></option>
			                            <option value="N">N</option>
			                            <option value="Y">Y</option>
			                        </select>
								</td>
								
								<td width="90" align="right" style="padding-right:4px;">Tariff Prefix</td>
								<td width="50"><input id="trf_pfx_cd" style="width:50px;ime-mode:disabled;text-align:center" class="input" name="trf_pfx_cd" dataformat="engup" maxlength="4" type="text" /></td>
								
								<td width="70" align="right" style="padding-right:4px;">Tariff No</td>
								<td width="50"><input id="trf_no" style="width:50px;ime-mode:disabled;text-align:center" class="input" name="trf_no" dataformat="num" maxlength="4" type="text" /></td>
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
								<td class="title_s">Service Scope Lane</td>
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
														<td class="btn2" name="btn_row_addup">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td id="btn_RowDelete_set">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_row_deleteup">Row Delete</td>
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
			
			
			<!-- Grid BG Box (S) -->
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">
						<table class="search">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Service Scope Limit</td>
							</tr>
						</table>
						
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%">
								
									<script language="javascript">ComSheetObject('sheet2');</script>
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
														<td class="btn2" name="btn_row_adddn">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td id="btn_RowDelete_set">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_row_deletedn">Row Delete</td>
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