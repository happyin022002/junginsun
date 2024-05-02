<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_1018.jsp
*@FileTitle : Location M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.05.20 문중철
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	String popYn			= "";

	Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();

		event = (EesCim1018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		popYn	= request.getParameter("pop_mode") == null ? "N" : "Y";

		xml = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to nis2010!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">

	var conds = {
		pop_yn : "<%=popYn%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var tempVal01  = "<%=event.getInquiryLevel()%>";
		var tempVal02  = "<%=event.getLocationBy  ()%>";
		var tempVal03  = "<%=event.getPeriod      ()%>";
		var tempVal04  = "<%=event.getFroms       ()%>";
		var tempVal05  = "<%=event.getTos         ()%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		if(tempVal01==""){
			flag0001 = "No";
		}else{
			flag0001 = "Yes";
		}
		document.getElementById("period"    ).value = tempVal03;
		document.getElementById("froms"     ).value = tempVal04;
		document.getElementById("tos"       ).value = tempVal05;
		document.getElementById("locationBy").value = tempVal01;
		document.getElementById("location"  ).value = tempVal02;
		if(tempVal03=="W"){
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
		}else{
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
		}
		if( tempVal01=="AR" || tempVal01=="AC" || tempVal01=="AP" ){
			document.getElementById("location").disable   = true;
			document.getElementById("location").className = "input2";
			document.getElementById("location").value     = "";
		}else{
			document.getElementById("location").disable   = false;
			document.getElementById("location").className = "input";
			document.getElementById("location").value     = tempVal02;
		}
		if(tempVal01==""){
			document.getElementById("period").value = "M";
		}
		if(tempVal01==""){
			document.getElementById("locationBy").value = "AR";
		}
		document.form.froms.focus();		
		loadPage(tempVal01);
	}
</script>
</head>
<% if(popYn.equals("Y")){ %>

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="etcDataValue" value="">
<input type="hidden" name="etcChk" value="">
<input type="hidden" name="from">
<input type="hidden" name="to">
<input type="hidden" name="inquiryLevel">
<input type="hidden" name="flag0001">
<!-- Report Start -->
<input type="hidden" name="rpt_period"    >
<input type="hidden" name="rpt_fromdate"  >
<input type="hidden" name="rpt_todate"    >
<input type="hidden" name="rpt_locationby">
<input type="hidden" name="rpt_location"  >
<input type="hidden" name="rpt_cargotype" >
<input type="hidden" name="rpt_tpsz"      >
<input type="hidden" name="rpt_rdtype"    >
<input type="hidden" name="rpt_enroute"   >
<input type="hidden" name="rpt_tnroute"   >
<input type="hidden" name="rpt_soc"       >
<input type="hidden" name="rpt_company"   >
<input type="hidden" name="rpt_loc_cd"   >
<input type="hidden" name="rpt_cnt_cd"  value="<%=strCnt_cd%>" >

<input type="hidden" name="pop_yn" value="<%=popYn %>">

<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Location M/B By Logistics-wise  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<% }else{ %> 
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="etcDataValue" value="">
<input type="hidden" name="etcChk" value="">
<input type="hidden" name="from">
<input type="hidden" name="to">
<input type="hidden" name="inquiryLevel">
<input type="hidden" name="flag0001">
<!-- Report Start -->
<input type="hidden" name="rpt_period"    >
<input type="hidden" name="rpt_fromdate"  >
<input type="hidden" name="rpt_todate"    >
<input type="hidden" name="rpt_locationby">
<input type="hidden" name="rpt_location"  >
<input type="hidden" name="rpt_cargotype" >
<input type="hidden" name="rpt_tpsz"      >
<input type="hidden" name="rpt_rdtype"    >
<input type="hidden" name="rpt_enroute"   >
<input type="hidden" name="rpt_tnroute"   >
<input type="hidden" name="rpt_soc"       >
<input type="hidden" name="rpt_company"   >
<input type="hidden" name="rpt_loc_cd"   >
<input type="hidden" name="rpt_cnt_cd"  value="<%=strCnt_cd%>" >

<input type="hidden" name="pop_yn" value="<%=popYn %>">

<!-- Report End -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
<% } %>	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Print">Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="45">&nbsp;Period</td>
					<td width="127"><select style="width:125;" class="input1" name="period" >
						<option value="M" selected>Month(YYYY-MM)</option>
						<option value="W">Week(YYYY-WW)</option>
						</select></td>
					<td width="208">
					<input type="text" style="width:55;" class="input1" value="" name="froms" caption="FM" required dataformat="ym" maxlength="6">&nbsp;~
					<input type="text" style="width:55;" class="input1" value="" name="tos"   caption="TO" required dataformat="ym" maxlength="6"></td>
					<td width="75">Location by</td>
					<td width="200">
					<select style="width:100;" class="input1" name="locationBy" >
						<option value="AR" selected >ALL(by RCC)    </option>
						<option value="AC"          >ALL(by Country)</option>
						<option value="RL"          >RCC(by LCC)    </option>
						<option value="RE"          >RCC(by ECC)    </option>
						<option value="LE"          >LCC(by ECC)    </option>
						<option value="LS"          >LCC(by SCC)    </option>
						<option value="ES"          >ECC(by SCC)    </option>
						<option value="CC"          >Country        </option>
						<option value="SS"          >SCC            </option>
						<option value="YY"          >Yard           </option>
						</select>
						<input type="text" disabled style="width:60;" class="input" value="" dataformat="engup" style="ime-mode:disabled" name="location" maxlength="7" >
						<img class="cursor" name="btn_loc_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="73">Cargo Type</td>
					<td width="100"><select style="width:80;" class="input" name="cargoType" >
						<option value="A" selected></option>
						<option value="F"         >Full</option>
						<option value="M"         >MTY</option>
						</select></td>
					<td width="60">Company</td>
					<td><input type="text" style="width:30;" class="input" value="SML" readOnly ></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="380">
    					<table border="0" style="width:365;" class="search_sm2"> 
        					<tr class="h23">
            					<td width="40">TP/SZ</td>
            					<td width="" class="stm" style="font-size:12;">
            						<input type="radio" class="trans" checked name="tpsz" value="A" onClick="rdTypeSel(this.value)">All&nbsp;
            						<input type="radio" class="trans"  name="tpsz" value="D" onClick="rdTypeSel(this.value)">DRY&nbsp;
            						<input type="radio" class="trans"  name="tpsz" value="S" onClick="rdTypeSel(this.value)">SPCL&nbsp;
            						<input type="radio" class="trans"  name="tpsz" value="R" onClick="rdTypeSel(this.value)">Reefer&nbsp;
            						<select style="width:100;" class="input" name="rdtype" disabled>
            						<option value="I" selected>Included R/D</option>
            						<option value="E">Excluded R/D</option>
            						<option value="O">Only R/D</option>
            						</select>
                                </td>
        					</tr> 
    					</table>
                    </td>
					<td width="75">En Route </td>
					<td width="90"><select style="width:78;" class="input" name="enRoute">
						<option value="E" selected>Exclude</option>
						<option value="I">Include</option>
						<option value="O">Only </option>
						</select></td>
					<td width="75">Tn Route </td>
					<td width="90"><select style="width:78;" class="input" name="tnRoute">
						<option value="E" selected>Exclude</option>
						<option value="I">Include</option>
						<option value="O">Only </option>
						</select></td>						
					<td width="73">S.O.C</td>
					<td width="90"><select style="width:80;" class="input" name="soc">
						<option value="E" selected>Exclude</option>
						<option value="I">Include</option>
						<option value="O">Only </option>
						</select></td>
					<td width="60">US DOM</td>
					<td width=""><select style="width:80;" class="input" name="company">
						<option value="E" selected>Exclude</option>
						<option value="I">Include</option>
						</select></td> 
					
					
				
				</tr> 
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
			
			
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 		
		
		
		
		
		
<!--TAB M/Back(%) (S) -->
<div id="tabLayer" style="display:inline">		
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
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

			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (E) -->
	<!--biz page (E)-->
	
</div>
<!--TAB M/Back(%) (E) --> 	
	


<!--TAB M/B Detail (S) -->
<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject1('t2sheet1');</script>
						</td>
					</tr>
				</table>			

			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

</div>
<!--TAB M/B Detail (E) -->  





<!--TAB M/B Trend (S) -->
<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject1('t3sheet1');</script>
						</td>
					</tr>
				</table>			

			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

</div>
<!--TAB M/B Trend (E) --> 




<table class="height_5"><tr><td></td></tr></table>	
	
	

	</td></tr>
</table>
<div id="popLayer" style="display:none">

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
		    					<%
		    						if("Y".equals(popYn)){ 
		    					%>
		    					<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<%	} %>
							</tr>
						</table>
    					<!--Button (E) -->
	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>
</form>
</body>
</html>
