<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0022.jsp
*@FileTitle : L/S & U/C Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.09.01 김종준
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.09.19 신자영 [CHM-201220003-01] L/S U/C CREATION - COR DRAFT 기능 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim0022Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String popup_mode = "";
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");
	String cntrTpszCd = "";
	String cnmvStsCd = "";
	String fullFlg = "";
	String locTypeCode = "";
	String locCd = "";
	String ofcCd = "";
	String lstmCd = "";
	String overStayDays = "";
	popup_mode = JSPUtil.getParameter(request, "popup_mode".trim(), "");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim0022Event)request.getAttribute("Event");
		cntrTpszCd = event.getFlaggingSDaysOptionVO().getCntrTpszCd();
		cnmvStsCd = event.getFlaggingSDaysOptionVO().getCnmvStsCd();
		fullFlg = event.getFlaggingSDaysOptionVO().getFullFlg();
		locTypeCode = event.getFlaggingSDaysOptionVO().getLocTypeCode();
		locCd = event.getFlaggingSDaysOptionVO().getLocCd();
		ofcCd = event.getFlaggingSDaysOptionVO().getOfcCd();
		lstmCd = event.getFlaggingSDaysOptionVO().getLstmCd(); 
		overStayDays =  event.getFlaggingSDaysOptionVO().getOverStayDays();
		
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

	    loadPage("<%=cnmv_sts_cd%>", "<%=cnmv_sts_nm%>","<%=cntrTpszCd%>","<%=cnmvStsCd%>","<%=fullFlg%>","<%=locTypeCode%>","<%=locCd%>","<%=lstmCd%>");
    }

</script>


<body <%if(popup_mode.equals("Y")){ %> class="popup_bg" <%} %>  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="in_bkg_no">
<input type="hidden" name="in_cntr_no">
<input type="hidden" name="pagerows">

<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 
<input type="hidden" name="param_full_flg" value=""> 

<!-- OUTER - POPUP (S)tart -->
<%if(popup_mode.equals("Y")){ %>
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;L/S & U/C Creation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%} else { %>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
<%} %>
	
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
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Cor">COR Draft</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_loadExcel">Load Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%"> 
				<tr class="h23">
					<td width="83">
						<select style="width:80;" name="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
						    <option value="4">RCC</option>
							<option value="1">LCC</option>
							<option value="2">ECC</option>
							<option value="3">SCC</option>
							<!-- loc_cd --> 
						</select>
					</td>
					<td  width="105">
						<input type="text" class="input1" name="loc_cd" style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill  style="width:45;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle">
					</td>

					<td width="80">Cargo Type</td>
					<td width="120">
						<select name="full_flg" style="width:100;" class="input">
							<option value="Y">Full</option>
							<option value="N">MTY</option>
							<option value="">All</option> 
						</select>
					</td>

					<td width="90">TP/SZ</td>
					<td width="120">
						<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 85, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_cntr_tpsz_cd" readOnly=true  class="input" value=""> -->					
					</td>
					<td width="260">
						<select name="bkg_cust_tp_cd" style="width:100;" class="input">
							<option value="S" selected>SHPR No.</option>
							<option value="C">CNEE No.</option>
							<option value="N">NTFY No.</option>
							<option value="T">Contract No.</option>
						</select>&nbsp;<input type="text" name="cust_cd" style="width:76;" class="input2" readonly dataformat="engup" class="input"  value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="search_cust_cd" id="search_cust_cd" width="19" height="20" border="0" align="absmiddle">
					</td>
						
				</tr> 
				<tr class="h23">
					<td width="">Staying Day</td>
					<td width="" class="stm"><input type="text" name="over_stay_days" style="width:38; text-align:right;" dataformat="int" class="input1" required value="<%=overStayDays%>">&nbsp;&nbsp;or over</td>
					<td width="80">Flag Status</td>
					<td width="">
						<select name="uclm_ls_div_cd" style="width:100;" class="input">
							<option value="P" selected>Pending</option>
							<option value="C">Completed</option>
							<option value="">All</option>
						</select>
					</td>
					<td width="95">MVMT Status</td>
					<td width="120">
						<script language="javascript">ComComboObject('cnmv_sts_cd', 1, 85, 1);</script>
						<!-- <input type="checkbox" class="input2" readOnly=true name="chk_cnmv_sts_cd" value=""> -->
					</td>
					
					<td width="">
						<select name="bkg_bl_type_code" style="width:100;" class="input">
							<option value="BKG" selected>BKG No.</option>
							<option value="BL">B/L No.</option>
							<option value="CNTR">CNTR No.</option>
						</select>&nbsp;<input type="text" class="input" name="bkg_bl_type_cd" dataformat="engup" style="width:100;" class="input" value="">
					</td>
					
				</tr> 
				<tr class="h23">
                    <td width="80">Sales OFC</td>
                    <td width="120"><input type="text" name="sales_ofc_cd" caption="Sales OFC" style="width:70;text-align:center;ime-mode:disabled;" value="<%=ofcCd%>" class="input" maxlength="6" dataformat="engup">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" border="0" align="absmiddle"></td>          

					<td width="40">CMDT</td>
					<td>
						<input type="text" name="rep_cmdt_nm" style="width:100;" class="input2" readonly dataformat="engup" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="search_rep_cmdt_cd" width="19" height="20" border="0" align="absmiddle">
						<input type="hidden" name="rep_cmdt_cd">
					</td>
					
					<td width="95">Lease Term</td>
					<td width="120">
						<script language="javascript">ComComboObject('lstm_cd', 1, 85, 1);</script>
						<!-- <input type="checkbox" class="input2" name="chk_lstm_cd readOnly=true  class="input" value=""> -->
					</td>
					
					<td width="260">
						<select name="code_flg" style="width:100;" class="input">
							<option value="CD00764" selected>RCV Term</option>
							<option value="CD00765">DEL Term</option>
						</select>&nbsp;
						<script language="javascript">ComComboObject('rcv_del_term', 1, 100, 1 ,0);</script>
					</td>
	
				</tr> 

				</table>
				
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
			
			<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
			<!-- Grid (E) -->
			<table class="height_2"><tr><td></td></tr></table>
			
			<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_movement">Movement</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_SelectAll">Select All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				

			</td></tr>
		</table>

	<table class="height_5"><tr><td colspan="8"></td></tr></table>
		</td></tr>
	</table>
		
	<!-- Tab BG Box  (S) -->
	<%if(popup_mode.equals("Y")){ %>
	<!-- : ( Button : pop ) (S) -->
	<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
	
	    	<!--Button (S) -->	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
			    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right">
					</tr></table></td>
				</tr>
				</table></td>
				</tr>
			</table>
	    	<!--Button (E) -->
		
		</td></tr>
	</table>
	<% } %>
	<!-- : ( Button : pop ) (E) -->
	
	<!--biz page (E)-->
</form>
</body>
</html>