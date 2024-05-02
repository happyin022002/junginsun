/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0656.js
*@FileTitle  : RFA Commodity PopUp
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0656 :business script for ESM_BKG_0656
     */
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
		 var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,document.form,IBSEARCH);								
				break; 
				case "btn_Select":
					comPopupSend(sheetObject, formObject);	
				break;
				case "btn_Close":
					ComClosePopup(); 
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");    
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
     * adding first-served functions after loading screen
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        if (parent.getSvcScpCd != undefined) {
    		document.form.svc_scp_cd.value = parent.getSvcScpCd();
    		document.form.ui_id.value = "ESM_BKG_0079";
    	}
    	if (document.form.lodg_due_dt.value != ""){
    		document.form.ui_id.value = "ESM_PRI_6001";
    	}
        
        sheet1_OnLoadFinish(sheet1);
    }
    
	function sheet1_OnLoadFinish(sheetObj) {   
 		sheetObj.SetWaitImageVisible(0);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		initControl();  
 		sheetObj.SetWaitImageVisible(1);
 	}                 
	function initControl() {
   	 	var formObject=document.form;
        //axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); 
        //axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
            		var HeadTitle1="|Group Code|RFA Description|Code|Description|Type|Cmdt|scope|rep cmdt";

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Radio",     Hidden:0, 	Width:0,    Align:"Center",  ColMerge:0,   SaveName:"chk" },
            		             {Type:"Text",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rfa_desc",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  	Width:180,  Align:"Left",    ColMerge:0,   SaveName:"grp_desc",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  	Width:55,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  	Width:180,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Left",    ColMerge:0,   SaveName:"type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  	Width:55,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1,	Width:55,   Align:"Left",    ColMerge:0,   SaveName:"rep_cmdt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);
            		SetSheetHeight(240);
            		SetEditable(1);
                }
                break;
        }
    }
      // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      
				formObj.f_cmd.value=SEARCH;
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0656GS.do", FormQueryString(formObj) );
				ComOpenWait(false); 
			break;
        }
    }
	//double click -> select
    function sheet1_OnDblClick(sheetObj , row, col) {  
   	 	var formObj=document.form;
   	 	sheetObj.SetCellValue(row,"chk","1",0);
   	 	comPopupSend(sheetObj, formObj);
    }     
    /**
     * send screen info to Main
     */     
	function comPopupSend(sheetObj, formObj){
		var calllFunc=formObj.calllFunc.value;
		var rArray=getCheckedRowByName(sheetObj,"chk");
    	if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}else{
			var opener = window.dialogArguments;
			if (!opener) opener = parent;
 			eval('opener.'+calllFunc)(rArray);
 			ComClosePopup(); 
		}
	}     	
