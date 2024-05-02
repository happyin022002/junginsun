<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0050.jsp
*@FileTitle : Tariff Condition Registry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.04
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.04 이혜민
* 1.0 Creation
* 2013.04.04 yoo 수정
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.event.EsdTes0050Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}		
	
%>
<html>
<head>
<title>Tariff Condition Registry</title>
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
<body  onLoad="setupPage();" >
<form name="form">
<input type="hidden" name="f_cmd" alt="">
<input type="hidden" name="pagerows">
<input type="hidden" name="login_ofc_cd"	value="<%=strOfc_cd%>">
<table width="100%" border="1" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New2">New2</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
			</td>			
		</tr>
		</table>
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">Type </td>
					<td width="120">
						<select name="tml_awk_cgo_cond_tp_cd" id="tml_awk_cgo_cond_tp_cd" style="width:80">
							<option value="" selected>All</option>
							<option value="C">Common</option>
							<option value="B">Basic</option>
							<option value="T">T/S</option>
							<option value="A">AddOn</option>
							<option value="S">Shuttle</option>
						</select>
					</td>
					<td width="30">ID</td>
					<td width="120"><input onKeyDown="ComKeyEnter();" onclick="" name="cond_no" dataformat="num" type="text"  maxlength="10" style="width:80;text-align:center;" class="input1" value="">&nbsp;<img class="cursor" name="btn_Condition_Search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="20"></td>
					<td width="600"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr><td class="title_h"></td>
					<td width="" class="title_s">Object</td>
				</tr>
				</table>
				<div id="objBtnList" style="overflow-y:auto;" >
					<table class="search_sm2" border="0" width="100%" >
					<tr class="h23">
						<td width="60" rowspan="2" valign="top"></td>
					</tr>
					</table>	
				</div>				
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="979">
					<!-- grid ( S)-->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
					<!-- grid ( E)-->
					<table width="100%"> 
						<tr>
							<td width="100%">
								<div id="dspXpr" style="background-color:white;padding:4px 8px 4px 8px;"></div>
							</td>
						</tr>
					</table> 
					
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btng_Row_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btng_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btng_Cell_Add">Cell Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btng_Cell_Delete">Cell Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
				</td></tr>
				</table>
	    			<!-- Button_Sub (E) -->
					</td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="750">
					<div id="oprBtnList" style="overflow-y:auto;" >
						<table class="search_sm2" border="0" width="100%" >
						<tr class="h23">
							<td width="60" valign="top" rowspan="2">Operator</td>
							<td width="60" rowspan="2" valign="top"></td>
						</tr>
						</table>	
					</div>
					</td>
				</tr>
				</table>
				<!--  biz_2   (E) -->
				</td></tr>
			</table>
			<table class="height_10"><tr><td></td></tr></table>
			<table class="height_10"><tr><td></td></tr></table>
	<!--biz page (E)-->
	</td></tr>
</table>
<!-- Hidden sheet -->
<div id="hidden_sheet2" style="display:none;">
<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<div id="hidden_sheet3" style="display:none;">
<script language="javascript">ComSheetObject('sheet3');</script>
</div>
<div id="hidden_sheet3" style="display:none;">
<script language="javascript">ComSheetObject('sheet4');</script>
</div>
<div id="hidden_sheet3" style="display:none;">
<script language="javascript">ComSheetObject('sheet5');</script>
</div>
</form>
</body>
</html>