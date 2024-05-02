/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_MAS_0121.js
*@FileTitle : Bound Switch ( Seasional SMC Cost (RA) POP UP ) 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 1.0 Creation
* =========================================================
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
     * @class ESM_MAS_0121 : ESM_MAS_0121 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0121() {
    	this.processButtonClick		= tprocessButtonClick;
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
	var sRow = 0;


	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_Rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btn_Close":
					window.close();
					break;
			} // end switch
		} catch(e) {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}

	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo) {
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
				//style.height = GetSheetHeight(10) ;
				style.height = 225 ;

				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				// 0202 SHKIM START
				var locCostUseTpCd = document.form.cost_use_tp_cd.value ;	// A.수정(안보임) ,C.신규(보임) 
				// 0202 SHKIM END
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]				
				InitColumnInfo(7, 0, 0, true);
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);
				
				var HeadTitle =  "DEL|STS|Trade|Sub Trade|Lane|Bound-Original|Bound-Adjusted";	// 0202 SHKIM
				
				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
				//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
				//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
				//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				var cnt = 0;
				InitDataProperty(0, cnt++, dtDelCheck,  30, daCenter, true);
				InitDataProperty(0, cnt++, dtStatus,  	30, daCenter, true,  "ibflag",  	false, "", dfNone,	0, false, false);
				InitDataProperty(0, cnt++, dtCombo,   	60, daCenter, true,  "trd_cd",   	true,  "", dfNone,  0, false, true);				
				InitDataProperty(0, cnt++, dtCombo,    100, daCenter, true,  "sub_trd_cd", 	true,  "", dfNone,  0, false, true);
				InitDataProperty(0, cnt++, dtCombo,    	60, daCenter, true,  "rlane_cd",  	true,  "", dfNone,  0, false, true);
				InitDataProperty(0, cnt++, dtCombo,    100, daCenter, true,  "dir_cd", 	true,  "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtCombo,    110, daCenter, true,  "conv_dir_cd",false,  "", dfNone, 0, false, true);	
				InitComboNoMatchText(true," ");
				CountPosition  = 0 ;
//				     if(locCostUseTpCd == 'A'){				sheetObj.ColHidden("conv_dir_cd") = true;		}
//				else if(locCostUseTpCd == 'C'){				sheetObj.ColHidden("conv_dir_cd") = false;		}
//				InitDataCombo(0, "dir_cd", 		" |E|W", " |E|W");
//				InitDataCombo(0, "conv_dir_cd", " |E|W", " |E|W");
				//InitDataValid(0,"dir_cd",vtEngUpOnly ); //영문대문자만 입력
				}
				break;
		}
	}
	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible=false;
		var trade = sheetObj.CellValue(sheetObj.SelectRow, "trd_cd");
		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0121GS2.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0){			ComMasSetIBCombo(sheetObj, arrXml[0], "trd_cd", true, 0); 	}
				if (arrXml.length > 1){			ComMasSetIBCombo(sheetObj, arrXml[1], "sub_trd_cd", true, 0);	}
				if (arrXml.length > 2){			ComMasSetIBCombo(sheetObj, arrXml[2], "rlane_cd", true, 0);	}
				if (arrXml.length > 3){			
					ComMasSetIBCombo(sheetObj, arrXml[3], "dir_cd", true, 0);	
					ComMasSetIBCombo(sheetObj, arrXml[3], "conv_dir_cd", true, 0);	
				}
				ComOpenWait(false);
				break;
			case IBSEARCH:      //조회
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch4Post("ESM_MAS_0121GS.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBSAVE:      //저장
				if(!validateForm(sheetObj, formObj, sAction)){ return false; }
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESM_MAS_0121GS.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBINSERT:
				sheetObj.DataInsert();
				break;

		}
	}
	/*
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * SAVE 값 체크 , 중복체크
	 */
	function validateForm(sheetObj, formObj, sAction){
		// Bound-Orignal, Bound-Adjusted checking "NULL,BLANK"
		for(a=1;a<(sheetObj.RowCount+1);a++){
			if( (sheetObj.CellValue(a, "dir_cd")== null) || (sheetObj.CellValue(a, "dir_cd")== '') ){
				ComShowMessage(ComGetMsg("MAS10026","Bound-Original"));// 
				return;
			}
			if( (sheetObj.CellValue(a, "conv_dir_cd")== null) || (sheetObj.CellValue(a, "conv_dir_cd")== '') ){
				ComShowMessage(ComGetMsg("MAS10026","Bound-Adjusted"));
				return;
			}					
		}
		// 중복체크 trd_cd, sub_trd_cd, rlane_cd
		var aRlaneCd 	= ''; /* 첫번째 비교대상 */		var bRlaneCd 	= ''; // 두번째 비교대상
		//var aSubTrdCd 	= ''; /* 첫번째 비교대상 */		var bSubTrdCd 	= ''; // 두번째 비교대상
		var aTrdCd 		= ''; /* 첫번째 비교대상 */		var bTrdCd 		= ''; // 두번째 비교대상
		var aDirCd 		= ''; /* 첫번째 비교대상 */		var bDirCd 	= ''; // 두번째 비교대상
		var c = 0;
		
		for(var a=1;a<(sheetObj.RowCount+1);a++){
			aRlaneCd = sheetObj.CellValue(a, "rlane_cd");
			c = a+1;
			for(var b=c;b<(sheetObj.RowCount+1);b++)
			{
				bRlaneCd = sheetObj.CellValue(b, "rlane_cd");
				if( aRlaneCd == bRlaneCd){
					// COMPLARE sub_trd_cd // COMPLARE trd_cd 
					//aSubTrdCd 	= sheetObj.CellValue(a, "sub_trd_cd");	bSubTrdCd 	= sheetObj.CellValue(b, "sub_trd_cd");
					aTrdCd 		= sheetObj.CellValue(a, "trd_cd");		bTrdCd 		= sheetObj.CellValue(b, "trd_cd");
					aDirCd 		= sheetObj.CellValue(a, "dir_cd");		
					bDirCd 		= sheetObj.CellValue(b, "dir_cd");
//					alert(	 "a:["+a+"],c:["+c+"],b:["+b+"]"+"\n"			
//							+"aRlaneCd["+aRlaneCd+"] 	== bRlaneCd["+bRlaneCd+"]"+"\n"
//							//+"aSubTrdCd["+aSubTrdCd+"] 	== bSubTrdCd["+bSubTrdCd+"]"+"\n"
//							+"aDirCd["+aDirCd+"] 	== bDirCd["+bDirCd+"]"+"\n"
//							+"aTrdCd["+aTrdCd+"] 		== bTrdCd["+bTrdCd+"]"+"\n" 
//					); /* 지우지말것. */
					if( (aDirCd == bDirCd) && (aTrdCd == bTrdCd) ){
							ComShowMessage(ComGetMsg("COM131301","uniquely")); //MAS10026 - 'Please select {?msg1}.' ,COM131301 - uniquerly Duplication occurred.
							return false;
					}
				}
			}
		} // 첫번째 for END
		return true;
	}
	/**
	*  Sheet의 Trade, subTrade 변경시 Lane Combo를 재설정한다.
	* @param sheetObj
	* @param row
	* @param col
	* @param value
	* @return
	*/
	function sheet1_OnChange(sheetObj, row, col, value){
		var formObj = document.form;

        if(sheetObj.ColSaveName(col) == "trd_cd"){
        	var formObj = document.form;
     		var sheetObj = sheetObjects[0];
     		var param = "f_cmd="+SEARCHLIST10 +"&f_trd_cd=" + value;
    		var sXml = sheetObj.GetSearchXml("ESM_MAS_0121GS2.do", param);
    		sXml = ComReplaceStr(sXml,"|sub_trd_cd|","|code|");
    		var arrXml = sXml.split("|$$|");
    		if (arrXml.length > 0)
    			ComMasSetIBCombo(sheetObj, arrXml[0], "sub_trd_cd", true, 0, row);
        }
        if(sheetObj.ColSaveName(col) == "sub_trd_cd"){
        	var formObj = document.form;
     		var sheetObj = sheetObjects[0];
     		var param = "f_cmd="+SEARCHLIST11 +"&f_sub_trd_cd=" + value;
    		var sXml = sheetObj.GetSearchXml("ESM_MAS_0121GS2.do", param);
    		sXml = ComReplaceStr(sXml,"|rlane_cd|","|code|");
    		var arrXml = sXml.split("|$$|");
    		if (arrXml.length > 0)
    			ComMasSetIBCombo(sheetObj, arrXml[0], "rlane_cd", true, 0, row);
        }
	}
	
	/* 개발자 작업  끝 */