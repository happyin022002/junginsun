<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0082.jsp
*@FileTitle : Product Catalog 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.09.28 정선용
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
<%@ page import="com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0082Event"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdPrd0082Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
 
	String xml = null;   
 
	//Logger log = Logger.getLogger("com.hanjin.apps.ProductCatalogManage.ProductCatalogManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdPrd0082Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
 
		DefaultViewAdapter adapter = new DefaultViewAdapter();   
		xml = adapter.makeXML(request, response); 
 
 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Product Catalog - Constraints</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cnst_cd", "01", "CD01386", 0, "")%>

    function setupPage(){  
	    loadPage();
    }
</script>
<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="sXml" value="<%=xml%>">  
<input type="hidden" name="f_cmd" >
<input type="hidden" name="pctl_no" value="<%=JSPUtil.getParameter(request, "pctl_no") %>">
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no") %>">

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0">
				<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Product Catalog - Constraints</td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<div id="node_hd_div" style="display=none; z-index:1" style="height:15px; width:100%">
		<table class="search" border="0" >
			<tr class="h23"><td width="250">* Location/Node *</td></tr>
		</table>
		</div> 
		<div id="node_div" style="display=block; z-index:1" style="height:93px; width:100%">
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				</td> 
			</tr>
		</table>
		</div>

		<div id="link_hd_div" style="display=none; z-index:1" style="height:15px; width:100%">
		<table class="search" border="0" style="width:700;">
			<tr class="h23"><td width="250">* Link *</td></tr>
		</table> 
		</div> 
		<div id="link_div" style="display=block; z-index:1" style="height:93px; width:100%">
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table> 
				</td>			
			</tr>
		</table>
		</div>

		<div id="route_hd_div" style="display=none; z-index:1" style="height:15px; width:100%">
		<table class="search" border="0" style="width:700;">
			<tr class="h23"><td width="250">* Route *</td></tr>
		</table> 
		</div> 
		<div id="route_div" style="display=block; z-index:1" style="height:93px; width:100%">
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table> 
				</td>			
			</tr>
		</table>
		</div>

		<div id="inland_hd_div" style="display=none; z-index:1" style="height:15px; width:100%">
		<table class="search" border="0" style="width:700;">
			<tr class="h23"><td width="250">* Inland Route POL/POD *</td></tr>
		</table> 
		</div> 
		<div id="inland_div" style="display=block; z-index:1" style="height:93px; width:100%">
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
					</table> 
				</td>
			</tr>
		</table>
		</div>
		<div id="canada_hd_div" style="display=none; z-index:1" style="height:15px; width:100%">
		<table class="title" border="0" style="width:700;">
			<tr class="h23"><td width="100%">* D7 CNTR booking for Canada is allowed only for CAVAN port/local cargo.</td></tr>
		</table> 
		</div> 		
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
				</table>
				</td></tr>
			</table>
		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->


</form>			
</body>
</html>
