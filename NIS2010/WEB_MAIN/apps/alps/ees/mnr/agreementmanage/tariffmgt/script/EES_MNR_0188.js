/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0188.js
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.02 김완규
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
     * @class ees_mnr_0188 : ees_mnr_0188 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0188() {
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
/* ********* General Functions ************* */

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */	
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	    var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				//조회
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;

				//새로고침
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					break;

				//적용
				case "btn_Ok":
					if(sheetObj.FindCheckedRow("checkbox") == ""){ 
						ComShowCodeMessage("MNR00038","SELECT ");             	   
					} else {   
						comPopupOK();       	  
					}                  
					break;

				//닫기
				case "btn_Close":
				    window.close();
					break;

				//달력
				case "cre_dt_cal":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.cre_dt_fr, formObject.cre_dt_to, 'yyyy-MM-dd');
					break;
					
			}
    	}catch(e) {
    		if( e == "[object Error]") {     
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
    	//버튼 설정
    	MnrWaitControl(true);

        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		//IBMultiCombo초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }

		//html컨트롤 이벤트초기화
		initControl();
        
		//화면 초기화
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }

  	/**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트 
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
	    var cnt  = 0 ;
	    var formObject = document.form
	   
	    switch(comboNo) {
	    	case 1: 
	            with (comboObj) { 
			       SetColAlign("left");         
				   DropHeight = 160;  
		        }
	            break;
	     } 
	}

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param	{IBSheet}	sheetObj	초기설정될 시트오브젝트 
     * @param	{String}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
				
        switch(sheetID) {
        	case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 332;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

		    		var HeadTitle1 = "|Sel|Seq|Tariff No|Tariff Type|Service Provider\nCode|Service Provider\n Name|EQ Type|Status|Eff.From|Unit|Currency|Creation Date|Office|Creation User|Agreement No";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,   25,     daCenter,	true,  	"checkbox");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,	"Seq");
					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	false,	"trf_no",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,		85,		daLeft,		false,	"mnr_trf_knd_cd",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"vndr_seq",    		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		false,	"vndr_nm",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daLeft,		false,	"eq_knd_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,		110,	daLeft,		false,	"mnr_trf_sts_cd",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"eff_dt",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,		30,		daLeft,		false,	"mnr_meas_ut_cd",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"curr_cd",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"cre_dt",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daLeft,		false,	"rqst_ofc_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			85,		daLeft,		false,	"cre_usr_nm",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,	"agmt_no",			false,	"",	dfNone,	0,	false,	false);

					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   

					CountPosition = 0;
                }
	  			break;
        }
    }
	
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_deactivate',	form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_activate',    	form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', 	form);	//- 키입력 할때
    }

	/** 
	 * IBCombo Object를 배열로 등록
	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj; 
 	}

	/** 
	 * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
	 * @param    {IBSheet}	sheet_obj	배열로 등록될 IBSheet Object
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
        ComChkObjValid(event.srcElement); 		   
	}	

	/**
     * HTML Control의 onfocus이벤트에서 Validation을 체크한다. <br>
     **/
	function obj_activate(){   
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
	        case "ymd":   
				ComKeyOnlyNumber(obj); 
	            break;     
	    }         
	}
	
	/** 
	 * Sheet1 더블클릭했을 때 발생하는 Event
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		sheetObj.CellValue(Row, "checkbox") = "1";  //더블클릭한 Row를 check in
		comPopupOK();
	}
	
  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			
			//초기화
			case IBCLEAR:
				//버튼 ,프로그레스바 설정
				sheetObj.WaitImageVisible = false;
				MnrWaitControl(true);

			    //조건부 값 초기화       
				formObj.cre_dt_fr.value = ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
			    formObj.cre_dt_to.value = ComGetNowInfo("ymd");
				
				//조건부 콤보데이타 초기화
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].RemoveAll();	
				}
				//쉬트 콤보데이타 조회
				var sCondition = new Array (      
					new Array("MnrGenCd","CD00002", "COMMON"),	//EQ Type
					new Array("MnrGenCd","CD00010", "COMMON"),	//UnitOfMass
					new Array("MnrGenCd","CD00007", "COMMON"),	//Tariff Status
					new Array("MnrGenCd","CD00011", "COMMON")	//Tariff Kind(STD,LCL)
				)             
				var comboList = MnrComSearchCombo(sheetObj,sCondition);
				//쉬트 콤보데이타에 값을 세팅함 
				var sheetComboText = "";  
				var sheetComboCode = "";
				var sheetComboDefault = "";
				//쉬트 콤보 SAVE_NAME
				var comboSaveNames = new Array();
				comboSaveNames[0] = "eq_knd_cd";
				comboSaveNames[1] = "mnr_meas_ut_cd";
				comboSaveNames[2] = "mnr_trf_sts_cd";
				comboSaveNames[3] = "mnr_trf_knd_cd";

				for(var i = 0; i < comboList.length;i++){
				 	if(comboList[i] != null){ 
				 		//쉬트 콤보
				 		for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");    
							 
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							if(j ==0){
								sheetComboDefault = tempText[0];      	
							}  
						} 
						sheetObj.InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode,sheetComboDefault); 
                        
						//조건부 콤보
						if(i==3) {
    						for(var j = 0; j < comboList[i].length;j++){ 
    							var tempText = comboList[i][j].split("|");    
    							document.form.combo1.InsertItem(j, tempText[1] ,tempText[0]);
    						}
                        }
					}                             
				}
				comboObjects[0].InsertItem(0, 'All Retrieve' ,'All');
				//쉬트 콤보를 설정   폼 콤보와 동일하여 여기서 설정한다.
				if (sheetComboText != "") {
			        sheetComboText = sheetComboText.substr(0, sheetComboText.length -1);	
				}
				if (sheetComboCode != "") {
			        sheetComboCode = sheetComboCode.substr(0, sheetComboCode.length -1);
				}
				
				//모든 쉬트를 초기화 	 
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll(); 
	            }

				//콤보초기값 설정
				comboObjects[0].Code = formObj.mnr_trf_knd_cd.value;           	
                comboObjects[0].Enable = false;

				//포커스 설정
				formObj.cre_dt_fr.focus();
				
				//조회
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				
				//버튼 ,프로그레스바 설정
				MnrWaitControl(false);
				sheetObj.WaitImageVisible = true;
				break;
			
			//조회
			case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					formObj.mnr_trf_knd_cd.value = ComGetObjValue(comboObjects[0]);
					sheetObj.DoSearch4Post("EES_MNR_0188GS.do",FormQueryString(formObj));
				}
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }

	/* 개발자 작업  끝 */