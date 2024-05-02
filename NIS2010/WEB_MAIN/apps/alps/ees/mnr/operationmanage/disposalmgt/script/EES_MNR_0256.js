/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_MNR_0256.js	 	
*@FileTitle : Disposal Cancelled Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 신혜정	
*@LastVersion : 1.0 
* 2011.11.23 신혜정     
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
     * @class EES_MNR_0256 : EES_MNR_0256 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0256() {
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

//쉬트  
var sheetObjects = new Array();
var sheetCnt = 0;

//콤보 객체   
var comboObjects = new Array();
var comboCnt = 0; 

//조회여부 (조회후 삭제 가능)
var selCheck = false;

//콤보 디폴트값 
var eqKnddefCode = "";

//메세지용 
var actionType = "";

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
					case "btn_Retrieve":
						sheetObjects[1].RemoveAll();
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);  
					break;
							 
					case "btn_New":     
						doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;	 	
					
					case "btn_Print":

						var rdParam = '/rv inv_no[' + sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"inv_no") + '] user_nm[' + self_usr_nm + ']';

						formObject.com_mrdBodyTitle.value = "Disposal Invoice";
						formObject.com_mrdPath.value = "apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0185.mrd";
						formObject.com_mrdArguments.value =	rdParam;
						var sFeatures = "resizable=yes,width=800,height=600"
						ComOpenRDPopup(sFeatures);  
						break;	
					
					break;
					
					case "btn_Detail":
						doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC01); 
					break;
																
					case "btn_DownExcel":
						 sheetObjects[0].SpeedDown2Excel(-1);    
					break;

					case "btn_DownExcelDtl":
						if(sheetObjects[1].Visible==true){
							sheetObjects[1].SpeedDown2Excel(-1);   
						}else{
							sheetObjects[2].SpeedDown2Excel(-1);   
						}
					break;

					case "btn_period":
						var cal = new ComCalendarFromTo();  	       
						cal.select(formObject.from_dt,  formObject.to_dt,  'yyyy-MM-dd'); 
					break;  
					  
			        case "btn_t1_req_multy":           
	                    rep_Multiful_inquiry("inv_no");   
					break;

			        case "btn_t2_req_multy":           
	                    rep_Multiful_inquiry("eq_no_list");   
						break;
																		
					case "btn_provider_popup":
				    	ComOpenPopup('/hanjin/COM_ENS_041.do', 780, 520, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;	

			        case "btn_t3_req_multy": // Disposal No.           
	                    rep_Multiful_inquiry("disp_no");   
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		initControl();   
        for(i = 0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		for(k = 0;k < comboObjects.length;k++){ 
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
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
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
						
					var HeadTitle1 = "|Sel|Seq.|Invoice No.|Status|Settle|Buyer|Currency|Amount|USD Amount|Invoice Date|Cancel Seq|Cancellation DT|Cancelled by|Due Date Payment|Remark(s)";
					
					var headCount = ComCountHeadTitle(HeadTitle1);  
							
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 1, 0, 0, true);           
									
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);
						
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
									
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox, 	40,		daCenter,  	false,     "sel",	   				false,          "",      dfNone,      	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"SEQ");
					InitDataProperty(0, cnt++ , dtData,		    110,	daCenter,	true,		"inv_no",				false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,		    110,	daLeft,		true,		"mnr_inv_sts_cd",		false,	"",		dfNone,				0,			false,		true);				
					InitDataProperty(0, cnt++ , dtData,		    80,		daLeft,		true,		"inv_stl_sts_cd",		false,	"",		dfNone,				0,			false,		true);				
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"mnr_prnr_lgl_eng_nm",	false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"curr_cd",				false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			130,	daRight,	true,		"ttl_amt",	        	false,	"",		dfFloat,			2,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			130,	daRight,	true,		"usd_ttl_amt",	        	false,	"",		dfFloat,			2,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			100, 	daCenter,	true,		"iss_dt",	    		false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			80, 	daCenter,	true,		"cxl_inv_seq",    		false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			100, 	daCenter,	true,		"cxl_dt",	    		false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			100, 	daCenter,	true,		"cxl_usr_id",    		false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			120, 	daCenter,	true,		"inv_due_dt",	    	false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"mnr_inv_rmk",			false,	"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		true,		"dp_prcs_knt",			false,	"",		dfNone,				0,			false,		true);
	 						
					CountPosition = 0;
					
					MultiSelection = true;
					SelectionMode = smSelectionRow;
					SelectHighLight = true;
  
			}				
			break;  	
			
            case "sheet2":
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
                    Editable = false;	 	
					
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);
						
					var HeadTitle1 = "|Seq.|Disposal Type|Invoice No.|Invoice Amount|Disposal No.|EQ No.|Cancel Seq|TP/SZ|Release No|Currency|Amount|USD Amount|Due Date|Request Date|Sold Date|Remark(S)";
					
					var headCount = ComCountHeadTitle(HeadTitle1);  
							
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);           
									
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
						
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
									
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,		"hdnStatus");
                    InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"SEQ");
					InitDataProperty(0, cnt++ , dtData,		    100,	daCenter,	true,		"disp_tp_nm",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,		    95,		daCenter,	true,		"inv_no",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"ttl_amt",	        	false,	"",		dfFloat,			2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,		    100,	daLeft,		true,		"disp_no",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		"eq_no",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80, 	daCenter,	true,		"cxl_inv_seq",    		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"eq_tpsz_cd",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			115,	daLeft,		true,		"disp_rlse_no",	        false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70, 	daCenter,	true,		"curr_cd",	    		false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"inv_amt",				false,	"",		dfFloat,			2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"usd_ttl_amt",				false,	"",		dfFloat,			2,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"inv_due_dt",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"rqst_dt",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"disp_sold_dt",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"mnr_disp_dtl_rmk",		false,	"",		dfNone,				0,			true,		true);

					CountPosition = 0;	  
			}				
			break;  		
								
        }
    }

	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 		//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);        //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);        //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',		formObject); 		//- 변경될때.
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
		if (ComTrim(obj.value) != "") {
			switch(obj.name) {      
	    		case "disp_eml_flg_temp":
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
				if(obj.name == "inv_no"){
					ComKeyOnlyAlphabet('uppernum','44');
				} else { 
					ComKeyOnlyAlphabet('uppernum');	
				}  			
	            break; 
	    }         
	}	

 // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){ 
					//헤더 리스트 조회   
					formObj.f_cmd.value = SEARCH;    
				    sParam = FormQueryString(formObj);  
				    var sXml = sheetObj.GetSaveXml("EES_MNR_0256GS.do", sParam);
				    sheetObjects[0].LoadSearchXml(sXml);    	
				}	 	 	
				break;	
 
 			case IBSEARCH_ASYNC01:      //Invoice Detail
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObjects[1].style.height = 220;
					sheetObjects[2].style.height = 0;
					
					sheetObjects[1].Visible = true;
					sheetObjects[2].Visible = false;
					
					var currPrcsKnt = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"dp_prcs_knt");

					if(currPrcsKnt=="0"){
						sheetObjects[1].InitDataProperty(0, 11 , dtData,  	100,		daRight,   	true,     "inv_amt", 			false,         	"",      dfInteger, 	0,     true,       true);
					}else{
						sheetObjects[1].InitDataProperty(0, 11 , dtData,  	100,		daRight,   	true,     "inv_amt", 			false,         	"",      dfFloat, 	2,     true,       true);
					}	
					
					sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"ibflag")="U";
					formObj.f_cmd.value = SEARCH01;
					var sParam = ComGetSaveString(sheetObjects[0]);

					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
					var sXml = sheetObj.GetSaveXml("EES_MNR_0256GS.do", sParam);
					sheetObj.LoadSearchXml(sXml); 
					sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"ibflag")="";
				}	 	 	
				break;	
													
			case IBCLEAR:      // 초기화 
				MnrWaitControl(true);
				sheetObj.WaitImageVisible=false;
				
				selCheck = false;   
				actionType = "";

				//시트 초기화  
				for(var i = 0; i < sheetObjects.length;i++){ 
					sheetObjects[i].RemoveAll(); 	
				}  
					 
				if(initLoader == 0){
					var sCondition = new Array (
						new Array("MnrGenCd","CD00081", "COMMON")	//Disposal Invoice Inquiry Status Code 
					);   
					
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
	
					//콤보 설정
					for(var i = 0; i < comboList.length;i++){
						if(comboList[i] != null){
							//쉬트콤보별 초기화
							sheetComboText = "";
							sheetComboCode = "";
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								//Repair Invoice Search Type  
								if(i==0) {
									comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){      
										comboObjects[0].InsertItem(0, "ALL" ,"ALL");
										comboObjects[0].Code = "ALL"; 
									}  								
								}
							}
						}
					}
				}
				
				initLoader = 1;	
				
				comboObjects[0].Code = "ALL"; 
												
				formObj.from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -7);;
				formObj.to_dt.value=ComGetNowInfo("ymd");
				formObj.inv_no.value="";
				formObj.cust_cd.value="";
				formObj.vndr_lgl_eng_nm.value="";
				formObj.eq_no_list.value="";
				formObj.disp_no.value = ""; // Disposal No. 초기화
			
				sheetObj.WaitImageVisible=true;	

				MnrWaitControl(false);  	
				break;			
        }				
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){            	        
			if(sAction==IBSEARCH_ASYNC01){ //Invoice Detail
				var selChk = "";
				var invNoList = "";
				var invChk = "";
				var invArray = new Array(sheetObjects[0].CheckedRows("sel"));
				var idx = 0;				
				for(var i=1; i<= sheetObjects[0].RowCount; i++){
					invChk = "";
					if(sheetObjects[0].CellValue(i, "sel") == 1){
						selChk = "Y";
						
						// 중복된 inv no 가 있는지 체크
						for(var k=0; k<invArray.length; k++){
							if(sheetObjects[0].CellValue(i, "inv_no") == invArray[k]){
								invChk = "Y";
							}
						}						
						
						if(invChk == ""){
							invArray[idx++] = sheetObjects[0].CellValue(i, "inv_no");						
							// 선택된 inv No 담기
							invNoList += sheetObjects[0].CellValue(i, "inv_no") + ",";
						}
					}
				}
				if(selChk == ""){
					ComShowCodeMessage("MNR00038");
					return false;
				}			
				if(invNoList != ""){
					invNoList = invNoList.substr(0, invNoList.length -1);
				}
				// inv No 리스트 셋팅
				formObj.inv_no_list.value = invNoList; 
			}
		}	
        return true; 
    }	
	
	/**
	 * rep_Multiful_inquiry 사용시 받는부분  
	 * 소스에 붙여서 사용하세요          
	 * Location : 팝업에서 단일 선택을 한경우..     
	 */      
	function getMnr_Multi(rowArray,ret_val) {
		
		var formObj = document.form;  
		var tempText = ""; 
		//초기화   
		eval("document.form." + ret_val + ".value = '';"); 
		for(var i=0; i<rowArray.length; i++) {   
			var colArray = rowArray[i];     
			tempText +=  rowArray[i] + ',';    
		}      
		//마지막에 ,를 없애기 위함      
		if (tempText != "")       
	        tempText = tempText.substr(0, tempText.length - 1);   	
		     
		tempText = tempText.toUpperCase(); 	            
		eval("document.form." + ret_val + ".value = '" + tempText + "';"); 
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
			formObj.cust_cd.value = aryPopupData[0][3];
			formObj.vndr_lgl_eng_nm.value  = aryPopupData[0][4];
		}
	}	
	
	/**
	 * 동일 Invoice No 체크 선택/해제 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @param {String} 	Value     	파일명
	 **/  
	function sheet1_OnChange(sheetObj,Row,Col,Value){	
	
		// Sel 컬럼일 경우
		if(Col == "1"){
			// 체크 해제 시
			for(var i=1; i<= sheetObjects[0].RowCount; i++){					
				if(sheetObjects[0].CellValue(i, "inv_no") == sheetObjects[0].CellValue(Row, "inv_no")){
					sheetObjects[0].CellValue(i, "sel") = Value;
				}
			}
		}
		return;
	} 	

/* 개발자 작업  끝 */