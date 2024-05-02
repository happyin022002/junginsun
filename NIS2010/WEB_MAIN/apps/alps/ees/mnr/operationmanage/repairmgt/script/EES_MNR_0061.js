/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0061.js 
*@FileTitle : ACEP(Approved continuous Exam Program) Check List
*Open Issues :
*Change history :  
*@LastModifyDate : 2018.01.02
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2018.01.02 변종건		   		
* 1.0 Creation	 	   
* History
* 2018.01.02 변종건 신규 개발	
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
     * @class EES_MNR_0061 : EES_MNR_0061 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0061() {
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
var tabObjects = new Array();
var tabCnt = 0;   
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0; 

var sheetComboList = new Array();  

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
//				case "btn_New":  
//					doActionIBSheet(sheetObjects[0],formObject,IBCLEAR); 
//					break;
								
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE); 	
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
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
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
		initControl();
		
        for(i = 0;i < sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i + 1);
			ComEndConfigSheet(sheetObjects[i]);
        }
		
		for(k = 0;k < tabObjects.length;k++){
			initTab(tabObjects[k],k + 1);
		}
		
		for(k = 0;k < comboObjects.length;k++){
            initCombo(comboObjects[k],k + 1);
        }
		
		doActionIBSheet(sheetObjects[0], document.form , IBSEARCH);
    }
    
    /**
     * 화면 초기화
     */
    function setInitData(){
        var formObj = document.form;   
        var todate = new Date();
        var calToDate = new Date(new Date(Date.parse(todate)-30*1000*60*60*24));
//        ComSetObjValue(formObj.cre_from_dt, ""+calToDate.getFullYear()+"-"+ComLpad(calToDate.getMonth()+1,2,"0")+"-"+ComLpad(calToDate.getDate(),2,"0"));
//        ComSetObjValue(formObj.cre_to_dt, ComGetNowInfo("yy")+"-"+ComLpad(ComGetNowInfo("mm"),2,"0")+"-"+ComLpad(ComGetNowInfo("dd"),2,"0"));
//        ComSetObjValue(formObj.today, ComGetNowInfo("yy")+"-"+ComLpad(ComGetNowInfo("mm"),2,"0")+"-"+ComLpad(ComGetNowInfo("dd"),2,"0"));
    }
	
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		 				
        switch( sheetObj.id ){
            case "sheet1":
            	 with (sheetObj) {
					// 높이 설정
					style.height = 480;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]	
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 10, 100);
					
					var HeadTitle1 = "|Seq|ACEP Seq|ACEP Detail Seq|Item No.|Inspection Item|Inspection Status|Inspection Status";
					var HeadTitle2 = "|Seq|ACEP Seq|ACEP Detail Seq|Item No.|Inspection Item|Checked|Not checked";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
					//데이터속성    [	ROW, 	COL,  	DATATYPE,   	WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,  			KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(	0, 		cnt++,  dtHiddenStatus,	 50,	daCenter,	false,  	"ibflag");
					InitDataProperty(	0, 		cnt++,  dtSeq,    		 70,    daCenter,   true,   	"seq");    
					InitDataProperty(	0,		cnt++,	dtHidden,		140,   	daLeft,		true,		"acep_seq",			false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(	0,		cnt++,	dtHidden,		113,   	daLeft,		true,		"acep_dtl_seq",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(	0,		cnt++,	dtHidden,		 80,	daCenter,	true,		"insp_itm_no",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(	0,		cnt++,	dtData,			680,	daLeft,		true,		"insp_itm_nm",		false,		"",			dfNone,		0,			false,		false);
					InitDataProperty(	0,		cnt++,	dtCheckBox,		100,	daCenter,	false,		"acep_chk",			false,		"",			dfNone,		0,			true,		true);
					InitDataProperty(	0,		cnt++,	dtCheckBox,		100,	daCenter,	false,		"acep_unchk",		false,		"",			dfNone,		0,			true,		true);
					    												 				 			
    				ColFontColor("TP") = RgbColor(255,0,0);
					
					MultiSelection = false;
					//SELECT 로우 배경색
					SelectionMode = smSelectionRow;
					SelectHighLight = true;
					SelectFontBold = false;
					SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
					CountPosition = 2;
				}
				break;
        }
    }
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:      //목록조회
        		if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.WaitImageVisible = true;
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0061GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
					
					//상단 폼값 채움  
					ComSetObjValue(formObj.acep_seq, ComGetEtcData(sXml, "acep_seq"));  	 
					ComSetObjValue(formObj.rpr_rqst_seq, ComGetEtcData(sXml, "rpr_rqst_seq"));  	 
					ComSetObjValue(formObj.mnr_ord_ofc_cty_cd, ComGetEtcData(sXml, "mnr_ord_ofc_cty_cd"));  	 
					ComSetObjValue(formObj.mnr_ord_seq, ComGetEtcData(sXml, "mnr_ord_seq"));  	 
					ComSetObjValue(formObj.ord_dtl_seq, ComGetEtcData(sXml, "ord_dtl_seq"));  	 
					ComSetObjValue(formObj.mnr_wo_tp_cd, ComGetEtcData(sXml, "mnr_wo_tp_cd"));  	 
					ComSetObjValue(formObj.eq_no, ComGetEtcData(sXml, "eq_no"));   	 
					ComSetObjValue(formObj.cntr_tpsz_cd, ComGetEtcData(sXml, "cntr_tpsz_cd"));   	 
					ComSetObjValue(formObj.mft_dt, ComGetEtcData(sXml, "mft_dt"));    	 
					ComSetObjValue(formObj.insp_yd_cd, ComGetEtcData(sXml, "insp_yd_cd"));
					ComSetObjValue(formObj.cre_usr_nm, ComGetEtcData(sXml, "cre_usr_nm"));
					ComSetObjValue(formObj.lst_insp_dt, ComGetEtcData(sXml, "lst_insp_dt"));
					ComSetObjValue(formObj.insp_dt, ComGetEtcData(sXml, "insp_dt"));
					formObj.lst_insp_dt.focus();
					formObj.insp_dt.focus();
					formObj.eq_no.focus();
				}
				break;
				
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;

					var sParam = sheetObj.GetSaveString(true, true);
					
					sParam = ComSetPrifix(sParam,"sheet1_");
					sParam += "&" + FormQueryString(formObj);
					var sXml = sheetObj.GetSaveXml("EES_MNR_0061GS.do", sParam);
					sheetObj.LoadSaveXml(sXml);

					//상단 폼값 채움  
					ComSetObjValue(formObj.acep_seq, ComGetEtcData(sXml, "acep_seq"));  	 
					ComSetObjValue(formObj.rpr_rqst_seq, ComGetEtcData(sXml, "rpr_rqst_seq"));  	 
					ComSetObjValue(formObj.mnr_ord_ofc_cty_cd, ComGetEtcData(sXml, "mnr_ord_ofc_cty_cd"));  	 
					ComSetObjValue(formObj.mnr_ord_seq, ComGetEtcData(sXml, "mnr_ord_seq"));  	 
					ComSetObjValue(formObj.ord_dtl_seq, ComGetEtcData(sXml, "ord_dtl_seq"));  	 
					ComSetObjValue(formObj.mnr_wo_tp_cd, ComGetEtcData(sXml, "mnr_wo_tp_cd"));  	 
					ComSetObjValue(formObj.eq_no, ComGetEtcData(sXml, "eq_no"));   	 
					ComSetObjValue(formObj.cntr_tpsz_cd, ComGetEtcData(sXml, "cntr_tpsz_cd"));   	 
					ComSetObjValue(formObj.mft_dt, ComGetEtcData(sXml, "mft_dt"));    	 
					ComSetObjValue(formObj.insp_yd_cd, ComGetEtcData(sXml, "insp_yd_cd"));
					ComSetObjValue(formObj.cre_usr_nm, ComGetEtcData(sXml, "cre_usr_nm"));
					ComSetObjValue(formObj.lst_insp_dt, ComGetEtcData(sXml, "lst_insp_dt"));
					ComSetObjValue(formObj.insp_dt, ComGetEtcData(sXml, "insp_dt"));
				}
				break;
				
			case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;

	    		//Sheet 초기화
	    		sheetObjects[0].RemoveAll();
	    		
	    		ComResetAll();
        		setInitData();
				
	    		sheetObj.WaitImageVisible = true;
	    		break;
		}
    }
			
		
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
				case IBSAVE:
					//폼중 필수 입력값이 다 제대로 들어갔는지  
//					if (!ComChkValid(formObj)) return false;
					break;
			}
		}
        return true;
    }
	
	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
		
		//Work Order 단계인 대상은 저장 불가. 오직 Estimate 단계에서만 저장 가능
		if( document.form.mnr_ord_seq.value != "" ){
			ComBtnDisable("btn_Save");
			sheetObjects[0].Enable = false;
		} else{
			ComBtnEnable("btn_Save");
			sheetObjects[0].Enable = true;
		}
		ComBtnEnable("btn_Close");
	}             
		   	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement);
	    
		var obj = event.srcElement;
//		if( obj.name == "mnr_rpr_rmk" ){
//			//Verify Result 및 Remark에 따른 Approval 버튼 활성/비활성 여부 로직
//			btnAproByVrfyRslt();
//		}
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
	    		case "eq_no":	   
//	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
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
	        	ComKeyOnlyNumber(event.srcElement);
	        	break;
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
	
	function sheet1_OnClick(sheetObj, Row, Col, Value){
		
		if(sheetObj.ColSaveName(Col)  == "acep_chk"){			//Checked 선택 시 Not checked 선택 해제
			if( sheetObj.CellValue(Row ,"acep_unchk") == "1" ){
				sheetObj.CellValue(Row ,"acep_unchk") = "0";
			}
		} else if(sheetObj.ColSaveName(Col)  == "acep_unchk"){	//Not checked 선택 시 Checked 선택 해제
			if( sheetObj.CellValue(Row ,"acep_chk") == "1" ){
				sheetObj.CellValue(Row ,"acep_chk") = "0";
			}
		}
	}
	
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00334");
		}
	}
	/* 개발자 작업  끝 */