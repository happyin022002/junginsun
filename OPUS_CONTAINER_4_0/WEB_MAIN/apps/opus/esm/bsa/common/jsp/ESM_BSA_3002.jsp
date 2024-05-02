<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_3002.jsp
*@FileTitle  : Excel Download
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                               //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.bsa.ESM_BSA_3002");

    try {
        //ADD ----------------------------------------------------------------------------------------- START
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        //ADD ----------------------------------------------------------------------------------------- END

    }catch(Exception e) {
        log.error("ESM_BSA_3002 Exception : "+e.toString());
    }

    String sheetIdx     = JSPUtil.getNull(request.getParameter("sheetidx"));
    if (sheetIdx.equals("")) {
        sheetIdx = "";
    }
%>

<script type="text/javascript">
	function setupPage(){
	}
</script>
<script>
document.onkeydown = keyEnter;

function keyEnter() {
    if (ComGetEvent("keycode") == 27) { // Esc
    	ComPopUpReturnValue("CANCEL");
        //window.returnValue = "CANCEL";
    	ComClosePopup();
    }
    if (ComGetEvent("keycode") == 13) { // Enter
        processButtonClick();
    }
}

document.onclick = processButtonClick;
function processButtonClick() {
	var formObject = document.form;

	try {
        var srcName =ComGetEvent("name");

		switch(srcName) {

			case "btn_ok":
				var data = "";
				if(formObject.data[0].checked){
					data = "A";
				}
				if(formObject.data[1].checked){
					data = "D";
				}
				var format = "";
				if(formObject.format[0].checked){
					format = "Y";
				}
				if(formObject.format[1].checked){
					format = "N";
				}

                //ComPopUpReturnValue(data+format);
                
                //2개 이상 sheet data 다운로드시 배열 처리
                 var rArray = new Array(2);
                 rArray[0] = data+format;
                 rArray[1] = formObject.sheet_idx.value;
                                     
                 if(formObject.sheet_idx.value == "") {
                 	ComPopUpReturnValue(data+format);
                 } else {
                 	ComPopUpReturnValue(rArray);
                 }
                    
				break;

			case "btn_close":
				ComPopUpReturnValue("CANCEL");
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

<body>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="sheet_idx" value="<%=sheetIdx%>">
<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span>Excel Download</span></h2>
        <!-- page_title(E) -->

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_ok" id="btn_ok">OK</button><!--
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<!-- wrap_result(S) -->
<div class="wrap_search">
    <div class="opus_design_data">
    	<table class="grid2 wAuto">
		    <colgroup>
		        <col width="160" />
		        <col width="160" />
		    </colgroup>
		    <tbody>
		        <tr>
		            <th><strong>Data</strong></th>
		            <th><strong>Format</strong></th>
		        </tr>
		        <tr>
		            <td class="sm pad_left_12"><input type="radio" name="data" id="data0" value="1" style="border: 0"> <label for="data0">All</label></td>
		            <td class="sm pad_left_12"><input type="radio" name="format" id="format0" value="1" style="border: 0"> <label for="format0">Yes</label></td>
		        </tr>
		        <tr>
		            <td class="sm pad_left_12"><input type="radio" name="data" id="data1" value="2" style="border: 0" checked> <label for="data1">Designed</label></td>
		            <td class="sm pad_left_12"><input type="radio" name="format" id="format1" value="2" style="border: 0" checked> <label for="format1">No</label></td>
		        </tr>
		    </tbody>
		</table>
    </div>
</div>
<!-- wrap_result(E) -->
</div>
<!-- popup_contens_area(E) -->
</form>
