/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0315.js
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
 * @class ESM_MAS_0315 : ESM_MAS_0315 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0315() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.initTab            = initTab            ;
    this.setSheetObject     = setSheetObject     ;
    this.setTabObject       = setTabObject       ;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    var sheetObject4 = sheetObjects[4];
    var sheetObject5 = sheetObjects[5];
    var sheetObject6 = sheetObjects[6];
    var sheetObject7 = sheetObjects[7];
    var sheetObject8 = sheetObjects[8];
    
    /*******************************************************/
    var formObject = document.form;
    var objs = document.all.item("tabLayer");
    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
            case "btn_retrieve":
            	if( objs[0].style.display == "inline" ){
            		doActionIBSheet(sheetObject,formObject,IBSEARCH);
				}else if( objs[1].style.display == "inline" ){
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				}else if( objs[2].style.display == "inline" ){
					doActionIBSheet(sheetObject2,formObject,IBSEARCH);
				}else if( objs[3].style.display == "inline" ){
					doActionIBSheet(sheetObject3,formObject,IBSEARCH);
				}else if( objs[4].style.display == "inline" ){
					doActionIBSheet(sheetObject4,formObject,IBSEARCH);
				}else if( objs[5].style.display == "inline" ){
					doActionIBSheet(sheetObject5,formObject,IBSEARCH);
				}else if( objs[6].style.display == "inline" ){
					doActionIBSheet(sheetObject6,formObject,IBSEARCH);
				}else if( objs[7].style.display == "inline" ){
					doActionIBSheet(sheetObject7,formObject,IBSEARCH);
				}else if( objs[8].style.display == "inline" ){
					doActionIBSheet(sheetObject8,formObject,IBSEARCH);
				}
                break;

            case "btn_creation":
            	if( objs[0].style.display == "inline" ){
            		doActionIBSheet(sheetObject,formObject,IBCREATE);
				}else if( objs[1].style.display == "inline" ){
					doActionIBSheet(sheetObject1,formObject,IBCREATE);
				}else if( objs[2].style.display == "inline" ){
					doActionIBSheet(sheetObject2,formObject,IBCREATE);
				}else if( objs[3].style.display == "inline" ){
					doActionIBSheet(sheetObject3,formObject,IBCREATE);
				}else if( objs[4].style.display == "inline" ){
					doActionIBSheet(sheetObject4,formObject,IBCREATE);
				}else if( objs[5].style.display == "inline" ){
					doActionIBSheet(sheetObject5,formObject,IBCREATE);
				}else if( objs[6].style.display == "inline" ){
					doActionIBSheet(sheetObject6,formObject,IBCREATE);
				}else if( objs[7].style.display == "inline" ){
					doActionIBSheet(sheetObject7,formObject,IBCREATE);
				}else if( objs[8].style.display == "inline" ){
					doActionIBSheet(sheetObject8,formObject,IBCREATE);
				}
                break;
                
            case "btn_save":
            	if( objs[0].style.display == "inline" ){
            		doActionIBSheet(sheetObject,formObject,IBSAVE);
				}else if( objs[1].style.display == "inline" ){
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				}else if( objs[2].style.display == "inline" ){
					doActionIBSheet(sheetObject2,formObject,IBSAVE);
				}else if( objs[3].style.display == "inline" ){
					doActionIBSheet(sheetObject3,formObject,IBSAVE);
				}else if( objs[4].style.display == "inline" ){
					doActionIBSheet(sheetObject4,formObject,IBSAVE);
				}else if( objs[5].style.display == "inline" ){
					doActionIBSheet(sheetObject5,formObject,IBSAVE);
				}else if( objs[6].style.display == "inline" ){
					doActionIBSheet(sheetObject6,formObject,IBSAVE);
				}else if( objs[7].style.display == "inline" ){
					doActionIBSheet(sheetObject7,formObject,IBSAVE);
				}else if( objs[8].style.display == "inline" ){
					doActionIBSheet(sheetObject8,formObject,IBSAVE);
				}
                break;                

            case "btn_down_excel":
                if( objs[0].style.display == "inline" ){
                	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				}else if( objs[1].style.display == "inline" ){
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				}else if( objs[2].style.display == "inline" ){
					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
				}else if( objs[3].style.display == "inline" ){
					doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
				}else if( objs[4].style.display == "inline" ){
					doActionIBSheet(sheetObject4,formObject,IBDOWNEXCEL);
				}else if( objs[5].style.display == "inline" ){
					doActionIBSheet(sheetObject5,formObject,IBDOWNEXCEL);
				}else if( objs[6].style.display == "inline" ){
					doActionIBSheet(sheetObject6,formObject,IBDOWNEXCEL);
				}else if( objs[7].style.display == "inline" ){
					doActionIBSheet(sheetObject7,formObject,IBDOWNEXCEL);
				}else if( objs[8].style.display == "inline" ){
					doActionIBSheet(sheetObject8,formObject,IBDOWNEXCEL);
				}
                break;

            case "btns_calendar":
                var cal = new ComCalendar();
                cal.select(formObject.f_yearweek, 'yyyyMM');
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
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
  
    setYearQtr();
	loadingMode = false;
}

//QTR 구하기
function setYearQtr(){
	var formObj = document.form;
    ComSetObjValue(formObj.f_year, ComGetNowInfo("yy"));
    
    //QTR 구하기
	num = ComGetNowInfo("mm");
	var mod = num%3;
	var mok = num/3;
	if(mod == 0){
		qtr = mok;
	}else{
		qtr = parseInt(mok+1);
	}
	ComSetObjValue(formObj.f_qtr, qtr);
}

function ComAddSeparator_Local(obj, sFormat) {
    try {
        obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
    } catch(err) { ComFuncErrMsg(err.message); }
}

function fnYearWeekSet(obj){
	obj.value = ComGetMaskedValue(obj.value,"ym");
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj) {
	var i=0;
	switch(comboObj.id) {
		case "f_trd_cd":
			setInit_combo(comboObj, "trade", "","All");
			comboObj.DropHeight=200;
			break;
			
//		case "f_rlane_cd":
//			setInit_combo(comboObj, "rLane3", "","All");
//			comboObj.DropHeight=200;
//			break;
			
		case "f_dir_cd":
			setInit_combo(comboObj, "CD00593", "","All");
			comboObj.DropHeight=100;
			break;

		case "f_hul_bnd_cd":			
			setInit_combo(comboObj, "CD03217", "","All");
			comboObj.DropHeight=100;
			break;
			
		case "f_dur":
			for(var i=1; i<=12; i++)
				comboObj.InsertItem(i-1,  i, i);
			comboObj.DropHeight = 300;
			comboObj.MaxLength = 2;
			comboObj.Index = 5;
			break;			
	}
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {
                var cnt  = 0 ;
                InsertTab( cnt++, "Crew Expense" , -1 );
                InsertTab( cnt++, "Insurance" , -1 );
                InsertTab( cnt++, "Store supply Exp" , -1 );
                InsertTab( cnt++, "Lubricant Exp" , -1 );
                InsertTab( cnt++, "Vessel M&R" , -1 );
                InsertTab( cnt++, "Depreciations" , -1 );
                InsertTab( cnt++, "Telecom Exp" , -1 );
                InsertTab( cnt++, "Other Operation Exp" , -1 );
                InsertTab( cnt++, "Vessel Interest" , -1 );
            }
        break;
    }
}

function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
    switch(sheetNo) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            with (sheetObj) {
                SheetWidth = mainTable.clientWidth;//전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
                Editable = true;//전체Edit 허용 여부 [선택, Default false]
                InitRowInfo(1 , 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(15, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                var HeadTitle   = "STS|YYYY-QTR|Trade|Sub Trade|Lane|Bound|Trade Dir|Cost period|TTL cost|Final Cost\n(SML Ratio)|Target Load or L/F|Cost / TEU|stnd_cost_cd|cost_yr|cost_qtr_cd";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtStatus,   30, daCenter,   false,  "ibflag");
                InitDataProperty(0, cnt++,  dtData,     70, daCenter,   false,  "cost_yr_qtr",   false,      "",     dfDateYm,      0,  false,  false);
                InitDataProperty(0, cnt++,  dtData,     50, daCenter,   false,  "trd_cd",        false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     70, daCenter,   false,  "sub_trd_cd",    false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     60, daCenter,   false,  "rlane_cd",      false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     50, daCenter,   false,  "dir_cd",        false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     60, daCenter,   false,  "hul_bnd_cd",    false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     130, daCenter,  false,  "eff_yrmon",     false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     110, daRight,   false,  "ttl_amt",       false,      "",     dfNullInteger, 0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     110, daRight,   false,  "fnl_ttl_amt",   false,      "",     dfNullInteger, 0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     110, daRight,   false,  "tgt_lod_qty",   false,      "",     dfNullInteger, 0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     110, daRight,   false,  "teu_uc_amt",    false,      "",     dfFloatOrg,    2,  true,   false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,  false,  "stnd_cost_cd",  false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,  false,  "cost_yr",       false,      "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,  false,  "cost_qtr_cd",   false,      "",     dfNone,        0,  false,  false);
                CountPosition   = 0 ;
                style.height = GetSheetHeight(18) ;
            }
            break;
    }
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem){
	var objs = document.all.item("tabLayer");
	var formObj = document.form;

	objs[nItem].style.display = "inline";
	objs[beforetab].style.display = "none";
	//--------------- 요기가 중요 --------------------------//
	var pre_idx =  objs[nItem].style.zIndex;
	pre_idx--;
	objs[beforetab].style.zIndex = pre_idx ;
	//------------------------------------------------------//

	beforetab = nItem;
	var arr_f_cobcost = ["54100000","54250000","54200000","54300000","54150000","54450000","54180000","54550000","72100000"];
	//ESM_MAS_0316
	//var arr_f_cobcost = ["54350000","54350009","54250009","54150009","54200009","53100000","53200000","65000000","54400000"];
    ComSetObjValue(formObj.f_cobcost, arr_f_cobcost[nItem]);	
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
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
  tabObjects[tabCnt++] = tab_obj;
}

function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}
    
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    // 업무처리중 버튼사용 금지 처리
	sheetObj.WaitImageVisible = false;
    
    switch(sAction) {
        case IBSEARCH:      //결과조회
            if (!validateForm(sheetObj,formObj,sAction)) {
                return false;
            }
            ComOpenWait(true);
            
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_MAS_0315GS.do", masFormQueryString(formObj));

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
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0315GS.do", masFormQueryString(formObj));
			sheetObj.LoadSaveXml(sXml);

			ComOpenWait(false);
			break;
			
        case IBSAVE:	//저장
			if(validateForm(sheetObj,formObj,sAction)){
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_MAS_0315GS.do", masFormQueryString(formObj));
				ComOpenWait(false);
			}
			break;
			
		case IBDOWNEXCEL:	//엑셀 다운로드
			sheetObj.SpeedDown2Excel(-1, false, false);
			break;
    }
}

function validateForm(sheetObj, formObj, sAction){
	switch (sAction) {
 		case IBSEARCH: // 조회
 			if(!ComIsDate(formObj.f_year, "YYYY")){
 				ComShowMessage(ComGetMsg("COM12114", "YYYY"));
 				formObj.f_year.focus();
 				return false;
 	       	}else if (formObj.f_qtr.value == "") {
 	        	ComShowMessage(ComGetMsg("COM12114", "QTR"));
 	        	formObj.f_qtr.focus();
 	        	return false;
 	       	}else if (formObj.f_qtr.value != "" && (formObj.f_qtr.value < 1 || formObj.f_qtr.value > 4)) {
 	        	ComShowMessage(ComGetMsg("COM12114", "QTR"));
 	        	formObj.f_qtr.focus();
 	        	return false;
 	       	}
 			break;

 		case IBSAVE: //Save
 			break;

 		case IBCREATE: // create
 			if(!ComIsDate(formObj.f_year, "YYYY")){
 				ComShowMessage(ComGetMsg("COM12114", "YYYY"));
 				formObj.f_year.focus();
 				return false;
 	       	}else if (formObj.f_qtr.value == "") {
 	        	ComShowMessage(ComGetMsg("COM12114", "QTR"));
 	        	formObj.f_qtr.focus();
 	        	return false;
 	       	}else if (formObj.f_qtr.value != "" && (formObj.f_qtr.value < 1 || formObj.f_qtr.value > 4)) {
 	        	ComShowMessage(ComGetMsg("COM12114", "QTR"));
 	        	formObj.f_qtr.focus();
 	        	return false;
 	       	}else if(!ComIsDate(formObj.f_sweek, "ym")){
 	       		ComShowMessage(ComGetMsg("COM12114", "YYYY-MM"));
 	       		formObj.f_sweek.focus();
 				return false;
 	       	}
			break;
	}
	
	return true;
}

function f_trd_cd_OnChange(comboObj, value, text)
{
	var formObj = document.form;
	var vMsg_ctnt = "";
	var comboObj1 = comboObjects[1];
	
	comboObj1.removeAll();
	if (value == "All"){
		setInit_combo(comboObj1, "rLane3", "","All");
		comboObj1.DropHeight=300;
	}else{
		setInit_combo(comboObj1, "rLane", value, "All");
		comboObj1.DropHeight=300;
	}
}

function setInit_combo(comboObj, codeItem, codeId, codeInit){
    var vParam = "f_cmd="+INIT+"&code_item="+codeItem+"&code_id="+codeId+"&code_init="+codeInit;		
	var sXml = sheetObjects[1].GetSearchXml("ESM_MAS_0315GS.do", vParam);
	ComXml2ComboItem(sXml, comboObj, "code", "name");
	comboObj.Code = codeInit;
}

function setCostTeu(){
	var formObj = document.form;
	var sUrl = "";
	var sParam = "?f_trd_cd="+ComGetObjValue(formObj.f_trd_cd)
+"&f_rlane_cd="+ComGetObjValue(formObj.f_rlane_cd)
+"&f_dir_cd="+ComGetObjValue(formObj.f_dir_cd)
+"&f_hul_bnd_cd="+ComGetObjValue(formObj.f_hul_bnd_cd)	
+"&f_cobcost="+ComGetObjValue(formObj.f_cobcost);
	sUrl = "/hanjin/ESM_MAS_0317.do"+sParam;
	ComOpenPopup(sUrl, 950, 600, "", "0,0", true, false);
}
 
function t1sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
}

function t2sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
}

function t3sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
}

function t4sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[3],formObject,IBSEARCH);
}

function t5sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[4],formObject,IBSEARCH);
}

function t6sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[5],formObject,IBSEARCH);
}

function t7sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[6],formObject,IBSEARCH);
}

function t8sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[7],formObject,IBSEARCH);
}

function t9sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[8],formObject,IBSEARCH);
}