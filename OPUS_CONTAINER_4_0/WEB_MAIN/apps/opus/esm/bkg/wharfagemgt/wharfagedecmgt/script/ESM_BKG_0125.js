/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : esm_bkg_0125.js
*@FileTitle : Customer Code Entry
 *@author : CLT
 *@version : 1.0
 *@since : 2014.04.24
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/* developer job	*/
	// common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
	// Event handler processing by button click event
    document.onclick=processButtonClick;
	// Event handler processing by button name
    function processButtonClick(){
		 var sheetObject1=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_retrieve":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
                case "btn_downexcel":
                	if(sheetObject1.RowCount() < 1){
                		ComShowCodeMessage("COM132501");
                	}else{
                		sheetObject1.Down2Excel({ HiddenColumn:-1});
                	}
				break;
				case "btn_close":
					ComClosePopup(); 
				break;						
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
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
        initControl();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
  	/**
    * Dynamically load HTML Control event in page. <br>
    * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
    * @param {ibsheet} sheetObj    IBSheet Object
    * @param {int}     sheetNo     sheetObjects list in turn
    **/
    function initControl() {
    	var formObject=document.form;
        /* axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form'); */
    	formObject.vvd.focus();
    }
    /**
     * handling input search condition
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=window.event.srcElement.getAttribute("value");
    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
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
                with(sheetObj){
                            
                var HeadTitle1="|Trans Mode|B/L No";

                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
                InitColumns(cols);

                SetEditable(1);
//                SetSheetHeight(300);
                resizeSheet();
                }


                break;
        }
    }
    // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      // retrieve
        		if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=SEARCH;   
 					sheetObj.DoSearch("ESM_BKG_0125GS.do",FormQueryString(formObj) );
        		}
			break;
        }
    }
    /**
     * handling process for input validation
     */
     function validateForm(sheetObj,formObj,sAction){
     	switch (sAction) {
	 		case IBSEARCH: // retrieve
	 			if ( formObj.vvd.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00887', 'VVD');
	 				return false;
	 			}
	 			if ( formObj.port_cd.value == "") 
	 			{
	 				ComShowCodeMessage('BKG00887', 'Port');
	 				return false;
	 			}
	 			if ( formObj.mrn_no.value == "") 
	 			{
	 				ComShowCodeMessage('BKG00887', 'MRN NO');
	 				return false;
	 			}
	 			if ( formObj.io_bnd_cd.value == "") 
	 			{
	 				ComShowCodeMessage('BKG00887', 'BND');
	 				return false;
	 			}
	 			return true;
	 		break;
     	}
     }
     /* developers work end */
     
     function resizeSheet(){
         ComResizeSheet(sheetObjects[0]);
     }
