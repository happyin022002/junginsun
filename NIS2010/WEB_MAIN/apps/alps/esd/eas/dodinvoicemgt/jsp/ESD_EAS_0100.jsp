<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0100.jsp
*@FileTitle : (KOR) DOD Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.09.11 
* 1.0 최초 생성 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%> 
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0100Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsdEas0100Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String mrd_path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1004.mrd";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc      = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc 	= account.getOfc_cd();
		
		event = (EsdEas0100Event)request.getAttribute("Event");
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
<title>(KOR) DOD Invoice Issue</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_no">

<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="cust_cntc_pnt_seq">
<input type="hidden" name="cntc_pnt_nm">

<input type="hidden" name="inv_curr_cd" value="KRW">
<input type="hidden" name="dod_inv_sts_cd" value="I">
<input type="hidden" name="session_ofc_cd" 	value="<%=strUsr_ofc%>">

<input type="hidden" name="mrd" value="<%=mrd_path%>">
<input type="hidden" name="rd_name" value="ESD_EAS_1004.mrd">
<input type="hidden" name="rd_parm">
<input type="hidden" name="send_flg">
<input type="hidden" name="dod_inv_no">
<input type="hidden" name="pol_conti_cd">
<input type="hidden" name="inv_rmk">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="Invoice Print">
<input type="hidden" name="com_mrdBodyTitle" value="Invoice Print">
<!-- <input type="hidden" name="cntc_pnt_eml"> 이메일이 화면에서 제외되면서 히든으로 :: 화면에서 보여주기 때문에 hidden필드 삭제  --> 
<input type="hidden" name="cust_rgst_no_old">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
	<td valign="top">
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
				<tr><td>
				<table> 
				<tr class="h23">
					<td width="73">B/L No</td>
					<td width="134"><input type="text" style="width:123;text-align:left;" class="input1" name="in_bl_no" value="" dataformat="uppernum" maxlength="12"></td>
					<td width="73">Tariff OFC</td>
					<td width="100"><SELECT name="trf_ofc" style='width:71'>
							<OPTION value="INCKS" selected >INCKS</OPTION>
							<OPTION value="KANKS">KANKS</OPTION>
							<OPTION value="PUSSC">PUSSC</OPTION>
					</SELECT></td>
					<td width="53">INV No</td>
					<td width="120"><input type="text" name="in_dod_inv_no" style="width:101;text-align:left;" class="input2" readonly></td>
					<td width="100">Tariff Eff.date</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('cboEffdt', 1, 95, 1, 0);</script>
					</td>
				</tr>
				</table>
				</td></tr>
				<tr><td>
				<table> 
				<tr class="h23">
					<td width="73">Reg. No</td>
					<td width="134"><input type="text" style="width:123;text-align:left;" class="input1" name="cust_rgst_no" value="" dataformat="uppernum" maxlength="14">
					</td>
					<td width="73">Payer</td>
					<td width="">
						<input type="text" style="width:70;text-align:left;" class="input1" name="payer_cd" value="" dataformat="uppernum" maxlength="8">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_payer_cd" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="payer_nm" style="width:592;text-align:left;" class="input2" readonly>
					</td>
				</tr>
				</table>
				</td></tr>
				<tr><td>
				<table> 
				<tr class="h23">
					<td width="73">Attn</td>
					<td width="134"><script language="javascript">ComComboObject('cboAttention', 5, 124 , 1, 0, 0, true);</script></td>
					<td width="35">Tel </td>
					<td width=""><input type="text" name="cntc_pnt_phn_no" style="width:90;text-align:left;" class="input2" readonly> 
					 &nbsp;&nbsp;Fax <input type="text" name="cntc_pnt_fax_no" style="width:90;text-align:left;" class="input2" readonly> 
					 &nbsp;Email <input type="text" name="cntc_pnt_eml" style="width:180;text-align:left;" class="input2" readonly>
					 SHPR <input type="text" name="shpr" style="width:247;text-align:left;" class="input2" readonly></td>
				</tr>
				</table>
				</td></tr>
				<tr><td>
				<table>
				<tr class="h23">
					<td width="73">POL/ConTi</td>
					<td width="134"><input type="text" name="pol_cd" style="width:54;text-align:left;" class="input2" readonly>/<input type="text" name="pol_conti_nm" style="width:60;text-align:left;" class="input2" readonly></td>
					
					<td width="35">POD </td>
					<td width=""><input type="text" name="pod_cd" style="width:50;text-align:left;" class="input2" readonly>
					
					DEL <input type="text" name="del_cd" style="width:50;text-align:left;" class="input2" readonly>
					
					TERM <input type="text" name="bkg_de_term_cd" style="width:44;text-align:left;" class="input2" readonly>
					
					&nbsp;CNEE <input type="text" name="cnee" style="width:180;text-align:left;" class="input2" readonly>
					
					NFTY  &nbsp;<input type="text" name="nfty" style="width:248;text-align:left;" class="input2" readonly></td>
				</tr>
                </table>
                </td></tr>
				</table>	
				<!-- biz_1  (E) -->		
			</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>

		<table class="search"> 
			<tr><td class="bg" style="height:338" valign="top">
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
		       		<td class="btn2_bg" style="text-align:left;">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!--
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_print">INV Print</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
							-->
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_fax">Fax Send</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_email">Email Send</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_preview">Preview</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
					<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="search">
								<tr class="h23" align="right">
									<td width="104">Total Billing AMT</td>
									<td width="120"><input type="text" name="ttl_bil_amt" style="width:110;text-align:right;" class="input2" readonly></td>
									<td width="95">Total Tax AMT</td>
									<td width="120"><input type="text" name="ttl_tax_amt" style="width:110;text-align:right;" class="input2" readonly></td>
									<td width="75">G.TTL AMT</td>
									<td width="120"><input type="text" name="ttl_inv_amt" style="width:110;text-align:right;" class="input2" readonly></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
		    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		
		<table class="height_8"><tr><td></td></tr></table>
		
		<!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
                    <td class="btn1" name="btn_issue">ISSUE</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_payer_info">Payer Info</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
		<!--Button (E) -->
		
		
	</td>
	</tr>
</table>

<!-- <div style="display:none;">-->
<div >
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="500">
		<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->
</div>
<!------- Print용 Hidden RD Object Start -------->
<table>
<tr>
	<td height="1" width="1">
		<script language="javascript">comRdObject('rd_invoice');</script>
	</td>
</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>