/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0754.js
*@FileTitle  : Special Cargo Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
/****************************************************************************************
   Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
					[Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   /**
     * @fileoverview As a java script file that uses common on business, it has been defined about calendar-related functions.
     * @author 
     */
 // Common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var opener=window.dialogArguments; 
 if (!opener) opener=parent;
 //Event Handler definition for Button Click event */
 document.onclick=processButtonClick;
 //Event Handler for branch processing by judging button name */
     function processButtonClick(){
/***** using extra sheet valuable if there are more 2 sheets *****/
 var sheetObject1=sheetObjects[0];
 var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
 					switch(srcName) {
 						case "btn_select":
 							var chkRow=sheetObjects[0].FindText("Chk", "1", 0, 2);
 							if(sheetObjects[0].RowCount() < 1){
 								ComShowCodeMessage("BKG00249");
 								return;
 							}
 							if(opener.document.getElementById("title_id").value =="awk"){
								opener.document.getElementById("frm_cntr_cgo_seq").value=sheetObjects[0].GetCellValue(chkRow, "dg_cntr_seq");
								opener.sheetObjects[1].SetCellValue(opener.sheetObjects[1].GetSelectRow(), "awk_dcgo_seq",sheetObjects[0].GetCellValue(chkRow, "dg_cntr_seq"),0);
								opener.sheetObjects[1].SetCellValue(opener.sheetObjects[1].GetSelectRow(), "cntr_cgo_seq",sheetObjects[0].GetCellValue(chkRow, "cntr_cgo_seq"),0);
 							}
 							if(opener.document.getElementById("title_id").value =="rf"){
								opener.document.getElementById("rf_dcgo_seq").value=sheetObjects[0].GetCellValue(chkRow, "dg_cntr_seq");
								opener.sheetObjects[1].SetCellValue(opener.sheetObjects[1].GetSelectRow(), "rf_dcgo_seq",sheetObjects[0].GetCellValue(chkRow, "dg_cntr_seq"),0);
								opener.sheetObjects[1].SetCellValue(opener.sheetObjects[1].GetSelectRow(), "cntr_cgo_seq",sheetObjects[0].GetCellValue(chkRow, "cntr_cgo_seq"),0);
 							}
 							if(opener.document.getElementById("title_id").value =="bb"){
								opener.document.getElementById("bb_dcgo_seq").value=sheetObjects[0].GetCellValue(chkRow, "dg_cntr_seq");
								opener.sheetObjects[2].SetCellValue(opener.sheetObjects[2].GetSelectRow(), "bb_dcgo_seq",sheetObjects[0].GetCellValue(chkRow, "dg_cntr_seq"),0);
								opener.sheetObjects[2].SetCellValue(opener.sheetObjects[2].GetSelectRow(), "cntr_cgo_seq",sheetObjects[0].GetCellValue(chkRow, "cntr_cgo_seq"),0);
 							}
 							ComClosePopup(); 
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
      * Registering IBSheet Object in to Array
      * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
      * The array is defined at upper part of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Sheet basic setting & initializing
      * onLoad Event HandlerImplementation of body tag
      * After loading screen in the browser, add function in pre-processing
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
      * Definition for sheet initial setting value, header
      * param : sheetObj ==> sheet object, 
      * sheetNo ==> If the serial number ID tag attached to the sheet are many,
      * adding 'Case' clause as a number of sheets, configures initial module.
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 				var sheetID=sheetObj.id;
 				switch(sheetID) {
 					case "sheet1":
 					    with(sheetObj){
	 				      var HeadTitle1="|||Container|Container|Container|Cargo Seq|UN No|Class|DG Package Description|CGO Status|M Poll|Pack Grp||||";
	 				      var headCount=ComCountHeadTitle(HeadTitle1);
	 				      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	 				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	 				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	 				      InitHeaders(headers, info);
	
	 				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
	 				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"merge_dg_cntr_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	 				             {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Chk" },
	 				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cgo_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"prp_shp_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mrn_polut_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no_temp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	 				             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd_temp",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	 				       
	 				      	InitColumns(cols);
	 				      	SetWaitImageVisible(0);
	 				      	SetSheetHeight(340);
 						}
 					    break;
				}
 	}
   // Handling process about Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
 					case IBSEARCH:    
 					ComOpenWait(true);
 					if(validateForm(sheetObj,formObj,sAction)) {
    					formObj.f_cmd.value=SEARCH;
     					sheetObj.DoSearch("ESM_BKG_0754GS.do", FormQueryString(formObj));
    					if(document.getElementById("modalFlg").value != "Y"){
    						sheetObjects[0].SetColHidden("Chk",1);
    					}
    					for(var i=1; i <= sheetObj.RowCount(); i++){
    						sheetObj.SetCellValue(i,"cntr_no_temp",sheetObj.GetCellValue(i,"cntr_no"),0);
    						sheetObj.SetCellValue(i,"cntr_tpsz_cd_temp",sheetObj.GetCellValue(i,"cntr_tpsz_cd"),0);
    						if(sheetObj.GetCellValue(i,"cntr_cgo_seq") != "1"){
    							sheetObj.SetCellValue(i, "cntr_no","",0);
        						sheetObj.SetCellValue(i, "cntr_tpsz_cd","",0);
    						}
    						if(opener.document.getElementById("title_id").value =="awk"){
    							if(sheetObj.GetCellValue(i,"dg_cntr_seq") == opener.document.getElementById("frm_cntr_cgo_seq").value){
        							sheetObj.SetCellValue(i,"Chk","Y",0);
        						}
    						}    						
    						if(opener.document.getElementById("title_id").value =="rf"){
    							if(sheetObj.GetCellValue(i,"dg_cntr_seq") == opener.document.getElementById("rf_dcgo_seq").value){
        							sheetObj.SetCellValue(i,"Chk","Y",0);
        						}
    						}
    						if(opener.document.getElementById("title_id").value =="bb"){
    							if(sheetObj.GetCellValue(i,"dg_cntr_seq") == opener.document.getElementById("bb_dcgo_seq").value){
        							sheetObj.SetCellValue(i,"Chk","Y",0);
        						}
    						}
    					}
    				} 													
 					break;
 					case IBSAVE:
 						if(validateForm(sheetObj,formObj,sAction))
 					break;
 					case IBINSERT:
 					break;
         }
     }
     /**
      * Handling validity verification process about screen form input value.
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }
     /**
      * When click sheet, handles it
      */
     function sheet1_OnClick(sheetObj, row, col) {
     	var rowCnt=sheetObj.RowCount();
		var ifFlag=sheetObj.GetCellValue(row,"if_flag");
		var Chk=sheetObj.GetCellValue(row,"Chk");
		var dgCntrSeq=sheetObj.GetCellValue(row,"dg_cntr_seq");
         var colSaveName=sheetObj.ColSaveName(col);
         switch(colSaveName) {
 	    	case "Chk" :
 	    		for(i=1; i<=rowCnt; i++) {
 		    		if(Chk == 1) {
 		    			if(i == row) continue;
 		    			if(dgCntrSeq == sheetObj.GetCellValue(i, "dg_cntr_seq")) {
 		    				sheetObj.SetCellValue(i, "Chk",0,0);
 		    			}
 		    		} else if(Chk == 0) {
 		    			if(i == row) continue;
 		    			if(dgCntrSeq == sheetObj.GetCellValue(i, "dg_cntr_seq")) {
 		    				sheetObj.SetCellValue(i, "Chk",1,0);
 		    			}
 		    			else{
 		    				sheetObj.SetCellValue(i, "Chk",0,0);
 		    			}
 		    		}
 	    		}
 	    		break;
         } // end switch
     }

     function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
     	ComOpenWait(false);
     }