<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0031GS.jsp
*@FileTitle : 상세운송계획 재생성 List 조회 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : Jongwon Park
*@LastVersion : 1.0
* 2006-08-25 Jongwon Park
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
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copreplan.event.ESD_SCE_0031Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copreplan.event.ESD_SCE_0031EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%

    ESD_SCE_0031EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;					//서버에서 발생한 에러
	DBRowSet rowSet = null;                           	//DB ResultSet
	
    String strErrMsg = "";                             	//에러메세지
    int rowCount     = 0;                              	//DB ResultSet 리스트의 건수

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (ESD_SCE_0031EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
   

				rowSet = eventResponse.getRs();
				if(rowSet != null){
					rowCount = rowSet.getRowCount();
				} // end if
            	
            } // end if
        } // end else

    }catch(Exception e) {
        out.println(e.toString());
    }

%>


<%
    if (serverException == null) {
%>
<SHEET>
	<DATA TOTAL="<%=rowCount%>">
<%		if (rowSet != null) {
			try{
				while (rowSet.next()) {
%>
	 <tr>
	 	<td></td>
	 	<td></td>
	 	<td><%=rowSet.getString("bkg_rcv_dt")%></td>
	 	<td><%=rowSet.getString("bkg_rcv_no")%></td>
	 	<td><%=rowSet.getString("cop_evnt_seq")%></td>
	 	<td><%=rowSet.getString("bkg_evnt_tp_cd")%></td>	 	
	 	<td><%=rowSet.getString("bkg_no")%></td>
	 	<td><%=rowSet.getString("bkg_no_split")%></td>
	 	<td><%=rowSet.getString("cntr_tpsz_cd")%></td>
	 	<td><%=rowSet.getString("cntr_no")%></td>
	 	<td><%=rowSet.getString("bkg_evnt_date")%></td>
	 	<td><%=rowSet.getString("bkg_evnt_time")%></td>
	 	<td><%=rowSet.getString("bkg_if_sts_cd")%></td>	 	
	 </tr>

<%					}
			}catch(Exception e) {out.println(e) ;};
		}
%>
  </DATA>
  
</SHEET>
<%
    } else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
	
%>

