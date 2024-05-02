
<%
	/*=========================================================
	 *Copyright(c) 2017 Hi-Plus Card
	 *@FileName : esm_bkg_0457.jsp
	 *@FileTitle : ESM_BKG-0457
	 *Open Issues :
	 *Change history :
		 2017.08.08 하대성 2017 Renewal Version Transmit 반영
	 *@LastModifyDate : 2017.08.08
	 *@LastModifier : 하대성
	 *@LastVersion : 1.0
	 * 2009.05.26 김승민
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
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0457Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0457Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0457Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG-0457</title>
<meta http-eqEsmv="Content-Type" content="text/html; charset=UTF-8">
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="cust_type">
<input type="hidden" name="form1_bl_no">
<input type="hidden" name="form1_bl_split_no">
<input type="hidden" name="pagerows"> 
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
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">B/L No.</td>
					<td width="470"><input type="text" style="width:100" class="input1" value="" name="in_bl_no" dataformat="uppernum" maxlength="12" style="ime-mode:disabled">&nbsp;<input type="text" style="width:30" class="input1" value="" name="in_bl_split_no" dataformat="uppernum" maxlength="2" style="ime-mode:disabled">&nbsp;<input type="text" style="width:50" class="input2" value="" name="form1_jp_bl_sts_cd" readonly>&nbsp;<input type="text" style="width:50" class="input2" name="form1_dcgo_flg" readonly>&nbsp;<input type="text" style="width:50" class="input2" value="" name="form1_locl_ts_flg" readonly></td>
					<td width="50">Stage </td>
					<td width=""><input type="text" style="width:60" class="input2" name="form1_jp_edi_trsm_stg_tp_cd" readonly>&nbsp;<select style="width:80;" name="form1_full_mty_cd"> 
						<option value="M" selected>Empty</option>
						<option value="F"></option>
						</select></td>
					</tr>
				</table>
												
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">VVD</td>
					<td width="120"><input type="text" style="width:75" value="" class="input2" name="form1_vvd_cd" readonly></td>
					<td width="40">POD</td>
					<td width="120"><input type="text" style="width:50" class="input" value="" name="form1_pod_cd" dataformat="upper" maxlength="5" style="ime-mode:disabled">&nbsp;<input type="text" style="width:26" dataformat="upper" name="form1_pod_split_cd" class="input" value="" style="ime-mode:disabled" maxlength="2"></td>
					<td width="30">ETA</td>
					<td width="120"><input type="text" style="width:80" class="input2" value="" name="form1_eta_dt" readonly></td>
					<td width="30">POR</td>
					<td width="120"><input type="text" style="width:70" class="input" value="" name="form1_bkg_por_cd" dataformat="upper" maxlength="5" style="ime-mode:disabled"></td>
					<td width="30">POL</td>
					<td width="120"><input type="text" style="width:70" class="input" value="" name="form1_bkg_pol_cd" dataformat="upper" maxlength="5" style="ime-mode:disabled"></td>
					<td width="30">DEL</td>
					<td width=""><input type="text" style="width:50" class="input" value="" name="form1_bkg_del_cd" dataformat="upper" maxlength="5" style="ime-mode:disabled"></td>
				
				</tr>
				<tr class="h23">
					<td width="">N.VVD</td>
					<td width=""><input type="text" style="width:75" value="" class="input2" name="form1_pst_vvd_cd" readonly></td>
					<td width="">N.POD</td>
					<td width=""><input type="text" style="width:80" class="input2" value="" name="form1_pst_rly_pod_cd" readonly></td>
					<td width="">Q'ty</td>
					<td width=""><input type="text" style="width:38" class="input" value="" name="form1_pck_qty" dataformat="num3" style="ime-mode:disabled">&nbsp;<input type="text" style="width:38" class="input" value="" name="form1_pck_tp_cd" dataformat="upper" maxlength="2" style="ime-mode:disabled"></td>
					<td width="">WGT</td>
					<td width=""><input type="text" style="width:70;text-align:right" class="input" value="" name="form1_grs_wgt" dataformat="num2">&nbsp;<select style="width:57;" name="form1_wgt_ut_cd" style="ime-mode:disabled">
						<option value="KGS" selected>KGS</option>
						<option value="LBS">LBS</option>
						</select></td>
					<td width="">MEA</td>
					<td width=""><input type="text" style="width:70;text-align:right" class="input" value="" name="form1_meas_qty" dataformat="num2">&nbsp;<select style="width:57;" name="form1_meas_ut_cd" style="ime-mode:disabled">
						<option value="CBM" selected>CBM</option>
						<option value="CBF">CBF</option>
						</select></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
												
					
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
		
			<!--  biz_2  (E) -->
                <table class="search" border="0" style="width:979;">
                    <tr class="h23">
                        <td width="480" valign="top">
                            <table class="grid2" border="0" style="width:100%;">
                            <tr class="h23">
                                <td width="81" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Shipper</td>
                                <td width="350" colspan="3" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
                                <input type="text" name="form1_cust_cnt_cd" dataformat="uppernum" caption="Shipper Country Code" style="width:30;" maxlength="2" class="input" style="ime-mode:disabled">
                                <input type="text" name="form1_cust_seq" dataformat="num3" style="width:60;text-align:right;" maxlength="6" class="input" style="ime-mode:disabled">
                                <img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cust"></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Name</td>
                                <td colspan="3"><textarea name="form1_cust_nm" dataformat="uppernum2" caption="Shipper Name" style="width:100%;" rows="2" maxlength="500" style="ime-mode:disabled"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Address</td>
                                <td colspan="3"><textarea name="form1_cust_addr" dataformat="uppernum2" caption="Shipper Address" style="width:100%;" rows="3" maxlength="500" style="ime-mode:disabled"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Tel.</td>
                                <td width="150"><input type="text" name="form1_phn_no" dataformat="num" caption="Shipper Tel." style="width:100%;" class="input" maxlength="20" style="ime-mode:disabled"></td>
                                <td width="70" class="tr_head2">Fax.</td>
                                <td width="180"><input type="text" name="form1_fax_no" dataformat="num" style="width:100%;" class="input" maxlength="20" style="ime-mode:disabled"></td>
                            </tr>
                        </table>
                        
                        <table class="height_8"><tr><td></td></tr></table>
                            <table class="grid2" border="0" style="width:100%;">
                            <tr class="h23">
                                <td width="81" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Consignee</td>
                                <td width="350" colspan="3" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
                                <input type="text" name="form1_cust_cnt_cd2" dataformat="uppernum" caption="Consignee Country Code" style="width:30;" maxlength="2" class="input" style="ime-mode:disabled">
                                <input type="text" name="form1_cust_seq2" dataformat="num3" style="width:60;text-align:right;" maxlength="6" class="input" style="ime-mode:disabled">
                                <img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cust2"></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Name</td>
                                <td colspan="3"><textarea name="form1_cust_nm2" dataformat="uppernum2" caption="Consignee Name" style="width:100%;" rows="2" maxlength="500" style="ime-mode:disabled"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Address</td>
                                <td colspan="3"><textarea name="form1_cust_addr2" dataformat="uppernum2" caption="Consignee Address" style="width:100%;" rows="3" maxlength="500" style="ime-mode:disabled"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Tel.</td>
                                <td width="150"><input type="text" name="form1_phn_no2" dataformat="num" caption="Consignee Tel." style="width:100%;" class="input" maxlength="20" style="ime-mode:disabled"></td>
                                <td width="70" class="tr_head2">Fax.</td>
                                <td width="180"><input type="text" name="form1_fax_no2" dataformat="num" style="width:100%;" class="input" maxlength="20" style="ime-mode:disabled"></td>
                            </tr>
                        </table>
                        </td> 
                        <td width="19"></td>
                        <td width="480" valign="top">
                            <table class="grid2" border="0" style="width:100%;">
                            <tr class="h23">
                                <td width="81" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Notify</td>
                                <td width="350" colspan="3" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
                                <input type="text" name="form1_cust_cnt_cd3" dataformat="uppernum" caption="Notify Country Code" style="width:30;" maxlength="2" class="input" style="ime-mode:disabled">
                                <input type="text" name="form1_cust_seq3" dataformat="num3" style="width:60;text-align:right;" maxlength="6" class="input" style="ime-mode:disabled">
                                <img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cust3"></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Name</td>
                                <td colspan="3"><textarea name="form1_cust_nm3" dataformat="uppernum2" caption="Notify Name" style="width:100%;" rows="2" maxlength="500" style="ime-mode:disabled"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Address</td>
                                <td colspan="3"><textarea name="form1_cust_addr3" dataformat="uppernum2" caption="Notify Address" style="width:100%;" rows="3" maxlength="500" style="ime-mode:disabled"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Tel.</td>
                                <td width="150"><input type="text" name="form1_phn_no3" dataformat="num" caption="Notify Tel." style="width:100%;" class="input" maxlength="20" style="ime-mode:disabled"></td>
                                <td width="70" class="tr_head2">Fax.</td>
                                <td width="180"><input type="text" name="form1_fax_no3" dataformat="num" style="width:100%;" class="input" maxlength="20" style="ime-mode:disabled"></td>
                            </tr>
                        </table>
                        
                        </td>
                </tr>
                </table>
		<!--  biz_1   (E) -->
		
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->

	
	
	<!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_reactivate">Reactivate</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_container">Container</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_marks">Marks & Desc</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
<!-- 				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transmit">Transmit to SEA-NACCS</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> -->
				
				<td>
					<table width="" border="0" cellpadding="0" cellspacing="0"
						class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_new_transmit">Transmit to SEA-NACCS</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
				
			</tr>
			</table>
    <!--Button (E) -->
	</td></tr>
		</table>
	    <table width="100%" id="mainTable" style="display:none">
	        <tr>
	            <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
	        </tr>
	    </table>
</form>
</body>
</html>