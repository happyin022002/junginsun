/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0033.js
*@FileTitle : Agent Commission Mass Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.23 김봉균
* 1.0 Creation
*
* 2014.06.03 박다은 [CHM-201430120] Agent Comm. Mass simulation 에 기능 추가
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
     * @class ESM_ACM_0033 : ESM_ACM_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0033() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
        this.frmObj_OnChange    = frmObj_OnChange;
    }

/* 개발자 작업 */


    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1 = sheetObjects[0];
        var memoShtObj2 = sheetObjects[1];
        var memoShtObj3 = sheetObjects[2];
        var memoShtObj4 = sheetObjects[3];
        var memoShtObj5 = sheetObjects[4];
        var shtObj		= sheetObjects[5];        
        var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            if (srcName != "btn2_vvd_cd") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.vvd_cd);    // CoAcm.js에 정의
            }
            if (srcName != "btn2_agmt_no1") {
                ACMMemoSheet_Close(memoShtObj2, frmObj.agmt_no1);    // CoAcm.js에 정의
            }
            if (srcName != "btn2_agmt_no2") {
                ACMMemoSheet_Close(memoShtObj3, frmObj.agmt_no2);    // CoAcm.js에 정의
            }
            if (srcName != "btn2_ofc_cd") {
                ACMMemoSheet_Close(memoShtObj4, frmObj.ofc_cd);    // CoAcm.js에 정의
            }
            if (srcName != "btn2_loc_cd") {
                ACMMemoSheet_Close(memoShtObj5, frmObj.loc_cd);    // CoAcm.js에 정의
            }

            switch (srcName) {
                case "btn_calendar":    // 캘린더 호출
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;

                case "btn2_vvd_cd":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;

                case "comm_stnd_cost_div":
                    ACMCheckBox_OnClick(frmObj.comm_stnd_cost_div, frmObj.ac_tp_cd);    // CoAcm.js에 정의
                    frmObj_OnChange();
                    break;

                case "agmt_div":
                    frmObj_OnChange();
                    break;

                case "btn2_agmt_no1":
                    ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
                    break;

                case "btn2_agmt_no2":
                    ACMMemoSheet_Open(memoShtObj3);    // CoAcm.js에 정의
                    break;

                case "ac_sts_div":
                	// Commission Status All 클릭시 전체 체크 및 해제
                    if (window.event.srcElement == frmObj.ac_sts_div[0]) {
                        var chkFlg = frmObj.ac_sts_div[0].checked;
                    	for(var i=1; i<frmObj.ac_sts_div.length; i++) {
                			frmObj.ac_sts_div[i].checked = chkFlg;
                    	}
                    } else {
                    	var chkCnt = 0;
                    	for(var i=1; i<frmObj.ac_sts_div.length; i++) {
                    		if(frmObj.ac_sts_div[i].checked) {
                    			chkCnt ++;
                    		}
                    	}
                    	if(chkCnt == 8) {
                    		frmObj.ac_sts_div[0].checked = true;
                    	} else {
                    		frmObj.ac_sts_div[0].checked = false;
                    	}
                    }
                    ACMCheckBox_OnClick(frmObj.ac_sts_div, frmObj.ac_sts_cd, 1);    // CoAcm.js에 정의
                    if (frmObj.ac_sts_div[7].checked) {
                        frmObj.ac_sts_cd2.value = "IS";
                    } else {
                        frmObj.ac_sts_cd2.value = "";
                    }
                    frmObj_OnChange();
                    break;

                case "btn2_ofc_cd":
                    ACMMemoSheet_Open(memoShtObj4);    // CoAcm.js에 정의
                    break;

                case "route_div":
                    frmObj_OnChange();
                    break;

                case "btn2_loc_cd":
                    ACMMemoSheet_Open(memoShtObj5);    // CoAcm.js에 정의
                    break;

                case "btn_search":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn2_bkg_expt":
                	ComOpenWait(true);
    			    frmObj.f_cmd.value = COMMAND01;
    			    frmObj.target = "_blank";
    			    frmObj.action = "ESM_ACM_0033DL.do?" + FormQueryString(frmObj);
    			    frmObj.submit();
    			    ComOpenWait(false);
                    break;

                case "btn_chk_sts":
                    ComOpenWindowCenter("ESM_ACM_0032.do", "Batch Management", 1010, 580, false);
                    break;

                case "btn_start_clc":
                	document.form.clc_rmk.setAttribute('required','');
                	doActionIBSheet(shtObj, frmObj, IBSAVE);
                	document.form.clc_rmk.removeAttribute('required');
                    break;

                case "btn_sml_popup":
                	ComOpenPopup("ESM_ACM_0110.do", 495, 390, "setPopupData", "1,0,1,1,1,1,1", true, false, 0, 0, 6);
                	break;

                case "btn2_downexcel": 
                	ComOpenWait(true);
    			    frmObj.f_cmd.value = COMMAND02;
    			    frmObj.target = "_blank";
    			    frmObj.action = "ESM_ACM_0033DL.do?" + FormQueryString(frmObj);
    			    frmObj.submit();
    			    ComOpenWait(false);
                	break;
                	
                case "btn1_add_bat":    // Add Batch
                    doActionIBSheet(shtObj, frmObj, MULTI01);
                    break;        
                    
                case "btn2_add_bat":    // Add Batch
                    doActionIBSheet(shtObj, frmObj, MULTI02);
                    break;    

                case "btn1_calendar":    // 캘린더 호출
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.sa_arr_dt_fm, frmObj.sa_arr_dt_to, "yyyy-MM-dd");
                    }
                    break;  
                    
                case "btn2_calendar":    // 캘린더 호출
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.bkg_date_fm, frmObj.bkg_date_to, "yyyy-MM-dd");
                    }
                    break;     
                    
            } // end switch

//        } catch(e) {
//            if (e == "[object Error]") {
//                ComShowMessage(OBJECT_ERROR);
//            } else {
//                ComShowMessage(e);
//            }
//        }
    }


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++] = shtObj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(var i=0; i<sheetObjects.length; i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        initControl();

        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var cnt = 0;

        with (shtObj) {
            switch (shtObj.id) {

                case "memo_sheet1":
                case "memo_sheet2":
                case "memo_sheet3":
                case "memo_sheet4":
                case "memo_sheet5":
                    ACMMemoSheet_InitSheet(shtObj);    // CoAcm.js에 정의
                    break;
                    
                case "sheet1":
                    // 높이 설정
                    style.height = 200;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

    				// Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "")
    					InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				// 전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

    				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 3, 100);

    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(2, 0, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false, false)

    				var HeadTitle = "|BKG No.";

    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,	80,     daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,	        80,     daCenter,    true,    "bkg_no");

                    CountPosition = 0;

                    break;                    
            }
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
//        axon_event.addListenerForm("click", "frmObj_OnClick", document.form);

        ComBtnDisable("btn2_bkg_expt");
        ComBtnDisable("btn_chk_sts");
        ComBtnDisable("btn_start_clc");

    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:    //조회
//                if (!ComChkValid(frmObj)) return;
                if (frmObj.date_fm.value == "" || frmObj.date_to.value == "" ) {
                	ComShowCodeMessage("COM12114", " 'Date'");
                	frmObj.date_fm.focus();
                    return;
                    } 	
            		
                if (frmObj.ofc_div.value == "F") {
					if (frmObj.port_div.value == "") {
						ComShowCodeMessage("ACM00002", "Office");
						return;
					}
				}

                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;

                shtObj.DoSearch("ESM_ACM_0033GS.do", FormQueryString(frmObj));
                
                ComBtnEnable("btn2_bkg_expt");
                ComBtnEnable("btn_chk_sts");
                ComBtnEnable("btn_start_clc");
                ComOpenWait(false);
                break;

            case IBSAVE:      //저장
            	// Commission Status 의 체크된 값이 없을 경우
                if(frmObj.ac_sts_cd.value == "") {
                	ComShowCodeMessage("COM12113", "Commission Status");
                	return;
                }
                if (!ComChkValid(frmObj)) return;
                
                var rArray = getArrayToSave(shtObj, "chk");
                if (rArray != null) {
                    
                    frmObj.bkg_no.value = getToClobString(rArray, 200);

                    ComOpenWait(true);
                    frmObj.f_cmd.value = MULTI;
                    shtObj.LoadSaveXml(shtObj.GetSaveXml("ESM_ACM_0033GS.do", FormQueryString(frmObj)));
                    ComOpenWait(false);
                }
                
                break;
                
            case MULTI01:  // Add Batch
                if(frmObj.sa_arr_dt_fm.value == "" || frmObj.sa_arr_dt_to.value == "" ) {
                 	ComShowCodeMessage("COM12114", " 'Sail arrival Date'");
                 	return;
                 }                
                if(frmObj.agn_agmt_no.value == "" || frmObj.agn_agmt_no.value.length != 9) {
                 	ComShowCodeMessage("COM12114", " 'Actual agreement No'");
                 	return;
                 }
                
                ComOpenWait(true);
                
                // Simulation No. 조회
                frmObj.f_cmd.value = SEARCH03;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0010GS.do", FormQueryString(frmObj));
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                ComSetObjValue(frmObj.act_agmt_sml_no, ComGetEtcData(xmlStr, "sim_no"));
                // Batch 테이블에 저장
                frmObj.f_cmd.value = MULTI01;
                shtObj.LoadSaveXml(shtObj.GetSaveXml("ESM_ACM_0033GS.do", FormQueryString(frmObj)));
                ComOpenWait(false);
                break;
                
            case MULTI02:  // Add Batch
                if(frmObj.bkg_date_fm.value == "" || frmObj.bkg_date_to.value == "" ) {
                 	ComShowCodeMessage("COM12114", " 'BKG Creation Date'");
                 	return;
                 }                
                if(frmObj.sim_agmt_no.value == "" || frmObj.sim_agmt_no.value.length != 9) {
                 	ComShowCodeMessage("COM12114", " 'Simulation Agreement No'");
                 	return;
                 }
            	ComOpenWait(true);
            	
                // Simulation No. 조회
                frmObj.f_cmd.value = SEARCH03;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0010GS.do", FormQueryString(frmObj));
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                ComSetObjValue(frmObj.sim_agmt_sml_no, ComGetEtcData(xmlStr, "sim_no"));
                // Batch 테이블에 저장
            	frmObj.f_cmd.value = MULTI02;
            	shtObj.LoadSaveXml(shtObj.GetSaveXml("ESM_ACM_0033GS.do", FormQueryString(frmObj)));
            	ComOpenWait(false);
            	break;    
        }
    }


    /**
     * Form Element의 OnChange 이벤트
     * (ESM_ACM_0033일때 coAcm.js의 ACMMemoSheet_Close이벤트에서 호출됨)
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        with (document.form) {
            switch (elementName) {
	            case "clc_rmk":
	            	return; //Calculation Remark 인 경우 하위 로직 타지 않음(버튼 비활성화 하지 않음)
	            	break;
				//BKG Office, Agent 선택시 Route 부분이 비활성화
	            case "ofc_div":
					if (document.form.ofc_div.value == "B" || document.form.ofc_div.value == "A") {
						document.form.port_div.value = "";
						document.form.port_div.disabled = true;
					} else {
						document.form.port_div.disabled = false;
					}
	                break;
            }
        }

        document.form.ttl_bkg.value = "";
        document.form.clc_rmk.value = "";
        ComBtnDisable("btn2_bkg_expt");
        ComBtnDisable("btn_chk_sts");
        ComBtnDisable("btn_start_clc");
    }

    
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        document.form.ttl_bkg.value = shtObj.TotalRows;
    }
    

    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
    }


    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData[0] : {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
     * @param ShtIdx : 대상IBSheet의 Sheet Array index
     */
    function setPopupData(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData[0].length > 0 ) {
        	
        }
    }

    
    /**
     * Save 대상 정보를 Array에 담는다.
     * @param {Object} sheetObj
     * @param {Object} colName
     */
    function getArrayToSave(shtObj, colName) {
        var rows = shtObj.Rows;
        var rArray = null; //행데이터를 담고 있는 배열
        var saveRows = document.form.ttl_bkg.value;

        if (saveRows != 0) {
            var idx = 0;
            rArray = new Array(saveRows);
            for(var i=shtObj.HeaderRows; i<rows; i++) {
            	rArray[idx++] = shtObj.CellText(i,"bkg_no");
            }
        }
        return rArray;
    }    
    
/* 개발자 작업 끝 */
