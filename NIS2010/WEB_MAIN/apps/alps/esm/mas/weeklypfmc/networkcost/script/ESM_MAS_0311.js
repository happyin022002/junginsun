/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0311.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
=========================================================
* History
*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0311 : ESM_MAS_0311 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0311() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.doActionIBSheet    = doActionIBSheet    ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var flagCreation = "";
var flagSave = "";

var flagStndCostCd = "";
var flagNowStndCostCd = "";
var flagStart = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
  var sheetObject = sheetObjects[0];
  var formObject = document.form;
  
  try {
    var srcName = window.event.srcElement.getAttribute("name");
    switch(srcName) {
      case "btn_Retrieve":
          doActionIBSheet(sheetObject,formObject,IBSEARCH);
          break;
      
      case "btn_Downexcel":
          doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
          break;
      
      case "btn_Save":
          doActionIBSheet(sheetObject,formObject,IBSAVE);
          break;
      
      case "btn_Create":
          doActionIBSheet(sheetObject,formObject,IBCREATE);
          break;          
          
	  case "btn_Close":
		  comPopupOK();
		  //self.close();
		  break;

    } // end switch
  } catch(e) {
    if( e == "[object Error]") {
      ComShowMessage(OBJECT_ERROR);
    } else {
      ComShowMessage(e);
    }
  } finally {
  	ComOpenWait(false);
  }
}

/**
 * 입력창에 지정한 주 셋팅
 * 사용 : setYrWk('2013', '25')
 *
 * @param Previous Week's year
 * @param Previous Week
 * @return NONE
 */    
function setYrWk(fYear,prevWeek){
	var formObj = document.form;
	with(formObj){
		var nowYear = fYear;
        f_yearweek.value = nowYear+prevWeek;	
        //if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
        //if(!ComAddSeparator(f_yearweek)) return false;
        if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
		f_yearweek.select();
		// 기간 표시     		
        setPeriod(f_yearweek);    		
	}

    fnYearWeekSet(document.getElementById("f_yearweek"));
}	

function fnYearWeekSet(obj){
    obj.value = ComGetMaskedValue(obj.value,"yw");
    setPeriod(obj);
}

function fnAmountSet(obj){
    obj.value = ComGetMaskedValue(obj.value,"int");
}

/**
 * month, week가 변경되었을때 Period를 변경한다.
 */
function setPeriod(obj){	
    ComMasSetPeriod2(obj);
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;
	flagStart = "Y";
	flagStndCostCd = formObj.stnd_cost_cd.value;
	flagNowStndCostCd = flagStndCostCd;
	
	
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }    
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);    
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    
    ComSetObjValue(formObj.f_cobcost, formObj.stnd_cost_cd.value);
    flagStart = "N";
}

/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {
	with (comboObj) {
		//DropHeight = 300;
		//Index = 0;		
		switch(comboObj.id) {
			case "f_cobcost":
				DropHeight = 300;
            	MaxLength = 5;
            	ValidChar(2, 3);	//영어 대문자, 숫자+특수문자 포함
 	    	 	InsertItem(0, 'Crew Expense', '54100000');
 	    	 	InsertItem(1, 'Insurance', '54250000');
 	    	 	InsertItem(2, 'Store supply Exp', '54200000');
 	    	 	InsertItem(3, 'Lubricant Exp', '54300000');
 	    	 	InsertItem(4, 'Vessel M&R', '54150000');
 	    	 	InsertItem(5, 'Depreciations', '54450000');
 	    	 	InsertItem(6, 'Telecom Exp', '54180000');
 	    	 	InsertItem(7, 'Other Operation Exp', '54550000');
 	    	 	InsertItem(8, 'Vessel Interest', '72100000');
 	    	 	Index = 0;           
  	            break;
		}
	}
}

/**
 * IBCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;

    switch(sheetNo) {
        case 1:      //sheet1 init
            with (sheetObj) {
                SheetWidth = mainTable.clientWidth;
            //전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                InitRowInfo(1 , 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(10, 0, 0, true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                var HeadTitle0  = "STS|YYYY-MM|WK|Vessel code|Original TTL Cost|Ratio(%)|Distributed Cost|H/B|ttl_amt|stnd_cost_cd";
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle0, true);
                
                //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,     cnt++,  dtStatus, 		30,     daCenter,   true,       "ibflag");
                InitDataProperty(0,     cnt++,  dtData,         80,     daCenter,   true,       "cost_yr",          false,     "",        dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,         50,     daCenter,   true,       "cost_wk",          false,     "",        dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,       "vsl_cd",		    false,     "",        dfNone,       0,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        180,     daRight,    true,       "vsl_amt",          false,     "",        dfFloatOrg,   2,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        110,     daCenter,   true,       "vsl_dtrb_rt",      false,     "",        dfFloatOrg,   2,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,    	   180,     daRight,    true,       "vsl_dtrb_amt",     false,     "",        dfFloatOrg,   2,  false,  false);
                InitDataProperty(0,     cnt++,  dtData,        120,     daRight,    true,       "dhir_amt",         false,     "",        dfFloatOrg,   2,  true,  true);
                InitDataProperty(0,     cnt++,  dtHidden,      120,     daRight,    true,       "ttl_amt",          false,     "",        dfInteger,    0,  false,   false);                
                InitDataProperty(0,     cnt++,  dtHidden,      120,     daRight,    true,       "stnd_cost_cd",     false,     "",        dfNone,       0,  false,   false);

                CountPosition  = 0 ;
                style.height = GetSheetHeight(16) ;
                //Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시 (업로드시)
                EditableColorDiff = true;
                WaitImageVisible = false;
            }
            break;
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

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
  sheetObj.ShowDebugMsg = false;
  
  switch(sAction) {
	case IBCLEAR:          //조회
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		
		//setYrWk('2014', '48')
		fnYearWeekSet(formObj.f_yearweek);
		
		formObj.f_cmd.value = INIT;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0311GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (0 < arrXml.length)
			//ComXml2ComboItem(arrXml[0], formObj.f_cobcost, "code", "name");

		ComOpenWait(false);
		//doActionIBSheet(sheetObj, formObj, IBSEARCH);  //Load시 조회
		break;

    case IBSEARCH:      //조회
    	// 업무처리중 버튼사용 금지 처리
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
        formObj.f_cmd.value = SEARCHLIST;
        //alert(masFormQueryString(formObj));
		sheetObj.DoSearch4Post("ESM_MAS_0311GS.do", masFormQueryString(formObj));
		ComOpenWait(false);
        break;

    case IBSAVE:                //저장
        if(!validateForm(sheetObj,formObj,sAction)) {
        	return false;
        }
        ComOpenWait(true);
        formObj.f_cmd.value = MULTI01;
        var sParamSheet = sheetObj.GetSaveString();
        var sParam = masFormQueryString(formObj);
        sParam += "&" + sParamSheet;
        //sheetObj.DoSave("ESM_MAS_0311GS.do", masFormQueryString(formObj,'f_cmd',true), -1, false);
        //var sXml = sheetObj.GetSaveXml("ESM_MAS_0311GS.do", masFormQueryString(formObj,'f_cmd',true), -1, false);
        
        if(sheetObj.RowCount("U") == 0){
        	//alert("수정 건수 는 " + sheetObj.RowCount("U") + " 건입니다.");
        	sheetObj.MessageText("UserMsg13");
        	return;
        }        
        var sXml = sheetObj.GetSaveXml("ESM_MAS_0311GS.do", sParam);
        
        if(sheetObj.IsDataModified && sParamSheet == ""){
        	return;
        }
        
        var CreationSaveFalse = ComGetEtcData(sXml, "CreationSaveFalse");
        //var sXml = sheetObj.GetSearchXml("ESM_MAS_0311GS.do", masFormQueryString(formObj));        
        ComOpenWait(false);
        //alert(CreationSaveFalse);
        if(CreationSaveFalse == "" || CreationSaveFalse == null || CreationSaveFalse == 'undefined'){
        	flagSave = "N";
        } else if(CreationSaveFalse == "N") {
        	flagSave = "Y";
        	popSaveComplete();
        } else {
        	flagSave = "Y";
        	popSaveComplete();
        }
        //alert(flagSave);
        break;
    
    case IBDOWNEXCEL:           //엑셀 다운로드
        //sheetObj.SpeedDown2Excel(-1);
        sheetObj.Down2Excel(-1, false, false, true);
        break;

    case IBCREATE:
    	if(!validateForm(sheetObj,formObj,sAction)) {
        	return false;
        }
    	if (!ComShowCodeConfirm("MAS10020")) {
    		return false;
    	}
        ComOpenWait(true);
        sheetObj.Redraw = false;
        formObj.f_cmd.value = COMMAND01;
        var sParamSheet = sheetObj.GetSaveString();
        var sParam = masFormQueryString(formObj);
        sParam += "&" + sParamSheet;
        var sXml = sheetObj.GetSearchXml("ESM_MAS_0311GS.do", sParam);
        var CreationSaveFalse = ComGetEtcData(sXml, "CreationSaveFalse");
        //sheetObj.DoSearch("ESM_MAS_0311GS.do", FormQueryString(formObj));
        //var sXml = sheetObj.GetSearchXml("ESM_MAS_0311GS.do", masFormQueryString(formObj));
        //var CreationSaveFalse = ComGetEtcData(sXml, "CreationSaveFalse");
        //alert(CreationSaveFalse);
        doActionIBSheet(sheetObj, formObj, IBSEARCH);
        sheetObj.Redraw = true;
        if(CreationSaveFalse == "Y"){
        	flagCreation = "N";
        } else if(CreationSaveFalse == "") {
        	flagCreation = "Y";
        } else {
        	flagCreation = "Y";
        }
        //alert(flagCreation);
        break;    
  }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	//공통 체크	       
	with(formObj){        	
    	if(!ComIsDate(f_yearweek, "yw")){
    		ComShowMessage(ComGetMsg("COM12114", "YYYY-WW"));
			f_yearweek.focus();
			return false;
    	}
    } 
    
	//버튼별 체크
    switch (sAction) {    			
  		case IBCREATE:
  			if(ComIsNull(formObj.f_ttl_amt)) {
  				ComShowMessage(ComGetMsg('MAS10002', 'Amount'));
  	            ComSetFocus(formObj.f_ttl_amt);
				return false;
			}
			break;
			
  		case IBDELETE:
  			if(sheetObj.RowCount < 1) {
  				return false;
  			}
			break;
    }
    
    return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	if(sheetObj.RowCount > 0){
		ComSetObjValue(formObj.f_ttl_amt, sheetObj.CellText(sheetObj.SelectRow, "ttl_amt"));
	}else{
		ComSetObjValue(formObj.f_ttl_amt, "");
	}
}

function comPopupOK() {	
	var flagCrSv = "";		
	if(flagCreation == "Y"){
		var flagCrSv = "Y"
		opener.getMAS_ENS_311(flagCrSv);
		window.close();
	} else if(flagSave == "Y"){
		var flagCrSv = "Y"
		opener.getMAS_ENS_311(flagCrSv);
		window.close();
	} else {
		var flagCrSv = "N"
		opener.getMAS_ENS_311(flagCrSv);
		window.close();
	}		
}

function popSaveComplete() {
	var sheetObj = sheetObjects[0];
	var lvrow = sheetObj.RowCount;
	//alert(lvrow);
	for(i=lvrow; i > 0; i--){		
		//alert(i);
		sheetObj.CellValue(i,'ibflag') = "";
	}
}

function f_cobcost_OnChange(obj,value,text) {
	var formObj = document.form;
	var flagNowStndCostCd = ComGetObjValue(formObj.f_cobcost);
	if(flagStart == "Y"){		
		ComBtnEnable("btn_Create");
		ComBtnEnable("btn_Save");
	} else {
		//flagNowStndCostCd = formObj.stnd_cost_cd.value;
		//alert(flagNowStndCostCd);
		//alert("flagStndCostCd : " + flagStndCostCd + " - flagNowStndCostCd : " + flagNowStndCostCd);		
		if(flagStndCostCd != flagNowStndCostCd){
			//alert("비활성~~");
			ComBtnDisable("btn_Create");
			ComBtnDisable("btn_Save");
		} else if(flagStndCostCd == flagNowStndCostCd) {
			//alert("활성~~");
			ComBtnEnable("btn_Create");
			ComBtnEnable("btn_Save");
		}
	}
}

function callParentFnc(){
	comPopupOK();
//	window.close();
//	if(eventMode)
//		window.dialogArguments.btn_Retrieve.click();
}

