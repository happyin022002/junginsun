<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_1032.jsp
*@FileTitle : Match-Back by Service Mode
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1032Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1032Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Match-Back by Service Mode</title>
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

<body  onLoad="setupPage();">
<form name="form"  onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="etcDataValue" value="">
<input type="hidden" name="from">
<input type="hidden" name="to">
<input type="hidden" name="inquirylevel">
<input type="hidden" name="inquiryLevel">
<!-- developer job	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td width="38" align="center">Period</td>
					<td width="127" style="padding-left:2;">
						<select style="width:125;" class="input1" name="period" >
						<option value="M" selected >Month(YYYY-MM)</option>
						<option value="W"          >Week(YYYY-WW)</option>
						</select>
					</td>
					<td width="180">
					<input type="text" style="width:55;" class="input1" value="" name="froms" caption="FM" required dataformat="ym" maxlength="6">&nbsp;~&nbsp;
					<input type="text" style="width:55;" class="input1" value="" name="tos"   caption="TO" required dataformat="ym" maxlength="6"></td>
					<td width="85">Location by</td>
					<td width="210">
					<select style="width:100;" class="input1" name="locationBy" onkeypress="form_keyup();">
						<option value="AR" selected >All(by RCC)    </option>
						<option value="AC"          >All(by Country)</option>
						<option value="AP"          >All(by Port)   </option>
                        <option value="RL"          >RCC(by LCC)    </option>
                        <option value="RE"          >RCC(by ECC)    </option>
                        <option value="RC"          >RCC(by Country)</option>
						<option value="LE"          >LCC(by ECC)    </option>
						<option value="LS"          >LCC(by SCC)    </option>
						<option value="ES"          >ECC(by SCC)    </option>
						<option value="SS"          >SCC            </option>
						</select>&nbsp;<input type="text" disabled style="width:45;" class="input" value="" dataformat="engup" style="ime-mode:disabled" name="location" maxlength="5" >&nbsp;<img class="cursor" name="btn_loc_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td align="right">
					
						<table border="0" style="width:295;" class="search_sm2"> 
						<tr class="h23">
							<td width="95">&nbsp;Service Mode</td>
							<td class="stm" style="font-size:12;">
								<input type="radio" class="trans" name="cargotype" value="A" checked >&nbsp;All&nbsp;
								<input type="radio" class="trans" name="cargotype" value="L"         >&nbsp;Local&nbsp;
								<input type="radio" class="trans" name="cargotype" value="I"         >&nbsp;IPI&nbsp;
								<input type="radio" class="trans" name="cargotype" value="M"         >&nbsp;MLB
							</td>
						</tr>
						</table>
						
					</td>
				</tr> 
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="492">
						<table border="0" style="width:430;" class="search_sm2"> 
						<tr class="h23">
							<td width="45">TP/SZ</td>
							<td width="" class="stm" style="font-size:12;">
								<input type="radio" class="trans" name="tpsz" value="A" checked onClick="rdTypeSel(this.value)">&nbsp;All&nbsp;&nbsp;
								<input type="radio" class="trans" name="tpsz" value="D"         onClick="rdTypeSel(this.value)">&nbsp;DRY&nbsp;&nbsp;
								<input type="radio" class="trans" name="tpsz" value="S"         onClick="rdTypeSel(this.value)">&nbsp;SPCL&nbsp;&nbsp;
								<input type="radio" class="trans" name="tpsz" value="R"         onClick="rdTypeSel(this.value)">&nbsp;Reefer&nbsp;&nbsp;
								<select style="width:100;" class="input" name="rdtype" disabled >
									<option value="I" selected >Include R/D</option>
									<option value="E"          >Exclude R/D</option>
									<option value="O"          >Only R/D</option>
								</select>
							</td>
						</tr>
						</table>
					</td>
					<td width="35">S.O.C</td>
					<td width="465">
						<select style="width:80;" class="input" name="soc">
							<option value="E" selected >Exclude</option>
							<option value="I"          >Include</option>
							<option value="O"          >Only</option>
						</select>
					</td>
				</tr>
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
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
			
						
			</td></tr>
		</table>
		<!--biz page (E)-->

	
	
	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
<!-- developer job end -->
</form>
</body>
</html>