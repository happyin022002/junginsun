/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0107.js
*@FileTitle : DV Factor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.20 김완규
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
     * @class ess_mnr_0107 : ess_mnr_0107 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0107() {
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
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
//조회 클릭시 상태를 저장
var retrieveClick = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */	
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_Retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
	
					case "btn_Save":
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;
						
					case "btn_New":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						break;
						
					case "dpc_yr_cal":
						var cal = new ComCalendar();
						cal.setDisplayType('year');
						cal.select(formObject.eq_dpc_yr, 'yyyy');
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
    	//버튼 설정
    	MnrWaitControl(true);

        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
	    //html컨트롤 이벤트초기화
	    initControl();

		//초기화 버튼 이벤트 호출
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	    
		//포커스 지정
		var formObject = document.form;
		formObject.eq_dpc_yr.focus();
		
    }

  	/**
     * 시트 초기설정값, 헤더 정의
     * @param	{IBSheet}	sheetObj	초기설정될 시트오브젝트 
     * @param	{String}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "t1sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Seq.|TP/SZ|Description|Currency|Monthly Depreciation Rate(%)|Price";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, 	dtSeq,			50,		daCenter,	true,	"Seq");
                    InitDataProperty(0, cnt++, 	dtData,			170,	daCenter,	true,	"cd_id",		false,	"",	dfNone,			0,	false,	true);
                    InitDataProperty(0, cnt++, 	dtData,			400,	daLeft,		true,	"cd_desc",		false,	"",	dfNone,			0,	false,	true);
                    InitDataProperty(0, cnt++ , dtData,			180,	daCenter,	true,	"curr_cd",		false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			200,	daRight,	true,	"eq_dpc_rt",	false,	"",	dfNullFloat,	2,	true,	true,	2,	false);
                    InitDataProperty(0, cnt++ , dtData,			130,	daRight,	true,	"eq_init_prc",	true,	"",	dfNullInteger,	0,	true,	true,	11);
                    //HIDDEN데이터
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"eq_dpc_yr",	false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"eq_knd_cd",	false,	"",	dfNone,			0,	true,	true);
										
					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   

					CountPosition = 0;
               }
                break;

            case "t2sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Seq.|TP/SZ|Description|Currency|Monthly Depreciation Rate(%)|Price";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, 	dtSeq,			50,		daCenter,	true,	"Seq");
                    InitDataProperty(0, cnt++, 	dtData,			170,	daCenter,	true,	"cd_id",		false,	"",	dfNone,			0,	false,	true);
                    InitDataProperty(0, cnt++, 	dtData,			400,	daLeft,		true,	"cd_desc",		false,	"",	dfNone,			0,	false,	true);
                    InitDataProperty(0, cnt++, 	dtData,			180,	daCenter,	true,	"curr_cd",		false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			200,	daRight,	true,	"eq_dpc_rt",	false,	"",	dfNullFloat,	2,	true,	true,	2,	false);
                    InitDataProperty(0, cnt++, 	dtData,			130,	daRight,	true,	"eq_init_prc",	true,	"",	dfNullInteger,	0,	true,	true,	11);
                    //HIDDEN데이터
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"eq_dpc_yr",	false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"eq_knd_cd",	false,	"",	dfNone,			0,	true,	true);
					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   

					CountPosition = 0;
               }
                break;
                
            case "t3sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

					var HeadTitle1 = "|Seq.|TP/SZ|Description|Currency|Monthly Depreciation Rate(%)|Price";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++, 	dtSeq,			50,		daCenter,	true,	"Seq");
                    InitDataProperty(0, cnt++, 	dtData,			170,	daCenter,	true,	"cd_id",		false,	"",	dfNone,			0,	false,	true);
                    InitDataProperty(0, cnt++, 	dtData,			400,	daLeft,		true,	"cd_desc",		false,	"",	dfNone,			0,	false,	true);
                    InitDataProperty(0, cnt++, 	dtData,			180,	daCenter,	true,	"curr_cd",		false,	"",	dfNone,			0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			200,	daRight,	true,	"eq_dpc_rt",	false,	"",	dfNullFloat,	2,	true,	true,	2,	false);
                    InitDataProperty(0, cnt++, 	dtData,			130,	daRight,	true,	"eq_init_prc",	true,	"",	dfNullInteger,	0,	true,	true,	11);
                    //HIDDEN데이터
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"eq_dpc_yr",	false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daRight,	true,	"eq_knd_cd",	false,	"",	dfNone,			0,	true,	true);
										
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Container", -1 );
                    InsertTab( cnt++ , "Chassis", -1 );
                    InsertTab( cnt++ , "MG Set", -1 );
                }
             break;
         }
    }

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch
		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	    axon_event.addListenerForm  ('blur', 		'obj_deactivate',	document.form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_activate',    	document.form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress', 	'obj_keypress', 	document.form); 	
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
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
	 * HTML Control의 onkeypress 이벤트 <br>
	 **/
	function obj_keypress(){
	    obj = event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
			              
	    switch(obj.dataformat) {  
	        case "yyyy":  
				ComKeyOnlyNumber(obj); 
	            break;     
	    }         
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
			
			case IBCLEAR:      // 초기화
				//버튼 ,프로그레스바 설정
				sheetObj.WaitImageVisible = false;
				MnrWaitControl(true);

			    //조건부 초기화
				var formObject = document.form;
				formObject.eq_dpc_yr.value = "";
				//모든 쉬트를 초기화 	 
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll(); 
	            }    
				//조회버튼 클릭 초기화 	
				retrieveClick = 0;
				//====================================================================
				//공통코드 호출 시작
				//====================================================================
				var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind");
				for(var i = 0; i < arrXml.length; i++){ 
					sheetObjects[i].LoadSearchXml(arrXml[i]);
				}
				//필수항목 입력
				for(var i = 0; i < arrXml.length; i++){ 
					for(var j=1; j <=sheetObjects[i].RowCount; j++){
						sheetObjects[i].CellValue2(j, "curr_cd") 		= "USD";	//Currency
						sheetObjects[i].CellValue2(j, "eq_init_prc")	= 0;  		//Price
						if(i==0) {
							sheetObjects[i].CellValue2(j, "eq_dpc_rt") 	= 0.45;  	//Monthly Depreciation Rate(%)
							sheetObjects[i].CellValue2(j, "eq_knd_cd") = "U";   	//KindCode
						} else if (i==1) {
							sheetObjects[i].CellValue2(j, "eq_dpc_rt") 	= 0.45;  	//Monthly Depreciation Rate(%)
							sheetObjects[i].CellValue2(j, "eq_knd_cd") = "Z";		//KindCode
						} else if (i==2){
							sheetObjects[i].CellValue2(j, "eq_dpc_rt") 	= 0.55;  	//Monthly Depreciation Rate(%)
							sheetObjects[i].CellValue2(j, "eq_knd_cd") = "G";		//KindCode
						} else {
							ComShowCodeConfirm("MNR00028");
						}
					}
				}
				//====================================================================
				//버튼 ,프로그레스바 설정
				MnrWaitControl(false);
				sheetObj.WaitImageVisible = true;

                break;

            case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH01;
                if(validateForm(sheetObj,formObj,sAction)) {
					//다중조회
					var sXml = sheetObj.GetSearchXml("EES_MNR_0107GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					for(var i = 0; i < arrXml.length; i++){ 
						sheetObjects[i].LoadSearchXml(arrXml[i]);
					}
					retrieveClick = 1;
			    }
                break;

            case IBSAVE:        //저장
                if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					var sParam = ComGetSaveString(sheetObjects);
				    if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    var sXml = sheetObjects[0].GetSaveXml("EES_MNR_0107GS.do", sParam);
				    sheetObjects[0].LoadSaveXml(sXml);     
				    sheetObjects[1].LoadSaveXml(sXml);   
				    sheetObjects[2].LoadSaveXml(sXml);
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
			var eqDpcYrObj = formObj.eq_dpc_yr; //기준연도 
			
			//조회시 체크
			if(sAction==IBSEARCH) {
				if(!checkMandatory(eqDpcYrObj)){return false;}	//필수
			}
			
			//저장시 체크
			if(sAction==IBSAVE) {
				if(!checkMandatory(eqDpcYrObj)){return false;}	//필수
				//if(!MnrCheckYear(eqDpcYrObj)){return false;}  		//날짜포맷
				
				//조회하지 않고 저장하는  경우
				if(retrieveClick==0) {
					if(!ComShowCodeConfirm("MNR00160")){return false;} //저장의사 확인
					setGridEqDpcYr(eqDpcYrObj); //기준연도 입력
					
				//조회한후  저장하는 경우
				} else {
					var eqDpcYrCond = eqDpcYrObj.value;     						//조건부 기준연도
					var eqDpcYrGrid = sheetObjects[0].CellValue(1, "eq_dpc_yr");	//그리드 기준연도
					
					//조회한 후 조건부 기준연도를 수정하고 저장하는  경우:조건부의 기준연도의 데이터에  이미 조회된 데이터가 복사됨
					if(eqDpcYrCond!=eqDpcYrGrid) { 
						if(!ComShowCodeConfirm("MNR00160")){return false;} //저장의사 확인
						setGridEqDpcYr(eqDpcYrObj); //기준연도 입력
					}
				}
			}
        }
        return true;
    }


/* ********* User Functions ************* */
	/** 
	 * 필수값 체크
	 * @param	{Object}	obj		Form의 element오브젝트
	 * @return  {Boolean}   true/false
	 */
    function checkMandatory(obj) {
		if(ComIsEmpty(obj)) {  
		    ComShowCodeMessage("MNR00003");
		    obj.focus();
		    return false;
		}
		return true;
	}

	/** 
	 * 기준연도 입력
	 * 모든 시트에 조건부의 기준연도를 입력한다.
	 * @param	{Object}	obj		Form의 element오브젝트
	 */
	function setGridEqDpcYr(obj) {
		for(var i = 0; i < sheetObjects.length; i++){ 
			for(var j=1; j <=sheetObjects[i].RowCount; j++){
				sheetObjects[i].CellValue2(j, "eq_dpc_yr") = obj.value;
			}
		}
	}


/* ********* Event Functions ************* */
	/** 
	 * 저장후 결과메세지 표시
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") { 
			ComShowCodeMessage("MNR00023",'');   
		} else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		}       
	}     
	
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {
		selectedTab = nItem;
        var objs = document.all.item("tabLayer");
    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";
    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }
	

/* 개발자 작업  끝 */