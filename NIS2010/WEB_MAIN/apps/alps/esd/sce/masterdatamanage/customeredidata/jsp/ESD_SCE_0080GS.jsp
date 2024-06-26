<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0080GS.jsp
*@FileTitle : Vessel Estimation Accunt
*Open Issues :
*@LastVersion : 1.0
* 2008-04-07 kim sang hyun
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0080Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0080EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%
	ESD_SCE_0080Event event = null;
	ESD_SCE_0080EventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null;                     //서버에서 발생한 에러
	DBRowSet rowSet = null;                               //DB ResultSet
	String strErrMsg = "";                                //에러메세지
	//int rowCount     = 0;                                 //DB ResultSet 리스트의 건수
	//String tabno = "1";
	int cnt = 0;
	
	String cs_grp_id = "";
	String tp_id = "";
	String cs_desc = "";
	String edi_sts = "";
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event = (ESD_SCE_0080Event)request.getAttribute("Event");
			eventResponse = (ESD_SCE_0080EventResponse)request.getAttribute("EventResponse");
            
			if (eventResponse != null) {

                rowSet = eventResponse.getRowSet();

                cs_grp_id = JSPUtil.getNull(eventResponse.getCs_grp_id());
                tp_id = JSPUtil.getNull(eventResponse.getTp_id());
                cs_desc = JSPUtil.getNull(eventResponse.getCs_desc());
                edi_sts = JSPUtil.getNull(eventResponse.getEdi_sts());
                
				if((rowSet != null) || (event.getFormCommand().isCommand(FormCommand.COMMAND03))){
                     cnt = eventResponse.getCnt();               
                } // end if
            } // end if
        }
	}catch(Exception e) {
        out.println(e.toString());
    }
%>
<%
if (serverException == null) {
        
        //화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
        //FormCommand가 다를 경우 조건문에 추가한다.
        //ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
%>
<SHEET>
<%
	if((event.getFormCommand().isCommand(FormCommand.SEARCH02)) || (event.getFormCommand().isCommand(FormCommand.COMMAND02)) || (event.getFormCommand().isCommand(FormCommand.COMMAND03))){
	%>
	<ETC-DATA>
		<ETC NAME="cs_grp_id"><![CDATA[<%=cs_grp_id%>]]></ETC>
		<ETC NAME="tp_id"><![CDATA[<%=tp_id%>]]></ETC>
		<ETC NAME="grp_nm"><![CDATA[<%=cs_desc%>]]></ETC>
		<ETC NAME="edi_sts"><![CDATA[<%=edi_sts%>]]></ETC>
		<ETC NAME="tp_id_cnt"><![CDATA[<%=cnt%>]]></ETC>
	</ETC-DATA>
<%
}else{
%>
<DATA TOTAL="<%=cnt%>">
<%
String temp = "";
int i =1;
if (rowSet != null) {
	while (rowSet.next()){
%>
		<TR>
<%
		for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
        		temp = JSPUtil.getNull(rowSet.getObject(i++)+"");
%>
				<TD><![CDATA[<%=temp%>]]></TD>
<%
        	
		}
        i = 1;
%>
</TR>
<%
	}
}
            
%>
  </DATA>
<%
		}

%>  
</SHEET>
<%
} else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
%>