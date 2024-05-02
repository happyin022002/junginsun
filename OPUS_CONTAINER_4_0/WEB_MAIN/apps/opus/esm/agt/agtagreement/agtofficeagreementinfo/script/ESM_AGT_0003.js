// Common Global Variables


var sheetObjects = new Array();
var sheetCnt = 0;
var IBSEARCH02  = 30;
var IBSEARCH03  = 31;
var IBSAVE02    = 32;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
	function processButtonClick(){
		 /***** Setting the additional Sheet variable when each tab has more than 2 sheets *****/
		 var sheetObject = sheetObjects[0];
		 var sheetObject1 = sheetObjects[1];
		 var sheetObject2 = sheetObjects[2];

		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
                case "cnt_btn":
                   
                	with(formObject)
                	{                	        
                	    //var v_cnt_cd = cnt_cd.value;
                	    var classId = "ESM_AGT_0001";
            		    var param = '?classId='+classId;
            		    var v_display = "1,0,1,1,1,1,1,1,1,1";
            		    var chkStr = v_display.substring(0,3)
            		  
            		    if(chkStr == "1,0") {

            		        ComOpenPopup('/opuscntr/ESM_AGT_0001.do' + param, 780, 560, 'getESM_AGT_001_1', v_display, true);
            		        
            		    }else {
            			    showErrMessage("팝업을 띄우기display속성 정보가 부족합니다.");
            			    return;
            		    }
                	}
                	formObject.version.value = "";
                	if(formObject.vndr_cnt_cd.value != ""){
                	    sheetObjects[0].Visible = true ;
                	    sheetObject.RemoveAll();
    					sheetObject1.RemoveAll();
    					sheetObject2.RemoveAll();
    					formObject.current.value = "";
    					formObject.total.value = "";
                	    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    	doActionIBSheet(sheetObject1,formObject,IBSEARCH02);
                    	
                    	if(sheetObject1.CellValue(2,"agn_agmt_ver_seq") != ""){
                    		formObject.agn_agmt_ver_seq.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
                    	   doActionIBSheet(sheetObject2,formObject,IBSEARCH03);
                    	   formObject.version.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
                    	   formObject.current.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
                           formObject.total.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
                    	}
                	}
                	
                	
                	break;
                	
				case "btn_retrieve":
					//doActionIBSheet(sheetObject1,formObject,IBSEARCH02);
					doActionIBSheet(sheetObject2,formObject,IBSEARCH03);
					break;

				case "btn_new":
					sheetObject.RemoveAll();
					sheetObject1.RemoveAll();
					formObject.reset();
					break;

				case "btng_rowadd1":
					doActionIBSheet(sheetObject1,formObject,COMMAND01);
					break;

				case "btng_save1":
//					alert(sheetObject1.CellValue(2,"agn_agmt_ver_seq"));
//					if(!validateForm(sheetObj,formObject,sAction)) return false;
//					alert(sheetObject1.CellValue(2,"agn_agmt_ver_seq"));
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					sheetObject2.RemoveAll();
//					formObject.agn_agmt_ver_seq.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
//					formObject.current.value = formObject.agn_agmt_ver_seq.value;
//                    formObject.total.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
                    //Save후 자동 Retrieve
//					alert(sheetObject1.CellValue(2, "ibflag"));
//					for(var i=2; i<sheetObject1.RowCount; i++){
//						if(sheetObject1.CellValue(i, "ibflag") != "R"){
							doActionIBSheet(sheetObject,formObject,IBSEARCH);
							doActionIBSheet(sheetObject1,formObject,IBSEARCH02);
//						}
//					}
					break;

				case "btng_rowadd2":
					doActionIBSheet(sheetObject2,formObject,COMMAND02);
					break;

				case "btng_save2":
					doActionIBSheet(sheetObject2,formObject,IBSAVE02);
					break;

				case "btng_rowcopy":
					doActionIBSheet(sheetObject2,formObject,IBCOPYROW);
					break;

				case "btng_agreementcopy":
//					alert(formObject.current.value);
//					if(!validateForm(sheetObj,formObject,sAction)) return false;
					formObject.agn_agmt_ver_seq.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
					formObject.current.value = formObject.version.value;
                    formObject.total.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
					doActionIBSheet(sheetObject1,formObject,COMMAND03);
					
//					alert(sheetObject1.CellValue(2, "ibflag"));
//					for(var i=2; i<sheetObject1.RowCount; i++){
//						if(sheetObject1.CellValue(i, "ibflag") != "R"){
//							doActionIBSheet(sheetObject,formObject,IBSEARCH);
//							doActionIBSheet(sheetObject1,formObject,IBSEARCH02);
//							doActionIBSheet(sheetObject1,formObject,IBSEARCH03);
//						}
//					}
//					if(formObject.version.value != "" || formObject.version.value > 0){
//						
//					}
					
					
					break;
				
				case "col_hidden":
					doActionIBSheet(sheetObject2,formObject,COMMAND04);
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
	function loadPage(ac_tp_cd, ac_tp_text) {

		for(i=0;i<sheetObjects.length;i++){

		//khlee-Changing Start Environment Setting Method's Name
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1,ac_tp_cd,ac_tp_text);
		//khlee-Adding Last Environment Setting method
			ComEndConfigSheet(sheetObjects[i]);			
		}
		sheetObjects[0].Visible = false ;
	}

   /**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo,ac_tp_cd,ac_tp_text) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					// setting height
					//style.height = GetSheetHeight(6) ;
					style.height = 25;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					Editable = true;

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 0, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(1, 0 , 0, true);

					// setting function handling header
                    //InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true, false);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   false,    "agmt_ofc_cd",     false,          "",       dfNone,          0,     false,       false);
				
					CountPosition = 0 ;
					RowHidden( 0 ) = true ;
				}
				break;
			case 2:      //sheet1 init
				with (sheetObj) {
					// setting height
					style.height = 130;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					Editable = true;

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 3 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Del.|STS|VER|Period|Period|Exchange\nRate|Office\nCharacter|Remarks|Update\nDate|Del";
					var HeadTitle1 = "Del.|STS|VER|From|To|Exchange\nRate|Office\nCharacter|Remarks|Update\nDate|Del";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
 
					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  true,    "",     false,          "",       dfNone,   		0,     true,       true);
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,    "ibflag",     false,          "",       dfNone,   		0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,        30,    daCenter,   true,    "agn_agmt_ver_seq",     false,          "",       dfNone,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "fm_eff_dt",     true,          "",       dfDateYmd,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "to_eff_dt",     true,          "",       dfDateYmd,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCombo,      80,    daCenter,   true,    "xch_rt_div_lvl",     true,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCombo,      80,    daCenter,   true,    "ofc_chr_lvl",     true,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      150,    daLeft,   true,    "agn_agmt_rmk",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "upd_dt",     false,          "",       dfDateYmd,          0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       30,    daCenter,   true,    "delt_flg",     false,          "",       dfNone,          0,     false,       false);
					CountPosition  = 0;

					//Setting Combo items[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
					InitDataCombo (0, "xch_rt_div_lvl" , " VVD|Monthly|Daily|Fixed", " 1|2|3|4");
					InitDataCombo (0, "ofc_chr_lvl" , "Agent|Subsidiary|Subsidiary(CN)|Agent(CN)", " 1|2|3|4");
					RangeBackColor(1,2,1,6) = RgbColor(222, 251, 248);   // OPUS
                    InitDataValid(0, "agn_agmt_rmk", vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?"); //Insert except in the case of KOREAN

					HeadRowHeight = 20 ;
					HeadRowHeight = 21 ;
                    
			   }
				break;
            
			case 3:      //sheet3 init
				with (sheetObj) {
					// setting height
					style.height = 260;
					//Whole setting width
					SheetWidth = mainTable.clientWidth;

					//setting Host information[mandatory][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//Whole Merge kind [Optional, Default msNone]
					MergeSheet = msHeaderOnly;

				   //Edit kind [Optional, Default false]
					Editable = true;

					//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 3, 1, 9, 100);

					//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(34, 6 , 0, true);

					// setting function handling header
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle = "Del.|STS|No.|Bound|Account|TP/SZ|Status|Amount|Amount|Subject AMT|Base|%|Deduct for Net|Deduct for Net|Deduct for Net|Deduct for Net|Deduct for Net|POR|POL|POD|DEL|Customer|S/C #|RFA #|S/C OFC|RFA OFC|BKG\nOFC|Sales\nOFC|PPD at|CCT at|3rd Party\nat|Lane|Vessel|Local\nCharge";
					var HeadTitle1= "Del.|STS|No.|Bound|Account|TP/SZ|Status|CUR|AMT|Subject AMT|Base|%|Charge|Haulage|Haulage|Feederage|Feederage|POR|POL|POD|DEL|Customer|S/C #|RFA #|S/C OFC|RFA OFC|BKG\nOFC|Sales\nOFC|PPD at|CCT at|3rd Party\nat|Lane|Vessel|Local\nCharge";
					var HeadTitle2= "Del.|STS|No.|Bound|Account|TP/SZ|Status|CUR|AMT|Subject AMT|Base|%|Charge|ORG|DEST|ORG|DEST|POR|POL|POD|DEL|Customer|S/C #|RFA #|S/C OFC|RFA OFC|BKG\nOFC|Sales\nOFC|PPD at|CCT at|3rd Party\nat|Lane|Vessel";

					//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, true);

					//Data  properties    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  true,    "",     false,          "",       dfNone,   		0,     true,       true);
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,    "ibflag",     false,          "",       dfNone,   		0,     false,      true);
					InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,   true,    "",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   true,    "io_bnd_cd",   false,          "",       dfNone,          0,     false,       true);
					InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,   true,    "ac_tp_cd",   true,          "",       dfNone,          0,     false,       true);
					InitDataProperty(0, cnt++ , dtPopup,  50,    daCenter,   true,    "cntr_inp_term_cd",  false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,   true,    "full_mty_cd",   false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,   true,    "curr_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight,    true,    "fx_comm_amt",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "comm_pay_term_cd",   true,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   true,    "grs_net_div_cd",   true,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight,    true,    "bkg_comm_rt",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "chg_ddct_inp_cd",  false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,   true,    "hlg_ddct_org_flg",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,   true,    "hlg_ddct_dest_flg",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,   true,    "fdrg_ddct_org_flg",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,   true,    "fdrg_ddct_dest_flg",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_por_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_pol_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_pod_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_del_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  70,    daCenter,   true,    "cust_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "sc_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  65,    daCenter,   true,    "rfa_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  70,    daCenter,   true,    "sc_ofc_inp_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "rfa_ofc_inp_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_ofc_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "sls_ofc_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_ppd_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "bkg_clt_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  70,    daCenter,   true,    "bkg_n3rd_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "lane_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopup,  60,    daCenter,   true,    "vsl_inp_term_cd",     false,          "",       dfNone,          0,     true,       true);
       				//hidden 추가
					//InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   true,    "agmt_ofc_cd",     true,          "",       dfNone,          0,     true,       true);
					//InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   true,    "agmt_ofc_cty_cd",     true,          "",       dfNone,          0,     true,       true);
					//InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   true,    "agn_agmt_seq",     true,          "",       dfNone,          0,     true,       true);
					//InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   true,    "vndr_cnt_cd",     true,          "",       dfNone,          0,     true,       true);
					//InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   true,    "vndr_seq",     true,          "",       dfNone,          0,     true,       true);
					//InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   true,    "agn_agmt_ver_seq",     true,          "",       dfNone,          0,     true,       true);
       				InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   true,    "agn_seq",     false,          "",       dfNone,          0,     true,       true);	
					CountPosition  = 0;

					//Setting Combo items[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
					InitDataCombo (0, "io_bnd_cd" , "Out|In", "O|I");
					//InitDataCombo (0, "ac_tp_cd" , "Common|Brokerage|CHF|T/S|T/R|SOC|Cross", "G|K|H|S|R|O|C");
					InitDataCombo (0, "ac_tp_cd" , ac_tp_text, ac_tp_cd);
					InitDataCombo (0, "full_mty_cd" , "Full|Empty", "F|M");
					InitDataCombo (0, "curr_cd" , "USD|JPY|AUD", "USD|JPY|AUD");
					InitDataCombo (0, "comm_pay_term_cd" , "TTL|PPD|CCT", "T|P|C");
					InitDataCombo (0, "grs_net_div_cd" , "Net|Gross", "N|G");
					
					RangeBackColor(1,5,2,17) = RgbColor(222, 251, 248);   // OPUS

					HeadRowHeight = 20 ;
					HeadRowHeight = 21 ;
					
					InitDataValid(0, "fx_comm_amt", vtNumericOther, ".");//Number와 . Insert되도록 설정
					InitDataValid(0, "bkg_comm_rt", vtNumericOther, ".");//Number와 . Insert되도록 설정
					
					sheetObj.ColHidden("cust_inp_term_cd") = true;
    				sheetObj.ColHidden("sc_inp_term_cd") = true;
    				sheetObj.ColHidden("rfa_inp_term_cd") = true;
    				sheetObj.ColHidden("sc_ofc_inp_cd") = true;
    				sheetObj.ColHidden("rfa_ofc_inp_cd") = true;
    				sheetObj.ColHidden("bkg_ofc_inp_term_cd") = true;
    				sheetObj.ColHidden("sls_ofc_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_ppd_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_clt_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_n3rd_inp_term_cd") = true;
    				sheetObj.ColHidden("lane_inp_term_cd") = true;
    				sheetObj.ColHidden("vsl_inp_term_cd") = true;

			   }
				break;
			
		}
	}

  // handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {

		   case IBSEARCH:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return false;
    			formObj.f_cmd.value = SEARCH01;
    			sheetObj.DoSearch4Post("ESM_AGT_0003GS.do", agtQryStr(formObj));				
				break;
		   case IBSEARCH02:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return false;
    			formObj.f_cmd.value = SEARCH02;
    			sheetObj.DoSearch4Post("ESM_AGT_0003GS2.do", agtQryStr(formObj));				
				break;
		   case IBSEARCH03:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return false;
    			formObj.f_cmd.value = SEARCH03;
    			sheetObj.DoSearch4Post("ESM_AGT_0003GS.do", agtQryStr(formObj));				
				break;
		   case IBSAVE:        //Save
			    if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = ADD;
				sheetObj.DoSave("ESM_AGT_0003GS2.do",agtQryStr(formObj));
				break;

		   case COMMAND01:      // Insert
		        if(!validateForm(sheetObj,formObj,sAction)) return false;
				sheetObj.DataInsert();
				break;
		  
		   case IBSAVE02:        //Save
			    if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_AGT_0003GS3.do",agtQryStr(formObj));
				break;
		  
		   case COMMAND02:      // Insert
		        if(!validateForm(sheetObj,formObj,sAction)) return false;
				sheetObj.DataInsert();
				break;

		   case IBCOPYROW:        //Row Copy
			    sheetObj.DataCopy();
			    break;
		
		   case COMMAND03:        //COPY
			    if(!validateForm(sheetObj,formObj,sAction)) return false;
//			    sheetObj.RemoveAll();
				formObj.f_cmd.value = MULTI02;
				sheetObj.DoSave("ESM_AGT_0003GS2.do",agtQryStr(formObj));
				
				formObj.f_cmd.value = SEARCH02;
    			sheetObj.DoSearch4Post("ESM_AGT_0003GS2.do", agtQryStr(formObj));
    			
				break;
		   
		   case COMMAND04:
		        if(formObj.mFlag.value == "0"){
		            sheetObj.ColHidden("cust_inp_term_cd") = true;
    				sheetObj.ColHidden("sc_inp_term_cd") = true;
    				sheetObj.ColHidden("rfa_inp_term_cd") = true;
    				sheetObj.ColHidden("sc_ofc_inp_cd") = true;
    				sheetObj.ColHidden("rfa_ofc_inp_cd") = true;
    				sheetObj.ColHidden("bkg_ofc_inp_term_cd") = true;
    				sheetObj.ColHidden("sls_ofc_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_ppd_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_clt_inp_term_cd") = true;
    				sheetObj.ColHidden("bkg_n3rd_inp_term_cd") = true;
    				sheetObj.ColHidden("lane_inp_term_cd") = true;
    				sheetObj.ColHidden("vsl_inp_term_cd") = true;
		        }else{
		            sheetObj.ColHidden("cust_inp_term_cd") = false;
    				sheetObj.ColHidden("sc_inp_term_cd") = false;
    				sheetObj.ColHidden("rfa_inp_term_cd") = false;
    				sheetObj.ColHidden("sc_ofc_inp_cd") = false;
    				sheetObj.ColHidden("rfa_ofc_inp_cd") = false;
    				sheetObj.ColHidden("bkg_ofc_inp_term_cd") = false;
    				sheetObj.ColHidden("sls_ofc_inp_term_cd") = false;
    				sheetObj.ColHidden("bkg_ppd_inp_term_cd") = false;
    				sheetObj.ColHidden("bkg_clt_inp_term_cd") = false;
    				sheetObj.ColHidden("bkg_n3rd_inp_term_cd") = false;
    				sheetObj.ColHidden("lane_inp_term_cd") = false;
    				sheetObj.ColHidden("vsl_inp_term_cd") = false;
		        }
		        				
				break;

		}
	}
    
    function sheet2_OnDblClick(sheetObj, row, col, value) {
   		var sheetObject1 = sheetObjects[1];
   		var sheetObject2 = sheetObjects[2];
        var formObject = document.form;
        
        if(sheetObject1.CellValue(row,"ibflag") == "R"){
            formObject.agn_agmt_ver_seq.value = sheetObject1.CellValue(row,"agn_agmt_ver_seq");
            doActionIBSheet(sheetObject2,formObject,IBSEARCH03);
            formObject.current.value = formObject.agn_agmt_ver_seq.value;
            formObject.total.value = sheetObject1.CellValue(2,"agn_agmt_ver_seq");
        }
        
        if(sheetObject2.RowCount > 0){
            formObject.version.value = sheetObject1.CellValue(row, "agn_agmt_ver_seq");
        }
        formObject.s_rownum.value = row;
    }  

    // Pop-up Open on handling dtPopupEdit
    
    function sheet3_OnPopupClick(sheetObj, row, col)
    {
        var formObject = document.form;
        var vndr_cnt_cd = formObject.vndr_cnt_cd.value;
        var vndr_seq = formObject.vndr_seq.value;
        var agmt_ofc_cty_cd = formObject.agmt_ofc_cty_cd.value;
        var agn_agmt_seq = formObject.agn_agmt_seq.value;
        var agmt_ofc_cd = formObject.agmt_ofc_cd.value;
        var agn_agmt_ver_seq = formObject.agn_agmt_ver_seq.value;
        
    	if ( sheetObj.ColSaveName(col) == "chg_ddct_inp_cd" ){
    		//Showing Process Pop-up  
//    		window.open("apps/opus/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//logic to handle pop-up
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
    	   var agn_seq = sheetObj.CellValue(row, "agn_seq");
    	       	   
    	   var dispaly = "0,1,1,1,1";    // Row PopUp
    	   var classId = "ESM_AGT_0005";
    	   var sheet = "4";
    	   var param = '?agmt_ofc_cd='+agmt_ofc_cd+'&vndr_cnt_cd='+vndr_cnt_cd+'&vndr_seq='+vndr_seq+'&agmt_ofc_cty_cd='+agmt_ofc_cty_cd+'&agn_agmt_seq='+agn_agmt_seq+'&agn_agmt_ver_seq='+agn_agmt_ver_seq+'&io_bnd_cd='+io_bnd_cd+'&ac_tp_cd='+ac_tp_cd+'&agn_seq='+agn_seq+'&sheet='+sheet+'&classId='+classId;
    	   var chkStr = dispaly.substring(0,3) ; 
    	        
    	   if(chkStr == "0,1") {
    	        // CheckBox PopUp (For Multi Data Optional ) => meaninglessness to sheet
    		   ComOpenPopup('/opuscntr/ESM_AGT_0005.do' + param, 760, 438, 'getESM_AGT_005_2', dispaly, true, false, row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}else if ( sheetObj.ColSaveName(col) == "cntr_inp_term_cd" ){
    		//Showing Process Pop-up  
//    		window.open("apps/opus/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//logic to handle pop-up
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
    	   var agn_seq = sheetObj.CellValue(row, "agn_seq");
    	   
    	   var dispaly = "0,1,1,1,1";    // Row PopUp
    	   var classId = "ESM_AGT_0004";
    	   var sheet = "3";
    	   var param = '?agmt_ofc_cd='+agmt_ofc_cd+'&vndr_cnt_cd='+vndr_cnt_cd+'&vndr_seq='+vndr_seq+'&agmt_ofc_cty_cd='+agmt_ofc_cty_cd+'&agn_agmt_seq='+agn_agmt_seq+'&agn_agmt_ver_seq='+agn_agmt_ver_seq+'&io_bnd_cd='+io_bnd_cd+'&ac_tp_cd='+ac_tp_cd+'&agn_seq='+agn_seq+'&sheet='+sheet+'&classId='+classId;
    	   var chkStr = dispaly.substring(0,3) ;         

    	   if(chkStr == "0,1") {
    	        // CheckBox PopUp (For Multi Data Optional ) => meaninglessness to sheet
    		   ComOpenPopup('ESM_AGT_0004.do' + param, 610, 480, 'getESM_AGT_004_2', dispaly, true, false, row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}else if ( sheetObj.ColSaveName(col) == "bkg_por_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_pol_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_pod_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_del_inp_term_cd" ){
    		//Showing Process Pop-up  
//    		window.open("apps/opus/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//logic to handle pop-up
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
    	   var rout_ref_div_cd = "";
    	   var agn_seq = sheetObj.CellValue(row, "agn_seq");
    	   
    	   if(sheetObj.ColSaveName(col) == "bkg_por_inp_term_cd"){
    	       rout_ref_div_cd = "PORL";
    	   }else if(sheetObj.ColSaveName(col) == "bkg_pol_inp_term_cd"){
    	       rout_ref_div_cd = "POLL";
    	   }else if(sheetObj.ColSaveName(col) == "bkg_pod_inp_term_cd"){
    	       rout_ref_div_cd = "PODL";
    	   }else if(sheetObj.ColSaveName(col) == "bkg_del_inp_term_cd"){
    	       rout_ref_div_cd = "DELL";
    	   }
    	   
    	   var dispaly = "0,1,1,1,1";    // Row PopUp
    	   var classId = "ESM_AGT_0006";
    	   var sheet = "5";
    	   var param = '?agmt_ofc_cd='+agmt_ofc_cd+'&vndr_cnt_cd='+vndr_cnt_cd+'&vndr_seq='+vndr_seq+'&agmt_ofc_cty_cd='+agmt_ofc_cty_cd+'&agn_agmt_seq='+agn_agmt_seq+'&agn_agmt_ver_seq='+agn_agmt_ver_seq+'&io_bnd_cd='+io_bnd_cd+'&ac_tp_cd='+ac_tp_cd+'&agn_seq='+agn_seq+'&rout_ref_div_cd='+rout_ref_div_cd+'&sheet='+sheet+'&classId='+classId;
    	   var chkStr = dispaly.substring(0,3) ;         
    	        
    	  if(chkStr == "0,1") {
    	        // CheckBox PopUp (For Multi Data Optional ) => meaninglessness to sheet
    		  ComOpenPopup('ESM_AGT_0006.do' + param, 900, 420, 'getESM_AGT_006_2', dispaly, true, false, row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}else if ( sheetObj.ColSaveName(col) == "sc_inp_term_cd" || sheetObj.ColSaveName(col) == "rfa_inp_term_cd" || sheetObj.ColSaveName(col) == "sc_ofc_inp_cd" || sheetObj.ColSaveName(col) == "rfa_ofc_inp_cd" || sheetObj.ColSaveName(col) == "lane_inp_term_cd" || sheetObj.ColSaveName(col) == "vsl_inp_term_cd" ){
    		//Showing Process Pop-up  
//    		window.open("apps/opus/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//logic to handle pop-up
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
    	   var agn_seq = sheetObj.CellValue(row, "agn_seq");
    	   var otr_ref_div_cd = "";
    	   
    	   if(sheetObj.ColSaveName(col) == "sc_inp_term_cd"){
    	       otr_ref_div_cd = "SCNO";
    	   }else if(sheetObj.ColSaveName(col) == "rfa_inp_term_cd"){
    	       otr_ref_div_cd = "RFAN";
    	   }else if(sheetObj.ColSaveName(col) == "sc_ofc_inp_cd"){
    	       otr_ref_div_cd = "SCOF";
    	   }else if(sheetObj.ColSaveName(col) == "rfa_ofc_inp_cd"){
    	       otr_ref_div_cd = "RFAO";
    	   }else if(sheetObj.ColSaveName(col) == "lane_inp_term_cd"){
    	       otr_ref_div_cd = "LANE";
    	   }else if(sheetObj.ColSaveName(col) == "vsl_inp_term_cd"){
    	       otr_ref_div_cd = "VSSL";
    	   }
    	   
    	   var dispaly = "1,0,1,1,1";    // Row PopUp
    	   var classId = "ESM_AGT_0037";
    	   var sheet = "6";
    	   var param = '?agmt_ofc_cd='+agmt_ofc_cd+'&vndr_cnt_cd='+vndr_cnt_cd+'&vndr_seq='+vndr_seq+'&agmt_ofc_cty_cd='+agmt_ofc_cty_cd+'&agn_agmt_seq='+agn_agmt_seq+'&agn_agmt_ver_seq='+agn_agmt_ver_seq+'&io_bnd_cd='+io_bnd_cd+'&ac_tp_cd='+ac_tp_cd+'&agn_seq='+agn_seq+'&otr_ref_div_cd='+otr_ref_div_cd+'&sheet='+sheet+'&classId='+classId;
    	   var chkStr = dispaly.substring(0,3) ;         
    	   
    	  if(chkStr == "1,0") {
//    		  alert(param);
    	        // CheckBox PopUp (For Multi Data Optional ) => meaninglessness to sheet
    	       	ComOpenPopup('ESM_AGT_0037.do' + param, 300, 310, 'getESM_AGT_037_2', dispaly, true, false,row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}else if ( sheetObj.ColSaveName(col) == "cust_inp_term_cd"){
    		//Showing Process Pop-up  
//    		window.open("apps/opus/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//logic to handle pop-up
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
           var agn_seq = sheetObj.CellValue(row, "agn_seq");
    	   
    	   var dispaly = "0,1,1,1,1,1,1,1,1,1";    // Row PopUp
    	   var classId = "COM_ENS_041";
    	   var sheet = "1";
    	   var param = '?sheet='+sheet+'&classId='+classId;
    	   var chkStr = dispaly.substring(0,3) ;         
    	   var showVal = sheetObj.CellValue(row, "cust_inp_term_cd");
    	       
    	  if(chkStr == "0,1") {
    	        //if(showVal != "" || showVal != null || showVal != "*"){
    	        //    showErrMessage(getMsg('AGT10007','Customer',showVal));
    	        //}
    	        // CheckBox PopUp (For Multi Data Optional ) => meaninglessness to sheet
    		  ComOpenPopup('COM_ENS_041.do' + param, 770, 470, 'getCOM_ENS_041_2', dispaly, true, false, row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}else if ( sheetObj.ColSaveName(col) == "bkg_ofc_inp_term_cd" || sheetObj.ColSaveName(col) == "sls_ofc_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_ppd_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_clt_inp_term_cd" || sheetObj.ColSaveName(col) == "bkg_n3rd_inp_term_cd"){
    		//Showing Process Pop-up  
//    		window.open("apps/opus/esm/agt/agtagreement/agtofficeagreementinfo/jsp/ESM_AGT_9999.jsp", "win", "width=300, height=200");
    		//logic to handle pop-up
    	   var io_bnd_cd = sheetObj.CellValue(row, "io_bnd_cd");
    	   var ac_tp_cd = sheetObj.CellValue(row, "ac_tp_cd");
           var agn_seq = sheetObj.CellValue(row, "agn_seq");
     	   
    	   var dispaly = "0,1,1,1,1,1,1,1,1,1";    // Row PopUp
    	   var classId = "COM_ENS_071";
    	   var sheet = "1";
    	   var param = '?sheet='+sheet+'&classId='+classId;
    	   var chkStr = dispaly.substring(0,3) ;
    	   var showVal = "";
    	            
    	   if(sheetObj.ColSaveName(col) == "bkg_ofc_inp_term_cd"){
    	       showVal = sheetObj.CellValue(row, "bkg_ofc_inp_term_cd");
    	   }else if(sheetObj.ColSaveName(col) == "sls_ofc_inp_term_cd"){
    	       showVal = sheetObj.CellValue(row, "sls_ofc_inp_term_cd");
    	   }else if(sheetObj.ColSaveName(col) == "bkg_ppd_inp_term_cd"){
    	       showVal = sheetObj.CellValue(row, "bkg_ppd_inp_term_cd");
    	   }else if(sheetObj.ColSaveName(col) == "bkg_clt_inp_term_cd"){
    	       showVal = sheetObj.CellValue(row, "bkg_clt_inp_term_cd");
    	   }else if(sheetObj.ColSaveName(col) == "bkg_n3rd_inp_term_cd"){
    	       showVal = sheetObj.CellValue(row, "bkg_n3rd_inp_term_cd");
    	   }  
    	   if(chkStr == "0,1") {
    	       //if(showVal != "" || showVal != null || showVal != "*"){
    	       //    showErrMessage(getMsg('AGT10007',sheetObj.ColSaveName(col),showVal));
    	       //}
    	       // CheckBox PopUp (For Multi Data Optional ) => meaninglessness to sheet
    		   ComOpenPopup('COM_ENS_071.do' + param, 770, 430, 'getCOM_ENS_071_2', dispaly, true, false, row, col);
    	   }else {
    		   ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
    	      	return;
    	   }
    	}

    }

    /**
	 *  In case of single Optional by Radio buttons at Pop-up..
	 */
	function getESM_AGT_001_1(rowArray) {
	    var formObject = document.form;
	    var colArray = rowArray[0];
		
		formObject.vndr_cnt_cd.value = colArray[5];
		formObject.vndr_seq.value = colArray[6];
		formObject.agmt_ofc_cty_cd.value = colArray[3];
		formObject.agn_agmt_seq.value = colArray[4];
		formObject.agmt_ofc_cd.value = colArray[7];
	}
	
	/**
	 * F.Forwarder(Customer) : In case of single Optional by Radio buttons at Pop-up..
	 */
	function getESM_AGT_004_2(rowArray, row, col) {
	    var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = "";
		for(var i = 0; i<arrayLen; i++){
		    cellVal = cellVal + rowArray[i][3] + ",";
		}
		cellVal = cellVal.substr(0, cellVal.length -1);
		sheetObj.CellValue(row, "cntr_inp_term_cd") = cellVal;
	}
	
	/**
     * COM_ENS_041 : Checking Multi Optional at Pop-up..
     */
    function getCOM_ENS_041_2(rowArray, row, col) {
     	
    	var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = "";
	    var colArray;
	    for(var i = 0; i<arrayLen; i++){
	        colArray = rowArray[i];
		    cellVal = cellVal + colArray[3] + ",";		    
		}
		cellVal = cellVal.substr(0, cellVal.length -1);
		sheetObj.CellValue(row, "cust_inp_term_cd") = cellVal;
    }
    
    /**
     * COM_ENS_071 : Checking Multi Optional at Pop-up..
     */
    function getCOM_ENS_071_2(rowArray, row, col) {
     	
    	var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = "";
	    var colArray;
	    for(var i = 0; i<arrayLen; i++){
	        colArray = rowArray[i];
		    cellVal = cellVal + colArray[3] + ",";		    
		}
		cellVal = cellVal.substr(0, cellVal.length -1);
		sheetObj.CellValue(row, col) = cellVal;
    }
	
	/**
	 * ESM_AGT_005 : Checking Multi Optional at Pop-up..
	 */
	function getESM_AGT_005_2(rowArray, row, col) {
	    var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = rowArray[0];
		sheetObj.CellValue(row, "chg_ddct_inp_cd") = cellVal;
	}
	
	/**
	 * ESM_AGT_006 : Checking Multi Optional at Pop-up..
	 */
	function getESM_AGT_006_2(rowArray, row, col) {
	    var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = rowArray[0];
	    if(sheetObj.ColSaveName(col) == "bkg_por_inp_term_cd"){
// 	       rout_ref_div_cd = "PORL";
	    	sheetObj.CellValue(row, "bkg_por_inp_term_cd") = cellVal;
 	   }else if(sheetObj.ColSaveName(col) == "bkg_pol_inp_term_cd"){
// 	       rout_ref_div_cd = "POLL";
 	      sheetObj.CellValue(row, "bkg_pol_inp_term_cd") = cellVal;
 	   }else if(sheetObj.ColSaveName(col) == "bkg_pod_inp_term_cd"){
// 	       rout_ref_div_cd = "PODL";
 	      sheetObj.CellValue(row, "bkg_pod_inp_term_cd") = cellVal;
 	   }else if(sheetObj.ColSaveName(col) == "bkg_del_inp_term_cd"){
// 	       rout_ref_div_cd = "DELL";
 	      sheetObj.CellValue(row, "bkg_del_inp_term_cd") = cellVal;
 	   }
	    
//		sheetObj.CellValue(row, col) = cellVal;
	}
	
	/**
	 * ESM_AGT_037 : Checking Multi Optional at Pop-up..
	 */
	function getESM_AGT_037_2(rowArray, row, col) {
		var sheetObj = sheetObjects[2];
	    var arrayLen = rowArray.length;
	    var cellVal = "";
	    for(var i = 0; i<arrayLen; i++){
	    	cellVal = cellVal + rowArray[i] + ",";
		}
		cellVal = cellVal.substr(0, cellVal.length -1);
		sheetObj.CellValue(row, col) = cellVal;
	}


   /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		
		switch(sAction) {

			case COMMAND01:
        		if(formObj.vndr_cnt_cd.value == ""){
        			ComShowMessage(ComGetMsg('COM12113','Agreement Office'));
        	        return false;
        		}
        		if(sheetObject1.RowCount("I") > 0){
        			ComShowMessage(ComGetMsg('AGT10008','Version Control '));
        	        return false;
        		}
        		break;
        		
        	case COMMAND02:
        		if(formObj.vndr_cnt_cd.value == ""){        		    
        			ComShowMessage(ComGetMsg('COM12113','Agreement Office'));
        	        return false;
        		}else if(sheetObject1.RowCount("R") < 1){
        			ComShowMessage(ComGetMsg('AGT10002','Version Control list','Version Control list'));
        	        return false;
        		}
        		if(formObj.agn_agmt_ver_seq.value == ""){
        			ComShowMessage(ComGetMsg('AGT10002','Version Control list','Version Control list'));
        	        return false;
        		}
        		
        		break;
        		
        	case COMMAND03:       
        		
        		if(sheetObject1.RowCount("R") == 0){
        			ComShowMessage(ComGetMsg('AGT10002','Version Control List '));
        	        return false;
        		}
        		if(sheetObject1.RowCount("I") == 0){
        			ComShowMessage(ComGetMsg('AGT10007','Agreement Copy is '));
        	        return false;
        		}
        		
        		if(formObj.version.value == ""){
        			ComShowMessage(ComGetMsg('AGT10001','Copy VERSION'));
        	        formObj.version.focus();
        	        return false;
        		}
        		
        		break;
        		
		}

		return true;
	}
//	Definition & Compensation Sheet Save  success or not
	function sheet3_OnSaveEnd(sheetObj, ErrMsg){
		var formObject = document.form;
		if(ErrMsg == ""){
			ComShowMessage(ComGetMsg('AGT00079','Success!'));
			sheet2_OnDblClick(sheetObj, formObject.s_rownum.value, 3, formObject.s_rownum.value);
		}else{
			ComShowMessage(ComGetMsg('AGT00079','Fail!'));
		}
	}
