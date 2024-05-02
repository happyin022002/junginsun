/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0004.js
*@FileTitle  : Agreement List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_lse_0004 : business script for ees_lse_0004
	 */
	/* developer job */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	var vOrcLstmCd;
	var vOrgCntrTpSzCd;
	var arrOrgCntrTpSzCd;
	var vAgmtLstmCd;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick() {
		/**********/
		var sheetObject1=sheetObjects[0];
		var comboObject1=comboObjects[0];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcObj=ComGetEvent();
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					sheetObject1.RemoveAll();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;
				case "btn_New":
					ComResetAll();
					// Setting Date.
					var vExpFromDt=ComGetObjValue(formObj.cur_year)+ComLpad(ComGetObjValue(formObj.cur_month), 2, "0")+"01";
					var vExpToDt=ComGetObjValue(formObj.cur_year)+ComLpad(ComGetObjValue(formObj.cur_month), 2, "0")+ComGetLastDay(ComParseInt(ComGetObjValue(formObj.cur_year)), ComParseInt(ComGetObjValue(formObj.cur_month)));
					ComSetObjValue(formObj.exp_from_dt, vExpFromDt);
					ComSetObjValue(formObj.exp_to_dt,   vExpToDt);
					ComAddSeparator(formObj.exp_from_dt, "ymd");
					ComAddSeparator(formObj.exp_to_dt, "ymd");
					comboObjects[0].SetSelectIndex(0);
					comboObjects[1].SetSelectIndex(0);
					break;
				case "btn_DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						//sheetObject1.Down2Excel(-1, false, false, true, "", "./apps/opus/ees/lse/containerleaseagreementregistration/agreementregistration/jsp/EES_LSE_0004_FORM.jsp?row_count="+sheetObject1.RowCount);
						// In the 4.0 Version EditMask is not useful.
						sheetObject1.Down2Excel({ SheetDesign:1, HiddenColumn:1, Merge:1 });
					}
					
					break;
				case "btns_search":
					// Lessor Search
					openPopup("3");
					break;
				case "btns_search1":
					openPopup("1");
					break;
				case "chk_lstm_cd":
					/* Lease Term 체크박스 체크시 전체체크,전체해재 기능 */
					if ( srcObj.checked ) {
						comboObject1.SetSelectCode(vOrcLstmCd.replaceStr("|", ","));
					} else {
						comboObject1.SetSelectCode("");
					}
					break;
				case "btns_calendar1":
					var cal=new ComCalendarFromTo();
					cal.select(formObj.exp_from_dt, formObj.exp_to_dt, 'yyyy-MM-dd');
					break;
			} // end switch
		} catch (e) {
			if ( e == "[object Error]") {
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
		vOrgCntrTpSzCd=ComGetObjValue(formObj.org_cntr_tpsz_cd);
		arrOrgCntrTpSzCd=vOrgCntrTpSzCd.split("|");
		//doActionIBSheet(sheetObjects[0], formObj, IBCREATE);
		
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		for( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
 		}
		/* Axon Control Setting*/
		initControl();
		
		/* Focus Setting */
		var vExpFromDt=ComGetObjValue(formObj.cur_year)+ComLpad(ComGetObjValue(formObj.cur_month), 2, "0")+"01";
		var vExpToDt=ComGetObjValue(formObj.cur_year)+ComLpad(ComGetObjValue(formObj.cur_month), 2, "0")+ComGetLastDay(ComParseInt(ComGetObjValue(formObj.cur_year)), ComParseInt(ComGetObjValue(formObj.cur_month)));
		ComSetObjValue(formObj.exp_from_dt, vExpFromDt);
		ComSetObjValue(formObj.exp_to_dt,   vExpToDt);
		ComAddSeparator(formObj.exp_from_dt, "ymd");
		ComAddSeparator(formObj.exp_to_dt, "ymd");
		sheet1_OnLoadFinish(sheet1);
	}
  	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('beforedeactivate',		'obj_blur',		formObj); 
//		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
//  	axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerFormat('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerFormat('change',		'obj_change',	formObj); 
  	}
  	/**
	 * handling Location blur event
	 */
	function obj_blur(){
		var obj=ComGetEvent();
	    switch(ComGetEvent("name")){
	        case "vndr_seq":
	            //checking number
	            ComChkObjValid(obj, true, false, false);
	            break;
	        default:
	            //checking Validation
	            ComChkObjValid(obj);
	        	break;
	    }
	}
	
	/**
	 * Onhandling event in case of Change
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				   	break;
			}
	    }
	}
	/**
	 * handling event in case of focus
	 */
	function obj_focus(){
		var obj  = ComGetEvent();
		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    //deleting data unit separator
		    ComClearSeparator(ComGetEvent());
		}
	}


	/**
	 * handling event in case of Key-Press
	 */
  	function obj_keypress() {
		var obj = ComGetEvent();

		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
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
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}

  	/**
  	 * handling event in case of Key-Up
  	 */
  	function obj_keyup() {
  		var obj = ComGetEvent();

  		switch(ComGetEvent("name")) {
 			case "vndr_seq":
  				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
  		}
  	}

   	/**
	 * handling event in case of Key-Down
	 */
   	function obj_keydown() {
   		var obj      = ComGetEvent();
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if ( vKeyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   		}
   	}
   	
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetid=sheetObj.id;
		switch(sheetid){ 
			case "sheet1":
				with (sheetObj) {
				    var HeadTitle1="Term|Lessor|AGMT No.|Payment Type|Ref No.|Contract Period|Contract Period|SLB|Year Build|Build Up|Build Down|Term|P.Term|Depr|Max Depr|Division|Level|Place|TTL|"+vOrgCntrTpSzCd+"||";
				    //var HeadTitle1="Term|Lessor|AGMT No.|Ref No.|Contract Period|Contract Period|Year Build|Division|TTL|"+vOrgCntrTpSzCd+"||";
				    var headCount=ComCountHeadTitle(HeadTitle1);
	
				    //SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:8, DataRowMerge:0 } );
				    SetConfig( { SearchMode:2, MergeSheet:2, Page:1000, FrozenCol:17, DataRowMerge:0, PrevColumnMergeMode:0 } );
	
				    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				    InitHeaders(headers, info);
				    var colsArray = [];
				    var cols = [  {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:1,   SaveName:"ref_no",        KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",        KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",        KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"slb_flg",        KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"year_built",    KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"effective_dt",  KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"expiry_dt",     KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lease_term",    KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:40,  Align:"Right",  ColMerge:1,    SaveName:"payment_term",   KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",  ColMerge:1,    SaveName:"yearly_depr",    KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",  ColMerge:1,    SaveName:"max_depr",       KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:110,   Align:"Left",  ColMerge:1,   SaveName:"type_nm",       KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",  ColMerge:1,   SaveName:"eq_loc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
					              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
					              
					              {Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl",           KeyField:0,   CalcLogic:"",   Format:"Float" ,       PointCount:2} ];
					    for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
					    	cols.push({Type:"Float",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_qty",KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 });
					    }
					    cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fst_cls",       KeyField:0,   CalcLogic:"",   Format:"" });
					    cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"type_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
					    colsArray.push(cols);
					    
					   /* for ( var RowCnt=0; RowCnt < 6 ; RowCnt++) {
					    	cols = [];
						    cols.push({Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Left",  	  ColMerge:1,  SaveName:"ref_no",        KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",        KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",        KeyField:0,   CalcLogic:"",   Format:"" });
						    
						    cols.push({Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"year_built",       KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"effective_dt",       KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"expiry_dt",       KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lease_term",        KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:60,  Align:"Right",    ColMerge:1,   SaveName:"payment_term",        KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",    ColMerge:1,   SaveName:"yearly_depr",        KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",    ColMerge:1,   SaveName:"max_depr",        KeyField:0,   CalcLogic:"",   Format:"" });
						    
						    
						    cols.push({Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"type_nm",       KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"eq_loc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ttl",           KeyField:0,   CalcLogic:"",   Format:"Integer" });
						    for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						    	cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_qty",KeyField:0,   CalcLogic:"",   Format:"Integer" });
						    }
						    cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fst_cls",       KeyField:0,   CalcLogic:"",   Format:"" });
						    cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"type_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
						    colsArray.push(cols);
					    }
					    
					    InitColumns(colsArray , 7);*/
					    InitColumns(cols);
					    SetEditable(0);
					    SetDataLinkMouse("agmt_no",1);
					    //SetRowMerge("eq_loc_tp_cd", 1);
					    //SetSheetHeight(400);
					    ComResizeSheet(sheetObj);
 				}
				break;
		}
 	}
	/**
	 * initializing IBMultiCombo
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "lstm_cd":
	        	with(comboObj) {
	            	SetDropHeight(250);
	            	SetMultiSelect(1);
	            	SetUseAutoComplete(1);
//no support[check again]CLT 	            	ValidChar(2,2);
	        	}
	        	break;
	    }
	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBCREATE:
				sheetObj.SetWaitImageVisible(0);
				/* Lease Term Form Combo Item Setting */
				ComSetObjValue(formObj.f_cmd, SEARCH01);
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		        if ( sXml != "" ) {
		        	comboObjects[1].InsertItem(0, 'ALL','ALL');
		        	LseComXml2ComboItem(sXml, comboObjects[1], "lease_term_nm", "lease_term_cd", "|");
		        }
		        vOrcLstmCd=ComGetEtcData(sXml, "lease_term_nm");
		        comboObjects[1].SetSelectIndex(0);
		        /* Focus Setting */
		        ComSetFocus(formObj.vndr_seq);
	            sheetObj.SetWaitImageVisible(1);
	            
	            formObj.f_cmd.value=SEARCH09;	
				var intgCdId='CD30090';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
			    } 
				if (xml != "") {
					var schargeType=ComGetEtcData(xml, "code_nm");
					var arrchargeType=schargeType.split("@");
					MakeComboObject(comboObjects[0], arrchargeType, 1, 0);
				}
	            break;
			case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						ComOpenWait(true);
						sheetObj.SetWaitImageVisible(0);
						
						ComSetObjValue(formObj.f_cmd, SEARCH);
						//setTimeout( function () {
							formObj.all_lstm_cd.value = "";
							if(formObj.lstm_cd.value == "ALL") {
								formObj.all_lstm_cd.value = vOrcLstmCd.replaceStr("|", ",")
							}
							
							sheetObj.DoSearch("EES_LSE_0004GS.do", FormQueryString(formObj) );
						//} , 100);
					}
				}
				break;
 			case IBSEARCH_ASYNC02:	//retrieving when input Form Lessor No.
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
 						sheetObj.SetWaitImageVisible(1);
 						if ( sXml != "" ) {
 							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
 								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
 								ComSetNextFocus(formObj.vndr_seq);
 	 						} else {
 	 							ComShowCodeMessage("LSE01019");
 	 							ComSetObjValue(formObj.vndr_seq, "");
 	 							ComSetObjValue(formObj.vndr_nm, "");
 	 							ComSetFocus(formObj.vndr_seq);
 	 						}
 						} else {
 							ComShowCodeMessage("LSE01019");
 							ComSetObjValue(formObj.vndr_seq, "");
 							ComSetFocus(formObj.vndr_seq);
 						}
 					}
 				}
 				break;
		}
	}
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}
	
	
	function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg) {
		sheetObj.SetWaitImageVisible(1);
		
		if(sheet1.RowCount() > 0) {
			
            for ( var i=1 ; i <= sheetObj.RowCount() ; i++ ) {
            	if(sheetObj.GetCellValue(i,"ttl") > 0) {
            		sheetObj.SetCellFontColor(i, "ttl", "#FF0000");
            	}else{
            		sheetObj.SetCellFontColor(i, "ttl", "#B2B2B2");
            	}
            	
            	for ( var j = 0 ; j < arrOrgCntrTpSzCd.length ; j++ ) {
        			if(sheetObj.GetCellValue(i,"cntr"+(j+1)+"_qty") > 0) {
        				sheetObj.SetCellFontColor(i, "cntr"+(j+1)+"_qty", "#FF0000");
        			}else{
        				sheetObj.SetCellFontColor(i, "cntr"+(j+1)+"_qty", "#B2B2B2");
        			}
        		}
            		
            	//sheetObj.SetMergeCell(1, 2, 5, 1);
            	
            	/*if(sheetObj.GetCellValue(i,"type_nm") == "Contract QTY" || sheetObj.GetCellValue(i,"type_nm") == "Lease Out" || sheetObj.GetCellValue(i,"type_nm") == "Current QTY") {
            		 //for ( var j = 0 ; j < arrOrgCntrTpSzCd.length ; j++ ) {
					     //alert("cntr"+(j+1)+"_qty");
            			 sheetObj.InitCellProperty(i,"cntr1_qty", { Type:"Int" ,  PointCount:0});
            			 sheetObj.InitCellProperty(i,"cntr2_qty", { Type:"Int" ,  PointCount:0});
            			 sheetObj.InitCellProperty(i,"cntr3_qty", { Type:"Int" ,  PointCount:0});
            			 sheetObj.InitCellProperty(i,"cntr4_qty", { Type:"Int" ,  PointCount:0});
            			 
            		// }
            	}*/
            }
		}
		
		ComOpenWait(false);


	}
    /**
	 * handling process for Container Type/Size Column 
	 * @param vSelectedCntrTpSz
	 * @param targetSheetObj
	 */
	function setCntrTypeSizeColumns(vSelectedCntrTpSz, targetSheetObj) {
		var vShowSheetWidth=0;
		var vStartCntrColIdx=0;
		if ( vSelectedCntrTpSz != "" ) {
			with(targetSheetObj) {
				if ( FrozenCols == 0 ) {
					vStartCntrColIdx=1;
				} else {
					vStartCntrColIdx=FrozenCols;
				}
				/* calculation with-column in case of Frozen */
				for ( var colIdx=0 ; colIdx < vStartCntrColIdx ; colIdx++ ) {
					if ( GetColHidden(colIdx) == false ) {
						vShowSheetWidth=vShowSheetWidth + GetColWidth(colIdx);
					}
				}
				RenderSheet(0);
				/* calculation with-column in case of Container Type/Size */
				for ( var colIdx=vStartCntrColIdx ; colIdx <= LastCol(); colIdx++ ) {
					if ( GetCellValue(0, colIdx) != "" ) {
						if ( vSelectedCntrTpSz.match(GetCellValue(0, colIdx)) ) {
							if ( GetColHidden(colIdx) == true ) {
								SetColHidden(colIdx,0);
							}
							vShowSheetWidth=vShowSheetWidth + GetColWidth(colIdx);
						} else {
							if ( GetColHidden(colIdx) == false ) {
								for ( var i=HeaderRows(); i <= LastRow(); i++ ) {
									SetCellValue(i, colIdx,"",0);
								}
								SetColHidden(colIdx,1);
							}
						}
					}
				}
				if ( RowCount()>= ViewRows ) {
					vShowSheetWidth=vShowSheetWidth + 20;
				} else {
					vShowSheetWidth=vShowSheetWidth + 10;
				}
				if ( vShowSheetWidth > mainTable.clientWidth-20 ) {
					SheetWidth=mainTable.clientWidth-20;
				} else {
					SheetWidth=vShowSheetWidth;
				}
				RenderSheet(1);
			}
		}
		targetSheetObj.SetVisible(1);
	}
	/**
     * handing process Pop-up<br>
     * @param type 1:Location for FORM, 2:Agreement No. Selection for FORM, 3:Lessor for FORM
     * @param object
     * @param Row index
     */
    function openPopup(type, Row, Col) {
    	 if ( type == "3" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "1") {
    		var formObj=document.form;
    		var sUrl='/opuscntr/COM_ENS_071.do';
			var iWidth=855;
			var iHeight=435;
			var sTargetObjList="ofc_cd:ofc_cd";
			var sDisplay="1,0,1,1,1,1,1,1";
			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
    	}
    }
	/**
	 * handling process for Lessor(Service Provider) Pop-up Return Value<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj=sheetObjects[SheetIdx];
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	switch(sAction) {
    		case IBSEARCH:
    			if ( ComGetObjValue(lstm_cd) == "" ) {
    				ComShowCodeMessage("LSE01009");
     				ComSetFocus(lstm_cd);
    				return false;
    			}
    			return ComChkValid(formObj);
    			break;
		}
		return true;
	}
    /**
	 * handling process for Form Element Clear<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		switch(fieldName) {
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetObjValue(formObj.vndr_nm,  "");
				break;
		}
	}
	/* end of developer job */
	
	
	/**
     * MultiSelect?띿꽦???댁슜?섎뒗 寃쎌슦, checking諛뺤뒪瑜??대┃?섎뒗 ?쒓컙 諛쒖깮?쒕떎.
     * @return
     */
    function lstm_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
    /**
     * creating combo object(Spec No * Type/Size)
     */
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
    	cmbObj.RemoveAll();
    	cmbObj.InsertItem(0, "ALL", "ALL");
    	for (var i=0; i<arrStr.length; i++) {
    		var arrCode=arrStr[i].split("|");
    		cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
    	}
    	cmbObj.SetSelectIndex(0 ,true);
    }
