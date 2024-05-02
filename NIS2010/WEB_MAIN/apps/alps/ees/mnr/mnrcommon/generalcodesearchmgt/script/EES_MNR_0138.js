/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0138.js
*@FileTitle : Depreciated Value Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.28 김완규
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
     * @class ess_mnr_0138 : ess_mnr_0138 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0138() {
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
	var comboValue = "U";
	
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
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
                //새로고침                
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;

                //달력
				case "total_loss_date_cal":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
					cal.select(formObject.total_loss_date, 'yyyy-MM-dd');
	                break;
					
				//멀티입력
				case "eq_no_multi":
				    rep_Multiful_inquiry("eq_no");
					break;
				
				//인쇄
				case "btn_Print":
					doActionIBSheet(sheetObject1,formObject,"PRINT");
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
		
		//초기화 이벤트
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);	
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
                    style.height = 442;
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

					var HeadTitle1 = " |EQ No.|Currency|Depreciated Value|Manufactured Date|TP/SZ|Owner/Lessor";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"eq_no",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"dv_cur",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			170,	daRight,	true,	"dv_value",		false,	"",	dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,	"manu_dt",		false,	"",	dfDateYmd,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"eq_tpsz_cd",	false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,	"lessor_nm",	false,	"",	dfNone,			0,	false,	false);
					//Hidden
					InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		false,	"eq_type");
					InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		false,	"total_loss_date");
															
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
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
		//** Date 구분자 **/
    	DATE_SEPARATOR = "-";
		
	    axon_event.addListenerForm  ('blur', 		'obj_deactivate',	form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_activate',    	form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', 	form);	//- 키입력 할때
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
	 * IBCombo Object를 배열로 등록
	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj; 
 	}
	
	/**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
		ComChkObjValid(event.srcElement);
	}	
	
	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
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
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function combo1_OnChange(comboObj,Index_Code, Text){
		comboValue = comboObj.Code;    
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
				
	        	//콤보데이타 초기화
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].RemoveAll();	
				}
				//콤보데이타 조회
				var sCondition = new Array (
					new Array("MnrGenCd","SELHO","CUSTOM9") //EQ Type
				)             
				var comboList = MnrComSearchCombo(sheetObj,sCondition);
				//콤보데이타에 값을 세팅함        
				for(var i = 0; i < comboList.length;i++){
					if(comboList[i] != null){
						for(var j = 0; j < comboList[i].length;j++){
							var tempText = comboList[i][j].split("|");    
							comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
						}
					}
				} 
				comboObjects[0].Code = "U";              			
				//콤보이외의 조회조건 값 초기화
				formObj.eq_no.value = "";
				formObj.total_loss_date.value = ComGetNowInfo("ymd");
				//모든 쉬트를 초기화 	 
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll(); 
	            }
				//콤보에 포커스 주기    
				comboObjects[0].focus();
				
				//버튼 ,프로그레스바 설정
				MnrWaitControl(false);
				sheetObj.WaitImageVisible = true;
				
				break;
				
			//조회
        	case IBSEARCH:      
				sheetObj.WaitImageVisible = true;

				if(validateForm(sheetObj,formObj,sAction)) {
					var eqType 			= 	comboValue;
					var eqNo   			= 	formObj.eq_no.value; //"SMCU7830661";
					var totalLossDate	=	formObj.total_loss_date.value;  //"2006-11-03";
					
					//====================================================================
					//공통함수 EQ GEN INFO 호출 
					//====================================================================
					var arrXml = MnrComEqGenInfoSearch(sheetObj,eqType,eqNo,totalLossDate);
					//====================================================================
					sheetObjects[0].LoadSearchXml(arrXml);
				}
                break;
                
            //인쇄
        	case "PRINT":
        		if(validateForm(sheetObj,formObj,sAction)) {
        			var eqType			= sheetObj.CellValue(sheetObj.selectRow, "eq_type");
        			var eqNo 			= sheetObj.CellValue(sheetObj.selectRow, "eq_no");
        			var totalLossDate	= sheetObj.CellValue(sheetObj.selectRow, "total_loss_date");
        			var rdParam = '/rv usr_id['+ usrId +'] eq_type['+ eqType +'] eq_no['+ eqNo +'] total_loss_date['+ totalLossDate +']';
        			
        			formObj.com_mrdPath.value = 'apps/alps/ees/mnr/mnrcommon/generalcodesearchmgt/report/EES_MNR_0233.mrd';
        			formObj.com_mrdArguments.value = rdParam;
        			ComOpenRDPopup();
        		}
        		break;
        }
    }

  	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSEARCH){
				 if (!ComChkValid(formObj)) return false;
			} else if(sAction=="PRINT") {
				if(sheetObj.RowCount < 1) {
					ComShowCodeMessage("MNR00310");
					return false;
				}
			}
        }
        return true;
    }


	/* ********* User Functions ************* */
	/** 
	 * rep_Multiful_inquiry의 리턴처리 메서드
	 * @param	{Array}		rowArray	반환되는 Array
	 * @param	{String}	return_val	반환되는 form element명
	 */
	function getMnr_Multi(rowArray,return_val) {
 		var formObj = document.form; 
 		var tempText = "";      
 		//초기화     
		eval("document.form." + return_val + ".value = '';"); 
 
 		for(var i=0; i<rowArray.length; i++) {     
 			tempText +=  rowArray[i] + ',';      
 		}     
 		//마지막에 ,를 없애기 위함	   	   
 		tempText = MnrDelLastDelim(tempText);	
 		     
 		eval("document.form." + return_val + ".value = '" + tempText + "';"); 
 	} 
	