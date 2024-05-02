/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0225.js
*@FileTitle : Division Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13 	
*@LastModifier : 박명신
*@LastVersion : 1.0	
* 2009.10.13 박명신   
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
     * @class EES_MNR_0225 : EES_MNR_0225 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0225() { 
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

// 로그인 유저의 Office 레벨 : HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴 (CoMnr.js에서
// MnrOfficeLevel 함수에 의해 셋팅)
var strMnrOfficeLevel = "";

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
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;

				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					setSaveBtnDisplay();
					break;
					
				case "btn_Save": 
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
 
				case "btn_RowAdd": 
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;

				case "btn_RowDelete":  
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
					break; 
					 
				case "btn_RowCopy":   
					doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
					break;
					
				case "btn_Excel1":
					sheetObjects[0].SpeedDown2Excel(-1);    
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

		// Office Level 조회 및 전역변수(strMnrOfficeLevel)에 세팅
		MnrOfficeLevel(currOfcCd, rhqOfcCd);
		
		MnrWaitControl(true);  
		initControl();    
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		
        for(k=0;k<comboObjects.length;k++){ 
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
	    var formObject = document.form
	 	 	   	
	    switch(comboNo) {      
			   default :   
		           with (comboObj) { 
				       //SetColAlign("left");         
					   //DropHeight = 160;     
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
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
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
                    InitRowInfo( 1, 1, 6, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);		

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)
					
                    var HeadTitle1 = "|Sel|Seq.|Tariff Group|Component Code|Repair Code|Division Code|Man-Hour|Description";
							
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]		
                    InitHeadRow(0, HeadTitle1, true);											
 
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,	"ibflag");	
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,		true,	"del_chk");		
					InitDataProperty(0, cnt++ , dtDataSeq,	 	30,		daCenter,		true,	"Seq");			
                    InitDataProperty(0, cnt++ , dtCombo,  		130,	daCenter,		true,	"cost_grp_cd",		true,	"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtComboEdit,	120,	daCenter,		true,	"eq_cmpo_cd",		true,	"",		dfNone,			0,	true,	true,	3,	true);
					InitDataProperty(0, cnt++ , dtComboEdit,	90,		daCenter,		true,	"eq_rpr_cd",		true,	"",		dfNone,			0,	true,	true,	2,	true);
					InitDataProperty(0, cnt++ , dtData,      	100,    daLeft,    		true,   "to_rlt_cd",     	true,   "",     dfNone, 	    0,  true,   true,   2);
					InitDataProperty(0, cnt++ , dtData,  		80,		daRight,		true,	"rpr_lbr_hrs",		false,	"",	    dfNullFloat, 	2,	true,	true,	6,	false);
					InitDataProperty(0, cnt++ , dtData,      	130,    daLeft,    		true,   "mnr_rlt_cd_desc",  false,  "",     dfNone, 		0,  true,   true);
												 	 			  	 
					//hidden 
					InitDataProperty(0,	cnt++,	dtHidden,		0,		daRight,		true,	"fm_rlt_cd",		false,	"",	dfNone,		0,	true,	true);					
					InitDataProperty(0,	cnt++,	dtHidden,		0,		daRight,		true,	"eq_cedex_rlt_tp_cd",		false,	"",	dfNone,		0,	true,	true);					
		     		
					//데이터 Validation
					InitDataValid(0,"eq_cmpo_cd",vtEngUpOnly);   
					InitDataValid(0,"eq_rpr_cd", vtEngUpOnly);  
					InitDataValid(0,"to_rlt_cd", vtEngUpOther,"0123456789");  
									
					CountPosition = 0; 
				}
                break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
              	if(validateForm(sheetObj,formObj,sAction)){
			  		var f_query = ''; 		        
					f_query += 'f_cmd' + '=' + SEARCH + '&'; 
					f_query += 'in_cost_grp_cd=' +  formObj.in_cost_grp_cd.Code  + '&'; 
					f_query += 'in_eq_cmpo_cd=' +  formObj.in_eq_cmpo_cd.value;    
     				sheetObj.DoSearch4Post("EES_MNR_0225GS.do",f_query); 	
			  	}		
                break;	   	
				  	   			
			case IBSAVE:        //저장 
              	if(validateForm(sheetObj,formObj,sAction)){   
			  		formObj.f_cmd.value = MULTI;    
					var sParam = ComGetSaveString(sheetObj);
					//필수 입력 체크
					if(sParam == "" && sheetObj.IsDataModified){ 
						return; 		
					} 
					 sParam += "&" + FormQueryString(formObj);
					var sXml = sheetObj.GetSaveXml("EES_MNR_0225GS.do", sParam);
					sheetObjects[0].LoadSaveXml(sXml);          
			  	} 
                break;

			case IBINSERT:      // 행입력 
				var Row = sheetObj.DataInsert(-1);		 
				//set Value Init
				sheetObj.CellValue2(Row, "eq_cedex_rlt_tp_cd")	= "CTV";  
				sheetObj.CellValue2(Row, "eq_cmpo_cd")	= "";  
				sheetObj.CellValue2(Row, "eq_rpr_cd")	= "";   
                break;  
				 
			case IBDELETE:      // 행삭제  
				ComRowHideDelete(sheetObj,  "del_chk"); 
                break;
				
			case IBCOPYROW:	
				if(sheetObj.SelectRow < 1){
					ComShowCodeMessage("MNR00282");    
				} else {
					var Row 	  = sheetObj.SelectRow; 
					var costGrpCd = sheetObj.CellValue(Row,"cost_grp_cd"); 
					var eqCmpoCd  = sheetObj.CellValue(Row,"eq_cmpo_cd"); 
					var eqRprCd   = sheetObj.CellValue(Row,"eq_rpr_cd");
					var fmRltCd   = sheetObj.CellValue(Row,"fm_rlt_cd"); 
					  
					var newRow = sheetObj.DataInsert(-1);
					sheetObj.CellValue2(newRow, "eq_cedex_rlt_tp_cd")	= "CTV";   
					sheetObj.CellValue2(newRow, "eq_cmpo_cd")			= eqCmpoCd;    
					sheetObj.CellValue2(newRow, "eq_rpr_cd")			= eqRprCd;      
					sheetObj.CellValue2(newRow, "fm_rlt_cd")			= fmRltCd;       
					sheetObj.CellValue2(newRow, "to_rlt_cd")			= "";       
					sheetObj.CellValue2(newRow, "mnr_rlt_cd_desc")		= "";    
					sheetObjects[0].SelectCell(newRow,"to_rlt_cd");        
				}
				break;
				
			case IBCLEAR:	
				MnrWaitControl(true);  
				sheetObj.WaitImageVisible=false; 
				//폼초기화 
				formObj.reset();
				//쉬트 초기화 
				sheetObjects[0].RemoveAll(); 
				//콤보 초기화 
				for(var i = 0; i < comboObjects.length;i++){ 
					if(i != 0 && i != 3){
						comboObjects[i].Code = "-1"; 
						comboObjects[i].RemoveAll(); 	
					}
				}   
					
				var sCondition = new Array (
					new Array("MnrGenCd","CC", "COMMON") 
				)
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
				//Tariff Type	
				comboObjects[0].InsertItem(0,"ALL","ALL");
				if(comboList[0] != null){ 	        
					for(var j = 0; j < comboList[0].length;j++){  
						var tempText = comboList[0][j].split("|");  
						comboObjects[0].InsertItem(j + 1, tempText[1] ,tempText[0]);
					}	     
				}   
				comboObjects[0].Code = "ALL"; 	
				
				//쉬트 콤보 설정
				var sCondition = new Array (	  
					new Array("MnrGenCd","CC", "COMMON"), 
					new Array("MnrCedexOthCd","RPR","COMMON"), 	//RPR
					new Array("MnrEqCmpoCd","3","COMMON")  	
				) 	
				var sheetComboList = MnrComSearchCombo(sheetObjects[0],sCondition);
								
				var sheetComboText = "";   
				var sheetComboCode = "";
				var sheetComboDefault = "";
						
				var comboSaveNames = new Array();
				comboSaveNames[0] = "cost_grp_cd";
				comboSaveNames[1] = "eq_rpr_cd";    
				comboSaveNames[2] = "eq_cmpo_cd";  
				        
					      
				for(var i = 0; i < sheetComboList.length;i++){
				 	if(sheetComboList[i] != null){	
						//쉬트콤보별 초기화
						sheetComboText = "";
						sheetComboCode = "";
						sheetComboCodeText = "";	
								   
				 		for(var j = 0; j < sheetComboList[i].length;j++){	 
							var tempText = sheetComboList[i][j].split("|");       
								 
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
						}			    		
																											
			   	     	sheetComboText = MnrDelLastDelim(sheetComboText);  
				        sheetComboCode = MnrDelLastDelim(sheetComboCode);
				        sheetComboCodeText = MnrDelLastDelim(sheetComboCodeText); 
						  		 					 	
						if(comboSaveNames[i] == "cost_grp_cd"){ 		
							sheetObjects[0].InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,"");	
						} else {  	 
							sheetObjects[0].InitDataCombo (0, comboSaveNames[i], sheetComboCodeText, sheetComboCode ,"");
						}            								
					}    	    
				} 
				sheetObj.WaitImageVisible=true;  	
				MnrWaitControl(false);     		
				break;
				
			case IBSEARCH_ASYNC01:        //Component Code 체크    	    
	            if(validateForm(sheetObj,formObj,sAction)){
					var checkComp = formObj.in_eq_cmpo_cd.value;   
									 	 		 			
					retArray = MnrGeneralCodeCheck(sheetObj,"COMP",checkComp);       
					if(retArray == null){               
						ComShowCodeMessage("MNR00165",checkComp);       				
						ComSetObjValue(formObj.in_eq_cmpo_cd, "");   	    
						ComSetObjValue(formObj.eq_cmpo_nm, "");  	    
						ComSetFocus(formObj.in_eq_cmpo_cd);                      
					} else {      
						var retValue = retArray[0].split("|");    
						ComSetObjValue(formObj.eq_cmpo_nm,retValue[1]);     
						return;      
					}  
				}		
				break;	
        }
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
					 
				case IBSAVE: 
				 	break;
			}			
        }
		 
        return true;
    }
	
	function sheet1_OnChange(sheetObj, Row, Col, Value) 
    {		
		var formObject = document.form;	
		
		if(sheetObj.ColSaveName(Col) == "eq_cmpo_cd" || sheetObj.ColSaveName(Col) == "eq_rpr_cd"){    
			var msgTarget = "";
			if(sheetObj.ColSaveName(Col) == "eq_cmpo_cd"){
				msgTarget = "Component Code";
			} else {
				msgTarget = "Repair Code";
			}
			  
			var checkColNm = sheetObj.ColSaveName(Col); 		
			var checkCd =  sheetObj.CellValue(Row,checkColNm);
			var isPossible = false;     
			
			var sCode = sheetObj.GetComboInfo(Row,checkColNm,"Code");
			var arrCode = sCode.split("|");		
								
			for(var i = 0;i < arrCode.length;i ++){
				if(arrCode[i] == checkCd){
					isPossible = true;	
				}   	
			}				
								  
			if(!isPossible){ 
				ComShowCodeMessage("MNR00010",msgTarget); 
				sheetObj.CellValue2(Row ,checkColNm) = "";      
				sheetObj.SelectCell(Row ,checkColNm);    
				return;	   
			}  	   	 
				 			
			//둘다 맞게 선택 했다면 
			sheetObj.CellValue2(Row ,"fm_rlt_cd") = sheetObj.CellValue(Row ,"eq_cmpo_cd") + sheetObj.CellValue(Row ,"eq_rpr_cd"); 
		}     	 	
    }
		
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") {   
			ComShowCodeMessage("MNR00023","Division Type Code ");  
		}        
	}  
	 
	function initControl() {        
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
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
	    		case "in_eq_cmpo_cd":    
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;    
			}       
	    } else {
			switch(obj.name) {       
	    		case "in_eq_cmpo_cd":  
					formObj.eq_cmpo_nm.value = "";
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
				ComKeyOnlyAlphabet('uppernum');           
	            break; 
	    }         
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