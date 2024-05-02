<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.common.prdcommon.event.PrdCommonEvent"%>
<%@ page import="com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.event.ESD_PRD_0004Event"%>
<%@ page import="com.clt.apps.opus.esd.prd.common.prdcommon.event.PrdCommonEvent"%>
<%@ page import="com.clt.apps.opus.esd.prd.common.prdcommon.event.PrdCommonEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.framework.core.layer.event.Event"%>
<%
	ESD_PRD_0004Event event004 = null;
	PrdCommonEvent eventCommon = null;
	PrdCommonEventResponse eventResponse = null;
	Exception serverException = null;
	DBRowSet rowSet = null;
	String strErrMsg = "";
	int rowCount = 0;
	FormCommand formcommand = new FormCommand();
	String eventName = "";
	String comData1 = "";
	String comData2 = "";
	boolean isDoor = false;
	try {
		eventName = ((Event) request.getAttribute("Event")).getEventName();
		if (eventName.equals("ESD_PRD_0004Event")) {
			event004 = (ESD_PRD_0004Event) request.getAttribute("Event");
		}
		if (eventName.equals("PrdCommonEvent")) {
			eventCommon = (PrdCommonEvent) request.getAttribute("Event");
		}
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			comData1 = "";
			comData2 = "";
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			eventResponse = (PrdCommonEventResponse) request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if (rowSet != null) {
					rowCount = rowSet.getRowCount();
					if (eventName.equals("PrdCommonEvent")) {
						if (eventCommon != null) {
							formcommand = eventCommon.getFormCommand();
							if (formcommand.isCommand(FormCommand.COMMAND07)) {
								while (rowSet.next()) {
									comData1 = JSPUtil.getNull(rowSet.getString("vsl_slan_nm"));
								}
							} else if (formcommand.isCommand(FormCommand.COMMAND04)) {
								isDoor = eventResponse.isDoor();
								while (rowSet.next()) {
									comData1 = JSPUtil.getNull(rowSet.getString("nod_nm"));
									comData2 = JSPUtil.getNull(rowSet.getString("loc_cd"));
								}
							} else if (formcommand.isCommand(FormCommand.COMMAND08)) {
								while (rowSet.next()) {
									comData1 = JSPUtil.getNull(rowSet.getString("comData1")); //VNDR_ABBR_NM
									comData2 = JSPUtil.getNull(rowSet.getString("comData2")); //vndr_lgl_eng_nm
								}
							}
						}
					}
				}
			}
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
	if (serverException == null) {
		if (eventName.equals("PrdCommonEvent")) {
			if (eventCommon != null) {
				formcommand = eventCommon.getFormCommand();
			}
		}
%>
<?xml version="1.0"  ?>
<SHEET>
	<DATA></DATA>
	<ETC-DATA>
     	<ETC KEY="rowCount"><![CDATA[<%=rowCount%>]]></ETC>
     	<ETC KEY="comData1"><![CDATA[<%=comData1%>]]></ETC>
     	<ETC KEY="comData2"><![CDATA[<%=comData2%>]]></ETC>
     	<ETC KEY="isDoor"><![CDATA[<%=isDoor%>]]></ETC>
	</ETC-DATA> 
</SHEET>
<%
	}	else {
%>
<ERROR>
	<ETC-DATA>
     	<ETC KEY="rowCount"><![CDATA[<%=rowCount%>]]></ETC>
     	<ETC KEY="comData1"><![CDATA[<%=comData1%>]]></ETC>
     	<ETC KEY="comData2"><![CDATA[<%=comData2%>]]></ETC>     	
     	<ETC KEY="isDoor"><![CDATA[<%=isDoor%>]]></ETC>     	
	</ETC-DATA> 
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
%>
