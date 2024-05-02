<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0021.jsp
*@FileTitle :  Container Specification Creation &amp; Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.11 김석준
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
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.event.EesMst0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	// popflg 값 가져오기.
	String popflag = JSPUtil.getParameter(request ,"popflag".trim(),"");
	if(popflag == null){
		popflag = "";
	}
	
	// cntr_spec_no 값 가져오기.
	String cntr_spec_no = JSPUtil.getParameter(request ,"cntr_spec_no".trim(),"");
	if(cntr_spec_no == null){
		cntr_spec_no = "";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EesMst0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<%if(popflag == "") {%>
<title><span id="title"></span></title>
<%}else{ %>
<title>Container Specification</title>
<%} %>
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
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="popflag" value="<%=popflag%>">
<input type="hidden" name="code">
<input type="hidden" name="vndr_seq2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
 		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> 		
			<%if(popflag == "") {%>
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;Equipment Management > CNTR Master > Specification > Container Specification Creation</td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			<%}else{ %>
						<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"></td></tr>
						<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Container Specification</td></tr>
			<%} %> 
 		</table>
 	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		
		
		<!-- biz (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg" style="height:510;" valign="top">
		
			<!-- 1 (S)-->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">&nbsp;Spec No.</td>
					<td width=""><input type="text" name="cntr_spec_no" style="width:110" class="input2" value="<%=cntr_spec_no%>" readonly style="text-align:center"><%if(popflag == "") {%>&nbsp;<img src="img/btns_search.gif" name="btn_Popup" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"><%} %></td>
				</tr> 
			</table>
			<!-- 1 (E)-->
			<!-- 2 (S)-->			
			<table class="line_bluedot" style="width:979;"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="223">
						<table class="search_sm2" border="0" style="width:180;"> 
							<tr class="h23">
							<td width="35">Spec</td>
							<td class="stm"><input type="radio" name="own_cntr_flg" value="Y" class="trans" checked>&nbsp;OWN&nbsp;&nbsp;<input type="radio" name="own_cntr_flg" value="N" class="trans">&nbsp;Lease</td>
							</tr> 
						</table>
					</td>		
					<td width="30">Year</td>
					<td width="110"><input type="text" name="spec_yr" style="width:68" dataformat="engup" maxlength=4 class="input1" style="text-align:center"></td>
					<td width="30">TP/SZ</td>
					<td width="100" style="padding-left:2;ime-mode:disabled;"><script language="javascript">ComComboObject('combo1', 1, 45, 1);</script></td>
					<td width="30">Material</td>
					<td width="204"><select name="cntr_mtrl_cd" style="width:180;" class="input1">
					<option value=""></option>
					<option value="SS">SS - Stainless Steel</option>
					<option value="SU">SU - Steel (Unspecified)</option>
					<option value="AU">AU - Aluminum</option>
					</select></td>
					<td>
						<div id="div_dcond1" style="display:inline">
							<table class="search"><tr class="h23">
								<td>M/facturer</td>
								<td style="padding-left:2;"><script language="javascript">ComComboObject('mft_vndr_seq',2,153,0,1,1);</script></td>
							</tr></table>
						</div>
						<div id="div_dcond2" style="display:none">
							<table class="search"><tr class="h23">
							<td>Lessor</td>
							<td><input type="text" name="vndr_seq" dataformat="int" maxlength="6" style="width:70;text-align:center;ime-mode:disabled" class="input1" value="" readonly="true">&nbsp;<img name="btns_vndr" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup2">&nbsp;<input type="text" name="vndr_lgl_eng_nm" readonly style="width:200;ime-mode:disabled" class="input2" value=""></td>							
							</tr></table>
						</div>
					</td>
				</tr> 
			</table>
			<table class="line_bluedot" style="width:979;"><tr><td colspan="6"></td></tr></table>
			<!-- 2 (E)-->
				
			<!-- 3,4 frame (S)-->
			<table class="search" border="0" style="width:979;">
			
			 
			<tr class="h23">	
				<td width="482" valign="top" style="padding-right:20;">	
											
					<!-- 3 (S)-->
					<table width="100%" class="search_sm"> 
					<tr class="h23"><td class="title_s">Capacity</td></tr>
					<tr class="h23"><td>
					
						<!--table width="100%" class="search"-->
						<table border="0" style="width:100%; background-color:white;" class="grid2"> 
						<tr class="h23">
							<td width="110" class="tr2_head">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                 Capacity</td> 
							<td width="115"><input type="text" name="lod_capa"  <%if(popflag=="") {%> dataformat="float" <%} %> maxlength="8"  size="7"   pointcount="1"  style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> > CBM</td>
							<!--td width="50" class="sm">CBM</td-->
							<td width="105"><input type="text" name="lod_capa_cbf" style="width:77;text-align:right" class="input2" readonly>  CBF</td>
							<!--td width="" class="sm">CBF</td-->
						</tr>
						<tr class="h23">
							<td width="%" class="tr2_head">&nbsp;&nbsp;Gross Weight</td> 
							<td width="%"><input type="text" name="cntr_grs_wgt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=6 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> > KG</td>
							<!--td width="%" class="sm">KG</td-->
							<td width="%"><input type="text" name="cntr_grs_wgt_ibs" style="width:77;text-align:right" class="input2" readonly> LBS</td>
							<!--td width="%" class="sm">LBS</td-->
						</tr>
						<tr class="h23">
							<td width="%" class="tr2_head">&nbsp;&nbsp;Tare Weight</td> 
							<td width="%"><input type="text" name="tare_wgt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=6 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> > KG</td>
							<!-- td width="%" class="sm">KG</td-->
							<td width="%"><input type="text" name="tare_wgt_ibs" style="width:77;text-align:right" class="input2" readonly> LBS</td>
							<!--td width="%" class="sm">LBS</td-->
						</tr>
						<tr class="h23">
							<td width="%" class="tr2_head">&nbsp;&nbsp;Pay Load</td> 
							<td width="%"><input type="text" name="pay_load" style="width:77;text-align:right" class="input2" readonly> KG</td>
							<!-- td width="%" class="sm">KG</td-->
							<td width="%"><input type="text" name="pay_load_ibs" style="width:77;text-align:right" class="input2" readonly> LBS</td>
							<!--td width="%" class="sm">LBS</td-->
						</tr>
						</table> 
					</td></tr>
					</table>
					<!-- 3 (E)-->
					
				</td>
				<td valign="top">
				
					<!-- 4 (S) -->
					<table width="100%" class="search_sm">
					<tr class="h23"><td class="title_s">Dimension</td></tr>
					<tr class="h23"><td>
						<table border="0" style="width:100%; background-color:white;" class="grid2"> 
							<tr><td width="" class="tr2_head">Unit (mm)</td> 
							<td width="" class="tr2_head">Length</td>
							<td width="" class="tr2_head">Width</td>
							<td width="" class="tr2_head">Height</td>
						</tr>
						<tr class="">
							<td width="" class="tr2_head2">Internal</td> 
							<td width="" align="right"><input type="text" name="inter_len"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=5 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
							<td width="" align="right"><input type="text" name="inter_wdt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
							<td width="" align="right"><input type="text" name="inter_hgt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
						</tr>
						<tr class="">
							<td width="" class="tr2_head2">External</td> 
							<td width="" align="right"><input type="text" name="xter_len"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=5 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
							<td width="" align="right"><input type="text" name="xter_wdt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
							<td width="" align="right"><input type="text" name="xter_hgt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
						</tr>
						<tr class="">
							<td width="" class="tr2_head2">Open Door</td> 
							<td width="" class=""></td>
							<td width="" align="right"><input type="text" name="opn_dor_wdt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
							<td width="" align="right"><input type="text" name="opn_dor_hgt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=4 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
						</tr>
						</table> 
					</td></tr>
					</table>
					<!-- 4 (E) -->
					
				</td>
			</tr>
			</table>		
			<table class="height_8"><tr><td></td></tr></table>
			<!-- 3,4 frame (E)-->

			<!-- 5,6 frame (S)-->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">	
				<td width="482" valign="top" style="padding-right:20;">	
											
					<!-- 5 (S)-->
					<table width="100%" class="search_sm"> 
					<tr class="h23"><td style="height:86;" valign="top">
		
						<!-- title (S) -->
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Reefer Cargo Loadable</td></tr>
						<tr><td class="height_5"></td></tr>
						</table>
						<!-- title (E) -->
		
						<table width="100%" class="search"> 
						<tr class="h23">
							<td width="102">&nbsp;&nbsp;Capacity</td> 
							<td width="85"><input type="text" name="rc_ldb_capa"  <%if(popflag=="") {%> dataformat="float" <%} %> maxlength="8"  size="7"   pointcount="1" style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
							<td width="50" class="sm">CBM</td>
							<td width="85"><input type="text" name="rc_ldb_capa_cbf" style="width:77;text-align:right" class="input2" readonly></td>
							<td width="" class="sm">CBF</td>
						</tr>
						<tr class="h23">
							<td width="%">&nbsp;&nbsp;Height</td> 
							<td width="%"><input type="text" name="rc_ldb_hgt"  <%if(popflag=="") {%> dataformat="int" <%} %> maxlength=5 style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
							<td width="%" class="sm">mm</td>
						</tr>
						</table> 

					</td></tr>
					</table>
					<!-- 5 (E)-->
					
				</td>
				<td valign="top">
				
					<!-- 6 (S) -->
					<table width="100%" class="search_sm"> 
					<tr class="h23"><td style="height:86;" valign="top">
		
						<!-- title (S) -->
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Tank Capacity</td></tr>
						<tr><td class="height_5"></td></tr>
						</table>
						<!-- title (E) -->
		
						<table width="100%" class="search"> 
						<tr class="h23">
							<td width="102">&nbsp;&nbsp;Capacity</td> 
							<td width="85"><input type="text" name="tnk_capa"  <%if(popflag=="") {%> dataformat="float" <%} %> maxlength="8"  size="7"   pointcount="1" style="width:77;text-align:right" class="input" <%if(popflag!="") out.print("readonly"); %> ></td>
							<td width="50" class="sm">CBM</td>
							<td width="85"><input type="text" name="tnk_capa_cbf" style="width:77;text-align:right" class="input2" readonly></td>
							<td width="" class="sm">CBF</td>
						</tr>
						</table> 

					</td></tr>
					</table>
					<!-- 6 (E) -->
					
				</td>
			</tr>
			</table>		
			<table class="height_8"><tr><td></td></tr></table>
			<!-- 5,6 frame (E)-->
							
			</td>
		</tr> 
		</table>	
		<!-- biz (E) -->
<%
if(popflag != "") {				// 팝업으로 호출될 경우
%>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="">
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<%
}
else				// 메인으로 호출될 경우.
{
%>	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
	    <!--Button (E) -->
<%
}
%>
	<div id="hiddenLayer" style="display:none">
		<script language="javascript">ComSheetObject('sheet1');</script>
		<script language="javascript">ComSheetObject('sheet2');</script>  
	</div>				
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>