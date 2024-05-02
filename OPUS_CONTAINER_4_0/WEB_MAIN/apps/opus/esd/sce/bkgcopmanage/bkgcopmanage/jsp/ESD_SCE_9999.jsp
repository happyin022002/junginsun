<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_9999.jsp
*@FileTitle : Bkg Cop Manage Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-21
*@LastModifier : Kim In-soo
*@LastVersion : 1.0
*
* 1.0 최초 생성
=========================================================*/
%>
<%@ page import="com.clt.framework.component.util.JSPUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.clt.apps.opus.esd.sce.bkgcopmanage.event.EsdSce9999Event"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;


	EsdSce9999Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String userId		= "";
	String userNm		= "";

	
	try {

			event = (EsdSce9999Event)request.getAttribute("Event");
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

<%
String szCOPNo = request.getParameter( "cop_no");
%>

<html>
<head>
<title>Welcome to OPUS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<script language="javascript">

    function setupPage(){
        loadPage();
        <% if( szCOPNo!= null && szCOPNo.length() > 0 ) {%>
	       	document.getElementById ("cop_no").value = "<%=szCOPNo%>";
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		<%}%>
    }

</script>
<body onLoad="setupPage();">

	<form name="form" method="post">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="pagerows" value="<%=pageRows%>">
		<input type="hidden" name="page_no" value="1">		
		
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

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr>
			<td class="bg">
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="80">Booking No. </td>
					<td width="200"><input name="bkg_no" type="text" style="width:120 ; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)" onKeyUp="ComChkObjValid(this, 'eng_num', true, 14)" onBlur="ComChkObjValid(this, 'eng_num', true, 14)"></td>
					<td width="55">B/L No.</td>
					<td  width="200"><input name="bl_no" type="text" style="width:110px ; text-transform:uppercase;"  Onkeydown="onEnterKey(this)"  onKeyUp="ComChkObjValid(this, 'eng_num', true, 12)" onBlur="ComChkObjValid(this, 'eng_num', true, 12)"></td>
					<td width="65">CNTR No.</td>
					<input name ="cntr_no" id ="cntr_no" type = "hidden" value ="">
					<td width="200">
					<input name="cntr_no_nonbit" type="text" style="width:100px ; text-transform:uppercase;" Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();'  onChange="CheckDigitSplit(this,'cntr_no_split', 'cntr_no')"  onKeyUp="CheckDigitSplit(this, 'cntr_no_split', 'cntr_no')"> 
					<input id ="cntr_no_split" type="text" style="width:22" maxlength="2" readonly>
					</td>
					<td width="60">COP No.</td>
					<td width=""><input name="cop_no" type="text" style="width:110px; text-transform:uppercase;" Onkeydown="onEnterKey(this)"  onKeyUp="ComChkObjValid(this, 'eng_num', true, 14)" onBlur="ComChkObjValid(this, 'eng_num', true, 14)"></td>
				</tr>
				<tr class="h23">
					<td width="80">Pctl No. </td>
					<td width="200"><input name="pctl_no" type="text" style="width:120 ; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)" onKeyUp="ComChkObjValid(this, 'eng_num', true, 14)" onBlur="ComChkObjValid(this, 'eng_num', true, 14)"></td>
					<td width="110">Target Bookings</td>
					<td width="" >
						<input name="tgt_bkg_nos" type="text" style="width:100; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)" >
						<img onClick="openAddPaste('tgt_bkg_nos')" class="cursor" src="/opuscntr/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					
					<td width="55">Partial</td>
					<td width="192">
					   <select name="flgPartial"  style='width:58'; >
					   		<!-- Confirm Default로 N으로 설정 &&& -->
						    <!--  <option value=""></option>-->
						    <option value="N">N</option>
						    <option value="Y">Y</option>
						</select>
					</td>
					<td>TPSZ</td><td><input name="cntr_tpsz_cd" type="text" style="width:60 ; text-transform:uppercase;" value="" onKeyUp="ComChkObjValid(this, 'eng_num', true, 14)" onBlur="ComChkObjValid(this, 'eng_num', true, 14)"></td>
				</tr>
				
				<tr class="h23">
					<td width="90">From / To Date</td>
					<td width=""><input type="text" style="width:78 ; text-transform:uppercase;" name="fm_dt"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:78" name="to_dt"  maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img name="btns_calendar1" class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				
				</table>
			</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab">
            <tr>
            	<td><script language="javascript">ComTabObject('tab1' )</script>
            	</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<div id="tabLayer" style="display:inline">
		
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0">
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
					</td>
					<!-- Repeat Pattern -->
				</tr>
			
				<tr>
					<td class="bg">
						<!-- TABLE '#D' : ( Grid ) (S) -->
						<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
						<table width="100%" id="mainTable">
							<tr><td>
							   <script language="javascript">ComSheetObject('t1sheet1');</script>
							</td></tr>
						</table>
						<!-- TABLE '#D' : ( Grid ) (E) -->
						<!-- : ( Button : Grid ) (S) -->
	                    <table style="width:737" class="sbutton">
	                    	<tr>
	                    		<td class="align">
	                    			<table class="sbutton">
	                    				<tr>
                    					</tr>
                    				</table></td>
	                    		</tr>
	                    	</table>
	                    <!-- : ( Button : Grid ) (E) --></td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
		
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
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
														<td class="btn2_left">												</td>
														<td class="btn2" name="btn_preset" id="btn_preset">Preset</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<!-- Repeat Pattern -->
											<!-- Repeat Pattern -->
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left">												</td>
														<td class="btn2" name="btn_manualReplan" id="btn_manualReplan">Manual Replan</td>
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
			
		</table>
		<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDelete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
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

					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t7sheet1');</script>
					</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
</td></tr>
</table>
<!-- OUTER - (E)nd -->
	</form>
</body>
</html>







