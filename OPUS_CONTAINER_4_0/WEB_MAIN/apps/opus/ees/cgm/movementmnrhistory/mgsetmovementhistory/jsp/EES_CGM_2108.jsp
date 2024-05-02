<%--
=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2108.jsp
*@FileTitle  : Bare Mgset Movement Manual Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2016/11/22
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event.EesCgm2108Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.clt.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm2108Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String form_day         = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	
	Logger log = Logger.getLogger("com.clt.apps.MovementMnrHistory.ChassisMovementHistory");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		form_day  = DateTime.getDateString().replace(".","-");


		event = (EesCgm2108Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
                // 1108 Permission 'CGM01','CGM02','CGM03','CGM04'
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

<form name="form"   >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="yd_cd">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="code1">
<input type="hidden" name="chss_mvmt_dt">
 
<input type="hidden" name="eq_knd_cd">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="calend1" value="<%=form_day%>">
<input type="hidden" name="trole" value="<%=tRole%>">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	   
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button>
			<button type="button" class="btn_normal" name="btn_verify" 	id="btn_verify">Verify</button>
			<button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    
	    <!-- page_location(S) -->
	    <div class="location">
	        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	    </div>
	    <!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
				<col width="50px" />
				<col width="100px" />
				<col width="50px" />
				<col width="220px" />
				<col width="120px" />
				<col width="*" />
			</colgroup>
	        <tbody>
				<tr>	
					<th>M.G Set No.</th>
					<td><input type="text" name="eq_no" id="eq_no" style="width:100px;ime-mode:disabled" dataformat="engup" maxlength="10" class="input1" value=""></td>
					<th>Period</th>
					<td><span class="inquiry_calendar"><input type="text" style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='10' class="input1"   name="str_mvmt_dt" value=""><span class="dash">-</span><input type="text" style="width:80px;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input1" value="" name="end_mvmt_dt"><button type="button" class="calendar ir" name="btns_Calendar2" id="btns_Calendar2"></button></span></td>
					<td class="sm">
						<input type="radio" value="S" class="trans" name="str_gubun" checked onclick="javascript:from_Chk()" id="rdo1">
						<label for="rdo1"><strong>Retrieve</strong></label>
						<input type="radio"  name="str_gubun" value="D"class="trans" onclick="javascript:from_Chk()" id="rdo2">
						<label for="rdo2"><strong>Creation</strong></label>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
	        <button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
	        <button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
	        <button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button>
	        <button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	    </div>
	    <!-- opus_design_btn(E) -->
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>