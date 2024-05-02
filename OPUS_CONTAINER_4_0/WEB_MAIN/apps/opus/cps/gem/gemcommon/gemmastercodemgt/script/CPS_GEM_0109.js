/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0109.js
 *@FileTitle : Office code history
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.15
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.05.15 최정미
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
 * @author CLT
 */

/**
 * @extends
 * @class Expense Matrix per Office : Expense Matrix per Office 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0109(){
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initControl = initControl;
	this.validateForm = validateForm;
	
	// add
	this.obj_keypress = obj_keypress;
	this.obj_deactivate = obj_deactivate;
	this.obj_activate = obj_activate;
	
	this.initProperty = initProperty;
	
	// sheet
	this.sheet1_OnClick = sheet1_OnClick;	
}

/* 개발자 작업 */

//===================================================================================
//공통전역변수
//===================================================================================
var sheetObjects = new Array();
var sheetCnt = 0;

var sheet1 = null;

var frm = null;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

//===================================================================================
//초기화 
//===================================================================================
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	frm = document.form;
	sheet1 = sheetObjects[0];
	sheetCnt = sheetObjects.length ;
	
	for(i=0;i<sheetCnt;i++){
		
		//khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
	}

    //sheetObjects[0].ExtendLastCol = false;

    // html컨트롤 이벤트초기화
    initControl();
    
    // 초기Data조회
	doActionIBSheet(IBSEARCH);		
}

/**
* 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
* 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 300;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 15, 100);

			var HeadTitle1 = "SEQ|Used|Used|Used|Used|Change|Change|Change|Change";
			var HeadTitle2 = "SEQ|OFC Code|Center Code|Effective Date|Expire Date|OFC Code|Center Code|ibFlag|Key1";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			
			InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,		true,		"Sel");	
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"ofc_cd",		false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"ctr_cd", 		false,		"",			dfNone);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"eff_dt",		false,		"",			dfDateYmd);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		"exp_dt",		true,		"",			dfDateYmd);
			
			InitDataProperty(0, cnt++ , dtData, 		100, 	daCenter, 		true, 		"bfr_ofc_cd", 	true, 		"", 		dfNone, 	0, true, true, 6, false, true, "", true);
			InitDataProperty(0, cnt++ , dtData, 		100, 	daCenter, 		true, 		"bfr_ctr_cd", 	false, 		"", 		dfNone, 	4, true, true, 6, false, true, "", true);

			InitDataProperty(0, cnt++ , dtHiddenStatus, 100, 	daCenter, 		true, 		"ibflag");
			InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,		true,		"ofc_his_seq",	false,		"",			dfNone);
			
			InitDataValid(0, "bfr_ofc_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, "bfr_ctr_cd", vtNumericOnly);
		}
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sAction){
	//sheetObj.ShowDebugMsg = false;
	//alert("sAction : "+sAction);
	switch (sAction) {		
		
		case IBSEARCH: // 조회
			if(validateForm(sAction)) {
				frm.f_cmd.value = SEARCH;
	  			var sXml = sheet1.GetSearchXml("CPS_GEM_0109GS.do", FormQueryString(frm));
	  			var arrXml = sXml.split("|$$|");
	  			var sheet1TotalCnt = ComGetTotalRows(arrXml[0]);
	  			if (ComGetTotalRows(arrXml[0]) > 0) {
	  				sheet1.LoadSearchXml(arrXml[0]);
	  				sheet1.SelectCell(parseInt(sheet1TotalCnt)+1, "exp_dt");
	  				
	  				// 검색된 데이터의 값을 체크해서 속성값을 Edittable시킴
	      			initProperty(sAction);	      			
	  			}
			}
     	   	break;
     	   	
		case IBSAVE: // 저장
			if(validateForm(sAction)) {
				// 저장하시겠습니까?
				if(!ComCodeMsgBySave()) return;
				
				frm.f_cmd.value = MULTI;    			
				var sXml = sheet1.DoSave("CPS_GEM_0109GS.do", FormQueryString(frm), -1, false);
				if(sXml) doActionIBSheet(IBSEARCH);
    			/*
				var sParam = FormQueryString(frm);
				var sParam1 = sheet1.GetSaveString(); 
				
				if (sheet1.IsDataModified && sParam1 == "") {				
					return; 
				} 	
				sParam = sParam + "&" + sParam1;
				
    			var sXml = sheet1.GetSaveXml("CPS_GEM_0109GS.do", sParam);
    			sheet1.LoadSearchXml(sXml);
    			*/
			}
			break;
	}
}

//===================================================================================
//Form 이벤트 처리
//===================================================================================
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
 	DATE_SEPARATOR = "/";
 	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',	form); //- 포커스 나갈때
	axon_event.addListenerForm('beforeactivate',	'obj_activate',		form); //- 포커스 들어갈때
	//axon_event.addListenerForm('keypress',			'obj_keypress',		form); //- 키 눌렸을때
	//axon_event.addListenerForm('keyup',				'obj_keyup',		form); //- 키 올라올때
	//axon_event.addListener('change',   'obj_change',  'agmt_seq'); //- 변경될때.
}

/**
* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
**/
function obj_keypress(){
	switch (event.srcElement.name) {    
	    case "bfr_ofc_cd":
	    	//ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 **/
function obj_deactivate(){
	switch(event.srcElement.name){
		case "":
			break;
	}
}

/**
* HTML Control Foucs in
*/
function obj_activate(){
   ComClearSeparator(event.srcElement);
}

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	//var sheetObject = sheetObjects[0];
	
	/** **************************************************** */
	//var formObject = document.form;
	
	try	{
		var srcName = window.event.srcElement.getAttribute("name");
		//alert("srcName : "+srcName);
		switch (srcName) {
			case "btn_RowAdd":
				if (!ComChkValid(frm)) return false;
				
				if(sheet1.RowCount == 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return false;
				}
				
				// Row Add시 Validation Check
				if(!validateForm(IBSAVE)) return;				
				
				// Row Add시 속성값 초기화하기
				var row = sheet1.DataInsert(-1);
				var bRow = parseInt(row) - 1;
				
				sheet1.CellValue2(row,"ofc_his_seq") = parseInt(sheet1.CellValue(bRow,"ofc_his_seq")) + 1;
				sheet1.CellValue2(row,"ofc_cd") = sheet1.CellValue(bRow,"ofc_cd");
				sheet1.CellValue2(row,"ctr_cd") = sheet1.CellValue(bRow,"ctr_cd");
				sheet1.CellValue2(row,"eff_dt") = sheet1.CellValue(bRow,"eff_dt");
				
				// 검색된 데이터의 값을 체크해서 속성값을 Edittable시킴
      			initProperty(IBSEARCH);
      			
      			sheet1.SelectCell(row,"exp_dt",true);
				
                break;
			case "btn_Save":
				if(sheet1.RowCount == 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return false;
				}
				doActionIBSheet(IBSAVE);
				break;
			case "btn_Close":
				
				if (sheet1.IsDataModified) {
					if(!ComShowCodeConfirm('GEM01057')) return;					
				}
				
				self.close();
				break;
			
		} // end switch
	}
	catch (e){
		if (e == "[object Error]"){
			// 지금은 사용하실 수가 없습니다.
			ComCodeMsgByNoUsed();
		}
	}
}

//===================================================================================
//Private function
//===================================================================================
/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sAction){
	if (!ComChkValid(frm)) return false;
	
	if(sAction == IBSAVE) {
		for(var row=2; row<=sheet1.LastRow; row++) {
			if(sheet1.CellValue(row,"exp_dt") == "") {
				ComShowCodeMessage("GEM00003","Expire Date");
				sheet1.SelectCell(row, "exp_dt");
				return false;
			}
			if(sheet1.CellValue(row,"bfr_ofc_cd") == "") {
				ComShowCodeMessage("GEM00003","OFC Code");
				sheet1.SelectCell(row, "bfr_ofc_cd");
				return false;
			}
			/*
			if(sheet1.CellValue(row,"bfr_ctr_cd") == "") {
				ComShowCodeMessage("GEM00003","Used Center Code");
				sheet1.SelectCell(row, "bfr_ctr_cd");
				return false;
			}
			*/
		}
	}
	return true;
}

/**
* 검색된 데이터의 값을 체크해서 속성값을 Edittable시킴
* @return
*/
function initProperty(sAction) {
	switch (sAction) {
		case IBSEARCH: //조회
			// 1.Ofc_cd, Ctr_cd, Eff_dt는 Editable = false; 
			// 2.Exp_dt, Bfr_ofc_cd, Bfr_ctr_cd값이 존재하는 경우 Editable = false;
			// 3.Exp_dt, Bfr_ofc_cd, Bfr_ctr_cd값이 존재하지 않는 경우 Editable = true;
			// 4.신규 RowAdd시 Editable = true;
		
			for(var row=2; row<=sheet1.LastRow; row++) {
				sheet1.CellEditable(row, "ofc_his_seq") = false;
				sheet1.CellEditable(row, "ofc_cd") = false;
				sheet1.CellEditable(row, "ctr_cd") = false;
				sheet1.CellEditable(row, "eff_dt") = false;
				sheet1.CellEditable(row, "bfr_ctr_cd") = false;
				
				// exp_dt
				if(sheet1.CellValue(row,"exp_dt") == "") {
					sheet1.CellEditable(row, "exp_dt") = true;
				}
				else{
					sheet1.CellEditable(row, "exp_dt") = false;
				}
				
				// used bfr_ofc_cd
				if(sheet1.CellValue(row,"bfr_ofc_cd") == "") {
					sheet1.CellEditable(row, "bfr_ofc_cd") = true;
				}
				else{
					sheet1.CellEditable(row, "bfr_ofc_cd") = false;
				}
				
				// used bfr_ctr_cd
				/*
				if(sheet1.CellValue(row,"bfr_ctr_cd") == "") {
					sheet1.CellEditable(row, "bfr_ctr_cd") = true;
				}
				else{
					sheet1.CellEditable(row, "bfr_ctr_cd") = false;
				}
				*/				
			}
			break;		
	}
}

//===================================================================================
//Sheet 이벤트 처리
//===================================================================================
/**
 * 셀을 클릭했을때 발생하는 이벤트 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	sheetObj의 선택된 Row
 * @param {ibsheet} col     	sheetObj의 선택된 Col
 **/
function sheet1_OnClick(sheetObj, row, col, value) {
	//alert(sheetObj+"=="+row+"=="+col+"=="+value);
}

/**
* 셀의 값이 바뀌었을 때 발생하는 Event
* @param sheetObj
* @param row
* @param col
* @return
*/
function sheet1_OnChange(sheetObj, row, col) {
	switch (sheetObj.ColSaveName(col)) {
		case "exp_dt" :
			if(sheetObj.cellvalue(row,"exp_dt") < sheetObj.cellvalue(row,"eff_dt")) {
				// {?msg1} 데이터가 유효하지 않습니다.
				ComShowCodeMessage("GEM00001","Expire Date");
				
				sheetObj.CellValue2(row,"exp_dt") = "";
				sheetObj.SelectCell(row, "exp_dt");
				return;
			}
			break;
			
		case "bfr_ofc_cd" :	
			// 초기화
			sheetObj.CellValue2(row,"bfr_ctr_cd") = "";
			var errCode = 0; 
				
			var ofc_cd = sheetObj.CellValue(row,"bfr_ofc_cd");
			if(ofc_cd != "") {
				frm.f_cmd.value = SEARCHLIST07;
				var sXml = sheet1.GetSearchXml("CPS_GEM_0007GS.do?ofc_cd=" + ofc_cd, FormQueryString(frm));
				var errCode = ComGetEtcData(sXml, "code");
				//alert("errCode : "+errCode);
				if (errCode != "2") {
					if (errCode == "0") {
						//GEM01015	ENG	W	오피스코드가 존재 하지 않습니다.
						ComShowCodeMessage("GEM01015");
					} else if (errCode == "1") {
						//GEM01016	ENG	W	삭제된 오피스코드 입니다.
						ComShowCodeMessage("GEM01016");	
					}
					sheetObj.CellValue2(row,"bfr_ofc_cd") = "";
					sheetObj.SelectCell(row, "bfr_ofc_cd");
				}
			}
			// 입력OFC_CD가 존재하면 관련 CTR_CD조회
			if (errCode == "2") {
				var ofc_cd = sheetObj.CellValue(row,"bfr_ofc_cd");
				frm.f_cmd.value = SEARCHLIST01;
				var sXml = sheet1.GetSearchXml("CPS_GEM_0109GS.do?ofc_cd=" + ofc_cd, FormQueryString(frm));
				var getCtrCode = ComGetEtcData(sXml, "ctrCode");
				//alert("getCtrCode : "+getCtrCode);
				sheetObj.CellValue2(row,"bfr_ctr_cd") = getCtrCode;
				//sheetObj.SelectCell(row, "bfr_ctr_cd");
			}
			break;
			
	}
}
/* 개발자 작업 끝 */