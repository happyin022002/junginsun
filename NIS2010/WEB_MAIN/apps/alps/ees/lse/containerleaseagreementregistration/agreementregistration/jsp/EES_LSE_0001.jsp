<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0001.jsp
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.26 노정용
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0001Event"%>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_off_cd    = "";
	String strCntrTpSzCd    = "";
	String csrGwUrl = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id     = account.getUsr_id();
		strUsr_nm     = account.getUsr_nm();
		strUsr_off_cd = account.getOfc_cd();

		event = (EesLse0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntrTpSzCd = (String)eventResponse.getCustomData("cntr_tpsz_cd");
		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Lease Agreement Creation & Update</title>
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
<input type="hidden" name="usr_ofc_cd"       value="<%= strUsr_off_cd %>">
<input type="hidden" name="org_cntr_tpsz_cd" value="<%= strCntrTpSzCd %>">
<input type="hidden" name="agmt_act_flg">
<input type="hidden" name="lstm_cd">
<input type="hidden" name="cntr_dpc_lvl_cd">
<input type="hidden" name="itchg_fee_flg">
<input type="hidden" name="agmt_lst_ver_seq">
<input type="hidden" name="dpc_val_flg">
<input type="hidden"   name="lse_agmt_doc_no">
<input type="hidden"   name="csr_gw_url" value="<%=csrGwUrl%>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
					                    	<td class="btn1" name="btn_Retrieve">Retrieve</td>
					                    	<td class="btn1_right"></td>
					                    </tr>
				                	</table>
				                </td>
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
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
					                    	<td class="btn1_left"></td>
					                    	<td class="btn1" name="btn_Create">New AGMT Creation</td>
					                    	<td class="btn1_right"></td>
					                    </tr>
				                	</table>
				                </td>
				                <td>
				                	<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
					                    	<td class="btn1_left"></td>
						                    <td class="btn1" name="btn_Save">Save</td>
					                    	<td class="btn1_right"></td>
					                    </tr>
				                	</table>
				                </td>
				                <td>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
					                    	<td class="btn1_left"></td>
					                    	<td class="btn1" name="btn_VersionUp">Version Up</td>
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
			<table class="search" width="100%" id="mainTable">
				<tr>
					<!-- : ( Search Options ) (S) -->
					<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979">
							<tr class="h23">
								<td width="110">&nbsp;&nbsp;AGMT No.</td>
								<td width="330">
									<input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:35;text-align:center;" class="input2" value="HHO" readonly>
									<input type="text" name="agmt_seq" caption="AGMT No." style="width:50;text-align:center" class="input" value="" dataformat="int" maxlength="6">
									<input type="text" name="agmt_ver_seq" caption="AGMT No." style="width:20;" class="input2" value="" dataformat="int" maxlength="3" readonly>
									<img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<span style="padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 12px; word-spacing:-0px;">InActive</span>
									<input type="checkbox" name="chk_agmt_act_flg" caption="InActive" value="" class="trans" disabled>
								</td>
								<td width="80">Term</td>
								<td width="170" style="padding-left:2">
									<script language="javascript">ComComboObject('combo1', 2, 75, 0, 1);</script>
								</td>
								<td width="80">DEPR</td>
								<td width="100">
									<input type="text" name="dpc_rto_val" caption="Yearly DEPR" style="width:40;text-align:right" class="input" value="" maxlength="6" dataformat="float" pointcount="3" minnum="0" maxnum="100.0" readonly>&nbsp;%
								</td>
								<td width="95">Yearly DEPR</td>
								<td width="">
									<input type="text" name="dpc_rto" caption="Yearly DEPR" style="width:40;text-align:right" class="input" value="" maxlength="6" dataformat="float" pointcount="3" minnum="0" maxnum="100.0" >&nbsp;%
								</td>
							</tr>
							<tr class="h23">
								<td width="">&nbsp;&nbsp;G/W Contract</td>
								<td width="">
									<input type="text" name="lse_agmt_doc_desc" caption="GW_Contract" style="width:250;text-align:left;" class="input2"  maxlength="500" readonly>
									<img class="cursor" src="img/btns_search.gif" name="btns_gwcontact" width="19" height="20" border="0" align="absmiddle">
									<a class="cursor" name="btn_del" onclick ="gw_del();">Del</a>
								</td>
								<td width="">Duration</td>
								<td width="">
									<input type="text" name="dt_drtn" caption="Duration" style="width:75;text-align:right;" class="input2" value="" dataformat="int" readonly>
								</td>
								<td width="">MAX DEPR</td>
								<td width="">
									<input type="text" name="max_dpc_rto" caption="MAX DEPR" style="width:60;text-align:right" class="input" value="" maxlength="6" dataformat="float" pointcount="2" minnum="0" maxnum="100.0">&nbsp;%
								</td>
								<td colspan ="2" >
								</td>
							</tr>
							<tr class="h23">
							    <td width="">&nbsp;&nbsp;Effective Date</td>
								<td width="">
									<input type="text" name="eff_dt" caption="Effective Date" style="width:75;text-align:center;" class="input1" value="" maxlength="8" dataformat="ymd" !cofield="exp_dt">
									~
									<input type="text" name="exp_dt" caption="Expired Date" style="width:75;text-align:center;" class="input1" value="" maxlength="8" dataformat="ymd" !cofield="eff_dt">
									<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle" dataformat="ymd">
								</td>
								<td width="">URL</td>
								<td width="">
									<input type="text" name="lse_vndr_url" caption="URL" style="width:150;ime-mode:disabled;" class="input" value="">
								</td>
								<td width="">DEPR Level</td>
								<td width="" style="padding-left:2">
									<script language="javascript">ComComboObject('combo2', 1, 70,  0, 0);</script>&nbsp;
								</td>
								<td colspan ="2" >
								<script language="javascript">ComComboObject('combo3', 1, 125, 0, 0);</script>
								</td>
							</tr>
							</table>
							<table class="search" border="0" style="width:979">
							<tr class="h23">
								<td width="100">&nbsp;&nbsp;Lessor.</td>
								<td width="330"><input type="text" name="vndr_seq" caption="Lessor" style="width:55;text-align:center;" class="input1" value="" dataformat="int" maxlength="6">
									<img class="cursor" src="img/btns_search.gif" name="btns_search2" width="19" height="20" border="0" align="absmiddle">
									<input type="text" name="vndr_nm" caption="Lessor" style="width:229;" class="input2" value="" readonly>
								</td>
								<td width="80">AGMT Date</td>
								<td width="170">
									<input type="text" name="agmt_dt" caption="AGMT Date" style="width:75;text-align:center;" class="input" value="" maxlength="8" dataformat="ymd">
									<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="95">ICF Flag</td>
								<td width="" style="padding-left:2">
									<input type="checkbox" name="chk_itchg_fee_flg" caption="ICF Flag" value="" class="trans">
								</td>
							</tr>
							</table>
							<table class="search" border="0" style="width:979">
							<tr class="h23">
								<td width="100">&nbsp;&nbsp;Contract No.</td>
								<td width="130"><input type="text" name="lse_ctrt_no" caption="Contract No" style="width:130;" lass="input1" value="" maxlength="20" dataformat="eng"></td>
								<td width="70">&nbsp;Ref. No.</td>
								<td width="128"><input type="text" name="ref_no" caption="Ref. No" style="width:121;ime-mode:disabled;" lass="input1" value="" maxlength="20" !dataformat="eng">
								</td>
								<td width="80">Pay Term</td>
								<td width="170">
									<input type="text" name="lse_pay_term_dys" caption="Pay Term" style="width:75;text-align:right;" class="input" value="" maxlength="5" dataformat="int">
								</td>
								<td width="95">DPP Coverage</td>
								<td width="" style="padding-left:2">
									<table border="0" style="width:175; background-color: #E9E9E9">
										<tr class="h23">
											<td class="stm">
												<input type="radio" name="dpp_tp_cd" value="Y" class="trans">Yes
												&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" name="dpp_tp_cd" value="N" class="trans">No
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr class="h23">
								<td width="">&nbsp;&nbsp;AGMT Office</td>
								<td width="">
									<input type="text" name="ofc_cd" caption="AGMT Office" style="width:75;text-align:center;" class="input2" value="<%= strUsr_off_cd %>" readonly>
								</td>
								<td width="">&nbsp;&nbsp;</td>
								<td width="">
								</td>
								<td width="">Currency</td>
								<td width="">
									<input type="text" name="curr_cd" caption="Currency" style="width:75;text-align:center;" class="input1" value="" maxlength="3" dataformat="engup">
									<img class="cursor" src="img/btns_search.gif" name="btns_search3" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="">DII/DIO Fee</td>
								<td width="">
									<input type="text" name="dir_itchg_fee_amt" caption="DII/DIO Fee" style="width:60;text-align:right" class="input" value="" maxlength="6" dataformat="float" pointcount="2">
								</td>
							</tr>
							<tr class="h23">
							   <td width="">&nbsp;&nbsp;Build Up</td>
								<td width="">
									<input type="text" name="bld_up_dt" caption="Build Up" style="width:75;text-align:center;" class="input" value="" maxlength="8" dataformat="ymd">
									<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar3" width="19" height="20" border="0" align="absmiddle">
								</td>
								<td width="">Free Days</td>
								<td width="">
									<input type="text" name="lse_free_dys" caption="Free Days" style="width:75;text-align:right;" class="input" value="" maxlength="5" dataformat="int">
								</td>
								<td width="">Create User</td>
								<td width="">
									<input type="text" name="cre_usr_id" caption="Create User" style="width:75;text-align:center;" class="input2" value="" readonly>
								</td>
								<td width="">Create Date</td>
								<td width="">
									<input type="text" name="cre_dt" caption="Create Date" style="width:75;text-align:center;" class="input2" value="" readonly>
								</td>
							</tr>
							</table>
							<table class="search" border="0" style="width:979">
							<tr class="h23">
								<td width="99" valign="top">&nbsp;&nbsp;Remark(s)</td>
								<td width="" colspan="5">
									<textarea name="agmt_rmk" rows="6" style="width:100%;ime-mode:disabled" maxlength="1000"></textarea>
								</td>
							</tr>
							</table>
						<!--  biz_1  (E) -->
						<table class="height_8"><tr><td></td></tr></table>
					</td>
					<!-- : ( Search Options ) (E) -->
				</tr>
			</table>
			<!--biz page (E)-->
			<table class="height_8"><tr><td></td></tr></table>
	        <!-- Tab ) (S) -->
	        <table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
	            <tr>
	                <td width="100%">
	                    <script language="javascript">ComTabObject('tab1')</script>
	                </td>
	            </tr>
	        </table>
	        <!-- Tab ) (E) -->

			<!--  Tab_1 (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search">
					<tr>
						<td class="bg" style="height:258" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable1">
								<tr>
				                    <td width="100%">
				                        <script language="javascript">ComSheetObject1('t1sheet1');</script>
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
					                            <td class="btn2" name="btn_t1RowAdd">Row&nbsp;Add</td>
					                            <td class="btn2_right"></td></tr>
					                            </table></td>
					                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            <tr><td class="btn2_left"></td>
					                            <td class="btn2" name="btn_t1RowDelete">Row&nbsp;Delete</td>
					                            <td class="btn2_right"></td></tr>
					                            </table></td>
					                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            <tr><td class="btn2_left"></td>
					                            <td class="btn2" name="btn_t1LoadExcel">Load&nbsp;Excel</td>
					                            <td class="btn2_right"></td></tr>
					                            </table></td>
					                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            <tr><td class="btn2_left"></td>
					                            <td class="btn2" name="btn_t1DownExcel">Down&nbsp;Excel</td>
					                            <td class="btn2_right"></td></tr>
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
			</div>
			<!--  Tab_1 (E) -->

			<!--  Tab_2 (S) -->
			<div id="tabLayer" style="display:none">
		        <table class="search">
		            <tr>
		            	<td class="bg" style="height:258" valign="top">
				            <!-- Grid  1(S) -->
				            <table width="100%"  id="mainTable2">
				                <tr>
				                    <td width="100%">
				                        <script language="javascript">ComSheetObject1('t2sheet1');</script>
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
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            		<tr>
					                            			<td class="btn2_left"></td>
					                            			<td class="btn2" name="btn_t2RowAdd">Row&nbsp;Add</td>
					                            			<td class="btn2_right"></td>
					                            		</tr>
					                            	</table>
					                            </td>
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            		<tr>
					                            			<td class="btn2_left"></td>
					                            			<td class="btn2" name="btn_t2RowDelete">Row&nbsp;Delete</td>
					                            			<td class="btn2_right"></td>
					                            		</tr>
					                            	</table>
					                            </td>
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            		<tr>
					                            			<td class="btn2_left"></td>
					                            			<td class="btn2" name="btn_t2LoadExcel">Load&nbsp;Excel</td>
					                            			<td class="btn2_right"></td>
					                            		</tr>
					                            	</table>
					                            </td>
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            		<tr>
					                            			<td class="btn2_left"></td>
					                            			<td class="btn2" name="btn_t2DownExcel">Down&nbsp;Excel</td>
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
		            	</TD>
		            </tr>
		        </table>
			</div>
			<!--  Tab_2 (E) -->

			<!--  Tab_3 (S) -->
			<div id="tabLayer" style="display:none">
		        <table class="search">
		            <tr>
		            	<td class="bg" style="height:258" valign="top">
			                <!-- Grid  (S) -->
			                <table width="100%"  id="mainTable3">
			                    <tr>
			                        <td width="100%">
			                            <script language="javascript">ComSheetObject1('t3sheet1');</script>
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
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            		<tr>
					                            			<td class="btn2_left"></td>
					                            			<td class="btn2" name="btn_t3RowAdd">Row&nbsp;Add</td>
					                            			<td class="btn2_right"></td>
					                            		</tr>
					                            	</table>
					                            </td>
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            		<tr>
					                            			<td class="btn2_left"></td>
					                            			<td class="btn2" name="btn_t3RowDelete">Row&nbsp;Delete</td>
					                            			<td class="btn2_right"></td>
					                            		</tr>
					                            	</table>
					                            </td>
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            		<tr>
					                            			<td class="btn2_left"></td>
					                            			<td class="btn2" name="btn_t3LoadExcel">Load&nbsp;Excel</td>
					                            			<td class="btn2_right"></td>
					                            		</tr>
					                            	</table>
					                            </td>
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            		<tr>
					                            			<td class="btn2_left"></td>
					                            			<td class="btn2" name="btn_t3DownExcel">Down&nbsp;Excel</td>
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
		            	</TD>
		            </tr>
		        </table>
			</div>
			<!--  Tab_3 (E) -->

			<!--  Tab_4 (S) -->
			<div id="tabLayer" style="display:none">
		        <table class="search">
		            <tr>
		            	<td class="bg">
				            <!-- Grid  (S) -->
				            <table width="100%"  id="mainTable4">
				                <tr>
				                    <td width="100%">
				                        <script language="javascript">ComSheetObject1('t4sheet1');</script>
				                    </td>
				                </tr>
				            </table>
				            <!-- Grid  (E) -->
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
						                            		<td class="btn2" name="btn_t4RowAdd">Row&nbsp;Add</td>
						                            		<td class="btn2_right"></td>
						                            	</tr>
						                            </table>
												</td>
						                        <td>
						                        	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                            	<tr>
						                            		<td class="btn2_left"></td>
						                            		<td class="btn2" name="btn_t4RowDelete">Row&nbsp;Delete</td>
						                            		<td class="btn2_right"></td>
						                            	</tr>
						                            </table>
												</td>
						                        <td>
						                        	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                            	<tr>
						                            		<td class="btn2_left"></td>
						                            		<td class="btn2" name="btn_t4LoadExcel">Load&nbsp;Excel</td>
						                            		<td class="btn2_right"></td>
						                            	</tr>
						                            </table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                            	<tr>
						                            		<td class="btn2_left"></td>
						                            		<td class="btn2" name="btn_t4DownExcel">Down&nbsp;Excel</td>
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
			                <table class="height_8"><tr><td></td></tr></table>
			                <!-- Grid  (S) -->
			                <table width="100%"  id="mainTable5">
			                    <tr>
			                        <td width="100%">
			                            <script language="javascript">ComSheetObject1('t4sheet2');</script>
			                        </td>
			                    </tr>
			                </table>
			                <!-- Grid  (E) -->
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
								                            <td class="btn2" name="btn_t4RowAdd2">Row&nbsp;Add</td>
								                            <td class="btn2_right"></td>
														</tr>
						                            </table>
												</td>
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            		<tr>
					                            			<td class="btn2_left"></td>
					                            			<td class="btn2" name="btn_t4RowDelete2">Row&nbsp;Delete</td>
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
						</TD>
					</tr>
		        </table>
			</div>
			<!--  Tab_4 (E) -->

			<!--  Tab_5 (S) -->
			<div id="tabLayer" style="display:none">
		        <table class="search">
		            <tr>
		            	<td class="bg">
		          			<table class="search" border="0" style="width:979;">
								<tr class="h23">
									<td width="120" >Build Down Period</td>
									<td width="" class="stm">
										<input type="text" name="agmt_chg_val" style="width:45;text-align:right;" class="input1" value="" dataformat="int" maxlength="3">&nbsp;&nbsp;Months
									</td>
								</tr>
							</table>
							<table class="height_5"><tr><td></td></tr></table>
							<table class="search" border="0">
								<tr>
									<td class="title_h"></td>
									<td class="title_s">Post Build Down Penalty</td>
								</tr>
							</table>
			                <!-- Grid  (S) -->
			                <table width="100%"  id="mainTable6">
			                    <tr>
			                        <td width="100%">
			                            <script language="javascript">ComSheetObject1('t5sheet1');</script>
			                        </td>
			                    </tr>
			                </table>
			                <!-- Grid  (E) -->
		            	</TD>
		            </tr>
		        </table>
			</div>
			<!--  Tab_5 (E) -->

			<!--  Tab_6 (S) -->
			<div id="tabLayer" style="display:none">
		        <table class="search">
		            <tr>
		            	<td class="bg">
			                <!-- Grid  (S) -->
			                <table width="100%"  id="mainTable7">
			                    <tr>
			                        <td width="100%">
			                            <script language="javascript">ComSheetObject1('t6sheet1');</script>
			                        </td>
			                    </tr>
			                </table>
			                <!-- Grid  (E) -->
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
							                            	<td class="btn2" name="btn_t6LoadExcel">Load&nbsp;Excel</td>
							                            	<td class="btn2_right"></td>
							                            </tr>
					                            	</table>
					                            </td>
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							                            <tr>
							                            	<td class="btn2_left"></td>
								                            <td class="btn2" name="btn_t6DownExcel">Down&nbsp;Excel</td>
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
			            </TD>
					</tr>
		        </table>
			</div>
			<!--  Tab_6 (E) -->
			
			<!--  Tab_7 (S) -->
			<div id="tabLayer" style="display:none">
		        <table class="search">
		            <tr>
		            	<td class="bg">
			                <!-- Grid  (S) -->
			                <table width="100%"  id="mainTable7">
			                    <tr>
			                        <td width="100%">
			                            <script language="javascript">ComSheetObject1('t7sheet1');</script>
			                        </td>
			                    </tr>
			                </table>
			                <!-- Grid  (E) -->
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
								                            <td class="btn2" name="btn_t7RowAdd">Row&nbsp;Add</td>
								                            <td class="btn2_right"></td>
														</tr>
						                            </table>
												</td>
					                            <td>
					                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            		<tr>
					                            			<td class="btn2_left"></td>
					                            			<td class="btn2" name="btn_t7RowDelete">Row&nbsp;Delete</td>
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
			            </TD>
					</tr>
		        </table>
			</div>
			<!--  Tab_7 (E) -->


		</td>
	</tr>
</table>
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>