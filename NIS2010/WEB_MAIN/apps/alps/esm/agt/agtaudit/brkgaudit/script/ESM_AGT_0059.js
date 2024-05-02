// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var prefix1 = "t1sheet1_";
var multi_vvd = "";

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
    	 var sheetObject = sheetObjects[1];
    	var sheetObj1 = sheetObjects[0];

    	 /*******************************************************/
    	 var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		// B/L No. sheet입력란이 활성화 된 경우 비활성화로....
    		// vvd_sheet
    		if (srcName != "tb1_btn_input_vvd_no") {
    			if (srcName != "s_vvd") {
    				setVvdNo(sheetObj1, 3);

    			}
    		}

    		switch(srcName) {

    			case "btn_retrieve":
    				setMultiVvd(sheetObj1);
    				doActionIBSheet(sheetObject,formObj,IBSEARCH);
    				multi_vvd = "";
    				break;

    			case "btn_new":
    				sheetObject.RemoveAll();
    				formObj.reset();
    				sheetObj1.RemoveAll();
    				initSheet(sheetObjects[0],0);
    				reSetDate();
    				break;

    			case "btn_save":
    				doActionIBSheet(sheetObject,formObj,IBSAVE);
    				break;

    			case "btn_recalculate":
    				 doActionIBSheet(sheetObject,formObj,IBRECALCULATE);
    				 break;

    			case "btn_downexcel":
    				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
    				break;

                case "btn_cal_fr":
                	var cal = new ComCalendar();
    				 cal.select(formObj.search_dt_fr, 'yyyy-MM-dd');
                    break;

                case "btn_cal_to":
                	var cal = new ComCalendar();
                    cal.select(formObj.search_dt_to, 'yyyy-MM-dd');
                    break;
                
    			case "tb1_btn_input_vvd_no": // B/L No.				
    				if (document.getElementById("vvd_input").style.display == "block") {
    					setVvdNo(sheetObj1, 1);
    				} else {
    					setVvdNo(sheetObj1, 2);
    				}
    				break;	    

    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111", "", "", "");
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
    		ComConfigSheet(sheetObjects[i]);

    		initSheet(sheetObjects[i],i+1);

    	    //khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}

        // S/A Date Unit 날짜 세팅
        var formObj = document.form;
        today = ComGetNowInfo();
        frday = ComGetDateAdd(today, "D", -15);
        formObj.search_dt_fr.value = frday;
        formObj.search_dt_to.value = today;

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
    				style.height = GetSheetHeight(15) ;
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    			   //전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 2, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(40, 4, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				//InitHeadMode(true, true, true, true, false, false) ;
    				InitHeadMode(true, true, true, true, false, false) ;

    				var HeadTitle = "Del.|STS|Calc.\nCHK|PAY\nCHK|SEQ|CA\nSEQ|AGMT\nCustomer|Vendor|F.F Name|BL NO.|BKG NO.|BKG STS|ETD|CRE DT|FMC|REF No.|Freight Status|Freight Status|Freight Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|Prev AMT|CA DIFF|Status|Remarks|AP IF DT";
    				var HeadTitle1 = "Del.|STS|Calc.\nCHK|PAY\nCHK|SEQ|CA\nSEQ|AGMT\nCustomer|Vendor|F.F Name|BL NO.|BKG NO.|BKG STS|ETD|CRE DT|FMC|REF No.|Commissionable|Rate|Commission|Box(CNT/AMT)|Box(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|REU(CNT/AMT)|REU(CNT/AMT)|RTEU(CNT/AMT)|RTEU(CNT/AMT)|RFEU(CNT/AMT)|RFEU(CNT/AMT)|Commission|Prev AMT|CA DIFF|Status|Remarks|AP IF DT";

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				InitHeadRow(1, HeadTitle1, true);

    				//데이터속성    [ROW, COL,  DATATYPE,      WIDTH, DATAALIGN,  COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,   true,    "checkDel",            false,         "",        dfNone,          0,     true,       false,    -1,       false,      true,      "",     false);
    				InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,   true,    "ibflag",              false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtHidden,   45,    daCenter,   true,    "check",               false,          "",       dfNone,          0,     true,       true);
    				InitDataProperty(0, cnt++ , dtCheckBox,   45,    daCenter,   true,    "pay_chk",               false,          "",       dfNone,          0,     true,       true);
    				InitDataProperty(0, cnt++ , dtSeq,        40,    daCenter,   true,    "seq",                 false,         "",        dfNone,          0,     true,       false);
    				InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   true,    "cmpn_seq",            false,         "",        dfNone,          0,     true,       false);
    				InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "frt_fwrd_cnt_seq",    false,          "",       dfNone,          0,     true,       false,       8);
    				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "vndr_cnt_seq",        false,          "",       dfNone,          0,     true,       false,       6);
    				InitDataProperty(0, cnt++ , dtData,      120,    daLeft,     true,    "cust_lgl_eng_nm",     false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   true,    "bl_no",               false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   true,    "bkg_no",          false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "bkg_sts_cd",          false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "vsl_dep_dt",          false,          "",       dfDateYmd,       0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "cre_dt",              false,          "",       dfDateYmd,       0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   true,    "fmc_no",              false,          "",       dfNone,          0,     true,       false,      10);
    				InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   true,    "cmpn_ref_no",         false,          "",       dfNone,          0,     true,       false);
    				InitDataProperty(0, cnt++ , dtData,      100,    daRight,    true,    "act_comm_able",       false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "cmpn_bkg_rt",         false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       80,    daRight,    true,    "act_comm_amt",        false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_bx_qty",          false,          "",       dfFloat,         1,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "cmpn_bx_rt",          false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_teu_qty",         false,          "",       dfFloat,         1,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "cmpn_teu_rt",         false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_feu_qty",         false,          "",       dfFloat,         1,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "cmpn_feu_rt",         false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtHidden,       50,    daRight,    true,    "bkg_rf_qty",          false,          "",       dfFloat,         1,     false,      false);
    				InitDataProperty(0, cnt++ , dtHidden,       50,    daRight,    true,    "cmpn_rf_rt",          false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_rf_teu_qty",      false,          "",       dfFloat,         1,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "cmpn_rf_teu_rt",      false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_rf_feu_qty",      false,          "",       dfFloat,         1,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "cmpn_rf_feu_rt",      false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       80,    daRight,    true,    "cntr_comm_amt",       false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "act_pre_comm_amt",    false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       60,    daRight,    true,    "act_if_comm_amt",     false,          "",       dfFloat,         2,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       45,    daCenter,   true,    "comm_proc_sts_cd",    false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,      350,    daLeft,     true,    "comm_proc_rslt_rsn",  false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "cmpn_if_dt",          false,          "",       dfDateYmd,       0,     false,      false);

    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_cnt_cd",         false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_cust_seq",       false,          "",       dfNone,          0,     false,      false);
    				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   true,    "agmt_rt_seq",         false,          "",       dfNone,          0,     false,      false);

                    InitDataValid(0, "frt_fwrd_cnt_seq", vtEngUpOther, "0123456789*");	// 영대문자, 숫자만 입력되도록 설정
                    InitDataValid(0, "vndr_cnt_seq", vtNumericOnly);	// 숫자만 입력되도록 설정
                    InitDataValid(0, "fmc_no", vtEngUpOther, "0123456789* ");	// 영대문자, 숫자만 입력되도록 설정
                    //InitDataValid(0, "vndr_cnt_seq", vtEngUpOther, "0123456789");	// 영대문자, 숫자만 입력되도록 설정

    				RangeBackColor(1,14,1,25) = RgbColor(222, 251, 248);   // ENIS
    				HeadRowHeight = 20 ;
    				HeadRowHeight = 21;

    			}
    			break;
    			
    		case "t1sheet1":
    			with (sheetObj) {

    				// 높이 설정
    				style.height = 150;
    				// 전체 너비 설정
    				SheetWidth = 150;//mainTable1.clientWidth;

    				// Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "")
    					InitHostInfo(location.hostname, location.port, page_path);

    				// 전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    				// 전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

    				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 2, 100);

    				var HeadTitle1 = " |vvd_no|vvd_combo";
    				var headCount = ComCountHeadTitle(HeadTitle1);

    				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false, false);

    				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);

    				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
    				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
    				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
    				// SAVESTATUS, FORMATFIX]

    				InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, prefix1 + "ibflag", false, "", dfNone, 0, true, true, 19);
    				InitDataProperty(0, cnt++, dtData, 80, daLeft, true, prefix1 + "vvd_no", false, "", dfEngUpKey, 0, true, true, 19);
    				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, prefix1 + "vvd_combo", false, "", dfNone, 0, true, true);

    				CountPosition = 0;

    			}
    			var formObject = document.form;

    			// row 50개 생성 후
    			// input_vvd_no.value 값을 초기 Row에 설정 후
    			// 타이틀 제거

    			for ( var i = 1; i <= 50; i++) {
    				//
    				sheetObj.DataInsert(-1);
    				sheetObj.CellValue(i, prefix1 + "ibflag") = "R";
    			}
    			
    			//alert(formObject.s_vvd.value);
    			sheetObj.CellValue2(1, prefix1 + "vvd_no") = formObject.s_vvd.value;
    			formObject.s_vvd.value = sheetObj.CellValue(1, prefix1 + "vvd_no");
    			sheetObj.SelectCell(1, prefix1 + "vvd_no");

    			sheetObj.RowHidden(0) = true;

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
    			//chkbl_no();
    			if(formObj.bl_no.value.trim().length > 0){
            		setBlNoRetrieve(formObj.bl_no);
            	}
    			
    			formObj.multi_vvd.value = multi_vvd;
    			//alert("multi_vvd"+multi_vvd);
                formObj.f_cmd.value = SEARCH;
                selectVal = agtQryStr(formObj);
                sheetObj.DoSearch4Post("ESM_AGT_0059GS.do", selectVal);
                break;

           case IBSAVE:        //저장
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESM_AGT_0059GS.do", agtQryStr(formObj));
                break;

           case IBRECALCULATE:	//re-calculate
                formObj.f_cmd.value = REPLY;
                var cnt = sheetObj.CheckedRows("check");
                //200건이상 실행금지 체크
				if(cnt > 200){
					//Please select **.
		    		ComShowCodeMessage("COM12113", "under 200 B/Ls at a time when you re-calculate.", "", "");
					return false;
				}

                if( cnt > 0 ) {
                    if(ComShowCodeConfirm("AGT10023", "Re-calculate "+ cnt, "re-calculate?", "") == 1) {
//            			alert("  처리중입니다....         ");
                        sheetObj.DoSave("ESM_AGT_0059GS.do", agtQryStr(formObj), "check", false);
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
    /*
    function sheet1_OnDblClick(sheetObj, Row, Col) {

        if(sheetObj.ColSaveName(Col) != "frt_fwrd_cnt_seq" && sheetObj.ColSaveName(Col) != "vndr_cnt_seq" && sheetObj.ColSaveName(Col) != "fmc_no") {
            var bl_no = sheetObj.CellValue(Row, "bl_no");
            var bkg_no = sheetObj.CellValue(Row, "bkg_no");
            var agmt_cnt_cd = sheetObj.CellValue(Row, "agmt_cnt_cd");
            var agmt_cust_seq = sheetObj.CellValue(Row, "agmt_cust_seq");
            var agmt_rt_seq = sheetObj.CellValue(Row, "agmt_rt_seq");

            var str = "agt_win_14";
        	var width = 900;
        	var height = 640;
        	//var func = "";
            //var display = "0,0,1";
            var url = "ESM_AGT_0014.do";

            url += "?bl_no="+bl_no + "&bkg_no="+bkg_no + "&agmt_cnt_cd="+agmt_cnt_cd + "&agmt_cust_seq="+agmt_cust_seq + "&agmt_rt_seq="+agmt_rt_seq +"&sheet=4";

            //ComOpenWindowCenter(url, str, width, height, "N");
            ComOpenWindow(url, str, "resizable=yes,width=900,height=640");
            
        	//comPopupInSheet(url, width, height, func, display, Row, Col, false, false);
        }
    }
	*/
    /**
     * Grid에서 OnPopupClick Event 처리
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {

    	if ( sheetObj.ColSaveName(Col) == "frt_fwrd_cnt_seq" ) {
    	    var cust_cd = "";
    		var width = 775;
    		var height = 482;
    		var func = "sheet1_setFFCntSeq";
            var display ='1,0,1,1,1,1,1,1';
            var url = "COM_ENS_041.do";
            ComOpenPopup(url, width, height, func, display, true, false, Row, Col, 0);
            
    	}
    }

    /**
     * Grid에서 OnChange Event 처리
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {

       var form1 = document.hiddenF;

       with(sheetObj) {
           if( ColSaveName(Col) == "frt_fwrd_cnt_seq" ) {

               Value = Value.trim();

               if( checkCustomer(Value) == true ) {

                   var seq = Value.substring(2);

                   if( seq == 999999 ) {
                       //CellValue2(Row, Col+2) = "REP. CUSTOMER";
                       CellValue2(Row, Col+2) = "";
                   } else {
                       form1.f_cmd.value = SEARCH01;
                       form1.cust_cd.value = Value;
                       form1.sheetId.value = sheetObj.id;
                       form1.row.value = Row;
                       form1.colNm1.value = ColSaveName(Col);
                       form1.colNm2.value = ColSaveName(Col+2);
                       form1.target = "frmHidden";
                       form1.action = "ESM_AGT_CHKCUST.do";
                       form1.submit();

                       //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                   }
               } else {
    			   CellValue2(Row, Col) = "";
    			   CellValue2(Row, Col+2) = "";
                   SelectCell(Row, Col);
               }
               /*
               if( Value != "" && (Value != "*000000" || Value != "*0") ) {

                   if( checkCustomer(Value) == true ) {
                       form1.f_cmd.value = SEARCH01;
                       form1.cust_cd.value = Value;
                       form1.sheetId.value = sheetObj.id;
                       form1.row.value = Row;
                       form1.colNm1.value = ColSaveName(Col);
                       form1.colNm2.value = ColSaveName(Col+2);
                       form1.target = "frmHidden";
                       form1.action = "ESM_AGT_CHKCUST.do";
                       form1.submit();

                       //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                   } else {
        			   CellValue2(Row, Col) = "";
        			   CellValue2(Row, Col+2) = "";
                       SelectCell(Row, Col);
                   }

               } else {
                   CellValue2(Row, Col) = "";
                   CellValue2(Row, Col+2) = "";
                   SelectCell(Row, Col);
               }
               */
           }
           /*
            if( ColSaveName(Col) == "checkDel"
                || ColSaveName(Col) == "frt_fwrd_cnt_seq"
                || ColSaveName(Col) == "vndr_cnt_seq" )
            {
                ReturnCellData(Row, "check");
            }
            */
        }
    }

    /**
     * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
     */
    function sheet1_setFFCntSeq(rowArray, row, col, sheetIdx) {
    	 
        var sheetObj = sheetObjects[0];
    	var colArray = rowArray[0];
    	
    	var cnt_cd = colArray[3].substring(0, 2);
    	var cust_seq = colArray[3].substring(2);
    	
     	sheetObj.CellValue2(row, col) = cnt_cd + ComLpad(cust_seq,   6, "0");
    	sheetObj.CellValue2(row, parseInt(col)+2) = colArray[4];

    }
     
    function sheet1_OnSearchEnd(sheetObj,errMsg){
    	if(sheetObj.RowCount > 0){
	    	for(var i=1;i<= sheetObj.RowCount+1;i++){
	    		if(sheetObj.CellValue(i, "comm_proc_sts_cd") == "CE"){
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
	    		}else if(sheetObj.CellValue(i, "comm_proc_sts_cd") == "CM"){
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 255);
	    		}
	    	}
    	}
   		if(errMsg!=null){
   			ComShowMessage(errMsg);
   		}

   	}
    function sheet1_OnSaveEnd(sheetObj,errMsg){
    	if(sheetObj.RowCount > 0){
	    	for(var i=1;i<= sheetObj.RowCount+1;i++){
	    		if(sheetObj.CellValue(i, "comm_proc_sts_cd") == "CE"){
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
	    		}else if(sheetObj.CellValue(i, "comm_proc_sts_cd") == "CM"){
	    			sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 255);
	    		}
	    	}
    	}
   		if(errMsg!=null){
   			ComShowMessage(errMsg);
   		}

   	}
    /**
     * 저장/re_calculate 버튼 클릭시 유효성검증 프로세스 처리
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {

        var f_cmd = document.form.f_cmd.value;
        Value = Value.trim();

        if( f_cmd == MULTI ) {

        	with(sheetObj) {

                if( RowStatus(Row).toUpperCase() == "U" ) {

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
            	    } else if ( ColSaveName(Col) == "vndr_cnt_seq" ) {
                        if (Value == "") {
                            ComShowCodeMessage("AGT10001", "Vendor", "", "");
                            ValidateFail = true;
                            SelectCell(Row, Col);
                        }
            	    } else if ( ColSaveName(Col) == "fmc_no" ) {
                        //ValidateFail = true;
                        SelectCell(Row, Col);
            	    }
                }
        	}
    	}
    }

    /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){
    	 return true;
        var formObj = document.form;

        formObj.bl_no.value= formObj.bl_no.value.trim().toUpperCase();
        formObj.bl_nos.value = formObj.bl_nos.value.trim().toUpperCase();
        formObj.multi_vvd.value= formObj.multi_vvd.value.trim().toUpperCase();
        formObj.ff_cnt_cd.value = formObj.ff_cnt_cd.value.trim().toUpperCase();

        var bl_no = formObj.bl_no.value;
        var bl_nos = formObj.bl_nos.value;
        var ff_cnt_seq = formObj.ff_cnt_cd.value.trim();
        var ff_cust_seq = "";

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
//                formObj.search_dt_fr.value = "";
//                formObj.search_dt_to.value = "";
            }
        }

        var search_dt_fr = formObj.search_dt_fr.value.trim();
        var search_dt_to = formObj.search_dt_to.value.trim();

        if( formObj.bl_nos.value == "" ) {
    		if ( search_dt_fr == "" ) {
    		    ComShowCodeMessage("AGT10009", "", "", "");
    		    formObj.search_dt_fr.focus();
    			return false;
    		}
    		if ( search_dt_to == "" ) {
    		    ComShowCodeMessage("AGT10009", "", "", "");
    		    formObj.search_dt_to.focus();
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
    	    if(!chkValidSearch()) return false;
    	}

    	return true;
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
    	var display ='1,0,1,1,1,1,1,1';
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

                if(ComTrim(form.bl_nos.value).length > 0) {
                	form.search_dt_fr.value = "";
                    form.search_dt_to.value = "";
                }
            }
        }
    }

    /**
     * BL NO가 입력이 되면 Date를 삭제해 준다.
     */
    function setDateEmpty() {

        var form = document.form;
        var bl_no_list = form.bl_nos.value.trim().toUpperCase();

        if(bl_no_list.length > 0) {
            form.search_dt_fr.value = "";
            form.search_dt_to.value = "";
        }else{
        	today = ComGetNowInfo();
            frday = ComGetDateAdd(today, "D", -15);
            form.search_dt_fr.value = frday;
            form.search_dt_to.value = today;
        }
    }

    /**
     * 날짜를 현재 날짜로 ReSet 한다.
     */
    function reSetDate() {
        form.search_dt_fr.value = frday;
        form.search_dt_to.value = today;
    }
     /**
      * Inputbox에서 Enter Key Event 발생시 조회 실행한다.
      * @param    : obj => 객체
      * sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyUp="checkEnterOffice(this)"  >
      */
     function checkEnterOffice(obj) {

         obj.value = obj.value.trim().toUpperCase();

         if ( window.event.keyCode == 13 ) {
     	    obj.blur(); // Update Date 조회
     	    document.btn_retrieve.click(); // 조회 실행
         }

         return true;
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
       * CSR No. 값 설정
       */
      function setVvdNo(sheetObj, param) {

      	//alert("param : [" + param + "]");

      	var formObject = document.form;
      	var rect = document.getElementById("td_vvd_no").getBoundingClientRect();
      	

      	formObject.rect_top.value = formObject.rect_top.value == "" ? rect.top : formObject.rect_top.value;
      	formObject.rect_left.value = formObject.rect_left.value == "" ? rect.left : formObject.rect_left.value;


      	if (param == 1) {
      		
      		// sheet 활성화
      		document.getElementById("vvd_input").style.display = "none";
      		document.getElementById("vvd_sheet").style.display = "block";
      		// sheet 위치설정
      		document.getElementById("vvd_sheet").style.top = formObject.rect_top.value;
      		document.getElementById("vvd_sheet").style.left = formObject.rect_left.value;

      		var BlNoselectRow = !ComIsEmpty(formObject.sheet_vvd_no_row_chk) ? formObject.sheet_vvd_no_row_chk.value : "1";

      		if (!ComIsEmpty(formObject.s_vvd)) {
      			sheetObj.CellValue2(BlNoselectRow, prefix1 + "vvd_no") = formObject.s_vvd.value;
      		}
      		sheetObj.SelectCell(BlNoselectRow, prefix1 + "vvd_no");
      	} else if (param == 2) {
      		// input 활성화
      		document.getElementById("vvd_input").style.display = "block";
      		document.getElementById("vvd_sheet").style.display = "none";

      		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
      			if (!ComIsEmpty(sheetObj.CellValue(i, prefix1 + "blank")) && !ComIsEmpty(sheetObj.CellValue(i, prefix1 + "vvd_no"))) {
      				formObject.sheet_vvd_no_row_chk.value = i;
      				formObject.s_vvd.value = sheetObj.CellValue(i, prefix1 + "vvd_no");
      				break;
      			}
      		}
      	} else if (param == 3) {
      		if (document.getElementById("vvd_sheet").style.display == "block") {
      			setVvdNo(sheetObj, 2);
      		}
      	}

      }
      
      /**
       * t1sheet1 시트가 OnChange 일 때 값을 지정해줌
       */
      function t1sheet1_OnChange(sheetObj, row , col , value) {

      	var formObject = document.form;
      	formObject.s_vvd.value = sheetObj.CellValue(1, col);
      }

      /**
       * MultiCsr  값을 지정해줌
       */
      function setMultiVvd ( sheetObj ){

      	var formObject = document.form;
      	if( formObject.s_vvd.value != "" ){
      		sheetObj.CellValue(1, prefix1 + "vvd_no") = formObject.s_vvd.value;
      	}
      	else {
      		sheetObj.CellValue(1, prefix1 + "vvd_no") = formObject.s_vvd.value;
      	}
      	
      	if(sheetObj.CellValue(1, prefix1 + "vvd_no") != "" ){

      		for (var i = 1 ; i <= 50 ; i++){
      			if ( sheetObj.CellValue(i, prefix1 + "vvd_no") != "" && sheetObj.CellValue(i+1, prefix1 + "vvd_no") != ""  ){
      				multi_vvd = multi_vvd + sheetObj.CellValue(i, prefix1 + "vvd_no")+",";
      			}
      			else{
      				multi_vvd = multi_vvd + sheetObj.CellValue(i, prefix1 + "vvd_no");
      			}				
      		}
      		
      	}
      	//alert(multi_vvd);	

      }
      
