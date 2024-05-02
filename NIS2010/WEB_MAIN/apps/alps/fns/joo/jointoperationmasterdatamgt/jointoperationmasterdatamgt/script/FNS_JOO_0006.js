/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0006.js
 *@FileTitle : Carrier Merge
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.05.11 박희동
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class fns_joo_0006 : fns_joo_0006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0006() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var curRow = 1;
var gVVD = "";
//sheet내의 lane code를 trade에 따라 선택할 수 있도록 하는 이차원배열
//gLaneComboItem[inx][0] => TRADE CODE;
//gLaneComboItem[inx][1] => LANE CODE;
var gLaneComboItem; 

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	
	/*******************************************************/
	var formObj = document.form;
	var prefix = "sheet1_";
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_add":
			var inx = sheetObject.DataInsert();
			sheetObject.CellValue(inx, prefix+"trd_cd") = "";
			sheetObject.CellValue(inx, prefix+"rlane_cd") = "";
			sheetObject.CellValue(inx, prefix+"acctg_crr_cd") = "";
			sheetObject.CellValue(inx, prefix+"jo_n1st_crr_cd") = "";
			sheetObject.CellValue(inx, prefix+"eff_eta_dt") = "99991231";
			sheetObject.CellValue(inx, prefix+"delt_flg") = "N";
			sheetObject.CellValue(inx, prefix+"skd_dir_cd") = "";
			sheetObject.SelectCell(inx,prefix+"trd_cd",true);
			break;

		case "btn_delete":
			JooRowHideDelete(sheetObject, prefix+"del_chk");
			break;

		case "btn_retrive":
			doActionIBSheet(sheetObject, formObj, IBSEARCH);
			break;

		case "btn_new":
			sheetObject.RemoveAll();
			formObj.trd_cd.Index2 = -1;
			formObj.rlane_cd.Index2 = -1;
			break;

		case "btn_save":
			doActionIBSheet(sheetObject, formObj, IBSAVE);
			break;

		case "btn_downExcel":
			sheetObject.SpeedDown2Excel();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/** 
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++] = combo_obj;  
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(tradeComboList, tradeSheetList, rlaneSheetList, carriSheetList, dirctSheetList) {
	//전역변수 2차원 배열 setting 
	//gLaneComboItem[inx][0] ==> TRADE 코드
	//gLaneComboItem[inx][1] ==> RLANE 코드
	gLaneComboItem = rlaneSheetList.split("|");
	var rlaneCombo = "";
	for (var inx=0; inx<gLaneComboItem.length; inx++){
		gLaneComboItem[inx] = gLaneComboItem[inx].split(",");
		rlaneCombo += gLaneComboItem[inx][1] + "|";
	}
	
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1, tradeSheetList, rlaneCombo, carriSheetList, dirctSheetList);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1, tradeComboList);
    }
    
    initControl();
}

function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj);
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj);
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
    
    formObj.trd_cd.focus();
}

function form_keyup(){
	ComKeyEnter('lengthnextfocus');  
} 

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo, tradeSheetList, rlaneSheetList, carriSheetList, dirctSheetList) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 420;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(13, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "STS||Trade|Lane|ACCT.Carrier|Carrier _ F|Carrier _ S|End Date|DEL_MK|VSL|VOY|Direction|Remark";

			var prefix="sheet1_";
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//InitComboNoMatchText(true); //COMBO에서 match된 data가 없어도 보여짐

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus    , 30, daCenter, true, prefix+"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox  , 30, daCenter, true, prefix+"del_chk"       , false, "", dfNone, 0);
			InitDataProperty(0, cnt++, dtCombo     , 60, daCenter, true, prefix+"trd_cd"        , true , "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo     , 70, daCenter, true, prefix+"rlane_cd"      , true , "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo     , 90, daCenter, true, prefix+"acctg_crr_cd"  , true , "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo     , 80, daCenter, true, prefix+"jo_n1st_crr_cd", true , "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtPopupEdit , 80, daCenter, true, prefix+"jo_n2nd_crr_cd", true , "", dfNone, 0, false, true, 3);
			InitDataProperty(0, cnt++, dtData      , 80, daCenter, true, prefix+"eff_eta_dt"    , true , "", dfUserFormat2, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo     , 60, daCenter, true, prefix+"delt_flg"      , false, "", dfNone, 0, true , true);
			InitDataProperty(0, cnt++, dtData      , 60, daCenter, true, prefix+"vsl_cd"        , false, "", dfNone, 0, true , true, 4);
			InitDataProperty(0, cnt++, dtData      , 60, daCenter, true, prefix+"skd_voy_no"    , false, "", dfNone, 0, true , true, 4);
			InitDataProperty(0, cnt++, dtCombo     , 60, daCenter, true, prefix+"skd_dir_cd"    , false, "", dfNone, 0, true , true);
			InitDataProperty(0, cnt++, dtData      , 94, daLeft  , true, prefix+"mrg_rmk"       , false, "", dfNone, 0, true , true,100);

			InitDataCombo(0, prefix+"trd_cd"        , tradeSheetList, tradeSheetList, "", "");
			InitDataCombo(0, prefix+"rlane_cd"      , rlaneSheetList, rlaneSheetList, "", "");
			InitDataCombo(0, prefix+"acctg_crr_cd"  , carriSheetList, carriSheetList, "", "");
			InitDataCombo(0, prefix+"jo_n1st_crr_cd", carriSheetList, carriSheetList, "", "");
			InitDataCombo(0, prefix+"delt_flg"      , "YES|NO"      , "Y|N");
			InitDataCombo(0, prefix+"skd_dir_cd"    , " |"+dirctSheetList, "|"+dirctSheetList);
			InitUserFormat2(0, prefix+"eff_eta_dt" , "####-##-##", "-");
			
			
			InitDataValid(0, prefix+"jo_n2nd_crr_cd", vtEngUpOnly);//영문대문자
			InitDataValid(0, prefix+"vsl_cd"    , vtEngUpOther, "0123456789");//영문대문자+숫자
			InitDataValid(0, prefix+"skd_voy_no", vtNumericOnly);//숫자만 올 수 있음
			InitDataValid(0, prefix+"mrg_rmk"   , vtEngOther, gVtOther); //영문
		}
		break;

	case 2: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
		}
		break;
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo, tradeComboList) {
    var formObj = document.form
    
    switch(comboNo) {  
    	//Trade
    	case 1: 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
 				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=3;
 		    }
           addComboItem(comboObj, tradeComboList.split("|"));           	
           
 			break; 

 		//Rlane
    	case 2: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=5;
  		    }
  			break;

  		//Carrier
    	case 3: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;
  				ValidChar(2,0);//영문대문자만 입력가능
  				MaxLength=3;
  		    }
  			break; 
 	} 
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj, sComboKey) {

    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
			if (sComboObj.id == "rlane_cd"){
				formObj.f_cmd.value = SEARCHLIST07;
				formObj.super_cd1.value = "";
				formObj.super_cd2.value = formObj.trd_cd.text;
				formObj.code.value = "";
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
				
				var comboItems = (",|"+ComGetEtcData(sXml, sComboKey)).split("|");
				addComboItem(sComboObj, comboItems);
			}else if (sComboObj.id == "jo_crr_cd"){
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();

				formObj.f_cmd.value = SEARCH02;            

                formObj.super_cd1.value = formObj.rlane_cd.Code;
                formObj.super_cd2.value = formObj.trd_cd.Code;
                
                var param =  FormQueryString(formObj);
                var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
				var comboItems = (",|"+ComGetEtcData(sXml, sComboKey)).split("|");
				addComboItem(sComboObj, comboItems);
			}
														
	        break;
    }
}

/**
 * Trade 변경시 Reset
 * @param comboObj
 * @param idx_cd
 * @param text
 * @return
 */
function trd_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();
	comboObjects[1].Index2 = -1;
	comboObjects[1].RemoveAll();
	comboObjects[2].Index2 = -1;
	comboObjects[2].RemoveAll();
}

/**
 * Rlane Focus 획득시 Rlane Combo 조회
 * @param comboObj
 * @return
 */
function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj, "rlane_cd");		
		comboObj.Enable = true;
	}
}

//LANE 변경시 Reset 
function rlane_cd_OnChange(comboObj){
	sheetObjects[0].RemoveAll();
	comboObjects[2].Index2 = -1;
	comboObjects[2].RemoveAll();
}

//Carrier코드 Focus 획득시 Carrier코드 LIST 조회
function jo_crr_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;
		doActionIBCombo(sheetObjects[1] , formObj ,IBSEARCH , comboObj, "jo_crr_cd");
		comboObj.Enable = true;
	}
}

//Carrier코드 변경시 Reset
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();	
}

/**
 * Sheet1 OnChange
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var prefix="sheet1_";
	var formObj = document.form;

	if (sheetObj.ColSaveName(Col)== prefix+"skd_dir_cd"){
		if (sheetObj.CellValue(Row, prefix+"vsl_cd").length==4){
			if (sheetObj.CellValue(Row, prefix+"skd_voy_no").length==4){
				curRow = Row; //현재 row
				gVVD = sheetObj.CellValue(Row, prefix+"vsl_cd")
				+sheetObj.CellValue(Row, prefix+"skd_voy_no")
				+sheetObj.CellValue(Row, prefix+"skd_dir_cd");
				doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
			}
		}
	}else 	if (sheetObj.ColSaveName(Col)== prefix+"vsl_cd"){
		if (sheetObj.CellValue(Row, prefix+"vsl_cd").length==4){
			if (sheetObj.CellValue(Row, prefix+"skd_voy_no").length==4){
				if (sheetObj.CellValue(Row, prefix+"skd_dir_cd").length==1){
					curRow = Row; //현재 row
					gVVD = sheetObj.CellValue(Row, prefix+"vsl_cd")
					+sheetObj.CellValue(Row, prefix+"skd_voy_no")
					+sheetObj.CellValue(Row, prefix+"skd_dir_cd");
					doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
				}
			}
		}
	}else 	if (sheetObj.ColSaveName(Col)== prefix+"skd_voy_no"){
		if (sheetObj.CellValue(Row, prefix+"vsl_cd").length==4){
			if (sheetObj.CellValue(Row, prefix+"skd_voy_no").length==4){
				if (sheetObj.CellValue(Row, prefix+"skd_dir_cd").length==1){
					curRow = Row; //현재 row
					gVVD = sheetObj.CellValue(Row, prefix+"vsl_cd")
					+sheetObj.CellValue(Row, prefix+"skd_voy_no")
					+sheetObj.CellValue(Row, prefix+"skd_dir_cd");
					doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
				}
			}
		}
	//Sheet내의 Trade 변경시 변경된 Trade에 해당하는 Rlane만 모아서 Rlane Combo를 setting한다. 
	}else if (sheetObj.ColSaveName(Col)== prefix+"trd_cd"){
		var trdCd = sheetObj.CellValue(Row, Col);
		UF_setLaneCombo(sheetObj, Row, trdCd);
	}
}

/**
 * Sheet내의 Trade 변경시 변경된 Trade에 해당하는 Rlane만 모아서 Rlane Combo를 setting한다.
 * @param sheetObj
 * @param Row
 * @param trdCd
 * @return
 */
function UF_setLaneCombo(sheetObj, Row, trdCd){
	var prefix="sheet1_";
	var laneItems = "";
	for (var inx=0; inx < gLaneComboItem.length; inx++){
		if (trdCd == gLaneComboItem[inx][0]){
			laneItems = laneItems + gLaneComboItem[inx][1] +"|";
		}
	}
	if (laneItems.length > 1){
		laneItems = laneItems.substring(0,laneItems.length-1);
	}
    sheetObj.CellComboItem(Row, prefix+"rlane_cd", laneItems, laneItems);
    sheetObj.CellValue2(Row, prefix+"rlane_cd") = ""; //Change Event가 발생하지 않는다.
}

/**
 * Carrier Code 조회하기 위함
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col){
	var prefix="sheet1_";
	if (sheetObj.ColSaveName(Col) == prefix+"jo_n2nd_crr_cd"){		
		ComOpenPopup('/hanjin/COM_ENS_0N1.do', 450, 455, 'getCOM_ENS_0N1', '1,0,1,1,1', false, false, Row, prefix+"jo_n2nd_crr_cd", 0);
	}
}

/**
 * Carrier Code Pop-UP 에서 OK 누른 후 실행되는 function
 * @param rowArray
 * @param Row
 * @param Col
 * @param sheetIdx
 * @return
 */
function getCOM_ENS_0N1(rowArray, Row, Col, sheetIdx){
	sheetObjects[sheetIdx].CellValue(Row, Col) = rowArray[0][3];
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회

		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = SEARCH;
	        var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0006GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			
			var arrXml = sXml.split("|$$|");
			sheetObj.LoadSearchXml(arrXml[0]);
		}
		break;

	case IBSAVE: //저장
		if (validateForm(sheetObj, formObj, sAction)){
			var SaveStr = ComGetSaveString(sheetObjects);
			
			if (SaveStr == ""){
				ComShowCodeMessage('JOO00036');
				return;
			}
			
			if (!ComShowCodeConfirm('JOO00046')){
				return;
			}
			
			var prefix="sheet1_";
			
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0006GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;

	// VVD 9자리 변경시
	case IBROWSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = SEARCHLIST08;
			formObj.code.value  = gVVD;
			formObj.super_cd1.value = "";
			formObj.super_cd2.value = "";
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
			
			if (ComGetEtcData(sXml,"CHECKVVD")=="E"){
				ComShowMessage(ComGetEtcData(sXml,"VVDMSG"));
				sheetObj.CellValue(curRow,"sheet1_"+"vsl_cd")=""; //VVD Clear
				sheetObj.CellValue(curRow,"sheet1_"+"skd_voy_no")=""; //VVD Clear
				sheetObj.CellValue(curRow,"sheet1_"+"skd_dir_cd")=""; //VVD Clear
				sheetObj.SelectCell(curRow,"sheet1_"+"vsl_cd",true);
			}
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var prefix="sheet1_";
	switch (sAction) {
		case IBSAVE:   //저장
			for(var inx=1; inx<=sheetObj.LastRow; inx++){
				var rowStatus = sheetObj.RowStatus(inx);
				//수정되지 않은 값은 skip
				if (rowStatus=="R"){
					continue;
				}
				
				//del_chk 체크만 한 경우를 방지하기 위함 
				if ((rowStatus == "I" || rowStatus == "U") && sheetObj.CellValue(inx,prefix+"del_chk") == "1"){
					ComShowCodeMessage("JOO00079");
					sheetObj.SelectCell(inx,prefix+"del_chk",true);
					return false;
				}
				
				//수정되지 않은 값은 skip
				if (rowStatus=="D"){
					continue;
				}
				
				if (sheetObj.CellValue(inx,prefix+"trd_cd").length < 3){
					ComShowCodeMessage('JOO00047',inx);
					sheetObj.SelectCell(inx,prefix+"trd_cd",true);
					return false;
				}

				if (sheetObj.CellValue(inx,prefix+"rlane_cd").length < 3){
					ComShowCodeMessage('JOO00048',inx);
					sheetObj.SelectCell(inx,prefix+"rlane_cd",true);
					return false;
				}

				if (sheetObj.CellValue(inx,prefix+"jo_n1st_crr_cd").length < 3){
					ComShowCodeMessage('JOO00049',inx);
					sheetObj.SelectCell(inx,prefix+"jo_n1st_crr_cd",true);
					return false;
				}

				if (sheetObj.CellValue(inx,prefix+"jo_n2nd_crr_cd").length < 3){
					ComShowCodeMessage('JOO00050',inx);
					sheetObj.SelectCell(inx,prefix+"jo_n2nd_crr_cd",true);
					return false;
				}
				
				//Carrier_M, Carrier_S가 같다면 error
				if (sheetObj.CellValue(inx,prefix+"jo_n1st_crr_cd") == sheetObj.CellValue(inx,prefix+"jo_n2nd_crr_cd")){
					ComShowCodeMessage('JOO00051',inx);
					sheetObj.SelectCell(inx,prefix+"jo_n2nd_crr_cd",true);
					return false;
				}
				
				var vslCd = sheetObj.CellValue(inx,prefix+"vsl_cd"); 
				var voyNo = sheetObj.CellValue(inx,prefix+"skd_voy_no");  
				var dirCd = sheetObj.CellValue(inx,prefix+"skd_dir_cd");
				
				//하나라도 입력되었다면 full로 입력할 것
				if ((vslCd.length > 0) || (voyNo.length > 0) || (dirCd.length > 0)){
					if (vslCd.legnth < 4){
						ComShowCodeMessage('JOO00040',inx);
						sheetObj.SelectCell(inx,prefix+"vsl_cd",true);
						return false;
					}

					if (voyNo.legnth < 4){
						ComShowCodeMessage('JOO00041',inx);
						sheetObj.SelectCell(inx,prefix+"skd_voy_no",true);
						return false;
					}
					
					if (dirCd.legnth < 1){
						ComShowCodeMessage('JOO00042',inx);
						sheetObj.SelectCell(inx,prefix+"skd_dir_cd",true);
						return false;
					}
				}
			}
			break;

		default:
			break;
	}
	return true;
}

/* 개발자 작업  끝 */