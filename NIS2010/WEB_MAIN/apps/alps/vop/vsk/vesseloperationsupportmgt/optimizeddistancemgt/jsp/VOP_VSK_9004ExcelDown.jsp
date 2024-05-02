<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VOP_VSK_0515ExcelDown.jsp
*@FileTitle : Port to Port distance - VMS Short  - Excel Download
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : 임예지
*@LastVersion : 1.0
* 2015.03.25 임예지
* 1.0 Creation
*
* History
* 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String VslCd = (request.getParameter("vsl_cd") == null)? "": request.getParameter("vsl_cd");	
	String SkdVoyNo = (request.getParameter("skd_voy_no") == null)? "": request.getParameter("skd_voy_no");	
	String SkdDirCd = (request.getParameter("skd_dir_cd") == null)? "": request.getParameter("skd_dir_cd");	
	String PasgPlnDt = (request.getParameter("pasg_pln_dt") == null)? "": request.getParameter("pasg_pln_dt");	
	String DepPortCd = (request.getParameter("dep_port_cd") == null)? "": request.getParameter("dep_port_cd");	
	String ArrPortCd = (request.getParameter("arr_port_cd") == null)? "": request.getParameter("arr_port_cd");
	String VpsEtaDt = (request.getParameter("vps_eta_dt") == null)? "": request.getParameter("vps_eta_dt");	

%>
 
<?xml version="1.0" ?> 
<Excel>

	<IBSheetSet>
		<StartRow>6</StartRow>
		<ViewCols></ViewCols>
	</IBSheetSet>

    <ColumnWidth Col1="1" Col2="1">-1</ColumnWidth> 
    <ColumnWidth Col1="2" Col2="2">-1</ColumnWidth> 
    <ColumnWidth Col1="3" Col2="3">-1</ColumnWidth> 
    <ColumnWidth Col1="4" Col2="4">-1</ColumnWidth> 
    <ColumnWidth Col1="5" Col2="5">-1</ColumnWidth> 
    <ColumnWidth Col1="6" Col2="6">-1</ColumnWidth> 
    <ColumnWidth Col1="7" Col2="7">-1</ColumnWidth> 
    <ColumnWidth Col1="8" Col2="8">-1</ColumnWidth> 
    <ColumnWidth Col1="9" Col2="9">-1</ColumnWidth> 
    <ColumnWidth Col1="10" Col2="10">-1</ColumnWidth> 
    <ColumnWidth Col1="11" Col2="11">-1</ColumnWidth> 
    <ColumnWidth Col1="12" Col2="12">-1</ColumnWidth> 
    <ColumnWidth Col1="13" Col2="13">-1</ColumnWidth> 

    
	<Label>
      <Range Row1="1" Col1="1" Row2="1" Col2="13" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Center" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="15" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[Distance Table (Detail)]]></InputText>
      </Range>
      
      <Range Row1="2" Col1="1" Row2="2" Col2="13" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText></InputText>
      </Range>      
      
      <Range Row1="3" Col1="1" Row2="3" Col2="4" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[Vessel Code : <%=VslCd%>]]></InputText>
      </Range>
      <Range Row1="3" Col1="5" Row2="3" Col2="9" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[Voyage : <%=SkdVoyNo%><%=SkdDirCd%>]]></InputText>
      </Range>
      <Range Row1="3" Col1="10" Row2="3" Col2="13" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[Port : <%=DepPortCd%> ~ <%=ArrPortCd%>]]></InputText>
      </Range> 
      
      <Range Row1="4" Col1="1" Row2="4" Col2="4" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[Plan Date : <%=PasgPlnDt%>]]></InputText>
      </Range>  
      <Range Row1="4" Col1="5" Row2="4" Col2="13" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[ETA Time : <%=VpsEtaDt%>]]></InputText>
      </Range>  
              
      <Range Row1="5" Col1="1" Row2="5" Col2="13" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText></InputText>
      </Range>   
	</Label>


</Excel>