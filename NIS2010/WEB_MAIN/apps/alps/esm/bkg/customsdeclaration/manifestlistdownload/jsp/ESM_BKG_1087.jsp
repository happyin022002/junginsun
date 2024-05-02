<%/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : ui_bkg_1087.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.14
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2017.11.14 하대성  두바이 세관 라이브 반영
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1087Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1087Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1087Event)request.getAttribute("Event");
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

<body class="popup_bg" onLoad="setupPage();"> 
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bl_no" value="<%=request.getParameter("bl_no")%>">
<input type="hidden" name="pod_cd" value="<%=request.getParameter("pod_cd")%>">
<input type="hidden" name="tabIndex" value="<%=request.getParameter("tabIndex")%>">

<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title">Dubai  Inbound Manifest - B/L Detail </span></td></tr>
			</table>
		
			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width="900">
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
	
<div id="tabLayer">
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<table class="search" border="0" style="width:800;"> 
							<tr class="h23">
								<td width="50">&nbsp;B/L No.</td>
								<td width="120"><input type="text" value="<%=request.getParameter("bl_no") %>" style="width:100;" class="input2" readonly="readonly"></td>
								<td width="30">Line</td>
								<td width="80"><input type="text" style="width:60;ime-mode:disabled" class="input" 
									name="bl_du_line_id" maxlength="6" dataformat="eng" caption="Line"></td>
								<td width="40">Agent</td>
								<td width="90"><input type="text" style="width:70;ime-mode:disabled" class="input" 
									name="bl_du_voy_agn_id" maxlength="6" dataformat="eng" caption="Agent"></td>
								<td width="25">POR</td>
								<td width="75"><input type="text" name="bl_por_cd" style="width:55;" class="input2" readonly="readonly"></td>	
								<td width="25">POL</td>
								<td width="75"><input type="text" name="bl_pol_cd" style="width:55;" class="input2" readonly="readonly"></td>
								<td width="25">POD</td>
								<td width="75"><input type="text" name="bl_pod_cd" style="width:55;" class="input2" readonly="readonly"></td>
								<td width="25">DEL</td>
								<td width=""><input type="text" name="bl_del_cd" style="width:100%;" class="input2" readonly="readonly"></td>	
							</tr>
						</table>
						<table class="search" border="0" style="width:800;"> 
							<tr class="h23">
								<td width="83">&nbsp;Org. B/L No.</td>
								<td width="156"><input type="text" style="width:100;ime-mode:disabled" class="input" 
									name="bl_org_bl_no" maxlength="12" fullfill dataformat="eng" caption="Org. B/L No."></td>
								<td width="79">Org. Voyage</td>
								<td width="143"><input type="text" style="width:100;ime-mode:disabled" class="input" 
									name="bl_org_vvd" maxlength="9" fullfill dataformat="eng" caption="Org. Voyage"></td>
								<td width="73">Org. Vsl Nm</td>
								<td width=""><input type="text" style="width:150;ime-mode:disabled" class="input" 
									name="bl_vsl_nm" maxlength="50" dataformat="eng" caption="Org. Vsl Nm"></td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table class="search" border="0" style="width:800;"> 
							<tr class="h23">
								<td width="290">
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
										<td width="110">Manifest No.</td>
										<td width=""><input type="text" style="width:150;ime-mode:disabled" class="input" 
									name="bl_du_mf_no" maxlength="8" dataformat="eng" caption="Manifest No."></td>
										</tr>
										<tr class="h23">
										<td width="">Cargo Code</td>
										<td width=""><script language="javascript">ComComboObject('bl_du_cgo_cd', 2, 150, 1, 0, 1);</script></td>
										</tr>
										<tr class="h23">
										<td width="">Org. Country</td>
										<td width=""><input type="text" style="width:150;ime-mode:disabled" class="input" 
									name="bl_org_cnt_cd" maxlength="2" dataformat="engup" caption="Org. Country"></td>
										</tr>
										<tr class="h23">
										<td width="">PKG Qty</td>
										<td width=""><input type="text" style="width:150;ime-mode:disabled;text-align:right" class="input" 
									name="bl_pck_qty" maxlength="12" dataformat="int" caption="PKG Qty"></td>
										</tr>
										<tr class="h23">
										<td width="">LCL CNTR</td>
										<td width=""><input type="text" style="width:150;ime-mode:disabled" class="input" 
									name="bl_cntr_no" maxlength="14" dataformat="eng" caption="LCL CNTR"></td>
										</tr>
										<tr class="h23">
										<td width="">Tare WGT</td>
										<td width=""><input type="text" style="width:150;ime-mode:disabled;text-align:right" class="input" 
									name="bl_tare_wgt" maxlength="9" dataformat="float" caption="Tare WGT"></td>
										</tr>
										<tr class="h23">
										<td width="">No of Pallet</td>
										<td width=""><input type="text" style="width:150;ime-mode:disabled;text-align:right" class="input" 
									name="bl_plt_qty" maxlength="6" dataformat="int" caption="No of Pallet"></td>
										</tr>
										<tr><td colspan="6"><table class="height_5"><tr><td></td></tr></table></td></tr>
									</table>
								</td>
								<td width="20"></td>
								<td width="270">
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
										<td width="110">Trade Code</td>
										<td width=""><script language="javascript">ComComboObject('bl_du_trd_cd', 2, 150, 1, 0, 1);</script></td>
										</tr>
										<tr class="h23">
										<td width="">Console</td>
										<td width=""><select name="bl_cnsl_cgo_flg" style="width:150">
											<option value="Y">Y</option><option value="N">N</option></select></td>
										</tr>
										<tr class="h23">
										<td width="100">T/S Mode</td>
										<td width=""><script language="javascript">ComComboObject('bl_du_ts_mod_cd', 2, 150, 1, 0, 1);</script></td>
										</tr>
										<tr class="h23">
										<td width="">PKG Type</td>
										<td width=""><input type="text" style="width:150;ime-mode:disabled" class="input" 
									name="bl_du_pck_desc" maxlength="100" dataformat="etc" caption="PKG Type"></td>
										</tr>
										<tr class="h23">
										<td width="">No of CNTR</td>
										<td width=""><input type="text" style="width:150;ime-mode:disabled;text-align:right" class="input" 
									name="bl_cntr_knt" maxlength="5" dataformat="int" caption="No of CNTR"></td>
										</tr>
										<tr class="h23">
										<td width="">Cargo WGT</td>
										<td width=""><input type="text" style="width:150;ime-mode:disabled;text-align:right" class="input" 
									name="bl_cgo_wgt" maxlength="18" dataformat="float" caption="Cargo WGT"></td>
										</tr>
										<tr class="h23">
										<td width="">Total Qty</td>
										<td width=""><input type="text" style="width:150;ime-mode:disabled;text-align:right" class="input" 
									name="bl_du_ttl_qty" maxlength="9" dataformat="int" caption="Total Qty"></td>
										</tr>
										<tr><td colspan="6"><table class="height_5"><tr><td></td></tr></table></td></tr>
										
									</table>
								</td>
								<td width="20"></td>
								<td width="200" valign="top">
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
										<td width="">Svc Type</td>
										<td width=""><script language="javascript">ComComboObject('bl_du_cntr_svc_tp_cd', 2, 96, 1, 0, 1);</script></td>
										</tr>
										<tr class="h23">
										<td width="">CMDT Code</td>
										<td width=""><input type="text" style="width:96;ime-mode:disabled" class="input" 
									name="bl_du_cmdt_cd" maxlength="10" dataformat="eng" caption="CMDT Code"></td>
										</tr>
										<tr class="h23">
										<td width="">PKG Type Code</td>
										<td width=""><input type="text" style="width:96;ime-mode:disabled" class="input" 
									name="bl_du_pck_tp_cd" maxlength="3" dataformat="engup" caption="PKG Type Code"></td>
										</tr>
										<tr class="h23">
										<td width="">No of TEU(s)</td>
										<td width=""><input type="text" style="width:96;ime-mode:disabled;text-align:right" class="input" 
									name="bl_bkg_teu_qty" maxlength="12" dataformat="float" caption="No of TEU(s)"></td>
										</tr>
										<tr class="h23">
										<td width="">Gross WGT</td>
										<td width=""><input type="text" style="width:96;ime-mode:disabled;text-align:right" class="input" 
									name="bl_grs_wgt" maxlength="18" dataformat="float" caption="Gross WGT"></td>
										</tr>
										<tr class="h23">
										<td width="">Freight TONE</td>
										<td width=""><input type="text" style="width:96;ime-mode:disabled;text-align:right" class="input" 
									name="bl_du_frt_wgt" maxlength="9" dataformat="float" caption="Freight TONE"></td>
										</tr>
										<tr class="h23">
										<td width="">Messure</td>
										<td width=""><input type="text" style="width:96;ime-mode:disabled;text-align:right" class="input" 
									name="bl_meas_qty" maxlength="12" dataformat="float" caption="Messure"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="height_10"><tr><td></td></tr></table>
						
						<table class="search" border="0" style="width:800"> 
							<tr class="h23">
								<td width="" align="left">
									<table border="0" style="width:390; background-color:white;" class="grid2">  
										<tr class="h23"><td class="tr2_head">Mark & Numbers</td></tr>
										<tr><td width=""><textarea style="width:100%;ime-mode:disabled" rows="6"
											name="bl_mk_no_ctnt" maxlength="1000" dataformat="etc" caption="Mark & Numbers"></textarea></td></tr>
									</table>
								</td>
								<td width="20"></td>
								<td width="" align="left">
									<table border="0" style="width:390; background-color:white;" class="grid2">
										<tr class="h23"><td class="tr2_head">Desc</td></tr>
										<tr><td width="">
										<textarea style="width:100%;ime-mode:disabled" rows="6" class="input"
										name="bl_cmdt_desc" maxlength="100" dataformat="etc" caption="Desc"></textarea></td></tr>
										</table>
								</td>
							</tr>
						</table>
										
					</td>
				</tr>
			</table>
</div>

<div id="tabLayer" style="display:none">

			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<table class="search" border="0" style="width:800;"> 
							<tr class="h23">
								<td width="50">&nbsp;B/L No.</td>
								<td width=""><input type="text" value="<%=request.getParameter("bl_no") %>" style="width:100;" class="input2" readonly="readonly"></td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table class="search" border="0" style="width:800;">
							<tr class="h23">
								<td width="400">
									<table class="search" border="0">
									<tr><td class="title_h"></td>
										<td class="title_s">Shipper</td>
										<td align="right"><strong>Country Code</strong>&nbsp;
											<input name="bl_s_cust_cnt_cd" type="text" style="width:50;"
											maxlength="2" dataformat="engup" caption="Shipper Country Code"></td>
										</tr>
									</table>
									<table class="grid2" border="0" style="width:100%;">
										<tr class="h23">
											<td class="tr_head2" width="100">Name</td>
											<td width=""><textarea style="width:100%;ime-mode:disabled" rows="3"
											name="bl_s_cust_nm" maxlength="30" dataformat="etc" caption="Shipper Name"></textarea></td></tr>
										<tr>
											<td class="tr_head2" width="100">Address</td>
											<td width=""><textarea style="width:100%;ime-mode:disabled" rows="3"
											name="bl_s_cust_addr" maxlength="240" dataformat="etc" caption="Shipper Address"></textarea></td></tr>
									</table>
								</td>
								<td width="20"></td>
								<td width="">
									<table class="search" border="0">
										<tr><td class="title_h"></td>
										<td class="title_s">Org. Shipper</td>
										</tr>
									</table>
									<table class="grid2" border="0" style="width:100%;">
										<tr class="h23">
											<td class="tr_head2" width="100">Name</td>
											<td width=""><textarea style="width:100%;ime-mode:disabled" rows="3"
											name="bl_s_org_cust_nm" maxlength="30" dataformat="etc" caption="Org. Shipper Name"></textarea></td></tr>
										<tr>
											<td class="tr_head2" width="100">Address</td>
											<td width=""><textarea style="width:100%;ime-mode:disabled" rows="3"
											name="bl_s_org_cust_addr" maxlength="240" dataformat="etc" caption="Org. Shipper Address"></textarea></td></tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="height_10"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:800;"> 
							<tr class="h23">
								<td width="400">
									<table class="search" border="0">
										<tr><td class="title_h"></td>
											<td class="title_s">Consignee</td>
											<td align="right"><strong>Code</strong>&nbsp;
												<input name="bl_c_du_cust_id" type="text" style="width:100;"
												maxlength="10" dataformat="etc" caption="Consignee Code"></td></tr>
									</table>
									<table class="grid2" border="0" style="width:100%;">
										<tr class="h23">
											<td class="tr_head2" width="100">Name</td>
											<td width=""><textarea style="width:100%;ime-mode:disabled" rows="3"
											name="bl_c_cust_nm" maxlength="48" dataformat="etc" caption="Consignee Name"></textarea></td></tr>
										<tr>
											<td class="tr_head2" width="100">Address</td>
											<td width=""><textarea style="width:100%;ime-mode:disabled" rows="3"
											name="bl_c_cust_addr" maxlength="240" dataformat="etc" caption="Consignee Address"></textarea></td></tr>
									</table>
								</td>
								<td width="20"></td>
								<td width="">
									<table class="search" border="0">
										<tr><td class="title_h"></td>
										<td class="title_s">Org. Consignee</td>
										</tr>
									</table>
									<table class="grid2" border="0" style="width:100%;">
										<tr class="h23">
											<td class="tr_head2" width="100">Name</td>
											<td width=""><textarea style="width:100%;ime-mode:disabled" rows="3"
											name="bl_c_org_cust_nm" maxlength="30" dataformat="etc" caption="Org. Consignee Name"></textarea></td></tr>
										<tr>
											<td class="tr_head2" width="100">Address</td>
											<td width=""><textarea style="width:100%;ime-mode:disabled" rows="3"
											name="bl_c_org_cust_addr" maxlength="240" dataformat="etc" caption="Org. Consignee Address"></textarea></td></tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="height_10"><tr><td></td></tr></table>
						<table class="search" border="0">
							<tr><td class="title_h"></td>
								<td class="title_s">Notify</td>
								</tr>
						</table>
						<table class="grid2" border="0" style="width:400;"> 
							<tr class="h23">
								<td class="tr_head2" width="100">Name</td>
								<td width=""><textarea style="width:100%;ime-mode:disabled" rows="3"
								name="bl_n_cust_nm" maxlength="48" dataformat="etc" caption="Notify Name"></textarea></td></tr>
							<tr>
								<td class="tr_head2" width="100">Address</td>
								<td width=""><textarea style="width:100%;ime-mode:disabled" rows="3"
								name="bl_n_cust_addr" maxlength="240" dataformat="etc" caption="Notify Address"></textarea></td></tr>
						</table>
					</td>
				</tr>
			</table>
</div>
	
<table width="100%"  id="mainTable">
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>	
		</td>
	</tr>
</table>
		
		
<!--Button (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Save">Save</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
								<td class="btn1_line"></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Close" onClick="window.close()">Close</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (E) -->
</form>
</body>
</html>