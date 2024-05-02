/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ees_ctm_0463.js
*@FileTitle : Modified event date history Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.01
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.11.01 김종옥
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
     * @class ees_ctm_0463 : ees_ctm_0463 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0463() {
        this.processButtonClick    = processButtonClick;
        this.setSheetObject        = setSheetObject;
        this.loadPage              = loadPage;
        this.initSheet             = initSheet;
        this.doActionIBSheet       = doActionIBSheet;
        this.validateForm          = validateForm;
    }

/* 개발자 작업    */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var errorXml = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {

         var sheetObj = sheetObjects[0];
         var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				
   				case "pe_co_tp":
  					if(formObj.pe_co_tp[0].checked){
						//Period
  						formObj.pe_co.value = "P";
						
						formObj.p_date1.className = "input1";
						formObj.p_date2.className = "input1";
						formObj.p_date1.readOnly = false;
						formObj.p_date2.readOnly = false;

						ComEnableObject(document.all.btn_Calendar, true);

						//Location
						formObj.location_gb.Enable = true;
						formObj.yd_cd_disp.className = "input1";
						formObj.yd_cd_disp.readOnly = false;
						formObj.p_yard2.Enable = false;
		
						//Status
						formObj.status_cd.Enable = true;

						//S.O.C
						formObj.soc_cd.Enable = true;
						
						//Container No.
						ComSetObjValue(formObj.p_cntrno, "");
						ComSetObjValue(formObj.check_digit, "");
						ComSetObjValue(formObj.ctnr_tpsz_cd, "");
						
		           		formObj.p_cntrno.className = "input2";
		           		formObj.check_digit.className = "input2";
		           		formObj.ctnr_tpsz_cd.className = "input2";
						
		           		formObj.p_cntrno.readOnly = true;
		           		formObj.check_digit.readOnly = true;
		           		formObj.ctnr_tpsz_cd.readOnly = true;

   					}else if(formObj.pe_co_tp[1].checked){
						//Period
   						formObj.pe_co.value = "C";
						formObj.p_date1.className = "input2";
						formObj.p_date2.className = "input2";
						formObj.p_date1.readOnly = true;
						formObj.p_date2.readOnly = true;
						
						ComSetObjValue(formObj.p_date1, ComGetObjValue(formObj.as_p_date1));
						ComSetObjValue(formObj.p_date2, ComGetObjValue(formObj.as_p_date2));
						
						ComEnableObject(document.all.btn_Calendar, false);

						//Location
						comboObjects[0].Code = "L";
						ComSetObjValue(formObj.yd_cd_disp, "");
						comboObjects[1].RemoveAll();
						
						formObj.location_gb.Enable = false;
						formObj.yd_cd_disp.className = "input2";
						formObj.yd_cd_disp.readOnly = true;
						formObj.p_yard2.Enable = false;

						//Status
						formObj.status_cd.Enable = false;
						initCombo(comboObjects[2], 0);

						//S.O.C
						formObj.soc_cd.Enable = false;
						comboObjects[3].Code = "IN";
						
						//Container No.
						ComSetObjValue(formObj.p_cntrno, "");
						ComSetObjValue(formObj.check_digit, "");
						ComSetObjValue(formObj.ctnr_tpsz_cd, "");
						
		           		formObj.p_cntrno.className = "input1";
		           		formObj.check_digit.className = "input";
		           		formObj.ctnr_tpsz_cd.className = "input";
						
		           		formObj.p_cntrno.readOnly = false;
		           		formObj.check_digit.readOnly = false;
		           		formObj.ctnr_tpsz_cd.readOnly = false;
   					}
  					break;
									
                case "btn_Calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(formObj.p_date1, formObj.p_date2, 'yyyy-MM-dd');
                    }
                    break;

	   			case "btn_Retrieve":
                    if (!checkFormField()) return;
	   				doActionIBSheet(sheetObj, formObj, IBSEARCH);
	   				break;

	   			case "btn_New":
	   				doActionIBSheet(sheetObj, formObj, IBCLEAR);
	   				break;

                case "btn_Excel":
                    sheetObj.WaitImageVisible = false;
                    sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "Sel");
                    sheetObj.WaitImageVisible = true;
                    break;

            } // end switch

        } catch(e) {
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
    function setSheetObject (sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }


    /**
     * IBMultiCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
       comboObjects[comboCnt++] = combo_obj;
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
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    } 

        // CTM-COMMON ("yd_cd_disp"예외처리)
        setEventProcess("yd_cd_disp");

        // OnKeyPress 이벤트 (공통function)
        axon_event.addListener("keypress", "obj_keypress", "yd_cd_disp");
        // OnKeyUp 이벤트 (자체function)
        axon_event.addListener("keyup", "obj_onkeyup", "yd_cd_disp");
		
		axon_event.addListenerFormat('focus', 'obj_activate', form);
		axon_event.addListenerForm ('blur', 'obj_blur', form);
		
		var formObj = document.form;
		formObj.p_yard2.Enable = false;
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
   	    switch(comboObj.id) {
   	    	case "location_gb":
	   			with (comboObj) {
	   				MultiSelect = false;
	   				UseAutoComplete = false;
	   				SetColAlign("left");
	   				SetColWidth("30");
	   				DropHeight = 160;
	   				ValidChar(2, 0);// 영문대문자만 입력가능
	   				MaxLength = 4;
	   				InsertItem(i++, "LCC", "L");
	   				InsertItem(i++, "ECC", "E");
	   				InsertItem(i++, "SCC", "S");
					InsertItem(i++, "RCC", "R");
	   				InsertItem(i++, "Yard", "Y");
					comboObj.Code2 = "L";
	   			}
   			break;
   	    
			case "status_cd":
				with(comboObj) {
					MultiSelect = true; 
					UseAutoComplete = true;	
					SetColAlign("left");
					SetColWidth("70");  
					comboObj.DropHeight = 200;
					InsertItem(i++, "ALL", "");
                    InsertItem(i++, "OP", "OP");
                    InsertItem(i++, "EN", "EN");
                    InsertItem(i++, "TN", "TN");
                    InsertItem(i++, "OC", "OC");
                    InsertItem(i++, "VL", "VL");
                    InsertItem(i++, "VD", "VD");
                    InsertItem(i++, "IC", "IC");
                    InsertItem(i++, "ID", "ID");
                    InsertItem(i++, "TS", "TS");
                    InsertItem(i++, "MT", "MT");
                    InsertItem(i++, "ER", "ER");
                    InsertItem(i++, "CP", "CP");
                    InsertItem(i++, "CT", "CT");
                    InsertItem(i++, "CE", "CE");
                    InsertItem(i++, "CO", "CO");
                    InsertItem(i++, "CI", "CI");
                    InsertItem(i++, "CD", "CD");
                    InsertItem(i++, "CM", "CM");
                    InsertItem(i++, "ZZ", "ZZ");					
					comboObj.Text = "ALL";
	        	}
				break;
			case "soc_cd":
				with(comboObj) {
					comboObj.DropHeight=100;
					InsertItem(i++,  "Exclude", "SH");
					InsertItem(i++,  "Include", "IN");
					comboObj.Code = "IN";
	        	}
				break;				
		}
	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet (sheetObj, sheetNo) {
        var cnt = 0;

        with (sheetObj) {

            // 높이 설정
            style.height = 442;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 3, 100);

            // 헤더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false);

             // Ctrl키를 눌러 다중행 선택가능
            MultiSelection = true;
            SelectionMode = smSelectionList;

            var HeadTitle = "|Seq.|Container No.|TP/SZ|Bkg No.|VVD|STS|Origin Yard|Event Date\n(From)|Event Date\n(To)|Gap(day)|Creation Date\n(Local)|Update Date\n(local)|MSG|Full/MT|Office|User Name|Remark(s)";
            var headCount = ComCountHeadTitle(HeadTitle);

            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            // 자동 트림하여 조회및 저장
            //DataAutoTrim = true;

            // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 40,   daCenter,   false,    "ibflag");
            InitDataProperty(0, cnt++, dtSeq,        30,     daCenter,   false,    "Seq");
            InitDataProperty(0, cnt++, dtData,       100,    daCenter,   false,    "cntr_no",           false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       50,     daCenter,   false,    "tp_sz",             false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       100,    daCenter,   false,    "bkg_no",            false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       72,     daCenter,   false,    "vvd",               false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       40,     daCenter,   false,    "sts",               false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       70,     daCenter,   false,    "org_yd_cd",         false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       100,    daCenter,   false,    "pre_cnmv_evnt_dt",  false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       100,    daCenter,   false,    "crnt_cnmv_evnt_dt", false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       60,     daCenter,   false,    "gap",               false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       100,    daCenter,   false,    "cre_locl_dt",       false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       100,    daCenter,   false,    "upd_locl_dt",       false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       40,     daCenter,   false,    "mvmt_edi_msg_tp_id",false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       50,     daCenter,   false,    "fcntr_flg",         false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       50,     daCenter,   false,    "ofc_cd",            false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       100,    daLeft,     false,    "usr_nm",            false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,       160,    daLeft,     false,    "cnmv_rmk",          false,    "",    dfNone,    0,    false,    false);
			
            CountPosition = 0;
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:    //조회
                if (validateForm(sheetObj, formObj, sAction)) {
                    //sheetObj.WaitImageVisible = false;
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch4Fx("EES_CTM_0463GS.do", FormQueryString(formObj));
                }
                break;
				
 			case IBCLEAR:
				//Period
				formObj.pe_co.value = "P";
			
				formObj.pe_co_tp[0].checked = true;
				formObj.p_date1.className = "input1";
				formObj.p_date2.className = "input1";
				formObj.p_date1.readOnly = true;
				formObj.p_date2.readOnly = true;

				ComSetObjValue(formObj.p_date1, ComGetObjValue(formObj.as_p_date1));
				ComSetObjValue(formObj.p_date2, ComGetObjValue(formObj.as_p_date2));
				
				ComEnableObject(document.all.btn_Calendar, true);

				//Location
				formObj.location_gb.Enable = true;
				formObj.yd_cd_disp.className = "input1";
				formObj.yd_cd_disp.readOnly = false;

				comboObjects[0].Code = "L";
				ComSetObjValue(formObj.yd_cd_disp, "");
				comboObjects[1].RemoveAll();
				formObj.p_yard2.Enable = false;
				
				//Status
				formObj.status_cd.Enable = true;				
 				initCombo(comboObjects[2], 0);
				
				//S.O.C
				formObj.soc_cd.Enable = true;				
 				comboObjects[3].Code = "IN";
 				
				//Container No.
				ComSetObjValue(formObj.p_cntrno, "");
				ComSetObjValue(formObj.check_digit, "");
				ComSetObjValue(formObj.ctnr_tpsz_cd, "");

           		formObj.p_cntrno.className = "input2";
           		formObj.check_digit.className = "input2";
           		formObj.ctnr_tpsz_cd.className = "input2";
           		formObj.p_cntrno.readOnly = true;
           		formObj.check_digit.readOnly = true;
           		formObj.ctnr_tpsz_cd.readOnly = true;
				
				sheetObjects[0].RemoveAll();
 				break;
        }
    }


    /**
     * HTML Object의 OnKeyUp이벤트 처리
     */
    function obj_onkeyup(event) {
        srcValue = event.srcElement.value;    // CoCtm.js의 공통스크립트의 자동실행 방지용
        var formObj = document.form;
        var sheetObj = sheetObjects[0];

        switch(event.srcElement.name) {
            case "yd_cd_disp":
				if(comboObjects[0].Code == "Y"){
	                // yd_cd_disp에 입력되는 값의 length에 따른 처리
		            var ydCdDisp = formObj.yd_cd_disp;
	                if (ydCdDisp.value.length > 1) {
	                    formObj.p_yard1.value = ydCdDisp.value.toUpperCase();
	                    if (ydCdDisp.value.length > 4) {
	                          // p_yard1에 5글자가 채워지면 CTM공통함수의 yard_search() 호출
	                          if (!yard_search()) {
	                                //ydCdDisp.select();
									ydCdDisp.value = "";
	                                ydCdDisp.focus();
	                          } else {
	                                formObj.p_yard2.focus();
	                          }
	                    } else {
	                        formObj.p_yard2.RemoveAll();
	                    }
	                } else {
	                    formObj.p_yard1.value = "";
	                    formObj.p_yard2.RemoveAll();
	                }
				}else{
					// lcc_cd에 입력되는 값의 length에 따른 처리
	                var lcc_cd = event.srcElement;
	                // lcc_cd에 5글자가 채워지면 CTM공통함수의 code_search() 호출
	                if (lcc_cd.value.length > 4) {
	                    var lccChechXml = sheetObj.GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH13 + "&p_yard1=" + lcc_cd.value);
	                    var rtnValue = ComGetEtcData(lccChechXml, "rtnValue");
	                    if (rtnValue) {
	                        if (rtnValue == "S") {
	                            setFocusIndex(lcc_cd, 1);
	                        } else {
	                            ComShowCodeMessage("CTM20072");
	                            lcc_cd.value = "";
	                            lcc_cd.focus();
	                        }
	                    } else {
	                        ComShowCodeMessage("CTM20072");
	                        lcc_cd.value = "";
	                        lcc_cd.focus();
	                    }
	                }		
				}
                break;

        }
        onShowErrMsg = false;
    }


    /** 
     * 업무 자바스크립트 OnFocus 이벤트 처리  <br>
     */    
	function obj_activate() {
       	//마스크 구분자 없애기
        //ComClearSeparator(event.srcElement);
           
       	switch(event.srcElement.name){ 	    	
       		case "p_date1":
       			ComClearSeparator(event.srcElement);
       			break;
       		case "p_date2":
       			ComClearSeparator(event.srcElement);
       			break;
       	}
    }
	
	
    /** 
     * 업무 자바스크립트 Onblur 이벤트 처리  <br>
     */    
    function obj_blur(){
    	obj = event.srcElement;
    	var formObj = document.form;
		var vLocationGb = comboObjects[0].Code;

    	switch(obj.name) {
    		case "p_date1":
    			if( formObj.p_date1.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("p_date1", "");
                    	setFocus("p_date1");
                        return false;
                    }else{
                    	if( formObj.p_date2.value != ""){
							if(vLocationGb == "R"){
	                    		if(ComGetDaysBetween(formObj.p_date1.value, formObj.p_date2.value) >= 31){
	                    			ComAlertFocus(formObj.p_date1, ComGetMsg("CTM20121"));
	                    			setObjValue("p_date1", "");
	                    			return false;
	                    		}
							}else{
	                    		if(ComGetDaysBetween(formObj.p_date1.value, formObj.p_date2.value) >= 92){
	                    			ComAlertFocus(formObj.p_date1, ComGetMsg("CTM20120"));
	                    			setObjValue("p_date1", "");
	                    			return false;
	                    		}
							}
                    	}
                    }
                }
    			break;
    		case "p_date2":
    			if( formObj.p_date2.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("p_date2", "");
                    	setFocus("p_date2");
                        return false;
                    }else{
                    	if( formObj.p_date1.value != ""){
							if(vLocationGb == "R"){
	                    		if(ComGetDaysBetween(formObj.p_date1.value, formObj.p_date2.value) >= 31){
	                    			ComAlertFocus(formObj.p_date2, ComGetMsg("CTM20121"));
	                    			setObjValue("p_date2", "");
	                    			return false;
	                    		}
							}else{
								if(ComGetDaysBetween(formObj.p_date1.value, formObj.p_date2.value) >= 92){
	                    			ComAlertFocus(formObj.p_date2, ComGetMsg("CTM20120"));
	                    			setObjValue("p_date2", "");
	                    			return false;
	                    		}
							}
                    	}
                    }
                }
    			break;
    	}
    }
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with (formObj) {
            /* Date format이 validation이 실패한 경우 경우 return false로 service 호출을 막음 */
//            if (sAction == IBSEARCH) {
//             if (cancelDate == false) return false;
//            }
        	var tmpobjValue = formObj.p_date1.value;
        	var tmpobjValue2 = formObj.p_date2.value;
            // 전체 내용중 -를 삭제.
        	
        	tmpobjValue = ComGetUnMaskedValue(tmpobjValue, "ymd");
            tmpobjValue2 = ComGetUnMaskedValue(tmpobjValue2, "ymd");
            if (!ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue2) || !ComIsDate(tmpobjValue2)) {
				return false;
            } else {
                    date1 = document.getElementById("p_date1").value;
                    date2 = document.getElementById("p_date2").value;
                    date1 = ComGetUnMaskedValue(date1, "ymd");
                    date2 = ComGetUnMaskedValue(date2, "ymd");
                    if (date1 == '' || date2 == '') return;
                    if (date1 > date2) {
                    	ComShowCodeMessage("CTM10114");
                    	formObj.p_date1.focus();
                        return false;
                    }
                    
                    if(document.getElementById("p_date1").value != '' && document.getElementById("p_date2").value != ''){
                    	if(comboObjects[0].Code == 'R'){
                    		if(ComGetDaysBetween(formObj.p_date1.value, formObj.p_date2.value) >= 31){
                    			ComAlertFocus(formObj.btn_Calendar, ComGetMsg("CTM20121"));
                    			return false;
                    		}
                    	}else{
                    		if(ComGetDaysBetween(formObj.p_date1.value, formObj.p_date2.value) >= 92){
                    			ComAlertFocus(formObj.btn_Calendar, ComGetMsg("CTM20120"));
                    			return false;
                    		}
                    	}
                    }

            }
        }
        return true;
    }

    function location_gb_OnChange(comObj,index,text)
    {
    	var formObj = document.form;
		ComSetObjValue(formObj.yd_cd_disp, "");
		comboObjects[1].RemoveAll();
		if(index == "Y"){
			formObj.p_yard2.Enable = true;
		}else{
			formObj.p_yard2.Enable = false;
		}
	}

    //멀티콤보 클릭 이벤트
	function status_cd_OnCheckClick(comboObj, index, code) { 
		//All 인 경우
	    if(index == 0) {
	    	//checked
	    	if(comboObj.CheckIndex(index)) {
	    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
	    			comboObj.checkIndex(i) = true;
	    		}
	
	    	} else {
	    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
	    			comboObj.checkIndex(i) = false;
	    		}
	    	}
		//All 이 아닌 경우
	    } else {
	    	var checkCnt = 0;
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				if(comboObj.checkIndex(i)) {
					checkCnt++;
				}
			}
			if(checkCnt == comboObj.GetCount() - 1) {
				comboObj.checkIndex(0) = true;
			}else{
				comboObj.checkIndex(0) = false;
			}
	    }	 	 		  
	}

 	/**
      * Get Object Value
      */
	function getObjValue(name) {
		return ComGetObjValue(eval("document.form."+name));
	}
     
    /**
      * Set Object Value
      */
	function setObjValue(name, value) {
		ComSetObjValue(eval("document.form."+name), value);
	}
     
    /**
      * Move Focus in Object
      */
	function setFocus(name) {
		ComSetFocus(eval("document.form."+name));
		eval("document.form."+name).select();
	}  

/* 개발자 작업  끝 */
