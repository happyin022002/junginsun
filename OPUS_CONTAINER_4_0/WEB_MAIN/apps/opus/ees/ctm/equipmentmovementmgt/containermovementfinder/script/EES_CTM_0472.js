/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0472.js
*@FileTitle : Booking No Search
*@author     : CLT
*@version    : 1.0
*@since      : 2016/01/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var sheetSelect=false;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_Calendar":
	                //if (!window.event.srcElement.disabled) {
	            	if (!ComGetEvent("disabled")) {
	                    var cal=new ComCalendarFromTo();
	                    cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
	                }
	            	break;
	            case "btn_retrieve":
	            	if (!checkFormField()) return;
	            	doActionIBSheet(sheetObject, frmObj, IBSEARCH);
	                break;
	            case "btn_new":
                    // initializing all Objects
                    obj_clear(); 
                    break;
	            case "btn_select":
                    Row=sheetObject.GetSelectRow();
                    if (Row == '') return;
                    if (Row == '0' || sheetSelect == false) {
                   	 ComShowCodeMessage("CTM30001");
                   	 return;
                    }
                    var bkgNo = sheetObject.GetCellValue(Row, "bkg_no");
                    //ComClosePopup();
                    ComPopUpReturnValue(bkgNo);
	                break;
            } // end switch
        } catch(e) {
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
        for (i=0; i<sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        // CTM-COMMON
        setEventProcess();
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObj){
	              var HeadTitle="Seq|CT|Booking No|BL No|Repo. Plan ID|T.VVD|T.VVD POL|T.VVD POL ETD|T.VVD POD|T.VVD POD ETA";
	             
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Seq",    Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
	  	                 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ToolTipText:"[ Cargo type ] <br>F: Full, P: Reposition, R: Revenue" },
	                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
	                     {Type:"Text",     Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"repo_pln_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:9 },
	                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:5 },
	                     {Type:"Text",     Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"etd_dt",              KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:17 },
	                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:5 },
                  		 {Type:"Text",     Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"eta_dt",              KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:17 },
                         {Type:"Text",     Hidden:1,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"p_date1" },
                         {Type:"Text",     Hidden:1,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"p_date2" } ];
	               
	              InitColumns(cols);
	              
	              SetEditable(1);
	              SetCountPosition(0);
	//              SetSheetHeight(442);
	              resizeSheet();
             }


                break;
        }
    }
    //handling process for Sheet
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     
                if (validateForm(sheetObj, frmObj, sAction)) {
                    ComOpenWait(true);
                    sheetObj.SetWaitImageVisible(0);
                    sheetObj.RemoveAll();
                    
                    frmObj.f_cmd.value=SEARCH;
                    sheetObj.DoSearchFx("EES_CTM_0472GS.do", FormQueryString(frmObj));
                    ComOpenWait(false);
                }
                break;
        }
    }
    /**
     * initializing all objects
     */
    function obj_clear() {
        ComResetAll();
        sheetObjects[0].RemoveEtcData();
    }
    /**
     * handling OnSearchEnd event in Sheet1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        sheetSelect=false;
        if (ErrMsg == "") {
            // in case retrieving result exists
            if (sheetObj.RowCount()> 0) {
                // making btn_del button Enable
                ComBtnEnable("btn_select");
                sheetObj.SelectCell(1, 2);
            } else {
                // making btn_del button Enable
                ComBtnDisable("btn_select");
            }
        }
        ComOpenWait(false);
        sheetObj.SetWaitImageVisible(1);
    }
    /**
     * event when double clicking cell in IBSheet data part
     * @param {sheetObj} String :  IBSheet cell name
     * @param {Row} Long : cell Row Index
     * @param {Col} Long : cell Column Index
     * @param {Value} String : changed value
     * @param {CellX} Long : cell x-coordinate
     * @param {CellY} Long : cell y-coordinate
     * @param {CellW} Long : cell width
     * @param {CellH} Long : cell length
     */
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
        with (sheetObj) {
            var bkgNo = sheetObj.GetCellValue(Row, "bkg_no");
            //ComClosePopup();
            ComPopUpReturnValue(bkgNo);
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        if (NewRow > 0) sheetSelect=true;
    }
    function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}