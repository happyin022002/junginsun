<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0073.jsp
*@FileTitle : BDR Time Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.28 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0073Event"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0073Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.BookingMasterMgt");
	
	String screenName = "";
	String sLandOptCheck = "";
	String sVvdOptCheck = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0073Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
	  	screenName = screen.getName();

	  if (screenName.indexOf("_1") > 0){
		  sLandOptCheck = "disabled";
		  sVvdOptCheck = "checked";
	  }else{
		  sVvdOptCheck = "disabled";
		  sLandOptCheck = "checked";
	  }
	  if (screenName.indexOf("Q") > 0){
		  sLandOptCheck = "checked";
		  sVvdOptCheck = "";
	  }
	 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>BDR Time Table</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->   
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>   
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>   
    </table>   
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
	
		<!-- Grid BG Box  (S) -->
     	<table class="search">
       	<tr><td class="bg">
			<!--  biz_2  (S) -->
			
			<table border="0" style="width:979;" class="search"> 
				<tr class="h23">
					<td width="250">
						<table border="0" style="width:210;" class="search_sm2"> 
						<tr class="h23"><td width="50">Option</td>
						<td width="" class="stm" style="font-size:12;">
						<input type="radio" name="opt_sel_bdr" value="Lane" class="trans" onClick="checkOption()" <%=sLandOptCheck %>>&nbsp;&nbsp;Lane  &nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="opt_sel_bdr" value="VVD" class="trans" onClick="checkOption()" <%=sVvdOptCheck %>>&nbsp;&nbsp;VVD</td>
						</tr>
						</table>
					</td>
					<td width="">
						<table border="0" style="width:769;display:none;" class="search" id="searchTable"> 
						<tr class="h23">
							<td width="10"></td>
							<td width="30">Lane</td>
							<td width="100">
									<script language="javascript">ComComboObject('cb_slan_cd', 1, 60, 0,1,0,true);</script>
									<script language="javascript" for="cb_slan_cd" Event='OnChange()'>getPortList();</script>
							</td>
							<td width="35">Bound</td>
							<td width="100">
									<script language="javascript">ComComboObject('cb_skd_dir_cd', 1, 50, 0,1,0,true);</script>
							</td>
							<td width="25">POL</td>
							<td width="">
									<script language="javascript">ComComboObject('cb_pol_cd', 1, 64, 0,1,0,true);</script>
							</td>
						</tr>
						</table>
						<table border="0" style="width:769;display:none;" class="search" id="searchTable" >
						<tr class="h23">
							<td width="10"></td>
							<td width="30">VVD</td>
							<td width="135"><input type="text" name="vvd" style="width:77;" class="input" value=""  style="ime-mode:disabled" dataformat=uppernum caption="VVD" maxlength="9"  fullfill>&nbsp;
							<img class="cursor"  src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_com_ens_ob2_pop"></td>
							<td width="25">POL</td>
							<td width="100">
								<script language="javascript">ComComboObject('pol_cd', 3, 64, 0,0,0,true);</script>
								<script language="javascript" for="pol_cd" Event='OnChange()'>selVvdPortVal();</script>
							</td>
							<td width="25">POD</td>
							<td width="100">
								<script language="javascript">ComComboObject('pod_cd', 1, 64, 0,0,0,true);</script>
							</td>
							<td width="35">LANE</td>
							<td width="70"><input type="text" name="slan_cd" style="width:40;" class="input2" value="" style="ime-mode:disabled" dataformat="engup" caption="LANE" maxlength="3"  fullfill readonly></td>
							<td width="25">ETD</td>
							<td width=""><input type="text" name="etd_cd"   style="width:130;" class="input2" value="" readonly></td>
						</tr>
						</TABLE>
					</td>
				</tr>
			</table>	
			
			
			
				<!--<table border="0" style="width:979;" class="search" id="searchTable"> 
				<tr class="h23">
				<td width="250">
					<table border="0" style="width:210;" class="search_sm"> 
					<tr class="h23"><td width="50">Option</td>
					<td width="" class="stm" style="font-size:12;">
					<input type="radio" name="opt_sel_bdr" value="Lane" class="trans" onClick="checkOption()" checked>&nbsp;&nbsp;Lane  &nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="opt_sel_bdr" value="VVD" class="trans" onClick="checkOption()">&nbsp;&nbsp;VVD</td>
					</tr>
					</table>
					
					</td>
				<td width="30">Lane</td>
				<td width="120">
						<script language="javascript">ComComboObject('cb_slan_cd', 1, 60, 0,1);</script>
						<script language="javascript" for="cb_slan_cd" Event='OnChange()'>getPortList();</script>
				</td>
				<td width="35">Bound</td>
				<td width="110">
						<script language="javascript">ComComboObject('cb_skd_dir_cd', 1, 50, 0,1);</script>
						<script language="javascript" for="cb_skd_dir_cd" Event='OnChange()'>getPortList();</script>
				</td>
				<td width="25">POL</td>
				<td width="">
						<script language="javascript">ComComboObject('cb_pol_cd', 1, 64, 0,1);</script>
				</td>
				</tr>
				</table>
				
				<table border="0" style="width:979;" class="search" id="searchTable"> 
				<tr class="h23">
				<td width="250">
					<table border="0" style="width:210;" class="search_sm"> 
					<tr class="h23"><td width="50">Option</td>
					<td width="" class="stm" style="font-size:12;">
					<input type="radio" name="opt_sel_bdr" value="Lane" class="trans" onClick="checkOption()" checked>&nbsp;&nbsp;Lane  &nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="opt_sel_bdr" value="VVD" class="trans" onClick="checkOption()">&nbsp;&nbsp;VVD</td>
					</tr>
					</table>
					</td>
				<td width="30">VVD</td>
				<td width="135"><input type="text" name="vvd" style="width:77;" class="input" value=""  style="ime-mode:disabled" dataformat=uppernum caption="VVD" maxlength="9"  fullfill>&nbsp;
				<img class="cursor"  src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_com_ens_ob2_pop"></td>
				<td width="25">POL</td>
				<td width="110">
					<script language="javascript">ComComboObject('pol_cd', 3, 64, 0,0);</script>
					<script language="javascript" for="pol_cd" Event='OnChange()'>selVvdPortVal();</script>
					<input type="text" name="pol_cd" style="width:49;" class="input1" value="" style="ime-mode:disabled" dataformat="engup" caption="POL" maxlength="5" required fullfill>
				</td>
				<td width="25">POD</td>
				<td width="120">
					<script language="javascript">ComComboObject('pod_cd', 1, 64, 0,0);</script>
					<input type="text" name="pod_cd" style="width:60;" class="input" value="" style="ime-mode:disabled" caption="POD" maxlength="5" dataformat="engup"  fullfill>
				</td>
				<td width="35">LANE</td>
				<td width="110"><input type="text" name="slan_cd" style="width:40;" class="input2" value="" style="ime-mode:disabled" dataformat="engup" caption="LANE" maxlength="3"  fullfill readonly></td>
				<td width="25">ETD</td>
				<td width=""><input type="text" name="etd_cd" dataformat="ymd"  style="width:110;" class="input2" value="" readonly></td>
				</tr>
				</table>
				
		
--><!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
	
	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable" style="display:none"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>	
			<!-- Grid (E) -->
			<% if (screenName.indexOf("Q") < 0){ %>
			<!--  Button_Sub (S) -->
			<table width="100%" class="button" id="rowButtonTable"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd1">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DeleteRow1">Delete Row</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
			<% } %>
	    	<!-- Button_Sub (E) -->
			<!--<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
				--><!-- Grid  (S) -->
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>	
				<!-- Grid (E) -->
			</td></tr>
		</table>
		
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;" id="buttonTable"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<% if (screenName.indexOf("Q") < 0){ %>
				<td class="btn1_line"></td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				
				<td>
				<table width="90" border="0" cellpadding="0" cellspacing="0" class="button"  style="visibility:none">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Creation">Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<% } %>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>