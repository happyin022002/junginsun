<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0260.jsp
*@FileTitle : Delivery Monitor
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
===============================================================================
 History
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.report.deliverymonitor.event.EsdTrs0260Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTrs0260Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strRhq_ofc_cd= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();

		event = (EsdTrs0260Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String selBOUND  = JSPUtil.getCodeCombo("s_bnd_cd", "01", "style='width:80'", "CD00591", 0, "000010:ALL:");
	//String selSTATUS = JSPUtil.getCodeCombo("s_sts_cd", "01", "style='width:80'", "CD00591", 0, "000010:ALL:");
%>
<html>
<head>
<title>Delivery Monitoring</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%=JSPUtil.getIBCodeCombo("f_rhq_cd" , "", "CD00961", 0, "")%>
	<%=BizComUtil.getIBCodeCombo("po_local_curr_cd", "01", "CURR", 2, "")%>
	
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
<form  name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="s_fm_date" value="">
<input type="hidden" name="s_to_date" value="">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
	
	    	<!--Button (S) -->
	        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		        <tr>
			        <td class="btn1_bg">
			            <table border="0" cellpadding="0" cellspacing="0">
				            <tr>
				                <td>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
						                    <td class="btn1_left"></td>
						                    <td class="btn1" name="btn_retrieve">Retrieve</td>
						                    <td class="btn1_right"></td>
					                    </tr>
				                	</table>
				                </td>

				                <td>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
						                    <td class="btn1_left"></td>
						                    <td class="btn1" name="btn_downexcel">Down Excel</td>
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
    	
			<!--biz page (S)-->			
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search_in" border="0" style="width:979;">
							<tr class="h23">
								<td class="sm">
									<table border="0" class="sm">
										<tr class="h23">

											<td width="165" >
												<input type="radio" value="W" name="f_chkprd" class="trans" onClick="javascript:chkWM('W');" checked>&nbsp;Week&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" value="M" name="f_chkprd" class="trans" onClick="javascript:chkWM('M');">&nbsp;Month
											</td>
											<td width="40" class="sm" >Year</td>
											<td width="60" >
												<input type="text" dataformat="num" style="width:40;text-align:center;" class="input1" name="f_year" maxlength="4" style="ime-mode:disabled" onBlur="if(this.value!=''){setPeriod(this);}">
											</td>
											<td width="40" class="sm" ><div id="div_wm">Week</td>
											<td width="100" >
												<input type="text" dataformat="num" style="width:30;text-align:center;" class="input1" name="i_fm_wm" maxlength="2" style="ime-mode:disabled" onBlur="if(this.value!=''){setPeriod(this);}">&nbsp;&nbsp;~&nbsp;
												<input type="text" dataformat="num" style="width:30;text-align:center;" class="input1" name="i_to_wm" maxlength="2" style="ime-mode:disabled" onBlur="if(this.value!=''){setPeriod(this);}">
											</td>
											<td width="160" class="sm" ><div id="div_period"></div></td>
											<td width="222" class="sm"  style= "color:#CC3D3D">Door Arrival Date is used for Export Door</td>
											<td width="226">Door Name&nbsp;<input type="text" name="s_dr_nm" style="width:124"></td>
										</tr>
									</table>
								</td>
							</tr>

							<tr>
								<td>
									<table border="0" class="search_in">
										<tr class="h23">
											<td width="10"></td>
											<td width="90">S/O Office</td>
											<td width="230">
												<input type="text" name="s_ofc_cd" dataformat="engup" style="width:80;" maxlength="6" class="input1">
												<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ofc_cd">
												<input type="checkbox" name="s_sub_ofc1" value="Y" class="trans" onClick="javascript:chkSubOfc(this);">Incl. Sub OFC
											</td>
											<td width="90">Bound</td>
											<td width="120"><%=selBOUND%></script></td>
											<td width="90">Status</td>
											<td width="145">
											  <SELECT name = "s_sts_cd">	
											    <OPTION  value=""> </OPTION>
					                            <OPTION  value="P">S/O Candiate</OPTION>
					                            <OPTION  value="C">S/O Created</OPTION>
					                            <OPTION  value="I">W/O Issued</OPTION>
				                              </SELECT>
                                            </td>
											<td width="70">D/O</td>
											<td width="155">
											  <SELECT name = "s_do_yn">	
											    <OPTION  value="A"> </OPTION>
					                            <OPTION  value="Y">Yes</OPTION>
					                            <OPTION  value="N">No</OPTION>
				                              </SELECT>
											</td>
										</tr>
										<tr class="h23">
											<td width="10"></td>
											<td width="90">Booking No.</td>
											<td width="230"><input type="text" name="s_bkg_no" dataformat="engup" style="width:80;">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('Booking No.');"></td>
											<td width="90">Container No.</td>
											<td width="120"><input type="text" name="s_cntr_no" dataformat="engup" style="width:80;">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('Container No.');"></td>
											<td width="90">S/O No.</td>
											<td width="145"><input type="text" name="s_so_no" dataformat="engup" style="width:80;">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('S/O No.');"></td>
											<td width="70">W/O No.</td>
											<td width="155"><input type="text" name="s_wo_no" dataformat="engup" style="width:80;">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('W/O No.');"></td>
										</tr>

										<tr class="h23">
											<td width="10"></td>
											<td width="90">From</td>
							                <td width="230"><input name="search_fm_loc" type="text" style="width:56;" maxlength="5" onChange="getComboList(this, document.form.search_fm_yard, 'F');" onBlur=""  >&nbsp;
							                  <script language="javascript">ComComboObject('search_fm_yard', 1, 48, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode">
							                </td>
											<td width="90">Via</td>
							                <td width="135"><input name="search_via_loc" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur="">&nbsp;
							                  <script language="javascript">ComComboObject('search_via_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_vianode">
							                </td>
											<td width="90">Door</td>
							                <td width="140"><input name="search_door_loc" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.form.search_door_yard, 'D');"  onBlur="">&nbsp;
							                  <script language="javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_dorloc">
						                    </td>
											<td width="70">To</td>
							                <td width="155"><input name="search_to_loc" type="text" style="width:52;" maxlength="5" onChange="getComboList(this, document.form.search_to_yard, 'T');"  onBlur="">&nbsp;
							                  <script language="javascript">ComComboObject('search_to_yard', 1, 45, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_tonode">
							                </td>
										</tr>

									</table>
								</td>
							</tr>

						</table>	
						<!-- biz_1  (E) -->
					</td>
				</tr>
			</table>

					
			<table class="height_8"><tr><td></td></tr></table>

			<table class="search"> 
				<tr>
					<td class="bg" style="height:315" valign="top">
						<div id="sheetLayer" style="display:inline">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</div>
						
						<div id="sheetLayer" style="display:none">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</div>

						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
					       	<tr>
						       	<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_detail">Go to Detail</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
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

<!-- 개발자 작업  끝 -->
</form>

<form name="form2">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="s_sts_cd">
	<input type="hidden" name="s_do_yn">
	<input type="hidden" name="s_bkg_no">
	<input type="hidden" name="s_cntr_no">
	<input type="hidden" name="s_so_no">
	<input type="hidden" name="s_wo_no">
	<input type="hidden" name="s_fm_dt">
	<input type="hidden" name="s_to_dt">
	<input type="hidden" name="s_so_ofc_cd">
	<input type="hidden" name="s_so_tp_cd">
	<input type="hidden" name="s_bnd_cd">
	<input type="hidden" name="s_fm_nod_cd">
	<input type="hidden" name="s_via_nod_cd">
	<input type="hidden" name="s_to_nod_cd">
	<input type="hidden" name="s_dor_nod_cd">
    <input type="hidden" name="s_yr_week">
</form>	

</body>
</html>