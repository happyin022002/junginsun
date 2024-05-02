/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_9455.jsp
*@FileTitle  : Container No Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_9455 : business script for ESM_BKG_9455
     */
   	/* developer's work	*/
 // global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    //  Event handler processing by button name */
        function processButtonClick(){
             /***** using extra sheet valuable if there are more 2 sheets *****/
             var sheetObject=sheetObjects[0];
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {
    		       case "btn_Retrieve":
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;
                    case "btn_Ok":
                    	comPopupOK();
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
            initControl();
        }
         function initControl() {
        	 var formObject=document.form;
         	 axon_event.addListenerFormat('keypress','obj_KeyPress',formObject); //Using keyboard
         	 axon_event.addListener('keydown', 'ComKeyEnter', 'form');
         }                
     /**
       * setting sheet initial values and header
       * param : sheetObj, sheetNo
       * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
    	   var cnt = 0;
           switch(sheetNo) {
               case 1:      //t1sheet1 init
            	      with(sheetObj){
                   
                var HeadTitle="|Seq.||Container No.|TP/SZ";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                    {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"checkbox" },
                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"full_cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cntr_no" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cntr_no_pst" },
                    {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sts_cd" } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetSheetHeight(300);
                         }

                  break;
           }
       }
   // handling of Sheet 
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) 
         {
            case IBSEARCH:      //Retrieve
            	if(validateForm(sheetObj,formObj,sAction)){
    				ComSetObjValue(formObj.f_cmd, SEARCH);
     				sheetObj.DoSearch("ESM_BKG_9455GS.do", FormQueryString(formObj) );
            	}
                break;
         }
     }
    /**
     * handling process for input validation 
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
	   	  	case IBSEARCH:         		
	   			if(ComGetObjValue(formObj.vvd) == ""){		// Saving without search
	   				ComShowCodeMessage("BKG00448");
	   				return false;
	   			}
	   			if(ComGetObjValue(formObj.yd_cd) == ""){	
	   				ComShowCodeMessage("BKG00808");
	   				return false;
	   			}
	   			return true;        		
	   			break;
    	}
    }	         
 	/*
 	* Sheet onMouseUP Calling
 	*/
   function sheet1_OnMouseUp(sheetObj,Button, Shift, X, Y){ 
	  var sRowStr=sheetObj.GetSelectionRows("/");
 	  var arr=sRowStr.split("/");
 	  if (Shift==1){
 	  	for (var i=0; i<arr.length; i++) {
 	  		if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !="checkbox" && sheetObj.GetCellValue(arr[i],"checkbox")=="0"){
 	  			sheetObj.SetCellValue(arr[i],"checkbox","1",0);
 	  		}else if (sheetObj.ColSaveName(sheetObj.GetSelectCol()) !="checkbox" && sheetObj.GetCellValue(arr[i],"checkbox")=="1"){
 	  			sheetObj.SetCellValue(arr[i],"checkbox","0",0);
 	  		}
 	  	}
 	  } 	  
  }           
	/* End of developer's work  */
