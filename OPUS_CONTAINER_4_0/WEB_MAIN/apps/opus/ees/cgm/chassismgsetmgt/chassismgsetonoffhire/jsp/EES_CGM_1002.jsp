<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1002.jsp
*@FileTitle  : Chassis Specification Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1002Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm1002Event event = null; //PDTO(Data Transfer Object including Parameters)
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
		event = (EesCgm1002Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        UserRoleUtil uru = new UserRoleUtil();
        ComUsrRoleVO[] curv = uru.getUserRole(strUsr_id);
        for (int i=0; i< curv.length; i++)
        {
            if(curv[i].getUsrRoleCd().equals("ENISADM"))
            {
                tRole = "Authenticated";
                break;
            } else if(curv[i].getUsrRoleCd().length() == 5)
            {
                if(curv[i].getUsrRoleCd().equals("CGM01"))
                {
                    tRole = "Authenticated";
                    break;
                }
            }else
            {
                tRole = "Not Authenticated";
            }
        }
	} catch (Exception e) {
		out.println(e.toString());
	}
    String eq_spec_no =  StringUtil.xssFilter(request.getParameter("eq_spec_no"));
    if(eq_spec_no == null) eq_spec_no = "";
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="ofc_cd" name="ofc_cd" type="hidden" />
<input id="eq_knd_cd" name="eq_knd_cd" value="Z" type="hidden" />
<input id="param_eq_spec_no" name="param_eq_spec_no" value="<%=eq_spec_no %>" type="hidden" />
<input id="trole" name="trole" value="<%=tRole%>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<h3 class="title_design" style="margin-bottom:2px;">Inquiry</h3>
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
					<col width="12px"/>
					<col width="100px"/>
					<col width="370px"/>
					<col width="*" />
				</colgroup>
				<tr>
					<td class="sm"></td>
					<th class="sm">Spec. No. & TP/SZ</th>
					<td class="sm"><script type="text/javascript">ComComboObject('eq_spec_no', 2, 350, 1, 0, 0, false);</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
					
<!-- opus_design_inquiry(S) -->
	<h3 class="title_design" style="margin-bottom:2px;">Creation</h3>
	<div class="opus_design_inquiry sm" style="width: 490px;">
		<table>
			<tbody>
			<colgroup>
					<col width="10"/>
					<col width="100"/>
					<col width="400"/>
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Specification No.</th>
					<td><input id="eq_spec_no_ins" style="text-align: left ; width: 350px; ime-mode:disabled" maxlength="20" class="input1" name="eq_spec_no_ins" type="text" /></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>Chassis Type/Size</th>
					<td><script type="text/javascript">ComComboObject('eq_tpsz_cd', 1, 80, 1, 1, 0, false);</script></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>Manufacturer</th>
					<td><script type="text/javascript">ComComboObject('vndr_seq', 1, 350, 1, 1, 0, false);</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<div class="opus_design_data">
			<h3 class="title_design" style="margin-bottom:2px;">Weight</h3>
			<table style="width: 470px;" class="grid_2">
				<tr>
					<th>Tare Weight</th>
					<td><input id="chss_tare_wgt" style="text-align:right;width: 70px;" maxlength="6" class="input" name="chss_tare_wgt" dataformat="int" type="text" />  kg</td>
					<td><input id="chss_tare_wgtlb" style="text-align:right;width: 70px;" maxlength="6" name="chss_tare_wgtlb" dataformat="int" type="text" />  lbs</td>
				</tr>
				<tr>
					<th>Payload</th>
					<td><input id="chss_payld_wgt" style="text-align:right;width: 70px;" maxlength="6" class="input" name="chss_payld_wgt" dataformat="int" type="text" />  kg</td>
					<td><input id="chss_payld_wgtlb" style="text-align:right;width: 70px;" maxlength="6" name="chss_payld_wgtlb" dataformat="int" type="text" />  lbs</td>
				</tr>
				<tr>
					<th>Gross Weight</th>
					<td><input id="gross_wgt" style="text-align:right;width: 70px;" maxlength="6" class="input2" name="gross_wgt" dataformat="int" readonly="readonly" type="text"/>  kg</td>
					<td><input id="gross_wgtlb" style="text-align:right;width: 70px;" maxlength="6" class="input2" name="gross_wgtlb" dataformat="int" readonly="readonly" type="text"/>  lbs</td>
				</tr>
			</table>
			<h3 class="title_design" style="margin-bottom:2px;">Dimension</h3>
			<table style="width: 470px;" class="grid_2">
				<tr>
					<th>Length</th>
					<td>
						<input id="chss_ttl_dim_len" style="text-align:right;width: 70px;" maxlength="6" name="chss_ttl_dim_len" dataformat="int" type="text" />mm
					</td>
					<td>
						<input id="chss_ttl_dim_len_ft" style="text-align:right;width: 30px;" maxlength="6" class="input" name="chss_ttl_dim_len_ft" dataformat="int" type="text" />ft
						<input id="chss_ttl_dim_len_in" style="text-align:right;width: 30px;" maxlength="6" class="input" name="chss_ttl_dim_len_in" dataformat="int" type="text" />in
					</td>
				</tr>
				<tr>
					<th>Width</th>
					<td>
						<input id="chss_ttl_dim_wdt" style="text-align:right;width: 70px;" maxlength="6" name="chss_ttl_dim_wdt" dataformat=int type="text" />mm
					<td>
						<input id="chss_ttl_dim_wdt_ft" style="text-align:right;width: 30px;" maxlength="6" class="input" name="chss_ttl_dim_wdt_ft" dataformat="int" type="text" />ft
						<input id="chss_ttl_dim_wdt_in" style="text-align:right;width: 30px;" maxlength="6" class="input" name="chss_ttl_dim_wdt_in" dataformat="int" type="text" />in
					</td>
				</tr>
				<tr>
					<th>Height</th>
					<td>
						<input id="chss_ttl_dim_hgt" style="text-align:right;width: 70px;" maxlength="5" name="chss_ttl_dim_hgt" dataformat="int" type="text" />mm
					<td>
						<input id="chss_ttl_dim_hgt_ft" style="text-align:right;width: 30px;" maxlength="6" class="input" name="chss_ttl_dim_hgt_ft" dataformat="int" type="text" />ft
						<input id="chss_ttl_dim_hgt_in" style="text-align:right;width: 30px;" maxlength="6" class="input" name="chss_ttl_dim_hgt_in" dataformat="int" type="text" />in
					</td>
				</tr>
			</table>
		</div>
	</div>
<!-- opus_design_inquiry(E) -->					
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	        <div class="opus_design_grid wFit" style="display: none;">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<form name="form2" id="form2">
<input id="sXml" name="sXml" value="<%=xml.replace(" \"","'") %>" type="hidden" />
</form>