<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0484.jsp
*@FileTitle : ESM_BKG_0484
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.26
*@LastModifier : 경종윤
*@LastVersion : 1.2
* 2009.10.08 경종윤
* 1.0 Creation
*--------------------------------------------------------
* History
* 1.1 2011.02.23 이일민 [CHM-201108294] 구주 EU24 관련 SITPRO 수정 요청 (ENS Download 버튼 추가)
* 1.2 2011.05.26 민정호 [CHM-201111097] [SITPRO] MRN정보 Tick박스 생성 (Tick마크시, Excel 다운로드시 포함)
* 2013.11.18 김보배 [CHM-201327127] [RFS Lane] Double calling logic 적용 요청 (2) SItpro & Firm BKG
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event.EsmBkg0484Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0484Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CustomsTransmission");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EsmBkg0484Event)request.getAttribute("Event");
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
<input type="hidden" name="call_type" value="ESM_BKG_0484">
<input type="hidden" name="ofcCd" value="<%= strOfc_cd %>">
<input type="hidden" name="bnd_cd">
<input type="hidden" name="p_vvd_cd">
<input type="hidden" name="p_ori_amd_cd" value="O">
 
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
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Option</td>
					<td width="">
						<table class="search_sm2" border="0" style="width:380"> 
						<tr class="stm">
				   	    <td width="90"><input type="radio" name="p_option" value="SP" class="trans" checked>SitPro</td>
						<td width=""><input type="radio" name="p_option" value="DL" class="trans">ENS Download for Feeder</td>
						<td width="">(<input type="checkbox" name="mrn" value="" class="trans" disabled="true">Incl. SML MRN)</td>						
						</tr>	
						</table>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">VVD</td>
					<td width="90">
						<input type="text" style="width:80; ime-mode: disabled" class="input1" value="" name="vvd_cd"
						dataformat="eng" maxlength="9" fullfill caption="VVD">
					</td>
					<td width="320">
						<table class="search_sm2" border="0" style="width:310;"> 
							<tr class="h23">
								<td width="120">
									&nbsp;POL&nbsp;<input type="text" style="width:50; ime-mode:disabled;" class="input1" value="" name="pol_cd"
									dataformat="engupnum" maxlength="5" fullfill caption="POL">
									<input type="text" style="width:25;" value="" class="input" name="pol_yd_cd" maxlength='2' dataformat='engupnum'>
								</td>
								<td width="120">
									POD&nbsp;<input type="text" style="width:50; ime-mode:disabled;" class="input1" value="" name="pod_cd"
									dataformat="engupnum" maxlength="5" fullfill caption="POD">
									<input type="text" style="width:25;" value="" class="input" name="pod_yd_cd" maxlength='2' dataformat='engupnum'>
								</td>
								<td width="60" >
									(<input type="checkbox" value="" class="trans" name="check_ts_search">T/S)
									<input type="hidden" name="ts_search_flag">
								</td>								
							</tr>
						</table>
					</td>
					<td width="25">POR</td>
					<td width="100">
						<input type="text" style="width:80; ime-mode:disabled;" class="input" value="" name="por_cd"
						dataformat="engupnum" maxlength="5" fullfill caption="POR">
					</td>
					<td width="25">DEL</td>
					<td width="100">
						<input type="text" style="width:80; ime-mode:disabled;" class="input" value="" name="del_cd"
						dataformat="engupnum" maxlength="5" caption="DEL">
					</td>
					<td width="160">POFE (Port of First Entry)</td>
					<td width="">
						<script language="javascript">ComComboObject('p_pod_cd_temp', 1, 100, '');</script>
						<input type="hidden" name="p_pod_cd">
						<input type="hidden" name="p_pod_yard_cd">
						<input type="hidden" name="p_search_pofe_yard_cd">
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">BKG No.</td>
					<td width="136">
						<input type="text" style="width:100; ime-mode:disabled;" class="input" name="bkg_no"
						dataformat="eng" maxlength="13" caption="BKG No.">
					</td>
					<td width="50">B/L No.</td>
					<td width="142">
						<input type="text" style="width:94; ime-mode:disabled;" class="input" value="" name="bl_no"
						dataformat="eng" maxlength="12" fullfill caption="B/L No.">
					</td>
					<td width="70">BKG OFFICE</td>
					<td width="132">
						<input type="text" style="width:80; ime-mode:disabled;" class="input2" value="<%= strOfc_cd %>" name="bkg_ofc_cd" readOnly
						dataformat="engup" maxlength="6" caption="BKG OFFICE">
					</td>
					<td width="90">BKG STATUS</td>
					<td width=""><select style="width:80;" name="bkg_sts_cd">
						<option value="" selected>ALL</option>
						<option value="F">Firm</option>
						<option value="W">Wait</option>
						<option value="S">Split (Memo)</option>
						</select></td>
					<td width="95">CGO STATUS</td>
					<td width=""><select style="width:80;" name="bkg_cgo_tp_cd">
						<option>All</option>
			            <option value="F" selected>Full</option>
			            <option value="P">Empty</option>
						</select></td>					
				</tr>
				</table>
				
												
					
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
												
				
				
				</td></tr>
			</table>
				
		
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_sitpro">SitPro</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownENS">ENS Download</td>
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
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<span style="display:none">
		<script language="javascript">ComSheetObject('sheet2');</script>
		<script language="javascript">ComSheetObject('sheet3');</script>
		<script language="javascript">ComSheetObject('sheet4');</script>		
	</span>
</form>
</body>
</html>
