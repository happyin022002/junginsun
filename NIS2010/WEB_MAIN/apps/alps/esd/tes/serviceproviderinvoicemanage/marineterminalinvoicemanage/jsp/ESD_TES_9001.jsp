<%
/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : ESD_TES_9001.jsp
 *@FileTitle : Node 조회(공통 Popup)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0  
 *2014-06-19 : 박재흥 [CHM-201429999] TES: Cost Code SVXXHC Vol 계산시 TOR data참조 logic
 =========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="java.util.*" %>
<%
    String yd_cd = JSPUtil.getParameter(request,"yd_cd");
    String vndr_seq = JSPUtil.getParameter(request,"vndr_seq");
    String vndr_seq_nm = JSPUtil.getParameter(request,"vndr_seq_nm");
    String yd_cd2 = JSPUtil.getParameter(request,"yd_cd").substring(0, 5); 
    String cost_cd_inv_tp_cd = JSPUtil.getParameter(request,"cost_cd_inv_tp_cd");
    
    String atb_dt = JSPUtil.getParameter(request,"atb_dt");
    String min_wrk_dt = JSPUtil.getParameter(request,"min_wrk_dt");
    String max_wrk_dt = JSPUtil.getParameter(request,"max_wrk_dt");
    String to_prd_dt = JSPUtil.getParameter(request,"to_prd_dt");
    
    String yd_nm = JSPUtil.getParameter(request,"yd_nm");
    String vvd = JSPUtil.getParameter(request,"vvd");
%>
<html>
<head>
<title>Receiver Info</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

var sFunc = '<%=JSPUtil.getParameter(request, "func")%>'; //js소스 생성
var prgm_id = '<%=JSPUtil.getParameter(request, "prgm_id")%>'; //프로그램 ID에 따라 화면 UI가 변경 됨.
    function setupPage()
    {
        loadPage();
    }
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form" method="post" id="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="agmt_ofc_cty_cd" value="">
<input type="hidden" name="agmt_seq" value="">
<input type="hidden" name="agmt_ver_no" value="">
<input type="hidden" name="tml_trns_mod_cd" value="">
<input type="hidden" name="vndr_seq" value="<%=vndr_seq  %>">
<input type="hidden" name="cost_code" value="">
<input type="hidden" name="tmp_common_code"	value="">
<input type="hidden" name="cost_cd_inv_tp_cd"	value="<%=cost_cd_inv_tp_cd%>">

<input type="hidden" name="atb_dt"	value="<%=atb_dt%>">
<input type="hidden" name="min_wrk_dt"	value="<%=min_wrk_dt%>">
<input type="hidden" name="max_wrk_dt"	value="<%=max_wrk_dt%>">
<input type="hidden" name="to_prd_dt"	value="<%=to_prd_dt%>">

<input type="hidden" name="yd_nm"	value="<%=yd_nm%>">
<input type="hidden" name="vvd"	value="<%=vvd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Agreement Information of Manual Rate.</td></tr>
      </table>
      <!-- : ( Title ) (E) -->


      <table>
        <tr>
          <td class="bg" width='800'>
      <!-- : ( Search Options ) (S) -->

			<table class="search">
		       	<tr>
		       		<td class="bg">
						<table border="0">
							<tr class="h23">
								<td width="135">Agreement No.</td>
								<td width="120" class="stm"><input class="input2" type="text" style="width:98;text-align:center" name="agmt_no" value='' maxlength=6  DISABLED></td>
								<td width="125">Agreement Version</td>
								<td width="115" class="stm"><input class="input2" type="text" style="width:103;text-align:right" name="agmt_version" value=''   DISABLED></td>
								<td width="90">Cost Code</td>
								<td class="stm"><script language="javascript">ComComboObject('cost_code_combo', 1, 91, 0, 1)</script></td></td>
							</tr>
						</table>
						<table border="0">
							<tr class="h23">
								<td width="35">UOM</td>
								<td width="70" class="stm">
									<!-- // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11) -->
									<SELECT name="tml_agmt_vol_ut_cd" style='width: 60' onChange='form_combo_onChange(this)'>
									<OPTION value="ALL">ALL</OPTION>
										<OPTION value="C">C</OPTION>
										<OPTION value="T">T</OPTION>
										<OPTION value="B">B</OPTION>
										<OPTION value="M">M</OPTION>
										<OPTION value="G">G</OPTION>
										<OPTION value="W">W</OPTION>
									<%if("OS".equals(cost_cd_inv_tp_cd)){ %>	
										<OPTION value="">Over day</OPTION>
									<%} %>	
									</SELECT>
								</td>
								<td width="60">Type Size</td>
								<td width="90" class="stm">
									<SELECT name="cntr_tpsz_cd" style='width: 70' onChange='form_combo_onChange(this)'>
										<OPTION value="ALL">ALL</OPTION>
									</SELECT>
									<%//= JSPUtil.getCodeCombo("cntr_tpsz_cd", "", "style='width:70' onChange='form_combo_onChange(this)'", "CD00830", 1, "00:ALL:ALL")%>
								</td>
								<td width="125">DG</td>
								<td width="115" class="stm"><%= JSPUtil.getCodeCombo("dcgo_ind_cd", "ALL", "style='width:105' onChange='form_combo_onChange(this)'", "CD00167", 1, "00:ALL:ALL CNTRS|01:ALLDG:ALL DG CLASS")%></td>
								<td width="88">Applied Date</td>
								<td class="stm"><%= JSPUtil.getCodeCombo("tml_wrk_dy_cd", "", "style='width:91' onChange='form_combo_onChange(this)'", "CD00168", 1, "00::")%></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		
			<table class="height_10"><tr><td></td></tr></table>
		
			<table class="search">
		       	<tr>
		       		<td class="bg">
						<table border="0">
							<tr class="h23">
								<td colspan='2' align='center'>Yard Code</td>
								<td width="100" ><input class="input2" type="text" style="width:75;text-align:center" name="yd_cd" value='<%=yd_cd%>' maxlength=6  DISABLED></td>
								<td width="100">S/P Code</td>
								<td width="115" ><input class="input2" type="text" style="width:75;text-align:center" name="sp_cd" value='<%=vndr_seq  %>'  maxlength=6  DISABLED></td>
								<td width="120">S/P Name (Abbr.)</td>
								<td width="210"><input class="input2" type="text" style="width:180" name="sp_nm" value='<%=vndr_seq_nm %>'  maxlength=6  DISABLED></td>
							</tr>
							<tr class="h23">
								<td width="100" rowspan='2' style=" border-right:1px solid #000">Effective Date</td>
								<td width="40" style="padding-left:5px">From</td>
								<td><input class="input2" type="text" style="width:75;text-align:center" name="eff_fm_dt" value=''  maxlength=8  DISABLED></td>
								<td>Contract Office</td>
								<td><input class="input2" type="text" style="width:75;text-align:center" name="ctrt_ofc_cd" value=''  maxlength=6  DISABLED></td>
								<td>Creation Office</td>
								<td><input class="input2" type="text" style="width:75;text-align:center" name="cre_ofc_cd" value=''  maxlength=6  DISABLED></td>
							</tr>
							<tr class="h23">
								<td style="padding-left:5px">To</td>
								<td><input class="input2" type="text" style="width:75;text-align:center" name="eff_to_dt" value=''  maxlength=8  DISABLED></td>
								<td>Creation Date</td>
								<td><input class="input2" type="text" style="width:75;text-align:center" name="cre_dt" value=''  maxlength=6  DISABLED></td>
								<td>Update Date</td>
								<td><input class="input2" type="text" style="width:75;text-align:center" name="upd_dt" value=''  maxlength=6  DISABLED></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

      <!-- : ( Search Options ) (E) -->
            <!--Grid (S)-->
            <table width="100%">
            <tr><td height="10"></td></tr>
            </table>
            <table width="100%"  id="mainTable"  class='search'>
			  <tr>
			    <td width="800" class='bg'>
			      <script language="javascript">ComSheetObject('sheet1');</script>
		      
					<!-- : ( Button : pop ) (S) -->
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				        <tr>
				          <td class="btn3_bg" style='padding-top:10px' align='right'>
				            <table border="0" cellpadding="0" cellspacing="0" align='right'>
				              <tr>
				                <td width="90">
				                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				                    <tr>
				                      <td class="btn1_left"></td>
				                      <td class="btn1" name="btn_AddItem" id="btn_AddItem">Add Item</td>
				                      <td class="btn1_right"></td>
				                    </tr>
				                  </table>
				                </td>
				              </tr>
				            </table>
				            <!--Button (E) -->
				
				          </td>
				        </tr>
				      </table>
				      <!-- : ( Button : pop ) (E) -->
					      
			    </td>
			  </tr>
			</table>
			
            <table width="100%">
            <tr><td height="5"></td></tr>
            <tr><td height="10" align='center' style='color:#0080c0;'>▼</td></tr>
            <tr><td height="5"></td></tr>
            </table>
		      
			
			<table width="100%"  id="mainTable"   class='search'>
			  <tr>
			    <td width="800" class='bg'>      	
			      <script language="javascript">ComSheetObject('select');</script>
			      
			      <!-- : ( Button : pop ) (S) -->
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				        <tr>
				          <td class="btn3_bg" style='padding-top:10px'>
				            <table border="0" cellpadding="0" cellspacing="0">
				              <tr>
				                <td width="110">
				                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				                    <tr>
				                      <td class="btn1_left"></td>
				                      <td class="btn1" name="btn_SelectItems" id="btn_SelectItems">Select Items</td>
				                      <td class="btn1_right"></td>
				                    </tr>
				                  </table>
				                </td>
				              
				             
				              
				                <td width="72">
				                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				                    <tr>
				                      <td class="btn1_left"></td>
				                      <td class="btn1" name="btn_Delete">Delete</td>
				                      <td class="btn1_right"></td>
				                    </tr>
				                  </table>
				                </td>
				              </tr>
				            </table>
				            <!--Button (E) -->
				
				          </td>
				        </tr>
				      </table>
				      <!-- : ( Button : pop ) (E) -->
			    </td>
			  </tr>
			</table>
			
			            
          </td>
        </tr>
      </table>
            <!--Grid (E)-->

    </td>
  </tr>
</table>
    </td>
  </tr>
</table>
</form>
<div style="width:600px;display:none">
	<script language="javascript">ComSheetObject('costcode');</script>
</div>
</body>
</html>
