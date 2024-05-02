/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_0152.jsp
*@FileTitle : Korea MOF Filing (Base Table)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
function ESM_PRI_0152() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
}

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;


var tabLoad = new Array();
var subDataCnt = 0;
var isAproUsr = false;

var selectedGlineSeq = null;
document.onclick = processButtonClick;

function processButtonClick() {
}


function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}


function loadPage() {
	for ( var k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
}

function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Scope & Location", 0);
			InsertTab(cnt++, "CGO Type", 1);
			InsertTab(cnt++, "CNTR Type", 2);
			InsertTab(cnt++, "Currency", 3);
			InsertTab(cnt++, "Surcharge", 4);
			ShowIcon = false;
		}
		break;
	}
}


function doActionIBSheet(sheetObj, formObj, sAction) {
}

function validateForm(sheetObj, formObj, sAction) {
	return true;
}

function clearAllTabPages() {
	for ( var i = 0; i < tabObjects[0].GetCount(); i++) {
		tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
		if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
			document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
		}
	}
}

function enableAllTabPages(flag) {
	if (flag == null || flag == "") {
		if (isAproUsr && document.form.cfm_flg.value.toUpperCase() != "YES") {
			flag = true;
		} else {
			flag = false;
		}
	}

	for ( var i = 0; i < tabObjects[0].GetCount(); i++) {
		if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet) {
			document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet(flag);
		}
	}
}

function tab1_OnChange(tabObj, tabIndex) {
	if (beforetab != tabIndex) {
		var objs = document.all.item("tabLayer");
		objs[tabIndex].style.display = "inline";
		objs[beforetab].style.display = "none";
	}
	beforetab = tabIndex;
	loadTabPage(tabIndex);
}

function loadTabPage(tabIndex) {
	if (tabIndex == null || tabIndex == "") {
		tabIndex = tabObjects[0].SelectedIndex;
	}
	var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
	
	if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
		var sUrl = "";
		switch (tabIndex) {
		case 0:
			sUrl = "ESM_PRI_0152_01.do";
			break;
		case 1:
			sUrl = "ESM_PRI_0152_02.do";
			break;
		case 2:
			sUrl = "ESM_PRI_0152_03.do";
			break;
		case 3:
			sUrl = "ESM_PRI_0152_04.do";
			break;
		case 4:
			sUrl = "ESM_PRI_0152_05.do";
			break;
		}
		objTabWindow.location.href = sUrl;
		return true;
	}
}