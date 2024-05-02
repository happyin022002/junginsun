<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1109.jsp
*@FileTitle  : Chassis Movement Update by Container
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event.EesCgm1109Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%
	EesCgm1109Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String p_cntrno         = "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	
	Logger log = Logger.getLogger("com.clt.apps.MovementMnrHistory.ChassisMovementHistory");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		p_cntrno  = StringUtil.xssFilter(request.getParameter("p_cntrno"));

		event = (EesCgm1109Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		if(p_cntrno != null && !"".equals(p_cntrno)){
// 			p_cntrno = p_cntrno.substring(0,11);
		} else {
			p_cntrno = "";
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
                // 1109 Permission 'CGM01','CGM02','CGM03','CGM04'
                if( curv[i].getUsrRoleCd().equals("CGM01")
                    || curv[i].getUsrRoleCd().equals("CGM02")
                    || curv[i].getUsrRoleCd().equals("CGM03")
                    || curv[i].getUsrRoleCd().equals("CGM04")
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
	}catch(Exception e) {
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eq_no" id="eq_no" />
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" />
<input type="hidden" name="from_dt" id="from_dt" />
<input type="hidden" name="to_dt" id="to_dt" />
<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="chss_no" id="chss_no" />
<input type="hidden" name="eq_tpsz_cd" id="eq_tpsz_cd" />
<input type="hidden" name="cntr_tpsz" id="cntr_tpsz" />
<input type="hidden" name="trole" value="<%=tRole%>" id="trole" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
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
			<colgroup>
				<col width="1" />
			</colgroup>
			<tbody>
				<tr>
					<th>Container No.</th>
					<td><input type="text" style="width:85px;ime-mode:disabled;" tabindex="1" name="p_cntrno" dataformat="engup" class="input1" value="<%=p_cntrno %>" maxlength="11" id="p_cntrno" onchange="obj_keyup()"/><!-- 
					-->
<!-- 					<input type="text" style="width:18px;" class="input2" name="check_digit" tabindex="2" readonly="readonly" id="check_digit" /> -->
					<!-- 
					--><input type="text" style="width:30px;" class="input2" value="" name="ctnr_tpsz_cd" readonly="readonly" id="ctnr_tpsz_cd" /> </td>
				</tr> 
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_area(E) -->


<!-- result_area(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
		<table><tr><td><h3 class="title_design mar_btm_8">VVD History</h3></td></tr></table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
		<table><tr><td><h3 class="title_design mar_btm_8">Movement History (Update)</h3></td></tr></table>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- result_area(E) -->
<!-- developer working end -->
</form>