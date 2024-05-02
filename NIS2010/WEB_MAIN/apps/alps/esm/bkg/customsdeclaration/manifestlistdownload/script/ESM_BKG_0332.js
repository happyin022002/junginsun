/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESM_BKG_0332.js
 *@FileTitle : ESM_BKG_0332
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2015.06.25 [CHM-201535756] 한국 WHF 면제/조정 기능 간소화
 * 1.0 Creation
 * ----------------------------------------------------
 * History 
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
 * @class esm_bkg_0332 : esm_bkg_0332 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0332() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
	
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		/** **************************************************** */
		var formObj = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
			case "btn_confirm":
				doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
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
	
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @param sheet_obj IBSheet Object
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
	
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
     	
		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); // -
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		// 키보드
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		
		axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
	
        if(formObj.vvd_no.value != "" && formObj.bkg_no.value!="" && formObj.pod_cd.value !="")
        {
        	doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
        
	}
	
	/**
	 * 조회조건 입력할 때 처리
	 */
	function obj_KeyUp() {
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var srcValue = window.event.srcElement.getAttribute("value");
		if (ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
	
	/**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 */
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
		case "uppernum":
			// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "upper":
			// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
			break;
		case "num":
			// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyNumber('num');
			break;
		case "int":
	 		//숫자만입력하기
	 		ComKeyOnlyNumber(event.srcElement);
	 		break;
	 	case "float":
	 		//숫자+"."입력하기
	 		ComKeyOnlyNumber(event.srcElement, ".");
	 		break;
	 	default:
			// 숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber(event.srcElement);
		}
	}
	
	/**
	 * Form Object - change
	 */
	function frmObj_OnChange(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var elementName = window.event.srcElement.getAttribute("name");
		with (document.form) {
			switch (elementName) {
				case "cbm_amt":
				case "ton_amt":
				case "chg_ut_amt":
					
					if(!ComIsNull(formObj.cbm_amt) &&  !ComIsNull(formObj.ton_amt) && !ComIsNull(formObj.chg_ut_amt)){
						
						if(formObj.cbm_amt.value-formObj.ton_amt.value >=0){
							// CBM 값이  Ton보다 클 경우
							formObj.chg_amt.value = formObj.cbm_amt.value * formObj.chg_ut_amt.value;
							formObj.rat_ut_cd.value = "CM";
							formObj.rat_as_qty.value = formObj.cbm_amt.value;
						}else{
							// Ton값이 CBM값 보다 클 경우
							formObj.chg_amt.value =  formObj.ton_amt.value * formObj.chg_ut_amt.value;
							formObj.rat_ut_cd.value = "MT";
							formObj.rat_as_qty.value = formObj.ton_amt.value;
						}
					}
					
				break;			
			}
		}
	}
	
	function cal_charge(){
		var formObj = document.form;
		
		if( formObj.cbm_amt.value-formObj.ton_amt.value >=0 ){
			// CBM 값이  Ton보다 클 경우
			formObj.chg_amt.value = formObj.cbm_amt.value * formObj.chg_ut_amt.value;
			formObj.rat_ut_cd.value = "CM";
			formObj.rat_as_qty.value = formObj.cbm_amt.value;
		}else{
			// Ton값이 CBM값 보다 클 경우
			formObj.chg_amt.value =  formObj.ton_amt.value * formObj.chg_ut_amt.value;
			formObj.rat_ut_cd.value = "MT";
			formObj.rat_as_qty.value = formObj.ton_amt.value;
		}
	}

	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * @param sheetObj 시트오브젝트
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;

		switch (sheetID) {
		case "sheet1": // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 100;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") 
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(14, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				var HeadTitle1 = "|vsl_cd|skd_voy_no|skd_dir_cd|pod_cd|bkg_no|bdr_flg|rt_seq|cbm_amt|ton_amt|rat_ut_cd|rat_as_qty|chg_ut_amt|chg_amt";
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//데이터속성          [ROW, COL,    DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	  0, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++,  dtData, 	     70, daCenter, true,  "vsl_cd");
				InitDataProperty(0, cnt++,  dtData,          70, daCenter, true,  "skd_voy_no");
				InitDataProperty(0, cnt++,  dtData, 		 40, daCenter, true,  "skd_dir_cd");
				InitDataProperty(0, cnt++,  dtData, 		 60, daCenter, true,  "pod_cd");
				InitDataProperty(0, cnt++,  dtData, 		100, daCenter, true,  "bkg_no");
				InitDataProperty(0, cnt++,  dtData, 		 60, daCenter, true,  "bdr_flg");
				InitDataProperty(0, cnt++,  dtData, 		 60, daCenter, true,  "rt_seq");
				InitDataProperty(0, cnt++,  dtData, 		 80, daCenter, true,  "cbm_amt");
				InitDataProperty(0, cnt++,  dtData, 		 80, daCenter, true,  "ton_amt");
				InitDataProperty(0, cnt++,  dtData, 		 80, daCenter, true,  "rat_ut_cd");
				InitDataProperty(0, cnt++,  dtData, 		 80, daCenter, true,  "rat_as_qty");
				InitDataProperty(0, cnt++,  dtData, 		 80, daCenter, true,  "chg_ut_amt");
				InitDataProperty(0, cnt++,  dtData, 		 80, daCenter, true,  "chg_amt");
			}
			break;
	
		}
	}
	
	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj Sheet
	 * @param formObj form객체
	 * @param sAction 작업처리코드
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

			
		switch (sAction) {
		case IBSEARCH: // 조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
			formObj.f_cmd.value = SEARCH;
			
			formObj.vsl_cd.value = formObj.vvd_no.value.substring(0,4);
   			formObj.skd_voy_no.value = formObj.vvd_no.value.substring(4,8);
   			formObj.skd_dir_cd.value = formObj.vvd_no.value.substring(8);
   			
   			
            var sXml = sheetObj.GetSearchXml("ESM_BKG_0332GS.do", FormQueryString(formObj));
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	        
			var resultVal = ComGetEtcData(sXml, "err_msg");
			
			if(State == "S"){
	        	
				var msg_cd = resultVal.split("&")[0] ;
	 	    	var msg_val = resultVal.split("&")[1] ;
	 	    	
	 	    	
	 	    	if(msg_cd == "SUCCESS"){
	 	    		sheetObj.LoadSearchXml(sXml);
	       			
	   				if(sheetObj.RowCount >0){
	   					formObj.cbm_amt.value  = sheetObj.CellValue(1,"cbm_amt");
	   					formObj.ton_amt.value  = sheetObj.CellValue(1,"ton_amt");
	   					formObj.chg_ut_amt.value = sheetObj.CellValue(1,"chg_ut_amt");
	   					
	   					cal_charge();
	   					ComBtnEnable("btn_confirm");
		 	    		
	   				}
	   				
	 	    	}else if(msg_cd == "BKG06170"){  // No data found. Please check {?msg1} data.
	 	    		ComShowCodeMessage(msg_cd,msg_val);
	 	    		ComBtnDisable("btn_confirm");
	 	    		
	 	    	}else if(msg_cd == "BKG06169" ){
	 	    		ComShowCodeMessage(msg_cd);  // Please check the WHF charge. These exists more than one WHF charge.
	 	    		ComBtnDisable("btn_confirm");
	 	    		
	 	    	}
	 	    	   
	        }else{
	        	// 에러메세지 출력
	    		ComShowMessage(ComResultMessage(sXml));
	        }
			break;
			
		case IBSAVE: // 저장
			
			if (validateForm(sheetObj, formObj, sAction)) {
				
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				
				// Save전에 한번 다시 계산하기
				cal_charge();
				
				
				sheetObj.CellValue(1,"vsl_cd")     = formObj.vsl_cd.value;
				sheetObj.CellValue(1,"skd_voy_no") = formObj.skd_voy_no.value;
				sheetObj.CellValue(1,"skd_dir_cd") = formObj.skd_dir_cd.value;
				sheetObj.CellValue(1,"pod_cd")     = formObj.pod_cd.value;
				sheetObj.CellValue(1,"bkg_no")     = formObj.bkg_no.value;
				sheetObj.CellValue(1,"bdr_flg")    = formObj.bdr_flg.value;
				
				sheetObj.CellValue(1,"cbm_amt")    = formObj.cbm_amt.value;
				sheetObj.CellValue(1,"ton_amt")    = formObj.ton_amt.value;
				
				sheetObj.CellValue(1,"rat_ut_cd")  = formObj.rat_ut_cd.value;
				sheetObj.CellValue(1,"rat_as_qty") = formObj.rat_as_qty.value;
				sheetObj.CellValue(1,"chg_ut_amt") = formObj.chg_ut_amt.value;
				sheetObj.CellValue(1,"chg_amt")	   = formObj.chg_amt.value;
				
				
				formObj.f_cmd.value = MULTI;
				
				var sParam = ComGetSaveString(sheetObj);
				sParam += "&" + FormQueryString(formObj);
				
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0332GS.do", sParam);
		 	    
				var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				
				var resultVal = ComGetEtcData(sXml, "err_msg");
		 	    
				if (state == "S") {
					
					var msg_cd = resultVal.split("&")[0] ;
		 	    	var msg_val = resultVal.split("&")[1] ;
		 	    	
		 	    	if(msg_cd == "SUCCESS"){
		 	    		ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!
		 	    		ComBtnDisable("btn_confirm");
		 	    		
		 	    	}else if(msg_cd == "BKG06170"){
		 	    	
		 	    		ComShowCodeMessage(msg_cd,msg_val);
		 	    		ComBtnDisable("btn_confirm");
		 	    		
		 	    	}else{
						ComShowMessage(ComResultMessage(sXml));
		 	    	}
		 	    	
					
				}else{
					ComShowMessage(ComResultMessage(sXml));
				}
				
				sheetObj.RemoveAll();
				
				ComOpenWait(false);
			}
			break;
		}
	}
	

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param sheetObj Sheet
	 * @param formObj form객체
	 * @param sAction 작업처리코드
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSAVE:
			if (ComIsNull(formObj.cbm_amt)){
				
				ComShowCodeMessage("BKG00626", "CBM");
				formObj.cbm_amt.focus();
				return false;
			}else if(ComIsNull(formObj.ton_amt)){
				ComShowCodeMessage("BKG00626", "Ton");
				formObj.ton_amt.focus();
				return false;
			}else if(ComIsNull(formObj.chg_ut_amt)) {
				ComShowCodeMessage("BKG00626", "Rate");
				formObj.chg_ut_amt.focus();
				return false;
			}
	
			return true;
			break;
		}
		
		return true;
	}
