/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7001.js
*@FileTitle  : Tariff Type Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

   	/*  Developer's task	*/
 	// Common global variable
 	var sheetObjects=new Array();
 	var sheetCnt=0;
 	// Event handler processing by button click event */
 	document.onclick=processButtonClick;
 	// Event handler processing by button name */
    function processButtonClick(){
    	/***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
 		var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		switch(srcName) {
				case "btn_DownExcel":
//parameter changed[check again]CLT
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel({ HiddenColumn:-1});
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
     * IRegister as an array IBSheet Object
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
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
        	case "sheet1":
        		with(sheetObj){
        			var HeadTitle1="Seq.|Tariff Type|Calculation Type|DEM/DET|Bound|Description";
        			var headCount=ComCountHeadTitle(HeadTitle1);

        			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Seq",       Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_calc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"dmdt_trf_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
        			InitColumns(cols);

        			SetEditable(1);
        			SetSheetHeight(560);
        		}
        		break;
         }
     }
    
    // Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieving
				formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
				sheetObj.DoSearch("EES_DMT_7001GS.do", FormQueryString(formObj) );
				break;
        }
    }
    
    /**
     * Screen input form validation process for handling
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
        }
        return true;
    }
	/* developers work end */
