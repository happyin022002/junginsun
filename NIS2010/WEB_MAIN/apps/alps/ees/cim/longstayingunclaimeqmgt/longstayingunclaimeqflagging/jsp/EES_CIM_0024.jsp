<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0024.jsp
*@FileTitle : L/S Flag Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.09.07 김종준
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//MVMT Status 멀티콤보 
	    String temp_cnmv_sts_cd = JSPUtil.getIBCodeCombo("", "", "CD02086", 0, "");
	    if(temp_cnmv_sts_cd != null && temp_cnmv_sts_cd.length() > 8) {
	    	cnmv_sts_cd = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Code = \"")+8, temp_cnmv_sts_cd.lastIndexOf("\""));
	    	cnmv_sts_nm = temp_cnmv_sts_cd.substring(temp_cnmv_sts_cd.indexOf("Text = \"")+8, temp_cnmv_sts_cd.indexOf("\";")); 
	    }						
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Welcome to nis2010!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">

    function setupPage(){  

	    loadPage("<%=cnmv_sts_cd%>", "<%=cnmv_sts_nm%>");
    }

</script>


<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 
<input type="hidden" name="tot_cntr_tpsz_cd" value=""> 


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">


				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="82">
						<select style="width:80;" name="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
							<option value="1" Qselected>LCC</option>
							<option value="2">RCC</option>
							<option value="3">ECC</option>
							<option value="4">SCC</option>
							<option value="5">Yard</option>
							<!-- loc_cd --> 
						</select>
					</td>
					<td width="130">
						<input type="text" class="input1" name="loc_cd" style="ime-mode:inactive" dataformat="engup" size="7" maxlength="7" required fulfill  style="width:60;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle">
					</td>

					<td width="90">Cargo Type</td>
					<td width="120"><select name="full_flg" style="width:70;" class="input">
							<option value="" selected></option>
							<option value="Y">Full</option>
							<option value="N">MTY</option>
						</select>
					</td>
					
					<td width="75">TP/SZ</td>
					<td width="120">
						<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 70, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_cntr_tpsz_cd" readOnly=true  class="input" value=""> -->					
					</td>

					<td width="75">Company</td>
					<td width=""><input type="text" class="input" name="tem_cntr_use_co_cd" readOnly=true style="width:30;" class="input" value="SML">
						<input type="hidden" name="cntr_use_co_cd" value="H"></td>
					
				</tr>
				<tr class="h23">
					<td>Staying Day</td>
					<td class="stm">
						<input type="text" name="over_stay_days" style="width:40; text-align:right;" dataformat="int" class="input1" required value="">&nbsp;or over
					</td>
					<td>MVMT Status</td>
					<td style="padding-left:2">
						<script language="javascript">ComComboObject('cnmv_sts_cd', 1, 70, 1);</script>
						<!-- <input type="checkbox" class="input2" readOnly=true name="chk_cnmv_sts_cd" value=""> -->
					</td>
					<td>Lease Term</td>
					<td>
						<script language="javascript">ComComboObject('lstm_cd', 1, 70, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_lstm_cd" readOnly=true  class="input" value=""> -->
					</td>
					
				</tr> 
				</table>			
				<!--  biz_1   (E) -->

	
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
			
			<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid - 1 (E) -->	
						
			</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)-->

	
	
	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>


</form>
</body>
</html>
