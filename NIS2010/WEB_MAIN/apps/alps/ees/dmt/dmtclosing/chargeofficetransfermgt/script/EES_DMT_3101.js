/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3101.js
*@FileTitle : Office Transfer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.21 황효근
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
     * @class EES_DMT_3101 : EES_DMT_3101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3101() {
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
	
	var ROWMARK = "|";
	var FIELDMARK = "=";


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
 				case "btn_Save":
 					doActionIBSheet(sheetObj,formObj,IBSAVE);
					break;
					
 				case "btn_Close":
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
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }

     
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	}
     

     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         // IBMultiCombo초기화 
         for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
         }
         
         //html컨트롤 이벤트초기화
         initControl();
     }
    
      
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
   	function sheet1_OnLoadFinish() {
		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
 		//sheetObj.WaitImageVisible = false;
		
		// RHQ Combobox 초기화
        doActionIBCombo(sheetObj, formObj, formObj.shd_rhq_cd, COMMAND06);
        
        // Should Read RHQ 초기 설정
        ComSetObjValue(formObj.shd_rhq_cd, formObj.ofc_rhq_cd.value);
        ComSetObjValue(formObj.rhq_ofc_cd, formObj.ofc_rhq_cd.value);
		
        // 조회조건 초기화
        doInit();
        //sheetObj.WaitImageVisible = true; 
   	}
     
     
	function initControl() {
 		//axon_event.addListenerForm  ('blur',	'obj_blur',		document.form); //- 포커스 나갈때
 		//axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때
 		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
 		axon_event.addListener('change',		'rhq_change',	'shd_rhq_cd');
 		//axon_event.addListener('keydown',		'ComKeyEnter',	'form');
 	}
 	
	// From/To Office의 RHQ Select Object OnChange 이벤트 처리
 	function rhq_change() {
 		var formObj = document.form;
 		//var obj = formObj.shd_rhq_cd;
 		
 		// Office RHQ의 선택된 항목
 		//var rhqCd = ComGetObjValue(obj);
 		ComSetObjValue(formObj.rhq_ofc_cd, formObj.shd_rhq_cd.value);
 		
 		// 선택된 RHQ에 속하는 Office Code 리스트를 설정할 IBMultiCombo Object 지정
 		var comboObj = comboObjects[0];
 		comboObj.RemoveAll();
 		
 		doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND21);
 	}
 	
 	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
		switch(event.srcElement.dataformat){
        	case "engup":
		    	// 영문대+숫자 
        		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
        	case "engup3":
		    	// 영문대+ALL
        		DmtComKeyOnlyAlphabet('upperall');
		        break;
        	case "int":
	   	        //숫자 만입력하기
	   	        //ComKeyOnlyNumber(event.srcElement);
	   	        break;
        	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            //ComKeyOnlyNumber(event.srcElement);
		}
    }
 	
	/*
	 * INIT SETTING
	 */
	function doInit() {
		var formObj = document.form;
		rhq_change();
		
		var opener = window.dialogArguments;
		var opnSheetObj = opener.document.form.sheet1;
		var sheetObj = sheetObjects[0];
		
		//sheet1의 "chk" 컬럼이 체크된 데이터를 조회XML로 만들기
		var sXml = ComMakeSearchXml(opnSheetObj, false, "chk", "cntr_no|cntr_tpsz_cd|bkg_no|bl_no|rlse_ofc|svr_id|cntr_cyc_no|dmdt_chg_loc_div_cd|chg_seq|dmdt_chg_sts_cd|dmdt_trf_cd");
		
		//sheet2로 조회XML 로드하기
		sheetObj.LoadSearchXml(sXml, true);
		
		//alert(sheetObj.TopRow + '..' + sheetObj.SearchRows);
		if(sheetObj.SearchRows == 0) {
			// by CNTR 화면에서 호출됨 
			var row = sheetObj.DataInsert(-1);
			//sheetObj.CellValue(row, "ibflag") = formObject.login_usr_nm.value;
			
			var opnFormObj = opener.document.form;
			sheetObj.CellValue(row, "cntr_no") 				= ComGetObjValue(opnFormObj.cntr_no);
			sheetObj.CellValue(row, "cntr_tpsz_cd") 		= ComGetObjValue(opnFormObj.cntr_tpsz_cd);
			sheetObj.CellValue(row, "bkg_no")				= ComGetObjValue(opnFormObj.bkg_no);
			sheetObj.CellValue(row, "bl_no")				= ComGetObjValue(opnFormObj.bl_no);
			sheetObj.CellValue(row, "rlse_ofc")				= ComGetObjValue(opnFormObj.rlse_ofc);
			sheetObj.CellValue(row, "svr_id")				= ComGetObjValue(opnFormObj.svr_id);
			sheetObj.CellValue(row, "cntr_cyc_no")			= ComGetObjValue(opnFormObj.cntr_cyc_no);
			sheetObj.CellValue(row, "dmdt_chg_loc_div_cd")	= ComGetObjValue(opnFormObj.dmdt_chg_loc_div_cd);
			sheetObj.CellValue(row, "chg_seq")				= ComGetObjValue(opnFormObj.chg_seq);
			sheetObj.CellValue(row, "dmdt_chg_sts_cd")		= ComGetObjValue(opnFormObj.dmdt_chg_sts_cd);
			sheetObj.CellValue(row, "dmdt_trf_cd")			= ComGetObjValue(opnFormObj.dmdt_trf_cd);
		}
		
		sheetObj.CheckAll("chk") = 1;
 	}
	

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         
         switch(sheetNo) {
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = GetSheetHeight(12);
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(14, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle  = "||Seq.|CNTR No.|T/S|BKG No.|B/L No.|D/O or R/OFC";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	true,	"chk");
                    InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"cntr_no",				false,	"", dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"cntr_tpsz_cd",			false,	"", dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"bkg_no",				false,	"", dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"bl_no",				false,	"", dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"rlse_ofc",				false,	"", dfNone,	0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtHidden,    	0,	daCenter,	true,	"dmdt_chg_sts_cd",		false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,	daCenter,	true,	"svr_id",				false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,	daCenter,	true,	"cntr_cyc_no",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,	daCenter,	true,	"dmdt_trf_cd",			false,  "",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,	daCenter,	true,	"dmdt_chg_loc_div_cd",	false,	"",	dfNone,	0,	false,  false);
					InitDataProperty(0, cnt++ , dtHidden,    	0,	daCenter,	true,	"chg_seq",				false,  "",	dfNone,	0,	false,  false);
 			   }
                 
               break;

         }
     }
     
     
	 /**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */
 	function initCombo(comboObj, comboNo) {
	    var formObj = document.form;
	    
	    switch(comboObj.id) {
	    	case "cb_to_ofc_cd":
	    		with (comboObj) {
					MultiSelect = false;
					UseAutoComplete = true;
					SetColAlign("left");
   					SetColWidth("60");
   					DropHeight = 160;
 					ColBackColor(0) = "#CCFFFD";
 					BackColor = "#CCFFFD";
 					
 					ValidChar(2);	// 영어대문자 사용
					MaxLength = 6;
    		    }
				break; 
	     }
 	}
     

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
         	case IBSAVE:        //저장
         		if(!validateForm(sheetObj,formObj,sAction)) return;
				
	         	sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
        	
 				formObj.f_cmd.value = MULTI;
 				sheetObj.DoSave("EES_DMT_3101GS.do", FormQueryString(formObj),"chk");
 				ComOpenWait(false);
                break;
         }
     }

   
	// 저장후 처리
	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		// 저장 오류 발생
		if(ErrMsg != '') return;
		
		ComShowCodeMessage('DMT01074');
		 
		var opener = window.dialogArguments;
		opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
		self.close();
	}
	
	
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
        	if (sheetObj.ColSaveName(Col) == "chk") {
            	//Check box 클릭시  AllCheck box 상태 동기화 처리
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
     
     
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
 		sheetObj.ShowDebugMsg = false;
 		sheetObj.WaitImageVisible = false;
  
 		formObj.f_cmd.value = formCmd;
 		var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
  
 		switch(comboObj.id) {
 			case "cb_to_ofc_cd":
 				if(formCmd == COMMAND21) {
	 				var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
	 				if(subOfcCds != undefined && subOfcCds != '') {	 					
	 					var comboItems = subOfcCds.split("|");
	 					var tempArr = [];
	 					for(var i in comboItems) {
	 						var temp = comboItems[i].split("=");
	 						tempArr.push(temp[0]);
	 					}
	 					addComboItem(comboObj,tempArr);
	 					comboObj.Index = -1;
	 					comboObjects[0].Code = tempArr[0];
	 				}
 				} else { // COMMAND09
 					var rhqCd = ComGetEtcData(sXml, "RHQ_CD");
 					if(rhqCd != '') {
 						// 입력한 ToOffice
 						var toOfcCd = comboObjects[0].Text;
 						ComSetObjValue(formObj.shd_rhq_cd, rhqCd);
 						ComSetObjValue(formObj.rhq_ofc_cd, rhqCd);
 						rhq_change();
 						comboObjects[0].Code = toOfcCd;
 					} else {
 						comboObj.Code = "";
 						ComShowCodeMessage('DMT00110', 'Should Read Office');
 					}
 				}
 	    	    break;
 	    	    
 			case "shd_rhq_cd":    
        		var data = ComGetEtcData(sXml, "common_cd");
				if (data != undefined && data != '') {
					var comboItems = data.split(ROWMARK);
					addComboItem(comboObj, comboItems);
				}
				 break;
         }
         sheetObj.WaitImageVisible = true;
     }
 	
 	
	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */	
  	function addComboItem(comboObj,comboItems) {
  		switch(comboObj.id) {
  			case "cb_to_ofc_cd":
 		  		for (var i = 0 ; i < comboItems.length ; i++) {
 		  			comboObj.InsertItem(i, comboItems[i], comboItems[i]);
 		  	   	}
 		  		break;
 		 
  			case "shd_rhq_cd":
  				for (var i = 0 ; i < comboItems.length ; i++) {
		  	   		ComAddComboItem(comboObj, comboItems[i], comboItems[i]);
		  	   	}
 		  		break;
  		}
  	}
  	
  	
  	/*
  	 * To(Should Read) Office Code를 직접 입력할  경우, Validation 중복처리를 
  	 * 제어하기 위한 Flag 변수
  	 */
  	var TO_OFC_CHK_FLG = false;
  	
  	
  	/*
  	 * 포커스가 나갔을때  발생하는 이벤트 처리
  	 */
  	function cb_to_ofc_cd_OnBlur(comboObj) {
  		
  		if(TO_OFC_CHK_FLG) {
  			return;
  		}
  		
  		var ofcCd = comboObj.Text;
  		if(ofcCd == '') return;
  		
  		if(ofcCd.length < 5) {
  			TO_OFC_CHK_FLG = true;
  			comboObj.Code = "";
  			ComShowCodeMessage('DMT00110', 'Should Read Office');
  			return;
  		}
  		
  		TO_OFC_CHK_FLG = true;
  		
  		var formObj = document.form;
  		ComSetObjValue(formObj.ofc_cd, ofcCd);
  		doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND09);
  	}
  	
  	
  	// 선택된 콤보Item이 변경되었을 때 이벤트발생
	function cb_to_ofc_cd_OnChange(comboObj,value,text) {
  		// 콤보 리스트에 존재하는  Office 변경
  		if(value != '') {
  			TO_OFC_CHK_FLG = true;
  		} else if(text != '')
  			TO_OFC_CHK_FLG = false;
  	}

  	
	// 키보드가 눌렸을 때 이벤트 발생
  	function cb_to_ofc_cd_OnKeyDown(comboObj, keycode, shift) {
  		
  		if(keycode != 13) return;
  		
  		if(TO_OFC_CHK_FLG) return;
  		
  		var ofcCd = comboObj.Text;
  		if(ofcCd == '') return;
  		
  		if(ofcCd.length < 5) {
  			TO_OFC_CHK_FLG = true;
  			comboObj.Code = "";
  			ComShowCodeMessage('DMT00110', 'Should Read Office');
  			return;
  		}
  		
  		TO_OFC_CHK_FLG = true;
  		
  		var formObj = document.form;
  		ComSetObjValue(formObj.ofc_cd, ofcCd);
  		doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND09);
  		//TO_OFC_CHK_FLG = false;
  	}
  	
  	
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         
    	 with(formObj){
        	 switch(sAction) {
		         case IBSAVE:
		        	 var fmOfcCd = ComGetObjValue(fm_ofc_cd);
		        	 var toOfcCd = ComGetObjValue(comboObjects[0]);
		        	 
		        	 if(ComIsEmpty(toOfcCd)) {
		        		 ComShowCodeMessage('DMT01021');
		        		 return false;
		        	 }
		        	 
		        	 if(fmOfcCd == toOfcCd) {
		        		 ComShowCodeMessage('DMT01044');
		        		 return false;
		        	 }
		        	 
		        	 var fmOfcRhqCd = ComGetObjValue(ofc_rhq_cd);
		        	 var toOfcRhqCd = ComGetObjValue(shd_rhq_cd);
		        	 
		        	 // 'L' status의 CNTR의 경우 타지역 O/T 불가
		        	 if(fmOfcRhqCd != toOfcRhqCd) {
		        		 for(var i=sheetObj.TopRow; i <= sheetObj.LastRow; i++) {
		        			if(sheetObj.CellValue(i, "dmdt_chg_sts_cd") == 'L') {
		        				ComShowCodeMessage('DMT01010');
		        				return false;
		        			}
		        		 }
		        	 }
		        	 
		        	 
		        	 var trnsRsn = ComGetObjValue(trns_rsn);
		        	 if(ComIsEmpty(trnsRsn)) {
		        		 ComShowCodeMessage('DMT01045');
		        		 ComSetFocus(trns_rsn);
		        		 return false;
		        	 }
		        	 
		        	 if(ComChkLenByByte(trnsRsn, 500) == 0) {	// 길이초과
		        		 ComAlertFocus(trnsRsn, ComGetMsg('COM12173', 'Reason', '500'));
		        		 return false;
		        	 }
		        	 
		        	 ComSetObjValue(to_ofc_cd, comboObjects[0].Code);
		        	 break;
        	 }
        	 
         }

         return true;
     }
    

	/* 개발자 작업  끝 */