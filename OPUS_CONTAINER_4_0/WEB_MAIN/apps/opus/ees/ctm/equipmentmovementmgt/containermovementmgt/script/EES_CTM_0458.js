/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0458.js
*@FileTitle  : MVMT
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
                 case "btn_retrive":
                     doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
		              var HeadTitle="T/S|Total|Remain|TP";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"op_cntr_qty",    KeyField:0,   CalcLogic:"",   Format:"" },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"renain",         KeyField:0,   CalcLogic:"",   Format:"" },
		                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"" } ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
		              SetSheetHeight(182);
                       }
                 break;
         }
     }
   //handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
          switch(sAction)
         {
            case IBSEARCH:     
                  if(validateForm(sheetObj,formObj,sAction)) {
                	  sheetObj.RemoveAll();
    				  ComOpenWait(true);
    				  sheetObj.SetWaitImageVisible(0);
                	  formObj.f_cmd.value=SEARCH;
                	  xml=sheetObj.DoSearch ("EES_CTM_0458GS.do", FormQueryString(formObj));
    				  ComOpenWait(false);
    				  sheetObj.SetWaitImageVisible(1);
                  }
                 break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
