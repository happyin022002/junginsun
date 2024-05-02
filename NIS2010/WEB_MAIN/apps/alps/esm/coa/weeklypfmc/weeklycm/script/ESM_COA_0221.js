/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0221.js
*@FileTitle : EMU Cost Table
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastVersion : 1.0
=========================================================
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_COA_0221 : ESM_COA_0221 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0221() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.setPeriod          = setPeriod          ;
    this.sheet1_OnSaveEnd   = sheet1_OnSaveEnd   ;
    this.sheet1_OnChange    = sheet1_OnChange    ;
    this.sheet1_OnSearchEnd = sheet1_OnSearchEnd ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateSheet      = validateSheet      ;
    this.validateCond       = validateCond       ;
    this.chkValidSearch     = chkValidSearch     ;
    this.validateForm       = validateForm       ;
}


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;


//Sheet Set
var tpszAll = "D2|D2|D4|D4|D5|D5|D7|D7|R2|R2|R5|R5|R9|R9|F2|F2|F4|F4|F5|F5|O2|O2|O4|O4|O5|O5"; 

var tpszDry	= "D2|D4|D5|D7";    // DRY TYPE SIZE
var tpszRf 	= "R2|R5|R9";       // RFR TYPE SIZE
var tpszSpcl = "F2|F4|F5|O2|O4|O5"; // OT  TYPE SIZE

var defaultAll = "D2,D4,D5,D7,R2,R5,R9,F2,F4,F5,O2,O4,O5"; 
var defaultAllArr   = defaultAll.split(',');
var defaultDry	= "D2,D4,D5,D7";    // DRY TYPE SIZE
var defaultRf 	= "R2,R5,R9";       // RFR TYPE SIZE
var defaultSpcl = "F2,F4,F5,O2,O4,O5"; // OT  TYPE SIZE 


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
          

	  case "btn_loc_cd": //Location 조회 팝업
		  var loc_cd = "";
		  var groupCd 	= document.getElementById("f_group");
		  var locCd 	= formObject.f_loc_cd.value;
	
		  if (groupCd.Code == "CNT") {			  
			  ComOpenPopupWithTarget('/hanjin/COM_ENS_0M1.do', 600, 420, "cnt_cd:f_loc_cd", "1,0,1,1,1,1,1,1", true);
			
		  } else if(groupCd.Code == "CONTI") {			  
			  ComOpenPopupWithTarget('/hanjin/COM_ENS_0H1.do', 400, 380, "conti_cd:f_loc_cd", "1,0,1,1,1,1,1,1", true);
		 
		  } else if(groupCd.Code == "ECC") {
			  ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 410, "ecc_cd:f_loc_cd", "1,0,1,1,1,1,1,1", true);
		 
		  } else if(groupCd.Code == "RCC") {
			  ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 410, "rcc_cd:f_loc_cd", "1,0,1,1,1,1,1,1", true);
		 
		  } else if(groupCd.Code == "LCC") {
			  ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 410, "lcc_cd:f_loc_cd", "1,0,1,1,1,1,1,1", true);
		 
		  } 

		  break;

    } // end switch
  } catch(e) {
    if( e == "[object Error]") {
      ComShowMessage(OBJECT_ERROR);
    } else {
      ComShowMessage(e);
    }
  }
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {	
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
	loadingMode = true;
//  doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    loadingMode = false;
    
    hiddenCntrTpsz(defaultDry);
}


/**
 * 콤보 설정
 */
function initCombo (comboObj, comboNo) {
	with (comboObj) {
    	DropHeight = 500;
    	switch(comboObj.id) {
    	
    	case "f_type_cd":
    		InsertItem(0,  "DRY", "DRY");
    		InsertItem(1,  "SPCL", "SPCL");
    		InsertItem(2,  "RF", "RF");
    		ValidChar(2, 0);
    		MaxLength = 5;  
        	Index2 = 0;
    		break;

    	case "f_cntr_tpsz_cd":    
    		var cnt = 0 ;
			var tpszList = tpszDry.split("|");
			
			MaxSelect = tpszList.length;
			MultiSelect = true;
			
			for (var i = 0; i < tpszList.length; i++) {
				InsertItem(cnt++, tpszList[i], tpszList[i]);
			}
			
    		Code2 = defaultDry;
    	    break;

    	case "f_group":
    		InsertItem(0,  "Continent", "CONTI");
    		InsertItem(1,  "RCC", "RCC");
    		InsertItem(2,  "Country", "CNT");
    		InsertItem(3,  "LCC", "LCC");
    		InsertItem(4,  "ECC", "ECC");
    		ValidChar(2, 0);
    		MaxLength = 5;  
        	Index2 = 4;
    		break;

    	case "f_selclass":
    		InsertItem(0,  "Credit Ratio", "RTO");
    		InsertItem(1,  "Credit Amount", "AMT");
    		InsertItem(2,  "Ratio & Amount", "TOT");
    		ValidChar(2, 0);
    		MaxLength = 5;  
        	Index2 = 0;
    		break;

    	case "f_sts_cd":
    		InsertItem(0,  "OP", "OP");
    		InsertItem(1,  "DEL", "DEL");
    		ValidChar(2, 0);
    		MaxLength = 5;  
        	Index2 = 1;
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
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @version 2014.07.30
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	
 	switch(sheetID) {
     	case "sheet1":	
     		with (sheetObj) {
                 // 높이 설정
                 style.height = GetSheetHeight(18);
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msPrevColumnMerge;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 500);

                 var HeadTitle = "|YYYY-MM|Continent|RCC|Country|LCC|ECC|Rule|" + tpszAll;
                 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus,30,		daCenter,	true,	"ibflag");
                 //InitDataProperty(0, cnt++ , dtDataSeq,		40, 	daCenter,  	true,	"seq");
				 InitDataProperty(0, cnt++ , dtData,  		80,		daCenter,	true,	"cost_yrmon",		false,	"",	dfDateYm,	0);
				 InitDataProperty(0, cnt++ , dtData,  		100,	daCenter,	true,	"conti_nm",			false,	"",	dfNone,	0);
				 InitDataProperty(0, cnt++ , dtData,  		70,		daCenter,	true,	"rcc_cd",			false,	"",	dfNone,	0);
                 InitDataProperty(0, cnt++ , dtData,		150,	daLeft,		true,	"cnt_nm",			false,	"",	dfNone,	0);
                 InitDataProperty(0, cnt++ , dtData,		70, 	daCenter,	true,	"lcc_cd",			false,	"",	dfNone,	0);
                 InitDataProperty(0, cnt++ , dtData,		70, 	daCenter,	true,	"ecc_cd",			false,	"",	dfNone,	0);
                 InitDataProperty(0, cnt++ , dtData,		60, 	daCenter,	true,	"rule_cd",  		false,	"",	dfNone,	0);
                
     		     for ( var i = 0; i < defaultAllArr.length; i++) {
     		    	InitDataProperty(0, cnt++ , dtData,		90, daRight,	true,	"tpsz_"+defaultAllArr[i].toLowerCase()+"_rto",  	false,	"",	dfNone, 0);
     		    	InitDataProperty(0, cnt++ , dtData,		90, daRight,	true,	"tpsz_"+defaultAllArr[i].toLowerCase()+"_amt",  	false,	"",	dfNone, 0);
     		     }

                 WaitImageVisible = false;     
                 CountPosition  = 0 ;                   
                 
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

/**
 * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
 */
function f_type_cd_OnChange(obj,value,text) {
 	var formObj = document.form;
 	var comboObj = document.getElementById("f_cntr_tpsz_cd");
	var cnt = 0 ;
	
	sheetObjects[0].RemoveAll();
	
	with (comboObj) {
		RemoveAll(); 
		
	 	if(value == "DRY") {
	 		var tpszList = tpszDry.split("|");		
			MaxSelect = tpszList.length;
			MultiSelect = true;
			
			for (var i = 0; i < tpszList.length; i++) {
				InsertItem(cnt++, tpszList[i], tpszList[i]);
			}
			
			Code2 = defaultDry;
	 	} else if (value == "RF") { 
	 		var tpszList = tpszRf.split("|");		
			MaxSelect = tpszList.length;
			MultiSelect = true;
			
			for (var i = 0; i < tpszList.length; i++) {
				InsertItem(cnt++, tpszList[i], tpszList[i]);
			}
			
			Code2 = defaultRf;
	 	} else if (value == "SPCL") {	
	 		var tpszList = tpszSpcl.split("|");		
			MaxSelect = tpszList.length;
			MultiSelect = true;
	
			for (var i = 0; i < tpszList.length; i++) {
				InsertItem(cnt++, tpszList[i], tpszList[i]);
			}
	
			Code2 = defaultSpcl;
	 	}
	 	
	 	hiddenCntrTpsz(Code);
	}	
}


/**
 * 
 */
function f_selclass_OnChange(obj,value,text) {
 	var formObj = document.form;
 	var unitType = document.getElementById("unit_type");
 	//var tpszcd = getComboObjValue(document.form.f_type_cd);
 	var cttpsz = getComboObjValue(document.form.f_cntr_tpsz_cd);
    
    if(value == "RTO") {
    	unitType.innerHTML = "[Unit : %]";
    } else if(value == "AMT") {
    	unitType.innerHTML = "[Unit : USD]";
    } else if(value == "TOT") {
    	unitType.innerHTML = "[Unit : % / USD]";
    }

    /*if(tpszcd == "DRY") { 		
		Code2 = defaultDry;
 	} else if (tpszcd == "RF") {
		Code2 = defaultRf;
 	} else if (tpszcd == "SPCL") {
		Code2 = defaultSpcl;
 	}*/ 	
 	hiddenCntrTpsz(cttpsz);
}


/**
 * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
 */
function f_group_OnChange(obj,value,text) {
 	var formObj = document.form;
 	formObj.f_loc_cd.value = ""; 	
}


//선택된 CONTAINER TYPE/SIZE에 따라 그리드의 헤더를 변경한다.
function f_cntr_tpsz_cd_OnChange(comboObj, value, text) {
	//alert(value);
	//조회 완료 후 선택된 Container Type/Size 이외 Hidden
	hiddenCntrTpsz(value);
}


/*
 * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
 * OnloadPage,OnSearchEnd event에서 호출
 * @param {String} tpsz_cd
 * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
 */
function hiddenCntrTpsz(tpsz_cd){
	var sheetObj = sheetObjects[0];
	var cntr_tpsz = tpsz_cd.toLowerCase();
	var arr_tpsz = cntr_tpsz.split(",");
	var raAm = getComboObjValue(document.form.f_selclass);
	
	for(var i=0;i<defaultAllArr.length;i++){ //전체의 Container Type/Size		
		sheetObj.ColHidden("tpsz_"+defaultAllArr[i].toLowerCase()+"_rto")= true;
		sheetObj.ColHidden("tpsz_"+defaultAllArr[i].toLowerCase()+"_amt")= true;
		
		for(var j = 0; j< arr_tpsz.length; j++) {
			//alert(defaultAllArr[i].toLowerCase()+"|"+arr_tpsz[j]);
			
			if(defaultAllArr[i].toLowerCase() == arr_tpsz[j]) {
				if(raAm == "RTO"){
					sheetObj.ColHidden("tpsz_"+defaultAllArr[i].toLowerCase()+"_rto")= false;
				} else if(raAm == "AMT"){
					sheetObj.ColHidden("tpsz_"+defaultAllArr[i].toLowerCase()+"_amt")= false;
				} else if(raAm == "TOT"){
					sheetObj.ColHidden("tpsz_"+defaultAllArr[i].toLowerCase()+"_rto")= false;
					sheetObj.ColHidden("tpsz_"+defaultAllArr[i].toLowerCase()+"_amt")= false;
				}
			}			
		}
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case IBSEARCH: // 조회
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCHLIST01;
		sheetObj.DoSearch4Post("ESM_COA_0221GS.do", coaFormQueryString(formObj));
		ComOpenWait(false);
		break;

	case IBDOWNEXCEL: // 엑셀 다운로드
		var excelType = selectDownExcelMethod(sheetObj);
		switch (excelType) {
		case "AY":
			sheetObj.Down2Excel(0, false, false, true);
			break;
		case "DY":
			sheetObj.Down2Excel(-1, false, false, true);
			break;
		case "AN":
			sheetObj.SpeedDown2Excel(0, false, false);
			break;
		case "DN":
			sheetObj.SpeedDown2Excel(-1, false, false);
			break;
		}
		break;
	}
}	    

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){  
    	if (f_cost_yrmon.value == ""){
			ComShowCodeMessage("COM12114", "Year Month")
			f_cost_yrmon.focus();
			return false;
    	}
    	
        if(!ComChkObjValid(f_cost_yrmon, null, null, "ym")) {
        	return false;
        }
    }

    return true;
}
function getComboObjValue(obj){
 	if (ComGetObjValue(obj) == "All") return "";
 	return ComGetObjValue(obj);
}