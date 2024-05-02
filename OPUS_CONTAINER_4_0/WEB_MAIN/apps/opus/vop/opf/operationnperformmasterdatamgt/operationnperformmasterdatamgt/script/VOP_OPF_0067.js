/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0067.js
*@FileTitle  : TPR Target Lanes Register
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11

=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class vop_opf_0067 : vop_opf_0067 business script for
     */
    function vop_opf_0067() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* Developer performance	*/
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          　
         var sheetObject1=sheetObjects[0];   //t1sheet1
         var sheetObject2=sheetObjects[1];   //t1sheet1
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		    if(ComGetBtnDisable(srcName)) return false;
 				switch(srcName) {
 						case "btn_Save":
 							    doActionIBSheet(sheetObject2, formObject, IBSAVE);
 								break;
 		                case "btn_Close":
 		                	ComClosePopup(); 
 		                		break;
						case "btn_Add":
								if(ComIsBtnEnable("btn_Save")){
									sheet1_OnDblClick(sheetObject1, sheetObject1.GetSelectRow(), 2);
								}
								break;		
						case "btn_Del":
								if(ComIsBtnEnable("btn_Save")){
						        	sheet2_OnDblClick(sheetObject2, sheetObject2.GetSelectRow(), 2);
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
     function loadPage(strOfcCd) {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
 		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
 		var ofcCd=strOfcCd;
// 		if(ofcCd == "SELCOL"){
 			ComEnableObject(document.all.btn_Del, true);
 			ComEnableObject(document.all.btn_Add, true);
 			ComBtnEnable("btn_Save");
// 		}else{
// 			ComEnableObject(document.all.btn_Del, false);
// 			ComEnableObject(document.all.btn_Add, false); 			
// 			ComBtnDisable("btn_Save");
// 		}
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1_":
 				with (sheetObj) {

	                 var HeadTitle1="|All Lanes|All Lanes|";
	                 var headCount=ComCountHeadTitle(HeadTitle1);
//	                 (headCount, 0, 0, true);
	                 var prefix="sheet1_";
	
	                 SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                 InitHeaders(headers, info);
	
	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	                     {Type:"Text",   Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_prod_rpt_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                  
	                 InitColumns(cols);
	
	                 SetEditable(1);
	                 SetSheetHeight(322);
 				}
 				break;
             case "sheet2_":
 				with (sheetObj) {

	            	 var HeadTitle1="|TPR Target Lanes|TPR Target Lanes|";
	            	 var headCount=ComCountHeadTitle(HeadTitle1);
	            	 (headCount, 0, 0, true);
	            	 var prefix="sheet2_";
	
	            	 SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	
	            	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            	 InitHeaders(headers, info);
	
	            	 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	            	              {Type:"Seq",       Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	            	              {Type:"Text",   Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	              {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_prod_rpt_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            	  
	            	 InitColumns(cols);
	
	            	 SetWaitImageVisible(false);
	            	 SetEditable(1);
	            	 SetSheetHeight(322);
 				}
 				break;
 		}
     }
   // handling process related Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 					case IBSEARCH:      //Retrieve
 						if(sheetObj.id == "sheet1_")
 						{
 							formObj.tml_prod_rpt_flg.value="N";
 							formObj.f_cmd.value=SEARCH;
 							sheetObj.DoSearch("VOP_OPF_0067GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
 						}else if(sheetObj.id == "sheet2_") {
 							formObj.tml_prod_rpt_flg.value="Y";
 	 						formObj.f_cmd.value=SEARCH;
 	 						sheetObj.DoSearch("VOP_OPF_0067GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") );
 						}
 						break;
 					case IBSAVE:        //save 						
 			            if(validateForm(sheetObj,formObj,sAction)) {
 							formObj.f_cmd.value=MULTI;
 							var sParam=ComGetSaveString(sheetObjects);
 						    if (sParam == "") return;
 						    sParam += "&" + FormQueryString(formObj);
 						    var sXml=sheetObjects[0].GetSaveData("VOP_OPF_0067GS.do", sParam);
 						    sheetObjects[0].LoadSaveData(sXml);
 						}
 						break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	   /**
             if (!isNumber(formObj.iPage)) {
                 return false;
             }
               **/
         }
         return true;
     }
     
     
     function sheet1_OnDblClick(sheetObj, Row, Col){
    	 var vVslSlanCd	= sheetObj.GetCellValue(Row, "sheet1_vsl_slan_cd");
    	 sheetObj.RowDelete(Row, false);
    	 var insert_row	= sheetObjects[1].DataInsert(-1);
    	 
    	 //sheetObjects[1].CellValue(sheetObjects[1].LastRow-1, Col) = sheetObj.CellValue(Row, Col);
    	 sheetObjects[1].SetCellValue(insert_row, "sheet2_vsl_slan_cd", vVslSlanCd);
    	 sheetObjects[1].SetCellValue(insert_row, "sheet2_tml_prod_rpt_flg", "Y");    	 
    	 
    	 sheetObjects[0].SetSumText(0, "sheet1_vsl_slan_cd", sheetObjects[0].RowCount());
    	 sheetObjects[1].SetSumText(0, "sheet2_vsl_slan_cd", sheetObjects[1].RowCount());
     }
     
     function sheet2_OnDblClick(sheetObj, Row, Col){
    	 var vVslSlanCd	= sheetObj.GetCellValue(Row, "sheet2_vsl_slan_cd");
    	 sheetObj.RowDelete(Row, false);
    	 var insert_row	= sheetObjects[0].DataInsert(-1);
    	 //sheetObjects[1].CellValue(sheetObjects[1].LastRow-1, Col) = sheetObj.CellValue(Row, Col);
    	 sheetObjects[0].SetCellValue(insert_row, "sheet1_vsl_slan_cd", vVslSlanCd);
    	 sheetObjects[0].SetCellValue(insert_row, "sheet1_tml_prod_rpt_flg", "N");
    	 sheetObjects[0].SetSumText(0, "sheet1_vsl_slan_cd", sheetObjects[0].RowCount());
    	 sheetObjects[1].SetSumText(0, "sheet2_vsl_slan_cd", sheetObjects[1].RowCount());
     }
     
     
     function sheet1__OnDblClick(sheetObj, Row, Col){    	 
    	 if(ComIsBtnEnable("btn_Save")){
    		 sheet1_OnDblClick(sheetObj, Row, Col);
    	 }
     }
     function sheet2__OnDblClick(sheetObj, Row, Col){
    	 if(ComIsBtnEnable("btn_Save")){
    		 sheet2_OnDblClick(sheetObj, Row, Col);
    	 }
     }
 	 function sheet1__OnSearchEnd(sheetObj, ErrMsg)
 	 {
 		with(sheetObj)
 		{
 			sheetObj.SetSumText(0, 2,sheetObj.RowCount());
 			//CellAlign(LastRow, "Lanes") = daRight;
 		}
 	}
 	function sheet2__OnSearchEnd(sheetObj, ErrMsg)
 	{
 		with(sheetObj)
 		{
 			sheetObj.SetSumText(0, 2,sheetObj.RowCount());
 		}
 	}
	/* Developer performance  end */
