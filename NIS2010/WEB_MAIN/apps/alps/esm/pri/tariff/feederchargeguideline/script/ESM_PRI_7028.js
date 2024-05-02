/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7028.js
 *@FileTitle : Add-On Tariff Amendment DG Cargo Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.19
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2012.07.19 서미진
 * 1.0 Creation
 * 2013.02.19 [CHM-201323107] 전윤주 AOC Feeder DG Tab 변경에 따른 컬럼 추가, AMT를 20', 40'로 구분함
 * 2014.12.09 [CHM-201433491] ADD ON TARIFF / DG 요율 관련 (CUR_CD 추가)
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

function ESM_PRI_7028() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

var sheetObjects = new Array();
var sheetCnt = 0;

document.onclick = processButtonClick;

function processButtonClick() {
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Close":
			self.close();
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}	
}

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		sheetObjects[i].WaitImageVisible = false;
		ComEndConfigSheet(sheetObjects[i]);
	}

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			style.height = 365;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			MergeSheet = msHeaderOnly;
			Editable = false;
			InitRowInfo(2, 1, 3, 100);
			var HeadTitle1 = "|Seq.|Point|Description|Base port|Term|Curr.|Class 1|Class 1|Class 1|Class 2|Class 2|Class 2|Class 3|Class 3|Class 3|Class 4|Class 4|Class 4|Class 5|Class 5|Class 5|Class 6|Class 6|Class 6|Class 7|Class 7|Class 7|Class 8|Class 8|Class 8|Class 9|Class 9|Class 9";
			var HeadTitle2 = "|Seq.|Point|Description|Base port|Term|Curr.|SVC|20'|40'|SVC|20'|40'|SVC|20'|40'|SVC|20'|40'|SVC|20'|40'|SVC|20'|40'|SVC|20'|40'|SVC|20'|40'|SVC|20'|40";

			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			InitHeadMode(true, true, true, true, false, false)
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);
			
			InitDataProperty(0, cnt++, dtHiddenStatus, 		30, 		daCenter,		true, 	"ibflag");
	     	InitDataProperty(0, cnt++, 	dtDataSeq,   		  	40,    		daCenter,  	true,  	"Seq");       
	     	InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"pnt_loc_cd",                  false, "", dfNone, 0, false, false);       
	     	InitDataProperty(0, cnt++, 	dtData, 				80, 		daLeft, 	true, 	"pnt_loc_nm",                  false, "", dfNone, 0, false, false);     
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"bse_port_loc_cd",             false, "", dfNone, 0, false, false);                                       
            InitDataProperty(0, cnt++, 	dtCombo, 			    80, 		daCenter, 	true, 	"rcv_de_term_cd",              false, "", dfNone, 0, false, false);   
            //[CHM-201433491] ADD ON TARIFF / DG 요율 관련 (CUR_CD 추가)
            InitDataProperty(0, cnt++, 	dtData, 				40, 		daCenter, 	true, 	"curr_cd",                 	 		false, "", dfNone, 0, false, false);  
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"imdg_n1st_clss_svc_flg",      false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n1st_clss_20ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n1st_clss_40ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"imdg_n2nd_clss_svc_flg",      false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n2nd_clss_20ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n2nd_clss_40ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"imdg_n3rd_clss_svc_flg",      false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n3rd_clss_20ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n3rd_clss_40ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"imdg_n4th_clss_svc_flg",      false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n4th_clss_20ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n4th_clss_40ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"imdg_n5th_clss_svc_flg",      false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n5th_clss_20ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n5th_clss_40ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"imdg_n6th_clss_svc_flg",      false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n6th_clss_20ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n6th_clss_40ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"imdg_n7th_clss_svc_flg",      false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n7th_clss_20ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n7th_clss_40ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"imdg_n8th_clss_svc_flg",      false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n8th_clss_20ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n8th_clss_40ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daCenter, 	true, 	"imdg_n9th_clss_svc_flg",      false, "", dfNone, 0, false, false);    
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n9th_clss_20ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	true, 	"imdg_n9th_clss_40ft_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
            
            
            
            InitDataCombo(0, "rcv_de_term_cd", termCdText, termCdValue);     
            Ellipsis = true;

		}
		break;
	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
			ComOpenWait(true);
		}
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		case IBSEARCH:
            if (!validateForm(sheetObjects[0],document.form,sAction)) {
                return false;
            }    				
            
            formObj.f_cmd.value = SEARCH01;
			sheetObj.WaitImageVisible = false;
			sheetObj.DoSearch("ESM_PRI_7028GS.do", FormQueryString(formObj));
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false);
	}
}

function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (formObj.svc_scp_cd.value == "") {
			ComShowCodeMessage("COM130403", "Service Scope");
			return false;
		}
		if (formObj.fdr_trf_no.value == "") {
			ComShowCodeMessage("COM130403", "Feeder Tariff Number");
			return false;
		}
		break;
	}
	return true;
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * Sheet의 값을 Html Object에 Setting하고 Font Style을 지정한다.
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 최성환
 * @version 2014.12.09
 */ 		
function sheet1_OnSearchEnd(sheetObj, errMsg){
/*
 * 대표 currency code 
	var formObj = document.form;
	var maxRow = sheetObj.RowCount;
	if (sheetObj.RowCount > 0){
		formObj.curr_cd.value = "* "+ sheetObj.CellValue(maxRow,"curr_cd");
	}
	*/
}