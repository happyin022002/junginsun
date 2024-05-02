<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1007.jsp
*@FileTitle  : Chassis Pool Inquiry/Update
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
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1007Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm1007Event event = null; //PDTO(Data Transfer Object including Parameters)
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
		event = (EesCgm1007Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        UserRoleUtil uru = new UserRoleUtil();
        ComUsrRoleVO[] curv = uru.getUserRole(strUsr_id);
        for(int i=0; i< curv.length; i++)
        {
            if(curv[i].getUsrRoleCd().equals("ENISADM"))
            {
                tRole = "Authenticated";
                break;
            } else if(curv[i].getUsrRoleCd().length() == 5)
            {
                // 1007 Permission 'CGM01','CGM02','CGM04'
                if( curv[i].getUsrRoleCd().equals("CGM01") || curv[i].getUsrRoleCd().equals("CGM02") || curv[i].getUsrRoleCd().equals("CGM04") || curv[i].getUsrRoleCd().equals("CGM05") || curv[i].getUsrRoleCd().equals("CGM99"))
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


<form name="form" onkeyup="ComKeyEnter('search');">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="intg_cd_id" name="intg_cd_id" value="CD02117" type="hidden" />
<input id="eq_knd_cd" name="eq_knd_cd" value="Z" type="hidden" />
<input id="eq_no" name="eq_no" type="hidden" />
<input id="btn_status" name="btn_status" type="hidden" />
<input id="eq_orz_cht_chktype" name="eq_orz_cht_chktype" type="hidden" />
<input id="eq_orz_cht_rcc_cd" name="eq_orz_cht_rcc_cd" type="hidden" />
<input id="eq_orz_cht_lcc_cd" name="eq_orz_cht_lcc_cd" type="hidden" />
<input id="eq_orz_cht_scc_cd" name="eq_orz_cht_scc_cd" type="hidden" />
<input id="chss_pool_cd" name="chss_pool_cd" type="hidden" />
<input id="location" name="location" type="hidden" />
<input id="aciac_div_cd" name="aciac_div_cd" type="hidden" />
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
		--><button type="button" class="btn_normal" name="btn_update" id="btn_update">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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
					<col width="120px"/>
					<col width="70px"/>
					<col width="150px"/>
					<col width="70px"/>
					<col width="180px"/>
					<col width="70px"/>
					<col width="50px"/>
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Pool Name</th>
					<td><script type="text/javascript">ComComboObject('combo_chss_pool_cd', 1, 70, 0, 1, 0, true);</script></td>
					<th>Location</th>
					<td><script type="text/javascript">ComComboObject('combo_location', 1, 50, 0, 1, 0, true);</script><input type="text" style="ime-mode:disabled;width: 50;" class="input" dataformat="engup" name="scc_cd"><button type="button" class="input_seach_btn" id="btn_popup" name="ComOpenPopupWithTargetLoc"></button></td>
					<th>Yard</th>
					<td><input id="crnt_yd_cd" dataformat="engup" style="width: 130px; ime-mode:disabled" class="input" name="crnt_yd_cd" type="text" /><button type="button" id="btn_popup" name="ComOpenPopupWithTargetYard" class="input_seach_btn"></button></td>
					<th>Active St.</th>
					<td><script type="text/javascript">ComComboObject('combo_aciac_div_cd', 1, 144, 0, 1, 0, true);</script></td>
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
					<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
					<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
					<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
<!-- opus_design_grid(E) -->
</div>

 </form>
<form name="form2">
<input id="sXml" name="sXml" value="<%=xml.replace(" \"","'") %>" type="hidden" />
</form>