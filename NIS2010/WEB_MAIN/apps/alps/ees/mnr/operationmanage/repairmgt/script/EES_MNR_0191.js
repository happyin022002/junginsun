/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0191.js 
*@FileTitle : Repair History_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.03 박명신
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
     * @class EES_MNR_0191 : EES_MNR_0191 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0191() {
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
 
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {  
						case "btn_Retrieve":       
								doActionIBSheet(sheetObject,formObject,IBSEARCH);
								break;
						case "btn_New":          
								doActionIBSheet(sheetObject,formObject,IBCLEAR);
								break;
						case "btn_Acep_Pop":
							if( sheetObject.RowCount > 0 ){
								var popParam = "";
								popParam = popParam + "?rqst_eq_no=" + sheetObject.CellValue(sheetObject.SelectRow, "rqst_eq_no");
								popParam = popParam + "&rpr_rqst_seq=" + sheetObject.CellValue(sheetObject.SelectRow, "rpr_rqst_seq");
								popParam = popParam + "&mnr_ord_ofc_cty_cd=" + sheetObject.CellValue(sheetObject.SelectRow, "mnr_ord_ofc_cty_cd");
								popParam = popParam + "&mnr_ord_seq=" + sheetObject.CellValue(sheetObject.SelectRow, "mnr_ord_seq");
								popParam = popParam + "&ord_dtl_seq=" + sheetObject.CellValue(sheetObject.SelectRow, "ord_dtl_seq");
								if( sheetObject.CellValue(sheetObject.SelectRow, "rpr") == "Repair" ){
									popParam = popParam + "&mnr_wo_tp_cd=" + "EST";
								} else{
									popParam = popParam + "&mnr_wo_tp_cd=" + "SPL";
								}
								
								ComOpenWindowCenter("EES_MNR_0061.do" + popParam, "EES_MNR_0061", 1020, 700, true);
							}
		                    break;
						case "btn_DownExcel": 
								sheetObject.SpeedDown2Excel(-1);      
								break;
						case "btns_calendar": 
								var cal = new ComCalendarFromTo();       
 								cal.select(form.fm_mnr_inp_dt,  form.to_mnr_inp_dt,  'yyyy-MM-dd'); 
								break;       
						case "btn_close": 
								self.close();
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		MnrWaitControl(true);	
		initControl();    
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1); 
            ComEndConfigSheet(sheetObjects[i]);

        } 
								
		var formObj = document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
		
		if(formObj.eq_no.value != ""){  
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
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
                    style.height = 300; 
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  					
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge; 
 					
                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true; 

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);  

		    		var HeadTitle1 = "|Seq|Input Date|C.OFC|Type|Service Provider|Est No|W/O No|Repair Yard|Repair Date|CURR|Amount|Status|RQST_EQ_NO|RPR_RQST_SEQ|MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|ORD_DTL_SEQ";
                    var headCount = ComCountHeadTitle(HeadTitle1);
						
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	true,	"ibflag");  
					InitDataProperty(0, cnt++ , dtSeq,			 30,	daCenter,	true,	"Seq");     
					InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	false,	"rqst_dt",			false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			 45,	daCenter,	false,	"cost_ofc_cd",		false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			 40,	daCenter,	false,	"rpr",				false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			110, 	daLeft,		false,	"vndr_lgl_eng_nm",	false,	"",		dfNone,		0,	false,		false);;
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,	"est_no",			false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			 75,	daCenter,	false,	"wo_no",			false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			 70, 	daCenter,	false,	"yd_cd",			false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			 80, 	daCenter,	false,	"rpr_rslt_dt",		false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			 40,	daCenter,	false,	"curr_cd",			false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			 70,	daRight,	false,	"cost_amt",			false,	"",		dfFloat,	2,	false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		 70,	daLeft,		false,	"rpr_sts_cd",		false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daLeft,		false,	"rqst_eq_no",		false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daLeft,		false,	"rpr_rqst_seq",		false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daLeft,		false,	"mnr_ord_ofc_cty_cd",false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daLeft,		false,	"mnr_ord_seq",		false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daLeft,		false,	"ord_dtl_seq",		false,	"",		dfNone,		0,	false,		false);
								                 			
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
					
					//SPP는 vndr_lgl_eng_nm 를 감춤  
					if(workApp == "SPP"){   
						ColHidden("vndr_lgl_eng_nm") = true; 
					}
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
						formObj.f_cmd.value = SEARCH;   
	     				sheetObj.DoSearch4Post("EES_MNR_0191GS.do",FormQueryString(formObj));	 	
					}                        
			break;          
			     	
			case IBCLEAR:      //초기화  
				MnrWaitControl(true);
                sheetObj.WaitImageVisible=false;  
				
				sheetObj.RemoveAll();       
				formObj.fm_mnr_inp_dt.value  = 	ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1); 	         
				formObj.to_mnr_inp_dt.value  = 	ComGetNowInfo("ymd");  
						
				//콤보데이타 조회
				var sCondition = new Array ( 
					new Array("MnrGenCd","CD00008", "COMMON")
				)		                       
						           
				//콤보데이타에 값을 세팅함 
				var sheetComboText = "";    
				var sheetComboCode = "";  
				var sheetComboDefault = "";    
				     
				var comboList = MnrComSearchCombo(sheetObj,sCondition); 
				for(var i = 0; i < comboList.length;i++){ 
			 	    
				 	if(comboList[i] != null){   
				 		for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");    
							 
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							         
							if(j ==0){
								sheetComboDefault = tempText[0];      	
							}  
						}            
					}                              
				}       
						       
				//쉬트 콤보를 설정   폼 콤보와 동일하여 여기서 설정한다.
				if (sheetComboText != "") 
			        sheetComboText = sheetComboText.substr(0, sheetComboText.length - 1);	
				if (sheetComboCode != "")
			        sheetComboCode = sheetComboCode.substr(0, sheetComboCode.length - 1);
				    		  
				sheetObj.InitDataCombo (0, "rpr_sts_cd", sheetComboText, sheetComboCode,sheetComboDefault); 
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
			if(sAction==IBSEARCH) {      
				if (!ComChkValid(formObj)) return false;       
			}        	           
        }      
        return true; 
    }
	
	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
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
	
    function sheet1_OnDblClick(sheetObj, Row, Col) {
		var formObj = document.form;
//		var colNm = sheetObj.ColSaveName(Col);

		var popParam = "";
		popParam = popParam + "?rqst_eq_no=" + sheetObj.CellValue(Row, "rqst_eq_no");
		popParam = popParam + "&rpr_rqst_seq=" + sheetObj.CellValue(Row, "rpr_rqst_seq");
		popParam = popParam + "&mnr_ord_ofc_cty_cd=" + sheetObj.CellValue(Row, "mnr_ord_ofc_cty_cd");
		popParam = popParam + "&mnr_ord_seq=" + sheetObj.CellValue(Row, "mnr_ord_seq");
		popParam = popParam + "&ord_dtl_seq=" + sheetObj.CellValue(Row, "ord_dtl_seq");
		if( sheetObj.CellValue(Row, "rpr") == "Repair" ){
			popParam = popParam + "&mnr_wo_tp_cd=" + "EST";
		} else{
			popParam = popParam + "&mnr_wo_tp_cd=" + "SPL";
		}
		
		ComOpenWindowCenter("EES_MNR_0061.do" + popParam, "EES_MNR_0061", 1020, 700, true);
	}
	/* 개발자 작업  끝 */