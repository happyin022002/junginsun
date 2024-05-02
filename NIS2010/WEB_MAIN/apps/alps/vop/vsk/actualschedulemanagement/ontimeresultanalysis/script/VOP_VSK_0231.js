/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0231.js
 *@FileTitle : SKD for Conversion
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.04.11
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.07.13 정명훈
 * 1.0 Creation
 * 
 * History
 * 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
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
 * @class VOP_VSK_0231 : VOP_VSK_0231 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * 2011.04.08 진마리아 DELT_FLG 관련 작업(jsp에 inc_del_vsl)이 필요하지만, CONVERSION 로직 수정이 우선이기 때문에 하지 않음
 */
function VOP_VSK_0231() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/


// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
	
			case "btn_ok":
				comPopupOK();
				break;
	
			case "btn_close":
				window.close();
				break;
	
			case "btns_search":
				doActionIBSheet(sheetObject1, formObject, SEARCH01);
				break; 					


		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK09005');	//Original
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
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

	}
	
	initControl();
	document.form.vsl_cd.focus();

}

/**
 * 이벤트 컨트롤 정의
 */
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
	axon_event.addListenerFormat("keypress", "obj_keypress", form);
	axon_event.addListenerFormat("keyup",    "obj_keyup" ,   form);
}

function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * KEY PRESS 이벤트
 */
function obj_keypress() {
	switch(event.srcElement.dataformat){
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "eng":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
			break;
		case "uppernum":
            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('uppernum');
            break;    	
		default:
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber(event.srcElement);
	}

	switch(event.srcElement.name){
		case "vsl_cd": case "voy_no": case "dir_cd": case "vsl_slan_cd":
			if(event.keyCode==13){
				doSearch();
			}
			break;
	}
	
}

/**
 * 필드 데이타가 CHANGE될 경우 이벤트
 */
function obj_keyup(){

	var formObject = document.form;
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var formObj = document.form;
		var obj = event.srcElement;
		
		switch(srcName) {

			case "vsl_cd":
				if(!obj || obj.value=="" || ComChkLen(obj.value, 4)!=2){
					break;
				}
				if(formObj.tmp_vsl_cd.value != obj.value){
					sheetObj = sheetObjects[0];
					doActionIBSheet(sheetObj, formObj, SEARCH02);
				}
				
				//자릿수가 차면 Focus 이동
				obj_nextfocus(event.srcElement);
				break;
				
			case "voy_no":
				
				//자릿수가 차면 Focus 이동
				obj_nextfocus(event.srcElement);
				break;		    

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
} 	


// 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
function obj_nextfocus(obj) {
	var objMaxLength = obj.getAttribute("maxlength");
	var objValue = obj.getAttribute("value");
	
	if (ComChkLen(objValue, objMaxLength) == 2) {
		ComSetNextFocus(obj);
	}
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
			// 높이 설정
			style.height = 242;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100);

			var HeadTitle = "||Seq.|Port|ETB|ETD|||||||||||||";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false);


			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			var prefix = "sheet1_";	

			//데이터속성    [ROW,  COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE, SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHidden,	20,    	daCenter,  	false,    "radio"		);
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	  "checkbox"	);
			InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	false,	  "seq"			);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	  prefix+"vps_port_cd",		false,	  "",		  dfNone,			0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	false,	  prefix+"vps_etb_dt",		false,	  "",		  dfUserFormat2,	0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	false,	  prefix+"vps_etd_dt",		false,	  "",		  dfUserFormat2,	0,	  false,	  true);
			
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"vsl_cd",			false,	  "",		  dfNone,			0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"pf_etd_dt",		false,	  "",		  dfUserFormat2,	0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"pf_eta_dt",		false,	  "",		  dfUserFormat2,	0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"skd_voy_no",		false,	  "",		  dfNone,			0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"pf_etb_dt",		false,	  "",		  dfUserFormat2,	0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"slan_cd",			false,	  "",		  dfNone,			0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"vps_eta_dt",		false,	  "",		  dfUserFormat2,	0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"skd_dir_cd",		false,	  "",		  dfNone,			0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"skd_cng_sts_cd",	false,	  "",		  dfNone,			0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"init_eta_dt",		false,	  "",		  dfUserFormat2,			0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"init_etb_dt",		false,	  "",		  dfUserFormat2,			0,	  false,	  true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"init_etd_dt",		false,	  "",		  dfUserFormat2,			0,	  false,	  true);
			
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,	  prefix+"clpt_seq",		false,	  "",		  dfNone,			0,	  false,	  true);

			InitUserFormat2(0, prefix+"vps_etb_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"vps_etd_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"pf_etd_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"pf_eta_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"pf_etb_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"vps_eta_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"init_eta_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"init_etb_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, prefix+"init_etd_dt", "####-##-## ##:##", "-|:" );

			MultiSelection = true;
			WaitImageVisible = false;

		}
		break;


	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

		case IBSEARCH:      //조회
			if(validateForm(sheetObj, formObj, sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var prefix = "sheet1_";	//prefix 
				//alert(FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0231GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchXml(sXml);
				
				sheetObj.CheckAll("checkbox") = 0;
				ComOpenWait(false);
			}
		break;
	
		case SEARCH01:		//VVD
			//VSL_CD 미입력시
			if(formObj.vsl_cd.value.length != 4){
				ComOpenPopupWithTarget('/hanjin/VOP_VSK_0219.do', 465, 500 
									   , "vsl_cd:vsl_cd"	//Popup1:Opener1|Popup2:Opener2
									   , "0,0", true);
			} else{
				targetObjList = "sheet1_vsl_slan_cd:vsl_slan_cd|sheet1_vsl_slan_cd:vsl_slan_cd";
				ComOpenPopupWithTarget('/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd='+formObj.vsl_cd.value, 340, 420 
									   , "vsl_cd:vsl_cd|skd_voy_no:voy_no|skd_dir_cd:dir_cd"
									   , "0,0", true);            		
			}
		break;
			
			
		case SEARCH02: // Vessel Code 조회
			//formObj.f_cmd.value = SEARCH;
			ComOpenWait(true);
			formObj.f_cmd.value = COMMAND16;
			var sParam = FormQueryString(formObj);
			sheetObj.WaitImageVisible = false;
			//var sXml = sheetObj.getSearchXml("VSK_GLOGS.do?op_=0219", sParam);
			var sXml = sheetObj.getSearchXml("VSK_GLOGS.do", sParam);
			var vsl_eng_nm = ComGetEtcData(sXml, "vsl_eng_nm");
			ComOpenWait(false);
			if(!vsl_eng_nm){ // undefined
	    		ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
				formObj.tmp_vsl_cd.value = "";
				formObj.vsl_cd.value = "";
				formObj.vsl_cd.focus();
				return false;
	    	}else{
	    		formObj.tmp_vsl_cd.value = formObj.vsl_cd.value;
	    		formObj.voy_no.focus();
	    	}
			
			
			break;
			
	}
}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {

	case IBSEARCH:      //조회

		if(ComIsNull(formObj.vsl_cd.value)){
			ComShowCodeMessage('VSK00027', "Vessel Code");
			formObj.vsl_cd.focus();
			return false;
		}

		if(formObj.voy_no.value.length == 0){
			ComShowCodeMessage('VSK00027', "Voyage No.");
			formObj.voy_no.focus();
			return false;
		}

		if(formObj.dir_cd.value.length == 0){
			ComShowCodeMessage('VSK00027', "Direction Code");
			formObj.dir_cd.focus();
			return false;
		}

		break;

	}

	return true;
}
 
function sheet1_OnLoadFinish(sheetObj) {
	var formObj = document.form;
	//초기 조회
	if(formObj.vsl_cd.value.length == 4
	   && formObj.voy_no.value.length == 4
	   && formObj.dir_cd.value.length == 1){
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}	
} 

/**
 * Sheet1 OnSearchEnd 이벤트 처리
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){

	var rows = sheetObj.SearchRows;
	var prefix = "sheet1_";
	if(rows == 0){
		form.vsl_slan_cd.value = "";
	} else{
		form.vsl_slan_cd.value = sheetObj.CellValue(1, prefix + "slan_cd");
	}
} 

/**
 * Sheet1 OnSelectCell 이벤트 처리
 * @return
 */
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
   /*
	var formObject = document.form;
    if( OldRow != NewRow ){
     	var rows = sheetObj.SearchRows;
    	var prefix = "sheet1_";
    	if(rows == 0){
    		form.vsl_slan_cd.value = "";
    	} else{
    		form.vsl_slan_cd.value = sheetObj.CellValue(sheetObj.SelectRow, prefix + "slan_cd");
    	}    
    }
   */ 
}

/**
 * Enter키 이벤트
 * @param sheetObj
 * @param formObj
 * @return
 */
function doSearch(){
	var formObject = document.form;
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}         


/* 개발자 작업  끝 */