/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_3005.js
*@FileTitle  : UN No. Help
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // common global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var comboObjNm=new Array();
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_ok":
// 					if(window.returnValue){
 						comPopupOK();
// 					}
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
      * register IBCombo Object created in page as comboObjects list
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
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
         
         // Initializing IBMultiCombo
         for(var k=0; k<comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }
         sheet1_OnLoadFinish(sheet1);
     }
     function sheet1_OnLoadFinish(sheetObj) {
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);	//Amdt No
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
     
     var ipageNo=1;
     function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
         if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
         doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
     }

     /**
      * Initializing Combo
      * setting Combo items
      */
     function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
    	    case "imdg_amdt_no":
    	        with(comboObj) {
    	        	SetColWidth(0, "100");
    	        	SetDropHeight(190);
    	        	SetMultiSelect(0);
    	        	SetMaxSelect(1);
    	        	SetUseAutoComplete(1);
    	        }
    	        break;
        }
    }
     
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // sheet1 init
                 with(sheetObj){
		             var HeadTitle="||UN No/Seq|UN No/Seq|Class|Class|Proper Shipping Name|Technical Name|Sub\nRisks|Packing\nGroup|OWN Restrictions|imdg_comp_grp_cd";
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					              {Type:"Radio",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"prp_shp_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"imdg_tec_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:0,  Width:75,  Align:"Left",    ColMerge:0,   SaveName:"imdg_crr_rstr_expt_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					              {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             SetWaitImageVisible(0);
		             InitColumns(cols);
                     SetSelectionMode(smSelectionRow);
                     SetSheetHeight(250);
                     //resizeSheet();
		             //no support[check again]CLT 					ScrollTrack=false;
		             //no support[check again]CLT 					MassOfSearch=true;
             	}
            break;
         }
     }
     
     /*function resizeSheet(){
    	         ComResizeSheet(sheetObjects[0]);
    }*/
   // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction, PageNo) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
	        	ComOpenWait(true);
	              if(validateForm(sheetObj,formObj,sAction))
					   if ( sheetObj.id == "sheet1"){
							 formObj.f_cmd.value=SEARCH05;
							 iPageNo = 1;
				             var param=FormQueryString(formObj);
				            sheetObj.DoSearch("SCG_COM_INTERNALGS.do", param  + "&ipage="+iPageNo);
					   }
            break;
            case IBSEARCHAPPEND:  // paging retrieve
	             formObj.f_cmd.value=SEARCH05;  
	             var param=FormQueryString(formObj);
	             sheetObj.DoSearch("SCG_COM_INTERNALGS.do", param + "&ipage="+iPageNo, {Append:true});
	        break;
    		case IBSEARCH_ASYNC10:   //Amdt No 조회
    			
				
				if(formObj.imdg_un_no.value != '' && formObj.imdg_un_no_seq.value) {
					formObj.f_cmd.value=SEARCH09;	
				}else{
					formObj.f_cmd.value=SEARCH07;	
				}
   				
				var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do" , FormQueryString(formObj));
         		var arrData=ComScgXml2Array(sXml, "imdg_amdt_no");
         		formObj.crte_imdg_un_no.value = arrData[0][0];
         		
         		//formObj.f_cmd.value=SEARCH07;
    			var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
    			ComXml2ComboItem(sXml,imdg_amdt_no, "imdg_amdt_no", "imdg_amdt_no");
    			comboObjects[0].SetSelectText(formObj.crte_imdg_un_no.value, false);
         		
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
 	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg){
 		ComOpenWait(false);
 		var k=0;
 		for(var i=0; i<sheetObj.RowCount(); i++) {
 			if (sheetObj.GetCellValue(i+1, "imdg_pck_grp_cd") == 1) {
 				sheetObj.SetCellValue(i+1, "imdg_pck_grp_cd","I");
 			}else if (sheetObj.GetCellValue(i+1, "imdg_pck_grp_cd") == 2) {
 				sheetObj.SetCellValue(i+1, "imdg_pck_grp_cd","II");
 			}else if (sheetObj.GetCellValue(i+1, "imdg_pck_grp_cd") == 3) {
 				sheetObj.SetCellValue(i+1, "imdg_pck_grp_cd","III");
 			}
 			if (sheetObj.GetCellValue(i+1, "imdg_tec_nm") != "") {
 				k++;
 			}
 		}
 		if (k < 1) {
 			sheetObj.SetColHidden("imdg_tec_nm",1);
 			sheetObj.SetColWidth("prp_shp_nm",500);
 		}else{
 			sheetObj.SetColHidden("imdg_tec_nm",0);
 			sheetObj.SetColWidth("prp_shp_nm",350);
 			sheetObj.SetColWidth("imdg_tec_nm",150);
 		}
 	}
 	
 	
 	
 	function imdg_amdt_no_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) { 
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 	} 
 	
