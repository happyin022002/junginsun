<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0296.jsp
*@FileTitle : ESM_BKG_0296
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.20 경종윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0296Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0296Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
	   
	   
		event = (EsmBkg0296Event)request.getAttribute("Event");
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
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cmd_detail">

<input type="hidden" name="cnt_cd" value="<%=strCnt_cd %>">

<!-- 개발자 작업	-->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)-->	
	
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">VVD</td>
					<td width="181">
						<input type="text" style="width:110;ime-mode: disabled;" class="input1" name="vvd_cd" value=""
						required dataformat="eng" maxlength="9" fullfill caption="VVD">
					</td>
					<td width="64">POL</td>
					<td width="131">
						<input type="text" style="width:80;ime-mode: disabled;" class="input" name="pol_cd" value=""
						dataformat="engupnum" caption="POL" fullfill maxlength="5">
					</td>
					<td width="54">POD</td>
					<td width="147">
						<input type="text" style="width:80;ime-mode: disabled;" class="input1" name="pod_cd" value=""
						required dataformat="engupnum" caption="POD" fullfill maxlength="5">
					</td>
					<td width="75">Entry Type</td>
					<td width="150">
						<script language="javascript">ComComboObject('entry_type',1,100);</script>
					</td>
					<td>Empty&nbsp;&nbsp;<input type="checkbox" class="trans" name="empty_check"></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">IGM No.</td>
					<td width="180"><input type="text" style="width:110;ime-mode: disabled;" class="input2"  readOnly="true" name="igm_no" ></td>
					<td width="65">IGM Date</td>
					<td width="130"><input type="text" style="width:80;ime-mode: disabled;" class="input2" readOnly="true" name="igm_date" ></td>
					<td width="55">Line No.</td>
					<td width="190" class="sm">
						<input type="text" style="width:80;ime-mode: disabled;" class="input" name="from_line_no" dataformat="int" maxlength="4" caption="Line No.">&nbsp;&nbsp;~&nbsp;&nbsp;
						<input type="text" style="width:80;ime-mode: disabled;" class="input" name="to_line_no" dataformat="int" maxlength="4" caption="Line No.">
					</td>
					<td>
					
						<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btns_assign">Assign</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr> 
				</table>				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Vessel Name</td>
					<td width="376"><input type="text" style="width:325;ime-mode: disabled;" class="input2"  readOnly="true" name="vsl_nm" ></td>
					<td width="54">ETA</td>
					<td width="147"><input type="text" style="width:80;ime-mode: disabled;" class="input2" readOnly="true" name="eta_dt" ></td>
					<td width="73">Total B/L</td>
					<td><input type="text" style="width:60;ime-mode: disabled;" class="input2" readOnly="true" name="tot_bl_num" ></td>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<!-- 1 (E) -->
		
		<!-- 2 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) -->  
		
		
<!--TAB B/L (S) -->
<div id="tabLayer" style="display:inline">		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	

			<!-- Grid (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->	
			
			</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)-->
</div>
<!--TAB B/L (E) --> 	






<!--TAB CNTR (S) -->
<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	

			<!-- Grid (S) --> 
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->	
			
			
		
				<table class="search" border="0" style="width:100%;"> 
				<tr><td height="3"></td></tr>
				<tr class="h23">
					<td align="right">CNTR&nbsp;&nbsp;</td>
					<td width="85" class="stm"><input type="text" style="width:50; text-align:center;" class="input" name="f_cnt">&nbsp;&nbsp;F</td>
					<td width="80" class="stm"><input type="text" style="width:50; text-align:center;" class="input" name="t_cnt">&nbsp;&nbsp;T</td>
				</tr> 
				</table>	
			
			
			</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)-->
</div>
<!--TAB CNTR (E) --> 	




		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_formset">Form Set</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_formprint">Form III Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_igmedi">IGM EDI</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_request">TP Request (EDI)</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cntrlist">CNTR List</td>
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
	


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
