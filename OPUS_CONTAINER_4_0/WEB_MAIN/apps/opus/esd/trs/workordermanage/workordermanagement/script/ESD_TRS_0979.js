/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0979.js
*@FileTitle  : Multiple Inquiry(S/P)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/19
=========================================================*/
/* 공통전역변수 */
var curTab=1;
var beforetab=0;
var sheetObjects=new Array();
var sheetCnt=0;
var sheet=null
if(sheet == 2) {
	var sheetObj=sheetObjects[1];
} else {
	var sheetObj=sheetObjects[0];
}
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName = ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;
			case "btng_rowadd":
    			doActionIBSheet(sheetObject,formObject,IBINSERT);
			break;
			case "btng_apply":
				comPopupOK1(sheetObject,formObject);
			break;
			case "btn_close":
				ComClosePopup();
			break;
			case "btn_new":
				ComNew();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e);
		}
	}
}


function ComNew(){
	sheetObjects[0].RemoveAll();
	for(i=0; i < 6; i++) {
		sheetObjects[0].DataInsert(-1);
	}
	sheetObjects[0].SelectCell(1,"multiplekey");
	
	form.row_count.value = "1";
	
	var returnVal = form.returnval.value;
	
	var strCntrList = ""
		
	returnVal = "vndr_seq";
	strCntrList = eval("parent.form."+returnVal+"");
	strCntrList.value = "";
			
}
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(i=0; i < 6; i++) {
		sheetObjects[0].DataInsert(-1);
	}
	sheetObjects[0].SelectCell(1,"multiplekey");
	
	
	var returnVal = form.returnval.value;
	var strCntrList = "";
	returnVal = "vndr_seq";
	
	strCntrList = eval("parent.form."+returnVal+".value");
	
	if(strCntrList.length > 0) {
		var sheetCnt = sheetObjects[0].RowCount();
		var strCntr = strCntrList.split(",");
		var intCntrlength = strCntr.length;
		if(parseInt(sheetCnt) < parseInt(intCntrlength)) {
			
			for(var j=sheetCnt;j<intCntrlength;j++) {
				sheetObjects[0].DataInsert(-1);
			}
			sheetCnt = sheetObjects[0].RowCount();				
		}
		
		for(var i=1;i<=sheetCnt;i++) {
			sheetObjects[0].SetCellValue(i,"multiplekey",strCntr[i-1]);
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
            with(sheetObj){
				var HeadTitle="Seq.|Chk|header";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							 {Type:"PopupEdit",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"multiplekey",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 , AcceptKeys:"N"}  ];
							 
				InitColumns(cols);
				SetSheetHeight(ComGetSheetHeight(sheetObj, 7) + 30);
				SetEditable(1);
            }
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBINSERT:      // 입력
			var lvcnt=0;
			var lvrow=sheetObj.RowCount();
			lvcnt=eval(formObj.row_count.value);
			if( isNaN(formObj.row_count.value) || donumberheck(formObj.row_count.value)){
				formObj.row_count.value="1";				
			} 
			lvcnt=eval(formObj.row_count.value);
			for(i=0; i < lvcnt; i++){
				sheetObj.DataInsert(-1);
			}
			sheetObj.FitColWidth();
		break;
		case IBCOPYROW:        //행 복사
			sheetObj.DataCopy();
		break;
		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		break;
		case IBLOADEXCEL:        //엑셀 업로드
			sheetObj.LoadExcel();
		break;
	}
}
/**
 * Location 이나 Contry Code 입력시 이벤트처리 
 *
 */
function sheet1_OnChange(sheetObj, row, col, value){
	var formObject=document.form;
	var colName=sheetObj.ColSaveName(col);
	var inputStr=delSpace(value);
	switch(colName){
		case 'multiplekey':
			for (var i=0; i < inputStr.length; i++) {
				var oneChar=inputStr.charAt(i);
				if (oneChar != "") {
					if ( hanCheck(oneChar) ) {
						var errMessage=ComGetMsg('COM12127','Multiple Inquiry data!','','');  
						ComShowMessage(errMessage);
						sheetObj.SetCellValue(row,col,"");
						sheetObj.SelectCell(row, col);
						loopval="N";
						break;
					}else{
						continue;
					}
				} else {
					break;
				}
			}
			
			var chkval=ComTrim(sheetObj.GetCellValue(row, 'multiplekey'));
			if(chkval=="") {
				sheetObj.SetCellValue(row,'check',"0");
				sheetObj.SetCellValue(row,col,"");
			} else {
				sheetObj.SetCellValue(row,'check',"1");
			}
		break;
	}
}
// 한글 여부 체크.
// 입력 문자열이 한글이면 true, 한글이 아니면 false.
function hanCheck(str) {
	var str1=getByteLenval(str);
	if(str.length*2 == str1) // 한글이면
		return true;
	else    // 한글이 아니면
		return false;
}
// 입력받은 String의 Byte Size를 구한다.
function getByteLenval(str) {
	var len=0;
	if( str == null ) return 0;
	for( var i=0 ; i < str.length ; i++ ) {
		var c=escape(str.charAt(i));
		if ( c.length == 1 ) len ++;
		else if( c.indexOf("%u") != -1 ) len += 2;
		else if( c.indexOf("%") != -1 ) len += c.length/3;
	}
	return len;
} 
// 문자열 사이의 공백을 제거
function delSpace(str) {
	var trimstr=str;
	for (var i=0; i< str.length;i++) {
		trimstr=trimstr.replace(' ' ,'');
	}
	return trimstr;
}
function comPopupOK1(sheetObj,formObject) {
	
	var iCnt=0
	var return_val=formObject.returnval.value;

	var sCheckRows = sheetObj.FindCheckedRow("check");

	var arrRow = sCheckRows.split("|");

	if(sCheckRows == "") return ComShowCodeMessage("TRS90036");

	var rArray=new Array(arrRow.length);	
	
	var chkval="";
	var row=0;
	var dupVal="";
	for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
		sheetObj.SetRowBackColor(i,"#FFFFFF");
	}
	
	for(var idx=0; idx<arrRow.length; idx++){
		row = arrRow[idx];
		
		chkval=sheetObj.GetCellValue(row, "multiplekey");
		if(chkval=="") {
			var errMessage=ComGetMsg("COM12114","Multiple Inquiry data!","","");  
			ComShowMessage(errMessage);
			sheetObj.SelectCell(row, "multiplekey");
			return;
		}
		//중복체크
		for(var j=idx+1; j<arrRow.length; j++){
			var row2 = arrRow[j];
			if (chkval == sheetObj.GetCellValue(row2, "multiplekey")){
				sheetObj.SetRowBackColor(row2,"#FFFF00");
				if (dupVal=="") dupVal=row2;
			}
		}
		rArray[idx]= ComLpad(chkval,6,"0");
		
	}

	if(dupVal!=""){
		var errMessage=ComGetMsg("COM12115","Multiple Inquiry data!","","");  
		ComShowMessage(errMessage);
		sheetObj.SelectCell(dupVal, "multiplekey");
	}else{
		var opener = window.dialogArguments;
		if (!opener) {
			opener=window.opener; 
		}
		if (!opener) {
			opener=parent; 
		}
		opener.getTRS_ENS_979(rArray,return_val);  //호출하는 부모js에 getTRS_ENS_978펑션을 붙여넣으면됩니다.
		ComClosePopup();
	}	
}
/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_979(rowArray,return_val) {
	var formObject=document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=ComLpad(rowArray[i],6,"0");
		//formObject.sheet1.CellValue2(row_val, col_val) = colArray;
	}
}

function sheet1_OnKey(sheetObj, row, col, keycode, Shift) {
	if( keycode == 9 || keycode == 13 ){
		sheetObj.SelectCell(row, 'multiplekey');
	}
}
/**
 * 숫자에 대한 유효성을 체크.
 */
function donumberheck(obj) {
	var lveng=/[0-9]/;
	if( lveng.test(obj) ) {
		return false;
	}
	return true;
}


function sheet1_OnPopupClick(sheetObj, Row,Col){
	var formObj=document.form;
	if (sheetObj.ColSaveName(Col) != "multiplekey") return;
	//clicked row
	formObj.curr_row.value=Row;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do?parentPgmNo=ESD_TRS_M001', 700, 555, 'setPopData_Sp', '1,0,1,1,1,1,1,1', false);
}

/** 
 * (Service Provider) Function of processing for pop-up screen return value<br>
 * @param {arry} returnedValues Returned value array of pop-up screen
 * @param Row The object is row index in case of IBSheet
 * @param Col The object is column index in case of IBSheet
 * @param The object is sheet index in case of IBSheet
 */
function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
	var formObj=document.form;
	var row = formObj.curr_row.value;
	if ( aryPopupData.length > 0 ) {
		sheet1.SetCellValue(row,"multiplekey",ComLpad(aryPopupData[0][2],6,"0"));
	}
}

