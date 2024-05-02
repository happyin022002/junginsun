/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FNS_JOO_0096.jsp
*@FileTitle : Additional Slot Sales/Purchase History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : 길정권
*@LastVersion : 1.0
* 2014.05.20 길정권
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
 * @class FNS_JOO_0096 : FNS_JOO_0096 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0096() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initCombo = initCombo;
	this.doActionIBCombo = doActionIBCombo;
	this.form_keyup = form_keyup
	this.doActionIBSheet = doActionIBSheet;
	this.obj_keypress = obj_keypress;
	this.sheet1_OnChange = sheet1_OnChange;
	this.sheet1_OnPopupClick = sheet1_OnPopupClick;
	this.UF_setLaneCombo = UF_setLaneCombo;
	this.validateForm = validateForm;
	this.UF_copyRow = UF_copyRow; 

}

/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var curRow = 1;
	var gVVD = "";
	var gPicUsrId = "";
	
	var vRedivrcd = "Revenue, R|Expense, E";
	var vDeltflg = "Y|N";
	var vStlflg = "Y|N";
    var vJoCarrier = "";	
    var vJoLane = "";	
	//sheet내의 lane code를 trade에 따라 선택할 수 있도록 하는 이차원배열
	//gLaneComboItem[inx][0] => TRADE CODE;
	//gLaneComboItem[inx][1] => LANE CODE;
	var gLaneComboItem; 
	var atchRow = "";
	var Dt = new Date();
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	
	/*******************************************************/
	var formObj = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var srcObj  = window.event.srcElement;

		switch (srcName) {

		case "btns_copy":
			UF_copyRow();
			break;		
		
		case "btn_add":
			var inx = sheetObject.DataInsert(-1);
			sheetObject.CellValue(inx, "trd_cd") = "";
			sheetObject.CellValue(inx, "rlane_cd") = "";
			sheetObject.CellValue(inx, "acctg_crr_cd") = "";
			sheetObject.CellValue(inx, "ofc_cd") = gUserOfcCd;
			
			sheetObject.CellValue(inx, "delt_flg") = "N";
			sheetObject.SelectCell(inx,"rel_ofc_cd",true);
			
			sheetObject.CellValue(inx,"del_chk") = "1";
			break;

		case "btn_delete":
			JooRowHideDelete(sheetObject, "del_chk");
			break;

		case "btn_retrive":
			doActionIBSheet(sheetObject, formObj, IBSEARCH);
			break;

		case "btn_new":
			sheetObject.RemoveAll();
			//201408 민정호
			comboObjects[0].Index = 0;
			comboObjects[1].Index = 0;
			comboObjects[2].Index = 0;
			comboObjects[3].Index2 = 0;
			comboObjects[4].Index2 = 0;
			comboObjects[5].Index2 = 2;
			comboObjects[5].Index2 = 2;
			formObj.vvd_cd.value = "";

			var Dt = new Date();
			formObj.cre_dt_to.value = Dt.getFullYear() + "-" + addZero(eval(Dt.getMonth()+1));
			Dt.setMonth( Dt.getMonth() - 13 );
			formObj.cre_dt_fr.value = Dt.getFullYear() + "-" + addZero(eval(Dt.getMonth()+1));
			//ComResetAll();							
			break;

		case "btn_save":
			doActionIBSheet(sheetObject, formObj, IBSAVE);
			break;

		case "btn_downExcel":
			//sheetObject.Down2Excel(-1, false, false, true);
			var paramObj = new Object();
			var url = ComJooGetPgmTitle(sheetObject, paramObj);
			//sheetObject.SpeedDown2Excel(-1, false, false, "", url);
			sheetObject.Down2Excel(-1, false, false, true,"",url,false,false,"",false,"1");
			break;
			
    		//Creation Date 달력
		case "btns_calendar1":		
			if ( srcObj.style.filter == "" ) {
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.cre_dt_fr, "yyyy-MM");
			}

			break;

		case "btns_calendar2":
			if ( srcObj.style.filter == "" ) {
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.cre_dt_to, "yyyy-MM");
			}
			break;
		
		case "cre_dt_cal":
			var cal = new ComCalendarFromTo();
			cal.select(formObj.cre_dt_fr, formObj.cre_dt_to, 'yyyy-MM-dd');
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
function loadPage(tradeComboList, tradeSheetList, rlaneSheetList, carriSheetList,  dirctSheetList) {
	//전역변수 2차원 배열 setting 
	//gLaneComboItem[inx][0] ==> TRADE 코드
	//gLaneComboItem[inx][1] ==> RLANE 코드
	gLaneComboItem = rlaneSheetList.split("|");
	var rlaneCombo = "";
	for (var inx=0; inx<gLaneComboItem.length; inx++){
		gLaneComboItem[inx] = gLaneComboItem[inx].split(",");
		rlaneCombo += gLaneComboItem[inx][1] + "|";
	}
	
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1,  carriSheetList, tradeSheetList, rlaneCombo,  dirctSheetList);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
		
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1, tradeComboList);
    }
    vJoCarrier = carriSheetList;
    vJoLane = rlaneCombo;
    
    /* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
    
    initControl();
}

function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  ,  formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	//axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj);
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj);
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
	//axon_event.addListenerForm('change',			'obj_change',	formObj); //- 변경될때.

	formObj.cre_dt_to.value = Dt.getFullYear() + "-" + addZero(eval(Dt.getMonth()+1));
	Dt.setMonth( Dt.getMonth() - 13 );
	formObj.cre_dt_fr.value = Dt.getFullYear() + "-" + addZero(eval(Dt.getMonth()+1));
    
    formObj.jo_crr_cd.focus();
}

function addZero(i){
	var rtn = i + 100;
	return rtn.toString().substring(1,3);
}

function form_keyup(){
	ComKeyEnter('lengthnextfocus');  
} 

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {
	var bReturn;
	bReturn = ComChkObjValid(event.srcElement);
	if (!bReturn){
		event.srcElement.value = "";
	}
}


function obj_activate() {
	ComClearSeparator(event.srcElement);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo, carriSheetList, tradeSheetList, rlaneSheetList , dirctSheetList) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle   = "||Office|Related\nOffice|Rev/Exp|Term|Carrier|Date|Trade|Lane|VVD|PIC|PIC|Issue Date|Leg\nFrom|Leg\nTo|BSA|Weight|Price|Remark|Settlement\nDate|Actual OUS\nQuantity|Attached||Delete|";
			var HeadTitle2  = "||Office|Related\nOffice|Rev/Exp|Term|Carrier|Date|Trade|Lane|VVD|ID|NAME|Issue Date|Leg\nFrom|Leg\nTo|BSA|Weight|Price|Remark|Settlement\nDate|Actual OUS\nQuantity|Attached||Delete|";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);

			//InitComboNoMatchText(true); //COMBO에서 match된 data가 없어도 보여짐

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus    , 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox	, 30, daCenter, true, "del_chk"       , false, "", dfNone, 0);

			InitDataProperty(0, cnt++, dtData		, 50, daCenter, true,   "ofc_cd"      	, false, "", dfNone        	, 0, false, false ,6);      // Office
			InitDataProperty(0, cnt++, dtCombo   	, 70, daCenter, true,   "rel_ofc_cd"  	, false, "", dfNone        	, 0, true, true ,6);      // Related Office
			InitDataProperty(0, cnt++, dtCombo      , 70, daCenter, true,   "rev_divr" 	 , true , "", dfNone        	, 0, false, true );        // Rev/Exp
			InitDataProperty(0, cnt++, dtCombo      , 60, daCenter, true,   "term"   	    , false, "", dfNone        	, 0, true, true );        // Term

			InitDataProperty(0, cnt++, dtCombo		, 70, daCenter, true,	  "acctg_crr_cd" , true , "", dfNone			, 0, false, true);
			InitDataProperty(0, cnt++, dtData		, 80, daCenter, true,   "date_dt"      , false, "", dfDateYmd     , 0, true, true);         // Date

			InitDataProperty(0, cnt++, dtCombo		, 60, daCenter, true,	  "trd_cd"       , true , "", dfNone			, 0, false, true, 3);
			InitDataProperty(0, cnt++, dtCombo		, 60, daCenter, true,	  "rlane_cd"     , true , "", dfNone			, 0, false, true);

			InitDataProperty(0, cnt++, dtData		, 80, daCenter, true,   "vvd_cd"       , false, "", dfNone        	, 0, true, true ,9 );     // VVD
			
			InitDataProperty(0, cnt++, dtData		, 80, daLeft, false,   "pic_usr_id"       , false, "", dfNone        	, 0, true, true ,20 );     // VVD
			InitDataProperty(0, cnt++, dtData		, 110, daLeft, false,   "pic_usr_nm"       , false, "", dfNone        	, 0, false, false);     // VVD
			InitDataProperty(0, cnt++, dtData		, 80, daCenter, true,   "cre_dt"       , false, "", dfNone        	, 0, false, false);     // VVD
			
			InitDataProperty(0, cnt++, dtData		, 60, daCenter, true,   "leg_fport"  	, false, "", dfNone        	, 0, false, false ,5 );     // Port from
			InitDataProperty(0, cnt++, dtData		, 60, daCenter, true,   "leg_tport"  	, false, "", dfNone        	, 0, false, false, 5 );     // Port to

			InitDataProperty(0, cnt++, dtData		, 70, daRight , true,   "jo_bsa"      	, false, "", dfInteger     	, 0, true , true );        // BSA			
			InitDataProperty(0, cnt++, dtData		, 70, daRight,  true,   "jo_weight"    	, false, "", dfFloat	   	, 2, true, true );        // Weight 
			InitDataProperty(0, cnt++, dtData		, 70, daRight,  true,   "jo_price"    	, false, "", dfFloat 	   	, 2, true , true );        // Price 
			InitDataProperty(0, cnt++, dtData		,100, daLeft,   true,   "jo_remark"    	, false, "", dfNone   		, 0, true , true );        // remark

			InitDataProperty(0, cnt++, dtData		, 80, daCenter , true,  "settle_dt"    	, false, "", dfDateYmd 		, 0, true , true );        // Settle date
			InitDataProperty(0, cnt++, dtData		, 80, daRight , true,   "ous_qty"    	, false, "", dfFloat 		, 2, true , true );        // OUS Quantity 
			InitDataProperty(0, cnt++, dtPopup		, 70, daCenter, true,   "attach_flg"   	, false, "", dfNone        	, 0, true, true);          // Attach
			InitDataProperty(0, cnt++, dtHidden		, 50, daCenter, true,   "atch_file_id"   	, false, "", dfNone        	, 0, true, true);          // Attach
//            InitDataProperty(0, cnt++ , dtPopup,			80,			daCenter,		true,			prefix+"file_cnt",				false,	        "",	     dfNone,	  		0,	   	true,	    true,	 200);
			InitDataProperty(0, cnt++, dtCombo		, 50, daCenter, true,   "delt_flg"     	, false, "", dfNone        	, 0, false, false);          // delete
			InitDataProperty(0, cnt++, dtHidden		, 50, daCenter, true,   "agmt_seq"     	, false, "", dfNone        	, 0, true, true);          // Seq

			
			InitDataCombo(0, "trd_cd"        , tradeSheetList, tradeSheetList, "", "");
			InitDataCombo(0, "rlane_cd"      , rlaneSheetList, rlaneSheetList, "", "");
			InitDataCombo(0, "acctg_crr_cd"  , carriSheetList, carriSheetList, "", "");
			InitDataCombo(0, "delt_flg"      , "Y|N"      , "Y|N");
			
            InitDataCombo(0, "rel_ofc_cd" , " |SELADG|SELCTS|SELCTY|SELCOV", " |SELADG|SELCTS|SELCTY|SELCOV");
			InitDataCombo(0, "rev_divr" , " |Rev|Exp", " |R|E");
			InitDataCombo(0, "attach_flg" , "Y|N", "Y|N");
			InitDataCombo(0, "term" , " |Fixed|Used", " |F|U");
			InitDataValid(0, "vvd_cd"    , vtEngUpOther, "0123456789");		//영문대문자+숫자
            InitDataValid(0, "leg_fport", vtEngUpOther, "0123456789");    	// 영대문자만+숫자
            InitDataValid(0, "leg_tport", vtEngUpOther, "0123456789");    	// 영대문자만+숫자

		}
		break;

	case 2: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
		}
		break;
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo, tradeComboList) {
    var formObj = document.form

    switch(comboNo) {  
		//Carrier
		case 1: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
		    }
			break;
			
		//Trade
    	case 2: 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
 				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=3;
 		    }
           	addComboItem(comboObj, tradeComboList.split("|"));           	
  
 			break; 

 		//Rlane
    	case 3: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;
 				ValidChar(2,1);//영문대문자만 입력가능
 				MaxLength=5;
  		    }
  			break;
  			
  		//Delt Flag	
		case "5":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 200;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 3;
			}
			var comboItems = "ALL, |Y,Y|N,N";
			UF_addComboItem(comboObj, comboItems.split("|"));
			comboObj.Code2 = "N";
			
			break;
		//Rev Exp
		case "4":
			with (comboObj) {
				MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 160;
				ValidChar(2, 0);//영문대문자만 입력가능
				MaxLength = 7;
			}
			var comboItems = "ALL, |Rev,R|Exp,E";
			UF_addComboItem(comboObj, comboItems.split("|"));
			comboObj.Text2 = "ALL";
			break;
 	} 
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj, sComboKey) {	
    sheetObj.ShowDebugMsg = false;
    switch(sAction) {

       case IBSEARCH: //TRADE
			if (sComboObj.id == "rlane_cd"){
				formObj.f_cmd.value = SEARCH01;
				formObj.super_cd1.value = "";
				
				//201408 민정호
				if(formObj.trd_cd.text == 'ALL'){
					formObj.super_cd2.value = '';					
				}else{
					formObj.super_cd2.value = formObj.trd_cd.text;					
				}				
				formObj.code.value = "";
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
				
				var comboItems = ("ALL, |"+ComGetEtcData(sXml, sComboKey)).split("|");
				addComboItem(sComboObj, comboItems);
			}else if (sComboObj.id == "jo_crr_cd"){				
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();

				formObj.f_cmd.value = SEARCH02;            								
                formObj.super_cd1.value = formObj.rlane_cd.Code;
                formObj.super_cd2.value = formObj.trd_cd.Code;
                
                var param =  FormQueryString(formObj);
                var sXml  = sheetObj.GetSearchXml("JOOCommonGS.do", param);
				var comboItems = (",|"+ComGetEtcData(sXml, sComboKey)).split("|");
				addComboItem(sComboObj, comboItems);
			}
														
	        break;
    }
}

/**
 * Trade 변경시 Reset
 * @param comboObj
 * @param idx_cd
 * @param text
 * @return
 */
function trd_cd_OnChange(comboObj, idx_cd, text){
	//sheetObjects[0].RemoveAll();
	//comboObjects[1].Index2 = -1;
	//comboObjects[1].RemoveAll();
	comboObjects[2].Index2 = -1;
	comboObjects[2].RemoveAll();
	//comboObjects[2].InsertItem(0, "ALL", " ");
	//comboObjects[2].Index2 = 0;	
	
	
	var formObj = document.form;
	
	if (comboObjects[2].GetCount() == 0){
		comboObjects[2].Enable = false;
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObjects[2], "rlane_cd");		
		comboObjects[2].Enable = true;
	}
	
	comboObjects[2].Index2 = 0;
	formObj.rlane_cd.focus();
	
}

//LANE 변경시 Reset 
function rlane_cd_OnChange(comboObj){	
//	201408 민정호		
//	if(comboObj.Index == -1){
//		comboObjects[2].Index2 = 0;			
//	}  	
}

//Carrier코드 Focus 획득시 Carrier코드 LIST 조회
function jo_crr_cd_OnFocus(comboObj){
	var formObj = document.form;

	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;
		doActionIBCombo(sheetObjects[0] , formObj ,IBSEARCH , comboObj, "jo_crr_cd");
		comboObj.Enable = true;
	}
}

//Carrier코드 변경시 Reset
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();	
}

/**
 * Trade Combo Focus 이동시 Rlane Combo 조회
 * @param comboObj
 * @return
 */
//function trd_cd_OnBlur(comboObj, Index_Code, Text) {
// 201408 민정호	
//	var formObj = document.form;
//	
//	if (comboObjects[2].GetCount() == 0){
//		comboObjects[2].Enable = false;
//		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObjects[2], "rlane_cd");		
//		comboObjects[2].Enable = true;
//	}
//	
//	comboObjects[2].Index2 = 0;
//	formObj.rlane_cd.focus();
//}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_focus(){
	var formObj = document.form;
	var obj = event.srcElement;
	
    if (event.srcElement.name == "cre_dt_fr"){		
    	ComClearSeparator(formObj.cre_dt_fr, "ym");
    	ComSetFocus(formObj.cre_dt_fr);
    }	
    if (event.srcElement.name == "cre_dt_to"){		
    	ComClearSeparator(formObj.cre_dt_to, "ym");
    	ComSetFocus(formObj.cre_dt_to);
    }    
}

/**
 * Key-Press Event 처리
 */
function obj_keypress() {
	var obj = event.srcElement;
	var formObj = document.form;

	switch(obj.dataformat) {
        case "ymd":
        case "ym":
            if(obj.name=="cre_dt_fr") ComKeyOnlyNumber(this, "-");
            if(obj.name=="cre_dt_to") ComKeyOnlyNumber(this, "-");            
            break;
        case "hms":
        case "hm":
        case "jumin":
        case "saupja":
        case "int":
            ComKeyOnlyNumber(obj);
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;
        case "eng":
            ComKeyOnlyAlphabet();
            break;
        case "engup":
        	if(obj.name == "setl_cd") {
        		ComKeyOnlyAlphabet('uppernum');
        	} else if(obj.name == "vvd_cd") {
        		if(obj.value.length > 3 && obj.value.length < 8) {
					ComKeyOnlyNumber(obj);
        		} else if (obj.value.length < 4) {
					ComKeyOnlyAlphabet('uppernum');
        		} else {
					ComKeyOnlyAlphabet('upper');
	        	}
        	} else {
				ComKeyOnlyAlphabet('upper');
        	}
            break;
        case "engdn":
            ComKeyOnlyAlphabet('lower');
            break;
        default:
            ComKeyOnlyNumber(obj);
        	break;
    }
}

/**
 * Sheet1 OnChange
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;

	if(sheetObj.ColSaveName(Col) == "vvd_cd"){
		if(Value.length < 9 && Value.length > 0){
			ComShowCodeMessage('JOO00031');
			sheetObj.CellValue2(Row,"vvd_cd") = "";
			return;
		}
	}
	
	if (sheetObj.ColSaveName(Col)== "skd_dir_cd"){
		if (sheetObj.CellValue(Row, "vsl_cd").length==4){
			if (sheetObj.CellValue(Row, "skd_voy_no").length==4){
				curRow = Row; //현재 row
				gVVD = sheetObj.CellValue(Row, "vsl_cd")
				+sheetObj.CellValue(Row, "skd_voy_no")
				+sheetObj.CellValue(Row, "skd_dir_cd");
				doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
			}
		}
	}else 	if (sheetObj.ColSaveName(Col) == "vvd_cd"){
		var strVvdCd = Value;
		if (strVvdCd.substring(0,4).length==4){
			if (strVvdCd.substring(4,8).length==4){
				if (strVvdCd.substring(8).length==1){
					curRow = Row; //현재 row
					gVVD = Value;
					doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
				}
			}
		}
		if(sheetObj.CellValue(Row, "vvd_cd").length == 9){
			sheetObj.CellEditable(Row,"leg_fport") = true;			
			sheetObj.CellEditable(Row,"leg_tport") = true;
		}else{
			sheetObj.CellEditable(Row,"leg_fport") = false;			
			sheetObj.CellEditable(Row,"leg_tport") = false;
		}
	}else if(sheetObj.ColSaveName(Col) == "leg_tport"){
		if (Value.length == 5) {
			curRow = Row;
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC09);
		}
	}else if(sheetObj.ColSaveName(Col) == "leg_fport"){
		if (Value.length == 5) {
			curRow = Row;
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC09);
		}
	//Sheet내의 Trade 변경시 변경된 Trade에 해당하는 Rlane만 모아서 Rlane Combo를 setting한다. 
	}else if (sheetObj.ColSaveName(Col)== "trd_cd"){
		var trdCd = sheetObj.CellValue(Row, Col);
		UF_setLaneCombo(sheetObj, Row, trdCd);
	//pic user id 변경시 user nm을 조회 해 온다.
	}else if (sheetObj.ColSaveName(Col)== "pic_usr_id"){
		curRow = Row;
		gPicUsrId = Value;
		if(gPicUsrId != ""){
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC10);
		} else {
			sheetObj.CellValue(Row, "pic_usr_nm") = "";
		}
	}
	
	if(sheetObj.CellValue(inx,"del_chk") != "1"){
		sheetObj.CellValue(inx,"del_chk") = "1";
	}
}

/**
 * Sheet내의 Trade 변경시 변경된 Trade에 해당하는 Rlane만 모아서 Rlane Combo를 setting한다.
 * @param sheetObj
 * @param Row
 * @param trdCd
 * @return
 */
function UF_setLaneCombo(sheetObj, Row, trdCd){
	var laneItems = "";
	for (var inx=0; inx < gLaneComboItem.length; inx++){
		if (trdCd == gLaneComboItem[inx][0]){
			laneItems = laneItems + gLaneComboItem[inx][1] +"|";
		}
	}
	if (laneItems.length > 1){
		laneItems = laneItems.substring(0,laneItems.length-1);
	}
    sheetObj.CellComboItem(Row, "rlane_cd", laneItems, laneItems);
    sheetObj.CellValue2(Row, "rlane_cd") = ""; //Change Event가 발생하지 않는다.
}

/**
 * Carrier Code 조회하기 위함
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col){
	
	if (sheetObj.ColSaveName(Col) == "jo_n2nd_crr_cd"){		
		ComOpenPopup('/hanjin/COM_ENS_0N1.do', 450, 455, 'getCOM_ENS_0N1', '1,0,1,1,1', false, false, Row, "jo_n2nd_crr_cd", 0);
	}else if (sheetObj.ColSaveName(Col) == "attach_flg"){
		
		var saveFileId = sheetObj.CellValue(Row, "atch_file_id");
		//if (sheetObj.CellValue(Row, "agmt_seq") == "") {
			//ComShowCodeMessage('JOO00003');
			//return;
		//}

		  var param = "?file_save_id="+saveFileId+
		     "&tbl_nm="+"joo_fx_agmt"+
		     "&col_nm1="+"jo_crr_cd"+
		     "&col_val1="+sheetObj.CellValue(Row, "acctg_crr_cd")+
		     "&col_nm2="+"trd_cd"+
		     "&col_val2="+sheetObj.CellValue(Row, "trd_cd")+
		     "&col_nm3="+"rlane_cd"+
		     "&col_val3="+sheetObj.CellText(Row, "rlane_cd")+
		     "&col_nm4="+"re_divr_cd"+
		     "&col_val4="+sheetObj.CellValue(Row, "rev_divr")+
		     "&col_nm5="+"fx_agmt_seq"+
		     "&col_val5="+sheetObj.CellValue(Row, "agmt_seq")+
		     "&edit_able="+"Y";
		  atchRow = Row;
		  ComOpenPopup("/hanjin/FNS_JOO_0097.do"+param, 835, 450, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
	}
}

function get_Child(arg){
	 var sheetObj = sheetObjects[0];
	 
	 if (arg == ""|| arg == undefined) {
		 sheetObj.CellValue2(atchRow, "attach_flg"  ) = "N";
	 } else {
		 sheetObj.CellValue2(atchRow, "attach_flg"  ) = "Y";
	 }
	 sheetObj.CellValue2(atchRow, "atch_file_id") = arg;
}


/**
 * Carrier Code Pop-UP 에서 OK 누른 후 실행되는 function
 * @param rowArray
 * @param Row
 * @param Col
 * @param sheetIdx
 * @return
 */
function getCOM_ENS_0N1(rowArray, Row, Col, sheetIdx){
	sheetObjects[sheetIdx].CellValue(Row, Col) = rowArray[0][3];
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBCREATE:
		//Carrier Combo Item Setting
		UF_addComboItem(comboObjects[0], vJoCarrier.split("|"));
		comboObjects[0].InsertItem(0 , "ALL"," ");
		comboObjects[0].Text = "ALL";

		//Trade Combo Item Setting
		//UF_addComboItem(comboObjects[1], vJoTrade.split("|"));
		comboObjects[1].DeleteItem(""); 
		comboObjects[1].InsertItem(0 , "ALL"," ");
		comboObjects[1].Text = "ALL";

		//Lane Combo Item Setting
		UF_addComboItem(comboObjects[2], vJoLane.split("|"));
		comboObjects[2].InsertItem(0 , "ALL"," ");
		comboObjects[2].Text = "ALL";

		//Rev exp Combo Item Setting
		UF_addComboItem(comboObjects[3], vRedivrcd.split("|"));
		comboObjects[3].InsertItem(0 , "ALL"," ");
		comboObjects[3].Text = "ALL";

		//Del Combo Item Setting Start
    	UF_addComboItem(comboObjects[5], vDeltflg.split("|"));
    	comboObjects[5].InsertItem(0 , "ALL"," ");
		comboObjects[5].Index2 = 2;

		//Settle Flag Combo Item Setting Start
    	UF_addComboItem(comboObjects[4], vStlflg.split("|"));
    	comboObjects[4].InsertItem(0 , "ALL"," ");
		comboObjects[4].Text = "ALL";

		//sheetObj.WaitImageVisible = false;
		//Container Type/Size Combo Item Setting Start
		//formObj.f_cmd.value = SEARCH02;
		//var sXml = sheetObj.GetSearchXml("FNS_JOO_COMGS.do", FormQueryString(formObj));
        //sheetObj.WaitImageVisible = true;

        break;
        
	case IBSEARCH: //조회

		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = SEARCH01;			
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0096GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			sheetObj.LoadSearchXml(arrXml[0]);
		}
		break;

	case IBSAVE: //저장
		if (validateForm(sheetObj, formObj, sAction)){
			var SaveStr = ComGetSaveString(sheetObjects);
			
			if (SaveStr == ""){
				ComShowCodeMessage('JOO00036');
				return;
			}
			
			if (!ComShowCodeConfirm('JOO00046')){
				return;
			}
			
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0096GS.do", SaveStr + "&" + FormQueryString(formObj));
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;

	// VVD 9자리 변경시
	case IBROWSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)){
			//formObj.f_cmd.value = SEARCHLIST08;
			formObj.f_cmd.value = SEARCH27;
			formObj.code.value  = "";
			formObj.super_cd1.value = gVVD;
			formObj.super_cd2.value = "";

			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
			
			if (ComGetEtcData(sXml,"RESULT") == "E"){
				//ComShowMessage(ComGetEtcData(sXml,"VVDMSG"));
				ComShowCodeMessage("JOO00031");
				sheetObj.CellValue2(curRow,"vvd_cd") = "";
				//sheetObj.SelectCell(curRow,"vsl_cd",true);
			}

		}
		break;
	case IBSEARCH_ASYNC09: //Port Code 변경시 VSK_VSL_PORT_SKD 테이블에서 LOC_CD 조회
		formObj.f_cmd.value = SEARCH27;
		sheetObj.WaitImageVisible = false;
		formObj.super_cd1.value = gVVD;

		if (sheetObj.ColSaveName(sheetObj.SelectCol) == "leg_tport"){
			formObj.super_cd2.value = sheetObj.CellValue(curRow, "leg_tport");
		}else if(sheetObj.ColSaveName(sheetObj.SelectCol) == "leg_fport") {
			formObj.super_cd2.value = sheetObj.CellValue(curRow, "leg_fport");			
		}
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

		if (ComGetEtcData(sXml,"RESULT") == "E"){
			ComShowCodeMessage("JOO00200");
			if (sheetObj.ColSaveName(sheetObj.SelectCol) == "leg_tport"){
				sheetObj.CellValue2(curRow,"leg_tport") = "";
			}else if(sheetObj.ColSaveName(sheetObj.SelectCol) == "leg_fport") {
				sheetObj.CellValue2(curRow,"leg_fport") = "";
			}
		}
		break;
	case IBSEARCH_ASYNC10://pic user nm 조회
		formObj.f_cmd.value = SEARCH29;
		sheetObj.WaitImageVisible = false;
		formObj.super_cd1.value = gPicUsrId;
		
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

		if (ComGetEtcData(sXml,"RESULT") == "E"){
			ComShowCodeMessage("JOO00136","'PIC ID'");
			sheetObj.CellValue2(curRow,"pic_usr_id") = "";
			sheetObj.CellValue2(curRow,"pic_usr_nm") = "";
		}else{
			sheetObj.CellValue2(curRow,"pic_usr_nm") = ComGetEtcData(sXml,"NAME");
		}
	}
}


function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

	for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){		
		
		if (sheetObj.CellValue(i, "delt_flg") == "Y"){
			sheetObj.RowEditable(i) = false;
		}else{
			sheetObj.RowEditable(i) = true;
		}

		if(sheetObj.CellValue(i, "vvd_cd").length == 9){
			sheetObj.CellEditable(i,"leg_fport") = true;			
			sheetObj.CellEditable(i,"leg_tport") = true;
		}else{
			sheetObj.CellEditable(i,"leg_fport") = false;			
			sheetObj.CellEditable(i,"leg_tport") = false;
		}
	}	// end for
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSAVE:   //저장
			for(var inx=2; inx<=sheetObj.LastRow; inx++){
				var rowStatus = sheetObj.RowStatus(inx);
				//수정되지 않은 값은 skip
				if (rowStatus=="R"){
					continue;
				}
				
				//del_chk 체크만 한 경우를 방지하기 위함 
//				if ((rowStatus == "I" || rowStatus == "U") && sheetObj.CellValue(inx,"del_chk") == "1"){
//					ComShowCodeMessage("JOO00079");
//					sheetObj.SelectCell(inx,"del_chk",true);
//					return false;
//				}
				if ((rowStatus == "I" || rowStatus == "U") && sheetObj.CellValue(inx,"del_chk") != "1"){
					continue;
				}
				
				
				//수정되지 않은 값은 skip
				if (rowStatus=="D"){
					continue;
				}

				if (sheetObj.CellValue(inx,"rev_divr").length < 1){
					ComShowCodeMessage('JOO00184');
					sheetObj.SelectCell(inx,"rev_divr",true);
					return false;
				}

				if (sheetObj.CellValue(inx,"acctg_crr_cd").length < 3){
					ComShowCodeMessage('JOO00008');
					sheetObj.SelectCell(inx,"acctg_crr_cd",true);
					return false;
				}

				if (sheetObj.CellValue(inx,"trd_cd").length < 3){
					ComShowCodeMessage('JOO00047',inx);
					sheetObj.SelectCell(inx,"trd_cd",true);
					return false;
				}

				if (sheetObj.CellValue(inx,"rlane_cd").length < 5){
					ComShowCodeMessage('JOO00048',inx);
					sheetObj.SelectCell(inx,"rlane_cd",true);
					return false;
				}

				if(sheetObj.CellValue(inx, "leg_fport").length > 0 && sheetObj.CellValue(inx, "leg_fport").length < 5){
					ComShowCodeMessage('JOO00136', "Port");
					sheetObj.SelectCell(inx,"leg_fport",true);
					return false;					
				}
					
				if(sheetObj.CellValue(inx, "leg_tport").length > 0 && sheetObj.CellValue(inx, "leg_tport").length < 5){
					ComShowCodeMessage('JOO00136', "Port");
					sheetObj.SelectCell(inx,"leg_tport",true);
					return false;					
				}
					
				var vslCd = sheetObj.CellValue(inx,"vvd_cd").substring(0,4); 
				var voyNo = sheetObj.CellValue(inx,"vvd_cd").substring(4,8);  
				var dirCd = sheetObj.CellValue(inx,"vvd_cd").substring(8);
				
				//하나라도 입력되었다면 full로 입력할 것
				if ((vslCd.length > 0) || (voyNo.length > 0) || (dirCd.length > 0)){
					if (vslCd.legnth < 4){
						ComShowCodeMessage('JOO00040',inx);
						sheetObj.CellValue2(inx,"vvd_cd") = "";
						sheetObj.SelectCell(inx,"vvd_cd",true);
						return false;
					}

					if (voyNo.legnth < 4){
						ComShowCodeMessage('JOO00041',inx);
						sheetObj.CellValue2(inx,"vvd_cd") = "";
						sheetObj.SelectCell(inx,"vvd_cd",true);
						return false;
					}
					
					if (dirCd.legnth < 1){
						ComShowCodeMessage('JOO00042',inx);
						sheetObj.CellValue2(inx,"vvd_cd") = "";
						sheetObj.SelectCell(inx,"vvd_cd",true);
						return false;
					}
				}
			}
			break;

		default:
			break;
	}
	return true;
}

/**
 * COPY ROW 기능 추가(201408 민정호)
 */
function UF_copyRow(){	
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	
	var arrs = sheetObj.GetSelectionRows(",");
	var rows = arrs.split(",");
		
	for (var i = rows.length-1; i >= 0; i--){		
		var row = sheetObj.DataCopy();		
		if(row != -1){
			sheetObj.CellValue2(row, "vvd_cd") = "";
			sheetObj.CellValue2(row, "leg_fport") = "";		
			sheetObj.CellValue2(row, "leg_tport") = "";
			sheetObj.CellValue2(row, "jo_bsa") = "";		
			sheetObj.CellValue2(row, "jo_weight") = "";
			sheetObj.CellValue2(row, "jo_price") = "";		
			sheetObj.CellValue2(row, "jo_remark") = "";
			sheetObj.CellValue2(row, "settle_dt") = "";		
			sheetObj.CellValue2(row, "ous_qty") = "";
			sheetObj.CellValue2(row, "attach_flg") = "";		
			sheetObj.CellValue2(row, "atch_file_id") = "";
			sheetObj.CellValue2(row, "delt_flg") = "N";		
			sheetObj.CellValue2(row, "agmt_seq") = "";
		}		
	}
}
/* 개발자 작업  끝 */