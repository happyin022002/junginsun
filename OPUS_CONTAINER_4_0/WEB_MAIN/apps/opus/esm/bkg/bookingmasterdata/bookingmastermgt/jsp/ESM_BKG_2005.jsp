<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_2004.jsp
*@FileTitle  : Hard Coding Contents
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg2005Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg2005Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String strhrd_cdg_id = "";
	String[] attr_nm = {"","","","","","","","","",""};
	

	Logger log = Logger
			.getLogger("com.clt.apps.BookingMasterData.BookingMasterData");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg2005Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);


		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
		request.setCharacterEncoding("euc-kr");
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strhrd_cdg_id = JSPUtil.getNull(request.getParameter("hrd_cdg_id"));
		for(int i=0; i<10; i++){
			attr_nm[i] = JSPUtil.getNull(request.getParameter("attr_nm"+(i+1)));
		}


	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="attr_nm1" value="<%=attr_nm[0]%>" id="attr_nm1" />
<input type="hidden" name="attr_nm2" value="<%=attr_nm[1]%>" id="attr_nm2" />
<input type="hidden" name="attr_nm3" value="<%=attr_nm[2]%>" id="attr_nm3" />
<input type="hidden" name="attr_nm4" value="<%=attr_nm[3]%>" id="attr_nm4" />
<input type="hidden" name="attr_nm5" value="<%=attr_nm[4]%>" id="attr_nm5" />
<input type="hidden" name="attr_nm6" value="<%=attr_nm[5]%>" id="attr_nm6" />
<input type="hidden" name="attr_nm7" value="<%=attr_nm[6]%>" id="attr_nm7" />
<input type="hidden" name="attr_nm8" value="<%=attr_nm[7]%>" id="attr_nm8" />
<input type="hidden" name="attr_nm9" value="<%=attr_nm[8]%>" id="attr_nm9" />
<input type="hidden" name="attr_nm10" value="<%=attr_nm[9]%>" id="attr_nm10" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title"><span>Hard Coding Contents</span></h2>
    <!-- page_title(E) -->
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_Save" id="btn_Save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_Close"   id="btn_Close">Close</button>
    </div>
    <!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <table>
             <colgroup>
                <col width="30"  />
                <col width="*" />
            </colgroup>
            <tbody>
				<tr>
					<th>ID</th>
					<td><input type="text" style="width:150px; ime-mode:disabled" name="hrd_cdg_id" id="hrd_cdg_id" class="input" maxlength="20" readOnly value="<%=strhrd_cdg_id%>"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid">

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_Copy" id="btn_Copy">Copy</button><!-- 
             --><button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!-- 
              --><button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button>
        </div>
        <!-- opus_design_btn(E) -->
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
