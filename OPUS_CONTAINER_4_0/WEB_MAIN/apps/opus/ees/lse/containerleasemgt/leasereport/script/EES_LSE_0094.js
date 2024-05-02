/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0094.js
*@FileTitle  : Sub Lease Out Container Summary
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
	 * @class EES_LSE_0094 : business script for EES_LSE_0094
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
    		var srcObj=window.ComGetEvent();
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "total_flg" :
            		sheetObject1.SetColHidden("loc_cd",srcObj.checked);
            		break;
            	case "lst_sts_flg" :
	  				if ( ComGetObjValue(srcObj) == "02" ) {
	  					formObj.str_evnt_dt.className="input";
	  					formObj.end_evnt_dt.className="input";
	  				} else {
	  					formObj.str_evnt_dt.className="input";
	  					formObj.end_evnt_dt.className="input";
	  				}
  					break;
            	case "btn_more":
                    doActionIBSheet1(sheetObjects[1], document.form, IBSEARCHAPPEND, appendCondParam, appendPageNo);
                    break;
				case "btn_Retrieve":
					dcondTD.innerHTML="&nbsp;"
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
 					break;
				case "btn_New":
					dcondTD.innerHTML="&nbsp;"
					ComResetAll();
					//sheetObject1.SetSheetWidth(984);
					for( var i=1; i < vCntrTpszCnt; i++ ) {
						if(vArrCntrTpsz[i] != "") {
							eval('sheetObject1.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
						} else {
							eval('sheetObject1.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
						}
					}
					formObj.loc_cd.readOnly=true;
					formObj.loc_cd.className="input2";
					formObj.str_evnt_dt.className="input";
	  				formObj.end_evnt_dt.className="input";
					ComEnableObject(formObj.btns_search, false);
					sheetObjects[0].SetCellText(0, "loc_cd" ,"RCC");
					sheetObjects[0].SetColHidden("loc_cd",0);
					comboObjects[0].SetItemCheck(0,1);
					comboObjects[1].SetItemCheck(0,1);
					ComSetFocus(formObj.lst_sts_flg[0]);
					rtv_total="0";
		        	ComBtnDisable("btn_more");
					break;
				case "btn_DownExcel":
					//sheetObject1.SpeedDown2Excel(-1);
					if(sheetObject1.RowCount() < 1){//no data	
						ComShowCodeMessage("COM132501");
					}else{	
						//sheetObject1.Down2Excel({ HiddenColumn:1,Merge:true});
						sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1, Merge:1, DownRows:"Visible"});
					}	
					break;
				case "btn_DownExcel2":
					if(sheetObject2.RowCount() < 1){//no data	
						ComShowCodeMessage("COM132501");
					}else{	
						sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
					}	
					break;
				case "btns_search":	//Form Location. Search
 					openPopup("1");
 					break;
				case "btns_search2": // Form Agreement Search
					openPopup("2");
					break;
				case "btns_search3": // Form Lessor Search
					openPopup("3");
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
		 for( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
 		}
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		ComBtnDisable("btn_more");
		sheet1_OnLoadFinish(sheet1);
		sheet2_OnLoadFinish(sheet2);
    }
    /**
	 * handling event in case of OnLoadFinish sheet1
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
     	/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
		/* Axon Control Setting*/
		initControl();
		/* 초기 Focus Setting */
		ComEnableObject(formObj.btns_search, false);
		ComSetFocus(formObj.lst_sts_flg[0]);
		comboObjects[0].SetItemCheck(0,1);
		comboObjects[1].SetItemCheck(0,1);
		sheetObjects[0].SetCellText(0, "loc_cd" ,"RCC");
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC08); //페이징 갯수 가져오기
    }
    /**
	 *  handling event in case of OnLoadFinish sheet2
	 */
    function sheet2_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* Container Type Size Dynamic Header Setting */
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC05);
		/* initializing Sheet */
		ComConfigSheet (sheetObjects[0] );
		initSheet(sheetObjects[0],1);
		ComEndConfigSheet(sheetObjects[0]);
    }
    
    
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		axon_event.addListenerForm('focus',			'obj_focus',	formObj); 
//  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',		'obj_change',	formObj); 
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
	    	case "agmt_seq" :
	    	case "vndr_seq" :
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
	 * handling event in case of focus
	 */
	function obj_focus(){
		var obj=ComGetEvent();
		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    //deleting data unit separator
		    //ComClearSeparator(ComGetEvent());
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
			case "loc_tp":		//Location Type
				formObj.loc_cd.value="";
				if(obj.value == "0" || obj.value == "1") {
					formObj.loc_cd.readOnly=true;
					formObj.loc_cd.className="input2";
					ComEnableObject(formObj.btns_search, false);
					sheetObj.SetCellText(0, "loc_cd" ,obj.value == "0" ? "RCC" : "Country");
				} else {
					formObj.loc_cd.readOnly=false;
					formObj.loc_cd.className="input";
					ComEnableObject(formObj.btns_search, true);
					formObj.loc_cd.maxLength=obj.value == "5" ? 2 : 5;
					ComSetNextFocus(obj);
					if(obj.value == "2") {
						sheetObj.SetCellText(0, "loc_cd" ,"LCC");
					} else if(obj.value == "3") {
						sheetObj.SetCellText(0, "loc_cd" ,"SCC");
					} else if(obj.value == "4") {
						sheetObj.SetCellText(0, "loc_cd" ,"Yard");
					} else {//obj.value is '5'
						sheetObj.SetCellText(0, "loc_cd" ,"Country");
					}
				}
				break;
			case "loc_cd":		//Location Code
  				if ( ComTrim(obj.value) != "" ) {
  					if(obj.maxLength == 5) {
	        			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  					} else {
  						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  					}
  				}
				break;
  			case "str_evnt_dt":
    		case "end_evnt_dt":
    			checkDurationDate(obj);
	    		break;
  			case "agmt_seq":	//Agreement No.
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
				}else{
					formObj.agmt_seq.value = "";
					formObj.ref_no.value = "";
					formObj.vndr_seq.value = "";
					formObj.vndr_abbr_nm.value = "";
					formObj.vndr_nm.value = "";
				}
				break;
			case "vndr_seq":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
  				}else{
  					formObj.vndr_seq.value = "";
					formObj.vndr_abbr_nm.value = "";
					formObj.vndr_nm.value = "";
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
                with(sheetObj){
                  var HeadTitle="RCC|Lease Term|Lessee||Total"+ vCntrTpszHdr +"|";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              //(headCount, 5, 0, true);
	              SetConfig( { SearchMode:2, MergeSheet:2, Page:1000, DataRowMerge:0  } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",   Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",   Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",   Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"tpsz_total",    KeyField:0,   CalcLogic:"",   Format:"Integer" } ];

	                    for(var i=1; i < vCntrTpszCnt; i++) {
			              var tpsz_dp_no="tpsz_dp"+ ComLpad(i, 2, "0");
			              cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:tpsz_dp_no,      KeyField:0,   CalcLogic:"",   Format:"Integer" });
			              if(vArrCntrTpsz[i] != "") {
			            	  eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
			              } else {
			            	  eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
			              }
				              
	                    }
						InitColumns(cols);
						SetEditable(0);
						SetCountFormat("[SELECTDATAROW / TOTALROWS]");
						SetDataAutoTrim(1);
						SetSheetHeight(240);
              }
				break;
            case "sheet2":
                with(sheetObj){
              var HeadTitle="Seq.|CNTR No.|TP/SZ|Term|AGMT No.|Ref No.|Out Yard|Out Date|In Yard|In Date|AGMT No.|Ref No.|Auth No.|Lessee|Lessee Name|F/Days|T/Using Days|PDM|LON|LOF|DOC|G.TTL";
              var headCount=ComCountHeadTitle(HeadTitle);
              (headCount, 3, 0, true);

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"lsi_agmt_no",        KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"lsi_ref_no",         KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sts_evnt_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rtn_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_rtn_evnt_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",             KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"approval_no",        KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"vndr_abbr_nm",       KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rntl_chg_free_dys",  KeyField:0,   CalcLogic:"",   Format:"Integer" },
                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_use_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer" },
                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"pdm_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"lon_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"lof_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"doc_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"ttl_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
               
              InitColumns(cols);
              SetEditable(0);
              SetCountFormat("[SELECTDATAROW / TOTALROWS]");
              SetDataAutoTrim(1);
              SetSheetHeight(220);
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
	            	//MaxSelect = 1;
	            	SetMultiSeparator(",");
	            	Style=0;
             		SetUseAutoComplete(1);
             		//only upper case, special characters - Lease Term
             //no support[check again]CLT 		ValidChar(2,2);
	        	}
	        	break;
	        case "combo2":
	        	with(comboObj) {
	            	SetDropHeight(200);
	            	SetMultiSelect(1);
	            	//MaxSelect = 1;
	            	SetMultiSeparator(",");
	            	Style=0;
             		SetUseAutoComplete(1);
             		//only upper case, special characters, number - TP/SZ
             //no support[check again]CLT 		ValidChar(2,3);
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
				var usr_ofc_cd = formObj.usr_ofc_cd.value;
				var ofc_type = usr_ofc_cd.substring(3,5);
				sheetObj.SetWaitImageVisible(0);
				
				if(ofc_type == 'HQ'){
					comboObjects[0].RemoveAll();
					comboObjects[0].InsertItem(0, "ALL","ALL");
					comboObjects[0].InsertItem(1, 'MI', 'MI');
					comboObjects[0].InsertItem(2, 'MO', 'MO');
					
				} else {
		        	//Lease Term Combo Item Setting
					formObj.f_cmd.value=SEARCH01;
					var sXml_1=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
					if(sXml_1 != "") {
						comboObjects[0].InsertItem(0 , "ALL","");
						LseComXml2ComboItem(sXml_1, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
						vOrcLstmCd=ComGetEtcData(sXml_1, "lease_term_cd");
					}
				}
				//Container Type/Size Combo Item Setting Start
				formObj.f_cmd.value=SEARCH02;
				var sXml_2=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		        sheetObj.SetWaitImageVisible(1);
		         if ( sXml_2 != "" ) {
		           	comboObjects[1].InsertItem(0 , 'ALL','');
		           	LseComXml2ComboItem(sXml_2, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
		           	vOrcCntrTpszCd=ComGetEtcData(sXml_2, "cntr_tpsz_cd");
		        }
				
	            break;
           case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var hq_lstm_cd = formObj.lstm_cd.value;
						var usr_ofc_cd = formObj.usr_ofc_cd.value;
						var ofc_type = usr_ofc_cd.substring(3,5);
						
						formObj.f_cmd.value=SEARCH;
						formObj.lstm_cd.value=ComGetObjValue(comboObjects[0]);
						formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObjects[1]);
						if(ofc_type == 'HQ' && hq_lstm_cd == ''){
							formObj.lstm_cd.value = 'MI,MO';
						}
						sheetObj.SetWaitImageVisible(0);
	         			ComOpenWait(true);
	         			setTimeout( function () {
                             var sXml=sheetObj.GetSearchData("EES_LSE_0094GS.do", FormQueryString(formObj));

                            if ( sXml != "" ) {
                                var comboVal=ComGetObjValue(comboObjects[1]);
                                if ( comboVal != "" ) {
                                    for ( var i=1 ; i < vCntrTpszCnt ; i++ ) {
                                        eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
                                    }
                                    var arrComboVal=comboVal.split(",");
                                    for ( var i=0 ; i < arrComboVal.length ; i++ ) {
                                        for( var j=1; j < vCntrTpszCnt; j++ ) {
                                            if(arrComboVal[i] == vArrCntrTpsz[j]) {
                                                eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(j, 2, "0") + '",0);');
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    for( var i=1; i < vCntrTpszCnt; i++ ) {
                                        if(vArrCntrTpsz[i] != "") {
                                            eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
                                        } else {
                                            eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
                                        }
                                    }
                                }
                                //sheetObj.RenderSheet(0);
                                sheetObj.LoadSearchData(sXml,{Sync:1} );
                                //sheetObj.RenderSheet(1);
                                //
                            }
                            ComOpenWait(false);
	         			} , 100);
					}
				}
				break;
			case IBSEARCH_ASYNC01:	// Location search
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var vLocTp=formObj.loc_tp.value == "2" ? "RCC" :
 									 formObj.loc_tp.value == "3" ? "LCC" : "SCC";
 						var param="f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
 								  +"&loc_cd="+ComGetObjValue(formObj.loc_cd);
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						iPageNo = 1;
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
									var vLocCd="";
									switch (vLocTp) {
										case "RCC":
											vLocCd=ComGetEtcData(sXml, "rcc_cd");
											break;
										case "LCC":
											vLocCd=ComGetEtcData(sXml, "lcc_cd");
											break;
										case "SCC":
											vLocCd=ComGetEtcData(sXml, "scc_cd");
											break;
									}
									formObj.loc_cd.value=vLocCd;
									ComSetFocus(formObj.loc_cd);
								} else {
									ComShowCodeMessage("LSE01037");
									formObj.loc_cd.value="";
									ComSetFocus(formObj.loc_cd);
								}
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_cd.value="";
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
				}
 				break;
 			case IBSEARCH_ASYNC02:	// Country search
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param="f_cmd="+SEARCH10+"&loc_cd="+ComGetObjValue(formObj.loc_cd);
						sheetObj.SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "loc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "loc_cd") != "" ) {
									formObj.loc_cd.value=ComGetEtcData(sXml, "loc_cd") ;
								}else{
									ComShowCodeMessage("LSE01048");
									formObj.loc_cd.value="";
									ComSetFocus(formObj.loc_cd);
								}
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_cd.value="";
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
				}
				break;
 			case IBSEARCH_ASYNC03:	//retrieving when input Form Agreement No.
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
								doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
							} else {
	 							ComShowCodeMessage("LSE01007");
	 							clearForm("agmt_seq");
	 						}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							clearForm("agmt_seq");;
						}
 					}
				}
				break;
			case IBSEARCH_ASYNC04:	//retrieving when input Form Lessor No.
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.SetWaitImageVisible(0);
 					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
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
			case IBSEARCH_ASYNC05:	//Container Type Size Dynamic Header Setting
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
 					sheetObj.DoSearch("EES_LSE_0094GS.do", CondParam+"&"+ "iPage="+ PageNo,{Append:true} );
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
       // doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, FormQueryString(document.form), ++iPageNo);
    }
	/**
	 * calling event after ScrollNext Sheet2<br>
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRows
	 */
    function sheet2_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		//doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}
	/**
	 * calling event after MouseMove Sheet1 
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var isFlag=GetCellValue(MouseRow(), "lstm_cd")  != "Total"
				&& GetCellValue(MouseRow(), "vndr_abbr_nm") != "S.TTL";
			isFlag=true;
			SetDataLinkMouse("loc_cd",isFlag);
			SetDataLinkMouse("lstm_cd",isFlag);
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
		var sLocCd=sheetObj.GetCellValue(Row,"loc_cd");
		var sLstmCd=sheetObj.GetCellValue(Row,"lstm_cd");
		var svndrSeq = sheetObj.GetCellValue(Row,"vndr_seq");
		
		if(svndrSeq == "") {
			svndrSeq = formObj.vndr_seq.value;
		}
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
				param="&cntr_tpsz_cd=" + sheetObj.GetCellText(0, Col)
				+ "&vndr_seq=" + svndrSeq
				+ "&cntr_onh_auth_no=" + ComGetObjValue(formObj.cntr_onh_auth_no)
				+ "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.GetCellValue(Row,"lstm_cd"))
				+ "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.GetCellValue(Row,"loc_cd"));
				if(sheetObj.GetMousePointer== "Hand") {
					dcondTD.innerHTML=sheetObj.GetCellText(0, "loc_cd") +" : "+ sheetObj.GetCellValue(Row,"loc_cd")
					+ ",&nbsp;&nbsp;Lease Term : "+ sheetObj.GetCellValue(Row,"lstm_cd")
					+ ",&nbsp;&nbsp;Lessee : "+ sheetObj.GetCellValue(Row,"vndr_abbr_nm")
						   + ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.GetCellText(0, Col);
				}
				break;
			case "tpsz_total":
			case "vndr_abbr_nm":
				param="&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
				+ "&vndr_seq=" + svndrSeq
				+ "&cntr_onh_auth_no=" + ComGetObjValue(formObj.cntr_onh_auth_no)
				+ "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.GetCellValue(Row,"lstm_cd"))
				+ "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.GetCellValue(Row,"loc_cd"));
				if(sheetObj.GetMousePointer== "Hand") {
					dcondTD.innerHTML=sheetObj.GetCellText(0, "loc_cd") +" : "+ sheetObj.GetCellValue(Row,"loc_cd")
					+ ",&nbsp;&nbsp;Lease Term : "+ sheetObj.GetCellValue(Row,"lstm_cd")
					+ ",&nbsp;&nbsp;Lessee : "+ sheetObj.GetCellValue(Row,"vndr_abbr_nm");
				}
				break;
			case "lstm_cd":
				param="&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
					  + "&vndr_seq=" + ComGetObjValue(formObj.hcond_vndr_seq)
					  + "&cntr_onh_auth_no=" + ComGetObjValue(formObj.cntr_onh_auth_no)
					  + "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.GetCellValue(Row,"lstm_cd"))
					  + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.GetCellValue(Row,"loc_cd"));
				if(sheetObj.GetMousePointer== "Hand") {
					dcondTD.innerHTML=sheetObj.GetCellText(0, "loc_cd") +" : "+ sheetObj.GetCellValue(Row,"loc_cd")
					+ ",&nbsp;&nbsp;Lease Term : "+ sheetObj.GetCellValue(Row,"lstm_cd");
				}
				break;
			case "loc_cd":
				param="&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
					  + "&vndr_seq=" + ComGetObjValue(formObj.hcond_vndr_seq)
					  + "&cntr_onh_auth_no=" + ComGetObjValue(formObj.cntr_onh_auth_no)
			          + "&lstm_cd=" + ComGetObjValue(formObj.hcond_lstm_cd)
			          + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.GetCellValue(Row,"loc_cd"));
				if(sheetObj.GetMousePointer== "Hand") {
					dcondTD.innerHTML=sheetObj.GetCellText(0, "loc_cd") +" : "+ sheetObj.GetCellValue(Row,"loc_cd");
				}
				break;
		}
		var isFlag=sheetObj.GetCellValue(Row, "lstm_cd")	!= "Total"
			&& sheetObj.GetCellValue(Row, "vndr_abbr_nm") != "S.TTL";
		if ( param != "") {
			param="f_cmd=" + SEARCH01 + param + ComGetObjValue(formObj.hcond_params);
			sheetObjects[1].SetWaitImageVisible(1);
			ComOpenWait(true);
			appendCondParam = param;	
			sheetObjects[1].DoSearch("EES_LSE_0094GS.do",param );
			ComOpenWait(false);
		}
	}
	/**
	 * sheet1_OnMouseDown
	 * calling event after MouseDown Sheet1
	 */
	function sheet1_OnMouseDown(sheetObj , Button, Shift, X, Y) {
		var formObj=document.form;
		var sRow=sheetObj.MouseRow();
		var sCol=sheetObj.MouseCol();
		var sName=sheetObj.ColSaveName(sCol);
		var sLocCd=sheetObj.GetCellValue(sRow,"loc_cd");
		var sLstmCd=sheetObj.GetCellValue(sRow,"lstm_cd");
		var param="";
		var svndrSeq = sheetObj.GetCellValue(sRow,"vndr_seq");
		if(svndrSeq == "") {
			svndrSeq = formObj.vndr_seq.value;
		}
		if(sRow > sheetObj.HeaderRows()&& sRow == sheetObj.LastRow()){
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
					param="&cntr_tpsz_cd=" + sheetObj.GetCellText(0, sCol)
					+ "&vndr_seq=" + svndrSeq
					+ "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.GetCellValue(sRow,"lstm_cd"))
					+ "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.GetCellValue(sRow,"loc_cd"));
					if(sheetObj.GetMousePointer== "Hand") {
						dcondTD.innerHTML=sheetObj.GetCellText(0, "loc_cd") +" : "+ sheetObj.GetCellValue(sRow,"loc_cd")
						+ ",&nbsp;&nbsp;Lease Term : "+ sheetObj.GetCellValue(sRow,"lstm_cd")
						+ ",&nbsp;&nbsp;Lessee : "+ sheetObj.GetCellValue(sRow,"vndr_abbr_nm")
							   + ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.GetCellText(0, sCol);
					}
					break;
				case "vndr_abbr_nm":
					param="&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
					+ "&vndr_seq=" + svndrSeq
					+ "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.GetCellValue(sRow,"lstm_cd"))
					+ "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.GetCellValue(sRow,"loc_cd"));
					if(sheetObj.GetMousePointer== "Hand") {
						dcondTD.innerHTML=sheetObj.GetCellText(0, "loc_cd") +" : "+ sheetObj.GetCellValue(sRow,"loc_cd")
						+ ",&nbsp;&nbsp;Lease Term : "+ sheetObj.GetCellValue(sRow,"lstm_cd")
						+ ",&nbsp;&nbsp;Lessee : "+ sheetObj.GetCellValue(sRow,"vndr_abbr_nm");
					}
					break;
				case "lstm_cd":
					param="&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
						  + "&vndr_seq=" + ComGetObjValue(formObj.hcond_vndr_seq)
						  + "&lstm_cd=" + (sLstmCd == "Total" ? "" : sheetObj.GetCellValue(sRow,"lstm_cd"))
						  + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.GetCellValue(sRow,"loc_cd"));
					if(sheetObj.GetMousePointer== "Hand") {
						dcondTD.innerHTML=sheetObj.GetCellText(0, "loc_cd") +" : "+ sheetObj.GetCellValue(sRow,"loc_cd")
						+ ",&nbsp;&nbsp;Lease Term : "+ sheetObj.GetCellValue(sRow,"lstm_cd");
					}
					break;
				case "loc_cd":
					param="&cntr_tpsz_cd=" + ComGetObjValue(formObj.hcond_tpsz_cd)
						  + "&vndr_seq=" + ComGetObjValue(formObj.hcond_vndr_seq)
				          + "&lstm_cd=" + ComGetObjValue(formObj.hcond_lstm_cd)
				          + "&loc_cd=" + (sLocCd == "G.Total" ? ComGetObjValue(formObj.hcond_loc_cd) : sheetObj.GetCellValue(sRow,"loc_cd"));
					if(sheetObj.GetMousePointer== "Hand") {
						dcondTD.innerHTML=sheetObj.GetCellText(0, "loc_cd") +" : "+ sheetObj.GetCellValue(sRow,"loc_cd");
					}
					break;
			}
			var isFlag=sheetObj.GetCellValue(sRow, "lstm_cd")	!= "Total"
				&& sheetObj.GetCellValue(sRow, "vndr_abbr_nm") != "S.TTL";
			if ( param != "") {
				param="f_cmd=" + SEARCH01 + param + ComGetObjValue(formObj.hcond_params);
				sheetObjects[1].SetWaitImageVisible(1);
				ComOpenWait(true);
				appendCondParam = param;	
 				sheetObjects[1].DoSearch("EES_LSE_0094GS.do",param );
				ComOpenWait(false);
			}
		}
	}
	/**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	ComOpenWait(false);
    	
		with(sheetObj) {
			var viewCnt=0;
			var formObj=document.form;
			for ( var i=1 ; i < vCntrTpszCnt ; i++ ) {
				var cellData=eval('sheetObj.GetSumValue(0, "tpsz_dp'+ ComLpad(i, 2, "0") + '")');
				
				if(cellData <= 0) {
					eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
				}
				var viewFlag=eval('sheetObj.GetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '")');
				if(viewFlag == false) {
					viewCnt++;
				}
			}
			var swidth =0;
			if(SearchRows()> 0) {
				if(310 + (viewCnt * 50) > 984) {
					//SetSheetWidth(984);
				} else {
					
					swidth = 320 + (viewCnt * 50);
					//SetSheetWidth(984);
				}
				
				if(formObj.total_flg.checked) {
					SheetWidth=SheetWidth -80;
					//SetSheetWidth(SheetWidth);
				}
		    	//RowBackColor(LastRow) = LSE_TOTCOL_BACK_COLOR;
			} else {
				//SetSheetWidth(984);
				for( var i=1; i < vCntrTpszCnt; i++ ) {
					if(vArrCntrTpsz[i] != "") {
						eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
						SetColWidth(i, 50);
					} else {
						eval('sheetObj.SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
					}
				}
				SetColWidth("loc_cd", 80);
                SetColWidth("lstm_cd", 80);
                SetColWidth("vndr_abbr_nm", 80);
                SetColWidth("vndr_seq", 60);
				SetColWidth("tpsz_total", 60);
			}
			for(var i=0; i <= SearchRows(); i++) {
				if(GetCellValue(i, "lstm_cd") == "Total" || GetCellValue(i, "vndr_abbr_nm") == "S.TTL" ) {
					//RowBackColor(i) = LSE_TOTCOL_BACK_COLOR;
				}
			}
			
			SetColBackColor("tpsz_total",LSE_TOTCOL_BACK_COLOR);
			if(SearchRows()> 0) {
//				for(var j=0; j <= LastCol(); j++) {
//					SetCellText(LastRow(), j ,GetCellText(LastRow()-1, j));
//				}
				SetRowHidden(LastRow(),1);
				if(formObj.total_flg.checked) {
					//합계 Title Merge 처리
					//SetMergeCell(LastRow(), 1, 1, 3);
					
				} else {
					try {
						//handling Title Merge total
						var strRows=ComFindAll(sheetObj, "lstm_cd", "Total");
						var arrStrRows=strRows.split("|");
						for ( var i=0 ; i < arrStrRows.length; i++ ) {
							SetMergeCell(parseInt(arrStrRows[i]), 1, 1, 3);
						}
						
					} catch(e) {
						SetMergeCell(parseInt(strRows), 1, 1, 3);
					}
					SetMergeCell(LastRow()-1, 0, 1, 4);
//					SetMergeCell(LastRow(), 0, 1, 4);
				}
			}
			formObj.hcond_tpsz_cd.value=ComGetObjValue(formObj.cntr_tpsz_cd);
			formObj.hcond_lstm_cd.value=ComGetObjValue(formObj.lstm_cd);
			formObj.hcond_vndr_seq.value=ComGetObjValue(formObj.vndr_seq);
			formObj.hcond_loc_cd.value=ComGetObjValue(formObj.loc_cd);
			formObj.hcond_params.value="&lst_sts_flg=" + ComGetObjValue(formObj.lst_sts_flg)
				   + "&cntr_sts_cd=" + ComGetObjValue(formObj.cntr_sts_cd)
				   + "&lstm_soc_tp=" + ComGetObjValue(formObj.lstm_soc_tp)
				   + "&str_evnt_dt=" + ComGetObjValue(formObj.str_evnt_dt)
				   + "&end_evnt_dt=" + ComGetObjValue(formObj.end_evnt_dt)
				   + "&agmt_cty_cd=" + ComGetObjValue(formObj.agmt_cty_cd)
			       + "&agmt_seq=" + ComGetObjValue(formObj.agmt_seq)
				   + "&onh_free_dys=" + ComGetObjValue(formObj.onh_free_dys)
				   + "&cntr_full_flg=" + ComGetObjValue(formObj.cntr_full_flg)
				   + "&total_flg=" + ComGetObjValue(formObj.total_flg)
				   + "&loc_tp=" + ComGetObjValue(formObj.loc_tp);
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
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
	}
	/**
	 * handling event in case of OnCheckClick combo1
	 * @return
	 */
	function combo2_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk=comboObj.GetItemCheck(index);
			if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
	}
    /**
	 * combo2_OnBlur
	 */
	function combo1_OnBlur(comboObj, Index_Code, Text) {
		var formObj=document.form;
		formObj.lstm_cd.value=ComGetObjValue(comboObj);
	}
    /**
	 * combo2_OnBlur
	 */
	function combo2_OnBlur(comboObj, Index_Code, Text) {
		var formObj=document.form;
		formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
	}
	/**
	 * combo1_OnKeyDown
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
     * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
     * @param object
     * @param Row index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		switch(formObj.loc_tp.value) {
    			case "2" :	//RCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "3" :	//LCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "4" :	//SCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "5" :	//Country
					ComOpenPopup("/opuscntr/COM_ENS_0M1.do",665, 480, 'setPopData_Country', "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
    	} else if ( type == "2" ) {
    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 480, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "3" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 665, 540, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	}
    	return;
    }
	/**
     * handling process for Agreement Pop-up Return Value<br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj=sheetObjects[SheetIdx];
    	var formObj=document.form;
    	if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.agmt_seq, aryPopupData[0][5]);
    		ComSetObjValue(formObj.ref_no,   aryPopupData[0][6]);
    		ComSetObjValue(formObj.vndr_seq, aryPopupData[0][8]);
    		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
    	}
    }
    /**
	 * handling process for Country Pop-up Return Value<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_Country(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj=sheetObjects[SheetIdx];
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
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
    	//checking for Duration
    	if(formObj.str_evnt_dt.className == "input") {
	    	if( vEffDt == "" && vExpDt == "" ) {
	    		return true;
	    	}
    	}
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
			case "agmt_seq":
				ComSetObjValue(formObj.agmt_seq,    "");
				ComSetObjValue(formObj.ref_no,   	"");
				ComSetFocus(formObj.agmt_seq);
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
				sheetObjects[1].DoSearch("EES_LSE_0094GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );  	   
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
