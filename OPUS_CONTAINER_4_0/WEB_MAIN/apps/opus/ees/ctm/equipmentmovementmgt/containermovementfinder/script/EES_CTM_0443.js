/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0443.js
*@FileTitle : Cargo Location message
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/23
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event  */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
            switch(srcName) {
                 case "btn_close":
                	 ComClosePopup(); 
                     break;
                 case "btn_downexcel":
                	 if(sheetObjects[0].RowCount() < 1){
            			ComShowCodeMessage("COM132501");
            		}else{
            			sheetObjects[0].Down2Excel({ HiddenColumn:-1});
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
          //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
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
                
                var HeadTitle1="Seq|F/M|Sight Code|Current|Current|Current|Service\nProvider|Mode|Final Destination|Final Destination|Final Destination|Train/Truck|Flatcar";
                var HeadTitle2="Seq|F/M|Sight Code|Location|Status|Event Date|Service\nProvider|Mode|Location|Status|Event Date|Train/Truck|Flatcar";
                sTipFM="";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},
                            { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                       {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:0 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"clm_sght_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"arr_loc_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"arr_ste_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"arr_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"clm_crr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mod_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dep_loc_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dep_ste_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dep_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trn_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fcar_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetColProperty("arr_dt", {Format:"####-##-####:##"} );
                SetColProperty("dep_dt", {Format:"####-##-####:##"} );
                SetCountPosition(0);
//                SetSheetHeight(370);
                resizeSheet();
                      }
                 break;
         }
     }
   //handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
           case IBSEARCH:     
 	          if(validateForm(sheetObj,formObj,sAction))
  	         	  ComOpenWait(true);
	         	  sheetObj.SetWaitImageVisible(0);
 	        	  formObj.f_cmd.value=SEARCH;
            		  sheetObj.DoSearch("EES_CTM_0443GS.do", FormQueryString(formObj) );
  	         	  ComOpenWait(false);
   	         	  sheetObj.SetWaitImageVisible(1);
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
     function resizeSheet(){
 		ComResizeSheet(sheetObjects[0]);
 	}
 /*
 	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		sheetObj.ShowSubSum([{StdCol:"a", SumCols:"a", Sort:true, ShowCumulate:false, CaptionCol:3, CaptionText:"0=;1=;2=;"}]);
 		var sRow=sheetObj.FindSubSumRow("a");
 		var arrRow=sRow.split("|");
 		for(idx=0; idx < arrRow.length-1 ; idx++)
 		{
if(sheetObj.GetCellValue(parseInt(arrRow[idx])+1, "a") =="A" )
 			{
 				sheetObj.SetCellValue(arrRow[idx],"d","▶ Auto Calculated Cost",0);
}else if(sheetObj.GetCellValue(parseInt(arrRow[idx])+1, "a") =="M" )
 			{
 				sheetObj.SetCellValue(arrRow[idx],"d","▶ Manual Input Cost",0);
 			}
 		}
 	}
 	*/
