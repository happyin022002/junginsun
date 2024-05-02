<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_2020.jsp
*@FileTitle : Lost M.G.Set Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.10 최민회
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2020Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm2020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm2020Event)request.getAttribute("Event");
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
<title>Lost M.G.Set Summary</title>
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

<body  onLoad="setupPage();" onkeyup="ComKeyEnter('search');">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="yd_cd">
<INPUT TYPE="HIDDEN" NAME="loc_cd">
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_rcc_cd">
<input type="hidden" name="eq_orz_cht_lcc_cd">
<input type="hidden" name="eq_orz_cht_scc_cd">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		
		<!-- Tab (S) Hire,  Other Exp,  Payment Term,  Redelivery,  CP file up, Certi File up,-->
     		
		<!-- Tab  (E) -->
		<!--biz page (S)-->
				<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S)  -->
			
			<table width="100%" class="search" > 
			<table width="100%" class="search" > 
			<tr class="h23">
					<td width="48"> Period</td>
					<td width="280">&nbsp;<input type="text" style="width:80;text-align:center;ime-mode:disabled"   maxlength="8"  name="evnt_dt_str"  dataformat="ymd" class="input1" value="">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;ime-mode:disabled"   maxlength="8" name="evnt_dt_end"  dataformat="ymd" class="input1" value="">&nbsp;<img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="60">Location</td>
					<td width="260" style="padding-left:4"><script language="javascript">ComComboObject('location', 1, 50, 2, 0, 1, true);</script>
					       &nbsp;<input type="text" style="width:75;text-align:center;ime-mode:disabled" dataformat="engup" name="scc_cd"  class="input"value="" maxlength='5'>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup" name="ComOpenPopupWithScc_cd"></td>
					</td>
					<td width="30">Yard</td>
					<td width=""><input type="text" dataformat="eng" maxlength="7" style="width:70;text-align:center;ime-mode:disabled" name="sts_evnt_yd_cd"  class="input"value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup" name="ComOpenPopupWithTargetYard"></td>
			
				</tr>
			</table>
			<table class="height_5"><tr><td></td></tr></table>
			<table class="search_sm2" border="0" style="width:553;"> 
				<tr class="h23">
					<td width=""><input type="radio" name="eq_aset_sts_cd" onclick="javascript:Period_Chk()" value="" class="trans" checked> Currently in Lost (Total Loss Excluded)
</td>
				</tr>
				<tr class="h23">
					<td width=""><input type="radio" name="eq_aset_sts_cd" onclick="javascript:Period_Chk()" value="LST" class="trans"> Lost Total (Total Loss and Found Included)
</td>
				</tr>
				<tr class="h23">
					<td width=""><input type="radio" name="eq_aset_sts_cd" onclick="javascript:Period_Chk()" value="FND" class="trans">  Found Total (Found M.G.Set Only)</td>
				</tr>
			</table>	
				<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
    
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				

				
	<!-- Tab BG Box  (S) -->
		

			
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
				</td>
				</tr>
			</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve"  id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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
    <!--Button (E) -->
	</td></tr>
</table>

</form>
</body>
</html>