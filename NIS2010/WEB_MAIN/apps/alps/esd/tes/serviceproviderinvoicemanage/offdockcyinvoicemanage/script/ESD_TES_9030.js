/**
 * @fileoverview Off-Dock CY Invoice Revised Volume TP Input (Auto) 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */

/**
 * @extends Tes
 * @class ESD_TES_9030 : Off-Dock CY Invoice Revised Volume TP Input (Auto) 화면에서 사용하는 업무 스크립트를 정의한다.
 * 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
 * 2011.11.21 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완(수정)
 * 2011.11.23 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
 */
function ESD_TES_9030() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var RVIS_CNTR_LIST_CD = '';
	var err_flag = false;
	


	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 * @return
	 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];

         var formObj = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

         	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObj,IBINSERT);
        	        break;

         	    case "btn_save":
					
         	    	if (!sheetObject.IsDataModified){
						ComShowMessage(ComGetMsg('TES21601')); //ComShowMessage('수정된 내역이 없습니다.');
						return false;
					}

         	    	if(!chkDupRow(sheetObject)){
						return false;
					}
         	    	
					for(var i=sheetObject.HeaderRows ; i<sheetObject.HeaderRows + sheetObject.RowCount; i++){
						if(sheetObject.CellValue(i,"ibflag")!='D'){
							if(sheetObject.CellValue(i,"eff_cntr_yn")=='N' && sheetObject.CellValue(i,"otr_crr_flg")!='Y'){
								sheetObject.CellFontColor(i, "rvis_cntr_no") = sheetObject.RgbColor(255, 0, 0);
								err_flag = true;
							}
						}
					}
					
					if(err_flag == true){
						alert('Wrong TPSZ');
						err_flag = false;
						break;
					}
					
					if(err_flag == false){
						doActionIBSheet(sheetObject,formObj,IBSAVE);
					}
					
        	        break;

         	    case "btn_close":
    	            window.close();
        	        break;

             	case "btn_rowdel":
    	            doActionIBSheet(sheetObject,formObj,IBDELETE);
    	            break;
 
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }


	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @return     
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    * @return
    */
    function loadPage() {
        for (i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }

		var formObj = document.form;
		//doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value.trim()=='A'){
			//자동MODE
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
		else if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && (formObj.calc_tp_cd.value.trim()=='M' || formObj.calc_tp_cd.value.trim()=='S')){
			//수동MODE
			doActionIBSheetManual(sheetObjects[0],document.form,IBSEARCH);
		}
	}

    /**
    * 시트 초기설정값, 헤더 정의
	  * @param {ibsheet} sheetObj 	IBSheet Object
	  * @param {int} sheetNo 	시트오브젝트 태그의 아이디에 붙인 일련번호
	  * 							시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    * @return
    */
    function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;
                                        
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(16, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "Del.|STS|Seq.|Cost Code|CNTR No.|TPSZ|B/L|OTH Carrier|Remarks";
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtCheckBox,   30,    daCenter,  false,    "tml_rvis_ind_flg",        false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++, dtHiddenStatus,     30,    daCenter,  false,    "ibflag");
                    InitDataProperty(0, cnt++, dtSeq,        50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData,      90,    daCenter,  false,    "lgs_cost_cd",        true,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++, dtData,       90,    daCenter,  false,    "cntr_no",        true,          "",       dfEngUpKey,    0,     false,       true);
                    
                    InitDataProperty(0, cnt++, dtData,       40,    daCenter,  false,    "cntr_tpsz_cd",        true,          "",       dfEngUpKey,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       90,    daCenter,  false,   "bkg_no",       false,          "",       dfEngUpKey,    0,     false,       true);
					
					InitDataProperty(0, cnt++, dtCombo,       110,   daCenter,  false,    "otr_crr_flg",        false,          "",       dfNone, 0,     false,       true);
					
                    InitDataProperty(0, cnt++, dtData,       90,    daLeft,	   false,   "cntr_rmk",       false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  false,    "tml_so_ofc_cty_cd",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  false,    "tml_so_seq",        false,          "",       dfNone,    0,     true,       true);
					
                    InitDataProperty(0, cnt++, dtHidden,     50,    daCenter,  false,    "tml_so_cntr_list_seq",        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  false,    "tml_so_dtl_seq",        false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  false,    "tml_so_rvis_list_seq",        false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  false,    "cntr_sty_cd",        false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++, dtHidden,     40,    daCenter,  true,     "eff_cntr_yn" 				,        false,          "",       dfNone,    0,     false,       true,		14);
					
					InitDataCombo(0, "otr_crr_flg", "Y|N", "Y|N","N","N");
					
			   }
               break;

             case 2:   //manual_mode_hidden
                with (sheetObj) {
                    style.height=GetSheetHeight(5);
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1 , 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(2, 1, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "rvis_cntr_list_cd|lgs_cost_cd";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       50,    daLeft,  false,    "rvis_cntr_list_cd",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daLeft,  false,    "lgs_cost_cd",     false,          "",       dfNone,         0,     true,      true);
			    }
                break;
                
                
        }
    }

	/**
	 * Auto Calculated Cost Sheet 관련 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}	sAction		실행할 액션 구분 값
	 * @return
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		   case IBSEARCH:      //조회
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value = SEARCHLIST;
			    sheetObj.DoSearch4Post("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
			    break;

           case IBINSERT:      //입력
                var Row = sheetObj.DataInsert(-1);
				// tml_so_dtl_seq가 존재하는 경우(이미 DB에 저장된 값이라는 말쌈)
				if (isNaN(formObj.tml_so_dtl_seq.value)) {
					ComShowMessage(ComGetMsg('TES24009','tml_so_dtl_seq')); //ComShowMessage('[NaN] tml_so_dtl_seq 값에 오류가 발생했습니다.');
					return false;
				}
				sheetObj.CellValue2(Row,"tml_so_dtl_seq") = formObj.tml_so_dtl_seq.value;
				
				setShtCellsEditable(sheetObj,Row,'lgs_cost_cd|bl_no|cntr_rmk','Y');
				//sheetObj.InitCellProperty(Row,'lgs_cost_cd',dtCombo,daCenter,'lgs_cost_cd','',dfNone);
				//sheetObj.CellComboItem(Row,'lgs_cost_cd',formObj.calcTerminalComboItems.value,formObj.calcTerminalComboItems.value);
				sheetObj.CellValue2(Row,"lgs_cost_cd") = formObj.param_lgs_cost_cd.value;
				sheetObj.CellValue2(Row,"tml_so_ofc_cty_cd") = formObj.tml_so_ofc_cty_cd.value;
				sheetObj.CellValue2(Row,"tml_so_seq") = formObj.tml_so_seq.value;
				sheetObj.CellEditable(Row, "lgs_cost_cd") = false;
				//sheetObj.CellEditable(Row, "cntr_tpsz_cd") = false;
				break;

           case IBSAVE:      //저장
				/*
				if (!sheetObj.IsDataModified){
					return false;
				}
				formObj.f_cmd.value = MULTI;
				var param = sheetObj.GetSaveString(false,false);
				var savexml = sheetObj.GetSaveXml("ESD_TES_9030Popup.do", param+'&'+tesFrmQryStr(formObj));
				sheetObj.LoadSaveXml(savexml,true);
                break;
				*/
				//if(chkDupRow(sheetObj)){ 2008-10-15 김보영대리 요청으로 임시로 뺌 협의후 작업 할 예정
				if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value.trim()=='A'){
					if (sheetObj.RowCount > 0 && sheetObj.IsDataModified){
						formObj.f_cmd.value = MULTI;
						var param = sheetObj.GetSaveString(false,false);
				        var savexml = sheetObj.GetSaveXml("ESD_TES_9030Popup.do", param+'&'+tesFrmQryStr(formObj));
				        sheetObj.LoadSaveXml(savexml,true);
					}
 				}
 				// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
 				else if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && (formObj.calc_tp_cd.value.trim()=='M' || formObj.calc_tp_cd.value.trim()=='S')){
					if (sheetObj.RowCount > 0 && sheetObj.IsDataModified){
						formObj.f_cmd.value = MULTI01;
						var param = sheetObj.GetSaveString(false,false);
				        var savexml = sheetObj.GetSaveXml("ESD_TES_9030Popup.do", param+'&'+tesFrmQryStr(formObj));
				        sheetObj.LoadSaveXml(savexml,true);
					}
				}
				//}			
				break;
				
			case IBDELETE:
			    	if (sheetObj.RowCount > 0){
						var Row = sheetObj.SelectRow;
						// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
						if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && (formObj.calc_tp_cd.value.trim()=='M' || formObj.calc_tp_cd.value.trim()=='S')){
							if (sheetObj.CellValue(Row,"tml_so_rvis_list_seq")==null || sheetObj.CellValue(Row,"tml_so_rvis_list_seq").trim()=='' || parseInt(sheetObj.CellValue(Row,"tml_so_rvis_list_seq"),10)==0){
								sheetObj.RowDelete(Row, false);
							} else {
								sheetObj.RowStatus(Row) = 'D';
								sheetObj.RowHidden(Row) = true;
							}
						}
					}
			break;

        }
    }

	/**
	 * Manual Calculated Cost Sheet 관련 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}	sAction		실행할 액션 구분 값
	 * @return
	 */    
    
	 function doActionIBSheetManual(sheetObj,formObj,sAction,RVIS_CNTR_LIST_CD) {
		
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		   case IBSEARCH:      //조회
				// MANUAL MODE인 경우, TES_TML_SO_RVIS_LIST 조회하기 
				// ROWCOUNT == 0 이며, RVIS_CNTR_LIST_CD에 따라 DEFAULT기능 수행하기
				if (!validateForm(sheetObj,formObj,sAction)){
					return false;
				}
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch4Post("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
				break;
        }
    }

	/**
	 * RVIS_CNTR_LIST_CD Sheet 관련 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}	sAction		실행할 액션 구분 값
	 * @return
	 */   
    function doActionIBSheetManualRvisCntrListCode(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		   case IBSEARCH:      //조회
				if (!validateForm(sheetObj,formObj,sAction)){
					return false;
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
			    break;
        }
    }

	/**
	 * 조회된 RVIS_CNTR_LIST_CD에 따라 DEFAULT 목록 Sheet 관련 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}	sAction		실행할 액션 구분 값
	 * @param {string}	RVIS_CNTR_LIST_CD		Cost Code 별 Revise Container List 제공 구분 Code
	 * @return
	 */     
	function doActionIBSheetManualDefaultRetrieve(sheetObj,formObj,sAction, RVIS_CNTR_LIST_CD) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
		    case IBSEARCH:      //조회
				if (RVIS_CNTR_LIST_CD=='N'){
					document.all.div_manual_mode_button.style.display = 'inline';
					formObj.f_cmd.value = SEARCH01;
					//일단 대기
					sheetObj.DoSearch4Post("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
				} else if (RVIS_CNTR_LIST_CD=='MT'){
					document.all.div_manual_mode_button.style.display = 'none';
					formObj.f_cmd.value = SEARCH02;
					sheetObj.DoSearch4Post("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
				} else if (RVIS_CNTR_LIST_CD=='DG'){
					document.all.div_manual_mode_button.style.display = 'none';
					formObj.f_cmd.value = SEARCH03;				
					sheetObj.DoSearch4Post("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
				} else if (RVIS_CNTR_LIST_CD=='RF'){
					if(formObj.param_lgs_cost_cd.value=="SVSCRF"){
						document.all.div_manual_mode_button.style.display = 'none';
						formObj.f_cmd.value = SEARCH04;	
					}else{
						document.all.div_manual_mode_button.style.display = 'inline';
						formObj.f_cmd.value = SEARCH01;
						
					}
					
					sheetObj.DoSearch4Post("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
				} else if (RVIS_CNTR_LIST_CD=='AK'){
					document.all.div_manual_mode_button.style.display = 'none';
					formObj.f_cmd.value = SEARCH05;				
					sheetObj.DoSearch4Post("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
				} 
				break;
        }
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}		sAction		실행할 액션 구분 값
	 * @return
	 */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			//ComShowMessage('1:'+formObj.tml_so_ofc_cty_cd.value + '\n 2:'+ +formObj.tml_so_seq.value + '\n 3:'+ +formObj.calc_tp_cd.value + '\n 4:' +formObj.param_lgs_cost_cd.value + '\n 5:' +formObj.param_cntr_tpsz_cd.value);
			if (formObj.tml_so_ofc_cty_cd.value==undefined || formObj.tml_so_ofc_cty_cd.value==null || formObj.tml_so_ofc_cty_cd.value.trim()=='' ||
		  	    formObj.tml_so_seq.value==undefined || formObj.tml_so_seq.value==null || formObj.tml_so_seq.value.trim()=='' ||
				formObj.calc_tp_cd.value==undefined || formObj.calc_tp_cd.value==null || formObj.calc_tp_cd.value.trim()=='' ||
				formObj.param_lgs_cost_cd.value==undefined || formObj.param_lgs_cost_cd.value==null || formObj.param_lgs_cost_cd.value.trim()=='')
			{
				ComShowMessage('Errors in missing mandatory item(s) to input.');	// [ERR] 필수값 인자에 오류가 발생했습니다.
				return false;
			}
        }
        return true;
    }

	 /**
	  * 조회가 완료되고 발생하는 이벤트
	  * @param {sheet}	sheet			ibsheet
	  * @param {string}	ErrMsg			error message
	  * @return
	  */
	function sheet_OnSearchEnd(sheet, ErrMsg){
		var formObj = document.form;
		if (sheet.RowCount > 0){
			// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
			if (formObj.calc_tp_cd.value.trim()=='M' || formObj.calc_tp_cd.value.trim()=='S'){
			    //sheet에 load된 row들을 검사하여 
				var tml_so_dtl_seq = formObj.tml_so_dtl_seq.value;
				for (var i=1; i<=sheet.RowCount; i++){
				   sheet.CellValue2(i,"tml_so_dtl_seq") = tml_so_dtl_seq;
				   if (formObj.f_cmd.value == SEARCH02 || formObj.f_cmd.value == SEARCH03 || formObj.f_cmd.value == SEARCH04 || formObj.f_cmd.value == SEARCH05){
				       sheet.RowStatus(i)	= 'I';
				   }
				}
				if (formObj.f_cmd.value == SEARCHLIST01){
					// 조회된 data가 없고, MANUAL MODE인 경우, TES_TML_SO_RVIS_LIST 조회하여, ROWCOUNT == 0 이면, RVIS_CNTR_LIST_CD를 조회하고, RVIS_CNTR_LIST_CD에 따라 DEFAULT조회를 수행한당.
					doActionIBSheetManualRvisCntrListCode(sheetObjects[1],document.form,IBSEARCH); //RVIS_CNTR_LIST_CD 가져오기
				}
			}
		} else if (sheet.RowCount == 0){
			var formObj = document.form;
			// CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
			if (formObj.calc_tp_cd.value.trim()=='M' || formObj.calc_tp_cd.value.trim()=='S'){
				if (formObj.f_cmd.value == SEARCHLIST01){
					// 조회된 data가 없고, MANUAL MODE인 경우, TES_TML_SO_RVIS_LIST 조회하여, ROWCOUNT == 0 이면, RVIS_CNTR_LIST_CD를 조회하고, RVIS_CNTR_LIST_CD에 따라 DEFAULT조회를 수행한당.
					doActionIBSheetManualRvisCntrListCode(sheetObjects[1],document.form,IBSEARCH); //RVIS_CNTR_LIST_CD 가져오기
				} else {
					var tml_so_dtl_seq = formObj.tml_so_dtl_seq.value;
				}
			}
		}
	}

	/**
	 * 저장 완료되고 발생하는 이벤트
	 * @param {sheet}	sheet			ibsheet
	 * @param {int}		Row				sheet row index
	 * @param {int}		Col				sheet column index
	 * @param {int}		Value			
	 * @return
	 */
	function sheet_OnSaveEnd(sheet, Row, Col, Value) {
//		if (sheet.RowCount > 0){
//			resetOprRevVol(sheet);
//		}
		resetOprRevVol(sheet);
	}
	 
	/**
	  * 조회가 완료되고 발생하는 이벤트
	  * @param {sheet}	sheetObj		ibsheet
	  * @param {string}	ErrMsg			error message
	  * @return
	  */
	function manual_mode_hidden_OnSearchEnd(sheetObj, ErrMsg) {
		//ComShowMessage('manual_mode_hidden_OnSearchEnd - '+sheetObj.CellValue(1,'rvis_cntr_list_cd'));
		if (sheetObj.RowCount == 1) {
			RVIS_CNTR_LIST_CD = sheetObj.CellValue(1,'rvis_cntr_list_cd');
			doActionIBSheetManualDefaultRetrieve(sheetObjects[0],document.form,IBSEARCH,sheetObj.CellValue(1,'rvis_cntr_list_cd'));
		} else if (sheetObj.RowCount > 1) {
			ComShowMessage(ComGetMsg('TES21032')); //ComShowMessage('[ERR] 복수개의 결과물이 조회되었습니다. 관리자에게 문의하십시오.');
			return false;
		}
	}


//		사용안하는듯...
//		function resetOprCalcVol(sheetObj){
//			var formObj = document.form;
//			var opener_obj = window.dialogArguments;
//			var opener_sheet_obj =  opener_obj.document.t3sheet1;
//			var sheet_curr_row = formObj.sheet_curr_row.value;
//			//ComShowMessage(sheet_curr_row + ' // '+getRevVolCnt(sheetObj));
//			opener_sheet_obj.CellValue(sheet_curr_row,'calc_vol_qty') = sheetObj.RowCount;
//		}
	function sheet_OnChange(sheet, row, col){
		var formObj = document.form;
		var sName = sheet.ColSaveName(col);
		if (sheet.RowCount > 0) {
			if ( sName == 'cntr_no' ) {
				// Bkg No 조회한 데이타 RowId에 넣기 위해 설정.
				document.getElementById("rowId").value	= row;
				document.getElementById("cntr_no").value = sheet.CellValue(row, "cntr_no");
				
				if ( ComIsNull( sheet.CellValue(row, "cntr_no") ) ) {
					return false;				
				}
				// UpperCase
				sheet.CellValue2(row, "cntr_no") = sheet.CellValue(row, "cntr_no").toUpperCase();
				
				// checkDigsit
				sheet.CellValue2(row, "cntr_no") = cntrCheckDigit( sheet.CellValue(row, "cntr_no") );
				
				// Container No. Duplication Check.
//				if ( !checkDupCntrNo(sheet, row) ) {
//					return false;
//				}
				
				if(!chkDupRow(sheet)){
					return false;
				}
				
				// Container No.로 Bkg No. search.
				searchBkgNo(formObj,sheet.CellValue(row, "cntr_no"));
				
			} else if ( sName == 'cntr_tpsz_cd' ) {
				// UpperCase
				sheet.CellValue2(row, "cntr_tpsz_cd") = sheet.CellValue(row, "cntr_tpsz_cd").toUpperCase();
				
			} else if ( sName == 'bkg_no' ) {
				// UpperCase
				sheet.CellValue2(row, "bkg_no") = sheet.CellValue(row, "bkg_no").toUpperCase();
				
			}
		}
	}

	/**
	 * Container No. Duplication Check. <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
//	function checkDupCntrNo(sheetObj, row) {
//
//		for (var i = sheetObjects[0].HeaderRows; i < (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount); i++) {
//		
//			if ( i != row ) {
//				if ((sheetObjects[0].CellValue(i, "cntr_no") == sheetObjects[0].CellValue(row, "cntr_no") ) &&
//					(sheetObjects[0].CellValue(i, "bkg_no") == sheetObjects[0].CellValue(row, "bkg_no") ) && 
//					 sheetObjects[0].CellValue(i, "ibflag") != 'D'
//				) {
//					ComShowCodeMessage("TES70117", sheetObjects[0].CellValue(row, "bkg_no"), sheetObjects[0].CellValue(row, "bkg_no"));		//[Container No. Dup] Container No. : " + guaranteeCommonVO.getCntrNo() + " exists already.
//					return false;
//				}
//			}
//		}
//		return true;
//	}
	
	 /**
	 * Container No. BKG No. List 조회. <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
	function searchBkgNo(formObj, cntr_no) {
		formObj.search_bkg_no.value = '';
		tes_getInputValue('search_bkg_no', SEARCHLIST11, 'yd_cd|fm_prd_dt|to_prd_dt|cntr_no', 'checkValidBkgCode');
	}
	 
	 /**
		 *  BkgCode Validation 함수
		 */
	function checkValidBkgCode(){
		var formObj = document.form;
		var tmp = '';
		var cntr_no = formObj.cntr_no.value;
		var param_cntr_tpsz_cd = formObj.param_cntr_tpsz_cd.value;
		var row = formObj.rowId.value;
//		var test = 'Y|D2|SGN109974700';
		if (formObj.search_bkg_no.value!='undefined' && formObj.search_bkg_no.value!=null && formObj.search_bkg_no.value.trim()!=''){
			tmp = formObj.search_bkg_no.value.split('|');
//			tmp = test.split('|');
			if (tmp.length > 0){
				formObj.search_bkg_no.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				sheetObjects[0].CellValue(document.getElementById("rowId").value, "cntr_tpsz_cd") = tmp[1];
				sheetObjects[0].CellValue(document.getElementById("rowId").value, "eff_cntr_yn") = 'N';
				if (formObj.search_bkg_no.value!=null && formObj.search_bkg_no.value == 'N'){
					sheetObjects[0].CellFontColor(document.getElementById("rowId").value, "cntr_no") = sheetObjects[0].RgbColor(255, 0, 0);
					ComShowMessage(ComGetMsg('TES21606', row, cntr_no)); //ComShowMessage('cntr_no는 등록이 안 된 EQ입니다.');
				} else {
					if (tmp[1]!=param_cntr_tpsz_cd){
						ComShowMessage(ComGetMsg('TES21607', row, cntr_no)); //ComShowMessage('cntr_no의 T/S코드가 다릅니다.');
					} else {
						sheetObjects[0].CellValue(document.getElementById("rowId").value, "eff_cntr_yn") = 'Y';
						if (tmp[2]!=null && tmp[2]!=''){
							sheetObjects[0].CellValue(document.getElementById("rowId").value, "bkg_no") = tmp[2];
						}
					}
				}
			} 
		} else {
			ComShowMessage(ComGetMsg('TES21606', row, cntr_no)); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
		}
		
	}

	/**
	 * 부모창의 Revised Volumn 수 세팅
	 * @param {sheet}	sheetObj	ibsheet	
	 * @return
	 */
	function resetOprRevVol(sheetObj){
		var formObj = document.form;
		var opener_obj = window.dialogArguments;
		var opener_sheet_obj =  opener_obj.document.t3sheet1;
		var sheet_curr_row = formObj.sheet_curr_row.value;
		var rev_vol_nt = getRevVolCnt(sheetObj);
		//ComShowMessage(sheet_curr_row + ' // '+getRevVolCnt(sheetObj));
		opener_sheet_obj.CellValue(sheet_curr_row,'rvis_vol_qty') = rev_vol_nt;
		if(rev_vol_nt>0){
    		window.dialogArguments.setShtCellsEditable(window.dialogArguments.document.t3sheet1,sheet_curr_row,'cntr_tpsz_cd','N');
    	} else {
    		window.dialogArguments.setShtCellsEditable(window.dialogArguments.document.t3sheet1,sheet_curr_row,'cntr_tpsz_cd','Y');
    	}
	}

	/**
	 * Del 이 체크되지 않은 리스트 수 구하기
	 * @param {sheet}	sheetObj	ibsheet	
	 * @return
	 */
	function getRevVolCnt(sheetObj){
		var rev_Y_vol_cnt = 0; //revised 'Y'로 된 cnt
		var rev_vol_cnt = sheetObj.RowCount; //최종 rev_vol_cnt
		if (sheetObj.RowCount > 0){
			for (i=1; i<sheetObj.Rows; i++){ //제목은 제외
				if (sheetObj.CellValue(i,'tml_rvis_ind_flg') == 1){
					rev_Y_vol_cnt++;
				}
			}
		}
		return (rev_vol_cnt - rev_Y_vol_cnt);
	}

	/**
	 * 셀의 Edit 가능 여부를 세팅
	 * @param {sheet}	sheetObj	ibsheet
	 * @param {int}		rownum		row number
	 * @param {int}		colnms		세팅을 원하는 column name, 복수개 사용 가능(column1|column2...)
	 * @param {string}	to_sts		수정가능 혹은 불가능 여부를 세팅 
	 * @return
	 */
	function setShtCellsEditable(sheetObj, rownum, colnms, to_sts) {
		// 수동입력 rowadd를 할때마다 실행..
		if (rownum==null || rownum==undefined || colnms==null || colnms==undefined || to_sts==null || to_sts==undefined){
			return false;
		}
		var arr_colnms = colnms.split('|');
		for (var i=0; i<arr_colnms.length; i++){
			sheetObj.CellEditable(rownum,arr_colnms[i]) = (to_sts!=null&&to_sts=='Y'?true:false);
		}
	}

	/**
	 * 중복된 값이 존재 여부 체크
	 * @param {sheet}	sheet	ibsheet
	 * @return
	 */
	function chkDupRow(sheet){
	    var Row = sheet.ColValueDup("cntr_no",false);
	    if(Row > 0){
	        ComShowMessage(ComGetMsg('TES23050','CNTR NO'));
	        return false;
	    }else{
	        return true;
	        
	    }
	}
