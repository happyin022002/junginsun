<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0229_06.jsp
*@FileTitle : e-Booking & SI Process Detail(TRO/O)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.22 전용진
* 1.0 Creation
* 20091101 modified by 이남경 
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022906Event"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg022906Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");
	String sXml = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg022906Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking & SI Process Detail(TRO/O)</title>
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
<input type="hidden" name="rqst_seq"  value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="tro_seq"   value="">
<input type="hidden" name="tro_alps"   value="">
<input type="hidden" name="tro_esvc"  value="">
<!-- 개발자 작업	-->
<input type="hidden" name="is_eur_flg"   value="N">
<input type="hidden" name="alps_eur_cnt" value="0">
<input type="hidden" name="cxl_flg"      value="N">

<input type="hidden" name="conti_cd"       value=""><!-- 대륙코드 : Booking정보 -->
<input type="hidden" name="f_del_flg"      value="N"><!-- 고정값 : delFlg -->
<input type="hidden" name="io_bnd_cd"      value="O"><!-- 화면별 고정 hidden parmam -->
<input type="hidden" name="rtn_tro_flg"    value="N"><!-- 화면별 고정 hidden parmam -->
<input type="hidden" name="curr_tro_seq"   value="">

<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="l_trans_result_key" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">
	<tr><td valign="top">
		<!--biz page (S)-->
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable" style="width:958;height:600;">
       		<tr><td class="bg" valign="top">
			
				<table class="search" border="0" style="width:958;"> 
				<tr class="h23">
					<td width="480" valign="top">
					<!--  biz_1  (S) -->
					<table class="search" border="0">
						<tr>
							<td width="240"><table class="search" border="0">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Booking Data ALPS</td>
								</tr>
								<tr><td class="height_5"></td></tr>
							</table></td>
							<td  width="240" align="right"><table width="150"  border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_cancelcopydata" id="btn_cancelcopydata">Cancel&nbsp;Copy&nbsp;Data</td>
								<td class="btn2_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					<table class="search_ssm" border="0" style="width:480;">
					<tr class="h23"><td>
						<table class="search" border="0">
							<tr class="h23">
								<td width="90">Seq.&nbsp;
								<select name="alps_seq" style="width:40;" onChange="javascript:change_seq('sheet3', this)" onClick="javascript:click_seq(this)">&nbsp;
								</select>
								</td>
								<td width="80">Booking No.</td>
								<td width="330"><input type="text" name="bkg_no" style="width:105;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="100" colspan="2">Self Truck<input type="checkbox" name="self_trk" value="Y" class="trans"></td>
								<td width="100">Status</td>
								<td><input type="text" style="width:50;" name="tro_status" class="input2"></td>
							</tr>
							<tr class="h23">
								<td width="100">Request Result</td>
								<td width="140"><input type="text" name="request_result" style="width:130;" class="input2" value="" readOnly></td>
								<td width="100">Request Date</td>
								<td width=""><input type="text" name="request_date" style="width:110;" class="input2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td>Actual Shipper</td>
								<td colspan="3" align="left"><input type="text" name="act_sh" style="width:93%;" maxlength="500" class="input" dataformat="etc" value="">
								<img src="img/btns_search.gif" name="btns_popActCust" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" tabindex=-1>
								</td>
							</tr>
							<tr class="h23">
								<td>Contact Person</td>
								<td colspan="3" align="right"><input type="text" name="cntc_pson" style="width:100%;" maxlength="50" class="input" dataformat="etc" value=""></td>
							</tr>
							<tr class="h23">
								<td>Tel.</td>
								<td colspan="3" align="right"><input type="text" name="tel" style="width:100%;" maxlength="20" class="input" dataformat="tel" value=""></td>
							</tr>
							<tr class="h23">
								<td>Mobile Phone</td>
								<td colspan="1" align="right"><input type="text" name="mobile" style="width:100%;" maxlength="20" class="input" dataformat="tel" value=""></td>
								<td align="right">ZIP </td>
								<td colspan="1" align="right"><input type="text" name="dor_pst_no" style="width:100%;" maxlength="12" class="input" dataformat="etc" value=""></td>
							</tr>
							<tr class="h23">
								<td valign="top">Address</td>
								<td colspan="3" align="right"><textarea name="addr" style="width:100%;height:40" dataformat="etc" maxlength="120" ></textarea></td>
							</tr>
							<tr class="h23">
								<td valign="top">Remark(s)</td>
								<td colspan="3" align="right"><textarea name="rmk" style="width:100%;height:40" dataformat="etc" maxlength="1000" ></textarea></td>
							</tr>
						</table>
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 
						<!-- : ( Grid ) (E) -->	
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
    						<tr><td class="btn2_bg">
								<table width="100%"  border="0" cellpadding="0" cellspacing="0">
									<tr align="right">
										<td width="300"></td>
										<td width="50"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_add" id="btn_add">Add</td>
											<td class="btn2_right"></td>
											</tr>
										</table></td>
										<td width="50"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
											<td class="btn2_left"></td>
												<td class="btn2" name="btn_del" id="btn_del">Del</td>
												<td class="btn2_right"></td>
											</tr>
										</table></td>
										<td width="60"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
												<td class="btn2" name="btn_copy" id="btn_copy">Copy</td>
												<td class="btn2_right"></td>
											</tr>
										</table></td>
										<td width="50"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
												<td class="btn2" name="btn_split" id="btn_split">Split</td>
												<td class="btn2_right"></td>
											</tr>
										</table></td>
									</tr>
								</table>
							</td></tr>
						</table>
 						<!-- Button_Sub (E) -->						
					</td></tr>
					</table>
					<!--  biz_1  (E) -->
					</td>
					<td width="12">&nbsp;</td>
					<td width="479" valign="top">
					<!--  biz_2  (S) -->
					<table class="search" border="0">
						<tr>
							<td width="240"><table class="search" border="0">
								<tr><td class="title_h"></td>
									<td class="title_s">From e- Service</td></tr>
								<tr><td class="height_5"></td></tr>
							</table></td>
							<td  width="240" align="right">
								<table width="150" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_datacopytoalps" id="btn_datacopytonis">Data&nbsp;Copy&nbsp;to&nbsp;ALPS</td>
									<td class="btn2_right"></td>
								</tr></table>
							</td>
						</tr>
					</table>
					<table class="search_ssm1" border="0" style="width:479;" height="100%">
					<tr class="h23"><td valign="top">
						<table class="search" border="0">
							<tr class="h23">
								<td width="90">Seq.&nbsp;
								<select name="xter_seq" style="width:40;" onChange="javascript:change_seq('sheet4', this)">
								</select>
								</td>
								<td width="80">Request No.</td>
								<td width=""><input type="text" name="rqst_no" style="width:105;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr class="h23">
								<td width="" colspan="4">Self Truck<input type="checkbox" name="self_trk2" value="" class="trans" readOnly></td>
							</tr>
							
							<tr class="h23">
								<td width="100">Actual Shipper</td>
								<td colspan="3" align="right"><input type="text" name="act_sh2" style="width:100%;" class="input2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td>Contact Person</td>
								<td colspan="3" align="right"><input type="text" name="cntc_pson2" style="width:100%;" class="input2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td>Tel.</td>
								<td colspan="3" align="right"><input type="text" name="tel2" style="width:100%;" class="input2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td>Mobile Phone</td>
								<td colspan="1" align="left"><input type="text" name="mobile2" style="width:160;" class="input2" value="" readOnly></td>
								<td align="right" width="100">ZIP </td>
								<td colspan="1" align="right"><input type="text" name="dor_pst_no2" style="width:100;" class="input2" value="" readOnly></td>
							</tr>
							<tr class="h23">
								<td valign="top">Address</td>
								<td colspan="3" align="right"><textarea name="addr2" style="width:100%;height:40" class="textarea2" readOnly></textarea></td>
							</tr>
							<tr class="h23">
								<td valign="top">Remark(s)</td>
								<td colspan="3" align="right"><textarea name="rmk2" style="width:100%;height:40" class="textarea2" readOnly></textarea></td>
							</tr>
						</table>
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100"></td>
								<td width="78%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>  
						<!-- : ( Grid ) (E) -->	
					</td></tr>
					</table>
					<!--  biz_2  (E) -->
					
					</td></tr>
				</table>
			</td></tr>
		</table>		
		<!--Button (S) : test... save-->
		<!-- <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
	       	<tr><td class="btn1_bg">		
			    <table border="0" cellpadding="0" cellspacing="0">
				    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_upload" id="btn_upload">Upload</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td></tr>
				</table>
			</td></tr>
		</table> -->
    	<!--Button (E) -->			
		<!-- Grid BG Box  (S) -->
		<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table>  
		<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet4');</script>
				</td>
			</tr>
		</table>  	
		<!--biz page (E)-->
	</td></tr>
</table>

</form>	
</body>
</html>