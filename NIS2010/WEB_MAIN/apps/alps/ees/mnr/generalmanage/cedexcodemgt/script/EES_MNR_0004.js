/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0004.js
*@FileTitle : EQ Damage Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.11 박명신
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
     * @extends Mnr
     * @class EES_MNR_0004 : EES_MNR_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0004() { 
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
	
	//콤보박스 값 변경시 값을 저장한다.          
	var comboValue = "";              

	// 로그인 유저의 Office 레벨 : HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴 (CoMnr.js에서
	// MnrOfficeLevel 함수에 의해 셋팅)
	var strMnrOfficeLevel = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */	
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */ 
    function processButtonClick(){ 
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject = sheetObjects[0];
			
         /*******************************************************/
         var formObject = document.form; 

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

						case "btn_Retrieve": 
								doActionIBSheet(sheetObject, formObject, IBSEARCH)
								break; 
								
						case "btn_New":    
								doActionIBSheet(sheetObject, formObject, IBCLEAR)
								setSaveBtnDisplay();
								break;

						case "btn_Save":  
								doActionIBSheet(sheetObject, formObject, IBSAVE)
								break; 
								 
						case "btn_RowAdd":  
								doActionIBSheet(sheetObject, formObject, IBINSERT)
								break;    
								 
						case "btn_RowDel":      
								doActionIBSheet(sheetObject, formObject, IBDELETE)
								break;      
								  
						case "btn_Excel1":
							 sheetObject.SpeedDown2Excel(-1);    
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
     * IBSheet Object를 배열로 등록 
     * @param	{IBSheet}	sheet_obj	화면에서 사용할 쉬트들을 추가한다.
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의 
     */ 
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }
	 
	/** 
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){    
    	comboObjects[comboCnt++] = combo_obj;  
	}      
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
    	MnrOfficeLevel(currOfcCd, rhqOfcCd);
		MnrWaitControl(true);  
		initControl(); 	
		 
        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i + 1);
			
            ComEndConfigSheet(sheetObjects[i]);
        }  
				 
		//IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }	 
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        setSaveBtnDisplay();
    }
    
	/**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {   
	    //var cnt  = 0 ; 
	    var formObject = document.form
	     
	    switch(comboNo) {    
	          case 1: 
	           with (comboObj) { 	
		      	   SetTitle("Code|Desc");	 
			       SetColAlign("left|left");        
			       SetColWidth("50|150");    
				   DropHeight = 160;  
		    }      
	           break;    
	     } 
	} 
	 
   /**   
     * 시트 초기설정값, 헤더 정의 
     * @param	{IBSheet}	sheetObj	시트오브젝트. 
	 * @param	{Number}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호 
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
					
					var HeadTitle1 = "|D|S|Code|Num Code|Name|Description";
					var headCount = ComCountHeadTitle(HeadTitle1);
					 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 1, 0, 0, true);        
 					 
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다  
                    InitHeadMode(true, true, false, true, false,false)
  						
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);    
					 
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, 						POINTCOUNT, 	UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  	InitDataProperty(0, cnt++ , dtHiddenStatus,	 	30,    	daCenter,  	false,   	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,       20,    	daCenter,  	false,   	"del_chk");
					InitDataProperty(0, cnt++ , dtSeq,				40,		daCenter,	true,		"S");
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		"eq_cedex_otr_cd",			true,	"",		dfNone,		    0,			false,		true,	2,			true);
					InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		"eq_cedex_otr_num_cd",		true,	"",		dfNone,			0,			false,		true,	5,			true);
					InitDataProperty(0, cnt++ , dtData,				230,	daLeft,		true,		"eq_cedex_otr_cd_nm",		false,	"",		dfNone,			0,			true,		true,	200);
					InitDataProperty(0, cnt++ , dtData,				100,	daLeft,		true,		"eq_cedex_otr_cd_desc",		false,	"",		dfNone,			0,			true,		true,	500);  
					//데이타 조작용 히든            
					InitDataProperty(0, cnt++ , dtHidden,			80,		daLeft,		true,		"eq_cedex_otr_tp_cd",	 	false,	"",		dfNone,			0,			false,		false); 
					                 
					InitDataValid(0,  "eq_cedex_otr_cd", vtEngUpOther,"0123456789");       
					InitDataValid(0,  "eq_cedex_otr_num_cd", vtNumericOnly);
					   
					//로우한개씩 선택  
					MultiSelection = false;   
					SelectionMode = smSelectionRow;
					//선택시 하이라이트 함       
					SelectHighLight = true;  
					//선택시 볼드체 변경 안함           
					SelectFontBold = false;  
					//SELECT 로우 배경색            
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);     
					CountPosition = 0;  
				}    
     			break;   

        }   
    }
  
	/**
	 * Sheet1관련 프로세스 처리
	 * @param {IBSheet} sheetObj 프로세스 처리될 시트오브젝트 
	 * @param {Form}  formObj  프로세스 처리될 폼오브젝트
	 * @param {Number} sAction  분기처리될 액션의 상수값(CoObject.js에 정의) 
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;                        
        switch(sAction) {           
		    case IBSEARCH:    //조회 
		    		//시트 초기화
	            	sheetObj.RemoveAll();     
					   	 
		    		if (validateForm(sheetObj,formObj,sAction)) {   
	          			formObj.f_cmd.value = SEARCH;             
	          			formObj.eq_cedex_otr_tp_cd.value = comboValue; 
						sheetObj.DoSearch4Post("EES_MNR_0004GS.do", FormQueryString(formObj));
					}    	    
	          	break;       
				 	           	  				  
			case IBSAVE:  //저장          
					if (validateForm(sheetObj,formObj,sAction)) {  
						formObj.f_cmd.value = MULTI;                                                            
						sheetObj.DoSave("EES_MNR_0004GS.do", FormQueryString(formObj),-1,false);          
					}        	       
	      		break;    	   
					 
				
			case IBINSERT:  // ROWADD   
		   	   		var Row = sheetObj.DataInsert(-1);          
					sheetObj.CellValue2(Row, "eq_cedex_otr_tp_cd") = comboValue;      
	      		break;           
					   
            case IBDELETE:  // 삭제      
            		if(sheetObj.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObj,"del_chk"); 
					} else {                        
						ComShowCodeMessage("MNR00150");	     	   
					}        
	      		break;      
       	           
          	case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화 
          		   MnrWaitControl(true);
                   sheetObj.WaitImageVisible = false;

					//콤보데이타 초기화
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();	
					}    
					
					//콤보데이타 조회
					var sCondition = new Array ( 
					 	new Array("MnrGenCd","CD00001", "COMMON")    
					)         
							       
					//콤보데이타에 값을 세팅함    
					var comboList = MnrComSearchCombo(sheetObj,sCondition); 
					for(var i = 0; i < comboList.length;i++){ 
						comboObjects[i].RemoveAll(); 
				 
					 	if(comboList[i] != null){  
					 		for(var j = 0; j < comboList[i].length;j++){ 
								comboObjects[i].InsertItem(j, comboList[i][j] ,j + '');
							}      
						}                     
					 	comboObjects[i].Code = 0;             			
					 }  
						 	   
					//쉬트 초기화
					sheetObj.RemoveAll();  
					//인풋 텍스트창을 초기화      
					formObj.eq_cedex_otr_cd_dummy.value = '';  
					sheetObj.WaitImageVisible = true; 
                    MnrWaitControl(false); 
                     	
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
			if(sAction==IBSAVE) {    
				//저장시 각시트별 중복체크   
				if(sheetObj.IsDataModified){ 
						var Row = sheetObj.ColValueDup("eq_cedex_otr_cd|eq_cedex_otr_tp_cd"); 
						if(Row > 0){               
							ComShowCodeMessage("MNR00006",i + 1 + "th sheet of " + Row + " row ");
							sheetObj.CellValue2(Row, "eq_cedex_otr_cd") = "";   
							sheetObj.SelectCell(Row, "eq_cedex_otr_cd", true);  
							return false;              
						}    			
				}
			} else if(sAction==IBSEARCH) {  
				//조회코드가 없을시 전체 조회   
				if(eq_cedex_otr_cd_dummy.value == '' || eq_cedex_otr_cd_dummy.value  == null){
					eq_cedex_otr_cd.value = 'All';    
				} else {
					eq_cedex_otr_cd.value = eq_cedex_otr_cd_dummy.value;	
				}      
			}
        }    
        return true; 
    } 
	 		
	/* ********* User Functions ************* */	
		
	//저장후 결과메세지 표시  
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {        
			ComShowCodeMessage("MNR00023",'');   
		} else {    
			ComShowCodeMessage("MNR00008",ErrMsg);  
		}         
	}    
	 
	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch 
	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	}           
		   
	//Axon 이벤트 처리2. 이벤트처리함수  
	function obj_deactivate(){     
	    ComChkObjValid(event.srcElement);
	}
	
	function obj_activate(){  
	    ComClearSeparator(event.srcElement);
	}  
	  
	function obj_keypress(){ 
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	         
	    switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');          
	            break;   
	    }   
	}      
	/**  
	 * combo1 체인지 이벤트      
	 * @param	{IBMultiCombo}		comboObj	콤보오브젝트  
	 * @param 	{Number} 			Index_Code 	선택된 row 
	 * @param 	{String} 			Text 		선택된 Text  
	 */  
	function combo1_OnChange(comboObj,Index_Code, Text){   
		comboValue = comboObj.GetText(Index_Code,0);          
	}        
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