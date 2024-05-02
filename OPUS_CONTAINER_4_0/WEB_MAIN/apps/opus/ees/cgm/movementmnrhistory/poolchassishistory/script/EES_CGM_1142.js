/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1142.js
*@FileTitle : Pool Chassis Comparison Detailed
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


    /**
     * @extends 
     * @class EES_CGM_1142 : EES_CGM_1142 business script for
     */
    function EES_CGM_1142() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* developer job	*/

 // common global variables

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1; 

 var sheetObjects = new Array();
 var sheetCnt = 0;

 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /***** use additional sheet var in case of more than 2 tap each sheet *****/
 		  var sheetObject1 = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {

		            case "btn_close":
		            	 ComClosePopup();
		                 break; 
					
					case "btn_downexcel":
						if (sheetObject1.RowCount() < 1) {// no data
							ComShowCodeMessage("COM132501");
						} else {
							sheetObject1.Down2Excel({DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1});
						}
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;
 			
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
         
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
      

   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) { 
             case 1:      //sheet1 init
                 with (sheetObj) {
	            	 var HeadTitle1 = "||Matching|Chassis No|Owner|CNTR No|OWN|OWN|OWN|OWN|OWN|MGMT|MGMT|MGMT|MGMT|MGMT|";
	                 var HeadTitle2 = "||Matching|Chassis No|Owner|CNTR No|On-Hire Date|On-Hire Yard|Off-Hire Date|Off-Hire Yard|Used Days|On-Hire Date|On-Hire Yard|Off-Hire Date|Off-Hire Yard|Used Days|Units";
	                 
//	                 var headCount=ComCountHeadTitle(HeadTitle);
	                 
	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, FrozenCol:6 } );
	                 
	                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                 var headers = [ { Text:HeadTitle1, Align:"Center"},
	       	                      { Text:HeadTitle2, Align:"Center"} ];
	   		      	 InitHeaders(headers, info);
	   		      	 
		   		      var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                      Wrap:1 },
		   		                   {Type:"Text",      Hidden:1,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"mst",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"matching",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chss_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Text",      Hidden:0,  Width:75,  Align:"Center",  ColMerge:0,   SaveName:"chss_ownr_co_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Text",      Hidden:0,  Width:115,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Date",      Hidden:0,  Width:140,   Align:"Center",  ColMerge:0,   SaveName:"own_onhdt",               KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"own_onhyd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Date",      Hidden:0,  Width:140,   Align:"Center",  ColMerge:0,   SaveName:"own_offhdt",               KeyField:0,   CalcLogic:"",   Format:"YmdHm",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Date",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"own_offhyd",               KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"AutoSum",   Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"own_usdy",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Date",      Hidden:0,  Width:140,   Align:"Center",  ColMerge:0,   SaveName:"mgmt_onhdt",              KeyField:0,   CalcLogic:"",   Format:"YmdHm",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"mgmt_onhyd",              KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Date",      Hidden:0,  Width:140,   Align:"Center",  ColMerge:0,   SaveName:"mgmt_offhdt",             KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",   ColMerge:0,   SaveName:"mgmt_offhyd",              KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Center",   ColMerge:0,   SaveName:"mgmt_usddys",             KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		   		                   {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pool_unit",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
		  			             ];
		   		      InitColumns(cols);
				      SetEditable(0);
				      SetSheetHeight(380);
                 
                }
                 break;         	

         }
     }
      
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
   	{
    
   		with(sheetObj)
   		{
   		}	
   	}

   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 					case IBSEARCH:      //retrieve
 					    formObj.f_cmd.value = SEARCH;
 					    
 	 				    queryString = "f_cmd=" + SEARCH ;
 	 				  var params = FormQueryString(formObj);
//	 	 				var sXml = sheetObj.GetSearchXml("EES_CGM_1142GS.do" , FormQueryString(formObj));
//	 	 	     		sheetObj.LoadSearchXml(sXml);
// 	 				  sheetObj.SetWaitImageVisible(0);
  			 	      ComOpenWait(true);
 	 				  sheetObj.DoSearch("EES_CGM_1142GS.do",  params);
// 	 				    var sXml = sheetObj.GetSearchXml("EES_CGM_1142GS.do" , FormQueryString(formObj));
// 	 				    sheetObj.LoadSearchXml(sXml);
 	 				    
// 	 				  sheetObj.SumText(0,9)  = "("+sheetObj.SumText(0,10)+") Units";
// 	 				  sheetObj.SumText(0,11) = "G.Total by MGMT";
// 	 				  sheetObj.SumText(0,14) = "("+sheetObj.SumText(0,15)+") Units";
// 	                  sheetObj.SumText(0,"matching")   = "";
  			 	      ComOpenWait(false);
 						//		
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

 		
 		

	/* developer job end */