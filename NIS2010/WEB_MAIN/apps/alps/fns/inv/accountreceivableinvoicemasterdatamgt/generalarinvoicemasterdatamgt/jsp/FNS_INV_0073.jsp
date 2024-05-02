<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0073.jsp
*@FileTitle : A/R Office Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.09 한동훈
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2012.01.03 권   민 [CHM-201115278] Split 01-환율 적용관련 보완 요청(AR INV & ERP AR)
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0073Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0073Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.GeneralARInvoiceMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0073Event)request.getAttribute("Event");
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
<title>A/R Office Code Management</title>
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
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="proc_gb">
<input type="hidden" name="ar_ofc_cd">
<input type="hidden" name="inv_snd_tp_cd">
<input type="hidden" name="modifyGb">
<input type="hidden" name="chg_cd">
<input type="hidden" name="chk_chg_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
<!--Page Title, Historical (E)-->
	
	
					
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">AR Office</td>
					<td width="">
						<!-- 
						<input type="text" name="ar_ofc_cd" style="width:74;" class="input1" value="HAMUR">
						-->
						<script language="javascript"  style="ime-mode:disabled" dataformat="uppernum">ComComboObject('ar_ofc_cd2', 1, 100, 0, 1, 0, true);</script>
					</td>
					</tr>
				</table>
				
			<table class="line_bluedot"><tr><td colspan="6"><br><br></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="140">추가 Invoice 발행 금액</td>
					<td width="290"><select name="inv_iss_tp_cd" style="width:210;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="S">Summary 발행</option>
						<option value="E">개별 발행(+),(-)</option>
						</select></td>
					<td width="130">Copy Inv 매수</td>
					<td width="90"><input type="text" name="cpy_inv_knt" style="width:50;" class="input" dataformat="num" maxlength="2" onchange="modify_gb();"></td>
					<td>
						<table class="search_sm2" border="0" style="width:320;"> 
							<tr class="h23">
							<td width="120">Invoice Send By</td>
							<td class="stm">
								<input type="radio" name="inv_snd_tp_cd1" class="trans" onchange="modify_gb();">Paper&nbsp;&nbsp;
								<input type="radio" name="inv_snd_tp_cd1" class="trans" onchange="modify_gb();">E-mail&nbsp;&nbsp;
								<input type="radio" name="inv_snd_tp_cd1" class="trans" onchange="modify_gb();">Fax
							</td>
							</tr>
						</table>
					</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">환율 타입</td>
					<td width="150" class="stm">USD&nbsp;&nbsp;
						<select name="xch_rt_usd_tp_cd" style="width:105;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="V">VVD 환율</option>
						<option value="A">경리환율</option>
						<option value="D">Daily 환율</option>
						<option value="F">고정 환율</option>
						<option value="C">China 환율</option>
						<option value="P">Period 환율</option>
						</select>
					<td width="180" class="stm">&nbsp;&nbsp;&nbsp;3RD&nbsp;&nbsp;
						<select name="xch_rt_n3rd_tp_cd" style="width:107;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="V">VVD 환율</option>
						<option value="A">경리환율</option>
						<option value="D">Daily 환율</option>
						<option value="F">고정 환율</option>
						<option value="C">China 환율</option>
						<option value="P">Period 환율</option>
						</select></td>
					<td width="110">환율 Inverse Flag</td>
					<td width=""><select name="xch_rt_rvs_flg" style="width:50;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>
					<td>
						<table class="search_sm2" border="0" style="width:377;"> 
							<tr class="h23">
							<td width="327">Invoice E-mail(PDF file) transmission</td>
							<td class="stm">
								<input type="radio" name="inv_eml_split_flg" class="trans" onchange="modify_gb();">Merge&nbsp;&nbsp;
								<input type="radio" name="inv_eml_split_flg" class="trans" onchange="modify_gb();">Separate
							</td>
							</tr>
						</table>
					</td>	
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="100">OTS 정산 단위</td>
						<td width="100"  class="stm"><select name="ots_smry_cd" style="width:87;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="BL">B/L</option>
						<option value="INV">INV</option>
						<option value="CLR">SYS CLEAR</option>
						</select></td>
						<td width="140">INV 중복 발행</td>
						<td width="85"><select name="inv_dup_flg" style="width:50;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="N">N</option>
						<option value="Y">Y</option>
						</select></td>
						<td width="140">MULTI B/L INV 발행</td>
						<td width="90"><select name="inv_mlt_bl_iss_flg" style="width:50;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="N">N</option>
						<option value="Y">Y</option>
						</select></td>
						<td width="140">TMNL INV No. 생성</td>
						<td width="225"><select name="tml_inv_iss_flg" style="width:50;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="N">N</option>
						<option value="Y">Y</option>
						</select></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">DMT I/F 단위</td>
						<td width="100"><select name="dmdt_inv_aply_bl_flg" style="width:87;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="N">B/L</option>
						<option value="Y">INV</option>
						</select></td>
						<td width="130">DMT AR INV No. 생성</td>
						<td width="80"><select name="dmdt_ar_inv_iss_flg" style="width:50;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="N">N</option>
						<option value="Y">Y</option>
						</select></td>
						<td width="125">TPB AR INV No. 생성</td>
						<td width="80"><select name="n3pty_bil_ar_inv_flg" style="width:50;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="N">N</option>
						<option value="Y">Y</option>
						</select></td>
						<td width="160">Office Group E-mail (O/B) </td>
						<td width="92"><input type="text" name="ar_ofc_ob_grp_eml" style="width:180;" class="input" maxlength="200" onchange="modify_gb();">
						</td>	
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="100">VAT Rate</td>
						<td width="330">
							<script language="javascript">ComComboObject('inv_vat_chg_cd', 1, 100, 0, 0, 0, true);</script>&nbsp;
							<!-- input type="text" name="inv_vat_chg_cd" style="width:50;" class="input" style="ime-mode:disabled" dataformat="engup" maxlength="3" onchange="modify_gb();">-->
							<input type="text" name="inv_vat_chg_rt" style="width:120;" class="input" style="text-align:right;" dataformat="float" onchange="modify_gb();" maxlength="10"  size="7"   pointcount="4" minnum="0" maxnum="99999.9999"> (%)
						</td>
						<td width="140">MNR AR INV No. 생성</td>
						<td width="90"><select name="mnr_ar_inv_iss_flg" style="width:50;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="N">N</option>
						<option value="Y">Y</option>
						</select></td>		
						<td width="172">Office Group E-mail (I/B)</td>
						<td width="92"><input type="text" name="ar_ofc_ib_grp_eml" style="width:180;" class="input" maxlength="200" onchange="modify_gb();">
						</td>				
						<td>&nbsp;</td>						
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="140">DOD AR INV No. 생성</td>
						<td width="200"><select name="dod_ar_inv_iss_flg" style="width:50;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="N">N</option>
						<option value="Y">Y</option>
						</select></td>		
						<td>&nbsp;</td>	
						<td width="140">MRI Local Charge 허용</td>
						<td width="90"><select name="mri_locl_chg_aply_flg" style="width:50;" class="input" onchange="modify_gb();">
						<option value="" selected></option>
						<option value="N">N</option>
						<option value="Y">Y</option>
						</select></td>	
						<td width="172"> </td>
						<td width="92"> </td>				
						<td>&nbsp;</td>						
					</tr>
				</table>
				<div style="display:none">
				<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
				<!-- Grid (E) -->
				</div>
				<!-- biz_1 (E) -->
				<table class="line_bluedot"><tr><td colspan="6"><br><br></td></tr></table>
				<!-- Grid (S) -->
				<table width="70%"  id="mainTable">
					<tr class="h23">
						<td width="14%">MRI Control</td>
						<td width="85%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				<!--  Button_Sub (S) -->
				<table width="70%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Delete">Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
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
				<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				
				</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>

</td></tr>
</table>



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>