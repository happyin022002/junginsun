/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0651.js
*@FileTitle  : booking report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 var sheetObjects = new Array();
 var sheetCnt = 0;

 // Event handler processing by button click event  */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
                 case "btn_sand":
                	 doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
 					 break;
                 case "btn_print":
                	 goPrint();
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
      * adding first-served functions after loading screen
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
 		 doActionIBSheet(sheetObjects[0],document.form,INIT);
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
                    var HeadTitle="C/A Office|C/A Issue Staff|C/A Date||";
                    
                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"corr_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"corr_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"corr_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"corr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"usr_eml",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    
                    InitColumns(cols);
                    SetEditable(1);
                    SetSheetHeight(ComGetSheetHeight(sheetObj, 4));
                }
                break;
             case 2:      //sheet2 init
                with(sheetObj){
                    var HeadTitle="Correction Items|New|Old";
                    
                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"his_cate_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"crnt_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"pre_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetSheetHeight(ComGetSheetHeight(sheetObj, 5));
                }
                 break;
         }
     }
   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case INIT:      //
	         	formObj.f_cmd.value=SEARCH;   
 				sheetObj.DoSearch("ESM_BKG_0651GS.do",FormQueryString(formObj) );
                break;
 			case SEARCH:      // 
 				sheetObj.SetWaitImageVisible(0);
 				ComOpenWait(true);
	 			formObj.f_cmd.value=SEARCH01;   
 				sheetObj.DoSearch("ESM_BKG_0651GS.do",FormQueryString(formObj) );
				
                break;
 			case COMMAND01:      // 
 				var sheetObj2=sheetObjects[1];
 				formObj.usr_eml.value="dhhan@itsmt.co.kr";
                formObj.rd_param.value="/rp ['" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bkg_no") + "'] ['" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "corr_no") + "'] /riprnmargin";
 				formObj.title.value="C/A History List";
 				formObj.content.value="C/A History List";
	 			formObj.f_cmd.value=COMMAND01; 
 				sheetObj.DoSearch("ESM_BKG_0651GS.do",FormQueryString(formObj) );
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
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		var formObj=document.form;
 		if (sheetObj.LastRow()>= 1){
            formObj.bkg_no.value=sheetObj.GetCellValue(1,"bkg_no");
            formObj.corr_no.value=sheetObj.GetCellValue(1,"corr_no");
 			doActionIBSheet(sheetObjects[1],document.form,SEARCH);
 		} else {
 		    ComOpenWait(false);
 		}
 	}
    function sheet2_OnSearchEnd(sheetObj, Code, ErrMsg, StCode, StMsg) { 
    	ComOpenWait(false);
    }

 	function sheet1_OnClick(sheetObj,Row, Col, Value)
 	{
 		var formObj=document.form;
        formObj.bkg_no.value=sheetObj.GetCellValue(Row,"bkg_no");
        formObj.corr_no.value=sheetObj.GetCellValue(Row,"corr_no");
 		doActionIBSheet(sheetObjects[1],document.form,SEARCH); 		
 	}
 	/**
     * RD(Report Designer) Print
     */
     function goPrint(){		    			
     	var sheetObj=sheetObjects[0];
     	var formObj=document.form;
 		var bkg_no=formObj.bkg_no.value;
     	var ca_no=formObj.corr_no.value; 			 	   
 	   	var rdPath="apps/opus/esm/bkg/bookingcorrection/bdrcorrection/report/ESM_BKG_0182.mrd";
 	    formObj.com_mrdTitle.value="C/A Detail(s)";
 	    formObj.com_mrdBodyTitle.value="C/A Detail(s)";
 	   	formObj.com_mrdPath.value=rdPath;
 	   	formObj.com_mrdArguments.value="/rp ['" + bkg_no + "'] ['" + ca_no + "'] /riprnmargin";
 	   	//ComDebug(formObj.com_mrdArguments.value);
 	   	//alert(formObj.com_mrdArguments.value);
	 	ComOpenRDPopup();
     }
