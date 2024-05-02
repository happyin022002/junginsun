/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_ACM_0033.js
*@FileTitle  : Agent Commission Mass Simulation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/

    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1=sheetObjects[0];
        var memoShtObj2=sheetObjects[1];
        var memoShtObj3=sheetObjects[2];
        var memoShtObj4=sheetObjects[3];
        var memoShtObj5=sheetObjects[4];
        var frmObj=document.form;
//        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
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
                    if (!ComGetBtnDisable(srcName)) {
                        var cal=new ComCalendarFromTo();
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
                        var chkFlg=frmObj.ac_sts_div[0].checked;
                    	for(var i=1; i<frmObj.ac_sts_div.length; i++) {
                			frmObj.ac_sts_div[i].checked=chkFlg;
                    	}
                    } else {
                    	var chkCnt=0;
                    	for(var i=1; i<frmObj.ac_sts_div.length; i++) {
                    		if(frmObj.ac_sts_div[i].checked) {
                    			chkCnt ++;
                    		}
                    	}
                    	if(chkCnt == 8) {
                    		frmObj.ac_sts_div[0].checked=true;
                    	} else {
                    		frmObj.ac_sts_div[0].checked=false;
                    	}
                    }
                    ACMCheckBox_OnClick(frmObj.ac_sts_div, frmObj.ac_sts_cd, 1);    // CoAcm.js에 정의
                    if (frmObj.ac_sts_div[7].checked) {
                        frmObj.ac_sts_cd2.value="IS";
                    } else {
                        frmObj.ac_sts_cd2.value="";
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
                    doActionIBSheet(sheetObjects[0], frmObj, IBSEARCH);
                    break;
                case "btn2_bkg_expt":
                	ComOpenWait(true);
                	frmObj.excel_flg.value = "";
    			    frmObj.f_cmd.value=COMMAND01;
    			    frmObj.target="_blank";
    			    frmObj.action="ESM_ACM_0033DL.do?" + FormQueryString(frmObj);
    			    frmObj.submit();
    			    ComOpenWait(false);
                    break;
                case "btn_chk_sts":
                    ComOpenWindowCenter("ESM_ACM_0032_POP.do?pop_mode=Y", "Batch Management", 1010, 580, false,"yes");
                    break;
                case "btn_start_clc":
                	document.form.clc_rmk.setAttribute('required','');
                	doActionIBSheet(sheetObjects[0], frmObj, IBSAVE);
                	document.form.clc_rmk.removeAttribute('required');
                    break;
                case "btn_sml_popup":
//                	ComOpenPopup("ESM_ACM_0110.do", 495, 430, "setPopupData", "1,0,1,1,1,1,1", true, false, 0, 0, 6);
                	//ComOpenPopup("ESM_ACM_0110.do"+ FormQueryString(frmObj), 495, 430, "setPopupData", "1,0", true, false, 0, 0, 6);
                	ComOpenPopup("ESM_ACM_0110.do?"+ FormQueryString(frmObj), 495, 430, "setPopupData", "1,0", true, false, 0, 0, 6);
                	break;
                case "btn2_downexcel": 
                	ComOpenWait(true);
                	frmObj.excel_flg.value = "Y";
    			    frmObj.f_cmd.value=COMMAND02;
    			    frmObj.target="_blank";
    			    frmObj.action="ESM_ACM_0033DL.do?" + FormQueryString(frmObj);
    			    frmObj.submit();
    			    ComOpenWait(false);
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
       sheetObjects[sheetCnt++]=shtObj;
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
            //ComEndConfigSheet(sheetObjects[i]);
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
        var cnt=0;
        with (shtObj) {
            switch (shtObj.id) {
                case "memo_sheet1":
                case "memo_sheet2":
                case "memo_sheet3":
                case "memo_sheet4":
                case "memo_sheet5":
                    ACMMemoSheet_InitSheet(shtObj, "130");    // CoAcm.js에 정의
                    break;
            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
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
                if (!ComChkValid(frmObj)) return;
                if (frmObj.ofc_div.value == "F") {
					if (frmObj.port_div.value == "") {
						ComShowCodeMessage("ACM00002", "Office");
						return;
					}
				}
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0033GS.do", FormQueryString(frmObj));
                if (!ACMDecideErrXml(shtObj, xmlStr)) {
                    frmObj.ttl_bkg.value=ComGetEtcData(xmlStr, "ttl_bkg");
                }
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
                
             // Simulation No. 조회
                frmObj.f_cmd.value=SEARCH01;
                //parameter changed[check again]CLT                 
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0033GS.do", FormQueryString(frmObj));
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                ComSetObjValue(frmObj.sml_no1, ComGetEtcData(xmlStr, "sim_no"));
                
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI;
                shtObj.GetSaveData("ESM_ACM_0033GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
        }
    }
    /**
     * Form Element의 OnChange 이벤트
     * (ESM_ACM_0033일때 coAcm.js의 ACMMemoSheet_Close이벤트에서 호출됨)
     */
    function frmObj_OnChange() {
        var elementName=ComGetEvent("name");
        with (document.form) {
            switch (elementName) {
	            case "clc_rmk":
	            	return; //Calculation Remark 인 경우 하위 로직 타지 않음(버튼 비활성화 하지 않음)
	            	break;
				//BKG Office, Agent 선택시 Route 부분이 비활성화
	            case "ofc_div":
					if (document.form.ofc_div.value == "B" || document.form.ofc_div.value == "A") {
						document.form.port_div.value="";
						document.form.port_div.disabled=true;
					} else {
						document.form.port_div.disabled=false;
					}
	                break;
            }
        }
        document.form.ttl_bkg.value="";
        document.form.clc_rmk.value="";
        document.form.sml_no1.value = "";
        ComBtnDisable("btn2_bkg_expt");
        ComBtnDisable("btn_chk_sts");
        ComBtnDisable("btn_start_clc");
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function memo_sheet1_OnSaveEnd(shtObj, ErrMsg) {
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
        	 with (sheetObjects[ShtIdx]) {
                 if (ColSaveName(Col) == "btn_sml_popup") 
                     SetCellValue(Row, Col,aryPopupData[0][33],0);
             }
        }
    }
/* 개발자 작업 끝 */
