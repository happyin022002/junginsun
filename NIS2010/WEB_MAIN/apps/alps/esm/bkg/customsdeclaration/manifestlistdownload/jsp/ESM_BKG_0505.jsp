<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0505.jsp
*@FileTitle : B/L Inquiry(Add & Edit B/L) Customer Info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.01 박상훈
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
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<html>
<head>
<title>B/L Inquiry(Add & Edit B/L) Customer Info</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
</head>
<%
	// IN-Bound, OUT-Bound 구분 ( I / O )
	String ioBndCd = StringUtil.xssFilter(request.getParameter("io_bnd_cd"));
	
	// 넘어오는 파라메터들 설정
	String vvd     = StringUtil.xssFilter(request.getParameter("vvd"));
	String portCd  = StringUtil.xssFilter(request.getParameter("port_cd"));
	String mrnNo   = StringUtil.xssFilter(request.getParameter("mrn_no"));
	String blNo    = StringUtil.xssFilter(request.getParameter("bl_no"));
	String cstmsDeclTpCd = StringUtil.xssFilter(request.getParameter("cstms_decl_tp_cd"));
	String podTmlCd = StringUtil.xssFilter(request.getParameter("pod_tml_cd"));
	String cgoSpecClear = StringUtil.xssFilter(request.getParameter("cgo_spec_clear"));
	// 모드 ( ADD / EDIT )
	String mode    = StringUtil.xssFilter(request.getParameter("mode"));

	if (ioBndCd==null) ioBndCd = "I";
	if (vvd==null) 	   vvd     = "";
	if (portCd==null)  portCd  = "";
	if (mrnNo==null)   mrnNo   = "";
	if (blNo==null)    blNo    = "";
	if (cstmsDeclTpCd==null)    cstmsDeclTpCd    = "";
	if (podTmlCd==null) podTmlCd = "";
	if (cgoSpecClear==null) cgoSpecClear = "";
	if (mode==null)    mode    = "ADD";
%>

<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>">
<input type="hidden" name="vvd_1" value="<%=vvd%>">
<input type="hidden" name="port_cd" value="<%=portCd%>">
<input type="hidden" name="mrn_no" value="<%=mrnNo%>">
<input type="hidden" name="mode" value="<%=mode%>">
<input type="hidden" name="cstms_decl_tp_cd" value="<%=cstmsDeclTpCd%>">
<input type="hidden" name="old_cstms_decl_tp_cd">
<input type="hidden" name="bkg_cgo_tp_cd">
<input type="hidden" name="cgo_trsp_cd">
<input type="hidden" name="pck_tp_cd">
<input type="hidden" name="kr_cstms_wh_tp_cd">
<input type="hidden" name="cmdt_cd">
<input type="hidden" name="biz_rgst_no">
<input type="hidden" name="trns_seq">
<input type="hidden" name="cgo_spec_clear" value="<%=cgoSpecClear %>">
<input type="hidden" name="pod_tml_cd" value="<%=podTmlCd %>">
<input type="hidden" name="loc_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--top menu (S)-->
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp; Service Management &gt; Booking/Documentation &gt; Manifest &gt; Korea &gt; B/L Inquiry Customer Info</td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; B/L Inquiry(Add &amp; Edit B/L) Customer Info</td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">B/L No.</td>
						<td width="165"><input type="text" class="input1" style="width:105;" name="bl_no" dataformat="eng" value="<%=blNo%>" maxlength="12"></td>
						<td width="70">Trans.</td>
						<td>
						<script language="javascript">ComComboObject('cboTrans', 1, 105, 1, 1);</script>
						</td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">BKG No.</td>
						<td width="162"><input type="text" class="input" style="width:105;" name="bkg_no" maxlength="13" dataformat="eng"></td>
						<td width="75">Cargo Type</td>
						<td>
						<script language="javascript">ComComboObject('cboCargoType', 2, 130, 1);</script>
						</td>
						<td width="90" align="right">Cargo Specific</td>
						<td width="305" align="right">
						<script language="javascript">ComComboObject('cboCargoSpec', 1, 300, 1);</script>
						</td>
					</tr>
				</table>
					
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">POR</td>
						<td width="91"><input type="text" class="input" style="width:60;ime-mode: disabled;" maxlength="5" dataformat="engupnum" name="por_cd"></td>
						<td width="55">VVD</td>
						<td width="155"><input type="text" class="input" style="width:80;"  maxlength="9" dataformat="eng" name="vvd" value=<%=vvd%>></td>
						<td width="50">MSN</td>
						<td><input type="text" class="input" style="width:40;" maxlength="4" dataformat="int" name="msn_no"></td>
						<td width="67">B/L Type</td>
						<td width="160"><select style="width:101;" class="input" name="kr_cstms_bl_tp_cd">
							<option value="S" selected>Simple</option>
							<option value="C">Consol</option>
							<option value="E">Empty</option>
							</select></td>
					  <td width="86" align="right">F.Folder Code</td>
						<td width="153" align="right"><input type="text" class="input" style="width:148;" name="fldr_cd"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">POL</td>
						<td width="91"><input type="text" class="input" style="width:60;ime-mode: disabled;" maxlength="5" dataformat="engupnum" name="pol_cd"></td>
						<td width="55">Package</td>
						<td width="155">
							<input type="text" class="input" style="width:60; text-align:right;" dataformat="int" name="pck_qty" value="0">&nbsp;<script language="javascript">ComComboObject('cboPackage', 2, 50, 1);</script>
							</td>
						<td width="50">Weight</td>
						<td>
							<input type="text" class="input" style="width:60; text-align:right;" dataformat="float" maxlength="19" name="cntr_ttl_wgt" value="0.00">&nbsp;<select style="width:50;" class="input" name="wgt_ut_cd">
							<option value="KGS" selected>KGS</option>
							<option value="LBS">LBS</option>
							</select></td>
						<td width="65">Measure</td>
						<td>
							<input type="text" class="input" style="width:60; text-align:right;" dataformat="float" maxlength="13" name="meas_qty" value="0.000">&nbsp;<select style="width:60;" class="input" name="bl_meas_ut_cd">
							<option value="CBM" selected>CBM</option>
							<option value="CBF">CBF</option>
							</select></td>
						<td width="72" align="right">세관 Code</td>
						<td width="110" align="right"><input type="text" class="input" style="width:50; text-align:center;" dataformat="int" maxlength="3" name="tax_code1" value="000">&nbsp;<input type="text" class="input" style="width:50; text-align:center;" dataformat="int" maxlength="2" name="tax_code2" value="00"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				  <tr class="h23">
						<td width="50">POD</td>
						<td width="91"><input type="text" class="input" style="width:60;ime-mode: disabled;" maxlength="5" dataformat="engupnum" name="pod_cd"></td>
						<td width="100">Bond Area Code</td>
						<td width="100"><input type="text" class="input" style="width:82;" maxlength="10" dataformat="eng" name="bd_area_cd"></td>
						<td width="60">Disch. CY</td>
						<td width="90"><input type="text" class="input" style="width:72;" maxlength="8" dataformat="eng" name="cstms_crr_in_loc_wh_cd"></td>
						<td width="105">Warehouse Info.</td>
						<td>
							<script language="javascript">ComComboObject('cboWarehouse', 2, 40, 1);</script>
							&nbsp;<input type="text" class="input" style="width:80; " dataformat="eng" name="kr_wh_cd"></td>
						<td width="71" align="right">IMDG Code</td>
						<td width="165" align="right"><input type="text" class="input" style="width:50;" maxlength="3" dataformat="eng" name="imdg_clss_cd">&nbsp;<input type="text" class="input" style="width:50;" maxlength="3" dataformat="eng" name="n2nd_imdg_clss_cd">&nbsp;<input type="text" class="input" style="width:50;" maxlength="3" dataformat="eng" name="n3rd_imdg_clss_cd"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
			  <tr class="h23">
						<td width="50">DEL</td>
		    <td width="91"><input type="text" class="input" style="width:60;ime-mode: disabled;" maxlength="5" dataformat="engupnum" name="del_cd"></td>
						<td width="65">품목 Code</td>
						<td width="112">
						<script language="javascript">ComComboObject('cboGoods', 2, 70, 1);</script>
						</td>
						<td width="65">용적단위</td>
						<td width="80">
							<select style="width:35;" class="input" name="kr_meas_ut_cd">
							<option value="B">B</option>
							<option value="M" SELECTED>M</option>
							</select></td>
						<td width="44">Biz No.</td>
						<td>
						<script language="javascript">ComComboObject('cboBizNo', 2, 110, 0, 0, 0, true);</script>
						</td>
						<td width="62" align="center">Bulk WGT</td>
				<td width="115"><input type="text" class="input" style="width:80; text-align:right;" maxlength="21" dataformat="float" name="bb_cgo_wgt" value="0.00"></td>
				  <td width="62" align="right">Bulk MEA</td>
					<td width="85" align="right"><input type="text" class="input" style="width:80; text-align:right;" maxlength="21" dataformat="float" name="bb_cgo_meas_qty" value="0.000"></td>
				  </tr>
			  </table>
				<table class="search" border="0" style="width:979;"> 
				  <tr class="h23">
						<td width="110">Cargo Desc. 1</td>
				  <td style="padding-left:1;"><input type="text" class="input" style="width:100%;" dataformat="engupspace" name="cgo_desc1"></td></tr>
					<tr class="h23">
						<td>Cargo Desc. 2</td>
						<td><textarea style="width:100%; height:50;" name="cgo_desc2" dataformat="engupspace"></textarea></td>
					</tr>
</table>
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>
		<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
				<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td></tr>
			</table>
		<!-- Tab (E) -->

<!--TAB Container Info (S) -->
<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->		
			
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button" border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				    <tr>
				    
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td>
					<input type="text" class="input" style="width:60; text-align:right;" dataformat="int" name="row_cnt" value="1" maxlength=3>
					</td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1RowAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1Delete">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1LoadExcel">Load Excel</td>
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
		<!--biz page (E)-->

</div>
<!--TAB Container Info (E) -->


<!--TAB Customer Info (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<table width="100%" class="grid2" id="mainTable"> 
			<tr><td class="tr2_head" width="140">Shipper Name</td>
				<td><input type="text" style="width:100%;" class="input" name="s_cust_nm" dataformat="engupspecial"></td></tr>
			<tr><td class="tr2_head">Shipper Address</td>
				<td><input type="text" style="width:100%;" class="input" name="s_cust_addr" dataformat="engupspecial"></td></tr>
			<tr><td class="tr2_head">Consignee Name</td>
				<td><input type="text" style="width:100%;" class="input" name="c_cust_nm" dataformat="engupspecial"></td></tr>
			<tr><td class="tr2_head">Consignee Address</td>
				<td><input type="text" style="width:100%;" class="input" name="c_cust_addr" dataformat="engupspecial"></td></tr>
			<tr><td class="tr2_head">Notify Name</td>
				<td><input type="text" style="width:100%;" class="input" name="n_cust_nm" dataformat="engupspecial"></td></tr>
			<tr><td class="tr2_head">Notify Address</td>
				<td><input type="text" style="width:100%;" class="input" name="n_cust_addr" dataformat="engupspecial"></td></tr>
			</table> 
			<script language="javascript">ComSheetObject('t2sheet1');</script>
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!--TAB Customer Info (E) -->


<!--TAB Export No (S) -->
<div id="tabLayer" style="display:none">

<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->		
			
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button" border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t3RowAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t3Delete">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t3LoadExcel">Load Excel</td>
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
		<!--biz page (E)-->

</div>
<!--TAB Export No (E) -->
	
	</td></tr>
		</table>
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
					
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BLBKGNoASSGN">B/L &amp; BKG No. Assign </td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

</form>
</body>
</html>