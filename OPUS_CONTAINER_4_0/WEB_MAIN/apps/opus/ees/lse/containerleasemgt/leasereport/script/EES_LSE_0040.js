/*=========================================================
 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0040.js
*@FileTitle  : Off Hire Result-Average using Day 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class EES_LSE_0040 : business script for EES_LSE_0040
	 */

	/* developer job */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	var vCntrTpszHdr="| | | | | | | | | | | | | | | | | | | | | | | | | | | | | |";
	var vArrCntrTpsz=vCntrTpszHdr.split("|");
	var vCntrTpszCnt=vArrCntrTpsz.length;
	var vOrcLstmCd="";
   	var vOrcCntrTpszCd="";
   	var iPageNo = 1;
   	var appendPageNo = 1;
   	var appendCondParam = "";
   	var rtv_total = 0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
    function processButtonClick(){
         /**********/
         var sheetObject1=sheetObjects[0];
		 var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcObj=ComGetEvent();
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":
					dcondTD.innerHTML="&nbsp;"
					sheetObject2.RemoveAll();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;
				case "btn_New":
					dcondTD.innerHTML="&nbsp;"
					ComResetAll();
					sheetObject1.SheetWidth=984;
					for( var i=1; i < vCntrTpszCnt; i++ ) {
						if(vArrCntrTpsz[i] != "") {
							eval('sheetObject1.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
						} else {
							eval('sheetObject1.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
						}
					}
					//setDefaultComboCheck(comboObjects[0]);
					ComSetFocus(formObj.str_evnt_dt);
					rtv_total="0";
		        	ComBtnDisable("btn_more");
					break;
				case "btn_more":
		            doActionIBSheet1(sheetObjects[1], formObj, IBSEARCHAPPEND, appendCondParam, appendPageNo);
		            break;
				case "btn_DownExcel":
					//sheetObject1.SpeedDown2Excel(-1);
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
						}
					break;
				case "btn_DownExcel2":
					if(sheetObject2.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
						}
					break;
				case "btns_search": // Form Lessor Search
					openPopup("1");
					break;
				case "btns_search2": // Form Lease Agreement Search
					openPopup("2");
					break;
				case "btns_calendar":	// Event Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal=new ComCalendarFromTo();
						cal.select(formObj.str_evnt_dt, formObj.end_evnt_dt, 'yyyy-MM-dd');
					}
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
        /* IBSheet 초기화 */
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
		 for( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
 		}
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		sheet1_OnLoadFinish(sheet1);
		sheet2_OnLoadFinish(sheet2);
		ComBtnDisable("btn_more");
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
		/* Focus Setting */
		ComSetFocus(formObj.str_evnt_dt);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC08); //페이징 갯수 가져오기
    }
    
    
    /**
	 * calling event after Load-Finish
	 */
    function sheet2_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* Container Type Size Dynamic Header Setting */
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
		/* setting IBSheet */
		ComConfigSheet (sheetObjects[0] );
		initSheet(sheetObjects[0],1);
		ComEndConfigSheet(sheetObjects[0]);
    }
    
    
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
//		axon_event.addListenerForm('focus',			'obj_focus',	formObj); 
//  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerFormat('change',		'obj_change',	formObj); 
  	}
	//setting event Duplicate
	var preEventType=null;
  	/**
	 * handling Location blur event
	 */
	function obj_blur(){
		var obj=ComGetEvent();
		var formObj=document.form;
		if(preEventType == event.type) {
			preEventType=null;
			return;
		}
	    switch(ComGetEvent("name")){
	    	case "vndr_seq" :
	    		if(formObj.vndr_seq.value == "") {
	    			formObj.vndr_abbr_nm.value = "";
	    			formObj.vndr_nm.value = "";
	    		}
	    		ComChkObjValid(obj, true, false, false);
	    		break;
	    	case "agmt_seq" :
	    		/* checking number */
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
		switch(ComGetEvent("name")) {
  			case "str_evnt_dt":
    		case "end_evnt_dt":
    			checkDurationDate(obj);
	    		break;
			case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
  				break;
			case "agmt_cty_cd":	//Agreement No.
				if ( ComTrim(obj.value) != "" && (formObj.agmt_seq.value != null && formObj.agmt_seq.value != "") ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
				}
				break;
  			case "agmt_seq":	//Agreement No.
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
					var vagmt_seq = formObj.agmt_seq.value;
	  				formObj.agmt_seq.value = ComLpad(vagmt_seq, 6, "0");
				}else{
					clearForm("agmt_seq");
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
		var sheetid=sheetObj.id;
        switch(sheetid) {
            case "sheet1":
                with (sheetObj) {
	                var HeadTitle="AGMT No.|||Ref No.||Lessor|DIV|Total"+ vCntrTpszHdr +"|";
	                var headCount=ComCountHeadTitle(HeadTitle);
//	                (headCount, 8, 0, true);
	                for(var j=0; j < 3; j ++) {
	                cnt=0;
	
	                SetConfig( { SearchMode:2, MergeSheet:2, Page:1000, DataRowMerge:0 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"agmt_no",       KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",      KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",        KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rst_div",       KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"tpsz_total",    KeyField:0,   CalcLogic:"",   Format:"Integer" } ];
	                	for(var i=1; i < vCntrTpszCnt; i++) {
	                		var tpsz_dp_no="tpsz_dp"+ ComLpad(i, 2, "0");
	                		cols.push({Type:"Int", Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:tpsz_dp_no,      KeyField:0,   CalcLogic:"",   Format:"Integer" });
	                		if(vArrCntrTpsz[i] != "") {
	                			eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
	                		} else {
	                			eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
	                		}	                	
	                	}
	                	//cols.push({Type:"int",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"auto_sum",      KeyField:0,   CalcLogic:"",   Format:"Integer" });
	                	InitColumns(cols);
                		SetEditable(0);
	                }
	                SetColHidden("auto_sum",1);
	                SetSheetHeight(280);
				}
				break;
            case "sheet2":
                with (sheetObj) {

	                var HeadTitle="Seq.|CNTR No.|TP/SZ|AGMT No.|Ref No.|Term|MVMT\nSTS|On-hire\nDate|On-hire\nYard|Free\nDays|Off-hire\nDate|Off-hire\nYard|Used\nDays|Current\nYard|MT Drayage\nCost|Term\nChange|"
	                + "Direct\nInterchange In|Immediate\nExit|Rental\nCharge|LON|PUC|PCR|LOF|MIN\nO/H Days|DOC|DCR|On-hire\nDrayage|Off-hire\nDrayage|M&R Cost|DPP|G.TTL";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                //(headCount, 5, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"" },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ref_no",             KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"on_hr_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                          {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"on_hr_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"rntl_chg_free_dys",  KeyField:0,   CalcLogic:"",   Format:"Integer" },
                          {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"off_hr_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                          {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"off_hr_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"used_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer" },
                          {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mt_drayage_cost",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"term_chg_flg",       KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"CheckBox",  Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"dii_flg",            KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"imdt_ext_flg",       KeyField:0,   CalcLogic:"",   Format:"" },
                          {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"pdm_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"lon_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"puc_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"pcr_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"lof_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"min_oh_days",        KeyField:0,   CalcLogic:"",   Format:"Integer" },
                          {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"doc_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"dcr_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"onh_drayage_cost",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"offh_drayage_cost",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_cost",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"dpp_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                          {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
                 
                	InitColumns(cols);

                    SetEditable(0);
                    SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	                SetSheetHeight(228);
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
	            	SetDropHeight(250);
	            	SetMultiSelect(1);
	            	SetMultiSeparator(",");
	            	Style=0;
             		SetUseAutoComplete(1);
             		SetMaxLength(2);
	            	SetSelectFontColor("#000000");
	        	}
	        	break;
	        case "combo2":
	        	with(comboObj) {
	            	SetDropHeight(200);
	            	SetMultiSelect(1);
	            	SetMultiSeparator(",");
	            	Style=0;
             		SetUseAutoComplete(1);
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
    function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBCREATE:
	        	sheetObj.SetWaitImageVisible(0);
	        	//Lease Term Combo Item Setting
				formObj.f_cmd.value=SEARCH01;
				var sXml_1=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
				//Container Type/Size Combo Item Setting Start
				formObj.f_cmd.value=SEARCH02;
				var sXml_2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		        sheetObj.SetWaitImageVisible(1);
				if(sXml_1 != "") {
					comboObjects[0].InsertItem(0 , 'ALL','');
					LseComXml2ComboItem(sXml_1, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
					vOrcLstmCd=ComGetEtcData(sXml_1, "lease_term_cd");
					//SetDefaultComboCheck(comboObjects[0]);
				}
	            if ( sXml_2 != "" ) {
	            	comboObjects[1].InsertItem(0 , 'ALL','');
	            	LseComXml2ComboItem(sXml_2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	            	vOrcCntrTpszCd=ComGetEtcData(sXml_2, "cntr_tpsz_cd");
	            }
	            break;
           case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						formObj.lstm_cd.value=ComGetObjValue(comboObjects[0]);
						formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObjects[1]);
						sheetObj.SetWaitImageVisible(0);
	         			ComOpenWait(true);
	         			
	         			setTimeout( function () {
		         			var sXml=sheetObj.GetSearchData("EES_LSE_0040GS.do", FormQueryString(formObj)+"&co_cre_flg=" + ComGetObjValue(formObj.com_cre_flg));
		         			
							if (ComGetTotalRows(sXml) > 1) {
								var comboVal=ComGetObjValue(comboObjects[1]);
								if ( comboVal != "" ) {
									for ( var i=1 ; i < vCntrTpszCnt ; i++ ) {
										
										sheetObj.SetColHidden("tpsz_dp"+ ComLpad(i, 2, "0") + "",1);
									}
									var arrComboVal=comboVal.split(",");
									for ( var i=0 ; i < arrComboVal.length ; i++ ) {
										for( var j=1; j < vCntrTpszCnt; j++ ) {
											if(arrComboVal[i] == vArrCntrTpsz[j]) {
												
												sheetObj.SetColHidden("tpsz_dp"+ ComLpad(j, 2, "0") + "",0);
												break;
											}
										}
									}
								} else {
									for( var i=1; i < vCntrTpszCnt; i++ ) {
										if(vArrCntrTpsz[i] != "") {
											sheetObj.SetColHidden("tpsz_dp"+ ComLpad(i, 2, "0") + "",0);
										} else {
											sheetObj.SetColHidden("tpsz_dp"+ ComLpad(i, 2, "0") + "",1);
										}
									}
								}
								sheetObj.RenderSheet(0);
								sheetObj.LoadSearchData(sXml,{Sync:1} );
								if(sheetObj.SearchRows()> 0) {
	//								sheetObj.RowDelete(sheetObj.LastRow()-5, false);
	//								sheetObj.RowDelete(sheetObj.LastRow()-4, false);
	//								sheetObj.RowDelete(sheetObj.LastRow()-3, false);
									sheetObj.SetMergeCell(sheetObj.LastRow()-2, 0, 3, 6);
									sheetObj.SetCellValue(sheetObj.LastRow()-2, "agmt_no","G.TTL",1);
								}
								sheetObj.RenderSheet(1);
								ComOpenWait(false);
							}
							else{
								//sheetObj.LoadSearchData("<SHEET><DATATOTAL='0'></DATA></SHEET>",{Sync:0} );
								sheetObj.LoadSearchData(sXml,{Sync:1} );
							}
							ComOpenWait(false);
	         			} , 100);
					}
					
				}
				break;
			case IBSEARCH_ASYNC01:	//retrieving when input Form Lessor No.
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					iPageNo = 1;
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetObjValue(formObj.vndr_abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
							ComSetFocus(formObj.vndr_nm);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							clearForm("vndr_seq");
 						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						clearForm("vndr_seq");;
					}
				}
				break;
			case IBSEARCH_ASYNC02:	//retrieving when input Form Agreement No.
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						var param="f_cmd="+SEARCH03+"&agmt_cty_cd="+ComGetObjValue(formObj.agmt_cty_cd)
 								  + "&agmt_seq="+ComGetObjValue(formObj.agmt_seq);
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
								ComSetObjValue(formObj.ref_no,   ComGetEtcData(sXml, "ref_no"));
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
								ComSetFocus(formObj.ref_no);
								doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
							} else {
	 							ComShowCodeMessage("LSE01007");
	 							clearForm("agmt_seq");
	 						}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							clearForm("agmt_seq");
						}
 					}
				}
				break;
			case IBSEARCH_ASYNC03: 	//Container Type Size Dynamic Header Setting
				sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=SEARCH12;
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
				sheetObj.SetWaitImageVisible(1);
				if(sXml != "") {
					if ( ComGetEtcData(sXml, "cntr_tpsz_hd") != undefined ) {
						if ( ComGetEtcData(sXml, "cntr_tpsz_hd") != "" ) {
							vCntrTpszHdr=ComGetEtcData(sXml, "cntr_tpsz_hd");
							vArrCntrTpsz=vCntrTpszHdr.split("|");
							vCntrTpszCnt=vArrCntrTpsz.length;
						}
					}
				}
				break;
			case IBSEARCHAPPEND:
				if(sheetObj.id == "sheet2") {
					formObj.f_cmd.value=SEARCH01;
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					sheetObj.DoSearch("EES_LSE_0040GS.do", CondParam+"&"+ "iPage="+ PageNo,{Append:true} );
					ComOpenWait(false);
				}
				break;
			case IBSEARCH_ASYNC08:
				formObj.f_cmd.value=SEARCH01;
				var intgCdId='CD30029';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
			    } 
				if (xml != "") {
					var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
					var arrStr=sCntrMtrlCdNm.split("@");					
					var arrCode=arrStr[0].split("|");
					formObj.pagerows.value=arrCode[0];
				}
				break;
        }
    }
    
    function sheet2_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
        if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
        //doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, FormQueryString(document.form), ++iPageNo);
    }    
    
    /**
	 * Sheet의 OnScrollNext Event 처리부분.<br>
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRows
	 */
//method change[check again]CLT 	function sheet2_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
//		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
//	}
    
    
	/**
	 * handling event in case of Mouse-Move sheet
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		
		with(sheetObj) {
			var isFlag=GetCellValue(MouseRow(), "agmt_no") != "G.TTL";
			isFlag=true;
			SetDataLinkMouse("agmt_no",isFlag);
			SetDataLinkMouse("vndr_abbr_nm",isFlag);
			for(var i=1; i < vCntrTpszCnt; i++) {
				var tpsz_dp_no="tpsz_dp"+ ComLpad(i, 2, "0");
            	SetDataLinkMouse(tpsz_dp_no,isFlag);
			}
		}
	}
	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var param="";
		var sRow=sheetObj.GetSelectRow();
		var sCol= sheetObj.GetSelectCol();
		var sDivsion = sheetObj.GetCellValue(sRow,"rst_div");
		switch (sName) {
			case "tpsz_dp01": case "tpsz_dp02": case "tpsz_dp03":
			case "tpsz_dp04": case "tpsz_dp05": case "tpsz_dp06":
			case "tpsz_dp07": case "tpsz_dp08": case "tpsz_dp09":
			case "tpsz_dp10": case "tpsz_dp11": case "tpsz_dp12":
			case "tpsz_dp13": case "tpsz_dp14": case "tpsz_dp15":
			case "tpsz_dp16": case "tpsz_dp17": case "tpsz_dp18":
			case "tpsz_dp19": case "tpsz_dp20": case "tpsz_dp21":
			case "tpsz_dp22": case "tpsz_dp23": case "tpsz_dp24":
			case "tpsz_dp25": case "tpsz_dp26": case "tpsz_dp27":
			case "tpsz_dp28": case "tpsz_dp29": case "tpsz_dp30":
				
				param="&agmt_cty_cd=" + sheetObj.GetCellValue(Row,"agmt_cty_cd")
				+ "&agmt_seq=" + sheetObj.GetCellValue(Row,"agmt_seq")
			          + "&cntr_tpsz_cd=" + sheetObj.GetCellText(0, Col);
				if(sCol > 5 && sDivsion != "VOL") {
				}else{
					dcondTD.innerHTML="AGMT No : "+ sheetObj.GetCellValue(Row,"agmt_no")
						   	+ ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.GetCellText(0, Col);
				}
				break;
			case "vndr_abbr_nm":
				param="&agmt_cty_cd=" + sheetObj.GetCellValue(Row,"agmt_cty_cd")
				+ "&agmt_seq=" + sheetObj.GetCellValue(Row,"agmt_seq")
			          + "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd);
				if(sheetObj.GetMousePointer== "Hand") {
					dcondTD.innerHTML="AGMT No : "+ sheetObj.GetCellValue(Row,"agmt_no")
					+ ",&nbsp;&nbsp;Lessor : "+ sheetObj.GetCellValue(Row,"vndr_abbr_nm");
				}
				break;
			case "tpsz_total":
			case "agmt_no":
				param="&agmt_cty_cd=" + sheetObj.GetCellValue(Row,"agmt_cty_cd")
				+ "&agmt_seq=" + sheetObj.GetCellValue(Row,"agmt_seq")
			          + "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd);
//				if(sheetObj.GetMousePointer== "Hand") {
					dcondTD.innerHTML="AGMT No : "+ sheetObj.GetCellValue(Row,"agmt_no");
	//			}
				break;
		}
		//if ( param != "" && sheetObj.CellValue(Row, "agmt_no") != "G.TTL") {
		if ( param != "") {
			if(sCol > 5 && sDivsion != "VOL") {
			}else{
				param="f_cmd=" + SEARCH01 + param + ComGetObjValue(formObj.hcond_params); 
				sheetObjects[1].SetWaitImageVisible(1);
				ComOpenWait(true);
				param = param.replace(/(\d{4})-(\d{2})-(\d{2})/g, '$1$2$3');
				appendCondParam = param;	
				sheetObjects[1].DoSearch("EES_LSE_0040GS.do",param );
				ComOpenWait(false);
			}
		}
	}
	/**
	 * handling event in case of Mouse-Down sheet
	 *//*
	function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var sRow=sheetObj.MouseRow();
		var sCol=sheetObj.MouseCol();
		var sRow=sheetObj.GetSelectRow();
		var sCol= sheetObj.GetSelectCol();
		var sDivsion = sheetObj.GetCellValue(sRow,"rst_div");
		
		if(sRow > sheetObj.HeaderRows()&& sRow > sheetObj.LastRow()-3){
			var formObj=document.form;
			var sName=sheetObj.ColSaveName(sCol);
			var param="";
			switch (sName) {
				case "tpsz_dp01": case "tpsz_dp02": case "tpsz_dp03":
				case "tpsz_dp04": case "tpsz_dp05": case "tpsz_dp06":
				case "tpsz_dp07": case "tpsz_dp08": case "tpsz_dp09":
				case "tpsz_dp10": case "tpsz_dp11": case "tpsz_dp12":
				case "tpsz_dp13": case "tpsz_dp14": case "tpsz_dp15":
				case "tpsz_dp16": case "tpsz_dp17": case "tpsz_dp18":
				case "tpsz_dp19": case "tpsz_dp20": case "tpsz_dp21":
				case "tpsz_dp22": case "tpsz_dp23": case "tpsz_dp24":
				case "tpsz_dp25": case "tpsz_dp26": case "tpsz_dp27":
				case "tpsz_dp28": case "tpsz_dp29": case "tpsz_dp30":
					
					param="&agmt_cty_cd=" + sheetObj.GetCellValue(sRow,"agmt_cty_cd")
					+"&agmt_seq=" + sheetObj.GetCellValue(sRow,"agmt_seq")
				          + "&cntr_tpsz_cd=" + sheetObj.GetCellText(0, sCol);
					if(sheetObj.GetMousePointer== "Hand") {
						if(sCol > 5 && sDivsion != "VOL") {
						}else{
							dcondTD.innerHTML="AGMT No : "+ sheetObj.GetCellValue(sRow,"agmt_no")
							   	+ ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.GetCellText(0, sCol);
						}
					}
					break;
				case "vndr_abbr_nm":
					param="&agmt_cty_cd=" + sheetObj.GetCellValue(sRow,"agmt_cty_cd")
					+"&agmt_seq=" + sheetObj.GetCellValue(sRow,"agmt_seq")
				          + "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd);
					if(sheetObj.GetMousePointer== "Hand") {
						dcondTD.innerHTML="AGMT No : "+ sheetObj.GetCellValue(sRow,"agmt_no")
						+ ",&nbsp;&nbsp;Lessor : "+ sheetObj.GetCellValue(sRow,"vndr_abbr_nm");
					}
					break;
				case "tpsz_total":
				case "agmt_no":
					param="&agmt_cty_cd=" + sheetObj.GetCellValue(sRow,"agmt_cty_cd")
					+ "&agmt_seq=" + sheetObj.GetCellValue(sRow,"agmt_seq")
				          + "&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd);
					if(sheetObj.GetMousePointer== "Hand") {
						dcondTD.innerHTML="AGMT No : "+ sheetObj.GetCellValue(sRow,"agmt_no");
					}
					break;
			}
			//if ( param != "" && sheetObj.CellValue(Row, "agmt_no") != "G.TTL") {
			if ( param != "") {
				if(sCol > 5 && sDivsion != "VOL") {
				}else{
					param="f_cmd=" + SEARCH01 + param + ComGetObjValue(formObj.hcond_params);
					sheetObjects[1].SetWaitImageVisible(1);
					ComOpenWait(true);
					appendCondParam = param;	
					sheetObjects[1].DoSearch("EES_LSE_0040GS.do",param );
					ComOpenWait(false);
				}
			}
		}
	}*/
	/**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			var viewCnt=0;
			for ( var i=1 ; i < vCntrTpszCnt ; i++ ) {
				var cellData=eval('sheetObj.GetCellValue(LastRow()-1, "tpsz_dp'+ ComLpad(i, 2, "0") + '")');
				if(cellData <= 0) {
					eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
				}
				var viewFlag=eval('sheetObj.GetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '")');
				if(viewFlag == false) {
					viewCnt++;
				}
			}
			
			if(SearchRows()> 0) {
				if(420 + (viewCnt * 60) > 984) {
					SheetWidth=984;
				} else {
					SheetWidth=490 + (viewCnt * 60);
				}
				/*for(var i=LastRow()-5; i < LastRow()-2; i++) {
					SetCellAlign(i +3, "rst_div","Center");
					for(var j=0; j < LastCol(); j++) {
						SetCellText(i +3, j ,GetCellText(i, j));
					}
				}*/
			} else {
				SheetWidth=984;
				for( var i=1; i < vCntrTpszCnt; i++ ) {
					if(vArrCntrTpsz[i] != "") {
						sheetObj.SetColHidden("tpsz_dp"+ ComLpad(i, 2, "0") + "",0);
					} else {
						sheetObj.SetColHidden("tpsz_dp"+ ComLpad(i, 2, "0") + "",1);
					}
				}
			}
			SetColBackColor("tpsz_total",LSE_TOTCOL_BACK_COLOR);
			var formObj=document.form;
			formObj.hcond_tpsz_cd.value=ComGetObjValue(formObj.cntr_tpsz_cd);
			formObj.hcond_params.value="&str_evnt_dt=" + ComGetObjValue(formObj.str_evnt_dt)
				   + "&end_evnt_dt=" + ComGetObjValue(formObj.end_evnt_dt)
				   + "&lstm_cd=" + ComGetObjValue(formObj.lstm_cd)
				   + "&vndr_seq=" + ComGetObjValue(formObj.vndr_seq)
				   + "&co_cre_flg=" + ComGetObjValue(formObj.com_cre_flg)
				   + "&cntr_sts_cd=" + ComGetObjValue(formObj.cntr_sts_cd);
			if(GetTotalRows() > 3) {
                SetTotalRows(GetTotalRows() - 3);
                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			}
		}
    }
    
    /**
     * calling event after retrieving Sheet
     * @param sheetObj
     * @param ErrMsg
     */
    function sheet2_OnSearchEnd(sheetObj, Code, ErrMsg) {
    	sheetObj.SetWaitImageVisible(0);
    	var formObj = document.form;
    	var lstTotal = sheetObj.GetTotalRows();
    	if (sheetObj.RowCount()< lstTotal) {
            // setting page number for APPEND retrieving
            appendPageNo=Math.ceil(sheetObj.RowCount()/ formObj.pagerows.value) + 1;
            ComBtnEnable("btn_more");
        } else {
        	appendPageNo = 1;
            ComBtnDisable("btn_more");
        }	
    	sheetObj.SetWaitImageVisible(0);
    	ComOpenWait1(false);    
    }
    
    /**
	 * handling event in case of OnCheckClick combo1
	 * @return
	 */
	function combo1_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk=comboObj.GetItemCheck(index);
			if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
				comboObj.SetItemCheck(0,1);
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
	}
	
	/**
	 * handling event in case of OnCheckClick combo2
	 * @return
	 */
	function combo2_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk=comboObj.GetItemCheck(index);
			if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
				comboObj.SetItemCheck(0,1);
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
	}
    /**
	 * combo2_OnBlur
	 */
	//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

	function combo1_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		formObj.lstm_cd.value=ComGetObjValue(comboObj);
	}
    /**
	 * combo2_OnBlur
	 */
	function combo2_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
	}
	/**
	 * handling event in case of Key-Down combo
	 */
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i=0 ; i < GetItemCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.lstm_cd.value=ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}
	/**
	 * combo2_OnKeyDown
	 */
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i=0 ; i < GetItemCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}
	/**
     * handing process Pop-up<br>
     * @param type 1:Lessor Code Popup for FORM, 2:Agreement No. Popup for FORM
     * @param Row index
     * @param Col index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 715, 540, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "2" ) {
    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 480, 'setPopData_Agreement', '1,0', true);
    	}
    	return;
    }
	/**
     * handing process for Agreement Pop-up Return Value<br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj=sheetObjects[SheetIdx];
    	var formObj=document.form;
    	if ( aryPopupData.length > 0 ) {
    		ComSetObjValue(formObj.agmt_cty_cd, aryPopupData[0][4]);
			ComSetObjValue(formObj.agmt_seq, aryPopupData[0][5]);
    		ComSetObjValue(formObj.ref_no,   aryPopupData[0][6]);
    		ComSetObjValue(formObj.vndr_seq, aryPopupData[0][8]);
    		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
    	}
    }
    /**
	 * handing process for Lessor(Service Provider) Pop-up Return Value<br>
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
			ComSetObjValue(formObj.vndr_abbr_nm,  aryPopupData[0][5]);
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}
	/**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH: 
    				if (!checkDurationDate()) {
    					return false;
    				} else if ( formObj.lstm_cd.value == "" ) {
						ComShowCodeMessage("LSE01009");
						ComSetFocus(combo1);
						return false;
					}
    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}
        return true;
    }
	/**
	 * handling process for Duration Date Validation<br>
	 */
    function checkDurationDate(eventObj) {
    	var formObj=document.form;
    	var vEffDt=ComReplaceStr(ComGetObjValue(formObj.str_evnt_dt),"-","");
		var vExpDt=ComReplaceStr(ComGetObjValue(formObj.end_evnt_dt),"-","");
		/* Duration Date Validation(str_evnt_dt) */
		if(vEffDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_evnt_dt);
			return false;
		} else if(vEffDt == "" && eventObj.name == "str_evnt_dt") {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_evnt_dt);
			return false;
		} else if (vEffDt != "" && !ComIsDate(formObj.str_evnt_dt) ) {
			ComShowCodeMessage("LSE01080");
			ComSetObjValue(formObj.str_evnt_dt,"");
			ComSetFocus(formObj.str_evnt_dt);
			return false;
		}
		/* Duration Date Validation(end_evnt_dt) */
		if(vExpDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_evnt_dt);
			return false;
		} else if(vExpDt == "" && eventObj.name == "end_evnt_dt") {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_evnt_dt);
			return false;
		} else if (vExpDt != "" && !ComIsDate(formObj.end_evnt_dt) ) {
			ComShowCodeMessage("LSE01081");
			ComSetObjValue(formObj.end_evnt_dt,"");
			ComSetFocus(formObj.end_evnt_dt);
			return false;
		}
		/* Duration Date Validation(str_evnt_dt < end_evnt_dt) */
		if(vEffDt != "" && vExpDt != "") {
			if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
				ComShowCodeMessage("LSE01082");
				if(eventObj == null) {
					ComSetObjValue(formObj.end_evnt_dt,"");
					ComSetFocus(formObj.end_evnt_dt);
				} else {
					ComSetObjValue(eventObj,"");
					ComSetFocus(eventObj);
				}
				return false;
			}
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

            case "agmt_cty_cd":
                ComSetObjValue(formObj.agmt_cty_cd, "");
                ComSetObjValue(formObj.agmt_seq,    "");
                ComSetObjValue(formObj.ref_no,   	"");
                ComSetObjValue(formObj.vndr_seq, 	"");
                ComSetObjValue(formObj.vndr_nm,  	"");
                ComSetObjValue(formObj.vndr_abbr_nm,"");
                ComSetFocus(formObj.agmt_cty_cd);
                break;
			case "agmt_seq":
				ComSetObjValue(formObj.agmt_seq,    "");
				ComSetObjValue(formObj.ref_no,   	"");
				ComSetFocus(formObj.agmt_seq);
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.vndr_abbr_nm,"");
				break;
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.vndr_abbr_nm,"");
				ComSetFocus(formObj.vndr_seq);
				break;
		}
	}
	/* end of developer job */

	/**
	 * handling process for Sheet
	 */    
	function doActionIBSheet1(sheetObj, formObj, sAction, CondParam, PageNo) {
		switch(sAction) {
		case IBSEARCHAPPEND:
			if(!validateForm(sheetObj,formObj,sAction)) return;
	        sheetObj.SetWaitImageVisible(0);
	        ComOpenWait(true);
	        setTimeout( function () {	        	
	        	sheetObjects[1].SetWaitImageVisible(0);				
				sheetObjects[1].DoSearch("EES_LSE_0040GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );  	   
				} , 100);
	        	
			break;
		}
	}


	function ComOpenWait1(flag, bOpenLayer){
	    try {
	        if(flag == isOpenWaitWindow ) return;
	        isOpenWaitWindow = flag;
	        if(flag) {
	        	var waitW   = 60;
	        	var waitH   = 60;
	        	var waitImage = "style/images/theme_default/waiting.gif";
	        	
	        	var ifr = document.getElementById("waitiframe");
	        	if (ifr==null){
	            	$('<div class="layer_wait"> </div>').appendTo("body");
	            	//$('<img name="waitiframe" id="waitiframe" src="'+waitImage+ '">').appendTo(".layer_wait");            	
	            	//$('<IFRAME id="waitiframe" name="waitiframe" frameBorder="0" name="iFrm" src="'+waitImage+ '"scrolling="no" width="'+waitW + '" height="' + waitH + '"></IFRAME>').appendTo(".layer_wait")
	    
	            	$("body").prepend("<div class='layer_wait_bg'></div>");        	
	        	}

	        	//open wait image
	        	$(".layer_wait_bg,.layer_wait").fadeIn(100);

	        	//position center
	        	$(".layer_wait").css({
	            	marginTop : parseInt("-" + $(".layer_wait").outerHeight()/2),
	            	marginLeft : parseInt("-" + $(".layer_wait").outerWidth()/2)
	        	});
	        } else {
	        	//close wait image
	        	$(".layer_wait_bg,.layer_wait").fadeOut(100);
	        }
	    } catch(err) {ComFuncErrMsg(err.message); }
	    return true;
	}