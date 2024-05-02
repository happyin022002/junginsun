/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : common_rd.js
*@FileTitle  : Common RD param & function define
*@author     : CLT
*@version    : 1.0
*@since      : 2014/03/16
=========================================================*/

/*
 * /rreportopt [256] : print first line of multiple line data (align middle) 
 * /rusesystemfont : use system font 
 */
var RDServer = "/rfn [http://10.82.175.62:7510/DataServer/rdagent.jsp] /rsn [jdbc/CNTRDEV] /ruseurlmoniker [0] /rlobopt [1] /roldarithop /rreportopt [256] /rpptexportapitype [1] ";  //RDServer RDAgnet url
var RDServerBAT = "/rfn [http://10.82.175.62:7510/DataServer/rdagent.jsp] /rsn [jdbc/CNTRDEV] /ruseurlmoniker [0] /rlobopt [1] /roldarithop /rreportopt [256] /rpptexportapitype [1] "; //Batch Connection Pool
//var ReportingServer = "http://116.127.223.204:8080/ReportingServer/service"; //CNTR(Unix) Reporting Server service URL
var ReportingServer = "http://10.82.175.90:9090/ReportingServer/service"; //CNTR(window) Reporting Server service URL
var RD_path = "http://" + location.host + "/opuscntr/"; // Report file 위치
var RdReport = "/opuscntr/rdReport.do"; // popup 으로 rd를 호출하는 공통 파일
var RDServerIP = "http://" + location.host + "/opuscntr"; // File 이용시 Server
var parmModalObj;

var viewer;
var _os = navigator.userAgent;

if (parent.parmObj !== undefined) {
	parmModalObj = parent.parmObj;
} else {
	parmModalObj = window.dialogArguments;
}

function rdViewerObject(){
	var hideItem = ["hwp","inquery","doc","xls"];
	document.write('<div id="report" style="position: absolute; width:100%; height:100%;" ></div>');
	m2soft.crownix.Layout.setTheme({
		toolbarColor: '#27415D',
//		toolbarIconColor: '#2979CE',
//		toolbarEffectColor: '#2979CE',
//		containerColor: '#2979CE',
//		pageBorderColor: '#2979CE',
	});
	m2soft.crownix.Resource.setLanguage('en');
	viewer = new m2soft.crownix.Viewer(ReportingServer, "report");
	viewer.hideToolbarItem(hideItem);
}

// 폼태그의 모든 컨트롤 데이타를 name[value] 포맷으로 가져오기
function RD_FormQueryString(form, no) {
	if (typeof form != "object" || form.tagName != "FORM") {
		 alert("FormQueryString function's parameter is not a FORM tag");
		 return "";
}

var name = new Array(form.elements.length);
var value = new Array(form.elements.length);
var j = 0;
var plain_text = "";

// 사용가능한 컨트롤을 배열로 생성한다.
len = form.elements.length;
for (i = 0; i < len; i++) {
	var prev_j = j;
	
	switch (form.elements[i].type) {
	case undefined:
	case "button":
	case "reset":
	case "submit":
		break;
	case "radio":
	case "checkbox":
		if (form.elements[i].checked === true) {
			name[j] = IBS_getName(form.elements[i]);
			value[j] = form.elements[i].value;
			j++;
		}
		break;
	case "select-one":
		name[j] = IBS_getName(form.elements[i]);
		var ind = form.elements[i].selectedIndex;
		if (ind >= 0) {

			value[j] = form.elements[i].options[ind].value;

		} else {
			value[j] = "";
		}
		j++;
		break;
	case "select-multiple":
		name[j] = IBS_getName(form.elements[i]);
		var llen = form.elements[i].length;
		var increased = 0;
		for (k = 0; k < llen; k++) {
			if (form.elements[i].options[k].selected) {
				name[j] = IBS_getName(form.elements[i]);
				value[j] = form.elements[i].options[k].value;
				j++;
				increased++;
			}
		}
		if (increased > 0) {
			j--;
		} else {
			value[j] = "";
		}
		j++;
		break;
	default:
		name[j] = IBS_getName(form.elements[i]);
		value[j] = form.elements[i].value;
		j++;
	}
}

// QueryString을 조합한다.
for (i = 0; i < j; i++) {
	if (name[i] !== ''){
		plain_text += "frm" + no + "_" + name[i] + "[" + value[i] + "] ";
	}
}

// 마지막에 &를 없애기 위함
if (plain_text !== "")
	plain_text = plain_text.substr(0, plain_text.length - 1);
	return plain_text;
}

// Sheet 에서 xml data 가져오기
function RD_GetDataSearchXml(sheet_obj, no) {

	if ((!sheet_obj) || (!sheet_obj.IBSheetVersion)) {
		alert("sheet_obj parameter is not a IBSheet in the IBS_GetDataSearchXml Function.");
		return "";
	}

	var rowXml = "";
	var allXml = "<SHEET" + no + ">  <DATA TOTAL='" + sheet_obj.GetTotalRows() + "'>";
	var rowcount = sheet_obj.RowCount() + sheet_obj.HeaderRows() - 1;

	for (ir = sheet_obj.HeaderRows(); ir <= rowcount; ir++) {
		rowXml = "<TR>";
		for (ic = 0; ic <= sheet_obj.LastCol(); ic++) {
			rowXml += "<TD><![CDATA[" + sheet_obj.GetCellValue(ir, ic) + "]]></TD>";
		}
		rowXml += "</TR>";
		allXml += rowXml;
	}
	allXml += "  </DATA></SHEET" + no + ">";

	return allXml;
}

/**
 * Report 모달창을 화면의 중앙에 활성화 한다.
 */
function rdObjModal(sURL, parmObj, sWidth, sHeight) {
	parmObj.FORM = document.form;
	
	var height = screen.height;
	var width = screen.width;
	var leftpos = width / 2 - sWidth / 2;
	var toppos = height / 2 - sHeight / 2;

	if (leftpos < 0)
		leftpos = 0;

	if (toppos < 0)
		toppos = 0;

	var sFeatures = [];
	sFeatures[0] = (sWidth > 0) ? "dialogWidth:" + sWidth + "px" : "dialgWidth:300px";
	sFeatures[1] = (sHeight > 0) ? "dialogHeight:" + sHeight + "px" : "dialogHeight:300px";
	sFeatures[2] = (toppos > 0) ? "dialogTop:" + toppos + "px" : "";
	sFeatures[3] = (leftpos > 0) ? "dialogLeft:" + leftpos + "px" : "";
	sFeatures[4] = (!toppos && !leftpos) ? "center:Yes" : "";
	sFeatures[5] = "resizeable:No";
	sFeatures[6] = "help:No";
	sFeatures[7] = "status:No";
	sFeatures[8] = "center:Yes;";
	sFeatures = sFeatures.join(";");

	if (_os.indexOf("MSIE") != -1 || _os.indexOf("Trident") != -1) {
		window.showModalDialog(sURL, parmObj, sFeatures);
	} else {
		_CallPopUpRD(sURL, parmObj, sFeatures);
	}
}

/**
 * Report modaless창을 화면의 중앙에 활성화 한다.
 */
function rdObjModaless(sURL, parmObj, sWidth, sHeight) {
	parmObj.FORM = document.form;

	var height = screen.height;
	var width = screen.width;
	var leftpos = width / 2 - sWidth / 2;
	var toppos = height / 2 - sHeight / 2;

	if (leftpos < 0)
		leftpos = 0;

	if (toppos < 0)
		toppos = 0;

	var sFeatures = [];
	sFeatures[0] = (sWidth > 0) ? "dialogWidth:" + sWidth + "px" : "dialgWidth:300px";
	sFeatures[1] = (sHeight > 0) ? "dialogHeight:" + sHeight + "px" : "dialogHeight:300px";
	sFeatures[2] = (toppos > 0) ? "dialogTop:" + toppos + "px" : "";
	sFeatures[3] = (leftpos > 0) ? "dialogLeft:" + leftpos + "px" : "";
	sFeatures[4] = (!toppos && !leftpos) ? "center:Yes" : "";
	sFeatures[5] = "resizeable:No";
	sFeatures[6] = "help:No";
	sFeatures[7] = "status:No";
	sFeatures[8] = "center:Yes;";
	sFeatures = sFeatures.join(";");

	if (_os.indexOf("MSIE") != -1 || _os.indexOf("Trident") != -1) {
		window.showModelessDialog(sURL, parmObj, sFeatures);
	} else {
		 var myWin = window.open(sURL, " ", "width="+sWidth+","+"height="+sHeight); 
		 myWin.parmObj = parmObj;
	}
}


