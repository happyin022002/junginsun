<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_SCE_6000.jsp
*@FileTitle : SCE Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.02 김인수
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
<%@ page import="com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.event.EsdSce6000Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce6000Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SceAdminManage.SceAdminManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce6000Event)request.getAttribute("Event");
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
<title>SCE Admin</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		leaInit();
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}

	function leaInit(){
	var currentDate = new Date();

	var yr = (currentDate.getYear()).toString();
	var mn = (currentDate.getMonth()).toString();

	if( mn.length == 1) mn = '0'+mn;
	
	document.form.leaAccMon.value = yr+mn;
}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
							<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
							<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
						</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td><td class="btn1" name="btn_download" id="btn_download">Download</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab">
            <tr>
            	<td><script language="javascript">ComTabObject('tab1' )</script>
            	</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<div id="tabLayer" style="display:inline">
		
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
					
					<tr class="h23">
						<td width="90">From / To Date</td>
						<td width=""><input type="text" style="width:78 ; text-transform:uppercase;" name="tml_fm_dt"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:78" name="tml_to_dt"  maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img name="btns_calendar1" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</tr>
					
					</table>
					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="button">
						<tr>
							<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
									<td></td>
									<!-- Repeat Pattern -->
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left">												</td>
													<td class="btn2" name="btn_terminalChange" id="btn_terminalChange">Terminal Change</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td>
						</tr>
					</table>
	    			<!-- : ( Button : Sub ) (E) -->	
	    				<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t1sheet1');</script>
					</td></tr>
					
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->
					
				</td>
			</tr>
		
				<!-- : ( Button : Sub ) (E) -->		
					

				
		
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		
		
		
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0">
				
				
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
		
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">Booking No.</td>
							<td width="160"><input name="rpln_bkg_no" type="text" style="width:120 ; text-transform:uppercase;" maxlength="13"   value="" Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
							<td width="50">B/L No.</td>
							<td width="140"><input name="rpln_bl_no" type="text" style="width:110px ; text-transform:uppercase;" maxlength="13"  Onkeydown="onEnterKey(this)"  onKeyUp="ComChkObjValid(this, false, true, true)" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
							<td width="90">Container No.</td>
							<td width=""><input name ="rpln_cntr_no" id ="rpln_cntr_no" type = "hidden" value =""></td>
							<td width="160"><input name="rpln_cntr_no_nonbit" type="text" value ="" style="width:100px ; text-transform:uppercase;" maxlength="11" Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();'  onChange="CheckDigitSplit(this,'rpln_cntr_no_split', 'rpln_cntr_no')"  onKeyUp="CheckDigitSplit(this, 'rpln_cntr_no_split', 'rpln_cntr_no')">&nbsp;<input id ="rpln_cntr_no_split" type="text" style="width:22" maxlength="2" readonly></td>
							<td width="50">COP No.</td>
							<td width="140"><input name="rpln_cop_no" type="text" style="width:110px; text-transform:uppercase;" maxlength="14"  Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();' ></td> 
						</tr>
						
						<tr class="h23">
							<td width="90">From / To Date</td>
							<td width=""><input type="text" style="width:78 ; text-transform:uppercase;" name="rpln_fm_dt"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:78" name="rpln_to_dt"  maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img name="btns_calendar2" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr>
					</table>
				
					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="button">
						<tr>
							<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
									<td></td>
										<!-- Repeat Pattern -->
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left">												</td>
													<td class="btn2" name="btn_manualReplan" id="btn_manualReplan" title="화면에서 직접 실행">Direct Manual Replan</td>
													<td class="btn2_right"></td>
													<td class="btn2_left">                                             </td>
                                                    <td class="btn2" name="btn_batchManualReplan" id="btn_batchManualReplan" title="batch table에 add">Batch Manual Replan</td>
                                                    <td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td>
						</tr>
					</table>
	    			<!-- : ( Button : Sub ) (E) -->		
					

					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t2sheet1');</script>
					</td></tr>
					
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) --></td>
			</tr>
			
			<tr>
                    <!-- Repeat Pattern -->
                    <td class="bg">
                        <!-- : ( Button : Sub ) (S) -->
                        <table width="100%" class="button">
                            <tr>
                                <td class="btn2_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <!-- Repeat Pattern -->
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                    <tr>
                                                        <td width=55 align=center><input type='text' name='row_add_cnt' value='5' style="width:50; text-align:right;" maxlength="4"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left">
                                                        </td>
                                                        <td class="btn2" name="btn_RowAdd">Row Add</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                    <tr>
                                                        <td width=55 align=center><input type='text' name='row_del_cnt' value='1' style="width:50; text-align:right;" maxlength="4"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn2_left">
                                                        </td>
                                                        <td class="btn2" name="btn_RowDelete">Row Delete</td>
                                                        <td class="btn2_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <!-- Repeat Pattern -->
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <!-- : ( Button : Sub ) (E) -->     
                    </td>
                    <!-- Repeat Pattern -->
                </tr>
			
		</table>
		
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
		
		<div id="tabLayer" style="display:none">
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg">
					
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="90">From / To Date</td>
								<td width=""><input type="text" style="width:78 ; text-transform:uppercase;" name="mst_fm_dt"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:78" name="mst_to_dt"  maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img name="btns_calendar3" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
						</table>
				
						<!-- TABLE '#D' : ( Grid ) (S) -->
						<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
						<table width="100%" id="mainTable">
						<tr><td>
						   <script language="javascript">ComSheetObject('t3sheet1');</script>
						</td></tr>
						</table>
						<!-- TABLE '#D' : ( Grid ) (E) --></td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
		
		<div id="tabLayer" style="display:none">
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg">
					
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="80">Booking No.</td>
								<td width="160"><input name="cdiff_bkg_no" type="text" style="width:120 ; text-transform:uppercase;" maxlength="13"   value="" Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
								<td width="50">B/L No.</td>
								<td width="140"><input name="cdiff_bl_no" type="text" style="width:110px ; text-transform:uppercase;" maxlength="13"  Onkeydown="onEnterKey(this)"  onKeyUp="ComChkObjValid(this, false, true, true)" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
								<td width="50">COP No.</td>
								<td width="140"><input name="cdiff_cop_no" type="text" style="width:110px; text-transform:uppercase;" maxlength="14"  Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();' ></td> 
							</tr>
							
							<tr class="h23">
								<td width="90">From / To Date</td>
								<td width=""><input type="text" style="width:78 ; text-transform:uppercase;" name="cdiff_fm_dt"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:78" name="cdiff_to_dt"  maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img name="btns_calendar4" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
						</table>
						<!-- TABLE '#D' : ( Grid ) (S) -->
						<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
						<table width="100%" id="mainTable">
							<tr>
								<td>
						   			<script language="javascript">ComSheetObject('t4sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- TABLE '#D' : ( Grid ) (E) -->
					</td>
				</tr>
				
				<tr>
					<!-- Repeat Pattern -->
					<td class="bg">
						<!-- : ( Button : Sub ) (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left">
														</td>
														<td class="btn2" name="btn_diff" id="btn_diff">Attach / Detach</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td>
							</tr>
						</table>
		    			<!-- : ( Button : Sub ) (E) -->		
					</td>
					<!-- Repeat Pattern -->
				</tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
		
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t5sheet1');</script>
					</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
		
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">Booking No.</td>
							<td width="160"><input name="act_bkg_no" type="text" style="width:120 ; text-transform:uppercase;" maxlength="13"   value="" Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
							<td width="50">B/L No.</td>
							<td width="140"><input name="act_bl_no" type="text" style="width:110px ; text-transform:uppercase;" maxlength="13"  Onkeydown="onEnterKey(this)"  onKeyUp="ComChkObjValid(this, false, true, true)" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
							<td width="90">Container No.</td>
							<td width=""><input name ="act_cntr_no" id ="act_cntr_no" type = "hidden" value =""></td>
							<td width="160"><input name="act_cntr_no_nonbit" type="text" value ="" style="width:100px ; text-transform:uppercase;" maxlength="11" Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();'  onChange="CheckDigitSplit(this,'act_cntr_no_split', 'act_cntr_no')"  onKeyUp="CheckDigitSplit(this, 'act_cntr_no_split', 'act_cntr_no')">&nbsp;<input id ="act_cntr_no_split" type="text" style="width:22" maxlength="2" readonly></td>
							<td width="50">COP No.</td>
							<td width="140"><input name="act_cop_no" type="text" style="width:110px; text-transform:uppercase;" maxlength="14"  Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();' ></td> 
						</tr>
						
						<tr class="h23">
							<td width="90">From / To Date</td>
							<td width=""><input type="text" style="width:78 ; text-transform:uppercase;" name="act_fm_dt"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:78" name="act_to_dt"  maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img name="btns_calendar5" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							
							
							<td width="60">VVD</td>
							<td width="84"><input onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="vvd" type="text" class="input" dataformat="engup" style="width:78; text-transform:uppercase;"></td>
							
							<td width=""><input name ="cntr_no" id ="cntr_no" type = "hidden" value =""></td>
							<td width=""><input name ="cntr_no" id ="cntr_no" type = "hidden" value =""></td>
							<td width=""><input name ="cntr_no" id ="cntr_no" type = "hidden" value =""></td>
							
							<td width="80">Rcv TP</td>
							<td width="168"><select name="act_rcv_tp_cd" style="width:112;">
								<option value="" >ALL</option>
								<option value="1" >MVMT</option>
								<option value="2" >VSK ACTUAL</option> 
								<option value="3" >EDI 322</option>
								<option value="9" >SPP</option>
								</select>
							</td>
							
							<td width="80">Result</td>
							<td width="168"><select name="act_umch_tp_cd" style="width:112;">
								<option value="" >ALL</option>
								<option value="99" >Success</option>
								<option value="30" >Node Not Found</option> 
								<option value="50" >Fail</option>
								</select>
							</td>
							
						</tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t6sheet1');</script>
					</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>

		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100">Account Month</td>
							<td width=""><input type="text" style="width:55 ; text-transform:uppercase;" name="leaAccMon"  maxlength="6" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">(yyyymm)</td>
						</tr>
					</table>
					
					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="button">
						<tr>
							<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
									<td></td>
									<!-- Repeat Pattern -->
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_leaSearch" id="btn_leaSearch" title="LEA DB에서 Replan해야하는 대상을 조회. SKIP 가능">LEA 대상 Retrieve</td>
													<td class="btn2_right"></td>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_LeaToAlpsIF" id="btn_LeaToAlpsIF" title="LEA DB 에서 ALPS DB로 DATA Migration. 필수사항">LEA->ALPS IF</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td>
						</tr>
					</table>
	    			<!-- : ( Button : Sub ) (E) -->	
					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t7sheet1');</script>
					</td></tr>
					</table>
			</TD></TR>
			<TR>
					<!-- TABLE '#D' : ( Grid ) (E) --></td>
				<td class="bg">
					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="button">
						<tr>
							<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
									<td></td>
									<!-- Repeat Pattern -->
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_mnrReplanAdd" id="btn_mnrReplanAdd" title="Manual replan table에 data insert. 필수사항">MNR Replan Add</td>
													<td class="btn2_right"></td>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_mnrReplanSearch" id="btn_mnrReplanSearch" title="Manual replan table 조회. SKIP 가능">MNR Replan Retrieve</td>
													<td class="btn2_right"></td>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_leadownload" id="btn_leadownload" title="COA에 Notice할 Excel download">Download</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td>
						</tr>
					</table>
	    			<!-- : ( Button : Sub ) (E) -->	
					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t8sheet1');</script>
					</td>
					
					<!-- : ( Button : Sub ) (S) -->
                    <table width="100%" class="button">
                        <tr>
                            <td class="btn2_bg">
                                <table border="0" cellpadding="0" cellspacing="0">
                                    <tr>
                                    <td></td>
                                    <!-- Repeat Pattern -->
                                        <td>
                                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_leaAuto" id="btn_leaAuto" title="LEA 결산 전과정을 자동 실행한다">Auto LEA Account</td>
                                                    <td class="btn2_right"></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <!-- Repeat Pattern -->
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                    <!-- : ( Button : Sub ) (E) --> 
					</tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) --></td>

			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>