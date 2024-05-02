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
<%@ page import="com.clt.framework.component.util.StringUtil" %>
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
<script language="javascript">
    
	function setupPage(){
		sheetNm = "t<%=sheetNo%>sheet1";
		var parentTabIdx = <%=StringUtil.xssFilter(nItem)%>;
		var parentTabName = parent.marrTabTitle[<%=StringUtil.xssFilter(nItem)%>];
//		var objSheet = .document.all.item(sheetNm);		
		var objSheet = eval(sheetNm);		

		ComConfigSheet(objSheet);
		initSheet(objSheet, <%=sheetNo%>);
		ComEndConfigSheet(objSheet);
		//objSheet.SelectHighLight = false;
		//objSheet.SelectFontBold = true;
		
		if(parent.bRetrive){
			parent.doActionIBSheet(objSheet, parent.document.form, IBSEARCH, "search<%= sheetNo < 10 ? "0" + sheetNo : Integer.toString(sheetNo) %>");
		}
		parent.iframeResize(true);
	}
       function setSheetObject(sheet_obj){
          sheetObjects[sheetCnt++] = sheet_obj;
       }
</script>

	<div class="wrap_result">	
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('t<%=sheetNo%>sheet1');</script>
		</div>
	</div>		