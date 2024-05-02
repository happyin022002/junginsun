<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2001
*@FileTitle  : M.G.Set Model Creation
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2001Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm2001Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply

	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm2001Event) request.getAttribute("Event");
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
                // 2001 Permission 'CGM01','CGM02'
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
<input type="hidden" name="eq_spec_no_dup" id="eq_spec_no_dup" />
<input type="hidden" name="eq_spec_no" id="eq_spec_no" />
<input type="hidden" name="trole" value="<%=tRole%>" id="trole" />

<!-- developer working -->

<input type="hidden" style="width: 60px; text-align: center; ime-mode:disabled" class="input2" maxlength="1" readonly name="eq_knd_cd" value="G" id="eq_knd_cd" />
<input type="hidden" style="width: 60px; text-align: center; ime-mode:disabled" class="input2" maxlength="1" readonly name="page_status" id="page_status" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn"><!-- 
		--><button class="btn_accent" name="Retrieve" id="Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="New" id="New" type="button">New</button><!--
		--><button class="btn_normal" name="Save" id="Save" type="button">Save</button><!--
		--><button class="btn_normal" name="Delete" id="Delete" type="button">Delete</button><!--
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="1"/>
				<col width="*" />				
		  	</colgroup> 
		   	<tr>
		   		<th>Model No.</th>
				<td><script type="text/javascript">ComComboObject('cmb_eq_spec_no', 1, 378, 1, 1, 0, true);</script></td>
		   	</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>



<div class="wrap_result">
	<h3 class="title_s">M.G.Set No.</h3>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
		<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;">
	<!-- <div class="opus_design_grid"> -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry ">
		<table>
			<colgroup>
				<col width="50"/>
				<col width="*" />				
		  	</colgroup>
			<tr>
				<th>Maker</th>
				<td width=""><script type="text/javascript">ComComboObject('vndr_seq', 1, 390, 1, 1, 0, true);</script></td>
			</tr>
			<tr>
				<th>Type</th>
				<td width=""><script type="text/javascript">ComComboObject('eq_tpsz_cd', 1, 80, 1, 1, 0, true);</script></td>
			</tr>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<colgroup>
				<col width="70"/>
				<col width="200"/>
				<col width="30"/>
				<col width="50"/>
				<col width="*" />				
		  	</colgroup>
			<tr>
				<th class="sm">Voltage</th>
				<td class="sm">	<input type="radio" class="trans" name="mgst_vltg_capa" id="mgst_vltg_capa" onclick="obj_onclick();"/> 220 <input type="radio" class="trans" name="mgst_vltg_capa" id="mgst_vltg_capa" onclick="obj_onclick();"/> 440</td>
				<td></td>
				<th>Fuel Capacity</th>
				<td><input type="text" style="width: 60px; text-align: right; ime-mode:disabled" class="input" name="mgst_fuel_capa" maxlength="15" dataformat="int" id="mgst_fuel_capa" /> ltrs</td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	
</div>
</form>