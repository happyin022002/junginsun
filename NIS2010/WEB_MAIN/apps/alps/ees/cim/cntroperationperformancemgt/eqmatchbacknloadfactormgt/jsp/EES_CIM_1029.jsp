<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_1029.jsp
*@FileTitle : Cargo Flow Map
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.06.23문중철
* 1.0 Creation 
* ======================================================
* 2010.08.27 남궁진호 Ticket ID :Ticket ID : CHM-201005533-01
*            조회 조건 추가 (Loc_Loc)에 화면 UI수정
* 2012.05.11 신자영 [CHM-201217714-01] Cargo Flow Map 로직 수정 - LOC-LOC조건 선택 시 region 에 걸린 제약 제거
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
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
	String xml = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
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
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		document.form.froms.focus();
	}
    
    
function revForm(type) {
  if (type == "on") {
    document.getElementById("layer1").style.display = "";
  } else if (type == "off") {
    document.getElementById("layer1").style.display = "none"; 
  }
}

  
</script>
</head>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="etcDataValue" value="">
<input type="hidden" name="etcChk" value="">
<input type="hidden" name="fromz">		<!-- 2014.11.18 민정호 from_dt랑 동일기능-->
<input type="hidden" name="toz">		<!-- 2014.11.18 민정호 to_dt랑 동일기능-->
<input type="hidden" name="inquiryLevel">
<input type="hidden" name="inquiryWise1">
<input type="hidden" name="inquiryWise2">
<input type="hidden" name="location">
<input type="hidden" name="location2">
<input type="hidden" name="week_list" value="">	<!-- 2014.11.18 민정호 -->
<input type="hidden" name="from_dt">	<!-- 2014.11.18 민정호 -->
<input type="hidden" name="to_dt">		<!-- 2014.11.18 민정호 -->
<input type="hidden" name="tp_sz_loc">		<!-- 2014.11.18 민정호 -->
<input type="hidden" name="from_loc">		<!-- 2014.11.18 민정호 -->
<input type="hidden" name="to_loc">		<!-- 2014.11.18 민정호 -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->
	<!--top menu (E)-->
	</td></tr>
	<tr><td valign="top">
    	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_detail">Detail</td>
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
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40" align="center">Period</td>
                    <td width="127">
                        <select style="width:125;" class="input1" name="period" >
                            <option value="M" selected>Month(YYYY-MM)</option>
                            <option value="W">Week(YYYY-WW)</option>
                        </select>
                    </td>
                    <td width="180">&nbsp;
                        <input type="text" style="width:55;" class="input1" value="" name="froms" caption="FM" required dataformat="ym" maxlength="6">&nbsp;~&nbsp;
                        <input type="text" style="width:55;" class="input1" value="" name="tos"   caption="TO" required dataformat="ym" maxlength="6">
                    </td>
					<td>
						<table border="0" style="width:420;border:0px" class="search_sm2"> 
						<tr class="h23">
							<td width="75">&nbsp;&nbsp;TP/SZ</td>
                            <td width="345" class="stm" style="font-size:12;">
                            <input type="radio" class="trans" checked name="tpsz" value="A" onClick="rdTypeSel(this.value)" onkeypress="testAlert()">&nbsp;All&nbsp;&nbsp;
                            <input type="radio" class="trans"         name="tpsz" value="D" onClick="rdTypeSel(this.value)" onkeypress="testAlert()">&nbsp;DRY&nbsp;&nbsp;
                            <input type="radio" class="trans"         name="tpsz" value="S" onClick="rdTypeSel(this.value)" onkeypress="testAlert()">&nbsp;SPCL&nbsp;&nbsp;
                            <input type="radio" class="trans"         name="tpsz" value="R" onClick="rdTypeSel(this.value)" onkeypress="testAlert()">&nbsp;Reefer&nbsp;
                            <select style="width:100;" class="input" name="rdtype" disabled>
                                <option value="I" selected>Incl R/D</option>
                                <option value="E"         >Excl R/D</option>
                                <option value="O"         >Only R/D</option>
                            </select>
                            </td>
						</tr>
						</table>
						
					</td>
				</tr> 
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr><td colspan="5" height="5"></td></tr>
				<tr class="h23">
					<td width="550">
						<table border="0" cellpadding="0" cellspacing="1" style="width:400;" class="search_sm2"> 
						<tr class="h23">
							<td rowspan="2" width="100">&nbsp;&nbsp;Direction Wise<br style="font-size:6;">&nbsp;
                                <select style="width:88;" class="input" name="directionWise" onchange="setText('R');">
                                    <option value="L" selected>Loc-Loc</option>
                                    <option value="F"         >From</option>
                                    <option value="T"         >To  </option>
                                </select>
                            </td>
							<td width="35" class="stm">&nbsp;&nbsp;<span id="ff" >From</span>&nbsp;</td>
							<td width="90">
                                <select style="width:82;" class="input" name="startloc" onchange="setSubCombo();">
                                    <option value="R" selected>RCC    </option>
                                    <option value="L"         >LCC    </option>
                                    <option value="E"         >ECC    </option>
                                    <option value="S"         >SCC    </option>
                                    <option value="C"         >Country</option>
                                    <option value="P"         >POL    </option>
                                </select>
                            </td>
                            <td width="165">    
                                <div id = "div_loc" style = "display:''" >
                                <input type="text" style="width:51;" size="5" class="input" dataformat="engup" style="ime-mode:disabled" name="locationf1" value="" maxlength="5">
                                </div>
                                <div id = "div_loc2" style = "display:'none'" >
                                <input type="text" style="width:132;" size="5" class="input" dataformat="engup" style="ime-mode:disabled; text-transform:uppercase;" name="locationf2" value="">
                                <img class="cursor" src="img/btns_search.gif" name="btn_floc_cd" width="19" height="20" border="0" align="absmiddle">
                                </div>
                                <div id = "div_cnty" style = "display:'none'" >
                                <input type="text" size="2" class="input" dataformat="engup" style="ime-mode:disabled" name="country" value="" maxlength="2">
                                </div>
                            </td>
                        </tr>
						<tr class="h23">
							<td width="35" class="stm">&nbsp;&nbsp;<span id="tt" >To</span>&nbsp;</td>
							<td width="90">
                                <select style="width:82;" class="input" name="endloc" onchange="setEndLoc();">
                                    <option value="R" selected>RCC    </option>
                                    <option value="L"         >LCC    </option>
                                    <option value="E"         >ECC    </option>
                                    <option value="S"         >SCC    </option>
                                    <option value="C"         >Country</option>
                                    <option value="P"         >POD    </option>
                                </select>
							</td>
							<td width="165">    
                                <div id = "div_loc3" style = "display:'none'" >
                                <input type="text" style="width:132;" size="5" class="input" dataformat="engup" style="ime-mode:disabled; text-transform:uppercase;" name="locationt2" value="">
                                <img class="cursor" src="img/btns_search.gif" name="btn_tloc_cd" width="19" height="20" border="0" align="absmiddle">
                                </div>
                                <div id = "div_cnty2" style = "display:'none'" >
                                <input type="text" size="2" class="input" dataformat="engup" style="ime-mode:disabled" name="country2" value="" maxlength="2">
                                </div>
                            </td>
						</tr>
						</table>
					</td>
					<td width="429"> 
					<table border="0" cellpadding="0" cellspacing="0" style="width:229;" > 
						<tr class="h23">
							<td width="50" valign="top"> &nbsp;S.O.C</td>
							<td width="120" valign="top">
		                        <select style="width:70;" class="input" name="soc" >
		                            <option value="E" selected>Exclude</option>
		                            <option value="I"         >Include</option>
		                            <option value="O"         >Only </option>
		                        </select>
		                    </td>
							<td width="69" valign="top">Company</td>
							<td valign="top"><input type="text" style="width:30;" class="input" value="SML" readOnly name="company"></td>
							<td width="285"></td>
						</tr>
						<tr class="h23"><td width="229"></td></tr>
					</table>
					</td>
				</tr>
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
<!-- ############################################################### -->
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 		
<!-- ############################################################### -->
<!--TAB M/B Detail (S) -->
<div id="tabLayer" style="display:none">
<!-- ############################################################### -->		
		<table class="search" id="mainTable"> 
       		<tr style="display:inline"><td class="bg">	

			<!-- Grid  (S) -->
			<div id = "tr_from_to" style = "display:''" >
				<table width="100%"  id="mainTable1"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
				</div>
				<div id = "tr_loc_loc" style = "display:'none'" >
				<table width="100%"  id="mainTable2"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet2');</script>
						</td>
					</tr>
				</table>
				</div>
			<!-- Grid (E) -->							
			</td></tr>			
		</table>
		<!--biz page (E)-->
<!-- ############################################################### -->		
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
							<script language="javascript">ComSheetObject1('t2sheet1');</script>
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
<!-- ############################################################### -->	
	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>

<!-- Copyright (S) -->
<!-- Copyright(E)-->
</form>
<div id="sheet_week"  style="display:'none'" >
<script language="javascript">ComSheetObject('sheet1');</script>
</div>
</body>
</html>
