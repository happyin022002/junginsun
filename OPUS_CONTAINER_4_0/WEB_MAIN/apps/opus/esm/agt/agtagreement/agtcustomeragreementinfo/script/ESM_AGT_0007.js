// Common Global Variables


var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
	function processButtonClick(){
	    /***** Setting the additional Sheet variable when each tab has more than 2 sheets *****/
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
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){

	   sheetObjects[sheetCnt++] = sheet_obj;


	}

	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen
	 */
	function loadPage( grpTpCode, grpTpText, brogDivCode, brogDivText, brogTpCode, brogTpText, brogKndCode, brogKndText ) {

		for(i=0;i<sheetObjects.length;i++){
		    //khlee-Changing Start Environment Setting Method's Name
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1, grpTpCode, grpTpText, brogDivCode, brogDivText, brogTpCode, brogTpText, brogKndCode, brogKndText );
			//khlee-Adding Last Environment Setting method
			ComEndConfigSheet(sheetObjects[i]);
		}
		/*
		for(p=0;p< comboObjects.length;p++){
			initCombo (comboObjects[p],p+1);
		}
		*/
	}

   /**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	*/
	function initSheet( sheetObj, sheetNo, grpTpCode, grpTpText, brogDivCode, brogDivText, brogTpCode, brogTpText, brogKndCode, brogKndText ) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					// setting height
					style.height = GetSheetHeight(16) ;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					Editable = true;

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(30, 4 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Del.|STS|SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|EFF DT|EXP DT|SC No|RFA No|Commodity TP|Commodity|Commodity|Type|CHG Type|Rate|Box AMT|TEU AMT|FEU AMT|REU AMT|CHG|Kind";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH,    DATAALIGN,  COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
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

					//Setting Combo items[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
					InitDataCombo (0,"por_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"pol_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"pod_grp_tp_cd",grpTpText,grpTpCode);
					InitDataCombo (0,"cmdt_tp_cd","*|Rep|Common","*|2|3");
					InitDataCombo (0,"brog_div_cd",brogDivCode,brogDivCode);
					InitDataCombo (0,"brog_tp_cd",brogTpCode,brogTpCode);
					InitDataCombo (0,"brog_knd_cd",brogKndCode,brogKndCode);

                    InitDataValid(0, "brog_cnt_cust_seq", vtEngUpOther, "0123456789");	// Upper case in English, Number: : Only Possible to Input
                    InitDataValid(0, "shpr_cnt_seq", vtEngUpOther, "0123456789*");	// Upper case in English, Number, * : : Only Possible to Input
                    InitDataValid(0, "por_rout_cd", vtEngUpOther, "*");	// Upper case in English, * : : Only Possible to Input
                    InitDataValid(0, "pol_rout_cd", vtEngUpOther, "*");	// Upper case in English, * : : Only Possible to Input
                    InitDataValid(0, "pod_rout_cd", vtEngUpOther, "*");	// Upper case in English, * : : Only Possible to Input
                    InitDataValid(0, "sc_no", vtEngUpOther, "0123456789*");	// Upper case in English, Number, * : : Only Possible to Input
                    InitDataValid(0, "rfa_no", vtEngUpOther, "0123456789*");	// Upper case in English, Number, * : : Only Possible to Input
                    //InitDataValid(0, "cmdt_cd", vtEngUpOther, "0123456789*");	// Upper case in English, Number, * : : Only Possible to Input
                    InitDataValid(0, "cmdt_cd", vtNumericOther, "*");	// Number, * : : Only Possible to Input
                    InitDataValid(0, "brog_chg_ctnt", vtEngUpOther, ","); // Upper case in English, Comma(,) : : Only Possible to Input

					//CountPosition  = 0 ;
					//style.height = GetSheetHeight(13) ;
				}
				break;
		}
	}

   /**
	 * handling process for Sheet
	*/
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        var newRow = -1;

		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) {
				    return false;
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_AGT_0007GS.do", agtQryStr(formObj));
				break;

			case IBSAVE:        //Save
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_AGT_0007GS.do", agtQryStr(formObj));
				break;

			case IBDOWNEXCEL:        //Excel Download
				sheetObj.Down2Excel(-1, false, false, true);
				break;

			case IBINSERT:      // Insert
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

			case IBCOPYROW:     //Row Copy
				newRow = sheetObj.DataCopy();
				setBrogDivCd( sheetObj, newRow, "brog_div_cd" );
				break;

		}
	}

    /**
     * Checking mandatoryInsert on Retrieving
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
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		    if(!chkValidSearch()) return false;
		}

		return true;
	}

	/**
	 * Grid Insert OnChange Event 
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

                           //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                           DoRowSearch("ESM_AGT_COM.do", agtQryStr(form1));
                           CellValue2(Row, parseInt(Col)+1) = EtcData("cust_nm");
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

                           //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
                           DoRowSearch("ESM_AGT_COM.do", agtQryStr(form1));
                           CellValue2(Row, parseInt(Col)+1) = EtcData("cust_nm");
                       }
                   }
               } else {
                   CellValue2(Row, parseInt(Col)+1) = "";
               }
           }
	    }
	}

	/**
	 * Grid OnPopupClick Event 
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
	 * Save button Validation Process
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
	 * Setting the returned value to the cell after retrieving from Pop-up 
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
	 * Setting the returned value to the cell after retrieving from Pop-up 
	 */
	function sheet1_setSheetData(rowArray, row, col) {
		var sheetObj = sheetObjects[0];

		var colArray = rowArray[0];

	 	sheetObj.CellValue(row, col) = colArray[3];
		sheetObj.CellValue(row, parseInt(col)+1) = colArray[4];
	}

	/**
	 * Setting the returned value to the cell after retrieving from Pop-up 
	 */
	function sheet1_setSheetData2(rowArray, row, col) {
		var sheetObj = sheetObjects[0];

		var colArray = rowArray[0];

	 	sheetObj.CellValue(row, col) = colArray[3];
	}

	/**
	 * Setting the returned value to the cell after retrieving from Pop-up 
	 */
	function sheet1_setSheetData3(rowArray, row, col) {
		var sheetObj = sheetObjects[0];

		var colArray = rowArray[0];

	 	sheetObj.CellValue(row, col) = colArray[2];
	 	sheetObj.CellValue(row, parseInt(col)+1) = colArray[3];
	}

	/**
	 * F.Forwarder Retrieve pop-up open
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
	 * Setting Returned Calue after Retrieving F.Forwarder
	 */
	function setForwarder(rowArray, row, col) {
		var colArray = rowArray[0];

		document.form.search_brog_cnt_cust_seq.value = colArray[3];
		document.form.search_brog_cnt_cust_seqName.value = colArray[4];
	}

	/**
	 * Type(brog_div_cd) Insert Format
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
	 * Checking Data Insert according to Type(brog_div_cd)
	 */
	function checkBrogDivCd( sheetObj, Row, Col ) {

		with(sheetObj) {

			var value = CellValue(Row, Col);

			if ( value == "BA" || value == "BF" ) { // must inseret

				var bkg_brog_rt = CellValue(Row, "bkg_brog_rt").trim();
				if(isNaN(bkg_brog_rt)) bkg_brog_rt = "0.000";

				if( Math.floor(bkg_brog_rt) <= 0 ) {
					ComShowMessage(ComGetMsg("AGT10017", "Rate", "", ""));
					SelectCell( Row, "bkg_brog_rt" );
					return false;
				}

			} else if( value == "BS" ) { // must inseret

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

			} else if( value == "CA" ) { // must inseret

                var brog_bx_rt = CellValue(Row, "brog_bx_rt").trim();

                if(isNaN(brog_bx_rt)) brog_bx_rt = "0.000";

                if( Math.floor(brog_bx_rt) <= 0 ) {
                    ComShowMessage(ComGetMsg("AGT10017", "Box AMT", "", ""));
                    SelectCell( Row, "brog_bx_rt" );
                    return false;
                }

            } else if( value == "CS" ) { // one of the three must inseret

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
	 * CHG check
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
	 * Insert length check
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
