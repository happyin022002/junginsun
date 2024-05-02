/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0028.js
*@FileTitle  : Mis Use In & Out Approval
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_LSE_0028 : business script for EES_LSE_0028
     */

   	/* developer job */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	//file up load Object Array
	var uploadObjects=new Array();
	var uploadCnt=0;
	var uploadFileSeq="";
	var fileUploadFlag=false;
	var fileSaveFlag=false;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
    function processButtonClick(){
         /**********/
         var sheetObject=sheetObjects[0];
         var comboObject=comboObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_retrive":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				case "btn_new":
					ComResetAll();
					formObject.rqst_no.value = "";
					formObject.apro_no.value = "";
					sheetObject.SetColHidden("sheet1_agmt_no",0);
					/* registering in Approval Number */
    				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
					ComSetFocus(comboObject);
				break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
	 * registering IBMultiCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}

    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		var formObj=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		initUpload();

	    sheet1_OnLoadFinish(sheet1);
    }
    
    var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/LSE_INTGS.do'
 			,Files:[
 			]
	 		,BeforeAddFile : function(result){ 
	 			return true;
			}
 			,AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
				  	var prefix=pSheetObj.id +"_";
	      			uploadFileName=ComGetEtcData(sXml,"filename");
	      			pSheetObj.SetCellValue(pRow, prefix +"apro_file_sav_id",uploadFileName,0);
	 				fileUploadFlag=false;
	      		}else {
					ComShowMessage(result.msg);
				}
				ComOpenWait(false);		
 			}
	 		,AfterAddFile:function(result){
	 			var files = result.files;
				var fileName= files[files.length-1].GetFileName();
			  	var prefix=pSheetObj.id +"_";
				ComOpenWait(true);
 		 		fileUploadFlag=true;
 		 		pSheetObj.SetCellValue(pRow, prefix +"apro_file_sav_nm",fileName,0);

	 			upload1.SaveStatus();
			}
 		});
 	}
    
	/**
	 * handling event when OnMouseMove Sheet.
	 */
    function sheet1_OnMouseMove(sheetObj, e) {
	  	  var row     = sheet1.MouseRow(),
	        col     = sheet1.MouseCol(),
	        info    = null;

	  	  var saveName = sheet1.ColSaveName(col);
	  	  var prefix=sheetObj.id +"_";
	  	  var linkFlag=sheetObj.GetCellValue(row, col) != "";
	  	  sheetObj.SetDataLinkMouse(prefix +"rqst_file_sav_nm",linkFlag);
			
	      if (row > 0 && saveName==prefix+"apro_file_sav_nm") {
				if ( fileUploadFlag ) {
		    		return;
		    	}

	            info = sheet1.GetCellElement(row, col, 1);
	            
	    		pSheetObj = sheetObj;
				pRow = row;
				pCol = col;

	            upload1.SetFileUploadElement(info);
	  	  }
	  }

    
    /**
	 * calling event after Load-Finish
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
     	/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
        /* Axon Control Setting*/
    	initControl();
    	/* registering after Approval Number */
    	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
    	/* Focus Setting */
    	ComSetFocus(formObj.combo1);
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
//		axon_event.addListenerForm('keydown',		'obj_keydown',		formObj); 	
		axon_event.addListenerForm('mouseover',		'obj_mouseover',	formObj);
		axon_event.addListenerForm('click',			'obj_click',		formObj);
  	}
   	/**
     * handling event in case of Mouse-Over
     */
   	function obj_mouseover() {
		var obj=ComGetEvent();
  		var vKeyCode=event.keyCode;
  		var formObj=document.form;
  		if(obj.name == "rqst_usr_id") {
  			obj.style.cursor=obj.value != "" ? "Hand" : "Arrow";
  		}
   	}
   	/**
     * handling event in case of Click
     */
   	function obj_click() {
   		var obj=ComGetEvent();
  		var vKeyCode=event.keyCode;
  		var formObj=document.form;
  		switch(ComGetEvent("name")) {
  			case "apro_usr_id":
  			case "rqst_usr_id":
  				if(obj.value != "") {
					ComUserPopup(obj.value);
  				}
  				break;
  		}
   	}
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetId=sheetObj.id;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
	                var prefix=sheetId +"_";

	                var HeadTitle="|* APP Mode |Approval No.|* APP AGMT No. |* APP AGMT No. |APP\nLease Term||CNTR No.|AGMT No.|TP/SZ|Lease\nTerm|MVMT|POD|POL|MU O/I Date|MU By / From|Yard|Per Diem|Handle On\nCharge|Liable Party|Request Reason|Request File Attachment||APP/REJ Reason|APP/REJ File Attachment|";
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mss_usd_apro_mod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"apro_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"apro_agmt_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"apro_agmt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"apro_lstm_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rqst_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lstm_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mvmt_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mss_usd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mss_usd_fm_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mss_use_plc_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pd_chg_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
	                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lft_chg_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
	                       {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:1,   SaveName:prefix+"libor_pty_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"rqst_rsn_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:prefix+"rqst_file_sav_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"rqst_file_sav_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"apro_rsn_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:100 },
	                       {Type:"Popup",     Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"apro_file_sav_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"apro_file_sav_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                InitColumns(cols);
	                SetEditable(1);
	                SetColProperty(prefix+"mss_usd_apro_mod_cd", {ComboText:"APP|REJ", ComboCode:"A|R"} );
	                SetShowButtonImage(1);
	                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	                SetColProperty(prefix+"apro_agmt_cty_cd", {color: "#FF0000"});
	                //SetColProperty(prefix+"agmt_seq" , {AcceptKeys:"N"});
	                //SetSheetHeight(210);
	                ComResizeSheet(sheetObj, 180);
               }
                break;
        }
    }
    /**
	 * initializing IBMultiCombo
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "combo1":
	        	with(comboObj) {
	            	SetDropHeight(130);
	            	SetMultiSelect(0);
	            	//MaxSelect = 1;
	            	SetMultiSeparator(",");
//no support[implemented common]CLT 	            	SelectBackColor="#eeeeee";
	            	SetSelectFontColor("#000000");
	        	}
	        	break;
	    }
	}
  	/**
	 * handling process for Sheet
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBCREATE:
				//Request Number Combo Item Setting
	        	sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("EES_LSE_0028GS.do",FormQueryString(formObj));
		        sheetObj.SetWaitImageVisible(1);
				if(sXml != "") {
					if ( ComGetEtcData(sXml, "rqst_no") != "" ) {
						comboObjects[0].RemoveAll();
						comboObjects[0].InsertItem(0, '');
						LseComXml2ComboItem(sXml, comboObjects[0], "rqst_no", "rqst_no", "|");
					} else {
						comboObjects[0].RemoveAll();
						comboObjects[0].InsertItem(0, '');
					}
				}
	            break;
			case IBSEARCH:
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						sheetObj.DoSearch("EES_LSE_0028GS.do",FormQueryString(formObj)+ "&IBPREFIX=sheet1_" );
					}
				}
				break;
			case IBSEARCH_ASYNC01:
				//Approval No Setting
				sheetObj.SetWaitImageVisible(0);
				var param="f_cmd="+SEARCH01+"&ofc_cd="+ComGetObjValue(formObj.apro_ofc_cd);
				var sXml=sheetObj.GetSearchData("EES_LSE_0028GS.do",param);
				sheetObj.SetWaitImageVisible(1);
				if(sXml != "") {
					if ( ComGetEtcData(sXml, "apro_no") != undefined ) {
						if ( ComGetEtcData(sXml, "apro_no") != "" ) {
							var vAproNo=ComGetEtcData(sXml, "apro_no");
							ComSetObjValue(formObj.apro_no,  vAproNo);
						} else {
							ComShowCodeMessage("LSE01048");
							formObj.apro_no.value="";
						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						formObj.apro_no.value="";
					}
				}
				break;
			case IBSAVE:
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=MULTI;
						sheetObj.DoAllSave("EES_LSE_0028GS.do", FormQueryString(formObj));
					}
				}
				break;
        }
    }
	/**
	 * handling event when changing Sheet.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		with(sheetObj) {
			var prefix=sheetObj.id +"_";
			var sName=ColSaveName(Col);
			switch(sName) {
				case prefix +"mss_usd_apro_mod_cd":
					if(Value == "A") {
						SetCellValue(Row, prefix +"apro_no",formObj.apro_no.value,0);
						SetCellValue(Row, prefix +"apro_agmt_cty_cd","HHO",0);
						SetCellEditable(Row, prefix +"apro_agmt_seq",1);
					} else {
						SetCellValue(Row, prefix +"apro_no","",0);
						SetCellValue(Row, prefix +"apro_agmt_cty_cd","",0);
						SetCellValue(Row, prefix +"apro_agmt_seq","",0);
		 				SetCellValue(Row, prefix +"apro_lstm_cd","",0);
						SetCellEditable(Row, prefix +"apro_agmt_seq",0);
					}
					break;
				case prefix +"apro_agmt_seq":
					if(GetCellValue(Row,Col) != "") {
						var param="f_cmd="  + SEARCH03
 								 + "&agmt_cty_cd=HHO"+ "&agmt_seq="+ GetCellValue(Row,Col);
						SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
 						SetWaitImageVisible(1);
 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "agmt_seq") != undefined) {
				 				if (ComGetEtcData(sXml, "agmt_seq") != "") {
				 					SetCellValue(Row,Col,ComGetEtcData(sXml, "agmt_seq"),0);
				 					SetCellValue(Row, prefix +"apro_lstm_cd",ComGetEtcData(sXml, "lstm_cd"));
		 						} else {
		 							ComShowCodeMessage("LSE01039");
		 							SetCellValue(Row,Col,"",0);
		 							SetCellValue(Row, prefix +"apro_lstm_cd","",0);
		 						}
 							} else {
 								var errMsg=LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								SetCellValue(Row,Col,"",0);
 								SetCellValue(Row, prefix +"apro_lstm_cd","",0);
 								SelectCell(Row,Col);
 							}
 						}
					} else {
						SetCellValue(Row, prefix +"apro_lstm_cd","",0);
					}
					break;
				case prefix +"apro_lstm_cd":
					var vIoModCode=ComGetObjValue(formObj.mss_rqst_io_mod_cd);
					if(GetCellValue(Row,Col) != "") {
						if(vIoModCode == "O" && Value != "MO") {//MUO
							ComShowCodeMessage("LSE10007", "MO");
							SetCellValue(Row,prefix +"apro_agmt_seq","",0);
 							SetCellValue(Row,Col,"",0);
						} else if(vIoModCode == "I" && Value != "MI") {//MUI
							ComShowCodeMessage("LSE10007", "MI");
							SetCellValue(Row,prefix +"apro_agmt_seq","",0);
 							SetCellValue(Row,Col,"",0);
						} else {
							//do nothing
						}
					}
					break;
			}
 		}
 	}
 	/**
 	 * handling event when OnPopuphandling Sheet.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
 			var prefix=sheetObj.id +"_";
			var sName=ColSaveName(Col);
			switch(sName) {
				case prefix +"apro_agmt_seq":	//Agreement No Pop-up
					openPopup("1", Row, Col);
					break;
			}
 		}
    }
    /**
     * handling event when OnValidation Sheet.
     * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		var prefix=sheetObj.id +"_";
    		//mandatory item
    		if(GetCellValue(Row, prefix +"mss_usd_apro_mod_cd") == "") {
				ComShowCodeMessage("LSE01042");
				ValidateFail(true);
		        SelectCell(Row, prefix +"mss_usd_apro_mod_cd");
				return;
			}
    		if(GetCellEditable(Row, prefix +"apro_agmt_seq") && GetCellValue(Row, prefix +"apro_agmt_seq") == "") {
				ComShowCodeMessage("LSE01006");
				ValidateFail(true);
		        SelectCell(Row, prefix +"apro_agmt_seq");
				return;
			}
    	}
    }

	/**
	 * handling event when OnClick Sheet.
	 */
	function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var prefix=sheetObj.id +"_";
//		if(sheetObj.GetMousePointer!= "Hand") return;
		with(sheetObj) {
			if(GetCellText(Row, sName.replace("_nm", "_id")) != "") {
                switch(sName) {
                    case prefix +"rqst_file_sav_nm":
                        location.href="/opuscntr/FileDownload?key="+GetCellText(Row, prefix +"rqst_file_sav_id");
                        break;
                    case prefix+"apro_file_sav_nm":
                        location.href="/opuscntr/FileDownload?key="+GetCellText(Row, prefix +"apro_file_sav_id");
                        break;
                }
			}
		}
	}
    /**
     * handling after saving
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE10001");
    		// initializing after saving
    		ComResetAll();
    		/* IBMulti Combo Item Setting */
			doActionIBSheet(sheetObj, formObj, IBCREATE);
			/* registering after Approval Number */
			doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
			ComSetFocus(formObj.combo1);
    	}
    }
	/**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
    	with(sheetObj) {
			var prefix=sheetObj.id +"_";
	    	ComSetObjValue(formObj.cntr_cnt, SearchRows());
	    	SetColFontColor(prefix +"rqst_file_sav_nm","#0000FF");
    	}
    }
	/**
	 * combo1_OnBlur
	 */
	function combo1_OnBlur() {
		var formObj=document.form;
		formObj.rqst_no.value=ac;
	}
	/**
	 * combo1_OnChange
	 */
	var ac = "";
	function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(comboObj) {
			if(newText != "") {
				var param="f_cmd="  + SEARCH03 + "&rqst_no="+ newText;
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_LSE_0028GS.do",param);
				sheetObj.SetWaitImageVisible(1);
				if (sXml != "") {
 					if (ComGetEtcData(sXml, "rqst_no") != undefined) {
		 				if (ComGetEtcData(sXml, "rqst_no") != "") {
							
		 					ComSetObjValue(formObj.rqst_no, ComGetEtcData(sXml, "rqst_no"));
							ComSetObjValue(formObj.ref_ofc_cd, ComGetEtcData(sXml, "ref_ofc_cd"));
							ComSetObjValue(formObj.n1st_ref_ofc_cd, ComGetEtcData(sXml, "n1st_ref_ofc_cd"));
							ComSetObjValue(formObj.n2nd_ref_ofc_cd, ComGetEtcData(sXml, "n2nd_ref_ofc_cd"));
							ComSetObjValue(formObj.n3rd_ref_ofc_cd, ComGetEtcData(sXml, "n3rd_ref_ofc_cd"));
							ComSetObjValue(formObj.n4th_ref_ofc_cd, ComGetEtcData(sXml, "n4th_ref_ofc_cd"));
							ComSetObjValue(formObj.rqst_ofc_cd, ComGetEtcData(sXml, "rqst_ofc_cd"));
							ComSetObjValue(formObj.rqst_usr_id, ComGetEtcData(sXml, "rqst_usr_id"));
							ComSetObjValue(formObj.rqst_dt, ComGetEtcData(sXml, "rqst_dt"));
							ComSetObjValue(formObj.curr_cd, ComGetEtcData(sXml, "curr_cd"));
							ComSetObjValue(formObj.mss_rqst_io_mod_cd, ComGetEtcData(sXml, "mss_rqst_io_mod_cd"));
							ComSetObjValue(formObj.diff_rmk, ComGetEtcData(sXml, "diff_rmk"));
							ComSetObjValue(formObj.apro_rmk, "");
 						} else {
 							ComShowCodeMessage("LSE01048");
 							ComResetAll();
 						}
					}
 					else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
 						ComResetAll();
					}
				}
			} else {
				ComResetAll();
				/* registering after Approval Number */
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
				ComSetFocus(comboObj);
			}
			sheetObj.SetColHidden("sheet1_agmt_no",ComGetObjValue(formObj.mss_rqst_io_mod_cd) == "I");
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		form.combo1_text.value = newText;
		ac = newText;
	}
//	function combo1_OnBlur() {
//		 document.form.combo1_text.value = ac;
//		}
	/**
     * handing process Pop-up<br>
     * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
     * @param object
     * @param Row index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement',  '1,0', false, false, Row, Col, 0);
    	}
    	return;
    }
  	/**
     * handing process in Agreement Pop-up Return Value<br>
     * @param {arry} returnedValues Pop-up Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index 
     */
    function setPopData_Agreement(aryPopupData, Row, Col, sheetIdx) {
    	if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var formObj=document.form;
				var prefix=sheetObjects[sheetIdx].id +"_";
				var vLeaseTerm=aryPopupData[0][7];
				var vIoModCode=ComGetObjValue(formObj.mss_rqst_io_mod_cd);
				if(vIoModCode == "O" && vLeaseTerm != "MO") {//MUO
					ComShowCodeMessage("LSE10007", "MO");
					SetCellValue(Row,prefix +"apro_agmt_seq","",0);
					SetCellValue(Row,prefix +"apro_lstm_cd","",0);
				} else if(vIoModCode == "I" && vLeaseTerm != "MI") {//MUI
					ComShowCodeMessage("LSE10007", "MI");
					SetCellValue(Row,prefix +"apro_agmt_seq","",0);
					SetCellValue(Row,prefix +"apro_lstm_cd","",0);
				} else {
					SetCellValue(Row, prefix +"apro_agmt_seq",aryPopupData[0][5],0);
					SetCellValue(Row, prefix +"apro_lstm_cd",aryPopupData[0][7],0);
				}
			}
		}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch(sAction) {
    			case IBSEARCH:
	    			if ( formObj.rqst_no.value == "" ) {
						ComShowCodeMessage("LSE01077");
						ComSetFocus(formObj.combo1);
						return false;
						break;
					}
    				return ComChkValid(formObj, false);
    				break;
    		}
        }
        with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}
        return true;
    }
    /**
	 * handling process for Form Element Clear.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		switch(fieldName) {
			default :	//do nothing
		}
	}
	/* end of developer job */
