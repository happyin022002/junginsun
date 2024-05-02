/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ui_ctm_0400.js
*@FileTitle : Container Movement Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 /* developer job	*/
 // common global variables
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
                 case "btn_add":
                	 //sheetObject.DataInsert();
                     break;
                 case "btn_del":
                	 //sheetObject.RowDelete();
                    break;
                 case "btn_save":
                     //doActionIBSheet(sheetObject,formObject,IBSAVE);
                     break;
                 case "btn_print":
                     alert(srcName);
                     break;
                 case "btn_DownExcel":
                	 if(sheetObject.RowCount() < 1){
                			ComShowCodeMessage("COM132501");
                		}else{
                		//	sheetObject.Down2Excel({ HiddenColumn:-1});
                			
                			sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
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
      * registering IBCombo Object as list
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
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
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
             case 1:      //sheet1 init
            	    with(sheetObj){                
               
               var HeadTitle=" |Seq|Status|Dest Flag|Description|Gate In/Out";
               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_yd_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:630,  Align:"Left",    ColMerge:0,   SaveName:"mvmt_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);

               SetEditable(1);
               SetSheetHeight(480);
               resizeSheet();
                     /*  true,		true */
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
                  if(validateForm(sheetObj,formObj,sAction))
                   if(sheetObj.id == "sheet1") {
                	   formObj.f_cmd.value=SEARCH;
                        sheetObj.DoSearch("EES_CTM_0400GS.do", FormQueryString(formObj) );
                   }
                 break;
              case IBSAVE:        
               if(validateForm(sheetObj,formObj,sAction)) {
            	   formObj.f_cmd.value=MULTI;
            	   sheetObj.DoSave("EES_CTM_0400GS.do", FormQueryString(formObj));
               }
                 break;
             case IBINSERT:      
                 break;
         }
          sheetObj.ShowDebugMsg(false);
     }
     /**
      * registering IBTab Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
    /**
     * initializing Tab
     * setting Tab items
     */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                 }
              break;
          }
     }
     /**
      * event when clicking Tab
      * activating selected tab items
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	//--------------- important --------------------------//
     	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab=nItem;
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
     function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
     }
