<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0113.jsp
*@FileTitle : Oneway Loading PFMC
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2016.04.05 두기민
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event.EesLse0113Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesLse0113Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	String strAgmt_seq		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id     = account.getUsr_id();
		strUsr_nm     = account.getUsr_nm();
		strUsr_off_cd = account.getOfc_cd();

		event = (EesLse0113Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		strAgmt_seq = JSPUtil.getNull(request.getParameter("agmt_seq"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strCntrTpSzCd = (String)eventResponse.getCustomData("cntr_tpsz_cd");
		
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Lease Agreement Inquiry</title>
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
<input type="hidden" name="req_agmt_seq" value="<%= strAgmt_seq %>">
<input type="hidden" name="inquiryLevel" value="">
<input type="hidden" name="location" value="">
<input type="hidden" name="tabFlg" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
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
				                <td>
									<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
					                    	<td class="btn1_left"></td>
					                    	<td class="btn1" name="btn_Oneway">Oneway Upload</td>
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
					<table class="search" id="mainTable">
						<tr>
							<td class="bg">
								<table class="search" border="0" bordercolor="red"
									style="width: 960;">

									<tr class="h23">
										<td width="45">Period</td>
					                    <td width="142">
					                      <select style="width:140;" class="input1" name="period">
						                    <option value="D" selected>Date(YYYY-MM-DD)</option>
						                    <option value="M" >Month(YYYY-MM)</option>
						                    <option value="W">Week(YYYY-WW) </option>
						                  </select>
						                </td>
						                <td width="255">
						                   &nbsp;<input type="text" style="width:80;" class="input1" value="" name="froms" caption="FM" required dataformat="ymd" maxlength="8">&nbsp;~&nbsp;
					                             <input type="text" style="width:80;" class="input1" value="" name="tos" required dataformat="ymd" caption="TO" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarfm" >
					                             <input type="hidden" name="tos_h">
					                    </td>
										<td width="70">Lease Term</td>
					                    <td width="60"><input type="text" name="lease_term_cd" caption="Lease Term" style="width:40;text-align:center;" value="OF" class="input2" readonly>	
										<td width="90" style="text-align:left"><input type="checkbox" name="dpsl" class="trans">DPSL</td>
										<td width="60">T/Size</td>
										<td width="" style="padding-left: 2;">
											<script language="javascript">
												ComComboObject('combo1', 1, 100, 1);
											</script>
									        &nbsp<input type="hidden" name="tpsz_cd" value="">
									    </td>
									</tr>
								</table>
								<table class="search" border="0" bordercolor="red" style="width: 960;">
									<tr class="h23">
										<td width="45">Trade</td>
										<td width="145">
											<select style="width: 100;" name="trd">
											    <option value="" selected>ALL</option>
												<option value="AES">AES</option>
												<option value="AFS">AFS</option>
												<option value="EFS">EFS</option>
												<option value="IAS">IAS</option>
												<option value="IES">IES</option>
												<option value="IFS">IFS</option>
												<option value="IMS">IMS</option>
												<option value="MFS">MFS</option>
												<option value="TAS">TAS</option>
												<option value="TPS">TPS</option>
												<option value="COM">COM</option>
											</select>
										</td>
										<td width="100">DEL/POD DOL</td>
										<td width="151">
											<select style="width: 100;" name="del_dol">
												<option value="" selected>ALL</option>
												<option value="Y">Y</option>
												<option value="N">N</option>
											</select>
										</td>
										<td width="71">POR DOL</td>
										<td width="151">
											<select style="width: 100;" name="por_dol">
												<option value="" selected>ALL</option>
												<option value="Y">Y</option>
												<option value="N">N</option>
											</select>
										</td>
										<td width="60">Interface</td>
										<td width="">
											<select style="width: 100;" name="if_flg">
												<option value="" selected>ALL</option>
												<option value="Y">Y</option>
												<option value="N">N</option>
											</select>
										</td>
									</tr>
									</tr>
								</table>
								
								<table class="search" border="0" bordercolor="red"
									style="width: 960;">
									<tr class="h23">
									    <td width="45">MVMT</td>
										<td width="145">
											<select style="width: 100;" name="mvmt">
												<option value="VLOCOC-VL">OC-VL</option>
												<option value="VLMTMT-VL">MT-VL</option>
											</select>
										</td>
									    <td width="100">Loading LOC</td>
										<td width="">
											<select name="loc_tp" style="width: 100;">
												<option value="RCC">RCC</option>
												<option value="LCC">LCC</option>
												<option value="ECC">ECC</option>
												<option value="SCC">SCC</option>
												<option value="OFC">Sale Office</option>
											</select> 
											<input type="text" caption="Location to" name="loc_to" style="width: 78; text-align: center;" class="input1" value="" maxlength="5" dataformat="engup"> 
										    <img class="cursor" name="btns_search4" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table> <!--  biz  1 (E) --> <!--biz 2 (S)-->
					<table class="height_8">
						<tr>
							<td></td>
						</tr>
					</table>

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
				<table class="search" onresize="ChangeSize(this.clientWidth)">
					<tr>
						<td class="bg">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable1">
								<tr>
				                    <td width="100%">
				                        <script language="javascript">ComSheetObject('t1sheet1');</script>
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
														<td class="btn2" name="btn_DownExcel">Down Excel</td>
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
			</div>
			<!--  Tab_1 (E) -->

			<!--  Tab_2 (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search">
					<tr>
						<td class="bg">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable2">
								<tr>
				                    <td width="100%">
				                        <script language="javascript">ComSheetObject('t2sheet1');</script>
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
														<td class="btn2" name="btn_agmt">Open AGMT</td>
														<td class="btn2_right"></td>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_DownExcel2">Down Excel</td>
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
			</div>
			<!--  Tab_2 (E) -->

			
		</td>
	</tr>
</table>
<table class="height_10"><tr><td></td></tr></table>
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>