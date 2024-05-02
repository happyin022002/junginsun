<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0072GS.jsp
*@FileTitle : EDI Performance Report
*Open Issues :
*Change history :
* 2008-03-28 sanghyun kim
* 1.0 최초 생성
*
* 2009-03-10 yjlee   : Performance 계산 Logic 변경 (N200902050103)
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
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0072Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.ESD_SCE_0072EventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>

<%
	ESD_SCE_0072Event event = null;
	ESD_SCE_0072EventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
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
	String cust_cd = ""; 
	
	try{
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event = (ESD_SCE_0072Event)request.getAttribute("Event");

            eventResponse = (ESD_SCE_0072EventResponse)request.getAttribute("EventResponse");
            
            if (eventResponse != null) {
            	rowSet = eventResponse.getRowSet();

                cs_grp_id = JSPUtil.getNull(eventResponse.getCs_grp_id());
                tp_id = JSPUtil.getNull(eventResponse.getTp_id());
                cs_desc = JSPUtil.getNull(eventResponse.getCs_desc());
                edi_sts = JSPUtil.getNull(eventResponse.getEdi_sts());
                cust_cd = JSPUtil.getNull(eventResponse.getCust_cd());
                
				if((rowSet != null) || (event.getFormCommand().isCommand(FormCommand.COMMAND02))){
                     cnt = eventResponse.getCnt();               
                } 
            }
        }
	} catch(Exception e) {
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
if((event.getFormCommand().isCommand(FormCommand.COMMAND01)) || (event.getFormCommand().isCommand(FormCommand.COMMAND02))){
%>
	<ETC-DATA>
		<ETC NAME="cs_grp_id"><![CDATA[<%=cs_grp_id%>]]></ETC>
		<ETC NAME="tp_id"><![CDATA[<%=tp_id%>]]></ETC>
		<ETC NAME="grp_nm"><![CDATA[<%=cs_desc%>]]></ETC>
		<ETC NAME="edi_sts"><![CDATA[<%=edi_sts%>]]></ETC>
		<ETC NAME="cust_cd"><![CDATA[<%=cust_cd%>]]></ETC>
		<ETC NAME="tp_id_cnt"><![CDATA[<%=cnt%>]]></ETC>
	</ETC-DATA>

<%
} else if(event.getFormCommand().isCommand(FormCommand.SEARCH03) || event.getFormCommand().isCommand(FormCommand.SEARCH04)){ 
%>	
	<ETC-DATA>
		<ETC NAME="edi_sts"><![CDATA[<%=edi_sts%>]]></ETC>
		<ETC NAME="cust_cd"><![CDATA[<%=cust_cd%>]]></ETC>
	</ETC-DATA>
<%
} else if(event.getFormCommand().isCommand(FormCommand.SEARCH02)){ 
	
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
			
			if(temp.equals("1")){
				temp = "~1 day";
			} else if(temp.equals("2")){
				temp = "1~2 days";
			} else if(temp.equals("3")){
				temp = "2~3 days";
			} else if(temp.equals("etc")){
				temp = "3 days ~";
			}
%>
			<TD><![CDATA[<%=temp%>]]></TD>
<%
		}
i = 1;
%>
	</TR>
	
	<TR>
<%
	double sum_temp = 0;

//N200902050103 : sum_temp1, sum_temp2, sum_temp_all 추가 
	double sum_temp1 = 0;
	double sum_temp2 = 0;
	double sum_temp_all = 0;
	int avg_cnt = 0;
	for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
		temp = JSPUtil.getNull(rowSet.getObject(i++)+"");
		double avg_temp = 0;
		String [] arr_temp = temp.split("/");
		String avg_temp_str = "";

		if(arr_temp.length == 2){ 
			String temp1 = arr_temp[0];
			String temp2 = arr_temp[1];	
    		avg_temp = JSPUtil.round(Double.parseDouble(temp1)* 100/Double.parseDouble(temp2),-2);
    		avg_temp_str = avg_temp+"%";
    		sum_temp = sum_temp+avg_temp;
//			N200902050103 : performance 계산을  과거  %의 평균에서 (누락 Count / 전체 Count) 로 Logic변경.		
			sum_temp1 = sum_temp1+JSPUtil.round((Double.parseDouble(temp1)),-5);
			sum_temp2 = sum_temp2+JSPUtil.round((Double.parseDouble(temp2)),-5);
		} else if((temp.equals("1")) || (temp.equals("2")) || (temp.equals("3")) || (temp.equals("etc")) ){
			avg_temp_str = "%";
			avg_cnt++;
		} else {
			avg_temp_str = "";
			avg_cnt++;
		}
%>
		<TD><![CDATA[<%=avg_temp_str%>]]></TD>
<%
	}
%>
	<td>
<%
	if((rowSet.getMetaData().getColumnCount() - avg_cnt ) != 0){
//		N200902050103 : performance 계산을  과거  %의 평균에서 (누락 Count / 전체 Count) 로 Logic변경.		
		sum_temp_all = JSPUtil.round((((sum_temp2-sum_temp1) / sum_temp2)* 100 ),-2);
	}
	i = 1;
%>					
		<![CDATA[<%=sum_temp_all+"%"%>]]>
	</td>

	</TR>
<%
	}
	
  }	
%>
</DATA>
<%

} else {
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
		for (int j = 0 ; j < rowSet.getMetaData().getColumnCount()+1 ; j++) {
        		if(j != rowSet.getMetaData().getColumnCount()){
        			temp = JSPUtil.getNull(rowSet.getObject(i++)+"");
%>
					<TD><![CDATA[<%=temp%>]]></TD>
<%					
				} else {
%>
					<td MERGE="TRUE"></td>
<%
				}
		}
        i = 1;
%>
</TR>
<TR>
<%
		double sum_temp = 0;
		double sum_temp1 = 0;
		double sum_temp2 = 0;
		double sum_temp_all = 0;

		int avg_cnt = 0;
		for (int j = 0 ; j < rowSet.getMetaData().getColumnCount() ; j++) {
        		temp = JSPUtil.getNull(rowSet.getObject(i++)+"");
        		double avg_temp = 0;
        		String [] arr_temp = temp.split("/");
        		String avg_temp_str = "";

        		if(arr_temp.length == 2){ 
        			String temp1 = arr_temp[0];
        			String temp2 = arr_temp[1];	
					avg_temp = JSPUtil.round((Double.parseDouble(temp2) - Double.parseDouble(temp1))* 100/Double.parseDouble(temp2),-2);
//					N200902050103 : performance 계산을  과거  %의 평균에서 (누락 Count / 전체 Count) 로 Logic변경.
					sum_temp1 = sum_temp1+JSPUtil.round((Double.parseDouble(temp1)),-5);
					sum_temp2 = sum_temp2+JSPUtil.round((Double.parseDouble(temp2)),-5);
					
					avg_temp_str = avg_temp+"%";
            		sum_temp = sum_temp+avg_temp;
        		} else if(temp.equals("Missing")){
        			avg_temp_str = "PFMC(%)";
        			avg_cnt++;
        		} else {
        			avg_temp_str = "";
        			avg_cnt++;
        		}
%>
				<TD><![CDATA[<%=avg_temp_str%>]]></TD>
<%
		}
		
%>
				<td MERGE="TRUE">
<%
				if((rowSet.getMetaData().getColumnCount() - avg_cnt ) != 0){
//					N200902050103 : performance 계산을  과거  %의 평균에서 (누락 Count / 전체 Count) 로 Logic변경.
					sum_temp_all = JSPUtil.round((((sum_temp2-sum_temp1) / sum_temp2)* 100 ),-2);

				}
%>					
					<![CDATA[<%=sum_temp_all+"%"%>]]>
				</td>
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
