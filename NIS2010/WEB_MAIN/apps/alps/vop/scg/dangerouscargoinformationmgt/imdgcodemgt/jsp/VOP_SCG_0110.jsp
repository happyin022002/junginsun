<%/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_SCG_0110.jsp
*@FileTitle : Packing Instruction Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.07
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2010.01.27 나상보
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0110Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0110Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DangerousCargoInformationMgt.IMDGCodeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0110Event)request.getAttribute("Event");
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
<title>User Management (Creation/Inquiry)</title>
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
<input type="hidden" name="imdg_pck_tp_cd">
<input type="hidden" name="imdg_pck_cd">
<input type="hidden" name="pck_tp_seq">
<input type="hidden" name="temp_pck_tp_cd">
<input type="hidden" name="temp_imdg_pck_desc">

<!-- 개발자 작업	-->
	<!-- Outer Table (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<div id="searchLayer">
				<table class="search">
					<tr><td class="bg">					
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="140" colspan="2">UN No./Seq.</td>
								<td width=""	colspan="7">&nbsp;<input type="text" style="width:130;" name='imdg_un_no' fullfill class="input1" required maxlength='4' style="ime-mode:disabled"   caption='UN No.'  value="" >&nbsp;<input type="text" style="width:19;"  name='imdg_un_no_seq' class="input1"  caption='UN No./Seq.' maxlength='2'   minlength='1' required   value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name='srch_imdg_un_no' align="absmiddle">&nbsp;<input type="text" style="width:610;" readonly class="input2" name='prp_shp_nm' value=""></td>
							</tr>
						</table>
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="150">Class</td>
								<td width="132"><input type="text" style="width:130;" readonly class="input2" name='imdg_clss_cd' value=""></td>
								<td width="52"></td>
								<td width="90">Pack Group</td>
								<td width="50"><input type="text" style="width:30;" readonly class="input2" name='imdg_pck_grp_cd' value=""></td>
								<td width="89">Cargo Status</td>
								<td width="80">
									<script language="javascript">ComComboObject('dcgo_sts_cd', 1, 62, 1, 0, 0, false);</script>
								</td>
								<td width="89">Limited Q'ty</td>
								<td width="70">
							   		<script language="javascript">ComComboObject('imdg_lmt_qty_flg', 1, 45, 1, 1, 0, false);</script>&nbsp;
							   	</td>
								<td width="95">Excepted Q'ty</td>
								<td width="">
									<script language="javascript">ComComboObject('imdg_expt_qty_flg', 1, 45, 1, 1, 0, false);</script>
							   	</td>
							</tr>
							<tr class="h23">
								<td width="">Grs. Weight</td>
								<td width=""><input type="text" style="width:130;text-align:right" class="input" name='grs_wgt' value="0.000" dataformat="float"  pointcount="3" ></td>
								<td width=""><input type="text" style="width:40;" readonly class="input2" name='grs_wgt_ut' value="KGS"></td>
								<td width="">Net Weight</td>
								<td colspan="2"><input type="text" style="width:130;text-align:right" class="input1" name='net_wgt' value="0.000" dataformat="float"  pointcount="3" required caption='Net Weight '></td>
								<td width=""><input type="text" style="width:60;" readonly class="input2" name='grs_net_ut' value="KGS"></td>
								<td width="">Total Capacity</td>
								<td colspan="2"><input type="text" style="width:130;text-align:right" class="input1" name='grs_capa_qty' value="0.000" dataformat="float"  pointcount="3" required caption='Total Capacity '></td>
								<td width=""><input type="text" style="width:45;" readonly class="input2" name='grs_capa_qty_ut' value="L"></td>
							</tr>
						</table>
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="150">Outer PKG Qty</td>
								<td width="130"><input type="text" style="width:130;text-align:right" class="input1" name='out_imdg_pck_qty1' value="" required caption='Outer Package Qty '></td>
								<td width="70"><input type="text" style="width:40;" class="input1" name='out_imdg_pck_cd1' value="" required caption='Outer Package Type '>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name='out_btn1' align="absmiddle"></td>
								<td width=""><input type="text" style="width:590;" readonly class="input2" name='out_imdg_pck_desc1' value=""></td>
							</tr>
							<tr class="h23">
								<td width="150">Intermidiate PKG Qty</td>
								<td width="130"><input type="text" style="width:130;text-align:right" class="input1" name='intmd_imdg_pck_qty1' value=""></td>
								<td width="70"><input type="text" style="width:40;" class="input1" name='intmd_imdg_pck_cd1' value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name='intmd_btn1' align="absmiddle"></td>
								<td width=""><input type="text" style="width:590;" readonly class="input2" name='intmd_imdg_pck_desc1' value=""></td>
							</tr>
							<tr class="h23">
								<td width="150">Inner PKG Qty(Total)</td>
								<td width="130"><input type="text" style="width:130;text-align:right" class="input1" name='in_imdg_pck_qty1' value=""></td>
								<td width="70"><input type="text" style="width:40;" class="input1" name='in_imdg_pck_cd1' value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name='in_btn1' align="absmiddle"></td>
								<td width=""><input type="text" style="width:590;" readonly class="input2" name='in_imdg_pck_desc1' value=""></td>
							</tr>
						</table>
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="150">Outer : Grs. Wgt/Unit</td>
								<td width="132"><input type="text" style="width:130;text-align:right" readonly class="input2" name='out_grs_per_ut' maxlength="15" size="15" value="0.000" dataformat="float"  pointcount="3" ></td>
								<td width="52"><input type="text" style="width:40;" readonly class="input2" name='out_grs_wgt_ut' value="KGS"></td>
								<td width="90">Net Wgt/Unit</td>
								<td width="139"><input type="text" style="width:130;text-align:right" readonly class="input2" name='out_net_per_ut' maxlength="15" size="15" value="0.000" dataformat="float" pointcount="3" ></td>
								<td width="80"><input type="text" style="width:60;" readonly class="input2" name='out_grs_net_ut' value="KGS"></td>
								<td width="89">Capa/Unit</td>
								<td width="165"><input type="text" style="width:155;text-align:right" readonly class="input2" name='out_ttl_capa_per_ut' maxlength="15" size="15" value="0.000" dataformat="float" pointcount="3" ></td>
								<td width=""><input type="text" style="width:45;" readonly class="input2" name='out_ttl_capa_ut' value="L"></td>
							</tr>
							<tr class="h23">
								<td width="150">inner : Grs. Wgt/Unit</td>
								<td width="132"><input type="text" style="width:130;text-align:right" readonly class="input2" name='in_grs_per_ut' maxlength="15" size="15" value="0.000" dataformat="float" pointcount="3" ></td>
								<td width="52"><input type="text" style="width:40;" readonly class="input2" name='in_grs_wgt_ut' value="KGS"></td>
								<td width="90">Net Wgt/Unit</td>
								<td width="139"><input type="text" style="width:130;text-align:right" readonly class="input2" name='in_net_per_ut' maxlength="15" size="15" value="0.000" dataformat="float" pointcount="3" ></td>
								<td width="80"><input type="text" style="width:60;" readonly class="input2" name='in_grs_net_ut' value="KGS"></td>
								<td width="89">Capa/Unit</td>
								<td width="165"><input type="text" style="width:155;text-align:right" readonly class="input2" name='in_ttl_capa_per_ut' maxlength="15" size="15" value="0.000" dataformat="float" pointcount="3" ></td>
								<td width=""><input type="text" style="width:45;" readonly class="input2" name='in_ttl_capa_ut' value="L"></td>
							</tr>
						</table>
					</td></tr>
				</table>
			</div>
			<table class="height_8"><tr><td></td></tr></table>
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
		       	<tr>
		       		<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
						    	<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Validate">Validate</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button (E) -->
				
			<!-- TABLE '#D' : ( Tab ) (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" style=""> 
       			<tr>
       				<td width="100%">
						<script language="javascript">ComTabObject('tab1');</script>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Tab ) (E) -->
			
			<!-- THIS IS 1st TAB (S) -->	
			<div id="tabLayer" style="display:inline">
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<!-- : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Restriction Regulatory</td>
								</tr>
								<tr>
								<td colspan="2"><script language="javascript">ComSheetObject('t1sheet1');</script></td>
								</tr>
							</table>
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Reason of Invalid Details</td>
								</tr>
								<tr>
								<td colspan="2"><script language="javascript">ComSheetObject('t1sheet2');</script></td>
								</tr>
							</table>
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Special Packaging Instruction & Provisions to be reffered</td>
								</tr>
								<tr>
								<td colspan="2"><script language="javascript">ComSheetObject('t1sheet3');</script></td>
								</tr>
							</table>
							<!-- : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- THIS IS 1st TAB (E) -->
			
			<!-- THIS IS 2nd TAB (S) -->
			<div id="tabLayer" style="display:none">			
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<!-- Port Prohibition/Restriction : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Port Prohibition/Restriction</td>
								</tr>
								<tr>
								<td colspan="2"><script language="javascript">ComSheetObject('t2sheet1');</script></td></tr>
							</table>
							<!-- Port Prohibition/Restriction : ( Grid ) (E) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr><td colspan="15" class="line_bluedot"></td></tr>
							</table>
							<!-- Vessel Operatior's Prohibition/Restriction : ( Grid ) (S) -->
							<table width="100%" class = "search" id="mainTable" style="">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Vessel Operator's Prohibition/Restriction</td>
								</tr>
								<tr>
								<td colspan="2"><script language="javascript">ComSheetObject('t2sheet2');</script></td></tr>
							</table>
							<!-- Vessel Operatior's Prohibition/Restriction : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- THIS IS 2nd TAB (E) -->
		</td></tr>
	</table>
	<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>