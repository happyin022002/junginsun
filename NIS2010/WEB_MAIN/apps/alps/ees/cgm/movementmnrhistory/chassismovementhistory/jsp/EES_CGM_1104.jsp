<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_1104.jsp
*@FileTitle : 특정 조회조건의 Chassis Movement 조회 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.23 최민회
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1104Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MovementMnrHistory.ChassisMovementHistory");
	String xml = HttpUtil.makeXML(request,response);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1104Event)request.getAttribute("Event");
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
<title>General Chassis Movement Inquiry</title>
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form"  onkeyup="ComKeyEnter('search');" action="">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<INPUT TYPE="HIDDEN" NAME="intg_cd_id">
<INPUT TYPE="HIDDEN" NAME="np" value='N'>
<input type="hidden" name="eq_no" >
<INPUT TYPE="HIDDEN" NAME="loc_cd">
<INPUT TYPE="HIDDEN" NAME="chss_mvmt_dt">
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_rcc_cd">
<input type="hidden" name="eq_orz_cht_lcc_cd">
<input type="hidden" name="eq_orz_cht_scc_cd">
<input type="hidden" name="pagerows" value='1000'>

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
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Location </td>
					<td width="265" style="padding-left:2">
					<select style="width:80;" name='location' class="input1">
						<option value="L" selected>LCC</option>
						<option value="S">SCC</option>
						</select>&nbsp;<input type="text" style="width:80;ime-mode:disabled" dataformat="engup" name="scc_cd"  class="input1"value="" maxlength='5'>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup" name="ComOpenPopupWithTarget"></td>
					<td width="75">Co-Op Pool</td>
					<td width="318"><script language="javascript">ComComboObject('chss_pool_cd', 1, 286, 0);</script></td>
					<td>Include 'NP'<input type="checkbox" value="1" class="trans" name='Include'></td>
				</tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Active Status </td>
					<td width="125" style="padding-left:2"><select style="width:80;" name='aciac_div_cd' class="input">
						<option value="" selected>ALL</option>
						<option value="A">Active</option>
						<option value="I">In-active</option>
						</select></td> 
					<td width="40"> MVMT </td> 
					<td width="99"><script language="javascript">ComComboObject('chss_mvmt_sts_cd', 1, 60, 0, 0, 1, true);</script>	
					</td>
						
					<td width="76">Type/Size</td>
					<td width="140"><script language="javascript">ComComboObject('eq_tpsz_cd', 1, 71,0);</script></td>
					<td width="75">Lease Term </td>
					<td width="103"><script language="javascript">ComComboObject('agmt_lstm_cd', 1, 71,0);</script></td>
					<td width="85">Staying Days</td>
					<td width="" class="stm"><input type="text"  dataformat="ymd"  style="width:70;text-align:right" class="input" value="" name='days'>&nbsp;or More</td>
				</tr>
			</table>
			
				<!--  biz_1  (E) -->
		</td></tr>
		</table>	
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">
				<!--  biz_2  (S)  -->
				
				
				<!-- Grid  (S) -->
			
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
			<!-- Grid (E) -->
				<!--  biz_2  (E)  -->
				<!--  Button_Sub (S) -->
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="100">Retrieved Row</td>
				<td width="120"><input type="text" style="width:70;text-align:right" class="input" readonly="readonly"name ="pngcnt"></td>
				<td width="70">Total Row</td>
				<td width="100"><input type="text" style="width:70;text-align:right" class="input" readonly="readonly"name ="ttl_knt"></td>
				
				<td align="right">
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_more">More</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					
					</tr></table>
			</td>
	    <!-- Button_Sub (E) -->
				
				
				
			</td></tr>
		</table>
				
		
			
		
						
				
		</td></tr>
		</table>	
			
			
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_master">Master</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_mvmt">MVMT</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>