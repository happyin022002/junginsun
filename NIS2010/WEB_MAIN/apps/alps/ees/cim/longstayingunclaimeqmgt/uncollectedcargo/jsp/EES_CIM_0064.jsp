<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0064.jsp 
*@FileTitle : UC Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.09
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 1.0 최초 생성 
------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%
	String srt_cnee_uc_dt_to = DateTime.getFormatString("yyyy-MM-dd");
	String srt_cnee_uc_dt_fr = srt_cnee_uc_dt_to.substring(0,4)+"-01-01";
%>

<html>
<head>
<title>Agreement Correction</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

// UC Status(CD03292), UC Type(CD03294), Disposal(CD03293) 셋팅
<%= JSPUtil.getIBCodeCombo("uc_sts_cd"		, "", "CD03292", 0, "")%>
<%= JSPUtil.getIBCodeCombo("uc_disp_opt_cd"	, "", "CD03294", 0, "")%>
<%= JSPUtil.getIBCodeCombo("uc_rsn_cd"		, "", "CD03293", 0, "")%>
<%= JSPUtil.getIBCodeCombo("uc_piclb_cd"	, "", "CD03295", 0, "")%>

  function setupPage(){
    loadPage();
  }
  
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" >
<input type="hidden" name="date_to"  value="<%=srt_cnee_uc_dt_to%>" >
<input type="hidden" name="date_fr"  value="<%=srt_cnee_uc_dt_fr%>" >

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td>
      	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      	</table>
      	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
      
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		  <tr>
		    <td class="btn1_bg">
		      <table border="0" cellpadding="0" cellspacing="0">
		        <tr>
		          <td>
		            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
		              <tr>
		                <td class="btn1_left"></td>
		                <td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
		                <td class="btn1_right"></td>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_new" id="btn_new">New</td>
						<td class="btn1_right"></td>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
						<td class="btn1_right"></td>
		              </tr>
		            </table>
		          </td>
		        </tr>
		  </table>
		</td></tr>
		</table>
		<!--Button (E) -->
  
		<!-- TABLE '#D' : ( Search ) (S) -->
       	<table class="search" style="width:295;">
		<tr>
             <td class="bg">
                 <table class="search_in" border="0" style="width:295;">
					<tr class="h23">
						<td width="30"><input type="radio" name="s_retrieve_gb" class="trans" value="A" OnClick="chg_retrieve_gb();" checked></td>
						<td width="100">UC Case No.</td>
						<td>
		                  <input name="s_uc_cs_no" type="text" style="width:183;" value="" dataformat="engup" maxlength="20">
		                </td>
					</tr>
					<tr class="h23">
						<td width="30"></td>
						<td width="100">B/L No.</td>
						<td>
		                  <input name="s_bl_no" type="text" style="width:183;" value="" dataformat="engup" maxlength="12">
		                </td>
					</tr>
					<tr class="h23">
						<td width="30"></td>
						<td width="100">CNTR No.</td>
						<td>
		                  <input name="s_cntr_no" type="text" style="width:183;" value="" dataformat="engup" maxlength="14">
		                </td>
					</tr>
                 </table>
             </td>
        </tr>
       	</table>
      	<!-- TABLE '#D' : ( Search ) (E) -->
      	
      	<table class="height_5"><tr><td></td></tr></table>
      	
		<!-- TABLE '#D' : ( Search ) (S) -->
       	<table class="search" border="0" style="width:824">
		<tr>
               <td class="bg">
                   <table class="search_in" border="0" style="width:824;">
					<tr class="h23">
						<td width="30"><input type="radio" name="s_retrieve_gb" class="trans" value="B" OnClick="chg_retrieve_gb();"></td>
						<td width="100">Date</td>
						<td width="350" class="stm">
			                  <select name="s_cnee_uc_dt_gb" style="width:100;">
			                    <!--<option value = ""> </option>-->
			                    <option value = "A">UC Date</option>
			                    <option value = "B">Close Date</option>
			                    <option value = "C">Creation Date</option>
			                    <option value = "D">POL Date</option>
			                    <option value = "E">POD Date</option>
			                  </select>
							<input name="s_cnee_uc_dt_fr" type="text" style="width:75; text-align:center;" maxlength="10" value="<%=srt_cnee_uc_dt_fr%>" onBlur="javascript:getDateBetween(this);" class="input1" dataformat="ymd">~<input name="s_cnee_uc_dt_to" type="text" style="width:75; text-align:center;" maxlength="10" value="<%=srt_cnee_uc_dt_to%>" onKeyup="" class="input1" dataformat="ymd">
							<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"> 
						</td>
						<td width="110">Handling RHQ</td>
						<td width="80">
							&nbsp;<input name="s_hndl_rhq_cd" type="text" style="width:70;" class="input" value="" dataformat="engup" maxlength="6">
						</td>					
						<td width="90r">Handling OFC</td>
		                <td width="80">
		                  <input name="s_hndl_brnc_cd" type="text" style="width:70;"  value="" dataformat="engup" maxlength="6">
		                </td>
					</tr>
					<tr class="h23">
						<td width="30"></td>
						<td width="100">Days</td>
						<td width="350" class="stm">
			                  <select name="s_uc_dys_gb" style="width:100;">
			                    <option value = ""> </option>
			                    <option value = "A">UC Days</option>
			                    <option value = "B">Days from Disc</option>
			                  </select>
			  				<input name="s_uc_dys_fr" type="text" style="width:75;"  value="" dataformat="num" maxlength="5">~<input name="s_uc_dys_to" type="text" style="width:75;"  value="" dataformat="num" maxlength="5">
						</td>
						<td width="110">Counter RHQ</td>
						<td width="80">
							&nbsp;<input name="s_kntr_rhq_cd" type="text" style="width:70;" class="input" value="" dataformat="engup" maxlength="6">
						</td>					
						<td>Counter OFC</td>
		                <td width="80">
		                  <input name="s_kntr_brnc_cd" type="text" style="width:70;"  value="" dataformat="engup" maxlength="6">
		                </td>
					</tr>
					<tr class="h23">
						<td width="30"></td>
						<td width="100">UC Status</td>
						<td width="350">
			  				&nbsp;<script language="javascript">ComComboObject('uc_sts_cd',2, 100 , 1 )</script>
							&nbsp;		  				
	                  		<input name="uc_sts_cd_nm" type="text" style="width:180;" readonly class="input2">
						</td>
						<td width="110">Disposal/Solution</td>
						<td width="80">
							&nbsp;<script language="javascript">ComComboObject('uc_disp_opt_cd',2, 70 , 1 )</script>
						</td>			
						<td width="70"  colspan="2">		
	                  		<input name="uc_disp_opt_cd_nm" type="text" style="width:158;" readonly class="input2">
						</td>			
					</tr>
					<tr class="h23">
						<td width="30"></td>
						<td width="100">UC Reasons</td>
						<td width="350" class="stm">
			  				&nbsp;<script language="javascript">ComComboObject('uc_rsn_cd',2, 100 , 1 )</script>
							&nbsp;		  				
	                  		<input name="uc_rsn_cd_nm" type="text" style="width:180;" readonly class="input2">
						</td>
						<td width="110">POL</td>
						<td width="80">
							&nbsp;<input name="s_pol_cd" type="text" style="width:70;" class="input" value="" dataformat="engup" maxlength="5" >
						</td>					
						<td>POD</td>
		                <td width="70">
		                  <input name="s_pod_cd" type="text" style="width:70;"  value="" dataformat="engup" maxlength="5" >
		                </td>
					</tr>
				</table>
               </td>
             <td>&nbsp;&nbsp;</td>
             <td class="bg">
                 <table class="search_in" border="0" style="width:130;">
					<tr class="h23">
						<td width="150"><input type="radio" name="s_case_gb" class="trans" value="A" OnClick="chg_case_gb();"checked>By Container</td>
					</tr>
					<tr class="h23">
						<td width="100"><input type="radio" name="s_case_gb" class="trans" value="B" OnClick="chg_case_gb();" >By Case</td>
					</tr>
                 </table>
             </td>                
           </tr>
       	</table>
      	<!-- TABLE '#D' : ( Search ) (E) -->
    </td>
  </tr>
</table>
    
<table class="height_5"><tr><td></td></tr></table>  

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:5;"> 
  <tr>
    <td>
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">
            
            <!-- TABLE '#D' : ( Grid ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                 <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Grid ) (E) -->

          </td>
        </tr>
      </table>
      <!-- : ( Button_ Sub ) (E) -->            
      
    </td>
  </tr>
</table>
<table class="height_10"><tr><td colspan="8"><script language="javascript">ComComboObject('uc_piclb_cd',2, 0 , 1 )</script></td></tr></table>
</form>
</body>
</html>
