/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : EES_DMT_7014.js
 *@FileTitle  : General Inventory
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/21
=========================================================*/
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var ROWMARK="|";
var FIELDMARK="=";
var SEARCHKEY=102;
var sheetObjects=new Array();
var sheetCnt=0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	// 스크립트 에러 위치를 확인하기 위해 주석처리
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
			case "btn_add":
				doActionAdd();
				break;
			case "btn_del":
				doActionDel();
				break;	
		} // end switch
    }catch(e) {
        if( e == "[object Error]") {
        	ComShowMessage(OBJECT_ERROR);
        } else {
        	ComShowMessage(e.message);
        }
    }
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
  	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
  	//sheetObj.SetGetWaitImageVisible(0);
	for (i=0; i < sheetObjects.length; i++) {
	    doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	}
	var formObj=document.form
	doActionIBCommon(sheetObjects[0],formObj,"cnt_cd",false);
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	//sheetObj.SetGetWaitImageVisible()(1);
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	//with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	//}
	return true;
}
 /**
  * IBSheet Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에
 * 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	with (sheetObj) {		
		var HeadTitle="||Seq.|Country|Weekend Type|Create User|Create Office|Create Date|Update User|Update Office|Update Date";
		var headCount=ComCountHeadTitle(HeadTitle);
		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		var headers = [ { Text:HeadTitle, Align:"Center"} ];
		InitHeaders(headers, info);
		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		 {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		 {Type:"ComboEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
		 {Type:"ComboEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"wknd_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
		 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		 {Type:"Text",   Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",  KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 }];
		InitColumns(cols);
		SetSheetHeight(535);
		SetEditable(1);
		SetColProperty("wknd_tp_cd", {ComboText:"Thursday,  Friday|Friday,  Saturday", ComboCode:"TF|FS"} );
		InitComboNoMatchText(1,"",1)
	}
}
 // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	var form=document.form;
	var sheetObject1=sheetObjects[0];
	switch (sAction) {
    	case IBSEARCH: // 조회
    		
    		// 조회결과 초기화 및 Sort 기능이 적용된 경우, 적용해제해 준다.
    		sheetObj.RemoveAll();	
    		
    		sheetObj.SetWaitImageVisible(0);
    		ComOpenWait(true);		 	
    		formObj.f_cmd.value=SEARCH;
    		sheetObj.DoSearch("EES_DMT_7014GS.do",FormQueryString(formObj) );
     		ComOpenWait(false);
            //4.데이터가 존재할 경우 
            if (sheetObj.RowCount()> 0) {
            	//4-1.버튼의 상태를 설정한다.
        		ComBtnEnable("btn_del");		//Delete 버튼
            }
            //5.데이터가 없을 경우
            else {
            	//5-1.버튼의 상태를 화면 로드되는 시점의 상태로 초기화 시킨다.
            	initBtnControl();
            }     		
    		break;
    	case IBSAVE: // 저장
			ComSetObjValue(formObj.f_cmd, MULTI);
			//그리드를 통해서 입력받은 정보로 저장/삭제 실행
			ComOpenWait(true);
			sheetObj.SetWaitImageVisible(0);
			sheetObj.DoSave("EES_DMT_7014GS.do", FormQueryString(formObj));
			break;		
    	case IBINSERT: // 입력
    		sheetObj.DataInsert();
    		// 히든 컬럼값 셋팅(CUD Query에서 필수 컬럼값)
			for(i=1; i < sheetObj.RowCount() + 1; i++){
				if(sheetObj.GetCellValue(i, "ibflag") == "D") {
    				continue;
    			}
    		}
            break;
    	case REMOVE: // 삭제
    		ComRowHideDelete(sheetObject1, "del_chk");
    		break;
	}
}
function doActionIBCommon(sheetObj,formObj,sComboField,sInitCellCombo) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	ComSetObjValue(formObj.f_cmd, SEARCHKEY);
	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
	var comboDatas=ComGetEtcData(sXml, "CNT");
	addCellComboItem(sheetObj,comboDatas,sComboField,sInitCellCombo);
	sheetObj.SetWaitImageVisible(1);
} 
/**
 * 중복 체크
 */
function sheet1_OnChange(sheetObj, Row, Col){
	var sheetObj=sheetObjects[0];
 	var formObj=document.form;
 	var cntCdCol=sheetObj.SaveNameCol("cnt_cd");
 	if (Col == cntCdCol && Row !=0) { 
 		var GetCellValue=sheetObj.GetCellValue(Row, Col);
 		var Row2=sheetObj.FindText(Col, GetCellValue, -1);
 		if(Row2 > 0){
 			Row2=sheetObj.FindText(Col, GetCellValue, Row2+1);
 			if (Row2 > 0) {
	        	ComShowCodeMessage('COM12115', 'Country');
	        	sheetObj.SetCellValue(Row, Col,'',0);
				sheetObj.SelectCell(Row, Col, true);
 			}
		}
	}
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg) {
    ComOpenWait(false);

    if (Msg != null && Msg != "") return;

    // 등록된 내용을 조회해서 보여준다.
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}

function sheet1_OnSort(sheetObj, Col, SortArrow) {
	sheetObj.ReNumberSeq();   
}

function addCellComboItem(sheetObj,comboDatas,sComboKey,isCellCombo,isOnlyTextView) {
	var sRow=sheetObj.GetSelectRow();
	var comboTxt="";
	var comboVal="";
	var comboItems;
	var comboItem;
	var comboInitTxt="";
	var comboInitVal="";
	if (comboDatas != undefined && ComTrim(comboDatas).length > 0) {
		comboItems=comboDatas.split(ROWMARK);
		for (var i=0 ; i < comboItems.length ; i++) {
			comboItem=comboItems[i].split(FIELDMARK);
			//InitDataCombo 메소드를 태울 경우 선택값을 주지 않을 경우
			//Code, Value 가 콤보에 나타나 글자가 밀리는 현상을 방지하기 위함.
			if (!isCellCombo && i == 0) {
				comboInitTxt=comboItem[0];
				comboInitVal=comboItem[0];
			}
			if (ComTrim(comboItem[0]) != "") {
			//Text 만 보여줘야 할 때
			if (isOnlyTextView) {
				comboTxt += comboItem[1];
			}
			//Text 가 '^' 을 구분자로 해서 내려올 때
			else if (comboItem[1].indexOf("\^") != -1) {
				comboTxt += comboItem[1].replace("^", " - ");
			}
			//Text 와 Code 를 둘 다 보여줘야 할 때
			else {
				comboTxt += comboItem[0] + "\t" + comboItem[1];
			}
			comboVal += comboItem[0];
		}
		else {
			comboTxt += " \t ";
			comboVal += " ";
		}
			if (i < comboItems.length-1) {
				comboTxt += ROWMARK;
				comboVal += ROWMARK;
			}				
		}
	}
	else {
		comboTxt += " \t ";
		comboVal += " ";			
	}
	var colName=sComboKey;
	if (isCellCombo) {
		sheetObj.CellComboItem(sRow,colName, {ComboText:comboTxt, ComboCode:comboVal} );
		sheetObj.SetGetCellValue(sRow,colName,"",0);
	}
	else {
		sheetObj.SetColProperty(colName, {ComboText:comboTxt, ComboCode:comboVal} );
	}
}
/**
* Row Add 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
*/	 
function doActionAdd() {
	var sheetObj=sheetObjects[0];
	//Row 가 추가되면 자동으로 Row Copy 와 Row Delete 버튼은 활성화된다.
	with(sheetObj) {
		DataInsert(-1);
	}
	if (!ComIsBtnEnable("btn_del")) 	ComBtnEnable("btn_del");
}
/**
* Delete 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
*/	 
 function doActionDel() {
 	var formObj=document.form;
 	var sheetObj=sheetObjects[0];
    var delRows=sheetObj.FindCheckedRow("del_chk");
    if (delRows == "") {
    	ComShowCodeMessage("DMT00140", "checkbox");
    	return;
    }
    var delRowArr=delRows.split(ROWMARK);
    //Row Delete시 "Do you want to delete [Value]?" Alert창을 띄우고 Yes시 조치
    var msg="delete Weekend Type";
    if (!ComShowCodeConfirm("DMT00135", msg)) return;
    //선택한 모든 ROW 를 삭제처리한다.
    for (var i = 0; i < delRowArr.length; i++) {
    	if (sheetObj.GetRowStatus(delRowArr[i]) == "I") {
			sheetObj.RowDelete(delRowArr[i], false);
		} else {
			sheetObj.SetRowStatus(delRowArr[i], "D");
			sheetObj.SetRowHidden(delRowArr[i], 1);
		}
    }
	//Row 가 모두 삭제되었다면 자동으로 Row Delete 버튼은 비활성화된다.
    if (fetchRowCount() == 0) {
     	if (ComIsBtnEnable("btn_del")) ComBtnDisable("btn_del");
    }
}
/**
 * 화면이 로드되는 시점에 버튼의 상태를 초기화 시킨다.
 */
function initBtnControl() {
	ComBtnEnable("btn_add");		//Row Add 버튼
	ComBtnEnable("btn_del");		//Delete 버튼
}	
/**
* 삭제되지 않은 전체 Row Count 를 구하는 함수 
*/ 	
function fetchRowCount() {
	var sheetObj=sheetObjects[0];
	var count=0;
	with(sheetObj) {
		for (var row = HeaderRows(); row <= LastRow(); row++) {
			if (GetRowStatus(row) != "D") count++;
		}
	}
	return count;
}
/* 개발자 작업 */