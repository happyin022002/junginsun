/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_mnr_0002.js
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.04.27 김완규
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.14 김상수 [CHM-201006047-01] ALPS MNR-> Code 조회 권한 조정 건
*                   (사용자 Office코드가 본사(장비팀)일때만 저장가능하도록 수정)
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
     * @class ess_mnr_0002 : ess_mnr_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0002() {
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
	var comboValue = "All";
	//쉬트 클릭시 상태를 저장 
	var sheetClicks = new Array(0,0,0);
	//조회 클릭시 상태를 저장
	var retrieveClick = 0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	
	// 로그인 유저의 Office 레벨 : HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴 (CoMnr.js에서
	// MnrOfficeLevel 함수에 의해 셋팅)
	var strMnrOfficeLevel = "";
	
	document.onclick = processButtonClick;

	/****************************************************************************************
	 * 2010.09.14 이석준 [ ] Office Level을 구하기 위해서 MnrOfficeLevel함수 추가
	 *                      Save Button 처리를 위해서 setSaveBtnDisplay 추가
	 ****************************************************************************************/	
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//버튼 설정
    	MnrWaitControl(true);

		//Sheet 초기화
        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i + 1);

            ComEndConfigSheet(sheetObjects[i]);
			
			//상태 초기화
			sheetClicks[i] = 0; 
        }
   	 	//IBMultiCombo초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
 	    
		// Office Level 조회 및 전역변수(strMnrOfficeLevel)에 세팅
		MnrOfficeLevel(currOfcCd, rhqOfcCd);
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        setSaveBtnDisplay();
		comboObjects[0].focus();
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
	 * @param    {IBSheet}	sheet_obj	배열로 등록될 IBSheet Object
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
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
			        SetColAlign("left|left");        
			        SetColWidth("10|90")   
		        }
	            break;
	     } 
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

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 402;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Sel|Code|Name";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	false,		"del_chk");
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"eq_cmpo_cd",				true,	"",	dfNone,	0,	false,	true,	2,	true);
					InitDataProperty(0, cnt++ , dtData,			70,		daLeft,		true,		"eq_cmpo_nm",				true,	"",	dfNone,	0,	true,	true,	200);
					
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_prnt_cmpo_cd",			false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_prnt_cmpo_grp_tp_cd",	false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_cmpo_num_iso_cd",		false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_cmpo_grp_tp_cd",		false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"cntr_cmpo_flg",			false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"chss_cmpo_flg",			false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"mgst_cmpo_flg",			false,	"",	dfNone,	0,	false,	false); 
 							                   	
					//데이터 Validation
					InitDataValid(0,  "eq_cmpo_cd", vtEngUpOther,"0123456789");  
											
					MultiSelection = false;
					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
					
					CountPosition = 0;
				}
		    	break;
	         		
            case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 402;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Sel|Code|Name";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	false,		"del_chk");
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"eq_cmpo_cd",				true,	"",	dfNone,	0,	false,	true,	3,	true);
					InitDataProperty(0, cnt++ , dtData,			70,		daLeft,		true,		"eq_cmpo_nm",				true,	"",	dfNone,	0,	true,	true,	200);
					
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_prnt_cmpo_cd",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_prnt_cmpo_grp_tp_cd",	false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_cmpo_num_iso_cd",		false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_cmpo_grp_tp_cd",		false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"cntr_cmpo_flg",			false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"chss_cmpo_flg",			false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"mgst_cmpo_flg",			false,	"",	dfNone,	0,	false,	false); 	
																					
					//데이터 Validation
					InitDataValid(0,  "eq_cmpo_cd", vtEngUpOther,"0123456789");  

					MultiSelection = false;
					//SELECT 로우 배경색       
					SelectionMode = smSelectionRow;    
					SelectHighLight = true;            
					SelectFontBold = false;          
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);   
					
					CountPosition = 0;
                }
                break;
		         		
            case "sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 402;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Sel|Code|ISO|Name|U|Z|G|Description";
					var headCount = ComCountHeadTitle(HeadTitle1);	
							
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);	
												
                    //데이터속성        [ROW, COL,    DATATYPE,    WIDTH,    DATAALIGN, COLMERGE,     SAVENAME,                KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	false,		"del_chk")
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"eq_cmpo_cd",				true,	"",	dfNone,	0,	false,	true,	3,	true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"eq_cmpo_num_iso_cd",		true,	"",	dfNone,	0,	false,	true,	5);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"eq_cmpo_nm",				false,	"",	dfNone,	0,	true,	true,	200);
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,		"cntr_cmpo_flg");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,		"chss_cmpo_flg");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,		"mgst_cmpo_flg");
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"eq_cmpo_desc",				false,	"",	dfNone,	0,	true,	true,	500);
																													
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_prnt_cmpo_cd",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_prnt_cmpo_grp_tp_cd",	false,	"",	dfNone,	0,	false,	false); 
					InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		"eq_cmpo_grp_tp_cd",		false,	"",	dfNone,	0,	false,	false); 
																						
					//데이터 Validation
					InitDataValid(0,  "eq_cmpo_cd", vtEngUpOther,"0123456789");  
					InitDataValid(0,  "eq_cmpo_num_iso_cd", vtNumericOnly);
						
					MultiSelection = false;
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
							
					case "btn_New":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						setSaveBtnDisplay();
						break;
	
					case "btn_Save":
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;
							
					case "btn_RowAdd1":
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
						break;
							
					case "btn_RowDel1":
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
						break;
							
					case "btn_Excel1":
						 sheetObject1.SpeedDown2Excel(-1);    
						break;
							
					case "btn_RowAdd2":
						doActionIBSheet1(sheetObject2,formObject,IBINSERT);
						break;
							
					case "btn_RowDel2":
						doActionIBSheet1(sheetObject2,formObject,IBDELETE);
						break;
							
					case "btn_Excel2":
						 sheetObject2.SpeedDown2Excel(-1);    
						break;
													
					case "btn_RowAdd3":
						doActionIBSheet2(sheetObject3,formObject,IBINSERT);
						break;
							
					case "btn_RowDel3":
						doActionIBSheet2(sheetObject3,formObject,IBDELETE);
						break;

					case "btn_Excel3":
						 sheetObject3.SpeedDown2Excel(-1);    
						break;
													
					case "btn_Grouping3":
						openPopup();
						break;
						
					default:
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
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBCLEAR:      //초기화
				//버튼 ,프로그레스바 설정
				sheetObj.WaitImageVisible = false;
				MnrWaitControl(true);
				
	        	//콤보데이타 초기화
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].RemoveAll();	
				}
				//콤보데이타 조회
				var sCondition = new Array (      
					new Array("MnrEqCmpoCd","1","COMMON") //Component Code Level 1
				)             
				var comboList = MnrComSearchCombo(sheetObj,sCondition);
				//콤보데이타에 값을 세팅함        
				for(var i = 0; i < comboList.length;i++){
					comboObjects[i].RemoveAll();   
					comboObjects[i].InsertItem(0, 'All | All Retrieve' ,'0'); 
					
					if(comboList[i] != null){
						for(var j = 0; j < comboList[i].length;j++){ 
							comboObjects[i].InsertItem(j + 1, comboList[i][j] ,j + 1 + '');
						}           	
					}
					comboObjects[i].Code = 0;              			
				}  
				//모든 쉬트를 초기화 	 
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll(); 
					sheetClicks[i] = 0;
	            }
				//조회버튼 클릭 초기화 	
				retrieveClick = 0;
				
				//버튼 ,프로그레스바 설정
				MnrWaitControl(false);
				sheetObj.WaitImageVisible = true;
				
				break;
	
			case IBSEARCH:      //조회
				sheetObj.WaitImageVisible = true;
				formObj.f_cmd.value = SEARCH01;
				formObj.f_type.value = "grid";
				formObj.key_value.value = comboValue;         

				if(validateForm(sheetObj,formObj,sAction)) {

					//다중조회
					var sXml = sheetObj.GetSearchXml("EES_MNR_0002GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					for(var i = 0; i < arrXml.length; i++){ 
						sheetObjects[i].Redraw = false;    
						if(i > 0) {
							sheetObjects[i].WaitImageVisible = false;	
						}  
						sheetObjects[i].LoadSearchXml(arrXml[i]);
						sheetObjects[i].Redraw = true; 
					}
					//시트 초기 조회 sheet1만 보여준다.           
					for(var i = 1; i <= sheetObj.RowCount; i++){ 
						sheetObj.RowHidden(i) = false;          		
					}
				}
				retrieveClick = 1;
				break;
	
			case IBSAVE:        //저장
	            if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					var sParam = ComGetSaveString(sheetObjects);
				    if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    var sXml = sheetObjects[0].GetSaveXml("EES_MNR_0002GS.do", sParam);
				    sheetObjects[0].LoadSaveXml(sXml);     
				    sheetObjects[1].LoadSaveXml(sXml);   
				    sheetObjects[2].LoadSaveXml(sXml);
				}
	            break;

			case IBINSERT:      // 입력
			    if(validateForm(sheetObj,formObj,sAction)) {
				    var Row = sheetObj.DataInsert(-1);
					sheetObj.CellValue2(Row, "eq_cmpo_grp_tp_cd") = "1";
					sheetObj.CellValue2(Row, "eq_prnt_cmpo_grp_tp_cd") = "N";
					sheetObj.CellValue2(Row, "eq_prnt_cmpo_cd") = "N";
					sheetObj.CellValue2(Row, "eq_cmpo_num_iso_cd") = "00000";
					//set Focus
					sheetObj.SelectCell(Row, "eq_cmpo_cd"); 
				}
				break;

			case IBDELETE:      // 삭제
			    if(validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == 'sheet1') {   
						ComRowHideDelete(sheetObj, "del_chk");
			   	   	}
					for(var i = 1; i < sheetObjects.length; i++){ 
						MnrAllSheetHidden(sheetObjects[i]); 
					}
				}    
				break;
        }
    }

  	/**
     * Sheet2관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBINSERT:      // 입력
				if(sheetClicks[0] == 0 || (sheetObjects[0].CellValue(sheetClicks[0],"eq_cmpo_cd") == '')){         
					ComShowCodeMessage("MNR00143","EQ Component");                  						
				} else {
				    var Row = sheetObj.DataInsert(-1);
					sheetObj.CellValue2(Row, "eq_cmpo_grp_tp_cd") = "2";
					sheetObj.CellValue2(Row, "eq_prnt_cmpo_grp_tp_cd") = "1";
					sheetObj.CellValue2(Row, "eq_prnt_cmpo_cd") = sheetObjects[0].CellValue(sheetClicks[0], "eq_cmpo_cd");
					sheetObj.CellValue2(Row, "eq_cmpo_num_iso_cd") = sheetObjects[0].CellValue(sheetClicks[0], "eq_cmpo_cd")+"000";
					//set Focus
					sheetObj.SelectCell(Row, "eq_cmpo_cd");
				}
				break;

			case IBDELETE:      // 삭제
			    if(validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == 'sheet2') { 
						ComRowHideDelete(sheetObj, "del_chk");
			   	   	}
					for(var i = 2; i < sheetObjects.length; i++){ 
						MnrAllSheetHidden(sheetObjects[i]); 
					}
				}   
				break;
        }
    }

  	/**
     * Sheet2관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBINSERT:      // 입력
				if(sheetClicks[1] == 0 || (sheetObjects[1].CellValue(sheetClicks[1], "eq_cmpo_cd") == '')){  
					ComShowCodeMessage("MNR00143","EQ Component");                 						
				} else {
				    var Row = sheetObj.DataInsert(-1);
					sheetObj.CellValue2(Row, "eq_cmpo_grp_tp_cd") = "3";
					sheetObj.CellValue2(Row, "eq_prnt_cmpo_grp_tp_cd") = "2";
					sheetObj.CellValue2(Row, "eq_prnt_cmpo_cd") = sheetObjects[1].CellValue(sheetClicks[1], "eq_cmpo_cd");
					//set Focus
					sheetObj.SelectCell(Row, "eq_cmpo_cd");
				}
				break;

			case IBDELETE:      // 삭제
				if(validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == 'sheet3') {   
						ComRowHideDelete(sheetObj, "del_chk");	
			   	   	}
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
			//조회시
			if (sAction==IBSEARCH) {
				for (var i=0; i<sheetObjects.length; i++){
					if(sheetObjects[i].IsDataModified){
						if(!ComShowCodeConfirm("MNR00007")){return false;}
					}
				}				
			}
			else if(sAction==IBSAVE) {
				//저장시 각시트별 중복체크
				for (var i=0; i<sheetObjects.length; i++){
					
					var Row = sheetObjects[i].ColValueDup("eq_cmpo_cd|eq_prnt_cmpo_cd|eq_cmpo_num_iso_cd");
					if(sheetObjects[i].IsDataModified){
						if(Row>0){
							ComShowCodeMessage("MNR00006",i + 1 + "th sheet of " + Row + " row ");
							sheetObjects[i].CellValue2(Row,"eq_cmpo_cd") = "";   
							sheetObjects[i].SelectCell(Row, "eq_cmpo_cd", true);  
							return false;
						}
					}
				}
			}
			else if(sAction==IBINSERT){
				//입력시 조회여부 체크
				if(retrieveClick==0){
					ComShowCodeMessage("MNR00147"); 
					return false;
				}
			}
			else if(sAction==IBDELETE){
				//삭제시 대상행 존재여부 체크
				var checkRow = sheetObj.FindCheckedRow(1);
				if(checkRow=='') {
					ComShowCodeMessage("MNR00150");
					return false;
				} 
			}
        }
        return true;
    }
	
	
/* ********* User Functions ************* */
	/** 
	 * 모든 시트 감추기
	 * @param    {IBSheet}	sheetObj	보이지 않게 할 시트
	 */
	function MnrAllSheetHidden(sheetObj){ 
		for (var idx=1; idx <= sheetObj.RowCount; idx++){
			sheetObj.RowHidden(idx) = true;   	 
		}	
	}
	
	/** 
	 * 클릭 이벤트 발생시 각 시트 필터링
	 * 시트가 여러개일시 시트의 프라이머리키와 포린키가 동일할경우만 사용 
	 * @param	{Number}	sheetIdx	시트번호
	 * @param	{String}	keyValue	상위 시트의 키값
	 * @param	{String}	foreginKey	하위 시트의 비교값
	 */
	function MnrSheetFiltering(sheetIdx,keyValue,foreginKey){ 
		for (var idx=1; idx <= sheetObjects[sheetIdx].RowCount; idx++){
			if(sheetObjects[sheetIdx].CellValue(idx,foreginKey) == keyValue){
				sheetObjects[sheetIdx].RowHidden(idx) = false;   
			} else {  
				sheetObjects[sheetIdx].RowHidden(idx) = true; 
			}   
		}	 	    				  
	}

	/** 
	 * SHEET3의 Grouping버튼 클릭시 팝업호출
	 */
    function openPopup() {
		var eqCmpoCd 	= "";  //EQ Component Code
		var eqCmpoNm 	= "";  //EQ Component Name
		var eqCmpoDesc	= "";  //Description
		eqCmpoCd 	= sheetObjects[2].CellValue(sheetClicks[2],"eq_cmpo_cd");
		eqCmpoNm 	= sheetObjects[2].CellValue(sheetClicks[2],"eq_cmpo_nm");
		eqCmpoDesc	= sheetObjects[2].CellValue(sheetClicks[2],"eq_cmpo_desc");
		if((sheetClicks[2] == 0 || eqCmpoCd == '' )){         
			ComShowCodeMessage("MNR00036","EQ Component");
			return;					                  						
		}
        ComPostOpenWindow('/hanjin/EES_MNR_0145.do?eqCmpoCd='+eqCmpoCd+'&eqCmpoDesc='+eqCmpoDesc+'&eqCmpoNm='+eqCmpoNm+'&strMnrOfficeLevel='+strMnrOfficeLevel, 'win1', 'width=1024,height=480');
    }
   
/* ********* Event Functions ************* */
	/** 
	 * 저장후 결과메세지 표시
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") { 
			ComShowCodeMessage("MNR00023",'');   
		} else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		}       
	}     
	
	/** 
	 * SHEET1 클릭 이벤트
	 * @param	{IBSheet}	sheetObj	클릭한 시트 오브젝트
	 * @param	{Number}	Row			클릭한 시트의 ROW
	 * @param	{String}	Col			클릭한 시트의 컬럼코드
	 */
	function sheet1_OnClick(sheetObj,Row,Col){
		sheetClicks[0] = Row;
		var keyValue = sheetObj.CellValue(Row,"eq_cmpo_cd");
		for(var i = 1; i < sheetObjects.length; i++){   
			MnrAllSheetHidden(sheetObjects[i]); 
			sheetClicks[i] = 0;                         	
		}    
		MnrSheetFiltering(1,keyValue,"eq_prnt_cmpo_cd");
	}
	
	/** 
	 * SHEET2 클릭 이벤트
	 * @param	{IBSheet}	sheetObj	클릭한 시트 오브젝트
	 * @param	{Number}	Row			클릭한 시트의 ROW
	 * @param	{String}	Col			클릭한 시트의 컬럼코드
	 */
	function sheet2_OnClick(sheetObj,Row,Col){
		sheetClicks[1] = Row;
		var keyValue = sheetObj.CellValue(Row,"eq_cmpo_cd");
		for(var i = 2; i < sheetObjects.length; i++){   
			MnrAllSheetHidden(sheetObjects[i]);
			sheetClicks[i] = 0;                          	
		}    
		MnrSheetFiltering(2,keyValue,"eq_prnt_cmpo_cd");
	}

	/** 
	 * SHEET3 클릭 이벤트
	 * @param	{IBSheet}	sheetObj	클릭한 시트 오브젝트
	 * @param	{Number}	Row			클릭한 시트의 ROW
	 * @param	{String}	Col			클릭한 시트의 컬럼코드
	 */
	function sheet3_OnClick(sheetObj,Row,Col){
		sheetClicks[2] = Row;
	}

	/** 
	 * COMBO 변경 이벤트
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function combo1_OnChange(comboObj,Index_Code, Text){
		comboValue = comboObj.GetText(Index_Code,0);    
	} 
	/****************************************************************************************
	 * 2010.09.14 이석준 [ ] 본사이외의 office가 들어올때 Save Button Disable처리
	 ****************************************************************************************/	
	/**
	 * 저장버튼 Display 설정
	 * 로그인한 OFFICE 의 LEVEL 이  L1 일 때만 Display 시키고 
	 * 나머지는  Disalbe 시킨다. 
	 * @return
	 */
	function setSaveBtnDisplay() {
		if(strMnrOfficeLevel=="L1") {
			ComBtnEnable("btn_Save");
		} else {
			ComBtnDisable("btn_Save");
		}
	}
	

/* 개발자 작업  끝 */