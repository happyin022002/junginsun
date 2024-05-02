/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0901.jsp
*@FileTitle : Remark Detail 조회/추가/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2008-05-22
*@LastModifier : JeongHo_Lee
*@LastVersion : 1.0
* 2008-05-22 JeongHo_Lee
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends Bkg
	 * @class ESD_EAS_0901 : 예)COD vs. TPB 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0901() {
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.initTab                = initTab;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	}	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	
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
			ComConfigSheet(sheetObjects[i]);
	       initSheet(sheetObjects[i],i+1);
	       //khlee-마지막 환경 설정 함수 추가
	       ComEndConfigSheet(sheetObjects[i]);
		}
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
//    	doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	}
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){

		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_add":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_close":
				    window.returnValue = null;
				    window.close();
				    break;
			} // end switch

		} catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage("COM12111");
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		var cnt = 0;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 240;
					
					// 헤더 높이 설정
					sheetObj.HeadRowHeight = 27;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 6, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(11, 1, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle1 = "Booking Nbr|Seq|Remark|Update Date|Update Office|Update User";
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					initDataProperty(0, cnt++, dtData,      100,    daCenter, true,    	"bkg_no",			false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,       40,    daCenter, false,    "rmk_ctnt_seq",     false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,      250,    daLeft,   false,    "rmk_ctnt",     	false,          "",       dfNone,    0,     true,        true,	1000);
					InitDataProperty(0, cnt++, dtData,    	 80,    daCenter, false,    "upd_dt",      		false, 			"",    	  dfNone,    0,     false,       false); 
					InitDataProperty(0, cnt++, dtData,       90,    daCenter, false,    "cre_ofc_cd",      	false,          "",       dfNone,    0,     false,       false,	6);
					InitDataProperty(0, cnt++, dtData,       85,    daCenter, false,    "upd_usr_id",      	false,          "",       dfNone,    0,     false,       false,	20);
					InitDataProperty(0, cnt++, dtData,     85,    daCenter, false,    "bl_no",      		false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,     85,    daCenter, false,    "eas_expn_tp_cd",  	false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData,     85,    daCenter, false,    "bkg_no_split",  	false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtData, 	 30,    daCenter, false,   	"op_code",		  	false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtStatus, 30,  daCenter, false,   	"ibflag",		  	false,          "",       dfNone,    0,     false,       false);
					WordWrap = true;
					sheetObj.DateFormatChar = "-";
					
				}
				break;
		}
	}


	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
		   case SEARCH01:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch4Post("ESD_EAS_0901GS.do", EasFrmQryString(formObj));
				break;
		   
		   case IBSAVE:		//저장
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
				formObj.f_cmd.value = MULTI01;

				if (sheetObj.DoSave("ESD_EAS_0901GS.do", EasFrmQryString(formObj))) {
					doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
				}
				
				break;
			
			case IBINSERT:	  //입력
				var Row = sheetObj.DataInsert(-1);
				var insertFlg = 1;
				sheetObj.CellValue(Row,"bkg_no")     = formObj.s_bkg_no.value;
				sheetObj.CellValue(Row,"cre_ofc_cd") = formObj.cre_ofc_cd.value;
				sheetObj.CellValue(Row,"upd_dt")     = formObj.login_date.value;
				sheetObj.CellValue(Row,"upd_usr_id") = formObj.cre_user_id.value;
				sheetObj.CellValue(Row,"rmk_ctnt_seq") = sheetObj.RowCount;
				sheetObj.CellValue(Row,"eas_expn_tp_cd") = formObj.s_eas_expn_tp_cd.value;
				sheetObj.CellValue(Row,"op_code")	 = "I"; 
//				sheetObj.RowStatus(Row)    = "I";
				break;
			
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;

		}
	}	

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
	}
	
	/**
	 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		doActionIBSheet(docObjects[0],document.form,SEARCH01);
	}

	function sheet1_OnDblClick(sheetObj, Row,Col,Value){
		var formObj = document.form;
		var currentOfcCd = formObj.s_cre_ofc_cd.value;
		
		if(Col == 2){
			if(sheetObj.CellValue(Row, 'cre_ofc_cd') != currentOfcCd ){
				sheetObj.CellEditable(Row, 2) = false; 
				ComShowMessage("Update by Only Created Office");
				return false;
				}
		}
	}

	/**
	 * Sheet1의 onChange이벤트핸들러
	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
	 */
	function sheet1_OnChange(sheetObj, Row,Col,Value){
		if(Col != 2 && Col != 9 ){
//			sheetObj.RowStatus(Row) = "R";
		}else if(Col == 2){
			if(sheetObj.CellValue(Row, 'op_code')=="I" 
				&& (sheetObj.RowCount == sheetObj.CellValue(Row, 'rmk_ctnt_seq'))){
//				sheetObj.RowStatus(Row) = "I";
				sheetObj.CellValue(Row, 'op_code') = "I"
			}else{
//				sheetObj.RowStatus(Row) = "U";
				sheetObj.CellValue(Row, 'op_code') = "U"
			}
		}
	}	
 
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			/**
			 * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
			 */
			//if (!isNumber(formObj.iPage)) {
			//	return false;
		   // }
		}
		
		return true;
	}

	function isInputField(formObj) {
		var result    = true ;
	
		if( document.form.s_cre_ofc_cd.value=="" ) {
			ComShowMessage(getMsg('EAS90001'));
			result = false;
		}
		return result;
	}
	