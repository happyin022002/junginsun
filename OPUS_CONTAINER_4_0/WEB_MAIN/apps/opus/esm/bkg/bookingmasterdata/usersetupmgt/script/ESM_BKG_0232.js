/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0232.js
*@FileTitle  : e-Booking & SI Set Search 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
	var currRows=0;
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var iterator="|$$|";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	    function processButtonClick(){
	        /***** using extra sheet valuable if there are more 2 sheets *****/
	        var sheetObject = sheetObjects[0];
	        /*******************************************************/
	        var formObject=document.form;
	    	try {
	    		var srcName= ComGetEvent("name");
	            switch(srcName) {
				case "btn_add":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_delete":
					if(!validateForm(sheetObject,formObject,IBDELETE)) {
						return false;
					}
					ComRowHideDelete(sheetObject,"del_chk");
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
	            case "btn_Close":
	            	ComClosePopup(); 
	            	break;
		        } // end switch
	    	}catch(e) {
	    		if( e == "[object Error]") {
	     			ComShowCodeMessage("COM12111");
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
          }
          initControl();
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);          
    }
    
	function initControl() {
		applyShortcut();
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
		             var HeadTitle1="|Del.|Sel.|DOC Type|Upload\nStatus|Via|Origin\nCountry|Delivery\nContinent|Hadling\nOffice|Customer|Customer|Customer|Customer|Booking\nAgent Code|Sales\nRep.|SetSubSeq|EDI ID|Lane";
		             var HeadTitle2="|Del.|Sel.|DOC Type|Upload\nStatus|Via|Origin\nCountry|Delivery\nContinent|Hadling\nOffice|Type|Code|Code|Name|Booking\nAgent Code|Sales\nRep.|SetSubSeq|EDI ID|Lane";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle1, Align:"Center"},
		                             { Text:HeadTitle2, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"set_slct_flg" },
		                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"doc_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"bkg_upld_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"xter_rqst_via_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"org_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"del_conti_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hndl_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"bkg_cust_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                 {Type:"Int",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",          KeyField:0,   CalcLogic:"",   Format:"######",      PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"chn_agn_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"srep_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"set_sub_seq" },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"edi_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lane",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 } ];
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(195);
                 }
            break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
        case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH;
        	var sXml=sheetObj.GetSearchData("ESM_BKG_0232GS.do", FormQueryString(formObj));
			var arrXml=sXml.split(iterator);
			if (arrXml[0].length > 0) {
				var arrCombo=ComXml2ComboString(arrXml[0], "val", "name");
				sheetObj.SetColProperty(0, "doc_tp_cd", {ComboText:"|"+arrCombo[1], ComboCode:"|"+arrCombo[0]} );
			}
			if (arrXml[1].length > 0) {
				var arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
				sheetObj.SetColProperty("bkg_upld_sts_cd", {ComboText:"|"+arrCombo[1], ComboCode:"|"+arrCombo[0]} );
			}
			if (arrXml[2].length > 0) {
				var arrCombo=ComXml2ComboString(arrXml[2], "val", "name");
				sheetObj.SetColProperty("xter_rqst_via_cd", {ComboText:"|"+arrCombo[1], ComboCode:"|"+arrCombo[0]} );
			}
			if (arrXml[3].length > 0) {
				var arrCombo=ComXml2ComboString(arrXml[3], "val", "name");
				sheetObj.SetColProperty("bkg_cust_tp_cd", {ComboText:"|"+arrCombo[1], ComboCode:"|"+arrCombo[0]} );
			}
			if (arrXml[4].length > 0) {
				var arrCombo=ComXml2ComboString(arrXml[4], "val", "name");
				sheetObj.SetColProperty("del_conti_cd", {ComboText:"|"+arrCombo[1], ComboCode:"|"+arrCombo[0]} );
			}
			if (arrXml[5].length > 0) {
				sheetObj.LoadSearchData(arrXml[5],{Sync:0} );
				sheetObjects[0].RenderSheet(1);
			}
			break;
        
        case IBSAVE:
			if(!validateForm(sheetObj,formObj,sAction)) {
			    return false;
			}
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value=MULTI;
				var params=FormQueryString(formObj);
				params=params + "&" + ComSetPrifix(sheetObj.GetSaveString(true));
				var sXml=sheetObj.GetSaveData("ESM_BKG_0232GS.do", params);
//				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObj.LoadSaveData(sXml);
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComBkgSaveCompleted();
				}
	        }
			break;
			
        case IBINSERT:      // insert
       	    sheetObj.DataInsert(-1);
       	    break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
		case IBDELETE:
			if (sheetObj.CheckedRows("del_chk") == 0) {
				ComShowMessage(msgs['COM12189']);
				return false;
			} else if (sheetObj.CheckedRows("del_chk") > 0) {
				ComShowMessage(msgs['COM12188']);
				return true;
			}
			break;
			
 	 	case IBSAVE: // Retrieve
			for(var i=2; i <= sheetObj.RowCount()+1; i++) {
				if (sheetObj.GetCellValue(i,"org_cnt_cd") != "" && (sheetObj.GetCellValue(i,"org_cnt_cd")).length == 1) {
		        		 ComShowMessage(msgs['BKG00465']);
					return false;
				}
				if (sheetObj.GetCellValue(i,"cust_cnt_cd") != "" && (sheetObj.GetCellValue(i,"cust_cnt_cd")).length == 1) {
		        		 ComShowMessage(msgs['BKG00458']);
					return false;
				}
				if ((sheetObj.GetCellValue(i,"cust_seq")).length > 0) {
					if (sheetObj.GetCellValue(i,"cust_cnt_cd") == "" || (sheetObj.GetCellValue(i,"cust_cnt_cd")).length == 0) {
			        		 ComShowMessage(msgs['BKG00458']);
						return false;
					}
				}
			}
		break;
	  }
      return true;
    }
    
	function initCombo() {
		var formObject=document.form;
		formObject.f_cmd.value=SEARCH01;
		var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0232GS.do", FormQueryString(formObject));
		var arrXml=sXml.split(iterator);
		if (arrXml[0].length > 0) {
			setIBCombo(sheetObjects[0],arrXml[0],"bkg_upld_sts_cd",true,0);	
		}
		if (arrXml[1].length > 0) {
			setIBCombo(sheetObjects[0],arrXml[1],"xter_rqst_via_cd",true,0);	
		}
		if (arrXml[2].length > 0) {
			setIBCombo(sheetObjects[0],arrXml[2],"bkg_cust_tp_cd",true,0);	
		}
	}
