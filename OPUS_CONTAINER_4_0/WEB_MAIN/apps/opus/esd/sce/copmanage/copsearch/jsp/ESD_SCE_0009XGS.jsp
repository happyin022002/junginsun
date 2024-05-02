<%--=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0009XGS.jsp
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-08-29 SeongMun_Kang
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0009Event" %>
<%@ page import="com.clt.framework.support.controller.html.FormCommand" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.clt.framework.core.layer.event.Event" %>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%
	EsdSce0009Event event  = null;
	GeneralEventResponse eventResponse = null;			
	Exception serverException = null;               //서버에서 발생한 에러
	String[][] rowSet2 = null;
	String strErrMsg = "";                          //에러메세지
	int rowCount2 = 0;	

	String maxCnt = "0";
	String ioBndCd = "O";


    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event = (EsdSce0009Event)request.getAttribute("Event");
        	
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			HashMap<String, String> mapVO = (HashMap)eventResponse.getETCData();
			
			maxCnt = mapVO.get("max_cnt");
			ioBndCd =  mapVO.get("io_bnd_Cd");

			if (eventResponse != null) {
				rowSet2= (String[][])eventResponse.getCustomData("list");
				
				if(rowSet2 != null){
					rowCount2 = rowSet2.length;
				}
			} // end if
            
        } // end else
    }catch(Exception ex) {
        out.println(ex.toString());
    }
%>
<%
	if (serverException == null) {
		FormCommand formcommand = event.getFormCommand();
		//화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
		//FormCommand가 다를 경우 조건문에 추가한다.
		//ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
		if( formcommand.isCommand(FormCommand.MULTI) || 
			formcommand.isCommand(FormCommand.ADD) || 
			formcommand.isCommand(FormCommand.MODIFY) || 
			formcommand.isCommand(FormCommand.REMOVE) || 
			formcommand.isCommand(FormCommand.REMOVELIST) ){	//저장XML인 경우
%>
<RESULT>
  <TR-ALL>OK</TR-ALL>
</RESULT>
<%		} else {	//조회XML인 경우     %>
<SHEET>
  <ETC-DATA>
   <ETC KEY="maxCnt"><%=maxCnt%></ETC>      
  </ETC-DATA>  
  <DATA TOTAL="<%=rowCount2%>">
<%			if (rowSet2 != null) {
				for(int m=0; m < rowSet2.length; m++) {     %>
	<TR>
		<TD></TD>
<%					for (int n = 0 ; n < rowSet2[m].length ; n++) {     %>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet2[m][n])%>]]></TD>			
<%					}     %>
		<TD><%=ioBndCd%></TD>
	</TR>
<%				}
			}     %>
  </DATA>
</SHEET>
<%		}
	} else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%	}     %>