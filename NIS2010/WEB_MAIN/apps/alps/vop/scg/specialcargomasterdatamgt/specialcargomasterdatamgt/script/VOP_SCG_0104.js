/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VOP_SCG_0140.js
*@FileTitle : Max. Qty by Packaging Type 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.25
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2013.02.25 박찬민
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
	 * @class VOP_SCG_0104 : VOP_SCG_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_SCG_0104() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
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
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");

	 		switch(srcName) {
	 		case "btn_RowAdd":
 				var row = sheetObject.DataInsert(-1);
 				sheetObject.CellValue(row,"imdg_pck_instr_cd") = formObject.f_pck_cd.value;
 				sheetObject.CellValue(row,"imdg_pck_instr_seq") = formObject.f_pck_cd_seq.value;
 				sheetObject.CellValue(row,"regu_dp_no") = formObject.regu_dp_no.value;
				sheetObject.SelectCell(row, 2);
				break;
			
			case "btn_RowCopy":
				var row = sheetObject.DataCopy();
				sheetObject.SelectCell(row, 2);
				break;
				
			case "btn_RowDelete":
			   ComRowHideDelete(sheetObject, "del_chk");
			
				break;	
			case "btn_Save":
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			case "btn_close":
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	}

	 function sheet1_OnLoadFinish(sheetObj) {
         //html컨트롤 이벤트초기화
         initControl();
         doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/

    function initControl() {
    	axon_event.addListener('keydown',	'ComKeyEnter', 			'form');
   	 	axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
    }

//	/**
//	 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
//	 **/
//	function obj_keypress(){
//		var obj = event.srcElement;
//		switch(obj.name){
//			case "cnt_cd":
//				if(event.keyCode!=32){ // 공백입력가능
//					ComKeyOnlyAlphabet('upper');
//				}
//				break;
//			case "port_cd":
//				if(event.keyCode!=32){ // 공백입력가능
//					ComKeyOnlyAlphabet('upper');
//				}
//				break;
//		}
//	}

//	function obj_blur() {
//		var formObj = document.form;
//		var obj = event.srcElement;
//   	 	switch(obj.name){
//   	 		case "cnt_cd":
//   	 			var length = formObj.cnt_cd.value.length;
//   	 			if (length > 0) {
//   	 				doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
//   	 			}
//   	 			break;
//   	 	}	
//	
//	}

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
					tabIndex = -1;
            	 
					// 높이 설정
					style.height = 237;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]

					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 2, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, false, false,false)

					var HeadTitle = "|Chk|imdg_pck_instr_cd|Imdg_pck_instr_seq|Display \n Seq.|seq|Type|Code|Name|Inner Packaging|Inner Packaging|Quter Packaging \n (Max. net mass)|Quter Packaging \n (Max. net mass)";
					var HeadTitle1= "|Chk|imdg_pck_instr_cd|Imdg_pck_instr_seq|Display \n Seq.|seq|Type|Code|Name|Q'ty|UOM|Q'ty|UOM";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
                 
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag",		 	false,	"",      	dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,	"del_chk",		   	false,	"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,	    50,		daCenter,	true,	"imdg_pck_instr_cd",		    true,	"",      	dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"imdg_pck_instr_seq",	 	false,	"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daLeft,		true,	"regu_dp_no",		 	true,	"",			dfNone,			0,			false,		false, 4);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	"sub_seq",				false,	"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		100,	daLeft,		true,	"pck_tp_cd",		false,	"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"imdg_pck_cd",			false,	"",			dfNone,			0,			true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"spcl_pck_desc",			false,	"",			dfNone,			0,			true,		true, 50);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"in_pkg_qty",		false,	"",			dfNone,			2,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		50,		daLeft,		true,	"in_pkg_meas_ut",	false,	"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	"out_pkg_qty",		false,	"",			dfNone,			2,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		50,		daLeft,		true,	"out_pkg_meas_ut",	false,	"",			dfNone,			0,			true,		true);
					InitDataValid(0, "imdg_pck_cd", vtEngUpOther, "0123456789"); // 영대문자,숫자만 입력
					InitDataValid(0, "in_pkg_qty", vtNumericOther, "."); // 숫자만 입력
					InitDataValid(0, "out_pkg_qty", vtNumericOther, "."); // 숫자만 입력
				}
				break;

		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case COMMAND01:		//ComboList 조회
				if(validateForm(sheetObj,formObj,sAction)){
        	 		formObj.f_cmd.value = COMMAND01;
        	 		var sXml = sheetObj.GetSearchXml("VOP_SCG_0104GS.do", FormQueryString(formObj));
        	 		if(ComGetTotalRows(sXml) > 0){
        	 			ComSetIBCombo(sheetObj, sXml, "pck_tp_cd", true );
        	 		}
	        	   	formObj.f_cmd.value = SEARCH01;
		   			var sXml = sheetObj.GetSearchXml("VOP_SCG_0103GS.do", FormQueryString(formObj));
		   			if(ComGetTotalRows(sXml) > 0){
			   			ComSetIBCombo(sheetObj, sXml, "in_pkg_meas_ut", true );
			   			ComSetIBCombo(sheetObj, sXml, "out_pkg_meas_ut", true );
		   			}
				}
        	case IBSEARCH:      //조회
        		if(validateForm(sheetObj,formObj,sAction)){
        	 		formObj.f_cmd.value = SEARCH;
	        	   	sheetObj.DoSearch("VOP_SCG_0104GS.do", FormQueryString(formObj));
				}
        		break;
        	case IBSAVE:      //Country Code조회
        		if(validateForm(sheetObj,formObj,sAction)){
        			if(!validateForm(sheetObj,formObj,sAction))return;
     				if(!ComShowCodeConfirm('SCG50001', 'data')) return;
            		formObj.f_cmd.value = MULTI;
    				sheetObj.DoAllSave("VOP_SCG_0104GS.do", FormQueryString(formObj));
    			
        		}
        		break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
//		var vsl_cd = formObj.vsl_cd;
//		var vsl_eng_nm = formObj.vsl_eng_nm;
//		var crr_cd = formObj.crr_cd;
//		with(formObj){
//			if (ComChkLen(vsl_cd, 2)==1 && ComChkLen(vsl_eng_nm, 2)==1 && ComChkLen(crr_cd, 2)==1){
//				ComShowCodeMessage('VSK00022');
//				vsl_cd.focus();
//				return false;
//			}
//		}
		return true;
	}
 
//	/**
//	 * 부모창에 선택값 리턴
//	 */
//	function sheet1_OnDblClick(sheetObj, Row, Col) {
//		window.returnValue = sheetObj.CellValue(sheetObj.SelectRow, 'val_cd');
//		comPopupOK();
//	}
// 
//	function sheet1_OnClick(sheetObj, Row, Col){
//		window.returnValue = sheetObj.CellValue(sheetObj.SelectRow, 'val_cd');
//	}//end sheet1_OnDblClick

	/**
	 * 엔터키로 연결된 화면 대표 이벤트
	 */
	function enter_keypress(){
//		VskKeyEnter();
	}
	
    /**
     * Sheet1 Combo Change Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var formObj = document.form;
    	 with(sheetObj) { 
    		switch(ColSaveName(Col)) {
    			case "imdg_pck_cd":
    				if(CellValue(Row, "imdg_pck_cd")!=""){
	    				formObj.f_cmd.value = COMMAND02;
	                    var sParam = "&f_cmd=" + formObj.f_cmd.value
	                               + "&imdg_pck_cd=" + sheetObj.CellValue(Row, "imdg_pck_cd"); 
	    				var sXml = sheetObj.GetSearchXml("VOP_SCG_0104GS.do", sParam);
	    				
	    				var pkgTpCd = ComGetEtcData(sXml,"PCK_TP_CD");
	    				var pkgCd = ComGetEtcData(sXml,"IMDG_PCK_CD");
	    				var pkgNm = ComGetEtcData(sXml,"SPCL_PCK_DESC");
	    				
	    				if(pkgTpCd != undefined){
	    					sheetObj.CellValue2(Row, "pck_tp_cd") = pkgTpCd ;
	    					sheetObj.CellValue2(Row, "imdg_pck_cd") = pkgCd ;
	    					sheetObj.CellValue2(Row, "spcl_pck_desc") = pkgNm ;
	    				}else{
	    					sheetObj.CellValue2(Row, "pck_tp_cd") = "" ;
	    					sheetObj.CellValue2(Row, "imdg_pck_cd") = "" ;
	    					sheetObj.CellValue2(Row, "spcl_pck_desc") = "" ;
	    					ComShowCodeMessage('SCG50010','Code');
	    				}
    				}
    				break;
    				
    			case "pck_tp_cd":
    				sheetObj.CellValue(Row, "imdg_pck_cd") = "";
    				sheetObj.CellValue(Row, "spcl_pck_desc") = "";
    		}
    	 }
	}


/* 개발자 작업  끝 */