/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0164.js	 	
*@FileTitle : Disposal Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 조경완	
*@LastVersion : 1.0 
* 2009.09.28 함형석     
* 1.0 Creation  			
* --------------------------------------------------------
* History
* 2011.08.30 나상보 [CHM-201113102] ALPS MNR-Disposal-Disposal Inquiry화면에 조회 Status 추가 개발 요청
* 2012.01.04 신혜정 [CHM-201217048] not pick up 된 장비 List 조회 팝업 추가
*                                   - [Not Pick-up CNTR] 버튼 추가
*                                   - 멀티 선택에 대한 not pick up 장비 list 팝업 조회
* 2012.06.04 신혜정 [CHM-201218271-01] 조회조건에 Regional HQ, Office 항목 추가                                   
* 2012.08.31 김창헌 [CHM-201219415-01] Disposal Request가 Reject된 List 현황 관리
* 									- Delete(Reject) 버튼 및 관련 기능 추가
* 2012.11.29 조경완 [CHM-201221421-01] ALPS - MNR -DISPOSAL-Inquiry-Disposal Inquiry 화면에서 Disposal No로 조회 시, 불편한 점 수정 요청
* 									- disposal no. 입력 편의 기능
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
     * @class EES_MNR_0164 : EES_MNR_0164 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0164() {
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

//IBCLEAR 일때
var isNowInit = false;  
var initLoader = 0;
var dispChk = "";
var isDelAuth = false;
var strMnrOfficeLevel = "";	// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];		
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {
					case "btn_Retrieve":   
						doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);  
					break;
							 
					case "btn_New":     
						doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;	 	

					case "btn_Detail":
						sheetObjects[1].CellValue2(sheetObjects[1].SelectRow,"ibflag") = "I";
						//sParam = ComGetSaveString(sheetObjects[1]);	
						sParam = ComReplaceStr(ComGetSaveString(sheetObjects[1]), '%0D%0A', '  ');	
						ComOpenPopup('/hanjin/EES_MNR_0200.do?' + sParam, 1024, 585, 'getInvoiceDetail', "0,1,1,1,1,1", true);
						sheetObjects[1].CellValue2(sheetObjects[1].SelectRow,"ibflag") = "R";
					break;
											
					case "btn_DownExcel":
						 sheetObjects[1].SpeedDown2Excel(-1);    
					break;
						
					case "btn_period":
						var cal = new ComCalendarFromTo();  	       
						cal.select(formObject.in_apro_st_dt,  formObject.in_apro_end_dt,  'yyyy-MM-dd'); 
					break;  
					  
			        case "btn_t1_req_multy":           
	                    rep_Multiful_inquiry("disp_no_list");   
						break;
												
			        case "btn_t2_req_multy":           
	                    rep_Multiful_inquiry("eq_no_list");   
						break;
			        case "btn_NotPickup":
						var selChk = "";
						var dispNoList = "";
						var idx = 0;
						for(var i=1; i<= sheetObjects[1].RowCount; i++){
							if(sheetObjects[1].CellValue(i, "sel") == 1){
								selChk = "Y";
								// 선택된 disp No 담기
								dispNoList += sheetObjects[1].CellValue(i, "disp_no") + ",";
								idx++;
							}
						}
						
						if(selChk == ""){
							ComShowCodeMessage("MNR00038"); // Please select the data first
							return false;
						}			
						if(idx > 1000){
							ComShowCodeMessage("MNR00372"); // 1000 row can be selected under!
							return false;
						}
						if(dispNoList != ""){
							dispNoList = dispNoList.substr(0, dispNoList.length -1);
						}
						var modObj = new Object();
						modObj.dispNoList = dispNoList;

						// 팝업 호출
						var sFeatures = "scroll:no;status:no;help:no;dialogWidth:990px;dialogHeight:505px;dialogLeft:90;dialogTop:113";
						showModalDialog('EES_MNR_0261.do', modObj, sFeatures);
			        	break;

					case "btn_DeleteReject":     
						doActionIBSheet(sheetObjects[1],formObject,IBDELETE);
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
	           case 2:
    				with (comboObj) {

                   	DropHeight = 12 * 18;

                   	MultiSelect = true;
                   	MaxSelect = 8 ;
                   	MultiSeparator = ",";
          	
        	    }
                   break;
                   
	       	case 3:
	           	with (comboObj) { 
					SetTitle("Office Code|Office Name");
	        	   	SetColAlign("center|left");        
					SetColWidth("55|225"); 
				   	DropHeight = 160;  
					UseAutoComplete = true;
					ValidChar(2,0);   
		    	}      
	    		break;
	    		
	    	case 4:
	    		with (comboObj) { 
	    			SetTitle("Office Code|Office Name");
	    			SetColAlign("left|left");        
	    			SetColWidth("60|305"); 
	    			DropHeight = 160;  
					UseAutoComplete = true;
					ValidChar(2,0);   
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
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				}
            case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 422;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly; 

                   //전체Edit 허용 여부 [선택, Default false] 
                    Editable = true;	 	
					
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 14, 100);
						
					var HeadTitle1 = "|Sel|Seq.|Disposal No.|Invoice No.|Request Office|Approval Office|Sale Type|EQ Type|Q'ty|Currency|T/AMT|Buyer Sel|Posting DT|Cre DT|Start Time|Close Time|Pick-up Period|Pick-up Period|Status"
					var headCount = ComCountHeadTitle(HeadTitle1);  
							
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 10, 6, 0, true);           
									
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);
						
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
						   	  		
                    //데이터속성    [ROW, COL,      DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,			KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus,	50,     daCenter,  	false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"sel");                    
					InitDataProperty(0, cnt++,  dtSeq,    		30,     daCenter,   true,   "Seq"); 
					InitDataProperty(0, cnt++ , dtData,		    100,	daCenter,	true,	"disp_no",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		    100,	daCenter,	true,	"inv_no",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		    100,	daCenter,	true,	"rqst_ofc_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		    100,	daCenter,	true,	"apro_ofc_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		80, 	daLeft,		false,	"disp_tp_cd",	    false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		80,		daLeft,		false,	"eq_knd_cd",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,	"disp_qty",			false,		"",		dfInteger,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,	"curr_cd",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,		daRight,	false,	"disp_st_prc",		false,		"",		dfFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"buyer_cnt",		false,		"",		dfInteger,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"disp_bultn_dt",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"rqst_dt",			false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"disp_st_dt",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"disp_end_dt",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"disp_pkup_st_dt",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"disp_pkup_end_dt",	false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtCombo,		80,		daLeft,		false,	"disp_sts_cd",		false,		"",		dfNone,			0,		false,		false);
									
					//히든 데이타  
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_st_dt",      false,      "",     dfNone,    		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_end_dt",     false,      "",     dfNone,    		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_pkup_st_dt", false,      "",     dfNone,    		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_pkup_end_dt",false,      "",     dfNone,    		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "disp_eml_flg",    false,      "",     dfNone,    		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "apro_ofc_cd",     false,      "",     dfNone,    		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "file_seq",     	false,      "",     dfNone,    		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "rqst_ofc_cd",     false,      "",     dfNone,    		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "rqst_usr_id",     false,      "",     dfNone,    		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_disp_rmk",     false,      "",     dfNone,    		0,     false,       false);
											 						
					CountPosition = 0;	  
			}				
			break;  	
        }
    }


	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
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
//	    var obj      = event.srcElement; 
//		var formObj  = document.form; 
//		var sheetObj = sheetObjects[0]; 
//		if ( ComTrim(obj.value) != "" ) {
//			switch(obj.name) {  
//				case "disp_no_list":
//					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
//					break;
//			}       
//	    } 
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
	    		case "disp_eml_flg_temp":     
				   	break;
				case "disp_no_list":
					var sValue = formObj.disp_no_list.value.split(",");
					var tempText = "";
					for(var i=0; i<sValue.length; i++) {  
						var colArray = sValue[i].split("-").join(""); 
						if(colArray.indexOf("-") < 0){
							sValue[i] = colArray.substring(0,colArray.length-7) + "-" + colArray.substring(colArray.length-7,colArray.length-3) + "-" + colArray.substring(colArray.length-3,colArray.length);
						} 
						tempText +=  sValue[i] + ',';
					}      
					//마지막에 ,를 없애기 위함     
					tempText = MnrDelLastDelim(tempText);
					
					formObj.disp_no_list.value = tempText;
					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
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
				if(obj.name == "disp_no_list"){
					ComKeyOnlyAlphabet('uppernum','44|45');					
				} else {
					ComKeyOnlyAlphabet('uppernum','44');	
				}	  
	            break; 
	    }         
	}	
	
	/** 
	 * COMBO 변경 이벤트
	 * ACEP Type 변경시 loc_cd 의 format 설정
	 * @param	{IBMultiCombo}	comboObj	변경한 콤보 오브젝트
	 * @param	{Number}		Index_Code	변경한 콤보의 코드
	 * @param	{String}		Text		변경한 콤보의 명
	 */
	function ar_hd_qtr_ofc_cd_OnChange(comboObj, Index_Code, Text){
		getAgmtOffice(Index_Code);
	}	
	
    /**
 	 * Regional HQ OnChange가 발생하는 경우 Office 조회
 	 * @param comboObj
 	 * @param Index_Code
 	 * @param Text
 	 * @return
 	 */   
 	function getAgmtOffice(Index_Code){ 
 		var formObj = document.form;
 		formObj.ofc_cd.removeAll();
 		formObj.ofc_cd.InsertItem(0,"ALL","A");	
 		
 		if(Index_Code != "A"){
 	 		var arHdQtrOfcCd = ComGetObjValue(formObj.ar_hd_qtr_ofc_cd);
 			var sCondition = new Array (         
 				new Array("MdmOrganization","SEARCH",arHdQtrOfcCd)
 			) 	 	       
 			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);      
 			 			
 			if(comboList[0] != null){		
 				for(var j = 0; j < comboList[0].length;j++){ 
 					var tempText = comboList[0][j].split("|");
 					formObj.ofc_cd.InsertItem(j + 1, comboList[0][j] ,tempText[0]);
 				}
 			} 			
 		}

		formObj.ofc_cd.Code = "A"; 	 
 	} 	
	
	/********************************SHEET EVENT *******************************/
	function sheet2_OnDblClick(sheetObj,Row,Col) 
    {	
		/**		
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow,"ibflag") = "I";
		sParam = ComReplaceStr(ComGetSaveString(sheetObjects[1]), '%0D%0A', '  ');
		ComOpenPopup('/hanjin/EES_MNR_0200.do?' + sParam, 1024, 585, 'getInvoiceDetail', "0,1,1,1,1,1", true);
		**/
		//[2011.02.07] 김종옥 부분 수정
		sheetObj.CellValue(Row,"ibflag") = "I";
		sParam = ComReplaceStr(ComGetSaveString(sheetObj), '%0D%0A', '  ');
		ComOpenPopup('/hanjin/EES_MNR_0200.do?' + sParam, 1024, 585, 'getInvoiceDetail', "0,1,1,1,1,1", true);
		sheetObj.CellValue(Row,"ibflag") = "R";
    }  
	
 // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){ 
					//헤더 리스트 조회   
					formObj.f_cmd.value = SEARCH;    
				    sParam = FormQueryString(formObj);  
				    var sXml = sheetObj.GetSaveXml("EES_MNR_0164GS.do", sParam);
				    sheetObjects[1].LoadSearchXml(sXml);    	
				}	 	 	
			
				if (isDelAuth && ComGetObjValue(formObj.input_status_type_code) == "HJ" && sheetObj.TotalRows > 0) {
					ComSetDisplay('btn_DeleteReject', true);
				} else {
					ComSetDisplay('btn_DeleteReject', false);
				}

				break;	
 					
			case IBCLEAR:      // 초기화 
				MnrWaitControl(true);
				isNowInit = true;  
				sheetObj.WaitImageVisible=false;
				
				MnrOfficeLevel(currOfcCd,rhqOfcCd);
				
				if( strMnrOfficeLevel == "L1" ) isDelAuth = true;
				
				selCheck = false;   
				actionType = "";
				  
				//차후에 하나씩 개별로  
				formObj.reset();   
				
				ComSetDisplay('btn_DeleteReject', false);
				
				if(initLoader == 0){
					//콤보 초기화  
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll(); 	
					} 
				
					//공통콤보 정보를 가져온다.  
					var sCondition = new Array (
						new Array("MnrGenCd","CD00052", "COMMON"),	//date  
						new Array("MnrGenCd","CD00035", "COMMON"),	//disp_tp_cd
						new Array("MnrGenCd","CD00002", "COMMON"),	//eq_knd_cd
						new Array("MdmCurrency","","COMMON"),       //curr_cd
						new Array("MnrGenCd","CD00029", "COMMON"), //disp_sts_cd
						new Array("MnrGenCd","CD00029", "CUSTOM11"), //disp_sts_cd
						new Array("MdmOrganization","RHQ","FALSE") //Regional HQ						
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
								//Date
								if(i==0) {
									formObj.input_date_type_code.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){      
										formObj.input_date_type_code.Code = tempText[0]; 
									} 							
								}else if(i==6) {//RegionalHQ
									if(j == 0){
										formObj.ar_hd_qtr_ofc_cd.InsertItem(0,"ALL","A");	
									}									
									formObj.ar_hd_qtr_ofc_cd.InsertItem(j+1, comboList[i][j] ,tempText[0]);  	
								}
							}
	
							if(i==1) {
								sheetObjects[1].InitDataCombo(0, "disp_tp_cd", sheetComboText, sheetComboCode, sheetComboCode);
							}else if(i==2) {		
								sheetObjects[1].InitDataCombo(0, "eq_knd_cd", sheetComboText, sheetComboCode, sheetComboCode);
							}else if(i==3) {		
								sheetObjects[1].InitDataCombo(0, "curr_cd", sheetComboCode, sheetComboCode, sheetComboCode);
							}else if(i==4) {		
								sheetObjects[1].InitDataCombo(0, "disp_sts_cd", sheetComboText, sheetComboCode, sheetComboCode);
							}else if(i==5){
								formObj.input_status_type_code.InsertItem(0, "ALL|ALL" ,"ALL");
								for(var j = 0; j < comboList[i].length; j++){
									var tempText = comboList[i][j].split("|");
									formObj.input_status_type_code.InsertItem(j+1, comboList[i][j] ,tempText[0]);
								}
							}
						}
					}
				}
				initLoader = 1;	
					

				//쉬트 초기화   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();    
		        }  
				
				//초기값 설정 
				formObj.in_apro_st_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -7);;
				formObj.in_apro_end_dt.value=ComGetNowInfo("ymd");
				formObj.disp_no_list.value="";
				formObj.eq_no_list.value="";
				formObj.ofc_cd.Code = ""; //Office
				formObj.ar_hd_qtr_ofc_cd.Code = "A"; //Regional HQ

				sheetObj.WaitImageVisible=true;	
				isNowInit = false;   
				MnrWaitControl(false);  	
				break;			

			case IBDELETE:      // Delete(Reject)
        		if(sheetObj.FindCheckedRow("sel") != ""){
        			if (!ComShowCodeConfirm("MNR00376")){return false;}
    				formObj.f_cmd.value = REMOVE02;
    				sheetObj.DoSave("EES_MNR_0164GS.do", FormQueryString(formObj), "sel", false);
				} else {
					ComShowCodeMessage("MNR00079");
				}
				break;
			
			case IBSEARCH_ASYNC01:
				formObj.f_cmd.value = SEARCH03;    
				sParam = FormQueryString(formObj);  
			    var sXml = sheetObj.GetSaveXml("EES_MNR_0159GS.do", sParam);
				
				var checkDisp = ComGetEtcData(sXml, "DISP_NO");
				if(checkDisp != "" && checkDisp.length != 0){
					alert("Invalid Disposal No: " + checkDisp);
					ComSetFocus(formObj.disp_no_list);
					dispChk = "N";
				}else{
					dispChk = "Y";
					return;
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
					if(dispChk == "N"){
						alert("Please Check Disposal No Again");
						return;
					}
					break;
			}		
		}	
        return true; 
    }
     
 	//멀티콤보 클릭 이벤트
 	function input_status_type_code_OnCheckClick(comboObj, index, code) { 
 		MnrAllChkMultiCombo(comboObj,index);  		  
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
			var colArray = rowArray[i].split("-").join("");
			if(ret_val == "disp_no_list"){
				if(colArray.indexOf("-") < 0){
					rowArray[i] = colArray.substring(0,colArray.length-7) + "-" + colArray.substring(colArray.length-7,colArray.length-3) + "-" + colArray.substring(colArray.length-3,colArray.length);
				}
			}
			tempText +=  rowArray[i] + ',';    
		}      
		//마지막에 ,를 없애기 위함      
		if (tempText != "")       
	        tempText = tempText.substr(0, tempText.length - 1);   	
		     
		tempText = tempText.toUpperCase(); 	            
		eval("document.form." + ret_val + ".value = '" + tempText + "';"); 
		
		if(formObj.disp_no_list.value != ""){
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
		}
	}      
	
/* 개발자 작업  끝 */