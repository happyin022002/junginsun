/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_8001.js
*@FileTitle  : MTY Repo Inquiry by VVD 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class ees_eqr_8001 : business script for ees_eqr_8001
     */
    // common static variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var IBSEARCH02=30;
//    
//    var PREFIX00  = "sheet1_";
//    var PREFIX01  = "sheet2_";
//    var PREFIX02  = "sheet3_";
    var PREFIX00="";
    var PREFIX01="";
    var PREFIX02="";    
    
    var strHidTpSz = "";
    var hidD2YN = 0;
    var hidD4YN = 0;
    var hidD5YN = 0;
    var hidD7YN = 0;
    var hidR2YN = 0;
    var hidR5YN = 0;
    var hidO2YN = 0;
    var hidS2YN = 0;
    var hidO4YN = 0;
    var hidS4YN = 0;
    var hidF2YN = 0;
    var hidA2YN = 0;
    var hidF4YN = 0;
    var hidA4YN = 0;
    var hidF5YN = 0;
    var hidP2YN = 0;
    var hidP4YN = 0;
    var hidT2YN = 0;
    var hidT4YN = 0;
   
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var sheetObject2=sheetObjects[2];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Retrieve":
                	doActionIBSheet( sheetObject , formObject , IBSEARCH_ASYNC01 );
                    doActionIBSheet( sheetObject , formObject , IBSEARCH );
                break;
                case "btn_new":
                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();
                    sheetObjects[2].RemoveAll();
                    formObject.reset();
                    document.getElementById("vvd").focus();
                    setHRText2();
                    break;
                break;
                case "btn_downexcel":
        			if(sheetObjects[0].RowCount() < 1){//no data
      				  ComShowCodeMessage("COM132501");
      				  return;
        			}
                	sheetObjects[0].Down2ExcelBuffer(true);
                    if ( sheetObjects[0].RowCount()> 0 ) {
                    	sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObject), SheetName:"Sheet1", SheetDesign:1,Merge:1 });
                    }
                    if ( sheetObjects[1].RowCount()> 0 ) {
                    	sheetObjects[1].Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetName:"Sheet2", SheetDesign:1,Merge:1 });
                    }
                    if ( sheetObjects[2].RowCount()> 0 ) {
                    	sheetObjects[2].Down2Excel({DownCols: makeHiddenSkipCol(sheetObject2), SheetName:"Sheet3", SheetDesign:1,Merge:1 });
                    }
                	sheetObjects[0].Down2ExcelBuffer(false);
                break;
                case "btn_vvd": //calling pop-up for retrieving for vvd 
                    var param="?vvd_cd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/COM_ENS_0B2.do" , 755, 500 , "popupFinish" , "1,0,1,1,1,1,1,1" , true );
                break;
                case "HRBTN":
                    var param="?version=H&vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/EES_EQR_7003.do"+param , 940, 485 , "" , "1,0,1,1,1,1,1,1" , true );
                break;
                case "RMBTN":
                    var param="?vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/EES_EQR_7002.do"+param , 910, 515 , "" , "1,0,1,1,1,1,1,1" , true );
                break;
                case "DMBTN":
                    var param="?version=D&vvd=" + formObject.vvd.value ;
                    ComOpenPopup( "/opuscntr/EES_EQR_7003.do"+param , 940, 485 , "" , "1,0,1,1,1,1,1,1" , true );
                break;                
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowCodeMessage("EQR90004");
            } else {
                alert(e);
            }
        }
    }
    function popHRBTN(){
        var formObject=document.form;
        var param="?version=H&vvd=" + formObject.vvd.value ;
        ComOpenPopup( "/opuscntr/EES_EQR_7003.do"+param , 940, 435 , "" , "1,0,1,1,1,1,1,1" , true );
    }
    function popRMBTN(){
        var formObject=document.form;
        var param="?vvd=" + formObject.vvd.value ;
        ComOpenPopup( "/opuscntr/EES_EQR_7002.do"+param , 910, 465 , "" , "1,0,1,1,1,1,1,1" , true );
    }
    function popDMBTN(){
        var formObject=document.form;
        var param="?version=D&vvd=" + formObject.vvd.value ;
        ComOpenPopup( "/opuscntr/EES_EQR_7003.do"+param , 940, 435 , "" , "1,0,1,1,1,1,1,1" , true );
    }
    /**
     * setting selected value from lane code pop-up
     */
    function popupFinish(aryPopupData, row, col, sheetIdx) {
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        formObject.vvd.value=aryPopupData[0][7];
        formObject.lane.value=aryPopupData[0][3];
        formObject.bay.value=aryPopupData[0][4];
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    function form_click(){
    	srcName=ComGetEvent("name");
    	if ( srcName == "user"){
    		var userId=document.form.user.value;
    		if ( userId != "" ){
   				ComUserPopup(userId);
    		}
    	}
    }
    function initControl(){
//        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'   , document.form );
//        axon_event.addListenerForm  ( 'change'   , 'obj_change'     , document.form );
//        axon_event.addListenerFormat( 'focus'    , 'obj_activate'   , document.form ); //- handling activate event
//        axon_event.addListenerForm  ( 'blur'     , 'obj_deactivate' , document.form ); //- handling deactivate event
//        axon_event.addListenerFormat( 'keyup'    , 'form_keyup'     , document.form );
//        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'    , 'form'        );
        axon_event.addListenerForm('click', 'form_click',    document.form); //- when clicked
        document.form.vvd.focus();
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	strHidTpSz = hidtpszallCode;
    	
   	    if(strHidTpSz.indexOf("D2") > -1) { hidD2YN = 1; }
	    if(strHidTpSz.indexOf("D4") > -1) { hidD4YN = 1; }
	    if(strHidTpSz.indexOf("D5") > -1) { hidD5YN = 1; }
	    if(strHidTpSz.indexOf("D7") > -1) { hidD7YN = 1; }
	    if(strHidTpSz.indexOf("R2") > -1) { hidR2YN = 1; }
	    if(strHidTpSz.indexOf("R5") > -1) { hidR5YN = 1; }
	    if(strHidTpSz.indexOf("O2") > -1) { hidO2YN = 1; }
	    if(strHidTpSz.indexOf("S2") > -1) { hidS2YN = 1; }
	    if(strHidTpSz.indexOf("O4") > -1) { hidO4YN = 1; }
	    if(strHidTpSz.indexOf("S4") > -1) { hidS4YN = 1; }
	    if(strHidTpSz.indexOf("F2") > -1) { hidF2YN = 1; }
	    if(strHidTpSz.indexOf("A2") > -1) { hidA2YN = 1; }
	    if(strHidTpSz.indexOf("F4") > -1) { hidF4YN = 1; }
	    if(strHidTpSz.indexOf("A4") > -1) { hidA4YN = 1; }
	    if(strHidTpSz.indexOf("F5") > -1) { hidF5YN = 1; }	    
	    if(strHidTpSz.indexOf("P2") > -1) { hidP2YN = 1; }
	    if(strHidTpSz.indexOf("P4") > -1) { hidP4YN = 1; }
	    if(strHidTpSz.indexOf("T2") > -1) { hidT2YN = 1; }
	    if(strHidTpSz.indexOf("T4") > -1) { hidT4YN = 1; }
	    
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        setHRText2();
        //sheetObjects[0].SetColHidden(4,1);
        //sheetObjects[0].SetColHidden(5,1);
        sheetObjects[0].SetColHidden(22,1);
        sheetObjects[0].SetColHidden(23,1);
        sheetObjects[0].SetColHidden(24,1);
        sheetObjects[0].SetColHidden(25,1);
        sheetObjects[1].SetColHidden(22,1);
        sheetObjects[1].SetColHidden(23,1);
        sheetObjects[1].SetColHidden(24,1);
        sheetObjects[1].SetColHidden(25,1);
        sheetObjects[2].SetColHidden(22,1);
        sheetObjects[2].SetColHidden(23,1);
        sheetObjects[2].SetColHidden(24,1);
        sheetObjects[2].SetColHidden(25,1);
    }
    function setHRText2(){
        ComGetObject('HRBTN').innerText="HR :    ";
        ComGetObject('RMBTN').innerText="Rev. MTY:  ";
        ComGetObject('DMBTN').innerText="DMG :    ";
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
            case "sheet1":
                with (sheetObj) {
	                var HeadTitle="|||MTY Volume|MTY Volume|MTY Volume|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                var sumLine="|"+PREFIX00+"d2| + |"+PREFIX00+"d4| + |"+PREFIX00+"d5| + |"+PREFIX00+"d7| + |"+PREFIX00+"r2| + |"+PREFIX00+"r5| + |"+PREFIX00+"o2| + " +
	                "|"+PREFIX00+"o4| + |"+PREFIX00+"s2| + |"+PREFIX00+"s4| + |"+PREFIX00+"f2| + |"+PREFIX00+"f4| + |"+PREFIX00+"f5| + |"+PREFIX00+"a4| + " +
	                "|"+PREFIX00+"a2| + |"+PREFIX00+"p2| + |"+PREFIX00+"p4| + |"+PREFIX00+"t2| + |"+PREFIX00+"t4|";
	
	                SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:PREFIX00+"ibflag" },
		                       {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:PREFIX00+"del_chk" },
		                       {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX00+"status" },
		                       {Type:"Text",      Hidden:1,  Width:0,  Align:"Center",  ColMerge:1,   SaveName:PREFIX00+"pod_cd",  KeyField:0,   CalcLogic:"",   Format:"",                             UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                       {Type:"Text",      Hidden:0,  Width:180,    Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",                         UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"etb",     KeyField:0,   CalcLogic:"",   Format:"Ymd",                        UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"total",   KeyField:0,   CalcLogic:sumLine,Format:"NullInteger",PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD5YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD7YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"d7",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidR2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"r2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidR5YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"r5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidO2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"o2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidS2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"s2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidO4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"o4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidS4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"s4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidF2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"f2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidA2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"a2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidF4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"f4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidA4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"a4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidF5YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"f5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidP2YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"p2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidP4YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"p4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidT2YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"t2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidT4YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX00+"t4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                //sheetObj.FrozenCols=2;
	                //SetAutoSumPosition(1);
	                SetSheetHeight(133);
                }
            break;
            case "sheet2":
                with (sheetObj) {
	                var HeadTitle="|||POL|POL|ETD|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                var sumLine2="|"+PREFIX01+"d2| + |"+PREFIX01+"d4| + |"+PREFIX01+"d5| + |"+PREFIX01+"d7| + |"+PREFIX01+"r2| + |"+PREFIX01+"r5| + " +
	                "|"+PREFIX01+"o2| + |"+PREFIX01+"o4| + |"+PREFIX01+"s2| + |"+PREFIX01+"s4| + |"+PREFIX01+"f2| + |"+PREFIX01+"f4| + " +
	                "|"+PREFIX01+"f5| + |"+PREFIX01+"a4| + |"+PREFIX01+"a2| + |"+PREFIX01+"p2| + |"+PREFIX01+"p4| + |"+PREFIX01+"t2| + |"+PREFIX01+"t4|";
	
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:PREFIX01+"ibflag" },
		                       {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:PREFIX01+"del_chk" },
		                       {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"status" },
		                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"pod_cd",  KeyField:0,   CalcLogic:"",   Format:"",                          UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",                          UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX01+"etb",     KeyField:0,   CalcLogic:"",   Format:"Ymd",                       UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"total",   KeyField:0,   CalcLogic:sumLine2,Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD5YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD7YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"d7",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidR2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"r2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidR5YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"r5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidO2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"o2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidS2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"s2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidO4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"o4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidS4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"s4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidF2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"f2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidA2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"a2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidF4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"f4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidA4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"a4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidF5YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"f5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidP2YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"p2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidP4YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"p4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidT2YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"t2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidT4YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX01+"t4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetSheetHeight(150);
                }
            break;
            case "sheet3":
                with (sheetObj) {
	                var HeadTitle="|||POD|POD|ETB|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                var sumLine3="|"+PREFIX02+"d2| + |"+PREFIX02+"d4| + |"+PREFIX02+"d5| + |"+PREFIX02+"d7| + |"+PREFIX02+"r2| + |"+PREFIX02+"r5| + |"+PREFIX02+"o2| + " +
	                "|"+PREFIX02+"o4| + |"+PREFIX02+"s2| + |"+PREFIX02+"s4| + |"+PREFIX02+"f2| + |"+PREFIX02+"f4| + |"+PREFIX02+"f5| + |"+PREFIX02+"a4| + " +
	                "|"+PREFIX02+"a2| + |"+PREFIX02+"p2| + |"+PREFIX02+"p4| + |"+PREFIX02+"t2| + |"+PREFIX02+"t4|";
	
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:PREFIX02+"ibflag" },
		                       {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:PREFIX02+"del_chk" },
		                       {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"status" },
		                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"pod_cd",  KeyField:0,   CalcLogic:"",   Format:"",                           UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",                           UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:PREFIX02+"etb",     KeyField:0,   CalcLogic:"",   Format:"Ymd",                        UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"total",   KeyField:0,   CalcLogic:sumLine3,Format:"NullInteger", PointCount:0,  UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD5YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidD7YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"d7",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidR2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"r2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidR5YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"r5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidO2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"o2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidS2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"s2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidO4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"o4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidS4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"s4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidF2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"f2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidA2YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"a2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidF4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"f4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidA4YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"a4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidF5YN, Width:45,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"f5",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidP2YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"p2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidP4YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"p4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidT2YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"t2",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,      UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"AutoSum",   Hidden:hidT4YN, Width:40,   Align:"Right",   ColMerge:0,   SaveName:PREFIX02+"t4",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,     UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
//	                InitDataValid( 0 , PREFIX02+"pod_cd" , vtEngUpOnly , "" ); //upper case
	                SetColProperty(0 ,PREFIX02+"pod_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
	                SetSheetHeight(150);
                }
            break;
        }
    }
  // handling process for Sheet
    function doActionIBSheet( sheetObj , formObj , sAction ) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //retrieve
                if(validateForm(sheetObj,formObj,sAction)){
                    if (sheetObj.id == 'sheet1') { 
                        for( var i=0 ; i < sheetObjects.length ; i++ ){
                            sheetObjects[i].RemoveAll();
                        }               
                		sheetObj.SetWaitImageVisible(0);
                		ComOpenWait(true);
                        formObj.f_cmd.value=SEARCH;    
                        var sXml=sheetObj.GetSearchData("EES_EQR_7001GS.do", FormQueryString(formObj));
                        var arrXml=sXml.split("|$$|");
                        var sCheck=ComGetEtcData(arrXml[0], "check");
                        var arrTpSz=sCheck.split("|");
                        if(arrTpSz[0] == '') arrTpSz[0]=0;
                        if(arrTpSz[1] == '') arrTpSz[1]=0;
                        if(arrTpSz[2] == '') arrTpSz[2]=0;
                        ComGetObject('HRBTN').innerText="HR : "       + arrTpSz[0];
                        ComGetObject('RMBTN').innerText="Rev. MTY : " + arrTpSz[2];
                        ComGetObject('DMBTN').innerText="DMG : "      + arrTpSz[1];
                        for( var i=0 ; i < arrXml.length ; i++ ){  
                            sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
                        }
                		sheetObj.SetWaitImageVisible(1);
                		ComOpenWait(false);
                    }                     
                } else {
                    return;
                }
            break;
            case IBSEARCH_ASYNC01:      // VVD retrieve
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value=SEARCH01;
                    sheetObj.SetWaitImageVisible(0);
                    var sXml=sheetObj.GetSearchData("EES_EQR_7001GS.do",FormQueryString(formObj));
                    var sCheck=ComGetEtcData(sXml, "check");
                    var arrTpSz=sCheck.split("|");
//                    alert("sCheck [" + sCheck + "]");
                    if(arrTpSz.length > 0){
                    	document.form.lane.value=arrTpSz[0];
                        document.form.bay.value=arrTpSz[1];
                    }
                    else{
                    	document.form.lane.value="";
                        document.form.bay.value="";
                    }
                //    document.form.version.value = arrTpSz[2];
                    if(arrTpSz[2] == "C"){
                    	document.form.version.value="C";
                	}
                    else{
                    	document.form.version.value="##";
                    }
                    document.form.remark.value=arrTpSz[4];
                    sheetObj.SetWaitImageVisible(1);
                } else {
                    return;
                }
            break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if(sAction == IBSEARCH){
                if(vvd.value == ""){
                    ComShowCodeMessage("EQR21001","VVD Code ");
                    ComSetFocus(vvd);
                    return false;
                }                
            }
        }
        return true;
    }
    //removing 0 from total row
    function removeZero(sheetObj) {
        with(sheetObj) {
            var sCol=6;
            var eCol=LastCol();
            for ( i=sCol ; i <= eCol ; i++ ) {
            	if ("" == GetSumText(0, i) ) {
            		SetSumText(0, i,"0");
                }
            }
        }
    }
    // handling search end event on sheet
    function sheet1_OnSearchEnd (sheetObj, ErrMsg) {
        with (sheetObj) {
//            SetColBackColor(PREFIX00+"yd_cd","#E5EAFF");
//            SumText(0, PREFIX00+"pod_cd") = "Onboard Total";
            SetSumText( 4 , "Onboard Total");
            //no support[implemented common]CLT MessageText("Sum")="Onboard Total";
            SetCellAlign(0,PREFIX00+"pod_cd","Center");
            removeZero(sheetObj);
            //sheetObjects[0].SetColHidden(4,1);
            //sheetObjects[0].SetColHidden(5,1);
        }
    }
    // handling search end event on sheet
    function sheet2_OnSearchEnd (sheetObj, ErrMsg) {
        with (sheetObj) {
        	SetSumText( 0 , PREFIX01 + "pod_cd","Additonal Load Total");
   //         SumText ( 0 , PREFIX01 + "yd_cd" ) = "Additonal Load Total";
   //         SumText ( 0 , PREFIX01 + "etb"   ) = "Additonal Load Total";
            SetMergeCell(LastRow(), 3 , 1 , 3);
            SetCellAlign(LastRow(),PREFIX01 + "pod_cd","Center");
           // SumText ( 0 , PREFIX01 + "pod_cd") = "Add. Load";
           // SumText ( 0 , PREFIX01 + "yd_cd" ) = "Total";
           // SumText ( 0 , PREFIX01 + "etb"   ) = "";
            removeZero(sheetObj);
            for ( var i=7 ; i < 26 ; i++ ) {
            	sheetObjects[0].SetCellValue(2,i,GetSumValue(0, i),0);
            }
        }
    }
    // handling search end event on sheet
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
        	SetSumText(0, PREFIX02+"pod_cd","Discharge Total");
            SetMergeCell(LastRow(), 3 , 1 , 3);
            SetCellAlign(LastRow(),PREFIX02+"pod_cd","Center");
            removeZero(sheetObj);
            var tVer=document.form.version.value;
            if ( tVer == "I" ) {
                for( var i=7 ; i < 26 ; i++ ) {
                	sheetObjects[0].SetCellValue(1,i,sheetObj.GetSumValue(0,i),0);
                }
            }
        }
    }
   /* 
    //handling deactivate event
    function obj_deactivate() {
        switch (event.srcElement.name) {
            case "vvd":
                if(event.srcElement.value != ""){
                    doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH_ASYNC01 );
                }
            break;
        }           
        return true;
    }
    */
    /**
     * 
     */
//	function obj_keypress(){
//	    //alert("event.srcElement.name ["+event.srcElement.name+"]");
//	    switch(event.srcElement.name){
//	        case "vvd":
//	            ComKeyOnlyAlphabet('uppernum');// upper case + number
//	        break;
//	    }   
//	}    
