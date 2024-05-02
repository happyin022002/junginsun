<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0193.jsp
*@FileTitle  : EQ Component 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0193Event"%>
<%@ page import="org.apache.log4j.Logger" %>
  	 
<%
	EesMnr0193Event  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//서버에서 발생한 에러
 	String strErrMsg = "";	 					//에러메세지
 	 
 	String strUsr_id		= "";     
 	String strUsr_nm		= "";      
	   		  
 	String recEqKndCd = ((request.getParameter("rec_eq_knd_cd")==null )?"":request.getParameter("rec_eq_knd_cd"));
 	String recKeyValue = ((request.getParameter("rec_key_value")==null )?"":request.getParameter("rec_key_value"));
 	   
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();
	  	   	     
 		event = (EesMnr0193Event)request.getAttribute("Event");
 		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
			 
 		if (serverException != null) { 
 			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
 		}  
 	}catch(Exception e) {    
 		out.println(e.toString());
 	}
 %>
   
<script language="javascript">
	function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();  
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">    
<input type="hidden" name="f_type">       
<input type="hidden" name="pagerows">    
<input type="hidden" name="rec_eq_knd_cd" value="<%=recEqKndCd%>">   
<input type="hidden" name="rec_key_value" value="<%=recKeyValue%>">   
<!-- 개발자 작업	-->

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Location Code Inquiry</span></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">OK</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
</div>
<!-- page_title_area(E) -->
 
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<!--     inquiry_area(S) -->
    <div class="wrap_search">
    <div class="opus_design_inquiry wFit">
<!--          biz_1 (S) -->
        <table>
            <colgroup>
                <col width="60"  />
                <col width="120" />
                <col width="120" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>EQ Type</th>      	
					<td><script language="javascript">ComComboObject('eq_knd_cd',1,104,1,1,0,false,0);</script></td>
					<th>1st Location Code</th>	
					<td width=""><script language="javascript">ComComboObject('key_value',2,180,1,1)</script>
                </tr>
            </tbody>
        </table>
<!--          biz_1 (E)    -->
    </div>
    </div>
<!--     opus_design_inquiry(E) -->

<!--     opus_design_grid(S) -->
    <div class="wrap_result">
    	<div class="layout_vertical_4" style="width:24%; margin-right:1%">
    		<div class="grid_option_left"><h3 class="title_design">1st Location Code</h3></div>
    	
        	<script language="javascript">ComSheetObject('sheet1');</script>
    	</div>    
    
	    <div class="layout_vertical_4" style="width:24%; margin-right:1%">
	    	<div class="grid_option_left"><h3 class="title_design">2st Location Code</h3></div>
	    
	        <script language="javascript">ComSheetObject('sheet2');</script>
	    </div>	    
	    
	    <div class="layout_vertical_4" style="width:24%; margin-right:1%">
	    	<div class="grid_option_left"><h3 class="title_design">3st Location Code</h3></div>
	    
	        <script language="javascript">ComSheetObject('sheet3');</script>
	    </div>	    
	    
	    <div class="layout_vertical_4" style="width:25%;">
	    	<div class="grid_option_left"><h3 class="title_design">4st Location Code</h3></div>
	    
	        <script language="javascript">ComSheetObject('sheet4');</script>
	    </div>   
    
	</div>
<!--     opus_design_grid(E) -->
</div>
<!-- popup_contens_area(E) -->
<!-- page(E) -->

<!-- 개발자 작업  끝 -->  
</form>