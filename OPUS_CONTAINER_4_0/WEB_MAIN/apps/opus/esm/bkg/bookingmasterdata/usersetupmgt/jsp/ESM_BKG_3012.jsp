<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_3012.js
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList = "";
	
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");
	String bl_esig_asgn_seq = "";	
	String bl_esig_seq = "";	
	try {
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
	
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
		
		log.debug("====================================");
		bl_esig_asgn_seq = StringUtil.xssFilter((String)request.getParameter("bl_esig_asgn_seq")) == null ? "":StringUtil.xssFilter((String)request.getParameter("bl_esig_asgn_seq"));
		bl_esig_seq = StringUtil.xssFilter((String)request.getParameter("bl_esig_seq")) == null ? "":StringUtil.xssFilter((String)request.getParameter("bl_esig_seq"));		
		log.debug("+++++++++++++ " + bl_esig_asgn_seq);
		log.debug("+++++++++++++ " + bl_esig_seq);
		log.debug("====================================");
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="act_flg">
<input type="hidden" name="bl_esig_asgn_seq" value="<%= bl_esig_asgn_seq %>">
<input type="hidden" name="bl_esig_seq" value="<%= bl_esig_seq %>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><img src="img/icon_title_dot.gif" align="absmiddle"> <span>Place of Issue Association ( ESM_BKG_3012 )</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_save" 	id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_close"  id="btn_close">Close</button>	
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_grid clear" >
	<div class="opus_design_data wFit">
        <table height="350px">
           <colgroup>
               <col width="250px">
               <col width="*">
           </colgroup>
           <tbody>
                <tr align="left">
                    <th><span style="color:red;">*</span> Place of Issue Code</th>
                    <td><input type="text" name="bl_iss_ofc_cd" style="width:100px" value="" dataformat="engup" otherchar=" -._/" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" required></td>
                </tr>
                <tr align="left">
                    <th><span style="color:red;">*</span> Place of Issue Name</th>
                    <td><input type="text" name="bl_iss_ofc_nm" style="width:200px" value="" style="ime-mode:disabled"  otherchar=" -._/" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" required></td>
                </tr> 
                <tr align="left">
                    <th><span style="color:red;">*</span> Country</th>
                    <td><script type="text/javascript">ComComboObject('cnt_cd', 2, 200, 0, 1);</script></td>                    
                </tr>
                <tr align="left">
                    <th><span style="color:red;">*</span> Agent's Company Name Clause(Line 1)</th>
                    <td><input type="text" name="agn_co_nm1" style="width:200px" value="" style="ime-mode:disabled"  otherchar=" -._/" maxlength="35" onKeyUp="ComKeyEnter('LengthNextFocus');" required></td>
                </tr>
                <tr align="left">  
                    <th>&nbsp;&nbsp;Agent's Company Name Clause(Line 2)</th>
                    <td><input type="text" name="agn_co_nm2" style="width:200px" value="" style="ime-mode:disabled"  otherchar=" -._/" maxlength="35" onKeyUp="ComKeyEnter('LengthNextFocus');" ></td>
                </tr>
                <tr align="left">
                    <th>&nbsp;&nbsp;Agent's Company Name Clause(Line 3)</th>
                    <td><input type="text" name="agn_co_nm3" style="width:200px" value="" style="ime-mode:disabled"  otherchar=" -._/" maxlength="35" onKeyUp="ComKeyEnter('LengthNextFocus');" ></td>
                </tr>	
                <tr align="left">
                    <th><span style="color:red;">*</span> Issuing Office's Employee</th>
                    <td><script type="text/javascript">ComComboObject('employee', 2, 200, 0, 1);</script></td>                    
                </tr>     
                <tr align="left">
                    <th colspan="2" style="padding-bottom: 10px; padding-top: 10px;">
                    	&nbsp;&nbsp;Signed&nbsp;&nbsp;<input type="checkbox" id="bl_esig_flg" name="bl_esig_flg" value="Y" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	&nbsp;&nbsp;Signed Copy&nbsp;&nbsp;<input type="checkbox" id="bl_cpy_esig_flg" name="bl_cpy_esig_flg" value="Y"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    	&nbsp;&nbsp;Counting Original&nbsp;&nbsp;<input type="checkbox" id="bl_knt_flg" name="bl_knt_flg" value="Y"/>
                    	
                    </th>
                </tr>  
				<tr align="left">
					<th>&nbsp;&nbsp;Notes<br>&nbsp;&nbsp;Maximum of <br>&nbsp;&nbsp;300 characters</th>
					<td><textarea style="width:100%; ime-mode:disabled;" name="bl_esig_rmk" id="bl_esig_rmk" cols="100" rows="10" class="noinput" maxlength="300"></textarea></td>
				</tr>                                                                              
            </tbody>
        </table>	
    </div>    
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">

</div>

<!-- opus_design_grid(E) -->
<!--IBUpload Component (S) -->
<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!--IBUpload Component (E) -->
<div id="hiddenLayer" style="display:none">
	<script language="javascript">ComSheetObject('sheet1');</script>  
</div>
</form>
