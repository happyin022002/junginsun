/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0119.js
*@FileTitle : VAT Ratio Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2011-03-31
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.03.31 최도순
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
	 * @class FNS_INV_0119 : FNS_INV_0119 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0119() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
		this.getBackEndJobStatus	= getBackEndJobStatus;
		this.getBackEndJobLoadFile	= getBackEndJobLoadFile;
	}
	
	/* 개발자 작업	*/	
	
	//공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var ROWMARK = "|";
	var FIELDMARK = "^";
	
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
	
			switch(srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
					
			case "btn_new":			
				sheetObject1.RemoveAll();	
				break;	
				
			case "btn_add":
				
				sheetObject1.DataInsert(-1); 
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);	
	
				break;
	
			case "btn_delete":
				ComRowHideDelete(sheetObject1, "chk");
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
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	
	
	/** 
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
	
		for(i=0;i<sheetObjects.length;i++){
	
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		initControl();			
	}
	
	/** 
	 * Sheet 기본 설정 및 초기화 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBSheet} sheetObj : 시트오브젝트
	 * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
	
		case "sheet1":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 385;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(9, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle = "|Sel.|Country|VAT(%)|From|To|Delete Date|Delete Y/N|inv_eu_cnt_seq";
	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  0,    	daCenter,  	true,    "ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,		60,		daCenter,	true,	 "chk",					false,	"",	dfNone,		0,	true,		true);
				InitDataProperty(0, cnt++ , dtCombo,		150,    daCenter,  	true,    "cnt_cd",				true,	"",	dfNone,		0,	false,		true,	2,true);
				InitDataProperty(0, cnt++ , dtData,	     	150,    daCenter,  	true,    "inv_euro_vat_rt",		true,  	"", dfNullFloat,2,	true,		true, 	4,false);
				InitDataProperty(0, cnt++ , dtData,     	150,    daCenter,  	true,    "inv_euro_vat_st_dt",  true,  	"", dfDateYmd,	0,	true,		true, 	8,true);
				InitDataProperty(0, cnt++ , dtData,	     	150,    daCenter,  	true,    "inv_euro_vat_end_dt", false, 	"",	dfDateYmd,	0,	true,		true, 	8,true);
				InitDataProperty(0, cnt++ , dtData,	     	200,    daCenter,  	true,    "delt_dt",  			false, 	"", dfNone,		0,	false,		false, 	0,false);
				InitDataProperty(0, cnt++ , dtData,     	80,    	daCenter,  	true,    "delt_flg",   			false,  "", dfNone,		0,	false,		false, 	0,false);
				InitDataProperty(0, cnt++ , dtHidden,     	0,    	daCenter,  	true,    "inv_eu_cnt_seq",      false,  "", dfNone,		0,	false,		false, 	0,false);
				
				WaitImageVisible = false; 
				
				InitComboNoMatchText(false);
			}
			break;		
	
		}
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSAVE:        //저장				
			if(validateForm(sheetObj,formObj,sAction)) return;
			ComOpenWait(true);
			
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("FNS_INV_0119GS.do", FormQueryString(formObj),-1,false); 						
			
			ComOpenWait(false);
			
			//doActionIBSheet(sheetObj,formObj,IBSEARCH);
	
		break;	
	
		case IBSEARCH:      //조회
	
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
	
			sheetObj.DoSearch("FNS_INV_0119GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			
		break;
		
		case IBSEARCH_ASYNC01:     
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			
			var sXml = sheetObj.GetSearchXml("FNS_INV_0119GS.do", FormQueryString(formObj));			
			var comboValues = ComGetEtcData(sXml, "cnt_cd");	
			formObj.cnt_cds.value = comboValues;
			addCellComboItem(sheetObj,comboValues,"cnt_cd",false);	
			
			ComOpenWait(false);
		break;
		}
	}
	
	
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
			case IBSAVE: 
				for (var i=1; i<=sheetObjects[0].RowCount; i++) {					
					
					if(sheetObjects[0].RowStatus(i)!="D"&&sheetObjects[0].CellValue(i,"delt_flg")!="Y"){
						
						var fmDt = sheetObj.CellValue(i,"inv_euro_vat_st_dt");
						var toDt = sheetObj.CellValue(i,"inv_euro_vat_end_dt");
						if(toDt!=""){
							if (fmDt > toDt) {
								ComShowCodeMessage("INV00024");
								sheetObj.SelectCell(i,"inv_euro_vat_end_dt");
								return true;
							}
						}
						
						for (var j=1; j<=sheetObjects[0].RowCount; j++) {
							if(i!=j){
								if(sheetObjects[0].CellValue(i,"cnt_cd")==sheetObjects[0].CellValue(j,"cnt_cd")){								
									if(sheetObjects[0].RowStatus(j)!="D"&&sheetObjects[0].CellValue(j,"delt_flg")!="Y"){									
										if(sheetObjects[0].CellValue(i,"inv_euro_vat_st_dt")<=sheetObjects[0].CellValue(j,"inv_euro_vat_end_dt")
												&& sheetObjects[0].CellValue(i,"inv_euro_vat_end_dt")>=sheetObjects[0].CellValue(j,"inv_euro_vat_st_dt") ){
											ComShowCodeMessage("INV00042", "Country  : "+sheetObjects[0].CellValue(i,"cnt_cd")+"  ", "   "+i+" Line and "+ j+" Line");
											return true;
										}
									}
								}
							}
						}
					}
				}
				break;
			}
		}     
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function obj_keypress(){
		switch(event.srcElement.dataformat){
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "ymd":
			//숫자+"-"입력하기
			ComKeyOnlyNumber(event.srcElement);
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
		case "num":
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber('num');
			break;
		case "uppernum":
			//영문대+숫자 
			ComKeyOnlyAlphabet('uppernum');
			break;
		default:
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
		}
	} 
	 

	/**
	 * 그리드내 콤보필드에 데이터를 추가해준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     addCellComboItem(sheetObj,comboValues,colName,isCellCombo);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} comboValues combo 로 생성할 values
	 * @param {String} colName combo 가 위치할 GRID 내 column 명
	 * @param {String} isCellCombo  일반 combo 와 cell combo 구분 flag 
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
	
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i];
	
				if (comboItem != "") {
					comboTxt += comboItem;
					comboVal += comboItem;
				}
	
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
	
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
		}
		else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal);
		}
	
	}
	 
	 /**
	 * 그리드 변경시 실행 Customer Validation<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    sheet1_OnChange(SheetObjects[0], 1,1,'20090901');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param string Value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */  
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		/*
		 if (sheetObjects[0].ColSaveName(Col) == "chk"){				
			if (Value =="1"){
				sheetObjects[0].CellValue(Row,"delt_flg")="Y";
			}else{
				sheetObjects[0].CellValue(Row,"delt_flg")="N";
			}
		}
		*/
	}
	
	 /**
	 * Sheet Save 종료시 Sheet Retrieve<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSaveEnd(sheetObjects[0],'');
	 * </pre>
	 * @param object sheetObj
	 * @param string ErrMsg
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){   
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}
 

/* 개발자 작업  끝 */