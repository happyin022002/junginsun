<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0031.jsp
*@FileTitle  : Sub trade
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
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.service.event.BcmCcd0031Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	BcmCcd0031Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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


		event = (BcmCcd0031Event)request.getAttribute("Event");
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
<title>sub trade</title>
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
<form name="form">

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ibflag" value="I" id="ibflag" />
<input type="hidden" name="user_id" value="<%= strUsr_id %>" id="user_id" />

<input type="hidden" name="creflag" value="Y" id="creflag" />
<input type="hidden" name="pagerows" id="pagerows" />


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
							&nbsp; Sub Trade					
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
								<td width="130" align="right" style="padding-right:4px;">Sub Trade Code</td>
								<td width="700"><input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="sub_trd_cd" class="input1" dataformat="engup" maxlength="2" id="sub_trd_cd" />
								<!-- button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1"></button-->
								<img src="img/btns_search.gif" name="btns_subtrade" id="btns_subtrade" width="19" height="20" alt="0" border="0" align="absmiddle" class="cursor"> 
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
								<td width="700"><input type="text" style="width:300px;ime-mode:disabled;text-align:left" name="sub_trd_nm" class="input1" dataformat="etc" otherchar="()_\-,. " maxlength="50" maxlength="3" id="sub_trd_nm" />
								</td>
							</tr>
			      		</table>
			      		
			      		<table class="search" style="width:979;" border="0">
			      			<tr class="h23">
								<td width="130" align="right" style="padding-right:4px;">Trade Code</td>
								<td width="700" style="padding-left:2px;"><script type="text/javascript">ComComboObject('trd_cd', 1, 210, 1, 0 ,0 ,false)</script></td>
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
</html>