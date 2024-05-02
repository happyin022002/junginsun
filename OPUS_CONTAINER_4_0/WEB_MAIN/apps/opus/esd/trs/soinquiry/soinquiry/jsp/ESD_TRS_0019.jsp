<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0019
*@FileTitle  :  SO Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.soinquiry.soinquiry.event.EsdTrs0019Event"%>

<%
	EsdTrs0019Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;								 	
	String today = DateTime.getFormatString("yyyyMMdd");
	String userId  = "";
	String selCOSTMODE = "";
	String selTRANSMODE = "";
	String selBOUND = "";
	String selSOMODE = "";
	String selWOMODE = "";
	String selINVOICEMODE = "";
	String selCARGOMODE = "";
	String selSOTYPE = "";
	String optionStr = "000020:ALL:ALL";
	String selAMOUNT = "";
	String eq_ctrl ="";
	String eq_ctrl_1 ="";
	selBOUND  = JSPUtil.getCodeCombo("sel_boundmode", "01"		," onChange='bound_OnChange_1(this);' style='width:101;'", "CD00591", 0, optionStr);
	selCOSTMODE  = JSPUtil.getCodeCombo("sel_costmode", "01"	," onChange='bound_OnChange_2(this);' style='width:150;'", "CD00958", 0, optionStr);
	selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01"	," onChange='bound_OnChange_3(this);' style='width:91;'", "CD00283", 0, optionStr);
	selSOMODE  = JSPUtil.getCodeCombo("sel_somode", "01"	," onChange='bound_OnChange_4(this);' style='width:101'", "CD00826", 0, optionStr);
	selWOMODE  = JSPUtil.getCodeCombo("sel_womode", "01"	," onChange='bound_OnChange_5(this);' style='width:150'", "CD00827", 0, optionStr);
	selINVOICEMODE  = JSPUtil.getCodeCombo("sel_invoicemode", "01"	," onChange='bound_OnChange_6(this);'", "CD01249", 0, optionStr);
	selCARGOMODE  = JSPUtil.getCodeCombo("sel_cargomode", "01"	," onChange='bound_OnChange_7(this);'", "CD00748", 0, optionStr);
	selSOTYPE  = JSPUtil.getCodeCombo("sel_sotype", "01"	," onChange='bound_OnChange_8(this);' style='width:130;'", "CD00279", 0, optionStr);
	selAMOUNT = JSPUtil.getCodeCombo("sel_amount", "01", "  onChange='bound_OnChange_9(this);' style='width:100;'", "CD00927", 0, optionStr);
	String sowonumber = JSPUtil.getParameter(request, "sowonumber");
	String railflg = JSPUtil.getParameter(request, "railflg");
	String opener		= JSPUtil.getParameter(request, "opener");
	String invar_sofmdt = JSPUtil.getParameter(request, "invar_sofmdt");
	String invar_sotodt = JSPUtil.getParameter(request, "invar_sotodt");
	String invar_ofc    = JSPUtil.getParameter(request, "invar_ofc");
	String invar_bnd    = JSPUtil.getParameter(request, "invar_bnd");
	String invar_term   = JSPUtil.getParameter(request, "invar_term");
	String invar_onlycy   = JSPUtil.getParameter(request, "invar_onlycy");
	String invar_trosts = JSPUtil.getParameter(request, "invar_trosts");
	String invar_colhd  = JSPUtil.getParameter(request, "invar_colhd");
	String invar_sotype  = JSPUtil.getParameter(request, "invar_sotype");
	String invar_from_node  = JSPUtil.getParameter(request, "invar_from_node");
	String invar_to_node  = JSPUtil.getParameter(request, "invar_to_node");
	String p_pop_flg  	  = JSPUtil.getParameter(request, "p_pop_flg");
	try {
	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   eq_ctrl=account.getOfc_cd();
	   eq_ctrl_1=eq_ctrl.substring(0, 3);
	   event = (EsdTrs0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var sowonumber = "<%=sowonumber%>";
	var railflg = "<%=railflg%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
		<%-- if ( sowonumber != "") {
			document.form.input_office.value="";
		} else {
		    document.form.input_office.value="<%=eq_ctrl%>"; 
		} --%>
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="opener" value="<%=opener%>" id="opener" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="cre_ofc_cd" value="<%=eq_ctrl%>" id="cre_ofc_cd" />
<input type="hidden" name="cre_ofc_cd_1" value="<%=eq_ctrl_1%>" id="cre_ofc_cd_1" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=userId%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=eq_ctrl%>" id="FORM_USR_OFC_CD" />
<input type="hidden" name="cre_dt_val" value="<%=today%>" id="cre_dt_val" />
<input type="hidden" name="upd_usr_id" value="<%=userId%>" id="upd_usr_id" />
<input type="hidden" name="upd_dt" value="<%=today%>" id="upd_dt" />
<input type="hidden" name="hid_boundmode" id="hid_boundmode" />
<input type="hidden" name="hid_costmode" id="hid_costmode" />
<input type="hidden" name="hid_transmode" id="hid_transmode" />
<input type="hidden" name="hid_sotype" id="hid_sotype" />
<input type="hidden" name="hid_usrail" value="N" id="hid_usrail" />
<input type="hidden" name="hid_usdropnpull" value="N" id="hid_usdropnpull" />
<input type="hidden" name="hid_somode" id="hid_somode" />
<input type="hidden" name="hid_womode" id="hid_womode" />
<input type="hidden" name="hid_invoicemode" id="hid_invoicemode" />
<input type="hidden" name="hid_cargomode" id="hid_cargomode" />
<input type="hidden" name="hid_wrkofc" id="hid_wrkofc" />
<input type="hidden" name="hid_bkgterm" id="hid_bkgterm" />
<input type="hidden" name="hid_onlycy" id="hid_onlycy" />
<input type="hidden" name="hid_trosts" id="hid_trosts" />
<input type="hidden" name="hid_tpsz" id="hid_tpsz" />
<input type="hidden" name="hid_period" value="S" id="hid_period" />
<input type="hidden" name="hid_radio_office" value="S" id="hid_radio_office" />
<input type="hidden" name="hid_radio_user" value="S" id="hid_radio_user" />
<input type="hidden" name="hid_radio_number" value="S" id="hid_radio_number" />
<input type="hidden" name="hid_radio_eq" value="CNTR" id="hid_radio_eq" />
<input type="hidden" name="hid_from_node" id="hid_from_node" />
<input type="hidden" name="hid_via_node" id="hid_via_node" />
<input type="hidden" name="hid_to_node" id="hid_to_node" />
<input type="hidden" name="hid_door_node" id="hid_door_node" />
<input type="hidden" name="hid_from_date" id="hid_from_date" />
<input type="hidden" name="hid_to_date" id="hid_to_date" />
<input type="hidden" name="hid_provider" id="hid_provider" />
<input type="hidden" name="hid_provider_type" id="hid_provider_type" />
<input type="hidden" name="chk_from_node" id="chk_from_node" />
<input type="hidden" name="chk_via_node" id="chk_via_node" />
<input type="hidden" name="chk_to_node" id="chk_to_node" />
<input type="hidden" name="chk_door_node" id="chk_door_node" />
<input type="hidden" name="hid_unplanned" id="hid_unplanned" />
<input type="hidden" name="hid_amount" value="ALL" id="hid_amount" />
<input type="hidden" name="old_ofc_cd" value="<%=eq_ctrl%>" id="old_ofc_cd" />
<input type="hidden" name="hid_grid_flg" id="hid_grid_flg" />
<input type="hidden" name="invar_sofmdt" value="<%=invar_sofmdt%>" id="invar_sofmdt" />
<input type="hidden" name="invar_sotodt" value="<%=invar_sotodt%>" id="invar_sotodt" />
<input type="hidden" name="invar_ofc" value="<%=invar_ofc%>" id="invar_ofc" />
<input type="hidden" name="invar_bnd" value="<%=invar_bnd%>" id="invar_bnd" />
<input type="hidden" name="invar_term" value="<%=invar_term%>" id="invar_term" />
<input type="hidden" name="invar_onlycy" value="<%=invar_onlycy%>" id="invar_onlycy" />
<input type="hidden" name="invar_trosts" value="<%=invar_trosts%>" id="invar_trosts" />
<input type="hidden" name="invar_colhd" value="<%=invar_colhd%>" id="invar_colhd" />
<input type="hidden" name="invar_sotype" value="<%=invar_sotype%>" id="invar_sotype" />
<input type="hidden" name="invar_from_node" value="<%=invar_from_node%>" id="invar_from_node" />
<input type="hidden" name="invar_to_node" value="<%=invar_to_node%>" id="invar_to_node" />


<div id="ButtLayer1" style="display:inline">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
<% if("Y".equals(p_pop_flg)) {%>	
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
<% } else { %>	
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
	</div>
<% } %>	
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
	<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->


<div id="MiniLayer" style="display:inline">
<!-- wrap_search(S) -->  
<div class="wrap_search" <% if("Y".equals(p_pop_flg)) {%> style='display:none'; <% } %>>
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="125">
				<col width="350">
				<col width="25">
				<col width="80">
				<col width="25">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr class="h23">
				<th>Date</th>
				<td>
					<SELECT style = "width:130px" name = "sel_period"  onChange='change_period();'>
						<OPTION  value="S"> S/O Creation</OPTION>
						<OPTION  value="W"> W/O Issue</OPTION>
						<OPTION  value="I"> Invoice Confirm</OPTION>
						<OPTION  value="O"> From Departure</OPTION>
						<OPTION  value="L"> To Arrival</OPTION>
						<OPTION  value="D"> Door Arrival</OPTION>
					</SELECT><!--  
					--><input name="from_date" type="text" class="input1" style="width:75px;" value="" onFocus='fun_Focus_del(this)'  onBlur='addBar_from(this); getDateBetween(this);' dataformat="ymd"><!-- 
					-->~ <!-- 
					--><input name="to_date" type="text" class="input1" style="width:75px;" value="" onFocus='fun_Focus_del(this)'  onBlur='addBar_to(this);' dataformat="ymd" ><!-- 
					--><button type="button" name="btns_calendar" id="btns_calendar"  class="calendar ir"></button>	
				</td>
				<td></td>
				<td><input type="checkbox" name="chk_usrail" id="chk_usrail" value="N" class="trans" onClick="usrailOnly(this);"><label for="chk_usrail"><strong>USA Rail Only</strong></label></td>
				<td></td>
				<td><input type="checkbox" name="chk_usdropnpull" id="chk_usdropnpull" value="Y" class="trans" onClick="usdropnpullOnly(this);"><label for="chk_usdropnpull"><strong>US Drop & Pull</strong></label></td>
				<td></td>
			</tr>
		</table>
		
		<table>
			<colgroup>
				<col width="125">
				<col width="50">
				<col width="50">
				<col width="60">
				<col width="50">
				<col width="*">
			</colgroup>
			<tr class="h23">
				<th>Office Code</th>				
                <td class="sm">
                <input name="radio_office"  type="radio" class="trans" checked Onclick="change_office();" >Issue <!-- 
                 --><input name="radio_office"  type="radio" class="trans"  Onclick="change_office();" > Invoice <!-- 
                  --><input name="input_office" type="text" class="input1" style="width:75px;" onBlur="setgetUpper(this);" dataformat="engup"><!-- 
				 --><button type="button" name="btns_office" id="btns_office"  class="input_seach_btn"></button><!-- 
				  --> <input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();"> Incl. Sub OFC</td>
				  <td></td>
				<th>User ID </th>
                 <td class="sm">
                 <input name="radio_user" type="radio" class="trans" checked  Onclick="change_user();" > Issue <!-- 
                  --><input name="radio_user" type="radio" class="trans" Onclick="change_user();" > Invoice <!-- 
                   --> <input name="user_id" type="text" style="width:100px;"  maxlength="20" onBlur="user_check(this);" dataformat="eng"></td>
                   <td></td>                             		
			</tr>
		</table>
		
		<table>
			<colgroup>
				<col width="125">
				<col width="150">
				<col width="50">
				<col width="130">
				<col width="82">
				<col width="150">
				<col width="105">
				<col width="*">
			</colgroup>
			<tr class="h23">
				<th>Service Order Type</th>
				<td><%=selSOTYPE%></td>
				<th>Service Order</th>
				<td><%=selSOMODE%></td>
				<th>Work Order</th>
				<td><%=selWOMODE%></td>
				<th>Invoice</th>
				<td><%=selINVOICEMODE%></td>
			</tr>
		</table>
		
		<table>
			<colgroup>
				<col width="125">
				<col width="185">
				<col width="50">
				<col width="143">
				<col width="50">
				<col width="50">
				<col width="93">
				<col width="*">
			</colgroup>
			<tr class="h23">
				<th>Unplanned</th>
				<td><SELECT name = "sel_unplanned"   onChange='bound_OnChange_10(this);' >	<!-- 
				   --><OPTION  value="ALL" selected="selected"> ALL</OPTION><!-- 
				    --><OPTION  value="Y"> Y</OPTION><!-- 
				     --><OPTION  value="N"> N</OPTION><!-- 
				      --></SELECT></td>
				<th>Bound</th>
				<td><%=selBOUND%></td>
				<th>Cost Mode</th>
				<td><%=selCOSTMODE%></td>
				<th>Trans Mode</th>
				<td><%=selTRANSMODE%></td>
			</tr>
									
		</table>
		
		<table>
			<colgroup>
				<col width="125">
				<col width="150">
				<col width="40">
				<col width="50">
				<col width="40">
				<col width="50">
				<col width="40">
				<col width="50">
				<col width="40">
				<col width="50">
				<col width="*">
			</colgroup>
			<tr class="h23">
				<th>From</th>
				<td><input name="search_fm_loc" type="text" style="width:56px;" maxlength="5" onChange="getComboList(this, search_fm_yard, 'F');" onBlur="" dataformat="engup" ><script type="text/javascript">ComComboObject('search_fm_yard', 1, 48, 0)</script><!-- 
				 --><button type="button" name="btns_frmnode" id="btns_frmnode"  class="input_seach_btn"></button>
                    <input name="search_fm_node" type="text" style="width:80px;" onchange="resetLocYard('FROM');" onblur="" id="search_fm_node"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multi_search_fm_node" name="btns_multi_search_fm_node" class="multiple_inq ir"></button>
				</td>
				<th>Via</th>
				<td><input name="search_via_loc" type="text" style="width:50px;" maxlength="5" onChange="getComboList(this, search_via_yard, 'V');" onBlur="" dataformat="engup" ><script type="text/javascript">ComComboObject('search_via_yard', 1, 45, 0)</script><!-- 
				--><button type="button" name="btns_vianode" id="btns_vianode"  class="input_seach_btn"></button></td>
				<th>To</th>
				<td><input name="search_to_loc" type="text" style="width:52px;" maxlength="5" onChange="getComboList(this, search_to_yard, 'T');"  onBlur="" dataformat="engup" ><script type="text/javascript">ComComboObject('search_to_yard', 1, 45, 0)</script><img src="" width="2" hight="1"><!-- 
				 --><button type="button" name="btns_tonode" id="btns_tonode"  class="input_seach_btn"></button>
                    <input name="search_to_node" type="text" style="width:80px;" onchange="resetLocYard('TO');" onblur="" id="search_to_node"  dataformat="engup" otherchar=", "/><button type="button" id="btns_multi_search_to_node" name="btns_multi_search_to_node" class="multiple_inq ir"></button>
				</td>
				<th>Door</th>
				<td><input name="search_door_loc" type="text" style="width:50px;" maxlength="5" onChange="getComboList(this, search_door_yard, 'D');"  onBlur="" dataformat="engup"><script type="text/javascript">ComComboObject('search_door_yard', 1, 45, 0)</script><!-- 
				--><button type="button" name="btns_dorloc" id="btns_dorloc"  class="input_seach_btn"></button></td>
				<th>Zip Code</th>
				<td><input name="zip_code"  type="text" style="width:70px;"  onBlur="val_check(this,'ZIPCD');" dataformat="engup" otherchar=", "><!-- 
				 --><button type="button" onClick="so_OnPopupClick('ZIP Code');" name="" id=""  class="multiple_inq ir"></button></td>
				 <td></td>
			</tr>
		</table>
		
		<table class="line_bluedot"><tr><td></td></tr></table>
		
		<table>
			<colgroup>
				<col width="125">
				<col width="50">
				<col width="70">
				<col width="50">
				<col width="95">
				<col width="70">
				<col width="*">
			</colgroup>
			<tr class="h23">				
				<th>Service Provider</th>
			  	<td class="sm"><!-- 
			  	 --><input type="radio" class="trans" name='sp_tp' value='WO' checked>Work Order<!-- 
			  	  --> <input type="radio" class="trans" name='sp_tp' value='PA'  >Parent<!-- 
			  	   --> <input type="radio" class="trans" name='sp_tp' value='IV'  >Invoice<!-- 
			  	    --> <input name="combo_svc_provider" type="text"  style="width:57px;" maxlength="6" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' dataformat="engup"><!-- 
			  	     --><input name="svc_provider" type="text" style="width:180px;" value="" readonly  class="input2"  title="This inputbox cant't write" dataformat="engup"><!-- 
			  	      --><button type="button" name="btng_provider" id="btng_provider"  class="input_seach_btn"></button>
	  	      	</td>				
				<th>Amount</th>
				<td><%=selAMOUNT%></td>	
				<th>Contract No.</th>
                <td class="sm"><input name="radio_number" type="radio" class="trans" checked  Onclick="change_number();" >S/C <!-- 
                 --><input name="radio_number" type="radio" class="trans" Onclick="change_number();" >RFA<!-- 
                  --> <input name="sc_rfa_cd" type="text" style="width:115px;"  value="" maxlength="20" onBlur="setgetUpper(this);number_check(this);" dataformat="engup" ><!-- 
                   --><button type="button" name="" id="" onClick="fn_popup();" class="input_seach_btn"></button>			      
			   	</td>
			   	<td></td>	
			</tr>
		</table>
		
		<table>
			<colgroup>
				<col width="125">
				<col width="50">
				<col width="100">
				<col width="50">
				<col width="50">
				<col width="100">
				<col width="50">
				<col width="50">
				<col width="*">
			</colgroup>			
			<tr class="h23">
				<th>T.VVD</th>
				<td><input  name="trunk_vvd"  type="text" style="width:85px;" onBlur="setgetUpper(this);vvd_check(this)" maxlength="10" dataformat="engup" otherchar=","><!-- 
				 --><button type="button" name="" id="" onClick="so_OnPopupClick('T.VVD');"  class="multiple_inq ir"></button><!-- 
				 --><button type="button" name="" id="" onClick="vvd_OnPopupClick();" class="input_seach_btn"></button>
			 	</td>
				<th>COP No.</th>
				<td><input name="copnumber"  type="text" style="width:123px;" onBlur="setgetUpper(this);val_check(this,'COP NUMBER');" dataformat="engup" otherchar=","><!-- 
				 --><button type="button" name="" id="" onClick="so_OnPopupClick('COP No.');" class="multiple_inq ir"></button>
				</td>					
				<th>Port</th>
				<td>
				    <input type="radio" name="port_io" class="trans" value="A" checked id="port_io" onclick="port_io_click(this);" /><label for="port_io">All</label><input type="radio" name="port_io" class="trans" value="I" id="port_io" onclick="port_io_click(this);" /><label for="port_io">In</label><input type="radio" name="port_io" class="trans" value="O" id="port_io" onclick="port_io_click(this);" /><label for="port_io">Out</label>
				    <input name="port_cd" type="text" style="width:55px;" id="port_cd" dataformat="engup" maxlength="5" /><input name="port_nm" type="text" style="width:93px;" id="port_nm" readonly /><button type="button" id="btns_port" name="btns_port" class="input_seach_btn"></button>
				</td>
				<th>Slot Ref No.</th>
	            <td>
	                <input id="cntr_slt_no" name="cntr_slt_no" type="text" style="width:100px;" dataformat="engup" otherchar=","><!-- 
	                --><button type="button" name="" id="" onClick="so_OnPopupClick('Slot Ref No.');" class="multiple_inq ir"></button>
	            </td>
	            <td></td>
			</tr>
			<tr class="h23">
				<th>Booking No.</th>
				<td>
					<input name="bkgnumber"  type="text" style="width:112px;" onBlur="setgetUpper(this);val_check(this,'BKG NUMBER');" dataformat="engup" otherchar=","><!-- 
				 --><button type="button" name="" id="" onClick="so_OnPopupClick('Booking No.');" class="multiple_inq ir"></button></td>
				<th>B/L No.</th>
				<td><input name="blnumber"  type="text" style="width:123px;" onBlur="setgetUpper(this);val_check(this,'BL NUMBER');" dataformat="engup" otherchar=","><!-- 
				 --><button type="button" name="" id="" onClick="so_OnPopupClick('B/L No.');" class="multiple_inq ir"></button></td>
				<th>Equipment No.</th>
                <td class="sm">	<input name="radio_eq"  type="radio" class="trans" checked  Onclick="change_eqno();">Container&nbsp; 
                				<input name="radio_eq"  type="radio" class="trans" Onclick="change_eqno();">Chassis&nbsp;
                				<input name="radio_eq"  type="radio" class="trans" Onclick="change_eqno();">Genset&nbsp;
                				<input name="eqnumber"  type="text" onBlur="javascript:this.value=this.value.toUpperCase(); " onChange="checkDigit(this)"  style="width:143px;" otherchar=","><!-- 
			 				 --><button type="button" name="" id="" onClick="so_OnPopupClick('EQ No.');" class="multiple_inq ir"></button>
			 	</td>
			 	<td></td>
			</tr>
		</table>
		
		<table>
			<colgroup>
				<col width="125">
				<col width="50">
				<col width="102">
				<col width="50">
				<col width="150">
				<col width="50">
				<col width="100">
				<col width="50">
				<col width="*">
			</colgroup>			
			<tr class="h23">
				<th>Service Order No.</th>
				<td><input name="sonumber" type="text" style="width:112px;" value="<%=sowonumber %>" onChange="setgetUpper(this);" onBlur="val_check(this,'SO NUMBER');" dataformat="engup"  otherchar=","><!-- 
				 --><button type="button" name="" id="" onClick="so_OnPopupClick('SO No.');" class="multiple_inq ir"></button></td>				
				<th>Work Order No.</th>
				<td><input name="wonumber" type="text" style="width:123px;" onChange="setgetUpper(this);"  onBlur="val_check(this,'WO NUMBER');" dataformat="engup"  otherchar=","><!-- 
				 --><button type="button" name="" id="" onClick="so_OnPopupClick('WO No.');" class="multiple_inq ir"></button></td>
				 <th>MTY Reference No.</th>
				<td><input name="mtyrefnumber" type="text" style="width:118px;" onBlur="val_check(this,'MTY Ref No.');" dataformat="engup" otherchar=","><!-- 
				 --><button type="button" name="" id="" onClick="so_OnPopupClick('MTY REF No.');" class="multiple_inq ir"></button></td>					
				<th>Invoice No.</th>
				<td><input name="invoicenumber" type="text" style="width:90px;" dataformat="engupetc" otherchar=","><!-- 
				--><button type="button" name="" id="" onClick="so_OnPopupClick('Invoice No.');" class="multiple_inq ir"></button>
				</td>
				<td></td>				
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry (E) -->
</div>
<!-- wrap_search(E) -->  
</div>
<div id="ButtLayer2" style="display:inline">
	<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		<!-- Content -->
			<button type="button" class="btn_normal" name="btng_frustrate" id="btng_frustrate">Frustrate</button><!-- 
			 --><button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(e) -->

	<!-- opus_design_grid(E) -->	
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
		</div>
	</div>
</div>
<!-- wrap_result(S) -->  

	<!-- opus_design_grid(S) -->
	
	<!-- opus_design_grid(E) -->

<!-- wrap_result(E) -->  
</div>
</form>