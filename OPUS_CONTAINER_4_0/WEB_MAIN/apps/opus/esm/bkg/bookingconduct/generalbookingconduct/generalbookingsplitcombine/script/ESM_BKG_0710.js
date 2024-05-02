/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0710.js
*@FileTitle  : RF Cargo Split
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var strSheetTitle=" |CNTR Seq. & No.|CNTR Seq. & No.|Temp.|Commodity";
var chkCntrValidate="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
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
							restoreCheck(sheetObject,strSheetTitle,prefix1,prefix1+"rc_seq",ComGetObjValue(document.form.cntrPopExists));
						}
					break;
					case "btn_save":
						callParentSplitFunc(sheetObjects[0],"R",prefix1+"cntr_no",prefix1+"rc_seq",ComGetObjValue(formObject.bkg_no),ComGetObjValue(formObject.bkgsplitno),ComGetObjValue(formObject.splitReason),strSheetTitle,ComGetObjValue(formObject.cntrPopExists));
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
		document.form.splitCntrSplitNo.value = openerFormObj.rfCntrSplitNo.value;
		
    	if(ComGetObjValue(document.form.splitReason)=="C" && ComGetObjValue(document.form.bkg_no).length==12){
			strSheetTitle=" |CNTR Seq. & No.|CNTR Seq. & No.|Temp.|Commodity|"+ComGetObjValue(document.form.bkg_no).substring(10,12);
		}else{
			strSheetTitle=" |CNTR Seq. & No.|CNTR Seq. & No.|Temp.|Commodity|"+ComGetObjValue(document.form.orgSplit);
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
	function sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.SetWaitImageVisible(0);
		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
		sheetObj.SetWaitImageVisible(1);
		if(ComParseInt(document.form.splitCnt.value)>0){ 
			if (ComGetObjValue(document.form.cntrExists)=="Y" && ComGetObjValue(document.form.cntrPopExists)=="N"){
				setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"cntr_no");
			}else{
				setSplitNo(sheetObjects[0],document.form.splitCntrSplitNo.value,strSheetTitle,prefix1,prefix1+"rc_seq");
			}
			chkCntrValidate=CheckCntrSplit(document.form.validateSplitNo.value);
		}
	} 
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                var HeadTitle1=strSheetTitle;
                var headCount=ComCountHeadTitle(HeadTitle1);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
                       {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"rc_seq",                                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_no",                                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix1+"cdo_temp",                               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
//                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:prefix1+"cmdt_nm",                                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:200,   Align:"Left",    ColMerge:0,   SaveName:prefix1+"cmdt_nm",                                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix1+ComGetObjValue(document.form.orgSplit),   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                
                var tmpCols = SheetSetInitCol(sheetObj,ComGetObjValue(document.form.splitReason),ComGetObjValue(document.form.splitCnt),ComParseInt(document.form.lastSplitNo),cnt,prefix1);
                cols = cols.concat(tmpCols);
                
                InitColumns(cols);
                SetEditable(1);
                //SheetSetInitCol(sheetObj,ComGetObjValue(document.form.splitReason),ComGetObjValue(document.form.splitCnt),ComParseInt(document.form.lastSplitNo),cnt,prefix1);
                SetSheetHeight(240);
               }
                break;
        }
    }
  // Sheet handling process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		var arrPreFix=new Array("sheet1_");
        switch(sAction) {
          case IBSEARCH:      //Retrieve
	        formObj.f_cmd.value=SEARCH; 
	        var sXml=sheetObj.GetSearchData("ESM_BKG_0710GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
			sheetObj.RenderSheet(0);
//			sheetObj.LoadSearchData(sXml,{Sync:0} );
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
	* Grid Onchange Event handling
	*/
	function sheet1_OnChange(sheetObj,Row,Col,Value){  
		 ComSetObjValue(document.form.cntrPopExists,"Y");
	} 
	/*
	* Grid OnBefore Event handling
	*/  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){
		if (!ComIsEmpty(sheetObj.GetCellValue(Row,prefix1+"cntr_no"))){
			if(!CheckCntrValidate(sheetObj,Col,sheetObj.GetCellValue(Row,prefix1+"cntr_no"),chkCntrValidate,prefix1)){
				sheetObj.SetCellValue(Row,Col,1,0);
			}
		}
	} 
