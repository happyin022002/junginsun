<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0113.jsp
*@FileTitle : EDI Submission(GLOVIS)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.26
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2009.10.05 이석준
* 1.0 Creation
* History
* 2011.11.30 권 민 [CHM-201114839] [INV] Glovis Invoice EDI 전송 기능 보완
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0113Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0113Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm	= "";
	String strUsr_eml    = "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.AccountReceivableEDISend");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_locl_nm();
		strUsr_eml= account.getUsr_eml();
		strOfc_cd = account.getOfc_cd();

		event = (FnsInv0113Event)request.getAttribute("Event");
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
<title>EDI Submission(GLOVIS)</title>
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

<input type="hidden" name="act_cust_cnt_cd" value="KR">
<input type="hidden" name="act_cust_seq" value="51157">
<input type="hidden" name="msg_id" value="FREINV">
<input type="hidden" name="buyr_rgst_no" value="">
<input type="hidden" name="buyr_co_nm" value="">
<input type="hidden" name="buyr_ceo_nm" value="">
<input type="hidden" name="buyr_addr1" value="">
<input type="hidden" name="buyr_addr2" value="">
<input type="hidden" name="snd_flg" value="">
<input type="hidden" name="upd_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="grid_bl_src_no" value="">
<input type="hidden" name="btn_flag" value="">
<input type="hidden" name="edi_type" value="">
<input type="hidden" name="ar_ofc_cd" value="SELSC">
<input type="hidden" name="eur_gubun" value="">
<input type="hidden" name="user_ofc_cd" value="<%=strOfc_cd %>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> 
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> 
		</table> 
		<!--Page Title, Historical (E)--> 
		<!--biz page (S)-->
		<table class="search" id="mainTable">
		<tr>
			<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
				    <td >조회조건&nbsp;</td>
					<td >		            
		                  <select name="rtv_opt" class = "input1">
                            <option value="SAIL" selected> S/A Date
                            <option value="EDI"> EDI 전송일
                            <option value="BL"> B/L No
                            <option value="INV"> Invoice NO
                          </select>
		            </td>
					<td ><input name="cre_fm_dt" dataformat="ymd" required maxlength="8" type="text"  class="input1" style="width:87;text-align:center" value="" cofield="cre_to_dt" caption="start date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~
					     <input name="cre_to_dt" dataformat="ymd" required maxlength="8" type="text"  class="input1" style="width:85;text-align:center" value="" cofield="cre_fm_dt" caption="end date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
		            </td>
		            <td >EDI 전송&nbsp;</td>
		            <td > 
		                  <select name="edi_send_ind">
                            <option value="A" selected> ALL
                            <option value="Y"> YES
                            <option value="N"> NO
                          </select>
		            </td>	
		            <td >Bound&nbsp;</td>
		            <td > 
		                  <select name="io_bnd_cd">
                            <option value="O" selected> O/B
                            <option value="I"> I/B                   
                          </select>
		            </td>
		            <td >EUR구분&nbsp;</td>
		            <td > 
		                  <select name="eur_gubun_flg">
                            <option value="A" selected> ALL
                            <option value="Y"> YES
                            <option value="N"> NO
                          </select>
		            </td>	
                    <td align="right">전자문서&nbsp;</td>
					<td ><input name="msg_id" type="text" class="input2" style="width:55;text-align:center" value="FRTINV" readOnly></td>
					<td style="visibility:hidden">청구형태&nbsp;</td>
					<td style="visibility:hidden">
						<input type="radio" name="send_type"  class="trans" value ="ALL" disabled> 묶음</input>
						<input type="radio" name="send_type"  class="trans" value ="SPC" checked> 개별</input>
					</td>					
				</tr>
				<tr class="h23">
				    <td></td>
				    <td></td>
					<td><input name="bl_src_no" type="text"  style="width:200" class="input2" dataformat="engup" disabled></td>				
		            <td></td>
		            <td></td>	
		            <td></td>
		            <td></td>		            				
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>			
			<table class="search" border="0" style="width:900;">
				<tr class="h23">
					<td width="100" align="">청구일자&nbsp;</td>
					<td style="padding-left:3"><input name="edi_snd_dt" type="text" dataformat="ymdhms"  class="input2" style="width:120;text-align:center" value="" readonly></td>
					<td width="90" >Ex. Rate(USD)&nbsp;</td>
					<td ><input name="inv_xch_rt"       type="text" dataformat="float" style="width:120;text-align:right" class="input" value="0.00" maxlength="12" pointcount="6" maxnum="99999999999"></td>
					<td  align="right">Ex. Rate(EUR)&nbsp;</td>
					<td ><input name="euro_locl_xch_rt" type="text" dataformat="float" style="width:120;text-align:right" class="input" value="0.00" maxlength="12" pointcount="6" maxnum="99999999999"></td>					
				</tr>
				<tr class="h23">
					<td width="100" >청구금액&nbsp;</td>
					<td class="stm" style="padding-left:3" >FRT(USD)&nbsp;<input name="bil_oft_amt" type="text" dataformat="float" style="width:100;text-align:right" class="input2" pointcount="2" value="0" readOnly></td>
					<td class="stm" colspan="2" style="padding-left:2">CHG(KRW)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="bil_chg_amt" type="text" dataformat="int" style="width:100;text-align:right" class="input2" value="0" readOnly></td>					
					<td  align="right">S/A Date&nbsp;</td>
					<td ><input name="sail_arr_dt" type="text" dataformat = "ymd" maxlength="8" class="input" style="width:90;text-align:center" value=""></td>
				</tr>				
				<tr class="h23">
					<td >업체명&nbsp;</td>
					<td style="padding-left:1"><input name="cust_locl_lang_nm" type="text" style="width:200" class="input2" value="(주)한진해운 한국지점" readOnly></td>
					<td width="70">RGST No.&nbsp;</td>
					<td><input name="cust_rgst_no" type="text" class="input2" style="width:100;text-align:center"value="104-85-21890" readOnly></td>
					<td align="right" valign="middle"><input name="usr_id" type="text" class="input2" style="width:80;text-align:center;padding-top:3" value="<%=strUsr_nm%>" readOnly></td>
					<td ><input name="usr_eml" type="text" style="width:180" class="input" value="<%=strUsr_eml%>"></td>
				</tr>
				<tr class="h23">
					<td >글로비스 담당자&nbsp;</td>
					<td style="padding-left:1"><input name="cust_nm" type="text" style="width:100" class="input" value="" ></td>
					<td >Email&nbsp;</td>
					<td ><input name="cust_eml" type="text" style="width:180" class="input" value="" ></td>
					<td></td>
					<td></td>
				</tr>
				<tr class="h23">
					<td >Remark(s)&nbsp;</td>
					<td colspan="5"><textarea name="inv_rmk" style="width:100%" type="text"></textarea></td>
					
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
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
				<!-- Grid (E) -->
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<!--biz page (E)-->
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
<tr>
	<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SendBL">Send</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ediCancel">EDI Cancel</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>			
		</tr>
		</table>
	</td>
</tr>
</table>
<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>