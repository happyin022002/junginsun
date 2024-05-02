/**
===============================================================================
프로그램  명  : UI관련 공통 함수 정의 Script
프로그램개요  :
작   성   자 :
작   성   일 :
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

var searchParams = "";
var codeSheet    = null;

// Load Excel 변수
var loadExcelVal       = "";
var loadExcelRowCnt    = 0;
var loadExcelTotFlg    = false; 
var loadExcelAplyField = "";
var loadExcelExField   = "";

// CSQ 추가 메세지 
msgs["CSQ00001"] = "{?msg1} saved successfully.";
msgs["CSQ00002"] = "Team code must be six-length.";
msgs["CSQ00003"] = "{?msg1} was copied successfully.";
msgs["CSQ00004"] = "Do you want to save?";
msgs["CSQ00005"] = "Do you want to copy data?";
msgs["CSQ00006"] = "There is no data to save.";
msgs["CSQ00007"] = "{?msg1} code is invalid.";
msgs["CSQ00008"] = "Please enter {?msg1} correctly.\n\n Format : {?msg2}";
msgs["CSQ00009"] = "Do you want to create data?";
msgs["CSQ00010"] = "{?msg1} was created successfully.";
msgs["CSQ00011"] = "{?msg1} were applied successfully.";
msgs["CSQ00012"] = "Do you want to {?msg1}?";
msgs["CSQ00013"] = "{?msg1} is mandatory item.";
msgs["CSQ00014"] = "{?msg1} Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n {?msg2}";
msgs["CSQ00015"] = "{?msg1} Portion TTL is over 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n {?msg2}";
msgs["CSQ00016"] = "{?msg1} was confirmed successfully.";
msgs["CSQ00017"] = "Please save first.";
msgs["CSQ00018"] = "There is generated data.";
msgs["CSQ00019"] = "There is no previous data.";
msgs["CSQ00020"] = "Batch get started now.";
msgs["CSQ00021"] = "Data is generating.";
msgs["CSQ00022"] = "To week can't be earlier than From week.\nPlease check the row : {?msg1} SEQ.";
msgs["CSQ00023"] = "{?msg1} has been already inputted.";
msgs["CSQ00024"] = "Please Input {?msg1}."
msgs["CSQ00025"] = "Duration doesn't include {?msg1}."
msgs["CSQ00026"] = "There is no data.";
msgs["CSQ00027"] = "Data has modified.";
msgs["CSQ00028"] = "{?msg1} can not same with {?msg2}.\nPlease select other {?msg3}. ";
msgs["CSQ00029"] = "{?msg1} was not saved succefully.";
msgs["CSQ00030"] = "There are modified data.\nPlease save before you click {?msg1}.";
msgs["CSQ00031"] = "Data has not been created : {?msg1}";
msgs["CSQ00032"] = "A maximum of {?msg1} weeks can be entered.";
msgs["CSQ00033"] = "Will you validate your uploading file?";
msgs["CSQ00034"] = "Will you apply uploaded data into main page?";
msgs["CSQ00035"] = "If you want to retrieve by Weekly or VVD level, maximum period should be less than 13 weeks or 3 months.";
msgs["CSQ00036"] = "Uploaded data has been applied. Please save.";
msgs["CSQ00037"] = "There is 'L/F existing & RPB = 0' data.\nPlease check below '{?msg1}' data.\n{?msg2}";
msgs["CSQ00038"] = "BackEndJob Request Fail! - Error : {?msg1}";
msgs["CSQ00039"] = "Created BackEndJob File exist already!";
msgs["CSQ00040"] = "There is data which is not {?msg1} data on the sheet.";
msgs["CSQ00041"] = "Do you finish 'SKD & BSA Inquiry'?";
msgs["CSQ00042"] = "There is 'Load existing & REV = 0' data.\nPlease check below '{?msg1}' data.\n{?msg2}";
msgs["CSQ00043"] = "This Week is already included.";
msgs["CSQ00044"] = "VVD code doesn't exist in '{?msg1}'";
msgs["CSQ00045"] = "Please select one R/Lane.";
msgs["CSQ00046"] = "Please check at least one row.";
msgs["CSQ00047"] = "There is no POL-POD Pair activated in '{?msg1}' Lane.";
msgs["CSQ00048"] = "Copy Source Lane can't same with New Lane.";
msgs["CSQ00049"] = "There is no Main Pair activated in '{?msg1}' Lane.";
msgs["CSQ00050"] = "Original portion is disconnected because of\n * Allocation = QTA\n {?msg1} \n\n * QTA Edit\n {?msg2}";
msgs["CSQ00051"] = "If you want to check 'Reefer Dry Exclued Flag',\nyou must choose Reefer container type.";
msgs["CSQ00052"] = "Failed to save the data.\nAll the sector cells of a trade should be all checked or all unchecked.\nPlease check the sector cells of {?msg1}.";
msgs["CSQ00053"] = "The selected lane(s) has been successfully disabled.";

/**
 * IBSheet의 콤보 컬럼에 데이터를 setting 한다. <br>
 * <b>Example :</b>
 * <pre>
 *     ComCsqSetIBCombo(sheetObj,sXml,"trd_cd",false,1);
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
function ComCsqSetIBCombo(sheetObj, sXml, title, iBlank, sCol, iRow, dCode, dText, bFlag) {
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
			sheetObj.CellComboItem(iRow, title, {ComboCode:arrData[1], ComboText:arrData[0]});
		}
	}
}

/**
 * xml 의 첫번째 Data 를 반환. <br>
 * <b>Example :</b>
 * <pre>
 *     ComCsqGetXmlValue(sheetObj,sXml,"trd_cd",false,1);
 * </pre>
 *
 * @param {string} sXml 필수(IBSheet를 통해 받아온 xml 문자열.)
 * @return string 
 */
function ComCsqGetXmlValue(sXml) {
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
	var arrData = ComCsqGetXmlValue(xml);
	var arrCode = arrData.split("-");
	f_bse_yr.SetSelectCode(arrCode[0]);
	f_bse_qtr_cd.SetSelectCode(arrCode[1]);
	
	period_change();
}

/**
 * period 변경
 */
function period_change(str) {
	var formObj    = document.form;
	var div_period = document.getElementById("div_period");
	
	if (f_bse_qtr_cd != undefined && div_period != undefined) {
		var year = ComGetObjValue(f_bse_yr);
		var qta  = ComGetObjValue(f_bse_qtr_cd);
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
	var xmlDoc = ComGetXmlDoc(xml);
	if (xmlDoc == null) return;
	var xmlRoot = xmlDoc.documentElement;

	var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
	if (etcDataNode == null) return;
	
	var etcNodes = etcDataNode.childNodes;
	if (etcDataNode == null) return;
	
	var etcs = new Array();
	for ( var i = 0; i < etcNodes.length; i++) {
		if (etcNodes[i].nodeType != 1)
			continue;
		var nodeKey = etcNodes[i].attributes[0].nodeValue;
		if (nodeKey && nodeKey != '') {
			var nodeValue = etcNodes[i].firstChild == null ? '' : (ComTrim(etcNodes[i].firstChild.wholeText) || etcNodes[i].firstChild.nodeValue);
			etcs[nodeKey] = nodeValue;
		}
	}
	return etcs;
}

/**
 * 결과 XML로 부터 MESSAGE를 추출하는 함수.
 *
 * @param 결과XML
 * @returns String
 */
function ComResultMessage(xmlStr){
	  return ComGetSelectSingleNode(xmlStr, "MESSAGE");
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
//					ComShowCodeMessage('CSQ00015','Load');
//					return false;
//				}else if(total_lod[x]<100){
//					ComShowCodeMessage('CSQ00014','Load');
//					return false;
//				}else if(total_rev[x]>100){
//					ComShowCodeMessage('CSQ00015','G.Rev');
//					return false;
//				}else if(total_rev[x]<100){
//					ComShowCodeMessage('CSQ00014','G.Rev');
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
//						ComShowCodeMessage('CSQ00015', 'Load' ,msg, total_lod);
//						return false;
//					}else if(total_lod<100){
//						ComShowCodeMessage('CSQ00014', 'Load' ,msg, total_lod);
//						return false;
//					}else if(total_rev>100){
//						ComShowCodeMessage('CSQ00015', 'G.Rev' ,msg, total_rev);
//						return false;
//					}else if(total_rev<100){
//						ComShowCodeMessage('CSQ00014', 'G.Rev' ,msg, total_rev);
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
//				ComShowCodeMessage('CSQ00015', 'Load' ,msg, sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto"));
//				return false;
//			}else if(sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto")<100){
//				ComShowCodeMessage('CSQ00014', 'Load' ,msg, sheetObj.CellValue(sheetObj.HeaderRows,"lod_potn_rto"));
//				return false;
//			}else if(sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto")>100){
//				ComShowCodeMessage('CSQ00015', 'G.Rev' ,msg, sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto"));
//				return false;
//			}else if(sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto")<100){
//				ComShowCodeMessage('CSQ00014', 'G.Rev' ,msg, sheetObj.CellValue(sheetObj.HeaderRows,"rev_potn_rto"));
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
	var total_lod=0;
	var total_rev=0;
	var msg1=new Array();
	var cnt1=0;
	var msg2=new Array();
	var cnt2=0;
	var lodRow=0;
	var revRow=0;
	var lodValue=0;
	var revValue=0;
	var result="";
	if ( sheetObj.RowCount()> 1 ) {	//조회된 데이터가 여러줄인 경우
	for ( var x=sheetObj.HeaderRows(); x < sheetObj.RowCount()+sheetObj.HeaderRows(); x++ ) {
		if ( x != sheetObj.RowCount()+sheetObj.HeaderRows()-1 ) {	// 마지막줄이 아닐때
				// trd, rlane, bound, rhq 다름 -> % 합산기준 달라짐
			if (sheetObj.GetCellValue(x, "trd_cd") != sheetObj.GetCellValue(x+1, "trd_cd")
					|| sheetObj.GetCellValue(x, "rlane_cd")    != sheetObj.GetCellValue(x+1, "rlane_cd")
					|| sheetObj.GetCellValue(x, "conv_dir_cd") != sheetObj.GetCellValue(x+1, "conv_dir_cd") ) {
				total_lod=(parseFloat(total_lod) + parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto"))).toFixed(2);
				total_rev=(parseFloat(total_rev) + parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto"))).toFixed(2);
				if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
						lodRow=x;
						lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
					}
				if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
						revRow=x;
						revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
					}
					if ( total_lod != 100 && total_lod != 0 ) {
						if ( total_lod == 99.99 ) {
							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) + 0.01,0);
						} else if ( total_lod == 100.01 ) {
							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) - 0.01,0);
						} else {
							msg1[cnt1]="";
							msg1[cnt1]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "=" + total_lod + "%\n";
							cnt1++;
						}
					}
					if ( total_rev != 100 && total_rev != 0 ) {
						if ( total_rev == 99.99 ) {
							sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) + 0.01,0);
						} else if ( total_rev == 100.01 ) {
							sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) - 0.01,0);
						} else {
							msg2[cnt2]="";
							msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "=" + total_rev + "%\n";
							cnt2++;
						}
					}
					total_lod=0;
					total_rev=0;
					lodRow=0;
					revRow=0;
					lodValue=0;
					revValue=0;
				} else {
					// trd, rlane, bound 가 같을때 같은 조건임을 표시
					total_lod=(parseFloat(total_lod) + parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto"))).toFixed(2);
					total_rev=(parseFloat(total_rev) + parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto"))).toFixed(2);
					if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
						lodRow=x;
						lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
					}
					if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
						revRow=x;
						revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
					}
				}
			} else {	// 마지막 row 일 때
				if (sheetObj.GetCellValue(x, "trd_cd")      == sheetObj.GetCellValue(x-1, "trd_cd")
						|| sheetObj.GetCellValue(x, "rlane_cd")    == sheetObj.GetCellValue(x-1, "rlane_cd")
						|| sheetObj.GetCellValue(x, "conv_dir_cd") == sheetObj.GetCellValue(x-1, "conv_dir_cd")) {
					// trd, rlane, bound 가 같을때
					total_lod=(parseFloat(total_lod)+ parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"))).toFixed(2);
					total_rev=(parseFloat(total_rev)+ parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"))).toFixed(2);
					if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
						lodRow=x;
						lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
					}
					if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
						revRow=x;
						revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
					}
					if ( total_lod != 100 && total_lod != 0 ) {
						if ( total_lod == 99.99 ) {
							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) + 0.01,0);
						} else if ( total_lod == 100.01 ) {
							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) - 0.01,0);
						} else {
							msg1[cnt1]="";
							msg1[cnt1]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "=" + total_lod + "%\n";
							cnt1++;
						}
					}
					if ( total_rev != 100 && total_rev != 0 ) {
						if ( total_rev == 99.99 ) {
							sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) + 0.01,0);
						} else if ( total_rev == 100.01 ) {
							sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) - 0.01,0);
						} else {
							msg2[cnt2]="";
							msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "=" + total_rev + "%\n";
							cnt2++;
						}
					}
				} else {	// trd, rlane, bound 다름
					total_lod=parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"));
					total_rev=parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"));
					if(total_lod != 100 && total_lod != 0){
						if ( total_lod == 99.99 ) {
							sheetObj.SetCellValue(x, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")) + 0.01,0);
						} else if ( total_lod == 100.01 ) {
							sheetObj.SetCellValue(x, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")) - 0.01,0);
						} else {
							msg1[cnt1]="";
							msg1[cnt1]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "=" + total_lod + "%\n";
	 					}
					}
					if ( total_rev != 100 && total_rev != 0 ) {
						if ( total_rev == 99.99 ) {
							sheetObj.SetCellValue(x, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")) + 0.01,0);
						} else if ( total_rev == 100.01 ) {
							sheetObj.SetCellValue(x, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")) - 0.01,0);
						} else {
							msg2[cnt2]="";
							msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "=" + total_rev + "%\n";
						}
					}
				}
			}
		}
	} else {	//조회된 데이터가 한줄밖에 없는 경우
		total_lod=parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(),"lod_potn_rto"));
		total_rev=parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(),"rev_potn_rto"));
		if ( total_lod != 100 && total_lod != 0 ) {
			if ( total_lod == 99.99 ) {
				sheetObj.SetCellValue(sheetObj.HeaderRows(), "lod_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "lod_potn_rto")) + 0.01,0);
			} else if ( total_lod == 100.01 ) {
				sheetObj.SetCellValue(sheetObj.HeaderRows(), "lod_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "lod_potn_rto")) - 0.01,0);
			} else {
				msg1[cnt1]="";
				msg1[cnt1]=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trd_cd")      + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rlane_cd")    + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "conv_dir_cd") + "=" + total_lod + "%\n";
			}
		}
		if ( total_rev != 100 && total_rev != 0 ) {
			if ( total_rev == 99.99 ) {
				sheetObj.SetCellValue(sheetObj.HeaderRows(), "rev_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "rev_potn_rto")) + 0.01,0);
			} else if ( total_rev == 100.01 ) {
				sheetObj.SetCellValue(sheetObj.HeaderRows(), "rev_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "rev_potn_rto")) - 0.01,0);
			} else {
				msg2[cnt2]="";
				msg2[cnt2]=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trd_cd")      + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rlane_cd")    + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "conv_dir_cd") + "=" + total_rev + "%\n";
			}
		}
	}
	if ( msg1.length > 0 || msg2.length > 0 ) {
		if ( msg1.length > 0 ) {
			for ( x=1; x < msg1.length; x++ ) {
				msg1[0]=msg1[0] + msg1[x];
			}
			result="Load Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg1[0];
		}
		if ( msg2.length > 0 ) {
			for ( x=1; x < msg2.length; x++ ) {
				msg2[0]=msg2[0] + msg2[x];
			}
			if ( result != "" )
				result=result + "\n\nG.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
			else
				result="G.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
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
	var total_lod=0;
	var total_rev=0;
	var msg1=new Array();
	var cnt1=0;
	var msg2=new Array();
	var cnt2=0;
	var lodRow=0;
	var revRow=0;
	var lodValue=0;
	var revValue=0;
	var result="";
	if ( sheetObj.RowCount()> 1 ) {	// 조회된 데이터가 여러줄인 경우
		for ( var x=sheetObj.HeaderRows(); x < sheetObj.RowCount()+sheetObj.HeaderRows(); x++ ) {
			if ( x != sheetObj.RowCount()+sheetObj.HeaderRows()-1 ) {	// 마지막줄이 아닐때
						// trd, rlane, bound, rhq 다름 -> %합산기준 달라짐
		if (    sheetObj.GetCellValue(x, "trd_cd")      != sheetObj.GetCellValue(x+1, "trd_cd")
		|| sheetObj.GetCellValue(x, "rlane_cd")    != sheetObj.GetCellValue(x+1, "rlane_cd")
		|| sheetObj.GetCellValue(x, "conv_dir_cd") != sheetObj.GetCellValue(x+1, "conv_dir_cd")
		|| sheetObj.GetCellValue(x, "rhq_cd")      != sheetObj.GetCellValue(x+1, "rhq_cd")) {
		total_lod=(parseFloat(total_lod)+ parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"))).toFixed(2);
		total_rev=(parseFloat(total_rev)+ parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"))).toFixed(2);
		if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
			lodRow=x;
			lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
		}
		if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
			revRow=x;
			revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
		}
		if ( total_lod != 100 && total_lod != 0 ) {
			if ( total_lod == 99.99 ) {
				sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) + 0.01,0);
			} else if ( total_lod == 100.01 ) {
				sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) - 0.01,0);
			} else {
				msg1[cnt1]="";
				msg1[cnt1]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
				+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
				+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
				+ sheetObj.GetCellValue(x, "rhq_cd")      + "=" + total_lod + "%\n";
				cnt1++;
			}
		}
		if ( total_rev != 100 && total_rev != 0 ) {
			if ( total_rev == 99.99 ) {
				sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) + 0.01,0);
			} else if ( total_rev == 100.01 ) {
				sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) - 0.01,0);
			} else {
				msg2[cnt2]="";
				msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
				+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
				+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
				+ sheetObj.GetCellValue(x, "rhq_cd")      + "=" + total_rev + "%\n";
									cnt2++;
			}
		}
		total_lod=0;
		total_rev=0;
		lodRow=0;
		revRow=0;
		lodValue=0;
		revValue=0;
	} else {
							// trd, rlane, bound, rhq 가 같을때 같은 조건임을 표시
		total_lod=(parseFloat(total_lod)+ parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"))).toFixed(2);
		total_rev=(parseFloat(total_rev)+ parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"))).toFixed(2);
		if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
								lodRow=x;
		lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
							}
		if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
								revRow=x;
		revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
							}
						}
					} else {	// 마지막 row 일 때
		if (    sheetObj.GetCellValue(x, "trd_cd")      == sheetObj.GetCellValue(x-1, "trd_cd")
		|| sheetObj.GetCellValue(x, "rlane_cd")    == sheetObj.GetCellValue(x-1, "rlane_cd")
		|| sheetObj.GetCellValue(x, "conv_dir_cd") == sheetObj.GetCellValue(x-1, "conv_dir_cd")
		|| sheetObj.GetCellValue(x, "rhq_cd")      == sheetObj.GetCellValue(x-1, "rhq_cd") ) {
							// trd, rlane, bound, rhq 가 같을때
		total_lod=(parseFloat(total_lod)+ parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"))).toFixed(2);
		total_rev=(parseFloat(total_rev)+ parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"))).toFixed(2);
		if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
								lodRow=x;
		lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
							}
		if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
								revRow=x;
		revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
							}
							if ( total_lod != 100 && total_lod != 0 ) {
								if ( total_lod == 99.99 ) {
		sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) + 0.01,0);
								} else if ( total_lod == 100.01 ) {
		sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) - 0.01,0);
								} else {
									msg1[cnt1]="";
		msg1[cnt1]=sheetObj.GetCellValue(x ,"trd_cd")      + "-"
		+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
		+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
		+ sheetObj.GetCellValue(x, "rhq_cd")      + "=" + total_lod + "%\n";
									cnt1++;
								}
							}
							if ( total_rev != 100 && total_rev != 0 ) {
								if ( total_rev == 99.99 ) {
		sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) + 0.01,0);
								} else if ( total_rev == 100.01 ) {
		sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) - 0.01,0);
								} else {
									msg2[cnt2]="";
		msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
		+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
		+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
		+ sheetObj.GetCellValue(x, "rhq_cd")      + "=" + total_rev + "%\n";
									cnt2++;
								}
							}
						} else {	// trd, rlane, bound, rhq 다름
		total_lod=parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"));
		total_rev=parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"));
							if ( total_lod != 100 && total_lod != 0 ) {
								if ( total_lod == 99.99 ) {
		sheetObj.SetCellValue(x, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")) + 0.01,0);
								} else if ( total_lod == 100.01 ) {
		sheetObj.SetCellValue(x, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")) - 0.01,0);
								} else {
									msg1[cnt1]="";
		msg1[cnt1]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
		+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
		+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
		+ sheetObj.GetCellValue(x, "rhq_cd")      + "=" + total_lod + "%\n";
								}
							}
							if ( total_rev != 100 && total_rev != 0 ) {
								if ( total_rev == 99.99 ) {
		sheetObj.SetCellValue(x, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")) + 0.01,0);
								} else if ( total_rev == 100.01 ) {
		sheetObj.SetCellValue(x, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")) - 0.01,0);
								} else {
									msg2[cnt2]="";
		msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")         + "-"
		+ sheetObj.GetCellValue(x, "rlane_cd")       + "-"
		+ sheetObj.GetCellValue(x, "conv_dir_cd")    + "-"
		+ sheetObj.GetCellValue(x, "rhq_cd") + "=" + total_rev + "%\n";
								}
							}
						}
					}
				}
			} else {	// 조회된 데이터가 한줄밖에 없는 경우
		total_lod=parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(),"lod_potn_rto"));
		total_rev=parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(),"rev_potn_rto"));
				if ( total_lod != 100 && total_lod != 0 ) {
					if ( total_lod == 99.99 ) {
		sheetObj.SetCellValue(sheetObj.HeaderRows(), "lod_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "lod_potn_rto")) + 0.01,0);
					} else if ( total_lod == 100.01 ) {
		sheetObj.SetCellValue(sheetObj.HeaderRows(), "lod_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "lod_potn_rto")) - 0.01,0);
					} else {
						msg1[cnt1]="";
		msg1[cnt1]=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trd_cd")      + "-"
		+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rlane_cd")    + "-"
		+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "conv_dir_cd") + "-"
		+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rhq_cd")      + "=" + total_lod + "%\n";
					}
				}
				if ( total_rev != 100 && total_rev != 0 ) {
					if ( total_rev == 99.99 ) {
		sheetObj.SetCellValue(sheetObj.HeaderRows(), "rev_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "rev_potn_rto")) + 0.01,0);
					} else if ( total_rev == 100.01 ) {
		sheetObj.SetCellValue(sheetObj.HeaderRows(), "rev_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "rev_potn_rto")) - 0.01,0);
					} else {
						msg2[cnt2]="";
		msg2[cnt2]=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trd_cd")      + "-"
		+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rlane_cd")    + "-"
		+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "conv_dir_cd") + "-"
		+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rhq_cd")      + "=" + total_rev + "%\n";
					}
				}
			}
			if ( msg1.length > 0 || msg2.length > 0 ) {
				if ( msg1.length > 0 ) {
					for ( x=1; x < msg1.length; x++ ) {
						msg1[0]=msg1[0] + msg1[x];
					}
					result="Load Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg1[0];
				}
				if ( msg2.length > 0 ){
					for ( x=1; x < msg2.length; x++ ) {
						msg2[0]=msg2[0] + msg2[x];
					}
					if ( result != "" )
						result=result + "\n\nG.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
					else
						result="G.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
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
 	var total_lod=0;
 	var total_rev=0;
 	var msg1=new Array();
 	var cnt1=0;
 	var msg2=new Array();
 	var cnt2=0;
 	var lodRow=0;
 	var revRow=0;
 	var lodValue=0;
 	var revValue=0;
 	var result="";
 	if ( sheetObj.RowCount()> 1 ) {	//조회된 데이터가 여러줄인 경우
	for ( var x=sheetObj.HeaderRows(); x < sheetObj.RowCount()+sheetObj.HeaderRows(); x++ ) {
		if ( x != sheetObj.RowCount()+sheetObj.HeaderRows()-1 ) {	// 마지막줄이 아닐	
 				// trd, rlane, bound, rhq 다름 -> % 합산기준 달라짐
	if (    sheetObj.GetCellValue(x, "trd_cd")      != sheetObj.GetCellValue(x+1, "trd_cd")
				|| sheetObj.GetCellValue(x, "rlane_cd")    != sheetObj.GetCellValue(x+1, "rlane_cd")
				|| sheetObj.GetCellValue(x, "conv_dir_cd") != sheetObj.GetCellValue(x+1, "conv_dir_cd")
				|| sheetObj.GetCellValue(x, "grp_no")      != sheetObj.GetCellValue(x+1, "grp_no")) {
				total_lod=(parseFloat(total_lod) + parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto"))).toFixed(2);
				total_rev=(parseFloat(total_rev) + parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto"))).toFixed(2);
	if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow=x;
 						lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
		 					}
				if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
		 						revRow=x;
		 						revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
		 					}
		 					if ( total_lod != 100 && total_lod != 0 ) {
		 						if ( total_lod == 99.99 ) {
		 							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) + 0.01,0);
		 						} else if ( total_lod == 100.01 ) {
		 							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) - 0.01,0);
 						} else {
 							msg1[cnt1]="";
							msg1[cnt1]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_lod + "%\n";
 							cnt1++;
 						}
 					}
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 								sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) + 0.01,0);
 						} else if ( total_rev == 100.01 ) {
 								sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) - 0.01,0);
 						} else {
 							msg2[cnt2]="";
							msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_rev + "%\n";
 							cnt2++;
 						}
 					}
 					total_lod=0;
 					total_rev=0;
 					lodRow=0;
 					revRow=0;
 					lodValue=0;
 					revValue=0;
 				} else {
 					// trd, rlane, bound 가 같을때 같은 조건임을 표시
						total_lod=(parseFloat(total_lod) + parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto"))).toFixed(2);
						total_rev=(parseFloat(total_rev) + parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto"))).toFixed(2);
						if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow=x;
 						lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
 					}
						if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow=x;
 						revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 				}
 			} else {	// 마지막 row 일 때
						if (    sheetObj.GetCellValue(x, "trd_cd")      == sheetObj.GetCellValue(x-1, "trd_cd")
						|| sheetObj.GetCellValue(x, "rlane_cd")    == sheetObj.GetCellValue(x-1, "rlane_cd")
						|| sheetObj.GetCellValue(x, "conv_dir_cd") == sheetObj.GetCellValue(x-1, "conv_dir_cd")
						|| sheetObj.GetCellValue(x, "grp_no")      != sheetObj.GetCellValue(x+1, "grp_no")) {
 					// trd, rlane, bound 가 같을때
						total_lod=(parseFloat(total_lod)+ parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"))).toFixed(2);
						total_rev=(parseFloat(total_rev)+ parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"))).toFixed(2);
						if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow=x;
 						lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
 					}
						if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow=x;
 						revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 					if ( total_lod != 100 && total_lod != 0 ) {
 						if ( total_lod == 99.99 ) {
 							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) + 0.01,0);
 						} else if ( total_lod == 100.01 ) {
 							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) - 0.01,0);
 						} else {
 							msg1[cnt1]="";
 							msg1[cnt1]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
 							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
 							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
 							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_lod + "%\n";
 							cnt1++;
 						}
 					}
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) + 0.01,0);
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) - 0.01,0);
 						} else {
 							msg2[cnt2]="";
 							msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
 							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
 							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
 							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_rev + "%\n";
 							cnt2++;
 						}
 					}
 				} else {	// trd, rlane, bound 다름
							total_lod=parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"));
							total_rev=parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"));
 					if(total_lod != 100 && total_lod != 0){
 						if ( total_lod == 99.99 ) {
 								sheetObj.SetCellValue(x, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")) + 0.01,0);
 						} else if ( total_lod == 100.01 ) {
 								sheetObj.SetCellValue(x, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")) - 0.01,0);
 						} else {
 							msg1[cnt1]="";
							msg1[cnt1]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_lod + "%\n";
 	 					}
 					}
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.SetCellValue(x, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")) + 0.01,0);
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.SetCellValue(x, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")) - 0.01,0);
 						} else {
 							msg2[cnt2]="";
							msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_rev + "%\n";
 						}
 					}
 				}
 			}
 		}
 				} else {	//조회된 데이터가 한줄밖에 없는 경우
							total_lod=parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(),"lod_potn_rto"));
							total_rev=parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(),"rev_potn_rto"));
 		if ( total_lod != 100 && total_lod != 0 ) {
 			if ( total_lod == 99.99 ) {
 				sheetObj.SetCellValue(sheetObj.HeaderRows(), "lod_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "lod_potn_rto")) + 0.01,0);
 			} else if ( total_lod == 100.01 ) {
 				sheetObj.SetCellValue(sheetObj.HeaderRows(), "lod_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "lod_potn_rto")) - 0.01,0);
 			} else {
 				msg1[cnt1]="";
				msg1[cnt1]=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trd_cd")      + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rlane_cd")    + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "conv_dir_cd") + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "aply_fm_yrwk")+ "=" + total_lod + "%\n";
 			}
 		}
 		if ( total_rev != 100 && total_rev != 0 ) {
 			if ( total_rev == 99.99 ) {
 				sheetObj.SetCellValue(sheetObj.HeaderRows(), "rev_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "rev_potn_rto")) + 0.01,0);
 			} else if ( total_rev == 100.01 ) {
 				sheetObj.SetCellValue(sheetObj.HeaderRows(), "rev_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "rev_potn_rto")) - 0.01,0);
 			} else {
 				msg2[cnt2]="";
				msg2[cnt2]=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trd_cd")      + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rlane_cd")    + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "conv_dir_cd") + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "aply_fm_yrwk")+ "=" + total_rev + "%\n";
 			}
 		}
 	}
 	if ( msg1.length > 0 || msg2.length > 0 ) {
 		if ( msg1.length > 0 ) {
 			for ( x=1; x < msg1.length; x++ ) {
 				msg1[0]=msg1[0] + msg1[x];
 			}
 			result="Load Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound-Week' portion.\n\n " + msg1[0];
 		}
 		if ( msg2.length > 0 ) {
 			for ( x=1; x < msg2.length; x++ ) {
 				msg2[0]=msg2[0] + msg2[x];
 			}
 			if ( result != "" )
 				result=result + "\n\nG.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound-Week' portion.\n\n " + msg2[0];
 			else
 				result="G.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound-Week' portion.\n\n " + msg2[0];
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
 	var total_lod=0;
 	var total_rev=0;
 	var msg1=new Array();
 	var cnt1=0;
 	var msg2=new Array();
 	var cnt2=0;
 	var lodRow=0;
 	var revRow=0;
 	var lodValue=0;
 	var revValue=0;
 	var result="";
 	if ( sheetObj.RowCount()> 1 ) {	// 조회된 데이터가 여러줄인 경우
	for ( var x=sheetObj.HeaderRows(); x < sheetObj.RowCount()+sheetObj.HeaderRows(); x++ ) {
		if ( x != sheetObj.RowCount()+sheetObj.HeaderRows()-1 ) {	// 마지막줄이 아닐때
			if (    sheetObj.GetCellValue(x, "trd_cd")      != sheetObj.GetCellValue(x+1, "trd_cd")
			|| sheetObj.GetCellValue(x, "rlane_cd")    != sheetObj.GetCellValue(x+1, "rlane_cd")
			|| sheetObj.GetCellValue(x, "conv_dir_cd") != sheetObj.GetCellValue(x+1, "conv_dir_cd")
			|| sheetObj.GetCellValue(x, "rhq_cd")      != sheetObj.GetCellValue(x+1, "rhq_cd")
			|| sheetObj.GetCellValue(x, "grp_no")      != sheetObj.GetCellValue(x+1, "grp_no")) {
			total_lod=(parseFloat(total_lod)+ parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"))).toFixed(2);
			total_rev=(parseFloat(total_rev)+ parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"))).toFixed(2);
			if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow=x;
 						lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
 					}
			if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow=x;
 						revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 					if ( total_lod != 100 && total_lod != 0 ) {
 						if ( total_lod == 99.99 ) {
 							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) + 0.01,0);
 						} else if ( total_lod == 100.01 ) {
 							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) - 0.01,0);
 						} else {
 							msg1[cnt1]="";
							msg1[cnt1]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
							+ sheetObj.GetCellValue(x, "rhq_cd")      + "-"
							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_lod + "%\n";
 							cnt1++;
 						}
 					}
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) + 0.01,0);
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) - 0.01,0);
 						} else {
 							msg2[cnt2]="";
							msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
							+ sheetObj.GetCellValue(x, "rhq_cd")      + "-"
							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_rev + "%\n";
 							cnt2++;
 						}
 					}
 					total_lod=0;
 					total_rev=0;
 					lodRow=0;
 					revRow=0;
 					lodValue=0;
 					revValue=0;
 				} else {
 					// trd, rlane, bound, rhq 가 같을때 같은 조건임을 표시
						total_lod=(parseFloat(total_lod)+ parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"))).toFixed(2);
						total_rev=(parseFloat(total_rev)+ parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"))).toFixed(2);
						if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow=x;
						lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
 					}
						if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow=x;
 						revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 				}
 			} else {	// 마지막 row 일 때
						if (    sheetObj.GetCellValue(x, "trd_cd")      == sheetObj.GetCellValue(x-1, "trd_cd")
						|| sheetObj.GetCellValue(x, "rlane_cd")    == sheetObj.GetCellValue(x-1, "rlane_cd")
						|| sheetObj.GetCellValue(x, "conv_dir_cd") == sheetObj.GetCellValue(x-1, "conv_dir_cd")
						|| sheetObj.GetCellValue(x, "rhq_cd")      == sheetObj.GetCellValue(x-1, "rhq_cd")
						|| sheetObj.GetCellValue(x, "grp_no")      == sheetObj.GetCellValue(x-1, "grp_no")) {
 					// trd, rlane, bound, rhq 가 같을때
						total_lod=(parseFloat(total_lod)+ parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"))).toFixed(2);
						total_rev=(parseFloat(total_rev)+ parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"))).toFixed(2);
						if ( lodValue < parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2) ) {
 						lodRow=x;
 						lodValue=parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")).toFixed(2);
 					}
						if ( revValue < parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2) ) {
 						revRow=x;
 						revValue=parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")).toFixed(2);
 					}
 					if ( total_lod != 100 && total_lod != 0 ) {
 						if ( total_lod == 99.99 ) {
 							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) + 0.01,0);
 						} else if ( total_lod == 100.01 ) {
 							sheetObj.SetCellValue(lodRow, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(lodRow, "lod_potn_rto")) - 0.01,0);
 						} else {
 							msg1[cnt1]="";
							msg1[cnt1]=sheetObj.GetCellValue(x ,"trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
							+ sheetObj.GetCellValue(x, "rhq_cd")      + "-"
							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_lod + "%\n";
 							cnt1++;
 						}
 					}
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) + 0.01,0);
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.SetCellValue(revRow, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(revRow, "rev_potn_rto")) - 0.01,0);
 						} else {
 							msg2[cnt2]="";
							msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
							+ sheetObj.GetCellValue(x, "rhq_cd")      + "-"
							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_rev + "%\n";
 							cnt2++;
 						}
 					}
 				} else {	// trd, rlane, bound, rhq 다름
							total_lod=parseFloat(sheetObj.GetCellValue(x,"lod_potn_rto"));
							total_rev=parseFloat(sheetObj.GetCellValue(x,"rev_potn_rto"));
 					if ( total_lod != 100 && total_lod != 0 ) {
 						if ( total_lod == 99.99 ) {
							sheetObj.SetCellValue(x, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")) + 0.01,0);
 						} else if ( total_lod == 100.01 ) {
 							sheetObj.SetCellValue(x, "lod_potn_rto",parseFloat(sheetObj.GetCellValue(x, "lod_potn_rto")) - 0.01,0);
 						} else {
 							msg1[cnt1]="";
							msg1[cnt1]=sheetObj.GetCellValue(x, "trd_cd")      + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")    + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd") + "-"
							+ sheetObj.GetCellValue(x, "rhq_cd")      + "-"
							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")+ "=" + total_lod + "%\n";
 						}
 					}
 					if ( total_rev != 100 && total_rev != 0 ) {
 						if ( total_rev == 99.99 ) {
 							sheetObj.SetCellValue(x, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")) + 0.01,0);
 						} else if ( total_rev == 100.01 ) {
 							sheetObj.SetCellValue(x, "rev_potn_rto",parseFloat(sheetObj.GetCellValue(x, "rev_potn_rto")) - 0.01,0);
 						} else {
 							msg2[cnt2]="";
							msg2[cnt2]=sheetObj.GetCellValue(x, "trd_cd")         + "-"
							+ sheetObj.GetCellValue(x, "rlane_cd")       + "-"
							+ sheetObj.GetCellValue(x, "conv_dir_cd")    + "-"
							+ sheetObj.GetCellValue(x, "rhq_cd")         + "-"
							+ sheetObj.GetCellValue(x, "aply_fm_yrwk")   + "=" + total_rev + "%\n";
 						}
 					}
 				}
 			}
 		}
 	} else {	// 조회된 데이터가 한줄밖에 없는 경우
							total_lod=parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(),"lod_potn_rto"));
							total_rev=parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(),"rev_potn_rto"));
 		if ( total_lod != 100 && total_lod != 0 ) {
 			if ( total_lod == 99.99 ) {
 				sheetObj.SetCellValue(sheetObj.HeaderRows(), "lod_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "lod_potn_rto")) + 0.01,0);
 			} else if ( total_lod == 100.01 ) {
 				sheetObj.SetCellValue(sheetObj.HeaderRows(), "lod_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "lod_potn_rto")) - 0.01,0);
 			} else {
 				msg1[cnt1]="";
				msg1[cnt1]=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trd_cd")      + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rlane_cd")    + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "conv_dir_cd") + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rhq_cd")      + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "aply_fm_yrwk")+ "=" + total_lod + "%\n";
 			}
 		}
 		if ( total_rev != 100 && total_rev != 0 ) {
 			if ( total_rev == 99.99 ) {
				sheetObj.SetCellValue(sheetObj.HeaderRows(), "rev_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "rev_potn_rto")) + 0.01,0);
 			} else if ( total_rev == 100.01 ) {
 				sheetObj.SetCellValue(sheetObj.HeaderRows(), "rev_potn_rto",parseFloat(sheetObj.GetCellValue(sheetObj.HeaderRows(), "rev_potn_rto")) - 0.01,0);
 			} else {
 				msg2[cnt2]="";
				msg2[cnt2]=sheetObj.GetCellValue(sheetObj.HeaderRows(), "trd_cd")      + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rlane_cd")    + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "conv_dir_cd") + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "rhq_cd")      + "-"
				+ sheetObj.GetCellValue(sheetObj.HeaderRows(), "aply_fm_yrwk")+ "=" + total_rev + "%\n";
 			}
 		}
 	}
 	if ( msg1.length > 0 || msg2.length > 0 ) {
 		if ( msg1.length > 0 ) {
 			for ( x=1; x < msg1.length; x++ ) {
 				msg1[0]=msg1[0] + msg1[x];
 			}
 			result="Load Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg1[0];
 		}
 		if ( msg2.length > 0 ){
 			for ( x=1; x < msg2.length; x++ ) {
 				msg2[0]=msg2[0] + msg2[x];
 			}
 			if ( result != "" )
 				result=result + "\n\nG.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
 			else
 				result="G.REV Portion TTL is not 100%.\nPlease check below 'Trade-Rlane-Bound' portion.\n\n " + msg2[0];
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
 	
 	for(var i=0; i < comboObj.GetItemCount(); i++) {
 		if ( code.indexOf(comboObj.GetIndexText(i, 0)) != -1 ) {
 			rtn = rtn +  i + "|" ;
 		}
 	}
 	rtn = rtn.substr(0, rtn.length-1);
 	if (rtn == "") rtn = 0;
 	return rtn;
 }
  