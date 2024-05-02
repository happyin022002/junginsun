<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0006GS.jsp
*@FileTitle : COP Detail Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-04
*@LastModifier : SeongMun_Kang
*@LastVersion : 1.0
* 2006-08-29 SeongMun_Kang
* 1.0 최초 생성  
* 2009-06-15 [SCE]An Jeong-Seon [Project# S1L-09U-003] Rail Export Cargo Available Return Time 개발
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page autoFlush="true" buffer="1kb" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.ESD_SCE_0006Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.ESD_SCE_0006EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%@ page import="com.hanjin.framework.core.layer.event.Event" %>
<%@ page import="com.hanjin.framework.core.layer.event.EventResponse" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copupdate.event.ESD_SCE_0006Event_U" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copupdate.event.ESD_SCE_0006EventResponse_U" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC" %>
<%
	Event                      e               = null;
    ESD_SCE_0006Event           event           = null;
    ESD_SCE_0006Event_U         eventU          = null;
    EventResponse              eResponse       = null;
    ESD_SCE_0006EventResponse   eventResponse   = null;
    ESD_SCE_0006EventResponse_U eventResponseU  = null;
    Exception                  serverException = null;
    DBRowSet                   rowSet          = null;
    RequestDataSetBC           dataSet         = null;
    String[]                   exptValues      = {""};
    String                     strErrMsg       = null;
    String                     result          = null;
    int                        rowCount        = 0; 
    int k = 1;
    
    String dueDt = "";
	//String appmnt = "";
	String obDrDate = "";
	String ibDrDate = "";
	String stsNm = "";
	
	// delivery Time 변수
	String dlvPlnDT  = null ;
	String dlvEstmDT = null ; 
	
	// Total Transit Time Info 변수
	String totTranPlnDT  = null ;
	String totTranEstmDT = null ;  
	
	// Rail Available Return Info 변수
	String railAvalRtnDT  = null ;

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            e         = (Event)request.getAttribute("Event") ;
            eResponse = (EventResponse)request.getAttribute("EventResponse") ;
            
			if(e.getEventName().equals("ESD_SCE_0006Event")){
			
				event = (ESD_SCE_0006Event)e ;
				eventResponse = (ESD_SCE_0006EventResponse)eResponse ;
				
				dueDt = eventResponse.getDueDt();
				obDrDate = eventResponse.getobDrDate();
				ibDrDate = eventResponse.getibDrDate();
				stsNm = eventResponse.getStsNm();

				dlvPlnDT  = eventResponse.getDlvPlnDT() ;
	        	dlvEstmDT = eventResponse.getDlvEstmDT() ; 
	        	
	        	totTranPlnDT  = eventResponse.getTotTranPlnDT() ;
	        	totTranEstmDT = eventResponse.getTotTranEstmDT() ;
	        	
	        	if (eventResponse != null) {
	                rowSet   = eventResponse.getRs();
	                rowCount = rowSet.getRowCount() ;
	                dataSet  = eventResponse.getDataSet() ;
	            }
			}
			else{
				eventU = (ESD_SCE_0006Event_U)e ;
				eventResponseU = (ESD_SCE_0006EventResponse_U)eResponse ;
				result = eventResponseU.getSuccessFlag().equals("SUCCESS")?"OK":"NO" ;
			}
			
            if (eventResponse != null) {
                rowSet   = eventResponse.getRs();
                rowCount = rowSet.getRowCount() ;
            }
        }
    }catch(Exception ex) {
        strErrMsg = ex.toString() ;
        out.println(ex.toString());
    }

%>
<%
    if (serverException == null) {
        FormCommand formcommand = e.getFormCommand();

        //화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
        //FormCommand가 다를 경우 조건문에 추가한다.
        //ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
        if( formcommand.isCommand(FormCommand.MODIFY)){
%>
<RESULT>
  <TR-ALL><%=result%></TR-ALL>
</RESULT>
<%
        }
        else{    //조회XML인 경우%>
<SHEET>
	<DATA TOTAL="<%=rowCount%>">
<%		if (rowSet != null) {
			try{
				// Transportation
				if(event.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
					while (rowSet.next()) {
						exptValues = JSPUtil.getNull(rowSet.getString("expt_info")).split("#") ;
						railAvalRtnDT = JSPUtil.getNull(rowSet.getString("rail_rcv_coff_fm_dt"));
%>
	 <tr>
	 	<td></td>
	 	<td></td>
	 	<td><![CDATA[<%=exptValues.length==3?exptValues[1].equals("O")?"02":"01":""%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("cop_grp_seq")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("cop_dtl_seq")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("act_cd")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("act_nm")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("vvd")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("nod_cd")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("pln_date")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("pln_time")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("estm_date")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("estm_time")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("act_date")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("act_time")%>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("act_rcv_tp_cd")%>]]></td>
	 	<td><![CDATA[<%=exptValues.length==3?exptValues[0]:""%>]]></td>
	 	<td><![CDATA[<%=exptValues.length==3?exptValues[2]:""%>]]></td>
	 </tr>
<%
                	}
				}
				// Documentation
				else if(event.getFormCommand().isCommand(FormCommand.SEARCHLIST02)){
					for(int i=0; i<dataSet.getParameterLength("act_nm"); i++) {
%>	<tr>
	 	<td></td>
	 	<td><![CDATA[<%=dataSet.getString("act_nm",i) %>]]></td>
	 	<td><![CDATA[<%=dataSet.getString("occ_date",i).equals("")?"0":"1" %>]]></td>
	 	<td><![CDATA[<%=dataSet.getString("occ_date",i)%>]]></td>
	 	<td><![CDATA[<%=dataSet.getString("occ_time",i)%>]]></td>
	 </tr>	
<%					}
				}
				
				else if(event.getFormCommand().isCommand(FormCommand.SEARCHLIST04)){
					while (rowSet.next()) {
%>
	<TR>
<%
						for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
%>
		<TD><![CDATA[<%=JSPUtil.getNull(rowSet.getString(k++))%>]]></TD>
<%
						}
						k = 1;
%>
	</TR>
<%
					}
				}
				// S/O Cost
				else if(event.getFormCommand().isCommand(FormCommand.SEARCHLIST03)){
					while (rowSet.next()) {
%>	<tr>
	 	<td></td>
	 	<td><![CDATA[<%=rowSet.getString("cost_act_grp_nm") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("ctrl_ofc_cd") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("vndr_abbr_nm") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("trsp_so_sts") %>]]></td>
	 	<td COLOR="BLUE"><![CDATA[<%=rowSet.getString("so_num") %>]]></td>
  	 	<td><![CDATA[<%=rowSet.getString("fm_to") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("so_dt") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("user_id") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("sp_h_no") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("so_rmk1") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("so_rmk2") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("so_rmk3") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("wo_no") %>]]></td>
	 	<td><![CDATA[<%=rowSet.getString("wo_dt") %>]]></td>
	 </tr>
<%					}
				}
			}catch(Exception ex) {out.println(ex) ;};
		}
%>
  </DATA>
<%
		if(event.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
%>
	<ETC-DATA>
		<ETC NAME="T1"><%=dueDt%></ETC> 
		<ETC NAME="T2"><%=obDrDate%></ETC> 
		<ETC NAME="T3"><%=ibDrDate%></ETC> 
		<ETC NAME="T4"><%=dlvPlnDT%></ETC> 
		<ETC NAME="T5"><%=dlvEstmDT%></ETC> 
		<ETC NAME="T6"><%=totTranPlnDT%></ETC> 
		<ETC NAME="T7"><%=totTranEstmDT%></ETC>  
		<ETC NAME="T8"><%=stsNm%></ETC>
		<ETC NAME="T9"><%=railAvalRtnDT%></ETC>
	</ETC-DATA>
<%
		}

%>  
  
  
</SHEET>
<%
        }
    } else {%>
<ERROR>
<MESSAGE> <![CDATA[ <%=strErrMsg%>]]> </MESSAGE>
</ERROR>
<%
    }
	
%>