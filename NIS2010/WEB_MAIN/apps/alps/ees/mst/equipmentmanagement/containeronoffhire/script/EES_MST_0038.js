/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0038.js
*@FileTitle : Lot No Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.17 민정호
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
     * @class ees_mst_0038 : ees_mst_0038 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0038() {
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

// Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		        var sheetObject1 = sheetObjects[0];
	            var formObject = document.form;
        /*******************************************************/

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
             	
							case "btn_retrieve":
								// 필수항목 Check  
								if(!checkItem(formObject)) return;
								doActionIBSheet(sheetObjects[0],formObject,IBSEARCH); 
							break;
							
							case "btn_new":
			   				    ComResetAll();
								sheetObject1.RemoveAll();
							break;
							
							case "btn_ok":
								if(sheetObject1.RowCount == 0){
									window.close();
								}else{
									comPopupOK();
								}
							break;
							
							case "btn_close":
								window.close();
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
	  * 필수항목 체크
	  */
	function checkItem(formObj){
		var inputYn = 'N'

		if( formObj.cntr_no.value.trim().length == 0  &&
			formObj.de_yrmon.value.trim().length == 0 &&
			comboObjects[0].Text == '')
		{
			ComShowCodeMessage("MST02019");
			return false;
		}
					
		if(formObj.de_yrmon.value.trim().length > 0 && formObj.de_yrmon.value.trim().length < 4){
			ComShowCodeMessage("MST01019", formObj.de_yrmon.value.trim());
			formObj.de_yrmon.value = '';
			formObj.de_yrmon.focus();
			return false;
		}
		return true;
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
 	 * IBMultiCombo Object를 배열로 등록
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
        
        //IBSheet 초기화하기
        for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

 		for ( k = 0 ; k < comboObjects.length ; k++ ) {
 	        initCombo(comboObjects[k], k+1);
 	    }

		initControl();
    }

      /**
       * initControl
      */      
  	function initControl() {
		axon_event.addListenerFormat('keypress','obj_keypress',	form);				//- 키 눌렸을때
		axon_event.addListener('keypress', 'cntr_no_keypress', 'cntr_no');
		axon_event.addListener("change", "de_yrmon_change","de_yrmon");
		axon_event.addListener("change", "cntr_no_change","cntr_no");
	}

    /**
     * obj_keypress
    */   
 	function obj_keypress(){
	    
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    
	    switch(obj.dataformat) {
	        case "engup":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
         	case "int":
    	        //숫자 만입력하기
				ComKeyOnlyNumber(event.srcElement);
    	        break;
	    }        
	}

    /**
     * cntr_no_keypress
    */   	
	function cntr_no_keypress(){
		var formObj = document.form;

		if(formObj.cntr_no.value.trim().length == 10){
			ComSetFocus(formObj.de_yrmon);
		}
	}

    /**
     * cntr_no_change
    */  
	function cntr_no_change(){
		var formObj = document.form;
		
		if(formObj.cntr_no.value.trim().length != 10){
			ComShowCodeMessage("MST01020", formObj.cntr_no.value.trim());
			ComSetFocus(formObj.cntr_no);
			return;
		}
	}

    /**
     * de_yrmon_change
    */   	
	function de_yrmon_change() {
		var formObj = document.form;

		if(formObj.de_yrmon.value.trim().length > 0){		
			if(!ComIsNumber(formObj.de_yrmon)){
				ComShowCodeMessage("MST01019", formObj.de_yrmon.value.trim());
				formObj.de_yrmon.value = '';
				formObj.de_yrmon.focus();
				return;
			}
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
            case "sheet1":      // t1sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 100;
                    
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);

                    var HeadTitle1 = "|Lot No|AGMT No|Serial Range";
										
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtRadioCheck,30,    daCenter,  false,    "radio",       false,          "",       dfNone,	    0,     true,       true);
//                    InitDataProperty(0, cnt++ , dtCheckBox,  50,    daCenter,  false,    "check",       false,          "",       dfNone,   	0,     true,       true);                    
                    InitDataProperty(0, cnt++, dtHiddenStatus,0,    daCenter,  false,   "sStatus");
                    InitDataProperty(0, cnt++, dtData,        180,  daCenter,  false,   "lot_no",      false,  "",       dfNone,     0,   true,		true);
                    InitDataProperty(0, cnt++, dtData,        180,  daCenter,  false,   "agmt_no",       false,  "",       dfNone,     0,   true,		true);
                    InitDataProperty(0, cnt++, dtData,        180,  daCenter,  false,   "serial_range",     false,  "",       dfNone,  		0,   true,		true);

					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"cntr_no",	false,	"",		dfNone,		0,	false,		false);        
					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"de_yrmon",	false,	"",		dfNone,		0,	false,		false);       
					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"cntr_tpsz_cd",	false,	"",		dfNone,		0,	false,		false);   
					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"lot_pln_yr",	false,	"",		dfNone,		0,	false,		false);     
					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"lot_loc_cd",	false,	"",		dfNone,		0,	false,		false);     
					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"lot_seq",	false,	"",		dfNone,		0,	false,		false);        
					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"agmt_cty_cd",	false,	"",		dfNone,		0,	false,		false);    
					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"agmt_seq",	false,	"",		dfNone,		0,	false,		false);       
					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"lot_cntr_pfx_cd",	false,	"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"fm_ser_no",	false,	"",		dfNone,		0,	false,		false);      
					InitDataProperty(0, cnt++ , dtHidden,	  50,	daCenter,  false,	"to_ser_no",	false,	"",		dfNone,		0,	false,		false);      

                }
                break;
                
        }
    }

  	/**
  	 * 콤보 초기설정값, 헤더 정의
  	 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initCombo(comboObj, comboNo) {
  	    switch(comboObj.id) {
  	        case "combo1":
  	        	with(comboObj) {
  	            	DropHeight = 200;
  	            	MultiSelect = false;
  	            	MaxSelect = 1;
  	            	MultiSeparator = ",";
  	            	BackColor = "white";
  	            }
  	        	
  	        	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
  	        	
  	        	break;
  	    }
  	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if (sheetObj.id == "sheet1")
				{
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);					
					formObj.f_cmd.value = SEARCH;
	 				xml = sheetObj.GetSearchXml("EES_MST_0038GS.do", FormQueryString(formObj));
            		sheetObj.LoadSearchXml(xml);
            		ComOpenWait(false);
				}
				break;
					
			case IBCREATE:
	      		formObj.f_cmd.value = SEARCH02;
	         	sheetObj.WaitImageVisible = false;
	         	var sXml = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
		        sheetObj.WaitImageVisible = true;
    			var chk = sXml.indexOf("ERROR");
    			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
    			   sheetObj.LoadSearchXml(sXml);
    			   return;
    			}		        

	            if ( sXml != "" ) {
		            var sCntrTpSzNm = ComGetEtcData(sXml,"cntr_tpsz_nm");
		            var sCntrTpSzCd = ComGetEtcData(sXml,"cntr_tpsz_cd");
		            
		            var arrCntrTpSzNm = sCntrTpSzNm.split("|");
		            var arrCntrTpSzCd = sCntrTpSzCd.split("|");
			            
		      		comboObjects[0].InsertItem(0, "", "");
		            MstMakeComboObject(comboObjects[0], arrCntrTpSzNm, arrCntrTpSzCd);
		            
		            // 초기 기본값 설정.
//		            comboObjects[0].Index = 0; 
		      		formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObjects[0]);
	            }
	            break;					
        }
    }

    /**
     * 더블클릭 처리.
     * @param SheetObj
     * @param Row
     * @param Col
     * @return
     */
	function sheet1_OnDblClick(SheetObj, Row, Col)
	{   
		if(SheetObj.RowCount == 0){
			window.close();
		}else{
			comPopupOK();
		}
	}

	/**
  	 * combo1_OnChange
  	 */
  	function combo1_OnChange(comboObj, Index_Code, Text) {
  		var formObj = document.form;
  		formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
  	}
  	
  	/**
  	 * combo1_OnKeyDown
  	 */
  	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
  		with(comboObj) {
  			if ( KeyCode == 8 || KeyCode == 46 ) {
  				for ( i = 0 ; i < GetCount() ; i++ ) {
  					if ( CheckIndex(i) ) {
  						CheckIndex(i) = false;
  					}
  				}
  			}
  		}
  	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        /*
        with(formObj){
            if (!isNumber(formObj.iPage)) {
                return false;
            }
        */
        return true;
    }
	/* 개발자 작업  끝 */