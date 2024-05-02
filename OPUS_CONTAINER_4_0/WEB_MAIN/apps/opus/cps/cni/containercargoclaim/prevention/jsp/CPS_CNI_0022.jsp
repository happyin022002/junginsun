<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0022.jsp
*@FileTitle  : [CPS_CNI_0022] Prevention
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	CpsCni0022Event event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0; 

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
    
    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
    SignOnUserAccount account = null;
    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0022Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

       

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------    
    String sXml = HttpUtil.makeXML(request,response);
    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    String cre_dt_start = (String)eventResponse.getCustomData("cre_dt_start");
    String cre_dt_end = (String)eventResponse.getCustomData("cre_dt_end");
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();
%>


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.prevention.event.CpsCni0022Event"%><html>
<head>
<title>Prevention-Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="sXml" id="sXml"  value="<%=sXml%>"/>
<input type="hidden" name="usr_id" id="usr_id"  value="<%=userId%>"/>
<input type="hidden" name="usr_roles"  id="usr_roles" value="<%=roles%>"/>
<input type="hidden" name="usr_area" id="usr_area" value="<%=area%>" />
<input type="hidden" name="usr_office"  id="usr_office" value="<%=ofcCd%>"/>
<!-- 개발자 작업 -->
<input type="hidden" name="insur_clm_pty_no" id="insur_clm_pty_no" />
<input type="hidden" name="cgo_clm_sts_cd" id="cgo_clm_sts_cd" />
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
		<button type="button" class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_New" id="btn1_New">New</button>
<%-- 		  <% if (!CniUtil.equalsRole(account , "CNI49")) { %> --%>
                    <button type="button" class="btn_normal" name="btn1_Delete" id="btn1_Delete">Delete</button>
<%--                 <% } %>        --%>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
 <!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
<div class= "opus_design_inquiry wFit">
	<!-- layout_wrap(S) -->
      <table>
		<tbody>
			<colgroup>
				<col width="200">
				<col width="145">
				<col width="45">
				<col width="*">
			</colgroup>       
            <tr>
             	<td><input type="text" name="cond_search_text" style="width:200px;" value="" class="input" id="cond_search_text" /> </td>
                <td><button type="button" class="btn_etc" name="btn2_Search" id="btn2_Search">Retrieve</button></td>
                <th>DORG</th>
                <td><input type="text" name="cre_dt_start" value="<%=cre_dt_start%>" caption="DORG" dataformat="ymd" required="" maxlength="10" style="ime-mode:disabled" class="input1" id="cre_dt_start" /><button type="button" id="btns_cre_dt_start" name="btns_cre_dt_start" class="calendar ir"></button>~&nbsp;<input type="text" name="cre_dt_end" value="<%=cre_dt_end%>" caption="DORG" dataformat="ymd" maxlength="10" style="ime-mode:disabled" required="" class="input1" id="cre_dt_end" /><button type="button" id="btns_cre_dt_end" name="btns_cre_dt_end" class="calendar ir"></button></td>                
            </tr>
          </tbody>
     	</table>
      	<table>
		<tbody>
			<colgroup>
				<col width="45">
				<col width="155">
				<col width="100">
				<col width="120">
				<col width="70">
				<col width="60">
				<col width="70">
				<col width="80">
				<col width="68">
				<col width="*">
			</colgroup>       
            <tr>
                <th>CLASS</th>
                <td><script type="text/javascript">ComComboObject("combo1", 1, 153, 1);</script><input type="hidden" name="clm_prve_div_cd" id="clm_prve_div_cd" /></td>
                <th>PRV No.</th>
                <td><input type="text" name="clm_prve_no" style="width:120px;text-align: center;" class="input" id="clm_prve_no" /></td>
                <th>Area</th>
                <td><select style="width:60px;" name="clm_area_cd" id="clm_area_cd"></select></td>
                <th>RGOFC</th>
                <td><input type="text" name="cre_ofc_cd" style="width:80px;" value=" " class="input" id="cre_ofc_cd" /> </td>
                <th>Register</th>
                <td><input type="text" name="cre_usr_id" style="width:80px;" value=" " class="input" id="cre_usr_id" /> </td>
            </tr>
            </tbody>
       </table> 
    </div>
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<table border="0" style="width:100%; background-color:white;" class="grid2"> 
<tr>
    <td class="input2"><textarea style="resize:none; width:100%" name="clm_prve_desc" id="clm_prve_desc" rows="12" class="textarea"></textarea></td>
    </tr>
</table>         
</div>
</form>       
   