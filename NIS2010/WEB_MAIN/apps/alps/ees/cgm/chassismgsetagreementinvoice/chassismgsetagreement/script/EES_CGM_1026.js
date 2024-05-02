/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1026.js
*@FileTitle : Lease Term Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.22 김창식
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


    /**
     * @extends
     * @class ees_cgm_1026 : ees_cgm_1026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_1026() {
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

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            	case "btn_Loadexcel":
        			var formObj = document.form;
        	     	var sheetObj = sheetObjects[0];

            		if (sheetObj.id == "sheet1") {
            			sheetObj.RemoveAll();
            			sheetObj.LoadExcel();
            		}
            		if(sheetObj.rowCount>0)
            		{
         				formObj.old_agmt_no.readOnly = true;
         				formObj.old_agmt_no.className = "input2";
         				ComCgmEnableObject(formObj.btns_agmtno, false);
            		}
            		// Expiry Date 가 PMNT인 경우 Data Disable
            		for(count_i=1; count_i<sheetObj.rowCount+1; count_i++){
            			var eqNo = sheetObj.CellValue(count_i, "eq_no");

            	     	if(eqNo != ''){

            	     		// Chassis No.에 대해서 Duplicate 체크를 수행한다.
            	     		//var checkDup = sheetObj.ColValueDup("eq_no", false);
            	            var checkDup = -1;
            	     		var cellValue = sheetObj.cellValue(count_i, "eq_no");
            	     		for(i=1; i<sheetObj.rowCount+1; i++){

            					if(sheetObj.CellValue(i, "eq_no")== cellValue && count_i != i )
            					{
            						checkDup = 1;
            					}
            				}
            	     		// Duplicate 가 아닐 경우 Chassis의 Current Status 정보를 가져온다.
            	     		if(checkDup == -1){

            			     	formObj.f_cmd.value = SEARCH01;
            					formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
            					formObj.eq_no.value = eqNo;
            			 		var sXml = sheetObjects[1].GetSearchXml("EES_CGM_1026GS.do" , FormQueryString(formObj), '', true);

            			 		// 데이터 건수
            			 		var dataCount = ComGetTotalRows(sXml);

            			 		// 데이터가 존재할 경우
            					if(dataCount > 0){

            						// inActive 일 경우에는 체크박스 Edit 속성을 False 로 한다.
            						if(ComGetEtcData(sXml,"aciac_div_cd") == 'I'){
            							sheetObj.CellEditable(count_i, "del_chk") = false;
            							sheetObj.RowFontColor(count_i) = sheetObj.RgbColor(255, 0, 0);	// Row 전체 Font Color 를 Red 로 설정
            						} else {
            							sheetObj.CellEditable(count_i, "del_chk") = true;
            							sheetObj.RowFontColor(count_i) = sheetObj.RgbColor(0, 0, 0);	// Row 전체 Font Color 를 Black 로 설정
            						}


            			 			sheetObj.cellValue2(count_i,"eq_no") 			= ComGetEtcData(sXml,"eq_no");
            				     	sheetObj.cellValue2(count_i,"eq_tpsz_cd") 		= ComGetEtcData(sXml,"eq_tpsz_cd");
            				     	sheetObj.cellValue2(count_i,"agmt_lstm_cd") 	= ComGetEtcData(sXml,"agmt_lstm_cd");
            				     	sheetObj.cellValue2(count_i,"sts_evnt_ofc_cd") 	= ComGetEtcData(sXml,"sts_evnt_ofc_cd");
            				     	sheetObj.cellValue2(count_i,"sts_evnt_yd_cd") 	= ComGetEtcData(sXml,"sts_evnt_yd_cd");
            				     	sheetObj.cellValue2(count_i,"vndr_seq") 		= ComGetEtcData(sXml,"vndr_seq");
            				     	sheetObj.cellValue2(count_i,"agmt_no") 			= ComGetEtcData(sXml,"agmt_no");
            				     	sheetObj.cellValue2(count_i,"agmt_ref_no") 		= ComGetEtcData(sXml,"agmt_ref_no");

            				     	sheetObj.cellValue2(count_i,"aciac_div_cd") 	= ComGetEtcData(sXml,"aciac_div_cd");
            				     	sheetObj.cellValue2(count_i,"eq_aset_sts_cd") 	= ComGetEtcData(sXml,"eq_aset_sts_cd");
            				     	sheetObj.cellValue2(count_i,"sts_evnt_loc_cd") 	= ComGetEtcData(sXml,"sts_evnt_loc_cd");
            				     	sheetObj.cellValue2(count_i,"agmt_ofc_cty_cd") 	= ComGetEtcData(sXml,"agmt_ofc_cty_cd");
            				     	sheetObj.cellValue2(count_i,"agmt_seq") 		= ComGetEtcData(sXml,"agmt_seq");
            				     	sheetObj.cellValue2(count_i,"agmt_ver_no") 		= ComGetEtcData(sXml,"agmt_ver_no");
            				     	sheetObj.cellValue2(count_i,"sts_evnt_dt") 		= ComGetEtcData(sXml,"sts_evnt_dt");


            				    // 데이터가 존재하지 않을 경우
            		     		} else {
            		     			ComShowCodeMessage('CGM10012');

            		     			sheetObj.CellEditable(count_i, "del_chk") = true;
            						sheetObj.RowFontColor(count_i) = sheetObj.RgbColor(0, 0, 0);

            		     			sheetObj.cellValue2(count_i,"eq_no") 			= "";
            				     	sheetObj.cellValue2(count_i,"eq_tpsz_cd") 		= "";
            				     	sheetObj.cellValue2(count_i,"agmt_lstm_cd") 	= "";
            				     	sheetObj.cellValue2(count_i,"sts_evnt_ofc_cd") 	= "";
            				     	sheetObj.cellValue2(count_i,"sts_evnt_yd_cd") 	= "";
            				     	sheetObj.cellValue2(count_i,"vndr_seq") 		= "";
            				     	sheetObj.cellValue2(count_i,"agmt_no") 			= "";
            				     	sheetObj.cellValue2(count_i,"agmt_ref_no") 		= "";

            				     	sheetObj.cellValue2(count_i,"aciac_div_cd") 	= "";
            				     	sheetObj.cellValue2(count_i,"eq_aset_sts_cd") 	= "";
            				     	sheetObj.cellValue2(count_i,"sts_evnt_loc_cd") 	= "";
            				     	sheetObj.cellValue2(count_i,"agmt_ofc_cty_cd") 	= "";
            				     	sheetObj.cellValue2(count_i,"agmt_seq") 		= "";
            				     	sheetObj.cellValue2(count_i,"agmt_ver_no") 		= "";
            				     	sheetObj.cellValue2(count_i,"sts_evnt_dt") 		= "";

            				     	sheetObj.focus();
            				     	sheetObj.SelectCell(count_i,"eq_no",true);
            		     		}

            	     		// Duplicate 되었을 경우에  메시지를 표시한 후 Row 를 Clear 한다.
            	     		} else {
            	     			ComShowCodeMessage('CGM10017','Chassis No.');

            	     			sheetObj.CellEditable(count_i, "del_chk") = true;
            					sheetObj.RowFontColor(count_i) = sheetObj.RgbColor(0, 0, 0);

            	     			sheetObj.cellValue2(count_i,"eq_no") 			= "";
            			     	sheetObj.cellValue2(count_i,"eq_tpsz_cd") 		= "";
            			     	sheetObj.cellValue2(count_i,"agmt_lstm_cd") 	= "";
            			     	sheetObj.cellValue2(count_i,"sts_evnt_ofc_cd") 	= "";
            			     	sheetObj.cellValue2(count_i,"sts_evnt_yd_cd") 	= "";
            			     	sheetObj.cellValue2(count_i,"vndr_seq") 		= "";
            			     	sheetObj.cellValue2(count_i,"agmt_no") 			= "";
            			     	sheetObj.cellValue2(count_i,"agmt_ref_no") 		= "";

            			     	sheetObj.cellValue2(count_i,"aciac_div_cd") 	= "";
            			     	sheetObj.cellValue2(count_i,"eq_aset_sts_cd") 	= "";
            			     	sheetObj.cellValue2(count_i,"sts_evnt_loc_cd") 	= "";
            			     	sheetObj.cellValue2(count_i,"agmt_ofc_cty_cd") 	= "";
            			     	sheetObj.cellValue2(count_i,"agmt_seq") 		= "";
            			     	sheetObj.cellValue2(count_i,"agmt_ver_no") 		= "";
            			     	sheetObj.cellValue2(count_i,"sts_evnt_dt") 		= "";
            	     		}
            	     	}
            		}
            		 break;
 				case "btn_rowadd":
 					if(ComIsBtnEnable(srcName)){
 						doActionIBSheet(sheetObject1,formObject,IBINSERT);
 					}
 					break;

 				case "btn_rowdelete":
 					if(ComIsBtnEnable(srcName)){
 						doActionIBSheet(sheetObject1,formObject,IBRESET);
 					}
 					break;

 				case "btn_downexcel":
 					if(ComIsBtnEnable(srcName)){
 						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					}
 					break;

 				case "btn_Retrieve":
 					if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
 						// 조회 실행
 						doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 						// 버튼 ENABLE 설정
 						doActionBtnEnable("btn_Retrieve");
 					}
 					break;

 				case "btn_New":
 					// Control 초기화
 					initControl();
 					// 버튼 ENABLE 설정
					doActionBtnEnable("btn_New");
 					break;

 				case "btn_Save":
 					if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
 						// 저장
 						//doActionIBSheet(sheetObject1, formObject, IBSAVE);
 						doActionIBSheet(sheetObject1, formObject, IBBATCH);
 					}
 					break;

 				case "btns_Calendar_activityDt" :		// Activity Date
					var cal = new ComCalendar();
 				    cal.setEndFunction("processEndCal");
			    	cal.select(formObject.sts_evnt_dt, "yyyy-MM-dd");
		    		break;

 				case "btns_agmtno":			// Agreement No 가져오기 팝업
 					if(!formObject.btns_agmtno.disabled){
	 					ComOpenPopupWithTarget(
							'/hanjin/EES_CGM_1117.do', 820, 420,
							"agmt_ofc_cty_cd:old_agmt_ofc_cty_cd|" +
							"agmt_seq:old_agmt_seq|" +
							"agmt_ver_no:old_agmt_ver_no|" +
							"agmt_no:old_agmt_no|" +
							"agmt_ref_no:old_agmt_ref_no|" +
							"agmt_lstm_cd:old_agmt_lstm_cd|" +
							"vndr_seq:old_vndr_seq|" +
							"vndr_lgl_eng_nm:old_vndr_lgl_eng_nm",
							"1,0,1,1,1,1,1,1,1", true);
 					}
 					break;

 				case "btns_new_agmtno":		// New Agreement No 가져오기 팝업
 					ComOpenPopupWithTarget(
 						'/hanjin/EES_CGM_1117.do', 820, 420,
 						"agmt_ofc_cty_cd:new_agmt_ofc_cty_cd|" +
						"agmt_seq:new_agmt_seq|" +
						"agmt_ver_no:new_agmt_ver_no|" +
 						"agmt_no:new_agmt_no|" +
 						"agmt_ref_no:new_agmt_ref_no|" +
 						"agmt_lstm_cd:new_agmt_lstm_cd|" +
 						"vndr_seq:new_vndr_seq|" +
 						"vndr_lgl_eng_nm:new_vndr_lgl_eng_nm",
 						"1,0,1,1,1,1,1,1,1", true);
					break;

 				case "btns_office":	// Office Code 가져오기 팝업
					ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 480, "ofc_cd:sts_evnt_ofc_cd", "1,0,1,1,1,1,1,1", true);
					break;

            } // end switch
            tRoleApply();
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
    }

    /**
     * IBSheet Object를 배열로 등록 <br>
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function loadPage() {

    	// axon event 등록
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerFormat('keydown', 'obj_keydown', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('change', 'obj_change', 'old_agmt_no');
        axon_event.addListener('change', 'obj_change', 'new_agmt_no');
        axon_event.addListener('change', 'obj_change', 'sts_evnt_ofc_cd');
        axon_event.addListenerForm 	 ('focusout', 'obj_focusout',   form);

    	for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        // Form Object 초기화
     	initControl();

     	tRoleApply();
    }

    /**
     * Form의 Conrol 를 초기화 시킨다. <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function initControl(){
    	// Form 객체 선언
      	formObj = document.form;

    	// 현재 날짜 가져오기
    	var sysDate   = new Date();
    	var year = sysDate.getFullYear();
    	var month = sysDate.getMonth()+1;
    	var date = sysDate.getDate();

    	var today = ComLpad(year, 4, "0") + "-" + ComLpad(month, 2, "0") + "-" + ComLpad(date, 2, "0");

    	// Form Object 초기화
        with(formObj){
        	ComCgmSetObjectValue(sts_evnt_dt, today);
        	ComCgmSetObjectValue(sts_evnt_ofc_cd, ofc_cd.value);

        	ComCgmSetObjectValue(old_agmt_no);
        	ComCgmSetObjectValue(old_agmt_ref_no);
        	ComCgmSetObjectValue(old_agmt_lstm_cd);
        	ComCgmSetObjectValue(old_vndr_seq);
        	ComCgmSetObjectValue(old_vndr_lgl_eng_nm);

        	ComCgmSetObjectValue(new_agmt_no);
        	ComCgmSetObjectValue(new_agmt_ref_no);
        	ComCgmSetObjectValue(new_agmt_lstm_cd);
        	ComCgmSetObjectValue(new_vndr_seq);
        	ComCgmSetObjectValue(new_vndr_lgl_eng_nm);

        }

        formObj.old_agmt_no.readOnly = false;
        formObj.old_agmt_no.className = "input";
        ComCgmEnableObject(formObj.btns_agmtno, true);

        // Sheet Object 초기화
        sheetObjects[0].RemoveAll();

        // 초기 focus
        formObj.old_agmt_no.focus();

    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

 					var HeadTitle = "||A/I|Chassis No.|Type/Size|Term|Office|Yard|Lessor|Agreement No.|Reference No.|Status|||||Status Date";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,30,	daCenter,	false,	"ibflag");
 					InitDataProperty(0, cnt++ , dtCheckBox,	30,		daCenter,	false,	"del_chk");
 					InitDataProperty(0, cnt++ , dtData,     30,	    daCenter,	false,	"aciac_div_cd",		false,	"",	dfNone,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,		110,	daCenter,	false,	"eq_no", 			false,	"",	dfNone,	0, false, true ,10);
 					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"eq_tpsz_cd",		false,	"",	dfNone,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"agmt_lstm_cd",		false,	"",	dfNone,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,	"sts_evnt_ofc_cd",	false,	"",	dfNone,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,		80,    daCenter,	false,	"sts_evnt_yd_cd",	false,	"",	dfNone,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,	"vndr_seq",	 		false,	"",	dfNone,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,		120,	daCenter,	false,	"agmt_no",	 		false,	"",	dfNone,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,		120,	daCenter,	false,	"agmt_ref_no",	 	false,	"",	dfNone,	0, false, false);
 					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,	"eq_aset_sts_cd",	false,	"",	dfNone,	0, false, false);


 					InitDataProperty(0, cnt++ , dtHidden,30,	daCenter,	false,	"sts_evnt_loc_cd");

 					InitDataProperty(0, cnt++ , dtHidden,30,	daCenter,	false,	"agmt_ofc_cty_cd");
 					InitDataProperty(0, cnt++ , dtHidden,30,	daCenter,	false,	"agmt_seq");
 					InitDataProperty(0, cnt++ , dtHidden,30,	daCenter,	false,	"agmt_ver_no");
 					InitDataProperty(0, cnt++ , dtData,	 80,	daCenter,	false,	"sts_evnt_dt",	    false,	"",	dfUserFormat2,	0, false, false);

 					InitUserFormat2(0, "sts_evnt_dt", "####-##-##", "-|:" );
 					InitDataValid(0, "eq_no", vtEngUpOther, "1234567890");

                }
                break;

            case 2:
	        	with (sheetObj) {
        			// 높이 설정
                    style.height = 202;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle1 = "";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(1, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOL	TIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	 daCenter,	true, "ibflag");
				}
        		break;
        }
    }

    /**
     * Action 버튼의 활성/비활성을 설정한다. <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function doActionBtnEnable (srcName){
    	switch(srcName){
    		case "btn_Retrieve":
    			ComBtnDisable("btn_rowadd");
    			ComBtnDisable("btn_rowdelete");
    			ComBtnEnable("btn_downexcel");
    			ComBtnDisable("btn_Loadexcel");
    			break;

    		case "btn_New":
    			ComBtnEnable("btn_rowadd");
    			ComBtnEnable("btn_rowdelete");
    			ComBtnDisable("btn_downexcel");
    			ComBtnEnable("btn_Loadexcel");
    			break;
    	}
    }


    /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
	            // Form Object 값 설정
            	formObj.f_cmd.value = SEARCH;
            	formObj.agmt_no.value = formObj.old_agmt_no.value;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
         		sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
	     		// 조회실행
	     		var sXml = sheetObj.GetSearchXml("EES_CGM_1026GS.do" , FormQueryString(formObj), '', true);
	     		sheetObj.LoadSearchXml(sXml);
	     		ComOpenWait(false);
	     		// Form Object 초기화 (New Agreement)
	     		formObj.new_agmt_no.value 			= "";
	 			formObj.new_agmt_ofc_cty_cd.value	= "";
	 			formObj.new_agmt_seq.value			= "";
	 			formObj.new_agmt_ver_no.value		= "";
	 			formObj.new_agmt_ref_no.value		= "";
	 			formObj.new_agmt_lstm_cd.value 		= "";
	 			formObj.new_vndr_seq.value 			= "";
	 			formObj.new_vndr_lgl_eng_nm.value	= "";

	 			break;

 			case IBSAVE:        //저장

 				var stsRows = sheetObj.FindStatusRow("I|U");
 				var chkRows = sheetObj.FindCheckedRow("del_chk");

 				var arrStsRows = stsRows.split(";");
 				var arrChkRows = chkRows.split("|");

 				var chk;
 				var dt   =   ComReplaceStr(form.sts_evnt_dt.value,"-","");
 				for(i=1; i<=sheetObj.rowCount; i++){
 					if(sheetObj.CellValue(i, "del_chk") == "1"){
 						if(dt<sheetObj.CellValue(i, "sts_evnt_dt")){
 							ComShowCodeMessage('CGM10060',sheetObj.CellValue(i, "eq_no"));
 							return false;
 							break;
 						}
 					}
 				}
 				for(i=0; i < arrStsRows.length-1; i++){
 					chk = false;

 					for(k=0; k < arrChkRows.length-1; k++){
 						if(arrStsRows[i] == arrChkRows[k]){
 							chk = true;
 							break;
 						}
 					}

 					if(!chk){
 						sheetObj.RowStatus(arrStsRows[i]) = "";
 					}
 				}

 				if(arrChkRows.length-1 > 0){

	 				// 저장
	 				formObj.f_cmd.value = MULTI;
	 				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;

	 				var sParam = sheetObjects[0].GetSaveString();
	 				sParam = ComSetPrifix(sParam, "sheet1") + "&" + FormQueryString(formObj);
	 				sheetObj.WaitImageVisible=false;
			 	    ComOpenWait(true);
	 				var sXml = sheetObj.GetSaveXml("EES_CGM_1026GS.do", sParam);
	 				sheetObjects[0].LoadSaveXml(sXml);
	 				ComOpenWait(false);

 				} else {
 					ComShowCodeMessage('CGM10009','checkbox');
 				}
//
 				break;
 			case IBBATCH:      //저장-BackEndJob
				var stsRows = sheetObj.FindStatusRow("I|U");
 				var chkRows = sheetObj.FindCheckedRow("del_chk");

 				var arrStsRows = stsRows.split(";");
 				var arrChkRows = chkRows.split("|");

 				var chk;
 				var dt   =   ComReplaceStr(form.sts_evnt_dt.value,"-","");
 				for(i=1; i<=sheetObj.rowCount; i++){
 					if(sheetObj.CellValue(i, "del_chk") == "1"){
 						if(dt<sheetObj.CellValue(i, "sts_evnt_dt")){
 							ComShowCodeMessage('CGM10060',sheetObj.CellValue(i, "eq_no"));
 							return false;
 							break;
 						}
 					}
 				}
 				for(i=0; i < arrStsRows.length-1; i++){
 					chk = false;

 					for(k=0; k < arrChkRows.length-1; k++){
 						if(arrStsRows[i] == arrChkRows[k]){
 							chk = true;
 							break;
 						}
 					}

 					if(!chk){
 						sheetObj.RowStatus(arrStsRows[i]) = "";
 					}
 				}

 				if(arrChkRows.length-1 > 0){

	 				// 저장
	 				formObj.f_cmd.value = COMMAND01;
	 				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;

	 				var sParam = sheetObjects[0].GetSaveString();
	 				sParam = ComSetPrifix(sParam, "sheet1") + "&" + FormQueryString(formObj);
	 				sheetObj.WaitImageVisible=false;
			 	    ComOpenWait(true);

			 	    var sXml = sheetObj.GetSaveXml("EES_CGM_1026GS.do", sParam);
					var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

					if (backendJobKey.length > 0) {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.RequestTimeOut = 10000;
						timer1 = setInterval(getBackEndJobStatus, 3000);
					}
 				} else {
 					ComShowCodeMessage('CGM10009','checkbox');
 				}
//
 				break;

 			case IBSEARCH_ASYNC01:	// Office Code 에 대한 Validation 체크
	        	formObj.f_cmd.value = COMMAND01;
	        	formObj.ofc_cd.value = formObj.sts_evnt_ofc_cd.value;
	        	var sXml = sheetObjects[1].GetSearchXml("CgmValidationGS.do", FormQueryString(formObj), '', true);
	        	var sCheckResult = ComGetEtcData(sXml,"checkResult");

	        	if(sCheckResult == COM_VALIDATION_FALSE){
	        		ComShowCodeMessage('CGM10009','Office');
	        		formObj.sts_evnt_ofc_cd.value = "";
	        		formObj.sts_evnt_ofc_cd.focus();
	        	}

	        	break;

 			case IBSEARCH_ASYNC02:

 				formObj.f_cmd.value = SEARCH12;
 				formObj.agmt_no.value = formObj.old_agmt_no.value;
 				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
 				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do" , FormQueryString(formObj), '', true);

		 		// 데이터 건수
				var dataCount = ComGetTotalRows(sXml);
				// 데이터가 존재할 경우
				if(dataCount>0){
					formObj.old_agmt_ofc_cty_cd.value 	= DomXml2String(sXml,"agmt_ofc_cty_cd");
		 			formObj.old_agmt_seq.value 			= DomXml2String(sXml,"agmt_seq");
		 			formObj.old_agmt_ver_no.value 		= DomXml2String(sXml,"agmt_ver_no");
		 			formObj.old_agmt_ref_no.value 		= DomXml2String(sXml,"agmt_ref_no");
		 			formObj.old_agmt_lstm_cd.value 		= DomXml2String(sXml,"agmt_lstm_cd");
		 			formObj.old_vndr_seq.value 			= DomXml2String(sXml,"vndr_seq");
		 			formObj.old_vndr_lgl_eng_nm.value 	= DomXml2String(sXml,"vndr_lgl_eng_nm");

		 			return true;
		 		} else {
	        		return false;
		 		}

 				break;

 			case IBSEARCH_ASYNC03:

 				formObj.f_cmd.value = SEARCH12;
 				formObj.agmt_no.value = formObj.new_agmt_no.value;
 				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
 				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do" , FormQueryString(formObj), '', true);

		 		// 데이터 건수
		 		var dataCount = ComGetTotalRows(sXml);

		 		// 데이터가 존재할 경우
				if(dataCount > 0){
					formObj.new_agmt_ofc_cty_cd.value 	= DomXml2String(sXml,"agmt_ofc_cty_cd");
		 			formObj.new_agmt_seq.value 			= DomXml2String(sXml,"agmt_seq");
		 			formObj.new_agmt_ver_no.value 		= DomXml2String(sXml,"agmt_ver_no");
		 			formObj.new_agmt_ref_no.value 		= DomXml2String(sXml,"agmt_ref_no");
		 			formObj.new_agmt_lstm_cd.value 		= DomXml2String(sXml,"agmt_lstm_cd");
		 			formObj.new_vndr_seq.value 			= DomXml2String(sXml,"vndr_seq");
		 			formObj.new_vndr_lgl_eng_nm.value 	= DomXml2String(sXml,"vndr_lgl_eng_nm");

		 			return true;
		 		} else {
	        		return false;
		 		}

 				break;

 			case IBINSERT:      // 행추가
 				sheetObj.DataInsert(-1);
 				formObj.old_agmt_no.readOnly = true;
 				formObj.old_agmt_no.className = "input2";
 				ComCgmEnableObject(formObj.btns_agmtno, false);

                break;

 			case IBRESET:	 	// 행삭제
 				ComRowHideDelete(sheetObj,"del_chk");
 				break;

 			case IBDOWNEXCEL:
 				sheetObj.SpeedDown2Excel(1,false,true,"","",false,false,"",true,"del_chk|sts_evnt_loc_cd|agmt_ofc_cty_cd|agmt_seq|agmt_ver_no");
 				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 김창식
     * @version 2009.06.23
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction){
    	 		case IBSEARCH:	// 조회
	    	 		if(old_agmt_no.value == ''){
	    	 			ComShowCodeMessage('CGM10004','Agreement No.');
	    	 			old_agmt_no.focus();
	    	 			return false;
	                } else {
	                	return true;
	                }
    	 			break;

    	 		case IBSAVE:	// 저장
	    	 		if(sts_evnt_dt.value == ''){
	    	 			ComShowCodeMessage('CGM10004','Activity Date');
	    	 			sts_evnt_dt.focus();
	    	 			return false;

	    	 		} else if(sts_evnt_ofc_cd.value == ''){
	    	 			ComShowCodeMessage('CGM10004','Office');
	    	 			sts_evnt_ofc_cd.focus();
	    	 			return false;
	    	 		} else if(new_agmt_no.value == ''){
		    	 		ComShowCodeMessage('CGM10004','Agreement No.');
		    	 		new_agmt_no.focus();
		    	 		return false;
		    	 	}

    	 			// 현재 Agreement No 와 New Agreement 가 같을 경우 메시지 출력
	    	 		if(old_agmt_no.value == new_agmt_no.value){
	    	 			ComShowCodeMessage('CGM10035');

	    	 			// Form Object 초기화 (New Agreement)
	    	     		new_agmt_no.value 			= "";
	    	 			new_agmt_ofc_cty_cd.value	= "";
	    	 			new_agmt_seq.value			= "";
	    	 			new_agmt_ver_no.value		= "";
	    	 			new_agmt_ref_no.value		= "";
	    	 			new_agmt_lstm_cd.value 		= "";
	    	 			new_vndr_seq.value 			= "";
	    	 			new_vndr_lgl_eng_nm.value	= "";

	    	 			new_agmt_no.focus();
	    	 			return false;
	    	 		}

	    	 	    //chungpa 20100525 grid의 agreement가 New Agreement와 동일한게 있다면 메시지 출력 start
            		for(count_i=1; count_i<sheetObj.rowCount+1; count_i++){
            			var grid_agmt_seq = sheetObj.CellValue(count_i, "agmt_seq");
            			var grid_agmt_ofc_cty_cd = sheetObj.CellValue(count_i, "agmt_ofc_cty_cd");

            			if( (grid_agmt_seq == new_agmt_seq.value)
	    	 				&& (grid_agmt_ofc_cty_cd == new_agmt_ofc_cty_cd.value)
	    	 			)
	    	 			{
		    	 			ComShowCodeMessage('CGM10035');

		    	 			// Form Object 초기화 (New Agreement)
		    	     		new_agmt_no.value 			= "";
		    	 			new_agmt_ofc_cty_cd.value	= "";
		    	 			new_agmt_seq.value			= "";
		    	 			new_agmt_ver_no.value		= "";
		    	 			new_agmt_ref_no.value		= "";
		    	 			new_agmt_lstm_cd.value 		= "";
		    	 			new_vndr_seq.value 			= "";
		    	 			new_vndr_lgl_eng_nm.value	= "";

		    	 			new_agmt_no.focus();
		    	 			return false;
	    	 			}
            		}
    	 			//chungpa 20100525 grid의 agreement가 New Agreement와 동일한게 있다면 메시지 출력 end
    	 			break;
        	}
        }

        return true;
    }

    /**
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function obj_keypress(){
      	obj = event.srcElement;
      	if(obj.dataformat == null) return;

      	window.defaultStatus = obj.dataformat;

      	switch(obj.dataformat) {
      	 	case "ym": case "ymd":
      	 		ComKeyOnlyNumber(obj);
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
      	        if(obj.name=="sts_evnt_ofc_cd") ComKeyOnlyAlphabet('uppernum');
      	        else if(obj.name=="old_agmt_no") ComKeyOnlyAlphabet('uppernum');
      	        else if(obj.name=="new_agmt_no") ComKeyOnlyAlphabet('uppernum');
      	        else ComKeyOnlyAlphabet('upper');
      	        break;
      	    case "engdn":
      	        ComKeyOnlyAlphabet('lower');
      	        break;
      	}
    }

    /**
     * Object 의 Keydown 이벤트에 대한 처리  <br>
     * 객체가 old_agmt_no 일 경우에만 enter 키 발생시 조회실행.  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function obj_keydown(){
    	var obj = event.srcElement;
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;

    	switch(obj.name){
    		case 'old_agmt_no':
    			var keyValue = null;
            	if(event == undefined || event == null) {
            		keyValue = 13;
            	} else {
            		keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    			}

    			if(keyValue != 13) return;

    			var agmtNo = formObj.old_agmt_no.value;
    	 		var result = true;

    	 		if(agmtNo != ""){
    	 			if(agmtNo.length <= 3){
	    	 			result = false;
	    	 		} else {
	    	 			if(ComIsNumber(agmtNo.substring(3))==false){
	    	 				result = false;
	    	 			}
	    	 		}
    	 		} else {
    	 			result = true;
    	 		}

    	 		if(!result){
    	 			ComShowCodeMessage('CGM10004','Agreement No.');
    	 			formObj.old_agmt_no.value="";
    	 			ComSetFocus(formObj.old_agmt_no);
    	 		} else {
    	 			if(!doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02)){
	 					formObj.old_agmt_no.focus();
    	 			} else {
    	 				ComKeyEnter();
    	 			}
    	 		}

    			break;
    	}
    }

    /**
     * Object 의 activate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function obj_activate(){
     	ComClearSeparator(event.srcElement);
    }

    /**
     * Object 의 deactivate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function obj_deactivate(){
     	var formObj = document.form;
     	obj = event.srcElement;

     	if(obj.name == 'sts_evnt_dt'){
     		ComChkObjValid(event.srcElement);
     	}
    }

    /**
     * Object 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function obj_change(){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];

    	obj = event.srcElement;
    	switch(obj.name){
    	 	case "old_agmt_no":
    	 	case "new_agmt_no":
    	 		var result = true;
    	 		var agmtNo;

    	 		if(obj.name == 'old_agmt_no')		agmtNo = formObj.old_agmt_no.value;
    	 		else if(obj.name == 'new_agmt_no')	agmtNo = formObj.new_agmt_no.value;

    	 		if(agmtNo != ""){
    	 			result = true;
    	 			if(agmtNo.length <= 3){
	    	 			result = false;
	    	 		} else {
	    	 			if(ComIsNumber(agmtNo.substring(3))==false){
	    	 				result = false;
	    	 			}
	    	 		}

	    	 		// validation 체크 오류일 경우
	    	 		if(!result){
	    	 			ComShowCodeMessage('CGM10004','Agreement No.');

	    	 			if(obj.name == 'old_agmt_no'){
	    	 				// Sheet Object 초기화
	    	 				sheetObj.RemoveAll();
	    	 				// Form Object 초기화
	    	 				formObj.old_agmt_no.value="";
	    	 				formObj.old_agmt_ofc_cty_cd.value	= "";
	    		 			formObj.old_agmt_seq.value			= "";
	    		 			formObj.old_agmt_ver_no.value		= "";
	    		 			formObj.old_agmt_ref_no.value		= "";
	    		 			formObj.old_agmt_lstm_cd.value 		= "";
	    		 			formObj.old_vndr_seq.value 			= "";
	    		 			formObj.old_vndr_lgl_eng_nm.value	= "";
		    	 			ComSetFocus(formObj.old_agmt_no);

		    	 			doActionBtnEnable("btn_New");

	    	 			} else if(obj.name == 'new_agmt_no'){
	    	 				// Form Object 초기화
	    	 				formObj.new_agmt_no.value="";
	    	 				formObj.new_agmt_ofc_cty_cd.value	= "";
	    		 			formObj.new_agmt_seq.value			= "";
	    		 			formObj.new_agmt_ver_no.value		= "";
	    		 			formObj.new_agmt_ref_no.value		= "";
	    		 			formObj.new_agmt_lstm_cd.value 		= "";
	    		 			formObj.new_vndr_seq.value 			= "";
	    		 			formObj.new_vndr_lgl_eng_nm.value	= "";
		    	 			ComSetFocus(formObj.new_agmt_no);
	    	 			}

	    	 		// Validation 체크가 성공적이면 Agreement 정보를 가져온다.
	    	 		} else {

	    	 			if(obj.name == 'old_agmt_no'){
	    	 				sheetObj.RemoveAll();
	    	 				if(!doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC02)){
	    	 					ComShowCodeMessage('CGM10009','Agreement No.');

	    	 					// Sheet Object 초기화
	    			 			sheetObjects[0].RemoveAll();

	    			 			// Form Object 초기화
	    			 			formObj.old_agmt_no.value 			= "";
	    			 			formObj.old_agmt_ofc_cty_cd.value	= "";
	    			 			formObj.old_agmt_seq.value			= "";
	    			 			formObj.old_agmt_ver_no.value		= "";
	    			 			formObj.old_agmt_ref_no.value		= "";
	    			 			formObj.old_agmt_lstm_cd.value 		= "";
	    			 			formObj.old_vndr_seq.value 			= "";
	    			 			formObj.old_vndr_lgl_eng_nm.value	= "";

	    			 			// Focus
	    	 					ComSetFocus(formObj.old_agmt_no);

	    	 					doActionBtnEnable("btn_New");

	    	 				} else {
	    	 					doActionBtnEnable("btn_Retrieve");
	    	 				}
	    	 			} else if(obj.name == 'new_agmt_no'){
	    	 				if(!doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC03)){

	    	 					ComShowCodeMessage('CGM10009','Agreement No.');

	    	 					// Form Object 초기화
	    			 			formObj.new_agmt_no.value 			= "";
	    			 			formObj.new_agmt_ofc_cty_cd.value	= "";
	    			 			formObj.new_agmt_seq.value			= "";
	    			 			formObj.new_agmt_ver_no.value		= "";
	    			 			formObj.new_agmt_ref_no.value		= "";
	    			 			formObj.new_agmt_lstm_cd.value 		= "";
	    			 			formObj.new_vndr_seq.value 			= "";
	    			 			formObj.new_vndr_lgl_eng_nm.value	= "";

	    	 					ComSetFocus(formObj.new_agmt_no);
	    	 				}
	    	 			}
	    	 		}
    	 		}

    	 		break;

    	 	case "sts_evnt_ofc_cd":
    	 		if(formObj.sts_evnt_ofc_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    	 		}

    	 		break;
    	}
    }


    /**
     * Sheet1 의 change 이벤트에 대한 처리  <br>
     * @param  sheetObj
     * @param  Row
     * @param  Col
     * @return 없음
     * @author 김창식
     * @version 2009.06.23
     */
    function sheet1_OnChange(sheetObj, Row, Col){
    	var formObj = document.form;
     	var sheetObj = sheetObjects[0];

     	var targetCol = sheetObj.SaveNameCol("eq_no");
     	var eqNo = sheetObj.cellValue(Row, "eq_no");

     	if(Col == targetCol && eqNo != ''){

     		// Chassis No.에 대해서 Duplicate 체크를 수행한다.
     		//var checkDup = sheetObj.ColValueDup("eq_no", false);
            var checkDup = -1;
     		var cellValue = sheetObj.cellValue(Row, Col);
     		for(i=1; i<sheetObj.rowCount+1; i++){

				if(sheetObj.CellValue(i, "eq_no")== cellValue && Row != i )
				{
					checkDup = 1;
				}
			}
     		// Duplicate 가 아닐 경우 Chassis의 Current Status 정보를 가져온다.
     		if(checkDup == -1){

		     	formObj.f_cmd.value = SEARCH01;
				formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				formObj.eq_no.value = eqNo;
		 		var sXml = sheetObjects[1].GetSearchXml("EES_CGM_1026GS.do" , FormQueryString(formObj), '', true);

		 		// 데이터 건수
		 		var dataCount = ComGetTotalRows(sXml);

		 		// 데이터가 존재할 경우
				if(dataCount > 0){

					// inActive 일 경우에는 체크박스 Edit 속성을 False 로 한다.
					if(ComGetEtcData(sXml,"aciac_div_cd") == 'I'){
						sheetObj.CellEditable(Row, "del_chk") = false;
						sheetObj.RowFontColor(Row) = sheetObj.RgbColor(255, 0, 0);	// Row 전체 Font Color 를 Red 로 설정
					} else {
						sheetObj.CellEditable(Row, "del_chk") = true;
						sheetObj.RowFontColor(Row) = sheetObj.RgbColor(0, 0, 0);	// Row 전체 Font Color 를 Black 로 설정
					}


		 			sheetObj.cellValue2(Row,"eq_no") 			= ComGetEtcData(sXml,"eq_no");
			     	sheetObj.cellValue2(Row,"eq_tpsz_cd") 		= ComGetEtcData(sXml,"eq_tpsz_cd");
			     	sheetObj.cellValue2(Row,"agmt_lstm_cd") 	= ComGetEtcData(sXml,"agmt_lstm_cd");
			     	sheetObj.cellValue2(Row,"sts_evnt_ofc_cd") 	= ComGetEtcData(sXml,"sts_evnt_ofc_cd");
			     	sheetObj.cellValue2(Row,"sts_evnt_yd_cd") 	= ComGetEtcData(sXml,"sts_evnt_yd_cd");
			     	sheetObj.cellValue2(Row,"vndr_seq") 		= ComGetEtcData(sXml,"vndr_seq");
			     	sheetObj.cellValue2(Row,"agmt_no") 			= ComGetEtcData(sXml,"agmt_no");
			     	sheetObj.cellValue2(Row,"agmt_ref_no") 		= ComGetEtcData(sXml,"agmt_ref_no");

			     	sheetObj.cellValue2(Row,"aciac_div_cd") 	= ComGetEtcData(sXml,"aciac_div_cd");
			     	sheetObj.cellValue2(Row,"eq_aset_sts_cd") 	= ComGetEtcData(sXml,"eq_aset_sts_cd");
			     	sheetObj.cellValue2(Row,"sts_evnt_loc_cd") 	= ComGetEtcData(sXml,"sts_evnt_loc_cd");
			     	sheetObj.cellValue2(Row,"agmt_ofc_cty_cd") 	= ComGetEtcData(sXml,"agmt_ofc_cty_cd");
			     	sheetObj.cellValue2(Row,"agmt_seq") 		= ComGetEtcData(sXml,"agmt_seq");
			     	sheetObj.cellValue2(Row,"agmt_ver_no") 		= ComGetEtcData(sXml,"agmt_ver_no");
			     	sheetObj.cellValue2(Row,"sts_evnt_dt") 		= ComGetEtcData(sXml,"sts_evnt_dt");


			    // 데이터가 존재하지 않을 경우
	     		} else {
	     			ComShowCodeMessage('CGM10012');

	     			sheetObj.CellEditable(Row, "del_chk") = true;
					sheetObj.RowFontColor(Row) = sheetObj.RgbColor(0, 0, 0);

	     			sheetObj.cellValue2(Row,"eq_no") 			= "";
			     	sheetObj.cellValue2(Row,"eq_tpsz_cd") 		= "";
			     	sheetObj.cellValue2(Row,"agmt_lstm_cd") 	= "";
			     	sheetObj.cellValue2(Row,"sts_evnt_ofc_cd") 	= "";
			     	sheetObj.cellValue2(Row,"sts_evnt_yd_cd") 	= "";
			     	sheetObj.cellValue2(Row,"vndr_seq") 		= "";
			     	sheetObj.cellValue2(Row,"agmt_no") 			= "";
			     	sheetObj.cellValue2(Row,"agmt_ref_no") 		= "";

			     	sheetObj.cellValue2(Row,"aciac_div_cd") 	= "";
			     	sheetObj.cellValue2(Row,"eq_aset_sts_cd") 	= "";
			     	sheetObj.cellValue2(Row,"sts_evnt_loc_cd") 	= "";
			     	sheetObj.cellValue2(Row,"agmt_ofc_cty_cd") 	= "";
			     	sheetObj.cellValue2(Row,"agmt_seq") 		= "";
			     	sheetObj.cellValue2(Row,"agmt_ver_no") 		= "";
			     	sheetObj.cellValue2(Row,"sts_evnt_dt") 		= "";

			     	sheetObj.focus();
			     	sheetObj.SelectCell(Row,"eq_no",true);
	     		}

     		// Duplicate 되었을 경우에  메시지를 표시한 후 Row 를 Clear 한다.
     		} else {
     			ComShowCodeMessage('CGM10017','Chassis No.');

     			sheetObj.CellEditable(Row, "del_chk") = true;
				sheetObj.RowFontColor(Row) = sheetObj.RgbColor(0, 0, 0);

     			sheetObj.cellValue2(Row,"eq_no") 			= "";
		     	sheetObj.cellValue2(Row,"eq_tpsz_cd") 		= "";
		     	sheetObj.cellValue2(Row,"agmt_lstm_cd") 	= "";
		     	sheetObj.cellValue2(Row,"sts_evnt_ofc_cd") 	= "";
		     	sheetObj.cellValue2(Row,"sts_evnt_yd_cd") 	= "";
		     	sheetObj.cellValue2(Row,"vndr_seq") 		= "";
		     	sheetObj.cellValue2(Row,"agmt_no") 			= "";
		     	sheetObj.cellValue2(Row,"agmt_ref_no") 		= "";

		     	sheetObj.cellValue2(Row,"aciac_div_cd") 	= "";
		     	sheetObj.cellValue2(Row,"eq_aset_sts_cd") 	= "";
		     	sheetObj.cellValue2(Row,"sts_evnt_loc_cd") 	= "";
		     	sheetObj.cellValue2(Row,"agmt_ofc_cty_cd") 	= "";
		     	sheetObj.cellValue2(Row,"agmt_seq") 		= "";
		     	sheetObj.cellValue2(Row,"agmt_ver_no") 		= "";
		     	sheetObj.cellValue2(Row,"sts_evnt_dt") 		= "";

		     	sheetObj.focus();
		     	sheetObj.SelectCell(Row,"eq_no",true);
     		}
     	}
    }

     /**
 	 * Sheet1 의 OnSaveEnd 이벤트처리 <br>
 	 * @param  {object} sheetObj	필수	 Sheet Object
 	 * @param  {string} ErrMsg		필수 String
 	 * @return 없음
 	 * @version 2009.09.28
 	 */
 	function sheet1_OnSaveEnd(sheetObj, errMsg) {
 		 var formObj = document.form;
 		 if(errMsg =='') {
 			ComShowCodeMessage('CGM00003');

 			// 조회실행
     		formObj.old_agmt_no.value = formObj.new_agmt_no.value;
     		formObj.old_agmt_ref_no.value = formObj.new_agmt_ref_no.value;
     		formObj.old_agmt_lstm_cd.value = formObj.new_agmt_lstm_cd.value;
     		formObj.old_vndr_seq.value = formObj.new_vndr_seq.value;
     		formObj.old_vndr_lgl_eng_nm.value = formObj.new_vndr_lgl_eng_nm.value;

     		formObj.new_agmt_no.value = "";
     		formObj.new_agmt_ref_no.value = "";
     		formObj.new_agmt_lstm_cd.value = "";
     		formObj.new_vndr_seq.value = "";
     		formObj.new_vndr_lgl_eng_nm.value = "";

     		formObj.old_agmt_no.readOnly = false;
     		formObj.old_agmt_no.className = "input";


     		var obj = document.getElementById("btn_Retrieve");
        	obj.fireEvent("onclick");
 		}
 	}


 	 /**
     * Found date 입력시, 현재 날짜/시간 이후를 입력시 오류.
     * "Found Date cannot be later than now."
     * @return
     */
    function processEndCal(){
   	 var form = document.form;
   	 var dt   = ComReplaceStr(form.form_day.value,"-","");
   	 var dt2  = ComReplaceStr(form.sts_evnt_dt.value,"-","");
        if(dt2 > dt){
       	 form.sts_evnt_dt.value = "";
       	 form.sts_evnt_dt.focus();
		 ComShowCodeMessage('CGM10059');
       	 return ;
	    }

    }

    // 업무 자바스크립트 OnFocusOut 이벤트 처리
    function obj_focusout() {
    	switch(event.srcElement.name){
    	case "sts_evnt_dt":
    		 var form = document.form;
	    	 var dt   =   ComReplaceStr(form.form_day.value,"-","");
	    	 var dt2  =   ComReplaceStr(form.sts_evnt_dt.value,"-","");;
	         if(form.sts_evnt_dt.value!="" &&  dt2 > dt){
	        	 form.sts_evnt_dt.value = "";
	        	 form.sts_evnt_dt.focus();
	        	 ComShowCodeMessage('CGM10059');

	        	 return;
	 	    }
	 		break;

    	}
    }

    /**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.GetSearchXml("EES_CGM_1026GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");

		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowCodeMessage("CGM20037");
			ComOpenWait(false);
			sheetObj.WaitImageVisible = true;
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("CGM20038");
			clearInterval(timer1);
		}
	}

	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		ComShowCodeMessage("CGM00003");

		// 조회실행
 		formObj.old_agmt_no.value = formObj.new_agmt_no.value;
 		formObj.old_agmt_ref_no.value = formObj.new_agmt_ref_no.value;
 		formObj.old_agmt_lstm_cd.value = formObj.new_agmt_lstm_cd.value;
 		formObj.old_vndr_seq.value = formObj.new_vndr_seq.value;
 		formObj.old_vndr_lgl_eng_nm.value = formObj.new_vndr_lgl_eng_nm.value;

 		formObj.new_agmt_no.value = "";
 		formObj.new_agmt_ref_no.value = "";
 		formObj.new_agmt_lstm_cd.value = "";
 		formObj.new_vndr_seq.value = "";
 		formObj.new_vndr_lgl_eng_nm.value = "";

 		formObj.old_agmt_no.readOnly = false;
 		formObj.old_agmt_no.className = "input";


 		var obj = document.getElementById("btn_Retrieve");
    	obj.fireEvent("onclick");
	}

	/**
	 * 기능(ex:btn_save)에 권한(trole) 적용  <br>
	 * @param  없음
	 * @return 없음
	 * @author 조재성
	 * @version 2010.03.05
	 */
	 function tRoleApply() {
	  	var formObj = document.form;
	  	if(formObj.trole.value == "Authenticated") {
			//do nothing
	  	}else {
		  	ComBtnDisable("btn_rowadd");
		  	ComBtnDisable("btn_rowdelete");
		  	ComBtnDisable("btn_Save");
	  	}
	 }
	/* 개발자 작업  끝 */