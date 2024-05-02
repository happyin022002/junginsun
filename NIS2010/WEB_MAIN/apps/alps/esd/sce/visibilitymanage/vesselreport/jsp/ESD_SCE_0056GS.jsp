<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0056GS.jsp
*@FileTitle :  Vessel Report
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-23
*@LastModifier : Jeong-Seon An , Yoon-Jung Lee
*@LastVersion : 1.0
* 2007-07-23 Jeong-Seon An , Yoon-Jung Lee
* 1.0 최초 생성
* 2007-08-31 우선주석처리 JSPUtil.getNull(rowSet.getString(PKUP_NO))
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event.ESD_SCE_0056EventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>

<%
    ESD_SCE_0056EventResponse eventResponse   = null ;
	DBRowSet                 rowSet          = null ;
	Exception				 serverException = null ;
	String					 strErrMsg       = null ;
	int                      totalCount      = 0 ;

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ESD_SCE_0056EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet     = eventResponse.getRowSet();
				totalCount = eventResponse.getTotalCount();
			}
		}
	}catch(Exception e) {
		//serverException = e ;
		//strErrMsg = new ErrorHandler(e).loadPopupMessage() ;
		out.println(e.getMessage());
	}

	if (serverException == null) {
%> 

	   
<SHEET>
	<DATA TOTAL="<%=totalCount%>">
<%		while(rowSet!=null&&rowSet.next()){%>
		<TR>
			<TD></TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("BL_NO"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_NO")+rowSet.getString("BKG_NO_SPLIT"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("UMCH_FLG"))%>]]> </TD>
			<TD <% if(!rowSet.getString("BKG_POD_CD").equals(rowSet.getString("COP_POD"))){ %> COLOR="RED" <%} %>> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_POD_CD"))%>]]> </TD>
			<TD <% if(!rowSet.getString("BKG_DEL_CD").equals(rowSet.getString("COP_DEL"))){ %> COLOR="RED" <%} %>> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("BKG_DEL_CD"))%>]]> </TD>
			<TD <% if(!rowSet.getString("BKG_POD_CD").equals(rowSet.getString("COP_POD"))){ %> COLOR="RED" <%} %>> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_POD"))%>]]> </TD>
			<TD <% if(!rowSet.getString("BKG_DEL_CD").equals(rowSet.getString("COP_DEL"))){ %> COLOR="RED" <%} %>> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_DEL"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("CONTAINER"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TY_SZ"))%>]]> </TD>
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MVMT"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MTY_NTFD_DT"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP"))%>]]> </TD>						
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("DUP"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("ST_NODE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("ST_DATE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("VVD"))%>]]> </TD>					
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("LANE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("ETA"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("SPE"))%>]]> </TD>			
			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("POD"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("RAIL_DEST"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("IT_LOC"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("CSTMS_CLR_LOC"))%>]]> </TD>						
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("DEL"))%>]]> </TD>	
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("EQ_CTRL_OFC_CD"))%>]]> </TD>		
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TERM"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("RL"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("ADD_TRSP"))%>]]> </TD>	
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("RAIL_SO_PLN_FLG"))%>]]> </TD>	
							
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MN_RD_SO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MN_RD_FMTO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MN_RD_SO_DT"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MN_RD_WO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MN_RD_WO_DT"))%>]]> </TD>	
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MN_RD_VN_NM"))%>]]> </TD>	
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MX_RD_SO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MX_RD_FMTO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MX_RD_SO_DT"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MX_RD_WO"))%>]]> </TD>
						
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MX_RD_WO_DT"))%>]]> </TD>	
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MX_RD_VN_NM"))%>]]> </TD>	
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TD_SO_PLN_FLG"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TD_SO"))%>]]> </TD>					
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TD_FMTO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TD_SO_DT"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TD_WO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TD_WO_DT"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TS_SO_PLN_FLG"))%>]]> </TD>						
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TS_SO"))%>]]> </TD>	
					
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TS_FMTO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TS_SO_DT"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TS_WO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TS_WO_DT"))%>]]> </TD>
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TC_SO_PLN_FLG"))%>]]> </TD>				
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TC_SO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TC_FMTO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TC_SO_DT"))%>]]> </TD>						
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TC_WO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("TC_WO_DT"))%>]]> </TD>
				
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("WD_SO_PLN_FLG"))%>]]> </TD>						
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("WD_SO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("WD_FMTO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("WD_SO_DT"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("WD_WO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("WD_WO_DT"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("DR_WK"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("DR_FM"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("DR_TO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("DR_SP"))%>]]> </TD>	
					
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("DR_SP_NM"))%>]]> </TD>	
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("DR_SP_PHN_NO"))%>]]> </TD>	
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("COP_STATUS"))%>]]> </TD>					
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("ADD_TRANS"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("GUIDE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("PKUP_NODE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("AVL_DATE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("FREE_DATE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("F"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("O"))%>]]> </TD>		
				
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("C"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("ICR_CODE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("PKUP_NO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("PKUP_OFFICE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("PKUP_NOTICE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("PKUP_END"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("SC_NO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNEE_NM"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNEE_ADDR"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("CNEE_FAX_NO"))%>]]> </TD>
						
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("SHPR_NM"))%>]]> </TD>					
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("SHPR_ADDR"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("SHPR_FAX_NO"))%>]]> </TD>					
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("NTFY_NM"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("NTFY_ADDR"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("NTFY_FAX_NO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("BL_DT"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("FILER"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("IT_NO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("IT_DATE"))%>]]> </TD>	
					
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("PO_NO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("SEAL_NO"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("WEIGHT"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MN_CLM_STATUS"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MN_CLM_LOCATION"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MN_ST"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MN_CLM_DATE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MX_CLM_STATUS"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MX_CLM_LOCATION"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MX_ST"))%>]]> </TD>	
					
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("MX_CLM_DATE"))%>]]> </TD>			
			<TD> <![CDATA[<%=JSPUtil.getNull(rowSet.getString("REMARK"))%>]]> </TD>						
			
		</TR>
<%		}%>
	</DATA>
	
<%			if(totalCount>0){%>
	<ETC-DATA>
	    <ETC NAME="totcnt"><![CDATA[<%=totalCount%>]]></ETC>
	</ETC-DATA>
<%			}%>		
	
</SHEET>
<%	
	} else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
	}
	
%>