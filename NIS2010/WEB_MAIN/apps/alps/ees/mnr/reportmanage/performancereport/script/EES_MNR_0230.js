/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0230.jsp
 *@FileTitle : ACEP Candidate Cntr List 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : 김완규 	
 *@LastVersion : 1.0     
 * 2009.10.22 김완규   
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
 * @class EES_MNR_0230 : EES_MNR_0230 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MNR_0230() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* ********* General Functions ************* */
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;

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
				//Date
				case "cur_dt_cal":
					var cal = new ComCalendar();
					cal.select(formObject.cur_dt, 'yyyy-MM-dd');
					break;
            
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break; 
				
				case "btn_Detail":
				    var selectedRow = sheetObject1.SelectRow;
					if(selectedRow < 0) {return;}
					var eqNo = sheetObject1.CellValue(selectedRow, "eq_no");
					//var eqNo = "SMCU8327625"; 
					ComOpenPopup('/hanjin/EES_MNR_0191.do?eq_no='+eqNo, 901, 495, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					break; 
				
				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1);	
					break;                   
				
            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
    			ComFuncErrMsg(e); 
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	// 버튼 설정
    	MnrWaitControl(true);
    	
    	//IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	
    	//IBSheet 초기화
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        //Axon이벤트 초기화
		initControl();
		
		//화면초기화
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
		
		//focus
		document.form.cur_dt.focus();
    }

    /**
     * IBCombo 기본 설정
     * @param {IBCombo} comboObj 초기설정될 콤보오브젝트
     * @param {Number} comboNo 콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
    	var cnt = 0;
    	var formObject = document.form

    	switch (comboNo) {
    	case 1:
    		with (comboObj) {
    			SetColAlign("center");
    			SetColWidth("25")
				UseAutoComplete = true;
				UseEdit = true;
				MaxLength = "2";
    		}
    		break;
    	
    	case 2:
    	case 3:
    		with (comboObj) {
    			SetColAlign("left");
    			SetColWidth("25")
    		}
    		break;
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
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정 
                    style.height = 423;    
					    
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
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) 
                    	 
                    var HeadTitle = "|Seq.|CNTR No.|TP/SZ|Location|Yard|W/O Creation Date|Recent Inspection Date|Next ACEP Date|Over Months";
											
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
							
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                   	InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  	false,	"ibflag",			false,	"", dfNone,     0,	false,  false);
                   	InitDataProperty(0, cnt++ , dtDataSeq,  	 40,    daCenter,  	false,	"seq", 				false,	"", dfNone,     0,	false,  false);
                   	InitDataProperty(0, cnt++ , dtData,  		120,   	daCenter,  	false,  "eq_no",			false,  "",	dfNone,     0,  false,	false);
                  	InitDataProperty(0, cnt++ , dtData,     	 60,	daCenter,  	false,  "eq_tpsz_cd",		false,  "", dfNone,     0,  false,  false);
                  	InitDataProperty(0, cnt++ , dtData, 		120,    daCenter,  	false,  "loc_cd", 			false,  "", dfNone,     0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,   		120,   	daCenter,  	false,  "yd_cd", 			false,  "", dfNone,		0,  false,  false);
                    InitDataProperty(0, cnt++ , dtHidden, 		120,    daCenter,   false,  "rpr_dt",	 		false,  "", dfTimeHm,   0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData, 		160,    daCenter,   false,  "rpr_rslt_dt",	 	false,  "", dfTimeHm,   0,  false,  false);
                	InitDataProperty(0, cnt++ , dtData,    		160,    daCenter,  	false,  "next_audit_dt",	false,  "", dfNone,     0,  false,  false);
					InitDataProperty(0, cnt++ , dtData,   		120,    daRight,  	false,  "over_month",		false,  "", dfNone,  	0,  false,  false);
					
					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
                }
                break;

        }
    }

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
    }
    
    /**
     * IBCombo Object를 배열로 등록
     * @param {IBCombo} combo_obj 배열로 등록될 IBCombo Object
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
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
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}	
	
	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }
	
	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');          
	            break;
			
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
	    } 
	}
    
	/** 
	 * COMBO 변경 이벤트
	 * ACEP Type 변경시 loc_cd 의 format 설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function acep_type_OnChange(comboObj, Index_Code, Text){
		var formObj = document.form;
		//ALL
		if(Index_Code == "A") {
			formObj.loc_cd.readOnly = true;
			formObj.loc_cd.className = "input2";
			formObj.loc_cd.removeAttribute("required");
		//ETC
		} else {
			formObj.loc_cd.readOnly = false;
			formObj.loc_cd.className = "input1";
			formObj.loc_cd.setAttribute("required","");
			formObj.loc_cd.focus();
			//Yard
			if(Index_Code == "YARD") {
				formObj.loc_cd.maxLength = "7";
			//ETC
			} else {
				formObj.loc_cd.maxLength = "5";
			}
		}
		formObj.loc_cd.value = "";
	}
	
    /**
     * Sheet1관련 프로세스 처리
     * 
     * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
     * @param {Form}formObj 프로세스 처리될 폼오브젝트
     * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	    	// 초기화
	    	case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);

	    		//쉬트 초기화
	    		sheetObjects[0].RemoveAll(); 

	        	//조건부 콤보데이타 초기화
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].RemoveAll();	
				}
	    		
				//(Month)콤보데이타 값을 세팅함
				for ( var i = 0; i < 30; i++) {
					formObj.month.InsertItem(i, i + 1, i + 1);
				}

				//조건부 콤보데이타 조회(Term,ACEP)
				var sCondition = new Array (
					new Array("MnrGenCd","CD00060", "COMMON") 	//Term Type
				   ,new Array("MnrGenCd","CD00061", "COMMON") 	//ACEP Type
				)             
				var comboList = MnrComSearchCombo(sheetObj,sCondition);
				//조건부 콤보데이타에 값을 세팅함        
				for(var i = 0; i < comboList.length;i++){
					if(comboList[i] != null){
						for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");    
							//Display[CODE_NAME]:Term Type
							if(i==0) {
								formObj.term_type.InsertItem(j, tempText[1] ,tempText[0]);
							
							//Display[CODE_NAME]:ACEP Type
							} else if(i==1) {
								formObj.acep_type.InsertItem(j, tempText[1] ,tempText[0]);
							}
						}
					}
				}
				formObj.term_type.InsertItem(0, "ALL" ,"A" );
				
				//초기값 설정
				formObj.cur_dt.value	= ComGetNowInfo("ymd"); //Date
				formObj.month.Code2 	= "1"; 		//Months after ACEP Audit
				formObj.term_type.Code2 = "A"; 		//Term Type
				formObj.acep_type.Code  = "RCC";	//ACEP Type
				
				// 버튼 , 프로그레스바 설정 끝
	    		MnrWaitControl(false);
	    		sheetObj.WaitImageVisible = true;
	    		break;

	    	//조회
			case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.WaitImageVisible = true;
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0230GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
				}
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		//조회시
		if(sAction==IBSEARCH){
			//Dataformat
			if (!ComChkValid(formObj)) {return false;}
			//Multi Combo 필수체크
			var month = ComGetObjValue(formObj.month);
			if(month=="") {
				ComShowCodeMessage("MNR00036","Months After ACEP Audit");
				formObj.month.focus();
			    return false;
			}
		}
    	return true;
    }
    
    
    function sheet1_OnDblClick(sheetObj, Row, Col) {
		var formObj = document.form;
//		var colNm = sheetObj.ColSaveName(Col);

		var eqNo = sheetObj.CellValue(Row, "eq_no");
		ComOpenPopup('/hanjin/EES_MNR_0191.do?eq_no='+eqNo, 901, 495, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
	}
    
    

