/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  EES_DMT_1004.js
*@FileTitle  : Basic Tariff Detail(s) Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/*------------------The following code added code to make a good  JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business calendar-related functions are defined as.
     * @author Hanjin Shipping
     */

   	/* Developer's task	*/
    // common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//  business global variables
	var CONTINENT="CONTI";
	var COUNTRY="CNT";
	var REGION="RGN";
	var STATE="STE";
	var LOCATION="LOC";
	var YARD="YD";
    var ALL_TARIFF_CD="all_tariff_cd"; 
    var CNTR_CARGE="CONTR_CGO";
	var ROWMARK="|";
	var FIELDMARK="=";
	var Mincount=0 ;
	var DEF_SHEET_HEIGHT = 398;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 135;
		
	var isNoChangeActive=false;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
    	///alert("processButtonClick");
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_new":
					initControl();
					break;
 				case "btn_minimize":
                    Mincount=(Mincount+1)%2 ;
                    Minimize(Mincount);
                    break;
				case "btn_downexcel":
				    t1901SpeedDownExcel();
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
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
        	ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
        initAxonControl();
        
        sheet1_OnLoadFinish(sheet1);
    }
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj=document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST08,"","");
    }

    function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
        //ComOpenWait End
        ComOpenWait(false);
    	for(var i=0; i<= sheetObj.RowCount()+1; i++) {
			if(sheetObj.GetCellValue(i, "expire_chk") == "Y") {
				sheetObj.SetCellFontColor(i, 5,"#FF0000");
				sheetObj.SetCellFontColor(i, 6,"#FF0000");
				sheetObj.SetCellFontColor(i, 7,"#FF0000");
			}
		}
		sheetObj.SetCellValue(1,"xcld_sat_flg",sheetObj.GetCellValue(2,"wknd1"));
		sheetObj.SetCellValue(1,"xcld_sun_flg",sheetObj.GetCellValue(2,"wknd2"));
    }
    
    function sheet2_OnSearchEnd(sheetObj, code, ErrMsg) {
        //ComOpenWait End
        ComOpenWait(false);
        if(sheetObj.RowCount() < 1){//no data
            ComShowCodeMessage("COM132501");
        }else{
        	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObj), SheetDesign:1,Merge:1 });
        }
    }
    /**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      // sheet4 init
                with(sheetObj){
                
              var HeadTitle1="|Tariff\nType|Coverage|ORG/\nDest.|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T EXCL|F/T EXCL|F/T EXCL|Free Time|Free Time|Charge|Charge|Charge|Charge|Charge|Charge|expire_chk|wknd1|wknd2";
              var HeadTitle2="|Tariff\nType|Coverage|ORG/\nDest.|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|Sat|Sun|HOLI|No.of\nCNTR|Free Day|CUR|Over Day|20FT|40FT|H/C|45FT|expire_chk|wknd1|wknd2";
              var headCount=ComCountHeadTitle(HeadTitle1);
              (headCount, 0, 0, true);

              SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:7, Page:20, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"covrg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_dest",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_grp_seq" },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_bzc_trf_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_cmnc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sat_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sun_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_hol_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"free_time",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Int",       Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"over_day",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_20ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_40ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_hc_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_45ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"expire_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wknd1",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wknd2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0} ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetSheetHeight(DEF_SHEET_HEIGHT);
              }


				break;
            case "sheet2":      // sheet4 init
                with(sheetObj){
                
              var HeadTitle1="|Tariff\nType|Coverage|ORG/\nDest.|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T Exclusion|F/T Exclusion|F/T Exclusion|Free Time|Free Time|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|expire_chk|wknd1|wknd2";
              var HeadTitle2="|Tariff\nType|Coverage|ORG/\nDest.|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|Sat|Sun|H/day|CNTR\nQ'ty|Free Day|Cur.|Over Day|20FT|40FT|H/C|45FT|expire_chk|wknd1|wknd2";
              var headCount=ComCountHeadTitle(HeadTitle1);
              (headCount, 0, 0, true);

              
              SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:7, Page:20, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"covrg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_dest",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_grp_seq" },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_bzc_trf_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_cmnc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sat_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_sun_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"xcld_hol_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"free_time",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"over_day",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_20ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_40ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_hc_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_45ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"expire_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wknd1",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wknd2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetSheetHeight(302);
              }


                break;
        }
    }    
    // Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      
        		setParameters(SEARCH);
				if (validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == "sheet1") {
						initResultControls();
						ComSetObjValue(formObj.f_cmd, SEARCH02 ); 
	                    //ComOpenWait Start
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);
	                    sheetObj.DoSearch("EES_DMT_1004GS.do", FormQueryString(formObj) );
//						for(var i=0; i<= sheetObj.RowCount()+1; i++) {
//							if(sheetObj.GetCellValue(i, "expire_chk") == "Y") {
//								sheetObj.SetCellFontColor(i, 5,"#FF0000");
//								sheetObj.SetCellFontColor(i, 6,"#FF0000");
//								sheetObj.SetCellFontColor(i, 7,"#FF0000");
//							}
//						}
//						sheetObj.SetCellValue(1,"xcld_sat_flg",sheetObj.GetCellValue(2,"wknd1"));
//						sheetObj.SetCellValue(1,"xcld_sun_flg",sheetObj.GetCellValue(2,"wknd2"));
					}
                    if (sheetObj.id == "sheet2") {
                        ComSetObjValue(formObj.f_cmd, SEARCH02 ); 
	                    //ComOpenWait Start
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);
	                    sheetObj.DoSearch("EES_DMT_1004GS.do", FormQueryString(formObj) );
//                        for(var i=0; i<= sheetObj.RowCount()+1; i++) {
//							if(sheetObj.GetCellValue(i, "expire_chk") == "Y") {
//								sheetObj.SetCellFontColor(i, 5,"#FF0000");
//								sheetObj.SetCellFontColor(i, 6,"#FF0000");
//								sheetObj.SetCellFontColor(i, 7,"#FF0000");
//                            }
//                        }
//						sheetObj.SetCellValue(1,"xcld_sat_flg",sheetObj.GetCellValue(2,"wknd1"));
//						sheetObj.SetCellValue(1,"xcld_sun_flg",sheetObj.GetCellValue(2,"wknd2"));
                    }
				}
				break;	
		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
			if (sheetObj.id == "sheet1") {
				if(sheetObject1.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObj), SheetDesign:1,Merge:1 });
                }
					
			}; 
			break;
		}			
    }    
	function initAxonControl() {  
		axon_event.addListenerFormat('blur',	'obj_blur',		form);
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); 
		axon_event.addListener('keydown', 'obj_keydown',  'cvrg_location', 'yd_cd1', 'org_dest_location');
	}
	function obj_keypress(){ 
	    obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');          
	            break;   
	    }   
	}
	function obj_blur() {
		obj=event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage('DMT00110');
			ComClearObject(obj);
		}
	}
	function obj_keydown() {
		if(event.keyCode == 13) {
			//obj = event.srcElement;
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	/**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
    	//Coverage Continent Valid check
    	if(ComTrim(ComGetObjValue(formObj.cvrg_conti_cd)) == "") {
    		ComAlertFocus(formObj.combo1, ComGetMsg('COM12113', "Coverage Continent"));
    		return false;
    	}
    	//Coverage Country Valid check
    	if(ComTrim(ComGetObjValue(formObj.cvrg_cnt_cd)) == "") {
    		ComAlertFocus(formObj.combo2, ComGetMsg('COM12113', "Coverage Country"));
    		return false;
    	}
    	//Validity check
    	if(!formObj.validity1.checked && !formObj.validity2.checked && !formObj.validity3.checked) {
    		ComShowCodeMessage('COM12114', "Validity");
    		return false;
    	}
        return true;
    }
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
	} 
	function initCombo(comboObj, comboNo) {
	    var formObj=document.form
	    switch(comboNo) {  
	    	//Continent
	    	case 1: 
	    		with (comboObj) { 	    		
					SetColBackColor(0, "#CCFFFD");
					SetColBackColor(1, "#CCFFFD");
	    		}
	    	case 5:
	    		with (comboObj) {
	    			SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "100");
					SetDropHeight(160);
					ValidChar(2);
					SetMaxLength(1);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObj);
			break;
			
			//Country
	    	case 2:
	    		with (comboObj) { 	    		
					SetColBackColor(0, "#CCFFFD");
					SetColBackColor(1, "#CCFFFD");
    			}	    		
	    	case 6:
	    		with (comboObj) {
	    			SetMultiSelect(0);
	    			UseAutoComplet=false;
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "200");
					SetDropHeight(160);
					ValidChar(2);
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(2);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObj);
	    	break;
	    	
	    	//Region
	    	case 3:
	    	case 7:
	    		with (comboObj) {
  					SetMultiSelect(0);
  					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "40");
					SetColWidth(1, "200");
  					SetDropHeight(160);
  					ValidChar(2);
//no support[check again]CLT 					ValidChar(2,0);		
//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(3);
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
	    	break;
	    	
		    //Coverage Yard
	    	case 4:
	    		with (comboObj) {
  					SetMultiSelect(0);
  					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColWidth(0, "50");
  					SetDropHeight(160);
  					ValidChar(2, 1);
					SetMaxLength(2);
	    		}
	    		comboObj.InsertItem(0, "", "");
	    	break;
	    	//Tariff Type

	    	case 8:
	    		with (comboObj) {
  					SetMultiSelect(1);
  					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "55");
					SetColWidth(1, "330");
  					SetDropHeight(160);
  					SetColBackColor(0, "#CCFFFD");
  					SetColBackColor(1, "#CCFFFD");  					
  					SetMultiSeparator(",");
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObj);
	    	break;
	    	
		    //CNTR & Cargo Type
	    	case 9:
	    		with (comboObj) {
  					SetMultiSelect(1);
  					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "300");
  					SetDropHeight(200);
  					SetMultiSeparator(",");
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH11,CNTR_CARGE,comboObj);
	    	break;
	     } 
	} 	
	function combo1_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo1(comboObj, Index_Code, Text);
	}
	function search_combo1(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		clearLocation1();
		clearYard();
	}	
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo1(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	function combo2_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo2(comboObj, Index_Code, Text);
	}
	function search_combo2(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		if (comboObj.GetSelectText()== "CA" || comboObj.GetSelectText()== 'US') {
			Region.innerHTML="State";
		} else {
			Region.innerHTML="Region";
		}
		var formObj=document.form;
		isNoChangeActive=true;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive=false;
		clearLocation1();
		clearYard();
	}	
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo2(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	function combo3_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo3(comboObj, Index_Code, Text);
	}
	function search_combo3(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) return;
		if (comboObj.GetSelectText().length == 0) return;
		var formObj=document.form;
		isNoChangeActive=true;
		if(comboObj.GetSelectText().length == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		isNoChangeActive=false;	
		clearLocation1();
		clearYard();
	}
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo3(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}		
	function checkLocation1(obj) {
		if(isAlpha()) {
			if (isNoChangeActive) return;
			var formObj=document.form;
	    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
				var locCd=ComTrim(ComGetObjValue(obj));
	    		if (locCd.length > 0) {
	    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
	    				Region.innerHTML="State";
	    			}else{
	    				Region.innerHTML="Region";
	    			}
	    			isNoChangeActive=true;
	    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
	    			isNoChangeActive=false;
				}
	    	}		
		}
	}
	function checkYard1(obj) {
		if(isAlpha()) {
			checkYard1_sub1(obj);
			checkYard1_sub2(obj);
		}
	}
	function checkYard1_sub1(obj) {
		if (isNoChangeActive) return;
		var formObj=document.form;
    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
			var yardCd1=ComTrim(ComGetObjValue(obj));
    		if (yardCd1.length > 0) {
    			if(yardCd1.substring(0,2) == "CA" || yardCd1.substring(0,2) == "US") {
    				Region.innerHTML="State";
    			}else{
    				Region.innerHTML="Region";
    			}
    			isNoChangeActive=true;
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
				isNoChangeActive=false;
			}
    	}
	}
	function checkYard1_sub2(obj) {
		if (isNoChangeActive) return;
		var formObj=document.form;
    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
			var yardCd1=ComTrim(ComGetObjValue(obj));
    		if (yardCd1.length > 0) {
				isNoChangeActive=true;
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH14,YARD,obj);
				isNoChangeActive=false;
			}
    	}
	}	
	function combo4_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo4(comboObj, Index_Code, Text);
	}
	function search_combo4(comboObj, searchIndex, searchText) {
		if(comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		if(searchIndex == undefined || searchIndex == ""){
			comboObj.SetSelectText("");
			return;
		}
		var formObj=document.form;
		isNoChangeActive=true;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,COMMAND03,YARD,comboObj);
		isNoChangeActive=false;
	}
	function combo4_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo4(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	function combo5_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo5(comboObj, Index_Code, Text);
	}
	function search_combo5(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		clearLocation2();
	}
	function combo5_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo5(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	function combo6_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo6(comboObj, Index_Code, Text);
	}
	function search_combo6(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) return;
		if (comboObj.GetSelectText().length == 0 ) return;
		if (comboObj.GetSelectText()== "CA" || comboObj.GetSelectText()== 'US') {
			Region2.innerHTML="State";
		} else {
			Region2.innerHTML="Region";
		}
		var formObj=document.form;
		isNoChangeActive=true;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive=false;
	}
	function combo6_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo6(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	
	function combo7_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, Text, Index_Code) {
		search_combo7(comboObj, Index_Code, Text);
	}
	function search_combo7(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) return;
		if (comboObj.GetSelectText().length == 0) return;
		var formObj=document.form;
		isNoChangeActive=true;
		if(comboObj.GetSelectText().length == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		isNoChangeActive=false;
	}
	function combo7_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo7(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	function checkLocation2(obj) {
		if(isAlpha()) {
			if (isNoChangeActive) return;
			var formObj=document.form;
	    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
				var locCd=ComTrim(ComGetObjValue(obj));
	    		if (locCd.length > 0) {
	    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
	    				Region2.innerHTML="State";
	    			}else{
	    				Region2.innerHTML="Region";
	    			}
	    			isNoChangeActive=true;
	    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
	    			isNoChangeActive=false;
				}
	    	}		
		}
	}
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		var index_1=0;
		var index_2=0;
		var index_3=0;
		switch(sAction) {
           case IBSEARCH:      
				if (sheetObj.id == "sheet1") {
					var comboDatas;
					var comboItems;
					switch(sComboAction) {
						case SEARCHLIST08:
							ComSetObjValue(formObj.f_cmd, SEARCHLIST08); 
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					        //ALL_TARIFF_TYPE
					        comboItems=ComGetEtcData(sXml, ALL_TARIFF_CD).split(ROWMARK);
							addComboItem(comboObjects[7],comboItems);						
							for (var i=0 ; i < comboItems.length ; i++) {
					    		var comboItem=comboItems[i].split(FIELDMARK);
					    		comboObjects[7].SetItemCheck(i,1);
					    	}  	
							//Cntr & Cargo
							comboItems=ComGetEtcData(sXml, CNTR_CARGE).split(ROWMARK);
							addComboItem2(comboObjects[8],comboItems);
							for (var i=0 ; i < comboItems.length ; i++) {
					    		var comboItem=comboItems[i].split(FIELDMARK);
					    		comboObjects[8].SetItemCheck(i,1);
					    	}
							//Coverage Continent
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
					            comboItems=comboDatas.split(ROWMARK);
					            comboObjects[0].SetSelectCode("-1");
					            comboObjects[0].RemoveAll();
					            addComboItem(comboObjects[0],comboItems);
					        }
							//Coverage Country 
							comboDatas=ComGetEtcData(sXml, COUNTRY);
					        if (comboDatas != undefined) {
					            comboItems=comboDatas.split(ROWMARK);
					            comboObjects[1].SetSelectCode("-1");
					            comboObjects[1].RemoveAll();
					            addComboItem(comboObjects[1],comboItems); //COUNTRY
					        }
					        //Coverage Region
					        comboDatas=ComGetEtcData(sXml, REGION);
					        if (comboDatas != undefined) {
					            comboItems=comboDatas.split(ROWMARK);
					            comboObjects[2].SetSelectCode("-1");
					            comboObjects[2].RemoveAll();
					            addComboItem(comboObjects[2],comboItems); //COUNTRY
					        }
					        //Coverage Continent
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
					            comboItems=comboDatas.split(ROWMARK);
					            comboObjects[4].SetSelectCode("-1");
					            comboObjects[4].RemoveAll();
					            addComboItem(comboObjects[4],comboItems);
					        }
							//Coverage Country 
							comboDatas=ComGetEtcData(sXml, COUNTRY);
					        if (comboDatas != undefined) {
					            comboItems=comboDatas.split(ROWMARK);
					            comboObjects[5].SetSelectCode("-1");
					            comboObjects[5].RemoveAll();
					            addComboItem(comboObjects[5],comboItems); //COUNTRY
					        }
					        //Coverage Region
					        comboDatas=ComGetEtcData(sXml, REGION);
					        if (comboDatas != undefined) {
					            comboItems=comboDatas.split(ROWMARK);
					            comboObjects[6].SetSelectCode("-1");
					            comboObjects[6].RemoveAll();
					            addComboItem(comboObjects[6],comboItems); //COUNTRY
					        }
							break;
						//1. CONTINENT LIST
						case SEARCH08:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo1") {
								index_1=0;
							} else {
								index_1=4;
							}
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//CONTINENT
							}else{
								ComShowCodeMessage("DMT06001");
							}
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							if(sObj.options.id == "combo2") {
								index_1=1;
							} else {
								index_1=5;
							}
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//COUNTRY
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//3. REGION LIST
						case SEARCH01:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.options.id == "combo3" || sObj.options.id == "combo1") {
								index_1=2;
							} else {
								index_1=6;
							} 
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_1].SetSelectCode("-1");
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//REGION
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						case SEARCH06:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							
                            var sObj_name = "";
                            if ( sObj.name == "cvrg_location" || sObj.name == "yd_cd1" || sObj.name == "org_dest_location"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
                            
					        if(sObj_name == "combo1" || sObj_name == "combo3" || sObj_name == "cvrg_location"
								|| sObj_name == "combo4" || sObj_name == "yd_cd1") {
								index_1=1;
							}else{
								index_1=5;
							}
							comboDatas=ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								if(comboDatas != "") {
									comboItems=comboDatas.split(ROWMARK);
									comboObjects[index_1].SetSelectCode("-1");
									comboObjects[index_1].RemoveAll();
									addComboItem(comboObjects[index_1],comboItems);	//Country
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						case SEARCH12:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					        if(sObj.options.id == "combo2") {
								index_1=0;
							} else {
								index_1=4;
							}
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if( comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);	//Continent
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						case SEARCH03:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							
                            var sObj_name = "";
                            if ( sObj.name == "cvrg_location" || sObj.name == "yd_cd1" || sObj.name == "org_dest_location"){
                            	sObj_name = sObj.name;
                            } else {
                            	sObj_name = sObj.options.id;
                            }
                            
					        if(sObj_name == "combo2" || sObj_name == "combo3" || sObj_name == "combo4" 
								|| sObj_name == "cvrg_location" || sObj_name == "yd_cd1") {
								index_1=1;
								index_2=2;
								clearLocation1();
							} else {
								index_1=5;
								index_2=6;
								clearLocation2();
							}
							if(comboObjects[index_1].GetSelectText()== "CA" || comboObjects[index_1].GetSelectText()== "US" ) {
								//State
								comboDatas=ComGetEtcData(sXml, STATE);
							}else{
	                                                                                                                                                                                        									//Region
								comboDatas=ComGetEtcData(sXml, REGION);
							}
							if(comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();				//Region
								addComboItem(comboObjects[index_2],comboItems);
							}else {
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						case SEARCH17:
						case SEARCH13:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					        if(sObj.options.id == "combo3") {
								index_1=0;
								index_2=1;	
								index_3=2;
								clearLocation1();
							} else {
								index_1=4;
								index_2=5;
								index_3=6;
								clearLocation2();
							}
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined) {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);	//Country
									comboObjects[index_3].SetSelectCode("-1");
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									comboDatas=ComGetEtcData(sXml, sComboKey);
									if (comboDatas != undefined) {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}							
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						case SEARCH10:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					        var location=ComGetObjValue(sObj);
							if(sObj.name == "cvrg_location" || sObj.name == "yd_cd1") {
								index_1=0;
								index_2=1;	
								index_3=2;
								clearLocation1();
							} else {
								index_1=4;
								index_2=5;
								index_3=6;
								clearLocation2();
							}
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								//Continent Setting
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();					//Country
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined) {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);
									comboObjects[index_3].SetSelectCode("-1");
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
										comboDatas=ComGetEtcData(sXml, STATE);
					    			}else{
										comboDatas=ComGetEtcData(sXml, REGION);
					    			}
									if (comboDatas != undefined) {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
										//location setting
										ComSetObjValue(sObj, location);
										if(sObj.name == "cvrg_location") {
											//yd_cd1 Setting
											ComSetObjValue(formObj.yd_cd1, ComGetObjValue(formObj.cvrg_location));
											isNoChangeActive=false;
											checkYard1_sub2(formObj.yd_cd1);
											ComSetFocus(formObj.yd_cd1);
										}
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
					    		ComAlertFocus(sObj, ComGetMsg('DMT00110'));
								clearObjectValue(sObj);
							}
							break;
						//ALL_TARIFF_TYPE
						case SEARCH09:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					        comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							addComboItem(sObj,comboItems);						
							for (var i=0 ; i < comboItems.length ; i++) {
					    		var comboItem=comboItems[i].split(FIELDMARK);
					    		sObj.SetItemCheck(i,1);
					    	}  		
							break;
						//Cntr & Cargo
						case SEARCH11:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					        comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							addComboItem2(sObj,comboItems);
							for (var i=0 ; i < comboItems.length ; i++) {
					    		var comboItem=comboItems[i].split(FIELDMARK);
					    		sObj.SetItemCheck(i,1);
					    	}  		
							break;
						case SEARCH14:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					        var yd_cd1=ComGetObjValue(sObj);
							ComSetObjValue(formObj.cvrg_location, yd_cd1);
							index_1=3;
							comboObjects[3].SetSelectCode("-1");
							comboObjects[3].RemoveAll();
							comboDatas=ComGetEtcData(sXml, YARD);
							if (comboDatas == undefined ||comboDatas == "") {
//								ComShowCodeMessage("DMT06001");
//								ComSetObjValue(formObj.cvrg_location, "");
//								ComSetObjValue(formObj.yd_cd1, "");
							}else{
								comboItems=comboDatas.split(ROWMARK);
								addComboItem1(comboObjects[index_1],comboItems);	
								setComboItem(comboObjects[index_1],comboItems);
							}
							break;
						case COMMAND03:
							setComboParameters(sComboAction, sObj);	
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					        index_1=0;
							index_2=1;
							index_3=2;
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);
								comboObjects[index_2].SetSelectCode("-1");
								comboObjects[index_2].RemoveAll();
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined) {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);
									comboObjects[index_3].SetSelectCode("-1");
									comboObjects[index_3].RemoveAll();
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									//Region/State Setting
									if(comboObjects[index_2].GetSelectText()== "CA" || comboObjects[index_2].GetSelectText()== "US" ) {
										comboDatas=ComGetEtcData(sXml, STATE);
									}else{
										comboDatas=ComGetEtcData(sXml, REGION);
									}
									if (comboDatas != undefined) {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);
										//location setting
										ComSetObjValue(formObj.cvrg_location, ComGetObjValue(formObj.yd_cd1));
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;								
					}
				};
                break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
    function addComboItem(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
    function addComboItem2(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
    		comboObj.InsertItem(i, ComReplaceStr(comboItem[1],"^"," - ") , comboItem[0]);
    	}   		
	}
    function addComboItem1(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
    	}   		
	}
    function Minimize(nItem)
    {
        var objs=document.all.item("showMin");
        if ( nItem == "1" )
        {
    	    objs.style.display="none";
    	    sheetObjects[0].SetSheetHeight(MAX_SHEET_HEIGHT);
    	}
    	else
    	{
    	    objs.style.display="inline";
    	    sheetObjects[0].SetSheetHeight(DEF_SHEET_HEIGHT);
    	}
    }
	function setParameters(sAction) {
		var formObj=document.form;
		//Coverage ComboSetting
		ComSetObjValue(formObj.cvrg_conti_cd, comboObjects[0].GetSelectText());
		ComSetObjValue(formObj.cvrg_cnt_cd, comboObjects[1].GetSelectText());
		ComSetObjValue(formObj.cvrg_rgn_cd, comboObjects[2].GetSelectText());
		ComSetObjValue(formObj.cvrg_loc_cd, ComGetObjValue(formObj.cvrg_location));
		ComSetObjValue(formObj.cvrg_yd_cd, comboObjects[3].GetSelectCode());
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.org_dest_conti_cd, comboObjects[4].GetSelectText());
		ComSetObjValue(formObj.org_dest_cnt_cd, comboObjects[5].GetSelectText());
		ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[6].GetSelectText());
		ComSetObjValue(formObj.org_dest_loc_cd, ComGetObjValue(formObj.org_dest_location));
		//others
		ComSetObjValue(formObj.dmdt_trf_cd_list, comboObjects[7].GetSelectText());
		ComSetObjValue(formObj.dmdt_cntr_cgo_list, comboObjects[8].GetSelectCode());
		//Retrieve Setting
		//ComSetObjValue(formObj.f_cmd, sAction);							//Command
	}
	function setComboParameters(sComboAction, sObj) {
		var formObj=document.form;
		
        var sObj_name = "";
        if ( sObj.name == "cvrg_location" || sObj.name == "yd_cd1" || sObj.name == "org_dest_location"){
        	sObj_name = sObj.name;
        } else {
        	sObj_name = sObj.options.id;
        }
        
		switch(sObj_name) {
			case "combo1":
			case "combo2":
			case "combo3":
			case "combo4":
			case "cvrg_location":
			case "yd_cd1":
				//Coverage ComboSetting
				ComSetObjValue(formObj.conti_cd, comboObjects[0].GetSelectText());
				ComSetObjValue(formObj.cnt_cd, comboObjects[1].GetSelectText());
				ComSetObjValue(formObj.rgn_cd, comboObjects[2].GetSelectText());
				ComSetObjValue(formObj.ste_cd, comboObjects[2].GetSelectText());
				if(sObj_name == "cvrg_location") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));
				} else if(sObj_name == "yd_cd1") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.yd_cd1));
				}
				ComSetObjValue(formObj.yd_cd, comboObjects[3].GetSelectCode());
				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;
			case "combo5":
			case "combo6":
			case "combo7":
			case "org_dest_location":
				//Origin/Dest ComboSettion
				ComSetObjValue(formObj.conti_cd, comboObjects[4].GetSelectText());
				ComSetObjValue(formObj.cnt_cd, comboObjects[5].GetSelectText());
				ComSetObjValue(formObj.rgn_cd, comboObjects[6].GetSelectText());
				ComSetObjValue(formObj.ste_cd, comboObjects[6].GetSelectText());
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.org_dest_loction));
				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;	
			case "combo8":
			case "combo9":
				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;
		}
	}
	
	/*function combo8_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}*/
	
	 var selComboIndex, selComboCode;
	 function combo8_OnSelect(comboObj ,index, code) {
	  selComboIndex = index;
	  selComboCode = code;
	 }
	 function combo8_OnChange(comboObj) {
	     ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	 }
	
	 var selComboIndex1, selComboCode1;
	 function combo9_OnSelect(comboObj ,index, code) {
	  selComboIndex1 = index;
	  selComboCode1 = code;
	 }
	 function combo9_OnChange(comboObj) {
	     ComSetMultiCombo(comboObj, selComboIndex1, selComboCode1);
	 }
	 
	/*function combo9_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}*/
	function setComboItem(comboObj,comboItems) {
		var checkedItem=comboItems[0].split(FIELDMARK);
		comboObj.SetSelectText(checkedItem[0]);
	}	
	function initResultControls() {
		sheetObjects[0].RemoveAll();
	}
	function clearLocation1() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
	}
	function clearLocation2() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.org_dest_location, "");
	}
	function clearObjectValue(obj) {
		switch(ComGetEvent("name")) {
			case "cvrg_location":
			case "yd_cd1":
			case "org_dest_location":
				obj.value="";
				break;
			default:
				obj.SetSelectText("");
				break;
		}
	}
	function clearYard() {
		var formObj=document.form;
		comboObjects[3].SetSelectCode("-1");
		comboObjects[3].RemoveAll();
		ComSetObjValue(formObj.yd_cd1, "");
		ComSetObjValue(formObj.cvrg_yd_cd, "");
		ComSetObjValue(formObj.yd_cd, "");
	}
	function initSearchControls() {
		var formObj=document.form;
		comboObjects[0].SetSelectCode("-1");
		comboObjects[0].RemoveAll();
		comboObjects[1].SetSelectCode("-1");
		comboObjects[1].RemoveAll();
		comboObjects[2].SetSelectCode("-1");
		comboObjects[2].RemoveAll();
		comboObjects[3].SetSelectCode("-1");
		comboObjects[3].RemoveAll();
		comboObjects[4].SetSelectCode("-1");
		comboObjects[4].RemoveAll();
		comboObjects[5].SetSelectCode("-1");
		comboObjects[5].RemoveAll();
		comboObjects[6].SetSelectCode("-1");
		comboObjects[6].RemoveAll();
		comboObjects[7].SetSelectCode("-1");
		comboObjects[7].RemoveAll();
		comboObjects[8].SetSelectCode("-1");
		comboObjects[8].RemoveAll();
		ComSetObjValue(formObj.conti_cd, "");	
		ComSetObjValue(formObj.cnt_cd, "");		
		ComSetObjValue(formObj.rgn_cd, "");		
		ComSetObjValue(formObj.ste_cd, "");		
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.yd_cd1, "");
		ComSetObjValue(formObj.yd_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
		ComSetObjValue(formObj.org_dest_location, "");
		ComSetObjValue(formObj.cvrg_conti_cd, "");
		ComSetObjValue(formObj.cvrg_cnt_cd, "");
		ComSetObjValue(formObj.cvrg_rgn_cd, "");
		ComSetObjValue(formObj.cvrg_loc_cd, "");
		ComSetObjValue(formObj.cvrg_yd_cd, "");
		ComSetObjValue(formObj.org_dest_conti_cd, "");
		ComSetObjValue(formObj.org_dest_cnt_cd, "");
		ComSetObjValue(formObj.org_dest_rgn_cd, "");
		ComSetObjValue(formObj.org_dest_loc_cd, "");
		ComSetObjValue(formObj.dmdt_trf_cd_list, "");
		ComSetObjValue(formObj.dmdt_cntr_cgo_list, "");
		ComSetObjValue(formObj.validity1, "Y");		//Validity
		ComSetObjValue(formObj.validity2, "Y");		//Validity
		ComSetObjValue(formObj.validity3, "");		//Validity
		Region.innerHTML="Region";
		Region2.innerHTML="Region";
	}
	function initControl() {
		initSearchControls();
		initResultControls();
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    var formObj=document.form;
	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST08,"","");
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[0]);		//1
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[1]);		//2
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[2]);			//3
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[4]);		//5
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[5]);		//6
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[6]);			//7
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObjects[7]);	//8
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH11,CNTR_CARGE,comboObjects[8]);		//9
	}
function t1901SpeedDownExcel () {
    sheetObjects[1].RemoveAll();
    doActionIBSheet( sheetObjects[1] , document.form , IBSEARCH );
//    sheetObjects[1].CellValue(1,"xcld_sat_flg") = sheetObjects[1].CellValue(2,"wknd1");
//    sheetObjects[1].CellValue(1,"xcld_sun_flg") = sheetObjects[1].CellValue(2,"wknd2");    
//    sheetObjects[1].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false,'','',false,'',true);
//    if(sheetObjects[1].RowCount() < 1){//no data
//        ComShowCodeMessage("COM132501");
//    }else{
//    	sheetObjects[1].Down2Excel({ HiddenColumn:-1});
//    }
	
}
	/* Developer's task end */
