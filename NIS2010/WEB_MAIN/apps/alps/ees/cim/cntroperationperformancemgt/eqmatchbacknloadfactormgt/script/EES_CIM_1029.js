/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1029.js
 *@FileTitle : Cargo Flow Map
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.24
 *@LastModifier : 문중철
 *@LastVersion : 1.0
 * 2009.06.24
 * 1.0 Creation 
 * ======================================================
 * 2010.08.27 남궁진호 Ticket ID :Ticket ID : CHM-201005533-01
 *            조회 조건 추가 (Loc_Loc)에 따른 로직 변경
 * 2011.03.16 남궁진호 [CHM-201109288-01]Location Code 숫자입력가능하게수정
 *                    ComKeyOnlyAlphabet('upper') ->ComKeyOnlyAlphabet('uppernum')
 * 2012.05.11 신자영 [CHM-201217714-01] Cargo Flow Map 로직 수정 - LOC-LOC조건 선택 시 region 에 걸린 제약 제거
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
 * @class ees_cim_1032 : ees_cim_1032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cim_1029() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;	
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;	//2014.11.18 민정호
	this.validateForm = validateForm;
}

/* 개발자 작업  */
// 공통전역변수
//2014.11.18 민정호
var tabObjects = new Array();
var tabCnt = 0 ; 
var beforetab = 1; 
var tabIndex = 0;
var beforetabForClick = 0;				 //사용 되지 않음.

var sheetObjects = new Array();
var sheetCnt = 0;

var oldCntrTypeSize = "";
var sCntrTypeSize = "";
var isOpen = false;
var tabIndexSheet1 = 0;		//2014.11.18 민정호

//var tabFlag = 0;				//사용하는 곳이 없음(2014.11.18 민정호)

var comboObjects = new Array();
var comboCnt = 0;

var isSearch = 0;				//사용하는데 의미 없음(2014.11.18 민정호)

// XTC 날짜입력이벤트 컨트롤 
var enterSwitch = false;

//2014.11.18 민정호
//t1sheet1을 다이나믹하게 사용하기 위한
var t1sheet1Stats = true;	

//2014.11.18 민정호
//이미지 경로
var imageUrl1 = "http://" + location.hostname + ":" + location.port;
imageUrl1 = imageUrl1 + "/hanjin/apps/alps/ees/cim/cntroperationperformancemgt/eqmatchbacknloadfactormgt/image/EES_CIM_1061_01.gif";
												
var imageUrl2 = "http://" + location.hostname + ":" + location.port;
imageUrl2 = imageUrl2 + "/hanjin/apps/alps/ees/cim/cntroperationperformancemgt/eqmatchbacknloadfactormgt/image/EES_CIM_1061_02.gif";
		
//2014.11.18 민정호
//Period 가 변경여부 확인 하기 위해 세팅
var currT2sheet1weekList = "";	


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var shtCnt = 0;
	var t1sheet1 = sheetObjects[shtCnt++];
	var t1sheet2 = sheetObjects[shtCnt++];
	var t2sheet1 = sheetObjects[shtCnt++];		//2014.11.08 민정호	
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Retrieve":
			isSearch = 1;
			//2014.11.19 민정호						
			if(tabIndex == 0){		// Summary		
				if (tabIndexSheet1 == 0) {
					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
					sheetObjects[0].SelectRow = 0;
				}else{ //Loc_Loc 조회
					doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
					sheetObjects[1].SelectRow = 0;
				}
			}else{	// Trend
				doActionIBSheet(sheetObjects[2], formObject, IBSEARCH);
				sheetObjects[2].SelectRow = 0;				
			}
			break;

		case "btn_new":
			var xVar = document.getElementById("directionWise").value;
			t1sheet1.RemoveAll();
			t1sheet2.RemoveAll();
			t2sheet1.RemoveAll();		//2014.11.18 민정호	
			formObject.reset();
			document.form.rdtype.disabled = true;
			document.getElementById("froms").focus();
			
			ComClearCombo(document.form.endloc);			
			ComAddComboItem(document.form.endloc, "RCC", "R");
			ComAddComboItem(document.form.endloc, "LCC", "L");
			ComAddComboItem(document.form.endloc, "ECC", "E");
			ComAddComboItem(document.form.endloc, "SCC", "S");
			ComAddComboItem(document.form.endloc, "Country", "C");
			ComAddComboItem(document.form.endloc, "POD", "P");
			document.getElementById("directionWise").value =xVar;
			
			
			break;
			
		case "btn_downexcel":
			var tVal01 = document.getElementById("directionWise").value;
			
			if(tabIndex == 0){	//2014.11.18 민정호
				if (tVal01 =="L"){
					t1sheet2.SpeedDown2Excel(-1);
				}else{
					t1sheet1.SpeedDown2Excel(-1);
				}
			}else{
				t2sheet1.SpeedDown2Excel(-1);				
			}	
						
			break;
		case "btn_floc_cd":
        	var display 	  = "0,1,1,1,1,1";
        	var targetObjList = "loc_cd:locationf2|loc_dpth_cd:startloc|chkDepth:startloc";
			var param 		  = "?depth=4&classId=COM_ENS_0O1";
			
			ComOpenPopup('/hanjin/COM_ENS_0O1.do' + param, 400, 470,  'getStartLoc', display,true,false);	//2014.11.18 민정호
			break;
      	case "btn_tloc_cd":
    		var display 	  = "0,1,1,1,1,1";
    		var targetObjList = "loc_cd:locationt2|loc_dpth_cd:endloc";
		    var param 		  = "?depth=4&classId=COM_ENS_0O1";
		    
		    ComOpenPopup('/hanjin/COM_ENS_0O1.do' + param, 400, 470,  'getEndLoc', display,true,false);		//2014.11.18 민정호
			break;
			
		case "btn_detail":    		
			if(form.tp_sz_loc.value == 'Total' ||
					form.tp_sz_loc.value == 'From' ||
					form.tp_sz_loc.value == 'To'							
					){
				return;
			}
			
			if(form.from_loc.value == '' || form.to_loc.value == ''){
				return;
			}			
			
    		var sUrl = "/hanjin/EES_CIM_1030.do?pgmNo=EES_CIM_1030";
    		ComOpenWindowCenter(sUrl, "EES_CIM_1030", 900, 400, false);
			break;								
			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		} // end if
	} // end try
}

//2014.11.18 민정호-주석, alert제거
//startloc PopUp 셋팅
function getStartLoc(rArray){
	var locLvl ="";
	var locVal ="";
	
	for ( i = 0; i < rArray.length; i++) {
		var aArray = rArray[i];			
		locLvl = aArray[3];			
		if (i+1 == rArray.length){
			locVal = locVal+aArray[4];
		}else{
			locVal = locVal+aArray[4]+",";
		}
	}	
	 if (locLvl!=""){ //popup에서 받아올경우 로직
	    	document.form.startloc.value = locLvl;
	    	document.form.locationf2.value = locVal;
	    	setSubCombo();
	  }else{
		   document.form.locationf2.value = "";
	  }
}

//endloc PopUp 셋팅
function getEndLoc(rArray){
	var locLvl ="";
	var locVal ="";
	for ( i = 0; i < rArray.length; i++) {
		var aArray = rArray[i];
		locLvl = aArray[3];
		if (i+1 == rArray.length){
			locVal = locVal+aArray[4];
		}else{
			locVal = locVal+aArray[4]+",";
		}
	}
	 if (locLvl!=""){ //popup에서 받아올경우 로직
		 var xVal = document.form.startloc.value;
		  if (xVal =="R" ){
	    	document.form.endloc.value = locLvl;
		  }else if(xVal =="L"){
			if (locLvl!="R")document.form.endloc.value = locLvl;  
		  }else if(xVal =="E"){
				if (locLvl=="E" || locLvl=="S")document.form.endloc.value = locLvl;  
		  }else if(xVal =="S"){
				if (locLvl=="S")document.form.endloc.value = locLvl; 
		  }
	    document.form.locationt2.value = locVal;
	  }else{
		document.form.locationt2.value = "";
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

//2014.11.18 민정호
/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Location by loc_cd 팝업에서 선택한 값 Setting.
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	formObject.locationf1.value = aryPopupData[0][3]
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		setText('R');
	}
	
	//2014.11.18 민정호
	for(var k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k + 1);
    }	
	
	axon_event.addListenerForm('click', 'obj_tpsz_click', document.form);
	axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
	axon_event.addListenerForm('change', 'obj_change', document.form);
	axon_event.addListenerFormat('focus', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListener('blur', 'obj_deactivate', 'froms');
	axon_event.addListener('blur', 'obj_deactivate', 'tos');
	axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener('blur', 'obj_blur', 'locationf1');
	axon_event.addListener('blur', 'obj_blur2', 'country');
	axon_event.addListener('blur', 'obj_blur4', 'country2');
	
	//2014.11.18 민정호	
	//초기화
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);	
}

//2014.11.18 민정호	
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {		
			var cnt = 0;
			InsertTab(cnt++, "Summary", 0);						
			InsertTab(cnt++, "Trend ", -1);					
							
			t1sheet1Stats = true;		
			ImageUrl(0)= imageUrl1; 																
		}
		break;

	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "t1sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 365;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 2, 100);

			//컬럼 가변 처리를 위한 기준 데이터를 배열로 만든다.
			oldCntrTypeSize = ComGetEtcData(document.form.sXml.value, "cntrTypeSize");//sCntrTypeSize;
			var arrTpSz = oldCntrTypeSize.split(",");

			var HeadTitle1 = "From|To|To|To|Total";
			var HeadTitle2 = "RCC |RCC|RCC|RCC|Total";

			var xVal01 = document.form.startloc.value;
			var xVal02 = document.form.directionWise.value;
			var xVal04 = document.form.endloc.value;

			var xHeadTitle01 = "";
			var xHeadTitle02 = "";

			for ( var i = 0; i < arrTpSz.length; i++) {
				HeadTitle1 += "|" + arrTpSz[i];
				HeadTitle2 += "|" + arrTpSz[i];
			}
			var headCount = ComCountHeadTitle(HeadTitle1);
			InitColumnInfo(headCount, 0, 0, true);

			var headCnt = HeadTitle1.split("|").length;
			SheetWidth = headCnt * 70 + 30;
			if (SheetWidth > 975) {
				SheetWidth = 975;
			}

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			FrozenCols = 5;

			var FM = 80;
			var TO = 60;
			var Total = 60;
			var rowCnt = 0;

			cnt = 0;

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                    
			InitDataProperty(rowCnt, cnt++, dtData, FM, daCenterTop, true, "loc_cd", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, TO, daCenterTop, true, "vvd", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, TO, daCenterTop, true, "division", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, TO, daCenter, true, "ibflag", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtAutoSum, Total, daRight, true, "total", false, "", dfNullInteger);
									
			for ( var i = 0; i < arrTpSz.length; i++) {
				arEtcData = "_" + i;
				InitDataProperty(rowCnt, cnt++, dtAutoSum, 60, daRight, true, "qty" + arEtcData, false, "", dfNullInteger);
			}
/*
			rowCnt++;
			cnt = 0;

			InitDataProperty(rowCnt, cnt++, dtData, FM, daCenterTop, true, "loc_cd2", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, TO, daCenterTop, true, "vvd2", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, TO, daCenterTop, true, "division2", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, TO, daCenter, true, "ibflag2", false, "", dfNone);
			InitDataProperty(rowCnt, cnt++, dtData, Total, daRight, true, "total2", false, "", dfNone);

			for ( var i = 0; i < arrTpSz.length; i++) {
				arEtcData = "_" + i;
				InitDataProperty(rowCnt, cnt++, dtData, 60, daRight, true, "qty" + arEtcData, false, "", dfNone);
			}
*/			
			if (xVal02 == "F" && xVal01 == "R" && xVal04 == "R") {
				ColHidden(1) = true;
			} else if (xVal02 == "T" && xVal01 == "R" && xVal05 == "R") {
				ColHidden(1) = true;
			} else {
				ColHidden(1) = false;
			}

			CountPosition = 0;
		
		}
		break;
	case "t1sheet2": //sheet2 init
	with (sheetObj) {

		// 높이 설정		
		style.height = 365;
		//전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		//전체Merge 종류 [선택, Default msNone]
		MergeSheet =  msHeaderOnly;

		//전체Edit 허용 여부 [선택, Default false]
		Editable = false;

		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 2, 100);

		//컬럼 가변 처리를 위한 기준 데이터를 배열로 만든다.
		oldCntrTypeSize = ComGetEtcData(document.form.sXml.value, "cntrTypeSize");
		var arrTpSz = oldCntrTypeSize.split(",");

		var HeadTitle1 = "|From|To|To|Total";
		var HeadTitle2 = "|RCC |RCC|RCC|Total";

		var xVal01 = document.form.startloc.value;
		var xVal02 = document.form.directionWise.value;
		var xVal04 = document.form.endloc.value;
		
		var xHeadTitle01 = "";
		var xHeadTitle02 = "";
		
		for ( var i = 0; i < arrTpSz.length; i++) {
			HeadTitle1 += "|" + arrTpSz[i];
			HeadTitle2 += "|" + arrTpSz[i];
		}
		
		var headCount = ComCountHeadTitle(HeadTitle1);
		InitColumnInfo(headCount, 0, 0, true);

		var headCnt = HeadTitle1.split("|").length;
		SheetWidth = headCnt * 70 + 30;
		if (SheetWidth > 975) {
			SheetWidth = 975;
		}

		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, false, true, false, false)

		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

		FrozenCols = 5;

		var FM = 80;
		var TO = 60;
		var Total = 60;
		var rowCnt = 0;

		cnt = 0;
		
		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                    
		InitDataProperty(rowCnt, cnt++, dtHiddenStatus, TO, daCenter, true, "ibflag", false, "", dfNone);
		InitDataProperty(rowCnt, cnt++, dtData, FM, daCenterTop, true, "loc_cd", false, "", dfNone);
		InitDataProperty(rowCnt, cnt++, dtData, TO, daCenterTop, true, "vvd", false, "", dfNone);
		InitDataProperty(rowCnt, cnt++, dtData, TO, daCenterTop, true, "division", false, "", dfNone);
		InitDataProperty(rowCnt, cnt++, dtData, Total, daRight, true, "total", false, "", dfNullInteger);

		for ( var i = 0; i < arrTpSz.length; i++) {
			arEtcData = "_" + i;
			InitDataProperty(rowCnt, cnt++, dtData, 60, daRight, true, "qty" + arEtcData, false, "", dfNullInteger);
		}
		
		CountPosition = 0;
	}
	break;
//============================================================================
// 2014.11.18 민정호
	case "t2sheet1": //sheet1 init
		with (sheetObj) {		
		// 높이 설정
		style.height = 365;		
		var formObj = document.form;						
		var HeadTitle1 = "|From|To|TP/SZ|Total|Bnd";
		var HeadTitle2 = "|RCC |RCC|TP/SZ|Total|Bnd";
				 		
		var weekList = form.week_list.value;  
											
		var currWeekList = weekList.split(",");	
		if(weekList == ""){	
			currWeekList.length = 0;	
		}	
		
		for ( var i = 0; i < currWeekList.length; i++) {
			HeadTitle1 += "|" + "ALL";
			HeadTitle2 += "|" + currWeekList[i];	
		}						
				
		//전체 너비 설정						 	 	
		var size =	280 + 20 + (parseInt(currWeekList.length) * 60);		
		if (size > 975) {														
			SheetWidth = 975;											
		} else {			
			SheetWidth = size;
		}			
							  	 						
		//Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
		//전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;			 			
														
		//전체Edit 허용 여부 [선택, Default false]
		Editable = false;				
							
		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 18, 100);									
								
		var headCount = 0;			
		headCount = 6 +  parseInt(currWeekList.length);
		
		//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D] 		
		InitHeadMode(false, true, false, false, false,false);		
					 						 	 				
		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]	
		InitColumnInfo(headCount, 4, 0, true); 		
								
		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]			
        InitHeadRow(0, HeadTitle1, true);										
        InitHeadRow(1, HeadTitle2, true); 
																						
		FrozenCols = 5;

		var FM = 80;
		var TO = 60;
		var tpsz = 60;
		var Bnd = 20;		
		var Total = 60;
		var rowCnt = 0;

		cnt = 0;
		
		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                    
		InitDataProperty(rowCnt, cnt++, dtHiddenStatus, TO, daCenter, true, "ibflag", false, "", dfNone);
		InitDataProperty(rowCnt, cnt++, dtData, FM, daCenterTop, true, "loc_cd", false, "", dfNone);
		InitDataProperty(rowCnt, cnt++, dtData, TO, daCenterTop, true, "vvd", false, "", dfNone);		
		InitDataProperty(rowCnt, cnt++, dtData, tpsz, daCenterTop, true, "tp_sz", false, "", dfNone);		
		InitDataProperty(rowCnt, cnt++, dtData, Total, daRight, true, "total", false, "", dfNullInteger);
		InitDataProperty(rowCnt, cnt++, dtHidden, Bnd, daCenterTop, true, "division", false, "", dfNone);
		for ( var i = 0; i < currWeekList.length; i++) {
			arEtcData = "_" + i;
			InitDataProperty(rowCnt, cnt++, dtData, TO, daRight, true, "qty" + arEtcData, false, "", dfNullInteger);
		}		
		
		MultiSelection = false;     
		SelectionMode = smSelectionRow;    
		SelectHighLight = false;												
		CountPosition = 0;										
		}
		break;	
//============================================================================
// 2014.11.18 민정호		
	case "sheet1": 	
	    with (sheetObj) {
	        //Host정보 설정[필수][HostIp, Port, PagePath]
	        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		} 	
		break;				
//============================================================================		
  }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	var xVal01 = document.getElementById("startloc").value;
	var xVal02 = document.getElementById("endloc").value;
	
	document.form.inquiryWise1.value = xVal01;
	document.form.inquiryWise2.value = xVal02;
	
	switch (sAction) {
	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)) {
			
			currT2sheet1weekList = form.week_list.value;	//2014.11.20 민정호
			
			var tVal01 = document.getElementById("directionWise").value;
			var tVal02 = document.getElementById("startloc").value;
			var tVal03 = document.getElementById("locationf1").value;
			var tVal04 = document.getElementById("locationf2").value;
			var tVal05 = document.getElementById("locationt2").value;
			var tVal06 = document.getElementById("country").value;
			var tVal07 = document.getElementById("country2").value;
			//2012.05.10 end location 사용 추가
			var tVal08 = document.getElementById("endloc").value;
			
			//initSheet(sheetObj);
			if (tVal01 == "F" && tVal02 == "R" && tVal08 == "R") {
				sheetObj.ColHidden(1) = true;
			} else if (tVal01 == "T" && tVal02 == "R" && tVal08 == "R") {
				sheetObj.ColHidden(1) = true;
			} else {
				sheetObj.ColHidden(1) = false;
			}
			if (tVal01=="L"){  //새로 추가된 Loc-Loc 조건             
				// 2012.05.10 condition control LOC-LOC인 경우 개별 제어
				// From 이 Country 조건이면 첫번 째 입력된 country 를 가져와서 setting
				if (tVal02 == "C" && tVal08 != "C") {
					document.getElementById("location").value = ComTrimAll(tVal06," ",".");
					document.getElementById("location2").value = ComTrimAll(tVal05," ",".");
					//document.getElementById("location2").value = ComTrimAll(tVal07," ",".");
				} else if (tVal02 != "C" && tVal08 == "C" ) {
					// To 가 country 이면 두번 째 입력된 country 를 가져와서 setting
					document.getElementById("location").value = ComTrimAll(tVal04," ",".");
					//document.getElementById("location2").value = ComTrimAll(tVal05," ",".");
					document.getElementById("location2").value = ComTrimAll(tVal07," ",".");
				} else if (tVal02 == "C" && tVal08 == "C"){
					document.getElementById("location").value = ComTrimAll(tVal06," ",".");
					document.getElementById("location2").value = ComTrimAll(tVal07," ",".");
				} else {
					document.getElementById("location").value = ComTrimAll(tVal04," ",".");
					document.getElementById("location2").value = ComTrimAll(tVal05," ",".");
				}
			}else{
				if (tVal02 == "C") {
					document.getElementById("location").value = ComTrimAll(tVal06," ",".");
				} else {
					document.getElementById("location").value = ComTrimAll(tVal03," ",".");
				}
			}
			
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			
			//2014.11.18 민정호
			var sXml = "";
			if(tabIndex == 0){		// Summary
				formObj.f_cmd.value = SEARCH;
				sXml = sheetObj.GetSearchXml("EES_CIM_1029GS.do", FormQueryString(formObj));				
			}else{						// Trend
				formObj.f_cmd.value = SEARCH01;				
				sXml = sheetObj.GetSearchXml("EES_CIM_1029GS.do", FormQueryString(formObj));				
			}			
			sheetObj.LoadSearchXml(sXml);			
					
			sheetObj.WaitImageVisible = true;
			ComOpenWait(false);
			
			//2014.11.18 민정호
			if(tabIndex == 0){			
				setText2(sheetObj);
				if (tabIndexSheet1 ==0){
					tr_from_to.style.display = "";
					tr_loc_loc.style.display = "none";
				}else{
					tr_from_to.style.display = "none";
					tr_loc_loc.style.display = "";
				}
			}else{				
				setText2Trend(sheetObj);
			}
		}
		break;

	case IBSEARCH_ASYNC01: //open 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH01;
			var sXml = "";
			if (sheetObj.id == "t1sheet1" || sheetObj.id=="t1sheet2" ) {
				sXml = formObj.sXml.value;
			}
			sCntrTypeSize = ComGetEtcData(sXml, "cntrTypeSize");
			
			//서버에서 가져온 "가변컬럼정보"만 읽어오기
			if ((oldCntrTypeSize != sCntrTypeSize) && (sheetObj.id == "t1sheet1" || sheetObj.id=="t1sheet2")) {
				oldCntrTypeSize = sCntrTypeSize;
				sheetObj.Reset();
				initSheet(sheetObj);
			}

		} // end if
		break;

	case IBSEARCH_ASYNC02: //location focusOut
		if (document.getElementById("locationf1").value != "")
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH02;
				document.form.inquiryLevel.value = document.getElementById("startloc").value;
				document.form.location.value = document.getElementById("locationf1").value;
				if (formObj.location.value == "") {
					return true;
				}
				if (formObj.inquiryLevel.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do", FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");

				if (sCheck != "OK") {
					var xLocationBy = document.getElementById("startloc").value;
					if (document.form.locationf1.value != "") {
						if (xLocationBy == "R") {
							ComShowCodeMessage("CIM29031");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "L") {
							ComShowCodeMessage("CIM29032");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "E") {
							ComShowCodeMessage("CIM29033");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "Y") {
							ComShowCodeMessage("CIM29036");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "P") {
							ComShowCodeMessage("CIM29035");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "S") {
							ComShowCodeMessage("CIM29034");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						}
					} else {
						document.form.soc.focus();
						return true;
					} // end if (document.form.location.value != "") {

				} else {
					document.form.soc.focus();
					return true;
				} // end if (sCheck != "OK") {
			} else {
				//document.form.soc.focus();
				return;
			} // end if (validateForm(sheetObj, formObj, sAction)) {
		sheetObj.WaitImageVisible = true;
		break;

	case IBSEARCH_ASYNC03: //country focusOut
		if (document.getElementById("country").value != "")
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH02;
				document.form.inquiryLevel.value = document.getElementById("startloc").value;
				document.form.location.value = document.getElementById("country").value;
				if (formObj.location.value == "") {
					return true;
				}
				if (formObj.inquiryLevel.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do", FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");

				if (sCheck != "OK") {
					var xLocationBy = document.getElementById("startloc").value;
					if (document.form.country.value != "") {
						if (xLocationBy == "R") {
							ComShowCodeMessage("CIM29031");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "L") {
							ComShowCodeMessage("CIM29032");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "E") {
							ComShowCodeMessage("CIM29033");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "Y") {
							ComShowCodeMessage("CIM29036");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "P") {
							ComShowCodeMessage("CIM29035");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "S") {
							ComShowCodeMessage("CIM29034");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "C") {
							ComShowCodeMessage("CIM29037");
							document.form.country.value = "";
							ComSetFocus(document.form.country);
							return false;
						}
					} else {
						document.form.soc.focus();
						return true;
					} // end if (document.form.location.value != "") {

				} else {
					document.form.soc.focus();
					return true;
				} // end if (sCheck != "OK") {
			} else {
				//document.form.soc.focus();
				return;
			} // end if (validateForm(sheetObj, formObj, sAction)) {
		sheetObj.WaitImageVisible = true;
		break;
	case IBSEARCH_ASYNC04: //country2 focusOut
		if (document.getElementById("country2").value != "")
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH02;
				document.form.inquiryLevel.value = document.getElementById("startloc").value;
				document.form.location.value = document.getElementById("country2").value;
				if (formObj.location.value == "") {
					return true;
				}
				if (formObj.inquiryLevel.value == "") {
					return false;
				}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_CIM_1001GS.do", FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");

				if (sCheck != "OK") {
					var xLocationBy = document.getElementById("startloc").value;
					if (document.form.country.value != "") {
						if (xLocationBy == "R") {
							ComShowCodeMessage("CIM29031");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "L") {
							ComShowCodeMessage("CIM29032");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "E") {
							ComShowCodeMessage("CIM29033");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "Y") {
							ComShowCodeMessage("CIM29036");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "P") {
							ComShowCodeMessage("CIM29035");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "S") {
							ComShowCodeMessage("CIM29034");
							document.form.locationf1.value = "";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "C") {
							ComShowCodeMessage("CIM29037");
							document.form.country.value = "";
							ComSetFocus(document.form.country);
							return false;
						}
					} else {
						document.form.soc.focus();
						return true;
					} // end if (document.form.location.value != "") {

				} else {
					document.form.soc.focus();
					return true;
				} // end if (sCheck != "OK") {
			} else {
				//document.form.soc.focus();
				return;
			} // end if (validateForm(sheetObj, formObj, sAction)) {
		sheetObj.WaitImageVisible = true;
		break;	

  //2014.11.18 민정호		
	case IBSEARCH_ASYNC05: //기간 변화에 따른 시트 변형
		formObj.f_cmd.value = COMMAND01;
		formObj.from_dt.value = formObj.fromz.value;
		formObj.to_dt.value = formObj.toz.value;
		var sXml = sheetObj.GetSearchXml("EES_CIM_10611GS.do", FormQueryString(formObj));
		var weekStr = ComGetEtcData(sXml, "PERIOD_LIST");
		formObj.week_list.value = weekStr;													
		break;	
	
	case IBDOWNEXCEL: //엑셀 다운로드
		sheetObj.WaitImageVisible = true;
		sheetObj.Down2Excel(-1, false, false, true);
		break;
		
		
	case IBCLEAR: //초기화	
		var formObj = document.form;
						
		formObj.reset();	
		
		//탭초기화
		tabObjects[0].SelectedIndex = 0;	
		tabObjects[0].ImageUrl(0)= imageUrl1;
		t1sheet1Stats = true;
		beforetabForClick = 0;  
															
		//btn_new 클릭과 동일
		var xVar = document.getElementById("directionWise").value;
		document.form.rdtype.disabled = true;
		document.getElementById("froms").focus();
		
		ComClearCombo(document.form.endloc);			
		ComAddComboItem(document.form.endloc, "RCC", "R");
		ComAddComboItem(document.form.endloc, "LCC", "L");
		ComAddComboItem(document.form.endloc, "ECC", "E");
		ComAddComboItem(document.form.endloc, "SCC", "S");
		ComAddComboItem(document.form.endloc, "Country", "C");
		ComAddComboItem(document.form.endloc, "POD", "P");
		document.getElementById("directionWise").value =xVar;		
		
		
		break;							
	} // end switch	
}

function obj_activate() {
	ComClearSeparator(event.srcElement);
	ComSetFocus(event.srcElement);
}

function lastDay(y, m) {
	var d, d2, s = "";
	d = new Date();
	d2 = new Date(y, m, "");
	s = d2.getDate();
	return (s);
}

function obj_keypress() {
	switch (event.srcElement.name) {
	case "locationf1":
		if (document.form.inquiryLevel.value == "Y") {
			ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
		} else {
			ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자만 입력허용
		}
		break;	
	case "country":
		if (document.form.inquiryLevel.value == "Y") {
			ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
		} else {
			ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
		}
		break;
	case "country2":
		if (document.form.inquiryLevel.value == "Y") {
			ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
		} else {
			ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
		}
		break;
	case "froms":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "tos":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	}
}

function form_keyup() {
	var obj = null;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}
}

function form_keyup2() {
	var obj = null;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}
}

function chkToDateWeekBlur() {
	var period = document.form.period.value;
	var toDate = document.form.tos.value;
	var frDate = document.form.froms.value;

	var toYearDate = toDate.substring(0, 4);
	var frYearDate = frDate.substring(0, 4);
	var toMonthDate = toDate.substring(5, 7);
	var frMonthDate = frDate.substring(5, 7);
	var frDayDate = "";
	var toDayDate = "";

	if (frDate.length > 7) {
		frDayDate = frDate.substring(8, 10);
		toDayDate = toDate.substring(8, 10);

	} else {
		frDayDate = "01";
		toDayDate = lastDay(toYearDate, toMonthDate);
	}

	var frDateFull = new Date(frYearDate, frMonthDate - 1, frDayDate);
	var toDateFull = new Date(toYearDate, toMonthDate - 1, toDayDate);
	var getDiffTime = toDateFull.getTime() - frDateFull.getTime();
	var retDate = Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
	var retMonth = ((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
	var retWeek = Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
	var week = "";
	var fromTo = 52;
	if (period == "M") {
		if (retMonth >= 12) {
			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "W") {
		if (frYearDate == toYearDate) {
			week = eval(toMonthDate) - eval(frMonthDate) + 1;
		} else {
			betwMonth = fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { //1년 차이일때
				week = betwMonth;
			} else {
				week = (eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}
		}

		if (week > 26) {
			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "D") {
		if (retDate >= 31) {
			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM29029");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	}
}

function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}

function obj_blur2() {
	var tVal01 = document.getElementById("directionWise").value;
	if (tVal01!="L")
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
}
//country to 입력시 체크
function obj_blur4() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
}

function setDate() {
	var today = new Date();
	var y = today.getFullYear().toString();
	var m = (today.getMonth() + 1).toString();
	if (m.length == 1) {
		m = 0 + m;
	}
	var ym = y + '-' + m;
	document.form.froms.value = ym;
	document.form.tos.value = ym;
	var day = lastDay(y, m);
	document.form.fromz.value = y + m + "01";
	document.form.toz.value = y + m + day;
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {	
	var f = document.getElementById("froms");
	var t = document.getElementById("tos");
	sVal1 = f.value.replace(/\/|\-|\./g, "");
	sVal2 = t.value.replace(/\/|\-|\./g, "");

	switch (event.srcElement.name) {
	case "froms":
		if (ComChkObjValid(event.srcElement, false)) {

			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1 != "" && sVal2 != "") {
					var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
					var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						enterSwitch = false;
						t.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("fromz").value = sVal1 + "01";
					document.getElementById("toz").value = sVal2 + day;
				}

			} else { // 주별로 조회
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						ComShowCodeMessage("CIM29003");
						enterSwitch = false;
						t.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("fromz").value = sVal1;
					document.getElementById("toz").value = sVal2;
				}
			}

		} else {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {

					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch = false;
					event.srcElement.focus();
					event.srcElement.select();
					return false;
				}
			} else { // 주별로 조회

				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					event.srcElement.focus();
					event.srcElement.select();
					enterSwitch = false;

					return false;
				}
			}
		}

		break;
	case "tos":
		if (ComChkObjValid(event.srcElement, false)) {

			if (t.getAttribute("dataformat") == "ym") {

				var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));

				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29004");
						}
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
				}

				document.getElementById("fromz").value = sVal1 + "01";
				document.getElementById("toz").value = sVal2 + day;
			} else { // 주별로 조회
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29003");
						}
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("fromz").value = sVal1;
				document.getElementById("toz").value = sVal2;
			}
			enterSwitch = true;
		} else {
			if (t.getAttribute("dataformat") == "ym") {
				if (sVal2.length > 0 && !ComIsMonth(sVal2.substring(4, 6))) {
					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					t.focus();
					t.select();
					return false;
				}
			} else { // 주별로 조회

				if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					t.focus();
					t.select();
					return false;
				}
			}
		}

		break;
	}
	
	//2014.11.18 민정호
	//===================================================================
	//주차 변환
	if(event.srcElement.name == "froms" || event.srcElement.name == "tos"){
		doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC05);		
		if(document.form.froms.value != "" && document.form.tos.value != ""){											
			if(tabIndex == 1){				
				sheetObjects[2].Reset();		
				initSheet(sheetObjects[2],3);	
			}													
		}								 														
	}			
	//===================================================================		
	
	return true;
}

function obj_change() {
	obj = event.srcElement;
	if (obj.name == "period") {
		if (obj.value == "M") {
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.fromz.value = "";
			document.form.toz.value = "";
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.fromz.value = "";
			document.form.toz.value = "";
		}
		document.getElementById("froms").focus();
	}
	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction != IBSEARCH_ASYNC01) {
			if (period.value == "M") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(tos);
					return false;
				}
			} else if (period.value == "W") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(tos);
					return false;
				}
			}

			if (froms.value.length < 6) {
				return false;
			} else if (tos.value.length < 6) {
				return false;
			}
			if (!enterSwitch) {
				return false;
			}
		}
	} // end of with
	return true;
}

function setDataGridText(caseVal, val01, val02) {
	if (caseVal == "S") {
		if (val01 == "R") {
			return "RCC ";
		} else if (val01 == "L") {
			return "LCC ";
		} else if (val01 == "E") {
			return "ECC ";
		} else if (val01 == "S") {
			return "SCC ";
		} else if (val01 == "C") {
			return "Country ";
		} else if (val01 == "P") {
			return "Port ";
		}
	} else if (caseVal == "M") {
		if (val01 == "R") {
			return " ";
		} else if (val01 == "L") {
			return " RCC";
		} else if (val01 == "E") {
			return " LCC";
		} else if (val01 == "S") {
			return " ECC";
		} else if (val01 == "C") {
			return " RCC";
		} else if (val01 == "P") {
			return " RCC";
		}
	} else {
		if (val01 == "R") {
			return "RCC";
		} else if (val01 == "L") {
			return "LCC";
		} else if (val01 == "E") {
			return "ECC";
		} else if (val01 == "S") {
			return "SCC";
		} else if (val01 == "C") {
			return "Country";
		} else if (val01 == "P") {
			return "Port";
		}
	}
}

function setDataGridText2(caseVal, val) {
	if (caseVal == "S") {
		if (val == "F" || val == "L") {
			return "From";
		} else{
			return "To";
		}
	} else {
		if (val == "F" || val == "L") {
			return "To";
		} else {
			return "From";
		}
	}
}

function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
}

function setFromToCombo(obj, no){
	ComClearCombo(obj);
	ComAddComboItem(obj, "RCC", "R");
	ComAddComboItem(obj, "LCC", "L");
	ComAddComboItem(obj, "ECC", "E");
	ComAddComboItem(obj, "SCC", "S");
	ComAddComboItem(obj, "Country", "C");
	if(no==1)
		ComAddComboItem(obj, "POL", "P");
	else if(no==2)
		ComAddComboItem(obj, "POD", "P");
}


function setText(rcvVal) {

	var xVal01 = document.form.startloc.value;
	var xVal02 = document.form.directionWise.value;
	var ft = document.getElementById("ff");
	var ld = document.getElementById("tt");

	if (xVal02 == "F") {
		ft.innerText = "From";
		ld.innerText = "To";
		if (rcvVal == "R") {
			setFromToCombo(document.form.endloc, 2);
		
			div_loc.style.display = "";
			div_loc2.style.display = "none";
			div_loc3.style.display = "none";
			div_cnty.style.display = "none";
			div_cnty2.style.display = "none";
			
			document.form.locationf1.value = "";
			document.form.locationf2.value = "";
			document.form.country.value = "";
			document.form.locationt2.value = "";
			document.form.country2.value = "";
			document.form.locationf1.focus();
		}

		setFromToCombo(document.form.startloc, 1);
		
		tabIndexSheet1 = 0;
		document.form.startloc.value = rcvVal;

	} else if(xVal02 == "T") {
		ft.innerText = "To";
		ld.innerText = "From";
		if (rcvVal == "R") {
			setFromToCombo(document.form.endloc, 2);
			
			div_loc.style.display = "";
			div_loc2.style.display = "none";
			div_loc3.style.display = "none";
			div_cnty.style.display = "none";
			div_cnty2.style.display = "none";
			
			document.form.locationf1.value = "";
			document.form.locationf2.value = "";
			document.form.country.value = "";
			
			document.form.locationt2.value = "";
			document.form.country2.value = "";
			
			document.form.locationf1.focus();
		}

		setFromToCombo(document.form.startloc, 1);
		
		tabIndexSheet1 = 0;
		document.form.startloc.value = rcvVal;

	}else{
		ft.innerText = "From";
		ld.innerText = "To";
		if (rcvVal == "R") {
			setFromToCombo(document.form.endloc, 2);
			
			div_loc.style.display = "none";
			div_loc2.style.display = "";
			div_loc3.style.display = "";
			div_cnty.style.display = "none";
			div_cnty2.style.display = "none";
			
			document.form.locationf1.value = "";
			document.form.locationf2.value = "";
			document.form.country.value = "";
			
			document.form.locationt2.value = "";
			document.form.country2.value = "";
			
			document.form.locationf2.focus();
		}

		setFromToCombo(document.form.startloc, 1);
		tabIndexSheet1 = 1;
		document.form.startloc.value = rcvVal;

	}
}

function setText2(sheetObj) {

	var xVal01 = document.form.startloc.value;
	var xVal02 = document.form.directionWise.value;
	var xVal03 = document.form.endloc.value;
	var ft = document.getElementById("ff");
	var ld = document.getElementById("tt");
	if (xVal02 == "L"){ //Loc_Loc 일때 
		if (xVal01 == "R") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);		
		} else if (xVal01 == "L") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "E") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "S") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "C") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "P") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		}
		
	}else{
		if (xVal02 == "F"  && xVal01 == "R") {
			sheetObj.CellValue2(0, 0) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 1) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 0) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("M", xVal03, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal02 == "T" && xVal01 == "R") {
			sheetObj.CellValue2(0, 0) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 1) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 0) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("M", xVal03, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "L") {
			sheetObj.CellValue2(0, 0) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 1) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 0) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("M", xVal03, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "E") {
			sheetObj.CellValue2(0, 0) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 1) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 0) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("M", xVal03, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "S") {
			sheetObj.CellValue2(0, 0) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 1) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 0) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("M", xVal03, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "C") {
			sheetObj.CellValue2(0, 0) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 1) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 0) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("M", xVal03, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "P") {
			sheetObj.CellValue2(0, 0) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 1) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(0, 3) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 0) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("M", xVal03, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
			sheetObj.CellValue2(1, 3) = setDataGridText("E", xVal03, xVal02);
		}
	}
}


/*
 * Trend탭에서 그리드 Header 세팅 
 */
function setText2Trend(sheetObj) {

	var xVal01 = document.form.startloc.value;
	var xVal02 = document.form.directionWise.value;
	var xVal03 = document.form.endloc.value;
	var ft = document.getElementById("ff");
	var ld = document.getElementById("tt");
	if (xVal02 == "L"){ //Loc_Loc 일때 
		if (xVal01 == "R") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);		
		} else if (xVal01 == "L") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "E") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);		
		} else if (xVal01 == "S") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "C") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
		} else if (xVal01 == "P") {
			sheetObj.CellValue2(0, 1) = setDataGridText2("S", xVal02);
			sheetObj.CellValue2(0, 2) = setDataGridText2("E", xVal02);
			sheetObj.CellValue2(1, 1) = setDataGridText("S", xVal01, xVal02);
			sheetObj.CellValue2(1, 2) = setDataGridText("E", xVal03, xVal02);
		}
		
		var weekList = form.week_list.value;  		
		var currWeekList = weekList.split(",");	
		var tpszVal = "";
		var tpszTxt = "";		

		tpszVal = ComGetObjValue(form.tpsz);
		
		if(tpszVal == "A"){		
			tpszTxt = "All";
		}else if(tpszVal == "D"){
			tpszTxt = "DRY";				
		}else if(tpszVal == "S"){
			tpszTxt = "SPCL";				
		}else if(tpszVal == "R"){
			tpszTxt = "Reefer";				
		}
		
		for(var i=0; i<currWeekList.length; i++){					
			sheetObj.CellValue2(0, 6+i) = tpszTxt;
		}
	}	
}	

function setSubCombo() {

	var xVal01 = document.form.startloc.value;
	var xVal02 = document.form.directionWise.value;
    if (xVal02 == "L"){
    	ComClearCombo(document.form.endloc);
    	ComAddComboItem(document.form.endloc, "RCC", "R");
    	ComAddComboItem(document.form.endloc, "LCC", "L");
    	ComAddComboItem(document.form.endloc, "ECC", "E");
    	ComAddComboItem(document.form.endloc, "SCC", "S");
    	ComAddComboItem(document.form.endloc, "Country", "C");
    	ComAddComboItem(document.form.endloc, "POD", "P");
    	if(xVal01 != "C"){
    		document.form.country.value = "";
    		setTextBox("L2");
    	} else {
    		setTextBox("L3")			
    	}
		   	
    	document.form.locationt2.value = "";
    	document.form.country2.value = "";
	
    } else if (xVal01 == "R" && xVal02 == "F") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "RCC", "R");
		ComAddComboItem(document.form.endloc, "LCC", "L");
		ComAddComboItem(document.form.endloc, "ECC", "E");
		ComAddComboItem(document.form.endloc, "SCC", "S");
		ComAddComboItem(document.form.endloc, "Country", "C");
		ComAddComboItem(document.form.endloc, "POD", "P");
		setTextBox("L");
		document.form.country.value = "";
		document.form.country2.value = "";
	} else if (xVal01 == "R" && xVal02 == "T") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "RCC", "R");
		ComAddComboItem(document.form.endloc, "LCC", "L");
		ComAddComboItem(document.form.endloc, "ECC", "E");
		ComAddComboItem(document.form.endloc, "SCC", "S");
		ComAddComboItem(document.form.endloc, "Country", "C");
		ComAddComboItem(document.form.endloc, "POL", "P");
		setTextBox("L");
		document.form.country.value = "";
		document.form.country2.value = "";
	} else if (xVal01 == "L") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "LCC", "L");
		ComAddComboItem(document.form.endloc, "ECC", "E");
		ComAddComboItem(document.form.endloc, "SCC", "S");
		if (xVal02=="L"){
			setTextBox("L2");
		}else{
			setTextBox("L");
		}
		document.form.country.value = "";
		document.form.country2.value = "";
	} else if (xVal01 == "E") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "ECC", "E");
		ComAddComboItem(document.form.endloc, "SCC", "S");
		if (xVal02=="L"){
			setTextBox("L2");
		}else{
			setTextBox("L");
		}
		document.form.country.value = "";
		document.form.country2.value = "";
	} else if (xVal01 == "S") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "SCC", "S");
		if (xVal02=="L"){
			setTextBox("L2");
		}else{
			setTextBox("L");
		}
		document.form.country.value = "";
		document.form.country2.value = "";
	} else if (xVal01 == "C") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "Country", "C");
		if (xVal02=="L"){
			setTextBox("C2");
		}else{
			setTextBox("C");
		}
		document.form.locationf1.value = "";
		document.form.locationf2.value = "";
		document.form.locationt2.value = "";
	} else if (xVal01 == "P" && xVal02 == "F") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "POD", "P");
		if (xVal02=="L"){
			setTextBox("L2");
		}else{
			setTextBox("L");
		}
		document.form.country.value = "";
		document.form.country2.value = "";
	} else if (xVal01 == "P" && xVal02 == "T") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "POL", "P");
		setTextBox("L");
		document.form.country.value = "";
		document.form.country2.value = "";
	}
}

function setTextBox(xVal01) {
	if (xVal01 == "L") {
		div_loc.style.display = "";
		div_loc2.style.display = "none";
		div_loc3.style.display = "none";
		div_cnty.style.display = "none";
		div_cnty2.style.display = "none";
		document.form.locationf1.focus();
	}  else if (xVal01 == "L2") {
		div_loc.style.display = "none";
		div_loc2.style.display = "";
		//div_loc3.style.display = "";
		div_cnty.style.display = "none";
		//div_cnty2.style.display = "none";
		document.form.locationf2.focus();
	}  else if (xVal01 == "L3") {
		div_loc.style.display = "none";
		div_loc2.style.display = "none";
		//div_loc3.style.display = "";
		div_cnty.style.display = "";
		//div_cnty2.style.display = "none";
		document.form.country.focus();
	}  else if (xVal01 == "C") {
		div_loc.style.display = "none";
		div_loc2.style.display = "none";
		div_loc3.style.display = "none";
		div_cnty.style.display = "";
		document.form.country.focus();
	}else if (xVal01 == "C2") {
		div_loc.style.display = "none";
		div_loc2.style.display = "none";
		div_loc3.style.display = "none";
		div_cnty.style.display = "";
		div_cnty2.style.display = "";
		document.form.country.focus();
	}
}

function rdTypeSel(type) {
	if (type == "R") {
		document.form.rdtype.disabled = false;
	} else {
		document.form.rdtype.disabled = true;
		document.form.rdtype.value = "I";
	}
}

function t1sheet1_OnLoadFinish(sheetObj) {
	//sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	document.getElementById("froms").focus();
	//sheetObj.WaitImageVisible = true;

}

function t1sheet2_OnLoadFinish(sheetObj) {
	//sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
	document.getElementById("froms").focus();
	//sheetObj.WaitImageVisible = true;

}

function setEndLoc() {
	var xVal01 = document.form.startloc.value;
	var xVal02 = document.form.directionWise.value;
	var xVal03 = document.form.endloc.value;
   
	if (xVal03 == "C" && xVal02 == "L") {
		div_loc3.style.display = "none";
		document.form.locationt2.value = "";
		div_cnty2.style.display = "";		
	} else {
		div_loc3.style.display = "";
		div_cnty2.style.display = "none";
		document.form.country2.value = "";
	}
}

//2014.11.18 민정호
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {	
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab = nItem;	
	tabIndex = nItem;	
}	

//2014.11.18 민정호
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnClick(tabObj, nItem) {	   
	var formObj = document.form;
	
	if (nItem == 0) {									// Summary		
		form.directionWise.disabled = false;		
		ComBtnEnable("btn_detail");
	} else if (nItem == 1) {						// Trend		
		form.directionWise.value = 'L';		// Direction Wise Loc-Loc
		setText('R');
		form.directionWise.disabled = true;
				
		if(currT2sheet1weekList != form.week_list.value){
			sheetObjects[2].Reset();		
			initSheet(sheetObjects[2],3);				
		}						
		ComBtnDisable("btn_detail");		
	}		
				
	beforetabForClick = nItem;
		
	//2014.11.18 민정호
	//===================================================================
	//주차 변환
		doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC05);				
		if(document.form.froms.value != "" && document.form.tos.value != ""){
			if(tabIndex == 1){				
				sheetObjects[2].Reset();		
				initSheet(sheetObjects[2],3);	
			}													
		}								 																	
	//===================================================================		
		
}

function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {	
		for ( var x = 0; x < LastRow; x++) {
			if (CellValue(x, 'division') == 1) {
				RowBackColor(x) = RgbColor(153, 204, 255);
			}
		}		
	}
}

/**
 * OnDblClick 이벤트 발생시 호출되는 function <br>
 * Cargo Flow Map Detail 화면 호출<br>
 *  
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @return 없음
 */  	
function t1sheet2_OnDblClick(sheetObject, row, col) {
	form.tp_sz_loc.value =	sheetObject.CellValue(0,col);
	form.from_loc.value =	sheetObject.CellValue(row,1);
	form.to_loc.value =	sheetObject.CellValue(row,2);		
	
	// Summary 일 경우 활성화, Trend 비활성화
	if(beforetabForClick == "1"){
		return;
	}
	
	if(form.tp_sz_loc.value == 'Total' ||
			form.tp_sz_loc.value == 'From' ||
			form.tp_sz_loc.value == 'To'							
			){
		return;
	}
	
	if(form.from_loc.value == '' || form.to_loc.value == ''){
		return;
	}
	
	var sUrl = "/hanjin/EES_CIM_1030.do?pgmNo=EES_CIM_1030";
	ComOpenWindowCenter(sUrl, "EES_CIM_1030", 900, 400, false);		
}

/**
 * 시트를 클릭했을 때 처리
 */
function t1sheet2_OnClick(sheetObject, row, col) {
	form.tp_sz_loc.value =	sheetObject.CellValue(0,col);
	form.from_loc.value =	sheetObject.CellValue(row,1);
	form.to_loc.value =	sheetObject.CellValue(row,2);		
}

/**
 * OnDblClick 이벤트 발생시 호출되는 function <br>
 * Cargo Flow Map Detail 화면 호출<br>
 *  
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @return 없음
 */  	
function t1sheet1_OnDblClick(sheetObject, row, col) {
	if(form.directionWise.value == 'F'){
		form.tp_sz_loc.value =	sheetObject.CellValue(0,col);
		form.from_loc.value =	sheetObject.CellValue(row,0);
		form.to_loc.value =	sheetObject.CellValue(row,2);		
	}else if(form.directionWise.value == 'T'){
		form.tp_sz_loc.value =	sheetObject.CellValue(0,col);
		form.from_loc.value =	sheetObject.CellValue(row,2);
		form.to_loc.value =	sheetObject.CellValue(row,0);		
	}	
	
	// Summary 일 경우 활성화, Trend 비활성화
	if(beforetabForClick == "1"){
		return;
	}
	
	if(form.tp_sz_loc.value == 'Total' ||
			form.tp_sz_loc.value == 'From' ||
			form.tp_sz_loc.value == 'To'							
			){
		return;
	}
/*
	alert("form.directionWise.value = "+form.directionWise.value +"\n"+
			"form.tp_sz_loc.value = "+form.tp_sz_loc.value +"\n"+
			"form.from_loc.value = "+form.from_loc.value +"\n"+
			"form.to_loc.value = "+form.to_loc.value			
			);
*/	
	if(form.from_loc.value == '' || form.to_loc.value == ''){
		return;
	}
	
	var sUrl = "/hanjin/EES_CIM_1030.do?pgmNo=EES_CIM_1030";
	ComOpenWindowCenter(sUrl, "EES_CIM_1030", 900, 400, false);		
}


/**
 * 시트를 클릭했을 때 처리
 */
function t1sheet1_OnClick(sheetObject, row, col) {	
	if(form.directionWise.value == 'F'){
		form.tp_sz_loc.value =	sheetObject.CellValue(0,col);
		form.from_loc.value =	sheetObject.CellValue(row,0);
		form.to_loc.value =	sheetObject.CellValue(row,2);		
	}else if(form.directionWise.value == 'T'){
		form.tp_sz_loc.value =	sheetObject.CellValue(0,col);
		form.from_loc.value =	sheetObject.CellValue(row,2);
		form.to_loc.value =	sheetObject.CellValue(row,0);		
	}		
/*	
	alert("form.directionWise.value = "+form.directionWise.value +"\n"+
			"form.tp_sz_loc.value = "+form.tp_sz_loc.value +"\n"+
			"form.from_loc.value = "+form.from_loc.value +"\n"+
			"form.to_loc.value = "+form.to_loc.value			
			);
*/			
}