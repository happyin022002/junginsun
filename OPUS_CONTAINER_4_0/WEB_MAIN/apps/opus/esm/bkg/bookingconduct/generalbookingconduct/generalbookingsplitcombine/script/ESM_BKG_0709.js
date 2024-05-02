/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0709.js
*@FileTitle  : DG Split
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class esm_bkg_0709 : esm_bkg_0709 - task script definition for screen
     */
// public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_"; 
var strSheetTitle=" ||CNTR Seq. & No.|CNTR Seq. & No.|Cargo Seq.|UN No.|IMDG Class";
var chkCntrValidate="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
					case "btn_new": 
						if (ComGetObjValue(document.form.cntrExists)=="Y" && ComGetObjValue(document.form.cntrPopExists)=="N"){
							restoreCheck(sheetObject,strSheetTitle,prefix1,prefix1+"cntr_no",ComGetObjValue(document.form.cntrPopExists));
						}else{
							restoreCheck(sheetObject,strSheetTitle,prefix1,prefix1+"dcgo_seq",ComGetObjValue(document.form.cntrPopExists));
						}
                    break;    
					case "btn_save":  
						callParentSplitFunc(sheetObject,"D",prefix1+"cntr_no",prefix1+"dcgo_seq",ComGetObjValue(formObject.bkg_no),ComGetObjValue(formObject.bkgsplitno),ComGetObjValue(formObject.splitReason),strSheetTitle,ComGetObjValue(formObject.cntrPopExists));
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
    function loadPage() { 
    	if(!opener) {
			opener=parent;
		}
		var openerFormObj = opener.document.form;
		document.form.splitCntrSplitNo.value = openerFormObj.dgCntrSplitNo.value;
		
		if(ComGetObjValue(document.form.splitReason)=="C" && ComGetObjValue(document.form.bkg_no).length==12){
			strSheetTitle=" ||CNTR Seq. & No.|CNTR Seq. & No.|Cargo Seq.|UN No.|IMDG Class|"+ComGetObjValue(document.form.bkg_no).substring(10,12);
		}else{
			strSheetTitle=" ||CNTR Seq. & No.|CNTR Seq. & No.|Cargo Seq.|UN No.|IMDG Class|"+ComGetObjValue(document.form.orgSplit);
		}
		strSheetTitle=SheetSetHeader(ComGetObjValue(document.form.splitReason),ComParseInt(document.form.lastSplitNo),ComGetObjValue(document.form.splitCnt),strSheetTitle);
        for(i=0;i<sheetObjects.length;i++){ 
			ComConfigSheet (sheetObjects[i] ); 
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]); 
        }
		sheetObjects[0].SetExtendLastCol(0);
		sheet1_OnLoadFinish(sheet1);
		ComFireEvent(ComGetObject("btn_new") ,"click");
    }
	/*
	* Processing to eliminate screen blinks
	*/
    function sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.SetWaitImageVisible(0);
		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
		sheetObj.SetWaitImageVisible(1);
		if(ComParseInt(document.form.splitCnt)>0){
			if (ComGetObjValue(document.form.cntrExists)=="Y" && ComGetObjValue(document.form.cntrPopExists)=="N"){
				setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"cntr_no",ComGetObjValue(document.form.cntrPopExists));
			}else{
				setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"dcgo_seq",ComGetObjValue(document.form.cntrPopExists));
			}
			chkCntrValidate=CheckCntrSplit(document.form.validateSplitNo.value);
		}
	} 
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) { 
	                var HeadTitle1=strSheetTitle;  //" |CNTR Seq. & No.|CNTR Seq. & No.|Cargo Seq.|UN No.|IMDG Class| |A1|B1|C1|D1|E1|f1|G1";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
	                       {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"dcgo_seq",                               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"dg_cntr_seq",                            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_no",                                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_cgo_seq",                           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"imdg_un_no",                             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"imdg_clss_cd",                           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix1+ComGetObjValue(document.form.orgSplit),   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                 
	                var tmpCols = SheetSetInitCol(sheetObj,ComGetObjValue(document.form.splitReason),ComGetObjValue(document.form.splitCnt),ComParseInt(document.form.lastSplitNo),cnt,prefix1);
	                cols = cols.concat(tmpCols);

	                InitColumns(cols);
	                SetEditable(1);
	                cnt = cols.length;
	                //SheetSetInitCol(sheetObj,ComGetObjValue(document.form.splitReason),ComGetObjValue(document.form.splitCnt),ComParseInt(document.form.lastSplitNo),cnt,prefix1);
	                SetSheetHeight(210);
               }
                break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		var arrPreFix=new Array("sheet1_","sheet2_");
        switch(sAction) {
          case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCH; 
				var sXml=sheetObj.GetSearchData("ESM_BKG_0709GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
				sheetObj.RenderSheet(0);
//				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.RenderSheet(1);
           break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
	/*
	* grid Onchange event handling
	*/
	function sheet1_OnChange(sheetObj,Row,Col,Value){ 
		ComSetObjValue(document.form.cntrPopExists,"Y");
	} 
	/*
	* grid OnBefore event handling
	*/  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){
		if (!ComIsEmpty(sheetObj.GetCellValue(Row,prefix1+"cntr_no"))){
			if(!CheckCntrValidate(sheetObj,Col,sheetObj.GetCellValue(Row,prefix1+"cntr_no"),chkCntrValidate,prefix1)){
				sheetObj.SetCellValue(Row,Col,1,0);
			}
		}
	}
