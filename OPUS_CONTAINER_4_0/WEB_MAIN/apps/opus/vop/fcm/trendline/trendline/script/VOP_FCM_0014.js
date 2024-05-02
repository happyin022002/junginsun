/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0014.js
 *@FileTitle : Trend Line Type Inquiry(Pup-Up)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
 * 2014.05.02 [CHM-201429874] Standard FOC 생성 및 단계별 저장 기능 개발 - 필요한 리턴값 추가
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
 * @class VOP_FCM_0014 : VOP_FCM_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0014() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

// 공통전역변수
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
    /*******************************************************/
	var formObject = document.form;

   	try {
   		var srcName = window.event.srcElement.getAttribute("name");

   		switch(srcName) {
   			case "btn_Retrieve":
   				doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	    break;

   			case "btns_calendar2":
            	  var cal = new ComCalendarFromTo();
            	  cal.select(formObject.trnd_line_fm_dt, formObject.trnd_line_to_dt, 'yyyy-MM-dd');
        	      break;

   			case "btn_Close":
   				self.close();
       	        break;

    	    case "btn_OK":
    	    	doOk(sheetObject);
    	        break;
        	    
       	    case "btns_search":
				openLandCdHelp();
				break;	
				
       	    case "btn_vsl_cd":
       	    	var sUrl = "/opuscntr/VOP_VSK_0219.do?vsl_cd=" + formObject.vsl_cd.value + "&inc_del_vsl_pop=Y";
        		ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
    			break;
       	    	break;	
   		} // end switch
   	}catch(e) {
   		if( e == "[object Error]") {
   			ComShowMessage(OBJECT_ERROR);
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
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}
 
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
    	//khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
 	with (form.trnd_line_tp_cd) {
 		//MultiSelect = true;
 		MultiSeparator = ",";
 		DropHeight = 320;
 		InsertItem(0, 'Design Capa/Lane','1');
 		InsertItem(1, 'Design Capa/All','2');
 		InsertItem(2, 'Vessel/Bound','3');
 		InsertItem(3, 'Vessel/All','4');
 	}
	with (form.skd_dir_cd) {
 		//MultiSelect = true;
 		MultiSeparator = ",";
 		DropHeight = 320;
 		var m=0;
 		InsertItem(m++, '','');
 		InsertItem(m++, 'E','E');
 		InsertItem(m++, 'W', 'W');
 		InsertItem(m++, 'S', 'S');
 		InsertItem(m++, 'N', 'N');
 	}
	with(form.vsl_clss_cd){
		MultiSeparator = ",";
 		DropHeight = 320;
 		var classList = form.classList.value;
 		var vslClass = classList.split("|");
 		for(var m=0; m<vslClass.length; m++){
 			InsertItem(m, vslClass[m], vslClass[m]);
 		}
	}
	with(form.vsl_clss_sub_cd){
		MultiSeparator = ",";
 		DropHeight = 320;
 		var m=0;
 		InsertItem(m++, '', '');
 		InsertItem(m++, 'A', 'A');
 		InsertItem(m++, 'B', 'B');
 		InsertItem(m++, 'C', 'C');
 		InsertItem(m++, 'D', 'D');
 		InsertItem(m++, 'E', 'E');
	}
    initControl();
//    document.form.vsl_clss_cd.Enable = false;
}

function initControl() {
	var formObject = document.form;
	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
    axon_event.addListenerForm("focus", "obj_activate", formObject);
    axon_event.addListenerForm('blur', 'obj_deactivate', form);
    axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    axon_event.addListenerForm('keyup', 'obj_keyup', form);
    axon_event.addListenerForm('change', 'obj_change', form);
}
     
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {
        case 1:      //IBSheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 420;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 5000);


                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, false, false, false, false,false)
              
                var HeadTitle = "|||||||||||||SEL|Trend LineNo.|Budget|Chart|Remark|Created Date|Created ID|avg_gnr_csm_wgt|avg_blr_csm_wgt|AVG_SLP_RT|FOML_DESC" ;
                var headCount = ComCountHeadTitle(HeadTitle);
                
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, false);

                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, false);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHidden,		 0,     daCenter,  false,    "trnd_line_seq",          false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 0,     daCenter,  false,    "trnd_line_tp_cd",        false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "vsl_slan_cd",            false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "vsl_clss_cd",            false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "vsl_clss_sub_cd",        false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "vsl_cd",                 false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "skd_dir_cd",             false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "trnd_line_tp_sub_cd",    false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "n1st_coef_val",    		false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "n2nd_coef_val",    		false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "trnd_line_cons_val",    			false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "trnd_line_fm_dt",    		false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,		 40,    daCenter,  false,    "trnd_line_to_dt",    		false,          "",       dfNone,	    0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtRadioCheck,    30,    daCenter, false,     "sel",                    false,          "",       dfNone,    	0,     true,      true);
                InitDataProperty(0, cnt++ , dtData,     	 150,    daCenter, false,    "trnd_line_no",       false,          "",       dfNone,    	0,     true,      true);
                InitDataProperty(0, cnt++ , dtHidden,     	 150,    daCenter, false,    "trnd_line_use_tp_cd",       false,          "",       dfNone,    	0,     true,      true);
                InitDataProperty(0, cnt++ , dtHidden,		 120,    daCenter,  false,    "trnd_line_cht_tp_cd",    false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,     	 450,    daCenter, false,    "trnd_line_rmk",          false,          "",       dfNone,        0,     true,      true);
                InitDataProperty(0, cnt++ , dtData,     	 140,    daCenter, false,    "cre_dt",                 false,          "",       dfNone,        0,     true,      true);
                InitDataProperty(0, cnt++ , dtData,      	 100,    daCenter, false,    "cre_usr_id",             false,          "",       dfNone,        0,     true,      true);
                
                InitDataProperty(0, cnt++ , dtHidden,      	 100,    daCenter, false,    "avg_gnr_csm_wgt",       false,          "",       dfNone,        0,     true,      true); 
                InitDataProperty(0, cnt++ , dtHidden,      	 100,    daCenter, false,    "avg_blr_csm_wgt",       false,          "",       dfNone,        0,     true,      true);
                InitDataProperty(0, cnt++ , dtHidden,      	 100,    daCenter, false,    "avg_slp_rt",       false,          "",       dfNone,	    0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,      	 100,    daCenter, false,    "foml_desc",       false,          "",       dfNone,	    0,     false,       false);
               // CountFormat = "[SELECTDATAROW / TOTALROWS]";
                
                InitDataCombo(0, "trnd_line_cht_tp_cd", "C.SPD vs M/E FOC|A.SPD vs M/E FOC|C.SPD vs RPM|RPM vs M/E FOC|LOD vs M/E FOC|C.SPD vs LOD", "01|02|03|04|05|06");
                
                FocusAfterProcess = false;

           }
        break;
    } 
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {

	switch(sAction) {
		case IBSEARCH:      //조회
			if (validateForm(sheetObj, formObj, sAction)) {
				var formObject = document.form;
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("VOP_FCM_0014GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);               
				for(var i=0; i< sheetObj.RowCount+1; i++){
					sheetObj.CellEditable(i,"trnd_line_no") = false;
					sheetObj.CellEditable(i,"trnd_line_rmk") = false;
					sheetObj.CellEditable(i,"cre_dt") = false;
					sheetObj.CellEditable(i,"cre_usr_id") = false;
				}
			}
        break;
	}
}


/* 
 * Object 의 activate 이벤트에 대한 처리
 */
function obj_activate(){
	var srcName = event.srcElement.name;

	switch(srcName){
		case "trnd_line_fm_dt":
		case "trnd_line_to_dt":
			ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
			event.srcElement.select();
		break;
	}
}
  
function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
		case "ym": case "ymd":
			ComKeyOnlyNumber(obj);
			break;
		case "num":
			ComKeyOnlyNumber(obj);
			break;
		case "eng":
			ComKeyOnlyAlphabet(); 
			break;
		case "engup":
			ComKeyOnlyAlphabet('upper');
			break;
		case "engdn":
//			ComKeyOnlyAlphabet('lowernum')
			ComKeyOnlyAlphabet('lower');
			break;
		case "uppernum":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}
/** 
 * Object 의 deactivate 이벤트에 대한 처리  <br>
 */
function obj_deactivate(){
 	
	var formObj = document.form;
	obj = event.srcElement;      	
 	 
	with(formObj){
		if(obj.name=="trnd_line_fm_dt" || obj.name=="trnd_line_to_dt"){
			var fmDt = ComReplaceStr(trnd_line_fm_dt.value,"-","");
			var toDt = ComReplaceStr(trnd_line_to_dt.value,"-","");

			switch(obj.name) {
     	    	case "trnd_line_fm_dt":	// Period From Date
     	    		if(fmDt != '' && toDt != ''){
     	    			if(fmDt > toDt){
     	    				ComShowCodeMessage('COM132002');
     	    				trnd_line_fm_dt.value='';
     	    				trnd_line_fm_dt.focus();
     	    				return;
     	    			}
     	    		}
     	    		formObj.trnd_line_fm_dt.value = ComGetMaskedValue(formObj.trnd_line_fm_dt.value, "ymd");
     	    		
     	            break;
     	            
     	    	case "trnd_line_to_dt":	// Period To Date
     	    		if(fmDt != '' && toDt != ''){
     	    			if(fmDt > toDt){
     	    				ComShowCodeMessage('COM132002');
     	    				trnd_line_to_dt.value='';
     	    				trnd_line_to_dt.focus();
     	    				return;
     	    			}
     	    		}
     	    		formObj.trnd_line_to_dt.value = ComGetMaskedValue(formObj.trnd_line_to_dt.value, "ymd");
     	           	break;	
         	}
			ComChkObjValid(event.srcElement);
		}
	}
}
 
function sheet1_OnDblClick(sheetObject,Row, Col, CellX, CellY, CellW, CellH) {
	doOk(sheetObject);
} 

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with (formObj) {
		switch(sAction) {
	 	case IBSEARCH:
	 		if(trnd_line_tp_cd.Code==""){
	 			ComShowCodeMessage('COM130403', 'Trnd Line Type');
	 			return false;
	 		}
	 		break;
		}
	}
	return true;
}
     
 /**
  * btn_OK 및 sheet 더블클릭시 호출
  */
function doOk(sheetObject){
	 if(sheetObject.RowCount == 0){
		 self.close();
	 }else{
		 comPopupOK();
	 }
}
  
/**
 * Lane Code Help 파일을 오픈한다
 */
function openLandCdHelp(){
	var targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd";
	var v_display = "0,0";
	var laneCd = document.form.vsl_slan_cd.value;
  	ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);
}
 
function getVslCdData(obj){
	if(obj){
		var rtnDatas = obj[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				document.form.vsl_cd.value = rtnDatas[1];
				doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
			}
		}
	}
}