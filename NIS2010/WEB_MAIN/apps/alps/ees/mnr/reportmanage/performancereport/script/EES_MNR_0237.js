/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0237.js
 *@FileTitle : MNR PFMC by Account/Cost Code	
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.12
 *@LastModifier : 박명신		
 *@LastVersion : 1.0
 * 2009.10.12 박명신
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
 * @class EES_MNR_0237 : EES_MNR_0237 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MNR_0237() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// TS타입일 경우 타입사이즈 배열 eq_type 별 3가지 모두 틀림
var uTpSz = new Array();
var gTpSz = new Array();
var zTpSz = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_New":
			doActionIBSheet(sheetObject, formObject, IBCLEAR);
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
		case "btn_calendar":  
			var cal = new ComCalendarFromTo();
			cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
			break;
		case "btn_provider_popup":
			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp','1,0,1,1,1,1,1,1', true);
			break;
		} // end switch 
	} catch (e) {
		if (e == "[object Error]") {
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
function setSheetObject(sheet_obj) {
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
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1, '');   
		ComEndConfigSheet(sheetObjects[i]);
	}
   	
	//IBMultiCombo초기화 
    for(var k=0;k<comboObjects.length;k++){ 
       initCombo(comboObjects[k],k + 1);  
    }	
   
    //타입사이즈는 처음 한번만 가져온다.		
    setTpSzArray(sheetObjects[0]); 	 
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
				MultiSeparator = "|";
				SetTitle("Period|Amount");	
				SetColAlign("left|left");		        
				SetColWidth("100|100");			     
				DropHeight = 160;		         
				UseAutoComplete = true;		
  		    }        
        	break; 	     
         case 2: 
           	with (comboObj) { 
           		MultiSelect = true; 
          	   	SetColAlign("left");        
  		       	SetColWidth("80");      
  			   	DropHeight = 160;  
  			   	UseAutoComplete = true;
  		    }          
        	break;   
         case 3:	 	
           	with (comboObj) { 
				MultiSelect = true; 
				UseAutoComplete = true;	
				SetColAlign("left");
				SetColWidth("230");  
				DropHeight = 200;
		    }          
        	break; 	 
         case 4:	 
           	with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
	   	   		SetColAlign("left|left");        
				//SetColWidth("100|150"); 
			   	DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
        	break; 
		 case 5: 	
			with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Code|Country Name");
				SetColAlign("left|left");	        
				//SetColWidth("100|150");	     
				DropHeight = 160;		         
				UseAutoComplete = true;
			}      
			break;	
         case 6: 
           	with (comboObj) { 
				MultiSelect = true; 
				MultiSeparator = ",";
				SetTitle("Office Code|Office Name");
	   	   		SetColAlign("left|left");        
				//SetColWidth("100|150");
			   	DropHeight = 160;  
				UseAutoComplete = true;
				MaxLength = 600;				
	    	}      
        	break;
		 case 7: 
           	with (comboObj) {
           		MultiSelect = true;
   	   			SetColAlign("left");        
	       		SetColWidth("80");      
		   		DropHeight = 160;  
				UseAutoComplete = true;
	    	}      
        	break;
		 case 8: 
           	with (comboObj) { 
   	   			SetColAlign("left");        
	       		SetColWidth("80");      
		   		DropHeight = 160;  
				UseAutoComplete = true;
	    	}		   	   
        	break;	
		 case 9:
           	with (comboObj) { 	
   	   			SetColAlign("left");        
	       		SetColWidth("80");      
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
function initSheet(sheetObj,sheetNo,sheetHeadTitle) {
    var cnt = 0;
	var sheetID = sheetObj.id;
							
    switch(sheetID) {   	 	
        case "sheet1":
            with (sheetObj) {	
               // 높이 설정
                    style.height = 382;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(17, 0, 0, true);	   

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);  
  						
                    var HeadTitle = "|Seq.|Account Code|Cost Code|Description|RHQ.|Country|Office|S/P Code|S/P Name|CURR|Repair QTY|Total AMT|Average AMT|TP/SZ";	
   					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
					 	
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,    	daCenter,  	false,     "ibflag"); 
                    InitDataProperty(0, cnt++ , dtDataSeq,    		90,     daCenter,  	true,      "Seq",     			false,          "",      dfNone);
                    InitDataProperty(0, cnt++ , dtData,      		90,     daCenter,  	false,     "acct_cd",     		false,          "",      dfNone     	,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,      		180,    daLeft,  	false,     "cost_cd_nm",     	false,          "",      dfNone     	,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,      		180,    daLeft,  	false,     "cost_dtl_cd_nm", 	false,          "",      dfNone     	,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,      		60,     daCenter,  	false,     "rhq_cost_ofc_cd",   false,          "",      dfNone     	,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,		 		120,	daLeft,		false,	   "cnt_nm",			false,			"",      dfNone     	,		0,			false,		false);  
					InitDataProperty(0, cnt++ , dtData,      		60,     daCenter,  	false,     "cost_ofc_cd",     	false,          "",      dfNone     	,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,      		80,     daLeft,  	false,     "vndr_seq",     		false,          "",      dfNone     	,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,      		150,    daLeft,  	false,     "vndr_nm",     		false,          "",      dfNone     	,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,      		60,     daCenter,  	false,     "curr_cd",     		false,          "",      dfNone     	,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtAutoSumEx, 		70,    daRight,  	false,     "total_qty",     	false,          "",      dfInteger  ,		0,			false,		false);   
                    InitDataProperty(0, cnt++ , dtAutoSumEx, 		100,    daRight,  	false,     "total_amt",     	false,          "",      dfFloat    ,		2,			false,		false);   
                    InitDataProperty(0, cnt++ , dtAutoSumEx, 		100,    daRight,  	false,     "avg_amt",     		false,          "",      dfFloat    ,		2,			false,		false);   
                    InitDataProperty(0, cnt++ , dtData,      		70,     daCenter,  	false,     "eq_tpsz_cd",     	false,          "",      dfNone     	,		0,			false,		false);   
																										
					//hidden	
					InitDataProperty(0, cnt++ , dtHidden,      	0,    daCenter,  false,     "cost_cd",     		false,          "",      dfNone     	,		0,			false,		false); 
					InitDataProperty(0, cnt++ , dtHidden,      	0,    daCenter,  false,     "cost_dtl_cd",     	false,          "",      dfNone     	,		0,			false,		false); 
																								   	  
					//로우한개씩 선택          
					MultiSelection = false;     
					SelectionMode = smSelectionRow;  
					//선택시 하이라이트 함       
					SelectHighLight = true;         
					//선택시 볼드체 변경 안함           
					SelectFontBold = false;  
					//SELECT 로우 배경색             
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);    
					CountPosition = 2;
		}				
    }
}

//Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj, formObj, sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {
 		case IBSEARCH:      //조회
 			if(validateForm(sheetObj,formObj,sAction)){	
				formObj.f_cmd.value = SEARCH;		   	  		
						
				if(formObj.temp_usd_only.checked){	
					formObj.usd_only.value = "Y"; 
				} else {		
					formObj.usd_only.value = "N";  
				}		
																		
				var sParam = FormQueryString(formObj);		
										
 				sheetObj.DoSearch4Post("EES_MNR_0237GS.do",sParam);			
 			}		
 			break;
		
 		case IBCLEAR:        //초기화
 			MnrWaitControl(true);
 		    sheetObj.WaitImageVisible = false;
			
			//쉬트 초기화   
 			for(i=0;i<sheetObjects.length;i++){   
 				sheetObjects[i].RemoveAll();    
 	        }  
			
			//콤보 초기화 
			for(var i = 0; i < comboObjects.length;i++){ 
				comboObjects[i].RemoveAll();       
			}  			
				
			//공통콤보 정보를 가져온다.    
			var sCondition = new Array ( 
				new Array("MnrGenCd","","CUSTOM9"), 
				new Array("MnrGenCd","CD00091", "COMMON"),		
				new Array("MdmOrganization","RHQ","FALSE"),
				new Array("MnrGenCd","CD00083", "COMMON")  
			)
									
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
				
			//EQ Type   
			formObj.eq_type.InsertItem(0,"ALL","A");
						
			var defEqType = "";
			if(comboList[0] != null){	       
				for(var j = 0; j < comboList[0].length;j++){ 
					var tempText = comboList[0][j].split("|");   
					formObj.eq_type.InsertItem(j + 1, tempText[1] ,tempText[0]);
				} 			    	    
			}	 	     		
			formObj.eq_type.Code = "A";
			 
			//Report Type Period
			if(comboList[1] != null){	       
				for(var j = 0; j < comboList[1].length;j++){ 
					var tempText = comboList[1][j].split("|");   
					var codeAmt = tempText[1].replace("=","|");
					formObj.report_period_type.InsertItem(j,codeAmt ,tempText[0]);
				}								     	    
			}					     
			formObj.report_period_type.Code = "WI";	
												
			//Regional HQ   
			formObj.rhq.InsertItem(0,"ALL","A");	
			if(comboList[2] != null){		       
				for(var j = 0; j < comboList[2].length;j++){	 
					var tempText = comboList[2][j].split("|"); 	 
					formObj.rhq.InsertItem(j + 1, comboList[2][j] ,tempText[0]);
				}	     	    
			}		
			formObj.rhq.Code = "A";	  
				
			//Account Code 세팅        
			formObj.acct_cd.InsertItem(0,"ALL","A");		  
			if(comboList[3] != null){	    
				for(var j = 0; j < comboList[3].length;j++){  
					var tempText = comboList[3][j].split("|");  
					formObj.acct_cd.InsertItem(j + 1,comboList[3][j] ,tempText[0]);
				} 					      
			}					
		    //formObj.acct_cd.Code = "A";		 	  	
 							
			//초기값 세팅		 				
			formObj.fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
			MnrSetFromDate(formObj.fm_dt);			
 			formObj.to_dt.value = ComGetNowInfo(); 
 																				
 			formObj.vndr_seq.value = ""; 
 			formObj.vndr_lgl_eng_nm.value = ""; 
 					
 			sheetObj.WaitImageVisible = true;	
 			MnrWaitControl(false); 	 				
 			break;
			
		case IBSEARCH_ASYNC01:	//조회(sevice provider No. 입력시)
			sheetObj.WaitImageVisible = false;
			if ( validateForm(sheetObj, formObj, sAction) ) { 
				if(Number(formObj.vndr_seq.value)){
					//서비스 프로바이더 조회     		
					var sCondition = new Array ( 		 
						new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
					)  	                           
					//조회 값이 있다면 세팅	
					var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
					if(comboList[0] != null){	  	
						var tempText = comboList[0][0].split("|");  
						formObj.vndr_lgl_eng_nm.value  = tempText[1];   
					} else {	        
						ComShowCodeMessage("MNR00005", "Service Provider");              
						ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
						ComSetObjValue(formObj.vndr_seq, "");   
						ComSetFocus(formObj.vndr_seq);	 	 
					}		 	 
				} else {	        
					ComShowCodeMessage("MNR00005", "Service Provider");              
					ComSetObjValue(formObj.vndr_lgl_eng_nm, "");  
					ComSetObjValue(formObj.vndr_seq, "");   
					ComSetFocus(formObj.vndr_seq);	 	 
				}		 	 
			}	
			sheetObj.WaitImageVisible = true;	
			break;
			
		case IBSEARCH_ASYNC02:	//조회(EQ TYPE 콤보 변경시)
			sheetObj.WaitImageVisible = false;
			if ( validateForm(sheetObj, formObj, sAction) ) { 
				//Cost Code						
				formObj.cost_cd.RemoveAll(); 
				var sCondition = new Array ( 		 
					new Array("MnrGenCd",formObj.eq_type.Code + "G", "COMMON")
				)  	                           
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
				
				formObj.cost_cd.InsertItem(0,"ALL","A");		  
				if(comboList[0] != null){		    
					for(var j = 0; j < comboList[0].length;j++){  
						var tempText = comboList[0][j].split("|");  
						formObj.cost_cd.InsertItem(j + 1,tempText[1] ,tempText[0]);
					} 			      
				}		
			    formObj.cost_cd.Code = "A";  			  		 
			}		
			sheetObj.WaitImageVisible = true;
			break;
			
		case IBSEARCH_ASYNC03:	//조회(COST_CD 콤보 변경시)
			sheetObj.WaitImageVisible = false;
			if ( validateForm(sheetObj, formObj, sAction) ) { 
				formObj.cost_dtl_cd.RemoveAll();	 
				var sCondition = new Array ( 			 
					new Array("MnrGenCd",formObj.cost_cd.Code, "COMMON")
				)  	                           
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
					 
				formObj.cost_dtl_cd.InsertItem(0,"ALL","A");			  
				if(comboList[0] != null){		    
					for(var j = 0; j < comboList[0].length;j++){  
						var tempText = comboList[0][j].split("|");  
						formObj.cost_dtl_cd.InsertItem(j + 1,tempText[1] ,tempText[0]);
					} 			      
				}		
			    formObj.cost_dtl_cd.Code = "A";  			  		 
			}		
			sheetObj.WaitImageVisible = true;
			break;
		
 		case IBDOWNEXCEL:
 		    sheetObj.SpeedDown2Excel(-1);   
 			break;	  				
     }
 }
  
/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	with(formObj){	
		if(sAction==IBSEARCH) {	  	    
			if (!ComChkValid(formObj)) return false; 
			if(!MnrChkFromDate(formObj.fm_dt)) return false;
		}  		
	}	
	return true;
}

 /**  
 * cost_cd Change 이벤트		      
 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
 * @param  {String}    Index_Code   Index 나 코드
 * @param  {String}    Text   텍스트
 */  	
function cost_cd_OnChange(comboObj,Index_Code, Text){
	//Cost dtl Cd 콤보 세팅 		
	var formObj  = document.form;	
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);		
}	
 
 /**  
 * rhq Change 이벤트		      
 * @param  {IBMultiCombo}  comboObj 콤보오브젝트  
 * @param  {String}    Index_Code   Index 나 코드
 * @param  {String}    Text   텍스트
 */  	
function rhq_OnChange(comboObj,Index_Code, Text){
	var formObj  = document.form;  
	formObj.country.removeAll(); 	 		    
	var sCondition = new Array (
			new Array("MdmOrganization","COUNTRY",Index_Code)   //Office	
		); 		  
	var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
				
	formObj.country.InsertItem(0, "ALL" , "A");		
	if(comboList[0] != null){
		for(var i = 0; i < comboList[0].length;i++){ 
			var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
			formObj.country.InsertItem(i + 1, comboList[0][i] , code);			   
		}		
	}				
	formObj.country.Code = "A";						
}															

/**  
 * country Change 이벤트		      
 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
 * @param  {String}    Index_Code   Index 나 코드
 * @param  {String}    Text   텍스트
 */  	
function country_OnChange(comboObj,Index_Code, Text){	
	var formObj  = document.form;			 
	formObj.ofc_cd.removeAll();          
	var sCondition = new Array (					
			new Array("MdmOrganization","OFCBYCOUNTRY",Index_Code + ',' + formObj.rhq.Code )   //Office
		);			 			   
	var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
		
	formObj.ofc_cd.InsertItem(0, "ALL" , "A");
	if(comboList[0] != null){	
		for(var i = 0; i < comboList[0].length;i++){ 
			var code = comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
			formObj.ofc_cd.InsertItem(i + 1, comboList[0][i] , code);			   
		}						
	}
	
	if(formObj.country.Code == 'A' && formObj.rhq.Code == 'A'){
		formObj.ofc_cd.enable = false; 
	} else {
		formObj.ofc_cd.enable = true;  
	}				
}			  
			
/**  
 * combo_eq_type_cd Change 이벤트      
 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
 * @param  {String}    Index_Code   Index 나 코드
 * @param  {String}    Text   텍스트
 */  
function eq_type_OnChange(comboObj,Index_Code, Text){ 
	var formObj  = document.form;        
	var comboValue = comboObj.Code;		 		   
	
	formObj.tp_sz_cd.RemoveAll();
	
	var selTpSz = new Array();
	if(comboValue == "U"){
		selTpSz = uTpSz;  	
	} else if(comboValue == "G"){
		selTpSz = gTpSz; 
	} else if(comboValue == "Z"){
		selTpSz = zTpSz;   
	}
	
	//디폴트로 올삽입
	if(selTpSz.length == 0){
		formObj.tp_sz_cd.Enable = false;		//tp_sz_cd
	}else{
		formObj.tp_sz_cd.Enable = true;			//tp_sz_cd 	 		
		formObj.tp_sz_cd.InsertItem(0,"ALL","A");   		
		for(var i = 1;i < (selTpSz.length + 1);i++){   
			formObj.tp_sz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]); 			
		}
	}
	
	//Cost Cd 콤보 세팅 	
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
} 
 
//멀티콤보 클릭 이벤트	
function eq_type_OnCheckClick(comboObj, index, code) { 
	MnrAllChkMultiCombo(comboObj,index);    		  
}
	
//멀티콤보 클릭 이벤트	
function tp_sz_cd_OnCheckClick(comboObj, index, code) { 
	MnrAllChkMultiCombo(comboObj,index);    		  
}	 

//멀티콤보 클릭 이벤트		
function acct_cd_OnCheckClick(comboObj, index, code) { 
	MnrAllChkMultiCombo(comboObj,index);    		  
}	 
	
//멀티콤보 클릭 이벤트	
function ofc_cd_OnCheckClick(comboObj, index, code) { 
	MnrAllChkMultiCombo(comboObj,index);    		  
}	 
	
function setTpSzArray(sheetObj){ 
	var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind");
		 
	if(arrXml != null){          
	    for(var i = 0; i < arrXml.length; i++){   
			if(i == 0){	       
				uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");    	
			} else if(i == 1){	  
				zTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");  
			} else if(i == 2){	    
				gTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");       	
			}	  	 
	    }  	 
	}					
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
		formObj.vndr_seq.value = aryPopupData[0][2];
		formObj.vndr_lgl_eng_nm.value  = aryPopupData[0][4];
	}
}	
		  
/**
* 조회후 처리
*/		
function sheet1_OnSearchEnd(sheetObj,ErrMsg){
	if (ErrMsg != "") {   
		ComShowCodeMessage("MNR00057","MNR PFMC by Account/Cost Code");	
	}																							     	 	       	                	
	sheetObj.ShowSubSum("cost_ofc_cd", "total_qty|total_amt", -1, true, false, -1,"avg_amt=(|total_amt| / |total_qty|)"); 
											
	var aFloat = parseFloat(sheetObj.SumValue(0,"total_amt") + "");										
	var bFloat = parseFloat(sheetObj.SumValue(0,"total_qty") + ""); 
	var avgFloat = 0;		
	if(bFloat != 0){			
		avgFloat = parseFloat(aFloat / bFloat).toFixed(2);
	} 						  	
	sheetObj.SumValue(0,"avg_amt") = avgFloat;				 		  
} 	
  
function initControl() {	 	      
    //Axon 이벤트 처리1. 이벤트catch  
    axon_event.addListenerForm  ('blur', 	'obj_deactivate',  	form); 			      //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_activate',     form);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListenerFormat('change',	 'obj_change',		form); 	  //- 변경될때.
}           
									    
/**
 * HTML Control의 deactivate 이벤트 <br>
 **/
function obj_deactivate(){  	  		
	obj = event.srcElement;      		 
    ComChkObjValid(event.srcElement);	 
} 
	
/**
 * HTML Control의 activate 이벤트 <br>
 **/
function obj_activate(){   				
    ComClearSeparator(event.srcElement);
}  
 	 
function obj_change(){	    			 
	var obj      = event.srcElement; 
	var formObj  = document.form; 	
	var sheetObj = sheetObjects[0]; 
	if ( ComTrim(obj.value) != "" ) {
		switch(obj.name) { 	      
    		case "vndr_seq":	 	 
				formObj.vndr_seq.value = ComLpad(formObj.vndr_seq.value,6,"0");  
        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
			   	break;	       
		}       
    } else {	
		switch(obj.name) {      
    		case "vndr_seq":     
				ComSetObjValue(formObj.vndr_lgl_eng_nm,"") 
			   	break;   	
		}  		
	}
} 
	 
/**
 * HTML Control의 keypress 이벤트 <br>
 **/     
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
            ComKeyOnlyNumber(obj, ".");
            break; 
        case "eng":   
            ComKeyOnlyAlphabet();
			break;   
        case "engup": 
			ComKeyOnlyAlphabet('uppernum');  
	        break;	  
    }
} 
/* 개발자 작업  끝 */