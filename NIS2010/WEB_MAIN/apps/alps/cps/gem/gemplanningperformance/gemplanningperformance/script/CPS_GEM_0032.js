/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0032.js
 *@FileTitle : Expense Code Maintenance for subsidiary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.09
 *@LastModifier : 이준범
 *@LastVersion : 1.0
 * 2012.04.09 이준범
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2012.05.09 이준범 {CHM-201217605-01] GEM - Excel Upload 기능에서 I/F Error data 삭제 기능 개발
 * 1) 지역본부 Upload 시 산하 조직 모두 가능토록 구현  2) 논리적으로 삭제 처리 되던 전표(승인 전)에 대하여  물리적으로 삭제 처리
 * 2012.05.29 이준범 [CHM-201218022-01] GEM/ Slip 중복 발생 방지 기능 및 Uploading 결과값 Pop-up 기능 추가 요청
 * 1) 로컬 회계시스템에서 생성된 전표 번호 뒤에 Office code와 Effective date를 자동으로 생성  2)전표 번호의 Slip Uploading시 Excel의 대상 건수와 실제 저장된 건수, Error로 처리된 건수를 저장 결과값으로 Pop-up 메시지 처리
 * 2012.07.18 이준범 [CHM-201219088-01] 현지법인 실적 Excel upload 기능 보완
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
 * @class Expense Matrix per Office : Expense Matrix per Office 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0032(){
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initControl = initControl;
	this.validateForm = validateForm;
	
	// add
	this.setComboObject = setComboObject;
	this.initCombo = initCombo;
	this.obj_keypress = obj_keypress;
	this.obj_deactivate = obj_deactivate;
	this.obj_activate = obj_activate;
	
	this.initProperty = initProperty;
	this.newButtonClear = newButtonClear;
	this.isSumupGubun = isSumupGubun;
	this.isDeltFlg = isDeltFlg;
	
	// sheet
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnMouseMove = sheet1_OnMouseMove;
	this.combo1_OnChange = combo1_OnChange;
}

/* 개발자 작업 */

//===================================================================================
//공통전역변수
//===================================================================================
var sheetObjects = new Array();
var frm = null;
var sheet1 = null;
var sheetCnt = 0;
var authFlg = null;

//IBMultiCombo
var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

/**
* IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
* 상단에 정의
*/
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
**/
function setComboObject(combo_obj){
  comboObjects[comboCnt++] = combo_obj;
}

//===================================================================================
//초기화 
//===================================================================================
/**
* Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
* 추가한다
*/
function loadPage() {
	frm      = document.form;
	sheet1   = sheetObjects[0];
	sheetCnt = sheetObjects.length ;
	authFlg  = frm.auth_flg.value;
	
	for(i=0;i<sheetCnt;i++) {		
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

}

/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {

	case "sheet1":
		with (sheetObj) {
            // 높이 설정
            style.height = 420;

            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet =  msNone;
            //MergeSheet =  msNone;
            //MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 18, 100);
            
            var HeadTitle1 = null;
            
            if ( authFlg == "YNYY") {
            	HeadTitle1 = "||No|SLIP NO|SEQ|Office|CUR|CTR|EFF DT|ACCT|SLIP AMT|SLIP DESC|SLP_IF_FLG";
            } else {
            	HeadTitle1 = "|No|SLIP NO|SEQ|Office|CUR|CTR|EFF DT|ACCT|SLIP AMT|SLIP DESC|SLP_IF_FLG";
            }
            
            var headCount  = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 5, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
			 //InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
			if ( authFlg == "YNYY") {
				InitDataProperty(0, cnt++ , dtCheckBox,  	20,     daCenter,  false,    	"delChk",         		false,      "",         dfNone,         0, true,  true);
			}
			InitDataProperty(0, cnt++ , dtSeq,          35,     daCenter,   true,       "seq",                  true,       "",         dfNone,      	0, false, false);
			InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,       "slp_tj_no",			true,		"",			dfNone,			0, false, true,		50);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,		"slp_seq_no",			true,		"",			dfNone,			0, false, true,		4);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"ofc_cd",				true,		"",			dfNone,			0, true,  true,		6);
			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,		"slp_curr_cd",			true,		"",			dfNone,			0, true,  true,		3);
			InitDataProperty(0, cnt++ , dtData,		    70,		daCenter,	true,		"slp_ctr_cd",  			true,		"",			dfNone,			0, true,  true,		6);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"gl_eff_dt",			true,		"",			dfDateYmd,		0, true,  true,		8);
			InitDataProperty(0, cnt++ , dtData,		    70,		daCenter,	true,		"subs_acct_cd",  		true,		"",			dfNone,			0, true,  true,		20);
			InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"slp_amt",				true,		"",			dfFloat,		3, true,  true);
			InitDataProperty(0, cnt++ , dtData,			400,	daLeft,		true,		"slp_desc",				true,		"",			dfNone,			0, true,  true,		500);
			InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		"slp_if_flg",			true,		"",			dfNone,			0, false, false);

		}
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sAction){
	switch (sAction) {
		
		case IBSEARCH:      //Open

			frm.f_cmd.value = SEARCH;
			var sXml = sheet1.GetSearchXml("CPS_GEM_0004GS.do", FormQueryString(frm));

			var arrXml = sXml.split("|$$|");
			var authFlg  = frm.auth_flg.value ;

			// 로그인 사용자 오피스 정보
			if (arrXml.length > 1) {

				var list = ComXml2ListMap(arrXml[1]);

				if(list.length > 0){
					var officeHierarchyVO  = list[0];
					var level1   = officeHierarchyVO["level1"];
					var level2   = officeHierarchyVO["level2"];
					var level3   = officeHierarchyVO["level3"];
					var level4   = officeHierarchyVO["level4"];
					var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
					if ("N" == rgnOfcFlg) {
						frm.sls_ofc_div_cd[0].checked = true;
					} else {
						frm.sls_ofc_div_cd[1].checked = true;
					}
					//집행단위.지역그룹
					if ( authFlg == "YNNN" || authFlg == "YYNN" ) {
						ComEnableObject(frm.ofc_lvl1, false);
						ComEnableObject(frm.ofc_lvl2, false);
						ComEnableObject(frm.ofc_lvl3, false);
						if ( authFlg == "YYNN" ) {
							ComEnableObject(frm.ofc_lvl3, true);
						}
						frm.sls_ofc_div_cd[0].disabled=true;
						frm.sls_ofc_div_cd[1].disabled=true;
						//LV1
						ComSetObjValue(frm.ofc_lvl1,level2);					
						//LV2
						selLevelChange('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');			
						ComSetObjValue(frm.ofc_lvl2,level3);					
						//LV3
						selLevelChange('GEM_COMMONGS.do','SEARCHLIST04','sheet1','sls_ofc_div_cd','2','document.form.ofc_lvl');			
						ComSetObjValue(frm.ofc_lvl3,level4);					
										
					//사무국 , BU ,TIC
					} else if ( authFlg == "YNYN" || authFlg == "YNYY" || authFlg == "YYYN") {
						ComEnableObject(frm.ofc_lvl1, true);
						ComEnableObject(frm.ofc_lvl2, true);
						ComEnableObject(frm.ofc_lvl3, true);				
						frm.sls_ofc_div_cd[0].checked = false;
						frm.sls_ofc_div_cd[1].checked = false;
						
					} else {
						ComEnableObject(frm.ofc_lvl1, false);
						ComEnableObject(frm.ofc_lvl2, false);
						ComEnableObject(frm.ofc_lvl3, false);		
						frm.sls_ofc_div_cd[0].disabled=true;
						frm.sls_ofc_div_cd[1].disabled=true;
					}
				}
			}
			break;
			
		case SEARCHLIST: // 조회
			if(validateForm(sAction))
    		{
    			frm.f_cmd.value = SEARCHLIST;    			
    			var sXml = sheet1.GetSearchXml("CPS_GEM_0032GS.do", FormQueryString(frm));
    			var arrXml = sXml.split("|$$|");
	  			if (arrXml.length > 0) {
	  				sheet1.LoadSearchXml(arrXml[0]);
	  			}
   	   		}
   	   		break;

		case IBSAVE: // 저장

			if(validateForm(sAction)) {
				// 저장하시겠습니까?
				if(!ComCodeMsgBySave()) return;
				
				frm.f_cmd.value = MULTI;
				var param  = FormQueryString(frm);
				var sParam = sheet1.GetSaveString();
  				param += "&" + sParam;

  				if (sParam == "") {		
					//msgs["GEM01056"] = "There is no contents to save.";
					//ComShowCodeMessage("GEM01056");
					return false; 
				}

				var sXml = sheet1.GetSaveXml("CPS_GEM_0032GS.do", param);
				
				var slpTjNo  = ComGetEtcData(sXml, "slpTjNo");
				var slpSeqNo = ComGetEtcData(sXml, "slpSeqNo");
				var saveCnt  = ComGetEtcData(sXml, "saveCnt");
				var failCnt  = ComGetEtcData(sXml, "failCnt");
				var totCnt   = eval(saveCnt) + eval(failCnt);

				if(!ComIsNull(slpTjNo)&&!ComIsNull(slpSeqNo)){
					ComShowCodeMessage("GEM01092", slpTjNo + slpSeqNo);
				}else{
					
					if(failCnt > 0) {
						ComShowCodeMessage("GEM01096", failCnt, totCnt, ", pls check.");
					} else {
						ComShowCodeMessage("GEM01096", failCnt, totCnt, ".");
					}
					
					doActionIBSheet(SEARCHLIST);
				}
			}
			break;
			
		case SEARCHLIST20:      // 조회
				
			frm.f_cmd.value = SEARCH;
			
			var sXml = sheet1.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
			
			// LEVEL2 조회
			var comboListData = ComGetEtcData(sXml, "searchBUOfficeList").split("|");
			
			if (typeof comboListData != "undefined" && comboListData != "") {
				
				var ofcLvl = frm.ofc_lvl1;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl, "", "");
				
				for ( var i = 0; i < comboListData.length; i++) {
					ComAddComboItem(ofcLvl, comboListData[i], comboListData[i]);
				}
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
 	//keypress

    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',	form); //- 포커스 나갈때
	axon_event.addListenerForm('beforeactivate',	'obj_activate',		form); //- 포커스 들어갈때
	axon_event.addListenerForm('keypress',			'obj_keypress',		form); //- 키 눌렸을때
}

/**
* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
**/
function obj_keypress(){
	switch (event.srcElement.name) {
	case "":
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

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	try	{
		var srcName = window.event.srcElement.getAttribute("name");
		//alert("srcName : "+srcName);
		switch (srcName) {
	    	case "btn_popup":
	    		var param = "popup=Y";
	   			var url   = "CPS_GEM_0112.do?"+param;
	   			var winName = "CPS_GEM_0112";
	   			
	   			var win = ComOpenWindowCenter(url,winName,1000,500, true);
	   			win.focus();
	   			
				break;
			case "btn_Retrieve":
				doActionIBSheet(SEARCHLIST);
              break;
			case "btn_Save":
				doActionIBSheet(IBSAVE);
				break;
			case "btn_DownExcel":
				if (sheet1.RowCount <= 0 ) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return false;
				}
				sheet1.SpeedDown2Excel(1,false,false,"","",false,false,"Slip Upload",false,"delChk|slp_if_flg","delChk|slp_if_flg");
				break;
				
			case "btn2_Delete":
				if (sheet1.RowCount <= 0) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return;
				}
								
				ComRowHideDelete(sheet1, "delChk");
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
	switch (sAction) {
	case IBSAVE: // 저장	
	 	var rowCnt = sheet1.RowCount;
	    //Closing Date
		var clsDt  = frm.hpln_yr.value + frm.hpln_mon.value;

		for(var i=1 ; i<=rowCnt ; i++) {			
			var plnDt    = sheet1.CellValue(i, "gl_eff_dt").substring(0,6);
			var slpIfFlg = sheet1.CellValue(i, "slp_if_flg");
			
			if ( slpIfFlg == "Y") continue ;
			
			if( plnDt != clsDt ){
				ComShowCodeMessage("GEM01093");
				sheet1.SelectCell(i, "gl_eff_dt");
				return false;
			}
		}
		break;
	}	
	return true;
}
	
/**
 * HO, HQ 체크 박스 설정 
 * @param {value} 선택된 체크 박스구분
 */
 function setHOHQ01(value) {
 	var c1 = frm.sls_ofc_div_cd[0].checked;
 	var c2 = frm.sls_ofc_div_cd[1].checked;	
 	
 	if ( c1 && c2 ) {
 		
 		if (value == "HO") {
		frm.sls_ofc_div_cd[1].checked = false;
	} else if (value == "HQ") {
 			frm.sls_ofc_div_cd[0].checked = false;
 		}
 		isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST03','sheet1','sls_ofc_div_cd','1','document.form.ofc_lvl');
 	}
 	if ( !c1 && !c2 ) {
 		ComSetObjValue(frm.ofc_lvl1,"");
 		ComSetObjValue(frm.ofc_lvl2,"");
 		ComSetObjValue(frm.ofc_lvl3,"");
 	}
 } 

/**
* 셀을 클릭했을때 발생하는 이벤트 <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {ibsheet} row     	sheetObj의 선택된 Row
* @param {ibsheet} col     	sheetObj의 선택된 Col
**/
function sheet1_OnClick(sheetObj, row, col, value) {

	switch (sheetObj.ColSaveName(col)) {
    
	case "slp_desc":
		var slpIfFlg = sheetObj.CellValue(row, "slp_if_flg");
		
		if( slpIfFlg == "N" || slpIfFlg == "") {
			sheetObj.CellEditable(row, col) = false;
	        ComShowMemoPad(sheetObj, row, col, false, 300, 150);
		}else{
			sheetObj.CellEditable(row, col) = false;
	        ComShowMemoPad(sheetObj, row, col, true, 300, 150);
		}
        break;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
	if(sheetObj.RowCount <= 0 )  {
		return;
	}

	for(var row=1 ; row <= sheetObj.RowCount ; row++ ) {
		var slpIfFlg = sheetObj.CellValue(row, "slp_if_flg");
		if( slpIfFlg == "N" ) {
			sheetObj.RowFontColor(row) = sheetObj.RgbColor(255, 0, 0);
			sheetObj.RowEditable(row)  = true;
			sheetObj.CellValue2(row, "ibflag")   = "U";
		} else {
			sheetObj.RowEditable(row)  = false;
		}
	}
}

function sheet1_OnChange(sheetObj, row, col, value) {	

	switch (sheetObj.ColSaveName(col)) {

	case "delChk" :
		
		var slpIfFlg = sheetObj.CellValue(row, "slp_if_flg");
		
		if ( slpIfFlg == "Y") sheetObj.CellValue2(row, col) = 0 ; 
		
		break;
	}
}

function sheet1_OnLoadFinish(sheetObj) {
	// html컨트롤 이벤트초기화
    initControl();

    //오피스 콤보 호출
    doActionIBSheet(SEARCHLIST20);

    // 초기Data조회
	doActionIBSheet(IBSEARCH);
	

	if ( authFlg == "YNYY" ) document.all.target_Delete.style.display = "";
	
	sheet1.LoadExcel(-1, 1, "", -1, -1, "", false);
}

/* 개발자 작업 끝 */