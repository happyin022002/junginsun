/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4015.js
*@FileTitle  : SZPBB DEM Tariff Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================**/

/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/


    // Common Global variables

	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	
	//  Business Global Variables
	
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
				    //t1901SpeedDownExcel();
					if(sheetObject1.RowCount() < 1){//no data						
						ComShowCodeMessage("COM132501");
					}else{
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}
					//doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
     //IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
        initAxonControl();
        sheet1_OnLoadFinish();
        combo5.SetBackColor("#e9f4ff");
    }
    //no support[check again]CLT 
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj=document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST08,"","");
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[1]);		//1
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[2]);			//2
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[3]);			//3
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObjects[4]);	//4
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH11,CNTR_CARGE,comboObjects[5]);		//5	 	
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      // sheet4 init
                with(sheetObj){		                
		              //no support[check again]CLT 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		              var HeadTitle1="|Tariff\nType|Coverage|ORG/\nDest.|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T EXCL|F/T EXCL|F/T EXCL|Free Time|Free Time|Charge|Charge|Charge|Charge|Charge|Charge|expire_chk|wknd1|wknd2";
		              var HeadTitle2="|Tariff\nType|Coverage|ORG/\nDest.|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|SAT|SUN|HOLI|No.of\nCNTR|Free Day|CUR|Over Day|20FT|40FT|H/C|45FT|expire_chk|wknd1|wknd2";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              //(headCount, 0, 0, true);
		
		              //SetConfig( { SearchMode:2, FrozenCol:savenamecol("eff_dt"), MergeSheet:7, Page:20, DataRowMerge:1 } );
		              SetConfig( { SearchMode:2, FrozenCol:0, MergeSheet:7, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"covrg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_dest",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_bzc_trf_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Date",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_cmnc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"xcld_sat_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"xcld_sun_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"xcld_hol_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"free_time",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Int",       Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"over_day",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_20ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_40ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_hc_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cntr_45ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"expire_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wknd1",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"wknd2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 } ];
		               
		              InitColumns(cols);		
		              SetEditable(1);
		              SetCountPosition(0);
		              FrozenCols=SaveNameCol("eff_dt");
		              SetSheetHeight(332);
              	}
				break;
            case "sheet2":      // sheet4 init
                with(sheetObj){		                
		              //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		              var HeadTitle1="|Tariff\nType|Coverage|ORG/\nDest.|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T Exclusion|F/T Exclusion|F/T Exclusion|Free Time|Free Time|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|expire_chk|wknd1|wknd2";
		              var HeadTitle2="|Tariff\nType|Coverage|ORG/\nDest.|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|Sat|Sun|H/day|CNTR\nQ'ty|Free Day|Cur.|Over Day|20FT|40FT|H/C|45FT|expire_chk|wknd1|wknd2";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              //(headCount, 0, 0, true);
		
		              //SetConfig( { SearchMode:2, FrozenCol:savenamecol("eff_dt"), MergeSheet:7, Page:20, DataRowMerge:1 } );
		              SetConfig( { SearchMode:2, FrozenCol:0, MergeSheet:7, Page:20, DataRowMerge:1 } );
		
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
		              FrozenCols=SaveNameCol("eff_dt");
		              SetSheetHeight(302);
              	}
                break;
        }
    }    
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      // Retrieve
				//1.Inquiry ago, the parameter is set to a value type or allows selected.
				setParameters(SEARCH);				
				if (validateForm(sheetObj,formObj,sAction)) {					
					if (sheetObj.id == "sheet1") {
						if(ComGetObjValue(formObj.combo4) == "") {
							ComSetObjValue(formObj.yd_cd1, "");
						}						
						//2.Inquiry ago, the result makes Empty fields.
						initResultControls();						
						ComSetObjValue(formObj.f_cmd, SEARCH02 ); 
	                    //ComOpenWait Start						
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);
						//2.Inquiry as a query is run conditions	                    
	                    sheetObj.DoSearch("EES_DMT_4015GS.do", FormQueryString(formObj) );	                    
					}
                    if (sheetObj.id == "sheet2") {
                    	//alert(222222);
                        ComSetObjValue(formObj.f_cmd, SEARCH02 ); 
	                    //ComOpenWait Start
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);
                        //2.Inquiry as a query is run conditions                         
	                    sheetObj.DoSearch("EES_DMT_4015GS.do", FormQueryString(formObj) );	                    
                    }
				}
				break;	
   		case IBCLEAR:       //initializing
			initSearchControls();
			//buttonMode("IBCLEAR");
			break;
		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
			if (sheetObj.id == "sheet1") {			
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			}; 
			break;
		}			
    }    
	function initAxonControl() {  
		axon_event.addListenerFormat('blur',	'obj_blur',		form); // out of focus
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); // Keyboard input
		axon_event.addListener('keydown', 'obj_keydown',  'cvrg_location', 'yd_cd1', 'org_dest_location');	
	}
	
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		
		if (sheetObj.id == "sheet1") {
			
	        //3.Expired Validity	                    
			for(var i=0; i<= sheetObj.RowCount()+1; i++) {
				if(sheetObj.GetCellValue(i, "expire_chk") == "Y") { 								
					sheetObj.SetCellFontColor(i, 5,"#FF0000"); 								
					sheetObj.SetCellFontColor(i, 6,"#FF0000");
					sheetObj.SetCellFontColor(i, 7,"#FF0000");
				}
			}
			//alert(6);
			sheetObj.SetCellValue(1,"xcld_sat_flg",sheetObj.GetCellValue(2,"wknd1"));
			//alert(7);
			sheetObj.SetCellValue(1,"xcld_sun_flg",sheetObj.GetCellValue(2,"wknd2"));
			
			//ComOpenWait End	                    
	        ComOpenWait(false);
		}
		
		if (sheetObj.id == "sheet2") {
			
			//ComOpenWait End
            ComOpenWait(false);
            //3.Expired Validity
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
	}
	
	
	/*
	 * Location field, enter the letters converted to upper case
	 */		
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
	/*
	 * Location FocusOut, input digits for the Validation Check
	 */
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
     *  handling process for input validation
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
	/** 
	 * IBCombo Object set to an array
	 * param : combo_obj 
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
	} 
	/**
	 * Initializing Combo 
	 * param : comboObj , comboNo
	 * adding case as numbers of counting Combos 
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObj=document.form;
	    switch(comboNo) {
	    	//Coverage Yard
	    	case 1:
	    		with (comboObj) {
					SetMultiSelect(0);
					//UseAutoComplete = false;	
					SetColAlign(0, "left");
					SetColWidth(0, "50");
					SetDropHeight(160);
					ValidChar(2, 1);	
					SetMaxLength(2);
	    		}
	    		comboObj.InsertItem(0, "", "");
	    		break;
	    	//Continent
	    	case 2:
	    		with (comboObj) {
					SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "100");
					SetDropHeight(160);
					ValidChar(2);
					//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(1);
	    		}
	    		break;
	    	//Country
	    	case 3:
	    		with (comboObj) {
	    			SetMultiSelect(0);
	    			UseAutoComplet=false;
	    			SetColAlign(0, "left");
	    			SetColAlign(1, "left");
	    			SetColWidth(0, "30");
	    			SetColWidth(1, "200");
	    			SetDropHeight(160);
	    			ValidChar(2);
	    			//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(2);
	    		}
	    		break;
	    	//Region
	    	case 4:
	    		with (comboObj) {
	    			SetMultiSelect(0);
					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "40");
					SetColWidth(1, "200");
					SetDropHeight(160);
					ValidChar(2);
					//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(3);
	    		}
	    		break;
	    	//Tariff Type
	    	case 5:
//	    		with (comboObj) {
//	    			MultiSelect = true; 
//					UseAutoComplete = true;	
//					SetColAlign("left|left");        
//					SetColWidth("55|330");
//					DropHeight = 160;
//	    		}
				with (comboObj) {
                    SetMultiSelect(0);
                    SetUseAutoComplete(1);
                    SetColAlign(0, "left");
                    SetColAlign(1, "left");
                    SetColWidth(0, "55");
                    SetColWidth(1, "330");
                    SetDropHeight(160);
                    ValidChar(2);
                    //no support[check again]CLT IMEMode=0;
                    SetMaxLength(4);
				}
	    		break;
	    	//CNTR & Cargo Type
	    	case 6:
	    		with (comboObj) {
	    			SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "300");
					SetDropHeight(200);
	    		}
	    		with (comboObj) {	                
	    			SetMultiSeparator(",");	                 
	    		}
	    		break;
	    }
	} 	
	/*
	 * Location Search Field, if entered in the Enter Key 
	 * Location that contains the Continent, Country and Region or State functions to query information
	 */		
	function checkLocation1(obj) {
		if(isAlpha()) {
			if (isNoChangeActive) return;
			var formObj=document.form;
	    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
				var locCd=ComTrim(ComGetObjValue(obj));
	    		if (locCd.length > 0) {
	    			isNoChangeActive=true;
	    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);	//ContinentHierarchyByLocation(conti,cnt,rgn,ste,loc)
	    			isNoChangeActive=false;
				}
	    	}		
		}
	}	
	/*
	 *yd_cd1 Search Field, if entered in the Enter Key
	 * Corresponding to the YARD LOCATION function to query information
	 */		
	function checkYard1(obj) {
		if(isAlpha()){
			checkYard1_sub1(obj);
			checkYard1_sub2(obj);
		}
	}
	/*
	 * Retrieve input location yd_cd1.
	 */
	function checkYard1_sub1(obj) {
		if (isNoChangeActive) return;
		var formObj=document.form;
	   	if (ComTrim(ComGetObjValue(obj)).length == 5) {
			var yardCd1=ComTrim(ComGetObjValue(obj));
	   		if (yardCd1.length > 0) {
				isNoChangeActive=true;
	   			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);	//ContinentHierarchyByLocation(conti,cnt,rgn,ste,loc)
				isNoChangeActive=false;
			}
	   	}
	}
	/*
	 * query input is yd_cd1 yd_cd list.
	 */
	function checkYard1_sub2(obj) {
		if (isNoChangeActive) return;
		var formObj=document.form;
		if (ComTrim(ComGetObjValue(obj)).length == 5) {
			var yardCd1=ComTrim(ComGetObjValue(obj));
			if (yardCd1.length > 0) {
				isNoChangeActive=true;
				doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH14,YARD,obj);		//yard_code list
				isNoChangeActive=false;
			}
		}
	}		
	/*
	 * Continent Combo event
	 * Country belonging to query information.
	 */		
	function combo2_OnChange(comboObj, Index_Code, Text) {
		search_combo2(comboObj, Index_Code, Text);
	}
	function search_combo2(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);	//CountryListByContinent
		//Region initialization
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);		//SearchRegionList
		//Location initialization
		clearLocation2();
	}
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo2(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Country Combo event
	 * Part of the Continent, Region or State functions that query information
	 */		
	function combo3_OnChange(comboObj, Index_Code, Text) {
		search_combo3(comboObj, Index_Code, Text);
	}
	function search_combo3(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive)	return;
		if (comboObj.GetSelectText()== "CA" || comboObj.GetSelectText()== 'US') {
			Region2.innerHTML="State";
		} else {
			Region2.innerHTML="Region";
		}
		var formObj=document.form;
		isNoChangeActive=true;
		//Continent 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);		//SearchContinetListByCountry
		//Region 
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);			//SearchRegionListByCountry, searchStateListByCountry
		isNoChangeActive=false;
		//Location initialization
		clearLocation2();
	}
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo3(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Region or State Combo event
	 * If a change occurs in Search Field, Location Search Field and initializing functions that
	 */	
	function combo4_OnChange(comboObj, Index_Code, Text) {
		search_combo4(comboObj, Index_Code, Text);
	}
	function search_combo4(comboObj, searchIndex, searchText) {
		var region_len=comboObj.GetSelectText().length ;
		if (region_len == 0)	return;
		if (isNoChangeActive)	return;
		var formObj=document.form;
		isNoChangeActive=true;
		if(region_len == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
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
	/*
	 * Location Search Field, if entered in the Enter Key, Location that contains the Continent, Country and Region or State functions to query information
	 */		
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
	// Search criteria field data retrieval Combo
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
           case IBSEARCH:      // Search
				if (sheetObj.id == "sheet1") {
					//3.After handling Retrieving results
					var comboDatas;
					var comboItems;
					switch(sComboAction) {
						case SEARCHLIST08:
					        //1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST08); 
					        //2.Inquiry as a query is run conditions
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
					        //Origin/Dest. Continent
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
					            comboItems=comboDatas.split(ROWMARK);
					            //Change the selection to a usable state
					            comboObjects[1].SetSelectCode("-1");
					            comboObjects[1].RemoveAll();
					            addComboItem(comboObjects[1],comboItems);
					        }
							//Coverage Country 
							comboDatas=ComGetEtcData(sXml, COUNTRY);
					        if (comboDatas != undefined) {
					            comboItems=comboDatas.split(ROWMARK);
					            comboObjects[2].SetSelectCode("-1");
					            comboObjects[2].RemoveAll();
					            addComboItem(comboObjects[2],comboItems); //COUNTRY
					        }
					        //Coverage Region
					        comboDatas=ComGetEtcData(sXml, REGION);
					        if (comboDatas != undefined) {
					            comboItems=comboDatas.split(ROWMARK);
					            comboObjects[3].SetSelectCode("-1");
					            comboObjects[3].RemoveAll();
					            addComboItem(comboObjects[3],comboItems); //COUNTRY
					        }
					        //ALL_TARIFF_TYPE
					        comboItems=ComGetEtcData(sXml, ALL_TARIFF_CD).split(ROWMARK);
					        var comboItemsTariff=new Array();
					        //alert(888888888);
							for (var i=0 ; i < comboItems.length ; i++) {
								var comboItem=comboItems[i].split(FIELDMARK);
								//alert(comboItem[0]);
								if(comboItem[0] == "All") {
									comboItemsTariff[0]=comboItems[i];
								}else if(comboItem[0] == "DMIF") {
									comboItemsTariff[1]=comboItems[i];
								}else if(comboItem[0] == "DMOF") {
									comboItemsTariff[2]=comboItems[i];
								}
							}
							addComboItem(comboObjects[4],comboItemsTariff);	
							comboObjects[4].SetSelectIndex(0);
							for (var i=0 ; i < comboItemsTariff.length ; i++) {
					    		var comboItem=comboItemsTariff[i].split(FIELDMARK);
					    		comboObjects[4].SetItemCheck(i,1);
					    	}   	
							//Cntr & Cargo
							comboItems=ComGetEtcData(sXml, CNTR_CARGE).split(ROWMARK);
							addComboItem2(comboObjects[5],comboItems);
							for (var i=0 ; i < comboItems.length ; i++) {
					    		var comboItem=comboItems[i].split(FIELDMARK);
					    		comboObjects[5].SetItemCheck(i,1);
					    	}
							combo5.SetItemCheck(0, 1);//add
							break;					
						//1. CONTINENT LIST
						case SEARCH08:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[1].SetSelectCode("-1");//CONTINENT
								comboObjects[1].RemoveAll();
								addComboItem(comboObjects[1],comboItems);
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[2].SetSelectCode("-1");//COUNTRY
								comboObjects[2].RemoveAll();
								addComboItem(comboObjects[2],comboItems);	
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//3. REGION LIST
						case SEARCH01:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[3].SetSelectCode("-1");//REGION
								comboObjects[3].RemoveAll();
								addComboItem(comboObjects[3],comboItems);	
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//4. ALL_TARIFF_TYPE
						case SEARCH09:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							var comboItemsTariff=new Array();
							for (var i=0 ; i < comboItems.length ; i++) {
								var comboItem=comboItems[i].split(FIELDMARK);
								if(comboItem[0] == "All") {
									comboItemsTariff[0]=comboItems[i];
								}else if(comboItem[0] == "DMIF") {
									comboItemsTariff[1]=comboItems[i];
								}else if(comboItem[0] == "DMOF") {
									comboItemsTariff[2]=comboItems[i];
								}
							}
							addComboItem(sObj,comboItemsTariff);						
							for (var i=0 ; i < comboItemsTariff.length ; i++) {
					    		var comboItem=comboItemsTariff[i].split(FIELDMARK);
					    		sObj.SetItemCheck(i,1);
					    	}  		
							break;
						//5. Cntr & Cargo
						case SEARCH11:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							addComboItem2(sObj,comboItems);
							for (var i=0 ; i < comboItems.length ; i++) {
					    		var comboItem=comboItems[i].split(FIELDMARK);
					    		sObj.SetItemCheck(i,1);
					    	}  		
							break;						
						//6. Location, input Inquiry-- (loc_cd,rgn_cd,ste_cd,cnt_cd,conti_cd)
						case SEARCH10:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.name == "cvrg_location"  || sObj.name == "yd_cd1") {		//Coverage Location
								var location=ComGetObjValue(sObj);
								var regionData="";
								var regionCode="";
								//RGN 
								regionData=ComGetEtcData(sXml, REGION);
								if(regionData != undefined && regionData != "") {
									regionCode=regionData.split(FIELDMARK);
									if(regionCode != undefined && regionCode != "") {
										if(regionCode[0] == "CNS") {
											//yd_cd1 Setting
											ComSetObjValue(formObj.yd_cd1, location);		
											isNoChangeActive=false;
											checkYard1_sub2(formObj.yd_cd1);				
											ComSetFocus(formObj.yd_cd1);
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
							}else{
								var location=ComGetObjValue(sObj);
								clearLocation2();
								//Continent 
								comboDatas=ComGetEtcData(sXml, CONTINENT);
								if (comboDatas != undefined && comboDatas != "") {
									comboItems=comboDatas.split(ROWMARK);
									//Continent Setting
									setComboItem(comboObjects[1],comboItems);		//Continent
									//Country List 
									comboObjects[2].SetSelectCode("-1");
									comboObjects[2].RemoveAll();					//Country
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
									//Country Setting
									comboDatas=ComGetEtcData(sXml, COUNTRY);
									if (comboDatas != undefined && comboDatas != "") {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[2],comboItems);
										//Region/State List 
										comboObjects[3].SetSelectCode("-1");
										comboObjects[3].RemoveAll();				//Region
										doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
										if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
											comboDatas=ComGetEtcData(sXml, STATE);
						    			}else{
											comboDatas=ComGetEtcData(sXml, REGION);
						    			}
										if (comboDatas != undefined && comboDatas != "") {
											comboItems=comboDatas.split(ROWMARK);
											setComboItem(comboObjects[3],comboItems);	//Region
											//location setting
											ComSetObjValue(sObj, location);
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
							}
							break;
						//7. When finished entering Yard, Yard List Inquiry
						case SEARCH14:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							var yd_cd1=ComGetObjValue(sObj);
							ComSetObjValue(formObj.cvrg_location, yd_cd1);
							//Initialized to Empty Continent Combo
							comboObjects[0].SetSelectCode("-1");
							comboObjects[0].RemoveAll();
							//Select Country combo with the queried data
							comboDatas=ComGetEtcData(sXml, YARD);
							if (comboDatas == undefined ||comboDatas == "") {
								//ComShowCodeMessage("DMT06001");
								//ComSetObjValue(formObj.cvrg_location, "");
								//ComSetObjValue(formObj.yd_cd1, "");
							}else{
								comboItems=comboDatas.split(ROWMARK);
								addComboItem1(comboObjects[0],comboItems);	
								setComboItem(comboObjects[0],comboItems);
							}
							break;	
						//8.  Search CONTRY of Continent 
						case SEARCH06:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								if(comboDatas != "") {
									comboItems=comboDatas.split(ROWMARK);
									comboObjects[2].SetSelectCode("-1");
									comboObjects[2].RemoveAll();
									addComboItem(comboObjects[2],comboItems);	//Country
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//9.  search  Continent  of Country
						case SEARCH12:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[1],comboItems);	//Continent
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;		
						//10. Corresponding changes at Country Region Information Inquiry
						case SEARCH03:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							clearLocation2();
							if(comboObjects[2].GetSelectText()== "CA" || comboObjects[2].GetSelectText()== "US" ) {
								//State
								comboDatas=ComGetEtcData(sXml, STATE);
							}else{
	                                                                                                                                                                                        									//Region
								comboDatas=ComGetEtcData(sXml, REGION);
							}
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[3].SetSelectCode("-1");
								comboObjects[3].RemoveAll();				//Region
								addComboItem(comboObjects[3],comboItems);
							}else {
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;	
						//6. State, Region at the time of change, the corresponding Continet, Country, State Lookup
						case SEARCH17:
						case SEARCH13:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions 							
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							clearLocation2();
							//Select Country combo with the queried data
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined && comboDatas != "") {
								//Continent Setting
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[1],comboItems);		//Continent
								//Country List 
								comboObjects[2].SetSelectCode("-1");
								comboObjects[2].RemoveAll();
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined && comboDatas != "") {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[2],comboItems);	//Country
									//Region/State List 
									comboObjects[3].SetSelectCode("-1");
									comboObjects[3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									comboDatas=ComGetEtcData(sXml, sComboKey);
									if (comboDatas != undefined && comboDatas != "") {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[3],comboItems);	//Region
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
	/**
     * add data  combo field 
     */	
	function addComboItem(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
	/**
     * add data  combo field 
     */	
	function addComboItem2(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
    		comboObj.InsertItem(i, ComReplaceStr(comboItem[1],"^"," - ") , comboItem[0]);
    	}   		
	}
	/**
     * add data  combo field 
     */	
	function addComboItem1(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
    	}   		
	}
    /**
     *Click the Tab at the event-related
     * Elements selected tab is active.
     */
    function Minimize(nItem)
    {
        var objs=document.all.item("showMin");
        if ( nItem == "1" )
        {
    	    objs.style.display="none";
    	    sheetObjects[0].SetSheetHeight(474);
    	}
    	else
    	{
    	    objs.style.display="inline";
    	    sheetObjects[0].SetSheetHeight(330);
    	}
    }
	/*
	 * Searching fields to enter information of the screen is stored in a lookup field values??.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		//Coverage ComboSetting
		ComSetObjValue(formObj.cvrg_conti_cd, ComGetObjValue(formObj.cvrg_continent));
		ComSetObjValue(formObj.cvrg_cnt_cd, ComGetObjValue(formObj.cvrg_country));
		ComSetObjValue(formObj.cvrg_rgn_cd, ComGetObjValue(formObj.cvrg_region));
		ComSetObjValue(formObj.cvrg_loc_cd, ComGetObjValue(formObj.cvrg_location));
		ComSetObjValue(formObj.cvrg_yd_cd, comboObjects[0].GetSelectCode());
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.org_dest_conti_cd, comboObjects[1].GetSelectText());
		ComSetObjValue(formObj.org_dest_cnt_cd, comboObjects[2].GetSelectText());
		ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[3].GetSelectCode());
		ComSetObjValue(formObj.org_dest_loc_cd, ComGetObjValue(formObj.org_dest_location));
		//others
		ComSetObjValue(formObj.dmdt_trf_cd_list, comboObjects[4].GetSelectText());
		ComSetObjValue(formObj.dmdt_cntr_cgo_list, comboObjects[5].GetSelectCode());
		//Retrieve Setting
		//ComSetObjValue(formObj.f_cmd, sAction);//Command
	}
	/*
	 * Common code is Inquiry for Combo
	 */
	function setComboParameters(sComboAction, sObj) {
		var formObj=document.form;
		switch(sObj.options.id) {
			case "combo1":		//coverage yd_cd2
			case "cvrg_location":
			case "yd_cd1":
				//Coverage ComboSetting
				if(sObj.name == "cvrg_location") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));
				} else if(sObj.name == "yd_cd1") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.yd_cd1));
				}
				ComSetObjValue(formObj.yd_cd, comboObjects[0].GetSelectCode());
				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;
			case "combo2":	//orgin/dest continent
			case "combo3":	//orgin/dest country
			case "combo4":	//orgin/dest region/state
			case "org_dest_location":
				//Origin/Dest ComboSettion
				ComSetObjValue(formObj.conti_cd, comboObjects[1].GetSelectText());
				ComSetObjValue(formObj.cnt_cd, comboObjects[2].GetSelectText());
				ComSetObjValue(formObj.rgn_cd, comboObjects[3].GetSelectText());
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.org_dest_loction));
				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;	
			case "combo5":	//Tariff Type
			case "combo6":	//CNTR & Cargo Type
				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;
		}
	}
	//Multi Combo click event
	function combo5_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}
	//Multi Combo click event
	function combo6_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;		
	}
    /**
     * Select the first item
     */	
	function setComboItem(comboObj,comboItems) {
		var checkedItem=comboItems[0].split(FIELDMARK);
		comboObj.SetSelectText(checkedItem[0]);
	}	
	/*
	 * Initialize the query result information
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
	}
	/*
	 * Location Search Field initialization
	 */		
	function clearLocation1() {
		var formObj=document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
	}
	/*
	 * Location Search Field initialization
	 */		
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
	/**
	 * Yard Search Field initialization
	 * @return
	 */
	function clearYard() {
		var formObj=document.form;
		comboObjects[0].SetSelectCode("-1");
		comboObjects[0].RemoveAll();
		ComSetObjValue(formObj.yd_cd1, "");
		ComSetObjValue(formObj.cvrg_yd_cd, "");
		ComSetObjValue(formObj.yd_cd, "");
	}
	/*
	 *  initializing
	 */		
	function initSearchControls() {
		var formObj=document.form;
		comboObjects[0].RemoveAll();
		comboObjects[1].RemoveAll();
		comboObjects[2].RemoveAll();
		comboObjects[3].RemoveAll();
		comboObjects[4].RemoveAll();
		comboObjects[5].RemoveAll();
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
		Region2.innerHTML="Region";
	}		
	/*
	 * htmlControl event initializing
	 */	
	function initControl() {
		initSearchControls();
		//initResultControls();
	 	//IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    //DATA initializing
    	var formObj=document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST08,"","");    	
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[0]);		//5
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[1]);			//6
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[2]);			//7
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObjects[4]);	//8
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH11,CNTR_CARGE,comboObjects[5]);		//9
	}	
function t1901SpeedDownExcel () {
    sheetObjects[1].RemoveAll();
    doActionIBSheet( sheetObjects[1] , document.form , IBSEARCH );
//    sheetObjects[1].CellValue(1,"xcld_sat_flg") = sheetObjects[1].CellValue(2,"wknd1");
//    sheetObjects[1].CellValue(1,"xcld_sun_flg") = sheetObjects[1].CellValue(2,"wknd2");    
//    sheetObjects[1].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false,'','',false,'',true);
//parameter changed[check again]CLT     sheetObjects[1].Down2Excel({ HiddenColumn:-1});
}
