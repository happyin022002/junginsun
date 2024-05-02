<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_COA_3001.jsp
*@FileTitle  : Select Creation Type
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                               //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_3001");

    try {
        //ADD ----------------------------------------------------------------------------------------- START
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        //ADD ----------------------------------------------------------------------------------------- END

    }catch(Exception e) {
        log.error("ESM_COA_3001 Exception : "+e.toString());
    }
%>
<script language="javascript">
    function fnProcess() {
        var frm = document.form;

        if(frm.f_password.value == ""){
            if(ComShowConfirm(ComGetMsg('COA10054'))){
                window.returnValue = "";
                self.close();
            }
        }else {
            if(frm.f_password.value != "6475"){
                ComShowConfirm(ComGetMsg('COA10055'));
                //window.returnValue = "";
               	ComPopUpReturnValue("CANCEL");
                ComClosePopup();
            }
            //window.returnValue = frm.f_password.value;
           	ComPopUpReturnValue("6475");
            ComClosePopup();
        }
    }

    function fnLoad(){
        form.f_password.focus();
    }

    function fnKeyPressAction(e){
        if(e.keyCode == 13){
            fnProcess();
        }
    }
    
    document.onclick = processButtonClick;
    function processButtonClick() {
        var formObject = document.form;
    
        try {
            var srcName =ComGetEvent("name");
    
            switch(srcName) {    
                case "btn_close":
                	ComPopUpReturnValue("CANCEL");
                    //window.returnValue = "CANCEL";
                    ComClosePopup();
                    break;
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

</script>

<form method="post" name="form">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Input PassWord</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" onClick="fnProcess();">Comfirm</button><!--  -->
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
              <tr class="h23">
                <th width="60px"><div align="right">Password</div></th>
                <td width="*"><input name="f_password" type="password" onKeyDown="fnKeyPressAction(event);"></td>
              </tr>
            </table>
		</div>
	</div>
</div>

</form>
