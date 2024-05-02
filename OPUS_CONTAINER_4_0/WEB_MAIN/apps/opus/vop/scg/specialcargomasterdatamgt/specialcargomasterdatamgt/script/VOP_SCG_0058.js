/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : vop_scg_0058.js
 *@FileTitle: Packing Group (Inquiry)
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/23
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0058 : business script for vop_scg_0058 
     */
//    function vop_scg_0058() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try { 
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    break;
                case "btn1_Excel":
                    var paramObj=new Object();
                    paramObj.title="Packing Group";
//                    paramObj.columnwidth="2:23|3:23|4:23|5:23|6:23";
//                    var url=ComScgGetPgmTitle(sheetObjects[0], paramObj);
//                    if(sheetObject.RowCount() < 1){//no data
//                		  ComShowCodeMessage("COM132501");
//        	       	}else{ 
//        	       		sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
//        	       	}
					var sheetExcelObj = sheetObjects[0];
                    paramObj.columnwidth=ComScgGetExcelDown(sheetExcelObj);
                    paramObj.cols=ComScgGetExcelDownCols(sheetExcelObj);	
                    paramObj.datarowheight="0:25";
                    var url=ComScgGetPgmTitle(sheetExcelObj, paramObj); 
                    
                    if(sheetExcelObj.RowCount() < 1){//no data
                		  ComShowCodeMessage("COM132501");
        	       	}else{
	       	       		var str = sheetExcelObj.GetSearchData(url);
	       	       		str = str.replace(/(^\s*)|(\s*$)/gi, "");
	       	       		sheetExcelObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetExcelObj), SheetDesign:1,Merge:1,ReportXML:str});
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
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             //
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //
             ComEndConfigSheet(sheetObjects[i]);
         }
         initControl();
         sheet1_OnLoadFinish(sheet1);
     }
 function sheet1_OnLoadFinish(sheetObj) {
    	 doActionIBSheet( sheetObj,document.form,IBSEARCH);
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
                with (sheetObj) {               
//                (7, 0, 0, true);
	                var HeadTitle="|No.|Packing.Group|Degree of Danger|Flash Point.(Closed Cup)|Initial.Boiling Point|Height of.Drop Test";
	                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
	                       {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                       {Type:"Text",      Hidden:0,  Width:185,  Align:"Center",  ColMerge:0,   SaveName:"pck_dgr_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
	                       {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"flsh_pnt_temp_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
	                       {Type:"Text",      Hidden:0,  Width:190,  Align:"Center",  ColMerge:0,   SaveName:"init_boil_pnt_temp_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
	                       {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"drp_hgt_ctnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 } ];
	                 
	                InitColumns(cols);
	                SetEditable(0);
	                //SetSheetHeight(460);
	                resizeSheet();
	                SetColProperty("imdg_pck_grp_cd", {ComboText:"I|II|III", ComboCode:"1|2|3"} );
                }
                break;
         }
     }
     function resizeSheet(){
    	 	ComResizeSheet(sheetObjects[0]);
     }
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
            case IBSEARCH:      //retrieve
                formObj.f_cmd.value=SEARCH;
                 sheetObj.DoSearch("VOP_SCG_0040GS.do", FormQueryString(formObj) );
                break;
         }
     }
    /**
      * Dynamically load HTML Control event in page. <br>
      * Initialize IBSheet Object by calling this function from {@link #loadPage} function. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects list in turn
      **/
     function initControl() {       
         //Axon event handling1. event catch
//         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
        return true;
     }
