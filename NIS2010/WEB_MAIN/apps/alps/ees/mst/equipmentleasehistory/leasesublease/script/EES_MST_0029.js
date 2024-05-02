/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0029.js
*@FileTitle : Container Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.09 이호선
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
     * @class ees_mst_0029 : ees_mst_0029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0029() {
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
 var SEARCH_ENABLE = true; 

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
					
					case "btn_close":
						window.close();
					break;					
					
					case "New":
						sheetObject1.RemoveAll();
						formObject.cntr_no.value          = "";
						formObject.chk_dgt.value          = "";
						formObject.aciac_div_cd.value     = "";
						formObject.cntr_tpsz_cd.value     = "";
						formObject.lstm_cd.value          = "";
						formObject.cntr_tpsz_iso_cd.value = "";
						formObject.cntr_old_van_flg.value = "";
						formObject.ownr_co_cd.value       = "";
						formObject.cntr_use_co_cd.value   = "";
						formObject.cntr_no.focus();
					break;
					
					case "Down_Excel":
						sheetObject1.Down2Excel(-1,false,false,true,"","",false,false,"",false,"0");
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

         for(i=0;i<sheetObjects.length;i++){
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         if (document.form.cntr_no.value.length > 0)
 		   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		initControl();
 		
     }
      
	// Axon 이벤트 처리
	// 1. 이벤트catch
	function initControl() {
		var formObj = document.form;
	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keydown',	'obj_keydown',	form); //- 키 눌렸을때
		axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',	'obj_keyup',	form); //- 키 눌렸을때
		axon_event.addListenerFormat('keypress','obj_keypress',	form); //- 키 눌렸을때
 		axon_event.addListenerForm('change',	'obj_change',	form); //- 변경될때.		
		formObj.cntr_no.focus();
	} 
	
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_deactivate(){
	    //ComChkObjValid(event.srcElement);
	}
	
	function obj_activate(){
	    //ComClearSeparator(event.srcElement);
	}	
	
  	/**
  	* Key-Down Event 처리
  	*/
 	function obj_keydown() {
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;
 		
  		switch (obj.name) {
			case "cntr_no":
				if ( vKeyCode == 9 || vKeyCode == 13 ) {
		  			SEARCH_ENABLE = false;
		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		  			SEARCH_ENABLE = true;
		  			ComSetFocus(formObj.cntr_no);
		  		}
		  	break;
  		}
    }
	
  	function obj_keyup() {
 		var obj      = event.srcElement;
 		var vKeyCode = event.keyCode;
 		var formObj  = document.form;

  		switch(obj.name) {
			case "cntr_no":
			if ( ComTrim(ComGetObjValue(obj)) != "" ) {
				ComKeyEnter('LengthNextFocus');
			}
			break;
	   }
 	}  	 
  	 
 	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    
	    switch(obj.dataformat) {
	        case "engup":
	            if(obj.name=="cntr_no") ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "int":
	        	if(obj.name=="chk_dgt") ComKeyOnlyNumber('int');
	        break;
	    }        
	}
 	
	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;

		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(obj.name) {
	    		case "cntr_no":
	    			if ( SEARCH_ENABLE ) {
	    				formObj.chk_dgt.value ="";
	    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase(); // Copy&paste 소문자를 대문자로 변경
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    				ComSetFocus(formObj.cntr_no);
	    			}
					break;	
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

         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 400;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(25, 8, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false);

                     var HeadTitle = "|Status|Date|Yard|AGMT No.|Contract No.|Lessor|Lessor Name|F/M|Pre Movement|DOC Charge|DOC Credit|Curr.|Lift On/Off Charge|DII/DIO Fee|Min On-Hire Days|Free Day|Pick Up Charge|Pick Up Credit|Term Change|Created Date|Updated Date|Created User|Updated User|Remark(s)";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     var prefix="sheet1_";
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,  0,   daCenter,  false,   	 "SheetStatus");
                     InitDataProperty(0, cnt++ , dtData, 		  45,  daCenter,  false,     "cntr_sts_cd",     	    false,   "",      dfNone, 			0,     true,       true,	2);
                     InitDataProperty(0, cnt++ , dtData,     	  70,  daCenter,  false,     "cntr_sts_evnt_dt",        false,   "",      dfDateYmd, 		0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData, 		  60,  daCenter,  false,     "yd_cd",       		    false,   "",      dfNone, 			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,     	  80,  daCenter,  false,     "agmt_no",    		        false,   "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData, 		  120, daLeft,    false,     "ref_no",     		        false,   "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,     	  60,  daCenter,  false,     "vndr_seq",     		    false,   "",      dfNone, 			0,     true,       true);
					 InitDataProperty(0, cnt++ , dtData,     	  190, daLeft,    false,     "vndr_lgl_eng_nm",         false,   "",      dfNone, 			0,     true,       true);
					 InitDataProperty(0, cnt++ , dtData,     	  40,  daCenter,  false,     "cntr_full_flg",     	    false,   "",      dfNone, 			0,     true,       true);
					 InitDataProperty(0, cnt++ , dtData,     	  100, daCenter,  false,     "cnmv_sts_cd",     	    false,   "",      dfNone, 			0,     true,       true);
					 InitDataProperty(0, cnt++ , dtData,     	  80,  daRight,   false,     "cntr_drff_amt",           false,   "",      dfFloat, 			2,     true,       true);					 
					 InitDataProperty(0, cnt++ , dtData,     	  80,  daRight,   false,     "cntr_drff_cr_amt",        false,   "",      dfFloat, 			2,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,     	  40,  daCenter,  false,     "curr_cd",     		    false,   "",      dfNone, 			0,     true,       true);					 
					 InitDataProperty(0, cnt++ , dtData,     	  110, daRight,   false,     "cntr_lft_chg_amt",        false,   "",      dfFloat, 		    2,     true,       true);
					 InitDataProperty(0, cnt++ , dtData,     	  80,  daRight,   false,     "cntr_dir_itchg_fee_amt",  false,   "",      dfFloat, 			2,     true,       true);
					 InitDataProperty(0, cnt++ , dtData,     	  110, daRight,   false,     "cntr_min_onh_dys",     	false,   "",      dfInteger, 		0,     true,       true);					
					 InitDataProperty(0, cnt++ , dtData,     	  60,  daRight,   false,     "rntl_chg_free_dys",     	false,   "",      dfInteger, 		0,     true,       true);
					 InitDataProperty(0, cnt++ , dtData,     	  90,  daRight,   false,     "cntr_pkup_chg_amt",     	false,   "",      dfFloat, 			2,     true,       true);					 
					 InitDataProperty(0, cnt++ , dtData,     	  90,  daRight,   false,     "cntr_pkup_chg_cr_amt",    false,   "",      dfFloat, 			2,     true,       true);
					 InitDataProperty(0, cnt++ , dtData,		  0,   daCenter,  false,	 "cntr_lstm_cng_flg",	    false,	 "",	  dfNone,			0,	   true,	   true);					 
					 InitDataProperty(0, cnt++ , dtData,     	  0,   daCenter,  false,     "cre_dt",     	            false,   "",      dfNone, 			0,     true,       true);					 
					 InitDataProperty(0, cnt++ , dtData,     	  0,   daCenter,  false,     "upd_dt",     	            false,   "",      dfNone, 			0,     true,       true);					 
					 InitDataProperty(0, cnt++ , dtData,     	  0,   daLeft,    false,     "cre_usr_id",     	        false,   "",      dfNone, 			0,     true,       true);					 
					 InitDataProperty(0, cnt++ , dtData,     	  0,   daLeft,    false,     "upd_usr_id",     	        false,   "",      dfNone, 			0,     true,       true);
					 InitDataProperty(0, cnt++ , dtData,     	  150, daLeft,    false,     "cntr_sts_rmk",     		false,   "",      dfNone, 			0,     true,       true);

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
	            	if (formObj.cntr_no.value.trim().length == 0) {
	            		ComShowCodeMessage("MST00001","CNTR NO.");
	            		formObj.cntr_no.focus();
	            		return;
	            	}
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);	            	
	            	var sXml = sheetObj.GetSearchXml("EES_MST_0029GS.do", FormQueryString(formObj));
	            	var arrXml = sXml.split("|$$|");
                    // 입력 박스 데이타 채우기 	  
	            	formObj.chk_dgt.value          = ComXmlString(arrXml[0], "chk_dgt");
	            	formObj.aciac_div_cd.value     = ComXmlString(arrXml[0], "aciac_div_cd");
	            	formObj.cntr_tpsz_cd.value     = ComXmlString(arrXml[0], "cntr_tpsz_cd");
	            	formObj.lstm_cd.value          = ComXmlString(arrXml[0], "lstm_cd");
	            	formObj.cntr_tpsz_iso_cd.value = ComXmlString(arrXml[0], "cntr_tpsz_iso_cd");
	            	formObj.cntr_old_van_flg.value = ComXmlString(arrXml[0], "cntr_old_van_flg");
	            	formObj.ownr_co_cd.value       = ComXmlString(arrXml[0], "ownr_co_cd");
	            	formObj.cntr_use_co_cd.value   = ComXmlString(arrXml[0], "cntr_use_co_cd");
	            	//시트 데이타 채우기
	            	if (arrXml.length > 1) sheetObjects[0].LoadSearchXml(arrXml[1]);
	            	if (arrXml.length == 1) sheetObjects[0].LoadSearchXml(arrXml[0]);
	            	ComOpenWait(false);
				}
			break;
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }

	/* 개발자 작업  끝 */