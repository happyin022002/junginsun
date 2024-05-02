/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0716.js
*@FileTitle  : BB Cargo Split 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
     */
    /**
     * @extends 
     * @class esm_bkg_0716 : esm_bkg_0716 business script.
     */
   	/* Developer Work	*/
// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var strSheetTitle=" |Cargo seq|Commodity|Length|Width|Height|Weight"; 
var chkCntrValidate="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName){
				case "btn_new":
					restoreCheck(sheetObjects[0],strSheetTitle,prefix1,prefix1+"bb_cgo_seq",ComGetObjValue(document.form.cntrPopExists));
					break;
				case "btn_save":
					callParentSplitFunc(sheetObjects[0],"B",prefix1+"bb_cgo_seq",prefix1+"bb_cgo_seq",ComGetObjValue(formObject.bkg_no),ComGetObjValue(formObject.bkgsplitno),ComGetObjValue(formObject.splitReason),strSheetTitle,ComGetObjValue(formObject.cntrPopExists));
					break;
				case "btn_close":
					ComClosePopup(); 
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
    function loadPage(){
    	
    	if(!opener) {
			opener=parent;
		}
		var openerFormObj = opener.document.form;
		document.form.splitCntrSplitNo.value = openerFormObj.bbCntrSplitNo.value;
		
	    if(ComGetObjValue(document.form.splitReason)=="C" && ComGetObjValue(document.form.bkg_no).length==12){
			strSheetTitle=" |Cargo seq|Commodity|Length|Width|Height|Weight|"+ComGetObjValue(document.form.bkg_no).substring(10,12);
		}else{
			strSheetTitle=" |Cargo seq|Commodity|Length|Width|Height|Weight|"+ComGetObjValue(document.form.orgSplit); 
		}
		strSheetTitle=SheetSetHeader(ComGetObjValue(document.form.splitReason),ComParseInt(document.form.lastSplitNo),ComGetObjValue(document.form.splitCnt),strSheetTitle);
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		sheetObjects[0].SetExtendLastCol(0);
		sheet1_OnLoadFinish(sheet1);
		ComFireEvent(ComGetObject("btn_new") ,"click");
    }
	/*
	* Sheet OnLoadFinish handling
	*/
 	function sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.SetWaitImageVisible(0);
		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
		sheetObj.SetWaitImageVisible(1);
		if(ComParseInt(document.form.splitCnt.value)>0){
			ComSetObjValue(document.form.cntrPopExists,"Y");
			setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"bb_cgo_seq");
			chkCntrValidate=CheckCntrSplit(document.form.validateSplitNo.value);
		}
	} 
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo){
        var cnt=0;
				var sheetID=sheetObj.id;
				switch(sheetID) {
					case "sheet1":
					    with(sheetObj){
				        
				      var HeadTitle1=strSheetTitle;
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 7, 0, true);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);

				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"bb_cgo_seq",                             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix1+"cmdt_nm",                                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
				             {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"dim_len",                                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"dim_wdt",                                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"dim_hgt",                                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"cgo_wgt",                                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix1+ComGetObjValue(document.form.orgSplit),   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				      
				      var tmpCols = SheetSetInitCol(sheetObj,ComGetObjValue(document.form.splitReason),ComGetObjValue(document.form.splitCnt),ComParseInt(document.form.lastSplitNo),cnt,prefix1);
				      cols = cols.concat(tmpCols);
				      
				      InitColumns(cols);

				      SetEditable(1);
				      //SheetSetInitCol(sheetObj,ComGetObjValue(document.form.splitReason),ComGetObjValue(document.form.splitCnt),ComParseInt(document.form.lastSplitNo),cnt,prefix1);
				      SetSheetHeight(202);  
					}


						break;
			}
	}
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		var arrPreFix=new Array("sheet1_");
        switch(sAction) {
          case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH; 
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0716GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
				sheetObj.RenderSheet(0);
//				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.RenderSheet(1);
            break;
        }
    }
    /*
	* Grid Onchange Event handling
	*/
	function sheet1_OnChange(sheetObj,Row,Col,Value){  
		 ComSetObjValue(document.form.cntrPopExists,"Y");
	} 
	/* Developer Work End */
