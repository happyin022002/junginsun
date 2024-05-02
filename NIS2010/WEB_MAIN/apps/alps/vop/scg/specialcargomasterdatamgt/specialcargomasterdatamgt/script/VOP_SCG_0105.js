/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VOP_SCG_0105.js
*@FileTitle : Proper IBC Code
*@LastModifyDate : 2013.02.25
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.02.25 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================
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
	 * @class VOP_SCG_0105 : VOP_SCG_0105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_SCG_0105() {
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
	 			doActionIBSheet(sheetObject,formObject,MULTI02);
				break;
			
			case "btn_RowCopy":
				var row = sheetObject.DataCopy();
				sheetObject.SelectCell(row, "perm_chk");
				break;
				
			case "btn_RowDelete":
				var sRow = sheetObject.FindCheckedRow("del_chk");
				var arrRow = sRow.split("|");
				if(arrRow.length > 0){
				    ComRowHideDelete(sheetObject, "del_chk");		
				}else{
					ComShowCodeMessage('COM12189');
				}
				break;
				
			case "btn_Save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
				
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
		var formObj = document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
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
				InitRowInfo( 1, 1, 3, 100);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "ibflag|CHK|Display\nSeq.|Seq|Allowed\nPermit|IBC Code|Type|And/Or|DELT_FLG|IMDG_PCK_INSTR_CD|IMDG_PCK_INSTR_SEQ";

				var headCount = ComCountHeadTitle(HeadTitle);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  
				InitHeadRow(0, HeadTitle, true); 
             
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag",		false,	"",      	dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,	"del_chk",		false,  "",			dfNone,		    0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"regu_dp_no",		false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	false,	"sub_seq",			false,	"",			dfNone,			0,			false,		false);
				InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	false,	"perm_chk",		false,	"",			dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"imdg_pck_cd",		false,	"",			dfNone,			0,			true,		true, 5);
				InitDataProperty(0, cnt++ , dtCombo,		180,	daLeft,		false,	"pck_tp_cd",	false,	"",			dfNone,			0,			true,		true);			
				InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,	false,	"and_or_cd",	false,	"",			dfNone,			0,			true,		true); 										
				InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		false,	"delt_flg",		false,	"",			dfNone,			0,			true,		true); 			
				InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		false,	"imdg_pck_instr_cd",		false,	"",			dfNone,			0,			true,		true); 	
				InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		false,	"imdg_pck_instr_seq",	false,	"",			dfNone,			0,			true,		true); 	
				InitDataCombo(0, "perm_chk", "|Allow|Permit", "|A|P");  
				InitDataCombo(0, "and_or_cd", "|And|Or", "|A|O");  
				InitDataValid(0, "imdg_pck_cd", vtEngUpOther, "0123456789"); // 영대문자,숫자만 입력
				}
				break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var formObj = document.form;
		switch(sAction) {
		
        	case IBSEARCH:      // combo
	  	 		formObj.f_cmd.value = SEARCH01;
	   			var sXml = sheetObj.GetSearchXml("VOP_SCG_0105GS.do", FormQueryString(formObj));
	   			ComSetIBCombo(sheetObj, sXml, "pck_tp_cd", true );
        		break;
        		
        	case IBSAVE:      // SAVE
//              if (!validateForm(sheetObj,formObj,sAction)) {
//              return false;
//          }
     			if(!ComShowCodeConfirm('SCG50001', 'data')) return;
        		formObj.f_cmd.value = MULTI01;			
		 		var sParamSheet1 = sheetObjects[0].GetSaveString(false);
                var sParam = "&f_cmd=" + formObj.f_cmd.value; 
                sParam = sParam + "&" + sParamSheet1;
	 			var sXml = sheetObj.DoSave("VOP_SCG_0105GS.do", sParam, -1, false ); 
        		break;
        		
        	case MULTI02:     // ROW ADD
        		var iRow = sheetObj.DataInsert(-1)
        		sheetObj.CellValue(iRow, "imdg_pck_instr_cd") = formObj.imdg_pck_instr_cd.value ;
        		sheetObj.CellValue(iRow, "imdg_pck_instr_seq") = formObj.imdg_pck_instr_seq.value ;
        		sheetObj.CellValue(iRow, "regu_dp_no") = formObj.regu_dp_no.value ;
        		sheetObj.CellValue(iRow, "perm_chk") = "" ;
        		sheetObj.CellValue(iRow, "and_or_cd") = "" ; 
        		sheetObj.CellValue(iRow, "delt_flg") = 'N' ;
        		sheetObj.SelectCell(iRow, "perm_chk");
        		break;
        		
        	case SEARCH02:      //조회
//              if (!validateForm(sheetObj,formObj,sAction)) {
//              return false;
//          }
		 		formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0105GS.do", FormQueryString(formObj));	 	 	 
				sheetObj.LoadSearchXml(sXml);
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
    				formObj.f_cmd.value = SEARCH03;
                    var sParam = "&f_cmd=" + formObj.f_cmd.value
                               + "&imdg_pck_cd=" + sheetObj.CellValue(Row, "imdg_pck_cd"); 
    				var sXml = sheetObj.GetSearchXml("VOP_SCG_0105GS.do", sParam);
    				var pkgTpCd = ComGetEtcData(sXml,"PCK_TP_CD");
    				
    				if(pkgTpCd != ""){
    					sheetObj.CellValue2(Row, "pck_tp_cd") = pkgTpCd ;
    				}else{
    					sheetObj.CellValue2(Row, "pck_tp_cd") = "";
    				}			
    				break;
    		}
    	 }
	}