/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0195.js
*@FileTitle : Total Loss No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : WanGyu Kim
*@LastVersion : 1.0
* 2009.09.15 WanGyu Kim
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
     * @class ees_mnr_0195 : ees_mnr_0195 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0195() {
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

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
	     var sheetObject2 = sheetObjects[1]; 
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				//달력
				case "rqst_dt_cal":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.rqst_dt_fr, formObject.rqst_dt_to, 'yyyy-MM-dd');
					break;

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,1);
					break;
				
				case "btn_OK":
					if(sheetObjects[0].FindCheckedRow("checkbox") == ""){ 
						ComShowCodeMessage("MNR00038","SELECT ");             	   
					} else {   
						comPopupOK();       	  
					} 
					break;
					
				
				case "btn_Close":
					window.close();
					break;
				
			} // end switch
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
    	// 버튼 설정
    	MnrWaitControl(true);

    	//IBSheet 초기화
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
		//Axon이벤트 초기화
		initControl();
	     if(window.dialogArguments != undefined)
	     {
	     	var formObject=document.form;
	     	if(window.dialogArguments.document.form.work_type!=undefined)
	     	{
	 	    	formObject.work_type.value=window.dialogArguments.document.form.work_type.value;
	     	}
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
                    style.height = 222;
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

                    var HeadTitle1 = "|Sel|Seq|Issue Date|Total Loss No|Issue Office|Responsible Office|Status";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,   40,     daCenter, 	true,  	"checkbox");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,	"Seq");
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	false,	"rqst_dt",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	false,	"ttl_lss_no",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,	"rqst_ofc_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	false,	"respb_ofc_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daLeft,		false,	"ttl_lss_sts_cd",	false,	"",	dfNone,	0,	false,	false);

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
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
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
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
	    } 
	}
    
    /**
     * 초기화 이벤트 OnLoad 가 끝나면 초기화 이벤트 실행
     * 
     * @param {Sheet}sheetObj 프로세스 처리될 시트오브젝트
     */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
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
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	    	// 초기화
	    	case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);
	    		
	    		// 모든 쉬트를 초기화
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
	    		
	    		// Only Loading
	    		if (sActionIdx == 0) {
		    		//쉬트 콤보 설정
					var sCondition = new Array (
						new Array("MnrGenCd","CD00039", "COMMON") 	//Status
					)             
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
					for(var i=0; i<comboList.length ; i++){
						if(comboList[i] != null){
							//Status
							if(i == 0) {
								var sheetComboText = "";  
								var sheetComboCode = "";
								var sheetComboDefault = "";
								for(var j = 0; j < comboList[i].length;j++){ 
									var tempText = comboList[i][j].split("|"); 
									sheetComboText +=  tempText[1] + "|";
									sheetComboCode +=  tempText[0] + "|";
									if(j ==0){
										sheetComboDefault = tempText[0];      	
									}
									//쉬크 콤보 값 세팅
									sheetObjects[0].InitDataCombo (0, "ttl_lss_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
								}
							} 
						}
					}
	    		}
	    		
	    		//초기값 설정
	    		formObj.rqst_ofc_cd.value	= rqstOfcCd;
	    		formObj.rqst_dt_fr.value	= ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
	    		formObj.rqst_dt_to.value	= ComGetNowInfo("ymd");
	    		formObj.rqst_dt_fr.focus();
	    		
	    		// 버튼 , 프로그레스바 설정 끝
	    		MnrWaitControl(false);
	    		sheetObj.WaitImageVisible = true;
	    		break;

	    	//조회
			case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0195GS.do",FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
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
            with(formObj){
            }
            return true;
        }
        return true;
    }
 	 
