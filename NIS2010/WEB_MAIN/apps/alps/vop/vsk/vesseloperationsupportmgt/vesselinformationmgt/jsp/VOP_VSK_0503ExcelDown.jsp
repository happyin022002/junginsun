<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0503ExcelDown.jsp
*@FileTitle : Vessel Information inquiry - Excel Download
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.12
*@LastModifier : 박다은
*@LastVersion : 1.0
* 2014.03.12 박다은
* 1.0 Creation
*
* 2014.04.16 박다은   [CHM-201429675-01] Voyage Performance내 Lane Code 구분
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
	String vsl_cd             	   = JSPUtil.replaceForHTML(request.getParameter("vsl_cd"));
	String vsl_slan_cd             = JSPUtil.replaceForHTML(request.getParameter("vsl_slan_cd"));     
	String pf_spd                  = JSPUtil.replaceForHTML(request.getParameter("pf_spd"));          
	String avg_slip                = JSPUtil.replaceForHTML(request.getParameter("avg_slip"));        
	String pf_net_spd              = JSPUtil.replaceForHTML(request.getParameter("pf_net_spd"));      
	String pf_foc_qty              = JSPUtil.replaceForHTML(request.getParameter("pf_foc_qty"));      
	String avg_act_foc_qty         = JSPUtil.replaceForHTML(request.getParameter("avg_act_foc_qty")); 
	String ctcl_rpm_no 			   = JSPUtil.replaceForHTML(request.getParameter("ctcl_rpm_no"));         
	String ctcl_to_rpm_no 		   = JSPUtil.replaceForHTML(request.getParameter("ctcl_to_rpm_no"));         
	String op_min_rpm_no           = JSPUtil.replaceForHTML(request.getParameter("op_min_rpm_no"));       
	String op_min_spd              = JSPUtil.replaceForHTML(request.getParameter("op_min_spd"));          
	String vsl_lod_rto             = JSPUtil.replaceForHTML(request.getParameter("vsl_lod_rto"));          
	String slw_stmng_flg           = JSPUtil.replaceForHTML(request.getParameter("slw_stmng_flg"));       
	String spr_slw_stmng_flg       = JSPUtil.replaceForHTML(request.getParameter("spr_slw_stmng_flg"));   
	String fuel_sav_eq_flg         = JSPUtil.replaceForHTML(request.getParameter("fuel_sav_eq_flg"));     
	String in_hld_per_tr_knt	   = JSPUtil.replaceForHTML(request.getParameter("in_hld_per_tr_knt"));   
	String in_hld_per_row_knt      = JSPUtil.replaceForHTML(request.getParameter("in_hld_per_row_knt"));   
	String htch_cvr_in_hld_knt     = JSPUtil.replaceForHTML(request.getParameter("htch_cvr_in_hld_knt")); 
	String on_deck_per_tr_knt      = JSPUtil.replaceForHTML(request.getParameter("on_deck_per_tr_knt"));  
	String on_deck_per_row_knt     = JSPUtil.replaceForHTML(request.getParameter("on_deck_per_row_knt")); 
	String bow_hgt                 = JSPUtil.replaceForHTML(request.getParameter("bow_hgt"));             
	String trsm_hgt				   = JSPUtil.replaceForHTML(request.getParameter("trsm_hgt"));            
	String shp_idx_scre            = JSPUtil.replaceForHTML(request.getParameter("shp_idx_scre"));    
	String amp_tp_cd	           = JSPUtil.replaceForHTML(request.getParameter("amp_tp_cd"));   

%>

<?xml version="1.0" ?>
<Excel>

	<IBSheetSet>
		<StartRow>20</StartRow>
		<ViewCols></ViewCols>
	</IBSheetSet>

    
	<Label>
      <Range Row1="2" Col1="1" Row2="2" Col2="18" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[Vessel Code : <%=vsl_cd%>]]></InputText>
      </Range>
      
      <Range Row1="4" Col1="1" Row2="4" Col2="18" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[<Operation>]]></InputText>
      </Range>     
      <Range Row1="5" Col1="1" Row2="5" Col2="2" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[1. Lane : <%=vsl_slan_cd%>]]></InputText>
      </Range>     
      <Range Row1="5" Col1="3" Row2="5" Col2="9" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[2. P/F Speed : <%=pf_spd%>]]></InputText>
      </Range>     
      <Range Row1="6" Col1="1" Row2="6" Col2="2" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[3. AVG Slip : <%=avg_slip%>]]></InputText>
      </Range>     
      <Range Row1="6" Col1="3" Row2="6" Col2="9" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[4. Net Speed : <%=pf_net_spd%>]]></InputText>
      </Range>     
      <Range Row1="7" Col1="1" Row2="7" Col2="2" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[5. FOC at P/F : <%=pf_foc_qty%>]]></InputText>
      </Range>     
      <Range Row1="7" Col1="3" Row2="7" Col2="9" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[6. AVG ACT FOC : <%=avg_act_foc_qty%>]]></InputText>
      </Range>    
      <Range Row1="9" Col1="1" Row2="9" Col2="18" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[<RPM& Slow Steaming>]]></InputText>
      </Range>
      <Range Row1="10" Col1="1" Row2="10" Col2="2" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[1. Critical RPM(Fm): <%=ctcl_rpm_no%>]]></InputText>
      </Range>     
      <Range Row1="10" Col1="3" Row2="10" Col2="4" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[2. Critical RPM(To): <%=ctcl_to_rpm_no%>]]></InputText>
      </Range>   
      <Range Row1="10" Col1="5" Row2="10" Col2="7" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[3. OPS MIN. RPM : <%=op_min_rpm_no%>]]></InputText>
      </Range>   
      <Range Row1="10" Col1="8" Row2="10" Col2="10" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[4. OPS MIN Speed : <%=op_min_spd%>]]></InputText>
      </Range>   
      <Range Row1="11" Col1="1" Row2="11" Col2="2" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[5. Slow Steaming : <%=slw_stmng_flg%>]]></InputText>
      </Range>     
      <Range Row1="11" Col1="3" Row2="11" Col2="4" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[6. Super Slow Steaming : <%=spr_slw_stmng_flg%>]]></InputText>
      </Range>   
      <Range Row1="11" Col1="5" Row2="11" Col2="7" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[7. Fuel Saving Equip : <%=fuel_sav_eq_flg%>]]></InputText>
      </Range>
      <Range Row1="11" Col1="8" Row2="11" Col2="10" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[8. Load(%) : <%=vsl_lod_rto%>]]></InputText>
      </Range>
      <Range Row1="13" Col1="1" Row2="13" Col2="18" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[<Design Max Load Hold/Deck>]]></InputText>
      </Range>      
      <Range Row1="14" Col1="1" Row2="14" Col2="2" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[1. In Hold by Tier : <%=in_hld_per_tr_knt%>]]></InputText>
      </Range>     
      <Range Row1="14" Col1="3" Row2="14" Col2="4" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[2. In Hold by Row : <%=in_hld_per_row_knt%>]]></InputText>
      </Range>   
      <Range Row1="14" Col1="5" Row2="14" Col2="6" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[3. H/C in Hold : <%=htch_cvr_in_hld_knt%>]]></InputText>
      </Range>
            <Range Row1="15" Col1="1" Row2="15" Col2="2" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[4. O/Deck by Tier : <%=on_deck_per_tr_knt%>]]></InputText>
      </Range>     
      <Range Row1="15" Col1="3" Row2="15" Col2="4" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[5. O/Deck by Row : <%=on_deck_per_row_knt%>]]></InputText>
      </Range>
      <Range Row1="17" Col1="1" Row2="17" Col2="18" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[<OPT trim>]]></InputText>
      </Range>
      <Range Row1="18" Col1="1" Row2="18" Col2="2" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[1. Bow : <%=bow_hgt%>]]></InputText>
      </Range>     
      <Range Row1="18" Col1="3" Row2="18" Col2="4" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[2. Tramsom : <%=trsm_hgt%>]]></InputText>
      </Range>   
      <Range Row1="18" Col1="5" Row2="18" Col2="6" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[3. ESI Score : <%=shp_idx_scre%>]]></InputText>
      </Range> 
      <Range Row1="18" Col1="7" Row2="18" Col2="8" RowHeight="15">
          <CellFormat>
              <Merge>true</Merge>
              <Alignment Horizantal="Left" Vertical="Center"/>
              <Interior BackColor="RGB(255,255,255)" Pattern="" />
              <Font Name="Arial" Bold="True" Size="10" Color="RGB(0,0,0)" />
          </CellFormat>
          <InputText><![CDATA[4. AMP Type : <%=amp_tp_cd%>]]></InputText>
      </Range>                   
	</Label>

</Excel>