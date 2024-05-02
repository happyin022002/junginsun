<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0021.jsp
*@FileTitle  : zone
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
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
        BcmCcd0021Event  event = null;              //PDTO(Data Transfer Object including Parameters)
        Exception serverException   = null;         //Error from server
        String strErrMsg = "";                      //Error message
        int rowCount     = 0;                       //Count of DB resultSet list

        String successFlag = "";
        String codeList  = "";
        String pageRows  = "100";

        String strUsr_id        = "";
        String strUsr_nm        = "";
        Logger log = Logger.getLogger("com.hanjin.apps.commoncode.location");
    
        // 승인처리용 정보
        String rqstNo       = JSPUtil.getParameter(request, "rqst_no");
        String procTpCd     = JSPUtil.getParameter(request, "proc_tp_cd");
        String rqstUsrChk   = JSPUtil.getParameter(request, "rqst_usr_chk");
        String rqstOfcCd    = JSPUtil.getParameter(request, "rqst_ofc_cd");
        String menuflag     = JSPUtil.getParameter(request, "menuflag");
        

        try {
            SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
                strUsr_id = account.getUsr_id();
                strUsr_nm = account.getUsr_nm();


                event = (BcmCcd0021Event)request.getAttribute("Event");
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
<title>Zone</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script langauge="javascript">
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
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="mdm_yn" value="Y" id="mdm_yn" />
<input type="hidden" name="creflag" value="Y" id="creflag" />
<input type="hidden" name="mst_dat_subj_cd" value="ZONE" id="mst_dat_subj_cd" />
<input type="hidden" name="rqst_no" value="<%=rqstNo%>" id="rqst_no" />
<input type="hidden" name="proc_tp_cd" value="<%=procTpCd%>" id="proc_tp_cd" />
<input type="hidden" name="rqst_usr_chk" value="<%=rqstUsrChk%>" id="rqst_usr_chk" />
<input type="hidden" name="rqst_ofc_cd" value="<%=rqstOfcCd%>" id="rqst_ofc_cd" />
<input type="hidden" name="onchange_flag" id="onchange_flag" />

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
							&nbsp; Zone
						</span>
					</td>
				</tr>
			</table>
			<!-- Page Title, Historical (E) -->
			
			<!-- opus_design_btn(S)
			    	<div class="opus_design_btn">
			        <button type="button" class="btn_accent" name="btn_Retrieve"    id="btn_Retrieve" style='display:none'>Retrieve</button>
			       <button type="button" class="btn_normal" name="btn_Save"         id="btn_Save" style='display:none'>Save</button>       
			       <button type="button" class="btn_normal" name="btn_New"      id="btn_New" style='display:none'>New</button> 
			       <button type="button" class="btn_normal" name="btn_Request"  id="btn_Request" style='display:none'>Request</button> 
			       <button type="button" class="btn_normal" name="btn_Close"        id="btn_Close" style='display:none'>Close</button>  
			    </div>
			    opus_design_btn(E) -->		
	    
		    <table width="100%" class="search" id="leftTable">
				<tr>
					<td width="120">
					</td>
				</tr>	    
		    </table>	
		
		<!-- biz page (S) -->
			<!-- biz_1 (S) -->
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">
						<table class="search" style="width:979;">
							<tr class="h23">
								<td width="180" align="right" style="padding-right:4px;">Zone Code</td>
			                    <td width="130">
			                    	<input type="text" style="width:100px;ime-mode:disabled;text-align:center" class="input1" name="zn_cd" dataformat="engupnum" maxlength="7" id="zn_cd" onBlur="obj_change();" />
									<img src="img/btns_search.gif" name="btns_search2" id="btns_search2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
			                    </td>
			                    <td width="180" align="right" style="padding-right:4px;">Name</td>
			                    <td colspan="3"><input type="text" style="width:100%; ime-mode: disabled;" class="input1" name="zn_nm" dataformat="engupnum" otherchar="()_\-,. " maxlength="50" id="zn_nm" /> </td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="180" align="right" style="padding-right:4px;">Cargo Handling Time(Hours)</td>
			                    <td width="130">
			                    	<input type="text" style="width:100px;ime-mode:disabled;text-align:right" class="input1" name="cgo_hndl_tm_hrs" dataformat="int" maxlength="3" id="cgo_hndl_tm_hrs" /> 
			                    </td>
			                    <td width="180" align="right" style="padding-right:4px;">Transit Time(Hours)</td>
			                    <td width="180"><input type="text" style="width:100px;ime-mode:disabled;text-align:right" class="input1" name="tztm_hrs" dataformat="float" maxlength="4" size="6" pointcount="2" id="tztm_hrs" /> </td>
			                    <td width="100" align="right" style="padding-right:4px;">Rep.Zone</td>
			                    <td>
			                        <select style="width:40px;" name="rep_zn_flg" class="input1" id="rep_zn_flg" onChange="obj_change();">
			                            <option value="Y" selected>Y</option>
			                            <option value="N">N</option>
			                        </select>
			                    </td>
							</tr>
						</table>
						<table class="search" style="width:979;">
							<tr class="h23">
			                    <td width="180" align="right" style="padding-right:4px;">Distance(Zone to Rep CY)</td>
			                    <td width="110"><input type="text" style="width:100px;ime-mode:disabled;text-align:right" class="input" name="lnk_dist" dataformat="int" maxlength="6" id="lnk_dist" /> </td>
			                    <td width="20" align="right" style="padding-right:4px;">Unit</td>
			                    <td><script type="text/javascript">ComComboObject('dist_ut_cd', 1, 50, 1, 0);</script></td>
			                    <td width="60" align="right" style="padding-right:4px;">Rep. CY</td>
			                    <td>
			                    	<input type="text" style="width:100px;ime-mode:disabled;text-align:center" class="input1" name="rep_yd_cd" dataformat="engupnum" maxlength="7" id="rep_yd_cd" onBlur="obj_change();"/>
									<img src="img/btns_search.gif" name="btns_search1" id="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
			                    </td>
			                    <td width="205">
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
								<td class="title_s">Zone Detail</td>
							</tr>
						</table>
						
						<!-- Grid (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
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
														<td class="btn2" name="btn_RowAdd" id="btn_RowAdd">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td id="btn_RowDelete_set">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_RowDelete" id="btn_RowDelete">Row Delete</td>
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
			                    <td width="70" style="padding-right:4px;">Delete Flag</td>
			                    <td width="60">
			                        <select style="width:40px;" name="delt_flg" class="input1" id="delt_flg" onChange="obj_change();">
			                            <option value="N" selected>N</option>
			                            <option value="Y">Y</option>
			                        </select>
			                    </td>
			                    <td width="75" style="padding-right:4px;">Create User</td>
					            <td><input type="text" style="width:70px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
					            </td>
					            <td width="110" style="padding-right:4px;">Create Date/Time</td>
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
					            </td>
					            <td width="110" style="padding-right:4px;">Last Update User</td>
					            <td><input type="text" style="width:70px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
					            </td>
					            <td width="150" style="padding-right:4px;">Last Update Date/Time</td>
					            <td><input type="text" style="width:102px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
					            </td>							
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- biz_2 (E) -->			
			
		<!-- biz page (E) -->	

		<!--Button (S) -->
			<table width="100%" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr>
	       			<td class="btn1_bg">
			    		<table border="0" cellpadding="0" cellspacing="0">
			    <tr>
			    	<td id="btn_History"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_History">History</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td id="btn_Save1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td id="btn_Create1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Create" id="btn_Create">Create</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<!-- <td id="btn_Request1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Request">MDM Request</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td> -->
					<td width="20" id="bottom_space"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New" id="btn_New" >New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
<!-- 					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
 -->					</tr>
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
