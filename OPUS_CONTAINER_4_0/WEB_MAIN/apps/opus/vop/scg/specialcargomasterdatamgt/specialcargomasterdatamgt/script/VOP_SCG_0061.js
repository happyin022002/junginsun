/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : vop_scg_0061.js
 *@FileTitle: Packaging Code (Inquiry)
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
     * @class vop_scg_0061 : business javascript for vop_scg_0061 
     */
//    function vop_scg_0061() {
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
                   var tabName="";
                   paramObj.title="Packaging Code";
//                   paramObj.columnwidth="2:10|3:100|4:10";
//                   paramObj.datarowheight="0:25";                   
//                   var url=ComScgGetPgmTitle(sheetObjects[0], paramObj);  
//                   for(var i=0;i<formObject.imdg_pck_tp_cd.length;i++){
//                       if (  formObject.imdg_pck_tp_cd[i].checked ) {
//                             tabName=formObject.imdg_pck_tp_cd[i].getAttribute("caption");
//                       } 
//                    }
//                   if(sheetObject.RowCount() < 1){//no data
//              		  ComShowCodeMessage("COM132501");
//      	       		}else{       
//      	       			sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
//      	       		}
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         //Initializing html control event
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
//                (6, 0, 0, true);
	                var HeadTitle="|No.|Code|Description|Packaging \n Style|Delete Flag";
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
		                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"imdg_pck_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:0,  Width:750,  Align:"Left",    ColMerge:0,   SaveName:"imdg_pck_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                       {Type:"Text",      Hidden:0, Width:30,   Align:"Center",    ColMerge:0,   SaveName:"delt_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
	                InitColumns(cols);
	                SetEditable(0);
	                //SetSheetHeight(432);
	                resizeSheet();
                }
                break;
         }
     }
     function resizeSheet(){
    	 	ComResizeSheet(sheetObjects[0]);
     }
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
                if(validateForm(sheetObj,formObj,sAction)) {
                    if(sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=SEARCH;
                         sheetObj.DoSearch("VOP_SCG_0043GS.do", FormQueryString(formObj) );
                    }
                }           
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
//         axon_event.addListener('keydown', 	'ComKeyEnter',	'form');
    	 axon_event.addListener('click',	'obj_Click', 	'imdg_pck_tp_cd');         
//         axon_event.addListenerForm('keyup',    'obj_keyup',   form);
//         axon_event.addListenerForm('blur',     'obj_blur'  ,  form);
//         axon_event.addListenerForm('keypress', 'obj_keypress',form);
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }
    /**
     * Handling business javascript OnClick event
     */
    function obj_Click() {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    function obj_keyup(){
        obj=ComGetEvent()
        var formObj=document.form;        
        switch  (obj.name ){
                case 'imdg_pck_cd':
                    break;
                case 'imdg_pck_desc':
                    break;                    
        }
    }
    function obj_blur(){
    }    
    function obj_keypress(){
        var obj=ComGetEvent()
        var formObj=document.form;
        switch(obj.name ) {
            case "imdg_pck_cd":  
                 ComKeyOnlyAlphabet('uppernum');   
                 break;
            case "imdg_pck_desc":  
                ComKeyOnlyAlphabet('num');   
                break;                 
        } // end switch
     }
