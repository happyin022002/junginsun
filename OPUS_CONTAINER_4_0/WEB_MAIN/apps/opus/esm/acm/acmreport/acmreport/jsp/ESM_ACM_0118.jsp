<%--=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0118.jsp
*@FileTitle  : Customized Report Form
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmreport.acmreport.event.EsmAcm0118Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0118Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMReport.ACMReport");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0118Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="save_flag" id="save_flag">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Customized Report Form</span></h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button><!--  
	 --><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
<!-- opus_design_btn(E) -->
</div>
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50"/>
				<col width="*" />
			</colgroup>
			<tbody>
              <tr>
                <th>Customized RPT Form</th>
                <td><select name="slct_itm_fom_seq" id="slct_itm_fom_seq" style="width:110px;"></select></td>
              </tr>
              </tbody>
      </table>
     </div>
</div>    

<div class="wrap_result">
	<div class="layout_wrap">
	 <div class="layout_vertical_3" style ="width: 250px;">
		<div class="opus_design_grid clear"><script type="text/javascript">ComSheetObject("sheet1");</script></div>
 	</div>   
	<div class="layout_vertical_3" align="center" style ="width:55px;">   
	<div style="height: 150px;">&nbsp;</div>  
         <img src="img/button/btns_add.gif" width="26" height="26" border="0" name="btns_add" id="btns_add"><br><br>
         <img src="img/button/btns_del.gif" width="26" height="26" border="0" name="btns_del" id="btns_del"></td>
 	</div>
   	<div class="layout_vertical_3" style ="width: 250px;">
	<div class="opus_design_grid clear"><script type="text/javascript">ComSheetObject("sheet2");</script></div>
   	</div>   
  </div>
 <div>
 <div style="height:40px;"></div>
<table>
	<colgroup>
		<col width="50"/>
		<col width="*" />
	</colgroup>
		<tbody>
		<tr>
          	<td class="stm"><input type="radio" class="trans" name="radio_save_yn" id="radio_save_yn"  onFocus="javascript:this.blur();"><label for ="radio_save_yn">Use this setting at this time only</label></td>
  		</tr>
   		<tr>
       		<td  class="stm"><input type="radio" class="trans" name="radio_save_yn" id="radio_save_yn"  onFocus="javascript:this.blur();" checked><label for = "radio_save_yn">Save this setting as</label><input name="slct_itm_fom_desc" id="slct_itm_fom_desc" type="text" dataformat="eng" maxlength="99" style="width:160;"></td>
       </tr>
       </tbody>
      </table>
</div>             

</div>
</form>