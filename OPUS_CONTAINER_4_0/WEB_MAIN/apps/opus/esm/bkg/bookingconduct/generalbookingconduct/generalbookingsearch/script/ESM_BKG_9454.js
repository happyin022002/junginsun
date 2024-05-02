/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_9454.js
*@FileTitle : Transhipment Route Update
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_9454 : business script for ESM_BKG_9454
     */

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
          var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
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
         
         sheet1_OnLoadFinish(sheetObjects[0])
     }
 
     
     function sheet1_OnLoadFinish(sheetObj) {   
 		sheetObj.SetWaitImageVisible(0);
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		sheetObj.SetWaitImageVisible(1);
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
            	 	var HeadTitle="|Seq.|VVD Code|POL|POD|Lane|POL ETD|POD ETA";
            	 	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	 	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 	InitHeaders(headers, info);

            	 	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq" },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"etd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eta",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
            	 	InitColumns(cols);

            	 	SetEditable(1);
            	 	SetCountPosition(0);
            	 	SetSheetHeight(120);
                     }
                 break;
              case 2:      //t1sheet1 init
            	    with(sheetObj){
               var HeadTitle="|Seq.|VVD Code|POL|POD|Lane|POL ETD|POD ETA";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq" },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"etd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eta",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                SetSheetHeight(120);
                      }


                 break;
               case 3:      //t1sheet1 init
            	    with(sheetObj){
                 var HeadTitle="|Seq.|VVD Code|POL|POD|Lane|POL ETD|POD ETA";

                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                        {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq" },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"etd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eta",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                  
                 InitColumns(cols);
                 
                 SetEditable(1);
                 SetCountPosition(0);
                 SetSheetHeight(120);
                       }


                 break;
         }
     }
	// handling of Sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) 
         {
            case IBSEARCH:      // retrieve
            	ComSetObjValue(formObj.f_cmd, SEARCH);
            	var sXml=sheetObj.GetSearchData("ESM_BKG_9454GS.do" , FormQueryString(formObj));
    			var arrXml=sXml.split("|$$|");  
    			for(var i=0 ; i < arrXml.length ; i++){
    				sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
    			}    			
                break;
         }
     }
     /* end developers work */
