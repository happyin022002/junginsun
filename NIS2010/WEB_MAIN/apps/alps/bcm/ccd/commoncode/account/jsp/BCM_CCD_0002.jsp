<%
/*=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : BCM_CCD_0002.jsp
*@FileTitle  : Charge
*@author     : SM Lines
*@version    : 1.0
*@since      : 2017/12/27
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.account.event.BcmCcd0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
BcmCcd0002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.commoncode.account");
	String mainPage 		= "";
	mainPage = request.getParameter("main_page");
	
	// 승인처리용 정보
	String procTpCd		= JSPUtil.getParameter(request, "proc_tp_cd");
	String rqstUsrChk	= JSPUtil.getParameter(request, "rqst_usr_chk");
	String rqstOfcCd	= JSPUtil.getParameter(request, "rqst_ofc_cd");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	
	
		event = (BcmCcd0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
	
	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<html>
<head>
<title>Charge</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if		
		ComSetObjValue(document.form.screenName,"<%=screenName%>");
		loadPage();
	}
	
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="screenName" value="<%=screenName %>">

<input type="hidden" name="ibflag" value="I" id="ibflag" />
<input type="hidden" name="user_id" value="<%= strUsr_id %>" id="user_id" />
<input type="hidden" name="mdm_yn" value="Y" id="mdm_yn" />

<input type="hidden" name="creflag" value="Y" id="creflag" />

<input type="hidden" name="mst_dat_subj_cd" value="SREP" id="mst_dat_subj_cd" />
<input type="hidden" name="proc_tp_cd" value="<%=procTpCd%>" id="proc_tp_cd" />
<input type="hidden" name="rqst_usr_chk" value="<%=rqstUsrChk%>" id="rqst_usr_chk" />
<input type="hidden" name="rqst_ofc_cd" value="<%=rqstOfcCd%>" id="rqst_ofc_cd" />
<textarea name="keys" style="width:100%; height:10px;display:none"></textarea>

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp; Charge</span></td></tr>
		</table>
		
		<!--Page Title, Historical (E)-->

			
		<!-- : ( Grid ) (S) -->
		<table width="100%" class="search"  id="leftTable"> 
            <tr>
                <td width="120">
                	<script language="javascript">ComSheetObject('sheet1');</script>
            	</td>
        	</tr>
        </table>
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
			
				<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="150">Charge Code</td>
							<td width="500" >
								<input id=chg_cd style="width: 70px; text-align:center;" class="input1" value="" name="chg_cd" maxlength="3" dataformat="engup" type="text" >
								<img src="img/btns_search.gif" name="input_seach_btn" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
							</td>
							<td width="450" ></td>
						</tr>
						
					</table>				
				<!--  biz_1   (E) -->
				</td>
			</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">	
					<table class="search" border="0" style="width:979;"> 
       					<tr class="h23">
							<td width="150">Charge Name</td>
							<td width="500">
								<input id="chg_nm" style="width: 500px; text-align:left;" class="input1" value="" name="chg_nm" maxlength="50" dataformat="uppernum" otherchar="!@&()_/\- " type="text" >
							</td>
							<td width="300" ></td>
						</tr> 
 
					</table>
					
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
	       					<td width="130">Charge Rev Type</td>
							<td width="150" >
								<script type="text/javascript">ComComboObject('chg_rev_tp_cd',  2, 140, 1, 1, 1)</script>
							</td>
							<td width="130">Charge Applying Type</td>
							<td width="150" >
								<script type="text/javascript">ComComboObject('chg_aply_tp_cd', 2, 140, 1, 1, 1)</script>
							</td>
							<td width="130">Charge Applying Area Code</td>
							<td width="150" >
								<script type="text/javascript">ComComboObject('chg_aply_area_cd', 2, 140, 1, 1, 1)</script>
							</td>
						</tr>
 
					</table>
					
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="130">Applying Service Mode Flag</td>
							<td width="150" >
								<select class="input1" style="width:60;" name="aply_svc_mod_flg">
				                    	<option value="N" selected>N</option>
				                    	<option value="Y">Y</option>
				                </select>
							</td>
	       					<td width="130">Account (G/L)</td>
							<td width="150" >
								<input id="hjs_chg_acct_cd" style="width: 90px; text-align:center;" class="input" value="" name="hjs_chg_acct_cd" maxlength="6" dataformat="uppernum" type="text" >
								<img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
							</td>
							<td width="130">Rep.Charge</td>
							<td width="150" >
								<script type="text/javascript">ComComboObject('rep_chg_cd', 2, 80, 1,1,2)</script>
							</td>
						</tr>
 
					</table>
					
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="130">Auto Rating Flag</td>
							<td width="150" >
								<select class="input1" style="width:60;" name="auto_rat_flg">
				                    	<option value="N" >N</option>
				                    	<option value="Y">Y</option>
				                </select>
							</td>
	       					<td width="130">Apply Company</td>
							<td width="150" >
								<script type="text/javascript">ComComboObject('use_co_tp_cd', 2, 80, 1, 1, 1)</script>
							</td>
							<td width="130">Display Seq. on B/L</td>
							<td width="150" >
								<input id="dp_seq" style="width: 50px; text-align:center;" class="input1" value="" name="dp_seq" maxlength="4" dataformat="num" type="text" >
							</td>
						</tr>
 					</table>
 					
 					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="130">Charge EDI Code</td>
							<td width="150" >
								<input id="chg_edi_cd" style="width: 90px; text-align:center;" class="input" value="" name="chg_edi_cd" maxlength="6" type="text" >
							</td>
							<td width="130">Mandatory</td>
							<td width="150" >
								<select class="input" style="width:60;" name="mdt_rat_flg">
								        <option value=""></option>
				                    	<option value="N" >N</option>
				                    	<option value="Y">Y</option>
				                </select>
							</td>
	       					<td width="130">Charge Status</td>
							<td width="150" >
								<select class="input" style="width:60;" name="chg_sts_cd">
								        <option value=""></option>
				                    	<option value="A">A</option>
				                    	<option value="I">I</option>
				                </select>
							</td>
						</tr>
 					</table>
 					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="130">R/D Term</td>
							<td class="sm">
			                    	<table class="search_sm2">
			                    		<tr><td>
											<input id="cy_rd_term_flg" value="Y" class="trans" name="cy_rd_term_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="cy_rd_term_flg">CY</label><!--
					                        --><input id="cfs_rd_term_flg" value="Y" class="trans" name="cfs_rd_term_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="cfs_rd_term_flg">CFS</label><!--
					                        --><input id="dor_rd_term_flg" value="Y" class="trans" name="dor_rd_term_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="dor_rd_term_flg">Door</label><!--
					                        --><input id="tkl_tml_flg" value="Y" class="trans" name="tkl_tml_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="tkl_tml_flg">Tackle</label><!--
					                        --><input id="na_rd_term_flg" value="Y" class="trans" name="na_rd_term_flg" type="checkbox" onclick="javascript:obj_change();"/><label for="na_rd_term_flg">Not Applicable</label>
			                    		</td></tr>
			                    	</table>
			                    </td>
						</tr>
					</table>
			
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="150">Delete Flag</td>
							<td width="110" >
								<select class="input" style="width:60;" name="delt_flg">
				                    	<option value="N" selected>N</option>
				                    	<option value="Y">Y</option>
				                </select>
							</td>
							<td width="150"></td>
							<td width="150" ></td>
							<td width="150"></td>
							<td width="110" ></td>
							<td width="200"></td>
							<td width="120" ></td>
						</tr>
						<tr class="h23">
							<td width="150">Create User</td>
							<td width="110" >
								<input id="cre_usr_id" style="width: 90px;" class="input" value="" name="cre_usr_id" maxlength="20" readonly type="text"  >
							</td>
							<td width="150">Create Date/Time</td>
							<td width="150" >
								<input id="cre_dt" style="width: 110px; text-align:center;" class="input" value="" name="cre_dt" maxlength="100" readonly type="text"  >
							</td>
							<td width="150">Last Update User</td>
							<td width="110" >
								<input id="upd_usr_id" style="width: 90px;" class="input" value="" name="upd_usr_id" maxlength="20" readonly type="text"  >
							</td>
							<td width="200">Last Update Date/Time</td>
							<td width="120" >
								<input id="upd_dt" style="width: 110px; text-align:center;" class="input" value="" name="upd_dt" maxlength="100" readonly type="text"  >
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		
		<!--Button (S) -->
		<table width="100%" class="button"  border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
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
					<td class="btn1" name="btn_Create">Create</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td width="20" id="bottom_space"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
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
		
	</td></tr>
	</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html> 







