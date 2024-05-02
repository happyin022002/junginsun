/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0090.js
*@FileTitle  : Special Stowage Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // global variable

 var sheetObjects = new Array();
 var sheetCnt = 0;

 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 				case "btn_Save":
 					setPopupToParent(sheetObject, formObject);
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
       * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         } 		
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    	 // getting script to show input value in Main
    	 if (opener) document.form.stwg_rmk.value =opener.form.stwg_rmk.value;
    	 else if (parent) document.form.stwg_rmk.value =parent.form.stwg_rmk.value;
         
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
                    var HeadTitle="|Sel.|Type|Detail";
                    
                    SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                                 {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"val",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"name",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetSheetHeight(ComGetSheetHeight(sheetObj, 12));
                }
                 break;
         }
     }
   // handling of Sheet 
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //search
            	formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_BKG_0090GS.do", FormQueryString(formObj) );
            break;
         }
     }

     function setPopupToParent(sheetObject, formObj){
    	var stwgRmk=formObj.stwg_rmk.value;
    	var stwgCd="";
     	for (var i=sheetObject.HeaderRows(); i<=sheetObject.LastRow(); i++) {
            if(sheetObject.GetCellValue(i,"chk") == 1){
                stwgCd=sheetObject.GetCellValue(i,"val");
     			break;
     		}
 	    } 		    	 		
		var calllFunc=formObj.calllFunc.value;
		if(calllFunc != ''){
			if (ComFuncCheck("opener." + calllFunc)) ComFunc(new Array(stwgCd, stwgRmk));
			else if (ComFuncCheck("parent." + calllFunc)) ComFunc(new Array(stwgCd, stwgRmk));
		}         	
        ComClosePopup(); 
     }
     // setting main information
     function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	 // setting StowageCode in Main 
    	var stwg_cd=ComTrimAll(document.form.stwg_cd.value);
    	if(stwg_cd.length > 0){
         	for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
                if(sheetObj.GetCellValue(i,"val") == stwg_cd){
         			sheetObj.SetCellValue(i,"chk",1);
         			break;
         		}
     	    } 		    		
    	}
     }
	/* End of developer's work */
