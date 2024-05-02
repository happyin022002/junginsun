<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2004.jsp
*@FileTitle  : Own M.G.Set Master Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2004Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm2004Event event     = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg          = ""; //error message
	int rowCount              = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply

	Logger log       = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm2004Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        //chungpa 20100304 transaction role apply start
        UserRoleUtil uru = new UserRoleUtil();
        ComUsrRoleVO[] curv = uru.getUserRole(strUsr_id);
        for(int i=0; i< curv.length; i++)
        {
            //System.out.println("chungpa priority>>>>" + curv[i].getUsrRoleCd());
            if(curv[i].getUsrRoleCd().equals("ENISADM"))
            {
                tRole = "Authenticated";
                break;
            }else if(curv[i].getUsrRoleCd().length() == 5)
            {
                // 2004 Permission 'CGM01','CGM02'
                if( curv[i].getUsrRoleCd().equals("CGM01")
                    || curv[i].getUsrRoleCd().equals("CGM02")
                    //|| curv[i].getUsrRoleCd().equals("CGM03")
                    //|| curv[i].getUsrRoleCd().equals("CGM04")
                    //|| curv[i].getUsrRoleCd().equals("CGM05")
                    //|| curv[i].getUsrRoleCd().equals("CGM99")
                )
                {
                    tRole = "Authenticated";
                    break;
                }
            }else
            {
                tRole = "Not Authenticated";
            }
        }
        //chungpa 20100304 transaction role apply end
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="trole" value="<%=tRole%>" id="trole" />

<!-- developer working -->

<input type="hidden" class="input2" style="width:50px;text-align:center" name="eq_knd_cd" value="G" id="eq_knd_cd" />
<input type="hidden" class="input2" style="width:50px;text-align:center" name="page_status" id="page_status" />
<input type="hidden" class="input2" style="width:120px;text-align:center" name="eq_lot_no_tmp" id="eq_lot_no_tmp" />
<input type="hidden" class="input2" style="width:130px;text-align:center" name="eq_spec_no_tmp" id="eq_spec_no_tmp" />
<input type="hidden" class="input2" style="width:50px;text-align:center" name="agmt_ver_no" id="agmt_ver_no" />
<input type="hidden" class="input2" style="width:50px;text-align:center" name="agmt_ofc_cty_cd" id="agmt_ofc_cty_cd" />
<input type="hidden" class="input2" style="width:50px;text-align:center" name="agmt_seq" id="agmt_seq" />
<input type="hidden" class="input2" style="width:100px;text-align:center" name="agmt_no" id="agmt_no" />
<input type="hidden" name="vndr_seq_agree" id="vndr_seq_agree" />
<input type="hidden" name="eq_tpsz_cd" id="eq_tpsz_cd" />
<input type="hidden" name="eq_lot_iss_dt" id="eq_lot_iss_dt" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="100"/>				
				<col width="*" />				
		   	</colgroup> 
		   <tr>
		   		<th>M.G.Set Serial Range</th>
				<td><script type="text/javascript">ComComboObject('mgset_range', 1, 220, 1, 0 ,0, true);</script></td>	
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="100"/>				
				<col width="*" />				
		   	</colgroup> 
			<tr>
				<th>Serial Range</th>
				<td>
					<input type="text" style="width:50px;ime-mode:disabled; text-align: center" class="input" dataformat="engup" maxlength="4" name="eq_pfx_cd" id="eq_pfx_cd" /><!-- 
				 --><input type="text" style="width:60px;ime-mode:disabled; text-align: Right" class="input" dataformat="num" maxlength="6" name="fm_ser_no" id="fm_ser_no" /><!-- 
				 --><input type="text" style="width:60px;ime-mode:disabled; text-align: Right" class="input" dataformat="num" maxlength="6" name="to_ser_no" id="to_ser_no" /><!-- 
				 --><input type="text" style="width:70px;ime-mode:disabled; text-align: Right" class="input2" name="units" readonly id="units" /><label>Unit(s)</label>
				</td>
			</tr>
			<tr>
				<th>Model No.</th>
				<td><script type="text/javascript">ComComboObject('eq_spec_no', 1, 368, 1, 1, 0, true);</script></td>
			</tr>
			<tr>
				<th>Maker</th>
				<td width=""><input type="text" style="width: 368px; text-align: left" class="input2" name="vndr_lgl_eng_nm_eqspec" readonly id="vndr_lgl_eng_nm_eqspec" /></td>
			</tr>
			<tr>
				<th>Voltage</th>
				<td>
					<input type="text" style="width: 60px; text-align: Right" class="input2" name="mgst_vltg_capa" readonly id="mgst_vltg_capa" /><label>Volt </label>
				</td>
			</tr>
			<tr>
				<th>Fuel Capacity</th>
				<td>
					<input type="text" style="width: 60px; text-align: Right" class="input2" name="mgst_fuel_capa" readonly id="mgst_fuel_capa" /><label>ltrs</label>
				</td>
			</tr>
			<tr>
				<th>Delivery Month</th>
				<td>
					<input type="text" name="de_yrmon" style="width:100px; ime-mode:disabled; text-align:center;" dataformat="ym"  class="input1" maxlength="7" id="de_yrmon" /><!-- 
				  --><button type="button" id="btn_Calendar_b" name="btn_Calendar_b" class="calendar ir btn_img"></button>
				</td>
			</tr>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>				
		<table>
			<colgroup>
				<col width="100"/>				
				<col width="*" />				
		   	</colgroup> 
			<tr>
				<th>Agreement No.</th>
				<td>
					<input type="text" style="width:100px;ime-mode:disabled; text-align:center;" dataformat="engup" class="input1" name="agreement_no" maxlength="9" id="agreement_no" /><!-- 
				--><button type="button" id="btn_ComOpenPopupWithTargetAgree" name="btn_ComOpenPopupWithTargetAgree" class="input_seach_btn btn_img"></button>
				</td>
			</tr>
			<tr>
				<th>Lease Term</th>
				<td width="">
					<input type="text" style="width: 100px; text-align: center" class="input2" name="agmt_lstm_cd" readonly id="agmt_lstm_cd" />
				</td>
			</tr>
			<tr>
				<th>Office</th>
				<td width="">
					<input type="text" style="width: 100px;text-align: center" class="input2" name="agmt_iss_ofc_cd" readonly id="agmt_iss_ofc_cd" />
				</td>
			</tr>
			<tr>
				<th>Date</th>
				<td width=""><input type="text" name="cre_dt" style="width:100px;text-align: center;ime-mode:disabled; text-align:center;" dataformat="ymd"  class="input2" maxlength="8" readonly id="cre_dt" /></td>
			</tr>
			<tr>
				<th>Financier</th>
				<td width="" style="padding-left:2"><script type="text/javascript">ComComboObject('financier', 1, 368, 1, 0, 0, true);</script></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;" id="tabLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
		<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;" id="tabLayer">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
