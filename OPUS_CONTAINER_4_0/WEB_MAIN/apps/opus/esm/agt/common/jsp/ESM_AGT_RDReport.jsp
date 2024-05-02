<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0001.jsp
*@FileTitle  : Container type Retrieve 및 다중 Optional(Pop-up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================
--%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount" %>
<%
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		String userTheme = account.getUsr_theme();

		if ("1".equals(userTheme)) {
			out.print("<link id=\"theme\" href=\"style/css/theme_default.css\" rel=\"stylesheet\" type=\"text/css\">");
		} else if ("2".equals(userTheme)) {
			out.print("<link id=\"theme\" href=\"style/css/theme_blue.css\" rel=\"stylesheet\" type=\"text/css\">");
		} else {
			out.print("<link id=\"theme\" href=\"style/css/theme_default.css\" rel=\"stylesheet\" type=\"text/css\">");
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
	<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
	<script type="text/javascript">

		// Event handler processing by button click event.
		document.onclick = processButtonClick;

		function processButtonClick() {
			var rdObject = document.getElementById("Rdviewer");

			try {
				var srcName = window.event.srcElement.getAttribute("name");

				switch (srcName) {
				case "btn_save" :
					rdObject.SaveAsDialog();
					break;
				case "btn_print" :
					rdObject.PrintDialog();
					break;
				case "btn_first" :
					rdObject.FirstPage();
					break;
				case "btn_back" :
					rdObject.PrevPage();
					break;
				case "btn_next" :
					rdObject.NextPage();
					break;
				case "btn_last" :
					rdObject.LastPage();
					break;
				case "btn_zoomin" :
					rdObject.ZoomIn();
					break;
				case "btn_zoomout" :
					rdObject.ZoomOut();
					break;
				case "btn_close" :
					ComClosePopup();
					break;
				}
			} catch (e) {
				if (e = "[object Error]") {
					ComShowCodeMessage('COM12111');
				} else {
					ComShowMessage(e);
				}
			}
		}

		function rdOpen() {
			var sXml = "";
			var sheetObj = new Array();
			var frmObj = new Array();
	        var etcObj = "";
	        var rdObject = document.getElementById("Rdviewer");
			sheetObj = parmModalObj[4] ;
			frmObj = parmModalObj[5] ;
			etcObj = parmModalObj[6] ;
	
			sXml = "<?xml version='1.0' ?><SHEET>" ;
			sheetCnt = 1 ;
			for (var i=0; i<sheetObj.length; i++) {
				sheetCnt = i + 1;
				if (sheetObj[i].RowCount == 0) {
					sXml += "<SHEET" + sheetCnt + "><DATA TOTAL='0'><TR>";
					for (var j=0; j<=sheetObj[i].LastCol; j++) {
						sXml += "<TD></TD>";
					}
					sXml += "</TR></DATA></SHEET" + sheetCnt + ">";
				} else {
					sXml += RD_GetDataSearchXml(sheetObj[i], sheetCnt);
				}
			}
			sXml += "</SHEET>";
	
			var	mrdPath = parmModalObj[3];
			var formParam = "/rv ";
			for (var k=0; k<frmObj.length; k++) {
				formParam += RD_FormQueryString(frmObj[k], k+1);
			}
	
			if (etcObj != undefined) {
				if (etcObj.length > 0) {
					formParam = formParam + etcObj;
				}
			}
	
			rdObject.AutoAdjust = false;
			rdObject.ZoomRatio = 90;
			rdObject.SetBackgroundColor(255,255,255);
			rdObject.SetPageScroll(0);
			rdObject.ApplyLicense("0.0.0.0");
			rdObject.SetRData(sXml);
			rdObject.FileOpen(mrdPath, RDServer + formParam);
		}

		function setupPage() {
			rdOpen();
		}
	</script>

	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title"><span>RD Print</span></h2>
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
				<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
			</div>
		</div>
	</div>

	<div class="layer_popup_contents">
		<div class="wrap_result">
			<div class="opus_design_RD"><script type="text/javascript">comRdObjectPopup("Rdviewer");</script></div>
		</div>
	</div>
