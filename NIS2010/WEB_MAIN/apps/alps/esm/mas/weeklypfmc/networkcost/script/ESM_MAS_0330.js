/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0330.js
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
 * @class ESM_MAS_0330 : ESM_MAS_0330 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0330() {
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

var shtTabTotal = null;

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
    var sheetObject9 = sheetObjects[9];
    var sheetObject10 = sheetObjects[10];
    
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
				}else if( objs[9].style.display == "inline" ){
					doActionIBSheet(sheetObject9,formObject,IBSEARCH);
				}else if( objs[10].style.display == "inline" ){
					shtTabTotal = "1";
					doActionIBSheet(sheetObject10,formObject,IBSEARCH);
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
				}else if( objs[9].style.display == "inline" ){
					doActionIBSheet(sheetObject9,formObject,IBCREATE);
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
				}else if( objs[9].style.display == "inline" ){
					doActionIBSheet(sheetObject9,formObject,IBSAVE);
				}
                break;

            case "btn_month_copy":
            	var vParam = "?classId=ESM_MAS_0330&f_cobcost="+ComGetObjValue(formObject.f_cobcost);
            	var display = "0,1";
            	ComOpenPopup("ESM_MAS_0173.do"+vParam, 250, 160, "", display, true, false);
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
				}else if( objs[9].style.display == "inline" ){
					doActionIBSheet(sheetObject9,formObject,IBDOWNEXCEL);
				}else if( objs[10].style.display == "inline" ){
					doActionIBSheet(sheetObject10,formObject,IBDOWNEXCEL);
				}
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
    
//	for(var c=0; c<comboObjects.length; c++){
//		initCombo(comboObjects[c]);
//	}
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
  
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    
	loadingMode = false;
	
	//ComSetFocus(document.form.f_yearweek);
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
//function initCombo(comboObj) {
//	var formObj = document.form;	
//	switch(comboObj.id) {
//		case "f_selclass":
////			setInit_combo(comboObj, "trade", ComGetObjValue(formObj.pf_trd_cd), "All");
////			comboObj.DropHeight=200;
//			break;
//	}
//}

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
                InsertTab( cnt++, "Time Charterage" , -1 );
                InsertTab( cnt++, "Total" , -1 );
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
        case 10:        	
            with (sheetObj) {
                SheetWidth = mainTable.clientWidth;//전체 너비 설정
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
                MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
                Editable = true;//전체Edit 허용 여부 [선택, Default false]

                InitRowInfo(1 , 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitColumnInfo(7, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                var HeadTitle = "STS|YYYY-MM|Class|TTL Vessel|Avg Hire|Avg Hire(Pre Mon)|stnd_cost_cd";
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtStatus,   30,  daCenter,   false,  "ibflag");
                InitDataProperty(0, cnt++,  dtData,     140, daCenter,   false,  "cost_yrmon",    false,     "",     dfDateYm,      0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     180, daRight,    false,  "vsl_clss_capa", false,     "",     dfNullInteger, 0,  false,  false);
                InitDataProperty(0, cnt++ , dtAutoSum,  160, daCenter,   false,  "vsl_knt",       false,     "",     dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtAutoSum,  220, daRight,    false,  "dhir_amt",      false,     "",     dfNullFloat,   1,  true,   false);
                InitDataProperty(0, cnt++ , dtAutoSum,  180, daRight,    false,  "pre_dhir_amt",  false,     "",     dfNullFloat,   1,  false,  false);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,   false,  "stnd_cost_cd",  false,     "",     dfNone,        0,  false,  false);
                
                CountPosition   = 0 ;
                style.height = GetSheetHeight(18) ;
            }
            break;

        case 11:
        	with (sheetObj) {
	            SheetWidth = mainTable.clientWidth;//전체 너비 설정
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
	            MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
	            Editable = true;//전체Edit 허용 여부 [선택, Default false]
	
	            InitRowInfo(1 , 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitColumnInfo(16, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitHeadMode(false, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
	            var HeadTitle = "STS|YYYY-MM|VSL Code|VSL Class|Total|Crew Expense|Insurance|Store supply Exp|Lubricant Exp|Vessel M&R|Depreciations|Telecom Exp|Other Operation Exp|Vessel Interest|Time Charterage|";
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle, true);
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtHiddenStatus,   30,  daCenter,   false,  "ibflag");
	            InitDataProperty(0, cnt++,  dtData,     100, daCenter,   false,  "cost_yrmon",    false,     "",     dfDateYm,      0,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daCenter,   false,  "vsl_cd",        false,     "",     dfNone,        0,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "vsl_clss_capa", false,     "",     dfNullInteger, 0,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "ttl_amt",       false,     "",     dfNullFloat,   1,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "cre_amt",       false,     "",     dfNullFloat,   1,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "ins_amt",       false,     "",     dfNullFloat,   1,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "sto_amt",       false,     "",     dfNullFloat,   1,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "lub_amt",       false,     "",     dfNullFloat,   1,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "mnr_amt",       false,     "",     dfNullFloat,   1,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "dep_amt",       false,     "",     dfNullFloat,   1,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "tel_amt",       false,     "",     dfNullFloat,   1,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "vsl_amt",       false,     "",     dfNullFloat,   1,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     150, daRight,    false,  "otr_amt",       false,     "",     dfNullFloat,   1,  false,  false);
	            InitDataProperty(0, cnt++ , dtData,     100, daRight,    false,  "tim_amt",       false,     "",     dfNullFloat,   1,  false,  false);	            
	            InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,   false,  "stnd_cost_cd",  false,     "",     dfNone,        0,  false,  false);
	            
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
	var arr_f_cobcost = ["54100000","54250000","54200000","54300000","54150000","54450000","54180000","54550000","72100000","54350000",""];
	//ESM_MAS_0316
    ComSetObjValue(formObj.f_cobcost, arr_f_cobcost[nItem]);
    var tBtnSave = document.getElementById("t_btn_save");
    var tBtnMonthCopy = document.getElementById("t_btn_month_copy");
    if ( nItem == 10 ) {
    	tBtnSave.style.display = "none";
    	tBtnMonthCopy.style.display = "none";
    	ComSetFocus(document.form.f_fmyearmonth);
    } else {
    	tBtnSave.style.display = "inline";
    	tBtnMonthCopy.style.display = "inline";
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
    
    //Class 콤보 생성
    setClass_combo();
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    // 업무처리중 버튼사용 금지 처리
	sheetObj.WaitImageVisible = false;
    
    switch(sAction) {
    
		case IBCLEAR:          //초기화
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
            
            if (shtTabTotal == "1") {
            	formObj.f_cmd.value = SEARCH10;
            } else {
            	formObj.f_cmd.value = SEARCH;
            }

            sheetObj.DoSearch("ESM_MAS_0330GS.do", masFormQueryString(formObj));

            //Deferred Expense를 위한 값 추출
            ComEtcDataToForm(formObj,sheetObj);
                        
            ComOpenWait(false);
            shtTabTotal = "0";
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
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0330GS.do", masFormQueryString(formObj));
			sheetObj.LoadSaveXml(sXml);

			ComOpenWait(false);
			break;
			
        case IBSAVE:	//저장
			if(validateForm(sheetObj,formObj,sAction)){
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_MAS_0330GS.do", masFormQueryString(formObj));
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
			break;
    }
}

function validateForm(sheetObj, formObj, sAction){
	switch (sAction) {

 		case IBSEARCH: // 조회
 			if (shtTabTotal == "1") {
 				if (formObj.f_fmyearmonth.value != "" && formObj.f_toyearmonth.value == "") {
        			ComShowCodeMessage('MAS10002','correct date.\nFormat: Date : yyyymm ~ yyyymm');
        			shtTabTotal = "0";
        			return false;
        		} else if (formObj.f_fmyearmonth.value == "" && formObj.f_toyearmonth.value != "") {
        			ComShowCodeMessage('MAS10002','correct date.\nFormat: Date : yyyymm ~ yyyymm');
        			shtTabTotal = "0";
        			return false;
        		} else if (formObj.f_fmyearmonth.value != "" && formObj.f_toyearmonth.value != "") {
        			if (!ComIsDate(formObj.f_fmyearmonth.value,"ym")) {
        				ComShowCodeMessage('MAS10002','correct date.\nFormat: yyyymm');
        				formObj.f_fmyearmonth.value = "";
        				shtTabTotal = "0";
        				return false;
        			} else if (!ComIsDate(formObj.f_toyearmonth.value,"ym")) {
        				ComShowCodeMessage('MAS10002','correct date.\nFormat: yyyymm');
        				formObj.f_toyearmonth.value = "";
        				shtTabTotal = "0";
        				return false;
        			}
        		}
            } else {
            	if(!ComIsDate(formObj.f_yearweek, "ym")){
     				ComShowMessage(ComGetMsg("COM12114", "YYYY-MM"));
     				formObj.f_yearweek.focus();
     				shtTabTotal = "0";
     				return false;
     	       	}
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

function setClass_combo(){
	var comboObj = comboObjects[0];
	var formObj = document.form;	
    var vParam = "f_cmd="+SEARCH01+"&f_yearweek="+ComGetObjValue(formObj.f_yearweek);
	var sXml = sheetObjects[1].GetSearchXml("ESM_MAS_0330GS.do", vParam);
	comboObj.DropHeight=300;
	ComXml2ComboItem(sXml, comboObj, "vsl_clss_capa", "vsl_clss_capa");
	comboObj.InsertItem(0,  "All",  "All");
	comboObj.Index = 0;
}

function setVSLRegister(){
	var formObj = document.form;
	var sUrl = "";
	
	if(!ComIsDate(formObj.f_yearweek, "ym")){
		ComShowMessage(ComGetMsg("COM12114", "YYYY-MM"));
		formObj.f_yearweek.focus();
   	}else{
   		var sParam = "?f_yearweek="+ComGetObjValue(formObj.f_yearweek)
   		+"&f_cobcost="+ComGetObjValue(formObj.f_cobcost);
   			sUrl = "/hanjin/ESM_MAS_0331.do"+sParam;
   			ComOpenPopup(sUrl, 850, 600, "", "0,0", true, false);
   	} 
}

function setCostDetail(){
	var formObj = document.form;
	var sUrl = "";
	
	if(!ComIsDate(formObj.f_yearweek, "ym")){
		ComShowMessage(ComGetMsg("COM12114", "YYYY-MM"));
		formObj.f_yearweek.focus();
   	}else{
		var sParam = "?f_yearweek="+ComGetObjValue(formObj.f_yearweek)
	+"&f_cobcost="+ComGetObjValue(formObj.f_cobcost);
		sUrl = "/hanjin/ESM_MAS_0332.do"+sParam;
		ComOpenPopup(sUrl, 750, 600, "", "0,0", true, false);
   	}
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

function t10sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[9],formObject,IBSEARCH);
}

function setSumText(sheetObj){
	sheetObj.SumText(0,0) = "";
	sheetObj.SumText(0,"cost_yrmon") = "Total";	
}

function t1sheet1_OnSearchEnd(sheetObj, errMsg){
	setSumText(sheetObj);
}

function t2sheet1_OnSearchEnd(sheetObj, errMsg){
	setSumText(sheetObj);
}

function t3sheet1_OnSearchEnd(sheetObj, errMsg){
	setSumText(sheetObj);
}

function t4sheet1_OnSearchEnd(sheetObj, errMsg){
	setSumText(sheetObj);
}

function t5sheet1_OnSearchEnd(sheetObj, errMsg){
	setSumText(sheetObj);
}

function t6sheet1_OnSearchEnd(sheetObj, errMsg){
	setSumText(sheetObj);
}

function t7sheet1_OnSearchEnd(sheetObj, errMsg){
	setSumText(sheetObj);
}

function t8sheet1_OnSearchEnd(sheetObj, errMsg){
	setSumText(sheetObj);
}

function t9sheet1_OnSearchEnd(sheetObj, errMsg){
	setSumText(sheetObj);
}

function t10sheet1_OnSearchEnd(sheetObj, errMsg){
	setSumText(sheetObj);
}

function t11sheet1_OnSearchEnd(sheetObj, errMsg){
	with(sheetObj) {	
		for (var i = 0; i <= LastRow; i ++) {			
			if (sheetObjects[10].CellValue(i, "vsl_cd") == "XXXX" ) {				
				var varAverage = "Average";
				sheetObjects[10].CellValue(i, "vsl_cd") = varAverage;
				sheetObjects[10].RowBackColor(i) = sheetObjects[10].RgbColor(247,225,236);
			}
		}		
	}	
}
