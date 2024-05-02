/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0193.js
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0	
* 2009.04.27 박명신 
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
     * @extends Mnr   
     * @class EES_MNR_0193 : EES_MNR_0193 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0193() {    
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
	
	//쉬트 클릭시 상태를 저장       
	var sheetClicks = new Array(0,0,0,0);         
	  
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */ 
    function processButtonClick(){ 
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];
		 var sheetObject2 = sheetObjects[2];
		 var sheetObject3 = sheetObjects[3];     

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
								break;          
	
						case "btn_Ok":   
								if(sheetObject3.FindCheckedRow("checkbox") == ""){ 
									ComShowCodeMessage("MNR00038","SELECT ");             	   
								} else { 		   
									comPopupOK(sheetObject3);     	       	  
								}   	                
								break;              
								 
						case "btn_Close":    
								self.close(); 
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

    /** 
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {    
		MnrWaitControl(true);
        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i + 1);
 
            ComEndConfigSheet(sheetObjects[i]);
			 
			//상태 초기화  
			sheetClicks[i] = 0;  
        }  
				 
		//IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);     
	    }	
							
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);	
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
	           break;
				   
			  case 2:
			  	with (comboObj) { 
					SetTitle("Code|Desc");		 
					SetColAlign("left|left");        
					SetColWidth("50|200");            
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
                    style.height = 302; 
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
  					 
					var HeadTitle1 = "|Code|EQ Type|Description";   
					var headCount = ComCountHeadTitle(HeadTitle1);   
 					 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 3, 0, 0, true);     
  		      		     
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                    InitHeadMode(true, true, false, true, false,false);
 					    	
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);  
					 			       
                    //데이터속성    [ROW, COL,  DATATYPE,   		 WIDTH,    DATAALIGN, COLMERGE, 	SAVENAME,  	   		KEYFIELD, CALCULOGIC, DATAFORMAT, 		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,    	daCenter,  	false,   	"ibflag");
					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	true,		"eq_loc_cd",		false,		"",			dfNone,				0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			80,		daCenter,	true,		"eq_knd_cd",		false,		"",			dfNone,				0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daLeft,		true,		"eq_loc_nm",		false,		"",			dfNone,				0,			false,		false);
					//데이타 조작용 히든  
					InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,		"eq_loc_cd_lvl",	false,		"",			dfNone,				0,			false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,		"eq_loc_prnt_cd",	false,		"",			dfNone,				0,			false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,		"eq_less_20ft_flg",	false,		"",			dfNone,				0,			false,		false); 
									 
					//SELECT 로우 배경색   
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB); 
					//SelectionMode MultiSelection=false이면 1개의 행만 선택 가능           
					EditableColorDiff = false;     
					MultiSelection = false;  
					SelectionMode = smSelectionRow;  
					//선택시 하이라이트사용하지 않음   
					SelectHighLight = true;      
					//선택시 볼드 사용하지 않음          
					SelectFontBold = false;             
					          
					CountPosition =  0;             
				}   
			break;  
	          		
            case "sheet2": 
                with (sheetObj) { 
                    // 높이 설정  
                    style.height = 302;
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
 					 
					var HeadTitle1 = "|Code|Description";
					var headCount = ComCountHeadTitle(HeadTitle1);
					  
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 4, 0, 0, true);     
 
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다.    
                    InitHeadMode(true, true, false, true, false,false)
 					  
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);    
    				      	  
                    //데이터속성         [ROW, COL,   DATATYPE,          WIDTH,    	DATAALIGN, COLMERGE, SAVENAME,  	   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,    		daCenter,  	false,   "ibflag");
					InitDataProperty(0, cnt++ , dtData,				40,			daCenter,	true,	 "eq_loc_cd",	    false,		"",		 dfNone,			0,		false,		false);   
					InitDataProperty(0, cnt++ , dtData,				80,			daLeft,		true,	 "eq_loc_nm",		false,		"",		 dfNone,			0,		false,		false);
					          
					//데이타 조작용 히든  
					InitDataProperty(0, cnt++ , dtHidden,			0,			daLeft,		true,	 "eq_loc_cd_lvl",	false,		"",		 dfNone,			0,		false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,			0,			daLeft,		true,	 "eq_loc_prnt_cd",	false,		"",		 dfNone,			0,		false,		false);	   
					InitDataProperty(0, cnt++ , dtHidden,			0,			daLeft,		true,	 "eq_knd_cd",	false,		"",		 dfNone,			0,		false,		false);	   
					InitDataProperty(0, cnt++ , dtHidden,			0,			daLeft,		true,	 "eq_less_20ft_flg",	false,		"",		 dfNone,			0,		false,		false);	   
					   
					//SELECT 로우 배경색 
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);     
					//SelectionMode MultiSelection=false이면 1개의 행만 선택 가능           
					EditableColorDiff = false; 
					MultiSelection = false;  
					SelectionMode = smSelectionRow;  
					//선택시 하이라이트사용하지 않음   
					SelectHighLight = true;      
					//선택시 볼드 사용하지 않음    
					
					CountPosition = 0;  
					}
				break;
		         		
            case "sheet3":
                with (sheetObj) { 
                    // 높이 설정      
                    style.height = 302;
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
 
					var HeadTitle1 = "|Code|Less 20ft|Description";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 3, 0, 0, true);
							   
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					         
                    //데이터속성    [ROW, COL,      DATATYPE,   		WIDTH, DATAALIGN, COLMERGE,     SAVENAME,         KEYFIELD,      CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 	30,    	daCenter,  	false,   	"ibflag");
					InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	true,		"eq_loc_cd",		false,	   		"",		dfNone,				0,		false,		false );
					InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	true,		"eq_less_20ft_flg",	false,	   		"",		dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,				80,		daLeft,		true,		"eq_loc_nm",		false,			"",		dfNone,				0,		false,		false);
					   
					//데이타 조작용 히든 
					InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,		"eq_loc_cd_lvl",		false,			"",		dfNone,				0,		false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,		"eq_loc_prnt_cd",		false,			"",		dfNone,				0,		false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,	 "eq_knd_cd",	false,		"",		 dfNone,			0,		false,		false);	   
					    
					//SELECT 로우 배경색      
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB); 
					//SelectionMode MultiSelection=false이면 1개의 행만 선택 가능           
					EditableColorDiff = false; 
					MultiSelection = false;  
					SelectionMode = smSelectionRow;  
					//선택시 하이라이트사용하지 않음   
					SelectHighLight = true;        
					//선택시 볼드 사용하지 않음              
					CountPosition = 0;        
					} 
				break;  
		        	   		
				case "sheet4":
	                with (sheetObj) { 
	                    // 높이 설정         
	                    style.height = 302; 
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
	
						var HeadTitle1 = "|S|Code|Less 20ft|Description";
						var headCount = ComCountHeadTitle(HeadTitle1); 
	  
	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                    InitColumnInfo(headCount + 4, 0, 0, true); 
	
	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다  
	                    InitHeadMode(true, true, false, true, false,false)
	  
	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                    InitHeadRow(0, HeadTitle1, true);     
	
	                    //데이터속성         [ROW, COL,  DATATYPE,          WIDTH,    DATAALIGN, COLMERGE,     SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 	30,    	daCenter,  	false,   	"ibflag");
						InitDataProperty(0, cnt++ , dtCheckBox,       20,    	daCenter,  	false,   	"checkbox");
						InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	true,		"eq_loc_cd",		 false,		"",		dfNone,				0,			false,		false);
						InitDataProperty(0, cnt++ , dtCheckBox,			60,		daCenter,	true,		"eq_less_20ft_flg",	 false,		"",		dfNone,				0,			false,		false);
						InitDataProperty(0, cnt++ , dtData,				80,		daLeft,		true,		"eq_loc_nm",		 false,		"",		dfNone,				0,			false,		false);
  						        	 	 	  
	  					//데이타 조작용 히든    
						InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,		"eq_loc_cd_lvl",	 false,		"",		dfNone,				0,		false,		false); 
						InitDataProperty(0, cnt++ , dtHidden,			0,		daLeft,		true,		"eq_loc_prnt_cd",	 false,		"",		dfNone,				0,		false,		false); 
						InitDataProperty(0, cnt++ , dtHidden,			0,			daLeft,		true,	 "eq_knd_cd",	false,		"",		 dfNone,			0,		false,		false);	   
						InitDataProperty(0, cnt++ , dtHidden,			0,			daLeft,		true,	 "eq_less_20ft_flg",	false,		"",		 dfNone,			0,		false,		false);	  						
					    	            	      
						//SELECT 로우 배경색                
						//SelectionMode MultiSelection=false이면 1개의 행만 선택 가능           
						EditableColorDiff = false;	
						MultiSelection = true;	 		                                              
						SelectionMode = smSelectionRow;  
						//선택시 하이라이트사용하지 않음            
						SelectHighLight = false;           
						//선택시 볼드 사용하지 않음        
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
	          		if (sheetObj.id == 'sheet1') { 
						for(i=0;i<sheetObjects.length;i++){
			            	sheetObjects[i].RemoveAll();    
			         	}               
	          			formObj.f_cmd.value = SEARCH;    
	          			formObj.f_type.value = 'grid';     
						   
						for(var i = 0; i < sheetObjects.length; i++){  
							sheetObjects[i].WaitImageVisible = false;
						} 
						var sXml = sheetObj.GetSearchXml("EES_MNR_0193GS.do", FormQueryString(formObj));
						var arrXml = sXml.split("|$$|");      
						                
						for(var i = 0; i < arrXml.length; i++){  
							sheetObjects[i].LoadSearchXml(arrXml[i]);
						}		 	                     
						//시트 초기 조회 sheet1만 보여준다.     
						for(var i = 1; i <= sheetObj.RowCount; i++){
							sheetObj.RowHidden(i) = false;                  
						}						         
	          		}    
	          	break;        
		   		
          	case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화 
          		MnrWaitControl(true);
                sheetObj.WaitImageVisible = false; 
	      	   	if (sheetObj.id == 'sheet1') {  
					 //모든 쉬트를 초기화    	   
					 for(i=0;i<sheetObjects.length;i++){
			            sheetObjects[i].RemoveAll(); 
						sheetClicks[i] = 0;  
			         }  	  
					 
				   	//콤보데이타 초기화 
					for(var i = 0; i < comboObjects.length;i++){ 
				 		 comboObjects[i].RemoveAll();	
					}	  
					
					//Sheet용 변수 
					var sheetComboText = "";  
					var sheetComboCode = ""; 
					var sheetComboDefault = "";
					
					var sCondition = new Array (
						new Array("MnrGenCd","", "CUSTOM9"),
						new Array("MnrEqLocCd","1","COMMON") 
					)		
						  
					var comboList = MnrComSearchCombo(sheetObj,sCondition); 
						
					formObj.eq_knd_cd.InsertItem(0,"ALL","ALL");
					if(comboList[0] != null){ 	   
						for(var j = 0; j < comboList[0].length;j++){ 
							var tempText = comboList[0][j].split("|");
							sheetComboCode +=  tempText[0] + "|";    
							sheetComboText +=  tempText[1] + "|"; 
							formObj.eq_knd_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);	
							
							if(j == 0){	    	     
								sheetComboDefault = tempText[0];           	
							}			  	 
						}	
						sheetObj.InitDataCombo(0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault); 				    
					}				 		 	 
						
					//초기값 설정
					if(MnrNullToBlank(formObj.rec_eq_knd_cd.value) == ""){
						formObj.eq_knd_cd.Code = "ALL"; 		
					} else {
						formObj.eq_knd_cd.Code = formObj.rec_eq_knd_cd.value;
					} 
					 
					formObj.key_value.InsertItem(0, 'ALL|ALL retrieve' ,'ALL');
					if(comboList[1] != null){ 	   
						for(var j = 0; j < comboList[1].length;j++){ 
							var tempText = comboList[1][j].split("|"); 
							formObj.key_value.InsertItem(j + 1, tempText[0] + '|' + tempText[1] ,tempText[0]);	
						} 	  
					}		
																					  	   
					if(MnrNullToBlank(formObj.rec_key_value.value) == ""){
						formObj.key_value.Code = "ALL"; 		
					} else {
						formObj.key_value.Code = formObj.rec_key_value.value;
					} 
	      	   	}
				MnrWaitControl(false);  
                sheetObj.WaitImageVisible = true;       
	      	   	break;     
        }               
    }   
	  
	/**
     * comPopupOK
     */
	function comPopupOK(sheetObj) { 
		var formObj = document.form;	
		var rArray = new Array(); //행데이터를 담고 있는 배열
	    var sRow = sheetObj.FindCheckedRow("checkbox");
	    //가져온 행을 배열로 반든다.	 	  	 	      
	    var arrRow = sRow.split("|"); 	   
		var cArray = new Array();   		  	   
	    for (idx = 0; idx < arrRow.length - 1; idx++){	     
			 //열데이터를 담고 있는 배열 		 	 
			cArray[idx] = sheetObj.CellValue(arrRow[idx], "eq_loc_cd");
		}	  
		opener.setEES_MNR_0193(cArray); 
		window.close();   	       		   	              	
	} 
	
	/* ********* User Functions ************* */ 
	/** 
	 * 클릭 이벤트 발생시 각시트 필터링      
	 * @param	{Number}	sheetIdx		필터링할 쉬트 인덱스
	 * @param 	{String}  	keyValue  		필터링할 조건값
	 * @param 	{Form}  	foreginKey  	keyValue로 필터링될 컬럼 
	 * 시트가 여러개일시 시트의 프라이머리키와 포린키가 동일한 패턴일 경우만 사용 
	 */ 
	function MnrSheetFiltering(sheetIdx,keyValue,foreginKey){ 
		for (var idx = 1; idx <= sheetObjects[sheetIdx].RowCount; idx++){
			if(sheetObjects[sheetIdx].CellValue(idx,foreginKey) == keyValue && sheetObjects[sheetIdx].CellValue(idx,'ibflag') != 'D'){
				sheetObjects[sheetIdx].RowHidden(idx) = false;   
			} else {         
				sheetObjects[sheetIdx].RowHidden(idx) = true; 
			}		      
		} 	 	    				  
	}    
           	
	/** 
	 * 쉬트가 여러게일 경우 해당 쉬트를 감춘다.
	 * @param 	{IBSheet} 	sheetObj	프로세스 처리될 시트오브젝트 
	 * 차후에 공통합수로 뺀다. 
	 */   	 	      
	function MnrAllSheetHidden(sheetObj){   
		for (var idx=1; idx <= sheetObj.RowCount; idx++){
			sheetObj.RowHidden(idx) = true;    	 
		}   	
	}   
	
	/* ********* Event Functions ************* */    
	function sheet4_OnChange(sheetObj,Row, Col, Value){
		var sRow = sheetObj.FindCheckedRow("checkbox");
		var arrRow = sRow.split("|");   
		
		//모두 지우고
		for (idx = 0; idx < arrRow.length - 1; idx++){
			sheetObj.CellValue2(arrRow[idx],"checkbox") = "0"; 
			sheetObj.RowBackColor(arrRow[idx]) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
		}		 
							
		//선택된 놈만 다시 선택  
		sheetObj.CellValue2(Row,"checkbox") = "1";   
		sheetObj.RowBackColor(Row) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
	}
	
	/**  
	 * sheet3 클릭 이벤트    
	 * @param	{IBSheet}		sheetObj	쉬트오브젝트  
	 * @param 	{Number} 		Row 		클릭된 row 
	 * @param 	{Number} 		Col 		클릭된 col
	 * @param 	{String} 		Value 		클릭된 값  
	 */            
	function sheet3_OnClick(sheetObj,Row,Col,Value){    
		sheetClicks[2] = Row;        
	    
		var keyValue = sheetObj.CellValue(Row,"eq_loc_cd");
		  	   
		for(var i = 3; i < sheetObjects.length; i++){   
			MnrAllSheetHidden(sheetObjects[i]); 
			sheetClicks[i] = 0;                         	
		}          
		MnrSheetFiltering(3,keyValue,"eq_loc_prnt_cd");		
	}        
	
	/**  
	 * sheet2 클릭 이벤트    
	 * @param	{IBSheet}		sheetObj	쉬트오브젝트  
	 * @param 	{Number} 		Row 		클릭된 row 
	 * @param 	{Number} 		Col 		클릭된 col
	 * @param 	{String} 		Value 		클릭된 값  
	 */       
	function sheet2_OnClick(sheetObj,Row,Col,Value){     
		sheetClicks[1] = Row;            
		
		var keyValue = sheetObj.CellValue(Row,"eq_loc_cd");
		
		for(var i = 2; i < sheetObjects.length; i++){    
			MnrAllSheetHidden(sheetObjects[i]);     
			sheetClicks[i] = 0;                       	
		}       
		MnrSheetFiltering(2,keyValue,"eq_loc_prnt_cd");		
	}         
	  
	/**  
	 * sheet1 클릭 이벤트    
	 * @param	{IBSheet}		sheetObj	쉬트오브젝트  
	 * @param 	{Number} 		Row 		클릭된 row 
	 * @param 	{Number} 		Col 		클릭된 col
	 * @param 	{String} 		Value 		클릭된 값  
	 */      
	function sheet1_OnClick(sheetObj,Row,Col,Value){  
		sheetClicks[0] = Row;    
		                        
		var keyValue = sheetObj.CellValue(Row,"eq_loc_cd"); 
		 
		for(var i = 1; i < sheetObjects.length; i++){ 
			MnrAllSheetHidden(sheetObjects[i]); 
			sheetClicks[i] = 0;                                     	
		}          
		MnrSheetFiltering(1,keyValue,"eq_loc_prnt_cd");	
	}                
	
	/* 개발자 작업  끝 */ 
