/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0513.js
*@FileTitle : SHA Tide Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.06 김종옥
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
     * @class vop_vsk_0513 : vop_vsk_0513 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0513() {
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
	var comboObjects = new Array();
	var comboCnt = 0; 

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1  = sheetObjects[0];   //sheet1
        var sheetObject2  = sheetObjects[1];   //sheet2
        var sheetObject3  = sheetObjects[2];   //sheet2
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Retrieve":
					 doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;

				case "btn_New":
					 doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;

				case "btn_Save":
					 doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
					
				case "btn_Excel":
					sheetObject1.Down2Excel(-1);
					break;

				case "btn_Import_File":
					var sheetObj = document.sheet1;
					sheetObj.RemoveAll();
					sheetObj.LoadExcel(true, 1, "", 1);
					last_day_check(sheetObj);
					break;                    
					
				case "btn_File_Templete":
					sheetObject3.Down2Excel(-1);
					/*var sheetObj = document.sheet1;
					var prefix = "sheet1_";
					var arrMustCol = "loc_cd|tide_yr|tide_mon|tide_dy|n1st_tide_fm_hrmnt|n1st_tide_to_hrmnt|n1st_high_tide_hgt|n1st_low_tide_hgt|n2nd_fm_tide_hrmnt|n2nd_to_tide_hrmnt|n2nd_high_tide_hgt|n2nd_low_tide_hgt".split("|");
					sheetObj.Redraw = false;
					for(var idx = 0; idx < arrMustCol.length; idx++){
						sheetObj.CellValue(0, prefix + arrMustCol[idx]) = sheetObj.CellValue(0, prefix + arrMustCol[idx]);
					}

					sheetObj.DirectDown2Excel("apps/alps/vop/vsk/vesseloperationsupportmgt/shatideinformationmgt/jsp/VOP_VSK_0513.xml");
					sheetObj.Redraw = true;*/
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

    function last_day_check(sheetObj){
    	
    	//alert(sheetObj.RowCount);
    	var vMaxDay = document.form.max_day.value;
    	var vLastRow = sheetObj.RowCount;
    	for(var i=vLastRow ; i>vMaxDay ; i--){
    		sheetObj.RowDelete(i+1, false);
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
     * Combo Object를 배열로 등록
     */    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		ComBtnDisable("btn_Import_File");
		ComBtnDisable("btn_File_Templete");	
		
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        initCombo(comboObjects[0], 1);
        initCombo(comboObjects[1], 2);
        
        initControl();
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
   	    switch(comboObj.id) {
			case "tide_yr":  
				with(comboObj) {
					comboObj.DropHeight=300;
					comboObj.BackColor = "#CCFFFD";
					for(var j=6; j<=20 ; j++)
					{
						if(j < 10 )
							InsertItem(i++,  "200"+j,  "200"+j);
						else
							InsertItem(i++,  "20"+j,  "20"+j);
					}

					Code = document.form.nowYear.value;
				}
				break;
			case "tide_mon":  
				with(comboObj) {
					comboObj.DropHeight=300;
					comboObj.BackColor = "#CCFFFD";
					for(var j=1; j<=12 ; j++)
					{
						if(j < 10 )
							InsertItem(i++,  "0"+j, j);
						else
							InsertItem(i++,  j,  j);
					}

					Text = document.form.nowMonth.value;
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
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
				with (sheetObj) {
                    // 높이 설정
                    style.height = 440;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msHeaderOnly;
                    MergeSheet = msAll;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Port Code|Year|Month|Day|1st Time|1st Time|Tide|Tide|2nd Time|2nd Time|Tide|Tide||";
					var HeadTitle2 = "|Port Code|Year|Month|Day|HH:MM (In)|HH:MM (Out)|High (In)|High (Out)|HH:MM (In)|HH:MM (Out)|High (In)|High (Out)||";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, false);

					var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE,    SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,	50,		daLeft,		false,	prefix+"loc_cd",				false,		"",	dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	prefix+"tide_yr",				false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	prefix+"tide_mon",				false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	prefix+"tide_dy",				false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n1st_tide_fm_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true, 4);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n1st_tide_to_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true, 4);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n1st_high_tide_hgt",	false,		"",	dfNullFloat,	2,		true,		true, 7);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n1st_low_tide_hgt",		false,		"",	dfNullFloat,	2,		true,		true, 7);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n2nd_fm_tide_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true, 4);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n2nd_to_tide_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true, 4);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n2nd_high_tide_hgt",	false,		"",	dfNullFloat,	2,		true,		true, 7);
                    InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	prefix+"n2nd_low_tide_hgt",		false,		"",	dfNullFloat,	2,		true,		true, 7);
                    
                    InitDataProperty(0, cnt++ , dtHidden,	50,		daLeft,		false,	prefix+"upd_usr_id",			false,		"",	dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,	50,		daLeft,		false,	prefix+"upd_dt",				false,		"",	dfNone,			0,		true,		true);

					//CountPosition = 0;
				}
                break;	
                
            case "sheet2":    				
                with (sheetObj) {
                	WaitImageVisible = false;
                }
                break;

            case "sheet3":
				with (sheetObj) {
                    // 높이 설정
                    style.height = 440;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msHeaderOnly;
                    MergeSheet = msAll;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Port Code|Year|Month|Day|1st Time|1st Time|Tide|Tide|2nd Time|2nd Time|Tide|Tide||";
					var HeadTitle2 = "|Port Code|Year|Month|Day|HH:MM (In)|HH:MM (Out)|High (In)|High (Out)|HH:MM (In)|HH:MM (Out)|High (In)|High (Out)||";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, false);

					var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE,    SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,		50,		daLeft,		false,	prefix+"loc_cd",				false,		"",	dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	prefix+"tide_yr",				false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	prefix+"tide_mon",				false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	prefix+"tide_dy",				false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n1st_tide_fm_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n1st_tide_to_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n1st_high_tide_hgt",	false,		"",	dfNullFloat,	2,		true,		true, 8);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n1st_low_tide_hgt",		false,		"",	dfNullFloat,	2,		true,		true, 8);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n2nd_fm_tide_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n2nd_to_tide_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	prefix+"n2nd_high_tide_hgt",	false,		"",	dfNullFloat,	2,		true,		true, 8);
                    InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	prefix+"n2nd_low_tide_hgt",		false,		"",	dfNullFloat,	2,		true,		true, 8);
                    
                    InitDataProperty(0, cnt++ , dtHidden,	50,		daLeft,		false,	prefix+"upd_usr_id",			false,		"",	dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,	50,		daLeft,		false,	prefix+"upd_dt",				false,		"",	dfNone,			0,		true,		true);

					//CountPosition = 0;
				}
                break;	                
		}
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
	        	var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0513GS.do", sParam);
				if(sXml.length>0){ 
					sheetObj.LoadSearchXml(sXml);
					sheetObjects[2].LoadSearchXml(sXml);
				}
				break;
	
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj)){
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("VOP_VSK_0513GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"), -1, false);				
				}				
				break;
				
			case IBCLEAR:
				var statsCnt = sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D");    						
				if(statsCnt > 0 ){
					if(ComShowCodeConfirm("VSK50012")){
						//formObj.loc_cd.value = "";
						comboObjects[0].RemoveAll();
				        initCombo(comboObjects[0], 1);
				        comboObjects[1].RemoveAll();
				        initCombo(comboObjects[1], 2);
						formObj.upd_dt.value = "";
						formObj.upd_usr_id.value = "";            		
						sheetObj.RemoveAll();
						sheetObjects[2].RemoveAll();
			    		ComBtnDisable("btn_Import_File");
			    		ComBtnDisable("btn_File_Templete");		
					}
				}else{
					//formObj.loc_cd.value = "";
					comboObjects[0].RemoveAll();
			        initCombo(comboObjects[0], 1);
			        comboObjects[1].RemoveAll();
			        initCombo(comboObjects[1], 2);
					formObj.upd_dt.value = "";
					formObj.upd_usr_id.value = "";            		
					sheetObj.RemoveAll();
					sheetObjects[2].RemoveAll();
		    		ComBtnDisable("btn_Import_File");
		    		ComBtnDisable("btn_File_Templete");		
				}
				break;
        }
    }


    function initControl() {
       	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
       	axon_event.addListenerFormat('keyup', 'obj_keyup', form);
       	axon_event.addListener('change', 'loc_cd_onchangeMax5', 'loc_cd', ''); //loc_cd 변경 Event
       	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }

    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김종옥
     * @version 2009.06.15
     */ 
    function obj_keyup(){
    	var formObj = document.form;
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
     	    case "engup":
     	        if(document.form.loc_cd.value.length == 5 ){    	        	
     	        	//Port Code 유효 체크
    				formObj.f_cmd.value = SEARCH01;
    				var sXml = sheetObjects[1].GetSearchXml("VOP_VSK_0513GS.do", FormQueryString(formObj));
    	    		var sLocCd = ComGetEtcData(sXml, "loc_cd");
    	    		if(sLocCd=="null" || sLocCd==null || sLocCd==""){
    	    			ComAlertFocus(formObj.loc_cd, ComGetMsg('VSK50015'));
    	    		}
     	        }
     	        break;
     	}
    } 
    
    /**
     * Port Code 5자리 체크
     */
	function loc_cd_onchangeMax5(){
		var formObj = document.form;
		if(formObj.loc_cd.value != ""){
			if(formObj.loc_cd.value.length < 5 ){
				ComShowCodeMessage("VSK50014");
				ComAlertFocus(formObj.loc_cd, "");
				return ;
			}
		}
	}
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        with(formObj){
        	//년도 비교
        	for(var i=sheetObj.HeaderRows ; i<=sheetObj.RowCount+1 ; i++){
        		if( sheetObj.CellValue(i, "sheet1_tide_yr") !=  comboObjects[0].Text ){
        			ComShowCodeMessage('VSK00097', 'Year');
        			return false;
        		}

        		if( sheetObj.CellValue(i, "sheet1_tide_mon") !=  comboObjects[1].Code ){
        			ComShowCodeMessage('VSK00097', 'Month');
        			return false;
        		}
        	}
        }

        return true;
    }

    /** 
      * Object 의 Keypress 이벤트에 대한 처리  <br>
      * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
      * @param  없음
      * @return 없음
      * @author 김종옥
      * @version 2009.06.15
      */ 
    function obj_keypress(){
    	obj = event.srcElement;
    	if(obj.dataformat == null) return;
         	 	
    	window.defaultStatus = obj.dataformat;
         	 
    	switch(obj.dataformat) {
        	case "engup":
         	     //if(obj.name=="agmt_iss_ofc_cd") ComKeyOnlyAlphabet('uppernum');
         	     ComKeyOnlyAlphabet('upper');
         	     break;
         	case "engdn":
         	     if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
         	     else ComKeyOnlyAlphabet('lower');
         	     break;
    	}
    } 
    
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		document.form.upd_dt.value = sheetObj.CellValue(NewRow, "sheet1_upd_dt");
		document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "sheet1_upd_usr_id");
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
    		document.form.upd_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_upd_usr_id");
    		document.form.max_day.value = sheetObj.RowCount;
    		
    		ComBtnEnable("btn_Import_File");
    		ComBtnEnable("btn_File_Templete");
		}
	}     
	
	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.SetMergeCell(0, 1, 2, 1);
		sheetObj.SetMergeCell(0, 2, 2, 1);
		sheetObj.SetMergeCell(0, 3, 2, 1);
		sheetObj.SetMergeCell(0, 4, 2, 1);
	}

    function tide_yr_OnChange(comObj,index,text)
    {
    	var formObj = document.form;
    	
		formObj.upd_dt.value = "";
		formObj.upd_usr_id.value = "";            		
		sheetObjects[0].RemoveAll();
		sheetObjects[2].RemoveAll();
		ComBtnDisable("btn_Import_File");
		ComBtnDisable("btn_File_Templete");		
	}

    function tide_mon_OnChange(comObj,index,text)
    {
    	var formObj = document.form;
    	
		formObj.upd_dt.value = "";
		formObj.upd_usr_id.value = "";            		
		sheetObjects[0].RemoveAll();
		sheetObjects[2].RemoveAll();
		ComBtnDisable("btn_Import_File");
		ComBtnDisable("btn_File_Templete");		
	}    
	/* 개발자 작업  끝 */