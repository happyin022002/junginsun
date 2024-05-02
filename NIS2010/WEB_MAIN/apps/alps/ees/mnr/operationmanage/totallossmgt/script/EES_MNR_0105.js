/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0105.js
*@FileTitle : Total Loss Payment to Lessor Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.06 민정호
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
     * @class EES_MNR_0105 : EES_MNR_0105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0105() {
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
    
    var initLoader = 0;
    
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
					case "btn_retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
					case "btn_new":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						break;	
					case "btn_downexcel":
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
						break;    
   					case "btn_calendar": 
   						var cal = new ComCalendarFromTo();
   						cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');       						
   						break;	     
   						//멀티입력
   					case "eq_no_multi": 
   					    rep_Multiful_inquiry("eq_no");  
   						break;    			
   					case "tln_multi":  
   					    rep_Multiful_inquiry("total_loss_no"); 
   						break;
   					case "btn_provider_popup":
   					    ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
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
    
    /**
     * IBSheet Object를 배열로 등록
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
    } 	
    
    /**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {        
	    var formObject = document.form
	    switch(comboNo) {          	    
	        case 1: 
	           	with (comboObj) { 
        	   	SetColAlign("left|left");        
		       	SetColWidth("80|100");      
			   	DropHeight = 160;  
				UseAutoComplete = true;
		    	}      
	        	break;         
	        case 2: 
	           	with (comboObj) { 
        	   	SetColAlign("left");        
		       	SetColWidth("130");      
			   	DropHeight = 160;  
				UseAutoComplete = true;
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
                    style.height = 382;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
						
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);
 
                    var HeadTitle1 = "|Seq.|Lessor\nCode|Lessor Name|EQ Type|EQ No.|INVOICE NO|TLL NO|REQUEST\nDATE|APPROVAL\nDATE|MAIN\nREASON|COMPLETE\n(Y/N)|TLL DT|D.V Value|Collection\nTotal(USD)|AGMT NO";                    
                                        
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(16, 4, 0, false);    					
							
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    // InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])         
                    InitHeadMode(true, false, false, true, false, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
											
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,		"iflag");
                    InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"seq");                    
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"lessor_cd",		false,		"",			dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			270,	daLeft,		true,		"lessor_nm",		false,		"",			dfNone,			0,		true,		true);
                    InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter, 	true,		"eq_type",		 	false,		"",			dfNone,			0,		true,		true);                                                              
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"eq_no",		 	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,		"inv_no",		 	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	true,		"ttl_lss_no",	 	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"rqst_dt",		 	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"ttl_lss_cfm_dt",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"ttl_lss_rsn_nm",	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,		"cmpl_flg",		 	false,		"",			dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"tll_dt",		 	false,		"",			dfNone,			0,		true,		true);                        
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	true,		"dv_value",		 	false,		"",			dfNumber,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daRight,	true,		"clt_amt",		 	false,		"",			dfNumber,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		"agmt_no",		 	false,		"",			dfNone,			0,		true,		true);
			}
			break;  		
        }
    }
	
	
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction))
					if (sheetObj.id == "sheet1"){
						formObj.f_cmd.value = SEARCH;     						
						sheetObj.DoSearch("EES_MNR_0105GS.do",FormQueryString(formObj));
					}
				break;
				
			case IBCLEAR:        //초기화
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
				if(initLoader == 0){
					//콤보 초기화 
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();       
					}   							
						
//					//콤보초기화
//					formObj.combo_ttl_lss_sts_cd.Code2=-1;
//					var sCondition = new Array (
//							new Array("MnrGenCd",formObj.self_ofc_cd.value,"CUSTOM9")	//EQ Type
//						   ,new Array("MnrGenCd","CD00039", "COMMON") 	//Status  
//					);   
//					var comboList = MnrComSearchCombo(sheetObj,sCondition);
//					var sheetComboText = "";	
//					var sheetComboCode = "";
//					var sheetComboCodeText = "";	
//					var sheetComboDefault = "";
//					for(var i=0; i<comboList.length; i++)
//					{	
//						sheetComboText = "";
//						sheetComboCode = "";
//						sheetComboCodeText = "";
//						sheetComboDefault = ""; 
//						if(comboList[i] != null)
//						{
//							for(var j = 0; j < comboList[i].length;j++)
//							{   
//								var xmlVal = comboList[i][j].split("|");  
//								if(i==0){
//									formObj.combo_eq_type.InsertItem(j, xmlVal[1] ,xmlVal[0]);
//									sheetComboText +=  xmlVal[1] + "|";
//									sheetComboCode +=  xmlVal[0] + "|";
//									sheetComboCodeText +=  xmlVal[0] + "\t" + xmlVal[1] + "|";
//									if(j ==0){	
//										sheetComboDefault = xmlVal[0];      	
//									}
//								}else if(i==1){
//									formObj.combo_ttl_lss_sts_cd.InsertItem(j, xmlVal[1] , xmlVal[0]);
//								}
//							}	
//							if(i==0){
//								formObj.combo_eq_type.InsertItem(0, "ALL" ,"A" );
//								formObj.combo_eq_type.Code = "A";
//								formObj.eq_type.value = formObj.combo_eq_type.Code;     
//								sheetObjects[0].InitDataCombo (0, "eq_type", sheetComboText, sheetComboCode ,sheetComboDefault);
//							}else if(i==1){
//						 		formObj.combo_ttl_lss_sts_cd.InsertItem(0, "ALL" ," " );
//						 		formObj.combo_ttl_lss_sts_cd.Code = " ";
//						 		formObj.ttl_lss_sts_cd.value = formObj.combo_ttl_lss_sts_cd.Code;   
//							}
//						}
//						else
//						{
//							if(i==0){
//								ComShowCodeMessage("MNR00005", "EQ Type   ");
//							}else if(i==1){
//								ComShowCodeMessage("MNR00005", "Status    ");
//							}
//						}
//					}							
					
					
					initLoader = 1;	
				}

				//쉬트 초기화   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();    
		        }  
				
//		 		formObj.combo_eq_type.Code = "A";	
//		 		formObj.combo_ttl_lss_sts_cd.Code = " ";	
//		 		formObj.eq_no.value = "";
//		 		formObj.total_loss_no.value = "";
//		 		formObj.lessor.value = "";
//		 		formObj.vndr_lgl_eng_nm.value = "";
							    	
				formObj.from_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
				formObj.to_dt.value = ComGetNowInfo();
		 											
				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);    			
				break;
				
			case IBDOWNEXCEL:
			    sheetObj.SpeedDown2Excel(-1);   
				break;
				
			case IBSEARCH_ASYNC01:	//조회(sevice provider No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					if(Number(formObj.lessor.value)){
						//서비스 프로바이더 조회     
						var sCondition = new Array (  
							new Array("MdmVendor",formObj.lessor.value,"COMMON")
						)	                             
						//조회 값이 있다면 세팅 
						var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
						if(comboList[0] != null){   
							var tempText = comboList[0][0].split("|");  
							formObj.vndr_lgl_eng_nm.value  = tempText[1];   
						} else {        
							ComShowCodeMessage("MNR00005", "Lessor");              
							ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
							ComSetObjValue(formObj.lessor, "");	 
							ComSetFocus(formObj.lessor);	 
						}  	
					} else {        
						ComShowCodeMessage("MNR00005", "Lessor");              
						ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
						ComSetObjValue(formObj.lessor, "");	 
						ComSetFocus(formObj.lessor);	 
					}  	
				}	
				break;	 			
        }
    }
    
	/**  
	 * combo_eq_type Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo_eq_type_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;        
		formObj.eq_type.value = comboObj.Code;   
	}      
	/**  
	 * combo_ttl_lss_sts_cd Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo_ttl_lss_sts_cd_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;        
		formObj.ttl_lss_sts_cd.value = comboObj.Code;   
	}   
     
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){ 	       
        	switch(sAction) { 	 
				case IBSEARCH:
					if (!ComChkValid(formObj)) return false;
				 	break;				
			}   
		}
        return true;
    }    
	
 	/**
 	 * rep_Multiful_inquiry 사용시 받는부분  
 	 * 소스에 붙여서 사용하세요          
 	 * Location : 팝업에서 단일 선택을 한경우..     
 	 */      
 	function getMnr_Multi(rowArray,return_val) {
 		var formObj = document.form;  
 		var tempText = ""; 	
 		//초기화	   
 		if(return_val == "eq_no"){
 			formObj.eq_no.value = '';
 		}else{
 			formObj.total_loss_no.value = '';
 		}
 		for(var i=0; i<rowArray.length; i++) {   
 			var colArray = rowArray[i];     
 			tempText +=  rowArray[i] + ','; 	  
 		}      
 		//마지막에 ,를 없애기 위함     
 		tempText = MnrDelLastDelim(tempText);	 
 					 	    
 		tempText = tempText.toUpperCase(); 	            
 		eval("document.form." + return_val + ".value = '" + tempText + "';"); 
 	}      
 	
	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;   
  			
		if ( aryPopupData.length > 0 ) {
			formObj.lessor.value = aryPopupData[0][2];
			formObj.vndr_lgl_eng_nm.value  = aryPopupData[0][4];
		}
	} 	
	     
	function initControl() {        
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',		formObject);            
	} 	 	            
		   	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement); 
	} 
	
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	} 	       
				
	function obj_change(){	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {	 	
			switch(obj.name) {	 			      
	    		case "lessor":  				   
					formObj.lessor.value =  ComLpad(formObj.lessor.value,6,"0"); 
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break; 		  
			}       
	    } else {		
			switch(obj.name) {      
	    		case "lessor":       
					ComSetObjValue(formObj.vndr_lgl_eng_nm,"")  
				   	break;   	
			}	  		
		}
	}    
			        
	function obj_keypress(){   
	    obj = event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
					 			              
	    switch(obj.dataformat) {   
	        case "ymd":	   
	        case "int":       
				ComKeyOnlyNumber(obj); 
	            break;     
	        case "float":   	 
	            ComKeyOnlyNumber(obj, "-.");
	            break;					 
	        case "eng": 	   
	            ComKeyOnlyAlphabet();
				break;								 						  
	        case "engup":  
				if(obj.name == "lessor"){ 							 
					ComKeyOnlyAlphabet('uppernum');			
				} else {	
					ComKeyOnlyAlphabet('uppernum','44');
				}	
	            break; 
	    }         
	}
	/* 개발자 작업  끝 */