/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0331.js
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
 * @class ESM_MAS_0331 : ESM_MAS_0331 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0331() {
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

            case "btn_month_copy":
            	var vParam = "?classId=ESM_MAS_0331";
            	var display = "0,1";
            	ComOpenPopup("ESM_MAS_0173.do"+vParam, 250, 160, "", display, true, false);
            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
                
            case "btn_down_excel":
               	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;

            case "btn_load_excel":
            	sheetObject.RemoveAll();
        		var strFilePath = sheetObject.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
        		sheetObject.LoadExcel(0,1,strFilePath,2,-1,"",true, false,"3=>vsl_oshp_cd|4=>chtr_out_flg|5=>vsl_cd|6=>vsl_nm|7=>vsl_dznd_capa|8=>vsl_clss_grp|9=>vsl_clss_capa");
                break;
                
            case "btn_close":
				window.close();
				break;
                
			case "btn_row_add":
				var inx = sheetObject.DataInsert(-1);
				//sheetObject.SelectCell(inx, "vsl_oshp_cd", true);
				break;

			case "btn_row_del":
				ComRowHideDelete(sheetObject,"del_chk");
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
    
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    
	loadingMode = false;
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
                InitColumnInfo(11, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다
                var HeadTitle = "STS|Sel.|Seq.|사/용선|대선|VSL Code|VSL Name|D.Capa|Class GRP|Class|cost_yrmon";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,30, daCenter,false,  "ibflag");
                InitDataProperty(0, cnt++ , dtCheckBox,	30,	 daCenter,	true,	"del_chk");
                InitDataProperty(0, cnt++ , dtDataSeq,	40,	 daCenter,	true,	"Seq");
                InitDataProperty(0, cnt++,  dtComboEdit,80,  daCenter,  false,  "vsl_oshp_cd",   false,    "",  dfNone,        0,  false,  true,  3);
                InitDataProperty(0, cnt++,  dtComboEdit,60,  daCenter,  false,  "chtr_out_flg",  false,    "",  dfNone,        0,  false,  true,  2);
                InitDataProperty(0, cnt++,  dtComboEdit,80,  daCenter,  false,  "vsl_cd",        true,     "",  dfNone,        0,  false,  true,  4);
                InitDataProperty(0, cnt++,  dtData,     150, daLeft,    false,  "vsl_nm",        false,    "",  dfNone,        0,  false,  false);
                InitDataProperty(0, cnt++ , dtData,     120, daRight,   false,  "vsl_dznd_capa", false,    "",  dfNullInteger, 3,  false,  true,  18);
                InitDataProperty(0, cnt++ , dtData,     100, daCenter,  false,  "vsl_clss_grp",  false,    "",  dfNullInteger, 0,  true,   true,  3);
                InitDataProperty(0, cnt++ , dtData,     120, daRight,   false,  "vsl_clss_capa", false,    "",  dfNullInteger, 0,  true,   true,  5);
                InitDataProperty(0, cnt++ , dtHidden,   100, daCenter,  false,  "cost_yrmon",    false,    "",  dfNone,        0,  false,  false);

                //InitDataCombo(0, "vsl_oshp_cd",  vsl_oshp_cdText,  vsl_oshp_cdCode);
            	InitDataCombo(0, "vsl_oshp_cd",  vsl_oshp_cdText,  vsl_oshp_cdText);
                InitDataCombo(0, "chtr_out_flg",  " |TO",  "N|Y");
                
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

function setSheetInit_combo(sheetObj, codeItem, codeId, codeInit){
    var vParam = "f_cmd="+INIT+"&code_item="+codeItem+"&code_id="+codeId+"&code_init="+codeInit;		
	var sXml = sheetObjects[1].GetSearchXml("ESM_MAS_0330GS.do", vParam);
	var arrCombo = ComXml2ComboString(sXml, "code", "name");
	if(arrCombo != null){
		var vInitDataComboName = "";
		var arrVal = arrCombo[0].split("|");
		var arrName = arrCombo[1].split("|");
		for(var j=0; j<arrVal.length ; j++)
		{
			if(j == 0)
		    	vInitDataComboName = vInitDataComboName + arrVal[j] +"\t"+ arrName[j];
			else
				vInitDataComboName = vInitDataComboName + "|"+arrVal[j] +"\t"+ arrName[j];
		}
	
		//sheetObj.InitDataCombo(0, "t1sheet1_yd_cd", vInitDataComboName, arrCombo[0], arrVal[0]);
		sheetObj.InitDataCombo(0, "vsl_cd", " |"+vInitDataComboName, " |"+arrCombo[0]);
	}	
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
			//setSheetInit_combo(sheetObj, "ownVesselName", "", "");
			//setSheetInit_combo(sheetObj, "vessel", "", "");
			//setSheetInit_combo(sheetObj, "ownVesselName", "", "");
			setSheetInit_combo(sheetObj, "opVessel", "", "");
			ComOpenWait(false);
			break;
        
        case IBSEARCH:      //결과조회
            if (!validateForm(sheetObj,formObj,sAction)) {
                return false;
            }
            ComOpenWait(true);
            
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_MAS_0331GS.do", masFormQueryString(formObj));

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
				sheetObj.DoAllSave("ESM_MAS_0331GS.do", masFormQueryString(formObj));
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
       	
       	if(sAction == IBSAVE){
       		var Row = sheetObj.ColValueDup("vsl_cd");
       		if(Row > -1){
       			ComShowMessage(ComGetMsg("COM12115", "VSL Code"));
       			sheetObj.SelectCell(Row, "vsl_cd", true);
           		return false;
       		}
       	}
    } 
    return true;
}

function sheet1_OnSearchEnd(sheetObj, errMsg){
	//sheetObj.ShowSubSum("trd_cd", "vvd_bsa_capa|lod_qty", -1, false, false, 1, "cost_yrmon=Trade TTL;ldf_rto=(|lod_qty|/|vvd_bsa_capa|)*100");
	//sheetObj.ShowSubSum("rlane_dir", "ttl_amt|fnl_ttl_amt|tgt_lod_qty|teu_uc_amt|vvd_bsa_capa", -1, false, false, 1, "cost_yrmon=TTL;l_f=(|tgt_lod_qty|/|vvd_bsa_capa|)*100;teu_uc_amt=|fnl_ttl_amt|/|tgt_lod_qty|");
}

function sheet1_OnSaveEnd(ErrMsg){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	var sName = sheetObj.ColSaveName(Col);
	if (sName == "vsl_cd") {	
		var sText = sheetObj.GetComboInfo(Row, Col, "Text");
		var arrText = sText.split("|");
		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
		var vText = arrText[idx].split("\t");
	
		sheetObj.CellValue(Row, "vsl_nm") = vText[1];
	}
}

function callParentFnc(){
//	if(eventMode)
		window.dialogArguments.setClass_combo();
}



