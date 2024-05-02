/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1017.js
 *@FileTitle : ESM_BKG-1017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.23
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
 * 1.0 Creation
 * 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
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
 * @class ESM_BKG-1017 : ESM_BKG-1017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1017() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

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
			case "btn_new":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
			 
			case "btn_Close":
				window.close();
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		 var formObj = document.form;
 		for(i=0;i<sheetObjects.length;i++){
	        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
 		//initSheetData(sheetObjects[0], formObj);
 		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form); 
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
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

	    var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
			
			case "sheet1":
					with (sheetObj) {

						// 높이 설정
						style.height = 302;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 3, 100);
						
						//var HeadTitle1 = "| |Harmonized Tariff Code|Description|Category";
						var HeadTitle1 = "| |vsl_call_ref_no|vvd_number|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|dem_free_dt|brth_ctnt|ntfy_ltr_ctnt|cre_usr_id|cre_dt|vps_eta_dt|vvd_number|user_ofc_cd";
						var headCount = ComCountHeadTitle(HeadTitle1);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0,		cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");						
						CountPosition = 0;

				}
				break;

		}
	}
	 /**
	  * 
	  * @return
	  */
	 function obj_KeyUp() {
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");		
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		if (srcName == "bl_no" && ComIsKorean(formObject.bl_no.value)) 
		{							 
			formObject.bl_no.focus();			 
		}
	 }
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {  
		switch(sAction) {
		
		case IBSAVE:  
			 
			formObj.f_cmd.value = MULTI;	
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DataInsert(-1);			 
			sheetObj.CellValue2(1, "ibflag") = "I";		
			// Add. 2015.04.20
			formObj.vsl_cd.value = formObj.vvd_number.value.substring(0,4);
			formObj.skd_voy_no.value = formObj.vvd_number.value.substring(4,8);
			formObj.skd_dir_cd.value = formObj.vvd_number.value.substring(8);
			
			sheetObj.DoSave("ESM_BKG_1017GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			window.close();
			break;
		}
	}