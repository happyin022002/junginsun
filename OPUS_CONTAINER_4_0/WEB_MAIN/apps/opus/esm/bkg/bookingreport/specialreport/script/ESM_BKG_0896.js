/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0896.js
*@FileTitle  : BookingReport
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class esm_bkg_0896 : esm_bkg_0896 - task script definition for screen
     */
 // public variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
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
           	doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
            if (document.form.edit_yn.value == "N"){
            	ComBtnDisable("btn_Save");
    		}
         }
     }
   /**
      * setting sheet initial values and header
      * 
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		switch(sheetObj.id) {
 			case "sheet1":      //sheet1 init
 			    with(sheetObj){
 		      var HeadTitle="|Sel.|User ID|Name|Office||||ownr";
 		      var headCount=ComCountHeadTitle(HeadTitle);
 		      var prefix="sheet1_";

 		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

 		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
 		      InitHeaders(headers, info);

 		      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
 		             {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_id",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"rpt_id" },
 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_rpt_knd_cd" },
 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id" },
 		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ownr_flg" } ];
 		       
 		      InitColumns(cols);

 		      SetEditable(1);
 		     SetSheetHeight(150);
 		            }


 				break;
 			}
 	}
   // Event handler processing by button name */
      function processButtonClick(){
           /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
           var sheetObject1=sheetObjects[0];
           /*******************************************************/
           var formObject=document.form;
      	try {
      		var srcName=ComGetEvent("name");
      		 if(ComGetBtnDisable(srcName)) return false;
  			switch(srcName) {
  				case "btn_RowAdd":
  					sheetObject1.DataInsert(-1);
  					break;
  				case "btn_Delete":
  					doActionIBSheet(sheetObject1,document.form,IBDELETE);
  					break;
  				case "btn_Save":
  					doActionIBSheet(sheetObject1,document.form,IBSAVE);
  					break;
  				case "btn_Close":
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
   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
           	case IBSEARCH:      //retrieve	
           		formObj.f_cmd.value=SEARCH;   
 				sheetObj.DoSearch("ESM_BKG_0896GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
                 break;
 	 		case IBSAVE:        //save
	 	 		if(!validateForm(sheetObj,formObj,sAction)) {
		            return;
		        }//end if
		        formObj.f_cmd.value=MULTI;		        
		        sheetObj.SetWaitImageVisible(0);
		        ComOpenWait(true);
		        var sParam="&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");;
                sheetObj.DoSave("ESM_BKG_0896GS.do", sParam);
// 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 				//self.close();
                 break;
 	 		case IBDELETE:      //delete	
// 	 			if(validateForm(sheetObj,formObj,sAction))
//				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_ibflag","D",0);
				ComRowHideDelete(sheetObj, "sheet1_del_chk");
        	    break;
         }
         	ComOpenWait(false);
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
	  for (var i=1 ; i < sheetObj.RowCount()+1 ; i++){
			//if (sheetObj.CellValue(i,1) == '0'){
				//sheetObj.CellValue2(i,0) = "R";
			//}else{
if (sheetObj.GetCellValue(i,2) == ''){
					alert("plase input user id");
  	        	return false;
  	        }
				sheetObj.SetCellValue(i,5,formObj.rpt_id.value,0);
				sheetObj.SetCellValue(i,6,formObj.bkg_rpt_knd_cd.value,0);
			//}
		}
        if (! sheetObj.IsDataModified()){
        	alert("change no data.. ");
        	return false;
        }
         return true;
     }
    /**
     * after changing cell, event handling >>> ID check
     */ 
     function sheet1_OnAfterEdit(sheetObj, Row, Col) {
    	 with (sheetObj) {
    		 if (Col == 2){
    			 document.form.usr_id.value=GetCellValue(Row,Col);
    			 if (document.form.usr_id.value == ''){
    				 return;
    			 }
    			 document.form.f_cmd.value=SEARCH01;   
  		         var sXml=GetSearchData("ESM_BKG_0896GS.do" , FormQueryString(document.form));
 		         if (ComGetEtcData(sXml,"check") == "Y:Y"){
 		        	 SetCellValue(Row,3,ComGetEtcData(sXml,"usrNm"),0);
 	 		         SetCellValue(Row,4,ComGetEtcData(sXml,"ofcCd"),0);
 		         }else if (ComGetEtcData(sXml,"check") == "Y:N"){
 		        	 alert("Exist User ID");
 		        	 SetCellValue(Row, Col, "");
 		        	 SelectCell(Row, Col);
 		         }else{
 		        	 alert("Wrong User ID");
 		        	 SetCellValue(Row, Col, "");
 		        	 SelectCell(Row, Col);
 		         }
    		 }
    	 }
     }
     
     function sheet1_OnSearchEnd(sheetObj, errMsg){
    	 for (var i=1 ; i < sheetObj.RowCount()+1 ; i++){
    		 if (sheetObj.GetCellValue(i, 2) != ''){
    			 sheetObj.SetCellEditable(i, 2, 0);
    		 }
    		 if (sheetObj.GetCellValue(i, "sheet1_ownr_flg") == "Y"){
    			 sheetObj.SetCellEditable(i, "sheet1_del_chk", 0);
    		 }
    	 }
    	 return false;
     }
     function sheet1_OnSaveEnd(sheetObj, errMsg){
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
     /**
      * Cell click event handling >>>activating cell
      */ 
      function sheet1_OnClick(sheetObj, Row, Col, Value) {
     	 with (sheetObj) {
     		 if (Col == 2){
     			SelectCell(Row, Col, true, Value);
     		 }
     	 }
      }
