/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0037.js
 *@FileTitle : Entry and Inquiry of Target Voyage Choose by Settlement Item
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2009.06.18 함대성
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
 * @class FNS_JOO_0037 : FNS_JOO_0037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0037() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

//VVD Change시에 해당하는 port를 가져오기 위함
//gBasicPortCombo[inx][0] ==> Rev. Dir  
//gBasicPortCombo[inx][1] ==> delt_flg  
//gBasicPortCombo[inx][2] ==> Basic Ports  
//gBasicPortCombo[inx][3] ==> ETA  
//gBasicPortCombo[inx][4] ==> ETD  
var gBasicPortCombo;
//gPairPortCombo[inx][0] ==> Pair Ports  
//gPairPortCombo[inx][1] ==> ETA  
//gPairPortCombo[inx][2] ==> ETD  
var gPairPortCombo;
//현재 row
var gCurRow;

//VVD
var gVVD;

//New button click시에 IBCombo들의 change이벤트를 타지 못하도록 하기 위함
var gNew = false;

var prefix="sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

		case "btn_new":
			gNew = true;
			formObject.jo_crr_cd.index = -1;
			formObject.trd_cd.index = -1;
			formObject.rlane_cd.index = -1;
			sheetObjects[0].RemoveAll();
			
			formObject.from_dt.value = formObject.hid_dt.value;
			formObject.to_dt.value = formObject.hid_dt.value;
			formObject.usdamount_chk2.checked = true;
			
			gNew = false;
			break;

		case "btn_downexcel":
            var paramObj = new Object();
            var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);  
            sheetObjects[0].SpeedDown2Excel(-1, false,false, "", url );
			break;

		case "btns_back1":
	    	sheetObjects[0].RemoveAll();
			if (formObject.from_dt.value!=""){
				formObject.from_dt.value = ComGetDateAdd(formObject.from_dt.value+"-01","M",-1).substring(0,7);
			}
			break;

		case "btns_next1":
			sheetObjects[0].RemoveAll();
			if (formObject.from_dt.value!=""){
				formObject.from_dt.value = ComGetDateAdd(formObject.from_dt.value+"-01","M", 1).substring(0,7);
			}
			break;
			
		case "btns_back2":
	    	sheetObjects[0].RemoveAll();
			if (formObject.to_dt.value!=""){
				formObject.to_dt.value = ComGetDateAdd(formObject.to_dt.value+"-01","M",-1).substring(0,7);
			}
			break;

		case "btns_next2":
			sheetObjects[0].RemoveAll();
			if (formObject.to_dt.value!=""){
				formObject.to_dt.value = ComGetDateAdd(formObject.to_dt.value+"-01","M", 1).substring(0,7);
			}
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
function loadPage(crrCombo,abbrSheet ) {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1);// abbrSheet, dirSheet, staSheet);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1, crrCombo);
    }
    
  //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 			 
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  form);    
	
	axon_event.addListener('keypress', 'from_dt_keypress', 'from_dt');
	axon_event.addListener('keypress', 'to_dt_keypress',   'to_dt');
    axon_event.addListener('click', 'click_usdamount_chk2', 'usdamount_chk2');
	
	document.form.usdamount_chk2.checked = true;
	document.form.usdamount_chk.value = "0" ;
}
 function sheet1_OnLoadFinish(sheetObj) {
     doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC02);
 }
 function form_keyup(){
	ComKeyEnter('lengthnextfocus');
 }
 
//Axon 이벤트 처리2. 이벤트처리함수
 function obj_deactivate(){
     ComChkObjValid(event.srcElement);
 }
 
 function obj_activate(){
     ComClearSeparator(event.srcElement);
 } 
 
 function to_dt_keypress(){
   	ComKeyOnlyNumber(this, '');
 }
	 
 function from_dt_keypress(){
   	ComKeyOnlyNumber(this, '');
 }

//Trd에 따른 Lane combo 설정
function user_setPortCombo(sheetObj, Row, rlaneCd, skdDirCd){
	var portItems = "";
	for (var inx=0; inx < gBasicPortCombo.length; inx++){
		if ((rlaneCd == gBasicPortCombo[inx][0]) && (skdDirCd == gBasicPortCombo[inx][1])){
			portItems = portItems + gBasicPortCombo[inx][2] +"|";
		}
	}
	if (portItems.length > 0){
		portItems = portItems.substring(0,portItems.length-1);
	}
	sheetObj.WaitImageVisible = false;   	
    sheetObj.CellComboItem(Row, prefix+"stl_bzc_port_cd" , portItems, portItems);
    sheetObj.CellComboItem(Row, prefix+"stl_pair_port_cd", portItems, portItems);
    sheetObj.WaitImageVisible = true;      
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;

     switch(sheetNo) {
         case 1:      // sheet1 init
             with (sheetObj) {
        	 	 ScrollBar = 2;
                 // 높이 설정
                 style.height = 430;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                  var HeadTitle1 = "|Account\nMonth|Trade|Lane|Carrier|Combined\nNo.|Cur.|Revenue|Expense|Balance|Beneficiary\nLine";
				  
				 var headCount = ComCountHeadTitle(HeadTitle1);
				 
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false)


                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);

                 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(i, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"Status");
                InitDataProperty(i, cnt++ , dtData,         100,    daCenter,       true,      prefix+"acct_yrmon",        false,      "",         dfDateYm,       0,          true,       true);
				InitDataProperty(i, cnt++ , dtData,			80,		daCenter,		true,		prefix+"trd_cd",		false,		"",			dfNone,			0,			true,		true);
				InitDataProperty(i, cnt++ , dtData,			100,	daCenter,		true,		prefix+"rlane_cd",			false,		"",			dfNone,			0,			true,		true);
                InitDataProperty(i, cnt++ , dtData,         100,    daCenter,       true,      prefix+"jo_crr_cd",     false,      "",         dfNone,         0,          true,       true);
				InitDataProperty(i, cnt++ , dtData,			130,	daCenter,		true,		prefix+"stl_cmb_seq",		false,		"",			dfNone,			0,			true,		true);
				
				InitDataProperty(i, cnt++ , dtData,			50,		daCenter,		true,		prefix+"locl_curr_cd",		false,		"",			dfNone,			0,			true,		true);
								
				InitDataProperty(i, cnt++ , dtData,	    	100,	daRight,		true,		prefix+"jo_rev",		false,		"",			dfFloat,			2,			true,		true);
				InitDataProperty(i, cnt++ , dtData,			100,	daRight,		true,		prefix+"jo_exp",		false,		"",			dfFloat,		2,			true,		true);
				InitDataProperty(i, cnt++ , dtData,			100,	daRight,		true,		prefix+"jo_balance",		false,		"",			dfFloat,		2,			true,		true);
				InitDataProperty(i, cnt++ , dtData,			100,	daCenter,		true,		prefix+"benefit_line",		false,		"",			dfNone,			0,			true,		true);
         	    }
             break;
     }
 }

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			//sheetObj.DoSearch("FNS_JOO_0037GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				var sXml = sheetObj.GetSearchXml("FNS_JOO_0037GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
    			var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 0) { 	   	  
 	   	  			sheetObjects[0].LoadSearchXml(arrXml[0]);			
 	   	  		}
				for(i=sheetObj.LastRow; i > 0 ; i--){
					if (sheetObj.CellValue(i, prefix+"acct_yrmon") == "TOTAL") {
						sheetObj.CellValue(i+1, prefix+"acct_yrmon") = "";
						sheetObj.CellValue(i, prefix+"stl_cmb_seq") = "";
					}
					if (sheetObj.CellValue(i, prefix+"jo_crr_cd") == "") {
						sheetObj.CellValue(i, prefix+"stl_cmb_seq") = "";
					}
					if (sheetObj.CellValue(i, prefix+"jo_crr_cd") == "Sub-Total") {
						sheetObj.CellValue(i, prefix+"stl_cmb_seq") = "";
					}
				}
			break;  
        case    IBSEARCH_ASYNC02:   //Get TRD_CD COMBO
                formObj.f_cmd.value = SEARCHLIST06;            
                var param =  FormQueryString(formObj);
        
                var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                ComXml2ComboItem( sXml, formObj.trd_cd, "code","code" );
                formObj.trd_cd.InsertItem(0, ''); 
                break;

    
        case    IBSEARCH_ASYNC03:   //Get rlane_cd COMBO
                formObj.f_cmd.value = SEARCHLIST07;            
        
                formObj.super_cd1.value = "";
                formObj.super_cd2.value = formObj.trd_cd.Code;
                var param =  FormQueryString(formObj);
                var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                ComXml2ComboItem( sXml, formObj.rlane_cd, "code","code" );
                formObj.rlane_cd.InsertItem(0, ''); 
                break;
                
        case    IBSEARCH_ASYNC04:   //Get jo_crr_cd COMBO
                formObj.f_cmd.value = SEARCH02;            
        
                formObj.super_cd1.value = formObj.rlane_cd.text;
                formObj.super_cd2.value = "";
                
                var param =  FormQueryString(formObj);
                var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
                ComXml2ComboItem( sXml, formObj.jo_crr_cd, "code","code" );
                formObj.jo_crr_cd.InsertItem(0, ''); 
                break;
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
 function initCombo(comboObj, comboNo, crrCombo) {
     var formObject = document.form
  
     switch(comboObj.id) {  
         case "jo_crr_cd": 
            with (comboObj) { 
                 MultiSelect = false; 
                 UseAutoComplete = true;    
                 SetColAlign("left|left");        
                 //SetColWidth("0|30");
                 DropHeight = 160;
                 ValidChar(2,0);//영문대문자만 입력가능
                 MaxLength=3;
             }
             
             break; 
             
         case "trd_cd": 
             with (comboObj) { 
                 MultiSelect = false; 
                 UseAutoComplete = true;    
                 SetColAlign("left|left");        
                 //SetColWidth("0|30");
                 DropHeight = 160;
                 ValidChar(2,0);//영문대문자만 입력가능
                 MaxLength=3;
             }
             break;
             
         case "rlane_cd": 
             with (comboObj) { 
                 MultiSelect = false; 
                 UseAutoComplete = true;    
                 SetColAlign("left|left");        
             //  SetColWidth("0|30");
                 DropHeight = 160;
                 ValidChar(2,1);//영문대문자+숫자만 입력가능
                 MaxLength=5;
             }
             break;

     	case "ofc_cd":
    		with (comboObj) {
    			MultiSelect = false;
    			UseAutoComplete = true;
    			SetColAlign("left");
    			SetColWidth("60");
    			DropHeight = 200;
    			ValidChar(2,2);//영문대문자만 입력가능
    			MaxLength=3;
    		}
    		var comboItems = gOffList.split("|");
    		addComboItem(comboObj, comboItems);
    		comboObj.Index2 = 0;
            if (comboItems.length == 1){
            	comboObj.Enable = false;
            }else{
            	comboObj.Enable = true;
            }	  	             
     } 
//     sheetObjects[0].WaitImageVisible = false;   
 //  doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[2], SEARCHLIST07 ,"rlane_cd"); 
 //  doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[1], SEARCHLIST06 ,"trd_cd"); 
//     sheetObjects[0].WaitImageVisible = true;   
 }


// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
			//if(validateForm(sheetObj,formObj,sAction))
			if (sComboObj.id == "trd_cd") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = sComboAction;
				formObj.code.value = "";
				formObj.super_cd1.value = formObj.jo_crr_cd.text;
				formObj.super_cd2.value = "";
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

				//Trade setting
				var comboItems = ComGetEtcData(sXml, sComboKey).split("|");
				addComboItem(sComboObj,comboItems);
				
			}else if (sComboObj.id == "rlane_cd"){
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = sComboAction;
				formObj.code.value = "";
				formObj.super_cd1.value = formObj.jo_crr_cd.text;
				formObj.super_cd2.value = formObj.trd_cd.text;
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

				var comboItems = ComGetEtcData(sXml, sComboKey).split("|");
				addComboItem(sComboObj,comboItems);
			}
														
	        break;
    }
}

//R/E변경시 
function acct_yrmon_OnChange(idx_cd, text){
	if (gNew) return;
	sheetObjects[0].RemoveAll();
}
//R/E변경시 
function acct_yrmon_OnChange(idx_cd, text){
    if (gNew) return;
    sheetObjects[0].RemoveAll();
}
 
//TRADE 변경시 LANE 변경
function trd_cd_OnChange(comObj, Value, Text){
    var formObject = document.form;

    sheetObjects[0].RemoveAll();
    formObject.jo_crr_cd.RemoveAll();
    formObject.rlane_cd.RemoveAll();    
    

}
function rlane_cd_OnFocus(comboObj){
    
    var formObj = document.form;
    
    if (comboObj.GetCount()== 0) {
        comboObj.Enable = false;
        doActionIBSheet(sheetObjects[sheetObjects.length-1], formObj, IBSEARCH_ASYNC03);
        comboObj.Enable = true;
    }
}
//RLANE 변경시 clear
function rlane_cd_OnChange(comObj, Value, Text){
    var formObject = document.form;
 
    sheetObjects[0].RemoveAll();
    formObject.jo_crr_cd.RemoveAll();
 
}
function jo_crr_cd_OnFocus(comboObj){
    var formObject = document.form;
    if (comboObj.GetCount()== 0) {
        comboObj.Enable = false;
        doActionIBSheet(sheetObjects[sheetObjects.length-1], formObject, IBSEARCH_ASYNC04);
        comboObj.Enable = true;
    }
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch(sAction){
			case IBSEARCH:
				var fr = from_dt.value;
				var to = to_dt.value;
				
				if (fr ==""){
					ComShowCodeMessage();
					from_dt.focus();
					return false;
				}
				if (ComGetDaysBetween(fr+"-01", to+"-01") < 0){
					ComShowCodeMessage("JOO00078");
					to_dt.focus();
					return false;
				}
				break;
		}
	}

	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj)
	{
        for(var i=1; i<=sheetObj.LastRow; i++) {
    		if (sheetObj.CellValue(i, prefix+"acct_yrmon") == "TOTAL") {
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(247,225,236);			//색상설정
				sheetObj.CellFont("FontBold", i, prefix+"acct_yrmon") = true;		//글자체 굵기설정
				sheetObj.CellFont("FontBold", i, prefix+"locl_curr_cd") = true;
				sheetObj.CellFont("FontBold", i, prefix+"jo_rev") = true;
				sheetObj.CellFont("FontBold", i, prefix+"jo_exp") = true;
				sheetObj.CellFont("FontBold", i, prefix+"jo_balance") = true;
			} else if (sheetObj.CellValue(i, prefix+"jo_crr_cd") == "Sub-Total") {
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(247,225,236);			//색상설정	
			}
			sheetObj.RowEditable(i) = false;
     	}
		if(SearchRows > 0) {
			//불필요 row삭제
			sheetObj.RowDelete(LastRow, false);
		}
	}
}


function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
	var sName = sheetObj.ColSaveName(Col);

	var Value = sheetObj.EditValue;

	//4자리 치면 NEXT로 이동
	if ((sName == (prefix+"vsl_cd")) && (Value.length == 4)){
		sheetObj.SelectCell(Row, prefix+"skd_voy_no",true);
	}

	//4자리 치면 NEXT로 이동
	if (sName == prefix+"skd_voy_no" && Value.length==4){
		sheetObj.SelectCell(Row, prefix+"skd_dir_cd",true);
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	var vvd = sheetObj.CellValue(Row, prefix+"vsl_cd");
	vvd = vvd + sheetObj.CellValue(Row, prefix+"skd_voy_no");
	vvd = vvd + sheetObj.CellValue(Row, prefix+"skd_dir_cd");
	
	if (sName == prefix+"vsl_cd"){
		if (Value.length < 4){
			ComShowMessage("Vessel length is 4");
			sheetObj.SelectCell(Row, Col, true);
			return;
		}

		if (vvd.length == 9){
			gVVD = vvd;
			gCurRow = Row;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}

	if (sName == prefix+"skd_voy_no"){
		if (Value.length < 4){
			ComShowMessage("Voyage length is 4");
			sheetObj.SelectCell(Row, Col, true);
			return;
		}

		if (vvd.length == 9){
			gVVD = vvd;
			gCurRow = Row;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}

	if (sName == prefix+"skd_dir_cd"){
		if (vvd.length == 9){
			gVVD = vvd;
			gCurRow = Row;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}

	//ABBR이 W/R이거나 P/B이면 Mannual settle 체크 못하게
	if (sName == prefix+"jo_stl_itm_cd"){
		if (Value=="P/B" || Value=="W/R"){
			sheetObj.CellEditable(Row,prefix+"jo_mnl_cre_flg")=false;
		}else{
			sheetObj.CellEditable(Row,prefix+"jo_mnl_cre_flg")=true;
		}
	}
	
	//Basic Port change시 ETA, ETD 세팅한다. 
	if (sName == prefix+"stl_bzc_port_cd"){
		var eta = "";
		var etd = "";
		//VVD가 같고 Port 가 같은 것의 ETA, ETD를 가져온다.
		for (var inx=0; inx<gBasicPortCombo.length; inx++){
			if (Value == gBasicPortCombo[inx][2]){
				eta = gBasicPortCombo[inx][3];
				etd = gBasicPortCombo[inx][4];
				break;
			}
		}
		
		sheetObj.CellValue(Row, prefix+"bzc_port_eta_dt") = eta;
		sheetObj.CellValue(Row, prefix+"bzc_port_etd_dt") = etd;
	}

	//Pair Port change시 ETA, ETD 세팅한다. 
	if (sName == prefix+"stl_pair_port_cd"){
		var eta = "";
		var etd = "";
		//VVD가 같고 Port 가 같은 것의 ETA, ETD를 가져온다.
		for (var inx=0; inx<gPairPortCombo.length; inx++){
			if (Value == gPairPortCombo[inx][0]){
				eta = gPairPortCombo[inx][1];
				etd = gPairPortCombo[inx][2];
				break;
			}
		}
		
		sheetObj.CellValue(Row, prefix+"pair_port_eta_dt") = eta;
		sheetObj.CellValue(Row, prefix+"pair_port_etd_dt") = etd;
	}
	 
}

function ofc_cd_OnChange(comObj, Value, Text){
	sheetObjects[0].RemoveAll();
}


function click_usdamount_chk2(){
	if (document.form.usdamount_chk2.checked){
		document.form.usdamount_chk.value = "0" ;
	}else{
		document.form.usdamount_chk.value = "" ;
	}
}
/* 개발자 작업  끝 */