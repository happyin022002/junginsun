/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0034.js
 *@FileTitle : Partner's Contact Point for SPCL CGO - Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0034 : business javascript for vop_scg_0034 
     */

    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
	var comboCnt=0;
	var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	var sheetObject3 = sheetObjects[2];
    	/*******************************************************/
    	var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
     			case "btn1_RowAdd":
     				var row=sheetObject1.DataInsert(-1);
     				if (ComIsBtnEnable("btn1_RowAdd")) sheetObject1.SetCellValue(row,"rgn_shp_opr_cd",ComGetObjValue(rgn_shp_opr_cd));sheetObject1.SelectCell(row, 2);
					break;
				case "btn1_RowInsert":
					var row=sheetObject1.DataInsert();
					if (ComIsBtnEnable("btn1_RowInsert")) sheetObject1.SetCellValue(row,"rgn_shp_opr_cd",ComGetObjValue(rgn_shp_opr_cd));sheetObject1.SelectCell(row, 2);
					break; 
				case "btn1_RowCopy":
					var row=sheetObject1.DataCopy();
					if (ComIsBtnEnable("btn1_RowCopy")) sheetObject1.SelectCell(row, 2);
					break;
				case "btn1_RowDelete":
					if (ComIsBtnEnable("btn1_RowDelete")) ComRowHideDelete(sheetObject1, "del_chk");
					break;	
				case "btn2_RowAdd":
     				var row=sheetObject2.DataInsert(-1);
     				if (ComIsBtnEnable("btn2_RowAdd")) sheetObject2.SetCellValue(row,"rgn_shp_opr_cd",ComGetObjValue(rgn_shp_opr_cd));sheetObject2.SelectCell(row, 2);
					break;
				case "btn2_RowInsert":
					var row=sheetObject2.DataInsert();
					if (ComIsBtnEnable("btn2_RowInsert")) sheetObject2.SetCellValue(row,"rgn_shp_opr_cd",ComGetObjValue(rgn_shp_opr_cd));sheetObject2.SelectCell(row, 2);
					break; 
				case "btn2_RowCopy":
					var row=sheetObject2.DataCopy();
					if (ComIsBtnEnable("btn2_RowCopy")) sheetObject2.SelectCell(row, 2);
					break;
				case "btn2_RowDelete":
					if (ComIsBtnEnable("btn2_RowDelete")) ComRowHideDelete(sheetObject2, "del_chk");
					break;	
				case "btn3_RowAdd":
     				var row=sheetObject3.DataInsert(-1);
     				if (ComIsBtnEnable("btn3_RowAdd")){
     					sheetObject3.SetCellValue(row,"rgn_shp_opr_cd",ComGetObjValue(rgn_shp_opr_cd));
     					sheetObject3.SelectCell(row, 2); 
     					sheetObject3.SetCellValue(row,"cntc_cate_cd","BX");
     				}
					break;
				case "btn3_RowInsert":
					var row=sheetObject3.DataInsert();
					if (ComIsBtnEnable("btn3_RowInsert")) {
						sheetObject3.SetCellValue(row,"rgn_shp_opr_cd",ComGetObjValue(rgn_shp_opr_cd));
						sheetObject3.SelectCell(row, 2);
						sheetObject3.SetCellValue(row,"cntc_cate_cd","BX");
					}	
					break; 
				case "btn3_RowCopy":
					var row=sheetObject3.DataCopy();
					if (ComIsBtnEnable("btn3_RowCopy")) sheetObject3.SelectCell(row, 2);
					break;
				case "btn3_RowDelete":
					if (ComIsBtnEnable("btn3_RowDelete")) ComRowHideDelete(sheetObject3, "del_chk");
					break;						
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
      * registering IBTab Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
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
    	 // combo
    	 //combo1=comboObjects[0];
    	 //comboCnt=comboObjects.length;	                      
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
         }
         ComSetObjValue(document.form.tabSelectedIdx, "0");
         
         // Initializing IBMultiCombo
         for(var k=0; k<comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }
//         ComBtnDisable('btn_RowAdd');
//         ComBtnDisable('btn_RowInsert');
//         ComBtnDisable('btn_RowCopy');
//         ComBtnDisable('btn_RowDelete');
     
        // function sheet1_OnLoadFinish(sheetObj) {
         //Initializing html control event
         initControl();
         
         resizeSheet();
         
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
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
         		with (sheetObj) {
         			// setting height
         		
         		var HeadTitle="|Sel.|No.|Carrier Code|Carrier Full Name|Lane|CGO Type|E-mail|TEL No|FAX No|";

         		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

         		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
         		var headers = [ { Text:HeadTitle, Align:"Center"} ];
         		InitHeaders(headers, info);

         		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
         		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
         		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
         		             {Type:"Text",      Hidden:0,  Width:155,  Align:"Left",    ColMerge:1,   SaveName:"vsl_opr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
         		             {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cate_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:0,  Width:310,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pson_eml_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_phn_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_fax_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rgn_shp_opr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
         		 
         		InitColumns(cols);
         		
         		SetEditable(1);
         		SetColProperty("crr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
         		SetColProperty("slan_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
         		SetColProperty("spcl_cgo_cate_cd", {ComboText:"DG|AK/BB|RF|SS", ComboCode:"DG|AK|RF|SS"} );
         		SetShowButtonImage(1);
         		
                }
         		break;
         		
         	case 2:      //sheet2 init
         		with (sheetObj) {
         			// setting height
         		
         		var HeadTitle="|Sel.|No.|Carrier Code|Carrier Full Name|Lane|Report Type|E-mail|";

         		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

         		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
         		var headers = [ { Text:HeadTitle, Align:"Center"} ];
         		InitHeaders(headers, info);

         		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
         		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
         		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
         		             {Type:"Text",      Hidden:0, Width:155,  Align:"Left",    ColMerge:1,   SaveName:"vsl_opr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
         		             {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cntc_cate_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:0, Width:310,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pson_eml_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rgn_shp_opr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntc_cate_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
         		 
         		InitColumns(cols);
         		
         		SetEditable(1);
         		SetColProperty("crr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
         		SetColProperty("slan_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
         		SetColProperty("cntc_cate_cd", {ComboText:"TDR|RDR", ComboCode:"TD|RD"} );
         		SetShowButtonImage(1);
         		
                }
         		break;

         	case 3:      //sheet3 init
         		with (sheetObj) {
         			// setting height
         		
         		var HeadTitle="|Sel.|No.|Carrier Code|Carrier Full Name|Lane|Bound|Port Code|Message Type|Effective Date From|Effective Date To|E-mail|";

         		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

         		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
         		var headers = [ { Text:HeadTitle, Align:"Center"} ];
         		InitHeaders(headers, info);
         		
         		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
         		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
         		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
         		             {Type:"Text",      Hidden:0, Width:155,  Align:"Left",    ColMerge:1,   SaveName:"vsl_opr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
         		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"port_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
       		                 {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"cntc_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
       		                 //{Type:"Text",     Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"org_cntc_cate_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
       		                 {Type:"Date",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
       		                 {Type:"Date",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
       		                 {Type:"Text",      Hidden:0, Width:310,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pson_eml_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rgn_shp_opr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntc_cate_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
         		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } 
         		             ];
         		 
         		InitColumns(cols);
         		
         		SetEditable(1);
         		SetColProperty("crr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
         		SetColProperty("slan_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
         		SetColProperty("port_cd", {AcceptKeys:"E"   , InputCaseSensitive:1});
         		
         		SetColProperty("skd_dir_cd",   {ComboText:"E|W|N|S", ComboCode:"E|W|N|S"} );
         		SetColProperty("port_cd", {ComboText:"TDR|RDR", ComboCode:"TD|RD"} );
         		SetColProperty("cntc_cate_cd", {ComboText:"BAPLIE(Syntax Error)|BAPLIE(External)|BAPLIE(Internal)", ComboCode:"BE|BX|BI"} );
        		
         		SetShowButtonImage(1);
         		
                }
         		break;
         }
     }
     /**
      * Initializing Combo
      * Setting Combo items.
      */
     function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "rgn_shp_opr_cd":
	            with(comboObj) {
	            	SetTitle("Code|Description");
	            	SetColAlign(0, "center");
	            	SetColAlign(1, "left");
	            	SetColWidth(0, "50");
	            	SetColWidth(1, "150");
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            }
	            break;	        
	    }
	}    
     
     /**
      * Initialzing Tab
      * Setting tab items
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     InsertItem("SPCL CGO" , "" );
                     InsertItem("TDR/RDR"  , "" );
                     InsertItem("BAPLIE"   , "" );
                 }
              break;

          }
     }
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH_ASYNC01: // retrieve RSO				
				formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
				break;
	      	case IBSEARCH: //retrieve	      		
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj));
	     			
	     			var arrXml = sXml.split("|$$|");
	     			
	     			var tabIdx = tabObjects[0].GetSelectedIndex();
	     			
	     			loadCt = 0;
	     			
					if(tabIdx == 0) {
						for(var i=0; i<arrXml.length; i++) {
							tabObjects[0].SetSelectedIndex(i);
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
						}
						tabObjects[0].SetSelectedIndex(tabIdx);
					} else {
						for(var i=arrXml.length-1; i>=0; i--) {
							tabObjects[0].SetSelectedIndex(i);
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
						}
						tabObjects[0].SetSelectedIndex(tabIdx);
					}
					
					if ( sheetObjects[2].FindText("crr_cd", "COM") == -1) {
						setAddRow(sheetObjects[2], formObj);
					} else {
						sheetObjects[2].SetRowBackColor(1, "#89E168");
					}
					
				}
				break;
			case IBSAVE:        //save
	 			
				var sheetObj1 = sheetObjects[0];
				var sheetObj2 = sheetObjects[1];
				var sheetObj3 = sheetObjects[2];
				
				if (sheetObj1.IsDataModified() == false && sheetObj2.IsDataModified() == false && sheetObj3.IsDataModified() == false) return;
				
				if(!validateForm(sheetObj1,formObj,sAction)) {
					tabObjects[0].SetSelectedIndex(0);
	 				return;
	 			}
	 			if(!validateForm(sheetObj2,formObj,sAction)) {
	 				tabObjects[0].SetSelectedIndex(1);
	 				return;
	 			}
	 			if(!validateForm(sheetObj3,formObj,sAction)) {
	 				tabObjects[0].SetSelectedIndex(2);
	 				return;
	 			}
	 			
	 			var tabIdx = ComGetObjValue(formObj.tabSelectedIdx);
	 			
 				if(!ComShowCodeConfirm('SCG50001', 'data')) return;
 				
 				formObj.f_cmd.value = MULTI;
	     	   	if (sheetObj1.IsDataModified()) {
	     	   		formObj.transmit_target.value = "SpclCgo";
 					var SaveSheet = ComGetSaveString(sheetObj1);
 					if(SaveSheet == "") {
 						return;
 					}
 					var sXml      = sheetObj1.GetSaveData("VOP_SCG_0034GS.do", SaveSheet + "&" + FormQueryString(formObj)); 
 					
 					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) != "S") {
 						ComShowCodeMessage("COM130103", "Data");
 						return;
		     	    }
 				}
 				if (sheetObj2.IsDataModified()) {
 					formObj.transmit_target.value = "TdrRdr";
 					var SaveSheet = ComGetSaveString(sheetObj2);
 					if(SaveSheet == "") {
 						return;
 					}
 					var sXml      = sheetObj2.GetSaveData("VOP_SCG_0034GS.do", SaveSheet + "&" + FormQueryString(formObj)); 	
 					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) != "S") {
 						ComShowCodeMessage("COM130103", "Data");
 						return;
		     	    }
 				}
 				if (sheetObj3.IsDataModified()) {
 					formObj.transmit_target.value = "Baplie";
 					var SaveSheet = ComGetSaveString(sheetObj3);
 					if(SaveSheet == "") {
 						return;
 					}
 					var sXml      = sheetObj3.GetSaveData("VOP_SCG_0034GS.do", SaveSheet + "&" + FormQueryString(formObj)); 	
 					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) != "S") {
 						ComShowCodeMessage("COM130103", "Data");
 						return;
		     	    }
 				}
 				
 				ComShowCodeMessage("COM130102", "Data");
				
 				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
				
				break;
			case IBROWSEARCH:   //retrieve
				var tabIdx = tabObjects[0].GetSelectedIndex();
	    		if (Col == "crr_cd") {
					/*
					 * 2014.12.30 dongsoo
					 * carrier code에 com이 없을경우  Data is invalid발생
					 * 공통 로직을 수정 불가하여 vop_scg_0034에 query 추가 
					 
	    			formObj.f_cmd.value=SEARCH01;
 					var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj)+"&crr_cd="+sheetObj.GetCellValue(Row,Col));
					var arrData=ComScgXml2Array(sXml, "crr_cd|crr_nm");
				    if (arrData != null && arrData.length > 0) {
				    	sheetObj.SetCellValue(Row,"vsl_opr_nm",arrData[1][1]);
					}else{
						ComShowCodeMessage('SCG50010', 'Data');
					    sheetObj.SelectCell(Row, Col, true, "");
						sheetObj.SetCellValue(Row,"vsl_opr_nm","",0);
					}
					*/
	    			formObj.f_cmd.value=SEARCH02;
 					var sXml=sheetObj.GetSearchData("VOP_SCG_0034GS.do", FormQueryString(formObj)+"&crr_cd="+sheetObj.GetCellValue(Row,Col));
					var arrData=ComScgXml2Array(sXml, "crr_cd|crr_nm");
				    if (arrData != null && arrData.length > 0) {
				    	if(tabIdx == 0){
				    		sheetObj.SetCellValue(Row,"vsl_opr_nm",arrData[0][1]);
				    	}else if(tabIdx == 1){
					    	if(arrData[0][0] == "COM"){
					    		sheetObj.SetCellValue(Row,"crr_cd","");
					    	}else{
					    		sheetObj.SetCellValue(Row,"vsl_opr_nm",arrData[0][1]);
					    	}
				    	}else if(tabIdx == 2){
				    		if(arrData[0][0] == "COM"){
					    		sheetObj.SetCellValue(Row,"crr_cd","");
					    	}else{
					    		sheetObj.SetCellValue(Row,"vsl_opr_nm",arrData[0][1]);
					    	}
				    	}
				    		
					}else{
						ComShowCodeMessage('SCG50010', 'Data');
					    sheetObj.SelectCell(Row, Col, true, "");
					    sheetObj.SetCellValue(Row,"crr_cd","",0);
						sheetObj.SetCellValue(Row,"vsl_opr_nm","",0);
					}
				}else if (Col == "slan_cd") {
	        		formObj.f_cmd.value=SEARCH02;
 	        		var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do" , FormQueryString(formObj)+"&vsl_slan_cd="+sheetObj.GetCellValue(Row,Col));
	        		var arrData=ComScgXml2Array(sXml, "vsl_slan_cd");
	        		if (arrData != null && arrData.length > 0) {
	        			if(tabIdx == 1){
	        				if(arrData[0][0] == "COM"){
	        					sheetObj.SetCellValue(Row,"slan_cd","");
						    }
	        			}else if(tabIdx == 2){
	        				if(arrData[0][0] == "COM"){
	        					sheetObj.SetCellValue(Row,"slan_cd","");
						    }
	        			}
	        		}else{
	        			ComShowCodeMessage('SCG50010', 'Data');
	        			sheetObj.SelectCell(Row, Col, true, "");
	        			return;
	        		}
				}
	    		break;
            case IBSEARCH_ASYNC02:      //retrieve   PORT_NM
				formObj.f_cmd.value=SEARCH09;;
				var param="f_cmd="+formObj.f_cmd.value+"&port_cd="+sheetObj.GetCellValue( Row, "port_cd");
				var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", param);
				var sMsg=ComScgGetMessageFromXml(sXml);
				if(sMsg != ""){
					ComShowMessage(sMsg); 
					sheetObj.SetCellValue(Row, "port_cd", "", 0);
                	return;
				}
	            break;	
         }
        sheetObj.SetWaitImageVisible(1);
     }
     //business javascript OnKeyPress event Catch
     function initControl() {
//         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    	 axon_event.addListener ('change', 'rgn_shp_opr_cd_OnChange', 'rgn_shp_opr_cd');     
    	 initUseBtn(false);
     }
 	function rgn_shp_opr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		if (!ComIsNull(newCode)) {
			var arrText=newCode.split("|");
			//formObj.rgn_shp_opr_desc.value=arrText[1];
			document.form.rgn_shp_opr_desc.value=comboObj.GetText(newCode,1);
			//Retrieve when selecting RSO code.
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			initUseBtn(true);
		}
	}
 	 function initUseBtn(useyn){
         var doc=document.all;
         if( useyn ){
        	 ComBtnEnable("btn1_RowAdd");
        	 ComBtnEnable("btn1_RowInsert");
        	 ComBtnEnable("btn1_RowCopy");
        	 ComBtnEnable("btn1_RowDelete");
        	 ComBtnEnable("btn2_RowAdd");
        	 ComBtnEnable("btn2_RowInsert");
        	 ComBtnEnable("btn2_RowCopy");
        	 ComBtnEnable("btn2_RowDelete");
        	 ComBtnEnable("btn3_RowAdd");
        	 ComBtnEnable("btn3_RowInsert");
        	 ComBtnEnable("btn3_RowCopy");
        	 ComBtnEnable("btn3_RowDelete");
         }else{
        	 ComBtnDisable("btn1_RowAdd");
        	 ComBtnDisable("btn1_RowInsert");
        	 ComBtnDisable("btn1_RowCopy");
        	 ComBtnDisable("btn1_RowDelete");
        	 ComBtnDisable("btn2_RowAdd");
        	 ComBtnDisable("btn2_RowInsert");
        	 ComBtnDisable("btn2_RowCopy");
        	 ComBtnDisable("btn2_RowDelete");
        	 ComBtnDisable("btn3_RowAdd");
        	 ComBtnDisable("btn3_RowInsert");
        	 ComBtnDisable("btn3_RowCopy");
        	 ComBtnDisable("btn3_RowDelete");
         }
     }     
 	
 	/**
 	 * handling process for input validation
 	 */
 	function validateForm(sheetObj,formObj,sAction){
 		if (sAction == IBSAVE) {
 			if (comboObjects[0].GetSelectCode()== "") {
 				ComShowCodeMessage('SCG50011','RSO');
 				//rgn_shp_opr_cd.focus();
 				return;
 			}
 			var dupStr = "";

 			if(sheetObj.id == "sheet1"){
 				dupStr = "rgn_shp_opr_cd|crr_cd|slan_cd|spcl_cgo_cate_cd";
 			}else if(sheetObj.id == "sheet2"){
 				dupStr = "rgn_shp_opr_cd|crr_cd|slan_cd|cntc_cate_cd";

 		    	for(var rowIdx1=sheetObj.HeaderRows()+1; rowIdx1<=sheetObj.LastRow(); rowIdx1++) {
 		    		ibflag=sheetObj.GetCellValue(rowIdx1,0);
 					if((ibflag == 'U' || ibflag == 'I')) {
 						if(sheetObj.GetCellValue(rowIdx1, "crr_cd") == ''){
 							ComShowCodeMessage('SCG50007', 'Carrier Code');  //Please input {?msg1}.
 		    				sheetObj.SelectCell(rowIdx1,"crr_cd");
 		    				return false;	
 						} 	
 						if(sheetObj.GetCellValue(rowIdx1, "slan_cd") == ''){
 							ComShowCodeMessage('SCG50007', 'Lane');   //Please input {?msg1}.
 		    				sheetObj.SelectCell(rowIdx1,"slan_cd");
 		    				return false;	
 						}
 					}
 		    	}
 			}else if(sheetObj.id == "sheet3"){
 				dupStr = "rgn_shp_opr_cd|crr_cd|slan_cd|skd_dir_cd|port_cd|cntc_cate_cd|cntc_pson_eml_ctnt";
 				
 		    	for(var rowIdx1=sheetObj.HeaderRows()+1; rowIdx1<=sheetObj.LastRow(); rowIdx1++) {
 		    		ibflag=sheetObj.GetCellValue(rowIdx1,0);
 					if((ibflag == 'U' || ibflag == 'I')) {
 						if(sheetObj.GetCellValue(rowIdx1, "slan_cd") == ''){
 							ComShowCodeMessage('SCG50007', 'Lane');   //Please input {?msg1}.
 		    				sheetObj.SelectCell(rowIdx1,"slan_cd");
 		    				return false;	
 						}
 						if(sheetObj.GetCellValue(rowIdx1, "skd_dir_cd") == ''){
 							ComShowCodeMessage('SCG50011', 'Bound');  //Please select {?msg1}.
 		    				sheetObj.SelectCell(rowIdx1,"skd_dir_cd");
 		    				return false;	
 						} 						
 						if(sheetObj.GetCellValue(rowIdx1, "eff_fm_dt") == ''){
 							ComShowCodeMessage('SCG50011', 'Effective Date From');
 		    				sheetObj.SelectCell(rowIdx1,"eff_fm_dt");
 		    				return false;	
 						}
 						if(sheetObj.GetCellValue(rowIdx1, "eff_to_dt") == ''){
 							ComShowCodeMessage('SCG50011', 'Effective Date To');
 		    				sheetObj.SelectCell(rowIdx1,"eff_to_dt");
 		    				return false;	
 						}

 						if(sheetObj.GetCellValue(rowIdx1, "eff_fm_dt") > sheetObj.GetCellValue(rowIdx1, "eff_to_dt")){
 							ComShowCodeMessage('COM132002');
 							sheetObj.SetCellValue(rowIdx1, "eff_to_dt", "", 0);
 							return false;
 						}
 						if(sheetObj.GetCellValue(rowIdx1, "cntc_pson_eml_ctnt") == ''){
 							ComShowCodeMessage('SCG50007', 'E-mail');
 		    				sheetObj.SelectCell(rowIdx1,"cntc_pson_eml_ctnt");
 		    				return false;	
 						}
 					}
 		    	}
 			}
 			var dupRow = sheetObj.ColValueDupRows(dupStr, false, true);

 			if(dupRow != "") {
				ComShowCodeMessage('SCG50005', 'Data');
				if (sheetObj.GetRowStatus(dupRow.split("|")[0])=="R") {
					sheetObj.SelectCell(dupRow.split("|")[1], 2);
				}else{
					sheetObj.SelectCell(dupRow.split("|")[0], 2);
				}
				return;
			}
 		}
 		if (sAction == IBSEARCH) {
 			if (comboObjects[0].GetSelectCode()== "") {
 				ComShowCodeMessage('SCG50011','RSO');
 				//rgn_shp_opr_cd.focus();
 				return;
 			}
 		}
 		return true;
 	}
 	/**
      * Clicking Popup in IBSheet Object
      */
 	function sheet1_OnPopupClick(sheetObj, Row, Col){ 		
		if (sheetObj.ColSaveName(Col) == "crr_cd") {
			ComOpenPopup("COM_ENS_0N1.do?crr_cd="+sheetObj.GetCellValue(Row, "crr_cd"), 600, 480, "setCrrCd", "1,0,1,1,1,1", true, false, Row, Col, 0);
		} else if (sheetObj.ColSaveName(Col) == "slan_cd") {
			var sUrl="/opuscntr/VOP_VSK_0202.do?intg_cd_id=CD00717";
            gRow=Row;
            ComOpenPopup(sUrl, 458, 480, "getSlanCdData", "0,0", true, false, Row, Col, 0);
		}
	}
 	
 	function sheet2_OnPopupClick(sheetObj, Row, Col) {	
		if (sheetObj.ColSaveName(Col) == "crr_cd") {
			ComOpenPopup("COM_ENS_0N1.do?crr_cd="+sheetObj.GetCellValue(Row, "crr_cd"), 600, 480, "setCrrCd", "1,0,1,1,1,1", true, false, Row, Col, 1);
		} else if (sheetObj.ColSaveName(Col) == "slan_cd") {
			var sUrl="/opuscntr/VOP_VSK_0202.do?intg_cd_id=CD00717";
            gRow=Row;
            ComOpenPopup(sUrl, 458, 480, "getSlanCdData", "0,0", true, false, Row, Col, 1);
		}
	}

 	function sheet3_OnPopupClick(sheetObj, Row, Col) {	
		if (sheetObj.ColSaveName(Col) == "crr_cd") {
			ComOpenPopup("COM_ENS_0N1.do?crr_cd="+sheetObj.GetCellValue(Row, "crr_cd"), 600, 480, "setCrrCd", "1,0,1,1,1,1", true, false, Row, Col, 2);
		} else if (sheetObj.ColSaveName(Col) == "slan_cd") {
			var sUrl="/opuscntr/VOP_VSK_0202.do?intg_cd_id=CD00717";
            gRow=Row;
            ComOpenPopup(sUrl, 458, 480, "getSlanCdData", "0,0", true, false, Row, Col, 2);
		} else if (sheetObj.ColSaveName(Col) == "port_cd") {
			gRow=Row;
			ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+sheetObj.GetCellValue(Row, "port_cd"), 427, 495, "setPortNm", "0,0", false,false,Row, Col, 2, "COM_ENS_051");
		}
	}
 	
    function setPortNm(aryPopupData){
    	sheetObjects[2].SetCellValue( sheetObjects[2].GetSelectRow(), "port_cd", aryPopupData, 0);
    }
    
	function getSlanCdData(obj, Row, Col, sheetIdx) {
		if(obj){
			var rtnDatas=obj;
			
			if(rtnDatas){
				if(rtnDatas.length > 0){
				    var sheetObject=sheetObjects[sheetIdx];
					if(sheetIdx == 0){
						sheetObject.SetCellValue(gRow, "slan_cd", rtnDatas[0][1], 0);	
					}else if(sheetIdx == 1){
						if(rtnDatas[0][1] == "COM"){
							sheetObject.SetCellValue(gRow, "slan_cd", "", 0);
						}else{
							sheetObject.SetCellValue(gRow, "slan_cd", ""+rtnDatas[0][1], 0);	
						}
					}else if(sheetIdx == 2){
						if(rtnDatas[0][1] == "COM"){
							sheetObject.SetCellValue(gRow, "slan_cd", "", 0);
						}else{
							sheetObject.SetCellValue(gRow, "slan_cd", ""+rtnDatas[0][1], 0);	
						}
					}
				    gRow=0;
				}
			}
		}
	}
 	
    /**
     * when input value change in IBSheet Object
     */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		var code=Value;
		if (sheetObj.ColSaveName(Col) == "crr_cd" && code !="") {
			if (code.length >= 3) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "crr_cd", Row);
			}else{
				ComShowCodeMessage('SCG50009','Carrier Code', '3', '4');
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col);
			}
		}else if (sheetObj.ColSaveName(Col) == "slan_cd" && code !="") {
			if (code.length == 3) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "slan_cd", Row);
			}else{
				ComShowCodeMessage('SCG50006','Lane Code', '3');
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col);
			}
		}		
	}
	
	/**
     * when input value change in IBSheet Object
     */
	function sheet2_OnChange(sheetObj,Row, Col, Value){
		var code=Value;
		if (sheetObj.ColSaveName(Col) == "crr_cd" && code !="") {
			if (code.length >= 3) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "crr_cd", Row);
			}else{
				ComShowCodeMessage('SCG50009','Carrier Code', '3', '4');
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col);
			}
		}else if (sheetObj.ColSaveName(Col) == "slan_cd" && code !="") {
			if (code.length == 3) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "slan_cd", Row);
			}else{
				ComShowCodeMessage('SCG50006','Lane Code', '3');
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col);
			}
		}	
	}
	
	/**
     * when input value change in IBSheet Object
     */
	function sheet3_OnChange(sheetObj,Row, Col, Value, OldValue){
		var code=Value;
		if (sheetObj.ColSaveName(Col) == "crr_cd" && code !="") {
			if (code.length >= 3) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "crr_cd", Row);
			}else{
				ComShowCodeMessage('SCG50009','Carrier Code', '3', '4');
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col);
			}
		}else if (sheetObj.ColSaveName(Col) == "slan_cd" && code !="") {
			if (code.length == 3) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "slan_cd", Row);
			}else{
				ComShowCodeMessage('SCG50006','Lane Code', '3');
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col);
			}
		}else if (sheetObj.ColSaveName(Col) == "port_cd" && code !="") {
			doActionIBSheet(sheetObj ,document.form, IBSEARCH_ASYNC02, "", Row);  	
		}else if (sheetObj.ColSaveName(Col) == "cntc_cate_cd") {
			if (Value =="BE"){
				sheetObj.SetCellValue(Row,"cntc_cate_cd", OldValue, 0);
			}
		}
	}
	
	function sheet3_OnSearchEnd(sheetObj){
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if(i == 1){
				sheetObj.SetRowEditable(i,0);		
				sheetObj.SetCellEditable(i, "cntc_pson_eml_ctnt", 1);
			}else{
				sheetObj.SetRowEditable(i,1);
			}
		}
	}
	
    /**
	 * crr_cd input<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setCrrCd(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[sheetIdx].SetCellValue(Row,Col,aryPopupData[0][3],0);
		sheetObjects[sheetIdx].SetCellValue(Row,"vsl_opr_nm",aryPopupData[0][4],0);
	}
	/**
	 * slan_cd input<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setSlanCd(aryPopupData, Row, Col, sheetIdx){
		sheetObjects[sheetIdx].SetCellValue(Row,Col,aryPopupData[0][1],0);
	}
	
	/**
     * When clicking Tab, related event
     * selected tab's elements activate.
     */
    function tab1_OnChange(tabObj , nItem) {
    	var formObj=document.form;
    	var tabSelectedIdx=ComGetObjValue(formObj.tabSelectedIdx);
    	var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- important point --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	
    	beforetab=nItem;
    	ComSetObjValue(formObj.tabSelectedIdx, nItem);
    	resizeSheet();
    }
    
    function setAddRow(sheetObj, formObj) {
		var row = sheetObj.DataInsert(0);
		sheetObj.SetCellValue(row,"rgn_shp_opr_cd"     , ComGetObjValue(formObj.rgn_shp_opr_cd));
		sheetObj.SetCellValue(row,"crr_cd"             , "COM", 0);
		sheetObj.SetCellValue(row,"slan_cd"            , "COM", 0);
		
		sheetObj.SetCellValue(row,"skd_dir_cd"         , "", 0);
		sheetObj.SetCellValue(row,"port_cd"            , "", 0);
		
		sheetObj.SetCellValue(row,"cntc_cate_cd"       , "BE");
		sheetObj.SetCellValue(row,"cntc_pson_eml_ctnt" , "realvision21@cyberlogitec.com");
		
		sheetObj.SelectCell(row, 2);
		sheetObj.SetRowEditable(row,0);		
		sheetObj.SetRowBackColor(row, "#89E168");
		sheetObj.SetCellEditable(row, "cntc_pson_eml_ctnt", 1);
	}
    
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }


