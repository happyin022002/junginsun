/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : .js
 *@FileTitle : Write off Approval Route Manager Selection
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.09.05 
 *@LastModifier : 한종희 	
 *@LastVersion : 1.0     
 * 2013.09.05 한종희   
 * 1.0 Creation
 * 2014-02-26 Jonghee HAN Live malfunction fixed
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
 * @class  :  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MNR_0265() {
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
	var comboObjects = new Array();
	var comboCnt = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var initLoader = 0;
	var newBtnClick = 0;
	var officeChk = "";
	var strMnrOfficeLevel = "";	// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
		
	 /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//버튼 설정
    	MnrWaitControl(true);
		//Axon이벤트 초기화
		initControl();

		//IBMultiCombo 초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
    	
    	// IBSheet 초기화
        for(i=0; i<sheetObjects.length; i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    }
    /**   
 	 * setting combo basic info    
 	 * @param	{IBMultiCombo}	combo_obj	ComboObject. 
 	 * @param	{Number}	comboNo		ComboObject tag number 
 	 * adding case as numbers of counting combos 
 	 */     
 	function initCombo (comboObj, comboNo) {        
 	    var formObject = document.form
 	    switch(comboNo) {          	        
 	        case 1: 
 	           	with (comboObj) { 
 				MultiSeparator = "|";
 				SetTitle("Office Code|Office Name");
         	   	SetColAlign("left|left");        
 				SetColWidth("100|250"); 
 			   	DropHeight = 160;  
 				UseAutoComplete = true;
 		    	}      
 	        	break;        	        	
 	     } 
 	}  
 	
 	
 	 /**
     * OnChange event on combo_eq_kind
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */   
//    function comboOnChange(comboObj, Index_Code, Text){ 
//    		var formObj = document.form;
//    		formObj.ofc_cd.removeAll();
//
//  		var sCondition = new Array (
//  				new Array("MdmOrganization","SEARCH",	Index_Code)   //Office
//  			);   
//  		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
//     	
//	       	if(comboList[0] != null){
//	      	 	for(var i = 0; i < comboList[0].length;i++){ 
//	      		 	   var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
//	      	 		   formObj.combo_office.InsertItem(i, comboList[0][i] , code);			   
//	      	 	}
//	      	 	formObj.ofc_cd.InsertItem(0, "ALL" , "A");
//	      	 	formObj.ofc_cd.Code = "A";
//	       	}
//    } 
    
//	function combo_ofc_cd_OnChange(comboObj, Index_Code, Text){ 
// 		var formObj  = document.form;     
// 		if(Index_Code==""){
//			comboObj.Code="A";
//		}
//		if(comboObj.Code=="A"){
//			formObj.ofc_cd.value = ""; 
//		}else{
//			formObj.ofc_cd.value = comboObj.Code; 
//		}
//   	}  
    
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
                    style.height = 402; 
                    //전체 너비 설정 
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly; 

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true; 

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 6, 100);
						
					var HeadTitle1 = "|Sel.|Step|Office|PIC1|PIC1|PIC1|PIC2|PIC2|PIC2|PIC3|PIC3|PIC3|PIC4|PIC4|PIC4|||||";
					var HeadTitle2 = "|Sel.|Step|Office||ID|Name||ID|Name||ID|Name||ID|Name|||||"; 
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
						
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);  
                    InitHeadRow(1, HeadTitle2, true);  
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++,  dtHiddenStatus,		0,      daCenter,		false,  	"ibflag");
	                InitDataProperty(0, cnt++ , dtCheckBox,			40,		daCenter,		true,		"del_chk",				false,		"",		dfNone,		0,	true,	true);
//					InitDataProperty(0, cnt++ , dtSeq,       			30,    	daCenter,		true,  		"Seq",     			false,		"",    	dfNone);    
					InitDataProperty(0, cnt++ , dtCombo,			70,		daCenter,		true,		"ofc_tp_cd",			true,		"",		dfNone,		0,	false,	true);
                    InitDataProperty(0, cnt++ , dtData,				60,		daCenter,		true,		"ofc_cd",				true,		"",		dfNone,		0,	false,	true);           
                    InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,		true,		"pic1_ofc",		false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,				70,		daLeft,			true,		"pic1_usr_id",			true,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,				150,	daLeft,			true,		"pic1_nm",			false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,		true,		"pic2_ofc",		false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,				70,		daLeft,			true,		"pic2_usr_id",			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,				150,	daLeft,			true,		"pic2_nm",			false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,		true,		"pic3_ofc",		false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,				70,		daLeft,			true,		"pic3_usr_id",			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,				150,	daLeft,			true,		"pic3_nm",			false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,			60,		daCenter,		true,		"pic4_ofc",		false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,				70,		daLeft,			true,		"pic4_usr_id",			false,		"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,				150,	daLeft,			true,		"pic4_nm",			false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,			true,		"pre_pic1_usr_id",			false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,			true,		"pre_pic2_usr_id",			false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,			true,		"pre_pic3_usr_id",			false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,			true,		"pre_pic4_usr_id",			false,		"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,			true,		"pic_cnt",			false,		"",		dfNone,		0,	false,	false);
                    
                    //Validating the data
					InitDataValid(0,  "ofc_cd", 		vtEngUpOther,	"0123456789");
					InitDataValid(0,  "pic1_usr_id",	 vtEngOther,	"0123456789");
					InitDataValid(0,  "pic2_usr_id",	 vtEngOther,	"0123456789");
					InitDataValid(0,  "pic3_usr_id",	 vtEngOther,	"0123456789");
					InitDataValid(0,  "pic4_usr_id",	 vtEngOther,	"0123456789");
					
					
					InitDataCombo (0, "ofc_tp_cd", "BA/BB/BO|RHQ|HO", "BB|HQ|HO");
					
					//Setting for Background color of selected row
					SelectionMode = smSelectionRow;
					SelectHighLight = true;
					SelectFontBold = false;
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
					
					sheetObj.Editable = true;
									
					CountPosition = 2;

				}
                break;
			}
    }
    /**
	 * Assigning array of IBCombo object
	 * @param    {IBCombo}	combo_obj        Registered as an array IBCombo Object
	 */
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	}

	/**
	 * Assigning array of IBSheet object
	 * @param    {IBSheet}	sheet_obj        Registered as an array IBSheet Object
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {
					case "btn_Retrieve" :  
						doActionIBSheet(sheetObject1,	formObject,	IBSEARCH);
						break;
					
					case "btn_New":      
						newBtnClick = 1;
						doActionIBSheet(sheetObject1,	formObject,	IBCLEAR);
						break;	
							
					case "btn_Save":    
						doActionIBSheet(sheetObject1,	formObject,	IBSAVE);
						break;     
					
					case "btn_RowAdd":
						doActionIBSheet(sheetObject1,	formObject,	IBINSERT);
						break;

					case "btn_RowDel":
						doActionIBSheet(sheetObject1,	formObject,	IBDELETE);
						break;

					case "btn_DownLoad":
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
     * Sheet 관련 프로세스 처리
     * 
     * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
     * @param {Form}formObj 프로세스 처리될 폼오브젝트
     * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function doActionIBSheet(sheetObj, formObj, sAction, sActionIdx) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
	    	// 초기화
	    	case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);
	    		
	    		if(initLoader == 0){
	    			MnrOfficeLevel(currOfcCd,rhqOfcCd);
	    			
	    			//initializing combo
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();       
					}
					
					var sCondition = new Array (
							new Array("MdmOrganization","SEARCH", "")   //Office 
						);
					
					var comboList = MnrComSearchCombo(sheetObj, sCondition);
					
					for(var i=0; i<comboList.length; i++)
					{	
						if(comboList[i] != null)
						{
							for(var i = 0; i < comboList[0].length;i++){ 
				      		 	   var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
				      	 		   formObj.ofc_cd.InsertItem(i, comboList[0][i] , code);			   
				      	 	}
							
				      	 	formObj.ofc_cd.InsertItem(0, "ALL" , "A");
//				      	 	formObj.ofc_cd.Code = "A";
						}
						else
						{		
							ComShowCodeMessage("MNR00005", "Office Code");
						}
					}
					
					if (strMnrOfficeLevel != "L1"){
						formObj.ofc_cd.text = currOfcCd;
					}
					
					initLoader = 1;
	    		}
	    		// 모든 쉬트를 초기화
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}   		

	    		formObj.working_type.Value = "P";
		
	    		// 버튼 , 프로그레스바 설정 끝
	    		MnrWaitControl(false);
	    		sheetObj.WaitImageVisible = true;
	    		
	    		if(strMnrOfficeLevel == "L1"){
	    			formObj.ofc_cd.Code = "A";
	    			formObj.ofc_cd.Enable = true;
	    			formObj.working_type[0].disabled  = false;
	    			formObj.working_type[1].disabled  = false;
	    			
	    			if(formObj.working_type[0].checked == true){
	    				ComBtnDisable('btn_RowAdd');
		    			ComBtnDisable('btn_RowDel');
	    			}else{
		    			ComBtnEnable('btn_RowAdd');
		    			ComBtnEnable('btn_RowDel');
	    			}
	    			
	    		}
	    		else{
	    			// 본사가 아니면 자동 조회
	    			if(newBtnClick == 0){
	    				doActionIBSheet(sheetObjects[0],	formObj,	IBSEARCH);
	    			}	
	    			formObj.ofc_cd.Enable = false;
	    			formObj.working_type[0].disabled  = true;
	    			formObj.working_type[1].disabled  = true;
	    			formObj.ofc_cd.disabled = true;
	    			ComBtnDisable('btn_RowAdd');
	    			ComBtnDisable('btn_RowDel');
	    			ComBtnDisable('btn_Save');
	    			
	    			sheetObj.Editable = false;
	    		}
	    		
	    		
	    		
	    		break;
	        
	    	//Header 조회
            case IBSEARCH:      
                if(validateForm(sheetObj,formObj,sAction)) {
                	sheetObj.WaitImageVisible = true;
    	    		MnrWaitControl(true);
    				formObj.f_cmd.value = SEARCH;
    				
    	    		// 모든 쉬트를 초기화
    	    		for (i = 0; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}
					
					var sParam = FormQueryString(formObj);  
					var sXml = sheetObj.GetSearchXml("EES_MNR_0265GS.do", sParam);
					sheetObj.LoadSearchXml(sXml);

					MnrWaitControl(false);
		    		sheetObj.WaitImageVisible = false;
		    		
		    		setEnableSwitch(ComGetObjValue(formObj.working_type));
	            }
                if(strMnrOfficeLevel != "L1"){
                	ComBtnDisable('btn_Save');
                }
                break;  
                
            case IBSEARCH_ASYNC01: 
                formObj.f_cmd.value = SEARCH01;
    			sheetObj.WaitImageVisible = false;

    			var sXml = sheetObj.GetSearchXml("EES_MNR_0265GS.do", FormQueryString(formObj));
    			var valResult = ComGetEtcData(sXml, "usr_nm");
    			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
    			if(valResult == "" || State != "S"){
    				ComShowCodeMessage('CGM20023', "Group Customer Code");
    				sheetObj.pic1_nm.value = "";
    				break;
    			}else{
    				sheetObj.pic1_nm.value = valResult;
    			}
    			
    			MnrWaitControl(false);
	    		sheetObj.WaitImageVisible = true;
	    		
    			break;
    		
            case IBINSERT:      
            	var Row = sheetObj.DataInsert(-1);          
				   
            	break;
      		
            case IBDELETE:   
        		if(sheetObj.FindCheckedRow("del_chk") != ""){
					ComRowHideDelete(sheetObj, "del_chk"); 
				} else {                        
					ComShowCodeMessage("MNR00150");	     	   
				}
        		break;
            case IBSAVE:
            	//PIC 중간에 입력 정보 없을 시 체크
        		if(sheetObj.RowCount > 0){
        			//header가 2개 row이므로 결과값을 모두 검색하기위해 +2
        			for(i=2; i<sheetObj.RowCount+2; i++) {
        				var pic_cnt;
            			for(j=4; j>0; j--) {					//PIC 숫자만큼 확인
        					if (sheetObj.CellValue(i , "pic"+j+"_usr_id") != "") {
        						pic_cnt = j;
        						break;
        					} 
        				}
        			
        				for (j=1; j<pic_cnt; j++) {
	            			if (sheetObj.CellValue(i, "pic"+j+"_usr_id") == "") {
	            				ComShowCodeMessage("MNR00399", i-1, sheetObj.CellValue(i,"ofc_cd"), j);	     				
	            				sheetObj.SelectCell(i,"pic"+j+"_usr_id");
	            				return;
	            			}
	            		}
        			}
        		}
        		
            	if(validateForm(sheetObj,formObj,sAction)) {
            		
	            	//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					ComSetObjValue(formObj.f_cmd, 			MULTI);
					
					var sParam = "";
					var sParam1 = sheetObjects[0].GetSaveString();
	
					sParam += sParam1 + "&" + FormQueryString(formObj);
	
					
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
	
					var sXml = sheetObj.GetSaveXml("EES_MNR_0265GS.do", sParam);
					
					ComOpenWait(false);
					
					//3.결과 처리
					if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
						ComShowCodeMessage("MNR00009", "Approval Step");
						doActionIBSheet(sheetObjects[0],	formObj,	IBSEARCH);
					}
            	}
                break;
      		break; 

                
        }
    }

    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, sActionIdx){
        var formObj = document.form;   
		with(formObj){
			if (sAction == IBSEARCH) { 
    			// Dataformat      				
    			if (!ComChkValid(formObj)) {	
    				return false;			
    			}

    		}
			else if (sAction == IBSAVE) {
				
				if(sheetObj.getSaveString() == "" || sheetObj.getSaveString() == null){
					ComShowCodeMessage("MNR00369");
					return;
				}
				
				if(!ComShowCodeConfirm('MNR00160')){
					return;
				}
			}
			
        }   
        return true; 
    }
		

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);		//- 변경될때
	    axon_event.addListenerForm  ('click'	   , 'obj_onclick'   , 	document.form);
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
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;	
	        	
			case "engup":
	         	if(obj.name == "in_ttl_lss_no"){ 
					ComKeyOnlyAlphabet('uppernum','45|44'); 
				} else {				   
					ComKeyOnlyAlphabet('uppernum');	
				}          
	            break; 
	    } 
	}

	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_change()
	{	     
		ComChkObjValid(event.srcElement);
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
	
		if ( ComTrim(obj.value) != "" ) 
		{
			switch(obj.name)
			{      
				case "pic1_usr_id", "pic2_usr_id", "pic3_usr_id", "pic4_usr_id":
					doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
					break;  
				
			}       
		} else {
			switch(obj.name) {
				case "pic1_usr_id":
					obj.pic1_nm.value = "";
					break;
					
				case "pic2_usr_id":
					obj.pic2_nm.value = "";
					break;
					
				case "pic3_usr_id":
					obj.pic4_nm.value = "";
					break;
					
				case "pic4_usr_id":
					obj.pic4_nm.value = "";
					break;				
			}
		}
	} 
	
	function obj_onclick(){
		var formObj = document.form;
		var obj	 = event.srcElement;
		if ( obj.name == "working_type" ) {
			setEnableSwitch(ComGetObjValue(obj));
		}
	}
	
	function setEnableSwitch(value) {
		var formObj = document.form;
		
		if(strMnrOfficeLevel == "L1"){
			if ( value == "P" ) {
				ComBtnDisable('btn_RowAdd');
				ComBtnDisable('btn_RowDel');
			} else if ( value == "A" ) {
				ComBtnEnable('btn_RowAdd');
				ComBtnEnable('btn_RowDel');
			} 
		}else{
			ComBtnDisable('btn_RowAdd');
			ComBtnDisable('btn_RowDel');
		}
	}

	 /** 
	  * 조회후 Office별 Approver 인원수 구하기 
	  * @param	{IBSheet}	sheetObj	시트오브젝트
	  * @param	{String}	Row		    Row
	  * @param   {String}    Col 		Col
	  */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){		
		if(sheetObj.RowCount > 0){
			//header가 2개 row이므로 결과값을 모두 검색하기위해 +2
			for(i=0; i<sheetObj.RowCount+2; i++) {
				var pic_cnt;
				for(j=1; j<5; j++) {					//PIC 숫자만큼 확인
					if (sheetObj.CellValue(i , "pic"+j+"_usr_id") == "") {
						pic_cnt = j-1;
						break;
					} else if (sheetObj.CellValue(i, "pic4_usr_id") != "") {
						pic_cnt = 4;
					}
				}
				sheetObj.CellValue2(i,"pic_cnt") = pic_cnt;
			}
		}
	}
	    
	/**
     * 저장시 필수 체크
     * @param	{Element}	obj	체크할 Form Element
     */
	function checkMandatory(obj) {
		if(ComIsEmpty(ComGetObjValue(obj))) {  
		    ComShowCodeMessage("MNR00003");
		    return false; 
		}
		return true;
	}
	
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		var formObj = document.form;
		
		if(sheetObj.ColSaveName(Col) == "ofc_cd"){
			
			var param = "f_cmd=" + SEARCH02;
			param += "&ofc_cd=" + sheetObj.CellValue(Row, "ofc_cd");
			
			var sXml = sheetObj.getSearchXml("EES_MNR_0265GS.do", param);
			// 데이터 건수
			officeChk = ComGetEtcData(sXml, "ISOFFICE");
			
		    if(officeChk == 'N'){
		    	ComShowCodeMessage('MNR00005','Office cd');
		    	sheetObj.Cellvalue2(Row, "ofc_cd") = "";
		    	sheetObj.SelectCell(Row, "ofc_cd");
		    	return;
		    }
		    	
		    var param1 = "f_cmd=" + SEARCH03;

		    param1 += "&ofc_cd=" + sheetObj.CellValue(Row, "ofc_cd");
		    param1 += "&ofc_tp_cd=" + sheetObj.CellValue(Row, "ofc_tp_cd");
			    
			var sXml = sheetObj.getSearchXml("EES_MNR_0265GS.do", param1);
			// 데이터 건수
			var dupOffice = ComGetEtcData(sXml, "ISDUPOFFICE");
				
			if(dupOffice == 'Y'){
			    ComShowCodeMessage('MNR00397');
			    sheetObj.Cellvalue2(Row, "ofc_cd") = "";
			    sheetObj.SelectCell(Row, "ofc_cd");
			    return;
			}

		}else if(sheetObj.ColSaveName(Col) == "pic1_usr_id" || sheetObj.ColSaveName(Col) == "pic2_usr_id" 
			|| sheetObj.ColSaveName(Col) == "pic3_usr_id" || sheetObj.ColSaveName(Col) == "pic4_usr_id"){
			var colName = sheetObj.ColSaveName(Col);
			
			if(sheetObj.CellValue(Row, colName) == ""){
				if(colName == "pic1_usr_id"){
					sheetObj.CellValue2(Row, "pic1_nm") = "";
//					sheetObj.CellValue2(Row, "pic1_ofc") = "";
				}else if(colName == "pic2_usr_id"){
					sheetObj.CellValue2(Row, "pic2_nm") = "";
//					sheetObj.CellValue2(Row, "pic2_ofc") = "";
				}else if(colName == "pic3_usr_id"){
					sheetObj.CellValue2(Row, "pic3_nm") = "";
//					sheetObj.CellValue2(Row, "pic3_ofc") = "";
				}else if(colName == "pic4_usr_id"){
					sheetObj.CellValue2(Row, "pic4_nm") = "";
//					sheetObj.CellValue2(Row, "pic4_ofc") = "";
				}
			}else{
				//현재 PIC보다 추가시 알림메시지 보여주기
				var pic_cnt = sheetObj.CellValue(Row,"pic_cnt");
				for (i=eval(pic_cnt)+1; i<5; i++) {
					if (colName == "pic"+i+"_usr_id") {
						ComShowCodeMessage('MNR00398');
						sheetObj.CellValue2(Row, "pic"+i+"_usr_id") = "";
						sheetObj.CellValue2(Row, "pic"+i+"_nm") = "";
						return;
					}
				}
				
				var param = "f_cmd=" + SEARCH04;
				param += "&apro_usr_id=" + sheetObj.CellValue(Row, colName);
				
				var sXml = sheetObj.getSearchXml("EES_MNR_0265GS.do", param);
				
				var usr_nm = ComGetEtcData(sXml, "USER_NAME");
				var ofc_cd = ComGetEtcData(sXml, "OFC_CD");
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				
				if(State == "S"){
					if(usr_nm != ""){
						if(colName == "pic1_usr_id"){
							sheetObj.CellValue2(Row, "pic1_nm") = usr_nm;
							sheetObj.CellValue2(Row, "pic1_ofc") = ofc_cd;
						}else if(colName == "pic2_usr_id"){
							sheetObj.CellValue2(Row, "pic2_nm") = usr_nm;
							sheetObj.CellValue2(Row, "pic2_ofc") = ofc_cd;
						}else if(colName == "pic3_usr_id"){
							sheetObj.CellValue2(Row, "pic3_nm") = usr_nm;
							sheetObj.CellValue2(Row, "pic3_ofc") = ofc_cd;
						}else if(colName == "pic4_usr_id"){
							sheetObj.CellValue2(Row, "pic4_nm") = usr_nm;
							sheetObj.CellValue2(Row, "pic4_ofc") = ofc_cd;
						}
					}else{
						ComShowCodeMessage('MNR00005','User Id');
				    	sheetObj.Cellvalue2(Row, colName) = "";
				    	sheetObj.CellValue2(Row, colName.substr(0,4)+"_nm") = "";
				    	sheetObj.SelectCell(Row, colName);
				    	return;
					}
				}
			}		
			
		}
	}

	/**
	 * 저장시 그리드 존재유무
	 */
//	function checkIsDetailRow(){
//		var cnt = 0;
//		for (var i=2; i<7; i++) {
//			if(sheetObjects[i].RowCount > 0) {
//				cnt++;
//			}
//		}
//		if(cnt<1) { return false}
//		
//		return true;
//	}