<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0004ExcelDown.jsp
*@FileTitle : P/F SKD Inquiry - Excel Download
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.02
*@LastModifier : 박다은
*@LastVersion : 1.0
* 2014.04.02 박다은
* 1.0 Creation
*
* History
* 2014.06.08 임예지 [CHM-201429996] P/F SKED Excel Down Format 변경 요청 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String	pf_vsl_cd	= JSPUtil.replaceForHTML(request.getParameter("pf_vsl_cd"));
	String	pf_duration	= JSPUtil.replaceForHTML(request.getParameter("pf_duration"));
	String	pf_vsl_clss	= JSPUtil.replaceForHTML(request.getParameter("pf_vsl_clss"));
	String	pf_skd_tp	= JSPUtil.replaceForHTML(request.getParameter("pf_skd_tp"));
	String	pf_upd_dt	= JSPUtil.replaceForHTML(request.getParameter("pf_upd_dt"));
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
    <ColumnWidth Col1="14" Col2="14">-1</ColumnWidth> 
    <ColumnWidth Col1="15" Col2="15">-1</ColumnWidth> 
    <ColumnWidth Col1="16" Col2="16">-1</ColumnWidth> 
    <ColumnWidth Col1="17" Col2="17">-1</ColumnWidth> 
    <ColumnWidth Col1="18" Col2="18">-1</ColumnWidth> 
    
	<Label>
      <Range Row1="1" Col1="1" Row2="1" Col2="19" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="15" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[Lane Code : <%=pf_vsl_cd%>]]></InputText>
      </Range>
      
      <Range Row1="2" Col1="1" Row2="2" Col2="19" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText></InputText>
      </Range>      
      
      <Range Row1="3" Col1="1" Row2="3" Col2="19" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[1. DURATION : <%=pf_duration%>]]></InputText>
      </Range>     
      <Range Row1="4" Col1="1" Row2="4" Col2="19" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[2. VSL Class : <%=pf_vsl_clss%>]]></InputText>
      </Range>     
      <Range Row1="5" Col1="1" Row2="5" Col2="17" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[3. P/F SKD Type : <%=pf_skd_tp%>]]></InputText>
      </Range>     
      <Range Row1="5" Col1="18" Row2="5" Col2="19" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[<%=pf_upd_dt%>]]></InputText>
      </Range>       
	</Label>


</Excel>