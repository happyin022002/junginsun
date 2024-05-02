/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1024.js
*@FileTitle  : VVD Change for partial container booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // public variable
 var sheetObjects = new Array();
 var sheetCnt = 0;

 // Event handler processing by button click event */
 document.onclick = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
 			switch(srcName) {
 				case "btn_Ok":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);   
 					break;
 				case "btn_Close":
                    ComClosePopup(); 
 					break; 					
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111"); 
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
 			initSheet(sheetObjects[i],i+1,"");
 			ComEndConfigSheet(sheetObjects[i]);
         }		
         
         var sheetObj = sheetObjects[0];
		 sheetObj.SetWaitImageVisible(0);
         if(ComIsNull(ComGetObjValue(document.form.bkg_no))){
        	 ComShowCodeMessage("BKG00255");
         }else{
        	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         }
		 sheetObj.SetWaitImageVisible(1);

     }
   /**
      * setting sheet initial values and header
      * 
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo,colName) {
         var cnt=0;
         switch(sheetObj.id){
             case "sheet1":
                with(sheetObj){
                  var colArr=colName.split("|");
                  var HeadTitle1="";
                  var HeadTitle2="";
                  if(colName != "" && colArr != null && colArr.length > 0){
                    HeadTitle1="BKG No.";
                    for(var i=0 ; i < colArr.length ; i++){
                        HeadTitle1=HeadTitle1 + "|CNTR No.";
                    }
                  
                    HeadTitle2="BKG No.|"+ colName.toUpperCase();
                  }else{
                    HeadTitle1="BKG No.|CNTR No.";
                    HeadTitle2="BKG No.|";
                  }
                  
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
    
                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"},
                                  { Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);
    
                  var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                  if(colName != "" && colArr != null && colArr.length > 0){
                    for(var i = 0 ; i < colArr.length ; i++){
                        cols.push({Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:colArr[i],    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    }
                  }else{
                    cols.push({Type:"CheckBox",  Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                  }
    
                  InitColumns(cols);
    
                  SetEditable(1);
                  SetCountPosition(0);
                  SetSheetHeight(152);
                }
 				break;
             case "sheet2":
                with(sheetObj){
                    var HeadTitle1="|BKG No.|I/R Change|I/R Change|Origin Inland|Origin Inland|Origin Inland|Origin Inland|Origin Inland|1st|1st|1st|1st|1st|2nd|2nd|2nd|2nd|2nd|3rd|3rd|3rd|3rd|3rd|4th|4th|4th|4th|4th|Destination Inland|Destination Inland|Destination Inland|Destination Inland||||";
                    var HeadTitle2="||ORG|DEST|POR|POR|POL|POL|S/O|1st VVD|POL|POL|POD|POD|2nd VVD|POL|POL|POD|POD|3rd VVD|POL|POL|POD|POD|4th VVD|POL|POL|POD|POD|POD|POD|DEL|DEL||||";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},
                                    { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Combo",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"org",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:"Y|N", ComboCode:"Y|N" },
                                 {Type:"Combo",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"dest",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:"Y|N", ComboCode:"Y|N" },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"por_nod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pol_nod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ob_so",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"polyd1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"podyd1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"polyd2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"podyd2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"polyd3",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"podyd3",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"podyd1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"polyd4",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"podyd4",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pod_nod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"del_nod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"bkg_trunk_vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pre_rly_port_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"pst_rly_port_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ocp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mty_pkup_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"full_rtn_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mty_pkup_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"org_trns_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"lodg_due_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mty_dor_arr_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"full_pkup_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"mty_rtn_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dest_trns_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"de_due_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                              
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetCountPosition(0);
                    SetSheetHeight(162);
                }
 				break;
 		}
     }
   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         switch(sAction) {
 			case IBSEARCH:      //retrieve
 				ComSetObjValue(formObj.f_cmd, SEARCH);
                var sXml=sheetObj.GetSearchData("ESM_BKG_1024GS.do", FormQueryString(formObj));
 				var arrXml=sXml.split("|$$|");  
				if (arrXml.length > 0){	
					var saveName=ComGetEtcData(arrXml[0], "SaveName");
					sheetObj.RemoveAll();
					sheetObjects[0] = sheetObjects[0].Reset();
					initSheet(sheetObjects[0],1,saveName);
					sheetObjects[0].LoadSearchData(arrXml[0]);
				}             		
				if (arrXml.length > 1){	
					sheetObjects[1].LoadSearchData(arrXml[1]);
				}      											
 				break;
 			case IBSAVE:        //save
 				ComSetObjValue(formObj.f_cmd, MULTI);					
 				var params=FormQueryString(formObj);	
 				params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true),"sheet2_");
 				var mainSheetObj=window.dialogArguments.sheetObjects[1];
				var startIdx=sheetObjects[1].HeaderRows();
                for(var i=startIdx+1; i <= sheetObjects[1].LastRow(); i++){
                    if(sheetObjects[1].GetCellValue(i,"vvd1")==null||(ComChkLen(sheetObjects[1].GetCellValue(i, "vvd1"),9)<2)){
						ComShowCodeMessage('BKG00144', 1);
						return false;
					}
                    if(sheetObjects[1].GetCellValue(i,"bkg_trunk_vvd")==null||(ComChkLen(sheetObjects[1].GetCellValue(i, "bkg_trunk_vvd"),9)<2)){
                        ComShowCodeMessage("BKG00051", sheetObjects[1].GetCellValue(i, "bkg_vvd_cd"));
						return false;
					}
				}
 				params=params + "&" + ComSetPrifix(mainSheetObj.GetSaveString(true),"sheetM_");
                var sXml=sheetObjects[1].GetSaveData("ESM_BKG_1024GS.do", params);
 				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
 				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
 			 		var calllFunc=ComGetObjValue(formObj.func);
 					if(calllFunc != ''){
 						eval('window.dialogArguments.'+calllFunc)();
 					}
                    ComClosePopup(); 
 				}
 				break;
         }
     }
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		sheetObj.FitColWidth();
		var iRow = sheetObj.FindText("bkg_no",ComGetObjValue(formObj.bkg_no));
		sheetObj.SetRowFontColor(iRow,"#0000FF");
        sheetObj.SetCellFontBold(iRow,0,1);
    }
    function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		// ** Display Booking information at first line(Start)***
		var mainSheetObj=window.dialogArguments.sheetObjects[1];
		var mainFormObj=window.dialogArguments.document.form;         				
		sheetObj.DataInsert(0);
		var addRow=sheetObj.HeaderRows();
		sheetObj.SetRowEditable(addRow,0);
		sheetObj.SetCellValue(addRow,"bkg_no",ComGetObjValue(formObj.bkg_no));
		sheetObj.SetCellValue(addRow,"org","");
		sheetObj.SetCellValue(addRow,"dest","");
		sheetObj.SetCellValue(addRow,"por_cd",ComGetObjValue(mainFormObj.bkg_por_cd));
		sheetObj.SetCellValue(addRow,"por_nod_cd",ComGetObjValue(mainFormObj.bkg_por_yd_cd));
		sheetObj.SetCellValue(addRow,"pol_cd",ComGetObjValue(mainFormObj.bkg_pol_cd));
		sheetObj.SetCellValue(addRow,"pol_nod_cd",ComGetObjValue(mainFormObj.bkg_pol_yd_cd));
		var idx=1;
        for(var i=mainSheetObj.HeaderRows(); i <= mainSheetObj.LastRow(); i++){
            sheetObj.SetCellValue(addRow,"vvd"+idx,mainSheetObj.GetCellValue(i,"bkg_vvd_cd"));
            sheetObj.SetCellValue(addRow,"pol"+idx,mainSheetObj.GetCellValue(i,"pol_cd"));
            sheetObj.SetCellValue(addRow,"polyd"+idx,mainSheetObj.GetCellValue(i,"pol_yd_cd"));
            sheetObj.SetCellValue(addRow,"pod"+idx,mainSheetObj.GetCellValue(i,"pod_cd"));
            sheetObj.SetCellValue(addRow,"podyd"+idx,mainSheetObj.GetCellValue(i,"pod_yd_cd"));
			idx++;
		}
		// get information in Main
		sheetObj.SetCellValue(addRow,"pod_cd",ComGetObjValue(mainFormObj.bkg_pod_cd));
		sheetObj.SetCellValue(addRow,"pod_nod_cd",ComGetObjValue(mainFormObj.bkg_pod_yd_cd));
		sheetObj.SetCellValue(addRow,"del_cd",ComGetObjValue(mainFormObj.bkg_del_cd));
		sheetObj.SetCellValue(addRow,"del_nod_cd",ComGetObjValue(mainFormObj.bkg_del_yd_cd));
		sheetObj.SetCellValue(addRow,"bkg_trunk_vvd",ComGetObjValue(mainFormObj.bkg_trunk_vvd));
		sheetObj.SetCellValue(addRow,"pre_rly_port_cd",ComGetObjValue(mainFormObj.pre_rly_port_cd));
		sheetObj.SetCellValue(addRow,"pst_rly_port_cd",ComGetObjValue(mainFormObj.pst_rly_port_cd));
		sheetObj.SetCellValue(addRow,"ocp_cd",ComGetObjValue(mainFormObj.ocp_cd));
		sheetObj.SetCellValue(addRow,"mty_pkup_yd_cd",ComGetObjValue(mainFormObj.mty_pkup_yd_cd));
		sheetObj.SetCellValue(addRow,"full_rtn_yd_cd",ComGetObjValue(mainFormObj.full_rtn_yd_cd));
		sheetObj.SetCellValue(addRow,"mty_pkup_dt",ComGetObjValue(mainFormObj.mty_pkup_dt));
		sheetObj.SetCellValue(addRow,"org_trns_mod_cd",ComGetObjValue(mainFormObj.org_trns_mod_cd));
		sheetObj.SetCellValue(addRow,"lodg_due_dt",ComGetObjValue(mainFormObj.lodg_due_dt));
		sheetObj.SetCellValue(addRow,"mty_dor_arr_dt",ComGetObjValue(mainFormObj.mty_dor_arr_dt));
		sheetObj.SetCellValue(addRow,"full_pkup_yd_cd",ComGetObjValue(mainFormObj.full_pkup_yd_cd));
		sheetObj.SetCellValue(addRow,"mty_rtn_yd_cd",ComGetObjValue(mainFormObj.mty_rtn_yd_cd));
		sheetObj.SetCellValue(addRow,"dest_trns_mod_cd",ComGetObjValue(mainFormObj.dest_trns_mod_cd));
		sheetObj.SetCellValue(addRow,"de_due_dt",ComGetObjValue(mainFormObj.de_due_dt));
		sheetObj.SetCellValue(addRow,"rcv_term_cd",ComGetObjValue(mainFormObj.rcv_term_cd));
		sheetObj.SetCellValue(addRow,"de_term_cd",ComGetObjValue(mainFormObj.de_term_cd));
		// ** isplay Booking information at first line(End)***
		// **  TS Route Information in Booking copy to other Booking (Start).
		var startIdx=sheetObj.HeaderRows();
        for(var i=startIdx+1; i <= sheetObj.LastRow(); i++){
            sheetObj.SetCellValue(i,"vvd1",sheetObj.GetCellValue(startIdx,"vvd1"));
            sheetObj.SetCellValue(i,"pol1",sheetObj.GetCellValue(startIdx,"pol1"));
            sheetObj.SetCellValue(i,"polyd1",sheetObj.GetCellValue(startIdx,"polyd1"));
            sheetObj.SetCellValue(i,"pod1",sheetObj.GetCellValue(startIdx,"pod1"));
            sheetObj.SetCellValue(i,"podyd1",sheetObj.GetCellValue(startIdx,"podyd1"));
            sheetObj.SetCellValue(i,"vvd2",sheetObj.GetCellValue(startIdx,"vvd2"));
            sheetObj.SetCellValue(i,"pol2",sheetObj.GetCellValue(startIdx,"pol2"));
            sheetObj.SetCellValue(i,"polyd2",sheetObj.GetCellValue(startIdx,"polyd2"));
            sheetObj.SetCellValue(i,"pod2",sheetObj.GetCellValue(startIdx,"pod2"));
            sheetObj.SetCellValue(i,"podyd2",sheetObj.GetCellValue(startIdx,"podyd2"));
            sheetObj.SetCellValue(i,"vvd3",sheetObj.GetCellValue(startIdx,"vvd3"));
            sheetObj.SetCellValue(i,"pol3",sheetObj.GetCellValue(startIdx,"pol3"));
            sheetObj.SetCellValue(i,"polyd3",sheetObj.GetCellValue(startIdx,"polyd3"));
            sheetObj.SetCellValue(i,"pod3",sheetObj.GetCellValue(startIdx,"pod3"));
            sheetObj.SetCellValue(i,"podyd3",sheetObj.GetCellValue(startIdx,"podyd3"));
            sheetObj.SetCellValue(i,"vvd4",sheetObj.GetCellValue(startIdx,"vvd4"));
            sheetObj.SetCellValue(i,"pol4",sheetObj.GetCellValue(startIdx,"pol4"));
            sheetObj.SetCellValue(i,"polyd4",sheetObj.GetCellValue(startIdx,"polyd4"));
            sheetObj.SetCellValue(i,"pod4",sheetObj.GetCellValue(startIdx,"pod4"));
            sheetObj.SetCellValue(i,"podyd4",sheetObj.GetCellValue(startIdx,"podyd4"));
            sheetObj.SetCellValue(i,"bkg_trunk_vvd",sheetObj.GetCellValue(startIdx,"bkg_trunk_vvd"));
            sheetObj.SetCellValue(i,"pre_rly_port_cd",sheetObj.GetCellValue(startIdx,"pre_rly_port_cd"));
            sheetObj.SetCellValue(i,"pst_rly_port_cd",sheetObj.GetCellValue(startIdx,"pst_rly_port_cd"));
		}
		// ** TS Route Information in Booking copy to other Booking(End).	
    }
     
     /**
     * In case of changing Sheet2 
     */
 	function sheet2_OnChange(sheetObj, Row, Col, Value)
	{
		var formObject=document.form;		
		var saveName=sheetObj.ColSaveName(Col);
		if(saveName == "org"){
            if(sheetObj.GetCellValue(Row, Col) == "Y"){
                var iRow2 = sheetObj.HeaderRows();
                sheetObj.SetCellValue(Row, "por_cd",sheetObj.GetCellValue(iRow2, "por_cd"),0);
                sheetObj.SetCellValue(Row, "por_nod_cd",sheetObj.GetCellValue(iRow2, "por_nod_cd"),0);
                sheetObj.SetCellValue(Row, "pol_cd",sheetObj.GetCellValue(iRow2, "pol_cd"),0);
                sheetObj.SetCellValue(Row, "pol_nod_cd",sheetObj.GetCellValue(iRow2, "pol_nod_cd"),0);
                sheetObj.SetCellValue(Row, "mty_pkup_yd_cd",sheetObj.GetCellValue(iRow2, "mty_pkup_yd_cd"),0);
                sheetObj.SetCellValue(Row, "full_rtn_yd_cd",sheetObj.GetCellValue(iRow2, "full_rtn_yd_cd"),0);
                sheetObj.SetCellValue(Row, "mty_pkup_dt",sheetObj.GetCellValue(iRow2, "mty_pkup_dt"),0);
                sheetObj.SetCellValue(Row, "org_trns_mod_cd",sheetObj.GetCellValue(iRow2, "org_trns_mod_cd"),0);
                sheetObj.SetCellValue(Row, "lodg_due_dt",sheetObj.GetCellValue(iRow2, "lodg_due_dt"),0);
                sheetObj.SetCellValue(Row, "mty_dor_arr_dt",sheetObj.GetCellValue(iRow2, "mty_dor_arr_dt"),0);
                sheetObj.SetCellValue(Row, "rcv_term_cd",sheetObj.GetCellValue(iRow2, "rcv_term_cd"),0);
			}else{
				sheetObj.SetCellValue(Row, "por_cd",sheetObj.CellSearchValue(Row, "por_cd"),0);
				sheetObj.SetCellValue(Row, "por_nod_cd",sheetObj.CellSearchValue(Row, "por_nod_cd"),0);
				sheetObj.SetCellValue(Row, "pol_cd",sheetObj.CellSearchValue(Row, "pol_cd"),0);
				sheetObj.SetCellValue(Row, "pol_nod_cd",sheetObj.CellSearchValue(Row, "pol_nod_cd"),0);
				sheetObj.SetCellValue(Row, "mty_pkup_yd_cd",sheetObj.CellSearchValue(Row, "mty_pkup_yd_cd"),0);
				sheetObj.SetCellValue(Row, "full_rtn_yd_cd",sheetObj.CellSearchValue(Row, "full_rtn_yd_cd"),0);
				sheetObj.SetCellValue(Row, "mty_pkup_dt",sheetObj.CellSearchValue(Row, "mty_pkup_dt"),0);
				sheetObj.SetCellValue(Row, "org_trns_mod_cd",sheetObj.CellSearchValue(Row, "org_trns_mod_cd"),0);
				sheetObj.SetCellValue(Row, "lodg_due_dt",sheetObj.CellSearchValue(Row, "lodg_due_dt"),0);
				sheetObj.SetCellValue(Row, "mty_dor_arr_dt",sheetObj.CellSearchValue(Row, "mty_dor_arr_dt"),0);
				sheetObj.SetCellValue(Row, "rcv_term_cd",sheetObj.CellSearchValue(Row, "rcv_term_cd"),0);
			}
		}else if(saveName == "dest"){
            if(sheetObj.GetCellValue(Row, Col) == "Y"){
                var iRow2 = sheetObj.HeaderRows();
                sheetObj.SetCellValue(Row, "pod_cd",sheetObj.GetCellValue(iRow2, "pod_cd"),0);
                sheetObj.SetCellValue(Row, "pod_nod_cd",sheetObj.GetCellValue(iRow2, "pod_nod_cd"),0);
                sheetObj.SetCellValue(Row, "del_cd",sheetObj.GetCellValue(iRow2, "del_cd"),0);
                sheetObj.SetCellValue(Row, "del_nod_cd",sheetObj.GetCellValue(iRow2, "del_nod_cd"),0);
                sheetObj.SetCellValue(Row, "full_pkup_yd_cd",sheetObj.GetCellValue(iRow2, "full_pkup_yd_cd"),0);
                sheetObj.SetCellValue(Row, "mty_rtn_yd_cd",sheetObj.GetCellValue(iRow2, "mty_rtn_yd_cd"),0);
                sheetObj.SetCellValue(Row, "dest_trns_mod_cd",sheetObj.GetCellValue(iRow2, "dest_trns_mod_cd"),0);
                sheetObj.SetCellValue(Row, "org_trns_mod_cd",sheetObj.GetCellValue(iRow2, "de_due_dt"),0);
                sheetObj.SetCellValue(Row, "de_term_cd",sheetObj.GetCellValue(iRow2, "de_term_cd"),0);
			}else{
				sheetObj.SetCellValue(Row, "pod_cd",sheetObj.CellSearchValue(Row, "pod_cd"),0);
				sheetObj.SetCellValue(Row, "pod_nod_cd",sheetObj.CellSearchValue(Row, "pod_nod_cd"),0);
				sheetObj.SetCellValue(Row, "del_cd",sheetObj.CellSearchValue(Row, "del_cd"),0);
				sheetObj.SetCellValue(Row, "del_nod_cd",sheetObj.CellSearchValue(Row, "del_nod_cd"),0);
				sheetObj.SetCellValue(Row, "full_pkup_yd_cd",sheetObj.CellSearchValue(Row, "full_pkup_yd_cd"),0);
				sheetObj.SetCellValue(Row, "mty_rtn_yd_cd",sheetObj.CellSearchValue(Row, "mty_rtn_yd_cd"),0);
				sheetObj.SetCellValue(Row, "dest_trns_mod_cd",sheetObj.CellSearchValue(Row, "dest_trns_mod_cd"),0);
				sheetObj.SetCellValue(Row, "de_due_dt",sheetObj.CellSearchValue(Row, "de_due_dt"),0);
				sheetObj.SetCellValue(Row, "de_term_cd",sheetObj.CellSearchValue(Row, "de_term_cd"),0);
			}			
		}
	}	
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
