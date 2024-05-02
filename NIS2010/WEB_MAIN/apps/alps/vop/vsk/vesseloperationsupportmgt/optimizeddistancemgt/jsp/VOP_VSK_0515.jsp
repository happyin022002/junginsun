<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0515.jsp
*@FileTitle : Optimized Distance Table
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.12
*@LastModifier : 정운
*@LastVersion : 1.0
* 2014.02.12 정운
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.event.VopVsk0515Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0515Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = ""; 
	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.vesseloperationsupportmgt.optimizeddistancemgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0515Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<html>
<head>
<title>Optimized Distance Table</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
</head>

<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="500">
<input type="hidden" name="page_no" value="1">
<input type="hidden" name="port_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
	
	
		<table class="search"> 
       	<tr><td class="bg" style="height:505" valign="top">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;">
				
				<tr class="h23">
					<td width="103" rowspan="1">
						<table class="search_sm2" style="width:70;">
							<tr class="h23">
								<td><input type="radio" name="rdo_tran" value="" class="trans" checked="checked">Port</td>
							</tr>
						</table>
					</td>  
					
					<td width="72">From Port</td>
					<td width="80"><input type="text" style="width:50;ime-mode:disabled;text-align:center" class="input1" name="fm_port_cd" value="" maxlength="5">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_fm_port_cd" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="80"><script language="javascript">ComComboObject('fm_yd_grp_cd',1,50,1,0);</script></td>
					<td width="60">To Port</td>
					<td width="80"><input type="text" style="width:50;ime-mode:disabled;text-align:center" name="to_port_cd" value="" maxlength="5">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_to_port_cd" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="140"><script language="javascript">ComComboObject('to_yd_grp_cd',1,50,1,0);</script></td>
					<td width="45">Period</td>
					<td width="220">
						<input type="text" name="fm_date" dataformat="ymd" style="width:80;text-align:center;" value="" maxlength="8" size="10">&nbsp;~&nbsp;
						<input type="text" name="to_date" dataformat="ymd" style="width:80;text-align:center;" value="" maxlength="8" size="10">&nbsp;
						<img class="cursor" name="btn_period" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width ="30"></td>
					<td width ="50"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="103" rowspan="1">
						<table class="search_sm2" style="width:70;">
							<tr class="h23">
								<td><input type="radio" name="rdo_tran" value="" class="trans">Lane</td>
							</tr>
						</table>
					</td>  
					
					<td width="74">Lane Code</td>
					<td width="90" class="stm"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="" name="vsl_slan_cd" maxlength="3" tabindex="1">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_search1"></td>
					<td width="315"></td>
					<td width="90">Updated Date</td>
					<td><input type="text" style="width:120;text-align:center;" name="upd_dt" class="input2" value="" readOnly="readonly">&nbsp;<input type="text" style="width:80;text-align:center;" name="upd_usr_id" class="input2" value="" readOnly="readonly"></td>
				
				</tr>
				</table>

				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<!--시트-->
							<script language="javascript">ComSheetObject('sheet1');</script>
							
						</td>
					</tr>
				</table> 
		
				<!-- Grid (E) -->
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_RowAdd">Row Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_RowDelete">Row Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_DownExcel">Down Excel</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					 </td></tr>
				</table>
				<!-- Button_Sub (E) -->
						
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> 
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_YdGroup" id="btn_YdGroup">YD Group</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SlipCalc" id="btn_SlipCalc">Slip Calc.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr>
			</table>
		</td></tr>
		</table>		
    <!--Button (E) -->
     
</td></tr>
</table>
<!--IBUpload Component (S) -->
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!--IBUpload Component (E) -->

</form>			
</body>
</html>