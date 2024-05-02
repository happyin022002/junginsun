<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1006.jsp
*@FileTitle  : Chassis Registration Inquiry/Update 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1006Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm1006Event event = null; //PDTO(Data Transfer Object including Parameters)
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
		event = (EesCgm1006Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        UserRoleUtil uru = new UserRoleUtil();
        ComUsrRoleVO[] curv = uru.getUserRole(strUsr_id);
        for(int i=0; i< curv.length; i++)
        {
            //System.out.println("chungpa priority>>>>" + curv[i].getUsrRoleCd());
            if(curv[i].getUsrRoleCd().equals("ENISADM"))
            {
                tRole = "Authenticated";
                break;
            } else if(curv[i].getUsrRoleCd().length() == 5)
            {
                // 1006 Permission 'CGM01','CGM02'
                if( curv[i].getUsrRoleCd().equals("CGM01") || curv[i].getUsrRoleCd().equals("CGM02"))
                {
                    tRole = "Authenticated";
                    break;
                }
            } else
            {
                tRole = "Not Authenticated";
            }
        }
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


<form name="form2" id="form2"><input id="sXml" name="sXml" value="<%=xml.replace(" \"","'") %>" type="hidden" /></form>
<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="eq_knd_cd" name="eq_knd_cd" value="Z" type="hidden" />
<input id="eq_no_tmp" name="eq_no_tmp" type="hidden" />
<input id="chss_als_no" name="chss_als_no" type="hidden" />
<input id="chss_rgst_lic_noa" name="chss_rgst_lic_noa" type="hidden" />
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
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
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
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
					<col width="10px"/>
					<col width="70px"/>
					<col width="220px"/>
					<col width="70px"/>
					<col width="150px"/>
					<col width="70px"/>
					<col width="180px"/>
					<col width="70px"/>
					<col width="50px"/>
					<col width="50px"/>
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Chassis No.</th>
					<td><input id="eq_no_fm" style="ime-mode: disabled; width:90px;" class="input1" maxlength="10" dataformat="engup" name="eq_no_fm" type="text" />- <input type="text" style="ime-mode: disabled; width: 60px;" class="input1" maxlength="6"  dataformat="num" name="eq_no_to"></td>
					<th>License No.</th>
					<td><input id="chss_rgst_lic_no" style="ime-mode: disabled; width: 100px;" class="input" maxlength="12" name="chss_rgst_lic_no" type="text" /></td>
					<th>Vehicle ID No.</th>
					<td><input id="chss_veh_id_no" style="ime-mode: disabled; width: 130px;" class="input" maxlength="20" name="chss_veh_id_no" type="text" /></td>
					<th>Expire Year</th>
					<td><input id="chss_rgst_exp_dt" name="chss_rgst_exp_dt" dataformat="num" maxlength="4" style="width: 50px; text-align:center;" class="input" value="" type="text" /></td>
					<th>and older</th>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
 <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
            <div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button>
				<button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
				<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
				<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
<!-- opus_design_grid(E) -->
</div>

</form>