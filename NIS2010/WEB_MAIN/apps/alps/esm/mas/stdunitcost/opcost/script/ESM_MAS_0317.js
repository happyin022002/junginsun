/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0317.js
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
 * @class ESM_MAS_0317 : ESM_MAS_0317 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0317() {
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
var fastRlaneCdFlg = false;
var eventMode = false;

var prevWeek = "";
var fYear = "";

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
	        case "btn_set_target_lf":
	        	setTargetLf();
	            break;
            
            case "btn_retrieve":
           		doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

            case "btn_creation":
           		doActionIBSheet(sheetObject,formObject,IBCREATE);
                break;                
                
            case "btn_save":
           		doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;

            case "btn_data_missing":
           		//doActionIBSheet(sheetObject,formObject,IBDATAMISSING);
            	callDetailPopup();
                break;

            case "btn_down_excel":
               	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;

            case "btns_calendar":
                var cal = new ComCalendar();
                cal.select(formObject.f_yearweek, 'yyyyMM');
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
	var i=0;
	switch(comboObj.id) {
		case "f_vsl_cd":
			setInit_combo(comboObj, "opVessel", ComGetObjValue(formObj.pf_vsl_cd), "All");
			comboObj.DropHeight=300;
			break;
	
		case "f_trd_cd":
			setInit_combo(comboObj, "trade", ComGetObjValue(formObj.pf_trd_cd), "All");
			comboObj.DropHeight=200;
			break;
			
		case "f_dir_cd":
			setInit_combo(comboObj, "CD00593", ComGetObjValue(formObj.pf_dir_cd), "All");
			comboObj.DropHeight=100;
			break;
	
		case "f_hul_bnd_cd":
			setInit_combo(comboObj, "CD03217", ComGetObjValue(formObj.pf_hul_bnd_cd), "All");
			comboObj.DropHeight=100;
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
                InitColumnInfo(24, 9, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                var HeadTitle   = "STS|YYYY-MM|YYYY-WK|Trade|Sub Trade|Lane|Bound|rlane_dir|Trade Dir|VSL TP|VVD|TTL Cost|TTL Days|Cost period|Cost / day|SML Sales Ratio(%)|Final Cost|L/F(%)|Target Load|Cost / TEU|vvd_bsa_capa|vsl_cd|skd_voy_no|stnd_cost_cd";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtStatus,   30, daCenter,   false,  "ibflag");
                InitDataProperty(0, cnt++,  dtData,     60, daCenter,   false,  "cost_yrmon",    false,      "",     dfDateYm,      0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     60, daCenter,   false,  "cost_wk",       false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     50, daCenter,   false,  "trd_cd",        false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     70, daCenter,   false,  "sub_trd_cd",    false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     60, daCenter,   false,  "rlane_cd",      false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     50, daCenter,   false,  "dir_cd",        false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,  false,  "rlane_dir",     false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     60, daCenter,   false,  "hul_bnd_cd",    false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     50, daCenter,   false,  "vsl_tp",        false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     80, daCenter,   false,  "vvd",           false,      "",     dfNone,        0,  false,  false);                
                InitDataProperty(0, cnt++ , dtData,     90, daRight,    false,  "ttl_amt",       false,      "",     dfNullInteger, 0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     90, daRight,    false,  "ttl_tz_dys",    false,      "",     dfFloatOrg, 	3,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     100,daCenter,   false,  "eff_yrmon",     false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     90, daRight,    false,  "dhir_amt",      false,      "",     dfNullInteger, 0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     120,daCenter,   false,  "own_sls_rto",   false,      "",     dfNullInteger, 0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     90, daRight,    false,  "fnl_ttl_amt",   false,      "",     dfNullInteger, 0,  true,  false);                
                InitDataProperty(0, cnt++ , dtData,     70, daRight,    false,  "l_f",           false,      "",     dfNullInteger, 0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     90, daRight,    false,  "tgt_lod_qty",   false,      "",     dfNullInteger, 0,  true,  false);
                //InitDataProperty(0, cnt++ , dtData,     90, daRight,    false,  "teu_uc_amt",    false,      "|fnl_ttl_amt|/|tgt_lod_qty|",     dfFloatOrg,    2,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     80, daRight,    false,  "teu_uc_amt",    false,      "",     dfFloatOrg,    2,  false,  false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,  false,  "vvd_bsa_capa",  false,      "",     dfNullInteger, 0,  false,  false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,  false,  "vsl_cd",        false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,  false,  "skd_voy_no",    false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,  false,  "stnd_cost_cd",  false,      "",     dfNone,        0,  false,  false);
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
    
/**
 * month, week가 변경되었을때 Period를 변경한다.
 */
function setPeriod(obj){
    ComMasSetPeriod2(obj);
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
            sheetObj.DoSearch("ESM_MAS_0317GS.do", masFormQueryString(formObj));

            //Deferred Expense를 위한 값 추출
            ComEtcDataToForm(formObj,sheetObj);
            
            ComOpenWait(false);
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
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0317GS.do", masFormQueryString(formObj));
			sheetObj.LoadSaveXml(sXml);
			eventMode = true;
			ComOpenWait(false);
			//callDetailPopup();
			break;
		
        case IBSAVE:	//저장
			if(validateForm(sheetObj,formObj,sAction)){
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_MAS_0317GS.do", masFormQueryString(formObj));
				eventMode = true;
				ComOpenWait(false);
			}
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
    } 
    return true;
}

function sheet1_OnSearchEnd(sheetObj, errMsg){
	//sheetObj.ShowSubSum("trd_cd", "vvd_bsa_capa|lod_qty", -1, false, false, 1, "cost_yrmon=Trade TTL;ldf_rto=(|lod_qty|/|vvd_bsa_capa|)*100");
	sheetObj.ShowSubSum("rlane_dir", "ttl_amt|fnl_ttl_amt|tgt_lod_qty|teu_uc_amt|vvd_bsa_capa", -1, false, false, 1, "cost_yrmon=TTL;l_f=(|tgt_lod_qty|/|vvd_bsa_capa|)*100;teu_uc_amt=|fnl_ttl_amt|/|tgt_lod_qty|");
}

function sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
}

function sheet1_OnChange (sheetObj, row , col, value ){
	if (col == "16"){
		sheetObj.CellValue2(row, "teu_uc_amt") = sheetObj.CellValue(row, "fnl_ttl_amt") / sheetObj.CellValue(row, "tgt_lod_qty");
	}
}

function f_trd_cd_OnChange(comboObj, value, text)
{
	var formObj = document.form;
	var vMsg_ctnt = "";
	var comboObj1 = comboObjects[2];
	
	comboObj1.removeAll();
	if (value == "All"){
		setInit_combo(comboObj1, "rLane3", "", "All");
	}else{
		setInit_combo(comboObj1, "rLane", value, "All");
	}
	comboObj1.DropHeight=300;
	
	var pfRlaneCd = ComGetObjValue(formObj.pf_rlane_cd);
	if(fastRlaneCdFlg) pfRlaneCd = "All";
	comboObj1.Code = pfRlaneCd;
	
	fastRlaneCdFlg = true;
}

function setInit_combo(comboObj, codeItem, codeId, codeInit){
    var vParam = "f_cmd="+INIT+"&code_item="+codeItem+"&code_id="+codeId+"&code_init="+codeInit;		
	var sXml = sheetObjects[1].GetSearchXml("ESM_MAS_0317GS.do", vParam);
	if (codeItem == "opVessel") {
		ComXml2ComboItem(sXml, comboObj, "code", "code");
	} else {
		ComXml2ComboItem(sXml, comboObj, "code", "name");
	}
	comboObj.Code = codeId;
}
 
function setTargetLf(){
	var formObj = document.form;
	var sUrl = "";
	var sParam = "?f_yearweek="+ComGetObjValue(formObj.f_yearweek)
+"&f_vsl_cd="+ComGetObjValue(formObj.f_vsl_cd)
+"&f_trd_cd="+ComGetObjValue(formObj.f_trd_cd)
+"&f_rlane_cd="+ComGetObjValue(formObj.f_rlane_cd)
+"&f_dir_cd="+ComGetObjValue(formObj.f_dir_cd)
+"&f_hul_bnd_cd="+ComGetObjValue(formObj.f_hul_bnd_cd);	
	sUrl = "/hanjin/ESM_MAS_0318.do"+sParam;
	ComOpenPopup(sUrl, 940, 580, "", "0,0", true, false, "", "", "", "Set Target L/F");
}

function callParentFnc(){
//	window.close();
	if(eventMode)
		window.dialogArguments.btn_creation.click();
}

function callDetailPopup(){
	var formObj = document.form;
	var sUrl = "";
	var sParam = "?f_yearweek="+ComGetObjValue(formObj.f_yearweek)
				+"&f_cobcost="+ComGetObjValue(formObj.f_cobcost);
				/*+"&f_vsl_cd="+ComGetObjValue(formObj.f_vsl_cd)
				+"&f_trd_cd="+ComGetObjValue(formObj.f_trd_cd)
				+"&f_rlane_cd="+ComGetObjValue(formObj.f_rlane_cd)
				+"&f_dir_cd="+ComGetObjValue(formObj.f_dir_cd)
				+"&f_hul_bnd_cd="+ComGetObjValue(formObj.f_hul_bnd_cd);*/
	//alert(sParam);
	sUrl = "/hanjin/ESM_MAS_0319.do"+sParam;
	ComOpenPopup(sUrl, 800, 530, "", "0,0", true, false, "", "", "", "");	
}


