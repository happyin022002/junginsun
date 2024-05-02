/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_EAS_0319.js
*@FileTitle : ESD_EAS_0319
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.16
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015.02.16 9014613
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
     * @class esd_eas_0319 : esd_eas_0319 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0319() {
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
			
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
	
                case "btn_downexcel":
                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
	        ComConfigSheetEas(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);	         
	    }
	    
		// IBMultiCombo 설정
		for(var k = 0; k < comboObjects.length; k++){
			comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
		}
	    
	    doActionIBCombo(formObj.s_lgs_cost_cd);
		getEasIbComboList(formObj.s_rto_tp_cd , 'A|M|Y' , 'All|Last Month|Over Last Year' , '');  // 금액 체크 범위 조건 
		formObj.s_rto_tp_cd.code2 = 'A';
	}
	
	/**
	 * 화면 로딩 완료 후 이벤트
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;
    	
		initFocus();
	    
		//화면에서 필요한 이벤트
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_keypress", document.form);
    	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm  ( 'click'     , 'obj_click'      , document.form );
    	axon_event.addListenerForm  ( 'change'     , 'obj_change'      , document.form );
		
    	if(formObj.s_ofc_cd.value != "") {
    		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    	}
	}   
	
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "float":
	        	ComKeyOnlyNumber(event.srcElement, "-.");
	        break;
	    }
	}
	
	function doActionIBCombo(comboObj) {
    	var frm = document.form;
    	var sheetObj = sheetObjects[0];
        switch(comboObj.id) {	    
		case "s_lgs_cost_cd":    
			frm.s_lgs_cost_cd.RemoveAll();
			frm.f_cmd.value = SEARCH01;
			var sXml = sheetObjects[0].GetSearchXml("ESD_EAS_0317GS.do", FormQueryString(frm));
			ComXml2ComboItem(sXml, frm.s_lgs_cost_cd, "lgs_cost_cd", "lgs_cost_cd|lgs_cost_nm|mdl_cd|cgo_tp_cd");	
			frm.s_lgs_cost_cd.InsertItem(0, "", "");
			frm.s_lgs_cost_cd.ValidChar(2,0);
			
		break;
        }
    }
	
	function s_lgs_cost_cd_OnChange(){
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	
	/**
	 * page Loading시 포커스 설정
	 * @return
	 */
	function initFocus() {
	    var formObj = document.form;
	    ComSetFocus(formObj.cmdt_cd);
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
			                style.height = GetSheetHeight(20) ;
			                
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;
							
							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
							
							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msAll;
							
							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;
							
							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 3, 100);
							
							var HeadTitle1 = "|Seq|Office|Month|Module|S/P Code|Cost Code|Cost Name|Account Code|Local CUR|Amount|Amount(USD)|";
							var headCount = ComCountHeadTitle(HeadTitle1);

							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);
							
							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false,false);
							
							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle1, true);
							
	                        //var prefix = "sheet1_";
							
							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,		daCenter,		false,		"ibflag");
							InitDataProperty(0,		cnt++ , dtSeq,					40,		daCenter,		false,		"Seq");
							InitDataProperty(0,		cnt++ , dtData,					60,	daCenter,			true,		"ofc_cd",			false,		"",		dfNone,					0,		false,	true);
							InitDataProperty(0,		cnt++ , dtData,					60,	daCenter,			true,		"gl_mon",			false,		"",		dfNone,					0,		false,	true);
							InitDataProperty(0,		cnt++ , dtData,					55,	daCenter,			false,		"mdl_cd",			false,		"",		dfNone,					0,		false,	true);
							InitDataProperty(0,		cnt++ , dtData,					70,	daCenter,			false,		"vndr_no",			false,		"",		dfNone,					0,		false,	true);
							InitDataProperty(0,		cnt++ , dtData,					70,	daCenter,			false,		"lgs_cost_cd",			false,		"",		dfNone,					0,		false,	true);
							InitDataProperty(0,		cnt++ , dtData,					200,	daLeft,			false,		"lgs_cost_nm",			false,		"",		dfNone,					0,		false,	true);
							InitDataProperty(0,		cnt++ , dtData,					100,	daCenter,			false,		"acct_cd",			false,		"",		dfNone,					0,		false,	true);
							InitDataProperty(0,		cnt++ , dtData,					70,	daCenter,			false,		"curr_cd",			false,		"",		dfNone,					0,		false,	true);
							InitDataProperty(0,		cnt++ , dtData,					100,	daRight,			false,		"curr_amt",			false,		"",		dfNullFloat, 			2,		false,	true);
							InitDataProperty(0,		cnt++ , dtData,					100,	daRight,			false,		"usd_amt",			false,		"",		dfNullFloat, 			2,		false,	true);
							InitDataProperty(0,		cnt++ , dtHidden,				100,	daLeft,			false,		"ym_tp_cd",			false,		"",		dfNone,					0,		false,	true);
							
							//카운트를 표시할 포지션 /0의 경우 비표시 
							CountPosition = 2; 
							//토탈카운트표시 
							CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
							
							WaitImageVisible=false;
					}
					break;


		}
	}
	
	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH:      //조회
			  
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST01;
				if(formObj.s_compare_mon_radio.checked){
					formObj.s_compare_mon.value = "3";
				} else {
					formObj.s_compare_mon.value = "1";
				}
				var sParam = FormQueryString(formObj);
				sheetObj.DoSearch("ESD_EAS_0319GS.do",sParam);
				ComOpenWait(false);
				break;
			        
			case IBDOWNEXCEL:   // 엑셀
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				sheetObj.Down2Excel(-1, false, false, true);
				break;
	    }
	}
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj,formObj,sAction){
		
	    switch(sAction) {
			case IBSEARCH: { // 조회
			    
				var ofcCd = formObj.s_ofc_cd.value;
				var ym  = formObj.s_ym.value;
				
				
				if(ofcCd.trim() == "" && ym.trim() == "") {
					ComShowCodeMessage("BKG06045" );
					return false;
				}

				break;
			}
			
			case IBDOWNEXCEL : { // 엑셀
				
				if(sheetObj.RowCount == 0) {
					ComShowCodeMessage('BKG00389');
					return false;
				}
				
				break;
			}
			
	    }
	    
	    return true;
	}
    
    
    /**
     * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnDblClick(sheetObj,Row,Col) {
        
    }
    
	
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (srcName == "brz_cmdt_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    	
    }
    
    /**
	 * HTML Control의 onclick이벤트 처리<br>
	 **/
	function obj_click(){
		var obj = event.srcElement;
		switch(obj.name) {	
			case "s_compare_mon_radio":
				//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
		}
	}
    
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {	
			case "s_mdl_cd":
				//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
		}
	}
	
	function s_rto_tp_cd_OnChange(comboObj,Index_Code, Text){   
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}	
	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		var formObj = document.form;
  		var txtRtoTpCd = formObj.s_rto_tp_cd.Code;
  		var txtRto = formObj.s_rto.value;
  		for (var i = sheetObj.HeaderRows ; i< sheetObj.RowCount + sheetObj.HeaderRows ; i++) {
  			var fColor = sheetObj.RgbColor(255, 0, 0);
  			if ( formObj.s_compare_mon_radio.checked && sheetObj.CellValue(i, "ym_tp_cd") == '1' && txtRto.length > 0 ) {
  				setAmtHighLight(sheetObj, formObj, "curr_amt", txtRto, i, txtRtoTpCd);
  			}
  			
  			//Total 항목의 Row 색상 변경
  			if ( sheetObj.CellValue(i, "ofc_cd") == 'TOTAL' ) {
  				sheetObj.RowBackColor(i) = sheetObj.RgbColor(245,226,240);
  			}
  			
  			//Comparison 체크시 3라인마다 ROW 배경색 변경
  			if( formObj.s_compare_mon_radio.checked ) {
	  			if ( ComIsNumber( Math.ceil(((i-0.9)/3)+1)/2) ) {
	  				if ( sheetObj.CellValue(i, "ofc_cd") == 'TOTAL' ) {
  	  					sheetObj.RowBackColor(i) = sheetObj.RgbColor(244,244,186);
	  				}else{
	  					sheetObj.RowBackColor(i) = sheetObj.RgbColor(226,245,240);
	  				}
  	  			}
  			}
  		}
  	}

	/* 개발자 작업  끝 */