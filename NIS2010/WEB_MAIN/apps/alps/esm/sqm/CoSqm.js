/**
===============================================================================
프로그램  명  : UI관련 공통 함수 정의 Script
프로그램개요  :
작   성   자 :
작   성   일 :
* 2014.01.16 IAS Sector Sales 판매시스템 개발[SearchIndex 추가]
* 2014.06.20 IAS Sector Sales - Main, Sector 구분자 추가, SQM00049 추가
* 2014.09.25 Portion Adjustment 화면의 From, TO VVD 입력 시 Portion Connected <> 'I' 인 VVD alert. SQM00050 추가 
* 2014.12.12 RF SPCL TPSZ Master 화면 신규 생성
* 2015.01.22 qtaRevMonArr 배열 및 function period_change_based_on_rev_month 생성(Rev Month 기준으로 관련 화면의 period를 변경)
* 2015.05.15 RHQ별 Portion 존재하고, Office portion이 없는 List 조회. 
* 2015.09.22 [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Freezing, Add-Freezing 버튼 Validation 추가
* 2015.10.01 [CSR 전환건] Allocation = QTA의 "SPC Alloc Apply" 로직 수정
* 2015.10.06 Portion Adjustment by RHQ, Head Office 화면 내 해당 분기 값만 입력 가능토록 Validation 설정
* 2015.10.29 [CSR 전환건] QTA Adjustment by VVD for IAS Sector 화면 보완 (Adjusting VVD Select, BSA Flag 칼럼 추가)
* 2015.12.02 연간/분기동안 확정 Data에 한번 들어간 Sector Pair는 active 해제할 수 없도록 로직 수정
* 2015.12.24 IAS Sector QTA Planning - Freezing 배치 방식으로 전환
* 2016.04.20 Target VVD Fix 월기준 항차 생성 등 개선 CSR
* 2016.04.22 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
* 2016.05.11 Sector Office Relation Setting for IAS Sector 화면 및 P/F Skd Group 화면 로직 수정 요청
===============================================================================
*/

var qtaWeekArr = new Array();
qtaWeekArr["1Q"] = new Array(".wk00",".wk13");
qtaWeekArr["2Q"] = new Array(".wk14",".wk26");
qtaWeekArr["3Q"] = new Array(".wk27",".wk39");
qtaWeekArr["4Q"] = new Array(".wk40",".wk53");

var qtaMonArr = new Array();
qtaMonArr["1Q"] = new Array("01","03");
qtaMonArr["2Q"] = new Array("04","06");
qtaMonArr["3Q"] = new Array("07","09");
qtaMonArr["4Q"] = new Array("10","12");

var qtaRevMonArr = new Array();
qtaRevMonArr["1Q"] = new Array(".01",".03 Rev month");
qtaRevMonArr["2Q"] = new Array(".04",".06 Rev month");
qtaRevMonArr["3Q"] = new Array(".07",".09 Rev month");
qtaRevMonArr["4Q"] = new Array(".10",".12 Rev month");

var searchParams = "";
var codeSheet    = null;

// Load Excel 변수
var loadExcelVal       = "";
var loadExcelRowCnt    = 0;
var loadExcelTotFlg    = false;
var loadExcelAplyField = "";
var loadExcelExField   = "";

// SQM 추가 메세지 
msgs["SQM00001"] = "{?msg1} saved successfully.";
msgs["SQM00002"] = "Team code is six-length and must begin with 'SEL'.";
msgs["SQM00003"] = "{?msg1} was copied successfully.";
msgs["SQM00004"] = "Do you want to save?";
msgs["SQM00005"] = "Do you want to data copy?";
msgs["SQM00006"] = "There is no data to save.";
msgs["SQM00007"] = "{?msg1} code is invalid.";
msgs["SQM00008"] = "Please enter {?msg1} correctly.\n\n Format : {?msg2}";
msgs["SQM00009"] = "Do you want to create data?";
msgs["SQM00010"] = "{?msg1} was created successfully.";
msgs["SQM00011"] = "{?msg1} were applied successfully.";
msgs["SQM00012"] = "Do you want to {?msg1}?";
msgs["SQM00013"] = "{?msg1} is mandatory item.";
msgs["SQM00014"] = "{?msg1} Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n {?msg2}";
msgs["SQM00015"] = "{?msg1} Portion TTL is over 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n {?msg2}";
msgs["SQM00016"] = "{?msg1} was confirmed successfully.";
msgs["SQM00017"] = "Please save first.";
msgs["SQM00018"] = "There is generated data.";
msgs["SQM00019"] = "There is no previous data.";
msgs["SQM00020"] = "Batch get started now.";
msgs["SQM00021"] = "Data is generating.";
msgs["SQM00022"] = "To week can't be earlier than From week.\nPlease check the row : {?msg1} SEQ.";
msgs["SQM00023"] = "{?msg1} has been already inputted.";
msgs["SQM00024"] = "Please Input {?msg1}."
msgs["SQM00025"] = "Duration doesn't include {?msg1}."
msgs["SQM00026"] = "There is no data.";
msgs["SQM00027"] = "Data has modified.";
msgs["SQM00028"] = "{?msg1} can not same with {?msg2}.\nPlease select other {?msg3}. ";
msgs["SQM00029"] = "{?msg1} was not saved succefully.";
msgs["SQM00030"] = "There are modified data.\nPlease save before you click {?msg1}.";
msgs["SQM00031"] = "Data has not been created : {?msg1}";
msgs["SQM00032"] = "A maximum of {?msg1} weeks can be entered.";
msgs["SQM00033"] = "Will you validate your uploading file?";
msgs["SQM00034"] = "Will you apply uploaded data into main page?";
msgs["SQM00035"] = "If you want to retrieve Weekly or VVD level, maximum period should be less than 13 weeks or 3 months.";
msgs["SQM00036"] = "Uploaded data has been applied. Please save.";
msgs["SQM00037"] = "There is 'L/F existing & RPB = 0' data.\nPlease check below '{?msg1}' data.\n{?msg2}";
msgs["SQM00038"] = "BackEndJob Request Fail! - Error : {?msg1}";
msgs["SQM00039"] = "Created BackEndJob File exist already!";
msgs["SQM00040"] = "There is data which is not {?msg1} data on the sheet.";
msgs["SQM00041"] = "Do you finish 'SKD & BSA Inquiry'?";
msgs["SQM00042"] = "There is 'Load existing & REV = 0' data.\nPlease check below '{?msg1}' data.\n{?msg2}";
msgs["SQM00043"] = "This Week is already included.";
msgs["SQM00044"] = "Please refer to 'QTA Adjustment by VVD'.\nThe VVD code doesn't exist in '{?msg1}'";
msgs["SQM00045"] = "Please select one R/Lane.";
msgs["SQM00046"] = "Please check at least one row.";
msgs["SQM00047"] = "There is no POL-POD Pair actived in '{?msg1}' Lane.";
msgs["SQM00048"] = "Copy Source Lane can't same with New Lane.";
msgs["SQM00049"] = "There is no Main Pair actived in '{?msg1}' Lane.";
msgs["SQM00050"] = "Original portion is disconnected because of\n * Allocation = QTA\n {?msg1} \n\n * QTA Edit\n {?msg2}";
msgs["SQM00051"] = "If you want to check 'Reefer Dry Excluded Flag',\nyou must choose Reefer container type.";
msgs["SQM00052"] = "Please set office portion(%) for the below RHQs.\n{?msg1}";
msgs["SQM00053"] = "({?msg1} {?msg2})\nG.RPB should not be zero when Load is not zero.\nBefore freezing data, please set G.RPB for below:\n\n              {?msg3}";
msgs["SQM00054"] = "'Activate' button does not work if any value of 'Applied' column among selected rows is 'Y' .";
msgs["SQM00055"] = "'{?msg1}' whose YRMON is {?msg2} does not belong to {?msg3}.";
msgs["SQM00056"] = "'Activate' button does not work if any value of 'Active' column among selected rows is 'Y' .";
msgs["SQM00057"] = "With 'RPB & CMPB(RA)' option checked, \nit might take a few minutes to retrieve and save data.";
msgs["SQM00058"] = "Creation will take up to 30 minutes (subject to change).\nDo you want to create data?";
msgs["SQM00059"] = "Batch process has started. Created data will be able to be retrieved after the batch process is completed.";
msgs["SQM00060"] = "Cannot be checked when there is data in the columns of 'Need to be Updated'.";
msgs["SQM00061"] = "Cannot copy from the same VVD";
msgs["SQM00062"] = "Selected pair cannot be inactivated because following data of the pair are already frozen.";
msgs["SQM00063"] = "Do you want to implement Freezing? (it can take a few minutes)";
msgs["SQM00064"] = "The same data already exists.";
msgs["SQM00065"] = "Invalid VVD";
msgs["SQM00066"] = "You have tried entering a VVD which does not exist in MAS Target VVD. It cannot be entered into the system.";
msgs["SQM00067"] = "'IAS' data can be pulled up only when Year-Quarter is after 2016 3Q.";
msgs["SQM00068"] = "'Add Creation' does not function after the process of Target VVD Fix until IAS sector data are frozen.";
msgs["SQM00069"] = "*** Caution!! ***\n\no Target VVD data already exists.\no Previous data will be lost.\no This operation may affect QTA report.\n\nAre you sure?";
msgs["SQM00070"] = "Do you want to {?msg1}?\n\n{?msg2}";

/**
 * IBSheet의 콤보 컬럼에 데이터를 setting 한다. <br>
 * <b>Example :</b>
 * <pre>
 *     ComSqmSetIBCombo(sheetObj,sXml,"trd_cd",false,1);
 * </pre>
 *
 * @param {string} sheetObj 필수
 * @param {string} sXml 필수, Combo에 채울 데이터(IBSheet를 통해 받아온 xml 문자열.)
 * @param {string} title 필수, Combo field명(IBSheet SaveName).
 * @param {string} iBlank 선택, Combo의 첫번째로우를 블랭크로 설정
 * @param {string} sCol 선택, 멀티콤보일경우 콤보를 선택하면 콤보에 보여질 순서설정(0:코드 or 1:description)
 * @param {string} iRow 선택, 생성할 선택 Row
 * @param {string} dCode 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Code값
 * @param {string} dText 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Text값
 * @param {string} bFlag multicombo 용 XML 파일을 Sheet 내에서 Combo 형태로 사용할 경우, Text 에 Code+"\t"+Text 형태로 만들어 사용할 수 있게 해 줌
 * (코드|디스크립션 형태가 아닐 경우는 0으로 설정해야함)
 * @return 없음
 * @version 2013.05.10
 */
function ComSqmSetIBCombo(sheetObj, sXml, title, iBlank, sCol, iRow, dCode, dText, bFlag) {
	var showCol = 0;
	
	if (ComGetTotalRows(sXml) == "0") return;
	if (bFlag == undefined || bFlag == "") {
		bFlag = false;
	}
	if (sCol != undefined && sCol !="") {
		showCol = sCol;
	}
	if (iBlank == undefined || iBlank == "") {
		iBlank = false;
	}
	if (iRow == undefined || iBlank == "") {
		iRow = 0;
	}
	
	var arrData = ComXml2ComboString(sXml, "code", "name");
	if (bFlag == true && arrData != null) {
		var arrCode = arrData[0].split("|");
		var arrName = arrData[1].split("|");
		var conData = "";
		
		for(i=0; i < arrName.length;i++) {
			if (i==0) {
				arrName[i] = arrCode[i]+"\t"+arrName[i];
			}else{
				arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
			}
			conData = conData.concat(arrName[i]);
		}
		arrData[1] = conData;
	}
	
	if (iBlank) {
		arrData[0] = " |" + arrData[0];
		arrData[1] = " |" + arrData[1];
	}
	
	if (arrData != null) {
		if (iRow == 0) {
			sheetObj.InitDataCombo(iRow, title, arrData[1], arrData[0], dText, dCode, showCol);
		}else{
			sheetObj.CellComboItem(iRow, title, arrData[1], arrData[0]);
		}
	}
}

/*
 * Sheet 없는 화면에서 사용하기 위해 숨겨진 IBSheet 를 만든다.
 * 
 * @return 없음
 * @version 2013.05.20
 */
function createCodeSheetObject() {
	if (codeSheet != null) {
        return;
    }
	
	var sTag = "";
	var id   = "codeSheet";
	sTag = ComGetSheetObjectTag(id);
	
	var divElement = document.createElement("DIV");
	divElement.style.display = "none";
	divElement.innerHTML = sTag;
	document.body.appendChild(divElement);
	
	codeSheet = divElement.children(0);
	ComConfigSheet(codeSheet);
	with(codeSheet) {
		style.height = 150;							// 전체 높이 설정
		SheetWidth   = 300;							// 전체 너비 설정
		if (location.hostname != "")	InitHostInfo(location.hostname, location.port, page_path);		//Host정보 설정[필수][HostIp, Port, PagePath]
		
		MergeSheet = msPrevColumnMerge;				// 전체Merge 종류 [선택, Default msNone]
		Editable = true;							// 전체Edit 허용 여부 [선택, Default false]
		InitRowInfo( 1, 1, 9, 100);					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitColumnInfo(4, 0 , 0, true);				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		
		var HeadTitle = "Status|Seq.|Code|Name";
		InitHeadRow(0, HeadTitle);					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitColumnInfo(10, 1 , 0, false);			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		
		var cnt = 0;
		InitDataProperty(0,	cnt++,	dtStatus,	50,	daCenter,	true,	"FLG",	false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtSeq,		50,	daCenter,	true,	"SEQ",	false,	"",	dfNone,	0,	false,	false);
		InitDataProperty(0,	cnt++,	dtData,		70,	daCenter,	true,	"CODE",	false,	"",	dfNone,	0,	true,	true);
		InitDataProperty(0,	cnt++,	dtData,		70,	daCenter,	true,	"TEXT",	false,	"",	dfNone,	0,	true,	true);
	}
	ComEndConfigSheet(codeSheet);
}

/**
 * xml 의 첫번째 Data 를 반환. <br>
 * <b>Example :</b>
 * <pre>
 *     ComSqmGetXmlValue(sheetObj,sXml,"trd_cd",false,1);
 * </pre>
 *
 * @param {string} sXml 필수(IBSheet를 통해 받아온 xml 문자열.)
 * @return string 
 */
function ComSqmGetXmlValue(sXml) {
	var rtnCode = "";
	var arrData = ComXml2ComboString(sXml, "code", "name");
	
	if (arrData != null) {
		var arrCode = arrData[0].split("|");
		rtnCode = arrCode[0];
	}
	
	return rtnCode;
}

/**
 * 화면 오픈시 Year, Quarter 세팅
 */
function ComSetYearQta(xml) {
	var formObj = document.form;
	var arrData = ComSqmGetXmlValue(xml);
	var arrCode = arrData.split("-");
	formObj.f_bse_yr.Code     = arrCode[0];
	formObj.f_bse_qtr_cd.Code = arrCode[1];
	
	period_change();
}

/**
 * period 변경
 */
function period_change(str) {
	var formObj    = document.form;
	var div_period = document.getElementById("div_period");
	
	if (formObj.f_bse_qtr_cd != undefined && div_period != undefined) {
		var year = ComGetObjValue(formObj.f_bse_yr);
		var qta  = ComGetObjValue(formObj.f_bse_qtr_cd);
		// 초기 로딩 시 "" 처리
		if ( qta != "" ) {
			if( qta == "All" ){
				div_period.innerHTML = "(" + year + ")";
			}else{
				div_period.innerHTML = "(" + year + qtaWeekArr[qta][0] + " ~ " + year + qtaWeekArr[qta][1] + ")";
			}
		}
	} else if (div_period != undefined) {
		div_period.innerHTML = "&nbsp;";
	}
}

/**
 * period 변경 (Rev Month 기준)
 */
function period_change_based_on_rev_month(str) {
	var formObj    = document.form;
	var div_period_based_on_rev_month = document.getElementById("div_period_based_on_rev_month");
	
	if (formObj.f_bse_qtr_cd != undefined && div_period_based_on_rev_month != undefined) {
		var year = ComGetObjValue(formObj.f_bse_yr);
		var qta  = ComGetObjValue(formObj.f_bse_qtr_cd);
		// 초기 로딩 시 "" 처리
		if ( qta != "" ) {
			if( qta == "All" ){
				div_period_based_on_rev_month.innerHTML = "(" + year + ")";
			}else{
				div_period_based_on_rev_month.innerHTML = "(" + year + qtaRevMonArr[qta][0] + " ~ " + year + qtaRevMonArr[qta][1] + ")";
			}
		}
	} else if (div_period_based_on_rev_month != undefined) {
		div_period_based_on_rev_month.innerHTML = "&nbsp;";
	}
}

/**
 * Sheet 의 표시되어 있는 Text 값을 반환
 *
 * @returns String
 */
function getSheetComboText() {
    var sheetObj, row, col, idx, name, value;
    sheetObj = arguments[0];
    row = arguments[1];
    col = arguments[2];
    if (arguments.length < 4) {
        idx = -1;
    }
    else{
    	idx = arguments[3];
    }
    var selectedIndex = sheetObj.GetComboInfo(row, col, "SelectedIndex") * 1;
    var texts = sheetObj.GetComboInfo(row, col, "Text").split("|");
    
    if (selectedIndex < 0) {
    	return "";
    }
    if (idx < 0) {
    	return texts[selectedIndex].split("\t");
    }
    return texts[selectedIndex].split("\t")[idx];
}

/**
 * Sheet 의 표시되어 있는 Code 값을 반환
 *
 * @returns String
 */
function getSheetComboCode() {
    var sheetObj, row, col, idx, name, value;
    sheetObj = arguments[0];
    row = arguments[1];
    col = arguments[2];
    if (arguments.length < 4) {
        idx = -1;
    }
    else{
    	idx = arguments[3];
    }
    var selectedIndex = sheetObj.GetComboInfo(row, col, "SelectedIndex") * 1;
    var texts = sheetObj.GetComboInfo(row, col, "Code").split("|");
    
    if (selectedIndex < 0) {
    	return "";
    }
    if (idx < 0) {
    	return texts[selectedIndex].split("\t");
    }
    return texts[selectedIndex].split("\t")[idx];
}

/**
 * XML 로 부터 특정 변수의 값을 추출하는 함수
 *
 * @param xml
 * @param key
 * @returns String
 */
function getEtcData(xml, key) {
	var xmlDoc = document.createElement("XML");
	xmlDoc.async = false;
	xmlDoc.loadXML(xml);
	var nodes = xmlDoc.selectNodes("SHEET/ETC-DATA/ETC");
	var etcs = new Array();
	for(var i = 0 ; i < nodes.length ; i++) {
		var node = nodes.nextNode();
		etcs[node.attributes[0].value] = node.text;
	}
	return etcs;
}

/**
 * 결과 XML로 부터 MESSAGE를 추출하는 함수.
 *
 * @param 결과XML
 * @returns String
 */
function ComResultMessage(xmlStr) {
    if (xmlStr == null || xmlStr == '') return '';
    
    var xValue = '';
    
    try {
    	/* XML Parsing */
    	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    	xmlDoc.async = "false";
    	xmlDoc.loadXML(xmlStr);
    	/* get message */
    	//xValue = xmlDoc.documentElement.getElementsByTagName("MESSAGE").item(0).text
    	var el_messages = xmlDoc.documentElement.getElementsByTagName("MESSAGE");
    	if (el_messages != null && el_messages.length > 0) {
    		xValue = el_messages.item(0).text;
    	}else{
    		xValue = '';
    	}
    } catch(err) {
    	xValue = err.message;
    }
    return xValue;
}

/**
 * 특정이름의 값을 searchParams 에서 가져온다.
 * 
 * @param {string} paramName 필수,	가져올 변수명
 * @return string
 */
function ComGetSearchParams(paramName) {
	try {
		var rtnValue = "";
        var posName = searchParams.indexOf(escape(paramName) + '=');
        
        if (posName != -1) {
        	var posValue = posName + (escape(paramName) + '=').length;
        	var endPos   = searchParams.indexOf('&', posValue);
        	
        	if (endPos != -1) rtnValue = unescape(searchParams.substring(posValue, endPos));
            else rtnValue = unescape(searchParams.substring(posValue));
        }
    } catch(err) { ComFuncErrMsg(err.message); }
    
    return (rtnValue);
}

/**
 * 특정이름의 값을 searchParams 에서 변경 가져온다.
 * 
 * @param {string} paramName	필수, 변경할 변수 명
 * @param {string} paramValue	필수, 변경할 변수 값
 */
function ComSetSearchParams(paramName, paramValue) {
	try {
        var posName = searchParams.indexOf(escape(paramName) + '=');
        if (posName != -1) {
        	var posValue = posName + (escape(paramName) + '=').length;
        	var endPos   = searchParams.indexOf('&', posValue);
        	
        	if (endPos != -1)
        		searchParams = unescape(searchParams.substring(0, posValue)) + paramValue + unescape(searchParams.substring(endPos));
            else
            	searchParams = unescape(searchParams.substring(0, posValue)) + paramValue;
        }
    } catch(err) { ComFuncErrMsg(err.message); }
}
 
// /**
//  * Ratio가 100%인지 확인한다.
// *  @param sheetObj	
// *  @param {string} arr	 ratio의 기준이 되는 컬럼연결 ex)"trd_cd|rlane_cd|conv_dir_cd"
//  * @returns Boolean
//  */
// function checkRatio(sheetObj, arr) {
//
//		//trd_cd|rlane_cd|conv_dir_cd을 기준으로 dup의 시작점 체크
//		var duprows2 = sheetObj.ColValueDupRows(arr, false, true);
//		var total_lod = new Array();
//		var total_rev = new Array();
//		if(duprows2 != "") {
//			var arrRow = duprows2.split("|");
//			var duprows = arrRow[0].split(",");
//			//동일조건의 시작과 끝까지 lod와 rev의 total값을 구함
//			for (var x=0; x < duprows.length; x++) {
//				total_lod[x]=0; 
//				total_rev[x]=0; 
//				if(x == duprows.length-1){
//					for(var y=duprows[x]; y<sheetObj.Rows; y++){
//						total_lod[x]= parseFloat(total_lod[x])+ parseFloat(sheetObj.CellValue(y,"lod_potn_rto"));
//						total_rev[x]= parseFloat(total_rev[x])+ parseFloat(sheetObj.CellValue(y,"lod_potn_rto"));
//					}
//				}else{
//					for(var y=duprows[x]; y<duprows[x+1]; y++){
//						total_lod[x]= parseFloat(total_lod[x])+ parseFloat(sheetObj.CellValue(y,"lod_potn_rto"));
//						total_rev[x]= parseFloat(total_rev[x])+ parseFloat(sheetObj.CellValue(y,"lod_potn_rto"));
//					}
//				}
//
//			}
//			for (x=0; x < duprows.length; x++) {
//				if(total_lod[x]>100){
//					ComShowCodeMessage('SQM00015','Load');
//					return false;
//				}else if(total_lod[x]<100){
//					ComShowCodeMessage('SQM00014','Load');
//					return false;
//				}else if(total_rev[x]>100){
//					ComShowCodeMessage('SQM00015','G.Rev');
//					return false;
//				}else if(total_rev[x]<100){
//					ComShowCodeMessage('SQM00014','G.Rev');
//					return false;
//				}
//
//			}
//		}
//		return true;
// }
 
 
// /**
//  * Ratio가 100%인지 확인한다.
// *  @param sheetObj	
//  * @returns Boolean
//  */
// function checkRatio(sheetObj) {
//
//		var total_lod = 0;
//		var total_rev = 0;
//		var dulchk = false;
//
//		if(sheetObj.SearchRows>1){//조회된 데이터가 여러줄인 경우
//			
//			for (var x=sheetObj.HeaderRows; x < sheetObj.Rows; x++){
//				if(x!=sheetObj.Rows-1){// 마지막줄이 아닐때 
//					//trd,rlane,bound,rhq 다름 -> %합산기준 달라짐
//					if(sheetObj.CellValue(x,"trd_cd")!=sheetObj.CellValue(x+1,"trd_cd")
//							||sheetObj.CellValue(x,"rlane_cd")!=sheetObj.CellValue(x+1,"rlane_cd")
//							||sheetObj.CellValue(x,"conv_dir_cd")!=sheetObj.CellValue(x+1,"conv_dir_cd")
//							||sheetObj.CellValue(x,"rhq_cd")!=sheetObj.CellValue(x+1,"rhq_cd")){
//						dulchk = false;	
//					}else{
//						//trd,rlane,bound,rhq가 같을때 같은 조건임을 표시
//						dulchk = true;					
//					}
//					total_lod = (parseFloat(total_lod)+ parseFloat(sheetObj.CellValue(x,"lod_potn_rto"))).toFixed(2);
//					total_rev = (parseFloat(total_rev)+ parseFloat(sheetObj.CellValue(x,"rev_potn_rto"))).toFixed(2);
//					
//				}else{//마지막 row일 때
//					
//					if(sheetObj.CellValue(x,"trd_cd")==sheetObj.CellValue(x-1,"trd_cd")
//							||sheetObj.CellValue(x,"rlane_cd")==sheetObj.CellValue(x-1,"rlane_cd")
//							||sheetObj.CellValue(x,"conv_dir_cd")==sheetObj.CellValue(x-1,"conv_dir_cd")
//							||sheetObj.CellValue(x,"rhq_cd")==sheetObj.CellValue(x-1,"rhq_cd")){
//						//trd,rlane,bound,rhq가 같을때
//						total_lod = (parseFloat(total_lod)+ parseFloat(sheetObj.CellValue(x,"lod_potn_rto"))).toFixed(2);
//						total_rev = (parseFloat(total_rev)+ parseFloat(sheetObj.CellValue(x,"rev_potn_rto"))).toFixed(2);
//					}else{//trd,rlane,bound,rhq 다름
//						total_lod = parseFloat(sheetObj.CellValue(x,"lod_potn_rto"));
//						total_rev = parseFloat(sheetObj.CellValue(x,"rev_potn_rto"));			
//					}
//					dulchk = false;	
//					
//				}
//
//				
//				if(!dulchk){
//					var msg = sheetObj.CellValue(x,"trd_cd") + "-"
//					+sheetObj.CellValue(x,"rlane_cd") + "-"
//					+sheetObj.CellValue(x,"conv_dir_cd") + "-"
//					+sheetObj.CellValue(x,"rhq_cd");
//					if(total_lod>100){
//						ComShowCodeMessage('SQM00015', 'Load' ,msg, total_lod);
//						return false;
//					}else if(total_lod<100){
//						ComShowCodeMessage('SQM00014', 'Load' ,msg, total_lod);
//						return false;
//					}else if(total_rev>100){
//						ComShowCodeMessage('SQM00015', 'G.Rev' ,msg, total_rev);
//						return false;
//					}else if(total_rev<100){
//						ComShowCodeMessage('SQM00014', 'G.Rev' ,msg, total_rev);
//						return false;
//					}
//					total_lod = 0;
//					total_rev = 0;
//				}
//
//			}
//		}else{ //조회된 데이터가 한줄밖에 없는 경우
//			
//			var msg = sheetObj.CellValue(sheetObj.HeaderRows,"trd_cd") + "-"
//						+sheetObj.CellValue(sheetObj.HeaderRows,"rlane_cd") + "-"
//						+sheetObj.CellValue(sheetObj.HeaderRows,"conv_dir_cd") + "-"
//						+sheetObj.CellValue(sheetObj.HeaderRows,"rhq_cd");
//			if(sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto")>100){
//				ComShowCodeMessage('SQM00015', 'Load' ,msg, sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto"));
//				return false;
//			}else if(sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto")<100){
//				ComShowCodeMessage('SQM00014', 'Load' ,msg, sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto"));
//				return false;
//			}else if(sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto")>100){
//				ComShowCodeMessage('SQM00015', 'G.Rev' ,msg, sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto"));
//				return false;
//			}else if(sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto")<100){
//				ComShowCodeMessage('SQM00014', 'G.Rev' ,msg, sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto"));
//				return false;
//			}
//
//		}
//		
//		
//		return true;
// }
  
  
  
/**
 * Ratio 가 100%인지 확인한다.
 * 
 * @param sheetObj	
 * @returns Boolean
 */
function checkRatio(sheetObj) {
	
	var total_lod = 0;
	var total_rev = 0;
	var msg1      = new Array();
	var cnt1      = 0;
	var msg2      = new Array();
	var cnt2      = 0;
	var lodRow    = 0;
	var revRow    = 0;
	var lodValue  = 0;
	var revValue  = 0;
	var result    = "";
	
	if ( sheetObj.RowCount > 1 ) {	//조회된 데이터가 여러줄인 경우
		
		for ( var x=sheetObj.HeaderRows; x < sheetObj.Rows-1; x++ ) {
			if ( x != sheetObj.Rows-2 ) {	// 마지막줄이 아닐때
				// trd, rlane, bound, rhq 다름 -> % 합산기준 달라짐
				if (    sheetObj.CellValue(x, "trd_cd")      != sheetObj.CellValue(x+1, "trd_cd")
					 || sheetObj.CellValue(x, "rlane_cd")    != sheetObj.CellValue(x+1, "rlane_cd")
					 || sheetObj.CellValue(x, "conv_dir_cd") != sheetObj.CellValue(x+1, "conv_dir_cd") ) {
					
					total_lod = (parseFloat(total_lod) + parseFloat(sheetObj.CellValue(x, "lod_potn_rto"))).toFixed(2);
					total_rev = (parseFloat(total_rev) + parseFloat(sheetObj.CellValue(x, "rev_potn_rto"))).toFixed(2);
					
					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
						lodRow   = x;
						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
					}
					
					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
						revRow   = x;
						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
					}
					
					if ( total_lod != 100 && total_lod != 0 ) {
						if ( total_lod == 99.99 ) {
							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) + 0.01; 
						} else if ( total_lod == 100.01 ) {
							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) - 0.01; 							
						} else {
							msg1[cnt1] = "";
							msg1[cnt1] = sheetObj.CellValue(x, "trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd") + " = " + total_lod + "%\n";
							cnt1++;
						}
					}
					
					if ( total_rev != 100 && total_rev != 0 ) {
						if ( total_rev == 99.99 ) {
							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) + 0.01; 
						} else if ( total_rev == 100.01 ) {
							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) - 0.01; 							
						} else {
							msg2[cnt2] = "";
							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd") + " = " + total_rev + "%\n";
							cnt2++;
						}
					}
					
					total_lod = 0;
					total_rev = 0;
					lodRow    = 0;
					revRow    = 0;
					lodValue  = 0;
					revValue  = 0;
				} else {
					// trd, rlane, bound 가 같을때 같은 조건임을 표시
					total_lod = (parseFloat(total_lod) + parseFloat(sheetObj.CellValue(x, "lod_potn_rto"))).toFixed(2);
					total_rev = (parseFloat(total_rev) + parseFloat(sheetObj.CellValue(x, "rev_potn_rto"))).toFixed(2);
					
					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
						lodRow   = x;
						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
					}
					
					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
						revRow   = x;
						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
					}
				}
			} else {	// 마지막 row 일 때
				if (    sheetObj.CellValue(x, "trd_cd")      == sheetObj.CellValue(x-1, "trd_cd")
					 || sheetObj.CellValue(x, "rlane_cd")    == sheetObj.CellValue(x-1, "rlane_cd")
					 || sheetObj.CellValue(x, "conv_dir_cd") == sheetObj.CellValue(x-1, "conv_dir_cd")) {
					// trd, rlane, bound 가 같을때
					total_lod = (parseFloat(total_lod)+ parseFloat(sheetObj.CellValue(x,"lod_potn_rto"))).toFixed(2);
					total_rev = (parseFloat(total_rev)+ parseFloat(sheetObj.CellValue(x,"rev_potn_rto"))).toFixed(2);
					
					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
						lodRow   = x;
						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
					}
					
					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
						revRow   = x;
						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
					}
					
					if ( total_lod != 100 && total_lod != 0 ) {
						if ( total_lod == 99.99 ) {
							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) + 0.01; 
						} else if ( total_lod == 100.01 ) {
							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) - 0.01; 							
						} else {
							msg1[cnt1] = "";
							msg1[cnt1] = sheetObj.CellValue(x, "trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
		 	 						   + sheetObj.CellValue(x, "conv_dir_cd") + " = " + total_lod + "%\n";
							cnt1++;
						}
					}
					
					if ( total_rev != 100 && total_rev != 0 ) {
						if ( total_rev == 99.99 ) {
							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) + 0.01; 
						} else if ( total_rev == 100.01 ) {
							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) - 0.01; 							
						} else {
							msg2[cnt2] = "";
							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd") + " = " + total_rev + "%\n";
							cnt2++;
						}
					}
				} else {	// trd, rlane, bound 다름
					total_lod = parseFloat(sheetObj.CellValue(x,"lod_potn_rto"));
					total_rev = parseFloat(sheetObj.CellValue(x,"rev_potn_rto"));
					
					if(total_lod != 100 && total_lod != 0){
						if ( total_lod == 99.99 ) {
							sheetObj.CellValue2(x, "lod_potn_rto") = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")) + 0.01; 
						} else if ( total_lod == 100.01 ) {
							sheetObj.CellValue2(x, "lod_potn_rto") = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")) - 0.01; 							
						} else {
							msg1[cnt1] = "";
							msg1[cnt1] = sheetObj.CellValue(x, "trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd") + " = " + total_lod + "%\n";
	 					}
					}
					
					if ( total_rev != 100 && total_rev != 0 ) {
						if ( total_rev == 99.99 ) {
							sheetObj.CellValue2(x, "rev_potn_rto") = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")) + 0.01; 
						} else if ( total_rev == 100.01 ) {
							sheetObj.CellValue2(x, "rev_potn_rto") = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")) - 0.01; 							
						} else {
							msg2[cnt2] = "";
							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd") + " = " + total_rev + "%\n";
						}
					}
				}
			}
		}
	} else {	//조회된 데이터가 한줄밖에 없는 경우
		total_lod = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto"));
		total_rev = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto"));
		
		if ( total_lod != 100 && total_lod != 0 ) {
			if ( total_lod == 99.99 ) {
				sheetObj.CellValue2(sheetObj.HeaderRows, "lod_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "lod_potn_rto")) + 0.01; 
			} else if ( total_lod == 100.01 ) {
				sheetObj.CellValue2(sheetObj.HeaderRows, "lod_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "lod_potn_rto")) - 0.01; 							
			} else {
				msg1[cnt1] = "";
				msg1[cnt1] = sheetObj.CellValue(sheetObj.HeaderRows, "trd_cd")      + "-"
				           + sheetObj.CellValue(sheetObj.HeaderRows, "rlane_cd")    + "-"
				           + sheetObj.CellValue(sheetObj.HeaderRows, "conv_dir_cd") + " = " + total_lod + "%\n";
			}
		}
		
		if ( total_rev != 100 && total_rev != 0 ) {
			if ( total_rev == 99.99 ) {
				sheetObj.CellValue2(sheetObj.HeaderRows, "rev_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "rev_potn_rto")) + 0.01; 
			} else if ( total_rev == 100.01 ) {
				sheetObj.CellValue2(sheetObj.HeaderRows, "rev_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "rev_potn_rto")) - 0.01; 							
			} else {
				msg2[cnt2] = "";
				msg2[cnt2] = sheetObj.CellValue(sheetObj.HeaderRows, "trd_cd")      + "-"
				           + sheetObj.CellValue(sheetObj.HeaderRows, "rlane_cd")    + "-"
				           + sheetObj.CellValue(sheetObj.HeaderRows, "conv_dir_cd") + " = " + total_rev + "%\n";
			}
		}
	}
	
	if ( msg1.length > 0 || msg2.length > 0 ) {
		if ( msg1.length > 0 ) {
			for ( x = 1; x < msg1.length; x++ ) {
				msg1[0] = msg1[0] + msg1[x];
			}
			result = "Load Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg1[0];
		}
		
		if ( msg2.length > 0 ) {
			for ( x = 1; x < msg2.length; x++ ) {
				msg2[0] = msg2[0] + msg2[x];
			}
			
			if ( result != "" )
				result = result + "\n\nG.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
			else
				result = "G.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
		}
		
		alert(result);
		return false;
	}
	return true;
}
 
 
/**
 * Ratio 가 100%인지 확인한다.
 * 
 * @param sheetObj	
 * @returns Boolean
 */
function checkRatioForRHQ(sheetObj) {
	var total_lod = 0;
	var total_rev = 0;
	var msg1      = new Array();
	var cnt1      = 0;
	var msg2      = new Array();
	var cnt2      = 0;
	var lodRow    = 0;
	var revRow    = 0;
	var lodValue  = 0;
	var revValue  = 0;
	var result    = "";
	
	if ( sheetObj.RowCount > 1 ) {	// 조회된 데이터가 여러줄인 경우
		for ( var x = sheetObj.HeaderRows; x < sheetObj.Rows-1; x++ ) {
			if ( x != sheetObj.Rows - 2 ) {	// 마지막줄이 아닐때
				// trd, rlane, bound, rhq 다름 -> %합산기준 달라짐
				if (    sheetObj.CellValue(x, "trd_cd")      != sheetObj.CellValue(x+1, "trd_cd")
					 || sheetObj.CellValue(x, "rlane_cd")    != sheetObj.CellValue(x+1, "rlane_cd")
					 || sheetObj.CellValue(x, "conv_dir_cd") != sheetObj.CellValue(x+1, "conv_dir_cd")
					 || sheetObj.CellValue(x, "rhq_cd")      != sheetObj.CellValue(x+1, "rhq_cd")) {
					total_lod = (parseFloat(total_lod)+ parseFloat(sheetObj.CellValue(x,"lod_potn_rto"))).toFixed(2);
					total_rev = (parseFloat(total_rev)+ parseFloat(sheetObj.CellValue(x,"rev_potn_rto"))).toFixed(2);
					
					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
						lodRow   = x;
						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
					}
					
					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
						revRow   = x;
						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
					}
					
					if ( total_lod != 100 && total_lod != 0 ) {
						if ( total_lod == 99.99 ) {
							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) + 0.01; 
						} else if ( total_lod == 100.01 ) {
							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) - 0.01; 							
						} else {
							msg1[cnt1] = "";
							msg1[cnt1] = sheetObj.CellValue(x, "trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd") + "-"
							           + sheetObj.CellValue(x, "rhq_cd")      + " = " + total_lod + "%\n";
							cnt1++;
						}
					}
					
					if ( total_rev != 100 && total_rev != 0 ) {
						if ( total_rev == 99.99 ) {
							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) + 0.01; 
						} else if ( total_rev == 100.01 ) {
							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) - 0.01; 							
						} else {
							msg2[cnt2] = "";
							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd") + "-"
							           + sheetObj.CellValue(x, "rhq_cd")      + " = " + total_rev + "%\n";
							cnt2++;
						}
					}
					
					total_lod = 0;
					total_rev = 0;
					lodRow    = 0;
					revRow    = 0;
					lodValue  = 0;
					revValue  = 0;
				} else {
					// trd, rlane, bound, rhq 가 같을때 같은 조건임을 표시
					total_lod = (parseFloat(total_lod)+ parseFloat(sheetObj.CellValue(x,"lod_potn_rto"))).toFixed(2);
					total_rev = (parseFloat(total_rev)+ parseFloat(sheetObj.CellValue(x,"rev_potn_rto"))).toFixed(2);
					
					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
						lodRow   = x;
						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
					}
					
					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
						revRow   = x;
						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
					}
				}
			} else {	// 마지막 row 일 때
				if (    sheetObj.CellValue(x, "trd_cd")      == sheetObj.CellValue(x-1, "trd_cd")
					 || sheetObj.CellValue(x, "rlane_cd")    == sheetObj.CellValue(x-1, "rlane_cd")
					 || sheetObj.CellValue(x, "conv_dir_cd") == sheetObj.CellValue(x-1, "conv_dir_cd")
					 || sheetObj.CellValue(x, "rhq_cd")      == sheetObj.CellValue(x-1, "rhq_cd") ) {
					// trd, rlane, bound, rhq 가 같을때
					total_lod = (parseFloat(total_lod)+ parseFloat(sheetObj.CellValue(x,"lod_potn_rto"))).toFixed(2);
					total_rev = (parseFloat(total_rev)+ parseFloat(sheetObj.CellValue(x,"rev_potn_rto"))).toFixed(2);
					
					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
						lodRow   = x;
						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
					}
					
					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
						revRow   = x;
						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
					}
					
					if ( total_lod != 100 && total_lod != 0 ) {
						if ( total_lod == 99.99 ) {
							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) + 0.01; 
						} else if ( total_lod == 100.01 ) {
							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) - 0.01; 							
						} else {
							msg1[cnt1] = "";
							msg1[cnt1] = sheetObj.CellValue(x ,"trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd") + "-"
							           + sheetObj.CellValue(x, "rhq_cd")      + " = " + total_lod + "%\n";
							cnt1++;
						}
					}
					
					if ( total_rev != 100 && total_rev != 0 ) {
						if ( total_rev == 99.99 ) {
							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) + 0.01; 
						} else if ( total_rev == 100.01 ) {
							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) - 0.01; 							
						} else {
							msg2[cnt2] = "";
							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd") + "-"
							           + sheetObj.CellValue(x, "rhq_cd")      + " = " + total_rev + "%\n";
							cnt2++;
						}
					}
				} else {	// trd, rlane, bound, rhq 다름
					total_lod = parseFloat(sheetObj.CellValue(x,"lod_potn_rto"));
					total_rev = parseFloat(sheetObj.CellValue(x,"rev_potn_rto"));
					
					if ( total_lod != 100 && total_lod != 0 ) {
						if ( total_lod == 99.99 ) {
							sheetObj.CellValue2(x, "lod_potn_rto") = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")) + 0.01; 
						} else if ( total_lod == 100.01 ) {
							sheetObj.CellValue2(x, "lod_potn_rto") = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")) - 0.01; 							
						} else {
							msg1[cnt1] = "";
							msg1[cnt1] = sheetObj.CellValue(x, "trd_cd")      + "-"
							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd") + "-"
							           + sheetObj.CellValue(x, "rhq_cd")      + " = " + total_lod + "%\n";
						}
					}
					
					if ( total_rev != 100 && total_rev != 0 ) {
						if ( total_rev == 99.99 ) {
							sheetObj.CellValue2(x, "rev_potn_rto") = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")) + 0.01; 
						} else if ( total_rev == 100.01 ) {
							sheetObj.CellValue2(x, "rev_potn_rto") = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")) - 0.01; 							
						} else {
							msg2[cnt2] = "";
							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")         + "-"
							           + sheetObj.CellValue(x, "rlane_cd")       + "-"
							           + sheetObj.CellValue(x, "conv_dir_cd")    + "-"
							           + sheetObj.CellValue(x, "rhq_cd") + " = " + total_rev + "%\n";
						}
					}
				}
			}
		}
	} else {	// 조회된 데이터가 한줄밖에 없는 경우
		total_lod = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto"));
		total_rev = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto"));
		
		if ( total_lod != 100 && total_lod != 0 ) {
			if ( total_lod == 99.99 ) {
				sheetObj.CellValue2(sheetObj.HeaderRows, "lod_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "lod_potn_rto")) + 0.01; 
			} else if ( total_lod == 100.01 ) {
				sheetObj.CellValue2(sheetObj.HeaderRows, "lod_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "lod_potn_rto")) - 0.01; 							
			} else {
				msg1[cnt1] = "";
				msg1[cnt1] = sheetObj.CellValue(sheetObj.HeaderRows, "trd_cd")      + "-"
				           + sheetObj.CellValue(sheetObj.HeaderRows, "rlane_cd")    + "-"
				           + sheetObj.CellValue(sheetObj.HeaderRows, "conv_dir_cd") + "-"
				           + sheetObj.CellValue(sheetObj.HeaderRows, "rhq_cd")      + " = " + total_lod + "%\n";
			}
		}
		
		if ( total_rev != 100 && total_rev != 0 ) {
			if ( total_rev == 99.99 ) {
				sheetObj.CellValue2(sheetObj.HeaderRows, "rev_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "rev_potn_rto")) + 0.01; 
			} else if ( total_rev == 100.01 ) {
				sheetObj.CellValue2(sheetObj.HeaderRows, "rev_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "rev_potn_rto")) - 0.01; 							
			} else {
				msg2[cnt2] = "";
				msg2[cnt2] = sheetObj.CellValue(sheetObj.HeaderRows, "trd_cd")      + "-"
				           + sheetObj.CellValue(sheetObj.HeaderRows, "rlane_cd")    + "-"
				           + sheetObj.CellValue(sheetObj.HeaderRows, "conv_dir_cd") + "-"
				           + sheetObj.CellValue(sheetObj.HeaderRows, "rhq_cd")      + " = " + total_rev + "%\n";
			}
		}
	}
	
	if ( msg1.length > 0 || msg2.length > 0 ) {
		if ( msg1.length > 0 ) {
			for ( x = 1; x < msg1.length; x++ ) {
				msg1[0] = msg1[0] + msg1[x];
			}
			result = "Load Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg1[0];
		}
		
		if ( msg2.length > 0 ){
			for ( x = 1; x < msg2.length; x++ ) {
				msg2[0] = msg2[0] + msg2[x];
			}
			
			if ( result != "" )
				result = result + "\n\nG.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
			else
				result = "G.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
		}
		
		alert(result);
		return false;
	}
	return true;
}
 
 
 
 /**
  * Ratio 가 100%인지 확인한다.
  * 
  * @param sheetObj	
  * @returns Boolean
  */
 function checkRatioAdj(sheetObj) {
 	
 	var total_lod = 0;
 	var total_rev = 0;
 	var msg1      = new Array();
 	var cnt1      = 0;
 	var msg2      = new Array();
 	var cnt2      = 0;
 	var lodRow    = 0;
 	var revRow    = 0;
 	var lodValue  = 0;
 	var revValue  = 0;
 	var result    = "";
 	
 	if ( sheetObj.RowCount > 1 ) {	//조회된 데이터가 여러줄인 경우

 		for ( var x=sheetObj.HeaderRows; x < sheetObj.Rows-1; x++ ) {
 			if ( x != sheetObj.Rows-2 ) {	// 마지막줄이 아닐때
 				// trd, rlane, bound, rhq 다름 -> % 합산기준 달라짐
 				if (    sheetObj.CellValue(x, "trd_cd")      != sheetObj.CellValue(x+1, "trd_cd")
 					 || sheetObj.CellValue(x, "rlane_cd")    != sheetObj.CellValue(x+1, "rlane_cd")
 					 || sheetObj.CellValue(x, "conv_dir_cd") != sheetObj.CellValue(x+1, "conv_dir_cd") 
 					 || sheetObj.CellValue(x, "grp_no")      != sheetObj.CellValue(x+1, "grp_no")) {
 					
 					total_lod = (parseFloat(total_lod) + parseFloat(sheetObj.CellValue(x, "lod_potn_rto"))).toFixed(2);
 					total_rev = (parseFloat(total_rev) + parseFloat(sheetObj.CellValue(x, "rev_potn_rto"))).toFixed(2);
 					
 					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow   = x;
 						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
 					}
 					
 					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow   = x;
 						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 					
 					if ( total_lod != 100 && total_lod != 0 ) {
 						if ( total_lod == 99.99 ) {
 							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) + 0.01; 
 						} else if ( total_lod == 100.01 ) {
 							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) - 0.01; 							
 						} else {
 							msg1[cnt1] = "";
 							msg1[cnt1] = sheetObj.CellValue(x, "trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd") + "-" 
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_lod + "%\n";
 							cnt1++;
 						}
 					}
 					
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) + 0.01; 
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) - 0.01; 							
 						} else {
 							msg2[cnt2] = "";
 							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd") + "-" 
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_rev + "%\n";
 							cnt2++;
 						}
 					}
 					
 					total_lod = 0;
 					total_rev = 0;
 					lodRow    = 0;
 					revRow    = 0;
 					lodValue  = 0;
 					revValue  = 0;
 				} else {
 					// trd, rlane, bound 가 같을때 같은 조건임을 표시
 					total_lod = (parseFloat(total_lod) + parseFloat(sheetObj.CellValue(x, "lod_potn_rto"))).toFixed(2);
 					total_rev = (parseFloat(total_rev) + parseFloat(sheetObj.CellValue(x, "rev_potn_rto"))).toFixed(2);
 					
 					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow   = x;
 						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
 					}
 					
 					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow   = x;
 						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 				}
 			} else {	// 마지막 row 일 때
 				if (    sheetObj.CellValue(x, "trd_cd")      == sheetObj.CellValue(x-1, "trd_cd")
 					 || sheetObj.CellValue(x, "rlane_cd")    == sheetObj.CellValue(x-1, "rlane_cd")
 					 || sheetObj.CellValue(x, "conv_dir_cd") == sheetObj.CellValue(x-1, "conv_dir_cd")
 					 || sheetObj.CellValue(x, "grp_no")      != sheetObj.CellValue(x+1, "grp_no")) {
 					// trd, rlane, bound 가 같을때
 					total_lod = (parseFloat(total_lod)+ parseFloat(sheetObj.CellValue(x,"lod_potn_rto"))).toFixed(2);
 					total_rev = (parseFloat(total_rev)+ parseFloat(sheetObj.CellValue(x,"rev_potn_rto"))).toFixed(2);
 					
 					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow   = x;
 						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
 					}
 					
 					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow   = x;
 						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 					
 					if ( total_lod != 100 && total_lod != 0 ) {
 						if ( total_lod == 99.99 ) {
 							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) + 0.01; 
 						} else if ( total_lod == 100.01 ) {
 							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) - 0.01; 							
 						} else {
 							msg1[cnt1] = "";
 							msg1[cnt1] = sheetObj.CellValue(x, "trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 		 	 						   + sheetObj.CellValue(x, "conv_dir_cd") + "-" 
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_lod + "%\n";
 							cnt1++;
 						}
 					}
 					
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) + 0.01; 
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) - 0.01; 							
 						} else {
 							msg2[cnt2] = "";
 							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd") + "-" 
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_rev + "%\n";
 							cnt2++;
 						}
 					}
 				} else {	// trd, rlane, bound 다름
 					total_lod = parseFloat(sheetObj.CellValue(x,"lod_potn_rto"));
 					total_rev = parseFloat(sheetObj.CellValue(x,"rev_potn_rto"));
 					
 					if(total_lod != 100 && total_lod != 0){
 						if ( total_lod == 99.99 ) {
 							sheetObj.CellValue2(x, "lod_potn_rto") = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")) + 0.01; 
 						} else if ( total_lod == 100.01 ) {
 							sheetObj.CellValue2(x, "lod_potn_rto") = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")) - 0.01; 							
 						} else {
 							msg1[cnt1] = "";
 							msg1[cnt1] = sheetObj.CellValue(x, "trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd") + "-" 
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_lod + "%\n";
 	 					}
 					}
 					
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.CellValue2(x, "rev_potn_rto") = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")) + 0.01; 
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.CellValue2(x, "rev_potn_rto") = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")) - 0.01; 							
 						} else {
 							msg2[cnt2] = "";
 							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd") + "-" 
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_rev + "%\n";
 						}
 					}
 				}
 			}
 		}
 	} else {	//조회된 데이터가 한줄밖에 없는 경우
 		total_lod = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto"));
 		total_rev = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto"));
 		
 		if ( total_lod != 100 && total_lod != 0 ) {
 			if ( total_lod == 99.99 ) {
 				sheetObj.CellValue2(sheetObj.HeaderRows, "lod_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "lod_potn_rto")) + 0.01; 
 			} else if ( total_lod == 100.01 ) {
 				sheetObj.CellValue2(sheetObj.HeaderRows, "lod_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "lod_potn_rto")) - 0.01; 							
 			} else {
 				msg1[cnt1] = "";
 				msg1[cnt1] = sheetObj.CellValue(sheetObj.HeaderRows, "trd_cd")      + "-"
 				           + sheetObj.CellValue(sheetObj.HeaderRows, "rlane_cd")    + "-"
 				           + sheetObj.CellValue(sheetObj.HeaderRows, "conv_dir_cd") + "-" 
					       + sheetObj.CellValue(sheetObj.HeaderRows, "aply_fm_yrwk")+ " = " + total_lod + "%\n";
 			}
 		}
 		
 		if ( total_rev != 100 && total_rev != 0 ) {
 			if ( total_rev == 99.99 ) {
 				sheetObj.CellValue2(sheetObj.HeaderRows, "rev_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "rev_potn_rto")) + 0.01; 
 			} else if ( total_rev == 100.01 ) {
 				sheetObj.CellValue2(sheetObj.HeaderRows, "rev_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "rev_potn_rto")) - 0.01; 							
 			} else {
 				msg2[cnt2] = "";
 				msg2[cnt2] = sheetObj.CellValue(sheetObj.HeaderRows, "trd_cd")      + "-"
 				           + sheetObj.CellValue(sheetObj.HeaderRows, "rlane_cd")    + "-"
 				           + sheetObj.CellValue(sheetObj.HeaderRows, "conv_dir_cd") + "-" 
					       + sheetObj.CellValue(sheetObj.HeaderRows, "aply_fm_yrwk")+ " = " + total_rev + "%\n";
 			}
 		}
 	}
 	
 	if ( msg1.length > 0 || msg2.length > 0 ) {
 		if ( msg1.length > 0 ) {
 			for ( x = 1; x < msg1.length; x++ ) {
 				msg1[0] = msg1[0] + msg1[x];
 			}
 			result = "Load Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound-Week' portion.\n\n " + msg1[0];
 		}
 		
 		if ( msg2.length > 0 ) {
 			for ( x = 1; x < msg2.length; x++ ) {
 				msg2[0] = msg2[0] + msg2[x];
 			}
 			
 			if ( result != "" )
 				result = result + "\n\nG.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound-Week' portion.\n\n " + msg2[0];
 			else
 				result = "G.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound-Week' portion.\n\n " + msg2[0];
 		}
 		
 		alert(result);
 		return false;
 	}
 	return true;
 }
 
 
 
 /**
  * Ratio 가 100%인지 확인한다.
  * 
  * @param sheetObj	
  * @returns Boolean
  */
 function checkRatioForRHQAdj(sheetObj) {
 	var total_lod = 0;
 	var total_rev = 0;
 	var msg1      = new Array();
 	var cnt1      = 0;
 	var msg2      = new Array();
 	var cnt2      = 0;
 	var lodRow    = 0;
 	var revRow    = 0;
 	var lodValue  = 0;
 	var revValue  = 0;
 	var result    = "";
 	
 	if ( sheetObj.RowCount > 1 ) {	// 조회된 데이터가 여러줄인 경우
 		for ( var x = sheetObj.HeaderRows; x < sheetObj.Rows-1; x++ ) {
 			if ( x != sheetObj.Rows - 2 ) {	// 마지막줄이 아닐때
 				// trd, rlane, bound, rhq 다름 -> %합산기준 달라짐
 				if (    sheetObj.CellValue(x, "trd_cd")      != sheetObj.CellValue(x+1, "trd_cd")
 					 || sheetObj.CellValue(x, "rlane_cd")    != sheetObj.CellValue(x+1, "rlane_cd")
 					 || sheetObj.CellValue(x, "conv_dir_cd") != sheetObj.CellValue(x+1, "conv_dir_cd")
 					 || sheetObj.CellValue(x, "rhq_cd")      != sheetObj.CellValue(x+1, "rhq_cd")
 					 || sheetObj.CellValue(x, "grp_no")      != sheetObj.CellValue(x+1, "grp_no")) {
 					total_lod = (parseFloat(total_lod)+ parseFloat(sheetObj.CellValue(x,"lod_potn_rto"))).toFixed(2);
 					total_rev = (parseFloat(total_rev)+ parseFloat(sheetObj.CellValue(x,"rev_potn_rto"))).toFixed(2);
 					
 					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow   = x;
 						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
 					}
 					
 					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow   = x;
 						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 					
 					if ( total_lod != 100 && total_lod != 0 ) {
 						if ( total_lod == 99.99 ) {
 							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) + 0.01; 
 						} else if ( total_lod == 100.01 ) {
 							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) - 0.01; 							
 						} else {
 							msg1[cnt1] = "";
 							msg1[cnt1] = sheetObj.CellValue(x, "trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd") + "-"
 							           + sheetObj.CellValue(x, "rhq_cd")      + "-"
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_lod + "%\n";
 							cnt1++;
 						}
 					}
 					
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) + 0.01; 
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) - 0.01; 							
 						} else {
 							msg2[cnt2] = "";
 							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd") + "-"
 							           + sheetObj.CellValue(x, "rhq_cd")      + "-"
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_rev + "%\n";
 							cnt2++;
 						}
 					}
 					
 					total_lod = 0;
 					total_rev = 0;
 					lodRow    = 0;
 					revRow    = 0;
 					lodValue  = 0;
 					revValue  = 0;
 				} else {
 					// trd, rlane, bound, rhq 가 같을때 같은 조건임을 표시
 					total_lod = (parseFloat(total_lod)+ parseFloat(sheetObj.CellValue(x,"lod_potn_rto"))).toFixed(2);
 					total_rev = (parseFloat(total_rev)+ parseFloat(sheetObj.CellValue(x,"rev_potn_rto"))).toFixed(2);
 					
 					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow   = x;
 						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
 					}
 					
 					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow   = x;
 						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 				}
 			} else {	// 마지막 row 일 때
 				if (    sheetObj.CellValue(x, "trd_cd")      == sheetObj.CellValue(x-1, "trd_cd")
 					 || sheetObj.CellValue(x, "rlane_cd")    == sheetObj.CellValue(x-1, "rlane_cd")
 					 || sheetObj.CellValue(x, "conv_dir_cd") == sheetObj.CellValue(x-1, "conv_dir_cd")
 					 || sheetObj.CellValue(x, "rhq_cd")      == sheetObj.CellValue(x-1, "rhq_cd")
 					 || sheetObj.CellValue(x, "grp_no")      == sheetObj.CellValue(x-1, "grp_no")) {
 					// trd, rlane, bound, rhq 가 같을때
 					total_lod = (parseFloat(total_lod)+ parseFloat(sheetObj.CellValue(x,"lod_potn_rto"))).toFixed(2);
 					total_rev = (parseFloat(total_rev)+ parseFloat(sheetObj.CellValue(x,"rev_potn_rto"))).toFixed(2);
 					
 					if ( lodValue < parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow   = x;
 						lodValue = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")).toFixed(2);
 					}
 					
 					if ( revValue < parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow   = x;
 						revValue = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 					
 					if ( total_lod != 100 && total_lod != 0 ) {
 						if ( total_lod == 99.99 ) {
 							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) + 0.01; 
 						} else if ( total_lod == 100.01 ) {
 							sheetObj.CellValue2(lodRow, "lod_potn_rto") = parseFloat(sheetObj.CellValue(lodRow, "lod_potn_rto")) - 0.01; 							
 						} else {
 							msg1[cnt1] = "";
 							msg1[cnt1] = sheetObj.CellValue(x ,"trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd") + "-"
 							           + sheetObj.CellValue(x, "rhq_cd")      + "-"
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_lod + "%\n";
 							cnt1++;
 						}
 					}
 					
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) + 0.01; 
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.CellValue2(revRow, "rev_potn_rto") = parseFloat(sheetObj.CellValue(revRow, "rev_potn_rto")) - 0.01; 							
 						} else {
 							msg2[cnt2] = "";
 							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd") + "-"
 							           + sheetObj.CellValue(x, "rhq_cd")      + "-"
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_rev + "%\n";
 							cnt2++;
 						}
 					}
 				} else {	// trd, rlane, bound, rhq 다름
 					total_lod = parseFloat(sheetObj.CellValue(x,"lod_potn_rto"));
 					total_rev = parseFloat(sheetObj.CellValue(x,"rev_potn_rto"));
 					
 					if ( total_lod != 100 && total_lod != 0 ) {
 						if ( total_lod == 99.99 ) {
 							sheetObj.CellValue2(x, "lod_potn_rto") = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")) + 0.01; 
 						} else if ( total_lod == 100.01 ) {
 							sheetObj.CellValue2(x, "lod_potn_rto") = parseFloat(sheetObj.CellValue(x, "lod_potn_rto")) - 0.01; 							
 						} else {
 							msg1[cnt1] = "";
 							msg1[cnt1] = sheetObj.CellValue(x, "trd_cd")      + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")    + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd") + "-"
 							           + sheetObj.CellValue(x, "rhq_cd")      + "-"
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")+ " = " + total_lod + "%\n";
 						}
 					}
 					
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.CellValue2(x, "rev_potn_rto") = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")) + 0.01; 
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.CellValue2(x, "rev_potn_rto") = parseFloat(sheetObj.CellValue(x, "rev_potn_rto")) - 0.01; 							
 						} else {
 							msg2[cnt2] = "";
 							msg2[cnt2] = sheetObj.CellValue(x, "trd_cd")         + "-"
 							           + sheetObj.CellValue(x, "rlane_cd")       + "-"
 							           + sheetObj.CellValue(x, "conv_dir_cd")    + "-"
 							           + sheetObj.CellValue(x, "rhq_cd")         + "-"
 							           + sheetObj.CellValue(x, "aply_fm_yrwk")   + " = " + total_rev + "%\n";
 						}
 					}
 				}
 			}
 		}
 	} else {	// 조회된 데이터가 한줄밖에 없는 경우
 		total_lod = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto"));
 		total_rev = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto"));
 		
 		if ( total_lod != 100 && total_lod != 0 ) {
 			if ( total_lod == 99.99 ) {
 				sheetObj.CellValue2(sheetObj.HeaderRows, "lod_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "lod_potn_rto")) + 0.01; 
 			} else if ( total_lod == 100.01 ) {
 				sheetObj.CellValue2(sheetObj.HeaderRows, "lod_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "lod_potn_rto")) - 0.01; 							
 			} else {
 				msg1[cnt1] = "";
 				msg1[cnt1] = sheetObj.CellValue(sheetObj.HeaderRows, "trd_cd")      + "-"
 				           + sheetObj.CellValue(sheetObj.HeaderRows, "rlane_cd")    + "-"
 				           + sheetObj.CellValue(sheetObj.HeaderRows, "conv_dir_cd") + "-"
 				           + sheetObj.CellValue(sheetObj.HeaderRows, "rhq_cd")      + "-"
					       + sheetObj.CellValue(sheetObj.HeaderRows, "aply_fm_yrwk")+ " = " + total_lod + "%\n";
 			}
 		}
 		
 		if ( total_rev != 100 && total_rev != 0 ) {
 			if ( total_rev == 99.99 ) {
 				sheetObj.CellValue2(sheetObj.HeaderRows, "rev_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "rev_potn_rto")) + 0.01; 
 			} else if ( total_rev == 100.01 ) {
 				sheetObj.CellValue2(sheetObj.HeaderRows, "rev_potn_rto") = parseFloat(sheetObj.CellValue(sheetObj.HeaderRows, "rev_potn_rto")) - 0.01; 							
 			} else {
 				msg2[cnt2] = "";
 				msg2[cnt2] = sheetObj.CellValue(sheetObj.HeaderRows, "trd_cd")      + "-"
 				           + sheetObj.CellValue(sheetObj.HeaderRows, "rlane_cd")    + "-"
 				           + sheetObj.CellValue(sheetObj.HeaderRows, "conv_dir_cd") + "-"
 				           + sheetObj.CellValue(sheetObj.HeaderRows, "rhq_cd")      + "-"
					       + sheetObj.CellValue(sheetObj.HeaderRows, "aply_fm_yrwk")+ " = " + total_rev + "%\n";
 			}
 		}
 	}
 	
 	if ( msg1.length > 0 || msg2.length > 0 ) {
 		if ( msg1.length > 0 ) {
 			for ( x = 1; x < msg1.length; x++ ) {
 				msg1[0] = msg1[0] + msg1[x];
 			}
 			result = "Load Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg1[0];
 		}
 		
 		if ( msg2.length > 0 ){
 			for ( x = 1; x < msg2.length; x++ ) {
 				msg2[0] = msg2[0] + msg2[x];
 			}
 			
 			if ( result != "" )
 				result = result + "\n\nG.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
 			else
 				result = "G.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
 		}
 		
 		alert(result);
 		return false;
 	}
 	return true;
 }
 
 /**
  *  combo box에 선택된 값의 Index를 리턴한다.
  * @param comboObj
  * @param code
  * @returns
  */
 function SearchIndex(comboObj, code){
 	var rtn = "";
 	
 	for(var i=0; i < comboObj.GetCount(); i++) {
 		if ( code.indexOf(comboObj.GetIndexText(i, 0)) != -1 ) {
 			rtn = rtn +  i + "|" ;
 		}
 	}
 	rtn = rtn.substr(0, rtn.length-1);
 	if (rtn == "") rtn = 0;
 	return rtn;
 }
  