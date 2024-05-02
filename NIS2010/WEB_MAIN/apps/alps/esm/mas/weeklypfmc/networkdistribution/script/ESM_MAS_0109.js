/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0109.js
*@FileTitle : SML Sales Amount U/C
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : Jong-Ock KIM
*@LastVersion : 1.0
=========================================================
* History
* ESM_MAS_0045 => ESM_MAS_0109 참조 수정
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0109 : ESM_MAS_0109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0109() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.doActionIBSheet    = doActionIBSheet    ;
    this.validateForm       = validateForm       ;
    this.setPeriod          = setPeriod          ;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

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

      case "btn_Creation":
          doActionIBSheet(sheetObject,formObject,COMMAND01);
          break;
          
      case "btn_Bkg_Creation":
    	  doActionIBSheet(sheetObject,formObject,COMMAND02);
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
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
    loadingMode = false;
}

/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {
	with (comboObj) {
		DropHeight = 300;
		Index = 0;
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
  switch(sheetNo) {
      case 1:      //sheet1 init
    	  
        var head1 = "R.Month|Week|Trade|Lane|Vessel|Voy.|BD|Trade Dir.|OPR|OPR2|V.Capa.|BSA.Capa.|Type|LOAD(Local+T/S)|SML Final";
        var head21 = "";
        for (var i=0; i<30; i++) {
          //head21 = head21 + "|Unit cost for SML Sales(Local+TS) ⓐO : Local vol only   ⓑI : Local+TS";
        	head21 = head21 + "|Unit cost for SML Sales";
        }
        var head22 = "|Total|Port Expense|Port Expense|Canal Transit Fee|Canal Transit Fee|Bunker|Bunker|Crew Expense|Crew Expense|Insurance|Insurance|Lubricant Expense|Lubricant Expense|Store Supply Expense|Store Supply Expense";
        head22 += "|Vessel M&R|Vessel M&R|Depreciations|Depreciations|Telecom Expense|Telecom Expense|Other Operation Fixed Exp|Other Operation Fixed Exp|Time Charterage|Time Charterage|Space Charterage|Space Charterage|VSL Interest|VSL Interest";	
        var head23 = "|Total|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|AMT|Unit Cost";
                           
        with (sheetObj) {
          style.height = GetSheetHeight(19) ;
          
          //전체 너비 설정
          SheetWidth = mainTable.clientWidth;
          
          //Host정보 설정[필수][HostIp, Port, PagePath]
          if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
          
          //전체Merge 종류 [선택, Default msNone]
          MergeSheet = msHeaderOnly;
          
           //전체Edit 허용 여부 [선택, Default false]
          Editable = false;
          
          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
          InitRowInfo(3, 1, 9, 100);
          
          // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
          InitHeadMode(true, true, false, true, false, false);
          
          var HeadTitle0 = head1+head21;
          var HeadTitle1 = head1+head22;
       	  var HeadTitle2 = head1+head23;
          
          var headCount = ComCountHeadTitle(HeadTitle1);
          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
          InitColumnInfo(headCount, 0, 0, true);
       		  
          //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          InitHeadRow(0, HeadTitle0, true);
          InitHeadRow(1, HeadTitle1, true);
          InitHeadRow(2, HeadTitle2, false);

          //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
          //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
          //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
          //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
          var cnt = 0;
          InitDataProperty(0, cnt++, dtData,    55, daCenter, true, "cost_yrmon",    	false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    45, daCenter, true, "cost_wk",         	false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "trd_cd",           false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    55, daCenter, true, "rlane_cd",         false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    60, daCenter, true, "vsl_cd",           false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    45, daCenter, true, "skd_voy_no",       false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    35, daCenter, true, "dir_cd",           false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "hul_bnd_cd",       false, "", dfNone,    0, false, false);

          InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "vop_cd",           false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "vsl_oshp_cd",      false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 50, daRight,  true, "vsl_capa",         false, "", dfInteger, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 65, daRight,  true, "bsa_capa",         false, "", dfInteger, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    45, daCenter, true, "bsa_op_nm",        false, "", dfNone,    0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 110, daRight, true, "hjs_sls_uc_qty",   false, "", dfInteger, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 65, daRight,  true, "fnl_hjs_bsa_capa", false, "", dfFloatOrg,2, false, false);
          
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "hjs_sls_amt",      false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_01",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_01",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_02",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_02",         false, "", dfFloatOrg, 0, false, false);          
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_03",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_03",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_04",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_04",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_05",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_05",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_06",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_06",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_07",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_07",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_08",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_08",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_09",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_09",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_10",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_10",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_11",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_11",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_12",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_12",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_13",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_13",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_1_14",         false, "", dfFloatOrg, 0, false, false);
          InitDataProperty(0, cnt++, dtAutoSum, 75, daRight,  true, "amt_2_14",         false, "", dfFloatOrg, 0, false, false);

          HeadRowHeight = 10;
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
function f_seltrade_OnChange(obj,value,text) {
	var formObj = document.form;
	if ("All"!=value) {
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCHLIST01;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0109GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_selrlane, "code", "name");
		formObj.f_selrlane.Index = 0;
	} else {
		formObj.f_selrlane.RemoveAll();
		formObj.f_selrlane.InsertItem(0, "All", "All");
		formObj.f_selrlane.Index = 0;
	}
}
    
/**
 * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
 */
function setPeriod(obj) {
	if(chkValidSearch()){
		var formObj = document.form;
	    var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("initPeriodGS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";		
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    
    switch(sAction) {
	    case IBCLEAR:          //조회
		    sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0109GS.do", masFormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			var prevWeek = "";
			if (0 < arrXml.length) {
				ComXml2ComboItem(arrXml[0], formObj.f_seltrade, "code", "name");
				prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
			}
			if (1 < arrXml.length)
				ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "name");
			if (2 < arrXml.length)
				ComXml2ComboItem(arrXml[2], formObj.f_selioc, "code", "name");
			
			formObj.f_year.focus();
			formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
		    formObj.f_fm_wk.value = formObj.f_to_wk.value = prevWeek;
		    setPeriod(formObj.f_to_wk);
			ComOpenWait(false);
			break;	

		case IBSEARCH:      //조회
            if (!validateForm(sheetObj,formObj,sAction)) {
                return false;
            }
			// 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch4Post("ESM_MAS_0109GS.do", masFormQueryString(formObj));
			ComOpenWait(false);
			break;			
        
        case IBDOWNEXCEL:   //엑셀 다운로드
            //sheetObj.Down2Excel(-1, false, false, true);
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
        
        case COMMAND01:      //생성
			if(!validateForm(sheetObj,formObj,sAction)) return false;
            if (ComShowConfirm(ComGetMsg('MAS10020')) == true) {
            	//업무처리중 버튼사용 금지 처리
			    ComOpenWait(true);
		        formObj.f_cmd.value = MULTI01;
		        var sXml = sheetObj.GetSearchXml("ESM_MAS_0109GS.do", masFormQueryString(formObj));
		        var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
				switch(BatchStatus){
					case "C": // 작업 submit	
						formObj.f_uc_cd.value = "BKUC";
						monitoringBatchJob();
						break;
					case "P"://해당 작업이 진행 중 
						ComShowCodeMessage("MAS00003", "Creation");
						ComOpenWait(false);
						break;
					default: break;							
				}
            }
            break;
            
        case COMMAND02:      //생성
			if(!validateForm(sheetObj,formObj,sAction))return false;
			if (ComShowConfirm(ComGetMsg('MAS10020')) == true) {
				//업무처리중 버튼사용 금지 처리
			    ComOpenWait(true);
		        formObj.f_cmd.value = MULTI02;
		        var sXml = sheetObj.GetSearchXml("ESM_MAS_0109GS.do", masFormQueryString(formObj));
		        var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
				switch(BatchStatus){
					case "C": // 작업 submit	
						formObj.f_uc_cd.value = "BKOP";
						monitoringBatchJob();
						break;
					case "P"://해당 작업이 진행 중 
						ComShowCodeMessage("MAS00003", "Creation");
						ComOpenWait(false);
						break;
					default: break;							
				}
			}
            break;            
    }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (f_year.value == "") {
			// [COM12114] : Year 를(을) 확인하세요.
			ComShowMessage(ComGetMsg("COM12114", "Year"));
			f_year.focus();
			return false;
		}

		if(!ComChkObjValid(f_year, null, null, "yyyy")) return false;
			if(f_fm_wk.value == "") {
			ComShowMessage(ComGetMsg("COM12114","From Week",""));
			f_fm_wk.focus();
			return false;
		}

		if(f_fm_wk.value.length != 2) {
			ComShowMessage(ComGetMsg("COM12114","From Week",""));
			f_fm_wk.focus();
			return false;
		}

		if(f_to_wk.value == "") {
			ComShowMessage(ComGetMsg("COM12114","To Week",""));
			f_to_wk.focus();
			return false;
		}

		if(f_to_wk.value.length != 2) {
			ComShowMessage(ComGetMsg("COM12114","To Week",""));
			f_to_wk.focus();
			return false;
		}
		
		if(sAction == IBCREATE){
			if(f_fm_wk.value != f_to_wk.value) {
				ComShowMessage(ComGetMsg("MAS10012","Week","From","To"));
				f_fm_wk.focus();
				return false;
			}
		}
	}
	return true;
}

/**
 * 검색시 필수입력사항 체크
*/
function chkValidSearch(){
    var formObj = document.form;
	
	with(formObj){
		// Year Check..
		if (f_year.value == "") {
			// [COM12114] : Year 를(을) 확인하세요.
			ComShowCodeMessage("COM12114", "Year");
			f_year.focus();
			return false;
		}
		
		if(!ComIsDate(f_year, "yyyy")){
			// [MAS10009] = 'Please enter Year correctly.\n\n Format : YYYY
			ComShowCodeMessage('MAS10009','Year','YYYY');
			f_year.focus();
			return false;
		}
		
		if (f_fm_wk.value != "" && f_to_wk.value == ""){
			// [COM12114] : Week 를(을) 확인하세요.
			ComShowCodeMessage("COM12114", "Week");
			f_to_wk.focus();
			return false;
		}
		if (f_fm_wk.value == "" && f_to_wk.value != ""){
			// [COM12114] : Week 를(을) 확인하세요.
			ComShowCodeMessage("COM12114", "Week");
			f_fm_wk.focus();
			return false;
		}
		if (f_fm_wk.value > f_to_wk.value) {
			// [MAS10011] = Month의 From는(은) To보다 적거나 같아야 합니다.
			ComShowCodeMessage("MAS10011","Week","From","To");
			f_to_wk.focus();
			return false;
		}
		if(!ComIsWeek(f_fm_wk)){
			// [MAS1009] = Week 값을 확인하십시오.
			ComShowCodeMessage('MAS10009','Week','WW');
			f_fm_wk.focus();
			return false;
		}
		if(!ComIsWeek(f_to_wk)) {
			// [MAS1009] = Week 값을 확인하십시오.
			ComShowCodeMessage('MAS10009','Week','WW');
			f_to_wk.focus();
			return false;
		}
	}
	return true;
}

function monitoringBatchJob(){
	//개발시에는 모니터링을 하지 않는다.
	if(location.hostname == "localhost"){
		return;
	}
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH01;
	var sXml = sheetObj.GetSearchXml("ESM_MAS_0109GS.do", masFormQueryString(formObj));
	var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
	if( BatchStatus == "P" ){
		if (formObj.f_uc_cd.value == "BKUC") {
			setTimeout(monitoringBatchJob, 30000);
		} else if (formObj.f_uc_cd.value == "BKOP") {
			setTimeout(monitoringBatchJob, 180000);
		}
	}else{
		if (formObj.f_uc_cd.value == "BKUC") {
			ComShowCodeMessage('MAS10018',"U/C Creation");
		} else if (formObj.f_uc_cd.value == "BKOP") {
			ComShowCodeMessage('MAS10018',"BKG Creation");
		}
		ComOpenWait(false);
		formObj.f_uc_cd.value = "";
	}
}

