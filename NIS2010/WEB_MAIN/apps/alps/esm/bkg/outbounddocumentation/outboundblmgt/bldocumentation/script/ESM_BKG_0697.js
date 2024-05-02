/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0697.js
*@FileTitle : Multi-Seal no input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.18 김영출
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
     * @class esm_bkg_0697 : esm_bkg_0697 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0697() {
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
	var opener = (!opener) ? window.dialogArguments : opener;
	var seal_knd_str = opener.seal_knd_str;
	var seal_pty_tp_str = opener.seal_pty_tp_str;
	var saveChkFlg = "N";
	
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

				case "btn_add":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
				
				case "btn_delete":
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
				//break;														
								
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
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
        }
		
		if(opener.document.form.cn_flg.value == 'Y'){
			sheetObjects[0].ColHidden("seal_knd_cd") = false;
			sheetObjects[0].ColHidden("seal_pty_tp_cd") = false;
		}else{
			sheetObjects[0].ColHidden("seal_knd_cd") = true;
			sheetObjects[0].ColHidden("seal_pty_tp_cd") = true;
		}
		
		// do init action
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 250;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle = "|Sel.|bkg no|cntr no|Seal Seq.|Seal No|Kind/Code|Kind/Code|pty_nm|Print|old_cntr_no";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH, DATAALIGN, COLMERGE,  SAVENAME,         KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,     "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,     40,     daCenter,  false,    "sel");
                    InitDataProperty(0, cnt++ , dtHidden,       40,    daCenter,  false,    "bkg_no",         false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,    daCenter,  false,    "cntr_no",        false,    "",         dfNone,     2,          true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,    daCenter,  false,    "cntr_seal_seq",  false,    "",         dfNone,     2,          true,        true);
                    InitDataProperty(0, cnt++ , dtData,         110,   daCenter,  false,    "cntr_seal_no",   false,    "",         dfNone,     2,          true,        true, 15);
                    InitDataProperty(0, cnt++,  dtCombo,        40,    daCenter,  false,    "seal_knd_cd",    false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++,  dtCombo,        40,    daCenter,  false,    "seal_pty_tp_cd", false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,    daLeft,    false,    "seal_pty_nm",    false,    "",         dfNone,     2,          true,        true);
                    InitDataProperty(0, cnt++ , dtCheckBox,     40,    daCenter,  false,    "prn_flg",        false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,       40,    daCenter,  false,    "old_cntr_no",    false,    "",         dfNone,     0,          true,        true);

					InitDataCombo(0, "seal_knd_cd", "| |M\tMechanical|E\tElectronic", seal_knd_str);
                    InitDataCombo(0, "seal_pty_tp_cd",  "| |SH\tShipper|CA\tCarrier|AA\tConsolidator|CU\tCustoms|AB\tUnknown|AC\tAgency|TO\tTerminal Operator", seal_pty_tp_str);
                    InitDataValid(0,  "cntr_seal_no",   	vtEngOther, "1234567890~!@#$%^&*()--_+={}[]|\:;<.>/?");
                    
               }
               break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        var eur = '';
        var saveSealFlg = '';
        if(opener.document.form.eur_flg != undefined)
        	eur = opener.document.form.eur_flg.value;
        
        if(opener.document.form.save_seal_flg != undefined)
        	saveSealFlg = opener.document.form.save_seal_flg.value;
        
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					//sheetObj.DoSearch("ESM_BKG_0697GS.do", FormQueryString(formObj));
					if(eur == undefined || eur == ''){
						opener.ComFilteredSheetToSheet(opener.sheetObjects[2], sheetObj, 'cntr_no', formObj.cntr_no.value);
					}else if(eur == 'Y'){
						opener.ComFilteredSheetToSheet(opener.sheetObjects[5], sheetObj, 'cntr_no', formObj.cntr_no.value);
					}
				}
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					var cntrNo = formObj.cntr_no.value;
					opener.ComRowDelete(sheetObj, "cntr_seal_no", '');
					if(eur == ''){
						opener.ComRowDelete(opener.sheetObjects[2], 'cntr_no', cntrNo);
						opener.ComFilteredSheetToSheet(sheetObj, opener.sheetObjects[2], 'cntr_no', cntrNo);
					}else if(eur == 'Y'){
						opener.ComRowDelete(opener.sheetObjects[5], 'cntr_no', cntrNo);
						opener.ComFilteredSheetToSheet(sheetObj, opener.sheetObjects[5], 'cntr_no', cntrNo);
					}
					opener.setSealNo(cntrNo);
								
					if(saveSealFlg == 'Y'){
					   opener.saveSeal(saveChkFlg,cntrNo);
					}
				}
			break;

			case IBINSERT:      // 입력
				//alert (" Insert .. ");
				var newRow = sheetObj.DataInsert(-1);
				//alert("* newRow : " + newRow);
				sheetObj.CellValue(newRow, "bkg_no") = formObj.bkg_no.value;
				sheetObj.CellValue(newRow, "cntr_no") = formObj.cntr_no.value;
				sheetObj.CellValue(newRow, "seal_knd_cd") = 'M';
				sheetObj.CellValue(newRow, "old_cntr_no") = formObj.old_cntr_no.value;
				sheetObj.CellValue(newRow, "prn_flg") = 'Y';
				//sheetObj.CellValue(newRow, "cntr_seal_seq") = ComGetMaxSeq(sheetObj, "cntr_seal_seq");
			break;
			
			case IBDELETE:      // 삭제
				//alert (" Delete .. ");
				//opener.ComRowDelete(sheetObj, 'sel', 1);
				var arrRow = opener.ComFindText(sheetObj, 'sel', 1);
				for (ir = 0; ir < arrRow.length; ir++) {
					if(arrRow[arrRow.length-1-ir]=='') continue;
					sheetObj.RowDelete(arrRow[arrRow.length-1-ir], false);
				}
				saveChkFlg = "Y"; //ESM_BKG_0697 에서 seal no 지우고 저장할때 Ibflag 박아줌
			break;

        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
        switch(sAction) {
			case IBSAVE:        //저장
				with(formObj){
		//            if (!isNumber(formObj.iPage)) {
		//                return false;
		//            }
				}
			break;
		}

        return true;
    }
        
        
        /**
         * Seal No 추가 입력 or 수정 or 삭제 시에 저장될 수 있도록 flag 로 구분시켜 줌 
         */
        function sheet1_OnAfterEdit(sheetObj, Row, Col, Value) {
        	saveChkFlg = "Y";
        }

	/* 개발자 작업  끝 */