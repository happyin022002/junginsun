<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0045.jsp
*@FileTitle : (Korea) Samsung Invoice EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.05 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0045Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.AccountReceivableEDISend");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0045Event)request.getAttribute("Event");
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
<title>(Korea) Samsung Invoice EDI</title>
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

<input type="hidden" name="act_cust_cnt_cd" value="">
<input type="hidden" name="act_cust_seq" value="">
<input type="hidden" name="msg_id" value="FREINV">
<input type="hidden" name="buyr_rgst_no" value="">
<input type="hidden" name="buyr_co_nm" value="">
<input type="hidden" name="buyr_ceo_nm" value="">
<input type="hidden" name="buyr_addr1" value="">
<input type="hidden" name="buyr_addr2" value="">
<input type="hidden" name="snd_flg" value="">
<input type="hidden" name="upd_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="grid_bl_src_no" value="">
<input type="hidden" name="force_to_save" value="N">

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
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="70">VVD&nbsp;</td><!-- HNYT0032E, YUTM0023W INV_AR_EDI_GERP_HDR -->
					<td width="350" colspan="3"><input name="vvd" type="text" dataformat="engup" style="width:85" class="input1" value="" maxlength="9">&nbsp;
						<script language="javascript">ComComboObject('rcvr_id', 1, 150, 1, 1);</script>
					</td>
					<td width="85" align="right">전자문서&nbsp;</td>
					<td width="160"><input name="msg_id" type="text" style="width:100" class="input2" value="FREINV" readOnly></td>
					<td width="85" align="">문서번호&nbsp;</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('msg_no', 1, 150, 1, 1);</script></td>
				</tr>
				<tr class="h23">
					<td width="70" align="">청구일자&nbsp;</td>
					<td width="135"><input name="bil_dt" type="text" dataformat="ymd" style="width:80" class="input" value="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					<td width="80" align="right">Ex. Rate&nbsp;</td>
					<td width="135"><input name="inv_xch_rt" type="text" dataformat="float" style="width:120;text-align:right" class="input" value="" maxlength="12" pointcount="6" maxnum="99999999999"></td>
					<td width="85" align="right">S/A Date&nbsp;</td>
					<td width="160"><input name="sail_arr_dt" type="text" dataformat="ymd" style="width:100" class="input" value=""></td>
					<td width="" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="revised_amount" type="checkbox" value="Y" class="trans"> Retrieve for revised amount</td>
				</tr>
				<tr class="h23">
					<td width="" align="">원본여부&nbsp;</td>
					<td width="" colspan="5" style="padding-left:2"><script language="javascript">ComComboObject('inv_msg_func_cd', 1, 80, 0);</script></td>
					<!--td width="" align="">영수/청구&nbsp;</td>
					<td width="" colspan="3" style="padding-left:2"><script language="javascript">ComComboObject('combo1', 1, 80, 0);</script></td-->
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="70" align="">청구금액&nbsp;</td>
					<td width="185" class="stm">OFT(USD)&nbsp;<input name="bil_oft_amt" type="text" dataformat="float" style="width:100;text-align:right" class="input2" pointcount="2" value="0" readOnly></td>
					<td width="188" class="stm">CHG(KRW)&nbsp;<input name="bil_chg_amt" type="text" dataformat="int" style="width:100;text-align:right" class="input2" value="0" readOnly></td>
					<td width="" class="stm">세액(KRW)&nbsp;<input name="bil_tax_amt" type="text" dataformat="int" style="width:100;text-align:right" class="input2" value="0" readOnly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="70" align="">업체명&nbsp;</td>
					<td width="350"><input name="locl_nm" type="text" style="width:300" class="input2" value="" readOnly></td>
					<td width="85" align="right">RGST No.&nbsp;</td>
					<td width="160"><input name="cust_rgst_no" type="text" style="width:100" class="input2" value="" readOnly></td>
					<td width="55" align="">E-Sign&nbsp;</td>
					<td width=""><input name="e_sign" type="text" style="width:180" class="input2" value="" readOnly></td>
				</tr>
				<tr class="h23">
					<td width="" align="">주소&nbsp;</td>
					<td width="" colspan="3"><input name="bzet_addr" type="text" style="width:535" class="input2" value="" readOnly></td>
					<td width="" align="">대표자&nbsp;</td>
					<td width=""><input name="ownr_nm" type="text" style="width:180" class="input2" value="" readOnly></td>
				</tr>
				<!--tr class="h23">
					<td width="" align="">담당자&nbsp;</td>
					<td width="190"><input name="srep_nm" type="text" style="width:123" class="input" value=""></td>
					<td width="85" align="">TEL&nbsp;</td>
					<td width="130"><input name="rcvr_phn_no" type="text" style="width:100" class="input" value=""></td>
					<td width=""></td>
					<td width="" colspan="3"></td>
				</tr-->
				</table>
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="70" align="">Remark(s)&nbsp;</td>
					<td width="595"><input name="edi_hdr_rmk" type="text" style="width:535" class="input" value=""></td>
					<td width="110" align="">Validation Check&nbsp;</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('gerp_val_flg', 1, 45, 0);</script></td>
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
				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
				<tr>
					<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
									<td class="btn2_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_RowDelete">Row&nbsp;Delete</td>
									<td class="btn2_right"></td>
								</tr>
							</table></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- Button_Sub (E) -->
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
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
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
		</tr>
		</table>
	</td>
</tr>
</table>
<div style="display:none">
<table width="100%"  id="mainTable">
<tr>
	<td width="100%">
		<script language="javascript">ComSheetObject('sheet2');</script>
	</td>
</tr>
</table>
</div>
<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>