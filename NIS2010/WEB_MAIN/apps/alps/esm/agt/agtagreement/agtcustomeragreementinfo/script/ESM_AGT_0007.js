// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];


		/*******************************************************/
		var formObject = document.form;

//		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				 case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;

				case "btng_rowcopy":
					doActionIBSheet(sheetObject,formObject,IBCOPYROW);
					break;

				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

			} // end switch
//		}catch(e) {
//			if( e == "[object Error]") {
//				ComShowMessage(ComGetMsg("COM12111", "", "", ""));
//			} else {
//				ComShowMessage(e);
//			}
//		}
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
	function loadPage( grpTpCode, grpTpText, brogDivCode, brogDivText, brogTpCode, brogTpText, brogKndCode, brogKndText ) {

		for(i=0;i<sheetObjects.length;i++){
		    //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1, grpTpCode, grpTpText, brogDivCode, brogDivText, brogTpCode, brogTpText, brogKndCode, brogKndText );
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		/*
		for(p=0;p< comboObjects.length;p++){
			initCombo (comboObjects[p],p+1);
		}
		*/
	}

   /**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet( sheetObj, sheetNo, grpTpCode, grpTpText, brogDivCode, brogDivText, brogTpCode, brogTpText, brogKndCode, brogKndText ) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(16) ;
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
					InitColumnInfo(30, 4 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Del.|STS|SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|EFF DT|EXP DT|SC No|RFA No|Commodity TP|Commodity|Commodity|Type|CHG Type|Rate|Box AMT|TEU AMT|FEU AMT|REU AMT|CHG|Kind";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH,    DATAALIGN,  COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,   false,    "",                    false,    "",         dfNone,   	     0,     true,       true);
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,   false,    "ibflag",              false,    "",         dfNone,   		 0,     false,      true);
					InitDataProperty(0, cnt++ , dtSeq,        40,    daCenter,   false,    "",                    false,    "",         dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   false,    "brog_cnt_cust_seq",   true,     "",         dfNone,          0,     false,      true,       8);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "brog_cnt_cust_nm",    false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   false,    "shpr_cnt_seq",        false,    "",         dfNone,          0,     true,       true,       8);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "shpr_cnt_nm",         false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "por_grp_tp_cd",       false,    "",         dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   false,    "por_rout_cd",         false,    "",         dfNone,          0,     true,       true,       5);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "pol_grp_tp_cd",       false,    "",         dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   false,    "pol_rout_cd",         false,    "",         dfNone,          0,     true,       true,       5);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "pod_grp_tp_cd",       false,    "",         dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   false,    "pod_rout_cd",         false,    "",         dfNone,          0,     true,       true,       5);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "fm_eff_dt",           false,    "",         dfDateYmd,       0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "to_eff_dt",           false,    "",         dfDateYmd,       0,     true,       true);
      				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "sc_no",               false,    "",         dfNone,          0,     true,       true,       9);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "rfa_no",              false,    "",         dfNone,          0,     true,       true,       11);
					InitDataProperty(0, cnt++ , dtCombo,     100,    daCenter,   false,    "cmdt_tp_cd",          false,    "",         dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   false,    "cmdt_cd",             false,    "",         dfNone,          0,     true,       true,       6);
					InitDataProperty(0, cnt++ , dtData,      140,    daLeft,     false,    "cmdt_nm",             false,    "",         dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,   false,    "brog_div_cd",         false,    "",         dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,   false,    "brog_tp_cd",          false,    "",         dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "bkg_brog_rt",         false,    "",         dfFloat,         3,     true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "brog_bx_rt",          false,    "",         dfFloat,         3,     true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "brog_teu_rt",         false,    "",         dfFloat,         3,     true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "brog_feu_rt",         false,    "",         dfFloat,         3,     true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "brog_rf_rt",          false,    "",         dfFloat,         3,     true,       true,       15);
					InitDataProperty(0, cnt++ , dtData,      130,    daLeft,     false,    "brog_chg_ctnt",       false,    "",         dfNone,          0,     true,       true,       50);
					InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   false,    "brog_knd_cd",         false,    "",         dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,   false,    "brog_rt_seq",         false,    "",         dfNone,          0,     false,      false);

					//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
					InitDataCombo (0,"por_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"pol_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"pod_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"cmdt_tp_cd","*|Rep|Common","*|2|3");
					InitDataCombo (0,"brog_div_cd",brogDivCode,brogDivCode);
					InitDataCombo (0,"brog_tp_cd",brogTpCode,brogTpCode);
					InitDataCombo (0,"brog_knd_cd",brogKndCode,brogKndCode);
					
					//Validation 체크
                    InitDataValid(0, "brog_cnt_cust_seq", vtEngUpOther, "0123456789");	// 영대문자, 숫자만 입력되도록 설정
                    InitDataValid(0, "shpr_cnt_seq", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "por_rout_cd", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "pol_rout_cd", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "pod_rout_cd", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "sc_no", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "rfa_no", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    //InitDataValid(0, "cmdt_cd", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "cmdt_cd", vtNumericOther, "*");	// 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "brog_chg_ctnt", vtEngUpOther, ","); // 영대문자, 콤마(,) 만 입력되도록 설정

					//CountPosition  = 0 ;
					//style.height = GetSheetHeight(13) ;
				}
				break;
		}
	}

   /**
	 * Sheet관련 프로세스 처리
	*/
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        var newRow = -1;

		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
				    return false;
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_AGT_0007GS.do", agtQryStr(formObj));
				break;

			case IBSAVE:        //저장
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_AGT_0007GS.do", agtQryStr(formObj));
				break;

			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;

			case IBINSERT:      // 입력
				newRow = sheetObj.DataInsert();
				//sheetObj.CellValue(newRow, "brog_cnt_cust_seq") = formObj.brog_cnt_cust_seq.value;
				//sheetObj.CellValue(newRow, "brog_cnt_cust_nm") = formObj.brog_cnt_cust_seqName.value;
				sheetObj.CellValue(newRow, "shpr_cnt_seq") = "*";
				sheetObj.CellValue(newRow, "por_rout_cd") = "*";
				sheetObj.CellValue(newRow, "pol_rout_cd") = "*";
				sheetObj.CellValue(newRow, "pod_rout_cd") = "*";
				sheetObj.CellValue(newRow, "fm_eff_dt") = "20000101";
				sheetObj.CellValue(newRow, "to_eff_dt") = "29991231";
				sheetObj.CellValue(newRow, "sc_no") = "*";
				sheetObj.CellValue(newRow, "rfa_no") = "*";
				sheetObj.CellValue(newRow, "cmdt_cd") = "*";
				//sheetObj.CellValue(newRow, "cmdt_nm") = "*";
				setBrogDivCd( sheetObj, newRow, "brog_div_cd" );
				break;

			case IBCOPYROW:     //행 복사
				newRow = sheetObj.DataCopy();
				setBrogDivCd( sheetObj, newRow, "brog_div_cd" );
				break;

		}
	}

    /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){

        var formObj = document.form;

        formObj.search_brog_cnt_cust_seq.value = formObj.search_brog_cnt_cust_seq.value.trim().toUpperCase();

        var ff_cnt_seq = formObj.search_brog_cnt_cust_seq.value;
        var ff_cust_seq = "";

	    if ( ff_cnt_seq.length > 2 ) {

            ff_cust_seq = ff_cnt_seq.substring(2, ff_cnt_seq.length);

            if(ComIsNumber(ff_cust_seq) == false) {
			    ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
			    formObj.search_brog_cnt_cust_seq.focus();
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
	 * Grid 입력값에 대한 OnChange Event 처리
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {

	    with(sheetObj) {

	        var saveNm = ColSaveName(Col);

            if( saveNm=="por_grp_tp_cd" || saveNm=="pol_grp_tp_cd" || saveNm=="pod_grp_tp_cd" ) {

	            CellValue2(Row, parseInt(Col)+1) = "*";

	        } else if( saveNm == "cmdt_tp_cd" ) {

	            CellValue2(Row, parseInt(Col)+1) = "*";
	            CellValue2(Row, parseInt(Col)+2) = "";
	            //CellValue2(Row, Col+2) = "*";

	        } else if( saveNm == "brog_div_cd" ) {

                setBrogDivCd( sheetObj, Row, Col );

            } else if( ColSaveName(Col) == "brog_cnt_cust_seq" ) {

                var form1 = document.hiddenF;

               if( Value.trim() != "" ) {

                   if( !/[A-Z]{2}[0-9]{6}/.test(Value) && "000000" != Value && "*000000" != Value ) {
        			   //ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
        			   CellValue2(Row, Col) = "";
        			   CellValue2(Row, parseInt(Col)+1) = "";
                       SelectCell(Row, Col);
                   } else {

                       var seq = Value.trim().substring(2);

                       if( seq == 999999 ) {

                           CellValue2(Row, parseInt(Col)+1) = "";

                       } else {
                           form1.f_cmd.value = SEARCH01;
                           form1.cust_cd.value = Value.trim();
                           form1.row.value = Row;
                           form1.colNm1.value = ColSaveName(Col);
                           form1.colNm2.value = ColSaveName(parseInt(Col)+1);

                           DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                       }
                   }
               } else {
                   CellValue2(Row, parseInt(Col)+1) = "";
               }
           } else if( ColSaveName(Col) == "shpr_cnt_seq" ) {

               var form1 = document.hiddenF;

               if( Value.trim() != "" && Value.trim() != "*" ) {

                   if( !/[A-Z]{2}[0-9]{6}/.test(Value) && "000000" != Value && "*000000" != Value ) {
        			   //ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
        			   CellValue2(Row, Col) = "";
        			   CellValue2(Row, parseInt(Col)+1) = "";
                       SelectCell(Row, Col);
                   } else {

                       var seq = Value.trim().substring(2);

                       if( seq == 999999 ) {

                           CellValue2(Row, parseInt(Col)+1) = "";

                       } else {
                           form1.f_cmd.value = SEARCH01;
                           form1.cust_cd.value = Value.trim();
                           form1.row.value = Row;
                           form1.colNm1.value = ColSaveName(Col);
                           form1.colNm2.value = ColSaveName(parseInt(Col)+1);

                           DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                       }
                   }
               } else {
                   CellValue2(Row, parseInt(Col)+1) = "";
               }
           }
	    }
	}

	/**
	 * Grid에서 OnPopupClick Event 처리
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {

		var saveNm = sheetObj.ColSaveName(Col);
		var width = 775;
		var height = 482;

		if ( saveNm == "brog_cnt_cust_seq" || saveNm == "shpr_cnt_seq" ) {

			var cust_cd = "";
			var func = "sheet1_setFFCntSeq";
			var display = "1,0,1,1,1,1,1,1,1,1,1,1";
			var url = "COM_ENS_041.do";

			ComOpenPopup(url, width, height, func, display, true, false, Row, Col);
			
		} else if( saveNm == "por_rout_cd" || saveNm == "pol_rout_cd" || saveNm == "pod_rout_cd" ) {

			var grp_tp = sheetObj.CellValue(Row, Col-1).trim();
			var func = "sheet1_setSheetData2";
			var display = "1,0,1,1,1,1,1,1,1,1,1,1";
			var url = "";

			if( grp_tp == "1" ) {
				width = 306;
				height = 382;
				url = "COM_ENS_0H1.do";
			} else if( grp_tp == "2" ) {
				width = 406;
				height = 422;
				url = "COM_ENS_0I1.do";
			} else if( grp_tp == "3" ) {
				width = 566;
				height = 484;
				url = "COM_ENS_0M1.do";
			} else if( grp_tp == "4" ) {
				width = 526;
				height = 454;
				url = "COM_ENS_0J1.do";
			} else if( grp_tp == "5" ) {
				url = "COM_ENS_051.do";
			} else {

				if( saveNm == "por_rout_cd" ) {
					ComShowMessage(ComGetMsg("COM12113", "POR TYPE", "", ""));
				} else if( saveNm == "pol_rout_cd" ) {
					ComShowMessage(ComGetMsg("COM12113", "POL TYPE", "", ""));
				} else if( saveNm == "pod_rout_cd" ) {
					ComShowMessage(ComGetMsg("COM12113", "POD TYPE", "", ""));
				}
				sheetObj.SelectCell ( Row, Col-1 );
				return false;
			}

			ComOpenPopup(url, width, height, func, display, true, false, Row, Col);

		} else if( saveNm == "cmdt_cd" ) {

			var func = "";
			var display = "1,0,1,1,1,1,1,1,1,1,1,1";
			var url = "";
			var cmdt_tp = sheetObj.CellValue(Row, Col-1).trim();

			if(cmdt_tp == "2") {
				width = 506;
				height = 382;
				func = "sheet1_setSheetData";
				url = "COM_ENS_0K1.do";
			} else if(cmdt_tp == "3") {
				width = 775;
				height = 482;
				func = "sheet1_setSheetData3";
				url = "COM_ENS_011.do";
			} else {
				ComShowMessage(ComGetMsg("COM12113", "Commodity Type", "", ""));
				sheetObj.SelectCell ( Row, Col-1 );
				return false;
			}

			ComOpenPopup(url, width, height, func, display, true, false, Row, Col);
		}
	}

	/**
	 * 저장 버튼 클릭시 유효성검증 프로세스 처리
	 */
	function sheet1_OnValidation(sheetObj, Row, Col, Value) {

		var val = Value.trim();
		var subValue = "";
		with(sheetObj) {
			var saveNm = ColSaveName(Col);
			var ibStatus = RowStatus(Row);
			if( ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U" ) {
				if( saveNm=="brog_cnt_cust_seq" ) {
					if( !/[A-Z]{2}[0-9]{6}/.test(val) && "000000" != val && "*000000" != val ) {
						ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
						ValidateFail = true;
						SelectCell(Row, Col);
					}
				}

				if( saveNm=="shpr_cnt_seq" ) {
					if( val.length > 0 && val != "*" ) {
						if( !/[A-Z]{2}[0-9]{6}/.test(val) && "000000" != val && "*000000" != val ) {
							ComShowMessage(ComGetMsg("AGT10017", "Shipper", "", ""));
							ValidateFail = true;
							SelectCell(Row, Col);
						}
					}
				}

				if( saveNm=="por_grp_tp_cd" || saveNm=="pol_grp_tp_cd" ||
					saveNm=="pod_grp_tp_cd" || saveNm=="cmdt_tp_cd" )
				{
					if( val.length > 0 && val != "*" ) {
						subValue = CellValue(Row, parseInt(Col)+1).trim();
						if( subValue == "" || subValue == "*") {
							if(saveNm=="por_grp_tp_cd") {
								ComShowMessage(ComGetMsg("AGT10001", "POR", "", ""));
							} else if(saveNm=="pol_grp_tp_cd") {
								ComShowMessage(ComGetMsg("AGT10001", "POL", "", ""));
							} else if(saveNm=="pod_grp_tp_cd") {
								ComShowMessage(ComGetMsg("AGT10001", "POD", "", ""));
							} else if(saveNm=="cmdt_tp_cd") {
								ComShowMessage(ComGetMsg("AGT10001", "Commodity", "", ""));
							}
							ValidateFail = true;
							SelectCell( Row, parseInt(Col)+1 );
						} else {
							if( saveNm=="por_grp_tp_cd" || saveNm=="pol_grp_tp_cd" || saveNm=="pod_grp_tp_cd" ) {
								if(checkSubLength( sheetObj, Row, Col, val ) == false) {
									ValidateFail = true;
									SelectCell( Row, parseInt(Col)+1 );
								}
							}
						}
					}
				}

				if( saveNm=="brog_div_cd" ) {
					if(checkBrogDivCd( sheetObj, Row, Col, val ) == false) {
						ValidateFail = true;
					}
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

	 	sheetObj.CellValue2(row, col) = cnt_cd + ComLpad(cust_seq, 6,'0');
		sheetObj.CellValue2(row, (parseInt(col)+1)) = colArray[4];
	}

	/**
	 * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
	 */
	function sheet1_setSheetData(rowArray, row, col) {
		var sheetObj = sheetObjects[0];

		var colArray = rowArray[0];

	 	sheetObj.CellValue(row, col) = colArray[3];
		sheetObj.CellValue(row, parseInt(col)+1) = colArray[4];
	}

	/**
	 * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
	 */
	function sheet1_setSheetData2(rowArray, row, col) {
		var sheetObj = sheetObjects[0];

		var colArray = rowArray[0];

	 	sheetObj.CellValue(row, col) = colArray[3];
	}

	/**
	 * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
	 */
	function sheet1_setSheetData3(rowArray, row, col) {
		var sheetObj = sheetObjects[0];

		var colArray = rowArray[0];

	 	sheetObj.CellValue(row, col) = colArray[2];
	 	sheetObj.CellValue(row, parseInt(col)+1) = colArray[3];
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
		var display = "1,0,1,1,1,1,1,1,1,1,1,1";
		//url = url + "?cust_cd="+cust_cd;
		//comPopup(url, width, height, func, display, bModal, b2ndSheet);
		ComOpenPopup(url, width, height, func, display, true, false);
	}

	/**
	 * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
	 */
	function setForwarder(rowArray, row, col) {
		var colArray = rowArray[0];

		document.form.search_brog_cnt_cust_seq.value = colArray[3];
		document.form.search_brog_cnt_cust_seqName.value = colArray[4];
	}

	/**
	 * Type(brog_div_cd) 입력시 Format 적용
	 */
	function setBrogDivCd( sheetObj, Row, Col ) {

		with(sheetObj) {

			var value = CellValue(Row, Col);

			if ( value == "BA" || value == "BF" ) {

				if( value == "BA" ) {
					CellValue2(Row, "brog_tp_cd") = "ALL";
				} else {
					CellValue2(Row, "brog_tp_cd") = "OFT";
				}

				CellValue2(Row, "brog_bx_rt") = 0;
				CellValue2(Row, "brog_teu_rt") = 0;
				CellValue2(Row, "brog_feu_rt") = 0;
				CellValue2(Row, "brog_rf_rt") = 0;
				CellValue2(Row, "brog_chg_ctnt") = "";

				CellEditable(Row, "bkg_brog_rt") = true;
				CellEditable(Row, "brog_bx_rt") = false;
				CellEditable(Row, "brog_teu_rt") = false;
				CellEditable(Row, "brog_feu_rt") = false;
				CellEditable(Row, "brog_rf_rt") = false;
				CellEditable(Row, "brog_chg_ctnt") = false;

			} else if( value == "BS" ) {

				CellValue2(Row, "brog_tp_cd") = "SPC";

				CellValue2(Row, "brog_bx_rt") = 0;
				CellValue2(Row, "brog_teu_rt") = 0;
				CellValue2(Row, "brog_feu_rt") = 0;
				CellValue2(Row, "brog_rf_rt") = 0;

				CellEditable(Row, "bkg_brog_rt") = true;
				CellEditable(Row, "brog_bx_rt") = false;
				CellEditable(Row, "brog_teu_rt") = false;
				CellEditable(Row, "brog_feu_rt") = false;
				CellEditable(Row, "brog_rf_rt") = false;
				CellEditable(Row, "brog_chg_ctnt") = true;

			} else if( value == "CA" ) {

				CellValue2(Row, "brog_tp_cd") = "ALL";

				CellValue2(Row, "bkg_brog_rt") = 0;
				CellValue2(Row, "brog_teu_rt") = 0;
				CellValue2(Row, "brog_feu_rt") = 0;
				CellValue2(Row, "brog_rf_rt") = 0;
				CellValue2(Row, "brog_chg_ctnt") = "";

				CellEditable(Row, "bkg_brog_rt") = false;
				CellEditable(Row, "brog_bx_rt") = true;
				CellEditable(Row, "brog_teu_rt") = false;
				CellEditable(Row, "brog_feu_rt") = false;
				CellEditable(Row, "brog_rf_rt") = false;
				CellEditable(Row, "brog_chg_ctnt") = false;

			} else if( value == "CS" ) {

				CellValue(Row, "brog_tp_cd") = "SPC";

				CellValue2(Row, "bkg_brog_rt") = 0;
				CellValue2(Row, "brog_bx_rt") = 0;
				CellValue2(Row, "brog_chg_ctnt") = "";

				CellEditable(Row, "bkg_brog_rt") = false;
				CellEditable(Row, "brog_bx_rt") = false;
				CellEditable(Row, "brog_teu_rt") = true;
				CellEditable(Row, "brog_feu_rt") = true;
				CellEditable(Row, "brog_rf_rt") = true;
				CellEditable(Row, "brog_chg_ctnt") = false;

			}
		}
	}

	/**
	 * Type(brog_div_cd) 에 따른 데이타 입력 체크
	 */
	function checkBrogDivCd( sheetObj, Row, Col ) {

		with(sheetObj) {

			var value = CellValue(Row, Col);

			if ( value == "BA" || value == "BF" ) { // 반드시 입력

				var bkg_brog_rt = CellValue(Row, "bkg_brog_rt").trim();
				if(isNaN(bkg_brog_rt)) bkg_brog_rt = "0.000";

				if( Math.floor(bkg_brog_rt) <= 0 ) {
					ComShowMessage(ComGetMsg("AGT10017", "Rate", "", ""));
					SelectCell( Row, "bkg_brog_rt" );
					return false;
				}

			} else if( value == "BS" ) { // 반드시 입력

				var bkg_brog_rt = CellValue(Row, "bkg_brog_rt").trim();
				var brog_chg_ctnt = CellValue(Row, "brog_chg_ctnt").trim();

				if(isNaN(bkg_brog_rt)) bkg_brog_rt = "0.000";

				if( Math.floor(bkg_brog_rt) <= 0 ) {
					ComShowMessage(ComGetMsg("AGT10017", "Rate", "", ""));
					SelectCell( Row, "bkg_brog_rt" );
					return false;
				}

				if( brog_chg_ctnt == "" ) {
					ComShowMessage(ComGetMsg("AGT10001", "CHG", "", ""));
					SelectCell( Row, "brog_chg_ctnt" );
					return false;
				} else {
					if(checkCHG( sheetObj, Row, "brog_chg_ctnt" ) == false) {
						return false;
					}
				}

			} else if( value == "CA" ) { // 반드시 입력

                var brog_bx_rt = CellValue(Row, "brog_bx_rt").trim();

                if(isNaN(brog_bx_rt)) brog_bx_rt = "0.000";

                if( Math.floor(brog_bx_rt) <= 0 ) {
                    ComShowMessage(ComGetMsg("AGT10017", "Box AMT", "", ""));
                    SelectCell( Row, "brog_bx_rt" );
                    return false;
                }

            } else if( value == "CS" ) { // 셋중에 하나는 반드시 입력

                var brog_teu_rt = CellValue(Row, "brog_teu_rt").trim();
                var brog_feu_rt = CellValue(Row, "brog_feu_rt").trim();
                var brog_rf_rt = CellValue(Row, "brog_rf_rt").trim();

                if(isNaN(brog_teu_rt)) brog_teu_rt = "0.000";
                if(isNaN(brog_feu_rt)) brog_feu_rt = "0.000";
                if(isNaN(brog_rf_rt)) brog_rf_rt = "0.000";

                if( Math.floor(brog_teu_rt) > 0 || Math.floor(brog_feu_rt) > 0 || Math.floor(brog_rf_rt) > 0 ) {
                    var flg = true;
                    if( Math.floor(brog_teu_rt) < 0 ) {
                        flg = false;
                    }
                    if( Math.floor(brog_feu_rt) < 0 ) {
                        flg = false;
                    }
                    if( Math.floor(brog_rf_rt) < 0 ) {
                        flg = false;
                    }
                    if(!flg) {
                        ComShowMessage(ComGetMsg("AGT10017", "TEU AMT or FEU AMT or REU AMT", "", ""));
                        SelectCell( Row, "brog_teu_rt" );
                        return false;
                    }
                } else {
                    ComShowMessage(ComGetMsg("AGT10017", "TEU AMT or FEU AMT or REU AMT", "", ""));
                    SelectCell( Row, "brog_teu_rt" );
                    return false;
                }
            }
	    }
	}

	/**
	 * CHG 체크
	 */
	function checkCHG( sheetObj, Row, ColNm ) {
	    with(sheetObj) {
	        var value = CellValue(Row, ColNm).trim();

	        var chg_arr = value.split(',');

	        if(chg_arr.length > 0) {
	            for(var i=0; i<chg_arr.length; i++) {
    	            if(chg_arr[i] == "") { // 계산시 문제 발생 가능하므로 trim하지 않고 체크한다.
                        ComShowMessage(ComGetMsg("AGT10017", "CHG", "(ex:OFT,OTH,DTH)", ""));
                        SelectCell( Row, ColNm );
    	                return false;
    	            } else {
    	                if(chg_arr[i].length > 3) {
                            ComShowMessage(ComGetMsg("AGT10020", "(ex:OFT,OTH,DTH)", "", ""));
                            SelectCell( Row, ColNm );
                            return false;
    	                }
    	            }
	            }
	        }
	    }

	    return true;
	}

	/**
	 * 입력 길이 체크
	 */
	function checkSubLength( sheetObj, Row, Col, Value ) {

	    with(sheetObj) {

    	    Value = Value.trim();

    	    var saveNm = ColSaveName(Col);
    	    var subValue = CellValue(Row, parseInt(Col)+1).trim();

    	    if(Value == "1") {
    	        if(subValue.length > 1) {
    	            if(saveNm=="por_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POR", "1", ""));
                    } else if(saveNm=="pol_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POL", "1", ""));
                    } else if(saveNm=="pod_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POD", "1", ""));
                    }
                    return false;
    	        }
    	    } else if(Value == "2" || Value == "3" ) {
    	        if(subValue.length > 2) {
    	            if(saveNm=="por_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POR", "2", ""));
                    } else if(saveNm=="pol_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POL", "2", ""));
                    } else if(saveNm=="pod_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POD", "2", ""));
                    }
                    return false;
    	        }
    	    } else if( Value == "4") {
    	        if(subValue.length > 3) {
    	            if(saveNm=="por_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POR", "3", ""));
                    } else if(saveNm=="pol_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POL", "3", ""));
                    } else if(saveNm=="pod_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POD", "3", ""));
                    }
                    return false;
    	        }
    	    } else if(Value == "5") {
    	        if(subValue.length > 5) {
    	            if(saveNm=="por_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POR", "5", ""));
                    } else if(saveNm=="pol_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POL", "5", ""));
                    } else if(saveNm=="pod_grp_tp_cd") {
                        ComShowMessage(ComGetMsg("COM12173", "POD", "5", ""));
                    }
                    return false;
    	        }
    	    }
	    }

	    return true;
	}
