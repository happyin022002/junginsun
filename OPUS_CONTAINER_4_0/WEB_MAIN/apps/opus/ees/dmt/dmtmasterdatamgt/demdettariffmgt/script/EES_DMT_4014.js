/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4014.js
*@FileTitle  : P/F SKD Settlement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 	
     * @class EES_DMT_4014 :  business script for EES_DMT_4014
     */
	function EES_DMT_4014() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
		this.setComboObject=setComboObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
	}
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
    var COMMON_TARIFF_CD="common_tariff_cd"; 
	var ROWMARK="|";
	var FIELDMARK="=";
	var ORIGIN="Origin";
	var DESTINATION="Destination";
	var IBSAVE2=51;	
	var isNoChangeActive=false;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	var sheetObject3=sheetObjects[2];
    	var sheetObject4=sheetObjects[3];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcObj=ComGetEvent();//window.event.srcElement;
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					initControl();
					EnableControls();
					break;
				case "btn_Create":
					if(ComIsBtnEnable(srcName)) {
						openPopup(sheetObject1, formObject, srcName);
					}
					break;
 				case "btn_Update":
					if(ComIsBtnEnable(srcName)) {
						openPopup(sheetObject1, formObject, srcName);
					}
 					break;
 				case "btn_Confirm":
 					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
 					}
					break;
 				case "btn_Expire":
 					if(ComIsBtnEnable(srcName)) {
						openPopup(sheetObject1, formObject, srcName);
 					}
					break;
 				case "btn_ConfirmCancel":
 					if(ComIsBtnEnable(srcName)) {
 						//ConfirmCancel
 						doActionIBSheet(sheetObject1,formObject,IBSAVE2);
 					}
					break;
 				case "btn_Delete":
 					if(ComIsBtnEnable(srcName)) {
 						doActionIBSheet(sheetObject1,formObject,IBDELETE);
 					}
					break;
 				case "btn_Copy":
 					if(ComIsBtnEnable(srcName)) {
						openPopup(sheetObject1, formObject, srcName);
 					}
					break;
 				case "btn_Downexcel":
 					if(sheetObject1.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						t1901SpeedDownExcel();
 					}  				    
//					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
	    //Button initializing
	    initButton();
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
	    var formObj=document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST07,"","");
    }
    //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {    	
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST,COMMON_TARIFF_CD,comboObjects[0]);	//Tariff Type
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[2]);			//Orgin Continent
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[3]);				//Orgin Country
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[4]);				//Orgin Region
//    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
				with(sheetObj){
					var HeadTitle="|trf_grp_seq|Group Name|Effective Date|Expiration Date|User Office|CNTR Type|Cargo Type|rgn_cfm_flg|grp_cfm_flg|trf_seq|svr_id|xcld_sat_flg|xcld_sun_flg|xcld_hol_flg|dmdt_chg_cmnc_tp_nm|cmnc_hr|curr_cd|eff_day|dmdt_trf_cd";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_grp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_bzc_trf_grp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"user_office",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cntr_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"dmdt_cgo_tp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cfm_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_cfm_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"trf_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xcld_sat_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xcld_sun_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xcld_hol_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_chg_cmnc_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cmnc_hr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eff_day",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(222);
					SetEditable(1);
					SetDataAutoTrim(0);
				}
                break;
            case 2:      // sheet3 init
				with(sheetObj){
					var HeadTitle="|CNTR Q'ty|CNTR Q'ty|Free Day";
					var HeadTitle2="|From|Up To|Free Day";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ft_fm_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ft_to_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 } ];
					   
					InitColumns(cols);
					SetSheetHeight(150);
					SetEditable(1);
				}
                break;
            case 3:      // sheet4 init
				with(sheetObj){
					var HeadTitle="|Over Day|Over Day|Rate Per Day|Rate Per Day|Rate Per Day|Rate Per Day";
					var HeadTitle2="|From|Up To|20 FT|40 FT|H/C|45 FT";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ft_und_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"cntr_20ft_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:22 },
					 {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"cntr_40ft_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:22 },
					 {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"cntr_hc_rt_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:22 },
					 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_45ft_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:22 } ];
					   
					InitColumns(cols);
					SetSheetHeight(150);
					SetEditable(1);
				}
                break;
            case 4:      // sheet4 init
				with(sheetObj){
					var HeadTitle1="|Tariff\nType|Coverage|ORG/\nDest.|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T Exclusion|F/T Exclusion|F/T Exclusion|Free Time|Free Time|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|expire_chk|wknd1|wknd2";
					var HeadTitle2="|Tariff\nType|Coverage|ORG/\nDest.|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|Sat|Sun|H/day|CNTR\nQ'ty|Free Day|Cur.|Over Day|20FT|40FT|H/C|45FT|expire_chk|wknd1|wknd2";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, FrozenCol:SaveNameCol("eff_dt"), MergeSheet:7, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
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
					SetSheetHeight(302);
					SetEditable(1);
					FrozenCols=SaveNameCol("eff_dt");
				}
                break;
        }
    }
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			// search
			case IBSEARCH:
				//1.Inquiry ago, the parameter is set to a value type or allows selected.
				if (sheetObj.id == "sheet1") {
					if(ComGetObjValue(formObj.combo5) == "") {
						ComSetObjValue(formObj.yd_cd1, "");
					}
					ComSetObjValue(formObj.f_cmd, SEARCH);
					setParameters(SEARCH);
					//ComSetObjValue(formObj.cnt_cd, comboObjects[2].Text);
					if (validateForm(sheetObj,formObj,sAction)) {
						initResultControls();
						initResultText();						
                        //ComOpenWait Start
                        sheetObj.SetWaitImageVisible(0);
                        ComOpenWait(true);
                        var sXml=sheetObj.GetSearchData("EES_DMT_4014GS.do", FormQueryString(formObj));
						sheetObj.LoadSearchData(sXml,{Sync:1} );
                        //ComOpenWait End
                        ComOpenWait(false);
						wknd1.innerHTML=ComGetEtcData(sXml, "WKND1");
						wknd2.innerHTML=ComGetEtcData(sXml, "WKND2");
						ComSetObjValue(formObj.wknd1, ComGetEtcData(sXml, "WKND1"));
						ComSetObjValue(formObj.wknd2, ComGetEtcData(sXml, "WKND2"));
						//sheet2, sheet3  auto
						sheetObj.SelectCell(1,1);
						sheet1_OnClick(sheetObj, 1, 1, "");
                        DisableControls();
					}
				}else if(sheetObj.id == "sheet2") {
					ComSetObjValue(formObj.f_cmd, SEARCH01);
					setParameters(SEARCH01);
                    //ComOpenWait Start
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    sheetObj.DoSearch("EES_DMT_4014GS.do", FormQueryString(formObj) );
                    //ComOpenWait End
                    ComOpenWait(false);
					sheetObj.SetCellValue(sheetObj.LastRow(), "ft_to_qty","");
				} else if(sheetObj.id == "sheet3") {
					ComSetObjValue(formObj.f_cmd, SEARCH02);
					setParameters(SEARCH02);
					//ComOpenWait Start
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    sheetObj.DoSearch("EES_DMT_4014GS.do", FormQueryString(formObj) );
                    //ComOpenWait End
                    ComOpenWait(false);
					sheetObj.SetCellValue(sheetObj.LastRow(), "ft_und_dys","");
                } else if (sheetObj.id == "sheet4") {
                    ComSetObjValue(formObj.f_cmd, SEARCH04 ); 
					//ComOpenWait Start
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    //2.Inquiry as a query is run conditions
                    sheetObj.DoSearch("EES_DMT_4014GS.do", FormQueryString(formObj) );
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
				break;
			//Confirm
			case IBSAVE:
				ComSetObjValue(formObj.f_cmd, MODIFY );
				setParameters(MODIFY);
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				if(ComShowCodeConfirm('DMT00122')) {
 	 				//Initialization
 	 				for(var i=1; i< sheetObj.GetTotalRows()+1; i++) {
 						sheetObj.SetRowStatus(i,"R");
 					}
 	 				for(var i=1; i< sheetObj.GetTotalRows()+1; i++) {
 						sheetObj.SetRowStatus(i,"U");
 					}
					//ComOpenWait Start
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
 					//Confirm 
 					sheetObj.DoSave("EES_DMT_4014GS.do", FormQueryString(formObj), -1, false);
                    //ComOpenWait End
                    ComOpenWait(false);
 	 				doActionIBSheet(sheetObj,formObj,IBSEARCH);
 				}
				break;
			//Confirm Cancel
			case IBSAVE2:
				ComSetObjValue(formObj.f_cmd, MODIFY01 );
				setParameters(MODIFY01);
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				if(ComShowCodeConfirm('DMT01137')) {
	 				//Initialization
	 				for(var i=1; i< sheetObj.GetTotalRows()+1; i++) {
						sheetObj.SetRowStatus(i,"R");
					}
	 				for(var i=1; i< sheetObj.GetTotalRows()+1; i++) {
						sheetObj.SetRowStatus(i,"U");
					}
					//Confirm Cancel
					sheetObj.DoSave("EES_DMT_4014GS.do", FormQueryString(formObj), -1, false);
	 				doActionIBSheet(sheetObj,formObj,IBSEARCH);
 				}
				break;
			//Delete
			case IBDELETE:
				ComSetObjValue(formObj.f_cmd, REMOVE );
				setParameters(REMOVE);
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				if(ComShowCodeConfirm('DMT01147')) {
 	 				//Initialization
 	 				for(var i=1; i< sheetObj.GetTotalRows()+1; i++) {
 						sheetObj.SetRowStatus(i,"R");
 					}
					var trf_seq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_seq");
					var grp_seq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_grp_seq");
                    sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"D");
//                    for(var i=1; i< sheetObj.TotalRows+1; i++) {
//                        sheetObj.RowStatus(i) = "D";
//                    }
 					//Confirm 
 					sheetObj.DoSave("EES_DMT_4014GS.do", FormQueryString(formObj), -1, false);
 	 				doActionIBSheet(sheetObj,formObj,IBSEARCH);
 				}
				break;
			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if (sheetObj.id == "sheet1") {
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				}
				break;
        }
    }
    /**
     * EES_DMT_1002, EES_DMT_1102 pop up
     * @param url
     * @param sheetObj
     * @param formObject
     * @param srcName	(btn_Create, btn_Update, btn_Expire, btn_Copy)
     * @return
     */
    function openPopup(sheetObj, formObj, srcName) {
    	if(srcName == "btn_Create") {
    		var exp_dt=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt");
    		var iCnt=0;
    		if(sheetObj.GetTotalRows()== 10) {
    			if(exp_dt == "") {
    				ComShowCodeMessage('DMT00116');//Pls expire the previous tariff first!
    				return;
    			}
			}
    		//exp_dt dup check
    		for(var i=1; i< sheetObj.GetTotalRows()+1 ; i++) {
    			if(exp_dt != sheetObj.GetCellValue(i, "exp_dt")) {
    				iCnt++;
    			}
    		}
    		if(iCnt > 0) {
    			ComShowCodeMessage('DMT00117');//Expiration Date different! Pls create tariff group separately!
    			return;
    		}
			//parameter
			var cvrg_rgn_cd="";
			var cvrg_ste_cd="";
			var org_dest_rgn_cd="";
			var org_dest_ste_cd="";
			if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
				cvrg_rgn_cd="";
				cvrg_ste_cd=ComGetObjValue(formObj.cvrg_rgn_cd);
			}else {
				cvrg_rgn_cd=ComGetObjValue(formObj.cvrg_rgn_cd);
				cvrg_ste_cd="";
			}
//			if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
//				org_dest_rgn_cd	= "";
//				org_dest_ste_cd = ComGetObjValue(formObj.org_dest_rgn_cd);
//			}else {
//				org_dest_rgn_cd	= ComGetObjValue(formObj.org_dest_rgn_cd);
//				org_dest_ste_cd = "";
//			}
			var url="EES_DMT_1002.do"
						+"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
						+"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
						+"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
						+"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
						+"&cvrg_rgn_cd="+cvrg_rgn_cd
						+"&cvrg_ste_cd="+cvrg_ste_cd
						+"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
						+"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
						+"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
						+"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
						+"&org_dest_rgn_cd="+ComGetObjValue(formObj.org_dest_rgn_cd)
						+"&org_dest_ste_cd="+ComGetObjValue(formObj.org_dest_ste_cd)
						+"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
						+"&button_mode=C"
						+"&dmdt_bzc_trf_grp_nm="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_bzc_trf_grp_nm")
						+"&exp_dt="+ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt"))
						+"&wknd1="+ComGetObjValue(formObj.wknd1)
						+"&wknd2="+ComGetObjValue(formObj.wknd2)
						+"&svr_id="+ComGetObjValue(formObj.svr_id)
						+"&trf_seq="+ComGetObjValue(formObj.trf_seq)
						+"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
						+"&ui_code=4014";
			//ComOpenPopup(url, 926, 680,  'popupFinish', '1,0,1,1,1,1,1,1', false);
			var returnValue=ComOpenWindowCenter(url, "EES_DMT_1002", "926","760", true);
			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
    	}else if(srcName == "btn_Update") {
			var rowIndex=sheetObj.GetSelectRow();
			if(ComTrim(sheetObj.GetCellValue(rowIndex, "grp_cfm_flg")) == "Y") {
				ComShowCodeMessage('DMT00118');//Already confirmed!'
				return;
			}    		
			//exp_dt 
			var exp_dt="";
			var exp_dt_check=false;
			var isFirst=false;
			for(var i=1; i< sheetObj.GetTotalRows()+1 ; i++) {
				if(ComTrim(sheetObj.GetCellValue(i, "exp_dt")) == "") {
					continue;
				}
				if(!isFirst) {
					isFirst=true;
					exp_dt=ComTrim(sheetObj.GetCellValue(i, "exp_dt"));
					continue;
				}
				//check exp_dt
				if(ComTrim(sheetObj.GetCellValue(i, "exp_dt")) != exp_dt) {
					exp_dt_check=true;
					break;
				}
				exp_dt=ComTrim(sheetObj.GetCellValue(i, "exp_dt"));
			}
			if(exp_dt_check) {
				ComShowCodeMessage('DMT00127');//Expiration Date different! Pls create tariff group separately!
				return;
			}
			//parameter
			var cvrg_rgn_cd="";
			var cvrg_ste_cd="";
			var org_dest_rgn_cd="";
			var org_dest_ste_cd="";
			if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
				cvrg_rgn_cd="";
				cvrg_ste_cd=ComGetObjValue(formObj.cvrg_rgn_cd);
			}else {
				cvrg_rgn_cd=ComGetObjValue(formObj.cvrg_rgn_cd);
				cvrg_ste_cd="";
			}
			if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
				org_dest_rgn_cd="";
				org_dest_ste_cd=ComGetObjValue(formObj.org_dest_rgn_cd);
			}else {
				org_dest_rgn_cd=ComGetObjValue(formObj.org_dest_rgn_cd);
				org_dest_ste_cd="";
			}
			var url="EES_DMT_1002.do"
				+"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
				+"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
				+"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
				+"&cvrg_rgn_cd="+cvrg_rgn_cd
				+"&cvrg_ste_cd="+cvrg_ste_cd
				+"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
				+"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
				+"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
				+"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
				+"&org_dest_rgn_cd="+org_dest_rgn_cd
				+"&org_dest_ste_cd="+org_dest_ste_cd
				+"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
				+"&button_mode=U"
				+"&exp_dt="+ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt"))
				+"&wknd1="+ComGetObjValue(formObj.wknd1)
				+"&wknd2="+ComGetObjValue(formObj.wknd2)
				+"&svr_id="+ComGetObjValue(formObj.svr_id)
				+"&trf_seq="+ComGetObjValue(formObj.trf_seq)
				+"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
				+"&ui_code=4014";
			//ComOpenPopup(url, 926, 680,  'popupFinish', '1,0,1,1,1,1,1,1', false);
			var returnValue=ComOpenWindowCenter(url, "EES_DMT_1002", "926","800", true);
			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
    	}else if(srcName == "btn_Expire") {
    		var rowIndex=sheetObj.GetSelectRow();
    		if(ComTrim(sheetObj.GetCellValue(rowIndex, "exp_dt")) != "") {
				//ComShowCodeMessage('DMT00118');//Already confirmed!'
    			alert("Expire Completed!");
				return;
			}
			//parameter
			var cvrg_rgn_cd="";
			var cvrg_ste_cd="";
			var org_dest_rgn_cd="";
			var org_dest_ste_cd="";
			if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
				cvrg_rgn_cd="";
				cvrg_ste_cd=ComGetObjValue(formObj.cvrg_rgn_cd);
			}else {
				cvrg_rgn_cd=ComGetObjValue(formObj.cvrg_rgn_cd);
				cvrg_ste_cd="";
			}
			if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
				org_dest_rgn_cd="";
				org_dest_ste_cd=ComGetObjValue(formObj.org_dest_rgn_cd);
			}else {
				org_dest_rgn_cd=ComGetObjValue(formObj.org_dest_rgn_cd);
				org_dest_ste_cd="";
			}
			var url="EES_DMT_1002.do"
				+"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
				+"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
				+"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
				+"&cvrg_rgn_cd="+cvrg_rgn_cd
				+"&cvrg_ste_cd="+cvrg_ste_cd
				+"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
				+"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
				+"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
				+"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
				+"&org_dest_rgn_cd="+org_dest_rgn_cd
				+"&org_dest_ste_cd="+org_dest_ste_cd
				+"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
				+"&button_mode=E"
				+"&exp_dt="+ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt"))
				+"&wknd1="+ComGetObjValue(formObj.wknd1)
				+"&wknd2="+ComGetObjValue(formObj.wknd2)
				+"&svr_id="+ComGetObjValue(formObj.svr_id)
				+"&trf_seq="+ComGetObjValue(formObj.trf_seq)
				+"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
				+"&ui_code=4014";
			//ComOpenPopup(url, 926, 680,  'popupFinish', '1,0,1,1,1,1,1,1', false);
			var returnValue=ComOpenWindowCenter(url, "EES_DMT_1002", "926","800", true);
			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
    	}else if(srcName == "btn_Copy") {
    		//parameter
			var cvrg_rgn_cd="";
			var cvrg_ste_cd="";
			var org_dest_rgn_cd="";
			var org_dest_ste_cd="";
			if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
				cvrg_rgn_cd="";
				cvrg_ste_cd=ComGetObjValue(formObj.cvrg_rgn_cd);
			}else {
				cvrg_rgn_cd=ComGetObjValue(formObj.cvrg_rgn_cd);
				cvrg_ste_cd="";
			}
			if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
				org_dest_rgn_cd="";
				org_dest_ste_cd=ComGetObjValue(formObj.org_dest_rgn_cd);
			}else {
				org_dest_rgn_cd=ComGetObjValue(formObj.org_dest_rgn_cd);
				org_dest_ste_cd="";
			}
			var url="EES_DMT_1101.do"
				+"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
				+"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
				+"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
				+"&cvrg_rgn_cd="+cvrg_rgn_cd
				+"&cvrg_ste_cd="+cvrg_ste_cd
				+"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
				+"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
				+"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
				+"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
				+"&org_dest_rgn_cd="+org_dest_rgn_cd
				+"&org_dest_ste_cd="+org_dest_ste_cd
				+"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
				+"&svr_id="+ComGetObjValue(formObj.svr_id)
				+"&trf_seq="+ComGetObjValue(formObj.trf_seq)
				+"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
				+"&ui_code=4014";
			//ComOpenPopup(url, 921, 328,  'popupFinish', '1,0,1,1,1,1,1,1', false);
			var returnValue=ComOpenWindowCenter(url, "EES_DMT_1101", "921","350", true);
			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
    	}
    }
	function initAxonControl() { 
		axon_event.addListenerFormat('blur',	'obj_blur',		form); // out of focus
		//axon_event.addListenerFormat('keypress',		'obj_keypress',    form); // Keyboard input
		//axon_event.addListener('keydown', 'obj_keydown',  'cvrg_location', 'yd_cd1', 'org_dest_location');	
	}
	/*
	 * Location field, enter the letters converted to upper case
	 */		
	function obj_keypress(){ 
	    obj=ComGetEvent();
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
		obj=ComGetEvent();
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
    	var msg="";
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      // Retrieve
		        	//Coverage Continent Valid check
		        	if(ComTrim(ComGetObjValue(formObj.dmdt_trf_cd)) == "") {
		        		ComAlertFocus(formObj.combo1, ComGetMsg('COM12113', "Tariff Type"));
		        		return false;
		        	}
		        	//Coverage Continent Valid check
		        	if(ComTrim(ComGetObjValue(formObj.cvrg_conti_cd)) == "") {
		        		ComAlertFocus(formObj.combo2, ComGetMsg('COM12113', "Coverage Continent"));
		        		return false;
		        	}
		        	//Coverage Country Valid check
		        	if(ComTrim(ComGetObjValue(formObj.cvrg_cnt_cd)) == "") {
		        		ComAlertFocus(formObj.combo3, ComGetMsg('COM12113', "Coverage Country"));
		        		return false;
		        	}
//		        	if(ComGetObjValue(formObj.dmdt_trf_cd) == "DMOF" || ComGetObjValue(formObj.dmdt_trf_cd) == "DTOC" || 
//		        		ComGetObjValue(formObj.dmdt_trf_cd) == "CTOC") {
		        	if(ComGetObjValue(formObj.dmdt_trf_cd) == "DMOF"){
		        		msg=DESTINATION;
//		        	} else if(ComGetObjValue(formObj.dmdt_trf_cd) == "DMIF" ||	ComGetObjValue(formObj.dmdt_trf_cd) == "DTIC" || 
//		        		ComGetObjValue(formObj.dmdt_trf_cd) == "CTIC") {
		        	} else if(ComGetObjValue(formObj.dmdt_trf_cd) == "DMIF") {
		        		msg=ORIGIN;
		        	}
		        	//Orgin/Dest Continent Valid check
		        	if(ComTrim(ComGetObjValue(formObj.org_dest_conti_cd)) == "") {
		        		ComAlertFocus(formObj.combo6, ComGetMsg('COM12113', msg+" Continent"));
		        		return false;
		        	}
		        	break;
    			case IBSAVE:	//Confirm
    				var rowIndex=sheetObj.GetSelectRow();
    				//Confirm 
//    				if(ComTrim(sheetObj.CellValue(rowIndex, "grp_cfm_flg")) == "Y") {
//    					ComShowCodeMessage('DMT00118');
//    					return false;
//    				}
    				//
    				if(sheetObj.GetTotalRows()!= 10) {
    					ComShowCodeMessage("DMT00121");
    					return false;
    				}
    				var exp_dt_cnt=0;
    				for(var i=1; i< sheetObj.GetTotalRows()+1 ; i++) {
    					//exp_dt 
    					if(ComTrim(sheetObj.GetCellValue(i, "exp_dt")) != "") {
    						exp_dt_cnt++;
    					}
    				}
    				//Expiration Date
    				if(exp_dt_cnt > 0) {
    					ComShowCodeMessage('DMT00121');
    					return false;
    				}
    				break;    				
    			case IBSAVE2:	//Confirm Cancel
    				var rowIndex=sheetObj.GetSelectRow();
    				if(ComTrim(sheetObj.GetCellValue(rowIndex, "grp_cfm_flg")) == "N") {
    					ComShowCodeMessage('DMT00123');//Not in confirmed staus!
    					return false;
    				}
                    //eff_day check
                    for(var i=1 ; i < sheetObj.GetTotalRows()+1 ; i++ ) {
                    	if(ComTrim(sheetObj.GetCellValue(i, "eff_day")) < 0) {
                          ComShowCodeMessage('DMT00124');//Only for future tariff!
                          return false;
                      }
                    }
    				break;
    			case IBDELETE:	//Delete
    				var rowIndex=sheetObj.GetSelectRow();
    				if(ComTrim(sheetObj.GetCellValue(rowIndex, "grp_cfm_flg")) == "Y") {
    					ComShowCodeMessage('DMT00118');//Already confirmed!
    					return false;
    				}
    				break;
    		}
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
	    var formObj=document.form
	    switch(comboNo) { 
	    	//Tariff Type
	    	case 1:
	    		with (comboObj) {
					SetMultiSelect(0);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "55");
					SetColWidth(1, "330");
					SetDropHeight(160);
					ValidChar(2);
					SetMaxLength(4);
	    		}
	    		break;
		    //Coverage Yard
	    	case 2:
	    		with (comboObj) {
					SetMultiSelect(0);
					//UseAutoComplete = false;	
					SetColAlign(0, "left");
					SetColWidth(0, "50");
					SetDropHeight(160);	
					ValidChar(2,1);
					SetMaxLength(2);
	    		}
	    		comboObj.InsertItem(0, "", "");
	    		break;
	    	//Continent
	    	case 3: 
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
				break;
	    	//Country
	    	case 4:
	    		with (comboObj) {
	    			SetMultiSelect(0);
	    			UseAutoComplet=false;
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "200");
	    			SetDropHeight(160);
	    			ValidChar(2);
					SetMaxLength(2);
	    		}
	    		break;
	    	//Region
	    	case 5:
	    		with (comboObj) {
  					SetMultiSelect(0);
  					SetUseAutoComplete(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "40");
					SetColWidth(1, "200");
  					SetDropHeight(160);
  					ValidChar(2);
					SetMaxLength(3);
	    		}
	    		break;
	     }
	    //comboObj.SetMultiSelect(0);
	} 	
	/*
	 *Initialize button
	 */
	function initButton() {
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		ComBtnDisable("btn_Create");
		ComBtnDisable("btn_Update");
		ComBtnDisable("btn_Confirm");
		ComBtnDisable("btn_Expire");
		ComBtnDisable("btn_ConfirmCancel");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Copy");
		ComBtnEnable("btn_DownExcel");
	}
	/*
	 * Searching fields to enter information of the screen is stored in a lookup field values??.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		//Triff Type ComboSettion
		ComSetObjValue(formObj.dmdt_trf_cd, comboObjects[0].GetSelectText());
		//Coverage ComboSetting
		ComSetObjValue(formObj.cvrg_conti_cd, ComGetObjValue(formObj.cvrg_continent));
		ComSetObjValue(formObj.cvrg_cnt_cd, ComGetObjValue(formObj.cvrg_country));
		ComSetObjValue(formObj.cvrg_rgn_cd, ComGetObjValue(formObj.cvrg_region));
		ComSetObjValue(formObj.cvrg_loc_cd, ComGetObjValue(formObj.cvrg_location));
		ComSetObjValue(formObj.cvrg_yd_cd, comboObjects[1].GetSelectCode());
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.org_dest_conti_cd, comboObjects[2].GetSelectText());
		ComSetObjValue(formObj.org_dest_cnt_cd, comboObjects[3].GetSelectText());
		if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
			ComSetObjValue(formObj.org_dest_rgn_cd, "");
			ComSetObjValue(formObj.org_dest_ste_cd, comboObjects[4].GetSelectText());
		}else{
			ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[4].GetSelectText());
			ComSetObjValue(formObj.org_dest_ste_cd, "");
		}
		ComSetObjValue(formObj.org_dest_loc_cd, ComGetObjValue(formObj.org_dest_location));
		ComSetObjValue(formObj.trf_seq, sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "trf_seq"));
		ComSetObjValue(formObj.trf_grp_seq, sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "trf_grp_seq"));
		ComSetObjValue(formObj.svr_id, sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "svr_id"));
	}	
	//Tariff Type event
	function combo1_OnChange(comboObj, Index_Code, Text) {
		if(comboObj.GetSelectText().length < 4) {
			comboObj.SetSelectText("");
			ComSetFocus(comboObj);
			return;
		}
		var coIndex = comboObj.GetSelectIndex();
		var teIndex = comboObj.GetSelectText();
		search_combo1(comboObj, coIndex, teIndex);
	}
	function search_combo1(comboObj, searchIndex, searchText) {
		var formObj=document.form;
		if (comboObj.GetSelectText().length == 0 ){
			ComSetObjValue(formObj.dmdt_trf_nm, "");
			comboObj.SetSelectText("");
			ComSetFocus(comboObj);
			return;
		}
		ComSetObjValue(formObj.dmdt_trf_nm, comboObj.GetText(parseInt(searchIndex),1));	//To show the text column
		var tariffType=ComTrim(comboObj.GetText(parseInt(searchIndex), 0));
		if (tariffType == "DMOF" ) {
			OriginDest.innerHTML=DESTINATION;
		}
		else if (tariffType == "DMIF" || tariffType == ""){
			OriginDest.innerHTML=ORIGIN;
		}
	}
	function combo1_OnBlur(comboObj) {
		var formObj=document.form;
		var sIndexCode=comboObj.GetSelectIndex();
		var sText=comboObj.GetSelectText();
		if(sIndexCode == -1) {
			comboObj.SetSelectText("");
			ComSetObjValue(formObj.dmdt_trf_nm, "");
		}
	}
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			//combo1_OnChange(comboObj, sIndexCode, sText);
			search_combo1(comboObj, sText, sText)
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
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
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH14,YARD,obj);
				isNoChangeActive=false;
			}
    	}
	}
	/*
	 * Yard Combo event
	 * Location that contains the Continent, Country and Region or State functions to query information
	 */		
	function combo2_OnChange(comboObj, Index_Code, Text) {
		search_combo2(comboObj, Index_Code, Text);
	}
	function search_combo2(comboObj, searchIndex, searchText) {
		if(comboObj.GetSelectText().length == 0 ) return;
		if(isNoChangeActive) return;
		if(searchIndex == undefined || searchIndex == ""){
			comboObj.SetSelectText("");
			return;
		}
	}
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo5(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/*
	 * Continent Combo event
	 * Country belonging to query information.
	 */		
	function combo3_OnChange(comboObj, Index_Code, Text) {
		search_combo3(comboObj, Index_Code, Text);
	}
	function search_combo3(comboObj, searchIndex, searchText) {
		if (comboObj.GetSelectText().length == 0 ) return;
		if (isNoChangeActive) return;
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);	//CountryListByContinent
		//Region initialization
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);		//SearchRegionList
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
	 * Country Combo event
	 * Part of the Continent, Region or State functions that query information
	 */		
	function combo4_OnChange(comboObj, Index_Code, Text) {
		search_combo4(comboObj, Index_Code, Text);
	}
	function search_combo4(comboObj, searchIndex, searchText) {
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
	function combo4_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo4(comboObj, sIndexCode, sText);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	/*
	 * Region or State Combo event
	 * If a change occurs in Search Field, Location Search Field and initializing functions that
	 */	
	function combo5_OnChange(comboObj, Index_Code, Text) {
		search_combo5(comboObj, Index_Code, Text);
	}
	function search_combo5(comboObj, searchIndex, searchText) {
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
	function combo5_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode=comboObj.GetSelectIndex();
			var sText=comboObj.GetSelectText();
			search_combo5(comboObj, sIndexCode, sText);
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
	//Sheet1 event
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		//if(sheetObj.SelectCol == 1) {
			var formObj=document.form;
			var sat_check=false;
			var sun_check=false;
			var hol_check=false;
			if(ComTrim(sheetObj.GetCellValue(Row, "xcld_sat_flg")) == "Y") {
				sat_check=true;
			}
			if(ComTrim(sheetObj.GetCellValue(Row, "xcld_sun_flg")) == "Y") {
				sun_check=true;
			}
			if(ComTrim(sheetObj.GetCellValue(Row, "xcld_hol_flg")) == "Y") {
				hol_check=true;
			}
			//F/Time Exclusion 
			doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);		
			ComSetObjValue(formObj.xcld_sat_flg, sat_check);
			ComSetObjValue(formObj.xcld_sun_flg, sun_check);
			ComSetObjValue(formObj.xcld_hol_flg, hol_check);
			ComSetObjValue(formObj.dmdt_chg_cmnc_tp_nm, ComTrim(sheetObj.GetCellValue(Row, "dmdt_chg_cmnc_tp_nm")));
			ComSetObjValue(formObj.cmnc_hr, ComTrim(sheetObj.GetCellValue(Row, "cmnc_hr")));
			ComSetObjValue(formObj.curr_cd, ComTrim(sheetObj.GetCellValue(Row, "curr_cd")));
			//F/Time Commence 
			doActionIBSheet(sheetObjects[2],formObj,IBSEARCH);
		//}
    }
	/**
	 * sheet1 Inquiry, and then set the button
	 */
	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
		var formObj=document.form;
		// Confirmed input box Setting
		ComSetObjValue(formObj.confirm_yn, ComTrim(sheetObj.GetCellValue(1, "rgn_cfm_flg")));	//region confirm
		//setting button
		var temp_cnt=0;
		var temp_cnt2=0;
		//Confirm status
		var confirm_st=ComGetObjValue(formObj.confirm_yn);
		//Tariff Group Status Y check
		var cnt_grp_confirm=0;
		for(var i=1; i < sheetObj.GetTotalRows()+1; i++) {
			//exp_dt is not exist
			if(ComTrim(sheetObj.GetCellValue(i, "exp_dt")) == "") {
				temp_cnt++;
			}
			//eff_dt check
			if(ComTrim(sheetObj.GetCellValue(i, "eff_day")) > 0) {
				temp_cnt2++;
			}
			//Tariff group confirm status
			if(ComTrim(sheetObj.GetCellValue(i, "grp_cfm_flg")) == "Y") {
				cnt_grp_confirm++;
			}
		}				
		//if(sheetObj.TotalRows == 10 && temp_cnt == 10 ) {
		if(sheetObj.GetTotalRows()== 10) {
			ComBtnDisable("btn_Create");
		} else {
			ComBtnEnable("btn_Create");
		}
		//2.Update
		if(confirm_st == "Y") {
			ComBtnDisable("btn_Update");
		}else if(confirm_st == "N"){
			ComBtnEnable("btn_Update");
		}else {
			ComBtnDisable("btn_Update");
		}
		//3.Confirm
		if(confirm_st == "Y") {
			ComBtnDisable("btn_Confirm");
		//}else if(confirm_st == "N" && sheetObj.TotalRows == 10){
		//	ComBtnEnable("btn_Confirm");
		}else if(confirm_st == "N") {
			ComBtnEnable("btn_Confirm");
		}else {
			ComBtnDisable("btn_Confirm");
		}
		//if(confirm_st == "Y" && temp_cnt == 10) {
//		if(cnt_grp_confirm == 10) {
//			if(temp_cnt == 0) {
//				ComBtnDisable("btn_Expire");
//			}else{
//				ComBtnEnable("btn_Expire");
//			}
//		}else{
//			ComBtnDisable("btn_Expire");
//		}
		if(cnt_grp_confirm > 0) {
			ComBtnEnable("btn_Expire");
		}else {
			ComBtnDisable("btn_Expire");
		}
		//5.Confirm Cancel
		if(confirm_st == "N") {
			ComBtnDisable("btn_ConfirmCancel");
		}else if(confirm_st == "Y"  && sheetObj.GetTotalRows()== 10){
			ComBtnEnable("btn_ConfirmCancel");
		}else {
			ComBtnDisable("btn_ConfirmCancel");
		}
		//6.Delete
        if(confirm_st == "Y") {
            ComBtnDisable("btn_Delete");
        }else if(confirm_st == "N") {
        	ComBtnEnable("btn_Delete");
//if(cnt_grp_confirm > 0 ) {
//                ComBtnDisable("btn_Delete");
//            }else if(sheetObj.TotalRows > 0){
//                ComBtnEnable("btn_Delete");
//            }
        }else {
            ComBtnDisable("btn_Delete");
        }
		//7.Copy
		if(sheetObj.GetTotalRows()== 10 && temp_cnt == 10) {
			ComBtnEnable("btn_Copy");
		}else{
			ComBtnDisable("btn_Copy");
		}
	}
	/**
     * Select the first item
     */	
	function setComboItem(comboObj,comboItems) {
		var checkedItem=comboItems[0].split(FIELDMARK);
		comboObj.SetSelectText(checkedItem[0]);
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
                		case SEARCHLIST07:
	                        //1.Inquiry ago, the parameter is set to a value type or allows selected.
	                		ComSetObjValue(formObj.f_cmd, SEARCHLIST07); 
	                        //2.Inquiry as a query is run conditions                 
	                		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
	                		//TARIFF LIST
	                		comboItems=ComGetEtcData(sXml, COMMON_TARIFF_CD).split(ROWMARK);	
	                		var comboItemsTariff=new Array();
							for (var i=0 ; i < comboItems.length ; i++) {
								var comboItem=comboItems[i].split(FIELDMARK);
								if(comboItem[0] == "DMIF") {
									comboItemsTariff[0]=comboItems[i];
								}else if(comboItem[0] == "DMOF") {
									comboItemsTariff[1]=comboItems[i];
								}
							}
							addComboItem(comboObjects[0],comboItemsTariff);
							//Coverage Continent
	                		comboDatas=ComGetEtcData(sXml, CONTINENT);
	                		if (comboDatas != undefined) {
	                            comboItems=comboDatas.split(ROWMARK);
	                            //Change the selection to a usable state
	                            comboObjects[2].SetSelectCode("-1");
	                            comboObjects[2].RemoveAll();
	                            addComboItem(comboObjects[2],comboItems);
	                        }
	                		//Coverage Country 
	                		comboDatas=ComGetEtcData(sXml, COUNTRY);
	                        if (comboDatas != undefined) {
	                            comboItems=comboDatas.split(ROWMARK);
	                            comboObjects[3].SetSelectCode("-1");
	                            comboObjects[3].RemoveAll();
	                            addComboItem(comboObjects[3],comboItems); //COUNTRY
	                        }
	                        //Coverage Region
	                        comboDatas=ComGetEtcData(sXml, REGION);
	                        if (comboDatas != undefined) {
	                            comboItems=comboDatas.split(ROWMARK);
	                            comboObjects[4].SetSelectCode("-1");
	                            comboObjects[4].RemoveAll();
	                            addComboItem(comboObjects[4],comboItems); //Region
	                        }
	                		break;					
						//1. TARIFF LIST
						case SEARCHLIST:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST); 
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							var comboItemsTariff=new Array();
							for (var i=0 ; i < comboItems.length ; i++) {
								var comboItem=comboItems[i].split(FIELDMARK);
								if(comboItem[0] == "DMIF") {
									comboItemsTariff[0]=comboItems[i];
								}else if(comboItem[0] == "DMOF") {
									comboItemsTariff[1]=comboItems[i];
								}
							}
							addComboItem(sObj,comboItemsTariff);						
							break;							
						//2. CONTINENT LIST
						case SEARCH08:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH08);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems=comboDatas.split(ROWMARK);
								//Change the selection to a usable state
								comboObjects[2].SetSelectCode("-1");
								comboObjects[2].RemoveAll();
								addComboItem(comboObjects[2],comboItems);	//CONTINENT
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH02);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems=comboDatas.split(ROWMARK);
								//Change the selection to a usable state
								comboObjects[3].SetSelectCode("-1");
								comboObjects[3].RemoveAll();
								addComboItem(comboObjects[3],comboItems);	//COUNTRY
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//3. REGION LIST
						case SEARCH01:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH01);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems=comboDatas.split(ROWMARK);
								//Change the selection to a usable state
								comboObjects[4].SetSelectCode("-1");
								comboObjects[4].RemoveAll();
								addComboItem(comboObjects[4],comboItems);	//REGION
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//4. Location, input Inquiry-- (loc_cd,rgn_cd,ste_cd,cnt_cd,conti_cd)
						case SEARCH10:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH10);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							if(sObj.name == "cvrg_location" || sObj.name == "yd_cd1") {
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
									setComboItem(comboObjects[2],comboItems);		//Continent
									//Country List 
									comboObjects[3].SetSelectCode("-1");
									comboObjects[3].RemoveAll();					//Country
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
									//Country Setting
									comboDatas=ComGetEtcData(sXml, COUNTRY);
									if (comboDatas != undefined && comboDatas != "") {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[3],comboItems);
										//Region/State List 
										comboObjects[4].SetSelectCode("-1");
										comboObjects[4].RemoveAll();				//Region
										doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
										if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
											comboDatas=ComGetEtcData(sXml, STATE);
						    			}else{
											comboDatas=ComGetEtcData(sXml, REGION);
						    			}
										if (comboDatas != undefined && comboDatas != "") {
											comboItems=comboDatas.split(ROWMARK);
											setComboItem(comboObjects[4],comboItems);	//Region
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
						//4.  Search CONTRY of Continent 
						case SEARCH06:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH06);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								if(comboDatas != "") {
									comboItems=comboDatas.split(ROWMARK);
									comboObjects[3].SetSelectCode("-1");
									comboObjects[3].RemoveAll();
									addComboItem(comboObjects[3],comboItems);	//Country
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//5.  search  Continent  of Country
						case SEARCH12:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH12);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[2],comboItems);	//Continent
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//5. Corresponding changes at Country Region Information Inquiry
						case SEARCH03:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH03);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							clearLocation2();
							if(comboObjects[3].GetSelectText()== "CA" || comboObjects[3].GetSelectText()== "US" ) {
								//State
								comboDatas=ComGetEtcData(sXml, STATE);
							}else{
								comboDatas=ComGetEtcData(sXml, REGION);
							}
							if (comboDatas != undefined) {
								comboItems=comboDatas.split(ROWMARK);
								comboObjects[4].SetSelectCode("-1");
								comboObjects[4].RemoveAll();				//Region
								addComboItem(comboObjects[4],comboItems);
							}else {
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//6. State, Region at the time of change, the corresponding Continet, Country, State Lookup
						case SEARCH17:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH17);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							clearLocation2();
							//Select Country combo with the queried data
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined && comboDatas != "") {
								//Continent Setting
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[2],comboItems);		//Continent
								//Country List 
								comboObjects[3].SetSelectCode("-1");
								comboObjects[3].RemoveAll();
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined && comboDatas != "") {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[3],comboItems);	//Country
									//Region/State List 
									comboObjects[4].SetSelectCode("-1");
									comboObjects[4].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									comboDatas=ComGetEtcData(sXml, sComboKey);
									if (comboDatas != undefined && comboDatas != "") {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[4],comboItems);	//Region
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
						case SEARCH13:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH13);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							clearLocation2();
							//Select Country combo with the queried data
							comboDatas=ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined && comboDatas != "") {
								//Continent Setting
								comboItems=comboDatas.split(ROWMARK);
								setComboItem(comboObjects[2],comboItems);		//Continent
								//Country List 
								comboObjects[3].SetSelectCode("-1");
								comboObjects[3].RemoveAll();
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								//Country Setting
								comboDatas=ComGetEtcData(sXml, COUNTRY);
								if (comboDatas != undefined && comboDatas != "") {
									comboItems=comboDatas.split(ROWMARK);
									setComboItem(comboObjects[3],comboItems);	//Country
									//Region/State List 
									comboObjects[4].SetSelectCode("-1");
									comboObjects[4].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
									comboDatas=ComGetEtcData(sXml, sComboKey);
									if (comboDatas != undefined && comboDatas != "") {
										comboItems=comboDatas.split(ROWMARK);
										setComboItem(comboObjects[4],comboItems);	//Region
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
						case SEARCH14:
							//1.Inquiry ago, the parameter is set to a value type or allows selected.
							ComSetObjValue(formObj.f_cmd, SEARCH14);
							setComboParameters(sComboAction, sObj);
							//2.Inquiry as a query is run conditions					
							var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
							var yd_cd1=ComGetObjValue(sObj);
							ComSetObjValue(formObj.cvrg_location, yd_cd1);
							//Initialized to Empty Continent Combo
							comboObjects[1].SetSelectCode("-1");
							comboObjects[1].RemoveAll();
							//Select Country combo with the queried data
							comboDatas=ComGetEtcData(sXml, YARD);
							if (comboDatas == undefined ||comboDatas == "") {
								//ComShowCodeMessage("DMT06001");
								//ComSetObjValue(formObj.cvrg_location, "");
								//ComSetObjValue(formObj.yd_cd1, "");
							}else{
								comboItems=comboDatas.split(ROWMARK);
								addComboItem1(comboObjects[1],comboItems);	
								setComboItem(comboObjects[1],comboItems);
							}
							break;
//						case COMMAND03:
//							index_1 = 1;
//							index_2 = 2;
//							index_3 = 3;
//							
//							
//							//Continent 
//							comboDatas = ComGetEtcData(sXml, CONTINENT);
//
//							if (comboDatas != undefined && comboDatas != "") {
//								//Continent Setting
//								comboItems = comboDatas.split(ROWMARK);
//								setComboItem(comboObjects[index_1],comboItems);
//								//Country List 
//								comboObjects[index_2].Code = "-1";
//								comboObjects[index_2].RemoveAll();		
//								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
//								
//								//Country Setting
//								comboDatas = ComGetEtcData(sXml, COUNTRY);
//
//								if (comboDatas != undefined && comboDatas != "") {
//									comboItems = comboDatas.split(ROWMARK);
//									setComboItem(comboObjects[index_2],comboItems);
//									
//									//Region/State List 
//									comboObjects[index_3].Code = "-1";
//									comboObjects[index_3].RemoveAll();
//									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
//
//									//Region/State Setting
//									if(comboObjects[index_2].Text == "CA" || comboObjects[index_2].Text == "US" ) {
//										comboDatas = ComGetEtcData(sXml, STATE);
//									}else{
//										comboDatas = ComGetEtcData(sXml, REGION);
//									}
//									
//									if (comboDatas != undefined && comboDatas != "") {
//										comboItems = comboDatas.split(ROWMARK);
//										setComboItem(comboObjects[index_3],comboItems);
//										
//										//location setting
//										ComSetObjValue(formObj.cvrg_location, ComGetObjValue(formObj.yd_cd1));
//									}else{
//										ComShowCodeMessage("DMT06001");
//										clearObjectValue(sObj);
//									}
//								}else{
//									ComShowCodeMessage("DMT06001");
//									clearObjectValue(sObj);
//								}
//								
//							}else{
//								ComShowCodeMessage("DMT06001");
//								clearObjectValue(sObj);
//							}
//
//							break;								
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
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);		
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
	 * Yard Search Field initialization
	 * @return
	 */
	function clearYard() {
		var formObj=document.form;
		comboObjects[1].SetSelectCode("-1");
		comboObjects[1].RemoveAll();
		ComSetObjValue(formObj.yd_cd1, "");
		ComSetObjValue(formObj.cvrg_yd_cd, "");
		ComSetObjValue(formObj.yd_cd, "");
	}
	/*
	 * Common code is Inquiry for Combo
	 */
	function setComboParameters(sComboAction, sObj) {
		var formObj=document.form;
		switch(sObj.name) {
			case "combo2":
			case "cvrg_location":
			case "yd_cd1":
				//Coverage ComboSetting
				if(sObj.name == "cvrg_location") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));
				} else if(sObj.name == "yd_cd1") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.yd_cd1));
				}
				ComSetObjValue(formObj.yd_cd, comboObjects[1].GetSelectCode());
				break;						
			case "combo3":
			case "combo4":
			case "combo5":
			case "org_dest_location":
				//Origin/Dest ComboSettion
				ComSetObjValue(formObj.conti_cd, comboObjects[2].GetSelectText());
				ComSetObjValue(formObj.cnt_cd, comboObjects[3].GetSelectText());
				ComSetObjValue(formObj.rgn_cd, comboObjects[4].GetSelectText());
                ComSetObjValue(formObj.ste_cd, comboObjects[4].GetSelectText());
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.org_dest_location));
				break;	
		}
	}
	/*
	 *Query options are available
	 */
	function EnableControls() {
		var formObj=document.form;
		ComEnableObject(formObj.yd_cd1, true);
		ComEnableObject(formObj.cvrg_location, true);
		ComEnableObject(formObj.org_dest_location, true);
		formObj.yd_cd1.className="input";
		formObj.cvrg_location.className="input";
		formObj.org_dest_location.className="input";
		for(var i=0 ; i < comboObjects.length ; i++) {
			comboObjects[i].SetEnable(1);
		}
	}
	/*
	 * Query options are not available
	 */
	function DisableControls() {
		var formObj=document.form;
		ComEnableObject(formObj.yd_cd1, false);
		ComEnableObject(formObj.cvrg_location, false);
		ComEnableObject(formObj.org_dest_location, false);
		formObj.yd_cd1.className="input2";
		formObj.cvrg_location.className="input2";
		formObj.org_dest_location.className="input2";
		for(var i=0 ; i < comboObjects.length ; i++) {
			comboObjects[i].SetEnable(0);
		}
	}
	/*
	 *  initializing
	 */		
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
		ComSetObjValue(formObj.conti_cd, "");	
		ComSetObjValue(formObj.cnt_cd, "");		
		ComSetObjValue(formObj.rgn_cd, "");		
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.ste_cd, "");
		ComSetObjValue(formObj.yd_cd1, "");
		ComSetObjValue(formObj.yd_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
		ComSetObjValue(formObj.org_dest_location, "");
		ComSetObjValue(formObj.cvrg_conti_cd, "");
		ComSetObjValue(formObj.cvrg_cnt_cd, "");
		ComSetObjValue(formObj.cvrg_rgn_cd, "");
		ComSetObjValue(formObj.cvrg_ste_cd, "");
		ComSetObjValue(formObj.cvrg_loc_cd, "");
		ComSetObjValue(formObj.cvrg_yd_cd, "");
		ComSetObjValue(formObj.org_dest_conti_cd, "");
		ComSetObjValue(formObj.org_dest_cnt_cd, "");
		ComSetObjValue(formObj.org_dest_rgn_cd, "");
		ComSetObjValue(formObj.org_dest_ste_cd, "");
		ComSetObjValue(formObj.org_dest_loc_cd, "");
		ComSetObjValue(formObj.dmdt_trf_cd, "");
		ComSetObjValue(formObj.trf_seq, "");
		ComSetObjValue(formObj.trf_grp_seq, "");
		ComSetObjValue(formObj.dmdt_trf_nm, "");
		ComSetObjValue(formObj.confirm_yn, "");
		ComSetObjValue(formObj.wknd1, "SAT");
		ComSetObjValue(formObj.wknd2, "SUN");
		Region2.innerHTML="Region";
		OriginDest.innerHTML="Origin";
		OriginDest.innerHTML="Origin";
		OriginDest.innerHTML="Origin";
		wknd1.innerHTML="SAT";
		wknd2.innerHTML="SUN";
		initResultText();
	}	
	function initResultText() {
		var formObj=document.form;
		ComSetObjValue(formObj.xcld_sat_flg, "");
		ComSetObjValue(formObj.xcld_sun_flg, "");
		ComSetObjValue(formObj.xcld_hol_flg, "");
		ComSetObjValue(formObj.cmnc_hr, "");
		ComSetObjValue(formObj.dmdt_chg_cmnc_tp_nm, "");
		ComSetObjValue(formObj.curr_cd, "");
	}
	/*
	 * Initialize the query result information
	 */
	function initResultControls() {
//		sheetObjects[0].RemoveAll();
//		sheetObjects[1].RemoveAll();
//		sheetObjects[2].RemoveAll();
	}
	/*
	 * htmlControl event initializing
	 */	
	function initControl() {
		initSearchControls();
		initResultControls();
		//Sheet2, Sheet3 initializing
		//initResultText();
		//ComResetAll();
	 	//IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    //DATA initializing
    	var formObj=document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST07,"","");
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST,COMMON_TARIFF_CD,comboObjects[0]);	//tariff type
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[2]);			//orgin/dest continent
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[3]);				//orgin/dest country
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[4]);				//orgin/dest region
	    //Button initializing
	    initButton();
	}	
function t1901SpeedDownExcel () {
    //sheetObjects[3].RemoveAll();
    doActionIBSheet( sheetObjects[3] , document.form , IBSEARCH );
//    sheetObjects[1].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false,'','',false,'',true);
	sheetObjects[3].Down2Excel({ HiddenColumn:-1});
}