<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0045_Dtl.jsp
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :  
 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0045Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";

	String nItem			= "";
	int sheetNo = 0;
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.RegionDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (VopOpf0045Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//Parameters in case of Retrieving TDR
		nItem	= request.getParameter("nItem") == null ? "1" : request.getParameter("nItem");
		sheetNo = Integer.parseInt(nItem) + 1;
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>RDR Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
	function setupPage(){
		var objSheet = sheetObjects[0];		

		ComConfigSheet(objSheet);
		initSheet(objSheet, 7);
		//objSheet.SelectHighLight = false;
		//objSheet.SelectFontBold = true;
		ComEndConfigSheet(objSheet);
		
		var objSheet2 = sheetObjects[1];
		ComConfigSheet(objSheet2);
		initSheet(objSheet2, 8);
		//objSheet2.SelectHighLight = false;
		//objSheet2.SelectFontBold = true;
		ComEndConfigSheet(objSheet2);
		
		if(parent.bRetrive){
			parent.doActionIBSheet(objSheet, parent.document.form, IBSEARCH, "search07");
		}
		parent.iframeResize(true);
	}  
       function setSheetObject(sheet_obj){
          sheetObjects[sheetCnt++] = sheet_obj;
       }
</script>
</head>

<body  onLoad="setupPage();">

<!-- <div class="wrap_result">	
	<table class="search"> 
    <tr><td class="bg">
		
			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480" valign="top">
					
		
					Grid  (S)
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t7sheet1');</script>
						</td>
					</tr>
				</table>
					Grid (E)
					
					</td>
					<td width="19">&nbsp;&nbsp;&nbsp;</td>
					<td width="480" valign="top">
					
					
		
					Grid  (S)
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t7sheet2');</script>
						</td>
					</tr>
				</table>
					Grid (E)
					
					</td>
					</tr>
				</table>	
			
			</td></tr>
		</table>
		Tab BG Box(E)


Developer Performance  end
</div> -->
<div class="wrap_result">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width: 49%;">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid" id="mainTable">				
				<script language="javascript">ComSheetObject('t7sheet1');</script>
			</div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    <div class="layout_vertical_2" style="width:2%;">&nbsp;</div>
	    <div class="layout_vertical_2" style="width:49%;">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid" id="mainTable">				
				<script language="javascript">ComSheetObject('t7sheet2');</script>
			</div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
</div>
</body>
</html>
