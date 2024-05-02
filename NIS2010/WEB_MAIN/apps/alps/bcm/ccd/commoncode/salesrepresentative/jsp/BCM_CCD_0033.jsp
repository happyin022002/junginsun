<%
/*=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : BCM_CCD_0033.jsp
*@FileTitle  : Sales rep
*@author     : CLT
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
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.event.BcmCcd0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	BcmCcd0033Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.commoncode.salesrepresentative");
	String mainPage 		= "";
    mainPage = request.getParameter("main_page");
    
	// 승인처리용 정보
	String srepCd		= JSPUtil.getParameter(request, "srep_cd");
	String procTpCd		= JSPUtil.getParameter(request, "proc_tp_cd");
	String rqstUsrChk	= JSPUtil.getParameter(request, "rqst_usr_chk");
	String rqstOfcCd	= JSPUtil.getParameter(request, "rqst_ofc_cd");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (BcmCcd0033Event)request.getAttribute("Event");
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
<title>Sales Rep</title>
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
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp; MDM Sales Rep</span></td></tr>
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
							<td width="120">Sales Rep Code</td>
							<td width="180" >
								<input id="srep_cd" style="width: 100px; text-align:center;" class="input1" value="" name="srep_cd" maxlength="5" dataformat="uppernum" type="text" >
								<img src="img/btns_search.gif" name="btn_com_ens_043" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
							</td>
							<td width="80">Global ID</td>
							<td width="100" ><input type="text" id="glo_usr_id" class="input1" maxlength="20" name="glo_usr_id" style="width:80;text-align: center;" style=""></td>
							<td width="80">SR Country</td>
							<td width="80">
								<input id="cnt_cd" style="width: 40px; text-align:center;" class="input1" value="" name="cnt_cd" maxlength="2" dataformat="engup" type="text" >
								<img src="img/btns_search.gif" name="btn_com_ens_0M1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</td>
					        <td width="300"><div style="display:none;width:450;color:red;" id="modi_srep_cd"></div></td>
					        
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
							<td width="150">Office Code</td>
							<td width="150" >
								<input id="ofc_cd" style="width: 80px; text-align:center;" class="input1" value="" name="ofc_cd" maxlength="6" dataformat="engup" type="text" >
								<img src="img/btns_search.gif" name="btn_com_ens_071" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</td>
							<td width="100">Name</td>
							<td width="200" style="padding-left:2">
								<input id="srep_nm" style="width: 150px;" class="input1" value="" name="srep_nm" maxlength="50" type="text"  >
							</td>
							<td width="150"></td>
							<td width="200"></td>
						</tr>
						<tr class="h23">
							<td width="150">Gender</td>
							<td width="150" >
								<script type="text/javascript">ComComboObject('sex_cd', 1, 80, true, '')</script>
							</td>
							<td width="85">Abbreviation</td>
							<td width="200" style="padding-left:2">
								<input id="srep_abbr_nm" style="width: 180px;" class="input" value="" name="srep_abbr_nm" maxlength="50"  type="text">
							</td>
							<td width="80">I/B Flag</td>
							<td width="70" >
								<select class="input" style="width:60;" name="ib_srep_flg">
				                    	<option value="" selected></option>
				                      	<option value="Y">Y</option>
				                      	<option value="N">N</option>
				                </select>
							</td>
							<td width="80">O/B Flag</td>
							<td width="70" >
								<select class="input" style="width:60;" name="ob_srep_flg">
				                    	<option value="" selected></option>
				                      	<option value="Y">Y</option>
				                      	<option value="N">N</option>
				                </select>
							</td>
							<td width="20"></td>
						</tr>
						<tr class="h23">
							<td width="100">Email</td>
							<td width="200" style="padding-left:2">
								<input id="srep_eml" style="width: 180px;" class="input1" value="" name="srep_eml" maxlength="50" type="text"  >
							</td>
							<td width="100">Mobile Number</td>
							<td width="150" style="padding-left:2">
								<input id="mphn_no" style="width: 150px;" class="input1" value="" name="mphn_no" maxlength="20" dataformat="uppernum" otherchar="!@&()_/\- " type="text"  >
							</td>
							<td width="150">Employee No</td>
							<td width="150" style="padding-left:2">
								<input id="empe_cd" style="width: 130px;" class="input" value="" name="empe_cd" maxlength="20" type="text"  >
							</td>
						</tr>
					</table>
					
					<table class="search" border="0" style="width:979;"> 

					</table>
			
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="150">Delete Flag</td>
							<td width="110" >
								<select class="input" style="width:60;" name="delt_flg">
				                    	<option value="" selected></option>
				                      	<option value="Y">Y</option>
				                      	<option value="N">N</option>
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
				<!-- <td id="btn_Request1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Request">MDM Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> -->
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