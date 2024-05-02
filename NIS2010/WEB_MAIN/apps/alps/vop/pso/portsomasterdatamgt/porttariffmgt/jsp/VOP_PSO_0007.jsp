<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0007.jsp
*@FileTitle : Formula & Condition Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.05 김진일
* 1.0 Creation
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
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String strBtnList = "";//json으로 말아 온다. 
	
	Logger log = Logger.getLogger("com.hanjin.apps.PortSOMasterDataMgt.PortTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		strBtnList = (String)eventResponse.getCustomData("BTNLIST");
		//if(firstList!=null)
		//	log.debug("firstList size :=" + firstList.size());

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Formula &amp; Condition Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var btnObjects = [];
	<%=strBtnList%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		//alert(btnObjects);
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();" onClick="setFocusIBsheet();" >
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_id" value="<%=strUsr_id %>" />
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
					<td width="20">ID</td>
					<td width="120"><input onKeyDown="ComKeyEnter();" onclick="setFlag('0');" name="txtid" dataformat="num" type="text"  maxlength="10" style="width:80;text-align:center;" class="input1" value="">&nbsp;<img class="cursor" name="btn_foml_cond" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="70"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_auto_id">AUTO ID</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
					<td width="">
						<table class="search_sm2" border="0" style="width:200;"> 
							<tr class="h23">
								<td><input onclick="setFlag('1');" name="radioflag" type="radio" value="1" class="trans" checked>Formula&nbsp;&nbsp;&nbsp;<input onclick="setFlag('2');" name="radioflag" type="radio" value="2" class="trans">Condition</td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>

				
				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr><td class="title_h"></td>
					<td width="" class="title_s">Formula</td>
					<td width="140" align="right">
						<table width="100%" border="0">
							<tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_Subject_Favorites">Subject Favorites</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<div id="btnList" style="overflow-y:auto;" >
					<table class="search_sm2" border="0" width="100%" >
					<tr class="h23">
						<td width="60" rowspan="2" valign="top">Subject </td>
						
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
								<div id="dspXpr" style="background-color:white;padding:4px 8px 4px 8px;" onclick="setFlag('0');"></div>
							</td>
						</tr>
					</table> 
					<!-- grid ( S) SYSTEM이 알수 있도록 데이터를 저장하고 있는 Hidden Sheet-->
					<input type="button" name="dscTbl" style="width:2px;height:2px" onclick="javascript:showDscTbl();" />
					<table width="100%"  id="sysDscTbl" style="display:none"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table> 
					<!-- grid ( E)-->
					
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
					<table class="search_sm2" border="0" width="979">
						<tr class="h23">
								<td width="60" valign="top" rowspan="2">Operator</td>
								<!-- * / + - [START] -->
								<td width="60"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<!-- td class="btn2" name="btn2_X">X</td-->	<!-- [2010.03.17:jmh] close -->
								<td class="btn2" name="btn2_*">X</td>	<!-- [2010.03.17:jmh] add -->
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_/">/</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_+">+</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_-">-</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_(">(</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_)">)</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td colspan = "11"></td>
								<!-- * / + - [END] -->
							</tr>
							<tr id="oprpanel" class="h23" style="display:none">
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_And">And</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_Or">Or</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<!-- IN [START] -->
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_IN">IN</td></td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="70"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_NOT IN">NOT IN</td></td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<!-- IN [END] -->
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_>">&gt;</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_>=">&gt;=</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_<"> &lt; </td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_<="> &lt;= </td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_="> = </td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_!="> != </td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="">&nbsp;</td>
						</tr>
						</table>
						<table id="consTbl" class="search_sm2" style="display:none" border="0" width="979">
							<tr class="h23">
								<td width="60" valign="top" rowspan="2">Constant</td>
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_Y">Y</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_N">N</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td colspan = "11"></td>
							</tr>
						</table>
						<table class="search_sm2" border="0" width="979">
							<tr class="h23">
								<td width="60" valign="top" rowspan="5">Function</td>
								<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_RoundUp">RoundUp</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_RoundDown">RoundDown</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_Round">Round</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_MAX">MAX</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="20" onClick="showAddFuncs(this);" style="cursor:hand;">▼</td>
								<td width="">&nbsp;</td>
							</tr>
						    <tr id="additonalFuncs" style="display:none" class="h23">
								<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_Other1">Other1</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_Other2">Other2</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_Other3">Other3</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_Other4">Other4</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="100"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_Other5">Other5</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="100"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_Other6">Other6</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td width="">&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_2   (E) -->
				
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	

	</td></tr>
</table>
</td></tr>
</table>


<textarea id="txtDebug" style="display:none;width:1024;height:300;"></textarea>
<!-- Copyright (S)
<table class="copy">
<tr><td class="familysite">&nbsp;
		<select name="sitelink" id="sitelink" class="select_family" onChange="javascript:go_sitelink(this);">
       	<option selected>&nbsp;&nbsp;  -- Family Site --  &nbsp;&nbsp;</option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
   		</select>
	</td>
	<td class="copy"><img src="img/img_bottom_logo.gif" width="460" height="16" alt="" border="0"></td></tr>
</table>
Copyright(E)-->
<!-- Hidden sheet -->
<script language="javascript">ComSheetObject('sheet3');</script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>