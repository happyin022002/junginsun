<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESM_AGT_CHKCUST.jsp
*@FileTitle : Customer Name Retrieve (iFrame 및 IBSheet에서 사용)
*Open Issues : 
*Change history :
*@LastModifyDate : 2007-03-07
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-03-07 Hwang GyeongNam
* 1.0 최초 Insert
=========================================================*/
--%>

<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.CodeUtil"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.event.CommonEvent" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.event.CommonEventResponse" %>

<%
	String sheetId		= "";
	String row			= "";
	String colNm1		= "";
	String colNm2		= "";
	String cust_cd		= "";
	String cust_nm		= "";

	CommonEvent event = null;
	CommonEventResponse eventResponse = null;
	Exception serverException = null;
	String strErrMsg = "";							//error message
	HashMap rtnHash = null;
	
	try{
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if(serverException != null){
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			event = (CommonEvent)request.getAttribute("Event");
			eventResponse = (CommonEventResponse)request.getAttribute("EventResponse");

			if( event != null ) {
				sheetId  = JSPUtil.getNull(event.getString("sheetId"));
				row  = JSPUtil.getNull(event.getString("row"));
				colNm1  = JSPUtil.getNull(event.getString("colNm1"));
				colNm2  = JSPUtil.getNull(event.getString("colNm2"));
			}
			
			// 사용자가 Insert한 Customer의 Name을 구한다.
			if( eventResponse != null ) {
				rtnHash = eventResponse.getHashMap();
			}

			if(rtnHash != null) {			
				cust_cd = JSPUtil.getNull((String)rtnHash.get("cust_cd"));
				cust_nm = JSPUtil.getNull((String)rtnHash.get("cust_nm"));
			}
		}

	}catch(Exception e){
		out.println(e.toString());
	}
	
	if("".equals(sheetId)) { // IBSheet 에서 DoRowSearch로 Retrieve한 경우
%>
		<?xml version="1.0"  ?>
		<SHEET>
		  <DATA>
		    <TR ROW="<%=row%>" >
		    	<TD COL="<%= colNm1 %>"><%=cust_cd%></TD>
		    	<TD COL="<%= colNm2 %>"><![CDATA[<%=cust_nm%>]]></TD>
		    </TR>
		  </DATA>
		</SHEET>
<%
	} else {				// IBSheet 에서 iFrame을 이용해서 Retrieve한 경우
%>
		<script language="javascript">
			var sheetId = "<%=sheetId%>";
			var cust_cd = "<%=cust_cd%>";
			var cust_nm = "<%=cust_nm%>";
	
			if( sheetId != "" ) {
				var sheetObj = eval("parent.document." + sheetId );
				var row = <%=row%>;
				var colNm1 = "<%=colNm1%>";
				var colNm2 = "<%=colNm2%>";

				sheetObj.CellValue2(row, colNm1) = cust_cd;
				sheetObj.CellValue2(row, colNm2) = cust_nm;
			}
		</script>
<%
	}
%>
