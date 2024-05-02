<%--
=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0000_1.jsp
*@FileTitle  :  
*@author     : KYOUNGIL MOON
*@version    : 1.0 
*@since      : 2015/07/03
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event.EsmBookingUtilEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<script language="javascript" type="text/javascript" src="/hanjin/js/jquery.js" ></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoObject.js?version=U15"></script>
<SCRIPT LANGUAGE="javascript" TYPE="text/javascript" SRC="/hanjin/js/CoCommon.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" TYPE="text/javascript" SRC="/hanjin/js/CoFormControl.js" ></SCRIPT>
<SCRIPT LANGUAGE="javascript" TYPE="text/javascript" SRC="/hanjin/js/CoMessage.js" ></SCRIPT>

<script type="text/javascript">

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn_activate":
				doActionIBSheet(formObject, COMMAND04);
				break;
		}
	} catch (e) {
		console.log(e);
	}
}
	
function doActionIBSheet(formObj, sAction) {
	switch (sAction) {
		case COMMAND04:
			$("#error").val("");
			var xmlStr = ComHttpSync('../../SampleReceiptEdi.do', $('form').serialize());
			if(ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == 'F'){
				var rmsg=ComGetEtcData(xmlStr,"Exception").split("<||>");
				$("#error").val(xmlStr.split('<||>')[1].replace(' # Error Type : ','').replace('(null)',''));
			}else if (ComGetEtcData(xmlStr,"TRANS_RESULT_KEY") == "S"){
				alert("Data was saved successfully.")
			}
			break;
	}
}

function ComGetEtcData(xmlStr, etcName) {
	if (xmlStr == null || xmlStr == "" || etcName == null || etcName == "")
		return;

	try {
		
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;

		var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
		if (etcDataNode == null) return;

		var etcNodes = etcDataNode.childNodes;
		if (etcDataNode == null) return;

		for ( var i = 0; i < etcNodes.length; i++) {
			if (etcNodes[i].nodeType != 1)
				continue;
			if (etcNodes[i].attributes[0].nodeValue == etcName) {
				if (etcNodes[i].firstChild == null) {
					return "";
				} else {
					if(etcName == "Exception"){
						if(etcNodes[i].firstChild.nodeValue =="" || etcNodes[i].firstChild.nodeValue == " "){
							return etcNodes[i].firstChild.wholeText;
						}
					}
					return ComTrim(etcNodes[i].firstChild.wholeText) || etcNodes[i].firstChild.nodeValue;
				}
			}
		}

		if(xmlRoot.getElementsByTagName("ETC-DATA").item(1)){
			
			var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(1);
			if (etcDataNode == null) return;

			var etcNodes = etcDataNode.childNodes;
			if (etcDataNode == null) return;

			for ( var i = 0; i < etcNodes.length; i++) {
				if (etcNodes[i].nodeType != 1)
					continue;
				if (etcNodes[i].attributes[0].nodeValue == etcName) {
					if (etcNodes[i].firstChild == null) {
						return "";
					} else {
						return ComTrim(etcNodes[i].firstChild.wholeText) || etcNodes[i].firstChild.nodeValue;
					}
				}
			}
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

function ComGetXmlDoc(sXml){
	if (sXml==undefined || sXml=="" || sXml==null || sXml=="null") return null;

	if (sXml.indexOf("?>") > 0) {
		sXml = sXml.substring(sXml.indexOf("?>") + 2);
	}
	xmlDoc = $.parseXML(sXml);
	if (xmlDoc.documentElement==null) return null;

	return xmlDoc;
}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" value="14">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="40" />
			<col width="40" />
		</colgroup>
		<tr>
			<th>MSG</th>
			<td><textarea rows="30" cols="150" id="msg" name="msg"></textarea></td>
			<td>
			<button type="button" class="btn_etc" name="btn_activate" id="btn_activate">Send</button>
			<input type="checkbox" id="commit" name="commit" />
			</td>
		</tr>
		<tr>
			<th>Error MSG</th>
			<td><textarea rows="10" cols="150" id="error" name="error"></textarea></td>
		</tr>
	</table>
	</div>
</div>
</form>