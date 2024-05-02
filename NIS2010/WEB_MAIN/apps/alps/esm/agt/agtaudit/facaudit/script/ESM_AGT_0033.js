// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/*
 * IBSheet Action 추가
 */
var IBRECALCULATE = 20; //re-calculate

/*
 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 */
document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	 var sheetObject = sheetObjects[0];

    	 /*******************************************************/
    	 var formObject = document.form;

//    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;

    			case "btn_new":
    				sheetObject.RemoveAll();
    				formObject.reset();
    				reSetDate();
    				break;

    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;

    			case "btn_downexcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				break;

    			case "btns_calendar1":
    				var cal = new ComCalendar();
    				cal.select(formObject.search_dt_fr, 'yyyy-MM-dd');
    				break;

    			case "btns_calendar2":
    				var cal = new ComCalendar();
    				cal.select(formObject.search_dt_to, 'yyyy-MM-dd');
                    break;

    			case "btn_recalculate":
    				 doActionIBSheet(sheetObject,formObject,IBRECALCULATE);
    				 break;

    		} // end switch
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowCodeMessage("COM12111", "", "", "");
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
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
    		ComConfigSheet(sheetObjects[i]);

    		initSheet(sheetObjects[i],i+1);

    	    //khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}

    	// S/A Date Unit 날짜 세팅	
    	var formObj = document.form;
    	var today = ComGetNowInfo();
    	var frday = ComGetDateAdd(null, "D", -15);
    	formObj.search_dt_fr.value = frday;
    	formObj.search_dt_to.value = today;
    	formObj.ar_ofc_cd.focus();

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
    				style.height = GetSheetHeight(14) ;
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    			   //전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(2, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(42, 4 , 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, true, true, false,false) ;

    				var HeadTitle = "STS|Calc.\nCHK|SEQ|CA\nSEQ|Freight\nForwarder|Name|BL NO.|BKG NO.|BKG STS|ETD|BL AMT|Curr|Freight Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|Prev AMT|AMT DIFF|Reason|Status|Remarks|AR IF DT";
    				var HeadTitle1 = "STS|Calc.\nCHK|SEQ|CA\nSEQ|Freight\nForwarder|Name|BL NO.|BKG NO.|BKG STS|ETD|BL AMT|Curr|Commission|Box(CNT/AMT)|Box(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|RTEU(CNT/AMT)|RTEU(CNT/AMT)|RFEU(CNT/AMT)|RFEU(CNT/AMT)|Commission|Prev AMT|AMT DIFF|Reason|Status|Remarks|AR IF DT";

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				InitHeadRow(1, HeadTitle1, true);

    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,                 KEYFIELD,    CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				//InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,   true,    "checkDel",            false,          "",       dfNone,   		0,     true,        false,     -1,      false,       true,      "",     false);
    				InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,   true,    "ibflag",              false,          "",       dfNone,   		0,     false,       false);
    				InitDataProperty(0, cnt++ , dtCheckBox,   45,    daCenter,   true,    "check",               false,          "",       dfNone,          0,     true,        true);
    				InitDataProperty(0, cnt++ , dtSeq,        40,    daCenter,   true,    "seq",                 false,          "",       dfNone,          0,     true,        false);
    				InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   true,    "fac_seq",             false,          "",       dfNone,          0,     false,        false);
    				InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "frt_fwrd_cnt_seq",    false,          "",       dfNone,          0,     false,       false,       8);
    				InitDataProperty(0, cnt++ , dtData,      120,    daLeft,     true,    "cust_lgl_eng_nm",     false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   true,    "bl_no",               false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   true,    "bkg_no",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "bkg_sts_cd",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "vsl_dep_dt",          false,          "",       dfDateYmd,       0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "bl_comm_amt",         false,          "",       dfFloat,         2,     false,        false);

                    // 2009-04-15 (kevin) CURR_CD 추가
    				InitDataProperty(0, cnt++ , dtData,       45,    daCenter,   true,    "curr_cd",             false,          "",       dfNone,          0,     false,       false);

    				InitDataProperty(0, cnt++ , dtData,      100,    daRight,    true,    "act_comm_amt",        false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_bx_qty",          false,          "",       dfFloat,         1,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "fac_bx_rt",           false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_teu_qty",         false,          "",       dfFloat,         1,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "fac_teu_rt",          false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_feu_qty",         false,          "",       dfFloat,         1,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "fac_feu_rt",          false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_rf_teu_qty",      false,          "",       dfFloat,         1,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "fac_rf_teu_rt",       false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_rf_feu_qty",      false,          "",       dfFloat,         1,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "fac_rf_feu_rt",       false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       80,    daRight,    true,    "cntr_comm_amt",       false,          "",       dfFloat,         2,     true,        false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "act_pre_comm_amt",    false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     60,    daRight,    true,    "act_if_comm_amt",     false,          "",       dfFloat,         2,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,    240,    daLeft,     true,    "fac_rmk",             false,          "",       dfNone,          0,     true,        false);
    				InitDataProperty(0, cnt++ , dtData,       45,    daCenter,   true,    "comm_proc_sts_cd",    false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,      350,    daLeft,     true,    "comm_proc_rslt_rsn",  false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "fac_if_dt",           false,          "",       dfDateYmd,       0,     false,       false);

    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "sls_ofc_cd",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "bkg_sts_cd",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "bkg_no_split",        false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "fac_ofc_cd",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_cnt_cd",         false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_cust_seq",       false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_rt_seq",         false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "fac_div_cd",          false,          "",       dfNone,          0,     false,       false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "fac_div_cd_1",        false,          "",       dfNone,          0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "old_act_comm_amt",    false,          "",       dfFloat,         2,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "fac_if_usr_id",       false,          "",       dfNone,          0,     false,       false);
				    InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "fac_if_dt_1",         false,          "",       dfNone,          0,     false,       false);

                    InitDataValid(0, "frt_fwrd_cnt_seq", vtEngUpOther, "0123456789*");	// 영대문자, 숫자만 입력되도록 설정

    				RangeBackColor(1,11,1,22) = RgbColor(222, 251, 248);   // ENIS
    				HeadRowHeight = 20 ;
    				HeadRowHeight = 21;
    			}
    			break;

    	}
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:		//조회
    			if(!validateForm(sheetObj,formObj,sAction)) {
    			    return false;
    			}

            	if(formObj.bl_no.value.trim().length > 0){
            		setBlNoRetrieve(formObj.bl_no);
            	}
 
                formObj.f_cmd.value = SEARCH;
                selectVal = agtQryStr(formObj);
                
                sheetObj.DoSearch4Post("ESM_AGT_0033GS.do", selectVal);
                break;

           case IBSAVE:        //저장
                checkSaveData(sheetObj, sAction);
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESM_AGT_0033GS.do", agtQryStr(formObj));
                break;

           case IBRECALCULATE:	//re-calculate
                formObj.f_cmd.value = SEARCH01;
                var cnt = sheetObj.CheckedRows("check");
                //1,000건이상 실행금지 체크
				if(cnt > 1000){
					//Please select **.
		    		ComShowCodeMessage("COM12113", "Under 1,000 B/Ls at a time when you re-calculate.", "", "");
					return false;
				}

				if( cnt > 0 ) {
                    if(ComShowCodeConfirm("AGT10023", "Re-calculate "+ cnt, "re-calculate?", "") == 1) {
//            			alert("  처리중입니다....         ");
                        sheetObj.DoSave("ESM_AGT_0033GS.do", agtQryStr(formObj), "check", false);
                    }
                } else {
                    ComShowCodeMessage("AGT10022", "re-calculate.", "", "");
                }
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                sheetObj.SpeedDown2Excel(-1);
                break;
            

        }
    }

    /**
     * Grid에서 OnDblClick Event 처리
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {

        var saveNm = sheetObj.ColSaveName(Col);

        if( saveNm != "bl_comm_amt" && saveNm != "act_comm_amt" && saveNm != "cntr_comm_amt" && saveNm != "fac_rmk") {
            var bl_no = sheetObj.CellValue(Row, "bl_no");
            var bkg_no = sheetObj.CellValue(Row, "bkg_no");
            var fac_ofc_cd = sheetObj.CellValue(Row, "fac_ofc_cd");
            var agmt_cnt_cd = sheetObj.CellValue(Row, "agmt_cnt_cd");
            var agmt_cust_seq = sheetObj.CellValue(Row, "agmt_cust_seq");
            var agmt_rt_seq = sheetObj.CellValue(Row, "agmt_rt_seq");

            var str = "agt_win_15";
        	var width = 905;
        	var height = 600;
        	//var func = "";
            //var display = "0,0,1";
            var url = "ESM_AGT_0015.do";

            url += "?bl_no="+bl_no + "&bkg_no="+bkg_no + "&fac_ofc_cd="+fac_ofc_cd + "&agmt_cnt_cd="+agmt_cnt_cd + "&agmt_cust_seq="+agmt_cust_seq + "&agmt_rt_seq="+agmt_rt_seq+"&sheet=4";

            ComOpenWindowCenter(url, str, width, height, "N");
        	//comPopupInSheet(url, width, height, func, display, Row, Col, false, false);
        }
    }

    /**
     * Grid에서 OnPopupClick Event 처리
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {

    	if ( sheetObj.ColSaveName(Col) == "frt_fwrd_cnt_seq" ) {

    	    var cust_cd = "";
    		var width = 775;
    		var height = 482;
    		var func = "sheet1_setFFCntSeq";
            var display = "1,0,1";
            var url = "COM_ENS_041.do";

    		comPopupInSheet(url, width, height, func, display, Row, Col, true, false);

    	}
    }

    /**
     * Grid에서 OnChange Event 처리
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {

       var form1 = document.hiddenF;

       with(sheetObj) {
/*
           if( ColSaveName(Col) == "frt_fwrd_cnt_seq" ) {

               Value = Value.trim();

               if( checkCustomer(Value) == true ) {

                   var seq = Value.substring(2);

                   if( seq == 999999 ) {
                       CellValue2(Row, Col+1) = "REP. CUSTOMER";
                   } else {
                       form1.f_cmd.value = SEARCH01;
                       form1.cust_cd.value = Value;
                       form1.sheetId.value = sheetObj.id;
                       form1.row.value = Row;
                       form1.colNm1.value = ColSaveName(Col);
                       form1.colNm2.value = ColSaveName(Col+1);
                       form1.target = "frmHidden";
                       form1.action = "ESM_AGT_CHKCUST.do";
                       form1.submit();

                       //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                   }
               } else {
    			   CellValue(Row, Col) = "";
    			   CellValue(Row, Col+1) = "";
                   SelectCell(Row, Col);
               }
           }
*/
           if( ColSaveName(Col) == "bl_comm_amt" || ColSaveName(Col) == "act_comm_amt" || ColSaveName(Col) == "cntr_comm_amt" ) {

               var fComm_amt = 0;
               var fAct_pre_comm_amt = 0;
               var fAct_if_comm_amt = 0;
               var fOld_act_comm_amt = 0;

               var act_pre_comm_amt = CellValue(Row, "act_pre_comm_amt").trim();
               var act_if_comm_amt = CellValue(Row, "act_if_comm_amt").trim();
               var old_act_comm_amt = CellValue(Row, "old_act_comm_amt").trim();

               if(trim(Value) != "") {
                   fComm_amt = parseFloat(trim(Value));
               }
               if(act_pre_comm_amt != "") {
                   fAct_pre_comm_amt = parseFloat(act_pre_comm_amt);
               }
               if(old_act_comm_amt != "") {
                   fOld_act_comm_amt = parseFloat(old_act_comm_amt);
               }

               if(fComm_amt == 0) {
                    if( ColSaveName(Col) == "bl_comm_amt" ) {
                        ComShowCodeMessage("AGT10032", "", "", "");
                    } else {
    			        ComShowCodeMessage("AGT10031", "", "", "");
                    }
                    SelectCell(Row, Col);
                    return false;
               }

               fAct_if_comm_amt = fComm_amt - fAct_pre_comm_amt

               if( fComm_amt != fOld_act_comm_amt ) {
                   CellValue2(Row, "act_pre_comm_amt") = fOld_act_comm_amt;
                   CellValue2(Row, "act_if_comm_amt") = fAct_if_comm_amt;
               } else {
                   ReturnCellData(Row, "act_pre_comm_amt");
                   ReturnCellData(Row, "act_if_comm_amt");
               }
           }
        }
    }

    /**
     * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
     */
    function sheet1_setFFCntSeq(rowArray, row, col) {
        var sheetObj = sheetObjects[0];

    	var colArray = rowArray[0];

    	var cnt_cd = colArray[3].substring(0, 2);
    	var cust_seq = colArray[3].substring(2);

     	sheetObj.CellValue2(row, col) = cnt_cd + fullZero(cust_seq, 6);
    	sheetObj.CellValue(row, col+1) = colArray[4];
    }

    /**
     * 저장/re_calculate 버튼 클릭시 유효성검증 프로세스 처리
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {

        var f_cmd = document.form.f_cmd.value;

        if( f_cmd == MULTI ) {

            var fValue = 0;
            Value = Value.trim();

        	with(sheetObj) {

        	    var ibStatus = RowStatus(Row);

                if( ibStatus.toUpperCase() == "U" ) {
/*
            	    if ( ColSaveName(Col) == "frt_fwrd_cnt_seq" ) {
                        if (Value == "") {
                            ComShowCodeMessage("AGT10001", "F/Forwarder", "", "");
                            ValidateFail = true;
                            SelectCell(Row, Col);
                        } else {
                            if( checkCustomer(Value) == false ) {
                			    ComShowCodeMessage("AGT10017", "F/Forwarder", "", "");
                			    ValidateFail = true;
                                SelectCell(Row, Col);
                            }
                        }
            	    }
*/
            	    if( ColSaveName(Col) == "bl_comm_amt" ) { // 혹시 모르므로 다시 한 번 체크
            	        var fac_div_cd = CellValue(Row, "fac_div_cd");
            	        if(Value != "") {
            	            fValue = parseFloat(Value);
            	        }

        	            if(fac_div_cd == "BL") {
        	                if(fValue == 0) {
                			    ComShowCodeMessage("AGT10032", "", "", "");
                			    ValidateFail = true;
                                SelectCell(Row, Col);
        	                }
        	            }

            	    } else if( ColSaveName(Col) == "act_comm_amt" ) { // 혹시 모르므로 다시 한 번 체크
            	        var fac_div_cd = CellValue(Row, "fac_div_cd");
            	        var fac_div_cd_1 = CellValue(Row, "fac_div_cd_1");
            	        if(Value != "") {
            	            fValue = parseFloat(Value);
            	        }

        	            if(fac_div_cd_1 == "B" && fac_div_cd != "BL") {
        	                if(fValue == 0) {
                			    ComShowCodeMessage("AGT10031", "", "", "");
                			    ValidateFail = true;
                                SelectCell(Row, Col);
        	                }
        	            }

            	    } else if( ColSaveName(Col) == "cntr_comm_amt" ) { // 혹시 모르므로 다시 한 번 체크
            	        var fac_div_cd_1 = CellValue(Row, "fac_div_cd_1");
            	        if(Value != "") {
            	            fValue = parseFloat(Value);
            	        }

        	            if(fac_div_cd_1 == "C") {
        	                if(fValue == 0) {
                			    ComShowCodeMessage("AGT10031", "", "", "");
                			    ValidateFail = true;
                                SelectCell(Row, Col);
        	                }
        	            }
            	    } else if( ColSaveName(Col) == "fac_rmk" ) {
                        if (Value == "") {
                            ComShowCodeMessage("AGT10001", "Reason", "", "");
                            ValidateFail = true;
                            SelectCell(Row, Col);
                        }
            	    }
                }
        	}
        }
    }

    /**
     * Office 선택시 처리
     */
    function rdoOfficeOpt_onClick(obj) {

        var val = obj.value;

        if( obj.checked == true ) {
            if( val == "A" ) {
                document.all.div_sub_ofc.style.display = "none";
                document.all.div_ar_ofc.style.display = "block";

                // AR Office로 초기화
                document.form.ar_ofc_cd.value = document.form.arOfcCd.value;

                var idx = document.form.ar_ofc_cd.selectedIndex;

                // AR Office에 일치하는 값이 없을 경우 첫번째 Index로 선택되게 한다.
                if( !(idx >= 0) ) {
                    document.form.ar_ofc_cd.selectedIndex = 0;
                }
            } else {
                document.all.div_ar_ofc.style.display = "none";
                document.all.div_sub_ofc.style.display = "block";

                // AR Office로 초기화
                document.form.agn_cd.value = document.form.arOfcCd.value;

                var idx = document.form.agn_cd.selectedIndex;

                // Sales Office에 일치하는 값이 없을 경우 첫번째 Index로 선택되게 한다.
                if( !(idx >= 0) ) {
                    document.form.agn_cd.selectedIndex = 0;
                }
            }
        }
    }

    /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){

        var ofcObj;
        var formObj = document.form;

        if( formObj.ofc_option[0].checked == true ) {
            ofcObj = formObj.ar_ofc_cd;
        } else {
            ofcObj = formObj.agn_cd;
        }

        formObj.bl_no.value= formObj.bl_no.value.trim().toUpperCase();
        formObj.bl_nos.value = formObj.bl_nos.value.trim().toUpperCase();
        formObj.vvd.value= formObj.vvd.value.trim().toUpperCase();
        formObj.ff_cnt_cd.value = formObj.ff_cnt_cd.value.trim().toUpperCase();

        var ofcCd = ofcObj.value.trim();
        var bl_no = formObj.bl_no.value;
        var bl_nos = formObj.bl_nos.value;
        var ff_cnt_seq = formObj.ff_cnt_cd.value.trim();
        var ff_cust_seq = "";

        if( ofcCd == "" ) {
    		    ComShowCodeMessage("COM12113", "Office", "", "");
    		    ofcObj.focus();
    			return false;
        } else {
            formObj.agn_cd.value = ofcCd;
        }

        if(bl_nos.length > 0 || bl_no.length > 0) {

            if(bl_no.length > 0) {
                if(bl_nos.length > 0) {
                    formObj.bl_nos.value = bl_nos + "," + bl_no;
                } else {
                    formObj.bl_nos.value = bl_no;
                }
            } else {
                formObj.bl_nos.value = bl_nos;
            }

            formObj.bl_no.value = "";

            if(formObj.bl_nos.value.length > 0) {
                //formObj.search_dt_fr.value = "";
                //formObj.search_dt_to.value = "";
            }
        }

        var selFromDt = formObj.search_dt_fr.value.trim();
        var selToDt = formObj.search_dt_to.value.trim();

        if( formObj.bl_nos.value == "" ) {
    		if ( selFromDt == "" ) {
    		    ComShowCodeMessage("AGT10009", "", "", "");
    		    formObj.search_dt_fr.focus();
    			return false;
    		}
    		if ( selToDt == "" ) {
    		    ComShowCodeMessage("AGT10009", "", "", "");
    		    formObj.selToDt.focus();
    			return false;
    		}
        }

	    if ( ff_cnt_seq.length > 2 ) {

            ff_cust_seq = ff_cnt_seq.substring(2, ff_cnt_seq.length);

            if(isNumber2(ff_cust_seq) == false) {
			    ComShowCodeMessage("AGT10017", "F/Forwarder", "", "");
			    formObj.ff_cnt_cd.focus();
				return false;
			}
	    }

    	return true;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    	   // if(!ComChkValid()) return false;
    	}

    	return true;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function checkSaveData(sheetObj, sAction){
        if( sAction == IBSAVE ) {
            with(sheetObj) {
                for(var i=2; i<Rows; i++) {
                    if(CellValue(i, "check") == 1) {
                        ReturnCellData(i, "check");
                    }
                }
            }
        }
    }

	/**
	 * Office 조회 팝업 열기
	 */
	function openWindowOffice(formObj) {
		var url = "COM_ENS_071.do";
		var width = 775;
		var height = 460;
		var func = "setOfficeCd";
		var display = "1,0,1";
		comPopup(url, width, height, func, display, true, false);
	}

	/**
	 * Office 조회 후 값 Return 받아 셋팅한다.
	 */
	function setOfficeCd(rowArray, row, col) {
		var colArray = rowArray[0];

		document.form.selOfficeCd.value = colArray[3];
	}

    /**
     * F.Forwarder 조회 팝업 열기
     */
    function openWindowCustomer(formObj) {
    	//var cust_cd = "US"; // Default 셋팅
    	var url = "COM_ENS_041.do";
    	var width = 775;
    	var height = 484;
    	var func = "setForwarder";
    	var display = "1,0,1,1,1,1,1,1";
    	//url = url + "?cust_cd="+cust_cd;
    	//comPopup(url, width, height, func, display, bModal, b2ndSheet);
    	ComOpenPopup(url, width, height, func, display, true, false);
    }

    /**
     * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
     */
    function setForwarder(rowArray, row, col) {
    	var colArray = rowArray[0];

    	document.form.ff_cnt_cd.value = colArray[3];
    }

    /**
     * 사용자가 입력한 BL NO를 셋팅한다.
     */
    function setBlNo(obj) {
        var form = document.form;
        var bl_no = obj.value.trim().toUpperCase();
        var bl_no_list = form.bl_nos.value.trim().toUpperCase();

        if (window.event.keyCode==13) {
            if(bl_no.length > 0) {

                if(bl_no_list.length > 0) {
                    form.bl_nos.value = bl_no_list + "," + bl_no;
                } else {
                    form.bl_nos.value = bl_no;
                }

                obj.value = "";

                if(form.bl_nos.value.trim().length > 0) {
                    //form.search_dt_fr.value = "";
                    //form.search_dt_to.value = "";
                }
            }
        }
    }
     /**
      * 사용자가 Retrieve 클릭시 BL NO를 셋팅 후 조회.
      */
     function setBlNoRetrieve(obj) {
         var form = document.form;
         var bl_no = obj.value.trim().toUpperCase();
         var bl_no_list = form.bl_nos.value.trim().toUpperCase();

             if(bl_no_list.length > 0) {
                 form.bl_nos.value = bl_no_list + "," + bl_no;
             } else {
                 form.bl_nos.value = bl_no;
             }

             obj.value = "";
     }

    /**
     * BL NO가 입력이 되면 Date를 삭제해 준다.
     */
    function setDateEmpty() {

        var form = document.form;
        var bl_no_list = form.bl_nos.value.trim().toUpperCase();

        if(bl_no_list.length > 0) {
        //    form.search_dt_fr.value = "";
        //    form.search_dt_to.value = "";
        }
    }

    /**
     * 날짜를 현재 날짜로 ReSet 한다.
     */
    function reSetDate() {
        form.search_dt_fr.value = fromDate;
        form.search_dt_to.value = toDate;
    }
     /**
      * 사용자가 입력한 BL NO를 셋팅한다.
      */
     function setBlNos(obj) {
          var form = document.form;
          form.bl_nos.value = obj.value.trim().toUpperCase();
      }
