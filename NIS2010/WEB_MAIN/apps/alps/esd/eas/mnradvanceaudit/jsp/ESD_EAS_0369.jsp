<%--
/*=========================================================
*Copyright(c) 2016 CyberLogitec 
*@FileName : ESD_EAS_0369.jsp
*@FileTitle : Futile Trip Container
*Open Issues :
*Change history :
*@LastModifyDate : 2016-03-29
*@LastModifier : Seong-pill Hong
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History 

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0369Event"%>
<%
String usrEmail = "";
try {
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	usrEmail = account.getUsr_eml();
}catch(Exception e) {
	out.println(e.toString());
}
%>
<html>
<head>
<title>Futile Trip Container</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("cntr_tpsz_cd", "01", "CD01860", 0, "")%>

	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="backendjob_key" />
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_save">New</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_mailretrieve" id="btn_mailretrieve">Mail Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
						</tr></table>
				</td></tr>
			</table>

			<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table width="100%" class="search" border="0">
		       	<tr>
		       		<td class="bg">
						<!-- : ( Week ) (S) -->
							<!-- [1]--------------------------------------------------------- -->
						<table width="100%" class="search_in" border="0">
							<tr class="h23">
								<td width="80">Period</td>
								<td width="240" colspan="3">
									<input type="hidden" name="fdate" value="" dataformat="ymd" maxlength="10">
									<input type="hidden" name="tdate" value="" dataformat="ymd" maxlength="10">
									<input type="text" style="width:80; text-align:Center" name="fdate_tmp" value="" dataformat="ymd" maxlength="10" class="input1">
									<img name="btn_start_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
									&nbsp;~&nbsp;
									<input type="text" style="width:80; text-align:Center" name="tdate_tmp" value="" dataformat="ymd" maxlength="10" class="input1">
									<img name="btn_end_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
								<td width="95">Location/Yard</td>
								<td>
									<input type="text" style="width:50;" class="input1" value="" name="loc_cd" dataformat="uppernum" maxlength="5">
									<input type="text" style="width:30;" class="input1" value="" name="yd_cd" dataformat="uppernum" maxlength="2">
									<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_loc_cd">
								</td>
								<td width="80">CNTR No.</td>
								<td>
									<input id="cntr_no" name="cntr_no" type="text" style="width:200px" class="input" dataformat="uppernum" value="" >&nbsp;
									<img src="img/btns_multisearch.gif" name="cntr_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
							</tr>								
							<tr class="h23">
								<td>Type / Size</td>
								<td style="padding-left:2"><script language="javascript">ComComboObject('cntr_tpsz_cd',1,60,0,0);</script></td>
								<td>Cargo Type</td>
								<td>
									<select id="fcntr_flg" name="fcntr_flg" style="width:70;">
										<option value="" selected></option>
										<option value="Y">FULL</value>
										<option value="N">EMPTY</value>
									</select>
								</td>
								<td>CNTR MVMT</td>
								<td style="padding-left:2">
									<input type="hidden" name="mvmt_sts_cd" value=""/>
									<input type="text" name="mvmt_sts_cd1" style="width:40px" class="input1" value="" dataformat="uppernum" maxlength="2"/>
									<input type="text" name="mvmt_sts_cd2" style="width:40px" class="input1" value="" dataformat="uppernum" maxlength="2"/>
									<input type="text" name="mvmt_sts_cd3" style="width:40px" class="input1" value="" dataformat="uppernum" maxlength="2"/>
									<input type="text" name="mvmt_sts_cd4" style="width:40px" class="input1" value="" dataformat="uppernum" maxlength="2"/>
									<input type="text" name="mvmt_sts_cd5" style="width:40px" class="input1" value="" dataformat="uppernum" maxlength="2"/>
								</td>
								<td>EMAIL</td>
								<td><input type="text" name="eml_snd_addr" style="width:200px" class="input" value="<%=usrEmail%>"/></td>
							</tr>
						</table>
						<!-- : ( Week ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>
			<!-- TABLE '#D' : ( Grid ) (S) -->
	     	<table class="search">
	       		<tr><td class="bg">
					<!-- <table class="height_10"><tr><td></td></tr></table> -->
					<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
					</table>
					<!-- : ( POR ) (E) -->
					<!-- : ( Button : Grid ) (S) -->
					<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr class="h23">
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_cntr_inquiry" id="btn_cntr_inquiry">CNTR Inquiry</td>
								<td class="btn2_right"></td></tr></table></td>
								
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_repair" id="btn_repair">Repair</td>
								<td class="btn2_right"></td></tr></table></td>
								
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_service_order" id="btn_service_order">Service Order</td>
								<td class="btn2_right"></td></tr></table></td>
								
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_bkg_inquiry" id="btn_bkg_inquiry">BKG Inquiry</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

								</tr>
							</table>
						</td></tr>
					</table>
			    	<!-- : ( Button : Grid ) (E) -->
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<table width="100%" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table> 
<!-- Outer Table (E)-->

</form>
</body>
</html>