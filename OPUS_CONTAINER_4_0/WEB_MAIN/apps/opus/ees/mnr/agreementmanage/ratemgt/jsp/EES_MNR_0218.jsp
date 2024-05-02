<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0218.jsp
*@FileTitle  : M&R AGREEMENT DETAIL Pop_Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================
--%>		
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.event.EesMnr0218Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>
  
<%
	EesMnr0218Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list
	 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
 	
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	String strAgmt_no		= "";  
	String strAgmt_ofc_cd		= "";  
	
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.EQFlagMgt");
	      
	try {    
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
		strOfc_cd = account.getOfc_cd();      

		if(request.getParameter("agmt_no")!=null && !request.getParameter("agmt_no").equals("")) {
			strAgmt_no = StringUtil.xssFilter(request.getParameter("agmt_no"));
		}
		if(request.getParameter("agmt_ofc_cd")!=null && !request.getParameter("agmt_ofc_cd").equals("")) {
			strAgmt_ofc_cd = StringUtil.xssFilter(request.getParameter("agmt_ofc_cd"));
		}			     
		event = (EesMnr0218Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 
		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}      
		
		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	    	    
	}catch(Exception e) {         
		out.println(e.toString());
	}
%>

<!-- common use in MNR -->                
<script type="text/javascript">   
	function setupPage(){ 
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if  
		
       // document.getElementById("title").innerHTML = "M&R Agreement Detail ";
		
		loadPage();
	}
</script>
<script type="text/javascript">ComSheetObject('sheet1');</script>    
	   
<form name="form" id="form">
<input type="hidden" name="local_ofc_cd" value="<%=strOfc_cd%>" id="local_ofc_cd" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- for indexing when saving -->                   
<input type="hidden" name="agmt_ofc_cty_cd" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" id="agmt_seq" />
<!-- handling variable TPSZ -->
<input type="hidden" name="agmt_type_tpsz" id="agmt_type_tpsz" />
<!-- handling variable VO type when saving --> 
<input type="hidden" name="agmt_display_type" id="agmt_display_type" />
<input type="hidden" name="agmt_prifix" id="agmt_prifix" />
<!-- version up status  -->    
<input type="hidden" name="isversionup" value="N" id="isversionup" />

<!-- PARTER hidden value  -->        
<input type="hidden" name="ctrl_ofc_cd" value="<%=strOfc_cd%>" id="ctrl_ofc_cd" />
<input type="hidden" name="strAgmt_no" value="<%=strAgmt_no%>" id="strAgmt_no" />


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>M&R Agreement Detail</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			 <button type="button" class="btn_accent" name="btn_Close" onClick="self.close()"	id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
	
<div class="layer_popup_contents">
	<div class= "wrap_search_tab">
		<div class= "opus_design_inquiry wFit">
			<!-- opus_design_inquiry(S) -->
		    <table>
			    <colgroup>
		            <col width="100" />
		            <col width="50" />
		            <col width="50" />
		            <col width="*" />
		        </colgroup>
		        <tbody>
					<tr>
						<th>Agreement No.</th>
						<td ><input  tabindex="1" type="text" name="agmt_no" style="width:100px;" class="input1" value="" dataformat="engup" id="agmt_no" /></td>
						<th>Version No.</th>
						<td><input  name="agmt_ver_no2" readonly type="text" style="width:42px;text-align:right;" class="input2" value="" id="agmt_ver_no2" /><input  name="agmt_ver_dt" readonly type="text" style="width:126px;" class="input2" value="" id="agmt_ver_dt" /></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr> </table>
		    <table>
			    <colgroup>
		            <col width="100" />
		            <col width="50" />
		            <col width="50" />
		            <col width="50" />
		            <col width="50" />
		            <col width="*" />
		        </colgroup>
		        <tbody>
					<tr>
						<th>Service Provider</th>
						<td><input  tabindex="3" type="text" name="vndr_seq" caption="Service Provider" style="width:55;text-align:left;" class="input1" value="" dataformat="num" maxlength="6"><input type="text" name="vndr_nm" caption="Service Provider" style="width:190px;" class="input2" value="" readonly id="vndr_nm" /></td>
		                <th>Currency</th>
		                <td><input  name="curr_cd2" readonly type="text" style="width:42px;" class="input2" value="" id="curr_cd2" /> </td>
		                <th>Agreement Office</th>
		                <td><input  name="agmt_ofc_cd2" readonly type="text" style="width:79px;" class="input2" value="<%=strAgmt_ofc_cd %>" id="agmt_ofc_cd2" /> </td>
					</tr>
					<tr>
						<th>Effect Period</th>
						<td><input  fullfill type="text" name="eff_dt" dataformat="ymd" class="input1" caption="from date" maxlength="10" style="width:78px;" cofield="exp_dt" value="" id="eff_dt" /><span class="dash">~</span><input  fullfill type="text" name="exp_dt" dataformat="ymd"   class="input1"  caption="to date"        maxlength="10"  size="10"  cofield="eff_dt"></td>
		                <th>Pay Terms</th>
		                <td><input  name="pay_term_dys" type="text" style="width:42px;text-align:right;" class="input1" value="" maxlength="3" dataformat="num" id="pay_term_dys" /><label for ="pay_term_dys">days</label></td>
		                <th>AGMT Sign Date</th>
		                <td><input  name="agmt_dt" type="text" style="width:79px;" class="input1" value="" dataformat="ymd" maxlength="10" id="agmt_dt" />  </td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr> </table>
		    <table>
		    	<colgroup>
		            <col width="100" />
		            <col width="50" />
		            <col width="50" />
		            <col width="*" />
		        </colgroup>
		        <tbody>
					<tr>
						<th>Tariff No.</th>
						<td><input  name="trf_no2" readonly type="text" style="width:182px;" class="input2" value="" id="trf_no2" /></td>
		                <th>Ref. No.</th>
		                <td><input  type="text" maxlength="20" name="agmt_ref_no" style="width:280px;" class="input1" value="" dataformat="engup" id="agmt_ref_no" /> </td>
					</tr>
					<tr>
						<th>EQ Type</th>
		                <td><input  name="eq_knd_cd2" readonly type="text" style="width:82px;" class="input2" value="" id="eq_knd_cd2" /> </td>
		                <th>Old Agreement No.</th>
						<td><input type="text" name="old_agmt_no" id="old_agmt_no" style="width:200px;" class="input2" value="" dataformat="engup" disabled></td>
		                
					</tr>
				</tbody>
			</table>
			<table>
            <colgroup>
                <col width="100">
                <col width="120">
                <col width="100">
                <col width="150">
                <col width="100">
                <col width="120">
                <col width="100">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th>Create User</th>
                    <td><input type="text" style="width:80px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
                    </td>
                    <th>Create Date/Time</th>
                    <td><input type="text" style="width:120px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
                    </td>
                    <th>Last Update User</th>
                    <td><input type="text" style="width:80px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
                    </td>
                    <th>Last Update Date/Time</th>
                    <td><input type="text" style="width:120px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
                    </td>
                </tr>
            </tbody>
        </table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
	<div class="layout_wrap">
 		<div class="layout_vertical" style="width: 49%;">
 		<div style="margin-right:10px;margin-left:10px;">
		    <!-- opus_tab_btn(S) -->
		    <div class="opus_design_tab">
		        <script type="text/javascript">ComTabObject('tab1')</script>
		    </div>
		    <div class="layout_flex_fixed" style="width:540px"> 
		    <!-- opus_tab_btn(E) -->
			<div id="tabLayer" style="display:none">
				<div class="opus_design_grid" >
					<script type="text/javascript">ComSheetObject('t1sheet1');</script><!--W/O Issue-->
				</div>
			</div>
			
			<div id="tabLayer" style="display:none">
				<div id="comboLayer" style="display:none">
					<table   id="mainTable"> 
						<tr>
							<td width="100%">
								<script type="text/javascript">ComComboObject('agmt_ver_no', 2, 0, 1, 1,0,false,2);</script>
								<script type="text/javascript">ComComboObject('curr_cd', 2, 0, 1, 1,0,false,4);</script>
								<script type="text/javascript">ComComboObject('agmt_ofc_cd', 1, 0, 1, 1);</script>
								<script type="text/javascript">ComComboObject('trf_no', 8, 270, 1, 0,0,false,1);</script>  						
								<script type="text/javascript">ComComboObject('eq_knd_cd',1, 78 , 1,1)</script> 	
							</td>
						</tr>
					</table>
				</div>
				<div class="opus_design_grid" >
					<script type="text/javascript">ComSheetObject('t2sheet1');</script><!--W/O Issue-->
				</div>
			</div>

			<div id="tabLayer" style="display:none">
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t3sheet1');</script><!--W/O Issue-->
				</div>
					<!-- opus_design_grid(E) -->
			</div>
	
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t4sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
	
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"   >
				  	<!-- Button_Sub (E) -->
					<script type="text/javascript">ComSheetObject('t5sheet1');</script><!--W/O Issue-->
				</div>
					<!-- opus_design_grid(E) -->
			</div>
	
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  id="sentTabSCTariffLayer" style="display:block">
				    <!-- opus_design_btn(E) -->
					<script type="text/javascript">ComSheetObject('t6sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
	
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid" >
					<script type="text/javascript">ComSheetObject('t7sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t8sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t9sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t10sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t11sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t12sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t13sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t14sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t15sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t16sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t17sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t18sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t19sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
			
			<div id="tabLayer" style="display:none">
				<!-- opus_design_grid(S) -->
				<div class="opus_design_grid"  >
					<script type="text/javascript">ComSheetObject('t20sheet1');</script><!--W/O Issue-->
				</div>
				<!-- opus_design_grid(E) -->
			</div>
		</div>
		</div>
		</div>
	
		<div class="layout_flex_flex" style="padding-left:566px;padding-top:25px"> 
			<!-- opus_design_grid(S) -->
			
			<div class="opus_design_grid"  id="mainTable" >
				<h3 style="margin-bottom:5px" class="title_design">Cost CTRL Office & Partner Infomation</h3>	
			    <script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>  
	</div>
	<!-- opus_design_grid(E) -->

		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry" style="margin-top:25px">
		    <table class="grid_2">
		    	 <colgroup>
		        	 <col width="50" />
		         	 <col width="*" />
		     	 </colgroup>
		        <tbody>
					<tr>
						<th><strong>Remark(s)</strong></th>
						<td><textarea name="agmt_rmk" id="agmt_rmk" wrap="off" style="width:100%;resize:none" rows="4"></textarea></td>
					</tr>
					
				</tbody>
			</table>
		</div>
	</div>
</div>
</form>   
