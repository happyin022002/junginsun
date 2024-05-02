/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : esm_bkg_1054_01.js
 *@FileTitle :  POD List of VVD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.05.28
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.05.28 
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
	 * @class esm_bkg_1054_01 : esm_bkg_1054_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function esm_bkg_1054_01() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업	*/
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	
	
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, SEARCH11);
		
//		var vRow = sheetObjects[0].DataInsert(-1);
//		sheetObjects[0].CellValue2(vRow, "pod_cd") = "KRPUS";
//		vRow = sheetObjects[0].DataInsert(-1);
//		sheetObjects[0].CellValue2(vRow, "pod_cd") = "USLGB";
//		
//		pod_list_sheet_OnSearchEnd(sheetObjects[0], "");
	}
	
	/* 개발자 작업 */
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		var formObject = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm  ('keypress', 'obj_Change',formObject);
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
        case "pod_list_sheet":
        	
        	with (sheetObj) {
        	// 높이 설정
        	style.height = 150;
        	// 전체 너비 설정
        	SheetWidth = 100;
        	
        	
        	//Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 3, 100);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            //SortEnable | ColumnMove |AllCheckEnable |UserResize |RowMove |Head3D
            InitHeadMode(false, false, true, true, false,false)

            //var HeadTitle = " |POR|POL|POD|DEL|DELTerm|DELTerm Desc|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|DSCH_LOC|BL_TP_CD|OBL_ISS_RMK";
            var HeadTitle1 = "Sel.|POD";
            headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
        	
        	
        	InitDataProperty(0, cnt++ , dtDummyCheck,	40,		   daCenter,	true,	"chk",	    false,    "",  dfNone,			0,     true,       true,        -1,     false,      true,"Check");
        	InitDataProperty(0, cnt++ , dtData,         60,       daCenter,    true,   "pod_cd",       false,    "",  dfNone,  0,  false, false);
        	
        	CountPosition = 0;
        }
        	break;
	
		}
	}
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
			case "btn_select":
				
                if (sheetObject.CheckedRows("chk") < 1) {
                    ComShowCodeMessage("COM12113", "[User Set List]");    // Please select {?msg1}
                    return;
                }
                
                var checkedRows = sheetObject.FindCheckedRow("chk");
                var arrRow = checkedRows.split("|");
                var rArray = new Array();
                for (var i = 0; i < arrRow.length -1; i++){
                	rArray.push(sheetObject.CellValue(arrRow[i],"pod_cd")); 
                }
				var myModal = window.dialogArguments;
				myModal.form.pod_cd.value=rArray.join(",");
				window.close();
				break;
			case "btn_close":
				window.close();
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}	
	
	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case SEARCH11:
				if(!validateForm(sheetObj,formObj,sAction)){
					return;
				}
				
				formObj.f_cmd.value = SEARCH11;
				sheetObj.DoSearch("ESM_BKG_1054GS.do", FormQueryString(formObj));
				break;
		}
	}
	
	
	/**
	 * 조회 이후 처리<br>
	 * <br>
	 * <b>Example : </b>
	 *
	 * <pre>
	 * </pre>
	 *
	 * @param {Object}
	 *            sheetObj 필수, Sheet개체
	 * @param {String}
	 *            errStr 필수, 메시지 문자열
	 * @return void
	 * @author Park Mangeon
	 * @version 2009.10.01
	 */
	function pod_list_sheet_OnSearchEnd(sheetObj, errStr) {
		 var p_pod_arr = form.pod_cd.value.split(",");
         var vRow;
         for (var i = 0; i < p_pod_arr.length; i++){
        	 if(ComIsNull(p_pod_arr[i])){
        		 continue; 
        	 }
        	 
        	 vRow = sheetObj.FindText("pod_cd", p_pod_arr[i]);
        	 if(vRow < 1 ){
        		 continue;
        	 }
        	 sheetObj.CellValue(vRow, "chk") = "1";
         }
	}
	
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
 * <br>
 * <b>Example : </b>
 *
 * <pre>
 * </pre>
 *
 * @param {Object}
 *            sheetObj 필수, Sheet개체
 * @param {Object}
 *            formObj 필수, 폼개체
 * @param {int}
 *            sAction 필수, 작업코드
 * @return {boolean} Validation 결과값
 * @author Park Mangeon
 * @version 2009.10.01
 */
function validateForm(sheetObj,formObj,sAction){
    var formObj = document.form;
    switch (sAction){
        case SEARCH11:
            if(ComIsNull(formObj.vvd)){
            	//msgs['BKG00104'] = "Mandatory item is missing. Please enter ({?msg1})"
           	    ComShowCodeMessage("BKG00104","VVD");
           	    return false;
            }
            if(!ComChkObjValid(form.vvd)) return false;
            break;
            
    }
    
   	return true;
}
        	
/* 개발자 작업  끝 */
	
	