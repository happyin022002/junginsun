/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0332.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 김종옥
*@LastVersion : 1.0 
=========================================================
* History
=========================================================
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0332 : ESM_MAS_0332 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0332() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.initTab            = initTab            ;
    this.setSheetObject     = setSheetObject     ;
    this.setTabObject       = setTabObject       ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var eventMode = false;

// 각각의 메인 화면에서 각각의 팝업화면을 띄우기 위해 사용
var POPUP_OPEN_ID = parseInt(Math.random() * 100).toString(10);

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject = sheetObjects[0];
    
    /*******************************************************/
    var formObject = document.form;
    var objs = document.all.item("tabLayer");
    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_retrieve":
           		doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
                
            case "btn_save":
           		doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;

            case "btn_creation":
           		doActionIBSheet(sheetObject,formObject,IBCREATE);
                break;
                
            case "btn_down_excel":
               	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;

            case "btn_close":
				window.close();
				break;
                
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg(OBJECT_ERROR));
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
	loadingMode = true;
	
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
	for(var c=0; c<comboObjects.length; c++){
		initCombo(comboObjects[c]);
	}

    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    
	loadingMode = false;
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj) {
	var formObj = document.form;	
	switch(comboObj.id) {
		case "f_dur":
			for(var i=1; i<=12; i++)
				comboObj.InsertItem(i-1,  i, i);
			comboObj.DropHeight = 300;
			comboObj.MaxLength = 2;
			comboObj.Index = 5;
			break;			
	}
}

function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
    switch(sheetNo) {
        case 1:
            with (sheetObj) {
                SheetWidth = mainTable.clientWidth;//전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
                Editable = true;//전체Edit 허용 여부 [선택, Default false]
                InitRowInfo(1 , 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(9, 9, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                var HeadTitle = "STS|YYYY-MM|Class|Vessel|Hire|Cost period|Cost period|stnd_cost_cd|grp_knt";
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtStatus,   30,  daCenter,   false,  "ibflag");
                InitDataProperty(0, cnt++,  dtData,     120, daCenter,   false,  "cost_yrmon",    false,      "",     dfDateYm,      0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     120, daRight,    false,  "vsl_clss_capa", false,      "",     dfNullInteger, 0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     120, daCenter,   false,  "vsl_cd",        false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     160, daRight,    false,  "dhir_amt",      false,      "",     dfNullFloat,   1,  true,   false);
                InitDataProperty(0, cnt++,  dtData,     80, daCenter,   false,  "eff_yrmon",      false,      "",     dfDateYm,      0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     40, daCenter,   false,  "eff_wk",         false,      "",     dfNone,      0,  false,  false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,   false,  "stnd_cost_cd",  false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,   false,  "grp_knt",       false,      "",     dfNone,        0,  false,  false);
                
                CountPosition   = 0 ;
                style.height = GetSheetHeight(18) ;
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

function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * 입력창에 금월 셋팅
 * 사용 : setYrMon()
 *
 * @param NONE
 * @return NONE
 */        
function setYrMon(){
	var formObj = document.form;
	if(ComIsNull(formObj.pf_yearweek)){
		ComSetObjValue(formObj.f_yearweek, ComGetNowInfo("ym"));
	}else{
		ComSetObjValue(formObj.f_yearweek, ComReplaceStr(formObj.pf_yearweek, "-", ""));
	}
    fnYearWeekSet(document.getElementById("f_yearweek"));
}

function fnYearWeekSet(obj){
    obj.value = ComGetMaskedValue(obj.value,"ym");
    setPeriod(obj);
}

function ComAddSeparator_Local(obj, sFormat) {
    try {
        obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * month, week가 변경되었을때 Period를 변경한다.
 */
function setPeriod(obj){
    ComMasSetPeriod2(obj);
    
    //Class 콤보 생성
    setVessel_combo();
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    // 업무처리중 버튼사용 금지 처리
	sheetObj.WaitImageVisible = false;
    
    switch(sAction) {
    	case IBCLEAR:          //조회
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			setYrMon();  // 월/주 입력 창에 금월 셋팅
			ComOpenWait(false);
			break;
        
        case IBSEARCH:      //결과조회
            if (!validateForm(sheetObj,formObj,sAction)) {
                return false;
            }
            ComOpenWait(true);
            
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_MAS_0332GS.do", masFormQueryString(formObj));

            //Deferred Expense를 위한 값 추출
            ComEtcDataToForm(formObj,sheetObj);
            
            ComOpenWait(false);
            break;
        
        case IBSAVE:	//저장
			if(validateForm(sheetObj,formObj,sAction)){
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_MAS_0332GS.do", masFormQueryString(formObj));
				eventMode = true;
				ComOpenWait(false);
			}
			break;
			
        case IBCREATE:      //생성
            if (!validateForm(sheetObj,formObj,sAction)) {
                return false;
            }
			
        	if (!ComShowCodeConfirm("MAS10020")) {
        		return false;
        	}
        	
			ComOpenWait(true);
			formObj.f_cmd.value = COMMAND01;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0332GS.do", masFormQueryString(formObj));
			sheetObj.LoadSaveXml(sXml);
			eventMode = true;
			ComOpenWait(false);
			break;			
			
		case IBDOWNEXCEL:	//엑셀 다운로드
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
	//공통 체크	       
	with(formObj){        	
       	if(!ComIsDate(f_yearweek, "ym")){
       		ComShowMessage(ComGetMsg("COM12114", "YYYY-MM"));
			f_yearweek.focus();
			return false;
       	}
       	
       	if((sAction == IBCREATE) && (!ComIsDate(f_sweek, "ym"))){
       		ComShowMessage(ComGetMsg("COM12114", "YYYY-MM"));
       		f_sweek.focus();
			return false;
       	}
    } 
    return true;
}

function sheet1_OnSearchEnd(sheetObj, errMsg){
	sheetObj.ShowSubSum("vsl_clss_capa", "dhir_amt|grp_knt", -1, false, false, 1, "cost_yrmon=Average;dhir_amt=|dhir_amt|/|grp_knt|","grp_knt");
}

function sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
}

function setInit_combo(comboObj, codeItem, codeId, codeInit){
    var vParam = "f_cmd="+INIT+"&code_item="+codeItem+"&code_id="+codeId+"&code_init="+codeInit;		
	var sXml = sheetObjects[1].GetSearchXml("ESM_MAS_0330GS.do", vParam);
	ComXml2ComboItem(sXml, comboObj, "code", "name");
	comboObj.Code = codeInit;
}

function setVessel_combo(){
	var comboObj = comboObjects[0];
	var formObj = document.form;	
    var vParam = "f_cmd="+SEARCH02+"&f_yearweek="+ComGetObjValue(formObj.f_yearweek);
	var sXml = sheetObjects[1].GetSearchXml("ESM_MAS_0330GS.do", vParam);
	comboObj.DropHeight=300;
	ComXml2ComboItem(sXml, comboObj, "vsl_cd", "vsl_cd");
	comboObj.InsertItem(0,  "All",  "All");
	comboObj.Index = 0;
}

function callParentFnc(){
	if(eventMode)
		window.dialogArguments.btn_retrieve.click();
}