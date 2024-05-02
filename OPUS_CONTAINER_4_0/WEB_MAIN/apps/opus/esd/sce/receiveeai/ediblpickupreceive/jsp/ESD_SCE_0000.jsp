<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_sce_0000.jsp
*@FileTitle : GATENEW Test
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.receiveeai.edi322receive.event.EsdSce0000Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsdSce0000Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet list count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.opus.esd.sce.receiveeai.edi322receive");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EsdSce0000Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>

<script language="javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer job -->

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_save">Save</button><!--
	    --><button type="button" class="btn_normal" name="btn_new">New</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->


  <!-- biz page (S) -->
 <div class="wrap_search">
	<div class="opus_design_inquiry wFit"> 
    <table class="search">
       <tr><td width="70%" class="bg" valign="top"><table width="100%" id="mainTable" border="0">
                <tr><td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
              </table></td>
           <td width="30%" class="bg" valign="top"><table width="100%" id="mainTable">
                <tr><td width="100%" valign="top"><textarea name="mq_text" style="width:100%; height:181px" class="input1"></textarea></td></tr>
            </table></td>
       </tr>
       <tr>
         <td class="bg" align="center"><input type="radio" name="input_radio" value="SHEET" class="trans">&nbsp;Sheet</td>
         <td class="bg" align="center"><input type="radio" name="input_radio" value="MQ" class="trans" checked>&nbsp;MQ_Text</td>
       </tr>
       <tr><td colspan="2" class="bg">
        <!-- biz_2   (E) -->
        </td></tr>
      </table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
	     <script language="javascript">ComSheetObject('sheet2');</script>
    </div>
</div>    


<!-- end of developer job -->
</form>
