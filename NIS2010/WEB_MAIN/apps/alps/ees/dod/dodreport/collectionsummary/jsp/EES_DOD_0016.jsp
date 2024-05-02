<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EES_DOD_0016.jsp
*@FileTitle : DOD Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-14
*@LastModifier : Lee Young du
*@LastVersion : 1.0
* 2016-05-11 Hong Seong Pil
* 1.0 최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event.EesDod0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String loginOfcCd = "";
	String strRhq_ofc_cd	= "";
	String strUsr_ofc		= "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		loginOfcCd = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
		strUsr_ofc	= account.getOfc_cd();
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Collection Summary by Customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	var loginOfcCd = "<%=loginOfcCd%>";
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="from">
<input type="hidden" name="to">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="s_cust_gubun">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
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
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_save">New</td><td class="btn1_right"></td></tr></table></td>
								<td class="btn1_line"></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_detail" id="btn_detail">Detail</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->
			<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table width="100%" class="search" border="0">
		       	<tr>
		       		<td class="bg" width="100%">
		       			<table class="search_in" border="0" style="width:960;">
							<tr class="h23">
								<td width="80">TRO Date</td>
								<td width="142">
									<select style="width:140;" class="input1" name="period">
										<option value="D" selected>Date(YYYY-MM-DD)</option>
										<option value="M" >Month(YYYY-MM)</option>
										<option value="W">Week(YYYY-WW) </option>
									</select>
								</td>
								<td width="454">&nbsp;
									<input type="text" style="width:80;text-align:Center;" class="input1" value="" name="froms" caption="FM" required dataformat="ymd" maxlength="8">&nbsp;~&nbsp;
									<input type="text" style="width:80;text-align:Center;" class="input1" value="" name="tos" required dataformat="ymd" caption="TO" maxlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarto" >
								</td>
								
								<td width="152">Return Location</td>
								<td width=""><input type="text" name="rtn_loc_cd" dataformat="engnum" maxlength='5' style="width:80;text-align:Center" class="input"/></td>
								
								
                                
							</tr>
						</table>
						
						<table class="search_in" border="0" style="width:960;">
							<tr class="h23">
								<td width="82"><input type="radio" name="sch_flg" value="SC" class="trans">&nbsp;S/C No.</td>
								<td width="80"><input type="radio" name="sch_flg" value="RFA" class="trans" checked>&nbsp;RFA No.</td>
								<td width="193"><input type="text" name="sc_rfa_no"  dataformat="engnum" maxlength='20' style="width:98;text-align:Center" class="input1">&nbsp;<img src="img/btns_multisearch.gif" name="btns_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
								<td width="100">Contract Office</td>
								<td width="220"><input type="text" name="ctrt_ofc" dataformat="engup" maxlength='6' style="width:80;text-align:Center" class="input">&nbsp;<img src="img/btns_search.gif" name="btns_ctrt_ofc" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
								
								<td width="154">A/R I/F</td>
								<td width="" class="stm" style="font-size:12;">
            						<select style="width:100;" class="input" name="ar_if">
	            						<option value="A" selected>All</option>
	            						<option value="Y">Y</option>
	            						<option value="N">N</option>
            						</select>
                                </td>
							</tr>
						</table>
						
						<table class="search_in" border="0" style="width:960;"> 
							<tr class="h23">
								<td width="70">Customer</td>
								<td width="60"><input type="radio" name="cust_flg" value="CUST" class="trans" checked onclick="cust_click()">&nbsp;CUST</td>
								<td width="60"><input type="radio" name="cust_flg" value="BKG" class="trans" onclick="cust_click()">&nbsp;BKG</td>
								<td width=""><script language="javascript">ComComboObject('cust_type', 1, 80 , 1)</script> 
		                        &nbsp;<input type="text" name="cust_cd" dataformat="engnum" style="width:68;" class="input1">&nbsp;<img src="img/btns_search.gif" name="btns_customer" width="19" height="20" alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="text" name="cust_nm" readonly style="width:200;" class="input2"></td>

							    <td width="155">CNTR type</td>
            					<td width="" class="stm" style="font-size:12;">
            						<select style="width:100;" class="input" name="tpsz">
	            						<option value="A" selected>All</option>
	            						<option value="D">DRY</option>
	            						<option value="S">SPCL</option>
	            						<option value="R">Reefer</option>
            						</select>
                                </td>
                            </tr>  
                                
						</table>
						
						<table class="search_in" border="0" style="width:960;"> 
							<tr class="h23">
								<td width="70">DOD Office</td>
								<td width="60"><input type="radio" name="ofc_flg" value="R" class="trans" checked>&nbsp;RHQ</td>
								<td width="60"><input type="radio" name="ofc_flg" value="O" class="trans">&nbsp;Office</td>
								<td width="90"><script language="javascript">ComComboObject('office',1,80,0,0,0,true);</script></td>
								<td width="393" class="sm"><input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">Incl. Sub Office&nbsp;</td>
								
								<td width="50">Currency</td>
                                <td width="">
                                	<input type="radio" class="trans" checked name="curr_cd" value="USD"/>USD&nbsp;
                                	<input type="radio" class="trans" name="curr_cd" value="EUR"/>EUR&nbsp;
                                	<input type="radio" class="trans" name="curr_cd" value="LOC"/>Local&nbsp;
                                </td>
							</tr>
						</table>	

						
		       		</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->	
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid  (e) -->
		</td>
	</tr>
</table>


</form>
</body>
</html>